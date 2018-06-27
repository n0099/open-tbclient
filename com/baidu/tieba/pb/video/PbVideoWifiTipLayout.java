package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView fNr;
    private TextView fNs;
    private TextView fNt;
    private TextView fNu;
    private TextView fNv;

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
        this.fNr = (TextView) findViewById(d.g.tv_video_duration);
        this.fNs = (TextView) findViewById(d.g.tv_video_data);
        this.fNt = (TextView) findViewById(d.g.tv_play);
        this.fNu = (TextView) findViewById(d.g.tv_divider);
        this.fNv = (TextView) findViewById(d.g.tv_open_free_data);
        this.fNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            if (videoInfo.video_duration.intValue() > 0) {
                this.fNr.setText(String.format(getResources().getString(d.k.pb_video_duration), ap.cY(videoInfo.video_duration.intValue() * 1000)));
            } else {
                this.fNr.setVisibility(8);
                this.fNu.setVisibility(8);
            }
            if (videoInfo.video_length.intValue() > 0) {
                this.fNs.setText(String.format(getResources().getString(d.k.pb_video_data), new DecimalFormat("0.0").format(videoInfo.video_length.intValue() / 1048576.0f)));
            } else {
                this.fNs.setVisibility(8);
                this.fNu.setVisibility(8);
            }
            this.fNv.setVisibility(0);
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.fNt.setOnClickListener(onClickListener);
    }
}
