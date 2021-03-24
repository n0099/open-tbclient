package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.bumptech.glide.load.engine.GlideException;
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.r2.t;
import tbclient.AdCloseInfo;
/* loaded from: classes5.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    public View r;
    public ViewStub s;
    public View t;
    public TextView u;
    public TextView v;
    public FrameLayout w;
    public LinearLayout x;
    public AdCloseView y;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdSimpleCardBaseView.this.y.performClick();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdCard f20775e;

        public b(AdCard adCard) {
            this.f20775e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo) {
            String scheme = this.f20775e.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.H3;
            }
            int d2 = t.d(AdSimpleCardBaseView.this.m.getPageActivity(), scheme, AdSimpleCardBaseView.this.p(advertAppInfo), advertAppInfo.T3);
            if (AdSimpleCardBaseView.this.o != null) {
                AdSimpleCardBaseView.this.o.a(d2, null);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A()) {
                AdSimpleCardBaseView.this.m.showToast(R.string.neterror);
                return;
            }
            AdCard adCard = this.f20775e;
            if (adCard == null) {
                return;
            }
            a(adCard.getAdvertAppInfo());
        }
    }

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public final void R(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (view.getParent() != null) {
            ((FrameLayout) view.getParent()).removeView(view);
        }
        this.w.setVisibility(0);
        this.w.removeAllViews();
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.w.addView(view);
    }

    public abstract void S(AdCard adCard);

    public final void T(AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.a aVar;
        AdCloseInfo adCloseInfo;
        if (advertAppInfo != null && (aVar = advertAppInfo.U3) != null && (adCloseInfo = aVar.r) != null && adCloseInfo.support_close.intValue() > 0) {
            this.y.setVisibility(0);
            this.y.setPage(getBusinessType());
            this.y.setData(advertAppInfo);
            l.c(this.m.getPageActivity(), this.x, 40, 40, 40, 120);
            this.x.setOnClickListener(new a());
            return;
        }
        this.y.setVisibility(8);
    }

    public abstract void U(View view);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: V */
    public void y(AdCard adCard, int i) {
        this.y.onChangeSkinType();
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109, 1, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: W */
    public void z(AdCard adCard) {
        if (adCard == null) {
            return;
        }
        this.r.setOnClickListener(new b(adCard));
        String str = adCard.threadTitle;
        if (!TextUtils.isEmpty(str)) {
            this.u.setText(str);
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
        String str2 = adCard.userName;
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2 + GlideException.IndentedAppendable.INDENT;
        }
        this.v.setText(str2 + "广告");
        R(this.x);
        y(adCard, TbadkCoreApplication.getInst().getSkinType());
        S(adCard);
        T(adCard.getAdvertAppInfo());
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.r = inflate;
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.ad_custom_view_stub);
        this.s = viewStub;
        viewStub.setLayoutResource(getCustomLayout());
        View inflate2 = this.s.inflate();
        this.t = inflate2;
        U(inflate2);
        this.u = (TextView) this.r.findViewById(R.id.ad_title);
        this.v = (TextView) this.r.findViewById(R.id.advert_app_name);
        this.w = (FrameLayout) this.r.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.x = linearLayout;
        this.y = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
        return this.r;
    }
}
