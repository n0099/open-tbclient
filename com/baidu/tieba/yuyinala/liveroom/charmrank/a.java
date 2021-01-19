package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aHv;
    private String bac;
    private long gmS;
    private long hJf;
    private String hJg;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView ojV;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aHv = i;
        this.hJf = j;
        this.hJg = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bac = str4;
        this.gmS = j2;
        this.otherParams = str3;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.ojV != null) {
            this.ojV.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.ojV != null && this.ojV.getParent() != null) {
            ((ViewGroup) this.ojV.getParent()).removeView(this.ojV);
        }
        if (this.ojV == null) {
            this.ojV = new CharmRankView(getPageContext().getPageActivity());
        }
        this.ojV.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.ojV, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        if (this.ojV != null && this.ojV.getParent() != null) {
            ((ViewGroup) this.ojV.getParent()).removeView(this.ojV);
        }
        if (this.ojV != null) {
            this.ojV.destory();
            this.ojV = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ojV != null) {
            this.ojV.destory();
            this.ojV = null;
        }
    }

    public void cjm() {
    }

    public void cjn() {
    }
}
