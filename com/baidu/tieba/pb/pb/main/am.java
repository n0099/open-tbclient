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
    private View.OnTouchListener aMU;
    private com.baidu.tieba.pb.a.c aRP;
    private View.OnClickListener aYY;
    private FrameLayout bjV;
    private com.baidu.tieba.pb.view.d ePP;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.am.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (am.this.ePP != null) {
                    return am.this.ePP.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bjV = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bjV.setBackgroundResource(d.e.transparent);
        this.bjV.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bjV, layoutParams);
        this.ePP = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bjV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public an onCreateViewHolder(ViewGroup viewGroup) {
        an anVar = new an(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aRP != null && anVar.mRootView != null) {
            anVar.mRootView.setClickable(true);
            anVar.mRootView.setOnTouchListener(this.aRP);
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
            anVar.ePR.setTag(d.h.pb_main_thread_praise_data, mVar);
            anVar.ePR.setTag(d.h.pb_main_thread_praise_view, anVar);
            if (this.ePP != null) {
                this.ePP.setAnchorView(anVar.ePR);
                this.ePP.setOnTouchListener(this.aMU);
            } else {
                anVar.ePR.setOnClickListener(this.aYY);
            }
            anVar.ePS.setOnClickListener(this.aYY);
            anVar.ePT.setOnClickListener(this.aYY);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYY = onClickListener;
        if (this.ePP != null) {
            this.ePP.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRP = cVar;
    }

    public void pf(int i) {
        if (i == 3 && this.eIw != null && this.bjV != null) {
            this.bjV.removeAllViews();
            ((FrameLayout) this.eIw.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bjV);
        }
        this.ePP.pf(i);
    }

    public void jF(boolean z) {
        this.ePP.cg(z);
    }
}
