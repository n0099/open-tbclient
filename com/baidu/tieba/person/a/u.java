package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.b.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.m, com.baidu.tieba.person.b.l> {
    private View.OnClickListener aew;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aew = new v(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public com.baidu.tieba.person.b.l a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.l(LayoutInflater.from(this.mContext).inflate(u.h.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.l lVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        a(lVar);
        if (mVar != null) {
            a(lVar, mVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.m mVar) {
        lVar.ell.setOnClickListener(this.aew);
        com.baidu.tbadk.core.data.y aLi = mVar.aLi();
        if (aLi == null || aLi.pp() == null || aLi.pq() == null) {
            lVar.elp.setVisibility(8);
            return;
        }
        TwZhiBoUser pp = aLi.pp();
        if (aLi.pq().size() == 0 || pp.in_black_list.intValue() == 1) {
            lVar.elp.setVisibility(8);
            return;
        }
        lVar.elp.setOnClickListener(this.aew);
        lVar.elp.setTag(mVar);
        lVar.elp.setVisibility(0);
        lVar.els.setText(String.format(this.mContext.getString(u.j.host_level_unlock), Integer.valueOf(a.C0031a.aL(pp.anchor_level.intValue()) + 1)));
        lVar.elt.removeAllViews();
        int c = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds4);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds32);
        for (TwAnchorProfitItem twAnchorProfitItem : aLi.pq()) {
            com.baidu.tieba.view.g gVar = new com.baidu.tieba.view.g(this.mContext);
            HeadImageView icon = gVar.getIcon();
            icon.setAutoChangeStyle(true);
            icon.c(twAnchorProfitItem.icon_unlock_url, 10, false);
            lVar.elt.addView(gVar);
            ((LinearLayout.LayoutParams) gVar.getLayoutParams()).leftMargin = c;
            gVar.bt(c2, c2);
            gVar.bu(c2, c2);
            gVar.bv(c2 / 2, c2 / 2);
        }
    }

    private void a(com.baidu.tieba.person.b.l lVar) {
        int skinType;
        if (lVar != null && (skinType = TbadkCoreApplication.m9getInst().getSkinType()) != lVar.mSkinType) {
            lVar.mSkinType = skinType;
            com.baidu.tbadk.core.util.av.k(lVar.ell, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(lVar.elo, u.f.icon_pl_live_telecast);
            com.baidu.tbadk.core.util.av.c(lVar.eln, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.l(lVar.eky, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(lVar.elm, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.k(lVar.elp, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(lVar.elq, u.f.icon_mine_anchor);
            com.baidu.tbadk.core.util.av.c(lVar.elr, u.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.av.c(lVar.els, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(lVar.elu, u.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.av.l(lVar.elv, u.d.cp_bg_line_c);
        }
    }
}
