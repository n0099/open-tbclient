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
    public static float f26472d = 50.0f;

    /* renamed from: e  reason: collision with root package name */
    public static int f26473e = 1800;

    /* renamed from: f  reason: collision with root package name */
    public static float f26474f = 50.0f;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f26475a;

    /* renamed from: b  reason: collision with root package name */
    public a f26476b;

    /* renamed from: c  reason: collision with root package name */
    public int f26477c;

    /* renamed from: g  reason: collision with root package name */
    public int f26478g;

    /* loaded from: classes5.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26479a = true;

        public a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            int i;
            int i2;
            int left = ScanLineView.this.f26475a.getLeft();
            int top = ScanLineView.this.f26475a.getTop();
            int right = ScanLineView.this.f26475a.getRight();
            int bottom = ScanLineView.this.f26475a.getBottom();
            ScanLineView.this.f26475a.getWidth();
            ScanLineView.this.f26475a.getHeight();
            if (this.f26479a) {
                ScanLineView.this.f26475a.setBackgroundResource(ResUtils.drawable(ScanLineView.this.getContext(), "wallet_qrscanner_line_down"));
                i = top + ScanLineView.this.f26477c;
                i2 = bottom + ScanLineView.this.f26477c;
            } else {
                ScanLineView.this.f26475a.setBackgroundResource(ResUtils.drawable(ScanLineView.this.getContext(), "wallet_qrscanner_line_up"));
                i = top - ScanLineView.this.f26477c;
                i2 = bottom - ScanLineView.this.f26477c;
            }
            int i3 = 0;
            if (i2 < 0) {
                i = -ScanLineView.this.f26475a.getHeight();
                this.f26479a = true;
                i2 = 0;
            }
            if (i > ScanLineView.this.getHeight()) {
                i = -ScanLineView.this.f26475a.getHeight();
                this.f26479a = true;
            } else {
                i3 = i2;
            }
            ScanLineView.this.f26475a.layout(left, i, right, i3);
            removeCallbacksAndMessages(null);
            sendEmptyMessageDelayed(1, ScanLineView.this.f26478g);
            super.dispatchMessage(message);
        }
    }

    public ScanLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26477c = 1;
        this.f26478g = (int) (f26473e / f26474f);
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Rect rect = new Rect();
        rect.left = i;
        rect.top = i2;
        rect.right = i3;
        rect.bottom = i4;
        if (getContext() instanceof QRScanCodeActivity) {
            ((QRScanCodeActivity) getContext()).relayoutUi(rect);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f26477c = (int) ((getMeasuredHeight() + DisplayUtils.dip2px(getContext(), 100.0f)) / f26472d);
    }

    public void start() {
        if (this.f26476b == null) {
            this.f26476b = new a();
        }
        this.f26476b.removeCallbacksAndMessages(null);
        this.f26476b.sendEmptyMessageDelayed(1, 1000L);
    }

    public void stop() {
        if (this.f26476b == null) {
            this.f26476b = new a();
        }
        this.f26476b.removeCallbacksAndMessages(null);
    }

    private void a() {
        ImageView imageView = new ImageView(getContext());
        this.f26475a = imageView;
        imageView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_line_down"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 100.0f));
        layoutParams.topMargin = -DisplayUtils.dip2px(getContext(), 100.0f);
        addView(this.f26475a, layoutParams);
    }

    public ScanLineView(Context context) {
        super(context);
        this.f26477c = 1;
        this.f26478g = (int) (f26473e / f26474f);
        a();
    }
}
