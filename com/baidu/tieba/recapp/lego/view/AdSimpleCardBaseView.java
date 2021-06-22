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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.t2.y;
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
        public AdCard f20341e;

        public b(AdCard adCard) {
            this.f20341e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo) {
            int d2 = y.d(AdSimpleCardBaseView.this.m.getPageActivity(), this.f20341e.getScheme(), this.f20341e.getDownloadId(), this.f20341e.getExtInfo());
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
            AdCard adCard = this.f20341e;
            if (adCard == null) {
                return;
            }
            a(adCard.getAdvertAppInfo());
        }
    }

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public final void N(View view) {
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

    public abstract void O(AdCard adCard);

    public final void P(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
            this.y.setVisibility(0);
            this.y.setPage(getBusinessType());
            this.y.setData(advertAppInfo, adCard.closeInfo);
            l.c(this.m.getPageActivity(), this.x, 40, 40, 40, 120);
            this.x.setOnClickListener(new a());
            return;
        }
        this.y.setVisibility(8);
    }

    public abstract void Q(View view);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: R */
    public void w(AdCard adCard, int i2) {
        this.y.onChangeSkinType();
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109, 1, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: S */
    public void x(AdCard adCard) {
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
        N(this.x);
        w(adCard, TbadkCoreApplication.getInst().getSkinType());
        O(adCard);
        P(adCard.getAdvertAppInfo(), adCard);
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View t() {
        View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.r = inflate;
        ViewStub viewStub = (ViewStub) inflate.findViewById(R.id.ad_custom_view_stub);
        this.s = viewStub;
        viewStub.setLayoutResource(getCustomLayout());
        View inflate2 = this.s.inflate();
        this.t = inflate2;
        Q(inflate2);
        this.u = (TextView) this.r.findViewById(R.id.ad_title);
        this.v = (TextView) this.r.findViewById(R.id.advert_app_name);
        this.w = (FrameLayout) this.r.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.x = linearLayout;
        this.y = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
        return this.r;
    }
}
