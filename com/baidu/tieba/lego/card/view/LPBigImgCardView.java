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
import d.a.c.e.p.l;
import d.a.j0.s2.w;
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
        public final /* synthetic */ LPBigImgCard f18699e;

        public a(LPBigImgCard lPBigImgCard) {
            this.f18699e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(LPBigImgCardView.this.m, new String[]{this.f18699e.getBtnLink()});
            w.p().m().c(this.f18699e.getsExtras(), LPBigImgCardView.this.f18681e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LPBigImgCard f18701e;

        public b(LPBigImgCard lPBigImgCard) {
            this.f18701e = lPBigImgCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(LPBigImgCardView.this.m, new String[]{this.f18701e.getBtnLink()});
            w.p().m().c(this.f18701e.getsExtras(), LPBigImgCardView.this.f18681e);
        }
    }

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.w = l.k(getContext());
    }

    public final int J(int i2) {
        return l.e(this.m.getPageActivity(), (int) (i2 / 2.0d));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void x(LPBigImgCard lPBigImgCard, int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void y(LPBigImgCard lPBigImgCard) {
        if (lPBigImgCard.getPicWidth() <= 0 || lPBigImgCard.getPicHeight() <= 0) {
            return;
        }
        int picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.w);
        this.v = picHeight;
        M(this.s, picHeight);
        if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
            this.s.R(lPBigImgCard.getPicUrl(), 17, this.w, this.v, false);
        } else {
            B(this.s, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
        }
        int i2 = this.v;
        if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight = lPBigImgCard.getBtnHeight();
            N(this.t, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            this.t.V(lPBigImgCard.getBtnImgUrl(), 17, false);
            int btnPosRatio = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
            if (btnPosRatio < 0) {
                btnPosRatio = 0;
            } else {
                int i3 = i2 - btnHeight;
                if (btnPosRatio > i3) {
                    btnPosRatio = i3;
                }
            }
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = btnPosRatio;
            this.t.setOnClickListener(new a(lPBigImgCard));
            this.t.setVisibility(0);
            this.u.setVisibility(8);
        } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
            int btnHeight2 = lPBigImgCard.getBtnHeight();
            this.u.setText(lPBigImgCard.getBtnText());
            N(this.u, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
            F(this.u, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
            int btnPosRatio2 = (int) ((i2 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
            if (btnPosRatio2 < 0) {
                btnPosRatio2 = 0;
            } else {
                int i4 = i2 - btnHeight2;
                if (btnPosRatio2 > i4) {
                    btnPosRatio2 = i4;
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
        w.p().m().d(lPBigImgCard.getShowExtra(), this.f18681e);
        lPBigImgCard.mHasShown = true;
    }

    public final void M(View view, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = this.w;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public final void N(View view, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = J(i3);
        layoutParams.width = J(i2);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
        this.r = relativeLayout;
        this.s = (TbImageView) o(relativeLayout, R.id.tb_img_background);
        this.t = (TbImageView) o(this.r, R.id.tb_img_button);
        this.u = (TextView) o(this.r, R.id.tv_button);
        return this.r;
    }
}
