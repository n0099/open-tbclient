package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.util.Base64;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public final class eh implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f59496a;

    public eh(FeedbackReportActivity feedbackReportActivity) {
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
        this.f59496a = feedbackReportActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x006e */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        List list;
        List list2;
        String str;
        EditText editText;
        EditText editText2;
        Handler handler;
        List list3;
        String str2;
        EditText editText3;
        EditText editText4;
        Handler handler2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            list = this.f59496a.x;
            if (list.size() <= 1) {
                FeedbackReportActivity feedbackReportActivity = this.f59496a;
                Context applicationContext = feedbackReportActivity.getApplicationContext();
                String str3 = UfoSDK.clientid;
                str2 = this.f59496a.z;
                StringBuilder sb = new StringBuilder();
                sb.append(com.baidu.ufosdk.b.l);
                editText3 = this.f59496a.t;
                sb.append(editText3.getText().toString());
                sb.append(com.baidu.ufosdk.b.m);
                String sb2 = sb.toString();
                editText4 = this.f59496a.u;
                String obj = editText4.getText().toString();
                handler2 = this.f59496a.K;
                feedbackReportActivity.a(applicationContext, str3, str2, sb2, obj, null, handler2);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list2.size() - 1; i2++) {
                list3 = this.f59496a.x;
                jSONArray.put(Base64.encodeToString((byte[]) list3.get(i2), 0));
            }
            if (jSONArray.toString().length() >= 2097152) {
                Toast.makeText(this.f59496a, com.baidu.ufosdk.f.s.a("21"), 0).show();
                return;
            }
            FeedbackReportActivity feedbackReportActivity2 = this.f59496a;
            Context applicationContext2 = feedbackReportActivity2.getApplicationContext();
            String str4 = UfoSDK.clientid;
            str = this.f59496a.z;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(com.baidu.ufosdk.b.l);
            editText = this.f59496a.t;
            sb3.append(editText.getText().toString());
            sb3.append(com.baidu.ufosdk.b.m);
            String sb4 = sb3.toString();
            editText2 = this.f59496a.u;
            String obj2 = editText2.getText().toString();
            String jSONArray2 = jSONArray.toString();
            handler = this.f59496a.K;
            feedbackReportActivity2.a(applicationContext2, str4, str, sb4, obj2, jSONArray2, handler);
        }
    }
}
