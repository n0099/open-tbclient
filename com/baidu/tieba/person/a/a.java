package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.d, com.baidu.tieba.person.b.a> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public com.baidu.tieba.person.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(R.layout.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.d dVar, com.baidu.tieba.person.b.a aVar) {
        if (dVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (aVar.MH != skinType) {
                aVar.MH = skinType;
                am.setBackgroundResource(aVar.jfo, dVar.backgroundId);
            }
            ViewGroup.LayoutParams layoutParams = aVar.jfo.getLayoutParams();
            if (dVar.jbg > 0) {
                layoutParams.height = dVar.jbg;
            }
            if (dVar.jbf > 0) {
                layoutParams.width = dVar.jbf;
            }
            aVar.jfo.setLayoutParams(layoutParams);
            aVar.jfo.setOnClickListener(null);
        }
        return view;
    }
}
