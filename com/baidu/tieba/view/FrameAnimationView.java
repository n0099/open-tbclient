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
    private Rect bcx;
    private Bitmap ckX;
    private Rect ckY;
    private int hRB;
    private boolean hRC;
    private Runnable hRD;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.bcx = new Rect();
        this.ckY = new Rect();
        this.hRD = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(FrameAnimationView.this.hRD);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.age();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.bcx = new Rect();
        this.ckY = new Rect();
        this.hRD = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(FrameAnimationView.this.hRD);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.age();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.bcx = new Rect();
        this.ckY = new Rect();
        this.hRD = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(FrameAnimationView.this.hRD);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.age();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.hRC = false;
            this.hRB = i;
            if (!eg(list)) {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hRD);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hRC = true;
            startLoad(str, 10, false);
        }
    }

    private boolean eg(List<String> list) {
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
            age();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void age() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.ckX = frameBitmap;
                this.bcx.set(0, 0, this.ckX.getWidth(), this.ckX.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.jG().postDelayed(this.hRD, this.hRB);
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
                return aVar.ot();
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
        if (!this.hRC) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hRD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hRC && this.ckX != null && !this.ckX.isRecycled()) {
            this.ckY.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.ckX, this.bcx, this.ckY, (Paint) null);
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
