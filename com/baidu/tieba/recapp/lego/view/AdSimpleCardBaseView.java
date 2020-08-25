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
/* loaded from: classes20.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    private AdCard jHb;
    protected TextView jHf;
    protected ViewStub lDT;
    protected View lDU;
    private AdCloseView lEm;
    private LinearLayout lEn;
    protected TextView lEp;
    private FrameLayout lEy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void di(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMp() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.lDT = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lDT.setLayoutResource(getCustomLayout());
        this.lDU = this.lDT.inflate();
        di(this.lDU);
        this.jHf = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.lEp = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lEy = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.lEn = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lEm = (AdCloseView) this.lEn.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.jHb = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.jHf.setText(Ps(str));
                this.jHf.setVisibility(0);
            } else {
                this.jHf.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.lEp.setText(str2 + "广告");
            dj(this.lEn);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            j(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.lEm.onChangeSkinType();
        ap.setViewTextColor(this.jHf, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lEp, R.color.cp_cont_d, 1, i);
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.dWo != null && advertAppInfo.dWo.adCloseInfo != null && advertAppInfo.dWo.adCloseInfo.support_close.intValue() > 0) {
            this.lEm.setVisibility(0);
            this.lEm.setPage(getBusinessType());
            this.lEm.setData(advertAppInfo);
            l.addToParentArea(this.efn.getPageActivity(), this.lEn, 40, 40, 40, 120);
            this.lEn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.lEm.performClick();
                }
            });
            return;
        }
        this.lEm.setVisibility(8);
    }

    private void dj(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.lEy.setVisibility(0);
            this.lEy.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.lEy.addView(view);
        }
    }

    protected String Ps(String str) {
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
        private AdCard lEL;

        public a(AdCard adCard) {
            this.lEL = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.efn.showToast(R.string.neterror);
            } else if (this.lEL != null) {
                h(this.lEL.getAdvertAppInfo());
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.lEL.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dWh;
            }
            int h = s.h(AdSimpleCardBaseView.this.efn, AdSimpleCardBaseView.this.Pu(scheme));
            if (AdSimpleCardBaseView.this.jPk != null) {
                AdSimpleCardBaseView.this.jPk.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Pu(String str) {
        if (this.jHb != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.jHb.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.jHb.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.jHb.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.jHb.getNextPageData()));
            }
            if (this.jHb.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.jHb.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.jHb.isImmersiveStyle()) {
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
