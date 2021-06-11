package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import d.a.c.e.i.a;
import d.a.c.e.p.j;
import java.util.List;
/* loaded from: classes5.dex */
public class LocationModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public e f20879e;

    /* renamed from: f  reason: collision with root package name */
    public f f20880f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.a.f f20881g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f20882h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.c f20883i;
    public a.c j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                if (LocationModel.this.f20879e != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.f20879e.onFail(str);
                    return;
                }
                return;
            }
            LocationModel.this.E(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.c {
        public b() {
        }

        @Override // d.a.c.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            if (i2 != 0 || address == null) {
                if (LocationModel.this.f20879e != null) {
                    LocationModel.this.f20879e.onFail(str);
                    return;
                }
                return;
            }
            LocationModel.this.I(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                if (LocationModel.this.f20879e != null) {
                    String str = null;
                    if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                        str = httpResponsedMessage.getErrorString();
                    }
                    LocationModel.this.f20879e.onFail(str);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().setLocationShared(true);
            LocationModel.this.H();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    LocationModel.this.L(false);
                    LocationModel.this.K(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    if (LocationModel.this.f20880f != null) {
                        LocationModel.this.f20880f.b(responsedSelectLocation.getName());
                        return;
                    }
                    return;
                }
                LocationModel.this.L(true);
                if (LocationModel.this.f20880f != null) {
                    LocationModel.this.f20880f.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b(LocationData locationData);

        void onFail(String str);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();

        void b(String str);
    }

    public LocationModel(d.a.c.a.f fVar) {
        super(fVar);
        this.f20883i = new a(303017, true);
        this.j = new b();
        this.k = new d(2001226);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.f20881g = fVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.f20883i.setSelfListener(false);
        }
        registerListener(this.f20883i);
        registerListener(this.k);
    }

    public static void A(LocationData locationData) {
        List<LocationData.NearByAddressData> poi_info;
        if (locationData == null || (poi_info = locationData.getPoi_info()) == null || poi_info.isEmpty()) {
            return;
        }
        int size = poi_info.size();
        int i2 = 0;
        while (i2 < size) {
            if (StringUtils.isNull(poi_info.get(i2) != null ? poi_info.get(i2).getName() : null)) {
                poi_info.remove(i2);
                size--;
                i2--;
            }
            i2++;
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

    public static void G() {
        d.a.n0.e3.d0.a.h(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public final void B() {
        this.f20882h = new c(CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public boolean C() {
        return System.currentTimeMillis() - d.a.n0.e3.m0.b.a().c() > 300000;
    }

    public boolean D() {
        LocationData b2 = d.a.n0.e3.m0.b.a().b();
        return (C() || b2 == null || StringUtils.isNull(b2.getFormatted_address())) ? false : true;
    }

    public final void E(LocationData locationData) {
        if (locationData == null) {
            e eVar = this.f20879e;
            if (eVar != null) {
                eVar.onFail(null);
                return;
            }
            return;
        }
        A(locationData);
        d.a.n0.e3.m0.b.a().g(System.currentTimeMillis());
        d.a.n0.e3.m0.b.a().e(locationData);
        e eVar2 = this.f20879e;
        if (eVar2 != null) {
            eVar2.b(locationData);
        }
    }

    public final void F(LocationData locationData) {
        if (TbadkCoreApplication.getInst().isMainProcess(false) || !(this.f20881g.getPageActivity() instanceof BaseActivity)) {
            return;
        }
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        locationEvent.locationData = locationData;
        locationEvent.needRefresh = true;
        ((BaseActivity) this.f20881g.getPageActivity()).publishEvent(locationEvent);
    }

    public void H() {
        if (D()) {
            e eVar = this.f20879e;
            if (eVar != null) {
                eVar.b(d.a.n0.e3.m0.b.a().b());
            }
        } else if (j.z()) {
            if (PermissionUtil.checkLocationForGoogle(this.f20881g.getPageActivity())) {
                d.a.c.e.i.a.l().i(true, this.j);
            }
        } else {
            e eVar2 = this.f20879e;
            if (eVar2 != null) {
                eVar2.a();
            }
        }
    }

    public void I(String str, String str2) {
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (this.f20881g.getPageActivity() instanceof BaseActivity) {
                LocationEvent locationEvent = new LocationEvent();
                locationEvent.setType(3);
                locationEvent.eventType = 0;
                locationEvent.lat = str2;
                locationEvent.lng = str;
                ((BaseActivity) this.f20881g.getPageActivity()).publishEvent(locationEvent);
                return;
            }
            return;
        }
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    public void J() {
        if (this.f20882h == null) {
            B();
            registerListener(this.f20882h);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void K(String str, String str2) {
        LocationData b2 = d.a.n0.e3.m0.b.a().b();
        if (b2 != null) {
            b2.setFormatted_address(str);
            b2.setSn(str2);
        }
        F(b2);
    }

    public void L(boolean z) {
        d.a.n0.e3.m0.b.a().f(z);
        d.a.m0.r.d0.b.j().t("no_longer_show_address", d.a.n0.e3.m0.b.a().d());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(e eVar) {
        this.f20879e = eVar;
    }

    public void N(f fVar) {
        this.f20880f = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public boolean z() {
        return UtilHelper.isSystemLocationProviderEnabled(this.f20881g.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !d.a.n0.e3.m0.b.a().d();
    }
}
