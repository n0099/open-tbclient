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
    private View.OnTouchListener aNm;
    private com.baidu.tieba.pb.a.c aVH;
    private FrameLayout bmD;
    private com.baidu.tieba.pb.view.d fbp;
    public boolean fbq;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aNm = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (an.this.fbp != null) {
                    return an.this.fbp.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bmD = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bmD.setBackgroundResource(d.C0096d.transparent);
        this.bmD.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bmD, layoutParams);
        this.fbp = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bmD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public ao onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = new ao(LayoutInflater.from(this.mContext).inflate(d.h.layout_thread_praise_item, viewGroup, false));
        if (this.aVH != null && aoVar.mRootView != null) {
            aoVar.mRootView.setClickable(true);
            aoVar.mRootView.setOnTouchListener(this.aVH);
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
            aoVar.fbu.setTag(d.g.pb_main_thread_praise_data, lVar);
            aoVar.fbu.setTag(d.g.pb_main_thread_praise_view, aoVar);
            ((ao) this.viewholder).fbv.setTag(d.g.pb_main_thread_praise_view, aoVar);
            aoVar.fbs.setTag(d.g.pb_main_thread_praise_view, aoVar);
            if (this.fbp != null) {
                this.fbp.setAnchorView(aoVar.fbs);
                this.fbp.bt(((ao) this.viewholder).fbv);
                this.fbp.setOnTouchListener(this.aNm);
            } else {
                aoVar.fbu.setOnClickListener(this.mClickListener);
            }
            aoVar.fbv.setOnClickListener(this.mClickListener);
            aoVar.fbt.setOnClickListener(this.mClickListener);
            aoVar.fby.setOnClickListener(this.mClickListener);
            aoVar.fbw.setOnClickListener(this.mClickListener);
            if (this.fbq) {
                aoVar.aVF();
            } else {
                aoVar.aVE();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fbp != null) {
            this.fbp.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVH = cVar;
    }

    public void pW(int i) {
        if (i == 3 && this.eVp != null && this.bmD != null) {
            this.bmD.removeAllViews();
            ((FrameLayout) this.eVp.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bmD);
        }
        this.fbp.pW(i);
    }

    public void j(boolean z, int i) {
        this.fbp.k(z, i);
    }
}
