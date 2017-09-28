package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class af extends k<com.baidu.tieba.pb.data.j, ag> {
    private View.OnClickListener eAg;

    /* JADX INFO: Access modifiers changed from: protected */
    public af(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public ag onCreateViewHolder(ViewGroup viewGroup) {
        ag agVar = new ag(this.eDC.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_reply_title_layout, viewGroup, false));
        agVar.D(this.eAg);
        if (getType() == com.baidu.tieba.pb.data.j.ezb) {
            agVar.h(com.baidu.tieba.pb.data.j.ezb);
        }
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.j jVar, ag agVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, agVar);
        if (agVar != null) {
            agVar.a(jVar);
        }
        return view;
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(com.baidu.tieba.pb.data.j.ezb);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.eAg = onClickListener;
    }
}
