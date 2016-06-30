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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.l, com.baidu.tieba.person.b.k> {
    private View.OnClickListener aew;
    private List<MyGroup> ego;
    private String egp;
    private com.baidu.tbadk.data.j egq;
    private PersonTainInfo egr;
    private a egs;
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
    /* renamed from: bB */
    public com.baidu.tieba.person.b.k a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.k(LayoutInflater.from(this.mContext).inflate(u.h.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.k kVar) {
        a(kVar);
        if (lVar != null && this.aMF) {
            a(kVar, lVar);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        if (lVar != null && lVar.getUserData() != null && kVar != null) {
            this.egq = lVar.aLh();
            this.egr = lVar.aLg();
            this.aew = new b(lVar.getUserId(), lVar.getSex());
            this.userId = lVar.getUserId();
            this.isSelf = lVar.getIsSelf();
            int AM = this.egq != null ? this.egq.AM() : 1;
            int isFriend = this.egr != null ? this.egr.getIsFriend() : 1;
            if (lVar.ehJ) {
                kVar.eky.setVisibility(0);
            } else {
                kVar.eky.setVisibility(8);
            }
            if (this.isSelf) {
                b(kVar, lVar);
            } else if (AM == 1 || (AM == 2 && isFriend == 1)) {
                b(kVar, lVar);
            } else {
                c(kVar, lVar);
            }
            kVar.ekz.setOnClickListener(this.aew);
        }
    }

    private void b(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        String str;
        if (lVar != null && kVar != null) {
            this.ego = lVar.aLf();
            this.isSelf = lVar.getIsSelf();
            this.egp = this.mContext.getResources().getString(u.j.my_groups);
            String string = this.mContext.getResources().getString(u.j.members_in_group);
            int i = 0;
            if (!this.isSelf && lVar.getSex() == 2) {
                this.egp = this.mContext.getResources().getString(u.j.her_groups);
            } else if (!this.isSelf && (lVar.getSex() == 1 || lVar.getSex() == 0)) {
                this.egp = this.mContext.getResources().getString(u.j.his_groups);
            }
            if (com.baidu.tbadk.core.util.y.s(this.ego) == 0) {
                kVar.ekz.setVisibility(8);
                kVar.eks.setVisibility(8);
                kVar.ekU.setVisibility(0);
                kVar.ekV.setText(this.egp);
                kVar.eks.setPadding(0, 0, 0, 0);
                kVar.ekU.setOnClickListener(this.aew);
                return;
            }
            if (this.egr != null) {
                i = this.egr.getGroupNum();
            }
            kVar.ekA.setText(this.egp);
            kVar.ekz.setVisibility(0);
            kVar.ekU.setVisibility(8);
            kVar.eks.setVisibility(0);
            kVar.ekD.setVisibility(0);
            kVar.ekC.setText(ba.B(i));
            int s = com.baidu.tbadk.core.util.y.s(this.ego);
            int i2 = 0;
            String str2 = "";
            while (i2 < s && i2 < 2) {
                if (i2 == 0) {
                    kVar.eld.setVisibility(0);
                    kVar.ele.setVisibility(0);
                    kVar.elg.setVisibility(0);
                    kVar.elf.setVisibility(0);
                    kVar.elh.setVisibility(8);
                    if (com.baidu.tbadk.core.util.y.c(this.ego, i2) != null) {
                        kVar.elf.setText(ba.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getmGroupName(), 8, "..."));
                        kVar.ele.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    kVar.elg.setText(str);
                    kVar.ekq.setVisibility(8);
                    this.egs = new a(((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getGroupId());
                    kVar.eld.setOnClickListener(this.egs);
                    kVar.eld.setPadding(kVar.eld.getPaddingLeft(), kVar.eld.getPaddingTop(), kVar.eld.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds40));
                } else if (i2 == 1) {
                    kVar.elh.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.ego, i2) != null) {
                        kVar.elj.setText(ba.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getmGroupName(), 8, "..."));
                        kVar.eli.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    kVar.elk.setText(str);
                    kVar.ekq.setVisibility(0);
                    this.egs = new a(((MyGroup) com.baidu.tbadk.core.util.y.c(this.ego, i2)).getGroupId());
                    kVar.elh.setOnClickListener(this.egs);
                    kVar.eld.setPadding(kVar.eld.getPaddingLeft(), kVar.eld.getPaddingTop(), kVar.eld.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds16));
                    kVar.elh.setPadding(kVar.elh.getPaddingLeft(), kVar.elh.getPaddingTop(), kVar.elh.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        kVar.ekz.setVisibility(8);
        kVar.ekD.setVisibility(8);
        kVar.eks.setVisibility(8);
        kVar.ekU.setVisibility(0);
        kVar.ekX.setVisibility(0);
        kVar.ekW.setText(u.j.set_private);
        this.egp = this.mContext.getResources().getString(u.j.my_groups);
        if (!this.isSelf && lVar.getSex() == 2) {
            this.egp = this.mContext.getResources().getString(u.j.her_groups);
        } else if (!this.isSelf && (lVar.getSex() == 1 || lVar.getSex() == 0)) {
            this.egp = this.mContext.getResources().getString(u.j.his_groups);
        }
        kVar.ekV.setText(this.egp);
        kVar.ekU.setOnClickListener(new t(this));
    }

    private void a(com.baidu.tieba.person.b.k kVar) {
        if (kVar != null && kVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(kVar.eld, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(kVar.elh, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(kVar.ekU, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(kVar.getView(), u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(kVar.eky, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(kVar.ekD, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(kVar.ekq, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(kVar.ekA, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(kVar.ekC, u.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.av.c(kVar.elf, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(kVar.elg, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(kVar.elj, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(kVar.elk, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(kVar.ekV, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(kVar.ekW, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(kVar.elk, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(kVar.ekB, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.c(kVar.ekX, u.f.icon_mycenter_lock);
            kVar.aeK = TbadkCoreApplication.m9getInst().getSkinType();
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
            if (this.id != null && bn.ab(s.this.mContext)) {
                if (!s.this.isSelf) {
                    if (s.this.userId != null) {
                        if (view.getId() == u.g.group_head) {
                            TiebaStatic.log(new ay("c10620").s("obj_type", 1).ab("obj_id", s.this.userId));
                        } else if (view.getId() == u.g.group_none) {
                            TiebaStatic.log(new ay("c10620").s("obj_type", 3).ab("obj_id", s.this.userId));
                        }
                    }
                } else if (view.getId() == u.g.group_head) {
                    TiebaStatic.log(new ay("c10592").s("obj_type", 1));
                } else if (view.getId() == u.g.group_none) {
                    TiebaStatic.log(new ay("c10592").s("obj_type", 3));
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
            if (bn.ab(s.this.mContext)) {
                if (!s.this.isSelf) {
                    if (s.this.userId != null) {
                        TiebaStatic.log(new ay("c10620").s("obj_type", 2).ab("obj_id", s.this.userId));
                    }
                } else {
                    TiebaStatic.log(new ay("c10592").s("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(s.this.mContext, this.groupId, 0)));
            }
        }
    }
}
