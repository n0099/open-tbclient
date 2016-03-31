package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends c<com.baidu.tieba.person.data.e, com.baidu.tieba.person.b.e> {
    private com.baidu.tieba.person.data.e duK;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aD */
    public com.baidu.tieba.person.b.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_fans_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.e eVar, com.baidu.tieba.person.b.e eVar2) {
        a(eVar2, view);
        if (eVar != null && this.bcn) {
            a(eVar2, eVar, view);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.e eVar2, View view) {
        if (eVar2 != null) {
            this.userId = eVar2.userId;
            if (eVar2.sex == 2) {
                eVar.dyt.setText(this.mContext.getResources().getString(t.j.attention_to_her));
            } else {
                eVar.dyt.setText(this.mContext.getResources().getString(t.j.attention_to_him));
            }
            if (eVar2.dwm > 0) {
                eVar.dyu.setVisibility(0);
                eVar.dyi.setVisibility(0);
                eVar.dyh.setVisibility(4);
                eVar.dyu.setText(new StringBuilder(String.valueOf(eVar2.dwm)).toString());
            } else {
                eVar.dyu.setVisibility(4);
                eVar.dyi.setVisibility(4);
                eVar.dyh.setVisibility(0);
            }
            a(view, eVar2);
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar, View view) {
        if (eVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(view, t.f.addresslist_item_bg);
            at.b(eVar.dyt, t.d.cp_cont_f, 1);
            at.b(eVar.dyu, t.d.cp_cont_c, 1);
            at.l(eVar.aKi, t.d.cp_bg_line_b);
            at.l(eVar.aRI, t.d.cp_bg_line_c);
            at.b(eVar.dyh, t.d.cp_cont_d, 1);
            at.c(eVar.dyi, t.f.icon_arrow_tab);
        }
    }

    private void a(View view, com.baidu.tieba.person.data.e eVar) {
        if (eVar != null) {
            this.duK = eVar;
            view.setOnClickListener(new h(this));
        }
    }
}
