package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class VideoListMediaControllerView extends au {
    public VideoListMediaControllerView(Context context) {
        super(context);
    }

    public VideoListMediaControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoListMediaControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.play.au
    protected View bi(Context context) {
        return View.inflate(context, r.j.video_list_video_controller, null);
    }
}
