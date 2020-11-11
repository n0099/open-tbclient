package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private w aES;
    public DatingNavView nVx;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void U(w wVar) {
        this.aES = wVar;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        aF(viewGroup);
        if (this.aES != null && this.nVx != null) {
            this.nVx.e(this.aES, true);
        }
    }

    public void cS(ViewGroup viewGroup) {
        super.ax(viewGroup);
        aF(viewGroup);
        if (this.aES != null && this.nVx != null) {
            this.nVx.e(this.aES, false);
            this.nVx.setVisibility(4);
        }
    }

    public void dXM() {
        if (this.nVx != null) {
            this.nVx.setVisibility(0);
        }
    }

    private void aF(ViewGroup viewGroup) {
        if (this.aES != null) {
            if (this.nVx != null && this.nVx.getParent() != null) {
                ((ViewGroup) this.nVx.getParent()).removeView(this.nVx);
            }
            this.nVx = new DatingNavView(getPageContext().getPageActivity());
            this.nVx.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_live_id);
            layoutParams.addRule(11);
            layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            layoutParams.width = BdUtilHelper.getScreenSize(getPageContext().getPageActivity()).widthPixels - BdUtilHelper.dip2px(getPageContext().getPageActivity(), 110.0f);
            viewGroup.addView(this.nVx, layoutParams);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.nVx != null && this.nVx.getParent() != null) {
            ((ViewGroup) this.nVx.getParent()).removeView(this.nVx);
        }
        if (this.nVx != null) {
            this.nVx.destory();
            this.nVx = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nVx != null && this.nVx.getParent() != null) {
            ((ViewGroup) this.nVx.getParent()).removeView(this.nVx);
        }
        if (this.nVx != null) {
            this.nVx.destory();
            this.nVx = null;
        }
    }

    public void j(w wVar) {
        if (this.nVx != null) {
            this.nVx.j(wVar);
        }
    }
}
