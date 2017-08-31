package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aj extends l<com.baidu.tieba.pb.data.l, ak> {
    private View.OnTouchListener aMA;
    private com.baidu.tieba.pb.a.c aRz;
    private View.OnClickListener aYK;
    private FrameLayout bkk;
    private com.baidu.tieba.pb.view.d eOa;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (aj.this.eOa != null) {
                    return aj.this.eOa.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bkk = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bkk.setBackgroundResource(d.e.transparent);
        this.bkk.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bkk, layoutParams);
        this.eOa = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bkk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public ak onCreateViewHolder(ViewGroup viewGroup) {
        ak akVar = new ak(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aRz != null && akVar.mRootView != null) {
            akVar.mRootView.setClickable(true);
            akVar.mRootView.setOnTouchListener(this.aRz);
        }
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, ak akVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, akVar);
        if (lVar != null && akVar != null) {
            akVar.b(lVar);
            akVar.eOc.setTag(d.h.pb_main_thread_praise_data, lVar);
            akVar.eOc.setTag(d.h.pb_main_thread_praise_view, akVar);
            if (this.eOa != null) {
                this.eOa.setAnchorView(akVar.eOc);
                this.eOa.setOnTouchListener(this.aMA);
            } else {
                akVar.eOc.setOnClickListener(this.aYK);
            }
            akVar.eOd.setOnClickListener(this.aYK);
            akVar.eOe.setOnClickListener(this.aYK);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYK = onClickListener;
        if (this.eOa != null) {
            this.eOa.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRz = cVar;
    }

    public void pm(int i) {
        if (i == 3 && this.eGQ != null && this.bkk != null) {
            this.bkk.removeAllViews();
            ((FrameLayout) this.eGQ.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bkk);
        }
        this.eOa.pm(i);
    }

    public void jC(boolean z) {
        this.eOa.cg(z);
    }
}
