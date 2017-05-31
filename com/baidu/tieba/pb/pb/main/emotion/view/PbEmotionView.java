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
    private View.OnClickListener bhc;
    private float bkY;
    private float ewi;
    private EmotionImageData ewq;
    private f ewr;
    private FrameLayout ews;
    private boolean ewt;
    private boolean ewu;
    private boolean ewv;
    private int eww;
    private float mCurrentX;
    private float mCurrentY;
    private int mPreviewHeight;
    private int mPreviewWidth;

    public PbEmotionView(Context context) {
        super(context);
        this.ewv = true;
        this.eww = 10;
        init();
    }

    public PbEmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewv = true;
        this.eww = 10;
        init();
    }

    public PbEmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewv = true;
        this.eww = 10;
        init();
    }

    private void init() {
        this.mPreviewWidth = k.g(getContext(), w.f.ds240);
        this.mPreviewHeight = k.g(getContext(), w.f.ds260);
        this.ewi = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    public void e(EmotionImageData emotionImageData) {
        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.ewq = emotionImageData;
            setTag(this.ewq.getThumbUrl());
            c(this.ewq.getThumbUrl(), this.eww, false);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.bhc = onClickListener;
    }

    public void aNp() {
        setOnTouchListener(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNq() {
        return Math.abs(this.mCurrentX - this.FG) < this.ewi && Math.abs(this.mCurrentY - this.bkY) < this.ewi;
    }

    public void j(float f, float f2) {
        this.mCurrentX = f;
        this.mCurrentY = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNr() {
        if (!this.ewu && this.ewv && this.ewq != null && !TextUtils.isEmpty(this.ewq.getPicUrl())) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.ewr == null) {
                this.ewr = new f(getContext());
            }
            this.ewr.h(this.ewq.getPicUrl(), this.ewq.getThumbUrl(), this.sb);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPreviewWidth, this.mPreviewHeight);
            layoutParams.leftMargin = iArr[0] - 60;
            layoutParams.topMargin = iArr[1] - this.mPreviewHeight;
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.mPreviewWidth > k.af(getContext())) {
                layoutParams.leftMargin = k.af(getContext()) - this.mPreviewWidth;
            }
            if (this.ews == null) {
                this.ews = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.ewr.getParent() != null && this.ewr.getParent() == this.ews) {
                this.ews.removeView(this.ewr);
            }
            this.ews.addView(this.ewr, layoutParams);
            this.ewu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPreview() {
        if (this.ewr != null) {
            if (this.ewr.getParent() != null && this.ewr.getParent() == this.ews) {
                this.ews.removeView(this.ewr);
            }
            this.ewu = false;
        }
    }

    public void setCanShowPreview(boolean z) {
        this.ewv = z;
        if (!this.ewv) {
            stopPreview();
        }
    }

    public int getLoadProcType() {
        return this.eww;
    }
}
