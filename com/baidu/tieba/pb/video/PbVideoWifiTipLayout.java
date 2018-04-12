package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView fwS;
    private TextView fwT;
    private TextView fwU;
    private TextView fwV;
    private TextView fwW;

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
        this.fwS = (TextView) findViewById(d.g.tv_video_duration);
        this.fwT = (TextView) findViewById(d.g.tv_video_data);
        this.fwU = (TextView) findViewById(d.g.tv_play);
        this.fwV = (TextView) findViewById(d.g.tv_divider);
        this.fwW = (TextView) findViewById(d.g.tv_open_free_data);
        this.fwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fwS.setText(String.format(getResources().getString(d.k.pb_video_duration), an.cV(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fwS.setVisibility(8);
                this.fwV.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fwT.setText(String.format(getResources().getString(d.k.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
            } else {
                this.fwT.setVisibility(8);
                this.fwV.setVisibility(8);
            }
            this.fwW.setVisibility(0);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fwU.setOnClickListener(onClickListener);
    }
}
