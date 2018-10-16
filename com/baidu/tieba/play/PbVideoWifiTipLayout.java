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
    private TextView gub;
    private TextView guc;
    private TextView gud;
    private TextView gue;
    private TextView guf;
    private View.OnClickListener gug;

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
        this.gub = (TextView) findViewById(e.g.tv_video_duration);
        this.guc = (TextView) findViewById(e.g.tv_video_data);
        this.gud = (TextView) findViewById(e.g.tv_play);
        this.gue = (TextView) findViewById(e.g.tv_divider);
        this.guf = (TextView) findViewById(e.g.tv_open_free_data);
        this.guf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(e.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.gug != null) {
                    PbVideoWifiTipLayout.this.gug.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.gud;
    }

    public TextView getTvOpenFreeData() {
        return this.guf;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.gug = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.gub.setText(String.format(getResources().getString(e.j.pb_video_duration), ao.dt(i * 1000)));
        } else {
            this.gub.setVisibility(8);
            this.gue.setVisibility(8);
        }
        if (i2 > 0) {
            this.guc.setText(String.format(getResources().getString(e.j.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.guc.setVisibility(8);
            this.gue.setVisibility(8);
        }
        this.guf.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.gud.setOnClickListener(onClickListener);
    }
}
