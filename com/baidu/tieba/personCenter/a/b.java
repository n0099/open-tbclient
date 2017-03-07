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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.b, com.baidu.tieba.personCenter.e.a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public com.baidu.tieba.personCenter.e.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.e.a(LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.b bVar, com.baidu.tieba.personCenter.e.a aVar) {
        if (bVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (aVar.amL != skinType) {
                aVar.amL = skinType;
                aq.j(aVar.bsy, bVar.eCV);
            }
            ViewGroup.LayoutParams layoutParams = aVar.bsy.getLayoutParams();
            if (bVar.eya > 0) {
                layoutParams.height = bVar.eya;
            }
            if (bVar.exZ > 0) {
                layoutParams.width = bVar.exZ;
            }
            aVar.bsy.setLayoutParams(layoutParams);
            aVar.bsy.setOnClickListener(null);
        }
        return view;
    }
}
