package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private b ovz;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void d(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && abVar != null) {
                    if (this.ovz != null && this.ovz.getView().getParent() != null) {
                        ((ViewGroup) this.ovz.getView().getParent()).removeView(this.ovz.getView());
                    }
                    if (this.ovz == null) {
                        this.ovz = new b(this.mTbPageContext);
                    }
                    this.ovz.getView().setId(a.f.ala_liveroom_live_id);
                    cac();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.ovz.getView(), layoutParams);
                    if (abVar.aKu != null && Long.valueOf(abVar.aKu.croom_id).longValue() != 0) {
                        this.ovz.fB(Long.valueOf(abVar.aKu.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void cac() {
        if (this.ovz != null && this.ovz.getView() != null && this.ovz.getView().getParent() != null) {
            ((ViewGroup) this.ovz.getView().getParent()).removeView(this.ovz.getView());
        }
    }

    public void FB() {
    }
}
