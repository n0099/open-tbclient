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
    private HttpMessageListener cDT;
    private a hdh;
    private b hdi;
    private BdBaseActivity hdj;
    private com.baidu.adp.framework.listener.c hdk;
    private a.InterfaceC0017a hdl;
    private CustomMessageListener hdm;

    /* loaded from: classes.dex */
    public interface a {
        void LR();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gA(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void LS();

        void gB(String str);
    }

    private void ahn() {
        this.cDT = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hdh != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hdh.gA(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bxG();
            }
        };
    }

    public void bxG() {
        if (bxI()) {
            if (this.hdh != null) {
                this.hdh.a(c.bxE().getLocationData());
            }
        } else if (j.oJ()) {
            if (ab.aR(this.hdj.getActivity())) {
                com.baidu.adp.lib.d.a.mG().a(true, this.hdl);
            }
        } else if (this.hdh != null) {
            this.hdh.LR();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hdk = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hdh != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hdh.gA(str);
                }
            }
        };
        this.hdl = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cf(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hdh != null) {
                    LocationModel.this.hdh.gA(str);
                }
            }
        };
        this.hdm = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mR(false);
                        LocationModel.this.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hdi != null) {
                            LocationModel.this.hdi.gB(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mR(true);
                    if (LocationModel.this.hdi != null) {
                        LocationModel.this.hdi.LS();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hdj = baseActivity;
        registerListener(this.hdk);
        registerListener(this.hdm);
    }

    public void cf(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.hdh != null) {
                this.hdh.gA(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bxE().cP(System.currentTimeMillis());
        c.bxE().b(aVar);
        if (this.hdh != null) {
            this.hdh.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0238a> bxB;
        int i;
        int i2;
        if (aVar != null && (bxB = aVar.bxB()) != null && !bxB.isEmpty()) {
            int size = bxB.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bxB.get(i3) != null) {
                    str = bxB.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bxB.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bxA())) {
                if (bxB.size() >= 1) {
                    aVar.sN(bxB.get(0).getName());
                    aVar.sO(bxB.get(0).bxC());
                    return;
                }
                return;
            }
            for (a.C0238a c0238a : bxB) {
                if (aVar.bxA().equals(c0238a.getName())) {
                    aVar.sO(c0238a.bxC());
                    return;
                }
            }
        }
    }

    public boolean bxH() {
        return System.currentTimeMillis() - c.bxE().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bxI() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxE().getLocationData();
        return (bxH() || locationData == null || StringUtils.isNull(locationData.bxA())) ? false : true;
    }

    public void mR(boolean z) {
        c.bxE().mQ(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bxE().bxF());
    }

    public void cg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxE().getLocationData();
        if (locationData != null) {
            locationData.sN(str);
            locationData.sO(str2);
        }
    }

    public static void bxJ() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean ahi() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hdj.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bxE().bxF()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void ahm() {
        if (this.cDT == null) {
            ahn();
            registerListener(this.cDT);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hdh = aVar;
    }

    public void a(b bVar) {
        this.hdi = bVar;
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
