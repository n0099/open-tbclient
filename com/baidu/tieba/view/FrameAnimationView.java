package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes8.dex */
public class FrameAnimationView extends TbImageView {
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Bitmap mig;
    private Rect mih;
    private int mii;
    private boolean mij;
    private Runnable mik;
    private Rect srcRect;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.mih = new Rect();
        this.mik = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(FrameAnimationView.this.mik);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dqu();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.mih = new Rect();
        this.mik = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(FrameAnimationView.this.mik);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dqu();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.mih = new Rect();
        this.mik = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(FrameAnimationView.this.mik);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dqu();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.mij = false;
            this.mii = i;
            if (!ff(list)) {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mik);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!ar.isEmpty(str)) {
            this.mij = true;
            startLoad(str, 10, false);
        }
    }

    private boolean ff(List<String> list) {
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
            dqu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqu() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.mig = frameBitmap;
                this.srcRect.set(0, 0, this.mig.getWidth(), this.mig.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mik, this.mii);
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
        if (!ar.isEmpty(frameUrl)) {
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
        if (!this.mij) {
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mik);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mij && this.mig != null && !this.mig.isRecycled()) {
            this.mih.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.mig, this.srcRect, this.mih, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
