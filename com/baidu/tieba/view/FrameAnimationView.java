package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class FrameAnimationView extends TbImageView {
    private Rect fDy;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Bitmap nND;
    private Rect nNE;
    private int nNF;
    private boolean nNG;
    private Runnable nNH;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.fDy = new Rect();
        this.nNE = new Rect();
        this.nNH = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(FrameAnimationView.this.nNH);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dTI();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.fDy = new Rect();
        this.nNE = new Rect();
        this.nNH = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(FrameAnimationView.this.nNH);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dTI();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.fDy = new Rect();
        this.nNE = new Rect();
        this.nNH = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(FrameAnimationView.this.nNH);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dTI();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.nNG = false;
            this.nNF = i;
            if (!as(list)) {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.nNH);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.nNG = true;
            startLoad(str, 10, false);
        }
    }

    private boolean as(List<String> list) {
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

    public void playAnimation() {
        if (this.mData != null) {
            dTI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTI() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.nND = frameBitmap;
                this.fDy.set(0, 0, this.nND.getWidth(), this.nND.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.f.e.mB().postDelayed(this.nNH, this.nNF);
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
        if (!at.isEmpty(frameUrl)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mx().loadResourceFromMemery(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.getRawBitmap();
            }
            com.baidu.adp.lib.e.d.mx().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.nNG) {
            playAnimation();
        }
    }

    private String getFrameUrl() {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(this.index);
    }

    public void stopAnimation() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.nNH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.nNG && this.nND != null && !this.nND.isRecycled()) {
            this.nNE.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.nND, this.fDy, this.nNE, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
