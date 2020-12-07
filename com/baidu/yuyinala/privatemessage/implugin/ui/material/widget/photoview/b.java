package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oTs;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oTs = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oTs == null) {
            return false;
        }
        ImageView emW = this.oTs.emW();
        if (this.oTs.getOnPhotoTapListener() != null && (displayRect = this.oTs.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oTs.getOnPhotoTapListener().d(emW, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oTs.getOnViewTapListener() != null) {
            this.oTs.getOnViewTapListener().e(emW, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oTs == null) {
            return false;
        }
        try {
            float scale = this.oTs.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oTs.getMediumScale()) {
                this.oTs.setScale(this.oTs.getMediumScale(), x, y, true);
            } else if (scale >= this.oTs.getMediumScale() && scale < this.oTs.getMaximumScale()) {
                this.oTs.setScale(this.oTs.getMaximumScale(), x, y, true);
            } else {
                this.oTs.setScale(this.oTs.getMinimumScale(), x, y, true);
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
