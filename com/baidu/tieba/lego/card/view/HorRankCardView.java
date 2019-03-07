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
    private LinearLayout gFM;
    private HorizontalScrollListView gIW;
    private RelativeLayout gIX;
    private View gIY;
    private MoreButton gIZ;
    private ImageView gJa;
    private ImageView gJb;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gFM = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_horizontal, (ViewGroup) null, false);
        this.gIW = (HorizontalScrollListView) A(this.gFM, d.g.horizontal_view);
        this.gIX = (RelativeLayout) A(this.gFM, d.g.rlTop);
        this.gIY = (View) A(this.gFM, d.g.left);
        this.title = (TextView) A(this.gFM, d.g.hor_title);
        this.gIZ = (MoreButton) A(this.gFM, d.g.right_textview);
        this.gJa = (ImageView) A(this.gFM, d.g.rightIcon);
        this.gJb = (ImageView) A(this.gFM, d.g.divider);
        return this.gFM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.l(this.gIY, d.C0236d.cp_other_b);
        al.l(this.gJb, d.C0236d.cp_bg_line_d);
        al.c(this.gJb, d.C0236d.cp_bg_line_b);
        al.l(this.gFM, d.C0236d.cp_bg_line_d);
        al.k(this.gIX, d.f.addresslist_item_bg);
        this.gIW.hN(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.gIY.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.gJb.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.gIW.setVisibility(8);
        } else {
            this.gIW.setRound(horRankCard.getPicType() == 1);
            this.gIW.setDisplayNum(horRankCard.getDisplayNum());
            this.gIW.setRatio(horRankCard.getRatio());
            this.gIW.setVisibility(0);
            this.gIW.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.gIW.setData(rankInfoList, this.mContext);
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
            al.k(this.gFM, d.f.addresslist_item_bg);
            this.gFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).di("obj_url", horRankCard.getScheme()).bb("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        q.f(HorRankCardView.this.mContext, horRankCard.getScheme());
                    }
                }
            });
        } else {
            al.l(this.gFM, d.C0236d.cp_bg_line_d);
            this.gFM.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.gJa.setVisibility(8);
            this.gIZ.setVisibility(0);
            this.gIZ.setData(rightText, this.mContext);
            return;
        }
        this.gIZ.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.gJa.setVisibility(0);
            al.c(this.gJa, d.f.icon_arrow_tab);
            return;
        }
        this.gJa.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            al.j(this.gIZ, d.C0236d.cp_link_tip_a);
        } else {
            a(this.gIZ, cVar.bzY(), cVar.bAa(), d.C0236d.cp_link_tip_a);
        }
    }
}
