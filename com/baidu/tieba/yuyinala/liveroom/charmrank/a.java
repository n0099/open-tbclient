package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aKa;
    private String bdj;
    private long gpB;
    private long hND;
    private String hNE;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView otN;
    public boolean otO;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, boolean z2) {
        this.aKa = i;
        this.hND = j;
        this.hNE = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdj = str4;
        this.gpB = j2;
        this.otherParams = str3;
        this.otO = z2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.otN != null) {
            this.otN.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.otN != null && this.otN.getParent() != null) {
            ((ViewGroup) this.otN.getParent()).removeView(this.otN);
        }
        if (this.otN == null) {
            this.otN = new CharmRankView(getPageContext().getPageActivity());
        }
        this.otN.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        eaS();
        viewGroup.addView(this.otN, layoutParams);
    }

    public void zT(boolean z) {
        this.otO = z;
        eaS();
    }

    private void eaS() {
        if (this.otN != null) {
            if (this.otO) {
                this.otN.setTvText(getPageContext().getResources().getString(a.h.yuyin_ala_charm_tab_title));
            } else {
                this.otN.setTvText(getPageContext().getResources().getString(a.h.yuyin_ala_contribute_tab_title));
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.otN != null && this.otN.getParent() != null) {
            ((ViewGroup) this.otN.getParent()).removeView(this.otN);
        }
        if (this.otN != null) {
            this.otN.destory();
            this.otN = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.otN != null) {
            this.otN.destory();
            this.otN = null;
        }
    }

    public void ckl() {
    }

    public void ckm() {
    }
}
