package com.baidu.zeus;

import android.app.ActivityThread;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes.dex */
final class GeolocationService implements LocationListener {
    private static final String TAG = "geolocationService";
    private boolean mIsGpsEnabled;
    private boolean mIsGpsProviderAvailable;
    private boolean mIsNetworkProviderAvailable;
    private boolean mIsRunning;
    private LocationManager mLocationManager = (LocationManager) ActivityThread.systemMain().getApplication().getSystemService(Headers.LOCATION);
    private long mNativeObject;

    private static native void nativeNewErrorAvailable(long j, String str);

    private static native void nativeNewLocationAvailable(long j, Location location);

    public GeolocationService(long j) {
        this.mNativeObject = j;
        if (this.mLocationManager == null) {
            Log.e(TAG, "Could not get location manager.");
        }
    }

    public void start() {
        registerForLocationUpdates();
        this.mIsRunning = true;
    }

    public void stop() {
        unregisterFromLocationUpdates();
        this.mIsRunning = false;
    }

    public void setEnableGps(boolean z) {
        if (this.mIsGpsEnabled != z) {
            this.mIsGpsEnabled = z;
            if (this.mIsRunning) {
                unregisterFromLocationUpdates();
                registerForLocationUpdates();
            }
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (this.mIsRunning) {
            nativeNewLocationAvailable(this.mNativeObject, location);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        boolean z = i == 2;
        if ("network".equals(str)) {
            this.mIsNetworkProviderAvailable = z;
        } else if ("gps".equals(str)) {
            this.mIsGpsProviderAvailable = z;
        }
        maybeReportError("The last location provider is no longer available");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("network".equals(str)) {
            this.mIsNetworkProviderAvailable = true;
        } else if ("gps".equals(str)) {
            this.mIsGpsProviderAvailable = true;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("network".equals(str)) {
            this.mIsNetworkProviderAvailable = false;
        } else if ("gps".equals(str)) {
            this.mIsGpsProviderAvailable = false;
        }
        maybeReportError("The last location provider was disabled");
    }

    private void registerForLocationUpdates() {
        try {
            try {
                this.mLocationManager.requestLocationUpdates("network", 0L, 0.0f, this);
                this.mIsNetworkProviderAvailable = true;
            } catch (SecurityException e) {
                Log.e(TAG, "Caught security exception registering for location updates from system. This should only happen in DumpRenderTree.");
                return;
            }
        } catch (IllegalArgumentException e2) {
        }
        if (this.mIsGpsEnabled) {
            try {
                this.mLocationManager.requestLocationUpdates("gps", 0L, 0.0f, this);
                this.mIsGpsProviderAvailable = true;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void unregisterFromLocationUpdates() {
        this.mLocationManager.removeUpdates(this);
    }

    private void maybeReportError(String str) {
        if (this.mIsRunning && !this.mIsNetworkProviderAvailable && !this.mIsGpsProviderAvailable) {
            nativeNewErrorAvailable(this.mNativeObject, str);
        }
    }
}
