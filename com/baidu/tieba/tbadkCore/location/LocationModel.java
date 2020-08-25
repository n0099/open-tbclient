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
/* loaded from: classes2.dex */
public class LocationModel extends BdBaseModel {
    private c eQe;
    private e mContext;
    private a mhj;
    private b mhk;
    private HttpMessageListener mhl;
    private a.InterfaceC0018a mhm;
    private CustomMessageListener mhn;

    /* loaded from: classes2.dex */
    public interface a {
        void a(LocationData locationData);

        void bsp();

        void onFail(String str);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Cc(String str);

        void bsq();
    }

    private void dxk() {
        this.mhl = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.mhj != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.mhj.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.dxl();
            }
        };
    }

    public void dxl() {
        if (dxn()) {
            if (this.mhj != null) {
                this.mhj.a(com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ae.checkLocationForGoogle(this.mContext.getPageActivity())) {
                com.baidu.adp.lib.c.a.mf().a(true, this.mhm);
            }
        } else if (this.mhj != null) {
            this.mhj.bsp();
        }
    }

    public LocationModel(e eVar) {
        super(eVar);
        this.eQe = new c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.mhj != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.mhj.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.b(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.mhm = new a.InterfaceC0018a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.mhj != null) {
                        LocationModel.this.mhj.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.fT(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.mhn = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.we(false);
                        LocationModel.this.fU(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.mhk != null) {
                            LocationModel.this.mhk.Cc(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.we(true);
                    if (LocationModel.this.mhk != null) {
                        LocationModel.this.mhk.bsq();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.mContext = eVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.eQe.setSelfListener(false);
        }
        registerListener(this.eQe);
        registerListener(this.mhn);
    }

    public void fT(String str, String str2) {
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
            if (this.mhj != null) {
                this.mhj.onFail(null);
                return;
            }
            return;
        }
        c(locationData);
        com.baidu.tieba.tbadkCore.location.b.dxi().setTimeStamp(System.currentTimeMillis());
        com.baidu.tieba.tbadkCore.location.b.dxi().setLocationData(locationData);
        if (this.mhj != null) {
            this.mhj.a(locationData);
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

    public boolean dxm() {
        return System.currentTimeMillis() - com.baidu.tieba.tbadkCore.location.b.dxi().getTimeStamp() > 300000;
    }

    public boolean dxn() {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData();
        return (dxm() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void we(boolean z) {
        com.baidu.tieba.tbadkCore.location.b.dxi().wd(z);
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, com.baidu.tieba.tbadkCore.location.b.dxi().dxj());
    }

    public void fU(String str, String str2) {
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void dxo() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bXz() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mContext.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !com.baidu.tieba.tbadkCore.location.b.dxi().dxj();
    }

    public void dxp() {
        if (this.mhl == null) {
            dxk();
            registerListener(this.mhl);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam(UgcConstant.UGC_TAG_OPTION, "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.mhj = aVar;
    }

    public void a(b bVar) {
        this.mhk = bVar;
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
