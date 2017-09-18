package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.pb.pb.main.l<k, o> {
    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public o onCreateViewHolder(ViewGroup viewGroup) {
        return new o(this.eHK.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.j.pb_recommend_video_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, o oVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, oVar);
        if (kVar != null) {
            oVar.a(kVar);
        }
        return view;
    }
}
