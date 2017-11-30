package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener bKZ;
    private a gBn;
    private b gBo;
    private BdBaseActivity gBp;
    private com.baidu.adp.framework.listener.c gBq;
    private a.InterfaceC0004a gBr;
    private CustomMessageListener gBs;

    /* loaded from: classes.dex */
    public interface a {
        void DS();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gb(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DT();

        void gc(String str);
    }

    private void YN() {
        this.bKZ = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gBn != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gBn.gb(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bwY();
            }
        };
    }

    public void bwY() {
        if (bxa()) {
            if (this.gBn != null) {
                this.gBn.a(c.bwW().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aJ(this.gBp.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.gBr);
            }
        } else if (this.gBn != null) {
            this.gBn.DS();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gBq = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gBn != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gBn.gb(str);
                }
            }
        };
        this.gBr = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cg(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gBn != null) {
                    LocationModel.this.gBn.gb(str);
                }
            }
        };
        this.gBs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.ne(false);
                        LocationModel.this.ch(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gBo != null) {
                            LocationModel.this.gBo.gc(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.ne(true);
                    if (LocationModel.this.gBo != null) {
                        LocationModel.this.gBo.DT();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gBp = baseActivity;
        registerListener(this.gBq);
        registerListener(this.gBs);
    }

    public void cg(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gBn != null) {
                this.gBn.gb(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bwW().cM(System.currentTimeMillis());
        c.bwW().b(aVar);
        if (this.gBn != null) {
            this.gBn.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0130a> bwT;
        int i;
        int i2;
        if (aVar != null && (bwT = aVar.bwT()) != null && !bwT.isEmpty()) {
            int size = bwT.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bwT.get(i3) != null) {
                    str = bwT.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bwT.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bwS())) {
                if (bwT.size() >= 1) {
                    aVar.ta(bwT.get(0).getName());
                    aVar.tb(bwT.get(0).bwU());
                    return;
                }
                return;
            }
            for (a.C0130a c0130a : bwT) {
                if (aVar.bwS().equals(c0130a.getName())) {
                    aVar.tb(c0130a.bwU());
                    return;
                }
            }
        }
    }

    public boolean bwZ() {
        return System.currentTimeMillis() - c.bwW().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bxa() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwW().getLocationData();
        return (bwZ() || locationData == null || StringUtils.isNull(locationData.bwS())) ? false : true;
    }

    public void ne(boolean z) {
        c.bwW().nd(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bwW().bwX());
    }

    public void ch(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwW().getLocationData();
        if (locationData != null) {
            locationData.ta(str);
            locationData.tb(str2);
        }
    }

    public static void bxb() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean YI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gBp.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bwW().bwX()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void YM() {
        if (this.bKZ == null) {
            YN();
            registerListener(this.bKZ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gBn = aVar;
    }

    public void a(b bVar) {
        this.gBo = bVar;
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
