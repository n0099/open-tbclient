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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener ceW;
    private a gPg;
    private b gPh;
    private BdBaseActivity gPi;
    private com.baidu.adp.framework.listener.c gPj;
    private a.InterfaceC0014a gPk;
    private CustomMessageListener gPl;

    /* loaded from: classes.dex */
    public interface a {
        void Io();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gT(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ip();

        void gU(String str);
    }

    private void afB() {
        this.ceW = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gPg != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gPg.gT(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bym();
            }
        };
    }

    public void bym() {
        if (byo()) {
            if (this.gPg != null) {
                this.gPg.a(c.byk().getLocationData());
            }
        } else if (j.jD()) {
            if (ac.aM(this.gPi.getActivity())) {
                com.baidu.adp.lib.d.a.hB().a(true, this.gPk);
            }
        } else if (this.gPg != null) {
            this.gPg.Io();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gPj = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gPg != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gPg.gT(str);
                }
            }
        };
        this.gPk = new a.InterfaceC0014a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cq(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gPg != null) {
                    LocationModel.this.gPg.gT(str);
                }
            }
        };
        this.gPl = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mL(false);
                        LocationModel.this.cr(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gPh != null) {
                            LocationModel.this.gPh.gU(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mL(true);
                    if (LocationModel.this.gPh != null) {
                        LocationModel.this.gPh.Ip();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gPi = baseActivity;
        registerListener(this.gPj);
        registerListener(this.gPl);
    }

    public void cq(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gPg != null) {
                this.gPg.gT(null);
                return;
            }
            return;
        }
        d(aVar);
        c.byk().cU(System.currentTimeMillis());
        c.byk().b(aVar);
        if (this.gPg != null) {
            this.gPg.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0238a> byh;
        int i;
        int i2;
        if (aVar != null && (byh = aVar.byh()) != null && !byh.isEmpty()) {
            int size = byh.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (byh.get(i3) != null) {
                    str = byh.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    byh.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.byg())) {
                if (byh.size() >= 1) {
                    aVar.tQ(byh.get(0).getName());
                    aVar.tR(byh.get(0).byi());
                    return;
                }
                return;
            }
            for (a.C0238a c0238a : byh) {
                if (aVar.byg().equals(c0238a.getName())) {
                    aVar.tR(c0238a.byi());
                    return;
                }
            }
        }
    }

    public boolean byn() {
        return System.currentTimeMillis() - c.byk().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean byo() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.byk().getLocationData();
        return (byn() || locationData == null || StringUtils.isNull(locationData.byg())) ? false : true;
    }

    public void mL(boolean z) {
        c.byk().mK(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.byk().byl());
    }

    public void cr(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.byk().getLocationData();
        if (locationData != null) {
            locationData.tQ(str);
            locationData.tR(str2);
        }
    }

    public static void byp() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean afw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gPi.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.byk().byl()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void afA() {
        if (this.ceW == null) {
            afB();
            registerListener(this.ceW);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gPg = aVar;
    }

    public void a(b bVar) {
        this.gPh = bVar;
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
