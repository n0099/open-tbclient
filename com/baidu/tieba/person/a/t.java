package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.b.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class t extends c<com.baidu.tieba.person.data.l, com.baidu.tieba.person.b.k> {
    private View.OnClickListener OS;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.OS = new u(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public com.baidu.tieba.person.b.k b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.k(LayoutInflater.from(this.mContext).inflate(t.h.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.b.k kVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(kVar);
        if (lVar != null && this.aXE) {
            a(kVar, lVar);
            this.aXE = false;
        }
        return view;
    }

    private void a(com.baidu.tieba.person.b.k kVar, com.baidu.tieba.person.data.l lVar) {
        kVar.dfb.setOnClickListener(this.OS);
        com.baidu.tbadk.core.data.q auo = lVar.auo();
        if (auo == null || auo.sm() == null || auo.sn() == null) {
            kVar.dff.setVisibility(8);
            return;
        }
        TwZhiBoUser sm = auo.sm();
        if (auo.sn().size() == 0 || sm.in_black_list.intValue() == 1) {
            kVar.dff.setVisibility(8);
            return;
        }
        kVar.dff.setOnClickListener(this.OS);
        kVar.dff.setTag(lVar);
        kVar.dff.setVisibility(0);
        kVar.dfi.setText(String.format(this.mContext.getString(t.j.host_level_unlock), Integer.valueOf(a.C0040a.aX(sm.anchor_level.intValue()) + 1)));
        kVar.dfj.removeAllViews();
        for (TwAnchorProfitItem twAnchorProfitItem : auo.sn()) {
            HeadImageView headImageView = new HeadImageView(this.mContext);
            headImageView.setAutoChangeStyle(true);
            int c = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds4);
            headImageView.setLayoutParams(layoutParams);
            headImageView.d(twAnchorProfitItem.icon_lock_url, 10, false);
            kVar.dfj.addView(headImageView);
        }
    }

    private void a(com.baidu.tieba.person.b.k kVar) {
        int skinType;
        if (kVar != null && (skinType = TbadkCoreApplication.m411getInst().getSkinType()) != kVar.mSkinType) {
            kVar.mSkinType = skinType;
            ar.k(kVar.dfb, t.f.addresslist_item_bg);
            ar.c(kVar.dfe, t.f.icon_pl_live_telecast);
            ar.c(kVar.dfd, t.f.icon_arrow_tab);
            ar.l(kVar.deo, t.d.cp_bg_line_c);
            ar.b(kVar.dfc, t.d.cp_cont_f, 1);
            ar.k(kVar.dff, t.f.addresslist_item_bg);
            ar.c(kVar.dfg, t.f.icon_mine_anchor);
            ar.b(kVar.dfh, t.d.cp_cont_f, 1);
            ar.b(kVar.dfi, t.d.cp_cont_d, 1);
            ar.c(kVar.dfk, t.f.icon_arrow_tab);
            ar.l(kVar.dfl, t.d.cp_bg_line_c);
        }
    }
}
