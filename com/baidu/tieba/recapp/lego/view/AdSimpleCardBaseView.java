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
    private AdCard kxc;
    protected TextView kxg;
    protected View mRootView;
    protected ViewStub muL;
    protected View muM;
    private AdCloseView mve;
    private LinearLayout mvf;
    protected TextView mvh;
    private FrameLayout mvq;

    protected abstract void a(AdCard adCard);

    protected abstract void dD(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZo() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.muL = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.muL.setLayoutResource(getCustomLayout());
        this.muM = this.muL.inflate();
        dD(this.muM);
        this.kxg = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mvh = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mvq = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mvf = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mve = (AdCloseView) this.mvf.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.kxc = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.kxg.setText(str);
                this.kxg.setVisibility(0);
            } else {
                this.kxg.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mvh.setText(str2 + "广告");
            dE(this.mvf);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            j(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mve.onChangeSkinType();
        ap.setViewTextColor(this.kxg, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mvh, R.color.cp_cont_d, 1, i);
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eyX != null && advertAppInfo.eyX.adCloseInfo != null && advertAppInfo.eyX.adCloseInfo.support_close.intValue() > 0) {
            this.mve.setVisibility(0);
            this.mve.setPage(getBusinessType());
            this.mve.setData(advertAppInfo);
            l.addToParentArea(this.eIc.getPageActivity(), this.mvf, 40, 40, 40, 120);
            this.mvf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mve.performClick();
                }
            });
            return;
        }
        this.mve.setVisibility(8);
    }

    private void dE(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mvq.setVisibility(0);
            this.mvq.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mvq.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdCard mvD;

        public a(AdCard adCard) {
            this.mvD = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eIc.showToast(R.string.neterror);
            } else if (this.mvD != null) {
                h(this.mvD.getAdvertAppInfo());
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mvD.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eyQ;
            }
            int h = s.h(AdSimpleCardBaseView.this.eIc, AdSimpleCardBaseView.this.Ry(scheme));
            if (AdSimpleCardBaseView.this.kFA != null) {
                AdSimpleCardBaseView.this.kFA.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ry(String str) {
        if (this.kxc != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.kxc.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.kxc.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.kxc.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.kxc.getNextPageData()));
            }
            if (this.kxc.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.kxc.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.kxc.isImmersiveStyle()) {
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
