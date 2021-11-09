package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes9.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f55325e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f55326f;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55326f = new Rect();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            Activity activity = (Activity) getContext();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f55326f);
            int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f55326f.top) - size;
            if (this.f55325e != null) {
                boolean z = true;
                if (!MenuKeyUtils.hasSmartBar() ? height <= 128 : height <= l.e(activity, 48.0f) + 128) {
                    z = false;
                }
                this.f55325e.a(z);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f55325e = aVar;
        }
    }
}
