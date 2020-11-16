package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oEm;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oEm = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oEm == null) {
            return false;
        }
        ImageView ehi = this.oEm.ehi();
        if (this.oEm.getOnPhotoTapListener() != null && (displayRect = this.oEm.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oEm.getOnPhotoTapListener().d(ehi, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oEm.getOnViewTapListener() != null) {
            this.oEm.getOnViewTapListener().e(ehi, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oEm == null) {
            return false;
        }
        try {
            float scale = this.oEm.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oEm.getMediumScale()) {
                this.oEm.setScale(this.oEm.getMediumScale(), x, y, true);
            } else if (scale >= this.oEm.getMediumScale() && scale < this.oEm.getMaximumScale()) {
                this.oEm.setScale(this.oEm.getMaximumScale(), x, y, true);
            } else {
                this.oEm.setScale(this.oEm.getMinimumScale(), x, y, true);
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
