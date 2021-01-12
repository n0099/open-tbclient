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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
/* loaded from: classes7.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected ViewStub mJS;
    protected View mJT;
    private FrameLayout mKA;
    protected TextView mKk;
    private AdCloseView mKn;
    private LinearLayout mKo;
    private AdCard mKu;
    protected TextView mLt;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void ec(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mJS = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mJS.setLayoutResource(getCustomLayout());
        this.mJT = this.mJS.inflate();
        ec(this.mJT);
        this.mKk = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mLt = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mKA = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mKo = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mKn = (AdCloseView) this.mKo.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mKu = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mKk.setText(str);
                this.mKk.setVisibility(0);
            } else {
                this.mKk.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mLt.setText(str2 + "广告");
            ef(this.mKo);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            o(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mKn.onChangeSkinType();
        ao.setViewTextColor(this.mKk, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mLt, R.color.CAM_X0109, 1, i);
    }

    private void o(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eJr != null && advertAppInfo.eJr.adCloseInfo != null && advertAppInfo.eJr.adCloseInfo.support_close.intValue() > 0) {
            this.mKn.setVisibility(0);
            this.mKn.setPage(getBusinessType());
            this.mKn.setData(advertAppInfo);
            l.addToParentArea(this.eSJ.getPageActivity(), this.mKo, 40, 40, 40, 120);
            this.mKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mKn.performClick();
                }
            });
            return;
        }
        this.mKn.setVisibility(8);
    }

    private void ef(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mKA.setVisibility(0);
            this.mKA.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mKA.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private AdCard mKO;

        public a(AdCard adCard) {
            this.mKO = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eSJ.showToast(R.string.neterror);
            } else if (this.mKO != null) {
                m(this.mKO.getAdvertAppInfo());
            }
        }

        private void m(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKO.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eJk;
            }
            int x = s.x(AdSimpleCardBaseView.this.eSJ.getPageActivity(), scheme, AdSimpleCardBaseView.this.d(advertAppInfo));
            if (AdSimpleCardBaseView.this.kUi != null) {
                AdSimpleCardBaseView.this.kUi.d(x, null);
            }
        }
    }
}
