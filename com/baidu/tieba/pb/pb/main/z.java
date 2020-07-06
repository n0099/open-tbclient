package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class z extends m<aa, ab> {
    private com.baidu.tieba.pb.data.e pbData;

    public z(com.baidu.tieba.pb.videopb.b bVar) {
        super(bVar, aa.khZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public ab b(ViewGroup viewGroup) {
        return new ab(LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_ala_recomment_layout, (ViewGroup) null), this.kdO.cJJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aa aaVar, ab abVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (aa) abVar);
        if (aaVar == null) {
            return null;
        }
        abVar.a(aaVar);
        abVar.i(this.pbData);
        return view;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.pbData = eVar;
    }
}
