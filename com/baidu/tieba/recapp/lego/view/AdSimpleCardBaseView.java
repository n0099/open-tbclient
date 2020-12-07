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
    protected TextView mJG;
    private AdCloseView mJJ;
    private LinearLayout mJK;
    private AdCard mJQ;
    private FrameLayout mJW;
    protected ViewStub mJo;
    protected View mJp;
    protected TextView mKP;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void dS(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddV() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mJo = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mJo.setLayoutResource(getCustomLayout());
        this.mJp = this.mJo.inflate();
        dS(this.mJp);
        this.mJG = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mKP = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mJW = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mJK = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mJJ = (AdCloseView) this.mJK.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mJQ = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mJG.setText(str);
                this.mJG.setVisibility(0);
            } else {
                this.mJG.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mKP.setText(str2 + "广告");
            dV(this.mJK);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            n(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mJJ.onChangeSkinType();
        ap.setViewTextColor(this.mJG, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mKP, R.color.CAM_X0109, 1, i);
    }

    private void n(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eEm != null && advertAppInfo.eEm.adCloseInfo != null && advertAppInfo.eEm.adCloseInfo.support_close.intValue() > 0) {
            this.mJJ.setVisibility(0);
            this.mJJ.setPage(getBusinessType());
            this.mJJ.setData(advertAppInfo);
            l.addToParentArea(this.eNx.getPageActivity(), this.mJK, 40, 40, 40, 120);
            this.mJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mJJ.performClick();
                }
            });
            return;
        }
        this.mJJ.setVisibility(8);
    }

    private void dV(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mJW.setVisibility(0);
            this.mJW.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mJW.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdCard mKk;

        public a(AdCard adCard) {
            this.mKk = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eNx.showToast(R.string.neterror);
            } else if (this.mKk != null) {
                l(this.mKk.getAdvertAppInfo());
            }
        }

        private void l(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKk.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eEf;
            }
            int h = s.h(AdSimpleCardBaseView.this.eNx, AdSimpleCardBaseView.this.Sc(scheme));
            if (AdSimpleCardBaseView.this.kTh != null) {
                AdSimpleCardBaseView.this.kTh.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Sc(String str) {
        if (this.mJQ != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.mJQ.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mJQ.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.mJQ.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mJQ.getNextPageData()));
            }
            if (this.mJQ.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append("=");
                sb.append("1");
            }
            if (this.mJQ.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append("=");
                sb.append("1");
            }
            if (this.mJQ.isImmersiveStyle()) {
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
