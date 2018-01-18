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
    private View.OnTouchListener bBl;
    private com.baidu.tieba.pb.a.c bJG;
    private FrameLayout bZY;
    private com.baidu.tieba.pb.view.d fPM;
    public boolean fPN;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.bBl = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ao.this.fPM != null) {
                    return ao.this.fPM.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bZY = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bZY.setBackgroundResource(d.C0107d.transparent);
        this.bZY.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bZY, layoutParams);
        this.fPM = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bZY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ap onCreateViewHolder(ViewGroup viewGroup) {
        ap apVar = new ap(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.bJG != null && apVar.mRootView != null) {
            apVar.mRootView.setClickable(true);
            apVar.mRootView.setOnTouchListener(this.bJG);
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
            apVar.fPV.setOnClickListener(this.mClickListener);
            apVar.fPT.setOnClickListener(this.mClickListener);
            apVar.b(lVar);
            apVar.fPR.setTag(d.g.pb_main_thread_praise_data, lVar);
            apVar.fPR.setTag(d.g.pb_main_thread_praise_view, apVar);
            ((ap) this.viewholder).fPS.setTag(d.g.pb_main_thread_praise_view, apVar);
            apVar.fPP.setTag(d.g.pb_main_thread_praise_view, apVar);
            if (this.fPM != null) {
                this.fPM.setAnchorView(apVar.fPP);
                this.fPM.cG(((ap) this.viewholder).fPS);
                this.fPM.setOnTouchListener(this.bBl);
            } else {
                apVar.fPR.setOnClickListener(this.mClickListener);
            }
            apVar.fPS.setOnClickListener(this.mClickListener);
            apVar.fPQ.setOnClickListener(this.mClickListener);
            if (this.fPN) {
                apVar.bcX();
            } else {
                apVar.bcW();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fPM != null) {
            this.fPM.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJG = cVar;
    }

    public void sJ(int i) {
        if (i == 3 && this.fJw != null && this.bZY != null) {
            this.bZY.removeAllViews();
            ((FrameLayout) this.fJw.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bZY);
        }
        this.fPM.sJ(i);
    }

    public void m(boolean z, int i) {
        this.fPM.n(z, i);
    }
}
