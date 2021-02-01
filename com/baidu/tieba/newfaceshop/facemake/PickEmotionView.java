package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
/* loaded from: classes9.dex */
public class PickEmotionView extends FrameLayout {
    private EmotionView lCm;
    private ImageView lCn;

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
        this.lCm = new EmotionView(getContext());
        addView(this.lCm, new FrameLayout.LayoutParams(-1, -1));
        this.lCn = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds8);
        layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds8);
        addView(this.lCn, layoutParams);
    }

    public void setData(EmotionImageData emotionImageData, int i) {
        this.lCm.setLoadProcType(i);
        this.lCm.cyh();
        this.lCm.a(emotionImageData);
    }

    public int getLoadType() {
        if (this.lCm != null) {
            return this.lCm.getLoadProcType();
        }
        return 10;
    }

    public void setChoosed(boolean z) {
        if (z) {
            ap.setBackgroundResource(this.lCn, R.drawable.ic_post_image_selected_s);
        } else {
            ap.setBackgroundResource(this.lCn, R.drawable.ic_post_image_selected_n);
        }
    }

    public EmotionView getEmotionView() {
        return this.lCm;
    }
}
