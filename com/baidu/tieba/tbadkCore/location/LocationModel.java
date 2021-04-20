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
import d.b.c.e.i.a;
import d.b.c.e.p.j;
import java.util.List;
/* loaded from: classes5.dex */
public class LocationModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public e f21045e;

    /* renamed from: f  reason: collision with root package name */
    public f f21046f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.a.f f21047g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f21048h;
    public d.b.c.c.g.c i;
    public a.c j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends d.b.c.c.g.c {
        public a(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                if (LocationModel.this.f21045e != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.f21045e.onFail(str);
                    return;
                }
                return;
            }
            LocationModel.this.A(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.c {
        public b() {
        }

        @Override // d.b.c.e.i.a.c
        public void onLocationGeted(int i, String str, Address address) {
            if (i != 0 || address == null) {
                if (LocationModel.this.f21045e != null) {
                    LocationModel.this.f21045e.onFail(str);
                    return;
                }
                return;
            }
            LocationModel.this.E(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                if (LocationModel.this.f21045e != null) {
                    String str = null;
                    if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                        str = httpResponsedMessage.getErrorString();
                    }
                    LocationModel.this.f21045e.onFail(str);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().setLocationShared(true);
            LocationModel.this.D();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    LocationModel.this.H(false);
                    LocationModel.this.G(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    if (LocationModel.this.f21046f != null) {
                        LocationModel.this.f21046f.a(responsedSelectLocation.getName());
                        return;
                    }
                    return;
                }
                LocationModel.this.H(true);
                if (LocationModel.this.f21046f != null) {
                    LocationModel.this.f21046f.b();
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
        void a(String str);

        void b();
    }

    public LocationModel(d.b.c.a.f fVar) {
        super(fVar);
        this.i = new a(303017, true);
        this.j = new b();
        this.k = new d(2001226);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.f21047g = fVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.i.setSelfListener(false);
        }
        registerListener(this.i);
        registerListener(this.k);
    }

    public static void C() {
        d.b.i0.d3.d0.a.h(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public static void w(LocationData locationData) {
        List<LocationData.NearByAddressData> poi_info;
        if (locationData == null || (poi_info = locationData.getPoi_info()) == null || poi_info.isEmpty()) {
            return;
        }
        int size = poi_info.size();
        int i = 0;
        while (i < size) {
            if (StringUtils.isNull(poi_info.get(i) != null ? poi_info.get(i).getName() : null)) {
                poi_info.remove(i);
                size--;
                i--;
            }
            i++;
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

    public final void A(LocationData locationData) {
        if (locationData == null) {
            e eVar = this.f21045e;
            if (eVar != null) {
                eVar.onFail(null);
                return;
            }
            return;
        }
        w(locationData);
        d.b.i0.d3.m0.b.a().g(System.currentTimeMillis());
        d.b.i0.d3.m0.b.a().e(locationData);
        e eVar2 = this.f21045e;
        if (eVar2 != null) {
            eVar2.b(locationData);
        }
    }

    public final void B(LocationData locationData) {
        if (TbadkCoreApplication.getInst().isMainProcess(false) || !(this.f21047g.getPageActivity() instanceof BaseActivity)) {
            return;
        }
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        locationEvent.locationData = locationData;
        locationEvent.needRefresh = true;
        ((BaseActivity) this.f21047g.getPageActivity()).publishEvent(locationEvent);
    }

    public void D() {
        if (z()) {
            e eVar = this.f21045e;
            if (eVar != null) {
                eVar.b(d.b.i0.d3.m0.b.a().b());
            }
        } else if (j.z()) {
            if (PermissionUtil.checkLocationForGoogle(this.f21047g.getPageActivity())) {
                d.b.c.e.i.a.l().i(true, this.j);
            }
        } else {
            e eVar2 = this.f21045e;
            if (eVar2 != null) {
                eVar2.a();
            }
        }
    }

    public void E(String str, String str2) {
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (this.f21047g.getPageActivity() instanceof BaseActivity) {
                LocationEvent locationEvent = new LocationEvent();
                locationEvent.setType(3);
                locationEvent.eventType = 0;
                locationEvent.lat = str2;
                locationEvent.lng = str;
                ((BaseActivity) this.f21047g.getPageActivity()).publishEvent(locationEvent);
                return;
            }
            return;
        }
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    public void F() {
        if (this.f21048h == null) {
            x();
            registerListener(this.f21048h);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void G(String str, String str2) {
        LocationData b2 = d.b.i0.d3.m0.b.a().b();
        if (b2 != null) {
            b2.setFormatted_address(str);
            b2.setSn(str2);
        }
        B(b2);
    }

    public void H(boolean z) {
        d.b.i0.d3.m0.b.a().f(z);
        d.b.h0.r.d0.b.j().t("no_longer_show_address", d.b.i0.d3.m0.b.a().d());
    }

    public void I(e eVar) {
        this.f21045e = eVar;
    }

    public void J(f fVar) {
        this.f21046f = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public boolean v() {
        return UtilHelper.isSystemLocationProviderEnabled(this.f21047g.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !d.b.i0.d3.m0.b.a().d();
    }

    public final void x() {
        this.f21048h = new c(CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public boolean y() {
        return System.currentTimeMillis() - d.b.i0.d3.m0.b.a().c() > 300000;
    }

    public boolean z() {
        LocationData b2 = d.b.i0.d3.m0.b.a().b();
        return (y() || b2 == null || StringUtils.isNull(b2.getFormatted_address())) ? false : true;
    }
}
