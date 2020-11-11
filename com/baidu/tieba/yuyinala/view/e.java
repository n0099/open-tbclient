package com.baidu.tieba.yuyinala.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public final class e {
    private final TextView gNw;
    private final ImageView hVK;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oka;
    private final int okb;
    private final int okc;

    /* loaded from: classes4.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oke = 0.0f;
        private float okf = 9.0f;
        private float okg = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float okh = 5.0f;
        private float oki = 5.0f;
        private float okj = 5.0f;
        private float okk = 5.0f;
        private float okl = 11.0f;
        private float okm = 2.0f;
        private boolean okn = true;
        private boolean oko = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a aT(float f) {
            this.width = e.c(f, this.context);
            return this;
        }

        public a aU(float f) {
            this.oke = f;
            return this;
        }

        public a aV(float f) {
            this.okf = f;
            return this;
        }

        public a aW(float f) {
            this.okg = f;
            return this;
        }

        public a v(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a MC(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.okh = f;
            this.oki = f2;
            this.okj = f3;
            this.okk = f4;
            return this;
        }

        public a aX(float f) {
            return h(f, f, f, f);
        }

        public a aY(float f) {
            this.okl = f;
            return this;
        }

        public a aZ(float f) {
            this.okm = f;
            return this;
        }

        public a zo(boolean z) {
            this.okn = z;
            return this;
        }

        public a zp(boolean z) {
            this.oko = z;
            return this;
        }

        public e eaZ() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oka = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oka.getLocationInWindow(iArr);
        int width = this.oka.getWidth();
        int height = this.oka.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.okb = ((width / 2) + i) - c(aVar.oke, context);
        this.okc = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.hVK = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.gNw = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hVK.getLayoutParams();
        layoutParams.width = c(aVar.okf, context);
        layoutParams.height = c(aVar.okg, context);
        layoutParams.leftMargin = c(aVar.oke, context) - (c(aVar.okf, context) / 2);
        this.hVK.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gNw.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.gNw.setLayoutParams(layoutParams2);
        this.gNw.setText(aVar.text);
        this.gNw.setGravity(aVar.gravity);
        this.gNw.setPadding(c(aVar.okh, context), c(aVar.oki, context), c(aVar.okj, context), c(aVar.okk, context));
        this.gNw.setTextSize(aVar.okl);
        GradientDrawable gradientDrawable = (GradientDrawable) this.gNw.getBackground();
        gradientDrawable.setCornerRadius(c(aVar.okm, context));
        this.gNw.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.okn);
        if (aVar.oko) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oka, 0, this.okb, this.okc);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
