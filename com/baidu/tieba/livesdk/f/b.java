package com.baidu.tieba.livesdk.f;

import android.location.Address;
import com.baidu.adp.lib.c.a;
import com.baidu.live.tbadk.location.LocationInfo;
import com.baidu.live.tbadk.location.interfaces.ILocation;
import com.baidu.live.tbadk.location.interfaces.LocationCallback;
/* loaded from: classes3.dex */
public class b implements ILocation {
    @Override // com.baidu.live.tbadk.location.interfaces.ILocation
    public LocationInfo getLocationInfo() {
        return a(com.baidu.adp.lib.c.a.kG().getAddress(false));
    }

    @Override // com.baidu.live.tbadk.location.interfaces.ILocation
    public void getLocation(final LocationCallback locationCallback) {
        if (locationCallback != null) {
            com.baidu.adp.lib.c.a.kG().a(false, new a.InterfaceC0020a() { // from class: com.baidu.tieba.livesdk.f.b.1
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    locationCallback.onGetLocationInfo(b.this.a(address));
                }
            });
        }
    }

    @Override // com.baidu.live.tbadk.location.interfaces.ILocation
    public void requestLocate() {
        com.baidu.adp.lib.c.a.kG().getAddress(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocationInfo a(Address address) {
        if (address == null) {
            return null;
        }
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.city = address.getLocality();
        locationInfo.county = address.getCountryName();
        locationInfo.latitude = address.getLatitude();
        locationInfo.longitude = address.getLongitude();
        locationInfo.prov = address.getAdminArea();
        locationInfo.cityCode = address.getPostalCode();
        locationInfo.street = address.getSubAdminArea();
        return locationInfo;
    }
}
