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
    private HttpMessageListener cgC;
    private a gQf;
    private b gQg;
    private BdBaseActivity gQh;
    private com.baidu.adp.framework.listener.c gQi;
    private a.InterfaceC0014a gQj;
    private CustomMessageListener gQk;

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

    private void afX() {
        this.cgC = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gQf != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gQf.gP(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bwQ();
            }
        };
    }

    public void bwQ() {
        if (bwS()) {
            if (this.gQf != null) {
                this.gQf.a(c.bwO().getLocationData());
            }
        } else if (j.jE()) {
            if (ac.aM(this.gQh.getActivity())) {
                com.baidu.adp.lib.d.a.hB().a(true, this.gQj);
            }
        } else if (this.gQf != null) {
            this.gQf.Ij();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gQi = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gQf != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gQf.gP(str);
                }
            }
        };
        this.gQj = new a.InterfaceC0014a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cn(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gQf != null) {
                    LocationModel.this.gQf.gP(str);
                }
            }
        };
        this.gQk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mw(false);
                        LocationModel.this.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gQg != null) {
                            LocationModel.this.gQg.gQ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mw(true);
                    if (LocationModel.this.gQg != null) {
                        LocationModel.this.gQg.Ik();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gQh = baseActivity;
        registerListener(this.gQi);
        registerListener(this.gQk);
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
            if (this.gQf != null) {
                this.gQf.gP(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bwO().cR(System.currentTimeMillis());
        c.bwO().b(aVar);
        if (this.gQf != null) {
            this.gQf.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0238a> bwL;
        int i;
        int i2;
        if (aVar != null && (bwL = aVar.bwL()) != null && !bwL.isEmpty()) {
            int size = bwL.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bwL.get(i3) != null) {
                    str = bwL.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bwL.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bwK())) {
                if (bwL.size() >= 1) {
                    aVar.tS(bwL.get(0).getName());
                    aVar.tT(bwL.get(0).bwM());
                    return;
                }
                return;
            }
            for (a.C0238a c0238a : bwL) {
                if (aVar.bwK().equals(c0238a.getName())) {
                    aVar.tT(c0238a.bwM());
                    return;
                }
            }
        }
    }

    public boolean bwR() {
        return System.currentTimeMillis() - c.bwO().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bwS() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwO().getLocationData();
        return (bwR() || locationData == null || StringUtils.isNull(locationData.bwK())) ? false : true;
    }

    public void mw(boolean z) {
        c.bwO().mv(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bwO().bwP());
    }

    public void co(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwO().getLocationData();
        if (locationData != null) {
            locationData.tS(str);
            locationData.tT(str2);
        }
    }

    public static void bwT() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean afS() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gQh.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bwO().bwP()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void afW() {
        if (this.cgC == null) {
            afX();
            registerListener(this.cgC);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gQf = aVar;
    }

    public void a(b bVar) {
        this.gQg = bVar;
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
