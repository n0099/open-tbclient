package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ad extends c<ae, com.baidu.tieba.person.b.m> {
    private View.OnClickListener cRp;

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.person.b.m a(ViewGroup viewGroup) {
        com.baidu.tieba.person.b.m mVar = new com.baidu.tieba.person.b.m(LayoutInflater.from(this.mContext).inflate(n.h.person_info_user_pics_layout, viewGroup, false), this.mContext);
        mVar.cUG.G(this.cRp);
        return mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ae aeVar, com.baidu.tieba.person.b.m mVar) {
        if (aeVar != null && mVar != null) {
            mVar.apC();
            if (this.aVr) {
                mVar.a(aeVar);
                this.aVr = false;
            }
        }
        return view;
    }

    public void F(View.OnClickListener onClickListener) {
        this.cRp = onClickListener;
    }
}
