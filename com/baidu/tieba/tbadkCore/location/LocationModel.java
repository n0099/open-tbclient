package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import android.net.http.Headers;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private a jjT;
    private b jjU;
    private BdBaseActivity jjV;
    private HttpMessageListener jjW;
    private com.baidu.adp.framework.listener.c jjX;
    private a.InterfaceC0015a jjY;
    private CustomMessageListener jjZ;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void auN();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void auO();

        void pO(String str);
    }

    private void coW() {
        this.jjW = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jjT != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jjT.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.coX();
            }
        };
    }

    public void coX() {
        if (coZ()) {
            if (this.jjT != null) {
                this.jjT.a(c.coU().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.jjV.getActivity())) {
                com.baidu.adp.lib.d.a.fw().a(true, this.jjY);
            }
        } else if (this.jjT != null) {
            this.jjT.auN();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jjX = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jjT != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jjT.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jjY = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jjT != null) {
                        LocationModel.this.jjT.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eb(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jjZ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qT(false);
                        LocationModel.this.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jjU != null) {
                            LocationModel.this.jjU.pO(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qT(true);
                    if (LocationModel.this.jjU != null) {
                        LocationModel.this.jjU.auO();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jjV = baseActivity;
        registerListener(this.jjX);
        registerListener(this.jjZ);
    }

    public void eb(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.jjT != null) {
                this.jjT.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.coU().setTimeStamp(System.currentTimeMillis());
        c.coU().b(aVar);
        if (this.jjT != null) {
            this.jjT.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0516a> coT;
        int i;
        int i2;
        if (aVar != null && (coT = aVar.coT()) != null && !coT.isEmpty()) {
            int size = coT.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (coT.get(i3) != null) {
                    str = coT.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    coT.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.coS())) {
                if (coT.size() >= 1) {
                    aVar.DS(coT.get(0).getName());
                    aVar.DT(coT.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0516a c0516a : coT) {
                if (aVar.coS().equals(c0516a.getName())) {
                    aVar.DT(c0516a.getSn());
                    return;
                }
            }
        }
    }

    public boolean coY() {
        return System.currentTimeMillis() - c.coU().getTimeStamp() > 300000;
    }

    public boolean coZ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.coU().getLocationData();
        return (coY() || locationData == null || StringUtils.isNull(locationData.coS())) ? false : true;
    }

    public void qT(boolean z) {
        c.coU().qS(z);
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.coU().coV());
    }

    public void ec(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.coU().getLocationData();
        if (locationData != null) {
            locationData.DS(str);
            locationData.DT(str2);
        }
    }

    public static void cpa() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aWP() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jjV.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.coU().coV();
    }

    public void cpb() {
        if (this.jjW == null) {
            coW();
            registerListener(this.jjW);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jjT = aVar;
    }

    public void a(b bVar) {
        this.jjU = bVar;
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
