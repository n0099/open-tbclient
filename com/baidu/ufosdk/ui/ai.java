package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
public final class ai implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f59339a;

    public ai(FeedbackFacePageActivity feedbackFacePageActivity) {
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
        this.f59339a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(this.f59339a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
                if (com.baidu.ufosdk.b.d.b(this.f59339a.getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(this.f59339a.getApplicationContext()).contains("NONE")) {
                    return;
                }
                new Thread(new aj(this)).start();
                return;
            }
            try {
                if (com.baidu.ufosdk.f.h.a()) {
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this.f59339a, FeedbackEditActivity.class);
                str = this.f59339a.t;
                intent.putExtra("msgid", str);
                intent.putExtra("fromlist", "no");
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.f59177j);
                intent.putExtra("come_from", 2);
                this.f59339a.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
