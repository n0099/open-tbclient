package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
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
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private c fAx;
    private e mContext;
    private a nor;
    private b nos;
    private HttpMessageListener nou;
    private a.InterfaceC0020a nov;
    private CustomMessageListener nox;

    /* loaded from: classes.dex */
    public interface a {
        void a(LocationData locationData);

        void bDm();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DZ(String str);

        void bDn();
    }

    private void dPW() {
        this.nou = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.nor != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.nor.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.dPX();
            }
        };
    }

    public void dPX() {
        if (dPZ()) {
            if (this.nor != null) {
                this.nor.a(com.baidu.tieba.tbadkCore.location.b.dPU().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ae.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.mk().a(true, this.nov);
            }
        } else if (this.nor != null) {
            this.nor.bDm();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.fAx = new c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.nor != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.nor.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.b(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.nov = new a.InterfaceC0020a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.nor != null) {
                        LocationModel.this.nor.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.gx(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.nox = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.yi(false);
                        LocationModel.this.gy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.nos != null) {
                            LocationModel.this.nos.DZ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.yi(true);
                    if (LocationModel.this.nos != null) {
                        LocationModel.this.nos.bDn();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.fAx.setSelfListener(false);
        }
        registerListener(this.fAx);
        registerListener(this.nox);
    }

    public void gx(String str, String str2) {
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
            if (this.nor != null) {
                this.nor.onFail(null);
                return;
            }
            return;
        }
        c(locationData);
        com.baidu.tieba.tbadkCore.location.b.dPU().setTimeStamp(System.currentTimeMillis());
        com.baidu.tieba.tbadkCore.location.b.dPU().setLocationData(locationData);
        if (this.nor != null) {
            this.nor.a(locationData);
        }
    }

    public static void c(LocationData locationData) {
        List<LocationData.NearByAddressData> poi_info;
        int i;
        int i2;
        if (locationData != null && (poi_info = locationData.getPoi_info()) != null && !poi_info.isEmpty()) {
            int size = poi_info.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (poi_info.get(i3) != null) {
                    str = poi_info.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    poi_info.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
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

    public boolean dPY() {
        return System.currentTimeMillis() - com.baidu.tieba.tbadkCore.location.b.dPU().getTimeStamp() > 300000;
    }

    public boolean dPZ() {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dPU().getLocationData();
        return (dPY() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void yi(boolean z) {
        com.baidu.tieba.tbadkCore.location.b.dPU().yh(z);
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, com.baidu.tieba.tbadkCore.location.b.dPU().dPV());
    }

    public void gy(String str, String str2) {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dPU().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void dQa() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean clC() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !com.baidu.tieba.tbadkCore.location.b.dPU().dPV();
    }

    public void dQb() {
        if (this.nou == null) {
            dPW();
            registerListener(this.nou);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.nor = aVar;
    }

    public void a(b bVar) {
        this.nos = bVar;
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
