package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class en extends ct<com.baidu.tbadk.core.data.ar, eo> {
    /* JADX INFO: Access modifiers changed from: protected */
    public en(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public eo a(ViewGroup viewGroup) {
        return new eo(this.eug.getPageContext(), LayoutInflater.from(this.mContext).inflate(r.h.pb_recommend_novel, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ct, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ar arVar, eo eoVar) {
        super.a(i, view, viewGroup, (ViewGroup) arVar, (com.baidu.tbadk.core.data.ar) eoVar);
        if (arVar != null) {
            eoVar.a(arVar);
        }
        return view;
    }
}
