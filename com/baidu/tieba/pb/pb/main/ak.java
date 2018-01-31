package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ak extends m<com.baidu.tieba.pb.data.j, al> {
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.fJR.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_title_layout, viewGroup, false));
        alVar.G(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.j.fEv) {
            alVar.h(com.baidu.tieba.pb.data.j.fEv);
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, al alVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, alVar);
        if (alVar != null) {
            if (getType() == com.baidu.tieba.pb.data.j.fEw) {
                alVar.n(com.baidu.tieba.pb.data.j.fEw);
            }
            alVar.a(jVar);
        }
        return view;
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(com.baidu.tieba.pb.data.j.fEv);
        MessageManager.getInstance().unRegisterListener(com.baidu.tieba.pb.data.j.fEw);
    }

    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
