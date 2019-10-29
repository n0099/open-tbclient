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
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private a jkK;
    private b jkL;
    private BdBaseActivity jkM;
    private HttpMessageListener jkN;
    private com.baidu.adp.framework.listener.c jkO;
    private a.InterfaceC0015a jkP;
    private CustomMessageListener jkQ;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void auP();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void auQ();

        void pO(String str);
    }

    private void coY() {
        this.jkN = new HttpMessageListener(1001506) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jkK != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jkK.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.coZ();
            }
        };
    }

    public void coZ() {
        if (cpb()) {
            if (this.jkK != null) {
                this.jkK.a(c.coW().getLocationData());
            }
        } else if (j.isNetWorkAvailable()) {
            if (ab.checkLocationForGoogle(this.jkM.getActivity())) {
                com.baidu.adp.lib.d.a.fw().a(true, this.jkP);
            }
        } else if (this.jkK != null) {
            this.jkK.auP();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jkO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_LOCATION, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jkK != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jkK.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jkP = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jkK != null) {
                        LocationModel.this.jkK.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eb(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jkQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qT(false);
                        LocationModel.this.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jkL != null) {
                            LocationModel.this.jkL.pO(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qT(true);
                    if (LocationModel.this.jkL != null) {
                        LocationModel.this.jkL.auQ();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jkM = baseActivity;
        registerListener(this.jkO);
        registerListener(this.jkQ);
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
            if (this.jkK != null) {
                this.jkK.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.coW().setTimeStamp(System.currentTimeMillis());
        c.coW().b(aVar);
        if (this.jkK != null) {
            this.jkK.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0521a> coV;
        int i;
        int i2;
        if (aVar != null && (coV = aVar.coV()) != null && !coV.isEmpty()) {
            int size = coV.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (coV.get(i3) != null) {
                    str = coV.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    coV.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.coU())) {
                if (coV.size() >= 1) {
                    aVar.DS(coV.get(0).getName());
                    aVar.DT(coV.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0521a c0521a : coV) {
                if (aVar.coU().equals(c0521a.getName())) {
                    aVar.DT(c0521a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cpa() {
        return System.currentTimeMillis() - c.coW().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cpb() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.coW().getLocationData();
        return (cpa() || locationData == null || StringUtils.isNull(locationData.coU())) ? false : true;
    }

    public void qT(boolean z) {
        c.coW().qS(z);
        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.NO_LONGER_SHOW_ADDRESS, c.coW().coX());
    }

    public void ec(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.coW().getLocationData();
        if (locationData != null) {
            locationData.DS(str);
            locationData.DT(str2);
        }
    }

    public static void cpc() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LOCATION, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aWR() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jkM.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.coW().coX();
    }

    public void cpd() {
        if (this.jkN == null) {
            coY();
            registerListener(this.jkN);
        }
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jkK = aVar;
    }

    public void a(b bVar) {
        this.jkL = bVar;
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
