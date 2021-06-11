package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class VideoMiddleNiaiControllerView extends VideoControllerView {
    public static final int u = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
    public static final int v = UtilHelper.getDimenPixelSize(R.dimen.tbds117);
    public static final int w = UtilHelper.getDimenPixelSize(R.dimen.tbds49);
    public static final int x = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
    public static final int y = UtilHelper.getDimenPixelSize(R.dimen.tbds37);
    public View t;

    public VideoMiddleNiaiControllerView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public View l(Context context) {
        View inflate = View.inflate(context, R.layout.video_middle_naivi_controller, null);
        this.t = inflate;
        return inflate;
    }

    public void setBottomBarShow(boolean z, int i2) {
        SeekBar seekBar = this.l;
        if (seekBar == null) {
            return;
        }
        if (z) {
            seekBar.setThumb(null);
            if (i2 == 1) {
                w();
            } else {
                u();
            }
            this.l.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_three_width_seekbar));
            return;
        }
        seekBar.setThumb(null);
        if (i2 == 1) {
            v();
        } else {
            u();
        }
        this.l.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
    }

    public void t(int i2) {
        if (i2 == 1) {
            w();
        } else {
            u();
        }
    }

    public final void u() {
        this.t.getLayoutParams().height = v;
        SeekBar seekBar = this.l;
        seekBar.setPadding(seekBar.getPaddingLeft(), 0, this.l.getPaddingRight(), y);
        this.t.requestLayout();
    }

    public final void v() {
        this.t.getLayoutParams().height = u;
        SeekBar seekBar = this.l;
        seekBar.setPadding(seekBar.getPaddingLeft(), x, this.l.getPaddingRight(), this.l.getPaddingBottom());
        this.t.requestLayout();
    }

    public final void w() {
        this.t.getLayoutParams().height = u;
        SeekBar seekBar = this.l;
        seekBar.setPadding(seekBar.getPaddingLeft(), w, this.l.getPaddingRight(), 0);
        this.t.requestLayout();
    }

    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
