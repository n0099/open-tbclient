package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ak extends k<com.baidu.tieba.pb.data.h, al> {
    private BdUniqueId fDF;
    private BdUniqueId fDG;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fDF = BdUniqueId.gen();
        this.fDG = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.fxm.getPageContext(), LayoutInflater.from(this.mContext).inflate(f.h.pb_reply_title_layout, viewGroup, false));
        alVar.J(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.h.fta) {
            alVar.h(this.fDF);
        } else if (getType() == com.baidu.tieba.pb.data.h.ftb) {
            alVar.n(this.fDG);
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
        MessageManager.getInstance().unRegisterListener(this.fDF);
        MessageManager.getInstance().unRegisterListener(this.fDG);
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
