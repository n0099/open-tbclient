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
    private final TextView hig;
    private final ImageView itE;
    private final LinearLayout mContentView;
    private final PopupWindow mPopupWindow;
    private final View oIu;
    private final int oIv;
    private final int oIw;

    /* loaded from: classes11.dex */
    public static final class a {
        private final View attachedView;
        private final Context context;
        private int width = -2;
        private int height = -2;
        private float oIy = 0.0f;
        private float oIz = 9.0f;
        private float oIA = 4.0f;
        @Nullable
        private CharSequence text = null;
        private int gravity = 16;
        private float oIB = 5.0f;
        private float oIC = 5.0f;
        private float oID = 5.0f;
        private float oIE = 5.0f;
        private float oIF = 11.0f;
        private float oIG = 2.0f;
        private boolean oIH = true;
        private boolean oII = true;

        public a(@NonNull View view) {
            this.attachedView = view;
            this.context = this.attachedView.getContext();
        }

        public a bm(float f) {
            this.width = e.c(f, this.context);
            return this;
        }

        public a bn(float f) {
            this.oIy = f;
            return this;
        }

        public a bo(float f) {
            this.oIz = f;
            return this;
        }

        public a bp(float f) {
            this.oIA = f;
            return this;
        }

        public a x(@Nullable CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public a NR(int i) {
            this.gravity = i;
            return this;
        }

        public a h(float f, float f2, float f3, float f4) {
            this.oIB = f;
            this.oIC = f2;
            this.oID = f3;
            this.oIE = f4;
            return this;
        }

        public a bq(float f) {
            return h(f, f, f, f);
        }

        public a br(float f) {
            this.oIF = f;
            return this;
        }

        public a bs(float f) {
            this.oIG = f;
            return this;
        }

        public a Ac(boolean z) {
            this.oIH = z;
            return this;
        }

        public a Ad(boolean z) {
            this.oII = z;
            return this;
        }

        public e ehj() {
            return new e(this);
        }
    }

    private e(@NonNull a aVar) {
        this.oIu = aVar.attachedView;
        Context context = aVar.context;
        int[] iArr = new int[2];
        this.oIu.getLocationInWindow(iArr);
        int width = this.oIu.getWidth();
        int height = this.oIu.getHeight();
        int i = iArr[0];
        int i2 = iArr[1];
        this.oIv = ((width / 2) + i) - c(aVar.oIy, context);
        this.oIw = i2 + height;
        this.mContentView = (LinearLayout) LayoutInflater.from(context).inflate(a.g.yuyin_component_popup_layout, (ViewGroup) null);
        this.itE = (ImageView) this.mContentView.findViewById(a.f.iv_arrow);
        this.hig = (TextView) this.mContentView.findViewById(a.f.tv_content);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.itE.getLayoutParams();
        layoutParams.width = c(aVar.oIz, context);
        layoutParams.height = c(aVar.oIA, context);
        layoutParams.leftMargin = c(aVar.oIy, context) - (c(aVar.oIz, context) / 2);
        this.itE.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hig.getLayoutParams();
        layoutParams2.width = aVar.width;
        layoutParams2.height = aVar.height;
        this.hig.setLayoutParams(layoutParams2);
        this.hig.setText(aVar.text);
        this.hig.setGravity(aVar.gravity);
        this.hig.setPadding(c(aVar.oIB, context), c(aVar.oIC, context), c(aVar.oID, context), c(aVar.oIE, context));
        this.hig.setTextSize(aVar.oIF);
        GradientDrawable gradientDrawable = (GradientDrawable) this.hig.getBackground();
        gradientDrawable.setCornerRadius(c(aVar.oIG, context));
        this.hig.setBackground(gradientDrawable);
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setContentView(this.mContentView);
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setOutsideTouchable(aVar.oIH);
        if (aVar.oII) {
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mPopupWindow.dismiss();
                }
            });
        }
    }

    public void show() {
        this.mPopupWindow.showAtLocation(this.oIu, 0, this.oIv, this.oIw);
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    protected static int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
