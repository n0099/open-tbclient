package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
/* loaded from: classes5.dex */
public class SSWebViewVideoPage extends SSWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30942a;

    /* renamed from: b  reason: collision with root package name */
    public float f30943b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30944c;

    /* renamed from: d  reason: collision with root package name */
    public ViewParent f30945d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebViewVideoPage(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f30942a = true;
        this.f30943b = -1.0f;
        this.f30944c = false;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (((ScrollView) this.f30945d).getScrollY() == 0) {
                if (z) {
                    a();
                } else {
                    b();
                }
            } else if (!this.f30942a) {
                a();
            } else if (z) {
                b();
            } else {
                a();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f30944c) {
            return;
        }
        this.f30945d.requestDisallowInterceptTouchEvent(false);
        this.f30944c = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.onOverScrolled(i2, i3, z, z2);
            if (i3 == 0 && z2) {
                this.f30942a = true;
            } else {
                this.f30942a = false;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.f30945d == null) {
                this.f30945d = a(this);
            }
            if (motionEvent.getAction() == 0) {
                this.f30943b = motionEvent.getY();
            } else if (motionEvent.getAction() == 2) {
                float y = motionEvent.getY() - this.f30943b;
                int i2 = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    a(true);
                } else if (i2 != 0 && y < 0.0f) {
                    a(false);
                }
                this.f30943b = motionEvent.getY();
            } else if (motionEvent.getAction() == 1) {
                a();
                this.f30944c = false;
            } else if (motionEvent.getAction() == 3) {
                a();
                this.f30944c = false;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebViewVideoPage(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30942a = true;
        this.f30943b = -1.0f;
        this.f30944c = false;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30944c) {
            return;
        }
        this.f30945d.requestDisallowInterceptTouchEvent(true);
        this.f30944c = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebViewVideoPage(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30942a = true;
        this.f30943b = -1.0f;
        this.f30944c = false;
    }

    private ViewParent a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, view)) == null) {
            ViewParent parent = view.getParent();
            return ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof ScrollingView) || !(parent instanceof View)) ? parent : a((View) parent);
        }
        return (ViewParent) invokeL.objValue;
    }
}
