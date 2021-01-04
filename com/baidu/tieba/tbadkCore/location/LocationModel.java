package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.c;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private c fKd;
    private f mContext;
    private a nuc;
    private b nud;
    private HttpMessageListener nue;
    private a.InterfaceC0015a nuf;
    private CustomMessageListener nug;

    /* loaded from: classes.dex */
    public interface a {
        void a(LocationData locationData);

        void bFH();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DW(String str);

        void bFI();
    }

    private void dPS() {
        this.nue = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.nuc != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.nuc.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.dPT();
            }
        };
    }

    public void dPT() {
        if (dPV()) {
            if (this.nuc != null) {
                this.nuc.a(com.baidu.tieba.tbadkCore.location.b.dPQ().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ad.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.lI().a(true, this.nuf);
            }
        } else if (this.nuc != null) {
            this.nuc.bFH();
        }
    }

    public LocationModel(f fVar) {
        super(fVar);
        this.fKd = new c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.nuc != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.nuc.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.b(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.nuf = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.nuc != null) {
                        LocationModel.this.nuc.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.gu(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.nug = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.yn(false);
                        LocationModel.this.gv(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.nud != null) {
                            LocationModel.this.nud.DW(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.yn(true);
                    if (LocationModel.this.nud != null) {
                        LocationModel.this.nud.bFI();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = fVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.fKd.setSelfListener(false);
        }
        registerListener(this.fKd);
        registerListener(this.nug);
    }

    public void gu(String str, String str2) {
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (this.mContext.getPageActivity() instanceof BaseActivity) {
                LocationEvent locationEvent = new LocationEvent();
                locationEvent.setType(3);
                locationEvent.eventType = 0;
                locationEvent.lat = str2;
                locationEvent.lng = str;
                ((BaseActivity) this.mContext.getPageActivity()).publishEvent(locationEvent);
                return;
            }
            return;
        }
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LocationData locationData) {
        if (locationData == null) {
            if (this.nuc != null) {
                this.nuc.onFail(null);
                return;
            }
            return;
        }
        c(locationData);
        com.baidu.tieba.tbadkCore.location.b.dPQ().setTimeStamp(System.currentTimeMillis());
        com.baidu.tieba.tbadkCore.location.b.dPQ().setLocationData(locationData);
        if (this.nuc != null) {
            this.nuc.a(locationData);
        }
    }

    public static void c(LocationData locationData) {
        List<LocationData.NearByAddressData> poi_info;
        int i;
        if (locationData != null && (poi_info = locationData.getPoi_info()) != null && !poi_info.isEmpty()) {
            int size = poi_info.size();
            int i2 = 0;
            while (i2 < size) {
                String str = null;
                if (poi_info.get(i2) != null) {
                    str = poi_info.get(i2).getName();
                }
                if (StringUtils.isNull(str)) {
                    poi_info.remove(i2);
                    i = size - 1;
                    i2--;
                } else {
                    i = size;
                }
                i2++;
                size = i;
            }
            if (StringUtils.isNull(locationData.getFormatted_address())) {
                if (poi_info.size() >= 1) {
                    locationData.setFormatted_address(poi_info.get(0).getName());
                    locationData.setSn(poi_info.get(0).getSn());
                    return;
                }
                return;
            }
            for (LocationData.NearByAddressData nearByAddressData : poi_info) {
                if (locationData.getFormatted_address().equals(nearByAddressData.getName())) {
                    locationData.setSn(nearByAddressData.getSn());
                    return;
                }
            }
        }
    }

    public boolean dPU() {
        return System.currentTimeMillis() - com.baidu.tieba.tbadkCore.location.b.dPQ().getTimeStamp() > 300000;
    }

    public boolean dPV() {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dPQ().getLocationData();
        return (dPU() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void yn(boolean z) {
        com.baidu.tieba.tbadkCore.location.b.dPQ().ym(z);
        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, com.baidu.tieba.tbadkCore.location.b.dPQ().dPR());
    }

    public void gv(String str, String str2) {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dPQ().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
        d(locationData);
    }

    private void d(LocationData locationData) {
        if (!TbadkCoreApplication.getInst().isMainProcess(false) && (this.mContext.getPageActivity() instanceof BaseActivity)) {
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setType(1);
            locationEvent.eventType = 2;
            locationEvent.locationData = locationData;
            locationEvent.needRefresh = true;
            ((BaseActivity) this.mContext.getPageActivity()).publishEvent(locationEvent);
        }
    }

    public static void dPW() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean cot() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !com.baidu.tieba.tbadkCore.location.b.dPQ().dPR();
    }

    public void dPX() {
        if (this.nue == null) {
            dPS();
            registerListener(this.nue);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.nuc = aVar;
    }

    public void a(b bVar) {
        this.nud = bVar;
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
