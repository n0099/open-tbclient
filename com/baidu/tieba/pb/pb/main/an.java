package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class an extends k<com.baidu.tieba.pb.data.j, ao> {
    private View.OnTouchListener bDn;
    private com.baidu.tieba.pb.a.c bLJ;
    private FrameLayout cch;
    private com.baidu.tieba.pb.view.d fTy;
    public boolean fTz;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.bDn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (an.this.fTy != null) {
                    return an.this.fTy.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.cch = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.cch.setBackgroundResource(d.C0141d.transparent);
        this.cch.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.cch, layoutParams);
        this.fTy = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.cch);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ao onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = new ao(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bLJ != null && aoVar.mRootView != null) {
            aoVar.mRootView.setClickable(true);
            aoVar.mRootView.setOnTouchListener(this.bLJ);
        }
        return aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, ao aoVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, aoVar);
        if (jVar != null && aoVar != null) {
            aoVar.fTH.setOnClickListener(this.mClickListener);
            aoVar.fTF.setOnClickListener(this.mClickListener);
            aoVar.b(jVar);
            aoVar.fTD.setTag(d.g.pb_main_thread_praise_data, jVar);
            aoVar.fTD.setTag(d.g.pb_main_thread_praise_view, aoVar);
            ((ao) this.viewholder).fTE.setTag(d.g.pb_main_thread_praise_view, aoVar);
            aoVar.fTB.setTag(d.g.pb_main_thread_praise_view, aoVar);
            if (this.fTy != null) {
                this.fTy.setAnchorView(aoVar.fTB);
                this.fTy.cF(((ao) this.viewholder).fTE);
                this.fTy.setOnTouchListener(this.bDn);
            } else {
                aoVar.fTD.setOnClickListener(this.mClickListener);
            }
            aoVar.fTE.setOnClickListener(this.mClickListener);
            aoVar.fTC.setOnClickListener(this.mClickListener);
            if (this.fTz) {
                aoVar.beE();
            } else {
                aoVar.beD();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fTy != null) {
            this.fTy.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLJ = cVar;
    }

    public void sN(int i) {
        if (i == 3 && this.fNg != null && this.cch != null) {
            this.cch.removeAllViews();
            ((FrameLayout) this.fNg.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.cch);
        }
        this.fTy.sN(i);
    }

    public void n(boolean z, int i) {
        this.fTy.o(z, i);
    }
}
