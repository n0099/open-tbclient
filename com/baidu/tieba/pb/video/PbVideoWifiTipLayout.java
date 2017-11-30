package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView fjC;
    private TextView fjD;
    private TextView fjE;
    private TextView fjF;

    public PbVideoWifiTipLayout(Context context) {
        super(context);
        initView();
    }

    public PbVideoWifiTipLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public PbVideoWifiTipLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), d.h.layout_video_wifi_tip, this);
        this.fjC = (TextView) findViewById(d.g.tv_video_duration);
        this.fjD = (TextView) findViewById(d.g.tv_video_data);
        this.fjE = (TextView) findViewById(d.g.tv_play);
        this.fjF = (TextView) findViewById(d.g.tv_divider);
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fjC.setText(String.format(getResources().getString(d.j.pb_video_duration), am.cY(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fjC.setVisibility(8);
                this.fjF.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fjD.setText(String.format(getResources().getString(d.j.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
                return;
            }
            this.fjD.setVisibility(8);
            this.fjF.setVisibility(8);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fjE.setOnClickListener(onClickListener);
    }
}
