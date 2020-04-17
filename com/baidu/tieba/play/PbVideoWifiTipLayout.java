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
    private TextView kfX;
    private TextView kfY;
    private TextView kfZ;
    private TextView kga;
    private TextView kgb;
    private View.OnClickListener kgc;

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
        this.kfX = (TextView) findViewById(R.id.tv_video_duration);
        this.kfY = (TextView) findViewById(R.id.tv_video_data);
        this.kfZ = (TextView) findViewById(R.id.tv_play);
        this.kga = (TextView) findViewById(R.id.tv_divider);
        this.kgb = (TextView) findViewById(R.id.tv_open_free_data);
        this.kgb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.kgc != null) {
                    PbVideoWifiTipLayout.this.kgc.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.kfZ;
    }

    public TextView getTvOpenFreeData() {
        return this.kgb;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.kgc = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.kfX.setText(String.format(getResources().getString(R.string.pb_video_duration), aq.stringForVideoTime(i * 1000)));
        } else {
            this.kfX.setVisibility(8);
            this.kga.setVisibility(8);
        }
        if (i2 > 0) {
            this.kfY.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.kfY.setVisibility(8);
            this.kga.setVisibility(8);
        }
        this.kgb.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.kfZ.setOnClickListener(onClickListener);
    }
}
