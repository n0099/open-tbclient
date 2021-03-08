package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class w extends l<x, PbListAlaRecommendVH> {
    private com.baidu.tieba.pb.data.f pbData;

    public w(com.baidu.tieba.pb.videopb.b bVar) {
        super(bVar, x.lWU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cv */
    public PbListAlaRecommendVH e(ViewGroup viewGroup) {
        return new PbListAlaRecommendVH(LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.lSl.doq());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar, PbListAlaRecommendVH pbListAlaRecommendVH) {
        super.a(i, view, viewGroup, (ViewGroup) xVar, (x) pbListAlaRecommendVH);
        if (xVar == null) {
            return null;
        }
        pbListAlaRecommendVH.a(xVar);
        pbListAlaRecommendVH.i(this.pbData);
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.pbData = fVar;
    }
}
