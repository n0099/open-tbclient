package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class VideoListMediaControllerView extends VideoControllerView {
    public VideoListMediaControllerView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public View l(Context context) {
        return View.inflate(context, R.layout.video_list_video_controller, null);
    }

    public VideoListMediaControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoListMediaControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
