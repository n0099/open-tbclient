package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class am extends l<com.baidu.tieba.pb.data.m, an> {
    private View.OnTouchListener aLD;
    private com.baidu.tieba.pb.a.c aQB;
    private View.OnClickListener aXL;
    private com.baidu.tieba.pb.view.d eMG;
    private FrameLayout eMH;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aLD = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.am.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (am.this.eMG != null) {
                    return am.this.eMG.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.eMH = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eMH.setBackgroundResource(d.e.transparent);
        this.eMH.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.eMH, layoutParams);
        this.eMG = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.eMH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public an onCreateViewHolder(ViewGroup viewGroup) {
        an anVar = new an(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aQB != null && anVar.mRootView != null) {
            anVar.mRootView.setClickable(true);
            anVar.mRootView.setOnTouchListener(this.aQB);
        }
        return anVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.m mVar, an anVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, anVar);
        if (mVar != null && anVar != null) {
            anVar.b(mVar);
            anVar.eMJ.setTag(d.h.pb_main_thread_praise_data, mVar);
            anVar.eMJ.setTag(d.h.pb_main_thread_praise_view, anVar);
            if (this.eMG != null) {
                this.eMG.setAnchorView(anVar.eMJ);
                this.eMG.setOnTouchListener(this.aLD);
            } else {
                anVar.eMJ.setOnClickListener(this.aXL);
            }
            anVar.eMK.setOnClickListener(this.aXL);
            anVar.eML.setOnClickListener(this.aXL);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aXL = onClickListener;
        if (this.eMG != null) {
            this.eMG.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aQB = cVar;
    }

    public void oV(int i) {
        if (i == 3 && this.eFn != null && this.eMH != null) {
            this.eMH.removeAllViews();
            ((FrameLayout) this.eFn.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.eMH);
        }
        this.eMG.oV(i);
    }

    public void jC(boolean z) {
        this.eMG.cg(z);
    }
}
