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
    private View.OnTouchListener bDk;
    private com.baidu.tieba.pb.a.c bLG;
    private FrameLayout cce;
    private com.baidu.tieba.pb.view.d fTi;
    public boolean fTj;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.bDk = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (an.this.fTi != null) {
                    return an.this.fTi.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.cce = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.cce.setBackgroundResource(d.C0141d.transparent);
        this.cce.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.cce, layoutParams);
        this.fTi = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.cce);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ao onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = new ao(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bLG != null && aoVar.mRootView != null) {
            aoVar.mRootView.setClickable(true);
            aoVar.mRootView.setOnTouchListener(this.bLG);
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
            aoVar.fTr.setOnClickListener(this.mClickListener);
            aoVar.fTp.setOnClickListener(this.mClickListener);
            aoVar.b(jVar);
            aoVar.fTn.setTag(d.g.pb_main_thread_praise_data, jVar);
            aoVar.fTn.setTag(d.g.pb_main_thread_praise_view, aoVar);
            ((ao) this.viewholder).fTo.setTag(d.g.pb_main_thread_praise_view, aoVar);
            aoVar.fTl.setTag(d.g.pb_main_thread_praise_view, aoVar);
            if (this.fTi != null) {
                this.fTi.setAnchorView(aoVar.fTl);
                this.fTi.cF(((ao) this.viewholder).fTo);
                this.fTi.setOnTouchListener(this.bDk);
            } else {
                aoVar.fTn.setOnClickListener(this.mClickListener);
            }
            aoVar.fTo.setOnClickListener(this.mClickListener);
            aoVar.fTm.setOnClickListener(this.mClickListener);
            if (this.fTj) {
                aoVar.beD();
            } else {
                aoVar.beC();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fTi != null) {
            this.fTi.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLG = cVar;
    }

    public void sN(int i) {
        if (i == 3 && this.fMQ != null && this.cce != null) {
            this.cce.removeAllViews();
            ((FrameLayout) this.fMQ.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.cce);
        }
        this.fTi.sN(i);
    }

    public void n(boolean z, int i) {
        this.fTi.o(z, i);
    }
}
