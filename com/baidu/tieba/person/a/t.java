package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.b.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class t extends c<com.baidu.tieba.person.data.l, com.baidu.tieba.person.b.k> {
    private View.OnClickListener OZ;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.OZ = new u(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public com.baidu.tieba.person.b.k b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.k(LayoutInflater.from(this.mContext).inflate(t.h.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.k kVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(kVar);
        if (lVar != null) {
            a(kVar, lVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        kVar.dzA.setOnClickListener(this.OZ);
        com.baidu.tbadk.core.data.w aBU = lVar.aBU();
        if (aBU == null || aBU.sd() == null || aBU.se() == null) {
            kVar.dzE.setVisibility(8);
            return;
        }
        TwZhiBoUser sd = aBU.sd();
        if (aBU.se().size() == 0 || sd.in_black_list.intValue() == 1) {
            kVar.dzE.setVisibility(8);
            return;
        }
        kVar.dzE.setOnClickListener(this.OZ);
        kVar.dzE.setTag(lVar);
        kVar.dzE.setVisibility(0);
        kVar.dzH.setText(String.format(this.mContext.getString(t.j.host_level_unlock), Integer.valueOf(a.C0040a.aW(sd.anchor_level.intValue()) + 1)));
        kVar.dzI.removeAllViews();
        int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds4);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
        for (TwAnchorProfitItem twAnchorProfitItem : aBU.se()) {
            com.baidu.tieba.view.f fVar = new com.baidu.tieba.view.f(this.mContext);
            HeadImageView icon = fVar.getIcon();
            icon.setAutoChangeStyle(true);
            icon.c(twAnchorProfitItem.icon_unlock_url, 10, false);
            kVar.dzI.addView(fVar);
            ((LinearLayout.LayoutParams) fVar.getLayoutParams()).leftMargin = c;
            fVar.bi(c2, c2);
            fVar.bj(c2, c2);
            fVar.bk(c2 / 2, c2 / 2);
        }
    }

    private void a(com.baidu.tieba.person.b.k kVar) {
        int skinType;
        if (kVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != kVar.mSkinType) {
            kVar.mSkinType = skinType;
            at.k(kVar.dzA, t.f.addresslist_item_bg);
            at.c(kVar.dzD, t.f.icon_pl_live_telecast);
            at.c(kVar.dzC, t.f.icon_arrow_tab);
            at.l(kVar.dyN, t.d.cp_bg_line_c);
            at.b(kVar.dzB, t.d.cp_cont_f, 1);
            at.k(kVar.dzE, t.f.addresslist_item_bg);
            at.c(kVar.dzF, t.f.icon_mine_anchor);
            at.b(kVar.dzG, t.d.cp_cont_f, 1);
            at.b(kVar.dzH, t.d.cp_cont_d, 1);
            at.c(kVar.dzJ, t.f.icon_arrow_tab);
            at.l(kVar.dzK, t.d.cp_bg_line_c);
        }
    }
}
