package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.b, com.baidu.tieba.person.holder.e> {
    private BaseFragmentActivity bgI;
    private View.OnClickListener epV;

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public com.baidu.tieba.person.holder.e a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.e(LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.holder.e eVar) {
        if (eVar == null || bVar == null) {
            return null;
        }
        eVar.J(this.epV);
        eVar.c(bVar);
        return eVar.getView();
    }

    public void J(View.OnClickListener onClickListener) {
        this.epV = onClickListener;
    }
}
