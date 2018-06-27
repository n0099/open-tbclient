package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ak extends k<com.baidu.tieba.pb.data.h, al> {
    private BdUniqueId fDA;
    private BdUniqueId fDz;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fDz = BdUniqueId.gen();
        this.fDA = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.fxh.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_title_layout, viewGroup, false));
        alVar.L(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.h.fsV) {
            alVar.h(this.fDz);
        } else if (getType() == com.baidu.tieba.pb.data.h.fsW) {
            alVar.n(this.fDA);
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.h hVar, al alVar) {
        super.onFillViewHolder(i, view, viewGroup, hVar, alVar);
        if (alVar != null) {
            alVar.a(hVar);
        }
        return view;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fDz);
        MessageManager.getInstance().unRegisterListener(this.fDA);
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
