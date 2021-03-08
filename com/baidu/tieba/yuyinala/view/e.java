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
    private final TextView hkf;
    private final ImageView iwy;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oQE;
    private final int oQF;
    private final int oQG;

    /* loaded from: classes10.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oQI = 0.0f;
        private float oQJ = 9.0f;
        private float oQK = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oQL = 5.0f;
        private float oQM = 5.0f;
        private float oQN = 5.0f;
        private float oQO = 5.0f;
        private float oQP = 11.0f;
        private float oQQ = 2.0f;
        private boolean oQR = true;
        private boolean oQS = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bt(float f) {
            this.width = e.d(f, this.context);
            return this;
        }

        public a bu(float f) {
            this.oQI = f;
            return this;
        }

        public a bv(float f) {
            this.oQJ = f;
            return this;
        }

        public a bw(float f) {
            this.oQK = f;
            return this;
        }

        public a y(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a ML(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.oQL = f;
            this.oQM = f2;
            this.oQN = f3;
            this.oQO = f4;
            return this;
        }

        public a bx(float f) {
            return h(f, f, f, f);
        }

        public a by(float f) {
            this.oQP = f;
            return this;
        }

        public a bz(float f) {
            this.oQQ = f;
            return this;
        }

        public a Aq(boolean z) {
            this.oQR = z;
            return this;
        }

        public a Ar(boolean z) {
            this.oQS = z;
            return this;
        }

        public e ega() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oQE = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oQE.getLocationInWindow(iArr);
        int width = this.oQE.getWidth();
        int height = this.oQE.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oQF = ((width / 2) + i) - d(aVar.oQI, context);
        this.oQG = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.iwy = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.hkf = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwy.getLayoutParams();
        layoutParams.width = d(aVar.oQJ, context);
        layoutParams.height = d(aVar.oQK, context);
        layoutParams.leftMargin = d(aVar.oQI, context) - (d(aVar.oQJ, context) / 2);
        this.iwy.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hkf.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.hkf.setLayoutParams(layoutParams2);
        this.hkf.setText(aVar.text);
        this.hkf.setGravity(aVar.gravity);
        this.hkf.setPadding(d(aVar.oQL, context), d(aVar.oQM, context), d(aVar.oQN, context), d(aVar.oQO, context));
        this.hkf.setTextSize(aVar.oQP);
        GradientDrawable gradientDrawable = (GradientDrawable) this.hkf.getBackground();
        gradientDrawable.setCornerRadius(d(aVar.oQQ, context));
        this.hkf.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oQR);
        if (aVar.oQS) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oQE, 0, this.oQF, this.oQG);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int d(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
