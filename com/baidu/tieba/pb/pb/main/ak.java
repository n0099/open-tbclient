package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ak extends k<com.baidu.tieba.pb.data.h, al> {
    private BdUniqueId hvl;
    private BdUniqueId hvm;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hvl = BdUniqueId.gen();
        this.hvm = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.hpc.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_title_layout, viewGroup, false));
        alVar.Si = false;
        alVar.L(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.h.hkG) {
            alVar.i(this.hvl);
        } else if (getType() == com.baidu.tieba.pb.data.h.hkH) {
            alVar.o(this.hvm);
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
        MessageManager.getInstance().unRegisterListener(this.hvl);
        MessageManager.getInstance().unRegisterListener(this.hvm);
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
