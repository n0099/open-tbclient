package com.baidu.tieba.yuyinala.liveroom.charmrank;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aLE;
    private String bdh;
    private long ggZ;
    private long hBI;
    private String hBJ;
    private boolean mIsHost;
    private String mPortrait;
    public CharmRankView olF;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aLE = i;
        this.hBI = j;
        this.hBJ = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdh = str4;
        this.ggZ = j2;
        this.otherParams = str3;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.olF != null) {
            this.olF.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
    }

    private void aB(ViewGroup viewGroup) {
        if (this.olF != null && this.olF.getParent() != null) {
            ((ViewGroup) this.olF.getParent()).removeView(this.olF);
        }
        if (this.olF == null) {
            this.olF = new CharmRankView(getPageContext().getPageActivity());
        }
        this.olF.setId(a.f.ala_liveroom_charm_rank);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_ranklist);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.olF, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        super.En();
        if (this.olF != null && this.olF.getParent() != null) {
            ((ViewGroup) this.olF.getParent()).removeView(this.olF);
        }
        if (this.olF != null) {
            this.olF.destory();
            this.olF = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.olF != null) {
            this.olF.destory();
            this.olF = null;
        }
    }

    public void cko() {
    }

    public void ckp() {
    }
}
