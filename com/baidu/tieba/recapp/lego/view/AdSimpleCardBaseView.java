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
    protected TextView mJI;
    private AdCloseView mJL;
    private LinearLayout mJM;
    private AdCard mJS;
    private FrameLayout mJY;
    protected ViewStub mJq;
    protected View mJr;
    protected TextView mKR;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void dS(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddW() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mJq = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mJq.setLayoutResource(getCustomLayout());
        this.mJr = this.mJq.inflate();
        dS(this.mJr);
        this.mJI = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mKR = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mJY = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mJM = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mJL = (AdCloseView) this.mJM.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mJS = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mJI.setText(str);
                this.mJI.setVisibility(0);
            } else {
                this.mJI.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mKR.setText(str2 + "广告");
            dV(this.mJM);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            n(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mJL.onChangeSkinType();
        ap.setViewTextColor(this.mJI, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mKR, R.color.CAM_X0109, 1, i);
    }

    private void n(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eEm != null && advertAppInfo.eEm.adCloseInfo != null && advertAppInfo.eEm.adCloseInfo.support_close.intValue() > 0) {
            this.mJL.setVisibility(0);
            this.mJL.setPage(getBusinessType());
            this.mJL.setData(advertAppInfo);
            l.addToParentArea(this.eNx.getPageActivity(), this.mJM, 40, 40, 40, 120);
            this.mJM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mJL.performClick();
                }
            });
            return;
        }
        this.mJL.setVisibility(8);
    }

    private void dV(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mJY.setVisibility(0);
            this.mJY.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mJY.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdCard mKm;

        public a(AdCard adCard) {
            this.mKm = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eNx.showToast(R.string.neterror);
            } else if (this.mKm != null) {
                l(this.mKm.getAdvertAppInfo());
            }
        }

        private void l(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKm.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eEf;
            }
            int h = s.h(AdSimpleCardBaseView.this.eNx, AdSimpleCardBaseView.this.Sc(scheme));
            if (AdSimpleCardBaseView.this.kTj != null) {
                AdSimpleCardBaseView.this.kTj.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Sc(String str) {
        if (this.mJS != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.mJS.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mJS.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.mJS.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mJS.getNextPageData()));
            }
            if (this.mJS.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append("=");
                sb.append("1");
            }
            if (this.mJS.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append("=");
                sb.append("1");
            }
            if (this.mJS.isImmersiveStyle()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_IMMERSIVE);
                sb.append("=");
                sb.append("1");
            }
            return sb.toString();
        }
        return str;
    }
}
