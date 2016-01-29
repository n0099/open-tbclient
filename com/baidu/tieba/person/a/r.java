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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class r extends c<com.baidu.tieba.person.data.k, com.baidu.tieba.person.b.j> {
    private View.OnClickListener OS;
    private List<MyGroup> das;
    private String dau;
    private com.baidu.tbadk.data.f dav;
    private PersonTainInfo daw;
    private a dax;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public com.baidu.tieba.person.b.j b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.j(LayoutInflater.from(this.mContext).inflate(t.h.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.k kVar, com.baidu.tieba.person.b.j jVar) {
        a(jVar);
        if (kVar != null && this.aXE) {
            a(jVar, kVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        if (kVar != null && kVar.getUserData() != null && jVar != null) {
            this.dav = kVar.aun();
            this.daw = kVar.aum();
            this.OS = new b(kVar.getUserId(), kVar.getSex());
            this.userId = kVar.getUserId();
            this.isSelf = kVar.getIsSelf();
            int Cd = this.dav != null ? this.dav.Cd() : 1;
            int isFriend = this.daw != null ? this.daw.getIsFriend() : 1;
            if (kVar.dbA) {
                jVar.deo.setVisibility(0);
            } else {
                jVar.deo.setVisibility(8);
            }
            if (this.isSelf) {
                b(jVar, kVar);
            } else if (Cd == 1 || (Cd == 2 && isFriend == 1)) {
                b(jVar, kVar);
            } else {
                c(jVar, kVar);
            }
            jVar.dep.setOnClickListener(this.OS);
        }
    }

    private void b(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        String str;
        if (kVar != null && jVar != null) {
            this.das = kVar.aul();
            this.isSelf = kVar.getIsSelf();
            this.dau = this.mContext.getResources().getString(t.j.my_groups);
            String string = this.mContext.getResources().getString(t.j.members_in_group);
            int i = 0;
            if (!this.isSelf && kVar.getSex() == 2) {
                this.dau = this.mContext.getResources().getString(t.j.her_groups);
            } else if (!this.isSelf && (kVar.getSex() == 1 || kVar.getSex() == 0)) {
                this.dau = this.mContext.getResources().getString(t.j.his_groups);
            }
            if (com.baidu.tbadk.core.util.x.o(this.das) == 0) {
                jVar.dep.setVisibility(8);
                jVar.deh.setVisibility(8);
                jVar.deK.setVisibility(0);
                jVar.deL.setText(this.dau);
                jVar.deh.setPadding(0, 0, 0, 0);
                jVar.deK.setOnClickListener(this.OS);
                return;
            }
            if (this.daw != null) {
                i = this.daw.getGroupNum();
            }
            jVar.deq.setText(this.dau);
            jVar.dep.setVisibility(0);
            jVar.deK.setVisibility(8);
            jVar.deh.setVisibility(0);
            jVar.det.setVisibility(0);
            jVar.des.setText(aw.x(i));
            int o = com.baidu.tbadk.core.util.x.o(this.das);
            int i2 = 0;
            String str2 = "";
            while (i2 < o && i2 < 2) {
                if (i2 == 0) {
                    jVar.deT.setVisibility(0);
                    jVar.deU.setVisibility(0);
                    jVar.deW.setVisibility(0);
                    jVar.deV.setVisibility(0);
                    jVar.deX.setVisibility(8);
                    if (com.baidu.tbadk.core.util.x.b(this.das, i2) != null) {
                        jVar.deV.setText(aw.d(((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getmGroupName(), 8, "..."));
                        jVar.deU.d(((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    jVar.deW.setText(str);
                    jVar.def.setVisibility(8);
                    this.dax = new a(((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getGroupId());
                    jVar.deT.setOnClickListener(this.dax);
                    jVar.deT.setPadding(jVar.deT.getPaddingLeft(), jVar.deT.getPaddingTop(), jVar.deT.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                } else if (i2 == 1) {
                    jVar.deX.setVisibility(0);
                    if (com.baidu.tbadk.core.util.x.b(this.das, i2) != null) {
                        jVar.deZ.setText(aw.d(((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getmGroupName(), 8, "..."));
                        jVar.deY.d(((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    jVar.dfa.setText(str);
                    jVar.def.setVisibility(0);
                    this.dax = new a(((MyGroup) com.baidu.tbadk.core.util.x.b(this.das, i2)).getGroupId());
                    jVar.deX.setOnClickListener(this.dax);
                    jVar.deT.setPadding(jVar.deT.getPaddingLeft(), jVar.deT.getPaddingTop(), jVar.deT.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds16));
                    jVar.deX.setPadding(jVar.deX.getPaddingLeft(), jVar.deX.getPaddingTop(), jVar.deX.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        jVar.dep.setVisibility(8);
        jVar.det.setVisibility(8);
        jVar.deh.setVisibility(8);
        jVar.deK.setVisibility(0);
        jVar.deN.setVisibility(0);
        jVar.deM.setText(t.j.set_private);
        this.dau = this.mContext.getResources().getString(t.j.my_groups);
        if (!this.isSelf && kVar.getSex() == 2) {
            this.dau = this.mContext.getResources().getString(t.j.her_groups);
        } else if (!this.isSelf && (kVar.getSex() == 1 || kVar.getSex() == 0)) {
            this.dau = this.mContext.getResources().getString(t.j.his_groups);
        }
        jVar.deL.setText(this.dau);
        jVar.deK.setOnClickListener(new s(this));
    }

    private void a(com.baidu.tieba.person.b.j jVar) {
        if (jVar != null && jVar.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            ar.k(jVar.deT, t.f.addresslist_item_bg);
            ar.k(jVar.deX, t.f.addresslist_item_bg);
            ar.k(jVar.deK, t.f.addresslist_item_bg);
            ar.l(jVar.getView(), t.d.cp_bg_line_d);
            ar.l(jVar.deo, t.d.cp_bg_line_c);
            ar.l(jVar.det, t.d.cp_bg_line_c);
            ar.l(jVar.def, t.d.cp_bg_line_c);
            ar.b(jVar.deq, t.d.cp_cont_f, 1);
            ar.b(jVar.des, t.d.cp_cont_c, 1);
            ar.b(jVar.deV, t.d.cp_cont_b, 1);
            ar.b(jVar.deW, t.d.cp_cont_d, 1);
            ar.b(jVar.deZ, t.d.cp_cont_b, 1);
            ar.b(jVar.dfa, t.d.cp_cont_d, 1);
            ar.b(jVar.deL, t.d.cp_cont_f, 1);
            ar.b(jVar.deM, t.d.cp_cont_d, 1);
            ar.b(jVar.dfa, t.d.cp_cont_d, 1);
            ar.c(jVar.der, t.f.icon_arrow_tab);
            ar.c(jVar.deN, t.f.icon_mycenter_lock);
            jVar.ahU = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && bi.ah(r.this.mContext)) {
                if (!r.this.isSelf) {
                    if (r.this.userId != null) {
                        if (view.getId() == t.g.group_head) {
                            TiebaStatic.log(new au("c10620").r("obj_type", 1).aa("obj_id", r.this.userId));
                        } else if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new au("c10620").r("obj_type", 3).aa("obj_id", r.this.userId));
                        }
                    }
                } else if (view.getId() == t.g.group_head) {
                    TiebaStatic.log(new au("c10592").r("obj_type", 1));
                } else if (view.getId() == t.g.group_none) {
                    TiebaStatic.log(new au("c10592").r("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(r.this.mContext, this.id, this.sex)));
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
            if (bi.ah(r.this.mContext)) {
                if (!r.this.isSelf) {
                    if (r.this.userId != null) {
                        TiebaStatic.log(new au("c10620").r("obj_type", 2).aa("obj_id", r.this.userId));
                    }
                } else {
                    TiebaStatic.log(new au("c10592").r("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(r.this.mContext, this.groupId, 0)));
            }
        }
    }
}
