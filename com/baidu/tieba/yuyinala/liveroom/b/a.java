package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private b oja;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void d(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && xVar != null) {
                    if (this.oja != null && this.oja.getView().getParent() != null) {
                        ((ViewGroup) this.oja.getView().getParent()).removeView(this.oja.getView());
                    }
                    if (this.oja == null) {
                        this.oja = new b(this.mTbPageContext);
                    }
                    this.oja.getView().setId(a.f.ala_liveroom_live_id);
                    bYT();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.oja.getView(), layoutParams);
                    if (xVar.aGy != null && Long.valueOf(xVar.aGy.croom_id).longValue() != 0) {
                        this.oja.fw(Long.valueOf(xVar.aGy.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void bYT() {
        if (this.oja != null && this.oja.getView() != null && this.oja.getView().getParent() != null) {
            ((ViewGroup) this.oja.getView().getParent()).removeView(this.oja.getView());
        }
    }

    public void Ei() {
    }
}
