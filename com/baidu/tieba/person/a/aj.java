package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aj extends c<al, com.baidu.tieba.person.b.r> {
    private BaseFragmentActivity cSp;
    private View.OnClickListener dyx;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public com.baidu.tieba.person.b.r b(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.r rVar = new com.baidu.tieba.person.b.r(LayoutInflater.from(this.mContext).inflate(t.h.person_info_user_pics_layout, viewGroup, false), this.cSp);
        rVar.dDP.setItemOnclickListener(this.dyx);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, al alVar, com.baidu.tieba.person.b.r rVar) {
        if (alVar != null && rVar != null) {
            rVar.aCQ();
            if (this.bUL) {
                rVar.a(alVar);
                this.bUL = false;
            }
        }
        return view;
    }

    public void L(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }
}
