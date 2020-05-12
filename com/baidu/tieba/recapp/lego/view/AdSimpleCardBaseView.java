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
    protected TextView iCQ;
    private LinearLayout ktA;
    protected TextView ktC;
    private AdCard ktG;
    private FrameLayout ktM;
    protected ViewStub ktf;
    protected View ktg;
    private AdCloseView ktz;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cW(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cmY() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.ktf = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.ktf.setLayoutResource(getCustomLayout());
        this.ktg = this.ktf.inflate();
        cW(this.ktg);
        this.iCQ = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.ktC = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.ktM = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.ktA = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.ktz = (AdCloseView) this.ktA.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.ktG = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.iCQ.setText(Jy(str));
                this.iCQ.setVisibility(0);
            } else {
                this.iCQ.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.ktC.setText(str2 + "广告");
            cX(this.ktA);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            k(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.ktz.onChangeSkinType();
        am.setViewTextColor(this.iCQ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.ktC, R.color.cp_cont_d, 1, i);
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.dmB != null && advertAppInfo.dmB.adCloseInfo != null && advertAppInfo.dmB.adCloseInfo.support_close.intValue() > 0) {
            this.ktz.setVisibility(0);
            this.ktz.setPage(getBusinessType());
            this.ktz.setData(advertAppInfo);
            l.addToParentArea(this.duK.getPageActivity(), this.ktA, 40, 40, 40, 120);
            this.ktA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.ktz.performClick();
                }
            });
            return;
        }
        this.ktz.setVisibility(8);
    }

    private void cX(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.ktM.setVisibility(0);
            this.ktM.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.ktM.addView(view);
        }
    }

    protected String Jy(String str) {
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
        private AdCard kua;

        public a(AdCard adCard) {
            this.kua = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.duK.showToast(R.string.neterror);
            } else if (this.kua != null) {
                i(this.kua.getAdvertAppInfo());
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.kua.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dmu;
            }
            int f = r.f(AdSimpleCardBaseView.this.duK, AdSimpleCardBaseView.this.JA(scheme));
            if (AdSimpleCardBaseView.this.iKo != null) {
                AdSimpleCardBaseView.this.iKo.d(f, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JA(String str) {
        if (this.ktG != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.ktG.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.ktG.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.ktG.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.ktG.getNextPageData()));
            }
            if (this.ktG.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.ktG.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.ktG.isImmersiveStyle()) {
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
