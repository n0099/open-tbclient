package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.person.d;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<d, com.baidu.tieba.person.b.a> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
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
            if (aVar.bdK != skinType) {
                aVar.bdK = skinType;
                aj.s(aVar.cTc, dVar.bvJ);
            }
            ViewGroup.LayoutParams layoutParams = aVar.cTc.getLayoutParams();
            if (dVar.gaO > 0) {
                layoutParams.height = dVar.gaO;
            }
            if (dVar.gaN > 0) {
                layoutParams.width = dVar.gaN;
            }
            aVar.cTc.setLayoutParams(layoutParams);
            aVar.cTc.setOnClickListener(null);
        }
        return view;
    }
}
