package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ao extends k<com.baidu.tieba.pb.data.j, ap> {
    private View.OnTouchListener aNK;
    private com.baidu.tieba.pb.a.c aWx;
    private FrameLayout bmh;
    private com.baidu.tieba.pb.view.b fnC;
    public boolean fnD;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aNK = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (ao.this.fnC != null) {
                    return ao.this.fnC.onTouch(view2, motionEvent);
                }
                return false;
            }
        };
        this.bmh = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bmh.setBackgroundResource(d.C0126d.transparent);
        this.bmh.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.bmh, layoutParams);
        this.fnC = new com.baidu.tieba.pb.view.b(pbActivity.getPageContext().getPageActivity(), this.bmh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public ap onCreateViewHolder(ViewGroup viewGroup) {
        ap apVar = new ap(LayoutInflater.from(this.mContext).inflate(d.i.layout_thread_praise_item, viewGroup, false));
        if (this.aWx != null && apVar.mRootView != null) {
            apVar.mRootView.setClickable(true);
            apVar.mRootView.setOnTouchListener(this.aWx);
        }
        return apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, ap apVar) {
        super.onFillViewHolder(i, view2, viewGroup, jVar, apVar);
        if (jVar != null && apVar != null) {
            apVar.fnL.setOnClickListener(this.mClickListener);
            apVar.fnJ.setOnClickListener(this.mClickListener);
            apVar.b(jVar);
            apVar.fnH.setTag(d.g.pb_main_thread_praise_data, jVar);
            apVar.fnH.setTag(d.g.pb_main_thread_praise_view, apVar);
            ((ap) this.viewholder).fnI.setTag(d.g.pb_main_thread_praise_view, apVar);
            apVar.fnF.setTag(d.g.pb_main_thread_praise_view, apVar);
            if (this.fnC != null) {
                this.fnC.setAnchorView(apVar.fnF);
                this.fnC.bl(((ap) this.viewholder).fnI);
                this.fnC.setOnTouchListener(this.aNK);
            } else {
                apVar.fnH.setOnClickListener(this.mClickListener);
            }
            apVar.fnI.setOnClickListener(this.mClickListener);
            apVar.fnG.setOnClickListener(this.mClickListener);
            if (this.fnD) {
                apVar.aZB();
            } else {
                apVar.aZA();
            }
        }
        return view2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fnC != null) {
            this.fnC.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWx = cVar;
    }

    public void qk(int i) {
        if (i == 3 && this.fgM != null && this.bmh != null) {
            this.bmh.removeAllViews();
            ((FrameLayout) this.fgM.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.bmh);
        }
        this.fnC.qk(i);
    }

    public void j(boolean z, int i) {
        this.fnC.k(z, i);
    }
}
