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
public class ab extends c<com.baidu.tieba.person.data.j, com.baidu.tieba.person.b.a> {
    private boolean bwJ;
    private String cMN;
    private String cMO;
    private BaseFragmentActivity mActivity;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bwJ = false;
        this.cMN = "c10433";
        this.cMO = "c10434";
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.person.b.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.a(LayoutInflater.from(this.mContext).inflate(n.g.personinfo_card_membership, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.j jVar, com.baidu.tieba.person.b.a aVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.aRB) {
            a(aVar, jVar);
            this.aRB = false;
        }
        com.baidu.tbadk.i.a.a(this.mActivity.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.a aVar, com.baidu.tieba.person.data.j jVar) {
        if (jVar != null) {
            LinearLayout linearLayout = (LinearLayout) aVar.getView();
            this.bwJ = jVar.getIsSelf();
            if (this.bwJ) {
                aVar.cNI.setVisibility(0);
                aVar.cNK.setVisibility(8);
                aVar.cNJ.setText(n.i.person_member_center);
                if (jVar.getUserData() != null && !ax.isEmpty(jVar.getUserData().getUserId())) {
                    if (com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("membership_first_launch" + jVar.getUserData().getUserId(), true)) {
                        aVar.cNM.setVisibility(0);
                    } else {
                        aVar.cNM.setVisibility(8);
                    }
                }
            } else if (jVar.getUserData() == null || jVar.getUserData().getIsMem() == 0) {
                linearLayout.setVisibility(8);
                return;
            } else {
                linearLayout.setVisibility(0);
                aVar.cNI.setVisibility(8);
                aVar.cNK.setVisibility(0);
                aVar.cNJ.setText(n.i.person_member_level);
                if (!StringUtils.isNull(jVar.getVipIcon())) {
                    aVar.cNK.setVisibility(0);
                    aVar.cNK.d(jVar.getVipIcon(), 21, false);
                } else {
                    aVar.cNK.setVisibility(8);
                }
            }
            if (!StringUtils.isNull(jVar.getVipContent())) {
                aVar.cNL.setText(jVar.getVipContent());
            }
            linearLayout.setOnClickListener(new ac(this, jVar, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoa() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
