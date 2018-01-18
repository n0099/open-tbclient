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
/* loaded from: classes2.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView fZc;
    private TextView fZd;
    private TextView fZe;
    private TextView fZf;

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
        this.fZc = (TextView) findViewById(d.g.tv_video_duration);
        this.fZd = (TextView) findViewById(d.g.tv_video_data);
        this.fZe = (TextView) findViewById(d.g.tv_play);
        this.fZf = (TextView) findViewById(d.g.tv_divider);
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fZc.setText(String.format(getResources().getString(d.j.pb_video_duration), am.fV(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fZc.setVisibility(8);
                this.fZf.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fZd.setText(String.format(getResources().getString(d.j.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
                return;
            }
            this.fZd.setVisibility(8);
            this.fZf.setVisibility(8);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fZe.setOnClickListener(onClickListener);
    }
}
