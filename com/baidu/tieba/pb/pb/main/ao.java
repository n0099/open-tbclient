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
    private View.OnTouchListener bBt;
    private com.baidu.tieba.pb.a.c bJO;
    private FrameLayout cag;
    private com.baidu.tieba.pb.view.d fQh;
    public boolean fQi;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.bBt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ao.this.fQh != null) {
                    return ao.this.fQh.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.cag = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.cag.setBackgroundResource(d.C0108d.transparent);
        this.cag.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.cag, layoutParams);
        this.fQh = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.cag);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ap onCreateViewHolder(ViewGroup viewGroup) {
        ap apVar = new ap(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bJO != null && apVar.mRootView != null) {
            apVar.mRootView.setClickable(true);
            apVar.mRootView.setOnTouchListener(this.bJO);
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
            apVar.fQq.setOnClickListener(this.mClickListener);
            apVar.fQo.setOnClickListener(this.mClickListener);
            apVar.b(lVar);
            apVar.fQm.setTag(d.g.pb_main_thread_praise_data, lVar);
            apVar.fQm.setTag(d.g.pb_main_thread_praise_view, apVar);
            ((ap) this.viewholder).fQn.setTag(d.g.pb_main_thread_praise_view, apVar);
            apVar.fQk.setTag(d.g.pb_main_thread_praise_view, apVar);
            if (this.fQh != null) {
                this.fQh.setAnchorView(apVar.fQk);
                this.fQh.cG(((ap) this.viewholder).fQn);
                this.fQh.setOnTouchListener(this.bBt);
            } else {
                apVar.fQm.setOnClickListener(this.mClickListener);
            }
            apVar.fQn.setOnClickListener(this.mClickListener);
            apVar.fQl.setOnClickListener(this.mClickListener);
            if (this.fQi) {
                apVar.bdc();
            } else {
                apVar.bdb();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fQh != null) {
            this.fQh.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJO = cVar;
    }

    public void sJ(int i) {
        if (i == 3 && this.fJR != null && this.cag != null) {
            this.cag.removeAllViews();
            ((FrameLayout) this.fJR.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.cag);
        }
        this.fQh.sJ(i);
    }

    public void m(boolean z, int i) {
        this.fQh.n(z, i);
    }
}
