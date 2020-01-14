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
    private a khN;
    private b khO;
    private HttpMessageListener khP;
    private com.baidu.adp.framework.listener.c khQ;
    private a.InterfaceC0016a khR;
    private CustomMessageListener khS;
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

    private void cKi() {
        this.khP = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.khN != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.khN.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cKj();
            }
        };
    }

    public void cKj() {
        if (cKl()) {
            if (this.khN != null) {
                this.khN.a(c.cKg().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.fK().a(true, this.khR);
            }
        } else if (this.khN != null) {
            this.khN.aMM();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.khQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.khN != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.khN.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.khR = new a.InterfaceC0016a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.khN != null) {
                        LocationModel.this.khN.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.ew(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.khS = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.sM(false);
                        LocationModel.this.ex(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.khO != null) {
                            LocationModel.this.khO.uY(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.sM(true);
                    if (LocationModel.this.khO != null) {
                        LocationModel.this.khO.aMN();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.khQ);
        registerListener(this.khS);
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
            if (this.khN != null) {
                this.khN.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cKg().setTimeStamp(System.currentTimeMillis());
        c.cKg().b(aVar);
        if (this.khN != null) {
            this.khN.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0605a> cKf;
        int i;
        int i2;
        if (aVar != null && (cKf = aVar.cKf()) != null && !cKf.isEmpty()) {
            int size = cKf.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cKf.get(i3) != null) {
                    str = cKf.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cKf.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cKe())) {
                if (cKf.size() >= 1) {
                    aVar.IR(cKf.get(0).getName());
                    aVar.IS(cKf.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0605a c0605a : cKf) {
                if (aVar.cKe().equals(c0605a.getName())) {
                    aVar.IS(c0605a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cKk() {
        return System.currentTimeMillis() - c.cKg().getTimeStamp() > 300000;
    }

    public boolean cKl() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cKg().getLocationData();
        return (cKk() || locationData == null || StringUtils.isNull(locationData.cKe())) ? false : true;
    }

    public void sM(boolean z) {
        c.cKg().sL(z);
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cKg().cKh());
    }

    public void ex(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cKg().getLocationData();
        if (locationData != null) {
            locationData.IR(str);
            locationData.IS(str2);
        }
    }

    public static void cKm() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bpD() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cKg().cKh();
    }

    public void cKn() {
        if (this.khP == null) {
            cKi();
            registerListener(this.khP);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.khN = aVar;
    }

    public void a(b bVar) {
        this.khO = bVar;
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
