package com.baidu.ufosdk;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
/* loaded from: classes6.dex */
public class c0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ ScreenCapEditActivity b;

    public c0(ScreenCapEditActivity screenCapEditActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {screenCapEditActivity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = screenCapEditActivity;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent();
            ScreenCapEditActivity screenCapEditActivity = this.b;
            intent.setClass(screenCapEditActivity, screenCapEditActivity.G ? FeedbackInputActivity.class : FeedbackEditActivity.class);
            intent.putExtra("shot", this.b.H.toByteArray());
            intent.putExtra("extend_feedback_channel", this.a);
            intent.putExtra("come_from", 3);
            intent.putExtra("feedback_channel", this.a);
            this.b.startActivity(intent);
            this.b.finish();
        }
    }
}
