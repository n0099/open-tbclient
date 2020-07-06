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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private a lIj;
    private b lIk;
    private HttpMessageListener lIl;
    private com.baidu.adp.framework.listener.c lIm;
    private a.InterfaceC0020a lIn;
    private CustomMessageListener lIo;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void bfT();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bfU();

        void yG(String str);
    }

    private void diG() {
        this.lIl = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.lIj != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.lIj.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.diH();
            }
        };
    }

    public void diH() {
        if (diJ()) {
            if (this.lIj != null) {
                this.lIj.a(c.diE().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ac.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.kG().a(true, this.lIn);
            }
        } else if (this.lIj != null) {
            this.lIj.bfT();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.lIm = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.lIj != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.lIj.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.lIn = new a.InterfaceC0020a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.lIj != null) {
                        LocationModel.this.lIj.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.fA(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.lIo = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.uL(false);
                        LocationModel.this.fB(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.lIk != null) {
                            LocationModel.this.lIk.yG(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.uL(true);
                    if (LocationModel.this.lIk != null) {
                        LocationModel.this.lIk.bfU();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.lIm);
        registerListener(this.lIo);
    }

    public void fA(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.lIj != null) {
                this.lIj.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.diE().setTimeStamp(System.currentTimeMillis());
        c.diE().b(aVar);
        if (this.lIj != null) {
            this.lIj.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0746a> diD;
        int i;
        int i2;
        if (aVar != null && (diD = aVar.diD()) != null && !diD.isEmpty()) {
            int size = diD.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (diD.get(i3) != null) {
                    str = diD.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    diD.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.diC())) {
                if (diD.size() >= 1) {
                    aVar.Nh(diD.get(0).getName());
                    aVar.Ni(diD.get(0).axE());
                    return;
                }
                return;
            }
            for (a.C0746a c0746a : diD) {
                if (aVar.diC().equals(c0746a.getName())) {
                    aVar.Ni(c0746a.axE());
                    return;
                }
            }
        }
    }

    public boolean diI() {
        return System.currentTimeMillis() - c.diE().getTimeStamp() > 300000;
    }

    public boolean diJ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.diE().getLocationData();
        return (diI() || locationData == null || StringUtils.isNull(locationData.diC())) ? false : true;
    }

    public void uL(boolean z) {
        c.diE().uK(z);
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.diE().diF());
    }

    public void fB(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.diE().getLocationData();
        if (locationData != null) {
            locationData.Nh(str);
            locationData.Ni(str2);
        }
    }

    public static void diK() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bKt() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.diE().diF();
    }

    public void diL() {
        if (this.lIl == null) {
            diG();
            registerListener(this.lIl);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.lIj = aVar;
    }

    public void a(b bVar) {
        this.lIk = bVar;
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
