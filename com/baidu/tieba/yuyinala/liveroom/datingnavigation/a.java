package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private w aFN;
    public DatingNavView oma;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Z(w wVar) {
        this.aFN = wVar;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
        if (this.aFN != null && this.oma != null) {
            this.oma.e(this.aFN, true);
        }
    }

    public void cR(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
        if (this.aFN != null && this.oma != null) {
            this.oma.e(this.aFN, false);
            this.oma.setVisibility(4);
        }
    }

    public void edq() {
        if (this.oma != null) {
            this.oma.setVisibility(0);
        }
    }

    private void aB(ViewGroup viewGroup) {
        if (this.aFN != null) {
            if (this.oma != null && this.oma.getParent() != null) {
                ((ViewGroup) this.oma.getParent()).removeView(this.oma);
            }
            this.oma = new DatingNavView(getPageContext().getPageActivity());
            this.oma.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.f.ala_liveroom_live_id);
            layoutParams.addRule(11);
            layoutParams.rightMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            layoutParams.width = BdUtilHelper.getScreenSize(getPageContext().getPageActivity()).widthPixels - BdUtilHelper.dip2px(getPageContext().getPageActivity(), 110.0f);
            viewGroup.addView(this.oma, layoutParams);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        super.En();
        if (this.oma != null && this.oma.getParent() != null) {
            ((ViewGroup) this.oma.getParent()).removeView(this.oma);
        }
        if (this.oma != null) {
            this.oma.destory();
            this.oma = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oma != null && this.oma.getParent() != null) {
            ((ViewGroup) this.oma.getParent()).removeView(this.oma);
        }
        if (this.oma != null) {
            this.oma.destory();
            this.oma = null;
        }
    }

    public void j(w wVar) {
        if (this.oma != null) {
            this.oma.j(wVar);
        }
    }
}
