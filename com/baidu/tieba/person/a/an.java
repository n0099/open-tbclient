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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class an extends c<com.baidu.tieba.person.data.n, com.baidu.tieba.person.b.b> {
    private boolean bJq;
    private BaseFragmentActivity cSp;
    private String dyG;
    private String dyH;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bJq = false;
        this.dyG = "c10433";
        this.dyH = "c10434";
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public com.baidu.tieba.person.b.b b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.b(LayoutInflater.from(this.mContext).inflate(t.h.personinfo_card_membership, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.b.b bVar) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (this.bUL) {
            a(bVar, nVar);
            this.bUL = false;
        }
        com.baidu.tbadk.i.a.a(this.cSp.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.b bVar, com.baidu.tieba.person.data.n nVar) {
        if (nVar != null) {
            LinearLayout linearLayout = (LinearLayout) bVar.getView();
            this.bJq = nVar.getIsSelf();
            if (this.bJq) {
                bVar.dBe.setVisibility(0);
                bVar.dBg.setVisibility(8);
                bVar.dBf.setText(t.j.person_member_center);
                if (nVar.getUserData() != null && !ay.isEmpty(nVar.getUserData().getUserId())) {
                    if (com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("membership_first_launch" + nVar.getUserData().getUserId(), true)) {
                        bVar.dBi.setVisibility(0);
                    } else {
                        bVar.dBi.setVisibility(8);
                    }
                }
            } else if (nVar.getUserData() == null || nVar.getUserData().getIsMem() == 0) {
                linearLayout.setVisibility(8);
                return;
            } else {
                linearLayout.setVisibility(0);
                bVar.dBe.setVisibility(8);
                bVar.dBg.setVisibility(0);
                bVar.dBf.setText(t.j.person_member_level);
                if (!StringUtils.isNull(nVar.getVipIcon())) {
                    bVar.dBg.setVisibility(0);
                    bVar.dBg.c(nVar.getVipIcon(), 21, false);
                } else {
                    bVar.dBg.setVisibility(8);
                }
            }
            if (!StringUtils.isNull(nVar.getVipContent())) {
                bVar.dBh.setText(nVar.getVipContent());
            }
            linearLayout.setOnClickListener(new ao(this, nVar, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBY() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
