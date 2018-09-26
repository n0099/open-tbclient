package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import android.net.http.Headers;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener cmt;
    private a gXK;
    private b gXL;
    private BdBaseActivity gXM;
    private com.baidu.adp.framework.listener.c gXN;
    private a.InterfaceC0014a gXO;
    private CustomMessageListener gXP;

    /* loaded from: classes.dex */
    public interface a {
        void Jz();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void hl(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void JA();

        void hm(String str);
    }

    private void ahJ() {
        this.cmt = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gXK != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gXK.hl(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bzu();
            }
        };
    }

    public void bzu() {
        if (bzw()) {
            if (this.gXK != null) {
                this.gXK.a(c.bzs().getLocationData());
            }
        } else if (j.kK()) {
            if (ab.bs(this.gXM.getActivity())) {
                com.baidu.adp.lib.d.a.iH().a(true, this.gXO);
            }
        } else if (this.gXK != null) {
            this.gXK.Jz();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gXN = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gXK != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gXK.hl(str);
                }
            }
        };
        this.gXO = new a.InterfaceC0014a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cx(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gXK != null) {
                    LocationModel.this.gXK.hl(str);
                }
            }
        };
        this.gXP = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mT(false);
                        LocationModel.this.cy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gXL != null) {
                            LocationModel.this.gXL.hm(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mT(true);
                    if (LocationModel.this.gXL != null) {
                        LocationModel.this.gXL.JA();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gXM = baseActivity;
        registerListener(this.gXN);
        registerListener(this.gXP);
    }

    public void cx(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gXK != null) {
                this.gXK.hl(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bzs().cV(System.currentTimeMillis());
        c.bzs().b(aVar);
        if (this.gXK != null) {
            this.gXK.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0244a> bzp;
        int i;
        int i2;
        if (aVar != null && (bzp = aVar.bzp()) != null && !bzp.isEmpty()) {
            int size = bzp.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bzp.get(i3) != null) {
                    str = bzp.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bzp.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bzo())) {
                if (bzp.size() >= 1) {
                    aVar.uz(bzp.get(0).getName());
                    aVar.uA(bzp.get(0).bzq());
                    return;
                }
                return;
            }
            for (a.C0244a c0244a : bzp) {
                if (aVar.bzo().equals(c0244a.getName())) {
                    aVar.uA(c0244a.bzq());
                    return;
                }
            }
        }
    }

    public boolean bzv() {
        return System.currentTimeMillis() - c.bzs().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bzw() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bzs().getLocationData();
        return (bzv() || locationData == null || StringUtils.isNull(locationData.bzo())) ? false : true;
    }

    public void mT(boolean z) {
        c.bzs().mS(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bzs().bzt());
    }

    public void cy(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bzs().getLocationData();
        if (locationData != null) {
            locationData.uz(str);
            locationData.uA(str2);
        }
    }

    public static void bzx() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean ahE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gXM.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bzs().bzt()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void ahI() {
        if (this.cmt == null) {
            ahJ();
            registerListener(this.cmt);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gXK = aVar;
    }

    public void a(b bVar) {
        this.gXL = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
