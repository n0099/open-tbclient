package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class aj extends k<com.baidu.tieba.pb.data.h, ak> {
    private BdUniqueId fzy;
    private BdUniqueId fzz;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.fzy = BdUniqueId.gen();
        this.fzz = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public ak onCreateViewHolder(ViewGroup viewGroup) {
        ak akVar = new ak(this.ftp.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.i.pb_reply_title_layout, viewGroup, false));
        akVar.H(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.h.fpb) {
            akVar.h(this.fzy);
        } else if (getType() == com.baidu.tieba.pb.data.h.fpc) {
            akVar.n(this.fzz);
        }
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.h hVar, ak akVar) {
        super.onFillViewHolder(i, view, viewGroup, hVar, akVar);
        if (akVar != null) {
            akVar.a(hVar);
        }
        return view;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzy);
        MessageManager.getInstance().unRegisterListener(this.fzz);
    }

    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
