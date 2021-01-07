package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aMi;
    private String beS;
    private long grz;
    private long hNL;
    private String hNM;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView ooA;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aMi = i;
        this.hNL = j;
        this.hNM = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beS = str4;
        this.grz = j2;
        this.otherParams = str3;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.ooA != null) {
            this.ooA.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.ooA != null && this.ooA.getParent() != null) {
            ((ViewGroup) this.ooA.getParent()).removeView(this.ooA);
        }
        if (this.ooA == null) {
            this.ooA = new CharmRankView(getPageContext().getPageActivity());
        }
        this.ooA.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.ooA, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.ooA != null && this.ooA.getParent() != null) {
            ((ViewGroup) this.ooA.getParent()).removeView(this.ooA);
        }
        if (this.ooA != null) {
            this.ooA.destory();
            this.ooA = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.ooA != null) {
            this.ooA.destory();
            this.ooA = null;
        }
    }

    public void cne() {
    }

    public void cnf() {
    }
}
