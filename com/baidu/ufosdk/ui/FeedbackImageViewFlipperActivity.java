package com.baidu.ufosdk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.core.view.ViewCompat;
/* loaded from: classes7.dex */
public class FeedbackImageViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f5412a;

    /* renamed from: b  reason: collision with root package name */
    private ViewFlipper f5413b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setFitsSystemWindows(true);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f5413b = new ViewFlipper(this);
        linearLayout.addView(this.f5413b, layoutParams);
        setContentView(linearLayout);
        this.f5412a = new GestureDetector(this);
        ImageView imageView = new ImageView(this);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(FeedbackInputActivity.f5414a);
        this.f5413b.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        this.f5413b.setAutoStart(false);
        this.f5413b.setFlipInterval(3000);
        if (!this.f5413b.isAutoStart() || this.f5413b.isFlipping()) {
            return;
        }
        this.f5413b.startFlipping();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FeedbackInputActivity.f5414a = null;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        finish();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        finish();
        return false;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f5413b.stopFlipping();
        this.f5413b.setAutoStart(false);
        return this.f5412a.onTouchEvent(motionEvent);
    }
}
