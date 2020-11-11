package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aKw;
    private String bbt;
    private long fZh;
    private long hsx;
    private String hsy;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView nVe;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aKw = i;
        this.hsx = j;
        this.hsy = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bbt = str4;
        this.fZh = j2;
        this.otherParams = str3;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.nVe != null) {
            this.nVe.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        aF(viewGroup);
    }

    private void aF(ViewGroup viewGroup) {
        if (this.nVe != null && this.nVe.getParent() != null) {
            ((ViewGroup) this.nVe.getParent()).removeView(this.nVe);
        }
        if (this.nVe == null) {
            this.nVe = new CharmRankView(getPageContext().getPageActivity());
        }
        this.nVe.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.nVe, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.nVe != null && this.nVe.getParent() != null) {
            ((ViewGroup) this.nVe.getParent()).removeView(this.nVe);
        }
        if (this.nVe != null) {
            this.nVe.destory();
            this.nVe = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nVe != null) {
            this.nVe.destory();
            this.nVe = null;
        }
    }

    public void chb() {
    }

    public void chc() {
    }
}
