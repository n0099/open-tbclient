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
    private TextView miW;
    private TextView miX;
    private TextView miY;
    private TextView miZ;
    private TextView mja;
    private View.OnClickListener mjb;

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
        this.miW = (TextView) findViewById(R.id.tv_video_duration);
        this.miX = (TextView) findViewById(R.id.tv_video_data);
        this.miY = (TextView) findViewById(R.id.tv_play);
        this.miZ = (TextView) findViewById(R.id.tv_divider);
        this.mja = (TextView) findViewById(R.id.tv_open_free_data);
        this.mja.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.startWebActivity(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.mjb != null) {
                    PbVideoWifiTipLayout.this.mjb.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.miY;
    }

    public TextView getTvOpenFreeData() {
        return this.mja;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.mjb = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.miW.setText(String.format(getResources().getString(R.string.pb_video_duration), at.stringForVideoTime(i * 1000)));
        } else {
            this.miW.setVisibility(8);
            this.miZ.setVisibility(8);
        }
        if (i2 > 0) {
            this.miX.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.miX.setVisibility(8);
            this.miZ.setVisibility(8);
        }
        this.mja.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.miY.setOnClickListener(onClickListener);
    }
}
