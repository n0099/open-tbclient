package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.a.a<aj, com.baidu.tieba.person.holder.r> {
    private BaseFragmentActivity bgI;
    private View.OnClickListener eqS;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public com.baidu.tieba.person.holder.r a(ViewGroup viewGroup) {
        com.baidu.tieba.person.holder.r rVar = new com.baidu.tieba.person.holder.r(LayoutInflater.from(this.mContext).inflate(u.h.person_info_user_pics_layout, viewGroup, false), this.bgI);
        rVar.exa.setItemOnclickListener(this.eqS);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aj ajVar, com.baidu.tieba.person.holder.r rVar) {
        if (ajVar != null && rVar != null) {
            rVar.aOp();
            if (this.aNz) {
                rVar.a(ajVar);
                this.aNz = false;
            }
        }
        return view;
    }

    public void L(View.OnClickListener onClickListener) {
        this.eqS = onClickListener;
    }
}
