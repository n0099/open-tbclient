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
    private a kiP;
    private b kiQ;
    private HttpMessageListener kiR;
    private com.baidu.adp.framework.listener.c kiS;
    private a.InterfaceC0016a kiT;
    private CustomMessageListener kiU;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aPi();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aPj();

        void vp(String str);
    }

    private void cLG() {
        this.kiR = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.kiP != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kiP.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cLH();
            }
        };
    }

    public void cLH() {
        if (cLJ()) {
            if (this.kiP != null) {
                this.kiP.a(c.cLE().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.fK().a(true, this.kiT);
            }
        } else if (this.kiP != null) {
            this.kiP.aPi();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.kiS = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.kiP != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kiP.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.kiT = new a.InterfaceC0016a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.kiP != null) {
                        LocationModel.this.kiP.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eF(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.kiU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.sQ(false);
                        LocationModel.this.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.kiQ != null) {
                            LocationModel.this.kiQ.vp(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.sQ(true);
                    if (LocationModel.this.kiQ != null) {
                        LocationModel.this.kiQ.aPj();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.kiS);
        registerListener(this.kiU);
    }

    public void eF(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.kiP != null) {
                this.kiP.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cLE().setTimeStamp(System.currentTimeMillis());
        c.cLE().b(aVar);
        if (this.kiP != null) {
            this.kiP.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0613a> cLD;
        int i;
        int i2;
        if (aVar != null && (cLD = aVar.cLD()) != null && !cLD.isEmpty()) {
            int size = cLD.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cLD.get(i3) != null) {
                    str = cLD.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cLD.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cLC())) {
                if (cLD.size() >= 1) {
                    aVar.Je(cLD.get(0).getName());
                    aVar.Jf(cLD.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0613a c0613a : cLD) {
                if (aVar.cLC().equals(c0613a.getName())) {
                    aVar.Jf(c0613a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cLI() {
        return System.currentTimeMillis() - c.cLE().getTimeStamp() > 300000;
    }

    public boolean cLJ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cLE().getLocationData();
        return (cLI() || locationData == null || StringUtils.isNull(locationData.cLC())) ? false : true;
    }

    public void sQ(boolean z) {
        c.cLE().sP(z);
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cLE().cLF());
    }

    public void eG(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cLE().getLocationData();
        if (locationData != null) {
            locationData.Je(str);
            locationData.Jf(str2);
        }
    }

    public static void cLK() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean brj() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cLE().cLF();
    }

    public void cLL() {
        if (this.kiR == null) {
            cLG();
            registerListener(this.kiR);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.kiP = aVar;
    }

    public void a(b bVar) {
        this.kiQ = bVar;
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
