package com.baidu.wallet.qrcodescanner.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
/* loaded from: classes5.dex */
public class ScanLineView extends FrameLayout {

    /* renamed from: d  reason: collision with root package name */
    public static float f26453d = 50.0f;

    /* renamed from: e  reason: collision with root package name */
    public static int f26454e = 1800;

    /* renamed from: f  reason: collision with root package name */
    public static float f26455f = 50.0f;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f26456a;

    /* renamed from: b  reason: collision with root package name */
    public a f26457b;

    /* renamed from: c  reason: collision with root package name */
    public int f26458c;

    /* renamed from: g  reason: collision with root package name */
    public int f26459g;

    /* loaded from: classes5.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26460a = true;

        public a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            int i2;
            int i3;
            int left = ScanLineView.this.f26456a.getLeft();
            int top = ScanLineView.this.f26456a.getTop();
            int right = ScanLineView.this.f26456a.getRight();
            int bottom = ScanLineView.this.f26456a.getBottom();
            ScanLineView.this.f26456a.getWidth();
            ScanLineView.this.f26456a.getHeight();
            if (this.f26460a) {
                ScanLineView.this.f26456a.setBackgroundResource(ResUtils.drawable(ScanLineView.this.getContext(), "wallet_qrscanner_line_down"));
                i2 = top + ScanLineView.this.f26458c;
                i3 = bottom + ScanLineView.this.f26458c;
            } else {
                ScanLineView.this.f26456a.setBackgroundResource(ResUtils.drawable(ScanLineView.this.getContext(), "wallet_qrscanner_line_up"));
                i2 = top - ScanLineView.this.f26458c;
                i3 = bottom - ScanLineView.this.f26458c;
            }
            int i4 = 0;
            if (i3 < 0) {
                i2 = -ScanLineView.this.f26456a.getHeight();
                this.f26460a = true;
                i3 = 0;
            }
            if (i2 > ScanLineView.this.getHeight()) {
                i2 = -ScanLineView.this.f26456a.getHeight();
                this.f26460a = true;
            } else {
                i4 = i3;
            }
            ScanLineView.this.f26456a.layout(left, i2, right, i4);
            removeCallbacksAndMessages(null);
            sendEmptyMessageDelayed(1, ScanLineView.this.f26459g);
            super.dispatchMessage(message);
        }
    }

    public ScanLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26458c = 1;
        this.f26459g = (int) (f26454e / f26455f);
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        Rect rect = new Rect();
        rect.left = i2;
        rect.top = i3;
        rect.right = i4;
        rect.bottom = i5;
        if (getContext() instanceof QRScanCodeActivity) {
            ((QRScanCodeActivity) getContext()).relayoutUi(rect);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f26458c = (int) ((getMeasuredHeight() + DisplayUtils.dip2px(getContext(), 100.0f)) / f26453d);
    }

    public void start() {
        if (this.f26457b == null) {
            this.f26457b = new a();
        }
        this.f26457b.removeCallbacksAndMessages(null);
        this.f26457b.sendEmptyMessageDelayed(1, 1000L);
    }

    public void stop() {
        if (this.f26457b == null) {
            this.f26457b = new a();
        }
        this.f26457b.removeCallbacksAndMessages(null);
    }

    private void a() {
        ImageView imageView = new ImageView(getContext());
        this.f26456a = imageView;
        imageView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_line_down"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 100.0f));
        layoutParams.topMargin = -DisplayUtils.dip2px(getContext(), 100.0f);
        addView(this.f26456a, layoutParams);
    }

    public ScanLineView(Context context) {
        super(context);
        this.f26458c = 1;
        this.f26459g = (int) (f26454e / f26455f);
        a();
    }
}
