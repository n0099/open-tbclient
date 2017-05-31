package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.dn;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab extends dn<ac, ag> {
    public ab(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public ag onCreateViewHolder(ViewGroup viewGroup) {
        return new ag(this.elf.getPageContext(), LayoutInflater.from(this.mContext).inflate(w.j.pb_recommend_video_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dn, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ac acVar, ag agVar) {
        super.onFillViewHolder(i, view, viewGroup, acVar, agVar);
        if (acVar != null) {
            agVar.a(acVar);
        }
        return view;
    }
}
