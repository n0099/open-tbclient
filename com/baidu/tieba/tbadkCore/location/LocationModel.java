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
    private HttpMessageListener ccM;
    private a gLf;
    private b gLg;
    private BdBaseActivity gLh;
    private com.baidu.adp.framework.listener.c gLi;
    private a.InterfaceC0014a gLj;
    private CustomMessageListener gLk;

    /* loaded from: classes.dex */
    public interface a {
        void HW();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gP(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void HX();

        void gQ(String str);
    }

    private void aeT() {
        this.ccM = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gLf != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gLf.gP(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bxJ();
            }
        };
    }

    public void bxJ() {
        if (bxL()) {
            if (this.gLf != null) {
                this.gLf.a(c.bxH().getLocationData());
            }
        } else if (j.jD()) {
            if (ac.aM(this.gLh.getActivity())) {
                com.baidu.adp.lib.d.a.hB().a(true, this.gLj);
            }
        } else if (this.gLf != null) {
            this.gLf.HW();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gLi = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gLf != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gLf.gP(str);
                }
            }
        };
        this.gLj = new a.InterfaceC0014a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cm(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gLf != null) {
                    LocationModel.this.gLf.gP(str);
                }
            }
        };
        this.gLk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mA(false);
                        LocationModel.this.cn(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gLg != null) {
                            LocationModel.this.gLg.gQ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mA(true);
                    if (LocationModel.this.gLg != null) {
                        LocationModel.this.gLg.HX();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gLh = baseActivity;
        registerListener(this.gLi);
        registerListener(this.gLk);
    }

    public void cm(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gLf != null) {
                this.gLf.gP(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bxH().cZ(System.currentTimeMillis());
        c.bxH().b(aVar);
        if (this.gLf != null) {
            this.gLf.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0236a> bxE;
        int i;
        int i2;
        if (aVar != null && (bxE = aVar.bxE()) != null && !bxE.isEmpty()) {
            int size = bxE.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bxE.get(i3) != null) {
                    str = bxE.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bxE.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bxD())) {
                if (bxE.size() >= 1) {
                    aVar.tR(bxE.get(0).getName());
                    aVar.tS(bxE.get(0).bxF());
                    return;
                }
                return;
            }
            for (a.C0236a c0236a : bxE) {
                if (aVar.bxD().equals(c0236a.getName())) {
                    aVar.tS(c0236a.bxF());
                    return;
                }
            }
        }
    }

    public boolean bxK() {
        return System.currentTimeMillis() - c.bxH().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bxL() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxH().getLocationData();
        return (bxK() || locationData == null || StringUtils.isNull(locationData.bxD())) ? false : true;
    }

    public void mA(boolean z) {
        c.bxH().mz(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bxH().bxI());
    }

    public void cn(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxH().getLocationData();
        if (locationData != null) {
            locationData.tR(str);
            locationData.tS(str2);
        }
    }

    public static void bxM() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aeO() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gLh.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bxH().bxI()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aeS() {
        if (this.ccM == null) {
            aeT();
            registerListener(this.ccM);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gLf = aVar;
    }

    public void a(b bVar) {
        this.gLg = bVar;
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
