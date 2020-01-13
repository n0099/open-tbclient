package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private a khI;
    private b khJ;
    private HttpMessageListener khK;
    private com.baidu.adp.framework.listener.c khL;
    private a.InterfaceC0016a khM;
    private CustomMessageListener khN;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aMM();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aMN();

        void uY(String str);
    }

    private void cKg() {
        this.khK = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.khI != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.khI.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cKh();
            }
        };
    }

    public void cKh() {
        if (cKj()) {
            if (this.khI != null) {
                this.khI.a(c.cKe().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.fK().a(true, this.khM);
            }
        } else if (this.khI != null) {
            this.khI.aMM();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.khL = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.khI != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.khI.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.khM = new a.InterfaceC0016a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.khI != null) {
                        LocationModel.this.khI.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.ew(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.khN = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.sM(false);
                        LocationModel.this.ex(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.khJ != null) {
                            LocationModel.this.khJ.uY(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.sM(true);
                    if (LocationModel.this.khJ != null) {
                        LocationModel.this.khJ.aMN();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.khL);
        registerListener(this.khN);
    }

    public void ew(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.khI != null) {
                this.khI.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cKe().setTimeStamp(System.currentTimeMillis());
        c.cKe().b(aVar);
        if (this.khI != null) {
            this.khI.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0605a> cKd;
        int i;
        int i2;
        if (aVar != null && (cKd = aVar.cKd()) != null && !cKd.isEmpty()) {
            int size = cKd.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cKd.get(i3) != null) {
                    str = cKd.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cKd.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cKc())) {
                if (cKd.size() >= 1) {
                    aVar.IR(cKd.get(0).getName());
                    aVar.IS(cKd.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0605a c0605a : cKd) {
                if (aVar.cKc().equals(c0605a.getName())) {
                    aVar.IS(c0605a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cKi() {
        return System.currentTimeMillis() - c.cKe().getTimeStamp() > 300000;
    }

    public boolean cKj() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cKe().getLocationData();
        return (cKi() || locationData == null || StringUtils.isNull(locationData.cKc())) ? false : true;
    }

    public void sM(boolean z) {
        c.cKe().sL(z);
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cKe().cKf());
    }

    public void ex(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cKe().getLocationData();
        if (locationData != null) {
            locationData.IR(str);
            locationData.IS(str2);
        }
    }

    public static void cKk() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bpD() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cKe().cKf();
    }

    public void cKl() {
        if (this.khK == null) {
            cKg();
            registerListener(this.khK);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.khI = aVar;
    }

    public void a(b bVar) {
        this.khJ = bVar;
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
