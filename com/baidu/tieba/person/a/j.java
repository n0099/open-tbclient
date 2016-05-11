package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends c<com.baidu.tieba.person.data.g, com.baidu.tieba.person.b.h> {
    private com.baidu.adp.widget.ListView.w dxI;
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
    /* renamed from: aQ */
    public com.baidu.tieba.person.b.h b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.h(LayoutInflater.from(this.mContext).inflate(t.h.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.g gVar, com.baidu.tieba.person.b.h hVar) {
        a(hVar, view);
        if (gVar != null && this.bUL) {
            a(hVar, gVar);
            this.bUL = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.g gVar) {
        if (hVar != null && gVar != null) {
            this.isSelf = gVar.isSelf();
            this.userId = gVar.getUserId();
            if (this.isSelf) {
                c(hVar, gVar);
            } else if (gVar.aCg() == 1 || (gVar.aCg() == 2 && gVar.getIsFriend() == 1)) {
                c(hVar, gVar);
            } else {
                b(hVar, gVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null) {
            hVar.dBP.setVisibility(8);
            hVar.dBM.setVisibility(8);
            hVar.dBN.setVisibility(8);
            hVar.dBU.setVisibility(0);
            hVar.dBQ.setVisibility(0);
            String string = this.mContext.getResources().getString(t.j.my_attention_bar);
            if (gVar.dzf) {
                hVar.aOf.setVisibility(0);
            } else {
                hVar.aOf.setVisibility(8);
            }
            if (!gVar.isSelf()) {
                if (gVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(t.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(t.j.his_attention_bar);
                }
            }
            hVar.dBR.setText(string);
            hVar.dBS.setText(t.j.set_private);
            hVar.dBQ.setOnClickListener(new k(this));
        }
    }

    private void c(com.baidu.tieba.person.b.h hVar, com.baidu.tieba.person.data.g gVar) {
        if (gVar != null) {
            String string = this.mContext.getResources().getString(t.j.my_attention_bar);
            if (gVar.dzf) {
                hVar.aOf.setVisibility(0);
            } else {
                hVar.aOf.setVisibility(8);
            }
            if (!gVar.isSelf()) {
                if (gVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(t.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(t.j.his_attention_bar);
                }
            }
            hVar.dBP.setVisibility(0);
            hVar.dBM.setVisibility(0);
            hVar.dBN.setVisibility(0);
            hVar.dBU.setVisibility(8);
            hVar.dBQ.setVisibility(8);
            hVar.dBL.setText(string);
            hVar.dBR.setText(string);
            if (com.baidu.tbadk.core.util.y.r(gVar.aCf()) > 0) {
                hVar.dBO.setText(new StringBuilder(String.valueOf(gVar.getCount())).toString());
                if (com.baidu.tbadk.core.util.y.r(gVar.aCf()) <= 3) {
                    hVar.dBT.setVisibility(8);
                } else {
                    hVar.dBT.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aCf(), 0) != null) {
                    hVar.dBF.setText(ms(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 0)).getForumName()));
                    hVar.dBF.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aCf(), 1) != null) {
                    hVar.dBG.setText(ms(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 1)).getForumName()));
                    hVar.dBG.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aCf(), 2) != null) {
                    hVar.dBH.setText(ms(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 2)).getForumName()));
                    hVar.dBH.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aCf(), 3) != null) {
                    hVar.dBI.setText(ms(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 3)).getForumName()));
                    hVar.dBI.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aCf(), 4) != null) {
                    hVar.dBJ.setText(ms(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 4)).getForumName()));
                    hVar.dBJ.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(gVar.aCf(), 5) != null) {
                    hVar.dBK.setText(ms(((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 5)).getForumName()));
                    hVar.dBK.setVisibility(0);
                }
                hVar.dBM.setOnClickListener(aBV());
                hVar.dBF.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 0)));
                hVar.dBG.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 1)));
                hVar.dBH.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 2)));
                hVar.dBI.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 3)));
                hVar.dBJ.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 4)));
                hVar.dBK.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(gVar.aCf(), 5)));
            } else {
                hVar.dBQ.setVisibility(0);
                hVar.dBP.setVisibility(8);
                hVar.dBM.setVisibility(8);
            }
            hVar.dBQ.setOnClickListener(aBV());
        }
    }

    private void a(com.baidu.tieba.person.b.h hVar, View view) {
        if (hVar.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            com.baidu.tbadk.core.util.at.k(hVar.dBP, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.k(hVar.dBQ, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(hVar.dBF, t.f.home_like_item_bg);
            com.baidu.tbadk.core.util.at.k(hVar.dBG, t.f.home_like_item_bg);
            com.baidu.tbadk.core.util.at.k(hVar.dBH, t.f.home_like_item_bg);
            com.baidu.tbadk.core.util.at.k(hVar.dBI, t.f.home_like_item_bg);
            com.baidu.tbadk.core.util.at.k(hVar.dBJ, t.f.home_like_item_bg);
            com.baidu.tbadk.core.util.at.k(hVar.dBK, t.f.home_like_item_bg);
            com.baidu.tbadk.core.util.at.c(hVar.dBF, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBG, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBH, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBI, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBJ, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBK, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.l(hVar.aOf, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(view, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(hVar.dBN, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(hVar.dBL, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBO, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBq, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.c(hVar.dBR, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBS, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(hVar.dBU, t.f.icon_mycenter_lock);
            hVar.aej = TbadkCoreApplication.m11getInst().getSkinType();
        }
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.dxI = wVar;
    }

    public View.OnClickListener aBV() {
        return new l(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new m(this, myLikeForum);
    }

    private String ms(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (ay.dx(str) >= 11) {
            return ay.j(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(t.j.bar);
    }
}
