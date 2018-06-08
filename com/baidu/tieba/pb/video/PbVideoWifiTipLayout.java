package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView fJp;
    private TextView fJq;
    private TextView fJr;
    private TextView fJs;
    private TextView fJt;

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
        inflate(getContext(), d.i.layout_video_wifi_tip, this);
        this.fJp = (TextView) findViewById(d.g.tv_video_duration);
        this.fJq = (TextView) findViewById(d.g.tv_video_data);
        this.fJr = (TextView) findViewById(d.g.tv_play);
        this.fJs = (TextView) findViewById(d.g.tv_divider);
        this.fJt = (TextView) findViewById(d.g.tv_open_free_data);
        this.fJt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fJp.setText(String.format(getResources().getString(d.k.pb_video_duration), ao.cX(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fJp.setVisibility(8);
                this.fJs.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fJq.setText(String.format(getResources().getString(d.k.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
            } else {
                this.fJq.setVisibility(8);
                this.fJs.setVisibility(8);
            }
            this.fJt.setVisibility(0);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fJr.setOnClickListener(onClickListener);
    }
}
