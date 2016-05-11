package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.i, com.baidu.tieba.person.b.q> {
    private BaseFragmentActivity cSp;
    private View.OnClickListener dxA;

    public ai(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public com.baidu.tieba.person.b.q b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.q(LayoutInflater.from(this.cSp.getPageContext().getPageActivity()).inflate(t.h.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.i iVar, com.baidu.tieba.person.b.q qVar) {
        if (qVar == null || iVar == null) {
            return null;
        }
        qVar.I(this.dxA);
        qVar.c(iVar);
        return qVar.getView();
    }

    public void I(View.OnClickListener onClickListener) {
        this.dxA = onClickListener;
    }
}
