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
    private Bitmap bQU;
    private Rect bQV;
    private int hoa;
    private boolean hob;
    private Runnable hoc;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.aPJ = new Rect();
        this.bQV = new Rect();
        this.hoc = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.im().removeCallbacks(FrameAnimationView.this.hoc);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zl();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.aPJ = new Rect();
        this.bQV = new Rect();
        this.hoc = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.im().removeCallbacks(FrameAnimationView.this.hoc);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zl();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.aPJ = new Rect();
        this.bQV = new Rect();
        this.hoc = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.im().removeCallbacks(FrameAnimationView.this.hoc);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.Zl();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.hob = false;
            this.hoa = i;
            if (!dR(list)) {
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.hoc);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ap.isEmpty(str)) {
            this.hob = true;
            startLoad(str, 10, false);
        }
    }

    private boolean dR(List<String> list) {
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
            Zl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zl() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.bQU = frameBitmap;
                this.aPJ.set(0, 0, this.bQU.getWidth(), this.bQU.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.im().postDelayed(this.hoc, this.hoa);
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
        if (!this.hob) {
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
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.hoc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hob && this.bQU != null && !this.bQU.isRecycled()) {
            this.bQV.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.bQU, this.aPJ, this.bQV, (Paint) null);
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
