package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class z implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f60105a;

    /* renamed from: b  reason: collision with root package name */
    public long f60106b;

    public z(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60105a = feedbackEditActivity;
        this.f60106b = 0L;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || System.currentTimeMillis() - this.f60106b < 3000) {
            return;
        }
        z = this.f60105a.v;
        if (z) {
            return;
        }
        this.f60106b = System.currentTimeMillis();
        editText = this.f60105a.n;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f60105a.f59771b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f60105a.f59771b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f60105a.f59771b;
        editor2.commit();
        FeedbackEditActivity.h(this.f60105a);
    }
}
