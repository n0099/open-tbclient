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
/* loaded from: classes15.dex */
public class FrameAnimationView extends TbImageView {
    private Rect eOn;
    private int index;
    private List<String> mData;
    private Bitmap mHQ;
    private Rect mHR;
    private int mHS;
    private boolean mHT;
    private Runnable mHU;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.eOn = new Rect();
        this.mHR = new Rect();
        this.mHU = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mS().removeCallbacks(FrameAnimationView.this.mHU);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dFm();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.eOn = new Rect();
        this.mHR = new Rect();
        this.mHU = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mS().removeCallbacks(FrameAnimationView.this.mHU);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dFm();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.eOn = new Rect();
        this.mHR = new Rect();
        this.mHU = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mS().removeCallbacks(FrameAnimationView.this.mHU);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dFm();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.mHT = false;
            this.mHS = i;
            if (!ft(list)) {
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mHU);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.mHT = true;
            startLoad(str, 10, false);
        }
    }

    private boolean ft(List<String> list) {
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
            dFm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFm() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.mHQ = frameBitmap;
                this.eOn.set(0, 0, this.mHQ.getWidth(), this.mHQ.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.f.e.mS().postDelayed(this.mHU, this.mHS);
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
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mM().loadResourceFromMemery(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.getRawBitmap();
            }
            com.baidu.adp.lib.e.c.mM().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.mHT) {
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
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mHU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mHT && this.mHQ != null && !this.mHQ.isRecycled()) {
            this.mHR.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.mHQ, this.eOn, this.mHR, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
