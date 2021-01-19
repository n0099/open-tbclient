package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oUY;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oUY = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oUY == null) {
            return false;
        }
        ImageView ejg = this.oUY.ejg();
        if (this.oUY.getOnPhotoTapListener() != null && (displayRect = this.oUY.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oUY.getOnPhotoTapListener().d(ejg, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oUY.getOnViewTapListener() != null) {
            this.oUY.getOnViewTapListener().e(ejg, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oUY == null) {
            return false;
        }
        try {
            float scale = this.oUY.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oUY.getMediumScale()) {
                this.oUY.setScale(this.oUY.getMediumScale(), x, y, true);
            } else if (scale >= this.oUY.getMediumScale() && scale < this.oUY.getMaximumScale()) {
                this.oUY.setScale(this.oUY.getMaximumScale(), x, y, true);
            } else {
                this.oUY.setScale(this.oUY.getMinimumScale(), x, y, true);
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
