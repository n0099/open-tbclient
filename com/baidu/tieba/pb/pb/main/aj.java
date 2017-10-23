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
    private View.OnTouchListener aLM;
    private View.OnClickListener aOR;
    private com.baidu.tieba.pb.a.c aSk;
    private FrameLayout blG;
    private com.baidu.tieba.pb.view.d eIy;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aLM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (aj.this.eIy != null) {
                    return aj.this.eIy.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.blG = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.blG.setBackgroundResource(d.e.transparent);
        this.blG.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.blG, layoutParams);
        this.eIy = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.blG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public ak onCreateViewHolder(ViewGroup viewGroup) {
        ak akVar = new ak(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aSk != null && akVar.mRootView != null) {
            akVar.mRootView.setClickable(true);
            akVar.mRootView.setOnTouchListener(this.aSk);
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
            akVar.eIA.setTag(d.h.pb_main_thread_praise_data, lVar);
            akVar.eIA.setTag(d.h.pb_main_thread_praise_view, akVar);
            if (this.eIy != null) {
                this.eIy.setAnchorView(akVar.eIA);
                this.eIy.setOnTouchListener(this.aLM);
            } else {
                akVar.eIA.setOnClickListener(this.aOR);
            }
            akVar.eIB.setOnClickListener(this.aOR);
            akVar.eIC.setOnClickListener(this.aOR);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aOR = onClickListener;
        if (this.eIy != null) {
            this.eIy.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSk = cVar;
    }

    public void pg(int i) {
        if (i == 3 && this.eDo != null && this.blG != null) {
            this.blG.removeAllViews();
            ((FrameLayout) this.eDo.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.blG);
        }
        this.eIy.pg(i);
    }

    public void jo(boolean z) {
        this.eIy.ce(z);
    }
}
