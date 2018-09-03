package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ap extends k<com.baidu.tieba.pb.data.j, aq> {
    private View.OnTouchListener aWF;
    private com.baidu.tieba.pb.a.c bgf;
    private FrameLayout bwF;
    private com.baidu.tieba.pb.view.b fEh;
    public boolean fEi;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ap(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ap.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ap.this.fEh != null) {
                    return ap.this.fEh.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bwF = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bwF.setBackgroundResource(f.d.transparent);
        this.bwF.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bwF, layoutParams);
        this.fEh = new com.baidu.tieba.pb.view.b(pbActivity.getPageContext().getPageActivity(), this.bwF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public aq onCreateViewHolder(ViewGroup viewGroup) {
        aq aqVar = new aq(LayoutInflater.from(this.mContext).inflate(f.h.layout_thread_praise_item, viewGroup, false));
        if (this.bgf != null && aqVar.mRootView != null) {
            aqVar.mRootView.setClickable(true);
            aqVar.mRootView.setOnTouchListener(this.bgf);
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
            aqVar.fEq.setOnClickListener(this.mClickListener);
            aqVar.fEo.setOnClickListener(this.mClickListener);
            aqVar.b(jVar);
            aqVar.fEm.setTag(f.g.pb_main_thread_praise_data, jVar);
            aqVar.fEm.setTag(f.g.pb_main_thread_praise_view, aqVar);
            ((aq) this.viewholder).fEn.setTag(f.g.pb_main_thread_praise_view, aqVar);
            aqVar.fEk.setTag(f.g.pb_main_thread_praise_view, aqVar);
            if (this.fEh != null) {
                this.fEh.setAnchorView(aqVar.fEk);
                this.fEh.bs(((aq) this.viewholder).fEn);
                this.fEh.setOnTouchListener(this.aWF);
            } else {
                aqVar.fEm.setOnClickListener(this.mClickListener);
            }
            aqVar.fEn.setOnClickListener(this.mClickListener);
            aqVar.fEl.setOnClickListener(this.mClickListener);
            if (this.fEi) {
                aqVar.bdv();
            } else {
                aqVar.bdu();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fEh != null) {
            this.fEh.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bgf = cVar;
    }

    public void qy(int i) {
        if (i == 3 && this.fxm != null && this.bwF != null) {
            this.bwF.removeAllViews();
            ((FrameLayout) this.fxm.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bwF);
        }
        this.fEh.qy(i);
    }

    public void i(boolean z, int i) {
        this.fEh.j(z, i);
    }
}
