package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class e extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f28596a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28597b;

    /* renamed from: c  reason: collision with root package name */
    public Button f28598c;

    /* renamed from: d  reason: collision with root package name */
    public Button f28599d;

    /* renamed from: e  reason: collision with root package name */
    public Context f28600e;

    /* renamed from: f  reason: collision with root package name */
    public String f28601f;

    /* renamed from: g  reason: collision with root package name */
    public String f28602g;

    /* renamed from: h  reason: collision with root package name */
    public String f28603h;
    public String i;
    public Drawable j;
    public a k;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);
    }

    public e(Context context) {
        super(context, ad.g(context, "tt_custom_dialog"));
        this.f28600e = context;
    }

    private void b() {
        TextView textView = this.f28596a;
        if (textView != null) {
            textView.setText(this.f28601f);
            Drawable drawable = this.j;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.j.getIntrinsicHeight();
                int c2 = al.c(this.f28600e, 45.0f);
                if (intrinsicWidth > c2 || intrinsicWidth < c2) {
                    intrinsicWidth = c2;
                }
                if (intrinsicHeight > c2 || intrinsicHeight < c2) {
                    intrinsicHeight = c2;
                }
                this.j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f28596a.setCompoundDrawables(this.j, null, null, null);
                this.f28596a.setCompoundDrawablePadding(al.c(this.f28600e, 10.0f));
            }
        }
        TextView textView2 = this.f28597b;
        if (textView2 != null) {
            textView2.setText(this.f28602g);
        }
        Button button = this.f28598c;
        if (button != null) {
            button.setText(this.f28603h);
        }
        Button button2 = this.f28599d;
        if (button2 != null) {
            button2.setText(this.i);
        }
    }

    public e c(@NonNull String str) {
        this.f28603h = str;
        return this;
    }

    public e d(@NonNull String str) {
        this.i = str;
        return this;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28600e, "tt_install_dialog_layout"));
        setCanceledOnTouchOutside(true);
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void a() {
        this.f28596a = (TextView) findViewById(ad.e(this.f28600e, "tt_install_title"));
        this.f28597b = (TextView) findViewById(ad.e(this.f28600e, "tt_install_content"));
        this.f28598c = (Button) findViewById(ad.e(this.f28600e, "tt_install_btn_yes"));
        this.f28599d = (Button) findViewById(ad.e(this.f28600e, "tt_install_btn_no"));
        this.f28598c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.a(e.this);
                }
            }
        });
        this.f28599d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.b(e.this);
                }
            }
        });
    }

    public e a(@NonNull String str) {
        this.f28601f = str;
        return this;
    }

    public e a(Drawable drawable) {
        this.j = drawable;
        return this;
    }

    public e a(a aVar) {
        this.k = aVar;
        return this;
    }

    public e a(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }

    public e b(@NonNull String str) {
        this.f28602g = str;
        return this;
    }
}
