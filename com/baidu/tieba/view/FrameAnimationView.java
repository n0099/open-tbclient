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
    private Bitmap dOj;
    private Rect dOk;
    private int index;
    private int jGY;
    private boolean jGZ;
    private Runnable jHa;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Rect srcRect;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.srcRect = new Rect();
        this.dOk = new Rect();
        this.jHa = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(FrameAnimationView.this.jHa);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aOX();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.srcRect = new Rect();
        this.dOk = new Rect();
        this.jHa = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(FrameAnimationView.this.jHa);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aOX();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.srcRect = new Rect();
        this.dOk = new Rect();
        this.jHa = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(FrameAnimationView.this.jHa);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.aOX();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.jGZ = false;
            this.jGY = i;
            if (!ev(list)) {
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.jHa);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!aq.isEmpty(str)) {
            this.jGZ = true;
            startLoad(str, 10, false);
        }
    }

    private boolean ev(List<String> list) {
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
            aOX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOX() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.dOj = frameBitmap;
                this.srcRect.set(0, 0, this.dOj.getWidth(), this.dOj.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.g.e.iK().postDelayed(this.jHa, this.jGY);
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
        if (!this.jGZ) {
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
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.jHa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.jGZ && this.dOj != null && !this.dOj.isRecycled()) {
            this.dOk.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.dOj, this.srcRect, this.dOk, (Paint) null);
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
