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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.view.MoreButton;
import d.b.b.e.p.l;
import d.b.i0.c3.v;
import d.b.i0.i1.i;
import d.b.i0.i1.o.f;
import d.b.i0.i1.o.j.c;
import d.b.i0.i1.o.k.b;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class SingleLineCardView extends BaseCardView<SingleLineCard> {
    public LinearLayout r;
    public View s;
    public TbImageView t;
    public TextView u;
    public TextView v;
    public MoreButton w;
    public ImageView x;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SingleLineCard f18691e;

        public a(SingleLineCard singleLineCard) {
            this.f18691e = singleLineCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.e(this.f18691e).a(TiebaStatic.Params.OBJ_URL, this.f18691e.getScheme()).c("obj_locate", SingleLineCardView.this.getStatPosition()).b(this.f18691e);
            v.c(SingleLineCardView.this.m, this.f18691e.getScheme());
        }
    }

    public SingleLineCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBgColor(SingleLineCard singleLineCard) {
        if (singleLineCard == null) {
            return;
        }
        boolean z = false;
        if (w()) {
            if (!b.a(singleLineCard.getBgColorNight())) {
                this.r.setBackgroundColor(singleLineCard.getBgColorNight());
                z = true;
            }
            if (z) {
                if (TextUtils.isEmpty(singleLineCard.getScheme())) {
                    SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
                    return;
                } else {
                    SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
                    return;
                }
            }
            return;
        }
        if (!b.a(singleLineCard.getBgColor())) {
            this.r.setBackgroundColor(singleLineCard.getBgColor());
            z = true;
        }
        if (z) {
        }
    }

    private void setMoreColor(c cVar) {
        if (cVar == null) {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
        } else {
            F(this.w, cVar.b(), cVar.c(), R.color.CAM_X0302);
        }
    }

    private void setPrefixTitle(SingleLineCard singleLineCard) {
        if (singleLineCard == null) {
            return;
        }
        this.v.setVisibility(0);
        this.v.setText(singleLineCard.getIconTitle());
        this.v.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        setPrefixTitleColor(singleLineCard);
    }

    private void setPrefixTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard == null) {
            return;
        }
        F(this.v, singleLineCard.getIconTitleColor(), singleLineCard.getIconTitleColorNight(), R.color.CAM_X0302);
    }

    private void setTitleColor(SingleLineCard singleLineCard) {
        if (singleLineCard == null) {
            return;
        }
        F(this.u, singleLineCard.getTitleColor(), singleLineCard.getTitleColorNight(), R.color.CAM_X0105);
    }

    public final String K(SingleLineCard singleLineCard) {
        return w() ? singleLineCard.getIconUrlNight() : singleLineCard.getIconUrl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void y(SingleLineCard singleLineCard, int i) {
        d.b.h0.s0.a.a(this.m, getRootView());
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0308);
        if (singleLineCard != null) {
            setBgColor(singleLineCard);
            setTitleColor(singleLineCard);
            setMoreColor(singleLineCard.getButtonInfo());
            setPrefixTitleColor(singleLineCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void z(SingleLineCard singleLineCard) {
        int g2 = l.g(getContext(), R.dimen.ds80);
        ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
        if (singleLineCard.getMaxLines() > 1) {
            layoutParams.height = -2;
            this.r.setMinimumHeight(g2);
        } else if (singleLineCard.getHeight() > 0) {
            int e2 = l.e(getContext(), singleLineCard.getHeight());
            layoutParams.height = e2;
            this.r.setMinimumHeight(e2);
        } else {
            layoutParams.height = g2;
            this.r.setMinimumHeight(g2);
        }
        this.r.setLayoutParams(layoutParams);
        if (singleLineCard.isShowLeftIcon()) {
            this.t.setVisibility(0);
            if (!TextUtils.isEmpty(K(singleLineCard))) {
                this.t.setImageDrawable(null);
                this.t.W(K(singleLineCard), 10, false);
            } else if (!TextUtils.isEmpty(singleLineCard.getIconTitle())) {
                this.t.setVisibility(8);
                setPrefixTitle(singleLineCard);
            } else {
                this.v.setVisibility(8);
                SkinManager.setImageResource(this.t, f.a(singleLineCard.getIconType()));
            }
        } else {
            this.v.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (singleLineCard.isShowLeftLine()) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
        setBgColor(singleLineCard);
        setTitleColor(singleLineCard);
        setMoreColor(singleLineCard.getButtonInfo());
        this.u.setTextSize(0, getResources().getDisplayMetrics().density * (singleLineCard.getTextSize() / 2.0f));
        if (singleLineCard.getMaxLines() > 1) {
            this.u.setSingleLine(false);
            this.u.setMaxLines(singleLineCard.getMaxLines());
        } else {
            this.u.setSingleLine(true);
        }
        this.u.setText(singleLineCard.getCardTitle());
        SpannableString n = n(singleLineCard.getCardTitle(), singleLineCard.getParams(), singleLineCard.getParamColor(), singleLineCard.getParamColorNight());
        if (n != null) {
            this.u.setText(n);
        }
        if (singleLineCard.getGravity() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.u.getLayoutParams();
            layoutParams2.weight = 0.0f;
            layoutParams2.width = -2;
            this.u.setLayoutParams(layoutParams2);
            this.r.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.u.getLayoutParams();
            layoutParams3.weight = 1.0f;
            layoutParams3.width = 0;
            this.u.setLayoutParams(layoutParams3);
            this.r.setGravity(0);
        }
        if (!TextUtils.isEmpty(singleLineCard.getScheme())) {
            setOnClickListener(new a(singleLineCard));
            this.x.setVisibility(0);
            SkinManager.setImageResource(this.x, R.drawable.icon_arrow_tab);
        } else {
            setOnClickListener(null);
            this.x.setVisibility(8);
        }
        c buttonInfo = singleLineCard.getButtonInfo();
        if (buttonInfo.f()) {
            this.w.setVisibility(0);
            this.x.setVisibility(8);
            this.w.setData(buttonInfo, this.m);
            return;
        }
        this.w.setVisibility(8);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_single_line, (ViewGroup) null);
        this.r = linearLayout;
        this.s = (View) o(linearLayout, R.id.leftLine);
        this.t = (TbImageView) o(this.r, R.id.leftIcon);
        this.u = (TextView) o(this.r, R.id.title);
        this.v = (TextView) o(this.r, R.id.title_prefix);
        this.w = (MoreButton) o(this.r, R.id.more);
        this.x = (ImageView) o(this.r, R.id.rightIcon);
        return this.r;
    }
}
