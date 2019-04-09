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
/* loaded from: classes3.dex */
public class FrameAnimationView extends TbImageView {
    private Bitmap dAb;
    private Rect dAc;
    private int index;
    private int jhS;
    private boolean jhT;
    private Runnable jhU;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Rect srcRect;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.dAc = new Rect();
        this.jhU = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(FrameAnimationView.this.jhU);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aGY();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.dAc = new Rect();
        this.jhU = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(FrameAnimationView.this.jhU);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aGY();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.dAc = new Rect();
        this.jhU = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(FrameAnimationView.this.jhU);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aGY();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.jhT = false;
            this.jhS = i;
            if (!ei(list)) {
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.jhU);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.jhT = true;
            startLoad(str, 10, false);
        }
    }

    private boolean ei(List<String> list) {
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

    public void cu() {
        if (this.mData != null) {
            aGY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGY() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.dAb = frameBitmap;
                this.srcRect.set(0, 0, this.dAb.getWidth(), this.dAb.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.jH().postDelayed(this.jhU, this.jhS);
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
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jB().a(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.oy();
            }
            com.baidu.adp.lib.f.c.jB().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.jhT) {
            cu();
        }
    }

    private String getFrameUrl() {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(this.index);
    }

    public void stopAnimation() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.jhU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.jhT && this.dAb != null && !this.dAb.isRecycled()) {
            this.dAc.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.dAb, this.srcRect, this.dAc, (Paint) null);
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
