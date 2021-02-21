package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import android.net.http.Headers;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private c fHI;
    private f mContext;
    private a nzG;
    private b nzH;
    private HttpMessageListener nzI;
    private a.InterfaceC0015a nzJ;
    private CustomMessageListener nzK;

    /* loaded from: classes.dex */
    public interface a {
        void a(LocationData locationData);

        void bCh();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void CZ(String str);

        void bCi();
    }

    private void dOu() {
        this.nzI = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.nzG != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.nzG.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.dOv();
            }
        };
    }

    public void dOv() {
        if (dOx()) {
            if (this.nzG != null) {
                this.nzG.a(com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ae.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.lH().a(true, this.nzJ);
            }
        } else if (this.nzG != null) {
            this.nzG.bCh();
        }
    }

    public LocationModel(f fVar) {
        super(fVar);
        this.fHI = new c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.nzG != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.nzG.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.b(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.nzJ = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.nzG != null) {
                        LocationModel.this.nzG.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.gB(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.nzK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.yC(false);
                        LocationModel.this.gC(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.nzH != null) {
                            LocationModel.this.nzH.CZ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.yC(true);
                    if (LocationModel.this.nzH != null) {
                        LocationModel.this.nzH.bCi();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = fVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.fHI.setSelfListener(false);
        }
        registerListener(this.fHI);
        registerListener(this.nzK);
    }

    public void gB(String str, String str2) {
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
            if (this.nzG != null) {
                this.nzG.onFail(null);
                return;
            }
            return;
        }
        c(locationData);
        com.baidu.tieba.tbadkCore.location.b.dOs().setTimeStamp(System.currentTimeMillis());
        com.baidu.tieba.tbadkCore.location.b.dOs().setLocationData(locationData);
        if (this.nzG != null) {
            this.nzG.a(locationData);
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

    public boolean dOw() {
        return System.currentTimeMillis() - com.baidu.tieba.tbadkCore.location.b.dOs().getTimeStamp() > 300000;
    }

    public boolean dOx() {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData();
        return (dOw() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void yC(boolean z) {
        com.baidu.tieba.tbadkCore.location.b.dOs().yB(z);
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, com.baidu.tieba.tbadkCore.location.b.dOs().dOt());
    }

    public void gC(String str, String str2) {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData();
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

    public static void dOy() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean clH() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !com.baidu.tieba.tbadkCore.location.b.dOs().dOt();
    }

    public void dOz() {
        if (this.nzI == null) {
            dOu();
            registerListener(this.nzI);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.nzG = aVar;
    }

    public void a(b bVar) {
        this.nzH = bVar;
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
