package com.baidu.webkit.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.a.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PermissionActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_CAMERA_RECORD_CODE = 1003;
    public transient /* synthetic */ FieldHolder $fh;

    public PermissionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int a = a.a(this);
            super.onCreate(bundle);
            if (a != -1 && Build.VERSION.SDK_INT == 26 && getApplicationInfo().targetSdkVersion > 26 && a.c(this) && !a.b(this)) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this);
                    Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
                    declaredField2.setAccessible(true);
                    if (declaredField2.getInt(obj) == -1) {
                        declaredField2.setInt(obj, a);
                    }
                    LogUtil.logActivity(this, "onCreate");
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                    LogUtil.logActivity(this, "onCreate");
                    return;
                }
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, strArr, iArr) == null) {
            PermissionRequest permissionRequest = WebViewFactory.getProvider().getPermissionRequest(getIntent().getStringExtra("PermissionRequest"));
            if (permissionRequest == null || i2 != 1003) {
                finish();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (iArr[i3] == 0) {
                    arrayList.add(strArr[i3]);
                }
            }
            if (arrayList.size() <= 0 || arrayList.size() != strArr.length) {
                permissionRequest.deny();
            } else {
                permissionRequest.grant((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            finish();
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onStart();
            String[] stringArrayExtra = getIntent().getStringArrayExtra("Resources");
            if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
                return;
            }
            requestPermissions(stringArrayExtra, 1003);
        }
    }
}
