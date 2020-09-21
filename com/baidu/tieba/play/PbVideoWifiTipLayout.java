package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView lBk;
    private TextView lBl;
    private TextView lBm;
    private TextView lBn;
    private TextView lBo;
    private View.OnClickListener lBp;

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
        this.lBk = (TextView) findViewById(R.id.tv_video_duration);
        this.lBl = (TextView) findViewById(R.id.tv_video_data);
        this.lBm = (TextView) findViewById(R.id.tv_play);
        this.lBn = (TextView) findViewById(R.id.tv_divider);
        this.lBo = (TextView) findViewById(R.id.tv_open_free_data);
        this.lBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.lBp != null) {
                    PbVideoWifiTipLayout.this.lBp.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.lBm;
    }

    public TextView getTvOpenFreeData() {
        return this.lBo;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.lBp = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.lBk.setText(String.format(getResources().getString(R.string.pb_video_duration), at.stringForVideoTime(i * 1000)));
        } else {
            this.lBk.setVisibility(8);
            this.lBn.setVisibility(8);
        }
        if (i2 > 0) {
            this.lBl.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.lBl.setVisibility(8);
            this.lBn.setVisibility(8);
        }
        this.lBo.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.lBm.setOnClickListener(onClickListener);
    }
}
