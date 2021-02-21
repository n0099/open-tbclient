package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d pfL;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.pfL = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.pfL == null) {
            return false;
        }
        ImageView elI = this.pfL.elI();
        if (this.pfL.getOnPhotoTapListener() != null && (displayRect = this.pfL.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.pfL.getOnPhotoTapListener().d(elI, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.pfL.getOnViewTapListener() != null) {
            this.pfL.getOnViewTapListener().e(elI, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.pfL == null) {
            return false;
        }
        try {
            float scale = this.pfL.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.pfL.getMediumScale()) {
                this.pfL.setScale(this.pfL.getMediumScale(), x, y, true);
            } else if (scale >= this.pfL.getMediumScale() && scale < this.pfL.getMaximumScale()) {
                this.pfL.setScale(this.pfL.getMaximumScale(), x, y, true);
            } else {
                this.pfL.setScale(this.pfL.getMinimumScale(), x, y, true);
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
