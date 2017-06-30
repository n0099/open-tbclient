package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ga extends du<com.baidu.tieba.pb.data.m, gc> {
    private View.OnTouchListener aKv;
    private com.baidu.tieba.pb.a.d aPs;
    private View.OnClickListener bkk;
    private com.baidu.tieba.pb.view.l eBy;
    private FrameLayout eBz;

    /* JADX INFO: Access modifiers changed from: protected */
    public ga(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aKv = new gb(this);
        this.eBz = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eBz.setBackgroundResource(w.e.transparent);
        this.eBz.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.eBz, layoutParams);
        this.eBy = new com.baidu.tieba.pb.view.l(pbActivity.getPageContext().getPageActivity(), this.eBz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public gc onCreateViewHolder(ViewGroup viewGroup) {
        gc gcVar = new gc(LayoutInflater.from(this.mContext).inflate(w.j.layout_thread_praise_item, viewGroup, false));
        if (this.aPs != null && gcVar.mRootView != null) {
            gcVar.mRootView.setClickable(true);
            gcVar.mRootView.setOnTouchListener(this.aPs);
        }
        return gcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, gc gcVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, gcVar);
        if (mVar != null && gcVar != null) {
            gcVar.b(mVar);
            gcVar.eBB.setTag(w.h.pb_main_thread_praise_data, mVar);
            gcVar.eBB.setTag(w.h.pb_main_thread_praise_view, gcVar);
            if (this.eBy != null) {
                this.eBy.setAnchorView(gcVar.eBB);
                this.eBy.setOnTouchListener(this.aKv);
            } else {
                gcVar.eBB.setOnClickListener(this.bkk);
            }
            gcVar.eBC.setOnClickListener(this.bkk);
            gcVar.eBD.setOnClickListener(this.bkk);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bkk = onClickListener;
        if (this.eBy != null) {
            this.eBy.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        this.aPs = dVar;
    }

    public void oM(int i) {
        if (i == 3 && this.euf != null && this.eBz != null) {
            this.eBz.removeAllViews();
            ((FrameLayout) this.euf.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.eBz);
        }
        this.eBy.oM(i);
    }

    public void ji(boolean z) {
        this.eBy.cd(z);
    }
}
