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
    private HttpMessageListener cDQ;
    private a hcJ;
    private b hcK;
    private BdBaseActivity hcL;
    private com.baidu.adp.framework.listener.c hcM;
    private a.InterfaceC0017a hcN;
    private CustomMessageListener hcO;

    /* loaded from: classes.dex */
    public interface a {
        void LQ();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gA(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void LR();

        void gB(String str);
    }

    private void ahm() {
        this.cDQ = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hcJ != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hcJ.gA(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bxB();
            }
        };
    }

    public void bxB() {
        if (bxD()) {
            if (this.hcJ != null) {
                this.hcJ.a(c.bxz().getLocationData());
            }
        } else if (j.oJ()) {
            if (ab.aR(this.hcL.getActivity())) {
                com.baidu.adp.lib.d.a.mG().a(true, this.hcN);
            }
        } else if (this.hcJ != null) {
            this.hcJ.LQ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hcM = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hcJ != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hcJ.gA(str);
                }
            }
        };
        this.hcN = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cf(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hcJ != null) {
                    LocationModel.this.hcJ.gA(str);
                }
            }
        };
        this.hcO = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mM(false);
                        LocationModel.this.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hcK != null) {
                            LocationModel.this.hcK.gB(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mM(true);
                    if (LocationModel.this.hcK != null) {
                        LocationModel.this.hcK.LR();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hcL = baseActivity;
        registerListener(this.hcM);
        registerListener(this.hcO);
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
            if (this.hcJ != null) {
                this.hcJ.gA(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bxz().cP(System.currentTimeMillis());
        c.bxz().b(aVar);
        if (this.hcJ != null) {
            this.hcJ.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0238a> bxw;
        int i;
        int i2;
        if (aVar != null && (bxw = aVar.bxw()) != null && !bxw.isEmpty()) {
            int size = bxw.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bxw.get(i3) != null) {
                    str = bxw.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bxw.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bxv())) {
                if (bxw.size() >= 1) {
                    aVar.sN(bxw.get(0).getName());
                    aVar.sO(bxw.get(0).bxx());
                    return;
                }
                return;
            }
            for (a.C0238a c0238a : bxw) {
                if (aVar.bxv().equals(c0238a.getName())) {
                    aVar.sO(c0238a.bxx());
                    return;
                }
            }
        }
    }

    public boolean bxC() {
        return System.currentTimeMillis() - c.bxz().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bxD() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxz().getLocationData();
        return (bxC() || locationData == null || StringUtils.isNull(locationData.bxv())) ? false : true;
    }

    public void mM(boolean z) {
        c.bxz().mL(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bxz().bxA());
    }

    public void cg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxz().getLocationData();
        if (locationData != null) {
            locationData.sN(str);
            locationData.sO(str2);
        }
    }

    public static void bxE() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean ahh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hcL.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bxz().bxA()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void ahl() {
        if (this.cDQ == null) {
            ahm();
            registerListener(this.cDQ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hcJ = aVar;
    }

    public void a(b bVar) {
        this.hcK = bVar;
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
