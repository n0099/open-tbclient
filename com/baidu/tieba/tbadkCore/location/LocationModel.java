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
    private a kef;
    private b keg;
    private HttpMessageListener keh;
    private com.baidu.adp.framework.listener.c kei;
    private a.InterfaceC0016a kej;
    private CustomMessageListener kek;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aMt();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aMu();

        void uT(String str);
    }

    private void cJc() {
        this.keh = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.kef != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kef.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cJd();
            }
        };
    }

    public void cJd() {
        if (cJf()) {
            if (this.kef != null) {
                this.kef.a(c.cJa().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.fK().a(true, this.kej);
            }
        } else if (this.kef != null) {
            this.kef.aMt();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.kei = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.kef != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kef.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.kej = new a.InterfaceC0016a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.kef != null) {
                        LocationModel.this.kef.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eu(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.kek = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.sA(false);
                        LocationModel.this.ev(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.keg != null) {
                            LocationModel.this.keg.uT(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.sA(true);
                    if (LocationModel.this.keg != null) {
                        LocationModel.this.keg.aMu();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.kei);
        registerListener(this.kek);
    }

    public void eu(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.kef != null) {
                this.kef.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cJa().setTimeStamp(System.currentTimeMillis());
        c.cJa().b(aVar);
        if (this.kef != null) {
            this.kef.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0600a> cIZ;
        int i;
        int i2;
        if (aVar != null && (cIZ = aVar.cIZ()) != null && !cIZ.isEmpty()) {
            int size = cIZ.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cIZ.get(i3) != null) {
                    str = cIZ.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cIZ.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cIY())) {
                if (cIZ.size() >= 1) {
                    aVar.IH(cIZ.get(0).getName());
                    aVar.II(cIZ.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0600a c0600a : cIZ) {
                if (aVar.cIY().equals(c0600a.getName())) {
                    aVar.II(c0600a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cJe() {
        return System.currentTimeMillis() - c.cJa().getTimeStamp() > 300000;
    }

    public boolean cJf() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cJa().getLocationData();
        return (cJe() || locationData == null || StringUtils.isNull(locationData.cIY())) ? false : true;
    }

    public void sA(boolean z) {
        c.cJa().sz(z);
        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cJa().cJb());
    }

    public void ev(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cJa().getLocationData();
        if (locationData != null) {
            locationData.IH(str);
            locationData.II(str2);
        }
    }

    public static void cJg() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean boD() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cJa().cJb();
    }

    public void cJh() {
        if (this.keh == null) {
            cJc();
            registerListener(this.keh);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.kef = aVar;
    }

    public void a(b bVar) {
        this.keg = bVar;
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
