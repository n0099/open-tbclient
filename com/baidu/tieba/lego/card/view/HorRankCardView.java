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
import com.baidu.tbadk.core.util.ap;
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
    private LinearLayout lcT;
    private HorizontalScrollListView lfY;
    private RelativeLayout lfZ;
    private View lga;
    private MoreButton lgb;
    private ImageView lgc;
    private ImageView lgd;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.lcT = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
        this.lfY = (HorizontalScrollListView) z(this.lcT, R.id.horizontal_view);
        this.lfZ = (RelativeLayout) z(this.lcT, R.id.rlTop);
        this.lga = (View) z(this.lcT, R.id.left);
        this.title = (TextView) z(this.lcT, R.id.hor_title);
        this.lgb = (MoreButton) z(this.lcT, R.id.right_textview);
        this.lgc = (ImageView) z(this.lcT, R.id.rightIcon);
        this.lgd = (ImageView) z(this.lcT, R.id.divider);
        return this.lcT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.eWx, getRootView());
        ap.setBackgroundColor(this.lga, R.color.CAM_X0308);
        ap.setBackgroundColor(this.lgd, R.color.CAM_X0201);
        ap.setImageResource(this.lgd, R.color.CAM_X0204);
        ap.setBackgroundColor(this.lcT, R.color.CAM_X0201);
        ap.setBackgroundResource(this.lfZ, R.drawable.addresslist_item_bg);
        this.lfY.onSkinTypeChanged(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.lga.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.lgd.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.lfY.setVisibility(8);
        } else {
            this.lfY.setRound(horRankCard.getPicType() == 1);
            this.lfY.setDisplayNum(horRankCard.getDisplayNum());
            this.lfY.setRatio(horRankCard.getRatio());
            this.lfY.setVisibility(0);
            this.lfY.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.lfY.setData(rankInfoList, this.eWx);
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
            ap.setBackgroundResource(this.lcT, R.drawable.addresslist_item_bg);
            this.lcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).fF(TiebaInitialize.Params.OBJ_URL, horRankCard.getScheme()).bA("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        v.j(HorRankCardView.this.eWx, horRankCard.getScheme());
                    }
                }
            });
        } else {
            ap.setBackgroundColor(this.lcT, R.color.CAM_X0201);
            this.lcT.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.lgc.setVisibility(8);
            this.lgb.setVisibility(0);
            this.lgb.setData(rightText, this.eWx);
            return;
        }
        this.lgb.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.lgc.setVisibility(0);
            ap.setImageResource(this.lgc, R.drawable.icon_arrow_tab);
            return;
        }
        this.lgc.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ap.setViewTextColor(this.lgb, R.color.CAM_X0302);
        } else {
            a(this.lgb, cVar.dbZ(), cVar.dcb(), R.color.CAM_X0302);
        }
    }
}
