package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k extends da<l, p> {
    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public p onCreateViewHolder(ViewGroup viewGroup) {
        return new p(this.ehi.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.j.pb_recommend_video_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.da, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, p pVar) {
        super.onFillViewHolder(i, view, viewGroup, lVar, pVar);
        if (lVar != null) {
            pVar.a(lVar);
        }
        return view;
    }
}
