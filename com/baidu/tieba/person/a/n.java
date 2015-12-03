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
public class n extends c<com.baidu.tieba.person.data.h, com.baidu.tieba.person.b.g> {
    private List<MyGroup> cMt;
    private String cMu;
    private com.baidu.tbadk.data.f cMv;
    private PersonTainInfo cMw;
    private a cMx;
    private boolean isSelf;
    private View.OnClickListener mClickListener;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public com.baidu.tieba.person.b.g a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.g(LayoutInflater.from(this.mContext).inflate(n.g.person_info_group_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.h hVar, com.baidu.tieba.person.b.g gVar) {
        a(gVar);
        if (hVar != null && this.aRB) {
            a(gVar, hVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.h hVar) {
        if (hVar != null && hVar.getUserData() != null && gVar != null) {
            this.cMv = hVar.aok();
            this.cMw = hVar.aoj();
            this.mClickListener = new b(hVar.getUserId(), hVar.getSex());
            this.userId = hVar.getUserId();
            this.isSelf = hVar.getIsSelf();
            int AX = this.cMv != null ? this.cMv.AX() : 1;
            int isFriend = this.cMw != null ? this.cMw.getIsFriend() : 1;
            if (hVar.cNi) {
                gVar.cOr.setVisibility(0);
            } else {
                gVar.cOr.setVisibility(8);
            }
            if (this.isSelf) {
                b(gVar, hVar);
            } else if (AX == 1 || (AX == 2 && isFriend == 1)) {
                b(gVar, hVar);
            } else {
                c(gVar, hVar);
            }
            gVar.cOs.setOnClickListener(this.mClickListener);
        }
    }

    private void b(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.h hVar) {
        String str;
        if (hVar != null && gVar != null) {
            this.cMt = hVar.aoi();
            this.isSelf = hVar.getIsSelf();
            this.cMu = this.mContext.getResources().getString(n.i.my_groups);
            String string = this.mContext.getResources().getString(n.i.members_in_group);
            int i = 0;
            if (!this.isSelf && hVar.getSex() == 2) {
                this.cMu = this.mContext.getResources().getString(n.i.her_groups);
            } else if (!this.isSelf && (hVar.getSex() == 1 || hVar.getSex() == 0)) {
                this.cMu = this.mContext.getResources().getString(n.i.his_groups);
            }
            if (com.baidu.tbadk.core.util.y.k(this.cMt) == 0) {
                gVar.cOs.setVisibility(8);
                gVar.cOl.setVisibility(8);
                gVar.cOM.setVisibility(0);
                gVar.cON.setText(this.cMu);
                gVar.cOl.setPadding(0, 0, 0, 0);
                gVar.cOM.setOnClickListener(this.mClickListener);
                return;
            }
            if (this.cMw != null) {
                i = this.cMw.getGroupNum();
            }
            gVar.cOt.setText(this.cMu);
            gVar.cOs.setVisibility(0);
            gVar.cOM.setVisibility(8);
            gVar.cOl.setVisibility(0);
            gVar.cOi.setVisibility(0);
            gVar.cOv.setText(ax.v(i));
            int k = com.baidu.tbadk.core.util.y.k(this.cMt);
            int i2 = 0;
            String str2 = "";
            while (i2 < k && i2 < 2) {
                if (i2 == 0) {
                    gVar.cOR.setVisibility(0);
                    gVar.cOS.setVisibility(0);
                    gVar.cOU.setVisibility(0);
                    gVar.cOT.setVisibility(0);
                    gVar.cOV.setVisibility(8);
                    if (com.baidu.tbadk.core.util.y.b(this.cMt, i2) != null) {
                        gVar.cOT.setText(ax.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getmGroupName(), 8, "..."));
                        gVar.cOS.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    gVar.cOU.setText(str);
                    gVar.cOj.setVisibility(8);
                    this.cMx = new a(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getGroupId());
                    gVar.cOR.setOnClickListener(this.cMx);
                    gVar.cOR.setPadding(gVar.cOR.getPaddingLeft(), gVar.cOR.getPaddingTop(), gVar.cOR.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.d.ds40));
                } else if (i2 == 1) {
                    gVar.cOV.setVisibility(0);
                    if (com.baidu.tbadk.core.util.y.b(this.cMt, i2) != null) {
                        gVar.cOX.setText(ax.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getmGroupName(), 8, "..."));
                        gVar.cOW.d(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getGroupPortrait(), 10, false);
                        str = String.format(string, ((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getmGroupMemberNum());
                    } else {
                        str = str2;
                    }
                    gVar.cOY.setText(str);
                    gVar.cOj.setVisibility(0);
                    this.cMx = new a(((MyGroup) com.baidu.tbadk.core.util.y.b(this.cMt, i2)).getGroupId());
                    gVar.cOV.setOnClickListener(this.cMx);
                    gVar.cOR.setPadding(gVar.cOR.getPaddingLeft(), gVar.cOR.getPaddingTop(), gVar.cOR.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.d.ds16));
                    gVar.cOV.setPadding(gVar.cOV.getPaddingLeft(), gVar.cOV.getPaddingTop(), gVar.cOV.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(n.d.ds40));
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
        }
    }

    private void c(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.h hVar) {
        gVar.cOs.setVisibility(8);
        gVar.cOi.setVisibility(8);
        gVar.cOl.setVisibility(8);
        gVar.cOM.setVisibility(0);
        gVar.cOP.setVisibility(0);
        gVar.cOO.setText(n.i.set_private);
        this.cMu = this.mContext.getResources().getString(n.i.my_groups);
        if (!this.isSelf && hVar.getSex() == 2) {
            this.cMu = this.mContext.getResources().getString(n.i.her_groups);
        } else if (!this.isSelf && (hVar.getSex() == 1 || hVar.getSex() == 0)) {
            this.cMu = this.mContext.getResources().getString(n.i.his_groups);
        }
        gVar.cON.setText(this.cMu);
        gVar.cOM.setOnClickListener(new o(this));
    }

    private void a(com.baidu.tieba.person.b.g gVar) {
        if (gVar != null && gVar.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(gVar.cOR, n.e.addresslist_item_bg);
            as.i(gVar.cOV, n.e.addresslist_item_bg);
            as.i(gVar.cOM, n.e.addresslist_item_bg);
            as.j(gVar.getView(), n.c.cp_bg_line_d);
            as.j(gVar.cOr, n.c.cp_bg_line_c);
            as.j(gVar.cOi, n.c.cp_bg_line_c);
            as.j(gVar.cOj, n.c.cp_bg_line_c);
            as.b(gVar.cOt, n.c.cp_cont_f, 1);
            as.b(gVar.cOv, n.c.cp_cont_c, 1);
            as.b(gVar.cOT, n.c.cp_cont_b, 1);
            as.b(gVar.cOU, n.c.cp_cont_d, 1);
            as.b(gVar.cOX, n.c.cp_cont_b, 1);
            as.b(gVar.cOY, n.c.cp_cont_d, 1);
            as.b(gVar.cON, n.c.cp_cont_f, 1);
            as.b(gVar.cOO, n.c.cp_cont_d, 1);
            as.b(gVar.cOY, n.c.cp_cont_d, 1);
            as.c(gVar.cOu, n.e.icon_arrow_tab);
            as.c(gVar.cOP, n.e.icon_mycenter_lock);
            gVar.afY = TbadkCoreApplication.m411getInst().getSkinType();
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
            if (this.id != null && bj.ah(n.this.mContext)) {
                if (!n.this.isSelf) {
                    if (n.this.userId != null) {
                        if (view.getId() == n.f.group_head) {
                            TiebaStatic.log(new av("c10620").r("obj_type", 1).ab("obj_id", n.this.userId));
                        } else if (view.getId() == n.f.group_none) {
                            TiebaStatic.log(new av("c10620").r("obj_type", 3).ab("obj_id", n.this.userId));
                        }
                    }
                } else if (view.getId() == n.f.group_head) {
                    TiebaStatic.log(new av("c10592").r("obj_type", 1));
                } else if (view.getId() == n.f.group_none) {
                    TiebaStatic.log(new av("c10592").r("obj_type", 3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(n.this.mContext, this.id, this.sex)));
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
            if (bj.ah(n.this.mContext)) {
                if (!n.this.isSelf) {
                    if (n.this.userId != null) {
                        TiebaStatic.log(new av("c10620").r("obj_type", 2).ab("obj_id", n.this.userId));
                    }
                } else {
                    TiebaStatic.log(new av("c10592").r("obj_type", 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(n.this.mContext, this.groupId, 0)));
            }
        }
    }
}
