package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aBr;
    public DatingNavView oko;

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
        if (this.aBr != null && this.oko != null) {
            this.oko.f(this.aBr, true);
        }
    }

    public void de(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
        if (this.aBr != null && this.oko != null) {
            this.oko.f(this.aBr, false);
            this.oko.setVisibility(4);
        }
    }

    public void dYI() {
        if (this.oko != null) {
            this.oko.setVisibility(0);
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.aBr != null) {
            if (this.oko != null && this.oko.getParent() != null) {
                ((ViewGroup) this.oko.getParent()).removeView(this.oko);
            }
            this.oko = new DatingNavView(getPageContext().getPageActivity());
            this.oko.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_live_id);
            layoutParams.addRule(11);
            layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            layoutParams.width = BdUtilHelper.getScreenSize(getPageContext().getPageActivity()).widthPixels - BdUtilHelper.dip2px(getPageContext().getPageActivity(), 110.0f);
            viewGroup.addView(this.oko, layoutParams);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        if (this.oko != null && this.oko.getParent() != null) {
            ((ViewGroup) this.oko.getParent()).removeView(this.oko);
        }
        if (this.oko != null) {
            this.oko.destory();
            this.oko = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oko != null && this.oko.getParent() != null) {
            ((ViewGroup) this.oko.getParent()).removeView(this.oko);
        }
        if (this.oko != null) {
            this.oko.destory();
            this.oko = null;
        }
    }

    public void k(x xVar) {
        if (this.oko != null) {
            this.oko.k(xVar);
        }
    }
}
