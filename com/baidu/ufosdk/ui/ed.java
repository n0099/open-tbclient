package com.baidu.ufosdk.ui;

import android.widget.Button;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ed implements ey {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f59691a;

    public ed(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59691a = feedbackReportActivity;
    }

    @Override // com.baidu.ufosdk.ui.ey
    public final void a(String str) {
        Button button;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f59691a.F = str;
            button = this.f59691a.m;
            int i2 = com.baidu.ufosdk.b.v;
            int i3 = com.baidu.ufosdk.b.y;
            int i4 = com.baidu.ufosdk.b.v;
            button.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
        }
    }
}
