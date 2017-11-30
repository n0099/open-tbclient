package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class an extends m<com.baidu.tieba.pb.data.l, ao> {
    private View.OnTouchListener aNj;
    private com.baidu.tieba.pb.a.c aVF;
    private FrameLayout bmC;
    private com.baidu.tieba.pb.view.d fam;
    public boolean fan;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aNj = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (an.this.fam != null) {
                    return an.this.fam.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bmC = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bmC.setBackgroundResource(d.C0082d.transparent);
        this.bmC.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bmC, layoutParams);
        this.fam = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bmC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public ao onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = new ao(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.aVF != null && aoVar.mRootView != null) {
            aoVar.mRootView.setClickable(true);
            aoVar.mRootView.setOnTouchListener(this.aVF);
        }
        return aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, ao aoVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, aoVar);
        if (lVar != null && aoVar != null) {
            aoVar.b(lVar);
            aoVar.far.setTag(d.g.pb_main_thread_praise_data, lVar);
            aoVar.far.setTag(d.g.pb_main_thread_praise_view, aoVar);
            ((ao) this.viewholder).fas.setTag(d.g.pb_main_thread_praise_view, aoVar);
            aoVar.fap.setTag(d.g.pb_main_thread_praise_view, aoVar);
            if (this.fam != null) {
                this.fam.setAnchorView(aoVar.fap);
                this.fam.bp(((ao) this.viewholder).fas);
                this.fam.setOnTouchListener(this.aNj);
            } else {
                aoVar.far.setOnClickListener(this.mClickListener);
            }
            aoVar.fas.setOnClickListener(this.mClickListener);
            aoVar.faq.setOnClickListener(this.mClickListener);
            aoVar.fav.setOnClickListener(this.mClickListener);
            aoVar.fat.setOnClickListener(this.mClickListener);
            if (this.fan) {
                aoVar.aVx();
            } else {
                aoVar.aVw();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fam != null) {
            this.fam.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVF = cVar;
    }

    public void pP(int i) {
        if (i == 3 && this.eUm != null && this.bmC != null) {
            this.bmC.removeAllViews();
            ((FrameLayout) this.eUm.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bmC);
        }
        this.fam.pP(i);
    }

    public void j(boolean z, int i) {
        this.fam.k(z, i);
    }
}
