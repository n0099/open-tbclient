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
    private AdCard keI;
    protected TextView keM;
    protected View mRootView;
    private AdCloseView mcI;
    private LinearLayout mcJ;
    protected TextView mcL;
    private FrameLayout mcU;
    protected ViewStub mcp;
    protected View mcq;

    protected abstract void a(AdCard adCard);

    protected abstract void du(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cTG() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mcp = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mcp.setLayoutResource(getCustomLayout());
        this.mcq = this.mcp.inflate();
        du(this.mcq);
        this.keM = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mcL = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mcU = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mcJ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mcI = (AdCloseView) this.mcJ.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.keI = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.keM.setText(str);
                this.keM.setVisibility(0);
            } else {
                this.keM.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mcL.setText(str2 + "广告");
            dv(this.mcJ);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            j(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mcI.onChangeSkinType();
        ap.setViewTextColor(this.keM, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mcL, R.color.cp_cont_d, 1, i);
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.ekE != null && advertAppInfo.ekE.adCloseInfo != null && advertAppInfo.ekE.adCloseInfo.support_close.intValue() > 0) {
            this.mcI.setVisibility(0);
            this.mcI.setPage(getBusinessType());
            this.mcI.setData(advertAppInfo);
            l.addToParentArea(this.etO.getPageActivity(), this.mcJ, 40, 40, 40, 120);
            this.mcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mcI.performClick();
                }
            });
            return;
        }
        this.mcI.setVisibility(8);
    }

    private void dv(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mcU.setVisibility(0);
            this.mcU.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mcU.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        private AdCard mdh;

        public a(AdCard adCard) {
            this.mdh = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.etO.showToast(R.string.neterror);
            } else if (this.mdh != null) {
                h(this.mdh.getAdvertAppInfo());
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mdh.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.ekx;
            }
            int h = s.h(AdSimpleCardBaseView.this.etO, AdSimpleCardBaseView.this.QJ(scheme));
            if (AdSimpleCardBaseView.this.knj != null) {
                AdSimpleCardBaseView.this.knj.d(h, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String QJ(String str) {
        if (this.keI != null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.keI.getPreLoadData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.PRE_LOAD);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.keI.getPreLoadData()));
            }
            if (!TextUtils.isEmpty(this.keI.getNextPageData())) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.NEXT_PAGE);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(this.keI.getNextPageData()));
            }
            if (this.keI.hasAnimation()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.HAS_ANIMATION);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.keI.isGoLandingPage()) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
                sb.append(ETAG.EQUAL);
                sb.append("1");
            }
            if (this.keI.isImmersiveStyle()) {
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
