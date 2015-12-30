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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class af extends c<com.baidu.tieba.person.data.l, com.baidu.tieba.person.b.a> {
    private boolean bAA;
    private String cRr;
    private String cRs;
    private BaseFragmentActivity mActivity;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public af(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bAA = false;
        this.cRr = "c10433";
        this.cRs = "c10434";
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.person.b.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(n.h.personinfo_card_membership, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.a aVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.aVr) {
            a(aVar, lVar);
            this.aVr = false;
        }
        com.baidu.tbadk.i.a.a(this.mActivity.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, com.baidu.tieba.person.data.l lVar) {
        if (lVar != null) {
            LinearLayout linearLayout = (LinearLayout) aVar.getView();
            this.bAA = lVar.getIsSelf();
            if (this.bAA) {
                aVar.cSo.setVisibility(0);
                aVar.cSq.setVisibility(8);
                aVar.cSp.setText(n.j.person_member_center);
                if (lVar.getUserData() != null && !ax.isEmpty(lVar.getUserData().getUserId())) {
                    if (com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("membership_first_launch" + lVar.getUserData().getUserId(), true)) {
                        aVar.cSs.setVisibility(0);
                    } else {
                        aVar.cSs.setVisibility(8);
                    }
                }
            } else if (lVar.getUserData() == null || lVar.getUserData().getIsMem() == 0) {
                linearLayout.setVisibility(8);
                return;
            } else {
                linearLayout.setVisibility(0);
                aVar.cSo.setVisibility(8);
                aVar.cSq.setVisibility(0);
                aVar.cSp.setText(n.j.person_member_level);
                if (!StringUtils.isNull(lVar.getVipIcon())) {
                    aVar.cSq.setVisibility(0);
                    aVar.cSq.d(lVar.getVipIcon(), 21, false);
                } else {
                    aVar.cSq.setVisibility(8);
                }
            }
            if (!StringUtils.isNull(lVar.getVipContent())) {
                aVar.cSr.setText(lVar.getVipContent());
            }
            linearLayout.setOnClickListener(new ag(this, lVar, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apk() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
