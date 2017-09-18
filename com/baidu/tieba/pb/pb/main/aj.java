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
    private View.OnTouchListener aMx;
    private com.baidu.tieba.pb.a.c aRw;
    private View.OnClickListener aYH;
    private FrameLayout bkj;
    private com.baidu.tieba.pb.view.d eOU;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aMx = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (aj.this.eOU != null) {
                    return aj.this.eOU.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.bkj = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bkj.setBackgroundResource(d.e.transparent);
        this.bkj.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bkj, layoutParams);
        this.eOU = new com.baidu.tieba.pb.view.d(pbActivity.getPageContext().getPageActivity(), this.bkj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public ak onCreateViewHolder(ViewGroup viewGroup) {
        ak akVar = new ak(LayoutInflater.from(this.mContext).inflate(d.j.layout_thread_praise_item, viewGroup, false));
        if (this.aRw != null && akVar.mRootView != null) {
            akVar.mRootView.setClickable(true);
            akVar.mRootView.setOnTouchListener(this.aRw);
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
            akVar.eOW.setTag(d.h.pb_main_thread_praise_data, lVar);
            akVar.eOW.setTag(d.h.pb_main_thread_praise_view, akVar);
            if (this.eOU != null) {
                this.eOU.setAnchorView(akVar.eOW);
                this.eOU.setOnTouchListener(this.aMx);
            } else {
                akVar.eOW.setOnClickListener(this.aYH);
            }
            akVar.eOX.setOnClickListener(this.aYH);
            akVar.eOY.setOnClickListener(this.aYH);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYH = onClickListener;
        if (this.eOU != null) {
            this.eOU.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRw = cVar;
    }

    public void po(int i) {
        if (i == 3 && this.eHK != null && this.bkj != null) {
            this.bkj.removeAllViews();
            ((FrameLayout) this.eHK.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bkj);
        }
        this.eOU.po(i);
    }

    public void jD(boolean z) {
        this.eOU.cg(z);
    }
}
