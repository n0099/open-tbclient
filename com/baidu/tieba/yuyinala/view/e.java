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
    private final TextView gWq;
    private final ImageView ihh;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oAD;
    private final int oAE;
    private final int oAF;

    /* loaded from: classes4.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oAH = 0.0f;
        private float oAI = 9.0f;
        private float oAJ = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oAK = 5.0f;
        private float oAL = 5.0f;
        private float oAM = 5.0f;
        private float oAN = 5.0f;
        private float oAO = 11.0f;
        private float oAP = 2.0f;
        private boolean oAQ = true;
        private boolean oAR = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bb(float f) {
            this.width = e.c(f, this.context);
            return this;
        }

        public a bc(float f) {
            this.oAH = f;
            return this;
        }

        public a bd(float f) {
            this.oAI = f;
            return this;
        }

        public a be(float f) {
            this.oAJ = f;
            return this;
        }

        public a x(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a NX(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.oAK = f;
            this.oAL = f2;
            this.oAM = f3;
            this.oAN = f4;
            return this;
        }

        public a bf(float f) {
            return h(f, f, f, f);
        }

        public a bg(float f) {
            this.oAO = f;
            return this;
        }

        public a bh(float f) {
            this.oAP = f;
            return this;
        }

        public a zZ(boolean z) {
            this.oAQ = z;
            return this;
        }

        public a Aa(boolean z) {
            this.oAR = z;
            return this;
        }

        public e egD() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oAD = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oAD.getLocationInWindow(iArr);
        int width = this.oAD.getWidth();
        int height = this.oAD.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oAE = ((width / 2) + i) - c(aVar.oAH, context);
        this.oAF = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.ihh = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.gWq = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ihh.getLayoutParams();
        layoutParams.width = c(aVar.oAI, context);
        layoutParams.height = c(aVar.oAJ, context);
        layoutParams.leftMargin = c(aVar.oAH, context) - (c(aVar.oAI, context) / 2);
        this.ihh.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gWq.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.gWq.setLayoutParams(layoutParams2);
        this.gWq.setText(aVar.text);
        this.gWq.setGravity(aVar.gravity);
        this.gWq.setPadding(c(aVar.oAK, context), c(aVar.oAL, context), c(aVar.oAM, context), c(aVar.oAN, context));
        this.gWq.setTextSize(aVar.oAO);
        GradientDrawable gradientDrawable = (GradientDrawable) this.gWq.getBackground();
        gradientDrawable.setCornerRadius(c(aVar.oAP, context));
        this.gWq.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oAQ);
        if (aVar.oAR) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oAD, 0, this.oAE, this.oAF);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
