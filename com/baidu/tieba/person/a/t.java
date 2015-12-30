package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class t extends c<com.baidu.tieba.person.data.k, com.baidu.tieba.person.b.j> {
    private View.OnClickListener mClickListener;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mClickListener = new u(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public com.baidu.tieba.person.b.j a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.j(LayoutInflater.from(this.mContext).inflate(n.h.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.k kVar, com.baidu.tieba.person.b.j jVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(jVar);
        if (kVar != null && this.aVr) {
            a(jVar, kVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        jVar.cTJ.setOnClickListener(this.mClickListener);
    }

    private void a(com.baidu.tieba.person.b.j jVar) {
        int skinType;
        if (jVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != jVar.mSkinType) {
            as.i(jVar.cTJ, n.f.addresslist_item_bg);
            as.c(jVar.cTM, n.f.icon_mine_live);
            as.c(jVar.cTL, n.f.icon_arrow_tab);
            as.j(jVar.cTb, n.d.cp_bg_line_c);
            as.b(jVar.cTK, n.d.cp_cont_f, 1);
            jVar.mSkinType = skinType;
        }
    }
}
