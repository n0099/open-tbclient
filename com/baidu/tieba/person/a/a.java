package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.d, com.baidu.tieba.person.b.a> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public com.baidu.tieba.person.b.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(R.layout.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.d dVar, com.baidu.tieba.person.b.a aVar) {
        if (dVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (aVar.csg != skinType) {
                aVar.csg = skinType;
                am.setBackgroundResource(aVar.ijP, dVar.backgroundId);
            }
            ViewGroup.LayoutParams layoutParams = aVar.ijP.getLayoutParams();
            if (dVar.ifx > 0) {
                layoutParams.height = dVar.ifx;
            }
            if (dVar.ifw > 0) {
                layoutParams.width = dVar.ifw;
            }
            aVar.ijP.setLayoutParams(layoutParams);
            aVar.ijP.setOnClickListener(null);
        }
        return view;
    }
}
