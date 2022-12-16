package com.baidu.ufosdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
/* loaded from: classes7.dex */
public class v0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackInputActivity a;

    public v0(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str2 = this.a.n;
            if (str2 != null && str2.length() > 0) {
                str = this.a.n;
            } else {
                str = this.a.l0.b;
            }
            FeedbackInputActivity feedbackInputActivity = this.a;
            String str3 = feedbackInputActivity.l0.a;
            b.c(feedbackInputActivity, feedbackInputActivity.l, str);
        }
    }
}
