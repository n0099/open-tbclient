package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class cy extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f59970a;

    public cy(FeedbackInputActivity feedbackInputActivity) {
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
        this.f59970a = feedbackInputActivity;
    }

    public static Integer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Thread.sleep(280L);
                return null;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Integer) invokeV.objValue;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        boolean z;
        z = this.f59970a.aD;
        if (z) {
            Intent intent = new Intent(this.f59970a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.f59723j);
            intent.putExtra("backPress", true);
            this.f59970a.startActivity(intent);
        }
        this.f59970a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f59970a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f59970a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f59970a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f59970a.getCurrentFocus() == null || this.f59970a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f59970a.getSystemService("input_method")).hideSoftInputFromWindow(this.f59970a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
