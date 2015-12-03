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
public class p extends c<com.baidu.tieba.person.data.i, com.baidu.tieba.person.b.h> {
    private View.OnClickListener mClickListener;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mClickListener = new q(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public com.baidu.tieba.person.b.h a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.h(LayoutInflater.from(this.mContext).inflate(n.g.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.i iVar, com.baidu.tieba.person.b.h hVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(hVar);
        if (iVar != null && this.aRB) {
            a(hVar, iVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.i iVar) {
        hVar.cOZ.setOnClickListener(this.mClickListener);
    }

    private void a(com.baidu.tieba.person.b.h hVar) {
        int skinType;
        if (hVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != hVar.mSkinType) {
            as.i(hVar.cOZ, n.e.addresslist_item_bg);
            as.c(hVar.cPc, n.e.icon_mine_live);
            as.c(hVar.cPb, n.e.icon_arrow_tab);
            as.j(hVar.cOr, n.c.cp_bg_line_c);
            as.b(hVar.cPa, n.c.cp_cont_f, 1);
            hVar.mSkinType = skinType;
        }
    }
}
