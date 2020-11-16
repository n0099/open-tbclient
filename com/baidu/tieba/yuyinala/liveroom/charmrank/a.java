package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aIL;
    private String aZH;
    private long fYO;
    private long hse;
    private String hsf;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView nWH;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aIL = i;
        this.hse = j;
        this.hsf = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aZH = str4;
        this.fYO = j2;
        this.otherParams = str3;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.nWH != null) {
            this.nWH.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
    }

    private void aB(ViewGroup viewGroup) {
        if (this.nWH != null && this.nWH.getParent() != null) {
            ((ViewGroup) this.nWH.getParent()).removeView(this.nWH);
        }
        if (this.nWH == null) {
            this.nWH = new CharmRankView(getPageContext().getPageActivity());
        }
        this.nWH.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.nWH, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CD() {
        super.CD();
        if (this.nWH != null && this.nWH.getParent() != null) {
            ((ViewGroup) this.nWH.getParent()).removeView(this.nWH);
        }
        if (this.nWH != null) {
            this.nWH.destory();
            this.nWH = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nWH != null) {
            this.nWH.destory();
            this.nWH = null;
        }
    }

    public void cgu() {
    }

    public void cgv() {
    }
}
