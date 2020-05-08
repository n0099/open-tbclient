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
    private TextView kgb;
    private TextView kgc;
    private TextView kgd;
    private TextView kge;
    private TextView kgf;
    private View.OnClickListener kgg;

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
        this.kgb = (TextView) findViewById(R.id.tv_video_duration);
        this.kgc = (TextView) findViewById(R.id.tv_video_data);
        this.kgd = (TextView) findViewById(R.id.tv_play);
        this.kge = (TextView) findViewById(R.id.tv_divider);
        this.kgf = (TextView) findViewById(R.id.tv_open_free_data);
        this.kgf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.kgg != null) {
                    PbVideoWifiTipLayout.this.kgg.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.kgd;
    }

    public TextView getTvOpenFreeData() {
        return this.kgf;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.kgg = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.kgb.setText(String.format(getResources().getString(R.string.pb_video_duration), aq.stringForVideoTime(i * 1000)));
        } else {
            this.kgb.setVisibility(8);
            this.kge.setVisibility(8);
        }
        if (i2 > 0) {
            this.kgc.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.kgc.setVisibility(8);
            this.kge.setVisibility(8);
        }
        this.kgf.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.kgd.setOnClickListener(onClickListener);
    }
}
