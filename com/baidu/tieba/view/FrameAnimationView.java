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
/* loaded from: classes21.dex */
public class FrameAnimationView extends TbImageView {
    private Rect flK;
    private int index;
    private List<String> mData;
    private BdUniqueId mPageId;
    private Bitmap ntH;
    private Rect ntI;
    private int ntJ;
    private boolean ntK;
    private Runnable ntL;

    public FrameAnimationView(Context context) {
        super(context);
        this.index = 0;
        this.flK = new Rect();
        this.ntI = new Rect();
        this.ntL = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(FrameAnimationView.this.ntL);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dQa();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 0;
        this.flK = new Rect();
        this.ntI = new Rect();
        this.ntL = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(FrameAnimationView.this.ntL);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dQa();
                }
            }
        };
    }

    public FrameAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 0;
        this.flK = new Rect();
        this.ntI = new Rect();
        this.ntL = new Runnable() { // from class: com.baidu.tieba.view.FrameAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(FrameAnimationView.this.ntL);
                if (FrameAnimationView.this.mData != null) {
                    FrameAnimationView.this.dQa();
                }
            }
        };
    }

    public void setData(List<String> list, int i) {
        if (list != null) {
            this.ntK = false;
            this.ntJ = i;
            if (!ah(list)) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ntL);
                this.mData = list;
                this.index = 0;
            }
        }
    }

    public void setData(String str) {
        if (!at.isEmpty(str)) {
            this.ntK = true;
            startLoad(str, 10, false);
        }
    }

    private boolean ah(List<String> list) {
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
            dQa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQa() {
        if (this.mData != null) {
            Bitmap frameBitmap = getFrameBitmap();
            if (frameBitmap != null && !frameBitmap.isRecycled()) {
                this.ntH = frameBitmap;
                this.flK.set(0, 0, this.ntH.getWidth(), this.ntH.getHeight());
            }
            invalidate();
            com.baidu.adp.lib.f.e.mY().postDelayed(this.ntL, this.ntJ);
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
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mS().loadResourceFromMemery(frameUrl, 10, new Object[0]);
            if (aVar != null) {
                return aVar.getRawBitmap();
            }
            com.baidu.adp.lib.e.c.mS().a(frameUrl, 10, null, this.mPageId);
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
        if (!this.ntK) {
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ntL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.ntK && this.ntH != null && !this.ntH.isRecycled()) {
            this.ntI.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawBitmap(this.ntH, this.flK, this.ntI, (Paint) null);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
