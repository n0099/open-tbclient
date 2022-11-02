package com.baidu.ufosdk;

import android.util.Base64;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class u0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackInputActivity a;

    public u0(FeedbackInputActivity feedbackInputActivity) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FeedbackInputActivity feedbackInputActivity = this.a;
            feedbackInputActivity.Z.getText().toString();
            if (feedbackInputActivity.c.size() < 2) {
                if (feedbackInputActivity.a(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.l0.a, feedbackInputActivity.l, feedbackInputActivity.n, feedbackInputActivity.Z.getText().toString(), feedbackInputActivity.f0, null, feedbackInputActivity.W, -999)) {
                    String str = "SendFeedback --> 反馈发送成功！--" + feedbackInputActivity.Z.getText().toString();
                    feedbackInputActivity.W.obtainMessage(1, feedbackInputActivity.Z.getText().toString()).sendToTarget();
                    String str2 = "346 --> tempRobotSwitch = " + feedbackInputActivity.C;
                    if (!feedbackInputActivity.C && !feedbackInputActivity.l.contains("newMessage") && !feedbackInputActivity.z && feedbackInputActivity.h0) {
                        feedbackInputActivity.W.obtainMessage(8).sendToTarget();
                        return;
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < feedbackInputActivity.c.size() - 1; i++) {
                jSONArray.put(Base64.encodeToString(feedbackInputActivity.c.get(i), 0));
            }
            if (jSONArray.toString().length() < 2097152) {
                if (feedbackInputActivity.a(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.l0.a, feedbackInputActivity.l, feedbackInputActivity.n, feedbackInputActivity.Z.getText().toString(), feedbackInputActivity.f0, jSONArray.toString(), feedbackInputActivity.W, -999)) {
                    feedbackInputActivity.W.obtainMessage(1, feedbackInputActivity.Z.getText().toString()).sendToTarget();
                    for (int i2 = 0; i2 < feedbackInputActivity.c.size() - 1; i2++) {
                        feedbackInputActivity.W.obtainMessage(3, feedbackInputActivity.c.get(i2)).sendToTarget();
                    }
                    if (!feedbackInputActivity.C && !feedbackInputActivity.l.contains("newMessage") && !feedbackInputActivity.z && feedbackInputActivity.h0) {
                        feedbackInputActivity.W.obtainMessage(8).sendToTarget();
                        return;
                    }
                    return;
                }
                return;
            }
            Toast.makeText(feedbackInputActivity, t1.a("21"), 1).show();
        }
    }
}
