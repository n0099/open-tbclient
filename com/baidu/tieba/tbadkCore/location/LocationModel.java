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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private a kUL;
    private b kUM;
    private HttpMessageListener kUN;
    private com.baidu.adp.framework.listener.c kUO;
    private a.InterfaceC0018a kUP;
    private CustomMessageListener kUQ;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aXG();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aXH();

        void wE(String str);
    }

    private void cWZ() {
        this.kUN = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.kUL != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kUL.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cXa();
            }
        };
    }

    public void cXa() {
        if (cXc()) {
            if (this.kUL != null) {
                this.kUL.a(c.cWX().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.ko().a(true, this.kUP);
            }
        } else if (this.kUL != null) {
            this.kUL.aXG();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.kUO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.kUL != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kUL.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.kUP = new a.InterfaceC0018a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.kUL != null) {
                        LocationModel.this.kUL.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eS(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.kUQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.tY(false);
                        LocationModel.this.eT(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.kUM != null) {
                            LocationModel.this.kUM.wE(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.tY(true);
                    if (LocationModel.this.kUM != null) {
                        LocationModel.this.kUM.aXH();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.kUO);
        registerListener(this.kUQ);
    }

    public void eS(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.kUL != null) {
                this.kUL.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cWX().setTimeStamp(System.currentTimeMillis());
        c.cWX().b(aVar);
        if (this.kUL != null) {
            this.kUL.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0655a> cWW;
        int i;
        int i2;
        if (aVar != null && (cWW = aVar.cWW()) != null && !cWW.isEmpty()) {
            int size = cWW.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cWW.get(i3) != null) {
                    str = cWW.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cWW.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cWV())) {
                if (cWW.size() >= 1) {
                    aVar.KO(cWW.get(0).getName());
                    aVar.KP(cWW.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0655a c0655a : cWW) {
                if (aVar.cWV().equals(c0655a.getName())) {
                    aVar.KP(c0655a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cXb() {
        return System.currentTimeMillis() - c.cWX().getTimeStamp() > 300000;
    }

    public boolean cXc() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cWX().getLocationData();
        return (cXb() || locationData == null || StringUtils.isNull(locationData.cWV())) ? false : true;
    }

    public void tY(boolean z) {
        c.cWX().tX(z);
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cWX().cWY());
    }

    public void eT(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cWX().getLocationData();
        if (locationData != null) {
            locationData.KO(str);
            locationData.KP(str2);
        }
    }

    public static void cXd() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bAU() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cWX().cWY();
    }

    public void cXe() {
        if (this.kUN == null) {
            cWZ();
            registerListener(this.kUN);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.kUL = aVar;
    }

    public void a(b bVar) {
        this.kUM = bVar;
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
