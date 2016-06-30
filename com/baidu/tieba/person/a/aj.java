package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.a.a<al, com.baidu.tieba.person.b.r> {
    private BaseFragmentActivity bfw;
    private View.OnClickListener egT;

    /* JADX INFO: Access modifiers changed from: protected */
    public aj(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public com.baidu.tieba.person.b.r a(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.r rVar = new com.baidu.tieba.person.b.r(LayoutInflater.from(this.mContext).inflate(u.h.person_info_user_pics_layout, viewGroup, false), this.bfw);
        rVar.emB.setItemOnclickListener(this.egT);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, al alVar, com.baidu.tieba.person.b.r rVar) {
        if (alVar != null && rVar != null) {
            rVar.aLM();
            if (this.aMF) {
                rVar.a(alVar);
                this.aMF = false;
            }
        }
        return view;
    }

    public void L(View.OnClickListener onClickListener) {
        this.egT = onClickListener;
    }
}
