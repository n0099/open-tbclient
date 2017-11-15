package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ah extends m<com.baidu.tieba.pb.data.j, ai> {
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ai onCreateViewHolder(ViewGroup viewGroup) {
        ai aiVar = new ai(this.eMB.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_title_layout, viewGroup, false));
        aiVar.E(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.j.eHi) {
            aiVar.h(com.baidu.tieba.pb.data.j.eHi);
        }
        return aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, ai aiVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, aiVar);
        if (aiVar != null) {
            aiVar.a(jVar);
        }
        return view;
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(com.baidu.tieba.pb.data.j.eHi);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
