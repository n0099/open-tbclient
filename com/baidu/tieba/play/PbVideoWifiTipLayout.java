package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView mHj;
    private TextView mHk;
    private TextView mHl;
    private TextView mHm;
    private TextView mHn;
    private View.OnClickListener mHo;

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
        this.mHj = (TextView) findViewById(R.id.tv_video_duration);
        this.mHk = (TextView) findViewById(R.id.tv_video_data);
        this.mHl = (TextView) findViewById(R.id.tv_play);
        this.mHm = (TextView) findViewById(R.id.tv_divider);
        this.mHn = (TextView) findViewById(R.id.tv_open_free_data);
        this.mHn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.mHo != null) {
                    PbVideoWifiTipLayout.this.mHo.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.mHl;
    }

    public TextView getTvOpenFreeData() {
        return this.mHn;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.mHo = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.mHj.setText(String.format(getResources().getString(R.string.pb_video_duration), au.stringForVideoTime(i * 1000)));
        } else {
            this.mHj.setVisibility(8);
            this.mHm.setVisibility(8);
        }
        if (i2 > 0) {
            this.mHk.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.mHk.setVisibility(8);
            this.mHm.setVisibility(8);
        }
        this.mHn.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.mHl.setOnClickListener(onClickListener);
    }
}
