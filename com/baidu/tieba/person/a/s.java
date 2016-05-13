package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class s extends c<com.baidu.tieba.person.data.l, com.baidu.tieba.person.b.k> {
    private View.OnClickListener Fn;
    private List<MyGroup> dxS;
    private String dxT;
    private com.baidu.tbadk.data.h dxU;
    private PersonTainInfo dxV;
    private a dxW;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.tieba.person.b.k b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.k(LayoutInflater.from(this.mContext).inflate(t.h.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.k kVar) {
        a(kVar);
        if (lVar != null && this.bUL) {
            a(kVar, lVar);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        if (lVar != null && lVar.getUserData() != null && kVar != null) {
            this.dxU = lVar.aCo();
            this.dxV = lVar.aCn();
            this.Fn = new b(lVar.getUserId(), lVar.getSex());
            this.userId = lVar.getUserId();
            this.isSelf = lVar.getIsSelf();
            int AD = this.dxU != null ? this.dxU.AD() : 1;
            int isFriend = this.dxV != null ? this.dxV.getIsFriend() : 1;
            if (lVar.dzf) {
                kVar.dBV.setVisibility(0);
            } else {
                kVar.dBV.setVisibility(8);
            }
            if (this.isSelf) {
                b(kVar, lVar);
            } else if (AD == 1 || (AD == 2 && isFriend == 1)) {
                b(kVar, lVar);
            } else {
                c(kVar, lVar);
            }
            kVar.dBW.setOnClickListener(this.Fn);
        }
    }

    private void b(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        String str;
        if (lVar != null && kVar != null) {
            this.dxS = lVar.aCm();
            this.isSelf = lVar.getIsSelf();
            this.dxT = this.mContext.getResources().getString(t.j.my_groups);
            String string = this.mContext.getResources().getString(t.j.members_in_group);
            int i = 0;
            if (!this.isSelf && lVar.getSex() == 2) {
                this.dxT = this.mContext.getResources().getString(t.j.her_groups);
            } else if (!this.isSelf && (lVar.getSex() == 1 || lVar.getSex() == 0)) {
                this.dxT = this.mContext.getResources().getString(t.j.his_groups);
            }
            if (com.baidu.tbadk.core.util.y.r(this.dxS) == 0) {
                kVar.dBW.setVisibility(8);
                kVar.dBP.setVisibility(8);
                kVar.dCr.setVisibility(0);
                kVar.dCs.setText(this.dxT);
                kVar.dBP.setPadding(0, 0, 0, 0);
                kVar.dCr.setOnClickListener(this.Fn);
                return;
            }
            if (this.dxV != null) {
                i = this.dxV.getGroupNum();
            }
            kVar.dBX.setText(this.dxT);
            kVar.dBW.setVisibility(0);
            kVar.dCr.setVisibility(8);
            kVar.dBP.setVisibility(0);
            kVar.dCa.setVisibility(0);
            kVar.dBZ.setText(ay.A(i));
            int r = com.baidu.tbadk.core.util.y.r(this.dxS);
            int i2 = 0;
            String str2 = "";
            while (i2 < r && i2 < 2) {
                if (i2 == 0) {
                    kVar.dCA.setVisibility(0);
                    kVar.dCB.setVisibility(0);
                    kVar.dCD.setVisibility(0);
                    kVar.dCC.setVisibility(0);
                    kVar.dCE.setVisibility(8);
                    if (com.baidu.tbadk.core.util.y.c(this.dxS, i2) != null) {
                        kVar.dCC.setText(ay.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getmGroupName(), 8, "..."));
                        kVar.dCB.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    kVar.dCD.setText(str);
                    kVar.dBN.setVisibility(8);
                    this.dxW = new a(((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getGroupId());
                    kVar.dCA.setOnClickListener(this.dxW);
                    kVar.dCA.setPadding(kVar.dCA.getPaddingLeft(), kVar.dCA.getPaddingTop(), kVar.dCA.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                } else if (i2 == 1) {
                    kVar.dCE.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.dxS, i2) != null) {
                        kVar.dCG.setText(ay.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getmGroupName(), 8, "..."));
                        kVar.dCF.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    kVar.dCH.setText(str);
                    kVar.dBN.setVisibility(0);
                    this.dxW = new a(((MyGroup) com.baidu.tbadk.core.util.y.c(this.dxS, i2)).getGroupId());
                    kVar.dCE.setOnClickListener(this.dxW);
                    kVar.dCA.setPadding(kVar.dCA.getPaddingLeft(), kVar.dCA.getPaddingTop(), kVar.dCA.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds16));
                    kVar.dCE.setPadding(kVar.dCE.getPaddingLeft(), kVar.dCE.getPaddingTop(), kVar.dCE.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        kVar.dBW.setVisibility(8);
        kVar.dCa.setVisibility(8);
        kVar.dBP.setVisibility(8);
        kVar.dCr.setVisibility(0);
        kVar.dCu.setVisibility(0);
        kVar.dCt.setText(t.j.set_private);
        this.dxT = this.mContext.getResources().getString(t.j.my_groups);
        if (!this.isSelf && lVar.getSex() == 2) {
            this.dxT = this.mContext.getResources().getString(t.j.her_groups);
        } else if (!this.isSelf && (lVar.getSex() == 1 || lVar.getSex() == 0)) {
            this.dxT = this.mContext.getResources().getString(t.j.his_groups);
        }
        kVar.dCs.setText(this.dxT);
        kVar.dCr.setOnClickListener(new t(this));
    }

    private void a(com.baidu.tieba.person.b.k kVar) {
        if (kVar != null && kVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(kVar.dCA, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(kVar.dCE, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(kVar.dCr, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(kVar.getView(), t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(kVar.dBV, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(kVar.dCa, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(kVar.dBN, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(kVar.dBX, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dBZ, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCC, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCD, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCG, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCH, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCs, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCt, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dCH, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(kVar.dBY, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.c(kVar.dCu, t.f.icon_mycenter_lock);
            kVar.aej = TbadkCoreApplication.m11getInst().getSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private String id;
        private int sex;

        public b(String str, int i) {
            this.id = str;
            this.sex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.id != null && bl.ac(s.this.mContext)) {
                if (!s.this.isSelf) {
                    if (s.this.userId != null) {
                        if (view.getId() == t.g.group_head) {
                            TiebaStatic.log(new aw("c10620").s("obj_type", 1).ac("obj_id", s.this.userId));
                        } else if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new aw("c10620").s("obj_type", 3).ac("obj_id", s.this.userId));
                        }
                    }
                } else if (view.getId() == t.g.group_head) {
                    TiebaStatic.log(new aw("c10592").s("obj_type", 1));
                } else if (view.getId() == t.g.group_none) {
                    TiebaStatic.log(new aw("c10592").s("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(s.this.mContext, this.id, this.sex)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private long groupId;

        public a(long j) {
            this.groupId = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bl.ac(s.this.mContext)) {
                if (!s.this.isSelf) {
                    if (s.this.userId != null) {
                        TiebaStatic.log(new aw("c10620").s("obj_type", 2).ac("obj_id", s.this.userId));
                    }
                } else {
                    TiebaStatic.log(new aw("c10592").s("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(s.this.mContext, this.groupId, 0)));
            }
        }
    }
}
