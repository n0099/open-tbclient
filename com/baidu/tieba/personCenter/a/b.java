package com.baidu.tieba.personCenter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personCenter.c.b, com.baidu.tieba.personCenter.e.a> {
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public com.baidu.tieba.personCenter.e.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.e.a(LayoutInflater.from(this.mContext).inflate(t.h.item_person_center_list_interval, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personCenter.c.b bVar, com.baidu.tieba.personCenter.e.a aVar) {
        if (bVar != null && aVar != null) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (aVar.ait != skinType) {
                aVar.ait = skinType;
                av.k(aVar.eDC, bVar.eDz);
            }
            ViewGroup.LayoutParams layoutParams = aVar.eDC.getLayoutParams();
            if (bVar.eyc > 0) {
                layoutParams.height = bVar.eyc;
            }
            if (bVar.eyb > 0) {
                layoutParams.width = bVar.eyb;
            }
            aVar.eDC.setLayoutParams(layoutParams);
            aVar.eDC.setOnClickListener(null);
        }
        return view;
    }
}
