package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class w extends m<x, y> {
    private BdUniqueId ibz;
    private com.baidu.tieba.pb.data.e pbData;

    public w(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, x.jML);
        this.ibz = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bU */
    public y b(ViewGroup viewGroup) {
        return new y(LayoutInflater.from(this.mContext).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.jJa.getPageContext(), this.ibz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar, y yVar) {
        super.a(i, view, viewGroup, (ViewGroup) xVar, (x) yVar);
        if (yVar != null) {
            yVar.a(xVar);
            yVar.i(this.pbData);
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.pbData = eVar;
    }
}
