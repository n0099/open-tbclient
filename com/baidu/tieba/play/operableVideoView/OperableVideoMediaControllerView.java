package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoControllerView;
/* loaded from: classes.dex */
public class OperableVideoMediaControllerView extends VideoControllerView {
    public OperableVideoMediaControllerView(Context context) {
        super(context);
    }

    public OperableVideoMediaControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperableVideoMediaControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    protected View cX(Context context) {
        return View.inflate(context, R.layout.operable_video_controller, null);
    }
}
