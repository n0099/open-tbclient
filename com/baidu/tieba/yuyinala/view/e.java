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
    private final TextView gHK;
    private final ImageView hPN;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oaU;
    private final int oaV;
    private final int oaW;

    /* loaded from: classes4.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oaY = 0.0f;
        private float oaZ = 9.0f;
        private float oba = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float obb = 5.0f;
        private float obc = 5.0f;
        private float obd = 5.0f;
        private float obe = 5.0f;
        private float obf = 11.0f;
        private float obg = 2.0f;
        private boolean obh = true;
        private boolean obi = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a aR(float f) {
            this.width = e.c(f, this.context);
            return this;
        }

        public a aS(float f) {
            this.oaY = f;
            return this;
        }

        public a aT(float f) {
            this.oaZ = f;
            return this;
        }

        public a aU(float f) {
            this.oba = f;
            return this;
        }

        public a v(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a Mj(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.obb = f;
            this.obc = f2;
            this.obd = f3;
            this.obe = f4;
            return this;
        }

        public a aV(float f) {
            return h(f, f, f, f);
        }

        public a aW(float f) {
            this.obf = f;
            return this;
        }

        public a aX(float f) {
            this.obg = f;
            return this;
        }

        public a zd(boolean z) {
            this.obh = z;
            return this;
        }

        public a ze(boolean z) {
            this.obi = z;
            return this;
        }

        public e dXr() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oaU = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oaU.getLocationInWindow(iArr);
        int width = this.oaU.getWidth();
        int height = this.oaU.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oaV = ((width / 2) + i) - c(aVar.oaY, context);
        this.oaW = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.h.yuyin_component_popup_layout, (ViewGroup) null);
        this.hPN = (ImageView) this.mContentView.findViewById(a.g.iv_arrow);
        this.gHK = (TextView) this.mContentView.findViewById(a.g.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPN.getLayoutParams();
        layoutParams.width = c(aVar.oaZ, context);
        layoutParams.height = c(aVar.oba, context);
        layoutParams.leftMargin = c(aVar.oaY, context) - (c(aVar.oaZ, context) / 2);
        this.hPN.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gHK.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.gHK.setLayoutParams(layoutParams2);
        this.gHK.setText(aVar.text);
        this.gHK.setGravity(aVar.gravity);
        this.gHK.setPadding(c(aVar.obb, context), c(aVar.obc, context), c(aVar.obd, context), c(aVar.obe, context));
        this.gHK.setTextSize(aVar.obf);
        GradientDrawable gradientDrawable = (GradientDrawable) this.gHK.getBackground();
        gradientDrawable.setCornerRadius(c(aVar.obg, context));
        this.gHK.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.obh);
        if (aVar.obi) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oaU, 0, this.oaV, this.oaW);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
