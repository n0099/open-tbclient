package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView gfh;
    private TextView gfi;
    private TextView gfj;
    private TextView gfk;
    private TextView gfl;
    private View.OnClickListener gfm;

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
        inflate(getContext(), f.h.layout_video_wifi_tip, this);
        this.gfh = (TextView) findViewById(f.g.tv_video_duration);
        this.gfi = (TextView) findViewById(f.g.tv_video_data);
        this.gfj = (TextView) findViewById(f.g.tv_play);
        this.gfk = (TextView) findViewById(f.g.tv_divider);
        this.gfl = (TextView) findViewById(f.g.tv_open_free_data);
        this.gfl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(f.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.gfm != null) {
                    PbVideoWifiTipLayout.this.gfm.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.gfj;
    }

    public TextView getTvOpenFreeData() {
        return this.gfl;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.gfm = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.gfh.setText(String.format(getResources().getString(f.j.pb_video_duration), ap.da(i * 1000)));
        } else {
            this.gfh.setVisibility(8);
            this.gfk.setVisibility(8);
        }
        if (i2 > 0) {
            this.gfi.setText(String.format(getResources().getString(f.j.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.gfi.setVisibility(8);
            this.gfk.setVisibility(8);
        }
        this.gfl.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.gfj.setOnClickListener(onClickListener);
    }
}
