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
/* loaded from: classes9.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    private LinearLayout laC;
    private HorizontalScrollListView ldH;
    private RelativeLayout ldI;
    private View ldJ;
    private MoreButton ldK;
    private ImageView ldL;
    private ImageView ldM;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.laC = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
        this.ldH = (HorizontalScrollListView) z(this.laC, R.id.horizontal_view);
        this.ldI = (RelativeLayout) z(this.laC, R.id.rlTop);
        this.ldJ = (View) z(this.laC, R.id.left);
        this.title = (TextView) z(this.laC, R.id.hor_title);
        this.ldK = (MoreButton) z(this.laC, R.id.right_textview);
        this.ldL = (ImageView) z(this.laC, R.id.rightIcon);
        this.ldM = (ImageView) z(this.laC, R.id.divider);
        return this.laC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundColor(this.ldJ, R.color.CAM_X0308);
        ap.setBackgroundColor(this.ldM, R.color.CAM_X0201);
        ap.setImageResource(this.ldM, R.color.CAM_X0204);
        ap.setBackgroundColor(this.laC, R.color.CAM_X0201);
        ap.setBackgroundResource(this.ldI, R.drawable.addresslist_item_bg);
        this.ldH.onSkinTypeChanged(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.ldJ.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.ldM.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.ldH.setVisibility(8);
        } else {
            this.ldH.setRound(horRankCard.getPicType() == 1);
            this.ldH.setDisplayNum(horRankCard.getDisplayNum());
            this.ldH.setRatio(horRankCard.getRatio());
            this.ldH.setVisibility(0);
            this.ldH.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.ldH.setData(rankInfoList, this.eUY);
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
            ap.setBackgroundResource(this.laC, R.drawable.addresslist_item_bg);
            this.laC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).fF(TiebaInitialize.Params.OBJ_URL, horRankCard.getScheme()).bA("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        v.j(HorRankCardView.this.eUY, horRankCard.getScheme());
                    }
                }
            });
        } else {
            ap.setBackgroundColor(this.laC, R.color.CAM_X0201);
            this.laC.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.ldL.setVisibility(8);
            this.ldK.setVisibility(0);
            this.ldK.setData(rightText, this.eUY);
            return;
        }
        this.ldK.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.ldL.setVisibility(0);
            ap.setImageResource(this.ldL, R.drawable.icon_arrow_tab);
            return;
        }
        this.ldL.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ap.setViewTextColor(this.ldK, R.color.CAM_X0302);
        } else {
            a(this.ldK, cVar.dbJ(), cVar.dbL(), R.color.CAM_X0302);
        }
    }
}
