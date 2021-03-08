package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.net.Uri;
import com.baidu.webkit.sdk.PermissionRequest;
@TargetApi(21)
/* loaded from: classes14.dex */
final class PermissionRequestImpl extends PermissionRequest {
    private final android.webkit.PermissionRequest mRequest;

    private PermissionRequestImpl(android.webkit.PermissionRequest permissionRequest) {
        this.mRequest = permissionRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PermissionRequest from(android.webkit.PermissionRequest permissionRequest) {
        if (permissionRequest == null) {
            return null;
        }
        return new PermissionRequestImpl(permissionRequest);
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final boolean defaultHandler() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final void deny() {
        this.mRequest.deny();
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final Uri getOrigin() {
        return this.mRequest.getOrigin();
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final String[] getResources() {
        return this.mRequest.getResources();
    }

    @Override // com.baidu.webkit.sdk.PermissionRequest
    public final void grant(String[] strArr) {
        this.mRequest.grant(strArr);
    }
}
