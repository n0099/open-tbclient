package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes6.dex */
public final class ak implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f23337a;

    public ak(FeedbackFacePageActivity feedbackFacePageActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackFacePageActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23337a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        SharedPreferences sharedPreferences2;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(this.f23337a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
                if (com.baidu.ufosdk.b.d.c(this.f23337a.getApplicationContext())) {
                    new Thread(new al(this)).start();
                    return;
                } else {
                    Toast.makeText(this.f23337a.getApplicationContext(), com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 1).show();
                    return;
                }
            }
            try {
                if (com.baidu.ufosdk.f.h.a()) {
                    return;
                }
                String b2 = com.baidu.ufosdk.f.i.b(System.currentTimeMillis());
                String str2 = UfoSDK.startStr;
                if (str2.equals(b2 + "-enable")) {
                    sharedPreferences = this.f23337a.f23271b;
                    if (!sharedPreferences.getBoolean("robotUv_has", false)) {
                        sharedPreferences2 = this.f23337a.f23271b;
                        int i2 = sharedPreferences2.getInt("robotUv", 0);
                        editor2 = this.f23337a.f23270a;
                        editor2.putInt("robotUv", i2 + 1);
                        editor3 = this.f23337a.f23270a;
                        editor3.putBoolean("robotUv_has", true);
                    }
                    editor = this.f23337a.f23270a;
                    editor.commit();
                }
                Intent intent = new Intent();
                intent.setClass(this.f23337a, FeedbackInputActivity.class);
                str = this.f23337a.t;
                intent.putExtra("msgid", str);
                intent.putExtra("fromlist", "no");
                intent.putExtra("from_facepage", true);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
                this.f23337a.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
