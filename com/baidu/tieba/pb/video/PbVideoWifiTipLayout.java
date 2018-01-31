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
    private TextView fZA;
    private TextView fZx;
    private TextView fZy;
    private TextView fZz;

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
        this.fZx = (TextView) findViewById(d.g.tv_video_duration);
        this.fZy = (TextView) findViewById(d.g.tv_video_data);
        this.fZz = (TextView) findViewById(d.g.tv_play);
        this.fZA = (TextView) findViewById(d.g.tv_divider);
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fZx.setText(String.format(getResources().getString(d.j.pb_video_duration), am.fV(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fZx.setVisibility(8);
                this.fZA.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fZy.setText(String.format(getResources().getString(d.j.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
                return;
            }
            this.fZy.setVisibility(8);
            this.fZA.setVisibility(8);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fZz.setOnClickListener(onClickListener);
    }
}
