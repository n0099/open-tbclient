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
/* loaded from: classes9.dex */
public class PickEmotionView extends FrameLayout {
    private EmotionView lyO;
    private ImageView lyP;

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
        this.lyO = new EmotionView(getContext());
        addView(this.lyO, new FrameLayout.LayoutParams(-1, -1));
        this.lyP = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds8);
        layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds8);
        addView(this.lyP, layoutParams);
    }

    public void setData(EmotionImageData emotionImageData, int i) {
        this.lyO.setLoadProcType(i);
        this.lyO.cAO();
        this.lyO.a(emotionImageData);
    }

    public int getLoadType() {
        if (this.lyO != null) {
            return this.lyO.getLoadProcType();
        }
        return 10;
    }

    public void setChoosed(boolean z) {
        if (z) {
            ao.setBackgroundResource(this.lyP, R.drawable.ic_post_image_selected_s);
        } else {
            ao.setBackgroundResource(this.lyP, R.drawable.ic_post_image_selected_n);
        }
    }

    public EmotionView getEmotionView() {
        return this.lyO;
    }
}
