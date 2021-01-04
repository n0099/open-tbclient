package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class j extends l<com.baidu.tieba.pb.data.e, PbChildTitleViewHolder> {
    public j(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cs */
    public PbChildTitleViewHolder e(ViewGroup viewGroup) {
        return new PbChildTitleViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.pb_child_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.e eVar, PbChildTitleViewHolder pbChildTitleViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) eVar, (com.baidu.tieba.pb.data.e) pbChildTitleViewHolder);
        pbChildTitleViewHolder.a(eVar);
        pbChildTitleViewHolder.onChangeSkinType();
        return view;
    }
}
