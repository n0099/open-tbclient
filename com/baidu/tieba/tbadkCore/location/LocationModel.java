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
    private a kjd;
    private b kje;
    private HttpMessageListener kjf;
    private com.baidu.adp.framework.listener.c kjg;
    private a.InterfaceC0016a kjh;
    private CustomMessageListener kji;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aPl();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aPm();

        void vq(String str);
    }

    private void cLJ() {
        this.kjf = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.kjd != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kjd.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cLK();
            }
        };
    }

    public void cLK() {
        if (cLM()) {
            if (this.kjd != null) {
                this.kjd.a(c.cLH().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.fK().a(true, this.kjh);
            }
        } else if (this.kjd != null) {
            this.kjd.aPl();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.kjg = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.kjd != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kjd.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.kjh = new a.InterfaceC0016a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.kjd != null) {
                        LocationModel.this.kjd.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eF(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.kji = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.sQ(false);
                        LocationModel.this.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.kje != null) {
                            LocationModel.this.kje.vq(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.sQ(true);
                    if (LocationModel.this.kje != null) {
                        LocationModel.this.kje.aPm();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.kjg);
        registerListener(this.kji);
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
            if (this.kjd != null) {
                this.kjd.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cLH().setTimeStamp(System.currentTimeMillis());
        c.cLH().b(aVar);
        if (this.kjd != null) {
            this.kjd.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0613a> cLG;
        int i;
        int i2;
        if (aVar != null && (cLG = aVar.cLG()) != null && !cLG.isEmpty()) {
            int size = cLG.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cLG.get(i3) != null) {
                    str = cLG.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cLG.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cLF())) {
                if (cLG.size() >= 1) {
                    aVar.Jf(cLG.get(0).getName());
                    aVar.Jg(cLG.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0613a c0613a : cLG) {
                if (aVar.cLF().equals(c0613a.getName())) {
                    aVar.Jg(c0613a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cLL() {
        return System.currentTimeMillis() - c.cLH().getTimeStamp() > 300000;
    }

    public boolean cLM() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cLH().getLocationData();
        return (cLL() || locationData == null || StringUtils.isNull(locationData.cLF())) ? false : true;
    }

    public void sQ(boolean z) {
        c.cLH().sP(z);
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cLH().cLI());
    }

    public void eG(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cLH().getLocationData();
        if (locationData != null) {
            locationData.Jf(str);
            locationData.Jg(str2);
        }
    }

    public static void cLN() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean brm() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cLH().cLI();
    }

    public void cLO() {
        if (this.kjf == null) {
            cLJ();
            registerListener(this.kjf);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.kjd = aVar;
    }

    public void a(b bVar) {
        this.kje = bVar;
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
