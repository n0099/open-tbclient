package com.baidu.wallet.passport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes5.dex */
public class c {
    public static void a(Context context, SapiWebView sapiWebView) {
        d(context, sapiWebView);
    }

    public static void b(Context context, final SapiWebView sapiWebView) {
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(ResUtils.layout(context, "wallet_login_sapi_exception"), (ViewGroup) null);
        inflate.findViewById(ResUtils.id(context, "exception_try_again")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.passport.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                inflate.setVisibility(4);
                sapiWebView.reload();
            }
        });
        inflate.findViewById(ResUtils.id(context, "exception_try_again")).setVisibility(8);
        sapiWebView.setNoNetworkView(inflate);
    }

    public static void c(Context context, final SapiWebView sapiWebView) {
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(ResUtils.layout(context, "wallet_login_sapi_exception"), (ViewGroup) null);
        Button button = (Button) inflate.findViewById(ResUtils.id(context, "exception_try_again"));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.passport.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.wallet.passport.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        inflate.setVisibility(4);
                        SapiWebView.this.reload();
                    }
                });
            }
        });
        button.setVisibility(8);
        sapiWebView.setTimeoutView(inflate);
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, 4, 0, 0));
        sapiWebView.setProgressBar(progressBar);
    }
}
