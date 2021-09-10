package com.baidu.wallet.personal.ui;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes8.dex */
public class CouponBaseActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources mResources;

    /* loaded from: classes8.dex */
    public static class a extends Resources {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f63441a;

        /* renamed from: b  reason: collision with root package name */
        public float f63442b;

        /* renamed from: c  reason: collision with root package name */
        public int f63443c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Resources resources) {
            super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void a(DisplayMetrics displayMetrics) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, displayMetrics) == null) && this.f63441a == 0.0f) {
                float f2 = displayMetrics.density;
                float f3 = displayMetrics.scaledDensity;
                float f4 = displayMetrics.widthPixels / 360.0f;
                this.f63441a = f4;
                this.f63442b = (f3 / f2) * f4;
                this.f63443c = (int) (f4 * 160.0f);
            }
        }

        private void b(DisplayMetrics displayMetrics) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, displayMetrics) == null) {
                displayMetrics.density = this.f63441a;
                displayMetrics.densityDpi = this.f63443c;
            }
        }

        @Override // android.content.res.Resources
        public DisplayMetrics getDisplayMetrics() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayMetrics.setTo(super.getDisplayMetrics());
                a(displayMetrics);
                b(displayMetrics);
                return displayMetrics;
            }
            return (DisplayMetrics) invokeV.objValue;
        }
    }

    public CouponBaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResources = null;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Resources resources = super.getResources();
            if (this.mResources == null) {
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.setToDefaults();
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                this.mResources = new a(super.getResources());
                LogUtil.d("CouponBaseActivity", "getResources config = " + configuration);
            }
            Resources resources2 = this.mResources;
            return resources2 != null ? resources2 : resources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }
}
