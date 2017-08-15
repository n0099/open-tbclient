package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class am extends l<com.baidu.tieba.pb.data.m, an> {
    private View.OnTouchListener aMT;
    private com.baidu.tieba.pb.a.c aRO;
    private View.OnClickListener aYX;
    private FrameLayout bjU;
    private com.baidu.tieba.pb.view.d ePN;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMT = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.am.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (am.this.ePN != null) {
                    return am.this.ePN.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bjU = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bjU.setBackgroundResource(d.e.transparent);
        this.bjU.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bjU, layoutParams);
        this.ePN = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bjU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public an onCreateViewHolder(ViewGroup viewGroup) {
        an anVar = new an(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aRO != null && anVar.mRootView != null) {
            anVar.mRootView.setClickable(true);
            anVar.mRootView.setOnTouchListener(this.aRO);
        }
        return anVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, an anVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, anVar);
        if (mVar != null && anVar != null) {
            anVar.b(mVar);
            anVar.ePP.setTag(d.h.pb_main_thread_praise_data, mVar);
            anVar.ePP.setTag(d.h.pb_main_thread_praise_view, anVar);
            if (this.ePN != null) {
                this.ePN.setAnchorView(anVar.ePP);
                this.ePN.setOnTouchListener(this.aMT);
            } else {
                anVar.ePP.setOnClickListener(this.aYX);
            }
            anVar.ePQ.setOnClickListener(this.aYX);
            anVar.ePR.setOnClickListener(this.aYX);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYX = onClickListener;
        if (this.ePN != null) {
            this.ePN.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRO = cVar;
    }

    public void pf(int i) {
        if (i == 3 && this.eIu != null && this.bjU != null) {
            this.bjU.removeAllViews();
            ((FrameLayout) this.eIu.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bjU);
        }
        this.ePN.pf(i);
    }

    public void jF(boolean z) {
        this.ePN.cg(z);
    }
}
