package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.tbadkCore.q;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    private TbImageView Uy;
    private ImageView gJa;
    private MoreButton gKA;
    private View gKy;
    private TextView gKz;
    private LinearLayout gzT;
    private TextView title;

    public SingleLineCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gzT = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_single_line, (ViewGroup) null);
        this.gKy = (View) A(this.gzT, d.g.leftLine);
        this.Uy = (TbImageView) A(this.gzT, d.g.leftIcon);
        this.title = (TextView) A(this.gzT, d.g.title);
        this.gKz = (TextView) A(this.gzT, d.g.title_prefix);
        this.gKA = (MoreButton) A(this.gzT, d.g.more);
        this.gJa = (ImageView) A(this.gzT, d.g.rightIcon);
        return this.gzT;
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            al.j(this.gKA, d.C0236d.cp_link_tip_a);
        } else {
            a(this.gKA, cVar.bzY(), cVar.bAa(), d.C0236d.cp_link_tip_a);
        }
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.title, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), d.C0236d.cp_cont_b);
        }
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.gKz, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), d.C0236d.cp_link_tip_a);
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            this.gKz.setVisibility(0);
            this.gKz.setText(singleLineCard.getIconTitle());
            this.gKz.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
            setPrefixTitleColor(singleLineCard);
        }
    }

    private String a(SingleLineCard singleLineCard) {
        return isNightMode() ? singleLineCard.getIconUrlNight() : singleLineCard.getIconUrl();
    }

    private void setBgColor(SingleLineCard singleLineCard) {
        boolean z = true;
        if (singleLineCard != null) {
            if (isNightMode()) {
                if (!com.baidu.tieba.lego.card.d.a.uP(singleLineCard.getBgColorNight())) {
                    this.gzT.setBackgroundColor(singleLineCard.getBgColorNight());
                }
                z = false;
            } else {
                if (!com.baidu.tieba.lego.card.d.a.uP(singleLineCard.getBgColor())) {
                    this.gzT.setBackgroundColor(singleLineCard.getBgColor());
                }
                z = false;
            }
            if (!z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    al.l(this.gzT, d.C0236d.cp_bg_line_d);
                } else {
                    al.k(this.gzT, d.f.addresslist_item_bg);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(SingleLineCard singleLineCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.l(this.gKy, d.C0236d.cp_other_b);
        if (singleLineCard != null) {
            setBgColor(singleLineCard);
            setTitleColor(singleLineCard);
            setMoreColor(singleLineCard.getButtonInfo());
            setPrefixTitleColor(singleLineCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final SingleLineCard singleLineCard) {
        int h = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds80);
        ViewGroup.LayoutParams layoutParams = this.gzT.getLayoutParams();
        if (singleLineCard.getMaxLines() > 1) {
            layoutParams.height = -2;
            this.gzT.setMinimumHeight(h);
        } else if (singleLineCard.getHeight() > 0) {
            layoutParams.height = com.baidu.adp.lib.util.l.dip2px(getContext(), singleLineCard.getHeight());
            this.gzT.setMinimumHeight(layoutParams.height);
        } else {
            layoutParams.height = h;
            this.gzT.setMinimumHeight(layoutParams.height);
        }
        this.gzT.setLayoutParams(layoutParams);
        if (singleLineCard.isShowLeftIcon()) {
            this.Uy.setVisibility(0);
            if (!TextUtils.isEmpty(a(singleLineCard))) {
                this.Uy.setImageDrawable(null);
                this.Uy.startLoad(a(singleLineCard), 10, false);
            } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                this.Uy.setVisibility(8);
                setPrefixTitle(singleLineCard);
            } else {
                this.gKz.setVisibility(8);
                al.c(this.Uy, com.baidu.tieba.lego.card.f.hu(singleLineCard.getIconType()));
            }
        } else {
            this.gKz.setVisibility(8);
            this.Uy.setVisibility(8);
        }
        if (singleLineCard.isShowLeftLine()) {
            this.gKy.setVisibility(0);
        } else {
            this.gKy.setVisibility(8);
        }
        setBgColor(singleLineCard);
        setTitleColor(singleLineCard);
        setMoreColor(singleLineCard.getButtonInfo());
        this.title.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        if (singleLineCard.getMaxLines() > 1) {
            this.title.setSingleLine(false);
            this.title.setMaxLines(singleLineCard.getMaxLines());
        } else {
            this.title.setSingleLine(true);
        }
        this.title.setText(singleLineCard.getCardTitle());
        SpannableString a = a(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
        if (a != null) {
            this.title.setText(a);
        }
        if (singleLineCard.getGravity() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.title.getLayoutParams();
            layoutParams2.weight = 0.0f;
            layoutParams2.width = -2;
            this.title.setLayoutParams(layoutParams2);
            this.gzT.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.title.getLayoutParams();
            layoutParams3.weight = 1.0f;
            layoutParams3.width = 0;
            this.title.setLayoutParams(layoutParams3);
            this.gzT.setGravity(0);
        }
        if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.SingleLineCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tieba.lego.i.a((BaseLegoCardInfo) singleLineCard).di("obj_url", singleLineCard.getScheme()).bb("obj_locate", SingleLineCardView.this.getStatPosition()).a(singleLineCard);
                    q.f(SingleLineCardView.this.mContext, singleLineCard.getScheme());
                }
            });
            this.gJa.setVisibility(0);
            al.c(this.gJa, d.f.icon_arrow_tab);
        } else {
            setOnClickListener(null);
            this.gJa.setVisibility(8);
        }
        com.baidu.tieba.lego.card.model.c buttonInfo = singleLineCard.getButtonInfo();
        if (buttonInfo.isValid()) {
            this.gKA.setVisibility(0);
            this.gJa.setVisibility(8);
            this.gKA.setData(buttonInfo, this.mContext);
            return;
        }
        this.gKA.setVisibility(8);
    }
}
