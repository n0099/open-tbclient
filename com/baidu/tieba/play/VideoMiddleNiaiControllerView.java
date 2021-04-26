package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class VideoMiddleNiaiControllerView extends VideoControllerView {
    public VideoMiddleNiaiControllerView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public View l(Context context) {
        return View.inflate(context, R.layout.video_middle_naivi_controller, null);
    }

    public void setBottomBarShow(boolean z) {
        SeekBar seekBar = this.l;
        if (seekBar == null) {
            return;
        }
        if (z) {
            seekBar.setThumb(null);
            this.l.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_three_width_seekbar));
            return;
        }
        seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
        this.l.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
        this.l.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
    }

    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
