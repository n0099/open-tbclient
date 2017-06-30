package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ff extends du<fb, fd> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ff(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public fd onCreateViewHolder(ViewGroup viewGroup) {
        return new fd(this.euf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_page_news, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.du, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, fb fbVar, fd fdVar) {
        super.onFillViewHolder(i, view, viewGroup, fbVar, fdVar);
        if (fbVar != null) {
            fdVar.a(fbVar);
            fdVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }
}
