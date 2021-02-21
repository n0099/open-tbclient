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
/* loaded from: classes8.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected View mRootView;
    protected ViewStub mTD;
    protected View mTE;
    protected TextView mTV;
    private AdCloseView mTY;
    private LinearLayout mTZ;
    private AdCard mUg;
    private FrameLayout mUn;
    protected TextView mVi;

    protected abstract void a(AdCard adCard);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mTD = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mTD.setLayoutResource(getCustomLayout());
        this.mTE = this.mTD.inflate();
        ea(this.mTE);
        this.mTV = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mVi = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mUn = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mTZ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mTY = (AdCloseView) this.mTZ.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mUg = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mTV.setText(str);
                this.mTV.setVisibility(0);
            } else {
                this.mTV.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mVi.setText(str2 + "广告");
            ed(this.mTZ);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            p(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mTY.onChangeSkinType();
        ap.setViewTextColor(this.mTV, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mVi, R.color.CAM_X0109, 1, i);
    }

    private void p(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eLC != null && advertAppInfo.eLC.adCloseInfo != null && advertAppInfo.eLC.adCloseInfo.support_close.intValue() > 0) {
            this.mTY.setVisibility(0);
            this.mTY.setPage(getBusinessType());
            this.mTY.setData(advertAppInfo);
            l.addToParentArea(this.eUY.getPageActivity(), this.mTZ, 40, 40, 40, 120);
            this.mTZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mTY.performClick();
                }
            });
            return;
        }
        this.mTY.setVisibility(8);
    }

    private void ed(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mUn.setVisibility(0);
            this.mUn.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mUn.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private AdCard mUC;

        public a(AdCard adCard) {
            this.mUC = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eUY.showToast(R.string.neterror);
            } else if (this.mUC != null) {
                n(this.mUC.getAdvertAppInfo());
            }
        }

        private void n(AdvertAppInfo advertAppInfo) {
            String scheme = this.mUC.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eLv;
            }
            int i = t.i(AdSimpleCardBaseView.this.eUY.getPageActivity(), scheme, AdSimpleCardBaseView.this.d(advertAppInfo), advertAppInfo.extensionInfo);
            if (AdSimpleCardBaseView.this.lcA != null) {
                AdSimpleCardBaseView.this.lcA.d(i, null);
            }
        }
    }
}
