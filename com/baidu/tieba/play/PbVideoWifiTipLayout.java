package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    private TextView ioS;
    private TextView ioT;
    private TextView ioU;
    private TextView ioV;
    private TextView ioW;
    private View.OnClickListener ioX;

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
        this.ioS = (TextView) findViewById(R.id.tv_video_duration);
        this.ioT = (TextView) findViewById(R.id.tv_video_data);
        this.ioU = (TextView) findViewById(R.id.tv_play);
        this.ioV = (TextView) findViewById(R.id.tv_divider);
        this.ioW = (TextView) findViewById(R.id.tv_open_free_data);
        this.ioW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.ioX != null) {
                    PbVideoWifiTipLayout.this.ioX.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.ioU;
    }

    public TextView getTvOpenFreeData() {
        return this.ioW;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.ioX = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.ioS.setText(String.format(getResources().getString(R.string.pb_video_duration), ap.im(i * 1000)));
        } else {
            this.ioS.setVisibility(8);
            this.ioV.setVisibility(8);
        }
        if (i2 > 0) {
            this.ioT.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.ioT.setVisibility(8);
            this.ioV.setVisibility(8);
        }
        this.ioW.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.ioU.setOnClickListener(onClickListener);
    }
}
