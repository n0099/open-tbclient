package com.baidu.ufosdk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import com.baidu.ufosdk.ResumeCallBack;
/* loaded from: classes5.dex */
public class FeedbackImageViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public GestureDetector f22658a;

    /* renamed from: b  reason: collision with root package name */
    public ViewFlipper f22659b;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
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
        linearLayout.setBackgroundColor(-16777216);
        ViewFlipper viewFlipper = new ViewFlipper(this);
        this.f22659b = viewFlipper;
        linearLayout.addView(viewFlipper, layoutParams);
        setContentView(linearLayout);
        this.f22658a = new GestureDetector(this);
        ImageView imageView = new ImageView(this);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(FeedbackInputActivity.f22660a);
        this.f22659b.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        this.f22659b.setAutoStart(false);
        this.f22659b.setFlipInterval(3000);
        if (!this.f22659b.isAutoStart() || this.f22659b.isFlipping()) {
            return;
        }
        this.f22659b.startFlipping();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FeedbackInputActivity.f22660a = null;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        finish();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ResumeCallBack resumeCallBack = com.baidu.ufosdk.b.ac;
        if (resumeCallBack != null) {
            resumeCallBack.onResumeCallback();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
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
        this.f22659b.stopFlipping();
        this.f22659b.setAutoStart(false);
        return this.f22658a.onTouchEvent(motionEvent);
    }
}
