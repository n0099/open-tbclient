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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
/* loaded from: classes8.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected View mRootView;
    private AdCard mTF;
    private FrameLayout mTL;
    protected ViewStub mTb;
    protected View mTc;
    protected TextView mTv;
    private AdCloseView mTy;
    private LinearLayout mTz;
    protected TextView mUH;

    protected abstract void a(AdCard adCard);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mTb = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mTb.setLayoutResource(getCustomLayout());
        this.mTc = this.mTb.inflate();
        ea(this.mTc);
        this.mTv = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mUH = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mTL = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mTz = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mTy = (AdCloseView) this.mTz.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mTF = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mTv.setText(str);
                this.mTv.setVisibility(0);
            } else {
                this.mTv.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mUH.setText(str2 + "广告");
            ed(this.mTz);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            p(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mTy.onChangeSkinType();
        ap.setViewTextColor(this.mTv, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mUH, R.color.CAM_X0109, 1, i);
    }

    private void p(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eLD != null && advertAppInfo.eLD.adCloseInfo != null && advertAppInfo.eLD.adCloseInfo.support_close.intValue() > 0) {
            this.mTy.setVisibility(0);
            this.mTy.setPage(getBusinessType());
            this.mTy.setData(advertAppInfo);
            l.addToParentArea(this.eUY.getPageActivity(), this.mTz, 40, 40, 40, 120);
            this.mTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mTy.performClick();
                }
            });
            return;
        }
        this.mTy.setVisibility(8);
    }

    private void ed(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mTL.setVisibility(0);
            this.mTL.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mTL.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private AdCard mUb;

        public a(AdCard adCard) {
            this.mUb = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eUY.showToast(R.string.neterror);
            } else if (this.mUb != null) {
                n(this.mUb.getAdvertAppInfo());
            }
        }

        private void n(AdvertAppInfo advertAppInfo) {
            String scheme = this.mUb.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eLw;
            }
            int x = s.x(AdSimpleCardBaseView.this.eUY.getPageActivity(), scheme, AdSimpleCardBaseView.this.d(advertAppInfo));
            if (AdSimpleCardBaseView.this.lcl != null) {
                AdSimpleCardBaseView.this.lcl.d(x, null);
            }
        }
    }
}
