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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.view.MoreButton;
import com.baidu.tieba.tbadkCore.v;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    private TbImageView abB;
    private LinearLayout kWf;
    private ImageView ldL;
    private View lfi;
    private TextView lfj;
    private MoreButton lfk;
    private TextView title;

    public SingleLineCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.kWf = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_single_line, (ViewGroup) null);
        this.lfi = (View) z(this.kWf, R.id.leftLine);
        this.abB = (TbImageView) z(this.kWf, R.id.leftIcon);
        this.title = (TextView) z(this.kWf, R.id.title);
        this.lfj = (TextView) z(this.kWf, R.id.title_prefix);
        this.lfk = (MoreButton) z(this.kWf, R.id.more);
        this.ldL = (ImageView) z(this.kWf, R.id.rightIcon);
        return this.kWf;
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ap.setViewTextColor(this.lfk, R.color.CAM_X0302);
        } else {
            a(this.lfk, cVar.dbJ(), cVar.dbL(), R.color.CAM_X0302);
        }
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.title, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
        }
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.lfj, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            this.lfj.setVisibility(0);
            this.lfj.setText(singleLineCard.getIconTitle());
            this.lfj.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
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
                if (!com.baidu.tieba.lego.card.c.b.DT(singleLineCard.getBgColorNight())) {
                    this.kWf.setBackgroundColor(singleLineCard.getBgColorNight());
                }
                z = false;
            } else {
                if (!com.baidu.tieba.lego.card.c.b.DT(singleLineCard.getBgColor())) {
                    this.kWf.setBackgroundColor(singleLineCard.getBgColor());
                }
                z = false;
            }
            if (!z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    ap.setBackgroundColor(this.kWf, R.color.CAM_X0201);
                } else {
                    ap.setBackgroundResource(this.kWf, R.drawable.addresslist_item_bg);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(SingleLineCard singleLineCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundColor(this.lfi, R.color.CAM_X0308);
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
        ViewGroup.LayoutParams layoutParams = this.kWf.getLayoutParams();
        if (singleLineCard.getMaxLines() > 1) {
            layoutParams.height = -2;
            this.kWf.setMinimumHeight(dimens);
        } else if (singleLineCard.getHeight() > 0) {
            layoutParams.height = com.baidu.adp.lib.util.l.dip2px(getContext(), singleLineCard.getHeight());
            this.kWf.setMinimumHeight(layoutParams.height);
        } else {
            layoutParams.height = dimens;
            this.kWf.setMinimumHeight(layoutParams.height);
        }
        this.kWf.setLayoutParams(layoutParams);
        if (singleLineCard.isShowLeftIcon()) {
            this.abB.setVisibility(0);
            if (!TextUtils.isEmpty(a(singleLineCard))) {
                this.abB.setImageDrawable(null);
                this.abB.startLoad(a(singleLineCard), 10, false);
            } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                this.abB.setVisibility(8);
                setPrefixTitle(singleLineCard);
            } else {
                this.lfj.setVisibility(8);
                ap.setImageResource(this.abB, com.baidu.tieba.lego.card.f.oA(singleLineCard.getIconType()));
            }
        } else {
            this.lfj.setVisibility(8);
            this.abB.setVisibility(8);
        }
        if (singleLineCard.isShowLeftLine()) {
            this.lfi.setVisibility(0);
        } else {
            this.lfi.setVisibility(8);
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
            this.kWf.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.title.getLayoutParams();
            layoutParams3.weight = 1.0f;
            layoutParams3.width = 0;
            this.title.setLayoutParams(layoutParams3);
            this.kWf.setGravity(0);
        }
        if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.SingleLineCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tieba.lego.i.a((BaseLegoCardInfo) singleLineCard).fF(TiebaInitialize.Params.OBJ_URL, singleLineCard.getScheme()).bA("obj_locate", SingleLineCardView.this.getStatPosition()).a(singleLineCard);
                    v.j(SingleLineCardView.this.eUY, singleLineCard.getScheme());
                }
            });
            this.ldL.setVisibility(0);
            ap.setImageResource(this.ldL, R.drawable.icon_arrow_tab);
        } else {
            setOnClickListener(null);
            this.ldL.setVisibility(8);
        }
        com.baidu.tieba.lego.card.model.c buttonInfo = singleLineCard.getButtonInfo();
        if (buttonInfo.isValid()) {
            this.lfk.setVisibility(0);
            this.ldL.setVisibility(8);
            this.lfk.setData(buttonInfo, this.eUY);
            return;
        }
        this.lfk.setVisibility(8);
    }
}
