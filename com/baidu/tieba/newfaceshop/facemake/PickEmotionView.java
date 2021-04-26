package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class PickEmotionView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public EmotionView f19387e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19388f;

    public PickEmotionView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f19387e = new EmotionView(getContext());
        addView(this.f19387e, new FrameLayout.LayoutParams(-1, -1));
        this.f19388f = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds8);
        layoutParams.rightMargin = l.g(getContext(), R.dimen.ds8);
        addView(this.f19388f, layoutParams);
    }

    public EmotionView getEmotionView() {
        return this.f19387e;
    }

    public int getLoadType() {
        EmotionView emotionView = this.f19387e;
        if (emotionView != null) {
            return emotionView.getLoadProcType();
        }
        return 10;
    }

    public void setChoosed(boolean z) {
        if (z) {
            SkinManager.setBackgroundResource(this.f19388f, R.drawable.ic_post_image_selected_s);
        } else {
            SkinManager.setBackgroundResource(this.f19388f, R.drawable.ic_post_image_selected_n);
        }
    }

    public void setData(EmotionImageData emotionImageData, int i2) {
        this.f19387e.setLoadProcType(i2);
        this.f19387e.A0();
        this.f19387e.C0(emotionImageData);
    }

    public PickEmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PickEmotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
