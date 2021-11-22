package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebView;
/* loaded from: classes10.dex */
public class LightappBrowserWebView extends LightappWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f59809a;

    /* renamed from: b  reason: collision with root package name */
    public int f59810b;

    /* renamed from: c  reason: collision with root package name */
    public int f59811c;
    public boolean isTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightappBrowserWebView(Context context) {
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
        this.f59809a = LightappBrowserWebView.class.getSimpleName();
        this.f59810b = -1;
        this.f59811c = -1;
        this.isTop = true;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            FrameLayout frameLayout = (FrameLayout) getParent();
            int childCount = frameLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (frameLayout.getChildAt(i2) instanceof EditText) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f59810b > 0 && this.f59811c > 0 && a() : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f59810b < 0 && measuredWidth > 0) {
                this.f59810b = measuredWidth;
            }
            if (this.f59811c < 0 && measuredHeight > 10) {
                this.f59811c = measuredHeight;
            }
            String str = this.f59809a;
            LogUtil.d(str, "onMeasure current:(" + measuredWidth + "," + measuredHeight + SmallTailInfo.EMOTION_SUFFIX);
            if (b()) {
                String str2 = this.f59809a;
                LogUtil.d(str2, "onMeasure force to:(" + this.f59810b + "," + this.f59811c + SmallTailInfo.EMOTION_SUFFIX);
                setMeasuredDimension(this.f59810b, this.f59811c);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            if (i3 == 0) {
                this.isTop = true;
            } else if (i3 != 0) {
                this.isTop = false;
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0 && getScrollY() <= 0) {
                scrollTo(0, 1);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
