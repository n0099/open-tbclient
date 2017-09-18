package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ag extends l<com.baidu.tieba.pb.data.j, ah> {
    private View.OnClickListener cUW;

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public ah onCreateViewHolder(ViewGroup viewGroup) {
        ah ahVar = new ah(this.eHK.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_title_layout, viewGroup, false));
        ahVar.B(this.cUW);
        if (getType() == com.baidu.tieba.pb.data.j.eFF) {
            ahVar.i(com.baidu.tieba.pb.data.j.eFF);
        }
        return ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, ah ahVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, ahVar);
        if (ahVar != null) {
            ahVar.a(jVar);
        }
        return view;
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(com.baidu.tieba.pb.data.j.eFF);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cUW = onClickListener;
    }
}
