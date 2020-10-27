package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
/* loaded from: classes26.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    private AdCard krg;
    protected TextView krk;
    protected View mRootView;
    protected ViewStub moO;
    protected View moP;
    private AdCloseView mph;
    private LinearLayout mpi;
    protected TextView mpk;
    private FrameLayout mpt;

    protected abstract void a(AdCard adCard);

    protected abstract void dy(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cWN() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.moO = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.moO.setLayoutResource(getCustomLayout());
        this.moP = this.moO.inflate();
        dy(this.moP);
        this.krk = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mpk = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mpt = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mpi = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mph = (AdCloseView) this.mpi.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.krg = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.krk.setText(str);
                this.krk.setVisibility(0);
            } else {
                this.krk.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mpk.setText(str2 + "广告");
            dz(this.mpi);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            j(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mph.onChangeSkinType();
        ap.setViewTextColor(this.krk, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mpk, R.color.cp_cont_d, 1, i);
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.ete != null && advertAppInfo.ete.adCloseInfo != null && advertAppInfo.ete.adCloseInfo.support_close.intValue() > 0) {
            this.mph.setVisibility(0);
            this.mph.setPage(getBusinessType());
            this.mph.setData(advertAppInfo);
            l.addToParentArea(this.eCn.getPageActivity(), this.mpi, 40, 40, 40, 120);
            this.mpi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mph.performClick();
                }
            });
            return;
        }
        this.mph.setVisibility(8);
    }

    private void dz(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mpt.setVisibility(0);
            this.mpt.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mpt.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdCard mpG;

        public a(AdCard adCard) {
            this.mpG = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eCn.showToast(R.string.neterror);
            } else if (this.mpG != null) {
                h(this.mpG.getAdvertAppInfo());
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mpG.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.esW;
            }
            int h = s.h(AdSimpleCardBaseView.this.eCn, AdSimpleCardBaseView.this.Rh(scheme));
            if (AdSimpleCardBaseView.this.kzG != null) {
                AdSimpleCardBaseView.this.kzG.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Rh(String str) {
        if (this.krg != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.krg.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.krg.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.krg.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.krg.getNextPageData()));
            }
            if (this.krg.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.krg.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.krg.isImmersiveStyle()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_IMMERSIVE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            return sb.toString();
        }
        return str;
    }
}
