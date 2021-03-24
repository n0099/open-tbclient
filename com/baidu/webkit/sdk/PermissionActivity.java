package com.baidu.webkit.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import com.baidu.webkit.internal.a.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PermissionActivity extends Activity {
    public static final int REQUEST_CAMERA_RECORD_CODE = 1003;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int a2 = a.a(this);
        super.onCreate(bundle);
        if (a2 == -1 || Build.VERSION.SDK_INT != 26 || getApplicationInfo().targetSdkVersion <= 26 || !a.c(this) || a.b(this)) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) == -1) {
                declaredField2.setInt(obj, a2);
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionRequest permissionRequest = WebViewFactory.getProvider().getPermissionRequest(getIntent().getStringExtra("PermissionRequest"));
        if (permissionRequest == null || i != 1003) {
            finish();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (iArr[i2] == 0) {
                arrayList.add(strArr[i2]);
            }
        }
        if (arrayList.size() <= 0 || arrayList.size() != strArr.length) {
            permissionRequest.deny();
        } else {
            permissionRequest.grant((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        finish();
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onStart() {
        super.onStart();
        String[] stringArrayExtra = getIntent().getStringArrayExtra("Resources");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            return;
        }
        requestPermissions(stringArrayExtra, 1003);
    }
}
