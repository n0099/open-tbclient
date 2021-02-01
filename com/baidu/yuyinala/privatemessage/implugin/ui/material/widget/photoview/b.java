package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d pfl;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.pfl = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.pfl == null) {
            return false;
        }
        ImageView elA = this.pfl.elA();
        if (this.pfl.getOnPhotoTapListener() != null && (displayRect = this.pfl.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.pfl.getOnPhotoTapListener().d(elA, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.pfl.getOnViewTapListener() != null) {
            this.pfl.getOnViewTapListener().e(elA, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.pfl == null) {
            return false;
        }
        try {
            float scale = this.pfl.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.pfl.getMediumScale()) {
                this.pfl.setScale(this.pfl.getMediumScale(), x, y, true);
            } else if (scale >= this.pfl.getMediumScale() && scale < this.pfl.getMaximumScale()) {
                this.pfl.setScale(this.pfl.getMaximumScale(), x, y, true);
            } else {
                this.pfl.setScale(this.pfl.getMinimumScale(), x, y, true);
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
