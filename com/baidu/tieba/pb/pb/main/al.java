package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class al extends m<com.baidu.tieba.pb.data.l, am> {
    private View.OnTouchListener aMA;
    private com.baidu.tieba.pb.a.c aSw;
    private FrameLayout bnp;
    private com.baidu.tieba.pb.view.d eRl;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public al(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.al.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (al.this.eRl != null) {
                    return al.this.eRl.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bnp = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bnp.setBackgroundResource(d.C0080d.transparent);
        this.bnp.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bnp, layoutParams);
        this.eRl = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bnp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public am onCreateViewHolder(ViewGroup viewGroup) {
        am amVar = new am(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.aSw != null && amVar.mRootView != null) {
            amVar.mRootView.setClickable(true);
            amVar.mRootView.setOnTouchListener(this.aSw);
        }
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, am amVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, amVar);
        if (lVar != null && amVar != null) {
            amVar.b(lVar);
            amVar.eRn.setTag(d.g.pb_main_thread_praise_data, lVar);
            amVar.eRn.setTag(d.g.pb_main_thread_praise_view, amVar);
            if (this.eRl != null) {
                this.eRl.setAnchorView(amVar.eRn);
                this.eRl.setOnTouchListener(this.aMA);
            } else {
                amVar.eRn.setOnClickListener(this.mClickListener);
            }
            amVar.eRo.setOnClickListener(this.mClickListener);
            amVar.eRp.setOnClickListener(this.mClickListener);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.eRl != null) {
            this.eRl.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSw = cVar;
    }

    public void pB(int i) {
        if (i == 3 && this.eMh != null && this.bnp != null) {
            this.bnp.removeAllViews();
            ((FrameLayout) this.eMh.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bnp);
        }
        this.eRl.pB(i);
    }

    public void j(boolean z, int i) {
        this.eRl.k(z, i);
    }
}
