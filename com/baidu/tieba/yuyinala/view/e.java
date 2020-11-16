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
    private final TextView gNd;
    private final ImageView hWk;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View olD;
    private final int olE;
    private final int olF;

    /* loaded from: classes4.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float olH = 0.0f;
        private float olI = 9.0f;
        private float olJ = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float olK = 5.0f;
        private float olL = 5.0f;
        private float olM = 5.0f;
        private float olN = 5.0f;
        private float olO = 11.0f;
        private float olP = 2.0f;
        private boolean olQ = true;
        private boolean olR = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a ba(float f) {
            this.width = e.c(f, this.context);
            return this;
        }

        public a bb(float f) {
            this.olH = f;
            return this;
        }

        public a bc(float f) {
            this.olI = f;
            return this;
        }

        public a bd(float f) {
            this.olJ = f;
            return this;
        }

        public a w(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a Nf(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.olK = f;
            this.olL = f2;
            this.olM = f3;
            this.olN = f4;
            return this;
        }

        public a be(float f) {
            return h(f, f, f, f);
        }

        public a bf(float f) {
            this.olO = f;
            return this;
        }

        public a bg(float f) {
            this.olP = f;
            return this;
        }

        public a zv(boolean z) {
            this.olQ = z;
            return this;
        }

        public a zw(boolean z) {
            this.olR = z;
            return this;
        }

        public e eaY() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.olD = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.olD.getLocationInWindow(iArr);
        int width = this.olD.getWidth();
        int height = this.olD.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.olE = ((width / 2) + i) - c(aVar.olH, context);
        this.olF = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.hWk = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.gNd = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hWk.getLayoutParams();
        layoutParams.width = c(aVar.olI, context);
        layoutParams.height = c(aVar.olJ, context);
        layoutParams.leftMargin = c(aVar.olH, context) - (c(aVar.olI, context) / 2);
        this.hWk.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gNd.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.gNd.setLayoutParams(layoutParams2);
        this.gNd.setText(aVar.text);
        this.gNd.setGravity(aVar.gravity);
        this.gNd.setPadding(c(aVar.olK, context), c(aVar.olL, context), c(aVar.olM, context), c(aVar.olN, context));
        this.gNd.setTextSize(aVar.olO);
        GradientDrawable gradientDrawable = (GradientDrawable) this.gNd.getBackground();
        gradientDrawable.setCornerRadius(c(aVar.olP, context));
        this.gNd.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.olQ);
        if (aVar.olR) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.olD, 0, this.olE, this.olF);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
