package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes3.dex */
public class FrameAnimationView extends TbImageView {
    private Bitmap dQb;
    private Rect dQc;
    private int index;
    private int jKA;
    private boolean jKB;
    private Runnable jKC;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Rect srcRect;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.dQc = new Rect();
        this.jKC = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(FrameAnimationView.this.jKC);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aPD();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.dQc = new Rect();
        this.jKC = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(FrameAnimationView.this.jKC);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aPD();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.dQc = new Rect();
        this.jKC = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(FrameAnimationView.this.jKC);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aPD();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.jKB = false;
            this.jKA = i;
            if (!eu(list)) {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.jKC);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jKB = true;
            startLoad(str, 10, false);
        }
    }

    private boolean eu(List<String> list) {
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

    public void br() {
        if (this.mData != null) {
            aPD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPD() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.dQb = frameBitmap;
                this.srcRect.set(0, 0, this.dQb.getWidth(), this.dQb.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.iK().postDelayed(this.jKC, this.jKA);
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
        if (!aq.isEmpty(frameUrl)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iE().b(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.nK();
            }
            com.baidu.adp.lib.f.c.iE().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.jKB) {
            br();
        }
    }

    private String getFrameUrl() {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(this.index);
    }

    public void stopAnimation() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.jKC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.jKB && this.dQb != null && !this.dQb.isRecycled()) {
            this.dQc.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.dQb, this.srcRect, this.dQc, (Paint) null);
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
