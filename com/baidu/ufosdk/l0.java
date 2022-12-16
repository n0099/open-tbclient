package com.baidu.ufosdk;

import android.graphics.BitmapFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
/* loaded from: classes7.dex */
public class l0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ FeedbackEditActivity c;

    public l0(FeedbackEditActivity feedbackEditActivity, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = feedbackEditActivity;
        this.a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = " --*^o^*-- return : " + this.a;
            byte[] a = FeedbackEditActivity.a(this.c, BitmapFactory.decodeFile(this.a));
            if (a != null && a.length != 0) {
                this.c.s.set(this.b, a);
                this.c.t.put("" + this.b, this.a);
                String str2 = "*^o^*-- picPathMap.size : " + this.c.t.size();
                this.c.D.obtainMessage(17).sendToTarget();
            }
        }
    }
}
