package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class z extends c<aa, com.baidu.tieba.person.b.k> {
    private View.OnClickListener cML;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.person.b.k a(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.k kVar = new com.baidu.tieba.person.b.k(LayoutInflater.from(this.mContext).inflate(n.g.person_info_user_pics_layout, viewGroup, false), this.mContext);
        kVar.cQe.G(this.cML);
        return kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aa aaVar, com.baidu.tieba.person.b.k kVar) {
        if (aaVar != null && kVar != null) {
            kVar.aos();
            if (this.aRB) {
                kVar.a(aaVar);
                this.aRB = false;
            }
        }
        return view;
    }

    public void F(View.OnClickListener onClickListener) {
        this.cML = onClickListener;
    }
}
