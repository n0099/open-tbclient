package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aGe;
    public AlaChallengeLiveView omF;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Y(x xVar) {
        this.aGe = xVar;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
        if (this.aGe != null && this.omF != null) {
            this.omF.Z(this.aGe);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.omF != null && this.omF.getParent() != null) {
            ((ViewGroup) this.omF.getParent()).removeView(this.omF);
        }
        if (this.omF != null) {
            this.omF.destory();
            this.omF = null;
        }
    }

    public void showView() {
        if (this.omF != null) {
            this.omF.setVisibility(0);
        }
    }

    public void dtz() {
        if (this.omF != null) {
            this.omF.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.omF != null && this.omF.getParent() != null) {
            ((ViewGroup) this.omF.getParent()).removeView(this.omF);
        }
        if (this.omF != null) {
            this.omF.destory();
            this.omF = null;
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.aGe != null) {
            if (this.omF != null && this.omF.getParent() != null) {
                ((ViewGroup) this.omF.getParent()).removeView(this.omF);
            }
            this.omF = new AlaChallengeLiveView(getPageContext().getPageActivity());
            this.omF.setId(a.f.ala_liveroom_live_pk_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_charm_rank);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds114);
            viewGroup.addView(this.omF, layoutParams);
        }
    }

    public void a(d dVar) {
        if (this.omF != null) {
            this.omF.a(dVar);
        }
    }
}
