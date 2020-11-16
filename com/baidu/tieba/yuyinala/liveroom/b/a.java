package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private b nVQ;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void c(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && wVar != null) {
                    if (this.nVQ != null && this.nVQ.getView().getParent() != null) {
                        ((ViewGroup) this.nVQ.getView().getParent()).removeView(this.nVQ.getView());
                    }
                    if (this.nVQ == null) {
                        this.nVQ = new b(this.mTbPageContext);
                    }
                    this.nVQ.getView().setId(a.f.ala_liveroom_live_id);
                    bWs();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.nVQ.getView(), layoutParams);
                    if (wVar.aHZ != null) {
                        this.nVQ.eS(Long.valueOf(wVar.aHZ.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void bWs() {
        if (this.nVQ != null && this.nVQ.getView() != null && this.nVQ.getView().getParent() != null) {
            ((ViewGroup) this.nVQ.getView().getParent()).removeView(this.nVQ.getView());
        }
    }

    public void GK() {
    }
}
