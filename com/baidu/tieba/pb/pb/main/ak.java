package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class ak extends k<com.baidu.tieba.pb.data.h, al> {
    private BdUniqueId fSR;
    private BdUniqueId fSS;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fSR = BdUniqueId.gen();
        this.fSS = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.fMF.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_title_layout, viewGroup, false));
        alVar.J(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.h.fIq) {
            alVar.h(this.fSR);
        } else if (getType() == com.baidu.tieba.pb.data.h.fIr) {
            alVar.n(this.fSS);
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
        MessageManager.getInstance().unRegisterListener(this.fSR);
        MessageManager.getInstance().unRegisterListener(this.fSS);
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
