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
/* loaded from: classes11.dex */
public final class e {
    private final TextView hii;
    private final ImageView iuB;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oNZ;
    private final int oOa;
    private final int oOb;

    /* loaded from: classes11.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oOd = 0.0f;
        private float oOe = 9.0f;
        private float oOf = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oOg = 5.0f;
        private float oOh = 5.0f;
        private float oOi = 5.0f;
        private float oOj = 5.0f;
        private float oOk = 11.0f;
        private float oOl = 2.0f;
        private boolean oOm = true;
        private boolean oOn = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bp(float f) {
            this.width = e.d(f, this.context);
            return this;
        }

        public a bq(float f) {
            this.oOd = f;
            return this;
        }

        public a br(float f) {
            this.oOe = f;
            return this;
        }

        public a bs(float f) {
            this.oOf = f;
            return this;
        }

        public a y(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a MG(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.oOg = f;
            this.oOh = f2;
            this.oOi = f3;
            this.oOj = f4;
            return this;
        }

        public a bt(float f) {
            return h(f, f, f, f);
        }

        public a bu(float f) {
            this.oOk = f;
            return this;
        }

        public a bv(float f) {
            this.oOl = f;
            return this;
        }

        public a Ar(boolean z) {
            this.oOm = z;
            return this;
        }

        public a As(boolean z) {
            this.oOn = z;
            return this;
        }

        public e efK() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oNZ = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oNZ.getLocationInWindow(iArr);
        int width = this.oNZ.getWidth();
        int height = this.oNZ.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oOa = ((width / 2) + i) - d(aVar.oOd, context);
        this.oOb = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.iuB = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.hii = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuB.getLayoutParams();
        layoutParams.width = d(aVar.oOe, context);
        layoutParams.height = d(aVar.oOf, context);
        layoutParams.leftMargin = d(aVar.oOd, context) - (d(aVar.oOe, context) / 2);
        this.iuB.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hii.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.hii.setLayoutParams(layoutParams2);
        this.hii.setText(aVar.text);
        this.hii.setGravity(aVar.gravity);
        this.hii.setPadding(d(aVar.oOg, context), d(aVar.oOh, context), d(aVar.oOi, context), d(aVar.oOj, context));
        this.hii.setTextSize(aVar.oOk);
        GradientDrawable gradientDrawable = (GradientDrawable) this.hii.getBackground();
        gradientDrawable.setCornerRadius(d(aVar.oOl, context));
        this.hii.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oOm);
        if (aVar.oOn) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oNZ, 0, this.oOa, this.oOb);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int d(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
