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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener dZv;
    private a jaV;
    private b jaW;
    private BdBaseActivity jaX;
    private com.baidu.adp.framework.listener.c jaY;
    private a.InterfaceC0015a jaZ;
    private CustomMessageListener jba;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void arJ();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void arK();

        void qe(String str);
    }

    private void aTJ() {
        this.dZv = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jaV != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jaV.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cnb();
            }
        };
    }

    public void cnb() {
        if (cnd()) {
            if (this.jaV != null) {
                this.jaV.a(c.cmZ().getLocationData());
            }
        } else if (j.jS()) {
            if (ab.cw(this.jaX.getActivity())) {
                com.baidu.adp.lib.d.a.hO().a(true, this.jaZ);
            }
        } else if (this.jaV != null) {
            this.jaV.arJ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jaY = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jaV != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jaV.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jaZ = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jaV != null) {
                        LocationModel.this.jaV.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.en(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jba = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qQ(false);
                        LocationModel.this.eo(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jaW != null) {
                            LocationModel.this.jaW.qe(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qQ(true);
                    if (LocationModel.this.jaW != null) {
                        LocationModel.this.jaW.arK();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jaX = baseActivity;
        registerListener(this.jaY);
        registerListener(this.jba);
    }

    public void en(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.jaV != null) {
                this.jaV.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cmZ().em(System.currentTimeMillis());
        c.cmZ().b(aVar);
        if (this.jaV != null) {
            this.jaV.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0410a> cmY;
        int i;
        int i2;
        if (aVar != null && (cmY = aVar.cmY()) != null && !cmY.isEmpty()) {
            int size = cmY.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cmY.get(i3) != null) {
                    str = cmY.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cmY.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cmX())) {
                if (cmY.size() >= 1) {
                    aVar.DY(cmY.get(0).getName());
                    aVar.DZ(cmY.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0410a c0410a : cmY) {
                if (aVar.cmX().equals(c0410a.getName())) {
                    aVar.DZ(c0410a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cnc() {
        return System.currentTimeMillis() - c.cmZ().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cnd() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cmZ().getLocationData();
        return (cnc() || locationData == null || StringUtils.isNull(locationData.cmX())) ? false : true;
    }

    public void qQ(boolean z) {
        c.cmZ().qP(z);
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("no_longer_show_address", c.cmZ().cna());
    }

    public void eo(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cmZ().getLocationData();
        if (locationData != null) {
            locationData.DY(str);
            locationData.DZ(str2);
        }
    }

    public static void cne() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aTE() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jaX.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cmZ().cna();
    }

    public void aTI() {
        if (this.dZv == null) {
            aTJ();
            registerListener(this.dZv);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jaV = aVar;
    }

    public void a(b bVar) {
        this.jaW = bVar;
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
