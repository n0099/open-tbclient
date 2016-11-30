package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.b, com.baidu.tieba.personCenter.e.a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public com.baidu.tieba.personCenter.e.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.e.a(LayoutInflater.from(this.mContext).inflate(r.h.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.b bVar, com.baidu.tieba.personCenter.e.a aVar) {
        if (bVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (aVar.aiA != skinType) {
                aVar.aiA = skinType;
                at.k(aVar.eMf, bVar.eMb);
            }
            ViewGroup.LayoutParams layoutParams = aVar.eMf.getLayoutParams();
            if (bVar.eGS > 0) {
                layoutParams.height = bVar.eGS;
            }
            if (bVar.eGR > 0) {
                layoutParams.width = bVar.eGR;
            }
            aVar.eMf.setLayoutParams(layoutParams);
            aVar.eMf.setOnClickListener(null);
        }
        return view;
    }
}
