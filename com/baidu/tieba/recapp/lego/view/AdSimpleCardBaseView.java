package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes25.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    private AdCard jPJ;
    protected TextView jPN;
    protected ViewStub lMY;
    protected View lMZ;
    private FrameLayout lND;
    private AdCloseView lNr;
    private LinearLayout lNs;
    protected TextView lNu;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void dq(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cPW() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.lMY = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lMY.setLayoutResource(getCustomLayout());
        this.lMZ = this.lMY.inflate();
        dq(this.lMZ);
        this.jPN = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.lNu = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lND = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.lNs = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lNr = (AdCloseView) this.lNs.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.jPJ = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.jPN.setText(PT(str));
                this.jPN.setVisibility(0);
            } else {
                this.jPN.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.lNu.setText(str2 + "广告");
            dr(this.lNs);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            j(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.lNr.onChangeSkinType();
        ap.setViewTextColor(this.jPN, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lNu, R.color.cp_cont_d, 1, i);
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.dYC != null && advertAppInfo.dYC.adCloseInfo != null && advertAppInfo.dYC.adCloseInfo.support_close.intValue() > 0) {
            this.lNr.setVisibility(0);
            this.lNr.setPage(getBusinessType());
            this.lNr.setData(advertAppInfo);
            l.addToParentArea(this.ehG.getPageActivity(), this.lNs, 40, 40, 40, 120);
            this.lNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.lNr.performClick();
                }
            });
            return;
        }
        this.lNr.setVisibility(8);
    }

    private void dr(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.lND.setVisibility(0);
            this.lND.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.lND.addView(view);
        }
    }

    protected String PT(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a implements View.OnClickListener {
        private AdCard lNQ;

        public a(AdCard adCard) {
            this.lNQ = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.ehG.showToast(R.string.neterror);
            } else if (this.lNQ != null) {
                h(this.lNQ.getAdvertAppInfo());
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.lNQ.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dYv;
            }
            int h = s.h(AdSimpleCardBaseView.this.ehG, AdSimpleCardBaseView.this.PV(scheme));
            if (AdSimpleCardBaseView.this.jXT != null) {
                AdSimpleCardBaseView.this.jXT.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String PV(String str) {
        if (this.jPJ != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.jPJ.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.jPJ.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.jPJ.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.jPJ.getNextPageData()));
            }
            if (this.jPJ.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.jPJ.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.jPJ.isImmersiveStyle()) {
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
