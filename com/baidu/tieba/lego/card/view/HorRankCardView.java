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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.view.HorizontalScrollListView;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    private LinearLayout kSz;
    private HorizontalScrollListView kVE;
    private RelativeLayout kVF;
    private View kVG;
    private MoreButton kVH;
    private ImageView kVI;
    private ImageView kVJ;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.kSz = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
        this.kVE = (HorizontalScrollListView) z(this.kSz, R.id.horizontal_view);
        this.kVF = (RelativeLayout) z(this.kSz, R.id.rlTop);
        this.kVG = (View) z(this.kSz, R.id.left);
        this.title = (TextView) z(this.kSz, R.id.hor_title);
        this.kVH = (MoreButton) z(this.kSz, R.id.right_textview);
        this.kVI = (ImageView) z(this.kSz, R.id.rightIcon);
        this.kVJ = (ImageView) z(this.kSz, R.id.divider);
        return this.kSz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        ao.setBackgroundColor(this.kVG, R.color.CAM_X0308);
        ao.setBackgroundColor(this.kVJ, R.color.CAM_X0201);
        ao.setImageResource(this.kVJ, R.color.CAM_X0204);
        ao.setBackgroundColor(this.kSz, R.color.CAM_X0201);
        ao.setBackgroundResource(this.kVF, R.drawable.addresslist_item_bg);
        this.kVE.onSkinTypeChanged(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.kVG.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.kVJ.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.kVE.setVisibility(8);
        } else {
            this.kVE.setRound(horRankCard.getPicType() == 1);
            this.kVE.setDisplayNum(horRankCard.getDisplayNum());
            this.kVE.setRatio(horRankCard.getRatio());
            this.kVE.setVisibility(0);
            this.kVE.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.kVE.setData(rankInfoList, this.eSJ);
        }
        if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
            this.title.setVisibility(0);
            a(this.title, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), R.color.CAM_X0105);
            this.title.setText(horRankCard.getCardTitle());
        } else {
            this.title.setVisibility(8);
        }
        setMoreColor(horRankCard.getRightText());
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            ao.setBackgroundResource(this.kSz, R.drawable.addresslist_item_bg);
            this.kSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).fF(TiebaInitialize.Params.OBJ_URL, horRankCard.getScheme()).bz("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        v.h(HorRankCardView.this.eSJ, horRankCard.getScheme());
                    }
                }
            });
        } else {
            ao.setBackgroundColor(this.kSz, R.color.CAM_X0201);
            this.kSz.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.kVI.setVisibility(8);
            this.kVH.setVisibility(0);
            this.kVH.setData(rightText, this.eSJ);
            return;
        }
        this.kVH.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.kVI.setVisibility(0);
            ao.setImageResource(this.kVI, R.drawable.icon_arrow_tab);
            return;
        }
        this.kVI.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ao.setViewTextColor(this.kVH, R.color.CAM_X0302);
        } else {
            a(this.kVH, cVar.cZL(), cVar.cZN(), R.color.CAM_X0302);
        }
    }
}
