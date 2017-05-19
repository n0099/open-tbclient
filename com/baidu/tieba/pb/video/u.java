package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends dh<v, z> {
    public u(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        return new z(this.efF.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, z zVar) {
        super.onFillViewHolder(i, view, viewGroup, vVar, zVar);
        if (vVar != null) {
            zVar.a(vVar);
        }
        return view;
    }
}
