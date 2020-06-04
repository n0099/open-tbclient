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
    private HttpMessageListener loA;
    private com.baidu.adp.framework.listener.c loB;
    private a.InterfaceC0020a loC;
    private CustomMessageListener loD;
    private a loy;
    private b loz;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void bdO();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bdP();

        void yn(String str);
    }

    private void det() {
        this.loA = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.loy != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.loy.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.deu();
            }
        };
    }

    public void deu() {
        if (dew()) {
            if (this.loy != null) {
                this.loy.a(c.der().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.kq().a(true, this.loC);
            }
        } else if (this.loy != null) {
            this.loy.bdO();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.loB = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.loy != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.loy.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.loC = new a.InterfaceC0020a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.loy != null) {
                        LocationModel.this.loy.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.ft(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.loD = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.uw(false);
                        LocationModel.this.fu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.loz != null) {
                            LocationModel.this.loz.yn(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.uw(true);
                    if (LocationModel.this.loz != null) {
                        LocationModel.this.loz.bdP();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.loB);
        registerListener(this.loD);
    }

    public void ft(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.loy != null) {
                this.loy.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.der().setTimeStamp(System.currentTimeMillis());
        c.der().b(aVar);
        if (this.loy != null) {
            this.loy.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0730a> deq;
        int i;
        int i2;
        if (aVar != null && (deq = aVar.deq()) != null && !deq.isEmpty()) {
            int size = deq.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (deq.get(i3) != null) {
                    str = deq.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    deq.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.dep())) {
                if (deq.size() >= 1) {
                    aVar.MF(deq.get(0).getName());
                    aVar.MG(deq.get(0).awy());
                    return;
                }
                return;
            }
            for (a.C0730a c0730a : deq) {
                if (aVar.dep().equals(c0730a.getName())) {
                    aVar.MG(c0730a.awy());
                    return;
                }
            }
        }
    }

    public boolean dev() {
        return System.currentTimeMillis() - c.der().getTimeStamp() > 300000;
    }

    public boolean dew() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.der().getLocationData();
        return (dev() || locationData == null || StringUtils.isNull(locationData.dep())) ? false : true;
    }

    public void uw(boolean z) {
        c.der().uv(z);
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.der().des());
    }

    public void fu(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.der().getLocationData();
        if (locationData != null) {
            locationData.MF(str);
            locationData.MG(str2);
        }
    }

    public static void dex() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bHo() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.der().des();
    }

    public void dey() {
        if (this.loA == null) {
            det();
            registerListener(this.loA);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.loy = aVar;
    }

    public void a(b bVar) {
        this.loz = bVar;
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
