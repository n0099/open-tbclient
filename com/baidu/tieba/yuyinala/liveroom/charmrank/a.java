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
    private long gpP;
    private long hNR;
    private String hNS;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;
    public CharmRankView oun;
    public boolean ouo;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, boolean z2) {
        this.aKa = i;
        this.hNR = j;
        this.hNS = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdj = str4;
        this.gpP = j2;
        this.otherParams = str3;
        this.ouo = z2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.oun != null) {
            this.oun.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.oun != null && this.oun.getParent() != null) {
            ((ViewGroup) this.oun.getParent()).removeView(this.oun);
        }
        if (this.oun == null) {
            this.oun = new CharmRankView(getPageContext().getPageActivity());
        }
        this.oun.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        eba();
        viewGroup.addView(this.oun, layoutParams);
    }

    public void zT(boolean z) {
        this.ouo = z;
        eba();
    }

    private void eba() {
        if (this.oun != null) {
            if (this.ouo) {
                this.oun.setTvText(getPageContext().getResources().getString(a.h.yuyin_ala_charm_tab_title));
            } else {
                this.oun.setTvText(getPageContext().getResources().getString(a.h.yuyin_ala_contribute_tab_title));
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.oun != null && this.oun.getParent() != null) {
            ((ViewGroup) this.oun.getParent()).removeView(this.oun);
        }
        if (this.oun != null) {
            this.oun.destory();
            this.oun = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oun != null) {
            this.oun.destory();
            this.oun = null;
        }
    }

    public void cks() {
    }

    public void ckt() {
    }
}
