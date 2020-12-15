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
    private b okQ;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void d(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && wVar != null) {
                    if (this.okQ != null && this.okQ.getView().getParent() != null) {
                        ((ViewGroup) this.okQ.getView().getParent()).removeView(this.okQ.getView());
                    }
                    if (this.okQ == null) {
                        this.okQ = new b(this.mTbPageContext);
                    }
                    this.okQ.getView().setId(a.f.ala_liveroom_live_id);
                    cad();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.okQ.getView(), layoutParams);
                    if (wVar.aKL != null) {
                        this.okQ.fw(Long.valueOf(wVar.aKL.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void cad() {
        if (this.okQ != null && this.okQ.getView() != null && this.okQ.getView().getParent() != null) {
            ((ViewGroup) this.okQ.getView().getParent()).removeView(this.okQ.getView());
        }
    }

    public void IB() {
    }
}
