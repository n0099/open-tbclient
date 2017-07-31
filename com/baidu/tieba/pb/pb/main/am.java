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
    private View.OnTouchListener aMS;
    private com.baidu.tieba.pb.a.c aRN;
    private View.OnClickListener aYW;
    private com.baidu.tieba.pb.view.d eNT;
    private FrameLayout eNU;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMS = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.am.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (am.this.eNT != null) {
                    return am.this.eNT.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.eNU = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eNU.setBackgroundResource(d.e.transparent);
        this.eNU.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.eNU, layoutParams);
        this.eNT = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.eNU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public an onCreateViewHolder(ViewGroup viewGroup) {
        an anVar = new an(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aRN != null && anVar.mRootView != null) {
            anVar.mRootView.setClickable(true);
            anVar.mRootView.setOnTouchListener(this.aRN);
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
            anVar.eNW.setTag(d.h.pb_main_thread_praise_data, mVar);
            anVar.eNW.setTag(d.h.pb_main_thread_praise_view, anVar);
            if (this.eNT != null) {
                this.eNT.setAnchorView(anVar.eNW);
                this.eNT.setOnTouchListener(this.aMS);
            } else {
                anVar.eNW.setOnClickListener(this.aYW);
            }
            anVar.eNX.setOnClickListener(this.aYW);
            anVar.eNY.setOnClickListener(this.aYW);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYW = onClickListener;
        if (this.eNT != null) {
            this.eNT.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRN = cVar;
    }

    public void oV(int i) {
        if (i == 3 && this.eGA != null && this.eNU != null) {
            this.eNU.removeAllViews();
            ((FrameLayout) this.eGA.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.eNU);
        }
        this.eNT.oV(i);
    }

    public void jC(boolean z) {
        this.eNT.cg(z);
    }
}
