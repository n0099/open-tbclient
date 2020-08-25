package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ab extends o<ac, ad> {
    private com.baidu.tieba.pb.data.f pbData;

    public ab(com.baidu.tieba.pb.videopb.b bVar) {
        super(bVar, ac.kGB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public ad b(ViewGroup viewGroup) {
        return new ad(LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.kBW.cYi());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ac acVar, ad adVar) {
        super.a(i, view, viewGroup, (ViewGroup) acVar, (ac) adVar);
        if (acVar == null) {
            return null;
        }
        adVar.a(acVar);
        adVar.i(this.pbData);
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.pbData = fVar;
    }
}
