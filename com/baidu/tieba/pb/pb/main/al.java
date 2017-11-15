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
    private View.OnTouchListener aMI;
    private com.baidu.tieba.pb.a.c aSE;
    private FrameLayout bny;
    private com.baidu.tieba.pb.view.d eRF;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public al(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMI = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.al.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (al.this.eRF != null) {
                    return al.this.eRF.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bny = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bny.setBackgroundResource(d.C0080d.transparent);
        this.bny.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bny, layoutParams);
        this.eRF = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bny);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public am onCreateViewHolder(ViewGroup viewGroup) {
        am amVar = new am(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.aSE != null && amVar.mRootView != null) {
            amVar.mRootView.setClickable(true);
            amVar.mRootView.setOnTouchListener(this.aSE);
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
            amVar.eRH.setTag(d.g.pb_main_thread_praise_data, lVar);
            amVar.eRH.setTag(d.g.pb_main_thread_praise_view, amVar);
            if (this.eRF != null) {
                this.eRF.setAnchorView(amVar.eRH);
                this.eRF.setOnTouchListener(this.aMI);
            } else {
                amVar.eRH.setOnClickListener(this.mClickListener);
            }
            amVar.eRI.setOnClickListener(this.mClickListener);
            amVar.eRJ.setOnClickListener(this.mClickListener);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.eRF != null) {
            this.eRF.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSE = cVar;
    }

    public void pC(int i) {
        if (i == 3 && this.eMB != null && this.bny != null) {
            this.bny.removeAllViews();
            ((FrameLayout) this.eMB.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bny);
        }
        this.eRF.pC(i);
    }

    public void j(boolean z, int i) {
        this.eRF.k(z, i);
    }
}
