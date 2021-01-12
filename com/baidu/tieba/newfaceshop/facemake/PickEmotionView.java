package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
/* loaded from: classes8.dex */
public class PickEmotionView extends FrameLayout {
    private EmotionView lui;
    private ImageView luj;

    public PickEmotionView(Context context) {
        super(context);
        init();
    }

    public PickEmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PickEmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.lui = new EmotionView(getContext());
        addView(this.lui, new FrameLayout.LayoutParams(-1, -1));
        this.luj = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds8);
        layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds8);
        addView(this.luj, layoutParams);
    }

    public void setData(EmotionImageData emotionImageData, int i) {
        this.lui.setLoadProcType(i);
        this.lui.cwW();
        this.lui.a(emotionImageData);
    }

    public int getLoadType() {
        if (this.lui != null) {
            return this.lui.getLoadProcType();
        }
        return 10;
    }

    public void setChoosed(boolean z) {
        if (z) {
            ao.setBackgroundResource(this.luj, R.drawable.ic_post_image_selected_s);
        } else {
            ao.setBackgroundResource(this.luj, R.drawable.ic_post_image_selected_n);
        }
    }

    public EmotionView getEmotionView() {
        return this.lui;
    }
}
