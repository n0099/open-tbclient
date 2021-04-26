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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.view.HorizontalScrollListView;
import com.baidu.tieba.lego.view.MoreButton;
import d.a.j0.d3.v;
import d.a.j0.j1.i;
import d.a.j0.j1.o.j.c;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HorRankCardView extends BaseCardView<HorRankCard> {
    public LinearLayout r;
    public HorizontalScrollListView s;
    public RelativeLayout t;
    public View u;
    public TextView v;
    public MoreButton w;
    public ImageView x;
    public ImageView y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard f18695e;

        public a(HorRankCard horRankCard) {
            this.f18695e = horRankCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18695e.getScheme())) {
                return;
            }
            i.e(this.f18695e).d(TiebaStatic.Params.OBJ_URL, this.f18695e.getScheme()).b("obj_locate", HorRankCardView.this.getStatPosition()).a(this.f18695e);
            v.c(HorRankCardView.this.m, this.f18695e.getScheme());
        }
    }

    public HorRankCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    private void setMoreColor(c cVar) {
        if (cVar == null) {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
        } else {
            F(this.w, cVar.b(), cVar.c(), R.color.CAM_X0302);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void x(HorRankCard horRankCard, int i2) {
        d.a.i0.s0.a.a(this.m, getRootView());
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0308);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
        SkinManager.setImageResource(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.t, R.drawable.addresslist_item_bg);
        this.s.i(this.n);
        setMoreColor(horRankCard.getRightText());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void y(HorRankCard horRankCard) {
        List<HorRankCard.a> rankInfoList = horRankCard.getRankInfoList();
        this.u.setVisibility(horRankCard.isShowLeft() ? 0 : 8);
        this.y.setVisibility(horRankCard.isShowSep() ? 0 : 8);
        if (rankInfoList != null && rankInfoList.size() != 0) {
            this.s.setRound(horRankCard.getPicType() == 1);
            this.s.setDisplayNum(horRankCard.getDisplayNum());
            this.s.setRatio(horRankCard.getRatio());
            this.s.setVisibility(0);
            this.s.setHorizontalScrollBarEnabled(horRankCard.isScrollEnabled());
            this.s.setData(rankInfoList, this.m);
        } else {
            this.s.setVisibility(8);
        }
        if (!TextUtils.isEmpty(horRankCard.getCardTitle())) {
            this.v.setVisibility(0);
            F(this.v, horRankCard.getTitleColor(), horRankCard.getTitleColorNight(), R.color.CAM_X0105);
            this.v.setText(horRankCard.getCardTitle());
        } else {
            this.v.setVisibility(8);
        }
        setMoreColor(horRankCard.getRightText());
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
            this.r.setOnClickListener(new a(horRankCard));
        } else {
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            this.r.setOnClickListener(null);
        }
        c rightText = horRankCard.getRightText();
        if (rightText.f()) {
            this.x.setVisibility(8);
            this.w.setVisibility(0);
            this.w.setData(rightText, this.m);
            return;
        }
        this.w.setVisibility(8);
        if (!TextUtils.isEmpty(horRankCard.getScheme())) {
            this.x.setVisibility(0);
            SkinManager.setImageResource(this.x, R.drawable.icon_arrow_tab);
            return;
        }
        this.x.setVisibility(8);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_horizontal, (ViewGroup) null, false);
        this.r = linearLayout;
        this.s = (HorizontalScrollListView) o(linearLayout, R.id.horizontal_view);
        this.t = (RelativeLayout) o(this.r, R.id.rlTop);
        this.u = (View) o(this.r, R.id.left);
        this.v = (TextView) o(this.r, R.id.hor_title);
        this.w = (MoreButton) o(this.r, R.id.right_textview);
        this.x = (ImageView) o(this.r, R.id.rightIcon);
        this.y = (ImageView) o(this.r, R.id.divider);
        return this.r;
    }
}
