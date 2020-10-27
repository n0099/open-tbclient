package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aJw;
    private String baa;
    private long fTr;
    private String hmA;
    private long hmz;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView nPg;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aJw = i;
        this.hmz = j;
        this.hmA = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.baa = str4;
        this.fTr = j2;
        this.otherParams = str3;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.nPg != null) {
            this.nPg.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        aD(viewGroup);
    }

    private void aD(ViewGroup viewGroup) {
        if (this.nPg != null && this.nPg.getParent() != null) {
            ((ViewGroup) this.nPg.getParent()).removeView(this.nPg);
        }
        if (this.nPg == null) {
            this.nPg = new CharmRankView(getPageContext().getPageActivity());
        }
        this.nPg.setId(a.g.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.g.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
        viewGroup.addView(this.nPg, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CT() {
        super.CT();
        if (this.nPg != null && this.nPg.getParent() != null) {
            ((ViewGroup) this.nPg.getParent()).removeView(this.nPg);
        }
        if (this.nPg != null) {
            this.nPg.destory();
            this.nPg = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nPg != null) {
            this.nPg.destory();
            this.nPg = null;
        }
    }

    public void cey() {
    }

    public void cez() {
    }
}
