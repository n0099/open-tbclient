package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView gGn;
    private TextView gGo;
    private TextView gGp;
    private TextView gGq;
    private TextView gGr;
    private View.OnClickListener gGs;

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
        inflate(getContext(), e.h.layout_video_wifi_tip, this);
        this.gGn = (TextView) findViewById(e.g.tv_video_duration);
        this.gGo = (TextView) findViewById(e.g.tv_video_data);
        this.gGp = (TextView) findViewById(e.g.tv_play);
        this.gGq = (TextView) findViewById(e.g.tv_divider);
        this.gGr = (TextView) findViewById(e.g.tv_open_free_data);
        this.gGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.gGs != null) {
                    PbVideoWifiTipLayout.this.gGs.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.gGp;
    }

    public TextView getTvOpenFreeData() {
        return this.gGr;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.gGs = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.gGn.setText(String.format(getResources().getString(e.j.pb_video_duration), ao.dV(i * 1000)));
        } else {
            this.gGn.setVisibility(8);
            this.gGq.setVisibility(8);
        }
        if (i2 > 0) {
            this.gGo.setText(String.format(getResources().getString(e.j.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.gGo.setVisibility(8);
            this.gGq.setVisibility(8);
        }
        this.gGr.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.gGp.setOnClickListener(onClickListener);
    }
}
