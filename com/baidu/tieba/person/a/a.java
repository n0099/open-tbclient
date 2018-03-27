package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.d, com.baidu.tieba.person.b.a> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public com.baidu.tieba.person.b.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(d.h.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.d dVar, com.baidu.tieba.person.b.a aVar) {
        if (dVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (aVar.bfC != skinType) {
                aVar.bfC = skinType;
                aj.s(aVar.giB, dVar.bxS);
            }
            ViewGroup.LayoutParams layoutParams = aVar.giB.getLayoutParams();
            if (dVar.get > 0) {
                layoutParams.height = dVar.get;
            }
            if (dVar.ges > 0) {
                layoutParams.width = dVar.ges;
            }
            aVar.giB.setLayoutParams(layoutParams);
            aVar.giB.setOnClickListener(null);
        }
        return view;
    }
}
