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
    private b ott;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
    }

    public void d(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null) {
            try {
                if (this.mTbPageContext != null && abVar != null) {
                    if (this.ott != null && this.ott.getView().getParent() != null) {
                        ((ViewGroup) this.ott.getView().getParent()).removeView(this.ott.getView());
                    }
                    if (this.ott == null) {
                        this.ott = new b(this.mTbPageContext);
                    }
                    this.ott.getView().setId(a.f.ala_liveroom_live_id);
                    bZW();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                    layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
                    layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    viewGroup.addView(this.ott.getView(), layoutParams);
                    if (abVar.aIU != null && Long.valueOf(abVar.aIU.croom_id).longValue() != 0) {
                        this.ott.fB(Long.valueOf(abVar.aIU.croom_id).longValue());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void bZW() {
        if (this.ott != null && this.ott.getView() != null && this.ott.getView().getParent() != null) {
            ((ViewGroup) this.ott.getView().getParent()).removeView(this.ott.getView());
        }
    }

    public void Fy() {
    }
}
