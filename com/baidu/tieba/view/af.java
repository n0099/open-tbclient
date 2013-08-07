package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class af extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Window f1810a;
    private ImageView b;
    private View c;
    private ProgressBar d;
    private View.OnTouchListener e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public af(Context context, int i, int i2) {
        super(context, R.style.big_image_dialog);
        this.f1810a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.l = com.baidu.tieba.util.am.a(context, 0.0f);
        this.f = i;
        this.g = i2;
        if (this.f <= 0) {
            this.f = 1;
        }
        if (this.g <= 0) {
            this.g = 1;
        }
        this.c = LayoutInflater.from(context).inflate(R.layout.big_image_dialog, (ViewGroup) null);
        this.b = (ImageView) this.c.findViewById(R.id.image);
        this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.b.setPadding(this.l, this.l, this.l, this.l);
        this.h = (int) (this.f * 0.8d);
        this.i = (int) (this.g * 0.8d);
        this.d = (ProgressBar) this.c.findViewById(R.id.image_progress);
        this.e = new ag(this);
    }

    public void a() {
        if (isShowing()) {
            this.d.setVisibility(8);
            com.baidu.tieba.util.am.a(getContext(), getContext().getResources().getString(R.string.image_error));
        }
    }

    public void a(com.baidu.adp.widget.a.b bVar) {
        this.d.setVisibility(8);
        if (bVar != null) {
            this.b.setLayoutParams(this.b.getLayoutParams());
            bVar.b(this.b);
        }
    }

    public void a(com.baidu.adp.widget.a.b bVar, boolean z) {
        b(bVar);
        if (!z) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        b();
        show();
    }

    private void b(com.baidu.adp.widget.a.b bVar) {
        int i;
        int b;
        if (bVar != null) {
            if (this.h / this.i > bVar.a() / bVar.b()) {
                i = (bVar.a() * this.i) / bVar.b();
                b = this.i;
            } else {
                i = this.h;
                b = (bVar.b() * this.h) / bVar.a();
            }
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            int i2 = i + (this.l * 2);
            int i3 = b + (this.l * 2);
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.b.setLayoutParams(layoutParams);
            this.j = (this.f - (i2 + (this.m * 2))) / 2;
            this.k = (this.g - (i3 + (this.m * 2))) / 2;
            bVar.b(this.b);
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.d.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.c);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().getDecorView().setOnTouchListener(this.e);
    }

    public void b() {
        this.f1810a = getWindow();
        this.f1810a.setWindowAnimations(R.style.big_image_dialog_anim);
        WindowManager.LayoutParams attributes = this.f1810a.getAttributes();
        attributes.x = this.j;
        attributes.y = this.k;
        attributes.horizontalMargin = 0.0f;
        attributes.verticalMargin = 0.0f;
        attributes.gravity = 51;
        this.f1810a.setAttributes(attributes);
    }
}
