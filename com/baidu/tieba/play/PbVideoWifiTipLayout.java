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
    private TextView mJF;
    private TextView mJG;
    private TextView mJH;
    private TextView mJI;
    private TextView mJJ;
    private View.OnClickListener mJK;

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
        this.mJF = (TextView) findViewById(R.id.tv_video_duration);
        this.mJG = (TextView) findViewById(R.id.tv_video_data);
        this.mJH = (TextView) findViewById(R.id.tv_play);
        this.mJI = (TextView) findViewById(R.id.tv_divider);
        this.mJJ = (TextView) findViewById(R.id.tv_open_free_data);
        this.mJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.mJK != null) {
                    PbVideoWifiTipLayout.this.mJK.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.mJH;
    }

    public TextView getTvOpenFreeData() {
        return this.mJJ;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.mJK = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.mJF.setText(String.format(getResources().getString(R.string.pb_video_duration), au.stringForVideoTime(i * 1000)));
        } else {
            this.mJF.setVisibility(8);
            this.mJI.setVisibility(8);
        }
        if (i2 > 0) {
            this.mJG.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.mJG.setVisibility(8);
            this.mJI.setVisibility(8);
        }
        this.mJJ.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.mJH.setOnClickListener(onClickListener);
    }
}
