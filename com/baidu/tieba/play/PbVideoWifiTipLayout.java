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
    private View.OnClickListener mxA;
    private TextView mxv;
    private TextView mxw;
    private TextView mxx;
    private TextView mxy;
    private TextView mxz;

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
        this.mxv = (TextView) findViewById(R.id.tv_video_duration);
        this.mxw = (TextView) findViewById(R.id.tv_video_data);
        this.mxx = (TextView) findViewById(R.id.tv_play);
        this.mxy = (TextView) findViewById(R.id.tv_divider);
        this.mxz = (TextView) findViewById(R.id.tv_open_free_data);
        this.mxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.mxA != null) {
                    PbVideoWifiTipLayout.this.mxA.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.mxx;
    }

    public TextView getTvOpenFreeData() {
        return this.mxz;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.mxA = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.mxv.setText(String.format(getResources().getString(R.string.pb_video_duration), au.stringForVideoTime(i * 1000)));
        } else {
            this.mxv.setVisibility(8);
            this.mxy.setVisibility(8);
        }
        if (i2 > 0) {
            this.mxw.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.mxw.setVisibility(8);
            this.mxy.setVisibility(8);
        }
        this.mxz.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.mxx.setOnClickListener(onClickListener);
    }
}
