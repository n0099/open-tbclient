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
    private a kUP;
    private b kUQ;
    private HttpMessageListener kUR;
    private com.baidu.adp.framework.listener.c kUS;
    private a.InterfaceC0018a kUT;
    private CustomMessageListener kUU;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void aXE();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aXF();

        void wH(String str);
    }

    private void cWW() {
        this.kUR = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.kUP != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kUP.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cWX();
            }
        };
    }

    public void cWX() {
        if (cWZ()) {
            if (this.kUP != null) {
                this.kUP.a(c.cWU().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.ko().a(true, this.kUT);
            }
        } else if (this.kUP != null) {
            this.kUP.aXE();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.kUS = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.kUP != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.kUP.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.kUT = new a.InterfaceC0018a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.kUP != null) {
                        LocationModel.this.kUP.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eS(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.kUU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.tY(false);
                        LocationModel.this.eT(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.kUQ != null) {
                            LocationModel.this.kUQ.wH(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.tY(true);
                    if (LocationModel.this.kUQ != null) {
                        LocationModel.this.kUQ.aXF();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.kUS);
        registerListener(this.kUU);
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
            if (this.kUP != null) {
                this.kUP.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cWU().setTimeStamp(System.currentTimeMillis());
        c.cWU().b(aVar);
        if (this.kUP != null) {
            this.kUP.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0676a> cWT;
        int i;
        int i2;
        if (aVar != null && (cWT = aVar.cWT()) != null && !cWT.isEmpty()) {
            int size = cWT.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cWT.get(i3) != null) {
                    str = cWT.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cWT.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cWS())) {
                if (cWT.size() >= 1) {
                    aVar.KR(cWT.get(0).getName());
                    aVar.KS(cWT.get(0).asR());
                    return;
                }
                return;
            }
            for (a.C0676a c0676a : cWT) {
                if (aVar.cWS().equals(c0676a.getName())) {
                    aVar.KS(c0676a.asR());
                    return;
                }
            }
        }
    }

    public boolean cWY() {
        return System.currentTimeMillis() - c.cWU().getTimeStamp() > 300000;
    }

    public boolean cWZ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cWU().getLocationData();
        return (cWY() || locationData == null || StringUtils.isNull(locationData.cWS())) ? false : true;
    }

    public void tY(boolean z) {
        c.cWU().tX(z);
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.cWU().cWV());
    }

    public void eT(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cWU().getLocationData();
        if (locationData != null) {
            locationData.KR(str);
            locationData.KS(str2);
        }
    }

    public static void cXa() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bAS() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cWU().cWV();
    }

    public void cXb() {
        if (this.kUR == null) {
            cWW();
            registerListener(this.kUR);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.kUP = aVar;
    }

    public void a(b bVar) {
        this.kUQ = bVar;
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
