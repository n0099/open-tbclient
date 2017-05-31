package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fr extends dn<com.baidu.tieba.pb.data.m, ft> {
    private View.OnTouchListener aJg;
    private View.OnClickListener bhc;
    private com.baidu.tieba.pb.view.l esn;
    private FrameLayout eso;

    /* JADX INFO: Access modifiers changed from: protected */
    public fr(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aJg = new fs(this);
        this.eso = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eso.setBackgroundResource(w.e.transparent);
        this.eso.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.eso, layoutParams);
        this.esn = new com.baidu.tieba.pb.view.l(pbActivity.getPageContext().getPageActivity(), this.eso);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ft onCreateViewHolder(ViewGroup viewGroup) {
        return new ft(LayoutInflater.from(this.mContext).inflate(w.j.layout_thread_praise_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, ft ftVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, ftVar);
        if (mVar != null && ftVar != null) {
            ftVar.b(mVar);
            ftVar.esq.setTag(w.h.pb_main_thread_praise_data, mVar);
            ftVar.esq.setTag(w.h.pb_main_thread_praise_view, ftVar);
            if (this.esn != null) {
                this.esn.setAnchorView(ftVar.esq);
                this.esn.setOnTouchListener(this.aJg);
            } else {
                ftVar.esq.setOnClickListener(this.bhc);
            }
            ftVar.esr.setOnClickListener(this.bhc);
            ftVar.ess.setOnClickListener(this.bhc);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bhc = onClickListener;
        if (this.esn != null) {
            this.esn.setOnClickListener(onClickListener);
        }
    }

    public void ov(int i) {
        if (i == 3 && this.elf != null && this.eso != null) {
            this.eso.removeAllViews();
            ((FrameLayout) this.elf.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.eso);
        }
        this.esn.ov(i);
    }

    public void iM(boolean z) {
        this.esn.cb(z);
    }
}
