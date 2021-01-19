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
/* loaded from: classes8.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    private TbImageView abG;
    private LinearLayout kOc;
    private ImageView kVI;
    private View kXe;
    private TextView kXf;
    private MoreButton kXg;
    private TextView title;

    public SingleLineCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.kOc = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_single_line, (ViewGroup) null);
        this.kXe = (View) z(this.kOc, R.id.leftLine);
        this.abG = (TbImageView) z(this.kOc, R.id.leftIcon);
        this.title = (TextView) z(this.kOc, R.id.title);
        this.kXf = (TextView) z(this.kOc, R.id.title_prefix);
        this.kXg = (MoreButton) z(this.kOc, R.id.more);
        this.kVI = (ImageView) z(this.kOc, R.id.rightIcon);
        return this.kOc;
    }

    private void setMoreColor(com.baidu.tieba.lego.card.model.c cVar) {
        if (cVar == null) {
            ao.setViewTextColor(this.kXg, R.color.CAM_X0302);
        } else {
            a(this.kXg, cVar.cZL(), cVar.cZN(), R.color.CAM_X0302);
        }
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.title, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
        }
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            a(this.kXf, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        if (singleLineCard != null) {
            this.kXf.setVisibility(0);
            this.kXf.setText(singleLineCard.getIconTitle());
            this.kXf.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
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
                if (!com.baidu.tieba.lego.card.c.b.DB(singleLineCard.getBgColorNight())) {
                    this.kOc.setBackgroundColor(singleLineCard.getBgColorNight());
                }
                z = false;
            } else {
                if (!com.baidu.tieba.lego.card.c.b.DB(singleLineCard.getBgColor())) {
                    this.kOc.setBackgroundColor(singleLineCard.getBgColor());
                }
                z = false;
            }
            if (!z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    ao.setBackgroundColor(this.kOc, R.color.CAM_X0201);
                } else {
                    ao.setBackgroundResource(this.kOc, R.drawable.addresslist_item_bg);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(SingleLineCard singleLineCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        ao.setBackgroundColor(this.kXe, R.color.CAM_X0308);
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
        ViewGroup.LayoutParams layoutParams = this.kOc.getLayoutParams();
        if (singleLineCard.getMaxLines() > 1) {
            layoutParams.height = -2;
            this.kOc.setMinimumHeight(dimens);
        } else if (singleLineCard.getHeight() > 0) {
            layoutParams.height = com.baidu.adp.lib.util.l.dip2px(getContext(), singleLineCard.getHeight());
            this.kOc.setMinimumHeight(layoutParams.height);
        } else {
            layoutParams.height = dimens;
            this.kOc.setMinimumHeight(layoutParams.height);
        }
        this.kOc.setLayoutParams(layoutParams);
        if (singleLineCard.isShowLeftIcon()) {
            this.abG.setVisibility(0);
            if (!TextUtils.isEmpty(a(singleLineCard))) {
                this.abG.setImageDrawable(null);
                this.abG.startLoad(a(singleLineCard), 10, false);
            } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                this.abG.setVisibility(8);
                setPrefixTitle(singleLineCard);
            } else {
                this.kXf.setVisibility(8);
                ao.setImageResource(this.abG, com.baidu.tieba.lego.card.f.ov(singleLineCard.getIconType()));
            }
        } else {
            this.kXf.setVisibility(8);
            this.abG.setVisibility(8);
        }
        if (singleLineCard.isShowLeftLine()) {
            this.kXe.setVisibility(0);
        } else {
            this.kXe.setVisibility(8);
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
            this.kOc.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.title.getLayoutParams();
            layoutParams3.weight = 1.0f;
            layoutParams3.width = 0;
            this.title.setLayoutParams(layoutParams3);
            this.kOc.setGravity(0);
        }
        if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.SingleLineCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tieba.lego.i.a((BaseLegoCardInfo) singleLineCard).fF(TiebaInitialize.Params.OBJ_URL, singleLineCard.getScheme()).bA("obj_locate", SingleLineCardView.this.getStatPosition()).a(singleLineCard);
                    v.h(SingleLineCardView.this.eSJ, singleLineCard.getScheme());
                }
            });
            this.kVI.setVisibility(0);
            ao.setImageResource(this.kVI, R.drawable.icon_arrow_tab);
        } else {
            setOnClickListener(null);
            this.kVI.setVisibility(8);
        }
        com.baidu.tieba.lego.card.model.c buttonInfo = singleLineCard.getButtonInfo();
        if (buttonInfo.isValid()) {
            this.kXg.setVisibility(0);
            this.kVI.setVisibility(8);
            this.kXg.setData(buttonInfo, this.eSJ);
            return;
        }
        this.kXg.setVisibility(8);
    }
}
