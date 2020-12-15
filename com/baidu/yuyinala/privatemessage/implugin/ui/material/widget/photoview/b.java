package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b implements GestureDetector.OnDoubleTapListener {
    private d oTu;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.oTu = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        if (this.oTu == null) {
            return false;
        }
        ImageView emX = this.oTu.emX();
        if (this.oTu.getOnPhotoTapListener() != null && (displayRect = this.oTu.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.width() > 0.0f && displayRect.height() > 0.0f && displayRect.contains(x, y)) {
                this.oTu.getOnPhotoTapListener().d(emX, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.oTu.getOnViewTapListener() != null) {
            this.oTu.getOnViewTapListener().e(emX, motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.oTu == null) {
            return false;
        }
        try {
            float scale = this.oTu.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.oTu.getMediumScale()) {
                this.oTu.setScale(this.oTu.getMediumScale(), x, y, true);
            } else if (scale >= this.oTu.getMediumScale() && scale < this.oTu.getMaximumScale()) {
                this.oTu.setScale(this.oTu.getMaximumScale(), x, y, true);
            } else {
                this.oTu.setScale(this.oTu.getMinimumScale(), x, y, true);
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
