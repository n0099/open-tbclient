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
    private Rect aPJ;
    private Bitmap bRQ;
    private Rect bRR;
    private int hpi;
    private boolean hpj;
    private Runnable hpk;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.aPJ = new Rect();
        this.bRR = new Rect();
        this.hpk = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.in().removeCallbacks(FrameAnimationView.this.hpk);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zv();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.aPJ = new Rect();
        this.bRR = new Rect();
        this.hpk = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.in().removeCallbacks(FrameAnimationView.this.hpk);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zv();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.aPJ = new Rect();
        this.bRR = new Rect();
        this.hpk = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.in().removeCallbacks(FrameAnimationView.this.hpk);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zv();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.hpj = false;
            this.hpi = i;
            if (!dN(list)) {
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.hpk);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.hpj = true;
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
            Zv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zv() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.bRQ = frameBitmap;
                this.aPJ.set(0, 0, this.bRQ.getWidth(), this.bRQ.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.in().postDelayed(this.hpk, this.hpi);
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
        if (!this.hpj) {
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
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.hpk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hpj && this.bRQ != null && !this.bRQ.isRecycled()) {
            this.bRR.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.bRQ, this.aPJ, this.bRR, (Paint) null);
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
