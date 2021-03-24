package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import d.b.b.e.p.l;
import d.b.i0.r2.s;
/* loaded from: classes4.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    public RelativeLayout r;
    public TbImageView s;
    public TbImageView t;
    public TextView u;
    public int v;
    public final int w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f18653e;

        public a(LPBigImgCard lPBigImgCard) {
            this.f18653e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(LPBigImgCardView.this.m, new String[]{this.f18653e.getBtnLink()});
            s.o().j().a(this.f18653e.getsExtras(), LPBigImgCardView.this.f18636e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f18655e;

        public b(LPBigImgCard lPBigImgCard) {
            this.f18655e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(LPBigImgCardView.this.m, new String[]{this.f18655e.getBtnLink()});
            s.o().j().a(this.f18655e.getsExtras(), LPBigImgCardView.this.f18636e);
        }
    }

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.w = l.k(getContext());
    }

    public final int K(int i) {
        double d2;
        Double.isNaN(i);
        return l.e(this.m.getPageActivity(), (int) (d2 / 2.0d));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void y(LPBigImgCard lPBigImgCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void z(LPBigImgCard lPBigImgCard) {
        if (lPBigImgCard.getPicWidth() <= 0 || lPBigImgCard.getPicHeight() <= 0) {
            return;
        }
        int picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.w);
        this.v = picHeight;
        O(this.s, picHeight);
        if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
            this.s.T(lPBigImgCard.getPicUrl(), 17, this.w, this.v, false);
        } else {
            E(this.s, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
        }
        int i = this.v;
        if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight = lPBigImgCard.getBtnHeight();
            P(this.t, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            this.t.W(lPBigImgCard.getBtnImgUrl(), 17, false);
            double d2 = i;
            double btnPosRatio = lPBigImgCard.getBtnPosRatio();
            Double.isNaN(d2);
            double d3 = d2 * btnPosRatio;
            double d4 = btnHeight;
            Double.isNaN(d4);
            int i2 = (int) (d3 - (d4 * 0.5d));
            if (i2 < 0) {
                i2 = 0;
            } else {
                int i3 = i - btnHeight;
                if (i2 > i3) {
                    i2 = i3;
                }
            }
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = i2;
            this.t.setOnClickListener(new a(lPBigImgCard));
            this.t.setVisibility(0);
            this.u.setVisibility(8);
        } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight2 = lPBigImgCard.getBtnHeight();
            this.u.setText(lPBigImgCard.getBtnText());
            P(this.u, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            F(this.u, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
            double d5 = i;
            double btnPosRatio2 = lPBigImgCard.getBtnPosRatio();
            Double.isNaN(d5);
            double d6 = d5 * btnPosRatio2;
            double d7 = btnHeight2;
            Double.isNaN(d7);
            int i4 = (int) (d6 - (d7 * 0.5d));
            if (i4 < 0) {
                i4 = 0;
            } else {
                int i5 = i - btnHeight2;
                if (i4 > i5) {
                    i4 = i5;
                }
            }
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = i4;
            this.u.setOnClickListener(new b(lPBigImgCard));
            this.u.setVisibility(0);
            this.t.setVisibility(8);
        } else {
            this.u.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (lPBigImgCard.mHasShown) {
            return;
        }
        s.o().j().c(lPBigImgCard.getShowExtra(), this.f18636e);
        lPBigImgCard.mHasShown = true;
    }

    public final void O(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = this.w;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public final void P(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = K(i2);
        layoutParams.width = K(i);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
        this.r = relativeLayout;
        this.s = (TbImageView) o(relativeLayout, R.id.tb_img_background);
        this.t = (TbImageView) o(this.r, R.id.tb_img_button);
        this.u = (TextView) o(this.r, R.id.tv_button);
        return this.r;
    }
}
