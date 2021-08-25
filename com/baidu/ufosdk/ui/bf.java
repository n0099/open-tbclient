package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class bf implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f59564a;

    public bf(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59564a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            try {
                if (!com.baidu.ufosdk.b.d.c(this.f59564a.getApplicationContext())) {
                    com.baidu.ufosdk.f.c.b("Network is not avaiable!");
                    return;
                }
                this.f59564a.f59492b.setVisibility(8);
                this.f59564a.k.setVisibility(0);
                if (this.f59564a.f59495e == null || this.f59564a.f59495e.length() <= 0) {
                    return;
                }
                this.f59564a.l.execute(new bg(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
