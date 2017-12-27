package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ao extends m<com.baidu.tieba.pb.data.l, ap> {
    private View.OnTouchListener bBc;
    private com.baidu.tieba.pb.a.c bJy;
    private FrameLayout bZR;
    private com.baidu.tieba.pb.view.d fOm;
    public boolean fOn;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.bBc = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ao.this.fOm != null) {
                    return ao.this.fOm.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bZR = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bZR.setBackgroundResource(d.C0108d.transparent);
        this.bZR.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bZR, layoutParams);
        this.fOm = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bZR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public ap onCreateViewHolder(ViewGroup viewGroup) {
        ap apVar = new ap(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bJy != null && apVar.mRootView != null) {
            apVar.mRootView.setClickable(true);
            apVar.mRootView.setOnTouchListener(this.bJy);
        }
        return apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, ap apVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, apVar);
        if (lVar != null && apVar != null) {
            apVar.fOv.setOnClickListener(this.mClickListener);
            apVar.fOt.setOnClickListener(this.mClickListener);
            apVar.b(lVar);
            apVar.fOr.setTag(d.g.pb_main_thread_praise_data, lVar);
            apVar.fOr.setTag(d.g.pb_main_thread_praise_view, apVar);
            ((ap) this.viewholder).fOs.setTag(d.g.pb_main_thread_praise_view, apVar);
            apVar.fOp.setTag(d.g.pb_main_thread_praise_view, apVar);
            if (this.fOm != null) {
                this.fOm.setAnchorView(apVar.fOp);
                this.fOm.cE(((ap) this.viewholder).fOs);
                this.fOm.setOnTouchListener(this.bBc);
            } else {
                apVar.fOr.setOnClickListener(this.mClickListener);
            }
            apVar.fOs.setOnClickListener(this.mClickListener);
            apVar.fOq.setOnClickListener(this.mClickListener);
            if (this.fOn) {
                apVar.bcT();
            } else {
                apVar.bcS();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fOm != null) {
            this.fOm.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJy = cVar;
    }

    public void sQ(int i) {
        if (i == 3 && this.fHW != null && this.bZR != null) {
            this.bZR.removeAllViews();
            ((FrameLayout) this.fHW.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bZR);
        }
        this.fOm.sQ(i);
    }

    public void m(boolean z, int i) {
        this.fOm.n(z, i);
    }
}
