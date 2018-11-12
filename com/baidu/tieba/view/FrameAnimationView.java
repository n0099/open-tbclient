package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class FrameAnimationView extends TbImageView {
    private Rect aYm;
    private Bitmap cgn;
    private Rect cgo;
    private int hFY;
    private boolean hFZ;
    private Runnable hGa;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.aYm = new Rect();
        this.cgo = new Rect();
        this.hGa = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(FrameAnimationView.this.hGa);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aes();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.aYm = new Rect();
        this.cgo = new Rect();
        this.hGa = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(FrameAnimationView.this.hGa);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aes();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.aYm = new Rect();
        this.cgo = new Rect();
        this.hGa = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(FrameAnimationView.this.hGa);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aes();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.hFZ = false;
            this.hFY = i;
            if (!ea(list)) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hGa);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hFZ = true;
            startLoad(str, 10, false);
        }
    }

    private boolean ea(List<String> list) {
        if (this.mData == null || list == null || this.mData.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < this.mData.size(); i++) {
            if (!this.mData.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void cv() {
        if (this.mData != null) {
            aes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aes() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.cgn = frameBitmap;
                this.aYm.set(0, 0, this.cgn.getWidth(), this.cgn.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hGa, this.hFY);
        }
    }

    private Bitmap getFrameBitmap() {
        if (this.mData == null) {
            return null;
        }
        if (this.index >= this.mData.size()) {
            this.index = 0;
        }
        String frameUrl = getFrameUrl();
        this.index++;
        if (!ao.isEmpty(frameUrl)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jA().a(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.oq();
            }
            com.baidu.adp.lib.f.c.jA().a(frameUrl, 10, null, this.mPageId);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.hFZ) {
            cv();
        }
    }

    private String getFrameUrl() {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(this.index);
    }

    public void stopAnimation() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hGa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hFZ && this.cgn != null && !this.cgn.isRecycled()) {
            this.cgo.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.cgn, this.aYm, this.cgo, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void release() {
        stopAnimation();
    }
}
