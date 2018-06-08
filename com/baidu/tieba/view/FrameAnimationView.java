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
    private Rect aON;
    private Bitmap bOK;
    private Rect bOL;
    private int hjV;
    private boolean hjW;
    private Runnable hjX;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.aON = new Rect();
        this.bOL = new Rect();
        this.hjX = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.im().removeCallbacks(FrameAnimationView.this.hjX);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.YI();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.aON = new Rect();
        this.bOL = new Rect();
        this.hjX = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.im().removeCallbacks(FrameAnimationView.this.hjX);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.YI();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.aON = new Rect();
        this.bOL = new Rect();
        this.hjX = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.im().removeCallbacks(FrameAnimationView.this.hjX);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.YI();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.hjW = false;
            this.hjV = i;
            if (!dO(list)) {
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.hjX);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ao.isEmpty(str)) {
            this.hjW = true;
            startLoad(str, 10, false);
        }
    }

    private boolean dO(List<String> list) {
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

    public void ba() {
        if (this.mData != null) {
            YI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YI() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.bOK = frameBitmap;
                this.aON.set(0, 0, this.bOK.getWidth(), this.bOK.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.im().postDelayed(this.hjX, this.hjV);
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
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ig().a(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.mZ();
            }
            com.baidu.adp.lib.f.c.ig().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.hjW) {
            ba();
        }
    }

    private String getFrameUrl() {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(this.index);
    }

    public void stopAnimation() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.hjX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hjW && this.bOK != null && !this.bOK.isRecycled()) {
            this.bOL.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.bOK, this.aON, this.bOL, (Paint) null);
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
