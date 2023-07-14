package com.baidu.ufosdk;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class s0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackEditActivity a;

    public s0(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.s.size() <= 0) {
                FeedbackEditActivity feedbackEditActivity = this.a;
                Context applicationContext = feedbackEditActivity.getApplicationContext();
                FeedbackEditActivity feedbackEditActivity2 = this.a;
                feedbackEditActivity.a(applicationContext, feedbackEditActivity2.K.a, feedbackEditActivity2.v, feedbackEditActivity2.l.getText().toString(), this.a.m.getText().toString(), null, this.a.D);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.a.s.size() - 1; i++) {
                jSONArray.put(Base64.encodeToString(this.a.s.get(i), 0));
            }
            if (jSONArray.toString().length() < 2097152) {
                FeedbackEditActivity feedbackEditActivity3 = this.a;
                Context applicationContext2 = feedbackEditActivity3.getApplicationContext();
                FeedbackEditActivity feedbackEditActivity4 = this.a;
                feedbackEditActivity3.a(applicationContext2, feedbackEditActivity4.K.a, feedbackEditActivity4.v, feedbackEditActivity4.l.getText().toString(), this.a.m.getText().toString(), jSONArray.toString(), this.a.D);
                return;
            }
            Toast.makeText(this.a, t1.a("21"), 0).show();
        }
    }
}
