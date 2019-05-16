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
    private TextView ioO;
    private TextView ioP;
    private TextView ioQ;
    private TextView ioR;
    private TextView ioS;
    private View.OnClickListener ioT;

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
        this.ioO = (TextView) findViewById(R.id.tv_video_duration);
        this.ioP = (TextView) findViewById(R.id.tv_video_data);
        this.ioQ = (TextView) findViewById(R.id.tv_play);
        this.ioR = (TextView) findViewById(R.id.tv_divider);
        this.ioS = (TextView) findViewById(R.id.tv_open_free_data);
        this.ioS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.play.PbVideoWifiTipLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.browser.a.a(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                if (PbVideoWifiTipLayout.this.ioT != null) {
                    PbVideoWifiTipLayout.this.ioT.onClick(view);
                }
            }
        });
    }

    public TextView getTvPlay() {
        return this.ioQ;
    }

    public TextView getTvOpenFreeData() {
        return this.ioS;
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.ioT = onClickListener;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo != null) {
            setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
        }
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.ioO.setText(String.format(getResources().getString(R.string.pb_video_duration), ap.im(i * 1000)));
        } else {
            this.ioO.setVisibility(8);
            this.ioR.setVisibility(8);
        }
        if (i2 > 0) {
            this.ioP.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
        } else {
            this.ioP.setVisibility(8);
            this.ioR.setVisibility(8);
        }
        this.ioS.setVisibility(0);
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.ioQ.setOnClickListener(onClickListener);
    }
}
