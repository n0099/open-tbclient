package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.d, com.baidu.tieba.person.holder.a> {
    private View.OnClickListener afk;
    private BaseFragmentActivity bgI;
    private com.baidu.tieba.person.data.d epY;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.afk = new g(this);
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public com.baidu.tieba.person.holder.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.a(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_book_shelf, viewGroup, false), this.afk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.d dVar, com.baidu.tieba.person.holder.a aVar) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (this.aNz) {
            a(aVar, dVar);
            this.aNz = false;
        }
        com.baidu.tbadk.j.a.a(this.bgI.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.holder.a aVar, com.baidu.tieba.person.data.d dVar) {
        if (dVar != null && aVar != null) {
            this.epY = dVar;
            aVar.a(dVar);
        }
    }
}
