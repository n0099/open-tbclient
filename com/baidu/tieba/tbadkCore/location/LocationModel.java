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
    private HttpMessageListener cgF;
    private a gQe;
    private b gQf;
    private BdBaseActivity gQg;
    private com.baidu.adp.framework.listener.c gQh;
    private a.InterfaceC0014a gQi;
    private CustomMessageListener gQj;

    /* loaded from: classes.dex */
    public interface a {
        void Ij();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gP(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ik();

        void gQ(String str);
    }

    private void afV() {
        this.cgF = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gQe != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gQe.gP(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bwP();
            }
        };
    }

    public void bwP() {
        if (bwR()) {
            if (this.gQe != null) {
                this.gQe.a(c.bwN().getLocationData());
            }
        } else if (j.jE()) {
            if (ac.aN(this.gQg.getActivity())) {
                com.baidu.adp.lib.d.a.hB().a(true, this.gQi);
            }
        } else if (this.gQe != null) {
            this.gQe.Ij();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gQh = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gQe != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gQe.gP(str);
                }
            }
        };
        this.gQi = new a.InterfaceC0014a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cn(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gQe != null) {
                    LocationModel.this.gQe.gP(str);
                }
            }
        };
        this.gQj = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mw(false);
                        LocationModel.this.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gQf != null) {
                            LocationModel.this.gQf.gQ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mw(true);
                    if (LocationModel.this.gQf != null) {
                        LocationModel.this.gQf.Ik();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gQg = baseActivity;
        registerListener(this.gQh);
        registerListener(this.gQj);
    }

    public void cn(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gQe != null) {
                this.gQe.gP(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bwN().cR(System.currentTimeMillis());
        c.bwN().b(aVar);
        if (this.gQe != null) {
            this.gQe.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0238a> bwK;
        int i;
        int i2;
        if (aVar != null && (bwK = aVar.bwK()) != null && !bwK.isEmpty()) {
            int size = bwK.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bwK.get(i3) != null) {
                    str = bwK.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bwK.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bwJ())) {
                if (bwK.size() >= 1) {
                    aVar.tO(bwK.get(0).getName());
                    aVar.tP(bwK.get(0).bwL());
                    return;
                }
                return;
            }
            for (a.C0238a c0238a : bwK) {
                if (aVar.bwJ().equals(c0238a.getName())) {
                    aVar.tP(c0238a.bwL());
                    return;
                }
            }
        }
    }

    public boolean bwQ() {
        return System.currentTimeMillis() - c.bwN().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bwR() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwN().getLocationData();
        return (bwQ() || locationData == null || StringUtils.isNull(locationData.bwJ())) ? false : true;
    }

    public void mw(boolean z) {
        c.bwN().mv(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bwN().bwO());
    }

    public void co(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwN().getLocationData();
        if (locationData != null) {
            locationData.tO(str);
            locationData.tP(str2);
        }
    }

    public static void bwS() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean afQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gQg.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bwN().bwO()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void afU() {
        if (this.cgF == null) {
            afV();
            registerListener(this.cgF);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gQe = aVar;
    }

    public void a(b bVar) {
        this.gQf = bVar;
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
