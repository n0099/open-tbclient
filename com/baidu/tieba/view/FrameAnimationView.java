package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes15.dex */
public class FrameAnimationView extends TbImageView {
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Bitmap mpA;
    private Rect mpB;
    private int mpC;
    private boolean mpD;
    private Runnable mpE;
    private Rect srcRect;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.mpB = new Rect();
        this.mpE = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(FrameAnimationView.this.mpE);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dtI();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.mpB = new Rect();
        this.mpE = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(FrameAnimationView.this.mpE);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dtI();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.mpB = new Rect();
        this.mpE = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(FrameAnimationView.this.mpE);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dtI();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.mpD = false;
            this.mpC = i;
            if (!fl(list)) {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mpE);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!as.isEmpty(str)) {
            this.mpD = true;
            startLoad(str, 10, false);
        }
    }

    private boolean fl(List<String> list) {
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
            dtI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtI() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.mpA = frameBitmap;
                this.srcRect.set(0, 0, this.mpA.getWidth(), this.mpA.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mpE, this.mpC);
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
        if (!as.isEmpty(frameUrl)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.ln().loadResourceFromMemery(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.getRawBitmap();
            }
            com.baidu.adp.lib.e.c.ln().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.mpD) {
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mpE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mpD && this.mpA != null && !this.mpA.isRecycled()) {
            this.mpB.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.mpA, this.srcRect, this.mpB, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
