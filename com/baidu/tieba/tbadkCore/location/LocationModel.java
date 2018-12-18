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
    private HttpMessageListener czc;
    private CustomMessageListener hnA;
    private a hnv;
    private b hnw;
    private BdBaseActivity hnx;
    private com.baidu.adp.framework.listener.c hny;
    private a.InterfaceC0017a hnz;

    /* loaded from: classes.dex */
    public interface a {
        void MN();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void dj(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void MO();

        void hS(String str);
    }

    private void alR() {
        this.czc = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hnv != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hnv.dj(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bDY();
            }
        };
    }

    public void bDY() {
        if (bEa()) {
            if (this.hnv != null) {
                this.hnv.a(c.bDW().getLocationData());
            }
        } else if (j.kV()) {
            if (ab.bC(this.hnx.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.hnz);
            }
        } else if (this.hnv != null) {
            this.hnv.MN();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hny = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hnv != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hnv.dj(str);
                }
            }
        };
        this.hnz = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cN(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hnv != null) {
                    LocationModel.this.hnv.dj(str);
                }
            }
        };
        this.hnA = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.nx(false);
                        LocationModel.this.cO(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hnw != null) {
                            LocationModel.this.hnw.hS(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.nx(true);
                    if (LocationModel.this.hnw != null) {
                        LocationModel.this.hnw.MO();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hnx = baseActivity;
        registerListener(this.hny);
        registerListener(this.hnA);
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
            if (this.hnv != null) {
                this.hnv.dj(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bDW().de(System.currentTimeMillis());
        c.bDW().b(aVar);
        if (this.hnv != null) {
            this.hnv.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0318a> bDU;
        int i;
        int i2;
        if (aVar != null && (bDU = aVar.bDU()) != null && !bDU.isEmpty()) {
            int size = bDU.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bDU.get(i3) != null) {
                    str = bDU.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bDU.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bDT())) {
                if (bDU.size() >= 1) {
                    aVar.vH(bDU.get(0).getName());
                    aVar.vI(bDU.get(0).bDV());
                    return;
                }
                return;
            }
            for (a.C0318a c0318a : bDU) {
                if (aVar.bDT().equals(c0318a.getName())) {
                    aVar.vI(c0318a.bDV());
                    return;
                }
            }
        }
    }

    public boolean bDZ() {
        return System.currentTimeMillis() - c.bDW().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bEa() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bDW().getLocationData();
        return (bDZ() || locationData == null || StringUtils.isNull(locationData.bDT())) ? false : true;
    }

    public void nx(boolean z) {
        c.bDW().nw(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bDW().bDX());
    }

    public void cO(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bDW().getLocationData();
        if (locationData != null) {
            locationData.vH(str);
            locationData.vI(str2);
        }
    }

    public static void bEb() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean alM() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hnx.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bDW().bDX()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void alQ() {
        if (this.czc == null) {
            alR();
            registerListener(this.czc);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hnv = aVar;
    }

    public void a(b bVar) {
        this.hnw = bVar;
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
