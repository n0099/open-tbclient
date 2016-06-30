package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.g, com.baidu.tieba.person.b.h> {
    private com.baidu.adp.widget.ListView.w ege;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public com.baidu.tieba.person.b.h a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.h(LayoutInflater.from(this.mContext).inflate(u.h.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.g gVar, com.baidu.tieba.person.b.h hVar) {
        a(hVar, view);
        if (gVar != null && this.aMF) {
            a(hVar, gVar);
            this.aMF = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.g gVar) {
        if (hVar != null && gVar != null) {
            this.isSelf = gVar.isSelf();
            this.userId = gVar.getUserId();
            if (this.isSelf) {
                c(hVar, gVar);
            } else if (gVar.aLc() == 1 || (gVar.aLc() == 2 && gVar.getIsFriend() == 1)) {
                c(hVar, gVar);
            } else {
                b(hVar, gVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null) {
            hVar.eks.setVisibility(8);
            hVar.ekp.setVisibility(8);
            hVar.ekq.setVisibility(8);
            hVar.ekx.setVisibility(0);
            hVar.ekt.setVisibility(0);
            String string = this.mContext.getResources().getString(u.j.my_attention_bar);
            if (gVar.ehJ) {
                hVar.aRC.setVisibility(0);
            } else {
                hVar.aRC.setVisibility(8);
            }
            if (!gVar.isSelf()) {
                if (gVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(u.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(u.j.his_attention_bar);
                }
            }
            hVar.eku.setText(string);
            hVar.ekv.setText(u.j.set_private);
            hVar.ekt.setOnClickListener(new k(this));
        }
    }

    private void c(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null) {
            String string = this.mContext.getResources().getString(u.j.my_attention_bar);
            if (gVar.ehJ) {
                hVar.aRC.setVisibility(0);
            } else {
                hVar.aRC.setVisibility(8);
            }
            if (!gVar.isSelf()) {
                if (gVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(u.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(u.j.his_attention_bar);
                }
            }
            hVar.eks.setVisibility(0);
            hVar.ekp.setVisibility(0);
            hVar.ekq.setVisibility(0);
            hVar.ekx.setVisibility(8);
            hVar.ekt.setVisibility(8);
            hVar.eko.setText(string);
            hVar.eku.setText(string);
            if (com.baidu.tbadk.core.util.y.s(gVar.aLb()) > 0) {
                hVar.ekr.setText(new StringBuilder(String.valueOf(gVar.getCount())).toString());
                if (com.baidu.tbadk.core.util.y.s(gVar.aLb()) <= 3) {
                    hVar.ekw.setVisibility(8);
                } else {
                    hVar.ekw.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aLb(), 0) != null) {
                    hVar.eki.setText(nX(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 0)).getForumName()));
                    hVar.eki.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aLb(), 1) != null) {
                    hVar.ekj.setText(nX(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 1)).getForumName()));
                    hVar.ekj.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aLb(), 2) != null) {
                    hVar.ekk.setText(nX(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 2)).getForumName()));
                    hVar.ekk.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aLb(), 3) != null) {
                    hVar.ekl.setText(nX(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 3)).getForumName()));
                    hVar.ekl.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aLb(), 4) != null) {
                    hVar.ekm.setText(nX(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 4)).getForumName()));
                    hVar.ekm.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aLb(), 5) != null) {
                    hVar.ekn.setText(nX(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 5)).getForumName()));
                    hVar.ekn.setVisibility(0);
                }
                hVar.ekp.setOnClickListener(aKQ());
                hVar.eki.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 0)));
                hVar.ekj.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 1)));
                hVar.ekk.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 2)));
                hVar.ekl.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 3)));
                hVar.ekm.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 4)));
                hVar.ekn.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aLb(), 5)));
            } else {
                hVar.ekt.setVisibility(0);
                hVar.eks.setVisibility(8);
                hVar.ekp.setVisibility(8);
            }
            hVar.ekt.setOnClickListener(aKQ());
        }
    }

    private void a(com.baidu.tieba.person.b.h hVar, View view) {
        if (hVar.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            com.baidu.tbadk.core.util.av.k(hVar.eks, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.k(hVar.ekt, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(hVar.eki, u.f.home_like_item_bg);
            com.baidu.tbadk.core.util.av.k(hVar.ekj, u.f.home_like_item_bg);
            com.baidu.tbadk.core.util.av.k(hVar.ekk, u.f.home_like_item_bg);
            com.baidu.tbadk.core.util.av.k(hVar.ekl, u.f.home_like_item_bg);
            com.baidu.tbadk.core.util.av.k(hVar.ekm, u.f.home_like_item_bg);
            com.baidu.tbadk.core.util.av.k(hVar.ekn, u.f.home_like_item_bg);
            com.baidu.tbadk.core.util.av.c(hVar.eki, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekj, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekk, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekl, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekm, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekn, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.l(hVar.aRC, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(view, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(hVar.ekq, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(hVar.eko, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekr, u.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ejT, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.c(hVar.eku, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekv, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(hVar.ekx, u.f.icon_mycenter_lock);
            hVar.aeK = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.ege = wVar;
    }

    public View.OnClickListener aKQ() {
        return new l(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new m(this, myLikeForum);
    }

    private String nX(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (ba.dA(str) >= 11) {
            return ba.j(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(u.j.bar);
    }
}
