package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private w aDh;
    public DatingNavView nXa;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void U(w wVar) {
        this.aDh = wVar;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
        if (this.aDh != null && this.nXa != null) {
            this.nXa.e(this.aDh, true);
        }
    }

    public void cO(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
        if (this.aDh != null && this.nXa != null) {
            this.nXa.e(this.aDh, false);
            this.nXa.setVisibility(4);
        }
    }

    public void dXL() {
        if (this.nXa != null) {
            this.nXa.setVisibility(0);
        }
    }

    private void aB(ViewGroup viewGroup) {
        if (this.aDh != null) {
            if (this.nXa != null && this.nXa.getParent() != null) {
                ((ViewGroup) this.nXa.getParent()).removeView(this.nXa);
            }
            this.nXa = new DatingNavView(getPageContext().getPageActivity());
            this.nXa.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_live_id);
            layoutParams.addRule(11);
            layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            layoutParams.width = BdUtilHelper.getScreenSize(getPageContext().getPageActivity()).widthPixels - BdUtilHelper.dip2px(getPageContext().getPageActivity(), 110.0f);
            viewGroup.addView(this.nXa, layoutParams);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CD() {
        super.CD();
        if (this.nXa != null && this.nXa.getParent() != null) {
            ((ViewGroup) this.nXa.getParent()).removeView(this.nXa);
        }
        if (this.nXa != null) {
            this.nXa.destory();
            this.nXa = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nXa != null && this.nXa.getParent() != null) {
            ((ViewGroup) this.nXa.getParent()).removeView(this.nXa);
        }
        if (this.nXa != null) {
            this.nXa.destory();
            this.nXa = null;
        }
    }

    public void j(w wVar) {
        if (this.nXa != null) {
            this.nXa.j(wVar);
        }
    }
}
