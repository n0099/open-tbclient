package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cz;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class r extends cz<s, w> {
    public r(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public w onCreateViewHolder(ViewGroup viewGroup) {
        return new w(this.eka.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cz, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, w wVar) {
        super.onFillViewHolder(i, view, viewGroup, sVar, wVar);
        if (sVar != null) {
            wVar.a(sVar);
        }
        return view;
    }
}
