package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.person.data.f, com.baidu.tieba.person.b.e> {
    private com.baidu.adp.widget.ListView.v cMm;
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
    /* renamed from: ak */
    public com.baidu.tieba.person.b.e a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.e(LayoutInflater.from(this.mContext).inflate(n.g.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.f fVar, com.baidu.tieba.person.b.e eVar) {
        a(eVar, view);
        if (fVar != null && this.aRB) {
            a(eVar, fVar);
            this.aRB = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.f fVar) {
        if (eVar != null && fVar != null) {
            this.isSelf = fVar.isSelf();
            this.userId = fVar.getUserId();
            if (this.isSelf) {
                c(eVar, fVar);
            } else if (fVar.aog() == 1 || (fVar.aog() == 2 && fVar.getIsFriend() == 1)) {
                c(eVar, fVar);
            } else {
                b(eVar, fVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            eVar.cOl.setVisibility(8);
            eVar.cOh.setVisibility(8);
            eVar.cOj.setVisibility(8);
            eVar.cOq.setVisibility(0);
            eVar.cOm.setVisibility(0);
            String string = this.mContext.getResources().getString(n.i.my_attention_bar);
            if (fVar.cNi) {
                eVar.cyG.setVisibility(0);
            } else {
                eVar.cyG.setVisibility(8);
            }
            if (!fVar.isSelf()) {
                if (fVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(n.i.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(n.i.his_attention_bar);
                }
            }
            eVar.cOn.setText(string);
            eVar.cOo.setText(n.i.set_private);
            eVar.cOm.setOnClickListener(new j(this));
        }
    }

    private void c(com.baidu.tieba.person.b.e eVar, com.baidu.tieba.person.data.f fVar) {
        if (fVar != null) {
            String string = this.mContext.getResources().getString(n.i.my_attention_bar);
            if (fVar.cNi) {
                eVar.cyG.setVisibility(0);
            } else {
                eVar.cyG.setVisibility(8);
            }
            if (!fVar.isSelf()) {
                if (fVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(n.i.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(n.i.his_attention_bar);
                }
            }
            eVar.cOg.setText(string);
            eVar.cOn.setText(string);
            if (com.baidu.tbadk.core.util.y.k(fVar.aof()) > 0) {
                eVar.cOk.setText(new StringBuilder(String.valueOf(fVar.getCount())).toString());
                if (com.baidu.tbadk.core.util.y.k(fVar.aof()) <= 3) {
                    eVar.cOp.setVisibility(8);
                } else {
                    eVar.cOp.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aof(), 0) != null) {
                    eVar.cOa.setText(kV(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 0)).getForumName()));
                    eVar.cOa.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aof(), 1) != null) {
                    eVar.cOb.setText(kV(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 1)).getForumName()));
                    eVar.cOb.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aof(), 2) != null) {
                    eVar.cOc.setText(kV(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 2)).getForumName()));
                    eVar.cOc.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aof(), 3) != null) {
                    eVar.cOd.setText(kV(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 3)).getForumName()));
                    eVar.cOd.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aof(), 4) != null) {
                    eVar.cOe.setText(kV(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 4)).getForumName()));
                    eVar.cOe.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar.aof(), 5) != null) {
                    eVar.cOf.setText(kV(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 5)).getForumName()));
                    eVar.cOf.setVisibility(0);
                }
                eVar.cOh.setOnClickListener(anX());
                eVar.cOa.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 0)));
                eVar.cOb.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 1)));
                eVar.cOc.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 2)));
                eVar.cOd.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 3)));
                eVar.cOe.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 4)));
                eVar.cOf.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar.aof(), 5)));
            } else {
                eVar.cOm.setVisibility(0);
                eVar.cOl.setVisibility(8);
                eVar.cOh.setVisibility(8);
            }
            eVar.cOm.setOnClickListener(anX());
        }
    }

    private void a(com.baidu.tieba.person.b.e eVar, View view) {
        if (eVar.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(eVar.cOl, n.c.cp_bg_line_d);
            as.i(eVar.cOm, n.e.addresslist_item_bg);
            as.i((View) eVar.cOa, n.e.home_like_item_bg);
            as.i((View) eVar.cOb, n.e.home_like_item_bg);
            as.i((View) eVar.cOc, n.e.home_like_item_bg);
            as.i((View) eVar.cOd, n.e.home_like_item_bg);
            as.i((View) eVar.cOe, n.e.home_like_item_bg);
            as.i((View) eVar.cOf, n.e.home_like_item_bg);
            as.b(eVar.cOa, n.c.cp_cont_f, 1);
            as.b(eVar.cOb, n.c.cp_cont_f, 1);
            as.b(eVar.cOc, n.c.cp_cont_f, 1);
            as.b(eVar.cOd, n.c.cp_cont_f, 1);
            as.b(eVar.cOe, n.c.cp_cont_f, 1);
            as.b(eVar.cOf, n.c.cp_cont_f, 1);
            as.j(eVar.cyG, n.c.cp_bg_line_c);
            as.j(view, n.c.cp_bg_line_d);
            as.j(eVar.cOi, n.c.cp_bg_line_c);
            as.j(eVar.cOj, n.c.cp_bg_line_c);
            as.b(eVar.cOg, n.c.cp_cont_f, 1);
            as.b(eVar.cOk, n.c.cp_cont_c, 1);
            as.c(eVar.cNR, n.e.icon_arrow_tab);
            as.b(eVar.cOn, n.c.cp_cont_f, 1);
            as.b(eVar.cOo, n.c.cp_cont_d, 1);
            as.c(eVar.cOq, n.e.icon_mycenter_lock);
            eVar.afY = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cMm = vVar;
    }

    public View.OnClickListener anX() {
        return new k(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new l(this, myLikeForum);
    }

    private String kV(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (ax.dx(str) >= 11) {
            return ax.i(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(n.i.bar);
    }
}
