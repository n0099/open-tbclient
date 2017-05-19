package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fi extends dh<com.baidu.tieba.pb.data.k, fj> {
    private View.OnClickListener aSt;

    /* JADX INFO: Access modifiers changed from: protected */
    public fi(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public fj onCreateViewHolder(ViewGroup viewGroup) {
        return new fj(LayoutInflater.from(this.mContext).inflate(w.j.layout_thread_praise_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.dh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.pb.data.k kVar, fj fjVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, fjVar);
        if (kVar != null && fjVar != null) {
            fjVar.b(kVar);
            fjVar.emA.setTag(w.h.pb_main_thread_praise_data, kVar);
            fjVar.emA.setTag(w.h.pb_main_thread_praise_view, fjVar);
            fjVar.emA.setOnClickListener(this.aSt);
            fjVar.emB.setOnClickListener(this.aSt);
            fjVar.emC.setOnClickListener(this.aSt);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aSt = onClickListener;
    }
}
