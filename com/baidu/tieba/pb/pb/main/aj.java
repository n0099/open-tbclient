package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aj extends k<com.baidu.tieba.pb.data.l, ak> {
    private View.OnTouchListener aLZ;
    private View.OnClickListener aPe;
    private com.baidu.tieba.pb.a.c aSx;
    private FrameLayout blU;
    private com.baidu.tieba.pb.view.d eIM;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aLZ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (aj.this.eIM != null) {
                    return aj.this.eIM.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.blU = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.blU.setBackgroundResource(d.e.transparent);
        this.blU.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.blU, layoutParams);
        this.eIM = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.blU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public ak onCreateViewHolder(ViewGroup viewGroup) {
        ak akVar = new ak(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aSx != null && akVar.mRootView != null) {
            akVar.mRootView.setClickable(true);
            akVar.mRootView.setOnTouchListener(this.aSx);
        }
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, ak akVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, akVar);
        if (lVar != null && akVar != null) {
            akVar.b(lVar);
            akVar.eIO.setTag(d.h.pb_main_thread_praise_data, lVar);
            akVar.eIO.setTag(d.h.pb_main_thread_praise_view, akVar);
            if (this.eIM != null) {
                this.eIM.setAnchorView(akVar.eIO);
                this.eIM.setOnTouchListener(this.aLZ);
            } else {
                akVar.eIO.setOnClickListener(this.aPe);
            }
            akVar.eIP.setOnClickListener(this.aPe);
            akVar.eIQ.setOnClickListener(this.aPe);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
        if (this.eIM != null) {
            this.eIM.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSx = cVar;
    }

    public void ph(int i) {
        if (i == 3 && this.eDC != null && this.blU != null) {
            this.blU.removeAllViews();
            ((FrameLayout) this.eDC.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.blU);
        }
        this.eIM.ph(i);
    }

    public void jp(boolean z) {
        this.eIM.cf(z);
    }
}
