package com.baidu.ufosdk.hybrid.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public abstract class BaseActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = false;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            if (this.a) {
                overridePendingTransition(R.anim.obfuscated_res_0x7f010179, R.anim.obfuscated_res_0x7f01017d);
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = false;
            try {
                TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
                Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
                method.setAccessible(true);
                boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
                try {
                    method.setAccessible(false);
                    return booleanValue;
                } catch (Exception unused) {
                    z = booleanValue;
                    return z;
                }
            } catch (Exception unused2) {
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (Build.VERSION.SDK_INT == 26 && c()) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                    declaredField.setAccessible(true);
                    ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
                    declaredField.setAccessible(false);
                } catch (Exception unused) {
                }
            }
            super.onCreate(bundle);
            this.a = b.a(getIntent(), "extra.has_anim", false);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStart();
            if (!this.c) {
                if (Build.VERSION.SDK_INT >= 21) {
                    int identifier = getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
                    boolean z = false;
                    if (identifier > 0) {
                        i = getResources().getDimensionPixelOffset(identifier);
                    } else {
                        i = 0;
                    }
                    Log.d("BaseActivity", "onSetDefaultStatusBarColor: " + i);
                    ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f092921);
                    if (viewGroup != null && i > 0) {
                        if (!getSharedPreferences("feedback_switch_prefs", 0).getBoolean("f_stu_b", false)) {
                            ((ViewGroup) viewGroup.getParent()).setPadding(0, i, 0, 0);
                        }
                        z = true;
                    }
                    if (z) {
                        Window window = getWindow();
                        window.getDecorView().setSystemUiVisibility(1280);
                        window.addFlags(Integer.MIN_VALUE);
                        window.clearFlags(67108864);
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (this.b) {
                                window.getDecorView().setSystemUiVisibility(1024);
                            } else {
                                window.getDecorView().setSystemUiVisibility(9216);
                            }
                        }
                        window.setStatusBarColor(getResources().getColor(R.color.obfuscated_res_0x7f06064a));
                    } else {
                        int color = getResources().getColor(R.color.obfuscated_res_0x7f06064a);
                        if (Build.VERSION.SDK_INT >= 21) {
                            Window window2 = getWindow();
                            window2.addFlags(Integer.MIN_VALUE);
                            if (Build.VERSION.SDK_INT >= 23) {
                                window2.getDecorView().setSystemUiVisibility(8192);
                            }
                            window2.setStatusBarColor(color);
                        }
                    }
                }
                this.c = true;
            }
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (Build.VERSION.SDK_INT == 26 && c()) {
                return;
            }
            super.setRequestedOrientation(i);
        }
    }
}
