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
/* loaded from: classes9.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    private LinearLayout kXe;
    private HorizontalScrollListView laj;
    private RelativeLayout lak;
    private View lal;
    private MoreButton lam;
    private ImageView lan;
    private ImageView lao;
    private TextView title;

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.kXe = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
        this.laj = (HorizontalScrollListView) z(this.kXe, R.id.horizontal_view);
        this.lak = (RelativeLayout) z(this.kXe, R.id.rlTop);
        this.lal = (View) z(this.kXe, R.id.left);
        this.title = (TextView) z(this.kXe, R.id.hor_title);
        this.lam = (MoreButton) z(this.kXe, R.id.right_textview);
        this.lan = (ImageView) z(this.kXe, R.id.rightIcon);
        this.lao = (ImageView) z(this.kXe, R.id.divider);
        return this.kXe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(HorRankCard horRankCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
        ao.setBackgroundColor(this.lal, R.color.CAM_X0308);
        ao.setBackgroundColor(this.lao, R.color.CAM_X0201);
        ao.setImageResource(this.lao, R.color.CAM_X0204);
        ao.setBackgroundColor(this.kXe, R.color.CAM_X0201);
        ao.setBackgroundResource(this.lak, R.drawable.addresslist_item_bg);
        this.laj.onSkinTypeChanged(this.mSkinType);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.lal.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.lao.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList == null || rankInfoList.size() == 0) {
            this.laj.setVisibility(8);
        } else {
            this.laj.setRound(horRankCard.getPicType() == 1);
            this.laj.setDisplayNum(horRankCard.getDisplayNum());
            this.laj.setRatio(horRankCard.getRatio());
            this.laj.setVisibility(0);
            this.laj.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.laj.setData(rankInfoList, this.eXu);
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
            ao.setBackgroundResource(this.kXe, R.drawable.addresslist_item_bg);
            this.kXe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.HorRankCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(horRankCard.getScheme())) {
                        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) horRankCard).fG(TiebaInitialize.Params.OBJ_URL, horRankCard.getScheme()).bz("obj_locate", HorRankCardView.this.getStatPosition()).a(horRankCard);
                        v.h(HorRankCardView.this.eXu, horRankCard.getScheme());
                    }
                }
            });
        } else {
            ao.setBackgroundColor(this.kXe, R.color.CAM_X0201);
            this.kXe.setOnClickListener(null);
        }
        com.baidu.tieba.lego.card.model.c rightText = horRankCard.getRightText();
        if (rightText.isValid()) {
            this.lan.setVisibility(8);
            this.lam.setVisibility(0);
            this.lam.setData(rightText, this.eXu);
            return;
        }
        this.lam.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.lan.setVisibility(0);
            ao.setImageResource(this.lan, R.drawable.icon_arrow_tab);
            return;
        }
        this.lan.setVisibility(8);
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ao.setViewTextColor(this.lam, R.color.CAM_X0302);
        } else {
            a(this.lam, cVar.ddD(), cVar.ddF(), R.color.CAM_X0302);
        }
    }
}
