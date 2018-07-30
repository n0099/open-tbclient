package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ap extends k<com.baidu.tieba.pb.data.j, aq> {
    private View.OnTouchListener aWF;
    private com.baidu.tieba.pb.a.c bge;
    private FrameLayout bwD;
    private com.baidu.tieba.pb.view.b fEo;
    public boolean fEp;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ap(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ap.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ap.this.fEo != null) {
                    return ap.this.fEo.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bwD = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bwD.setBackgroundResource(d.C0140d.transparent);
        this.bwD.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bwD, layoutParams);
        this.fEo = new com.baidu.tieba.pb.view.b(pbActivity.getPageContext().getPageActivity(), this.bwD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public aq onCreateViewHolder(ViewGroup viewGroup) {
        aq aqVar = new aq(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bge != null && aqVar.mRootView != null) {
            aqVar.mRootView.setClickable(true);
            aqVar.mRootView.setOnTouchListener(this.bge);
        }
        return aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, aq aqVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, aqVar);
        if (jVar != null && aqVar != null) {
            aqVar.fEx.setOnClickListener(this.mClickListener);
            aqVar.fEv.setOnClickListener(this.mClickListener);
            aqVar.b(jVar);
            aqVar.fEt.setTag(d.g.pb_main_thread_praise_data, jVar);
            aqVar.fEt.setTag(d.g.pb_main_thread_praise_view, aqVar);
            ((aq) this.viewholder).fEu.setTag(d.g.pb_main_thread_praise_view, aqVar);
            aqVar.fEr.setTag(d.g.pb_main_thread_praise_view, aqVar);
            if (this.fEo != null) {
                this.fEo.setAnchorView(aqVar.fEr);
                this.fEo.bs(((aq) this.viewholder).fEu);
                this.fEo.setOnTouchListener(this.aWF);
            } else {
                aqVar.fEt.setOnClickListener(this.mClickListener);
            }
            aqVar.fEu.setOnClickListener(this.mClickListener);
            aqVar.fEs.setOnClickListener(this.mClickListener);
            if (this.fEp) {
                aqVar.bdA();
            } else {
                aqVar.bdz();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fEo != null) {
            this.fEo.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bge = cVar;
    }

    public void qy(int i) {
        if (i == 3 && this.fxt != null && this.bwD != null) {
            this.bwD.removeAllViews();
            ((FrameLayout) this.fxt.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bwD);
        }
        this.fEo.qy(i);
    }

    public void i(boolean z, int i) {
        this.fEo.j(z, i);
    }
}
