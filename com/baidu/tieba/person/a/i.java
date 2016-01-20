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
public class i extends c<com.baidu.tieba.person.data.f, com.baidu.tieba.person.b.f> {
    private com.baidu.adp.widget.ListView.v cQE;
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
    /* renamed from: ah */
    public com.baidu.tieba.person.b.f a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.f(LayoutInflater.from(this.mContext).inflate(n.h.person_info_forum_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.f fVar, com.baidu.tieba.person.b.f fVar2) {
        a(fVar2, view);
        if (fVar != null && this.aVr) {
            a(fVar2, fVar);
            this.aVr = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.f fVar, com.baidu.tieba.person.data.f fVar2) {
        if (fVar != null && fVar2 != null) {
            this.isSelf = fVar2.isSelf();
            this.userId = fVar2.getUserId();
            if (this.isSelf) {
                c(fVar, fVar2);
            } else if (fVar2.apq() == 1 || (fVar2.apq() == 2 && fVar2.getIsFriend() == 1)) {
                c(fVar, fVar2);
            } else {
                b(fVar, fVar2);
            }
        }
    }

    private void b(com.baidu.tieba.person.b.f fVar, com.baidu.tieba.person.data.f fVar2) {
        if (fVar2 != null) {
            fVar.cSU.setVisibility(8);
            fVar.cSQ.setVisibility(8);
            fVar.cSS.setVisibility(8);
            fVar.cSZ.setVisibility(0);
            fVar.cSV.setVisibility(0);
            String string = this.mContext.getResources().getString(n.j.my_attention_bar);
            if (fVar2.cRM) {
                fVar.aPe.setVisibility(0);
            } else {
                fVar.aPe.setVisibility(8);
            }
            if (!fVar2.isSelf()) {
                if (fVar2.getSex() == 2) {
                    string = this.mContext.getResources().getString(n.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(n.j.his_attention_bar);
                }
            }
            fVar.cSW.setText(string);
            fVar.cSX.setText(n.j.set_private);
            fVar.cSV.setOnClickListener(new j(this));
        }
    }

    private void c(com.baidu.tieba.person.b.f fVar, com.baidu.tieba.person.data.f fVar2) {
        if (fVar2 != null) {
            String string = this.mContext.getResources().getString(n.j.my_attention_bar);
            if (fVar2.cRM) {
                fVar.aPe.setVisibility(0);
            } else {
                fVar.aPe.setVisibility(8);
            }
            if (!fVar2.isSelf()) {
                if (fVar2.getSex() == 2) {
                    string = this.mContext.getResources().getString(n.j.her_attention_bar);
                } else {
                    string = this.mContext.getResources().getString(n.j.his_attention_bar);
                }
            }
            fVar.cSU.setVisibility(0);
            fVar.cSQ.setVisibility(0);
            fVar.cSS.setVisibility(0);
            fVar.cSZ.setVisibility(8);
            fVar.cSV.setVisibility(8);
            fVar.cSP.setText(string);
            fVar.cSW.setText(string);
            if (com.baidu.tbadk.core.util.y.l(fVar2.app()) > 0) {
                fVar.cST.setText(new StringBuilder(String.valueOf(fVar2.getCount())).toString());
                if (com.baidu.tbadk.core.util.y.l(fVar2.app()) <= 3) {
                    fVar.cSY.setVisibility(8);
                } else {
                    fVar.cSY.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar2.app(), 0) != null) {
                    fVar.cSJ.setText(kT(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 0)).getForumName()));
                    fVar.cSJ.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar2.app(), 1) != null) {
                    fVar.cSK.setText(kT(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 1)).getForumName()));
                    fVar.cSK.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar2.app(), 2) != null) {
                    fVar.cSL.setText(kT(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 2)).getForumName()));
                    fVar.cSL.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar2.app(), 3) != null) {
                    fVar.cSM.setText(kT(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 3)).getForumName()));
                    fVar.cSM.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar2.app(), 4) != null) {
                    fVar.cSN.setText(kT(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 4)).getForumName()));
                    fVar.cSN.setVisibility(0);
                }
                if (com.baidu.tbadk.core.util.y.b(fVar2.app(), 5) != null) {
                    fVar.cSO.setText(kT(((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 5)).getForumName()));
                    fVar.cSO.setVisibility(0);
                }
                fVar.cSQ.setOnClickListener(api());
                fVar.cSJ.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 0)));
                fVar.cSK.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 1)));
                fVar.cSL.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 2)));
                fVar.cSM.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 3)));
                fVar.cSN.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 4)));
                fVar.cSO.setOnClickListener(a((MyLikeForum) com.baidu.tbadk.core.util.y.b(fVar2.app(), 5)));
            } else {
                fVar.cSV.setVisibility(0);
                fVar.cSU.setVisibility(8);
                fVar.cSQ.setVisibility(8);
            }
            fVar.cSV.setOnClickListener(api());
        }
    }

    private void a(com.baidu.tieba.person.b.f fVar, View view) {
        if (fVar.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            as.i(fVar.cSU, n.d.cp_bg_line_d);
            as.i(fVar.cSV, n.f.addresslist_item_bg);
            as.i((View) fVar.cSJ, n.f.home_like_item_bg);
            as.i((View) fVar.cSK, n.f.home_like_item_bg);
            as.i((View) fVar.cSL, n.f.home_like_item_bg);
            as.i((View) fVar.cSM, n.f.home_like_item_bg);
            as.i((View) fVar.cSN, n.f.home_like_item_bg);
            as.i((View) fVar.cSO, n.f.home_like_item_bg);
            as.b(fVar.cSJ, n.d.cp_cont_f, 1);
            as.b(fVar.cSK, n.d.cp_cont_f, 1);
            as.b(fVar.cSL, n.d.cp_cont_f, 1);
            as.b(fVar.cSM, n.d.cp_cont_f, 1);
            as.b(fVar.cSN, n.d.cp_cont_f, 1);
            as.b(fVar.cSO, n.d.cp_cont_f, 1);
            as.j(fVar.aPe, n.d.cp_bg_line_c);
            as.j(view, n.d.cp_bg_line_d);
            as.j(fVar.cSR, n.d.cp_bg_line_c);
            as.j(fVar.cSS, n.d.cp_bg_line_c);
            as.b(fVar.cSP, n.d.cp_cont_f, 1);
            as.b(fVar.cST, n.d.cp_cont_c, 1);
            as.c(fVar.cSx, n.f.icon_arrow_tab);
            as.b(fVar.cSW, n.d.cp_cont_f, 1);
            as.b(fVar.cSX, n.d.cp_cont_d, 1);
            as.c(fVar.cSZ, n.f.icon_mycenter_lock);
            fVar.ahf = TbadkCoreApplication.m411getInst().getSkinType();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cQE = vVar;
    }

    public View.OnClickListener api() {
        return new k(this);
    }

    public View.OnClickListener a(MyLikeForum myLikeForum) {
        if (myLikeForum == null) {
            return null;
        }
        return new l(this, myLikeForum);
    }

    private String kT(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (ax.dA(str) >= 11) {
            return ax.i(str, 10);
        }
        return String.valueOf(str) + this.mContext.getResources().getString(n.j.bar);
    }
}
