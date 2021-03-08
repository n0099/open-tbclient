package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aLA;
    private String beL;
    private long gry;
    private long hPA;
    private String hPB;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;
    public CharmRankView owt;
    public boolean owu;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, boolean z2) {
        this.aLA = i;
        this.hPA = j;
        this.hPB = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beL = str4;
        this.gry = j2;
        this.otherParams = str3;
        this.owu = z2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.owt != null) {
            this.owt.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.owt != null && this.owt.getParent() != null) {
            ((ViewGroup) this.owt.getParent()).removeView(this.owt);
        }
        if (this.owt == null) {
            this.owt = new CharmRankView(getPageContext().getPageActivity());
        }
        this.owt.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        ebi();
        viewGroup.addView(this.owt, layoutParams);
    }

    public void zS(boolean z) {
        this.owu = z;
        ebi();
    }

    private void ebi() {
        if (this.owt != null) {
            if (this.owu) {
                this.owt.setTvText(getPageContext().getResources().getString(a.h.yuyin_ala_charm_tab_title));
            } else {
                this.owt.setTvText(getPageContext().getResources().getString(a.h.yuyin_ala_contribute_tab_title));
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        super.Au();
        if (this.owt != null && this.owt.getParent() != null) {
            ((ViewGroup) this.owt.getParent()).removeView(this.owt);
        }
        if (this.owt != null) {
            this.owt.destory();
            this.owt = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.owt != null) {
            this.owt.destory();
            this.owt = null;
        }
    }

    public void cky() {
    }

    public void ckz() {
    }
}
