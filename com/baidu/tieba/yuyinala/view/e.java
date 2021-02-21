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
    private final TextView hiw;
    private final ImageView iuP;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final int oOA;
    private final int oOB;
    private final View oOz;

    /* loaded from: classes11.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oOD = 0.0f;
        private float oOE = 9.0f;
        private float oOF = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oOG = 5.0f;
        private float oOH = 5.0f;
        private float oOI = 5.0f;
        private float oOJ = 5.0f;
        private float oOK = 11.0f;
        private float oOL = 2.0f;
        private boolean oOM = true;
        private boolean oON = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bp(float f) {
            this.width = e.d(f, this.context);
            return this;
        }

        public a bq(float f) {
            this.oOD = f;
            return this;
        }

        public a br(float f) {
            this.oOE = f;
            return this;
        }

        public a bs(float f) {
            this.oOF = f;
            return this;
        }

        public a y(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a MH(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.oOG = f;
            this.oOH = f2;
            this.oOI = f3;
            this.oOJ = f4;
            return this;
        }

        public a bt(float f) {
            return h(f, f, f, f);
        }

        public a bu(float f) {
            this.oOK = f;
            return this;
        }

        public a bv(float f) {
            this.oOL = f;
            return this;
        }

        public a Ar(boolean z) {
            this.oOM = z;
            return this;
        }

        public a As(boolean z) {
            this.oON = z;
            return this;
        }

        public e efS() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oOz = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oOz.getLocationInWindow(iArr);
        int width = this.oOz.getWidth();
        int height = this.oOz.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oOA = ((width / 2) + i) - d(aVar.oOD, context);
        this.oOB = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.iuP = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.hiw = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuP.getLayoutParams();
        layoutParams.width = d(aVar.oOE, context);
        layoutParams.height = d(aVar.oOF, context);
        layoutParams.leftMargin = d(aVar.oOD, context) - (d(aVar.oOE, context) / 2);
        this.iuP.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hiw.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.hiw.setLayoutParams(layoutParams2);
        this.hiw.setText(aVar.text);
        this.hiw.setGravity(aVar.gravity);
        this.hiw.setPadding(d(aVar.oOG, context), d(aVar.oOH, context), d(aVar.oOI, context), d(aVar.oOJ, context));
        this.hiw.setTextSize(aVar.oOK);
        GradientDrawable gradientDrawable = (GradientDrawable) this.hiw.getBackground();
        gradientDrawable.setCornerRadius(d(aVar.oOL, context));
        this.hiw.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oOM);
        if (aVar.oON) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oOz, 0, this.oOA, this.oOB);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int d(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
