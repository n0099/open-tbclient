package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private b osT;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void d(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && abVar != null) {
                    if (this.osT != null && this.osT.getView().getParent() != null) {
                        ((ViewGroup) this.osT.getView().getParent()).removeView(this.osT.getView());
                    }
                    if (this.osT == null) {
                        this.osT = new b(this.mTbPageContext);
                    }
                    this.osT.getView().setId(a.f.ala_liveroom_live_id);
                    bZP();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.osT.getView(), layoutParams);
                    if (abVar.aIU != null && Long.valueOf(abVar.aIU.croom_id).longValue() != 0) {
                        this.osT.fB(Long.valueOf(abVar.aIU.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void bZP() {
        if (this.osT != null && this.osT.getView() != null && this.osT.getView().getParent() != null) {
            ((ViewGroup) this.osT.getView().getParent()).removeView(this.osT.getView());
        }
    }

    public void Fy() {
    }
}
