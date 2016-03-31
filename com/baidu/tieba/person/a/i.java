package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.person.data.f, com.baidu.tieba.person.b.g> {
    private com.baidu.adp.widget.ListView.v duM;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public com.baidu.tieba.person.b.g b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.g(LayoutInflater.from(this.mContext).inflate(t.h.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.f fVar, com.baidu.tieba.person.b.g gVar) {
        a(gVar, view);
        if (fVar != null && this.bcn) {
            a(gVar, fVar);
            this.bcn = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.f fVar) {
        if (gVar != null && fVar != null) {
            this.isSelf = fVar.isSelf();
            this.userId = fVar.getUserId();
            if (this.isSelf) {
                c(gVar, fVar);
            } else if (fVar.aBO() == 1 || (fVar.aBO() == 2 && fVar.getIsFriend() == 1)) {
                c(gVar, fVar);
            } else {
                b(gVar, fVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            gVar.dyH.setVisibility(8);
            gVar.dyE.setVisibility(8);
            gVar.dyF.setVisibility(8);
            gVar.dyM.setVisibility(0);
            gVar.dyI.setVisibility(0);
            String string = this.mContext.getResources().getString(t.j.my_attention_bar);
            if (fVar.dwd) {
                gVar.aRI.setVisibility(0);
            } else {
                gVar.aRI.setVisibility(8);
            }
            if (!fVar.isSelf()) {
                if (fVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(t.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(t.j.his_attention_bar);
                }
            }
            gVar.dyJ.setText(string);
            gVar.dyK.setText(t.j.set_private);
            gVar.dyI.setOnClickListener(new j(this));
        }
    }

    private void c(com.baidu.tieba.person.b.g gVar, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            String string = this.mContext.getResources().getString(t.j.my_attention_bar);
            if (fVar.dwd) {
                gVar.aRI.setVisibility(0);
            } else {
                gVar.aRI.setVisibility(8);
            }
            if (!fVar.isSelf()) {
                if (fVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(t.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(t.j.his_attention_bar);
                }
            }
            gVar.dyH.setVisibility(0);
            gVar.dyE.setVisibility(0);
            gVar.dyF.setVisibility(0);
            gVar.dyM.setVisibility(8);
            gVar.dyI.setVisibility(8);
            gVar.dyD.setText(string);
            gVar.dyJ.setText(string);
            if (com.baidu.tbadk.core.util.y.p(fVar.aBN()) > 0) {
                gVar.dyG.setText(new StringBuilder(String.valueOf(fVar.getCount())).toString());
                if (com.baidu.tbadk.core.util.y.p(fVar.aBN()) <= 3) {
                    gVar.dyL.setVisibility(8);
                } else {
                    gVar.dyL.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aBN(), 0) != null) {
                    gVar.dyx.setText(mo(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 0)).getForumName()));
                    gVar.dyx.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aBN(), 1) != null) {
                    gVar.dyy.setText(mo(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 1)).getForumName()));
                    gVar.dyy.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aBN(), 2) != null) {
                    gVar.dyz.setText(mo(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 2)).getForumName()));
                    gVar.dyz.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aBN(), 3) != null) {
                    gVar.dyA.setText(mo(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 3)).getForumName()));
                    gVar.dyA.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aBN(), 4) != null) {
                    gVar.dyB.setText(mo(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 4)).getForumName()));
                    gVar.dyB.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aBN(), 5) != null) {
                    gVar.dyC.setText(mo(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 5)).getForumName()));
                    gVar.dyC.setVisibility(0);
                }
                gVar.dyE.setOnClickListener(aBF());
                gVar.dyx.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 0)));
                gVar.dyy.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 1)));
                gVar.dyz.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 2)));
                gVar.dyA.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 3)));
                gVar.dyB.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 4)));
                gVar.dyC.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aBN(), 5)));
            } else {
                gVar.dyI.setVisibility(0);
                gVar.dyH.setVisibility(8);
                gVar.dyE.setVisibility(8);
            }
            gVar.dyI.setOnClickListener(aBF());
        }
    }

    private void a(com.baidu.tieba.person.b.g gVar, View view) {
        if (gVar.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            at.k(gVar.dyH, t.d.cp_bg_line_d);
            at.k(gVar.dyI, t.f.addresslist_item_bg);
            at.k(gVar.dyx, t.f.home_like_item_bg);
            at.k(gVar.dyy, t.f.home_like_item_bg);
            at.k(gVar.dyz, t.f.home_like_item_bg);
            at.k(gVar.dyA, t.f.home_like_item_bg);
            at.k(gVar.dyB, t.f.home_like_item_bg);
            at.k(gVar.dyC, t.f.home_like_item_bg);
            at.b(gVar.dyx, t.d.cp_cont_f, 1);
            at.b(gVar.dyy, t.d.cp_cont_f, 1);
            at.b(gVar.dyz, t.d.cp_cont_f, 1);
            at.b(gVar.dyA, t.d.cp_cont_f, 1);
            at.b(gVar.dyB, t.d.cp_cont_f, 1);
            at.b(gVar.dyC, t.d.cp_cont_f, 1);
            at.l(gVar.aRI, t.d.cp_bg_line_c);
            at.l(view, t.d.cp_bg_line_d);
            at.l(gVar.dyF, t.d.cp_bg_line_c);
            at.b(gVar.dyD, t.d.cp_cont_f, 1);
            at.b(gVar.dyG, t.d.cp_cont_c, 1);
            at.c(gVar.dyi, t.f.icon_arrow_tab);
            at.b(gVar.dyJ, t.d.cp_cont_f, 1);
            at.b(gVar.dyK, t.d.cp_cont_d, 1);
            at.c(gVar.dyM, t.f.icon_mycenter_lock);
            gVar.aik = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.duM = vVar;
    }

    public View.OnClickListener aBF() {
        return new k(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new l(this, myLikeForum);
    }

    private String mo(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (ay.dA(str) >= 11) {
            return ay.j(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(t.j.bar);
    }
}
