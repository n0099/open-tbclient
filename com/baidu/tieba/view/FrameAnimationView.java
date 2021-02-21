package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class FrameAnimationView extends TbImageView {
    private Rect fFK;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Bitmap nYi;
    private Rect nYj;
    private int nYk;
    private boolean nYl;
    private Runnable nYm;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.fFK = new Rect();
        this.nYj = new Rect();
        this.nYm = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(FrameAnimationView.this.nYm);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dWe();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.fFK = new Rect();
        this.nYj = new Rect();
        this.nYm = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(FrameAnimationView.this.nYm);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dWe();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.fFK = new Rect();
        this.nYj = new Rect();
        this.nYm = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(FrameAnimationView.this.nYm);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dWe();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.nYl = false;
            this.nYk = i;
            if (!at(list)) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nYm);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!au.isEmpty(str)) {
            this.nYl = true;
            startLoad(str, 10, false);
        }
    }

    private boolean at(List<String> list) {
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
            dWe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWe() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.nYi = frameBitmap;
                this.fFK.set(0, 0, this.nYi.getWidth(), this.nYi.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.f.e.mA().postDelayed(this.nYm, this.nYk);
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
        if (!au.isEmpty(frameUrl)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mw().loadResourceFromMemery(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.getRawBitmap();
            }
            com.baidu.adp.lib.e.d.mw().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.nYl) {
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nYm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.nYl && this.nYi != null && !this.nYi.isRecycled()) {
            this.nYj.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.nYi, this.fFK, this.nYj, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
