package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oCI;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oCI = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oCI == null) {
            return false;
        }
        ImageView ehk = this.oCI.ehk();
        if (this.oCI.getOnPhotoTapListener() != null && (displayRect = this.oCI.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oCI.getOnPhotoTapListener().d(ehk, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oCI.getOnViewTapListener() != null) {
            this.oCI.getOnViewTapListener().e(ehk, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oCI == null) {
            return false;
        }
        try {
            float scale = this.oCI.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oCI.getMediumScale()) {
                this.oCI.setScale(this.oCI.getMediumScale(), x, y, true);
            } else if (scale >= this.oCI.getMediumScale() && scale < this.oCI.getMaximumScale()) {
                this.oCI.setScale(this.oCI.getMaximumScale(), x, y, true);
            } else {
                this.oCI.setScale(this.oCI.getMinimumScale(), x, y, true);
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
