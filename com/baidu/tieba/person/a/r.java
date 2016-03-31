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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class r extends c<com.baidu.tieba.person.data.k, com.baidu.tieba.person.b.j> {
    private View.OnClickListener OZ;
    private List<MyGroup> duW;
    private String duX;
    private com.baidu.tbadk.data.g duY;
    private PersonTainInfo duZ;
    private a dva;
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
    /* renamed from: aI */
    public com.baidu.tieba.person.b.j b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.j(LayoutInflater.from(this.mContext).inflate(t.h.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.k kVar, com.baidu.tieba.person.b.j jVar) {
        a(jVar);
        if (kVar != null && this.bcn) {
            a(jVar, kVar);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        if (kVar != null && kVar.getUserData() != null && jVar != null) {
            this.duY = kVar.aBT();
            this.duZ = kVar.aBS();
            this.OZ = new b(kVar.getUserId(), kVar.getSex());
            this.userId = kVar.getUserId();
            this.isSelf = kVar.getIsSelf();
            int CI = this.duY != null ? this.duY.CI() : 1;
            int isFriend = this.duZ != null ? this.duZ.getIsFriend() : 1;
            if (kVar.dwd) {
                jVar.dyN.setVisibility(0);
            } else {
                jVar.dyN.setVisibility(8);
            }
            if (this.isSelf) {
                b(jVar, kVar);
            } else if (CI == 1 || (CI == 2 && isFriend == 1)) {
                b(jVar, kVar);
            } else {
                c(jVar, kVar);
            }
            jVar.dyO.setOnClickListener(this.OZ);
        }
    }

    private void b(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        String str;
        if (kVar != null && jVar != null) {
            this.duW = kVar.aBR();
            this.isSelf = kVar.getIsSelf();
            this.duX = this.mContext.getResources().getString(t.j.my_groups);
            String string = this.mContext.getResources().getString(t.j.members_in_group);
            int i = 0;
            if (!this.isSelf && kVar.getSex() == 2) {
                this.duX = this.mContext.getResources().getString(t.j.her_groups);
            } else if (!this.isSelf && (kVar.getSex() == 1 || kVar.getSex() == 0)) {
                this.duX = this.mContext.getResources().getString(t.j.his_groups);
            }
            if (com.baidu.tbadk.core.util.y.p(this.duW) == 0) {
                jVar.dyO.setVisibility(8);
                jVar.dyH.setVisibility(8);
                jVar.dzj.setVisibility(0);
                jVar.dzk.setText(this.duX);
                jVar.dyH.setPadding(0, 0, 0, 0);
                jVar.dzj.setOnClickListener(this.OZ);
                return;
            }
            if (this.duZ != null) {
                i = this.duZ.getGroupNum();
            }
            jVar.dyP.setText(this.duX);
            jVar.dyO.setVisibility(0);
            jVar.dzj.setVisibility(8);
            jVar.dyH.setVisibility(0);
            jVar.dyS.setVisibility(0);
            jVar.dyR.setText(ay.z(i));
            int p = com.baidu.tbadk.core.util.y.p(this.duW);
            int i2 = 0;
            String str2 = "";
            while (i2 < p && i2 < 2) {
                if (i2 == 0) {
                    jVar.dzs.setVisibility(0);
                    jVar.dzt.setVisibility(0);
                    jVar.dzv.setVisibility(0);
                    jVar.dzu.setVisibility(0);
                    jVar.dzw.setVisibility(8);
                    if (com.baidu.tbadk.core.util.y.b(this.duW, i2) != null) {
                        jVar.dzu.setText(ay.c(((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getmGroupName(), 8, "..."));
                        jVar.dzt.c(((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    jVar.dzv.setText(str);
                    jVar.dyF.setVisibility(8);
                    this.dva = new a(((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getGroupId());
                    jVar.dzs.setOnClickListener(this.dva);
                    jVar.dzs.setPadding(jVar.dzs.getPaddingLeft(), jVar.dzs.getPaddingTop(), jVar.dzs.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                } else if (i2 == 1) {
                    jVar.dzw.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.duW, i2) != null) {
                        jVar.dzy.setText(ay.c(((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getmGroupName(), 8, "..."));
                        jVar.dzx.c(((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    jVar.dzz.setText(str);
                    jVar.dyF.setVisibility(0);
                    this.dva = new a(((MyGroup) com.baidu.tbadk.core.util.y.b(this.duW, i2)).getGroupId());
                    jVar.dzw.setOnClickListener(this.dva);
                    jVar.dzs.setPadding(jVar.dzs.getPaddingLeft(), jVar.dzs.getPaddingTop(), jVar.dzs.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds16));
                    jVar.dzw.setPadding(jVar.dzw.getPaddingLeft(), jVar.dzw.getPaddingTop(), jVar.dzw.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(t.e.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.b.j jVar, com.baidu.tieba.person.data.k kVar) {
        jVar.dyO.setVisibility(8);
        jVar.dyS.setVisibility(8);
        jVar.dyH.setVisibility(8);
        jVar.dzj.setVisibility(0);
        jVar.dzm.setVisibility(0);
        jVar.dzl.setText(t.j.set_private);
        this.duX = this.mContext.getResources().getString(t.j.my_groups);
        if (!this.isSelf && kVar.getSex() == 2) {
            this.duX = this.mContext.getResources().getString(t.j.her_groups);
        } else if (!this.isSelf && (kVar.getSex() == 1 || kVar.getSex() == 0)) {
            this.duX = this.mContext.getResources().getString(t.j.his_groups);
        }
        jVar.dzk.setText(this.duX);
        jVar.dzj.setOnClickListener(new s(this));
    }

    private void a(com.baidu.tieba.person.b.j jVar) {
        if (jVar != null && jVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(jVar.dzs, t.f.addresslist_item_bg);
            at.k(jVar.dzw, t.f.addresslist_item_bg);
            at.k(jVar.dzj, t.f.addresslist_item_bg);
            at.l(jVar.getView(), t.d.cp_bg_line_d);
            at.l(jVar.dyN, t.d.cp_bg_line_c);
            at.l(jVar.dyS, t.d.cp_bg_line_c);
            at.l(jVar.dyF, t.d.cp_bg_line_c);
            at.b(jVar.dyP, t.d.cp_cont_f, 1);
            at.b(jVar.dyR, t.d.cp_cont_c, 1);
            at.b(jVar.dzu, t.d.cp_cont_b, 1);
            at.b(jVar.dzv, t.d.cp_cont_d, 1);
            at.b(jVar.dzy, t.d.cp_cont_b, 1);
            at.b(jVar.dzz, t.d.cp_cont_d, 1);
            at.b(jVar.dzk, t.d.cp_cont_f, 1);
            at.b(jVar.dzl, t.d.cp_cont_d, 1);
            at.b(jVar.dzz, t.d.cp_cont_d, 1);
            at.c(jVar.dyQ, t.f.icon_arrow_tab);
            at.c(jVar.dzm, t.f.icon_mycenter_lock);
            jVar.aik = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && bl.ad(r.this.mContext)) {
                if (!r.this.isSelf) {
                    if (r.this.userId != null) {
                        if (view.getId() == t.g.group_head) {
                            TiebaStatic.log(new aw("c10620").r("obj_type", 1).ac("obj_id", r.this.userId));
                        } else if (view.getId() == t.g.group_none) {
                            TiebaStatic.log(new aw("c10620").r("obj_type", 3).ac("obj_id", r.this.userId));
                        }
                    }
                } else if (view.getId() == t.g.group_head) {
                    TiebaStatic.log(new aw("c10592").r("obj_type", 1));
                } else if (view.getId() == t.g.group_none) {
                    TiebaStatic.log(new aw("c10592").r("obj_type", 3));
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
            if (bl.ad(r.this.mContext)) {
                if (!r.this.isSelf) {
                    if (r.this.userId != null) {
                        TiebaStatic.log(new aw("c10620").r("obj_type", 2).ac("obj_id", r.this.userId));
                    }
                } else {
                    TiebaStatic.log(new aw("c10592").r("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(r.this.mContext, this.groupId, 0)));
            }
        }
    }
}
