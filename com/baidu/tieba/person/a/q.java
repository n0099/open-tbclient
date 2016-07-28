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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.k, com.baidu.tieba.person.holder.k> {
    private View.OnClickListener afk;
    private List<MyGroup> eqn;
    private String eqo;
    private com.baidu.tbadk.data.j eqp;
    private PersonTainInfo eqq;
    private a eqr;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bJ */
    public com.baidu.tieba.person.holder.k a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.k(LayoutInflater.from(this.mContext).inflate(u.h.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.k kVar, com.baidu.tieba.person.holder.k kVar2) {
        a(kVar2);
        if (kVar != null && this.aNz) {
            a(kVar2, kVar);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.k kVar, com.baidu.tieba.person.data.k kVar2) {
        if (kVar2 != null && kVar2.getUserData() != null && kVar != null) {
            this.eqp = kVar2.aNK();
            this.eqq = kVar2.aNJ();
            this.afk = new b(kVar2.getUserId(), kVar2.getSex());
            this.userId = kVar2.getUserId();
            this.isSelf = kVar2.getIsSelf();
            int AM = this.eqp != null ? this.eqp.AM() : 1;
            int isFriend = this.eqq != null ? this.eqq.getIsFriend() : 1;
            if (kVar2.erI) {
                kVar.euV.setVisibility(0);
            } else {
                kVar.euV.setVisibility(8);
            }
            if (this.isSelf) {
                b(kVar, kVar2);
            } else if (AM == 1 || (AM == 2 && isFriend == 1)) {
                b(kVar, kVar2);
            } else {
                c(kVar, kVar2);
            }
            kVar.euW.setOnClickListener(this.afk);
        }
    }

    private void b(com.baidu.tieba.person.holder.k kVar, com.baidu.tieba.person.data.k kVar2) {
        String str;
        if (kVar2 != null && kVar != null) {
            this.eqn = kVar2.aNI();
            this.isSelf = kVar2.getIsSelf();
            this.eqo = this.mContext.getResources().getString(u.j.my_groups);
            String string = this.mContext.getResources().getString(u.j.members_in_group);
            int i = 0;
            if (!this.isSelf && kVar2.getSex() == 2) {
                this.eqo = this.mContext.getResources().getString(u.j.her_groups);
            } else if (!this.isSelf && (kVar2.getSex() == 1 || kVar2.getSex() == 0)) {
                this.eqo = this.mContext.getResources().getString(u.j.his_groups);
            }
            if (com.baidu.tbadk.core.util.y.s(this.eqn) == 0) {
                kVar.euW.setVisibility(8);
                kVar.euP.setVisibility(8);
                kVar.evr.setVisibility(0);
                kVar.evs.setText(this.eqo);
                kVar.euP.setPadding(0, 0, 0, 0);
                kVar.evr.setOnClickListener(this.afk);
                return;
            }
            if (this.eqq != null) {
                i = this.eqq.getGroupNum();
            }
            kVar.euX.setText(this.eqo);
            kVar.euW.setVisibility(0);
            kVar.evr.setVisibility(8);
            kVar.euP.setVisibility(0);
            kVar.eva.setVisibility(0);
            kVar.euZ.setText(ba.w(i));
            int s = com.baidu.tbadk.core.util.y.s(this.eqn);
            int i2 = 0;
            String str2 = "";
            while (i2 < s && i2 < 2) {
                if (i2 == 0) {
                    kVar.evA.setVisibility(0);
                    kVar.evB.setVisibility(0);
                    kVar.evD.setVisibility(0);
                    kVar.evC.setVisibility(0);
                    kVar.evE.setVisibility(8);
                    if (com.baidu.tbadk.core.util.y.c(this.eqn, i2) != null) {
                        kVar.evC.setText(ba.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getmGroupName(), 8, "..."));
                        kVar.evB.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    kVar.evD.setText(str);
                    kVar.euN.setVisibility(8);
                    this.eqr = new a(((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getGroupId());
                    kVar.evA.setOnClickListener(this.eqr);
                    kVar.evA.setPadding(kVar.evA.getPaddingLeft(), kVar.evA.getPaddingTop(), kVar.evA.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds40));
                } else if (i2 == 1) {
                    kVar.evE.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.c(this.eqn, i2) != null) {
                        kVar.evG.setText(ba.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getmGroupName(), 8, "..."));
                        kVar.evF.c(((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    kVar.evH.setText(str);
                    kVar.euN.setVisibility(0);
                    this.eqr = new a(((MyGroup) com.baidu.tbadk.core.util.y.c(this.eqn, i2)).getGroupId());
                    kVar.evE.setOnClickListener(this.eqr);
                    kVar.evA.setPadding(kVar.evA.getPaddingLeft(), kVar.evA.getPaddingTop(), kVar.evA.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds16));
                    kVar.evE.setPadding(kVar.evE.getPaddingLeft(), kVar.evE.getPaddingTop(), kVar.evE.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(u.e.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.holder.k kVar, com.baidu.tieba.person.data.k kVar2) {
        kVar.euW.setVisibility(8);
        kVar.eva.setVisibility(8);
        kVar.euP.setVisibility(8);
        kVar.evr.setVisibility(0);
        kVar.evu.setVisibility(0);
        kVar.evt.setText(u.j.set_private);
        this.eqo = this.mContext.getResources().getString(u.j.my_groups);
        if (!this.isSelf && kVar2.getSex() == 2) {
            this.eqo = this.mContext.getResources().getString(u.j.her_groups);
        } else if (!this.isSelf && (kVar2.getSex() == 1 || kVar2.getSex() == 0)) {
            this.eqo = this.mContext.getResources().getString(u.j.his_groups);
        }
        kVar.evs.setText(this.eqo);
        kVar.evr.setOnClickListener(new r(this));
    }

    private void a(com.baidu.tieba.person.holder.k kVar) {
        if (kVar != null && kVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(kVar.evA, u.f.addresslist_item_bg);
            av.k(kVar.evE, u.f.addresslist_item_bg);
            av.k(kVar.evr, u.f.addresslist_item_bg);
            av.l(kVar.getView(), u.d.cp_bg_line_d);
            av.l(kVar.euV, u.d.cp_bg_line_c);
            av.l(kVar.eva, u.d.cp_bg_line_c);
            av.l(kVar.euN, u.d.cp_bg_line_c);
            av.c(kVar.euX, u.d.cp_cont_f, 1);
            av.c(kVar.euZ, u.d.cp_cont_c, 1);
            av.c(kVar.evC, u.d.cp_cont_b, 1);
            av.c(kVar.evD, u.d.cp_cont_d, 1);
            av.c(kVar.evG, u.d.cp_cont_b, 1);
            av.c(kVar.evH, u.d.cp_cont_d, 1);
            av.c(kVar.evs, u.d.cp_cont_f, 1);
            av.c(kVar.evt, u.d.cp_cont_d, 1);
            av.c(kVar.evH, u.d.cp_cont_d, 1);
            av.c(kVar.euY, u.f.icon_arrow_tab);
            av.c(kVar.evu, u.f.icon_mycenter_lock);
            kVar.afy = TbadkCoreApplication.m10getInst().getSkinType();
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
            if (this.id != null && bn.ab(q.this.mContext)) {
                if (!q.this.isSelf) {
                    if (q.this.userId != null) {
                        if (view.getId() == u.g.group_head) {
                            TiebaStatic.log(new ay("c10620").s("obj_type", 1).ab("obj_id", q.this.userId));
                        } else if (view.getId() == u.g.group_none) {
                            TiebaStatic.log(new ay("c10620").s("obj_type", 3).ab("obj_id", q.this.userId));
                        }
                    }
                } else if (view.getId() == u.g.group_head) {
                    TiebaStatic.log(new ay("c10592").s("obj_type", 1));
                } else if (view.getId() == u.g.group_none) {
                    TiebaStatic.log(new ay("c10592").s("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(q.this.mContext, this.id, this.sex)));
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
            if (bn.ab(q.this.mContext)) {
                if (!q.this.isSelf) {
                    if (q.this.userId != null) {
                        TiebaStatic.log(new ay("c10620").s("obj_type", 2).ab("obj_id", q.this.userId));
                    }
                } else {
                    TiebaStatic.log(new ay("c10592").s("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(q.this.mContext, this.groupId, 0)));
            }
        }
    }
}
