package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oUX;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oUX = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oUX == null) {
            return false;
        }
        ImageView ejg = this.oUX.ejg();
        if (this.oUX.getOnPhotoTapListener() != null && (displayRect = this.oUX.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oUX.getOnPhotoTapListener().d(ejg, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oUX.getOnViewTapListener() != null) {
            this.oUX.getOnViewTapListener().e(ejg, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oUX == null) {
            return false;
        }
        try {
            float scale = this.oUX.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oUX.getMediumScale()) {
                this.oUX.setScale(this.oUX.getMediumScale(), x, y, true);
            } else if (scale >= this.oUX.getMediumScale() && scale < this.oUX.getMaximumScale()) {
                this.oUX.setScale(this.oUX.getMaximumScale(), x, y, true);
            } else {
                this.oUX.setScale(this.oUX.getMinimumScale(), x, y, true);
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
