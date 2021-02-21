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
    private LinearLayout laQ;
    private HorizontalScrollListView ldV;
    private RelativeLayout ldW;
    private View ldX;
    private MoreButton ldY;
    private ImageView ldZ;
    private ImageView lea;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.laQ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
        this.ldV = (HorizontalScrollListView) z(this.laQ, R.id.horizontal_view);
        this.ldW = (RelativeLayout) z(this.laQ, R.id.rlTop);
        this.ldX = (View) z(this.laQ, R.id.left);
        this.title = (TextView) z(this.laQ, R.id.hor_title);
        this.ldY = (MoreButton) z(this.laQ, R.id.right_textview);
        this.ldZ = (ImageView) z(this.laQ, R.id.rightIcon);
        this.lea = (ImageView) z(this.laQ, R.id.divider);
        return this.laQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundColor(this.ldX, R.color.CAM_X0308);
        ap.setBackgroundColor(this.lea, R.color.CAM_X0201);
        ap.setImageResource(this.lea, R.color.CAM_X0204);
        ap.setBackgroundColor(this.laQ, R.color.CAM_X0201);
        ap.setBackgroundResource(this.ldW, R.drawable.addresslist_item_bg);
        this.ldV.onSkinTypeChanged(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.ldX.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.lea.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.ldV.setVisibility(8);
        } else {
            this.ldV.setRound(horRankCard.getPicType() == 1);
            this.ldV.setDisplayNum(horRankCard.getDisplayNum());
            this.ldV.setRatio(horRankCard.getRatio());
            this.ldV.setVisibility(0);
            this.ldV.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.ldV.setData(rankInfoList, this.eUY);
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
            ap.setBackgroundResource(this.laQ, R.drawable.addresslist_item_bg);
            this.laQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).fF(TiebaInitialize.Params.OBJ_URL, horRankCard.getScheme()).bA("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        v.j(HorRankCardView.this.eUY, horRankCard.getScheme());
                    }
                }
            });
        } else {
            ap.setBackgroundColor(this.laQ, R.color.CAM_X0201);
            this.laQ.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.ldZ.setVisibility(8);
            this.ldY.setVisibility(0);
            this.ldY.setData(rightText, this.eUY);
            return;
        }
        this.ldY.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.ldZ.setVisibility(0);
            ap.setImageResource(this.ldZ, R.drawable.icon_arrow_tab);
            return;
        }
        this.ldZ.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ap.setViewTextColor(this.ldY, R.color.CAM_X0302);
        } else {
            a(this.ldY, cVar.dbQ(), cVar.dbS(), R.color.CAM_X0302);
        }
    }
}
