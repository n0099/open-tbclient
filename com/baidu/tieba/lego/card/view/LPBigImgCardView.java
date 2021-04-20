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
import d.b.c.e.p.l;
import d.b.i0.s2.v;
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
        public final /* synthetic */ LPBigImgCard f18331e;

        public a(LPBigImgCard lPBigImgCard) {
            this.f18331e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(LPBigImgCardView.this.m, new String[]{this.f18331e.getBtnLink()});
            v.p().k().a(this.f18331e.getsExtras(), LPBigImgCardView.this.f18314e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f18333e;

        public b(LPBigImgCard lPBigImgCard) {
            this.f18333e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(LPBigImgCardView.this.m, new String[]{this.f18333e.getBtnLink()});
            v.p().k().a(this.f18333e.getsExtras(), LPBigImgCardView.this.f18314e);
        }
    }

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.w = l.k(getContext());
    }

    public final int K(int i) {
        return l.e(this.m.getPageActivity(), (int) (i / 2.0d));
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
            int btnPosRatio = (int) ((i * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
            if (btnPosRatio < 0) {
                btnPosRatio = 0;
            } else {
                int i2 = i - btnHeight;
                if (btnPosRatio > i2) {
                    btnPosRatio = i2;
                }
            }
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = btnPosRatio;
            this.t.setOnClickListener(new a(lPBigImgCard));
            this.t.setVisibility(0);
            this.u.setVisibility(8);
        } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight2 = lPBigImgCard.getBtnHeight();
            this.u.setText(lPBigImgCard.getBtnText());
            P(this.u, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            F(this.u, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
            int btnPosRatio2 = (int) ((i * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
            if (btnPosRatio2 < 0) {
                btnPosRatio2 = 0;
            } else {
                int i3 = i - btnHeight2;
                if (btnPosRatio2 > i3) {
                    btnPosRatio2 = i3;
                }
            }
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = btnPosRatio2;
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
        v.p().k().c(lPBigImgCard.getShowExtra(), this.f18314e);
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
