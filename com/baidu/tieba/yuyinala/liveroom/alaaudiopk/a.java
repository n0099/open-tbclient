package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aGe;
    public AlaChallengeLiveView omE;

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
        if (this.aGe != null && this.omE != null) {
            this.omE.Z(this.aGe);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.omE != null && this.omE.getParent() != null) {
            ((ViewGroup) this.omE.getParent()).removeView(this.omE);
        }
        if (this.omE != null) {
            this.omE.destory();
            this.omE = null;
        }
    }

    public void showView() {
        if (this.omE != null) {
            this.omE.setVisibility(0);
        }
    }

    public void dtA() {
        if (this.omE != null) {
            this.omE.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.omE != null && this.omE.getParent() != null) {
            ((ViewGroup) this.omE.getParent()).removeView(this.omE);
        }
        if (this.omE != null) {
            this.omE.destory();
            this.omE = null;
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.aGe != null) {
            if (this.omE != null && this.omE.getParent() != null) {
                ((ViewGroup) this.omE.getParent()).removeView(this.omE);
            }
            this.omE = new AlaChallengeLiveView(getPageContext().getPageActivity());
            this.omE.setId(a.f.ala_liveroom_live_pk_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_charm_rank);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds114);
            viewGroup.addView(this.omE, layoutParams);
        }
    }

    public void a(d dVar) {
        if (this.omE != null) {
            this.omE.a(dVar);
        }
    }
}
