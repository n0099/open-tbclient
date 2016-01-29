package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ag extends c<com.baidu.tieba.person.data.m, com.baidu.tieba.person.b.b> {
    private boolean bDM;
    private BaseFragmentActivity cZG;
    private String dbc;
    private String dbd;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bDM = false;
        this.dbc = "c10433";
        this.dbd = "c10434";
        this.cZG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public com.baidu.tieba.person.b.b b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_card_membership, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.b bVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.aXE) {
            a(bVar, mVar);
            this.aXE = false;
        }
        com.baidu.tbadk.i.a.a(this.cZG.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.b bVar, com.baidu.tieba.person.data.m mVar) {
        if (mVar != null) {
            LinearLayout linearLayout = (LinearLayout) bVar.getView();
            this.bDM = mVar.getIsSelf();
            if (this.bDM) {
                bVar.ddy.setVisibility(0);
                bVar.ddA.setVisibility(8);
                bVar.ddz.setText(t.j.person_member_center);
                if (mVar.getUserData() != null && !aw.isEmpty(mVar.getUserData().getUserId())) {
                    if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("membership_first_launch" + mVar.getUserData().getUserId(), true)) {
                        bVar.ddC.setVisibility(0);
                    } else {
                        bVar.ddC.setVisibility(8);
                    }
                }
            } else if (mVar.getUserData() == null || mVar.getUserData().getIsMem() == 0) {
                linearLayout.setVisibility(8);
                return;
            } else {
                linearLayout.setVisibility(0);
                bVar.ddy.setVisibility(8);
                bVar.ddA.setVisibility(0);
                bVar.ddz.setText(t.j.person_member_level);
                if (!StringUtils.isNull(mVar.getVipIcon())) {
                    bVar.ddA.setVisibility(0);
                    bVar.ddA.d(mVar.getVipIcon(), 21, false);
                } else {
                    bVar.ddA.setVisibility(8);
                }
            }
            if (!StringUtils.isNull(mVar.getVipContent())) {
                bVar.ddB.setText(mVar.getVipContent());
            }
            linearLayout.setOnClickListener(new ah(this, mVar, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auc() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
