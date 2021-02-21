package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoMiddleNiaiControllerView extends VideoControllerView {
    public VideoMiddleNiaiControllerView(Context context) {
        super(context);
    }

    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    protected View fE(Context context) {
        return View.inflate(context, R.layout.video_middle_naivi_controller, null);
    }

    public void setBottomBarShow(boolean z) {
        if (this.ghT != null) {
            if (z) {
                this.ghT.setThumb(null);
                this.ghT.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_three_width_seekbar));
                return;
            }
            this.ghT.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_pressed));
            this.ghT.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.video_seekbar_thumb_normal));
            this.ghT.setProgressDrawable(TbadkCoreApplication.getInst().getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
        }
    }
}
