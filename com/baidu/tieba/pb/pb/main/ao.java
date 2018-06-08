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
    private View.OnTouchListener aVI;
    private com.baidu.tieba.pb.a.c beE;
    private FrameLayout buC;
    private com.baidu.tieba.pb.view.b fAa;
    public boolean fAb;
    private View.OnClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.aVI = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ao.this.fAa != null) {
                    return ao.this.fAa.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.buC = new FrameLayout(pbActivity.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.buC.setBackgroundResource(d.C0141d.transparent);
        this.buC.setTag("PraiseContainerView");
        ((FrameLayout) pbActivity.getPageContext().getPageActivity().getWindow().getDecorView()).addView(this.buC, layoutParams);
        this.fAa = new com.baidu.tieba.pb.view.b(pbActivity.getPageContext().getPageActivity(), this.buC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public ap onCreateViewHolder(ViewGroup viewGroup) {
        ap apVar = new ap(LayoutInflater.from(this.mContext).inflate(d.i.layout_thread_praise_item, viewGroup, false));
        if (this.beE != null && apVar.mRootView != null) {
            apVar.mRootView.setClickable(true);
            apVar.mRootView.setOnTouchListener(this.beE);
        }
        return apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, ap apVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, apVar);
        if (jVar != null && apVar != null) {
            apVar.fAj.setOnClickListener(this.mClickListener);
            apVar.fAh.setOnClickListener(this.mClickListener);
            apVar.b(jVar);
            apVar.fAf.setTag(d.g.pb_main_thread_praise_data, jVar);
            apVar.fAf.setTag(d.g.pb_main_thread_praise_view, apVar);
            ((ap) this.viewholder).fAg.setTag(d.g.pb_main_thread_praise_view, apVar);
            apVar.fAd.setTag(d.g.pb_main_thread_praise_view, apVar);
            if (this.fAa != null) {
                this.fAa.setAnchorView(apVar.fAd);
                this.fAa.bo(((ap) this.viewholder).fAg);
                this.fAa.setOnTouchListener(this.aVI);
            } else {
                apVar.fAf.setOnClickListener(this.mClickListener);
            }
            apVar.fAg.setOnClickListener(this.mClickListener);
            apVar.fAe.setOnClickListener(this.mClickListener);
            if (this.fAb) {
                apVar.bez();
            } else {
                apVar.bey();
            }
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        if (this.fAa != null) {
            this.fAa.setOnClickListener(onClickListener);
        }
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.beE = cVar;
    }

    public void qu(int i) {
        if (i == 3 && this.ftp != null && this.buC != null) {
            this.buC.removeAllViews();
            ((FrameLayout) this.ftp.getPageContext().getPageActivity().getWindow().getDecorView()).removeView(this.buC);
        }
        this.fAa.qu(i);
    }

    public void j(boolean z, int i) {
        this.fAa.k(z, i);
    }
}
