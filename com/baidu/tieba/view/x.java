package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class x extends Dialog {
    private Window a;
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

    public x(Context context, int i, int i2) {
        super(context, R.style.big_image_dialog);
        this.a = null;
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
        this.l = com.baidu.tieba.c.ah.a(context, 0.0f);
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
        this.h = com.baidu.tieba.c.ah.a(context, 234.0f);
        if (this.h > 350) {
            this.h = 350;
        }
        this.i = (int) (this.h * 1.62f);
        this.d = (ProgressBar) this.c.findViewById(R.id.image_progress);
        this.e = new y(this);
    }

    public void a() {
        if (isShowing()) {
            this.d.setVisibility(8);
            com.baidu.tieba.c.ah.a(getContext(), getContext().getResources().getString(R.string.image_error));
        }
    }

    public void a(Bitmap bitmap) {
        this.d.setVisibility(8);
        if (bitmap != null) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams.width <= bitmap.getWidth() + 4) {
                layoutParams.width = bitmap.getWidth();
            }
            if (layoutParams.height <= bitmap.getHeight() + 4) {
                layoutParams.height = bitmap.getHeight();
            }
            this.b.setLayoutParams(layoutParams);
            this.b.setImageBitmap(bitmap);
        }
    }

    public void a(Bitmap bitmap, boolean z) {
        b(bitmap);
        if (!z) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        b();
        show();
    }

    private void b(Bitmap bitmap) {
        int i;
        int height;
        if (bitmap != null) {
            if (this.h / this.i > bitmap.getWidth() / bitmap.getHeight()) {
                i = (bitmap.getWidth() * this.i) / bitmap.getHeight();
                height = this.i;
            } else {
                i = this.h;
                height = (bitmap.getHeight() * this.h) / bitmap.getWidth();
            }
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            int i2 = i + (this.l * 2);
            int i3 = height + (this.l * 2);
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.b.setLayoutParams(layoutParams);
            this.j = (this.f - (i2 + (this.m * 2))) / 2;
            this.k = (this.g - (i3 + (this.m * 2))) / 2;
            this.b.setImageBitmap(bitmap);
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
        this.a = getWindow();
        this.a.setWindowAnimations(R.style.big_image_dialog_anim);
        WindowManager.LayoutParams attributes = this.a.getAttributes();
        attributes.x = this.j;
        attributes.y = this.k;
        attributes.horizontalMargin = 0.0f;
        attributes.verticalMargin = 0.0f;
        attributes.gravity = 51;
        this.a.setAttributes(attributes);
    }
}
