package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d phQ;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.phQ = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.phQ == null) {
            return false;
        }
        ImageView elS = this.phQ.elS();
        if (this.phQ.getOnPhotoTapListener() != null && (displayRect = this.phQ.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.phQ.getOnPhotoTapListener().d(elS, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.phQ.getOnViewTapListener() != null) {
            this.phQ.getOnViewTapListener().e(elS, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.phQ == null) {
            return false;
        }
        try {
            float scale = this.phQ.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.phQ.getMediumScale()) {
                this.phQ.setScale(this.phQ.getMediumScale(), x, y, true);
            } else if (scale >= this.phQ.getMediumScale() && scale < this.phQ.getMaximumScale()) {
                this.phQ.setScale(this.phQ.getMaximumScale(), x, y, true);
            } else {
                this.phQ.setScale(this.phQ.getMinimumScale(), x, y, true);
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
