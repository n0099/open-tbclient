package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.b.b, com.baidu.tieba.personCenter.d.a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public com.baidu.tieba.personCenter.d.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.d.a(LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.b.b bVar, com.baidu.tieba.personCenter.d.a aVar) {
        if (bVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (aVar.ane != skinType) {
                aVar.ane = skinType;
                aq.j(aVar.buG, bVar.eyG);
            }
            ViewGroup.LayoutParams layoutParams = aVar.buG.getLayoutParams();
            if (bVar.eug > 0) {
                layoutParams.height = bVar.eug;
            }
            if (bVar.euf > 0) {
                layoutParams.width = bVar.euf;
            }
            aVar.buG.setLayoutParams(layoutParams);
            aVar.buG.setOnClickListener(null);
        }
        return view;
    }
}
