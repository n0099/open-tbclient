package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oZz;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oZz = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oZz == null) {
            return false;
        }
        ImageView ena = this.oZz.ena();
        if (this.oZz.getOnPhotoTapListener() != null && (displayRect = this.oZz.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oZz.getOnPhotoTapListener().d(ena, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oZz.getOnViewTapListener() != null) {
            this.oZz.getOnViewTapListener().e(ena, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oZz == null) {
            return false;
        }
        try {
            float scale = this.oZz.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oZz.getMediumScale()) {
                this.oZz.setScale(this.oZz.getMediumScale(), x, y, true);
            } else if (scale >= this.oZz.getMediumScale() && scale < this.oZz.getMaximumScale()) {
                this.oZz.setScale(this.oZz.getMaximumScale(), x, y, true);
            } else {
                this.oZz.setScale(this.oZz.getMinimumScale(), x, y, true);
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
