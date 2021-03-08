package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonCenterIntervalHolder;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.d, PersonCenterIntervalHolder> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cM */
    public PersonCenterIntervalHolder e(ViewGroup viewGroup) {
        return new PersonCenterIntervalHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        if (dVar != null && personCenterIntervalHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (personCenterIntervalHolder.aln != skinType) {
                personCenterIntervalHolder.aln = skinType;
                ap.setBackgroundResource(personCenterIntervalHolder.muU, dVar.backgroundId);
            }
            ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.muU.getLayoutParams();
            if (dVar.mrs > 0) {
                layoutParams.height = dVar.mrs;
            }
            if (dVar.mrr > 0) {
                layoutParams.width = dVar.mrr;
            }
            personCenterIntervalHolder.muU.setLayoutParams(layoutParams);
            personCenterIntervalHolder.muU.setOnClickListener(null);
        }
        return view;
    }
}
