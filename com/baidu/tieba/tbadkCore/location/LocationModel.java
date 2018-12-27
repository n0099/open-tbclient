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
    private HttpMessageListener cAc;
    private a hqH;
    private b hqI;
    private BdBaseActivity hqJ;
    private com.baidu.adp.framework.listener.c hqK;
    private a.InterfaceC0017a hqL;
    private CustomMessageListener hqM;

    /* loaded from: classes.dex */
    public interface a {
        void MO();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void dj(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void MP();

        void hT(String str);
    }

    private void amt() {
        this.cAc = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hqH != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hqH.dj(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bEQ();
            }
        };
    }

    public void bEQ() {
        if (bES()) {
            if (this.hqH != null) {
                this.hqH.a(c.bEO().getLocationData());
            }
        } else if (j.kV()) {
            if (ab.bC(this.hqJ.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.hqL);
            }
        } else if (this.hqH != null) {
            this.hqH.MO();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hqK = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hqH != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hqH.dj(str);
                }
            }
        };
        this.hqL = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cN(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hqH != null) {
                    LocationModel.this.hqH.dj(str);
                }
            }
        };
        this.hqM = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.nA(false);
                        LocationModel.this.cO(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hqI != null) {
                            LocationModel.this.hqI.hT(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.nA(true);
                    if (LocationModel.this.hqI != null) {
                        LocationModel.this.hqI.MP();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hqJ = baseActivity;
        registerListener(this.hqK);
        registerListener(this.hqM);
    }

    public void cN(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.hqH != null) {
                this.hqH.dj(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bEO().dj(System.currentTimeMillis());
        c.bEO().b(aVar);
        if (this.hqH != null) {
            this.hqH.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0318a> bEM;
        int i;
        int i2;
        if (aVar != null && (bEM = aVar.bEM()) != null && !bEM.isEmpty()) {
            int size = bEM.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bEM.get(i3) != null) {
                    str = bEM.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bEM.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bEL())) {
                if (bEM.size() >= 1) {
                    aVar.vK(bEM.get(0).getName());
                    aVar.vL(bEM.get(0).bEN());
                    return;
                }
                return;
            }
            for (a.C0318a c0318a : bEM) {
                if (aVar.bEL().equals(c0318a.getName())) {
                    aVar.vL(c0318a.bEN());
                    return;
                }
            }
        }
    }

    public boolean bER() {
        return System.currentTimeMillis() - c.bEO().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bES() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bEO().getLocationData();
        return (bER() || locationData == null || StringUtils.isNull(locationData.bEL())) ? false : true;
    }

    public void nA(boolean z) {
        c.bEO().nz(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bEO().bEP());
    }

    public void cO(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bEO().getLocationData();
        if (locationData != null) {
            locationData.vK(str);
            locationData.vL(str2);
        }
    }

    public static void bET() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean amo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hqJ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bEO().bEP()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void ams() {
        if (this.cAc == null) {
            amt();
            registerListener(this.cAc);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hqH = aVar;
    }

    public void a(b bVar) {
        this.hqI = bVar;
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
