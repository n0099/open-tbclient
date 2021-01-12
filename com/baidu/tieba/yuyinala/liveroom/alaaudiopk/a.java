package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aBr;
    public AlaChallengeLiveView ohZ;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Y(x xVar) {
        this.aBr = xVar;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
        if (this.aBr != null && this.ohZ != null) {
            this.ohZ.Z(this.aBr);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        if (this.ohZ != null && this.ohZ.getParent() != null) {
            ((ViewGroup) this.ohZ.getParent()).removeView(this.ohZ);
        }
        if (this.ohZ != null) {
            this.ohZ.destory();
            this.ohZ = null;
        }
    }

    public void showView() {
        if (this.ohZ != null) {
            this.ohZ.setVisibility(0);
        }
    }

    public void dpI() {
        if (this.ohZ != null) {
            this.ohZ.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ohZ != null && this.ohZ.getParent() != null) {
            ((ViewGroup) this.ohZ.getParent()).removeView(this.ohZ);
        }
        if (this.ohZ != null) {
            this.ohZ.destory();
            this.ohZ = null;
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.aBr != null) {
            if (this.ohZ != null && this.ohZ.getParent() != null) {
                ((ViewGroup) this.ohZ.getParent()).removeView(this.ohZ);
            }
            this.ohZ = new AlaChallengeLiveView(getPageContext().getPageActivity());
            this.ohZ.setId(a.f.ala_liveroom_live_pk_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_charm_rank);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds114);
            viewGroup.addView(this.ohZ, layoutParams);
        }
    }

    public void a(d dVar) {
        if (this.ohZ != null) {
            this.ohZ.a(dVar);
        }
    }
}
