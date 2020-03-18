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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
/* loaded from: classes13.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected TextView hST;
    private AdCloseView jJJ;
    private LinearLayout jJK;
    protected TextView jJM;
    private AdCard jJQ;
    private FrameLayout jJW;
    protected ViewStub jJp;
    protected View jJq;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccz() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.jJp = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jJp.setLayoutResource(getCustomLayout());
        this.jJq = this.jJp.inflate();
        cO(this.jJq);
        this.hST = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jJM = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jJW = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.jJK = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jJJ = (AdCloseView) this.jJK.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.jJQ = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.hST.setText(HQ(str));
                this.hST.setVisibility(0);
            } else {
                this.hST.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.jJM.setText(str2 + "广告");
            cP(this.jJK);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            k(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.jJJ.onChangeSkinType();
        am.setViewTextColor(this.hST, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jJM, R.color.cp_cont_d, 1, i);
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.cNt != null && advertAppInfo.cNt.adCloseInfo != null && advertAppInfo.cNt.adCloseInfo.support_close.intValue() > 0) {
            this.jJJ.setVisibility(0);
            this.jJJ.setPage(getBusinessType());
            this.jJJ.setData(advertAppInfo);
            l.addToParentArea(this.cVv.getPageActivity(), this.jJK, 40, 40, 40, 120);
            this.jJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.jJJ.performClick();
                }
            });
            return;
        }
        this.jJJ.setVisibility(8);
    }

    private void cP(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.jJW.setVisibility(0);
            this.jJW.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.jJW.addView(view);
        }
    }

    protected String HQ(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(HanziToPinyin.Token.SEPARATOR, "  ");
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
        private AdCard jKj;

        public a(AdCard adCard) {
            this.jKj = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.cVv.showToast(R.string.neterror);
            } else if (this.jKj != null) {
                i(this.jKj.getAdvertAppInfo());
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jKj.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cNm;
            }
            int e = s.e(AdSimpleCardBaseView.this.cVv, AdSimpleCardBaseView.this.HS(scheme));
            if (AdSimpleCardBaseView.this.iaq != null) {
                AdSimpleCardBaseView.this.iaq.b(e, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String HS(String str) {
        if (this.jJQ != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.jJQ.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.jJQ.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.jJQ.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.jJQ.getNextPageData()));
            }
            if (this.jJQ.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.jJQ.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.jJQ.isImmersiveStyle()) {
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
