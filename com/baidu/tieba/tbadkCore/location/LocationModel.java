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
    private HttpMessageListener cvk;
    private a hgB;
    private b hgC;
    private BdBaseActivity hgD;
    private com.baidu.adp.framework.listener.c hgE;
    private a.InterfaceC0017a hgF;
    private CustomMessageListener hgG;

    /* loaded from: classes.dex */
    public interface a {
        void LJ();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void hA(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void LK();

        void hB(String str);
    }

    private void akK() {
        this.cvk = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hgB != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hgB.hA(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bCe();
            }
        };
    }

    public void bCe() {
        if (bCg()) {
            if (this.hgB != null) {
                this.hgB.a(c.bCc().getLocationData());
            }
        } else if (j.kV()) {
            if (ab.bz(this.hgD.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.hgF);
            }
        } else if (this.hgB != null) {
            this.hgB.LJ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hgE = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hgB != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hgB.hA(str);
                }
            }
        };
        this.hgF = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cI(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hgB != null) {
                    LocationModel.this.hgB.hA(str);
                }
            }
        };
        this.hgG = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.nv(false);
                        LocationModel.this.cJ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hgC != null) {
                            LocationModel.this.hgC.hB(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.nv(true);
                    if (LocationModel.this.hgC != null) {
                        LocationModel.this.hgC.LK();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hgD = baseActivity;
        registerListener(this.hgE);
        registerListener(this.hgG);
    }

    public void cI(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.hgB != null) {
                this.hgB.hA(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bCc().cX(System.currentTimeMillis());
        c.bCc().b(aVar);
        if (this.hgB != null) {
            this.hgB.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0307a> bCa;
        int i;
        int i2;
        if (aVar != null && (bCa = aVar.bCa()) != null && !bCa.isEmpty()) {
            int size = bCa.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bCa.get(i3) != null) {
                    str = bCa.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bCa.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bBZ())) {
                if (bCa.size() >= 1) {
                    aVar.vg(bCa.get(0).getName());
                    aVar.vh(bCa.get(0).bCb());
                    return;
                }
                return;
            }
            for (a.C0307a c0307a : bCa) {
                if (aVar.bBZ().equals(c0307a.getName())) {
                    aVar.vh(c0307a.bCb());
                    return;
                }
            }
        }
    }

    public boolean bCf() {
        return System.currentTimeMillis() - c.bCc().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bCg() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCc().getLocationData();
        return (bCf() || locationData == null || StringUtils.isNull(locationData.bBZ())) ? false : true;
    }

    public void nv(boolean z) {
        c.bCc().nu(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bCc().bCd());
    }

    public void cJ(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCc().getLocationData();
        if (locationData != null) {
            locationData.vg(str);
            locationData.vh(str2);
        }
    }

    public static void bCh() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean akF() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hgD.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bCc().bCd()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void akJ() {
        if (this.cvk == null) {
            akK();
            registerListener(this.cvk);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hgB = aVar;
    }

    public void a(b bVar) {
        this.hgC = bVar;
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
