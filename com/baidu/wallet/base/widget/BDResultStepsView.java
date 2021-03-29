package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class BDResultStepsView extends LinearLayout {
    public static final int FAIL_2_STATE = 6;
    public static final int FAIL_3_STATE = 4;
    public static final int INIT_STATE = 0;
    public static final int MIDDLE_2_STATE = 5;
    public static final int NODE3_SUCCESS1_STATE = 17;
    public static final int NODE3_SUCCESS3_STATE = 18;
    public static final int SUCCESS_2_STATE = 2;
    public static final int SUCCESS_3_STATE = 3;

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f23705a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23706b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23707c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23708d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f23709e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23710f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f23711g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23712h;
    public TextView i;
    public TextView j;
    public TextView k;
    public LinearLayout mRootLayout;
    public ImageView mStep1Image;
    public ImageView mStep2Image;
    public ImageView mStep3Image;
    public int state;

    public BDResultStepsView(Context context) {
        super(context);
        this.state = 0;
        Context applicationContext = context.getApplicationContext();
        this.f23706b = applicationContext;
        this.f23705a = LayoutInflater.from(applicationContext);
        a();
    }

    private void a(Canvas canvas, String str) {
        a(this.mStep1Image.getWidth() + a(this.mStep1Image), b(this.mStep1Image) + (this.mStep1Image.getHeight() / 2), a(this.mStep2Image), b(this.mStep2Image) + (this.mStep2Image.getHeight() / 2), canvas, str);
    }

    private void b(Canvas canvas, String str) {
        a(this.mStep2Image.getWidth() + a(this.mStep2Image), b(this.mStep2Image) + (this.mStep2Image.getHeight() / 2), a(this.mStep3Image), b(this.mStep3Image) + (this.mStep3Image.getHeight() / 2), canvas, str);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public void dispatchDraw(Canvas canvas) {
        ImageView imageView;
        super.dispatchDraw(canvas);
        int right = (((this.mRootLayout.getRight() - this.mRootLayout.getLeft()) / 2) - (this.mStep2Image.getWidth() / 2)) + this.mRootLayout.getLeft();
        int i = this.state;
        if (i == 0) {
            if (this.mStep1Image == null || this.mStep2Image == null || this.mStep3Image == null) {
                return;
            }
            a(imageView.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), right, this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), canvas, "wallet_base_mainColor1");
            a(right + this.mStep2Image.getWidth(), this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "wallet_base_separate2Color1");
        } else if (i == 2) {
            a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "wallet_base_mainColor1");
        } else if (i == 3) {
            a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), right, this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), canvas, "wallet_base_mainColor1");
            a(right + this.mStep2Image.getWidth(), this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "wallet_base_mainColor1");
        } else if (i == 4) {
            a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), right, this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), canvas, "wallet_base_mainColor1");
            a(right + this.mStep2Image.getWidth(), this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "wallet_base_separate2Color1");
        } else if (i == 5) {
            int left = this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft();
            int top = this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2);
            int right2 = this.mRootLayout.getRight() - this.mStep3Image.getWidth();
            float f2 = left;
            float f3 = top;
            float f4 = left + ((right2 - left) / 2);
            float height = this.mStep3Image.getHeight() / 2;
            a(f2, f3, f4, height, canvas, "wallet_base_separate2Color1");
            a(f4, f3, right2, height, canvas, "wallet_base_separate2Color1");
        } else if (i == 6) {
            a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "wallet_base_separate2Color1");
        } else if (i == 17) {
            this.mStep2Image.setImageResource(ResUtils.drawable(this.f23706b, "wallet_base_result_time_axis_wait"));
            a(canvas, "wallet_base_separate2Color1");
            b(canvas, "wallet_base_separate2Color1");
        } else if (i != 18) {
        } else {
            this.mStep3Image.setImageResource(ResUtils.drawable(this.f23706b, "wallet_base_result_time_axis_check_1"));
            a(canvas, "wallet_base_mainColor1");
            b(canvas, "wallet_base_mainColor1");
        }
    }

    public LinearLayout getmStep2Layout() {
        return this.f23710f;
    }

    public TextView getmTips1() {
        return this.f23707c;
    }

    public TextView getmTips2() {
        return this.f23708d;
    }

    public TextView getmTips3() {
        return this.f23712h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        super.onAttachedToWindow();
        ImageView imageView = this.mStep1Image;
        if (imageView == null || this.mStep2Image == null || this.mStep3Image == null) {
            return;
        }
        imageView.getLocationOnScreen(iArr);
        this.mStep2Image.getLocationOnScreen(iArr2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"NewApi"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setStepTips(String str, String str2, String str3) {
        TextView textView = this.f23707c;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f23708d;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.f23712h;
        if (textView3 != null) {
            textView3.setText(str3);
        }
    }

    public void setStepTipsTime(String str, String str2, String str3) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setText(str3);
        }
    }

    public BDResultStepsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = 0;
        Context applicationContext = context.getApplicationContext();
        this.f23706b = applicationContext;
        this.f23705a = LayoutInflater.from(applicationContext);
        a();
    }

    private int a(View view) {
        int left;
        int left2;
        if (view == null) {
            return 0;
        }
        ImageView imageView = this.mStep1Image;
        if (view == imageView) {
            left = imageView.getLeft() + this.f23709e.getLeft();
            left2 = this.mRootLayout.getLeft();
        } else {
            ImageView imageView2 = this.mStep2Image;
            if (view == imageView2) {
                left = imageView2.getLeft() + this.f23710f.getLeft();
                left2 = this.mRootLayout.getLeft();
            } else {
                ImageView imageView3 = this.mStep3Image;
                if (view != imageView3) {
                    return 0;
                }
                left = imageView3.getLeft() + this.f23711g.getLeft();
                left2 = this.mRootLayout.getLeft();
            }
        }
        return left2 + left;
    }

    private int b(View view) {
        int top;
        int top2;
        if (view == null) {
            return 0;
        }
        ImageView imageView = this.mStep1Image;
        if (view == imageView) {
            top = imageView.getTop() + this.f23709e.getTop();
            top2 = this.mRootLayout.getTop();
        } else {
            ImageView imageView2 = this.mStep2Image;
            if (view == imageView2) {
                top = imageView2.getTop() + this.f23710f.getTop();
                top2 = this.mRootLayout.getTop();
            } else {
                ImageView imageView3 = this.mStep3Image;
                if (view != imageView3) {
                    return 0;
                }
                top = imageView3.getTop() + this.f23711g.getTop();
                top2 = this.mRootLayout.getTop();
            }
        }
        return top2 + top;
    }

    private void a() {
        this.f23705a.inflate(ResUtils.layout(this.f23706b, "wallet_base_result_step_layout"), this);
        this.mRootLayout = (LinearLayout) findViewById(ResUtils.id(this.f23706b, "root_layout"));
        this.mStep1Image = (ImageView) findViewById(ResUtils.id(this.f23706b, "step_image_1"));
        this.mStep2Image = (ImageView) findViewById(ResUtils.id(this.f23706b, "step_image_2"));
        this.mStep3Image = (ImageView) findViewById(ResUtils.id(this.f23706b, "step_image_3"));
        this.f23707c = (TextView) findViewById(ResUtils.id(this.f23706b, "step1_tips"));
        this.f23708d = (TextView) findViewById(ResUtils.id(this.f23706b, "step2_tips"));
        this.f23712h = (TextView) findViewById(ResUtils.id(this.f23706b, "step3_tips"));
        this.i = (TextView) findViewById(ResUtils.id(this.f23706b, "step1_tips_time"));
        this.j = (TextView) findViewById(ResUtils.id(this.f23706b, "step2_tips_time"));
        this.k = (TextView) findViewById(ResUtils.id(this.f23706b, "step3_tips_time"));
        this.f23710f = (LinearLayout) findViewById(ResUtils.id(this.f23706b, "step_2_layout"));
        this.f23709e = (LinearLayout) findViewById(ResUtils.id(this.f23706b, "step_1_layout"));
        this.f23711g = (LinearLayout) findViewById(ResUtils.id(this.f23706b, "step_3_layout"));
    }

    private void a(float f2, float f3, float f4, float f5, Canvas canvas, String str) {
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        paint.setColor(getContext().getResources().getColor(ResUtils.color(getContext(), str)));
        if (canvas == null) {
            return;
        }
        canvas.drawLine(f2, f3, f4, f5, paint);
    }
}
