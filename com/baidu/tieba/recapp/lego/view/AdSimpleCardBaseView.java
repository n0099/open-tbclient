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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
/* loaded from: classes13.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected TextView iSq;
    private AdCloseView kMB;
    private LinearLayout kMC;
    protected TextView kME;
    private AdCard kMI;
    private FrameLayout kMO;
    protected ViewStub kMi;
    protected View kMj;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cX(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctJ() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.kMi = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.kMi.setLayoutResource(getCustomLayout());
        this.kMj = this.kMi.inflate();
        cX(this.kMj);
        this.iSq = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.kME = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.kMO = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.kMC = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kMB = (AdCloseView) this.kMC.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.kMI = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.iSq.setText(Ll(str));
                this.iSq.setVisibility(0);
            } else {
                this.iSq.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.kME.setText(str2 + "广告");
            cY(this.kMC);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            k(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.kMB.onChangeSkinType();
        am.setViewTextColor(this.iSq, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kME, R.color.cp_cont_d, 1, i);
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kMB.setVisibility(0);
            this.kMB.setPage(getBusinessType());
            this.kMB.setData(advertAppInfo);
            l.addToParentArea(this.dIF.getPageActivity(), this.kMC, 40, 40, 40, 120);
            this.kMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.kMB.performClick();
                }
            });
            return;
        }
        this.kMB.setVisibility(8);
    }

    private void cY(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.kMO.setVisibility(0);
            this.kMO.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.kMO.addView(view);
        }
    }

    protected String Ll(String str) {
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
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        private AdCard kNc;

        public a(AdCard adCard) {
            this.kNc = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.dIF.showToast(R.string.neterror);
            } else if (this.kNc != null) {
                i(this.kNc.getAdvertAppInfo());
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.kNc.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dAw;
            }
            int f = r.f(AdSimpleCardBaseView.this.dIF, AdSimpleCardBaseView.this.Ln(scheme));
            if (AdSimpleCardBaseView.this.jab != null) {
                AdSimpleCardBaseView.this.jab.d(f, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ln(String str) {
        if (this.kMI != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.kMI.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.kMI.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.kMI.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.kMI.getNextPageData()));
            }
            if (this.kMI.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.kMI.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.kMI.isImmersiveStyle()) {
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
