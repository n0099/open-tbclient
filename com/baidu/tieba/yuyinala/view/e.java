package com.baidu.tieba.yuyinala.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public final class e {
    private final TextView hdz;
    private final ImageView ioX;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oDP;
    private final int oDQ;
    private final int oDR;

    /* loaded from: classes10.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oDT = 0.0f;
        private float oDU = 9.0f;
        private float oDV = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oDW = 5.0f;
        private float oDX = 5.0f;
        private float oDY = 5.0f;
        private float oDZ = 5.0f;
        private float oEa = 11.0f;
        private float oEb = 2.0f;
        private boolean oEc = true;
        private boolean oEd = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bm(float f) {
            this.width = e.d(f, this.context);
            return this;
        }

        public a bn(float f) {
            this.oDT = f;
            return this;
        }

        public a bo(float f) {
            this.oDU = f;
            return this;
        }

        public a bp(float f) {
            this.oDV = f;
            return this;
        }

        public a x(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a Mk(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.oDW = f;
            this.oDX = f2;
            this.oDY = f3;
            this.oDZ = f4;
            return this;
        }

        public a bq(float f) {
            return h(f, f, f, f);
        }

        public a br(float f) {
            this.oEa = f;
            return this;
        }

        public a bs(float f) {
            this.oEb = f;
            return this;
        }

        public a zY(boolean z) {
            this.oEc = z;
            return this;
        }

        public a zZ(boolean z) {
            this.oEd = z;
            return this;
        }

        public e eds() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oDP = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oDP.getLocationInWindow(iArr);
        int width = this.oDP.getWidth();
        int height = this.oDP.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oDQ = ((width / 2) + i) - d(aVar.oDT, context);
        this.oDR = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.ioX = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.hdz = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ioX.getLayoutParams();
        layoutParams.width = d(aVar.oDU, context);
        layoutParams.height = d(aVar.oDV, context);
        layoutParams.leftMargin = d(aVar.oDT, context) - (d(aVar.oDU, context) / 2);
        this.ioX.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hdz.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.hdz.setLayoutParams(layoutParams2);
        this.hdz.setText(aVar.text);
        this.hdz.setGravity(aVar.gravity);
        this.hdz.setPadding(d(aVar.oDW, context), d(aVar.oDX, context), d(aVar.oDY, context), d(aVar.oDZ, context));
        this.hdz.setTextSize(aVar.oEa);
        GradientDrawable gradientDrawable = (GradientDrawable) this.hdz.getBackground();
        gradientDrawable.setCornerRadius(d(aVar.oEb, context));
        this.hdz.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oEc);
        if (aVar.oEd) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oDP, 0, this.oDQ, this.oDR);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int d(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
