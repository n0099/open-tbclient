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
    private a kkF;
    private b kkG;
    private HttpMessageListener kkH;
    private com.baidu.adp.framework.listener.c kkI;
    private a.InterfaceC0016a kkJ;
    private CustomMessageListener kkK;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aPp();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aPq();

        void vq(String str);
    }

    private void cMd() {
        this.kkH = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.kkF != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kkF.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cMe();
            }
        };
    }

    public void cMe() {
        if (cMg()) {
            if (this.kkF != null) {
                this.kkF.a(c.cMb().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.fK().a(true, this.kkJ);
            }
        } else if (this.kkF != null) {
            this.kkF.aPp();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.kkI = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.kkF != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kkF.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.kkJ = new a.InterfaceC0016a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.kkF != null) {
                        LocationModel.this.kkF.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eD(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.kkK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.sW(false);
                        LocationModel.this.eE(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.kkG != null) {
                            LocationModel.this.kkG.vq(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.sW(true);
                    if (LocationModel.this.kkG != null) {
                        LocationModel.this.kkG.aPq();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.kkI);
        registerListener(this.kkK);
    }

    public void eD(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.kkF != null) {
                this.kkF.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cMb().setTimeStamp(System.currentTimeMillis());
        c.cMb().b(aVar);
        if (this.kkF != null) {
            this.kkF.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0614a> cMa;
        int i;
        int i2;
        if (aVar != null && (cMa = aVar.cMa()) != null && !cMa.isEmpty()) {
            int size = cMa.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cMa.get(i3) != null) {
                    str = cMa.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cMa.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cLZ())) {
                if (cMa.size() >= 1) {
                    aVar.Jf(cMa.get(0).getName());
                    aVar.Jg(cMa.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0614a c0614a : cMa) {
                if (aVar.cLZ().equals(c0614a.getName())) {
                    aVar.Jg(c0614a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cMf() {
        return System.currentTimeMillis() - c.cMb().getTimeStamp() > 300000;
    }

    public boolean cMg() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cMb().getLocationData();
        return (cMf() || locationData == null || StringUtils.isNull(locationData.cLZ())) ? false : true;
    }

    public void sW(boolean z) {
        c.cMb().sV(z);
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cMb().cMc());
    }

    public void eE(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cMb().getLocationData();
        if (locationData != null) {
            locationData.Jf(str);
            locationData.Jg(str2);
        }
    }

    public static void cMh() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean brr() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cMb().cMc();
    }

    public void cMi() {
        if (this.kkH == null) {
            cMd();
            registerListener(this.kkH);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.kkF = aVar;
    }

    public void a(b bVar) {
        this.kkG = bVar;
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
