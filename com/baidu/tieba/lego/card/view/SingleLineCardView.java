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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.tbadkCore.v;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    private TbImageView abI;
    private LinearLayout kSH;
    private ImageView lan;
    private View lbK;
    private TextView lbL;
    private MoreButton lbM;
    private TextView title;

    public SingleLineCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.kSH = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_single_line, (ViewGroup) null);
        this.lbK = (View) z(this.kSH, R.id.leftLine);
        this.abI = (TbImageView) z(this.kSH, R.id.leftIcon);
        this.title = (TextView) z(this.kSH, R.id.title);
        this.lbL = (TextView) z(this.kSH, R.id.title_prefix);
        this.lbM = (MoreButton) z(this.kSH, R.id.more);
        this.lan = (ImageView) z(this.kSH, R.id.rightIcon);
        return this.kSH;
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ao.setViewTextColor(this.lbM, R.color.CAM_X0302);
        } else {
            a(this.lbM, cVar.ddD(), cVar.ddF(), R.color.CAM_X0302);
        }
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.title, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
        }
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.lbL, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            this.lbL.setVisibility(0);
            this.lbL.setText(singleLineCard.getIconTitle());
            this.lbL.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
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
                if (!com.baidu.tieba.lego.card.c.b.Fh(singleLineCard.getBgColorNight())) {
                    this.kSH.setBackgroundColor(singleLineCard.getBgColorNight());
                }
                z = false;
            } else {
                if (!com.baidu.tieba.lego.card.c.b.Fh(singleLineCard.getBgColor())) {
                    this.kSH.setBackgroundColor(singleLineCard.getBgColor());
                }
                z = false;
            }
            if (!z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    ao.setBackgroundColor(this.kSH, R.color.CAM_X0201);
                } else {
                    ao.setBackgroundResource(this.kSH, R.drawable.addresslist_item_bg);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(SingleLineCard singleLineCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
        ao.setBackgroundColor(this.lbK, R.color.CAM_X0308);
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
    public void d(final SingleLineCard singleLineCard) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds80);
        ViewGroup.LayoutParams layoutParams = this.kSH.getLayoutParams();
        if (singleLineCard.getMaxLines() > 1) {
            layoutParams.height = -2;
            this.kSH.setMinimumHeight(dimens);
        } else if (singleLineCard.getHeight() > 0) {
            layoutParams.height = com.baidu.adp.lib.util.l.dip2px(getContext(), singleLineCard.getHeight());
            this.kSH.setMinimumHeight(layoutParams.height);
        } else {
            layoutParams.height = dimens;
            this.kSH.setMinimumHeight(layoutParams.height);
        }
        this.kSH.setLayoutParams(layoutParams);
        if (singleLineCard.isShowLeftIcon()) {
            this.abI.setVisibility(0);
            if (!TextUtils.isEmpty(a(singleLineCard))) {
                this.abI.setImageDrawable(null);
                this.abI.startLoad(a(singleLineCard), 10, false);
            } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                this.abI.setVisibility(8);
                setPrefixTitle(singleLineCard);
            } else {
                this.lbL.setVisibility(8);
                ao.setImageResource(this.abI, com.baidu.tieba.lego.card.f.qc(singleLineCard.getIconType()));
            }
        } else {
            this.lbL.setVisibility(8);
            this.abI.setVisibility(8);
        }
        if (singleLineCard.isShowLeftLine()) {
            this.lbK.setVisibility(0);
        } else {
            this.lbK.setVisibility(8);
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
        SpannableString a2 = a(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
        if (a2 != null) {
            this.title.setText(a2);
        }
        if (singleLineCard.getGravity() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.title.getLayoutParams();
            layoutParams2.weight = 0.0f;
            layoutParams2.width = -2;
            this.title.setLayoutParams(layoutParams2);
            this.kSH.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.title.getLayoutParams();
            layoutParams3.weight = 1.0f;
            layoutParams3.width = 0;
            this.title.setLayoutParams(layoutParams3);
            this.kSH.setGravity(0);
        }
        if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.SingleLineCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tieba.lego.i.a((BaseLegoCardInfo) singleLineCard).fG(TiebaInitialize.Params.OBJ_URL, singleLineCard.getScheme()).bz("obj_locate", SingleLineCardView.this.getStatPosition()).a(singleLineCard);
                    v.h(SingleLineCardView.this.eXu, singleLineCard.getScheme());
                }
            });
            this.lan.setVisibility(0);
            ao.setImageResource(this.lan, R.drawable.icon_arrow_tab);
        } else {
            setOnClickListener(null);
            this.lan.setVisibility(8);
        }
        com.baidu.tieba.lego.card.model.c buttonInfo = singleLineCard.getButtonInfo();
        if (buttonInfo.isValid()) {
            this.lbM.setVisibility(0);
            this.lan.setVisibility(8);
            this.lbM.setData(buttonInfo, this.eXu);
            return;
        }
        this.lbM.setVisibility(8);
    }
}
