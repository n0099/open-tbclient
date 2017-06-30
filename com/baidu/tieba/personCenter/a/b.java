package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.person.h;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, com.baidu.tieba.personCenter.d.a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public com.baidu.tieba.personCenter.d.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.d.a(LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, com.baidu.tieba.personCenter.d.a aVar) {
        if (hVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (aVar.aoa != skinType) {
                aVar.aoa = skinType;
                as.j(aVar.bBm, hVar.eQh);
            }
            ViewGroup.LayoutParams layoutParams = aVar.bBm.getLayoutParams();
            if (hVar.eMR > 0) {
                layoutParams.height = hVar.eMR;
            }
            if (hVar.eMQ > 0) {
                layoutParams.width = hVar.eMQ;
            }
            aVar.bBm.setLayoutParams(layoutParams);
            aVar.bBm.setOnClickListener(null);
        }
        return view;
    }
}
