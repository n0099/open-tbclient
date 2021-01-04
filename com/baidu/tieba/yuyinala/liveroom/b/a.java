package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private b onG;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void d(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && xVar != null) {
                    if (this.onG != null && this.onG.getView().getParent() != null) {
                        ((ViewGroup) this.onG.getView().getParent()).removeView(this.onG.getView());
                    }
                    if (this.onG == null) {
                        this.onG = new b(this.mTbPageContext);
                    }
                    this.onG.getView().setId(a.f.ala_liveroom_live_id);
                    ccK();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.onG.getView(), layoutParams);
                    if (xVar.aLl != null && Long.valueOf(xVar.aLl.croom_id).longValue() != 0) {
                        this.onG.fw(Long.valueOf(xVar.aLl.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void ccK() {
        if (this.onG != null && this.onG.getView() != null && this.onG.getView().getParent() != null) {
            ((ViewGroup) this.onG.getView().getParent()).removeView(this.onG.getView());
        }
    }

    public void Id() {
    }
}
