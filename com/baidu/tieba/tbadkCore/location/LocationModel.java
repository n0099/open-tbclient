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
    private HttpMessageListener bTY;
    private a gyC;
    private b gyD;
    private BdBaseActivity gyE;
    private com.baidu.adp.framework.listener.c gyF;
    private a.InterfaceC0006a gyG;
    private CustomMessageListener gyH;

    /* loaded from: classes.dex */
    public interface a {
        void Eu();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gq(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ev();

        void gr(String str);
    }

    private void abt() {
        this.bTY = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gyC != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gyC.gq(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bsG();
            }
        };
    }

    public void bsG() {
        if (bsI()) {
            if (this.gyC != null) {
                this.gyC.a(c.bsE().getLocationData());
            }
        } else if (j.gP()) {
            if (ab.aB(this.gyE.getActivity())) {
                com.baidu.adp.lib.d.a.eK().a(true, this.gyG);
            }
        } else if (this.gyC != null) {
            this.gyC.Eu();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gyF = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gyC != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gyC.gq(str);
                }
            }
        };
        this.gyG = new a.InterfaceC0006a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ce(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gyC != null) {
                    LocationModel.this.gyC.gq(str);
                }
            }
        };
        this.gyH = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mt(false);
                        LocationModel.this.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gyD != null) {
                            LocationModel.this.gyD.gr(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mt(true);
                    if (LocationModel.this.gyD != null) {
                        LocationModel.this.gyD.Ev();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gyE = baseActivity;
        registerListener(this.gyF);
        registerListener(this.gyH);
    }

    public void ce(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gyC != null) {
                this.gyC.gq(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bsE().cT(System.currentTimeMillis());
        c.bsE().b(aVar);
        if (this.gyC != null) {
            this.gyC.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0219a> bsB;
        int i;
        int i2;
        if (aVar != null && (bsB = aVar.bsB()) != null && !bsB.isEmpty()) {
            int size = bsB.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bsB.get(i3) != null) {
                    str = bsB.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bsB.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bsA())) {
                if (bsB.size() >= 1) {
                    aVar.sU(bsB.get(0).getName());
                    aVar.sV(bsB.get(0).bsC());
                    return;
                }
                return;
            }
            for (a.C0219a c0219a : bsB) {
                if (aVar.bsA().equals(c0219a.getName())) {
                    aVar.sV(c0219a.bsC());
                    return;
                }
            }
        }
    }

    public boolean bsH() {
        return System.currentTimeMillis() - c.bsE().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bsI() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsE().getLocationData();
        return (bsH() || locationData == null || StringUtils.isNull(locationData.bsA())) ? false : true;
    }

    public void mt(boolean z) {
        c.bsE().ms(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bsE().bsF());
    }

    public void cf(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsE().getLocationData();
        if (locationData != null) {
            locationData.sU(str);
            locationData.sV(str2);
        }
    }

    public static void bsJ() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean abo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gyE.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bsE().bsF()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void abs() {
        if (this.bTY == null) {
            abt();
            registerListener(this.bTY);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gyC = aVar;
    }

    public void a(b bVar) {
        this.gyD = bVar;
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
