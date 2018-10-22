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
    private HttpMessageListener cuY;
    private a hfe;
    private b hff;
    private BdBaseActivity hfg;
    private com.baidu.adp.framework.listener.c hfh;
    private a.InterfaceC0017a hfi;
    private CustomMessageListener hfj;

    /* loaded from: classes.dex */
    public interface a {
        void Lx();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void hz(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ly();

        void hA(String str);
    }

    private void alp() {
        this.cuY = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hfe != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hfe.hz(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bCJ();
            }
        };
    }

    public void bCJ() {
        if (bCL()) {
            if (this.hfe != null) {
                this.hfe.a(c.bCH().getLocationData());
            }
        } else if (j.kX()) {
            if (ab.bB(this.hfg.getActivity())) {
                com.baidu.adp.lib.d.a.iX().a(true, this.hfi);
            }
        } else if (this.hfe != null) {
            this.hfe.Lx();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hfh = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hfe != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hfe.hz(str);
                }
            }
        };
        this.hfi = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cI(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hfe != null) {
                    LocationModel.this.hfe.hz(str);
                }
            }
        };
        this.hfj = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.nk(false);
                        LocationModel.this.cJ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hff != null) {
                            LocationModel.this.hff.hA(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.nk(true);
                    if (LocationModel.this.hff != null) {
                        LocationModel.this.hff.Ly();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hfg = baseActivity;
        registerListener(this.hfh);
        registerListener(this.hfj);
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
            if (this.hfe != null) {
                this.hfe.hz(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bCH().dc(System.currentTimeMillis());
        c.bCH().b(aVar);
        if (this.hfe != null) {
            this.hfe.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0279a> bCE;
        int i;
        int i2;
        if (aVar != null && (bCE = aVar.bCE()) != null && !bCE.isEmpty()) {
            int size = bCE.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bCE.get(i3) != null) {
                    str = bCE.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bCE.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bCD())) {
                if (bCE.size() >= 1) {
                    aVar.vb(bCE.get(0).getName());
                    aVar.vc(bCE.get(0).bCF());
                    return;
                }
                return;
            }
            for (a.C0279a c0279a : bCE) {
                if (aVar.bCD().equals(c0279a.getName())) {
                    aVar.vc(c0279a.bCF());
                    return;
                }
            }
        }
    }

    public boolean bCK() {
        return System.currentTimeMillis() - c.bCH().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bCL() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCH().getLocationData();
        return (bCK() || locationData == null || StringUtils.isNull(locationData.bCD())) ? false : true;
    }

    public void nk(boolean z) {
        c.bCH().nj(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bCH().bCI());
    }

    public void cJ(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCH().getLocationData();
        if (locationData != null) {
            locationData.vb(str);
            locationData.vc(str2);
        }
    }

    public static void bCM() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean alk() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hfg.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bCH().bCI()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void alo() {
        if (this.cuY == null) {
            alp();
            registerListener(this.cuY);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hfe = aVar;
    }

    public void a(b bVar) {
        this.hff = bVar;
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
