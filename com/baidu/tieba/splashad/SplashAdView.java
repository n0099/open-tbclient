package com.baidu.tieba.splashad;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.z6a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SplashAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z6a a;
    public BaseFragmentActivity b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView(BaseFragmentActivity baseFragmentActivity, int i) {
        super(baseFragmentActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.c = i;
        this.b = baseFragmentActivity;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    public void a() {
        z6a z6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (z6aVar = this.a) != null) {
            z6aVar.e();
        }
    }

    public void b() {
        z6a z6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (z6aVar = this.a) != null) {
            z6aVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            z6a z6aVar = new z6a();
            this.a = z6aVar;
            z6aVar.a(this.b, this, this.c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            z6a z6aVar = this.a;
            if (z6aVar != null) {
                z6aVar.g();
            }
            this.a = null;
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        z6a z6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) && (z6aVar = this.a) != null) {
            z6aVar.d(configuration);
        }
    }
}
