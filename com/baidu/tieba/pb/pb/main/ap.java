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
    private View.OnTouchListener aWD;
    private com.baidu.tieba.pb.a.c bfS;
    private FrameLayout bvX;
    private com.baidu.tieba.pb.view.b fEb;
    public boolean fEc;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ap(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aWD = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ap.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ap.this.fEb != null) {
                    return ap.this.fEb.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bvX = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bvX.setBackgroundResource(d.C0142d.transparent);
        this.bvX.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bvX, layoutParams);
        this.fEb = new com.baidu.tieba.pb.view.b(pbActivity.getPageContext().getPageActivity(), this.bvX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public aq onCreateViewHolder(ViewGroup viewGroup) {
        aq aqVar = new aq(LayoutInflater.from(this.mContext).inflate(d.i.layout_thread_praise_item, viewGroup, false));
        if (this.bfS != null && aqVar.mRootView != null) {
            aqVar.mRootView.setClickable(true);
            aqVar.mRootView.setOnTouchListener(this.bfS);
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
            aqVar.fEk.setOnClickListener(this.mClickListener);
            aqVar.fEi.setOnClickListener(this.mClickListener);
            aqVar.b(jVar);
            aqVar.fEg.setTag(d.g.pb_main_thread_praise_data, jVar);
            aqVar.fEg.setTag(d.g.pb_main_thread_praise_view, aqVar);
            ((aq) this.viewholder).fEh.setTag(d.g.pb_main_thread_praise_view, aqVar);
            aqVar.fEe.setTag(d.g.pb_main_thread_praise_view, aqVar);
            if (this.fEb != null) {
                this.fEb.setAnchorView(aqVar.fEe);
                this.fEb.bp(((aq) this.viewholder).fEh);
                this.fEb.setOnTouchListener(this.aWD);
            } else {
                aqVar.fEg.setOnClickListener(this.mClickListener);
            }
            aqVar.fEh.setOnClickListener(this.mClickListener);
            aqVar.fEf.setOnClickListener(this.mClickListener);
            if (this.fEc) {
                aqVar.bfh();
            } else {
                aqVar.bfg();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fEb != null) {
            this.fEb.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bfS = cVar;
    }

    public void qB(int i) {
        if (i == 3 && this.fxh != null && this.bvX != null) {
            this.bvX.removeAllViews();
            ((FrameLayout) this.fxh.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bvX);
        }
        this.fEb.qB(i);
    }

    public void j(boolean z, int i) {
        this.fEb.k(z, i);
    }
}
