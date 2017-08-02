package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.person.h;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, com.baidu.tieba.personCenter.d.a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public com.baidu.tieba.personCenter.d.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.d.a(LayoutInflater.from(this.mContext).inflate(d.j.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, com.baidu.tieba.personCenter.d.a aVar) {
        if (hVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (aVar.aoR != skinType) {
                aVar.aoR = skinType;
                ai.j(aVar.bFs, hVar.fcI);
            }
            ViewGroup.LayoutParams layoutParams = aVar.bFs.getLayoutParams();
            if (hVar.eZs > 0) {
                layoutParams.height = hVar.eZs;
            }
            if (hVar.eZr > 0) {
                layoutParams.width = hVar.eZr;
            }
            aVar.bFs.setLayoutParams(layoutParams);
            aVar.bFs.setOnClickListener(null);
        }
        return view;
    }
}
