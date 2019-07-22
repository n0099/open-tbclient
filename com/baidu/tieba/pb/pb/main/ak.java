package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ak extends k<com.baidu.tieba.pb.data.i, al> {
    private BdUniqueId hSM;
    private BdUniqueId hSN;
    private View.OnClickListener mCommonClickListener;

    /* JADX INFO: Access modifiers changed from: protected */
    public ak(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.hSM = BdUniqueId.gen();
        this.hSN = BdUniqueId.gen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public al onCreateViewHolder(ViewGroup viewGroup) {
        al alVar = new al(this.hMD.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_title_layout, viewGroup, false));
        alVar.Ql = false;
        alVar.P(this.mCommonClickListener);
        if (getType() == com.baidu.tieba.pb.data.i.hIl) {
            alVar.j(this.hSM);
        } else if (getType() == com.baidu.tieba.pb.data.i.hIm) {
            alVar.q(this.hSN);
        }
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.i iVar, al alVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, alVar);
        if (alVar != null) {
            alVar.a(iVar);
        }
        return view;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hSM);
        MessageManager.getInstance().unRegisterListener(this.hSN);
    }

    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
