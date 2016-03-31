package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ad extends c<ae, com.baidu.tieba.person.b.n> {
    private View.OnClickListener dvy;

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.person.b.n b(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.n nVar = new com.baidu.tieba.person.b.n(LayoutInflater.from(this.mContext).inflate(t.h.person_info_user_pics_layout, viewGroup, false), this.mContext);
        nVar.dAD.setClickListener(this.dvy);
        return nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ae aeVar, com.baidu.tieba.person.b.n nVar) {
        if (aeVar != null && nVar != null) {
            nVar.aCv();
            if (this.bcn) {
                nVar.a(aeVar);
                this.bcn = false;
            }
        }
        return view;
    }

    public void P(View.OnClickListener onClickListener) {
        this.dvy = onClickListener;
    }
}
