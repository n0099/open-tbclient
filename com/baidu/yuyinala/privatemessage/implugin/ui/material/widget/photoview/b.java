package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d otp;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.otp = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.otp == null) {
            return false;
        }
        ImageView edv = this.otp.edv();
        if (this.otp.getOnPhotoTapListener() != null && (displayRect = this.otp.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.otp.getOnPhotoTapListener().d(edv, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.otp.getOnViewTapListener() != null) {
            this.otp.getOnViewTapListener().e(edv, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.otp == null) {
            return false;
        }
        try {
            float scale = this.otp.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.otp.getMediumScale()) {
                this.otp.setScale(this.otp.getMediumScale(), x, y, true);
            } else if (scale >= this.otp.getMediumScale() && scale < this.otp.getMaximumScale()) {
                this.otp.setScale(this.otp.getMaximumScale(), x, y, true);
            } else {
                this.otp.setScale(this.otp.getMinimumScale(), x, y, true);
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
