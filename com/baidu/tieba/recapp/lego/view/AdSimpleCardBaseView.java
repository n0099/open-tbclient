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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
/* loaded from: classes25.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected View mRootView;
    private AdCard mvE;
    private FrameLayout mvK;
    protected ViewStub mvc;
    protected View mvd;
    protected TextView mvu;
    private AdCloseView mvx;
    private LinearLayout mvy;
    protected TextView mwD;

    protected abstract void a(AdCard adCard);

    protected abstract void dH(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cYK() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mvc = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mvc.setLayoutResource(getCustomLayout());
        this.mvd = this.mvc.inflate();
        dH(this.mvd);
        this.mvu = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mwD = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mvK = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mvy = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mvx = (AdCloseView) this.mvy.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mvE = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mvu.setText(str);
                this.mvu.setVisibility(0);
            } else {
                this.mvu.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mwD.setText(str2 + "广告");
            dK(this.mvy);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            j(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mvx.onChangeSkinType();
        ap.setViewTextColor(this.mvu, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mwD, R.color.CAM_X0109, 1, i);
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.exl != null && advertAppInfo.exl.adCloseInfo != null && advertAppInfo.exl.adCloseInfo.support_close.intValue() > 0) {
            this.mvx.setVisibility(0);
            this.mvx.setPage(getBusinessType());
            this.mvx.setData(advertAppInfo);
            l.addToParentArea(this.eGu.getPageActivity(), this.mvy, 40, 40, 40, 120);
            this.mvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mvx.performClick();
                }
            });
            return;
        }
        this.mvx.setVisibility(8);
    }

    private void dK(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mvK.setVisibility(0);
            this.mvK.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mvK.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a implements View.OnClickListener {
        private AdCard mvY;

        public a(AdCard adCard) {
            this.mvY = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eGu.showToast(R.string.neterror);
            } else if (this.mvY != null) {
                h(this.mvY.getAdvertAppInfo());
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mvY.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.exe;
            }
            int h = r.h(AdSimpleCardBaseView.this.eGu, AdSimpleCardBaseView.this.QT(scheme));
            if (AdSimpleCardBaseView.this.kFP != null) {
                AdSimpleCardBaseView.this.kFP.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String QT(String str) {
        if (this.mvE != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.mvE.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.mvE.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.mvE.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.mvE.getNextPageData()));
            }
            if (this.mvE.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.mvE.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.mvE.isImmersiveStyle()) {
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
