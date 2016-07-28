package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.b.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.l, com.baidu.tieba.person.holder.l> {
    private View.OnClickListener afk;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.afk = new t(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public com.baidu.tieba.person.holder.l a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.l(LayoutInflater.from(this.mContext).inflate(u.h.person_info_live_thread_card, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.l lVar, com.baidu.tieba.person.holder.l lVar2) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        a(lVar2);
        if (lVar != null) {
            a(lVar2, lVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.person.holder.l lVar, com.baidu.tieba.person.data.l lVar2) {
        lVar.evI.setOnClickListener(this.afk);
        com.baidu.tbadk.core.data.ab aNL = lVar2.aNL();
        if (aNL == null || aNL.oY() == null || aNL.oZ() == null) {
            lVar.evM.setVisibility(8);
            return;
        }
        TwZhiBoUser oY = aNL.oY();
        if (aNL.oZ().size() == 0 || oY.in_black_list.intValue() == 1) {
            lVar.evM.setVisibility(8);
            return;
        }
        lVar.evM.setOnClickListener(this.afk);
        lVar.evM.setTag(lVar2);
        lVar.evM.setVisibility(0);
        lVar.evP.setText(String.format(this.mContext.getString(u.j.host_level_unlock), Integer.valueOf(a.C0031a.aO(oY.anchor_level.intValue()) + 1)));
        lVar.evQ.removeAllViews();
        int c = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds4);
        int c2 = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds32);
        for (TwAnchorProfitItem twAnchorProfitItem : aNL.oZ()) {
            com.baidu.tieba.view.g gVar = new com.baidu.tieba.view.g(this.mContext);
            HeadImageView icon = gVar.getIcon();
            icon.setAutoChangeStyle(true);
            icon.c(twAnchorProfitItem.icon_unlock_url, 10, false);
            lVar.evQ.addView(gVar);
            ((LinearLayout.LayoutParams) gVar.getLayoutParams()).leftMargin = c;
            gVar.bw(c2, c2);
            gVar.bx(c2, c2);
            gVar.by(c2 / 2, c2 / 2);
        }
    }

    private void a(com.baidu.tieba.person.holder.l lVar) {
        int skinType;
        if (lVar != null && (skinType = TbadkCoreApplication.m10getInst().getSkinType()) != lVar.mSkinType) {
            lVar.mSkinType = skinType;
            av.k(lVar.evI, u.f.addresslist_item_bg);
            av.c(lVar.evL, u.f.icon_pl_live_telecast);
            av.c(lVar.evK, u.f.icon_arrow_tab);
            av.l(lVar.euV, u.d.cp_bg_line_c);
            av.c(lVar.evJ, u.d.cp_cont_f, 1);
            av.k(lVar.evM, u.f.addresslist_item_bg);
            av.c(lVar.evN, u.f.icon_mine_anchor);
            av.c(lVar.evO, u.d.cp_cont_f, 1);
            av.c(lVar.evP, u.d.cp_cont_d, 1);
            av.c(lVar.evR, u.f.icon_arrow_tab);
            av.l(lVar.evS, u.d.cp_bg_line_c);
        }
    }
}
