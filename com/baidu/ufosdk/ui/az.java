package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class az implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f56821a;

    public az(FeedbackHotActivity feedbackHotActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackHotActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56821a = feedbackHotActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        LinearLayout linearLayout;
        View view3;
        TextView textView;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || com.baidu.ufosdk.f.h.a()) {
            return;
        }
        view2 = this.f56821a.l;
        view2.setVisibility(0);
        linearLayout = this.f56821a.f56755h;
        linearLayout.setVisibility(8);
        if (!com.baidu.ufosdk.b.d.b(this.f56821a.getApplicationContext()).contains(RomUtils.UNKNOWN) && !com.baidu.ufosdk.b.d.b(this.f56821a.getApplicationContext()).contains("NONE")) {
            this.f56821a.a();
            linearLayout3 = this.f56821a.f56755h;
            linearLayout3.setVisibility(8);
            webView = this.f56821a.j;
            webView.setVisibility(0);
            return;
        }
        view3 = this.f56821a.l;
        view3.setVisibility(8);
        Context applicationContext = this.f56821a.getApplicationContext();
        textView = this.f56821a.m;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout2 = this.f56821a.f56755h;
        linearLayout2.setVisibility(0);
    }
}
