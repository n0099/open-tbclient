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
    public TextView f29483a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f29484b;

    /* renamed from: c  reason: collision with root package name */
    public Button f29485c;

    /* renamed from: d  reason: collision with root package name */
    public Button f29486d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29487e;

    /* renamed from: f  reason: collision with root package name */
    public String f29488f;

    /* renamed from: g  reason: collision with root package name */
    public String f29489g;

    /* renamed from: h  reason: collision with root package name */
    public String f29490h;

    /* renamed from: i  reason: collision with root package name */
    public String f29491i;
    public Drawable j;
    public a k;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);
    }

    public e(Context context) {
        super(context, ad.g(context, "tt_custom_dialog"));
        this.f29487e = context;
    }

    private void b() {
        TextView textView = this.f29483a;
        if (textView != null) {
            textView.setText(this.f29488f);
            Drawable drawable = this.j;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.j.getIntrinsicHeight();
                int c2 = al.c(this.f29487e, 45.0f);
                if (intrinsicWidth > c2 || intrinsicWidth < c2) {
                    intrinsicWidth = c2;
                }
                if (intrinsicHeight > c2 || intrinsicHeight < c2) {
                    intrinsicHeight = c2;
                }
                this.j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f29483a.setCompoundDrawables(this.j, null, null, null);
                this.f29483a.setCompoundDrawablePadding(al.c(this.f29487e, 10.0f));
            }
        }
        TextView textView2 = this.f29484b;
        if (textView2 != null) {
            textView2.setText(this.f29489g);
        }
        Button button = this.f29485c;
        if (button != null) {
            button.setText(this.f29490h);
        }
        Button button2 = this.f29486d;
        if (button2 != null) {
            button2.setText(this.f29491i);
        }
    }

    public e c(@NonNull String str) {
        this.f29490h = str;
        return this;
    }

    public e d(@NonNull String str) {
        this.f29491i = str;
        return this;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f29487e, "tt_install_dialog_layout"));
        setCanceledOnTouchOutside(true);
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void a() {
        this.f29483a = (TextView) findViewById(ad.e(this.f29487e, "tt_install_title"));
        this.f29484b = (TextView) findViewById(ad.e(this.f29487e, "tt_install_content"));
        this.f29485c = (Button) findViewById(ad.e(this.f29487e, "tt_install_btn_yes"));
        this.f29486d = (Button) findViewById(ad.e(this.f29487e, "tt_install_btn_no"));
        this.f29485c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.a(e.this);
                }
            }
        });
        this.f29486d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.2
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
        this.f29488f = str;
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
        this.f29489g = str;
        return this;
    }
}
