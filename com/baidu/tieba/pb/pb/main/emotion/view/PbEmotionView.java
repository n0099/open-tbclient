package com.baidu.tieba.pb.pb.main.emotion.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbEmotionView extends TbImageView {
    private float FG;
    private View.OnClickListener bkk;
    private float boN;
    private EmotionImageData eFM;
    private g eFN;
    private FrameLayout eFO;
    private boolean eFP;
    private boolean eFQ;
    private boolean eFR;
    private int eFS;
    private float eFw;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public PbEmotionView(Context context) {
        super(context);
        this.eFR = true;
        this.eFS = 10;
        init();
    }

    public PbEmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFR = true;
        this.eFS = 10;
        init();
    }

    public PbEmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFR = true;
        this.eFS = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), w.f.ds240);
        this.mPreviewHeight = k.g(getContext(), w.f.ds260);
        this.eFw = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void e(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.eFM = emotionImageData;
            setTag(this.eFM.getThumbUrl());
            c(this.eFM.getThumbUrl(), this.eFS, false);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.bkk = onClickListener;
    }

    public void aRp() {
        setOnTouchListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRq() {
        return Math.abs(this.mCurrentX - this.FG) < this.eFw && Math.abs(this.mCurrentY - this.boN) < this.eFw;
    }

    public void l(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRr() {
        if (!this.eFQ && this.eFR && this.eFM != null && !TextUtils.isEmpty(this.eFM.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.eFN == null) {
                this.eFN = new g(getContext());
            }
            this.eFN.h(this.eFM.getPicUrl(), this.eFM.getThumbUrl(), this.sa);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.af(getContext())) {
                layoutParams.leftMargin = k.af(getContext()) - this.mPreviewWidth;
            }
            if (this.eFO == null) {
                this.eFO = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.eFN.getParent() != null && this.eFN.getParent() == this.eFO) {
                this.eFO.removeView(this.eFN);
            }
            this.eFO.addView(this.eFN, layoutParams);
            this.eFQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.eFN != null) {
            if (this.eFN.getParent() != null && this.eFN.getParent() == this.eFO) {
                this.eFO.removeView(this.eFN);
            }
            this.eFQ = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.eFR = z;
        if (!this.eFR) {
            stopPreview();
        }
    }

    public int getLoadProcType() {
        return this.eFS;
    }
}
