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
import com.baidu.tieba.t;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class u extends c<com.baidu.tieba.person.data.m, com.baidu.tieba.person.b.l> {
    private View.OnClickListener Fn;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.Fn = new v(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public com.baidu.tieba.person.b.l b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.l(LayoutInflater.from(this.mContext).inflate(t.h.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.l lVar) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        a(lVar);
        if (mVar != null) {
            a(lVar, mVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.l lVar, com.baidu.tieba.person.data.m mVar) {
        lVar.dCI.setOnClickListener(this.Fn);
        com.baidu.tbadk.core.data.w aCp = mVar.aCp();
        if (aCp == null || aCp.pw() == null || aCp.px() == null) {
            lVar.dCM.setVisibility(8);
            return;
        }
        TwZhiBoUser pw = aCp.pw();
        if (aCp.px().size() == 0 || pw.in_black_list.intValue() == 1) {
            lVar.dCM.setVisibility(8);
            return;
        }
        lVar.dCM.setOnClickListener(this.Fn);
        lVar.dCM.setTag(mVar);
        lVar.dCM.setVisibility(0);
        lVar.dCP.setText(String.format(this.mContext.getString(t.j.host_level_unlock), Integer.valueOf(a.C0031a.aK(pw.anchor_level.intValue()) + 1)));
        lVar.dCQ.removeAllViews();
        int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds4);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
        for (TwAnchorProfitItem twAnchorProfitItem : aCp.px()) {
            com.baidu.tieba.view.g gVar = new com.baidu.tieba.view.g(this.mContext);
            HeadImageView icon = gVar.getIcon();
            icon.setAutoChangeStyle(true);
            icon.c(twAnchorProfitItem.icon_unlock_url, 10, false);
            lVar.dCQ.addView(gVar);
            ((LinearLayout.LayoutParams) gVar.getLayoutParams()).leftMargin = c;
            gVar.bl(c2, c2);
            gVar.bm(c2, c2);
            gVar.bn(c2 / 2, c2 / 2);
        }
    }

    private void a(com.baidu.tieba.person.b.l lVar) {
        int skinType;
        if (lVar != null && (skinType = TbadkCoreApplication.m11getInst().getSkinType()) != lVar.mSkinType) {
            lVar.mSkinType = skinType;
            com.baidu.tbadk.core.util.at.k(lVar.dCI, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(lVar.dCL, t.f.icon_pl_live_telecast);
            com.baidu.tbadk.core.util.at.c(lVar.dCK, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.l(lVar.dBV, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(lVar.dCJ, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.k(lVar.dCM, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(lVar.dCN, t.f.icon_mine_anchor);
            com.baidu.tbadk.core.util.at.c(lVar.dCO, t.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.at.c(lVar.dCP, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(lVar.dCR, t.f.icon_arrow_tab);
            com.baidu.tbadk.core.util.at.l(lVar.dCS, t.d.cp_bg_line_c);
        }
    }
}
