package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.m, com.baidu.tieba.person.holder.d> {
    private BaseFragmentActivity bgI;
    private boolean cjo;
    private String erk;
    private String erl;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public am(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.cjo = false;
        this.erk = "c10433";
        this.erl = "c10434";
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public com.baidu.tieba.person.holder.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.d(LayoutInflater.from(this.mContext).inflate(u.h.personinfo_card_membership, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.holder.d dVar) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (this.aNz) {
            a(dVar, mVar);
            this.aNz = false;
        }
        com.baidu.tbadk.j.a.a(this.bgI.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.holder.d dVar, com.baidu.tieba.person.data.m mVar) {
        if (mVar != null) {
            LinearLayout linearLayout = (LinearLayout) dVar.getView();
            this.cjo = mVar.cjo;
            if (this.cjo) {
                dVar.euj.setVisibility(0);
                dVar.euj.c(mVar.mVipIcon, 10, false);
                dVar.euk.setText(mVar.mTitle);
                if (!StringUtils.isNull(mVar.mContent)) {
                    dVar.eul.setText(mVar.mContent);
                }
            } else {
                linearLayout.setVisibility(8);
            }
            linearLayout.setOnClickListener(new an(this, mVar));
        }
    }
}
