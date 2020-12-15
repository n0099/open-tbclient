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
    private final TextView gWs;
    private final ImageView ihj;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oAF;
    private final int oAG;
    private final int oAH;

    /* loaded from: classes4.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oAJ = 0.0f;
        private float oAK = 9.0f;
        private float oAL = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oAM = 5.0f;
        private float oAN = 5.0f;
        private float oAO = 5.0f;
        private float oAP = 5.0f;
        private float oAQ = 11.0f;
        private float oAR = 2.0f;
        private boolean oAS = true;
        private boolean oAT = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bb(float f) {
            this.width = e.c(f, this.context);
            return this;
        }

        public a bc(float f) {
            this.oAJ = f;
            return this;
        }

        public a bd(float f) {
            this.oAK = f;
            return this;
        }

        public a be(float f) {
            this.oAL = f;
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
            this.oAM = f;
            this.oAN = f2;
            this.oAO = f3;
            this.oAP = f4;
            return this;
        }

        public a bf(float f) {
            return h(f, f, f, f);
        }

        public a bg(float f) {
            this.oAQ = f;
            return this;
        }

        public a bh(float f) {
            this.oAR = f;
            return this;
        }

        public a zZ(boolean z) {
            this.oAS = z;
            return this;
        }

        public a Aa(boolean z) {
            this.oAT = z;
            return this;
        }

        public e egE() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oAF = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oAF.getLocationInWindow(iArr);
        int width = this.oAF.getWidth();
        int height = this.oAF.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oAG = ((width / 2) + i) - c(aVar.oAJ, context);
        this.oAH = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.ihj = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.gWs = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ihj.getLayoutParams();
        layoutParams.width = c(aVar.oAK, context);
        layoutParams.height = c(aVar.oAL, context);
        layoutParams.leftMargin = c(aVar.oAJ, context) - (c(aVar.oAK, context) / 2);
        this.ihj.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gWs.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.gWs.setLayoutParams(layoutParams2);
        this.gWs.setText(aVar.text);
        this.gWs.setGravity(aVar.gravity);
        this.gWs.setPadding(c(aVar.oAM, context), c(aVar.oAN, context), c(aVar.oAO, context), c(aVar.oAP, context));
        this.gWs.setTextSize(aVar.oAQ);
        GradientDrawable gradientDrawable = (GradientDrawable) this.gWs.getBackground();
        gradientDrawable.setCornerRadius(c(aVar.oAR, context));
        this.gWs.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oAS);
        if (aVar.oAT) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oAF, 0, this.oAG, this.oAH);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
