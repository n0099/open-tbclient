package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.tieba.video.f;
/* loaded from: classes2.dex */
public class PbVideoNetworkStateTipView extends OperableVideoNetworkStateTipView {
    private TextView eBu;

    public PbVideoNetworkStateTipView(Context context) {
        super(context);
        init();
    }

    public PbVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PbVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public int getLayoutR() {
        return R.layout.pb_video_network_state_tip;
    }

    private void init() {
        this.eBu = (TextView) findViewById(R.id.video_net_tip_duration);
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public void setVideoDuration(int i) {
        if (i > 0) {
            this.eBu.setText(String.format(getResources().getString(R.string.pb_video_duration), au.stringForVideoTime(i * 1000)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public boolean dvB() {
        return (hasAgreeToPlay() || f.dSf().dSg() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.isMobileNet()) ? false : true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public void au(boolean z, boolean z2) {
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.free_flow) {
                com.baidu.tbadk.browser.a.startWebActivity(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            } else if (view.getId() == R.id.play) {
                if (this.mKI != null) {
                    this.mKI.onClick(view);
                }
                TiebaStatic.log("c12618");
            }
        }
    }
}
