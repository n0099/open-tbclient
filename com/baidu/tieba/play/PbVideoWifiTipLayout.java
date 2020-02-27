package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView juq;
    private TextView jur;
    private TextView jus;
    private TextView jut;
    private TextView juu;
    private View.OnClickListener juv;

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
        inflate(getContext(), R.layout.layout_video_wifi_tip, this);
        this.juq = (TextView) findViewById(R.id.tv_video_duration);
        this.jur = (TextView) findViewById(R.id.tv_video_data);
        this.jus = (TextView) findViewById(R.id.tv_play);
        this.jut = (TextView) findViewById(R.id.tv_divider);
        this.juu = (TextView) findViewById(R.id.tv_open_free_data);
        this.juu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.juv != null) {
                    PbVideoWifiTipLayout.this.juv.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.jus;
    }

    public TextView getTvOpenFreeData() {
        return this.juu;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.juv = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.juq.setText(String.format(getResources().getString(R.string.pb_video_duration), aq.stringForVideoTime(i * 1000)));
        } else {
            this.juq.setVisibility(8);
            this.jut.setVisibility(8);
        }
        if (i2 > 0) {
            this.jur.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.jur.setVisibility(8);
            this.jut.setVisibility(8);
        }
        this.juu.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.jus.setOnClickListener(onClickListener);
    }
}
