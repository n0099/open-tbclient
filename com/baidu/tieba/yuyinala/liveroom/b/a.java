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
    private b nOq;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void c(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && wVar != null) {
                    if (this.nOq != null && this.nOq.getView().getParent() != null) {
                        ((ViewGroup) this.nOq.getView().getParent()).removeView(this.nOq.getView());
                    }
                    if (this.nOq == null) {
                        this.nOq = new b(this.mTbPageContext);
                    }
                    bUz();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                    layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds58);
                    viewGroup.addView(this.nOq.getView(), layoutParams);
                    if (wVar.aIS != null) {
                        this.nOq.ew(Long.valueOf(wVar.aIS.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void bUz() {
        if (this.nOq != null && this.nOq.getView() != null && this.nOq.getView().getParent() != null) {
            ((ViewGroup) this.nOq.getView().getParent()).removeView(this.nOq.getView());
        }
    }

    public void GS() {
    }
}
