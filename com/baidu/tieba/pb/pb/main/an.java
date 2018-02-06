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
    private View.OnTouchListener bDx;
    private com.baidu.tieba.pb.a.c bLT;
    private FrameLayout ccq;
    private com.baidu.tieba.pb.view.d fTt;
    public boolean fTu;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.bDx = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (an.this.fTt != null) {
                    return an.this.fTt.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.ccq = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ccq.setBackgroundResource(d.C0140d.transparent);
        this.ccq.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.ccq, layoutParams);
        this.fTt = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.ccq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ao onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = new ao(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bLT != null && aoVar.mRootView != null) {
            aoVar.mRootView.setClickable(true);
            aoVar.mRootView.setOnTouchListener(this.bLT);
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
            aoVar.fTC.setOnClickListener(this.mClickListener);
            aoVar.fTA.setOnClickListener(this.mClickListener);
            aoVar.b(jVar);
            aoVar.fTy.setTag(d.g.pb_main_thread_praise_data, jVar);
            aoVar.fTy.setTag(d.g.pb_main_thread_praise_view, aoVar);
            ((ao) this.viewholder).fTz.setTag(d.g.pb_main_thread_praise_view, aoVar);
            aoVar.fTw.setTag(d.g.pb_main_thread_praise_view, aoVar);
            if (this.fTt != null) {
                this.fTt.setAnchorView(aoVar.fTw);
                this.fTt.cF(((ao) this.viewholder).fTz);
                this.fTt.setOnTouchListener(this.bDx);
            } else {
                aoVar.fTy.setOnClickListener(this.mClickListener);
            }
            aoVar.fTz.setOnClickListener(this.mClickListener);
            aoVar.fTx.setOnClickListener(this.mClickListener);
            if (this.fTu) {
                aoVar.beE();
            } else {
                aoVar.beD();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fTt != null) {
            this.fTt.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLT = cVar;
    }

    public void sM(int i) {
        if (i == 3 && this.fNb != null && this.ccq != null) {
            this.ccq.removeAllViews();
            ((FrameLayout) this.fNb.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.ccq);
        }
        this.fTt.sM(i);
    }

    public void n(boolean z, int i) {
        this.fTt.o(z, i);
    }
}
