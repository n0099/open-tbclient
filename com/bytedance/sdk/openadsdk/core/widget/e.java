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
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class e extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4614a;
    private TextView b;
    private Button c;
    private Button d;
    private Context e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Drawable j;
    private a k;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);
    }

    public e(Context context) {
        super(context, ac.g(context, "tt_custom_dialog"));
        this.e = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.e, "tt_install_dialog_layout"));
        setCanceledOnTouchOutside(true);
        a();
    }

    private void a() {
        this.f4614a = (TextView) findViewById(ac.e(this.e, "tt_install_title"));
        this.b = (TextView) findViewById(ac.e(this.e, "tt_install_content"));
        this.c = (Button) findViewById(ac.e(this.e, "tt_install_btn_yes"));
        this.d = (Button) findViewById(ac.e(this.e, "tt_install_btn_no"));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.a(e.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.b(e.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void b() {
        if (this.f4614a != null) {
            this.f4614a.setText(this.f);
            if (this.j != null) {
                int intrinsicWidth = this.j.getIntrinsicWidth();
                int intrinsicHeight = this.j.getIntrinsicHeight();
                int c = ak.c(this.e, 45.0f);
                if (intrinsicWidth > c || intrinsicWidth < c) {
                    intrinsicWidth = c;
                }
                if (intrinsicHeight > c || intrinsicHeight < c) {
                    intrinsicHeight = c;
                }
                this.j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f4614a.setCompoundDrawables(this.j, null, null, null);
                this.f4614a.setCompoundDrawablePadding(ak.c(this.e, 10.0f));
            }
        }
        if (this.b != null) {
            this.b.setText(this.g);
        }
        if (this.c != null) {
            this.c.setText(this.h);
        }
        if (this.d != null) {
            this.d.setText(this.i);
        }
    }

    public e a(@NonNull String str) {
        this.f = str;
        return this;
    }

    public e b(@NonNull String str) {
        this.g = str;
        return this;
    }

    public e c(@NonNull String str) {
        this.h = str;
        return this;
    }

    public e d(@NonNull String str) {
        this.i = str;
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
}
