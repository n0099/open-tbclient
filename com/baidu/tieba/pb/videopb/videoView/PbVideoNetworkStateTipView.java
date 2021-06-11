package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import d.a.c.e.p.j;
import d.a.m0.l.a;
import d.a.n0.r3.f;
/* loaded from: classes5.dex */
public class PbVideoNetworkStateTipView extends OperableVideoNetworkStateTipView {

    /* renamed from: i  reason: collision with root package name */
    public TextView f19581i;

    public PbVideoNetworkStateTipView(Context context) {
        super(context);
        c();
    }

    private void c() {
        this.f19581i = (TextView) findViewById(R.id.video_net_tip_duration);
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public void a(boolean z, boolean z2) {
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public boolean d() {
        return (b() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public int getLayoutR() {
        return R.layout.pb_video_network_state_tip;
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.free_flow) {
            a.u(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        } else if (view.getId() == R.id.play) {
            View.OnClickListener onClickListener = this.f20042g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TiebaStatic.log("c12618");
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public void setVideoDuration(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f19581i.setText(String.format(getResources().getString(R.string.pb_video_duration), StringHelper.stringForVideoTime(i2 * 1000)));
    }

    public PbVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public PbVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }
}
