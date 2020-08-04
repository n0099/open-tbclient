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
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private b lPA;
    private HttpMessageListener lPB;
    private com.baidu.adp.framework.listener.c lPC;
    private a.InterfaceC0021a lPD;
    private CustomMessageListener lPE;
    private a lPz;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void bjD();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bjE();

        void zM(String str);
    }

    private void dlP() {
        this.lPB = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.lPz != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.lPz.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.dlQ();
            }
        };
    }

    public void dlQ() {
        if (dlS()) {
            if (this.lPz != null) {
                this.lPz.a(c.dlN().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ad.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.kG().a(true, this.lPD);
            }
        } else if (this.lPz != null) {
            this.lPz.bjD();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.lPC = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.lPz != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.lPz.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.lPD = new a.InterfaceC0021a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.lPz != null) {
                        LocationModel.this.lPz.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.fC(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.lPE = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.vp(false);
                        LocationModel.this.fD(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.lPA != null) {
                            LocationModel.this.lPA.zM(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.vp(true);
                    if (LocationModel.this.lPA != null) {
                        LocationModel.this.lPA.bjE();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.lPC);
        registerListener(this.lPE);
    }

    public void fC(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.lPz != null) {
                this.lPz.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.dlN().setTimeStamp(System.currentTimeMillis());
        c.dlN().b(aVar);
        if (this.lPz != null) {
            this.lPz.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0756a> dlM;
        int i;
        int i2;
        if (aVar != null && (dlM = aVar.dlM()) != null && !dlM.isEmpty()) {
            int size = dlM.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (dlM.get(i3) != null) {
                    str = dlM.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    dlM.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.dlL())) {
                if (dlM.size() >= 1) {
                    aVar.NP(dlM.get(0).getName());
                    aVar.NQ(dlM.get(0).aAC());
                    return;
                }
                return;
            }
            for (a.C0756a c0756a : dlM) {
                if (aVar.dlL().equals(c0756a.getName())) {
                    aVar.NQ(c0756a.aAC());
                    return;
                }
            }
        }
    }

    public boolean dlR() {
        return System.currentTimeMillis() - c.dlN().getTimeStamp() > 300000;
    }

    public boolean dlS() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.dlN().getLocationData();
        return (dlR() || locationData == null || StringUtils.isNull(locationData.dlL())) ? false : true;
    }

    public void vp(boolean z) {
        c.dlN().vo(z);
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.dlN().dlO());
    }

    public void fD(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.dlN().getLocationData();
        if (locationData != null) {
            locationData.NP(str);
            locationData.NQ(str2);
        }
    }

    public static void dlT() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bNz() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.dlN().dlO();
    }

    public void dlU() {
        if (this.lPB == null) {
            dlP();
            registerListener(this.lPB);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.lPz = aVar;
    }

    public void a(b bVar) {
        this.lPA = bVar;
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
