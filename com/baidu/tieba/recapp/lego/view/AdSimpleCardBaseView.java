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
/* loaded from: classes8.dex */
public abstract class AdSimpleCardBaseView extends BaseLegoCardView<AdCard> {
    protected TextView mOO;
    private AdCloseView mOR;
    private LinearLayout mOS;
    private AdCard mOY;
    protected ViewStub mOw;
    protected View mOx;
    protected TextView mPZ;
    private FrameLayout mPe;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void ec(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdSimpleCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mOw = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mOw.setLayoutResource(getCustomLayout());
        this.mOx = this.mOw.inflate();
        ec(this.mOx);
        this.mOO = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mPZ = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mPe = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mOS = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mOR = (AdCloseView) this.mOS.findViewById(R.id.ad_close_view);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        if (adCard != null) {
            this.mOY = adCard;
            this.mRootView.setOnClickListener(new a(adCard));
            String str = adCard.threadTitle;
            if (!TextUtils.isEmpty(str)) {
                this.mOO.setText(str);
                this.mOO.setVisibility(0);
            } else {
                this.mOO.setVisibility(8);
            }
            String str2 = adCard.userName;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + "  ";
            }
            this.mPZ.setText(str2 + "广告");
            ef(this.mOS);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
            a(adCard);
            o(adCard.getAdvertAppInfo());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mOR.onChangeSkinType();
        ao.setViewTextColor(this.mOO, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mPZ, R.color.CAM_X0109, 1, i);
    }

    private void o(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eOc != null && advertAppInfo.eOc.adCloseInfo != null && advertAppInfo.eOc.adCloseInfo.support_close.intValue() > 0) {
            this.mOR.setVisibility(0);
            this.mOR.setPage(getBusinessType());
            this.mOR.setData(advertAppInfo);
            l.addToParentArea(this.eXu.getPageActivity(), this.mOS, 40, 40, 40, 120);
            this.mOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdSimpleCardBaseView.this.mOR.performClick();
                }
            });
            return;
        }
        this.mOR.setVisibility(8);
    }

    private void ef(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.mPe.setVisibility(0);
            this.mPe.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.mPe.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private AdCard mPu;

        public a(AdCard adCard) {
            this.mPu = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdSimpleCardBaseView.this.eXu.showToast(R.string.neterror);
            } else if (this.mPu != null) {
                m(this.mPu.getAdvertAppInfo());
            }
        }

        private void m(AdvertAppInfo advertAppInfo) {
            String scheme = this.mPu.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eNV;
            }
            int x = s.x(AdSimpleCardBaseView.this.eXu.getPageActivity(), scheme, AdSimpleCardBaseView.this.d(advertAppInfo));
            if (AdSimpleCardBaseView.this.kYN != null) {
                AdSimpleCardBaseView.this.kYN.d(x, null);
            }
        }
    }
}
