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
    private c ftB;
    private e mContext;
    private a mZo;
    private b mZp;
    private HttpMessageListener mZq;
    private a.InterfaceC0020a mZr;
    private CustomMessageListener mZs;

    /* loaded from: classes.dex */
    public interface a {
        void a(LocationData locationData);

        void bAw();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DS(String str);

        void bAx();
    }

    private void dKE() {
        this.mZq = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.mZo != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.mZo.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.dKF();
            }
        };
    }

    public void dKF() {
        if (dKH()) {
            if (this.mZo != null) {
                this.mZo.a(com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ae.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.mk().a(true, this.mZr);
            }
        } else if (this.mZo != null) {
            this.mZo.bAw();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.ftB = new c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.mZo != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.mZo.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.b(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.mZr = new a.InterfaceC0020a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.mZo != null) {
                        LocationModel.this.mZo.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.gs(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.mZs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.xw(false);
                        LocationModel.this.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.mZp != null) {
                            LocationModel.this.mZp.DS(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.xw(true);
                    if (LocationModel.this.mZp != null) {
                        LocationModel.this.mZp.bAx();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.ftB.setSelfListener(false);
        }
        registerListener(this.ftB);
        registerListener(this.mZs);
    }

    public void gs(String str, String str2) {
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
            if (this.mZo != null) {
                this.mZo.onFail(null);
                return;
            }
            return;
        }
        c(locationData);
        com.baidu.tieba.tbadkCore.location.b.dKC().setTimeStamp(System.currentTimeMillis());
        com.baidu.tieba.tbadkCore.location.b.dKC().setLocationData(locationData);
        if (this.mZo != null) {
            this.mZo.a(locationData);
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

    public boolean dKG() {
        return System.currentTimeMillis() - com.baidu.tieba.tbadkCore.location.b.dKC().getTimeStamp() > 300000;
    }

    public boolean dKH() {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData();
        return (dKG() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void xw(boolean z) {
        com.baidu.tieba.tbadkCore.location.b.dKC().xv(z);
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, com.baidu.tieba.tbadkCore.location.b.dKC().dKD());
    }

    public void gt(String str, String str2) {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void dKI() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean cin() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !com.baidu.tieba.tbadkCore.location.b.dKC().dKD();
    }

    public void dKJ() {
        if (this.mZq == null) {
            dKE();
            registerListener(this.mZq);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.mZo = aVar;
    }

    public void a(b bVar) {
        this.mZp = bVar;
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
