package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public final class ad implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23328a;

    public ad(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23328a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            z = this.f23328a.v;
            if (z) {
                return;
            }
            list = this.f23328a.q;
            if (list.size() >= 3) {
                FeedbackEditActivity.a(this.f23328a, 3);
            }
        }
    }
}
