package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class an extends m<com.baidu.tieba.pb.data.l, ao> {
    private View.OnTouchListener aNp;
    private com.baidu.tieba.pb.a.c aVK;
    private FrameLayout bmH;
    private com.baidu.tieba.pb.view.d fbu;
    public boolean fbv;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aNp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (an.this.fbu != null) {
                    return an.this.fbu.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bmH = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bmH.setBackgroundResource(d.C0095d.transparent);
        this.bmH.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bmH, layoutParams);
        this.fbu = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bmH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public ao onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = new ao(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.aVK != null && aoVar.mRootView != null) {
            aoVar.mRootView.setClickable(true);
            aoVar.mRootView.setOnTouchListener(this.aVK);
        }
        return aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.l lVar, ao aoVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, aoVar);
        if (lVar != null && aoVar != null) {
            aoVar.b(lVar);
            aoVar.fbz.setTag(d.g.pb_main_thread_praise_data, lVar);
            aoVar.fbz.setTag(d.g.pb_main_thread_praise_view, aoVar);
            ((ao) this.viewholder).fbA.setTag(d.g.pb_main_thread_praise_view, aoVar);
            aoVar.fbx.setTag(d.g.pb_main_thread_praise_view, aoVar);
            if (this.fbu != null) {
                this.fbu.setAnchorView(aoVar.fbx);
                this.fbu.bt(((ao) this.viewholder).fbA);
                this.fbu.setOnTouchListener(this.aNp);
            } else {
                aoVar.fbz.setOnClickListener(this.mClickListener);
            }
            aoVar.fbA.setOnClickListener(this.mClickListener);
            aoVar.fby.setOnClickListener(this.mClickListener);
            aoVar.fbD.setOnClickListener(this.mClickListener);
            aoVar.fbB.setOnClickListener(this.mClickListener);
            if (this.fbv) {
                aoVar.aVG();
            } else {
                aoVar.aVF();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fbu != null) {
            this.fbu.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVK = cVar;
    }

    public void pW(int i) {
        if (i == 3 && this.eVu != null && this.bmH != null) {
            this.bmH.removeAllViews();
            ((FrameLayout) this.eVu.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bmH);
        }
        this.fbu.pW(i);
    }

    public void j(boolean z, int i) {
        this.fbu.k(z, i);
    }
}
