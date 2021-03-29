package com.baidu.wallet.personal.ui.fragment.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.personal.storage.CardListCache;
import com.baidu.wallet.personal.ui.widget.MyBankCardLayout;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class CardListBaseFragment extends BaseFragment implements View.OnClickListener, IBeanResponseCallback {
    public static final String EVENT_NEED_SYNC_SERVER_DATA = "ev_need_sync_server_data";
    public static final float FOCUS_ALPHA_VALUE = 0.5f;
    public static final String KEY_HAS_EEM_CARD_LIST_LOADED = "key_has_eem_card_loaded_msg";
    public static final float NORMAL_ALPHA_VALUE = 1.0f;

    /* renamed from: a  reason: collision with root package name */
    public View f26648a;

    /* renamed from: b  reason: collision with root package name */
    public Button f26649b;

    /* renamed from: c  reason: collision with root package name */
    public View f26650c;

    /* renamed from: e  reason: collision with root package name */
    public PromptDialog f26652e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f26653f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f26654g;
    public boolean isViewCreated;
    public Activity mActivity;
    public MyBankCardLayout mBankLayout;
    public a mCallback;
    public CardListResponse mCardListResponse;
    public RelativeLayout mCustomContainer;
    public LayoutInflater mInflater;
    public View mLoadFailedView;
    public LinearLayout mLoadingLayout;
    public ImageView mLoadingView;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26651d = false;
    public boolean mRefreshFlag = false;
    public final View.OnClickListener mOnCardClickListener = new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            CardListBaseFragment.this.mRefreshFlag = true;
            BaiduWalletDelegate.getInstance().openH5Module(CardListBaseFragment.this.mActivity, str, false);
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void bindCard();

        void handleFailure(int i, int i2, String str);

        void setBankCardDetectEnabled(boolean z);

        void setNoBankCardAndPwdFlag(boolean z);

        void showPwdLayout(boolean z);
    }

    public abstract void bindCardData(boolean z);

    public void bindCustomViewData() {
    }

    public void bindData(boolean z) {
        CardListResponse cardListResponse;
        Activity activity = this.mActivity;
        if (activity == null || (cardListResponse = this.mCardListResponse) == null) {
            return;
        }
        if (cardListResponse.bind_card_arr != null) {
            bindCardData(z);
            this.f26648a.setBackgroundColor(ResUtils.getColor(this.mActivity, "bd_extend_bankcardlist_bg1"));
        } else {
            this.f26648a.setBackgroundColor(ResUtils.getColor(activity, "bd_extend_bankcardlist_bg2"));
        }
        bindCustomViewData();
    }

    public abstract void getCacheData();

    public void handleFailure(int i, int i2, String str) {
        if (599 != i && 607 != i) {
            a aVar = this.mCallback;
            if (aVar != null) {
                aVar.handleFailure(i, i2, str);
            }
        } else if (i2 == 5003) {
            WalletLoginHelper.getInstance().handlerWalletError(5003);
            AccountManager.getInstance(this.mActivity.getApplicationContext()).logout();
            WalletLoginHelper.getInstance().logout(false);
            GlobalUtils.toast(this.mActivity, str);
            this.mActivity.finish();
        } else if (i2 == 5099) {
            PromptDialog promptDialog = new PromptDialog(this.mActivity);
            this.f26652e = promptDialog;
            promptDialog.setTitleText(ResUtils.getString(this.mActivity, "bd_wallet_base_third_login_title"));
            this.f26652e.setMessage(str);
            this.f26652e.setPositiveBtn(ResUtils.getString(this.mActivity, "bd_wallet_base_third_login_positive"), new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CardListBaseFragment.this.f26652e.dismiss();
                    CardListBaseFragment.this.c();
                }
            });
            this.f26652e.setNegativeBtn(ResUtils.getString(this.mActivity, "bd_wallet_base_third_login_negative"), new View.OnClickListener() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CardListBaseFragment.this.f26652e.dismiss();
                    CardListBaseFragment.this.mActivity.finish();
                }
            });
            this.f26652e.show();
        } else if (i2 == 100035 || i2 == 100036) {
            PassUtil.passNormalized(this.mActivity, str, i2 == 100036 ? 2 : 1, new PassUtil.PassNormalize() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.7
                @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                public boolean onNormalize(Context context, int i3, Map<String, String> map) {
                    if (super.onNormalize(context, i3, map)) {
                        CardListBaseFragment.this.syncData();
                        return false;
                    }
                    CardListBaseFragment.this.mActivity.finish();
                    return false;
                }
            });
        } else if (i2 != 5140 && i2 != 5139) {
            if (this.mCardListResponse == null) {
                this.mLoadFailedView.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.mActivity, "fp_get_data_fail");
            }
            GlobalUtils.toast(this.mActivity, str);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_from", "4");
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, i2 == 5140 ? HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9 : "0");
            BaiduPayDelegate.getInstance().doRNAuth(this.mActivity, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.8
                @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                public void onRNAuthResult(int i3, String str2) {
                    if (i3 == 0) {
                        CardListBaseFragment.this.syncData();
                    } else {
                        CardListBaseFragment.this.mActivity.finish();
                    }
                }
            });
        }
    }

    public void handleResponse(int i, Object obj, String str) {
        if ((599 == i || 607 == i) && obj != null && (obj instanceof CardListResponse)) {
            this.mCardListResponse = (CardListResponse) obj;
            bindData(false);
        }
    }

    public void hideLoading() {
        LinearLayout linearLayout = this.mLoadingLayout;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.mLoadingLayout.setVisibility(8);
        AnimationDrawable animationDrawable = this.f26653f;
        if (animationDrawable == null || !animationDrawable.isRunning()) {
            return;
        }
        this.f26653f.stop();
    }

    public abstract void loadData();

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void onAttach(Context context) {
        super.onAttach(context);
        a(context);
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i, final int i2, final String str) {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.4
            @Override // java.lang.Runnable
            public void run() {
                CardListBaseFragment cardListBaseFragment = CardListBaseFragment.this;
                if (cardListBaseFragment.mActivity != null) {
                    cardListBaseFragment.handleFailure(i, i2, str);
                }
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i, final Object obj, final String str) {
        a(i, obj, str);
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.3
            @Override // java.lang.Runnable
            public void run() {
                CardListBaseFragment cardListBaseFragment = CardListBaseFragment.this;
                if (cardListBaseFragment.mActivity != null) {
                    cardListBaseFragment.handleResponse(i, obj, str);
                }
            }
        });
    }

    public void onClick(View view) {
        if (view == this.f26649b) {
            this.f26654g = new LoginBackListenerProxy(this.mActivity, new ILoginBackListener() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.2
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i, String str) {
                    if (i == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(CardListBaseFragment.this.f26654g);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i, String str) {
                    CardListBaseFragment.this.f26649b.setVisibility(8);
                    CardListBaseFragment.this.syncData();
                }
            });
            WalletLoginHelper.getInstance().login(this.f26654g);
        } else if (view == this.f26650c) {
            syncData();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getInstance().register(this, EVENT_NEED_SYNC_SERVER_DATA, 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mInflater = layoutInflater;
        return b();
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        removeRequest();
        EventBus.getInstance().unregister(this, EVENT_NEED_SYNC_SERVER_DATA);
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isViewCreated = false;
        if (isDetached() || isRemoving()) {
            return;
        }
        try {
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && EVENT_NEED_SYNC_SERVER_DATA.equals(event.mEventKey)) {
            syncData();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mRefreshFlag && this.isViewCreated) {
            this.mRefreshFlag = false;
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(EVENT_NEED_SYNC_SERVER_DATA, ""));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("NeedRestoreDataFlag", true);
        bundle.putSerializable("CardListResponse", this.mCardListResponse);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        if (bundle != null) {
            boolean z = bundle.getBoolean("NeedRestoreDataFlag");
            this.f26651d = z;
            if (z) {
                Serializable serializable = bundle.getSerializable("CardListResponse");
                if (serializable instanceof CardListResponse) {
                    CardListResponse cardListResponse = (CardListResponse) serializable;
                    this.mCardListResponse = cardListResponse;
                    cardListResponse.storeResponse(this.mActivity);
                } else {
                    this.f26651d = false;
                }
            }
        }
        PassUtil.onCreate();
        a();
    }

    public abstract void removeRequest();

    public void setCallback(a aVar) {
        this.mCallback = aVar;
    }

    public void showLoading() {
        this.mLoadingLayout.setVisibility(0);
        if (this.f26653f == null) {
            this.f26653f = (AnimationDrawable) this.mLoadingView.getDrawable();
        }
        this.f26653f.stop();
        this.f26653f.start();
    }

    public void syncData() {
        this.mLoadFailedView.setVisibility(8);
        loadData();
    }

    private void a(Context context) {
        if (context != null) {
            this.mActivity = (Activity) context;
        }
    }

    private View b() {
        ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(ResUtils.layout(this.mActivity, "wallet_base_card_list_fragment"), (ViewGroup) null);
        this.f26648a = viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_base_card_list_page_view"));
        this.mBankLayout = (MyBankCardLayout) viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_my_bank_layout"));
        Button button = (Button) viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_login"));
        this.f26649b = button;
        button.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(ResUtils.id(this.mActivity, "custom_container"));
        this.mCustomContainer = relativeLayout;
        relativeLayout.setVisibility(8);
        View findViewById = viewGroup.findViewById(ResUtils.id(this.mActivity, "bd_wallet_empty_list"));
        this.mLoadFailedView = findViewById;
        View findViewById2 = findViewById.findViewById(ResUtils.id(this.mActivity, "bd_wallet_do"));
        this.f26650c = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mLoadingLayout = (LinearLayout) viewGroup.findViewById(ResUtils.id(this.mActivity, "loading_page_layout"));
        this.mLoadingView = (ImageView) viewGroup.findViewById(ResUtils.id(this.mActivity, "img_anim"));
        this.mLoadingLayout.setVisibility(8);
        ((TextView) ((ViewGroup) viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_base_logo_layout_scrollview_bottom"))).findViewById(ResUtils.id(this.mActivity, "brand_text"))).setText(ResUtils.string(this.mActivity, "dxm_finance_brand"));
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f26654g = new LoginBackListenerProxy(this.mActivity, new ILoginBackListener() { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.9
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(CardListBaseFragment.this.f26654g);
                } else {
                    CardListBaseFragment.this.mActivity.finish();
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                CardListBaseFragment.this.syncData();
            }
        });
        WalletLoginHelper.getInstance().login(this.f26654g);
    }

    private void a() {
        CardListResponse cardListResponse;
        if (this.isViewCreated) {
            if (this.f26651d && (cardListResponse = this.mCardListResponse) != null && cardListResponse.checkResponseValidity()) {
                bindData(true);
            } else if (!WalletLoginHelper.getInstance().isLogin()) {
                this.mBankLayout.setData(false, null, 0, true, null);
                this.f26649b.setVisibility(0);
            } else {
                getCacheData();
                syncData();
            }
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            a(activity);
        }
    }

    private void a(int i, Object obj, String str) {
        CardListCache.getInstance().updateCardList(i, (CardListResponse) obj);
    }
}
