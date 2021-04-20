package com.baidu.wallet.personal.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.e;
import com.baidu.wallet.paysdk.datamodel.ApplyCardEntrance;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.paysdk.datamodel.SourceFlag;
import com.baidu.wallet.personal.storage.CardListCache;
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment;
/* loaded from: classes5.dex */
public class BankCardListFragment extends CardListBaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f26315a;

    /* renamed from: b  reason: collision with root package name */
    public View f26316b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26317c = false;

    /* renamed from: d  reason: collision with root package name */
    public e f26318d;

    /* renamed from: e  reason: collision with root package name */
    public View f26319e;

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void bindCardData(boolean z) {
        CardListResponse.Card[] cardArr = this.mCardListResponse.bind_card_arr;
        if (cardArr != null) {
            this.mBankLayout.setData(true, cardArr, 0, z, this.mOnCardClickListener);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void bindCustomViewData() {
        CardListBaseFragment.a aVar;
        CardListResponse.User user;
        CardListBaseFragment.a aVar2;
        boolean z = false;
        if (a() != null) {
            this.mCustomContainer.setVisibility(0);
            this.mCustomContainer.removeAllViews();
            this.mCustomContainer.addView(a());
        }
        CardListResponse.Misc misc = this.mCardListResponse.card_bind_misc_info;
        if (misc != null && "0".equals(misc.bank_card_detect_enabled) && (aVar2 = this.mCallback) != null) {
            aVar2.setBankCardDetectEnabled(true);
        }
        CardListResponse.Card[] cardArr = this.mCardListResponse.bind_card_arr;
        if ((cardArr == null || cardArr.length == 0) && (aVar = this.mCallback) != null) {
            aVar.setNoBankCardAndPwdFlag(true);
        }
        CardListResponse.Misc misc2 = this.mCardListResponse.card_bind_misc_info;
        if (misc2 != null) {
            this.f26317c = "1".equals(misc2.can_bind_card_flag);
            View view = this.f26316b;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        CardListResponse cardListResponse = this.mCardListResponse;
        if (cardListResponse != null && (user = cardListResponse.user) != null && !"1".equals(user.has_pwd)) {
            z = true;
        }
        CardListBaseFragment.a aVar3 = this.mCallback;
        if (aVar3 != null) {
            aVar3.showPwdLayout(z);
        }
        b();
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void getCacheData() {
        CardListCache.getInstance().getCardList(new CardListCache.b<CardListResponse>() { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.wallet.personal.storage.CardListCache.b
            public void a(final CardListResponse cardListResponse) {
                BankCardListFragment.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BankCardListFragment bankCardListFragment = BankCardListFragment.this;
                        CardListResponse cardListResponse2 = cardListResponse;
                        bankCardListFragment.mCardListResponse = cardListResponse2;
                        if (cardListResponse2 != null) {
                            bankCardListFragment.mLoadFailedView.setVisibility(4);
                            BankCardListFragment.this.bindData(true);
                        }
                    }
                });
            }
        });
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void loadData() {
        removeRequest();
        if (this.f26318d == null) {
            this.f26318d = (e) PayBeanFactory.getInstance().getBean((Context) this.mActivity, PayBeanFactory.BEAN_ID_CARD_LIST, "BankCardListFragment");
        }
        this.f26318d.setResponseCallback(this);
        this.f26318d.a(SourceFlag.SDK);
        this.f26318d.execBean();
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        CardListResponse.Misc misc;
        super.onClick(view);
        if (view == this.f26316b) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.ADD_NEW_BANK_CARD, "addBankCard");
            if (this.f26317c) {
                CardListBaseFragment.a aVar = this.mCallback;
                if (aVar != null) {
                    aVar.bindCard();
                    return;
                }
                return;
            }
            CardListResponse cardListResponse = this.mCardListResponse;
            if (cardListResponse != null && (misc = cardListResponse.card_bind_misc_info) != null && !TextUtils.isEmpty(misc.bind_card_limit_msg)) {
                string = this.mCardListResponse.card_bind_misc_info.bind_card_limit_msg;
            } else {
                string = ResUtils.getString(this.mActivity, "bd_wallet_bind_card_number_overrun");
            }
            GlobalUtils.toast(this.mActivity, string);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getInstance().register(this, BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS, 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister(this, BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS);
        CardListCache.getInstance().getCardList(null);
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void onModuleEvent(EventBus.Event event) {
        super.onModuleEvent(event);
        if (event != null && BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS.equals(event.mEventKey)) {
            syncData();
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void removeRequest() {
        BeanManager.getInstance().removeAllBeans("BankCardListFragment");
    }

    private View a() {
        if (this.f26319e == null) {
            View inflate = this.mInflater.inflate(ResUtils.layout(this.mActivity, "wallet_bank_card_list_fragment"), (ViewGroup) null);
            this.f26319e = inflate;
            this.f26315a = (LinearLayout) inflate.findViewById(ResUtils.id(this.mActivity, "wallet_my_bank_ll_credicard"));
            View findViewById = this.f26319e.findViewById(ResUtils.id(this.mActivity, "wallet_my_bank_card_btn"));
            this.f26316b = findViewById;
            findViewById.setOnClickListener(this);
            this.f26316b.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                        ViewHelper.setAlpha(BankCardListFragment.this.f26316b, 0.5f);
                        return false;
                    }
                    ViewHelper.setAlpha(BankCardListFragment.this.f26316b, 1.0f);
                    return false;
                }
            });
        }
        return this.f26319e;
    }

    private void b() {
        ApplyCardEntrance[] applyCardEntranceArr;
        CardListResponse cardListResponse = this.mCardListResponse;
        if (cardListResponse == null || (applyCardEntranceArr = cardListResponse.apply_card_entrance) == null) {
            return;
        }
        a(applyCardEntranceArr);
    }

    private void a(ApplyCardEntrance[] applyCardEntranceArr) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.f26315a;
        if (linearLayout2 != null && linearLayout2.getChildCount() > 0) {
            this.f26315a.removeAllViews();
        }
        Activity activity = this.mActivity;
        if (activity == null || applyCardEntranceArr == null || applyCardEntranceArr.length <= 0) {
            return;
        }
        int dimension = (int) ResUtils.getDimension(activity, "wallet_base_15dp");
        int dimension2 = (int) ResUtils.getDimension(this.mActivity, "wallet_base_25dp");
        int displayWidth = DisplayUtils.getDisplayWidth(this.mActivity);
        boolean z = true;
        for (ApplyCardEntrance applyCardEntrance : applyCardEntranceArr) {
            if (applyCardEntrance != null) {
                String str = applyCardEntrance.image;
                String str2 = applyCardEntrance.jump_url;
                float heightToWidthRatio = applyCardEntrance.getHeightToWidthRatio();
                NetImageView a2 = a(str, str2);
                a2.setAdjustViewBounds(true);
                a2.setContentDescription(applyCardEntrance.desc + "");
                LinearLayout.LayoutParams a3 = a(heightToWidthRatio, displayWidth, dimension, z ? dimension2 : dimension);
                if (a2 != null && a3 != null && (linearLayout = this.f26315a) != null) {
                    linearLayout.addView(a2, a3);
                }
                z = false;
            }
        }
    }

    private NetImageView a(String str, final String str2) {
        final NetImageView netImageView = new NetImageView(this.mActivity);
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        netImageView.setImageResource(ResUtils.drawable(this.mActivity, "wallet_personal_my_bank_credit_list_item_bg"));
        if (!TextUtils.isEmpty(str)) {
            netImageView.setImageUrl(str);
        }
        netImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                    ViewHelper.setAlpha(netImageView, 1.0f);
                    return false;
                }
                ViewHelper.setAlpha(netImageView, 0.5f);
                return false;
            }
        });
        netImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    GlobalUtils.toast(BankCardListFragment.this.mActivity, ResUtils.getString(BankCardListFragment.this.mActivity, "bd_wallet_jump_url_error"));
                    return;
                }
                BankCardListFragment.this.mRefreshFlag = true;
                BaiduWalletDelegate.getInstance().openH5Module(BankCardListFragment.this.mActivity, str2, true);
            }
        });
        return netImageView;
    }

    private LinearLayout.LayoutParams a(float f2, int i, int i2, int i3) {
        if (f2 > 0.0f) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ((i - (i2 * 2)) * f2));
            layoutParams.setMargins(0, i3, 0, 0);
            return layoutParams;
        }
        return null;
    }
}
