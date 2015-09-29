package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class br extends bk<com.baidu.tbadk.core.data.z, bq> {
    private View.OnClickListener bML;

    /* JADX INFO: Access modifiers changed from: protected */
    public br(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public bq a(ViewGroup viewGroup) {
        return new bq(LayoutInflater.from(this.mContext).inflate(i.g.pb_u9_news_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bk, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, bq bqVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) bqVar);
        if (zVar != null) {
            bqVar.cjN.setOnClickListener(this.bML);
            bqVar.cjN.setText(zVar.getSummary());
            bqVar.cjN.setTag(zVar);
            com.baidu.tbadk.core.util.am.j(bqVar.cjO, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.b(bqVar.cjN, i.c.cp_cont_b, 1);
            bqVar.cjN.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_frs_news), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        return view;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bML = onClickListener;
    }
}
