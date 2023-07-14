package com.baidu.ufosdk;

import android.util.Base64;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class b1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackReportActivity a;

    public b1(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackReportActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.w.size() <= 1) {
                FeedbackReportActivity feedbackReportActivity = this.a;
                feedbackReportActivity.a(feedbackReportActivity, feedbackReportActivity.U.a, feedbackReportActivity.y, feedbackReportActivity.s.getText().toString(), this.a.t.getText().toString(), null, this.a.H);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.a.w.size() - 1; i++) {
                jSONArray.put(Base64.encodeToString(this.a.w.get(i), 0));
            }
            if (jSONArray.toString().length() < 2097152) {
                FeedbackReportActivity feedbackReportActivity2 = this.a;
                feedbackReportActivity2.a(feedbackReportActivity2, feedbackReportActivity2.U.a, feedbackReportActivity2.y, feedbackReportActivity2.s.getText().toString(), this.a.t.getText().toString(), jSONArray.toString(), this.a.H);
                return;
            }
            Toast.makeText(this.a, t1.a("21"), 0).show();
        }
    }
}
