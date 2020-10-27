package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class y extends o<z, aa> {
    private BdUniqueId jwu;
    private com.baidu.tieba.pb.data.f pbData;

    public y(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, z.lqk);
        this.jwu = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public aa c(ViewGroup viewGroup) {
        return new aa(LayoutInflater.from(this.mContext).inflate(R.layout.pb_image_ala_recomment_layout, viewGroup, false), this.lml.getPageContext(), this.jwu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, z zVar, aa aaVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (z) aaVar);
        if (aaVar != null) {
            aaVar.a(zVar);
            aaVar.i(this.pbData);
        }
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.pbData = fVar;
    }
}
