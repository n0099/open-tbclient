package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fm extends du<com.baidu.tbadk.core.data.av, fn> {
    /* JADX INFO: Access modifiers changed from: protected */
    public fm(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public fn onCreateViewHolder(ViewGroup viewGroup) {
        return new fn(this.euf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.av avVar, fn fnVar) {
        super.onFillViewHolder(i, view, viewGroup, avVar, fnVar);
        if (avVar != null) {
            fnVar.a(avVar);
        }
        return view;
    }
}
