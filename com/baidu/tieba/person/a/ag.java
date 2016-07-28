package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.k, com.baidu.tieba.person.holder.q> {
    private BaseFragmentActivity bgI;
    private View.OnClickListener epV;

    public ag(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public com.baidu.tieba.person.holder.q a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.q(LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.k kVar, com.baidu.tieba.person.holder.q qVar) {
        if (qVar == null || kVar == null) {
            return null;
        }
        qVar.J(this.epV);
        qVar.c(kVar);
        return qVar.getView();
    }

    public void J(View.OnClickListener onClickListener) {
        this.epV = onClickListener;
    }
}
