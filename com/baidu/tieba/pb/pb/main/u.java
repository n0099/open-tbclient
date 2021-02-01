package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class u extends l<v, PbImageAlaRecommendVH> {
    private BdUniqueId khF;
    private com.baidu.tieba.pb.data.f pbData;

    public u(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, v.lTS);
        this.khF = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cv */
    public PbImageAlaRecommendVH e(ViewGroup viewGroup) {
        return new PbImageAlaRecommendVH(LayoutInflater.from(this.mContext).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.lPU.getPageContext(), this.khF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, v vVar, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (v) pbImageAlaRecommendVH);
        if (pbImageAlaRecommendVH != null) {
            pbImageAlaRecommendVH.a(vVar);
            pbImageAlaRecommendVH.i(this.pbData);
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.pbData = fVar;
    }
}
