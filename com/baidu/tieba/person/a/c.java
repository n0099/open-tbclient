package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.b, com.baidu.tieba.person.b.c> {
    private BaseFragmentActivity bfw;
    private View.OnClickListener efW;

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public com.baidu.tieba.person.b.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.c(LayoutInflater.from(this.bfw.getPageContext().getPageActivity()).inflate(u.h.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.b bVar, com.baidu.tieba.person.b.c cVar) {
        if (cVar == null || bVar == null) {
            return null;
        }
        cVar.I(this.efW);
        cVar.c(bVar);
        return cVar.getView();
    }

    public void I(View.OnClickListener onClickListener) {
        this.efW = onClickListener;
    }
}
