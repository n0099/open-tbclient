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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
/* loaded from: classes20.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected TextView jsj;
    private AdCloseView lnM;
    private LinearLayout lnN;
    protected TextView lnP;
    private AdCard lnT;
    private FrameLayout lnZ;
    protected ViewStub lnt;
    protected View lnu;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void de(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.lnt = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lnt.setLayoutResource(getCustomLayout());
        this.lnu = this.lnt.inflate();
        de(this.lnu);
        this.jsj = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.lnP = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lnZ = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.lnN = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lnM = (AdCloseView) this.lnN.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.lnT = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.jsj.setText(Mu(str));
                this.jsj.setVisibility(0);
            } else {
                this.jsj.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.lnP.setText(str2 + "广告");
            df(this.lnN);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            k(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.lnM.onChangeSkinType();
        ao.setViewTextColor(this.jsj, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.lnP, R.color.cp_cont_d, 1, i);
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.dNf != null && advertAppInfo.dNf.adCloseInfo != null && advertAppInfo.dNf.adCloseInfo.support_close.intValue() > 0) {
            this.lnM.setVisibility(0);
            this.lnM.setPage(getBusinessType());
            this.lnM.setData(advertAppInfo);
            l.addToParentArea(this.dVN.getPageActivity(), this.lnN, 40, 40, 40, 120);
            this.lnN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.lnM.performClick();
                }
            });
            return;
        }
        this.lnM.setVisibility(8);
    }

    private void df(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.lnZ.setVisibility(0);
            this.lnZ.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.lnZ.addView(view);
        }
    }

    protected String Mu(String str) {
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
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private AdCard lop;

        public a(AdCard adCard) {
            this.lop = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.dVN.showToast(R.string.neterror);
            } else if (this.lop != null) {
                i(this.lop.getAdvertAppInfo());
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.lop.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dMY;
            }
            int h = s.h(AdSimpleCardBaseView.this.dVN, AdSimpleCardBaseView.this.Mw(scheme));
            if (AdSimpleCardBaseView.this.jzQ != null) {
                AdSimpleCardBaseView.this.jzQ.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Mw(String str) {
        if (this.lnT != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.lnT.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.lnT.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.lnT.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.lnT.getNextPageData()));
            }
            if (this.lnT.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.lnT.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.lnT.isImmersiveStyle()) {
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
