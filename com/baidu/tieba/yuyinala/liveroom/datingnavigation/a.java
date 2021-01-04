package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aGe;
    public DatingNavView ooV;

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
        if (this.aGe != null && this.ooV != null) {
            this.ooV.f(this.aGe, true);
        }
    }

    public void de(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
        if (this.aGe != null && this.ooV != null) {
            this.ooV.f(this.aGe, false);
            this.ooV.setVisibility(4);
        }
    }

    public void ecz() {
        if (this.ooV != null) {
            this.ooV.setVisibility(0);
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.aGe != null) {
            if (this.ooV != null && this.ooV.getParent() != null) {
                ((ViewGroup) this.ooV.getParent()).removeView(this.ooV);
            }
            this.ooV = new DatingNavView(getPageContext().getPageActivity());
            this.ooV.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_live_id);
            layoutParams.addRule(11);
            layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            layoutParams.width = BdUtilHelper.getScreenSize(getPageContext().getPageActivity()).widthPixels - BdUtilHelper.dip2px(getPageContext().getPageActivity(), 110.0f);
            viewGroup.addView(this.ooV, layoutParams);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.ooV != null && this.ooV.getParent() != null) {
            ((ViewGroup) this.ooV.getParent()).removeView(this.ooV);
        }
        if (this.ooV != null) {
            this.ooV.destory();
            this.ooV = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ooV != null && this.ooV.getParent() != null) {
            ((ViewGroup) this.ooV.getParent()).removeView(this.ooV);
        }
        if (this.ooV != null) {
            this.ooV.destory();
            this.ooV = null;
        }
    }

    public void k(x xVar) {
        if (this.ooV != null) {
            this.ooV.k(xVar);
        }
    }
}
