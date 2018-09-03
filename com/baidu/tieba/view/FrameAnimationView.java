package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class FrameAnimationView extends TbImageView {
    private Rect aPG;
    private Bitmap bRP;
    private Rect bRQ;
    private int hpj;
    private boolean hpk;
    private Runnable hpl;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.aPG = new Rect();
        this.bRQ = new Rect();
        this.hpl = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.in().removeCallbacks(FrameAnimationView.this.hpl);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zx();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.aPG = new Rect();
        this.bRQ = new Rect();
        this.hpl = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.in().removeCallbacks(FrameAnimationView.this.hpl);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zx();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.aPG = new Rect();
        this.bRQ = new Rect();
        this.hpl = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.in().removeCallbacks(FrameAnimationView.this.hpl);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zx();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.hpk = false;
            this.hpj = i;
            if (!dN(list)) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.hpl);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.hpk = true;
            startLoad(str, 10, false);
        }
    }

    private boolean dN(List<String> list) {
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

    public void aX() {
        if (this.mData != null) {
            Zx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zx() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.bRP = frameBitmap;
                this.aPG.set(0, 0, this.bRP.getWidth(), this.bRP.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.in().postDelayed(this.hpl, this.hpj);
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
        if (!ap.isEmpty(frameUrl)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ih().a(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.nb();
            }
            com.baidu.adp.lib.f.c.ih().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.hpk) {
            aX();
        }
    }

    private String getFrameUrl() {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(this.index);
    }

    public void stopAnimation() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.hpl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hpk && this.bRP != null && !this.bRP.isRecycled()) {
            this.bRQ.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.bRP, this.aPG, this.bRQ, (Paint) null);
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
