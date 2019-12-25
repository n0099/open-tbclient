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
    private TextView jpX;
    private TextView jpY;
    private TextView jpZ;
    private TextView jqa;
    private TextView jqb;
    private View.OnClickListener jqc;

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
        this.jpX = (TextView) findViewById(R.id.tv_video_duration);
        this.jpY = (TextView) findViewById(R.id.tv_video_data);
        this.jpZ = (TextView) findViewById(R.id.tv_play);
        this.jqa = (TextView) findViewById(R.id.tv_divider);
        this.jqb = (TextView) findViewById(R.id.tv_open_free_data);
        this.jqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.jqc != null) {
                    PbVideoWifiTipLayout.this.jqc.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.jpZ;
    }

    public TextView getTvOpenFreeData() {
        return this.jqb;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.jqc = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.jpX.setText(String.format(getResources().getString(R.string.pb_video_duration), aq.stringForVideoTime(i * 1000)));
        } else {
            this.jpX.setVisibility(8);
            this.jqa.setVisibility(8);
        }
        if (i2 > 0) {
            this.jpY.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.jpY.setVisibility(8);
            this.jqa.setVisibility(8);
        }
        this.jqb.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.jpZ.setOnClickListener(onClickListener);
    }
}
