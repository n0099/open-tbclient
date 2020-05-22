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
    private a lnl;
    private b lnm;
    private HttpMessageListener lnn;
    private com.baidu.adp.framework.listener.c lno;
    private a.InterfaceC0020a lnp;
    private CustomMessageListener lnq;
    private e mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void bdN();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bdO();

        void yn(String str);
    }

    private void dee() {
        this.lnn = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.lnl != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.lnl.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.def();
            }
        };
    }

    public void def() {
        if (deh()) {
            if (this.lnl != null) {
                this.lnl.a(c.dec().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.kq().a(true, this.lnp);
            }
        } else if (this.lnl != null) {
            this.lnl.bdN();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.lno = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.lnl != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.lnl.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.lnp = new a.InterfaceC0020a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.lnl != null) {
                        LocationModel.this.lnl.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.ft(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.lnq = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.uw(false);
                        LocationModel.this.fu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.lnm != null) {
                            LocationModel.this.lnm.yn(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.uw(true);
                    if (LocationModel.this.lnm != null) {
                        LocationModel.this.lnm.bdO();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        registerListener(this.lno);
        registerListener(this.lnq);
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
            if (this.lnl != null) {
                this.lnl.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.dec().setTimeStamp(System.currentTimeMillis());
        c.dec().b(aVar);
        if (this.lnl != null) {
            this.lnl.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0729a> deb;
        int i;
        int i2;
        if (aVar != null && (deb = aVar.deb()) != null && !deb.isEmpty()) {
            int size = deb.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (deb.get(i3) != null) {
                    str = deb.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    deb.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.dea())) {
                if (deb.size() >= 1) {
                    aVar.ME(deb.get(0).getName());
                    aVar.MF(deb.get(0).awy());
                    return;
                }
                return;
            }
            for (a.C0729a c0729a : deb) {
                if (aVar.dea().equals(c0729a.getName())) {
                    aVar.MF(c0729a.awy());
                    return;
                }
            }
        }
    }

    public boolean deg() {
        return System.currentTimeMillis() - c.dec().getTimeStamp() > 300000;
    }

    public boolean deh() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.dec().getLocationData();
        return (deg() || locationData == null || StringUtils.isNull(locationData.dea())) ? false : true;
    }

    public void uw(boolean z) {
        c.dec().uv(z);
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.dec().ded());
    }

    public void fu(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.dec().getLocationData();
        if (locationData != null) {
            locationData.ME(str);
            locationData.MF(str2);
        }
    }

    public static void dei() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bHm() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.dec().ded();
    }

    public void dej() {
        if (this.lnn == null) {
            dee();
            registerListener(this.lnn);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.lnl = aVar;
    }

    public void a(b bVar) {
        this.lnm = bVar;
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
