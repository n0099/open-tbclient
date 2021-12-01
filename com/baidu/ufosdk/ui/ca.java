package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class ca implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackInputActivity a;

    public ca(FeedbackInputActivity feedbackInputActivity) {
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
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            FeedbackInputActivity feedbackInputActivity = this.a;
            if (feedbackInputActivity.D) {
                return;
            }
            if (feedbackInputActivity.p.getVisibility() == 0) {
                linearLayout = this.a.p;
                i2 = 8;
            } else {
                if (this.a.p.getChildCount() <= 0) {
                    this.a.a(true);
                }
                linearLayout = this.a.p;
                i2 = 0;
            }
            linearLayout.setVisibility(i2);
            this.a.C.setVisibility(i2);
        }
    }
}
