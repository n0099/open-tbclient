package com.baidu.tieba.play;

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
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private View.OnClickListener hWA;
    private TextView hWv;
    private TextView hWw;
    private TextView hWx;
    private TextView hWy;
    private TextView hWz;

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
        this.hWv = (TextView) findViewById(d.g.tv_video_duration);
        this.hWw = (TextView) findViewById(d.g.tv_video_data);
        this.hWx = (TextView) findViewById(d.g.tv_play);
        this.hWy = (TextView) findViewById(d.g.tv_divider);
        this.hWz = (TextView) findViewById(d.g.tv_open_free_data);
        this.hWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.hWA != null) {
                    PbVideoWifiTipLayout.this.hWA.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.hWx;
    }

    public TextView getTvOpenFreeData() {
        return this.hWz;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.hWA = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.hWv.setText(String.format(getResources().getString(d.j.pb_video_duration), ap.hz(i * 1000)));
        } else {
            this.hWv.setVisibility(8);
            this.hWy.setVisibility(8);
        }
        if (i2 > 0) {
            this.hWw.setText(String.format(getResources().getString(d.j.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.hWw.setVisibility(8);
            this.hWy.setVisibility(8);
        }
        this.hWz.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.hWx.setOnClickListener(onClickListener);
    }
}
