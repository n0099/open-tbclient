package com.baidu.tieba.recommendfrs.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<g, C0078a> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public C0078a b(ViewGroup viewGroup) {
        TextView textView = new TextView(this.mContext);
        textView.setText(t.j.god_acction_notice);
        textView.setTextSize(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize28));
        textView.setGravity(17);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)));
        return new C0078a(textView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, C0078a c0078a) {
        if (c0078a.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.l(c0078a.getView(), t.d.cp_bg_line_e);
            at.j(c0078a.getView(), t.d.cp_cont_d);
            c0078a.aik = TbadkCoreApplication.m411getInst().getSkinType();
        }
        return c0078a.getView();
    }

    /* renamed from: com.baidu.tieba.recommendfrs.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0078a extends x.a {
        public int aik;

        public C0078a(View view) {
            super(view);
            this.aik = 3;
        }
    }
}
