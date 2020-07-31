package com.baidu.webkit.sdk.system;

import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import com.baidu.webkit.sdk.GeolocationPermissions;
import java.util.Set;
/* loaded from: classes8.dex */
final class GeolocationPermissionsImpl extends GeolocationPermissions {

    /* loaded from: classes8.dex */
    static class CallbackWrapper implements GeolocationPermissions.Callback {
        private final GeolocationPermissions.Callback mCallback;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CallbackWrapper(GeolocationPermissions.Callback callback) {
            this.mCallback = callback;
        }

        @Override // com.baidu.webkit.sdk.GeolocationPermissions.Callback
        public void invoke(String str, boolean z, boolean z2) {
            this.mCallback.invoke(str, z, z2);
        }
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void allow(String str) {
        android.webkit.GeolocationPermissions.getInstance().allow(str);
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void clear(String str) {
        android.webkit.GeolocationPermissions.getInstance().clear(str);
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void clearAll() {
        android.webkit.GeolocationPermissions.getInstance().clearAll();
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
    }

    @Override // com.baidu.webkit.sdk.GeolocationPermissions
    public final void getOrigins(ValueCallback<Set<String>> valueCallback) {
        android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
    }
}
