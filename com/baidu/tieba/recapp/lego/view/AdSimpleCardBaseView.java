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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.view.AdCloseView;
/* loaded from: classes7.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected View mRootView;
    protected ViewStub mVO;
    protected View mVP;
    protected TextView mWg;
    private AdCloseView mWj;
    private LinearLayout mWk;
    private AdCard mWq;
    private FrameLayout mWw;
    protected TextView mXt;

    protected abstract void a(AdCard adCard);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mVO = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mVO.setLayoutResource(getCustomLayout());
        this.mVP = this.mVO.inflate();
        ea(this.mVP);
        this.mWg = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mXt = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mWw = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mWk = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mWj = (AdCloseView) this.mWk.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mWq = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mWg.setText(str);
                this.mWg.setVisibility(0);
            } else {
                this.mWg.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mXt.setText(str2 + "广告");
            ed(this.mWk);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            p(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mWj.onChangeSkinType();
        ap.setViewTextColor(this.mWg, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mXt, R.color.CAM_X0109, 1, i);
    }

    private void p(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eNd != null && advertAppInfo.eNd.adCloseInfo != null && advertAppInfo.eNd.adCloseInfo.support_close.intValue() > 0) {
            this.mWj.setVisibility(0);
            this.mWj.setPage(getBusinessType());
            this.mWj.setData(advertAppInfo);
            l.addToParentArea(this.eWx.getPageActivity(), this.mWk, 40, 40, 40, 120);
            this.mWk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mWj.performClick();
                }
            });
            return;
        }
        this.mWj.setVisibility(8);
    }

    private void ed(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mWw.setVisibility(0);
            this.mWw.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mWw.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private AdCard mWL;

        public a(AdCard adCard) {
            this.mWL = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eWx.showToast(R.string.neterror);
            } else if (this.mWL != null) {
                n(this.mWL.getAdvertAppInfo());
            }
        }

        private void n(AdvertAppInfo advertAppInfo) {
            String scheme = this.mWL.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eMW;
            }
            int i = t.i(AdSimpleCardBaseView.this.eWx.getPageActivity(), scheme, AdSimpleCardBaseView.this.d(advertAppInfo), advertAppInfo.extensionInfo);
            if (AdSimpleCardBaseView.this.leD != null) {
                AdSimpleCardBaseView.this.leD.d(i, null);
            }
        }
    }
}
