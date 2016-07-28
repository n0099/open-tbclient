package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.MyLikeForum;
import com.baidu.tieba.person.data.h;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.a.a<h, com.baidu.tieba.person.holder.i> {
    private com.baidu.adp.widget.ListView.w eqf;
    private boolean isSelf;
    private String userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.isSelf = true;
        this.userId = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public com.baidu.tieba.person.holder.i a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.i(LayoutInflater.from(this.mContext).inflate(u.h.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, com.baidu.tieba.person.holder.i iVar) {
        a(iVar, view);
        if (hVar != null && this.aNz) {
            a(iVar, hVar);
            this.aNz = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.i iVar, h hVar) {
        if (iVar != null && hVar != null) {
            this.isSelf = hVar.isSelf();
            this.userId = hVar.getUserId();
            if (this.isSelf) {
                c(iVar, hVar);
            } else if (hVar.aNF() == 1 || (hVar.aNF() == 2 && hVar.getIsFriend() == 1)) {
                c(iVar, hVar);
            } else {
                b(iVar, hVar);
            }
        }
    }

    private void b(com.baidu.tieba.person.holder.i iVar, h hVar) {
        if (hVar != null) {
            iVar.euP.setVisibility(8);
            iVar.euM.setVisibility(8);
            iVar.euN.setVisibility(8);
            iVar.euU.setVisibility(0);
            iVar.euQ.setVisibility(0);
            String string = this.mContext.getResources().getString(u.j.my_attention_bar);
            if (hVar.erI) {
                iVar.aSw.setVisibility(0);
            } else {
                iVar.aSw.setVisibility(8);
            }
            if (!hVar.isSelf()) {
                if (hVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(u.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(u.j.his_attention_bar);
                }
            }
            iVar.euR.setText(string);
            iVar.euS.setText(u.j.set_private);
            iVar.euQ.setOnClickListener(new m(this));
        }
    }

    private void c(com.baidu.tieba.person.holder.i iVar, h hVar) {
        if (hVar != null) {
            String string = this.mContext.getResources().getString(u.j.my_attention_bar);
            if (hVar.erI) {
                iVar.aSw.setVisibility(0);
            } else {
                iVar.aSw.setVisibility(8);
            }
            if (!hVar.isSelf()) {
                if (hVar.getSex() == 2) {
                    string = this.mContext.getResources().getString(u.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(u.j.his_attention_bar);
                }
            }
            iVar.euP.setVisibility(0);
            iVar.euM.setVisibility(0);
            iVar.euN.setVisibility(0);
            iVar.euU.setVisibility(8);
            iVar.euQ.setVisibility(8);
            iVar.euL.setText(string);
            iVar.euR.setText(string);
            if (com.baidu.tbadk.core.util.y.s(hVar.aNE()) > 0) {
                iVar.euO.setText(new StringBuilder(String.valueOf(hVar.getCount())).toString());
                if (com.baidu.tbadk.core.util.y.s(hVar.aNE()) <= 3) {
                    iVar.euT.setVisibility(8);
                } else {
                    iVar.euT.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(hVar.aNE(), 0) != null) {
                    iVar.euF.setText(oG(((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 0)).getForumName()));
                    iVar.euF.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(hVar.aNE(), 1) != null) {
                    iVar.euG.setText(oG(((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 1)).getForumName()));
                    iVar.euG.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(hVar.aNE(), 2) != null) {
                    iVar.euH.setText(oG(((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 2)).getForumName()));
                    iVar.euH.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(hVar.aNE(), 3) != null) {
                    iVar.euI.setText(oG(((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 3)).getForumName()));
                    iVar.euI.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(hVar.aNE(), 4) != null) {
                    iVar.euJ.setText(oG(((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 4)).getForumName()));
                    iVar.euJ.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.c(hVar.aNE(), 5) != null) {
                    iVar.euK.setText(oG(((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 5)).getForumName()));
                    iVar.euK.setVisibility(0);
                }
                iVar.euM.setOnClickListener(aNt());
                iVar.euF.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 0)));
                iVar.euG.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 1)));
                iVar.euH.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 2)));
                iVar.euI.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 3)));
                iVar.euJ.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 4)));
                iVar.euK.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.c(hVar.aNE(), 5)));
            } else {
                iVar.euQ.setVisibility(0);
                iVar.euP.setVisibility(8);
                iVar.euM.setVisibility(8);
            }
            iVar.euQ.setOnClickListener(aNt());
        }
    }

    private void a(com.baidu.tieba.person.holder.i iVar, View view) {
        if (iVar.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            av.k(iVar.euP, u.d.cp_bg_line_d);
            av.k(iVar.euQ, u.f.addresslist_item_bg);
            av.k(iVar.euF, u.f.home_like_item_bg);
            av.k(iVar.euG, u.f.home_like_item_bg);
            av.k(iVar.euH, u.f.home_like_item_bg);
            av.k(iVar.euI, u.f.home_like_item_bg);
            av.k(iVar.euJ, u.f.home_like_item_bg);
            av.k(iVar.euK, u.f.home_like_item_bg);
            av.c(iVar.euF, u.d.cp_cont_f, 1);
            av.c(iVar.euG, u.d.cp_cont_f, 1);
            av.c(iVar.euH, u.d.cp_cont_f, 1);
            av.c(iVar.euI, u.d.cp_cont_f, 1);
            av.c(iVar.euJ, u.d.cp_cont_f, 1);
            av.c(iVar.euK, u.d.cp_cont_f, 1);
            av.l(iVar.aSw, u.d.cp_bg_line_c);
            av.l(view, u.d.cp_bg_line_d);
            av.l(iVar.euN, u.d.cp_bg_line_c);
            av.c(iVar.euL, u.d.cp_cont_f, 1);
            av.c(iVar.euO, u.d.cp_cont_c, 1);
            av.c(iVar.eut, u.f.icon_arrow_tab);
            av.c(iVar.euR, u.d.cp_cont_f, 1);
            av.c(iVar.euS, u.d.cp_cont_d, 1);
            av.c(iVar.euU, u.f.icon_mycenter_lock);
            iVar.afy = TbadkCoreApplication.m10getInst().getSkinType();
        }
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.eqf = wVar;
    }

    public View.OnClickListener aNt() {
        return new n(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new o(this, myLikeForum);
    }

    private String oG(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (ba.dz(str) >= 11) {
            return ba.j(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(u.j.bar);
    }
}
