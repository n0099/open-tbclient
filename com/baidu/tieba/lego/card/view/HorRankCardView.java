package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.view.HorizontalScrollListView;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.tbadkCore.q;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    private LinearLayout gFN;
    private HorizontalScrollListView gIX;
    private RelativeLayout gIY;
    private View gIZ;
    private MoreButton gJa;
    private ImageView gJb;
    private ImageView gJc;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.gFN = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_horizontal, (ViewGroup) null, false);
        this.gIX = (HorizontalScrollListView) A(this.gFN, d.g.horizontal_view);
        this.gIY = (RelativeLayout) A(this.gFN, d.g.rlTop);
        this.gIZ = (View) A(this.gFN, d.g.left);
        this.title = (TextView) A(this.gFN, d.g.hor_title);
        this.gJa = (MoreButton) A(this.gFN, d.g.right_textview);
        this.gJb = (ImageView) A(this.gFN, d.g.rightIcon);
        this.gJc = (ImageView) A(this.gFN, d.g.divider);
        return this.gFN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.l(this.gIZ, d.C0236d.cp_other_b);
        al.l(this.gJc, d.C0236d.cp_bg_line_d);
        al.c(this.gJc, d.C0236d.cp_bg_line_b);
        al.l(this.gFN, d.C0236d.cp_bg_line_d);
        al.k(this.gIY, d.f.addresslist_item_bg);
        this.gIX.hN(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.gIZ.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.gJc.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.gIX.setVisibility(8);
        } else {
            this.gIX.setRound(horRankCard.getPicType() == 1);
            this.gIX.setDisplayNum(horRankCard.getDisplayNum());
            this.gIX.setRatio(horRankCard.getRatio());
            this.gIX.setVisibility(0);
            this.gIX.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.gIX.setData(rankInfoList, this.mContext);
        }
        if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
            this.title.setVisibility(0);
            a(this.title, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), d.C0236d.cp_cont_b);
            this.title.setText(horRankCard.getCardTitle());
        } else {
            this.title.setVisibility(8);
        }
        setMoreColor(horRankCard.getRightText());
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            al.k(this.gFN, d.f.addresslist_item_bg);
            this.gFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).di("obj_url", horRankCard.getScheme()).bb("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        q.f(HorRankCardView.this.mContext, horRankCard.getScheme());
                    }
                }
            });
        } else {
            al.l(this.gFN, d.C0236d.cp_bg_line_d);
            this.gFN.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.gJb.setVisibility(8);
            this.gJa.setVisibility(0);
            this.gJa.setData(rightText, this.mContext);
            return;
        }
        this.gJa.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.gJb.setVisibility(0);
            al.c(this.gJb, d.f.icon_arrow_tab);
            return;
        }
        this.gJb.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            al.j(this.gJa, d.C0236d.cp_link_tip_a);
        } else {
            a(this.gJa, cVar.bzZ(), cVar.bAb(), d.C0236d.cp_link_tip_a);
        }
    }
}
