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
    private TextView fwP;
    private TextView fwQ;
    private TextView fwR;
    private TextView fwS;
    private TextView fwT;

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
        this.fwP = (TextView) findViewById(d.g.tv_video_duration);
        this.fwQ = (TextView) findViewById(d.g.tv_video_data);
        this.fwR = (TextView) findViewById(d.g.tv_play);
        this.fwS = (TextView) findViewById(d.g.tv_divider);
        this.fwT = (TextView) findViewById(d.g.tv_open_free_data);
        this.fwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fwP.setText(String.format(getResources().getString(d.k.pb_video_duration), an.cU(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fwP.setVisibility(8);
                this.fwS.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fwQ.setText(String.format(getResources().getString(d.k.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
            } else {
                this.fwQ.setVisibility(8);
                this.fwS.setVisibility(8);
            }
            this.fwT.setVisibility(0);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fwR.setOnClickListener(onClickListener);
    }
}
