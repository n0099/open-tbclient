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
    private TextView gGo;
    private TextView gGp;
    private TextView gGq;
    private TextView gGr;
    private TextView gGs;
    private View.OnClickListener gGt;

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
        this.gGo = (TextView) findViewById(e.g.tv_video_duration);
        this.gGp = (TextView) findViewById(e.g.tv_video_data);
        this.gGq = (TextView) findViewById(e.g.tv_play);
        this.gGr = (TextView) findViewById(e.g.tv_divider);
        this.gGs = (TextView) findViewById(e.g.tv_open_free_data);
        this.gGs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.gGt != null) {
                    PbVideoWifiTipLayout.this.gGt.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.gGq;
    }

    public TextView getTvOpenFreeData() {
        return this.gGs;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.gGt = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.gGo.setText(String.format(getResources().getString(e.j.pb_video_duration), ao.dV(i * 1000)));
        } else {
            this.gGo.setVisibility(8);
            this.gGr.setVisibility(8);
        }
        if (i2 > 0) {
            this.gGp.setText(String.format(getResources().getString(e.j.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.gGp.setVisibility(8);
            this.gGr.setVisibility(8);
        }
        this.gGs.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.gGq.setOnClickListener(onClickListener);
    }
}
