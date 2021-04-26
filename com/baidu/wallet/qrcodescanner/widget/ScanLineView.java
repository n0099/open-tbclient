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
    public static float f27279d = 50.0f;

    /* renamed from: e  reason: collision with root package name */
    public static int f27280e = 1800;

    /* renamed from: f  reason: collision with root package name */
    public static float f27281f = 50.0f;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f27282a;

    /* renamed from: b  reason: collision with root package name */
    public a f27283b;

    /* renamed from: c  reason: collision with root package name */
    public int f27284c;

    /* renamed from: g  reason: collision with root package name */
    public int f27285g;

    /* loaded from: classes5.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public boolean f27286a = true;

        public a() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            int i2;
            int i3;
            int left = ScanLineView.this.f27282a.getLeft();
            int top = ScanLineView.this.f27282a.getTop();
            int right = ScanLineView.this.f27282a.getRight();
            int bottom = ScanLineView.this.f27282a.getBottom();
            ScanLineView.this.f27282a.getWidth();
            ScanLineView.this.f27282a.getHeight();
            if (this.f27286a) {
                ScanLineView.this.f27282a.setBackgroundResource(ResUtils.drawable(ScanLineView.this.getContext(), "wallet_qrscanner_line_down"));
                i2 = top + ScanLineView.this.f27284c;
                i3 = bottom + ScanLineView.this.f27284c;
            } else {
                ScanLineView.this.f27282a.setBackgroundResource(ResUtils.drawable(ScanLineView.this.getContext(), "wallet_qrscanner_line_up"));
                i2 = top - ScanLineView.this.f27284c;
                i3 = bottom - ScanLineView.this.f27284c;
            }
            int i4 = 0;
            if (i3 < 0) {
                i2 = -ScanLineView.this.f27282a.getHeight();
                this.f27286a = true;
                i3 = 0;
            }
            if (i2 > ScanLineView.this.getHeight()) {
                i2 = -ScanLineView.this.f27282a.getHeight();
                this.f27286a = true;
            } else {
                i4 = i3;
            }
            ScanLineView.this.f27282a.layout(left, i2, right, i4);
            removeCallbacksAndMessages(null);
            sendEmptyMessageDelayed(1, ScanLineView.this.f27285g);
            super.dispatchMessage(message);
        }
    }

    public ScanLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27284c = 1;
        this.f27285g = (int) (f27280e / f27281f);
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
        this.f27284c = (int) ((getMeasuredHeight() + DisplayUtils.dip2px(getContext(), 100.0f)) / f27279d);
    }

    public void start() {
        if (this.f27283b == null) {
            this.f27283b = new a();
        }
        this.f27283b.removeCallbacksAndMessages(null);
        this.f27283b.sendEmptyMessageDelayed(1, 1000L);
    }

    public void stop() {
        if (this.f27283b == null) {
            this.f27283b = new a();
        }
        this.f27283b.removeCallbacksAndMessages(null);
    }

    private void a() {
        ImageView imageView = new ImageView(getContext());
        this.f27282a = imageView;
        imageView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_line_down"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 100.0f));
        layoutParams.topMargin = -DisplayUtils.dip2px(getContext(), 100.0f);
        addView(this.f27282a, layoutParams);
    }

    public ScanLineView(Context context) {
        super(context);
        this.f27284c = 1;
        this.f27285g = (int) (f27280e / f27281f);
        a();
    }
}
