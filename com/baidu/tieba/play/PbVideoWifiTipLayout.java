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
    private TextView kxR;
    private TextView kxS;
    private TextView kxT;
    private TextView kxU;
    private TextView kxV;
    private View.OnClickListener kxW;

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
        this.kxR = (TextView) findViewById(R.id.tv_video_duration);
        this.kxS = (TextView) findViewById(R.id.tv_video_data);
        this.kxT = (TextView) findViewById(R.id.tv_play);
        this.kxU = (TextView) findViewById(R.id.tv_divider);
        this.kxV = (TextView) findViewById(R.id.tv_open_free_data);
        this.kxV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.kxW != null) {
                    PbVideoWifiTipLayout.this.kxW.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.kxT;
    }

    public TextView getTvOpenFreeData() {
        return this.kxV;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.kxW = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.kxR.setText(String.format(getResources().getString(R.string.pb_video_duration), aq.stringForVideoTime(i * 1000)));
        } else {
            this.kxR.setVisibility(8);
            this.kxU.setVisibility(8);
        }
        if (i2 > 0) {
            this.kxS.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.kxS.setVisibility(8);
            this.kxU.setVisibility(8);
        }
        this.kxV.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.kxT.setOnClickListener(onClickListener);
    }
}
