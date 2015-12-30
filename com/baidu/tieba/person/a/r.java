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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.data.MyGroup;
import com.baidu.tieba.n;
import com.baidu.tieba.personInfo.PersonTainInfo;
import java.util.List;
/* loaded from: classes.dex */
public class r extends c<com.baidu.tieba.person.data.j, com.baidu.tieba.person.b.i> {
    private List<MyGroup> cQN;
    private String cQO;
    private com.baidu.tbadk.data.f cQP;
    private PersonTainInfo cQQ;
    private a cQR;
    private boolean isSelf;
    private View.OnClickListener mClickListener;
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
    /* renamed from: al */
    public com.baidu.tieba.person.b.i a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.i(LayoutInflater.from(this.mContext).inflate(n.h.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.j jVar, com.baidu.tieba.person.b.i iVar) {
        a(iVar);
        if (jVar != null && this.aVr) {
            a(iVar, jVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.j jVar) {
        if (jVar != null && jVar.getUserData() != null && iVar != null) {
            this.cQP = jVar.apu();
            this.cQQ = jVar.apt();
            this.mClickListener = new b(jVar.getUserId(), jVar.getSex());
            this.userId = jVar.getUserId();
            this.isSelf = jVar.getIsSelf();
            int AN = this.cQP != null ? this.cQP.AN() : 1;
            int isFriend = this.cQQ != null ? this.cQQ.getIsFriend() : 1;
            if (jVar.cRM) {
                iVar.cTb.setVisibility(0);
            } else {
                iVar.cTb.setVisibility(8);
            }
            if (this.isSelf) {
                b(iVar, jVar);
            } else if (AN == 1 || (AN == 2 && isFriend == 1)) {
                b(iVar, jVar);
            } else {
                c(iVar, jVar);
            }
            iVar.cTc.setOnClickListener(this.mClickListener);
        }
    }

    private void b(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.j jVar) {
        String str;
        if (jVar != null && iVar != null) {
            this.cQN = jVar.aps();
            this.isSelf = jVar.getIsSelf();
            this.cQO = this.mContext.getResources().getString(n.j.my_groups);
            String string = this.mContext.getResources().getString(n.j.members_in_group);
            int i = 0;
            if (!this.isSelf && jVar.getSex() == 2) {
                this.cQO = this.mContext.getResources().getString(n.j.her_groups);
            } else if (!this.isSelf && (jVar.getSex() == 1 || jVar.getSex() == 0)) {
                this.cQO = this.mContext.getResources().getString(n.j.his_groups);
            }
            if (com.baidu.tbadk.core.util.y.l(this.cQN) == 0) {
                iVar.cTc.setVisibility(8);
                iVar.cSU.setVisibility(8);
                iVar.cTw.setVisibility(0);
                iVar.cTx.setText(this.cQO);
                iVar.cSU.setPadding(0, 0, 0, 0);
                iVar.cTw.setOnClickListener(this.mClickListener);
                return;
            }
            if (this.cQQ != null) {
                i = this.cQQ.getGroupNum();
            }
            iVar.cTd.setText(this.cQO);
            iVar.cTc.setVisibility(0);
            iVar.cTw.setVisibility(8);
            iVar.cSU.setVisibility(0);
            iVar.cSR.setVisibility(0);
            iVar.cTf.setText(ax.w(i));
            int l = com.baidu.tbadk.core.util.y.l(this.cQN);
            int i2 = 0;
            String str2 = "";
            while (i2 < l && i2 < 2) {
                if (i2 == 0) {
                    iVar.cTB.setVisibility(0);
                    iVar.cTC.setVisibility(0);
                    iVar.cTE.setVisibility(0);
                    iVar.cTD.setVisibility(0);
                    iVar.cTF.setVisibility(8);
                    if (com.baidu.tbadk.core.util.y.b(this.cQN, i2) != null) {
                        iVar.cTD.setText(ax.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getmGroupName(), 8, "..."));
                        iVar.cTC.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    iVar.cTE.setText(str);
                    iVar.cSS.setVisibility(8);
                    this.cQR = new a(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getGroupId());
                    iVar.cTB.setOnClickListener(this.cQR);
                    iVar.cTB.setPadding(iVar.cTB.getPaddingLeft(), iVar.cTB.getPaddingTop(), iVar.cTB.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.e.ds40));
                } else if (i2 == 1) {
                    iVar.cTF.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cQN, i2) != null) {
                        iVar.cTH.setText(ax.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getmGroupName(), 8, "..."));
                        iVar.cTG.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    iVar.cTI.setText(str);
                    iVar.cSS.setVisibility(0);
                    this.cQR = new a(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cQN, i2)).getGroupId());
                    iVar.cTF.setOnClickListener(this.cQR);
                    iVar.cTB.setPadding(iVar.cTB.getPaddingLeft(), iVar.cTB.getPaddingTop(), iVar.cTB.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.e.ds16));
                    iVar.cTF.setPadding(iVar.cTF.getPaddingLeft(), iVar.cTF.getPaddingTop(), iVar.cTF.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.e.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.b.i iVar, com.baidu.tieba.person.data.j jVar) {
        iVar.cTc.setVisibility(8);
        iVar.cSR.setVisibility(8);
        iVar.cSU.setVisibility(8);
        iVar.cTw.setVisibility(0);
        iVar.cTz.setVisibility(0);
        iVar.cTy.setText(n.j.set_private);
        this.cQO = this.mContext.getResources().getString(n.j.my_groups);
        if (!this.isSelf && jVar.getSex() == 2) {
            this.cQO = this.mContext.getResources().getString(n.j.her_groups);
        } else if (!this.isSelf && (jVar.getSex() == 1 || jVar.getSex() == 0)) {
            this.cQO = this.mContext.getResources().getString(n.j.his_groups);
        }
        iVar.cTx.setText(this.cQO);
        iVar.cTw.setOnClickListener(new s(this));
    }

    private void a(com.baidu.tieba.person.b.i iVar) {
        if (iVar != null && iVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(iVar.cTB, n.f.addresslist_item_bg);
            as.i(iVar.cTF, n.f.addresslist_item_bg);
            as.i(iVar.cTw, n.f.addresslist_item_bg);
            as.j(iVar.getView(), n.d.cp_bg_line_d);
            as.j(iVar.cTb, n.d.cp_bg_line_c);
            as.j(iVar.cSR, n.d.cp_bg_line_c);
            as.j(iVar.cSS, n.d.cp_bg_line_c);
            as.b(iVar.cTd, n.d.cp_cont_f, 1);
            as.b(iVar.cTf, n.d.cp_cont_c, 1);
            as.b(iVar.cTD, n.d.cp_cont_b, 1);
            as.b(iVar.cTE, n.d.cp_cont_d, 1);
            as.b(iVar.cTH, n.d.cp_cont_b, 1);
            as.b(iVar.cTI, n.d.cp_cont_d, 1);
            as.b(iVar.cTx, n.d.cp_cont_f, 1);
            as.b(iVar.cTy, n.d.cp_cont_d, 1);
            as.b(iVar.cTI, n.d.cp_cont_d, 1);
            as.c(iVar.cTe, n.f.icon_arrow_tab);
            as.c(iVar.cTz, n.f.icon_mycenter_lock);
            iVar.ahf = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && bj.ah(r.this.mContext)) {
                if (!r.this.isSelf) {
                    if (r.this.userId != null) {
                        if (view.getId() == n.g.group_head) {
                            TiebaStatic.log(new av("c10620").r("obj_type", 1).aa("obj_id", r.this.userId));
                        } else if (view.getId() == n.g.group_none) {
                            TiebaStatic.log(new av("c10620").r("obj_type", 3).aa("obj_id", r.this.userId));
                        }
                    }
                } else if (view.getId() == n.g.group_head) {
                    TiebaStatic.log(new av("c10592").r("obj_type", 1));
                } else if (view.getId() == n.g.group_none) {
                    TiebaStatic.log(new av("c10592").r("obj_type", 3));
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
            if (bj.ah(r.this.mContext)) {
                if (!r.this.isSelf) {
                    if (r.this.userId != null) {
                        TiebaStatic.log(new av("c10620").r("obj_type", 2).aa("obj_id", r.this.userId));
                    }
                } else {
                    TiebaStatic.log(new av("c10592").r("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(r.this.mContext, this.groupId, 0)));
            }
        }
    }
}
