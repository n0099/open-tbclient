package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class k extends o<com.baidu.tieba.pb.data.e, l> {
    public k(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public l b(ViewGroup viewGroup) {
        return new l(LayoutInflater.from(this.mContext).inflate(R.layout.pb_child_title, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.e eVar, l lVar) {
        super.a(i, view, viewGroup, (ViewGroup) eVar, (com.baidu.tieba.pb.data.e) lVar);
        lVar.a(eVar);
        lVar.onChangeSkinType();
        return view;
    }
}
