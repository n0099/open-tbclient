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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.utils.PassUtil;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_NEED_SYNC_SERVER_DATA = "ev_need_sync_server_data";
    public static final float FOCUS_ALPHA_VALUE = 0.5f;
    public static final String KEY_HAS_EEM_CARD_LIST_LOADED = "key_has_eem_card_loaded_msg";
    public static final float NORMAL_ALPHA_VALUE = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27159a;

    /* renamed from: b  reason: collision with root package name */
    public Button f27160b;

    /* renamed from: c  reason: collision with root package name */
    public View f27161c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27162d;

    /* renamed from: e  reason: collision with root package name */
    public PromptDialog f27163e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f27164f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f27165g;
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
    public final View.OnClickListener mOnCardClickListener;
    public boolean mRefreshFlag;

    /* loaded from: classes5.dex */
    public interface a {
        void bindCard();

        void handleFailure(int i2, int i3, String str);

        void setBankCardDetectEnabled(boolean z);

        void setNoBankCardAndPwdFlag(boolean z);

        void showPwdLayout(boolean z);
    }

    public CardListBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27162d = false;
        this.mRefreshFlag = false;
        this.mOnCardClickListener = new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CardListBaseFragment f27166a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f27166a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    String str = (String) view.getTag();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.f27166a.mRefreshFlag = true;
                    BaiduWalletDelegate.getInstance().openH5Module(this.f27166a.mActivity, str, false);
                }
            }
        };
    }

    public abstract void bindCardData(boolean z);

    public void bindCustomViewData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void bindData(boolean z) {
        Activity activity;
        CardListResponse cardListResponse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (activity = this.mActivity) == null || (cardListResponse = this.mCardListResponse) == null) {
            return;
        }
        if (cardListResponse.bind_card_arr != null) {
            bindCardData(z);
            this.f27159a.setBackgroundColor(ResUtils.getColor(this.mActivity, "bd_extend_bankcardlist_bg1"));
        } else {
            this.f27159a.setBackgroundColor(ResUtils.getColor(activity, "bd_extend_bankcardlist_bg2"));
        }
        bindCustomViewData();
    }

    public abstract void getCacheData();

    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
            if (599 != i2 && 607 != i2) {
                a aVar = this.mCallback;
                if (aVar != null) {
                    aVar.handleFailure(i2, i3, str);
                }
            } else if (i3 == 5003) {
                WalletLoginHelper.getInstance().handlerWalletError(5003);
                AccountManager.getInstance(this.mActivity.getApplicationContext()).logout();
                WalletLoginHelper.getInstance().logout(false);
                GlobalUtils.toast(this.mActivity, str);
                this.mActivity.finish();
            } else if (i3 == 5099) {
                PromptDialog promptDialog = new PromptDialog(this.mActivity);
                this.f27163e = promptDialog;
                promptDialog.setTitleText(ResUtils.getString(this.mActivity, "bd_wallet_base_third_login_title"));
                this.f27163e.setMessage(str);
                this.f27163e.setPositiveBtn(ResUtils.getString(this.mActivity, "bd_wallet_base_third_login_positive"), new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CardListBaseFragment f27176a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27176a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f27176a.f27163e.dismiss();
                            this.f27176a.c();
                        }
                    }
                });
                this.f27163e.setNegativeBtn(ResUtils.getString(this.mActivity, "bd_wallet_base_third_login_negative"), new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CardListBaseFragment f27177a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27177a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f27177a.f27163e.dismiss();
                            this.f27177a.mActivity.finish();
                        }
                    }
                });
                this.f27163e.show();
            } else if (i3 == 100035 || i3 == 100036) {
                PassUtil.passNormalized(this.mActivity, str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CardListBaseFragment f27178a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27178a = this;
                    }

                    @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                    public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                            if (super.onNormalize(context, i4, map)) {
                                this.f27178a.syncData();
                                return false;
                            }
                            this.f27178a.mActivity.finish();
                            return false;
                        }
                        return invokeLIL.booleanValue;
                    }
                });
            } else if (i3 != 5140 && i3 != 5139) {
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
                hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, i3 == 5140 ? "9" : "0");
                BaiduPayDelegate.getInstance().doRNAuth(this.mActivity, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CardListBaseFragment f27179a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27179a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            if (i4 == 0) {
                                this.f27179a.syncData();
                            } else {
                                this.f27179a.mActivity.finish();
                            }
                        }
                    }
                });
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) {
            if ((599 == i2 || 607 == i2) && obj != null && (obj instanceof CardListResponse)) {
                this.mCardListResponse = (CardListResponse) obj;
                bindData(false);
            }
        }
    }

    public void hideLoading() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (linearLayout = this.mLoadingLayout) != null && linearLayout.getVisibility() == 0) {
            this.mLoadingLayout.setVisibility(8);
            AnimationDrawable animationDrawable = this.f27164f;
            if (animationDrawable == null || !animationDrawable.isRunning()) {
                return;
            }
            this.f27164f.stop();
        }
    }

    public abstract void loadData();

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            super.onAttach(context);
            a(context);
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, str) == null) || (activity = this.mActivity) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f27172a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f27173b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f27174c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ CardListBaseFragment f27175d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27175d = this;
                this.f27172a = i2;
                this.f27173b = i3;
                this.f27174c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    CardListBaseFragment cardListBaseFragment = this.f27175d;
                    if (cardListBaseFragment.mActivity != null) {
                        cardListBaseFragment.handleFailure(this.f27172a, this.f27173b, this.f27174c);
                    }
                }
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, obj, str) == null) {
            a(i2, obj, str);
            Activity activity = this.mActivity;
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f27168a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f27169b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f27170c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ CardListBaseFragment f27171d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), obj, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27171d = this;
                    this.f27168a = i2;
                    this.f27169b = obj;
                    this.f27170c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CardListBaseFragment cardListBaseFragment = this.f27171d;
                        if (cardListBaseFragment.mActivity != null) {
                            cardListBaseFragment.handleResponse(this.f27168a, this.f27169b, this.f27170c);
                        }
                    }
                }
            });
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (view == this.f27160b) {
                this.f27165g = new LoginBackListenerProxy(this.mActivity, new ILoginBackListener(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CardListBaseFragment f27167a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27167a = this;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) && i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f27167a.f27165g);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                            this.f27167a.f27160b.setVisibility(8);
                            this.f27167a.syncData();
                        }
                    }
                });
                WalletLoginHelper.getInstance().login(this.f27165g);
            } else if (view == this.f27161c) {
                syncData();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            EventBus.getInstance().register(this, EVENT_NEED_SYNC_SERVER_DATA, 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.mInflater = layoutInflater;
            return b();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            removeRequest();
            EventBus.getInstance().unregister(this, EVENT_NEED_SYNC_SERVER_DATA);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetach();
            this.mActivity = null;
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, event) == null) && event != null && EVENT_NEED_SYNC_SERVER_DATA.equals(event.mEventKey)) {
            syncData();
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            if (this.mRefreshFlag && this.isViewCreated) {
                this.mRefreshFlag = false;
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.post(new EventBus.Event(eventBus, EVENT_NEED_SYNC_SERVER_DATA, ""));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("NeedRestoreDataFlag", true);
            bundle.putSerializable("CardListResponse", this.mCardListResponse);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.isViewCreated = true;
            if (bundle != null) {
                boolean z = bundle.getBoolean("NeedRestoreDataFlag");
                this.f27162d = z;
                if (z) {
                    Serializable serializable = bundle.getSerializable("CardListResponse");
                    if (serializable instanceof CardListResponse) {
                        CardListResponse cardListResponse = (CardListResponse) serializable;
                        this.mCardListResponse = cardListResponse;
                        cardListResponse.storeResponse(this.mActivity);
                    } else {
                        this.f27162d = false;
                    }
                }
            }
            PassUtil.onCreate();
            a();
        }
    }

    public abstract void removeRequest();

    public void setCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.mCallback = aVar;
        }
    }

    public void showLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mLoadingLayout.setVisibility(0);
            if (this.f27164f == null) {
                this.f27164f = (AnimationDrawable) this.mLoadingView.getDrawable();
            }
            this.f27164f.stop();
            this.f27164f.start();
        }
    }

    public void syncData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mLoadFailedView.setVisibility(8);
            loadData();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) || context == null) {
            return;
        }
        this.mActivity = (Activity) context;
    }

    private View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(ResUtils.layout(this.mActivity, "wallet_base_card_list_fragment"), (ViewGroup) null);
            this.f27159a = viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_base_card_list_page_view"));
            this.mBankLayout = (MyBankCardLayout) viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_my_bank_layout"));
            Button button = (Button) viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_login"));
            this.f27160b = button;
            button.setOnClickListener(this);
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(ResUtils.id(this.mActivity, "custom_container"));
            this.mCustomContainer = relativeLayout;
            relativeLayout.setVisibility(8);
            View findViewById = viewGroup.findViewById(ResUtils.id(this.mActivity, "bd_wallet_empty_list"));
            this.mLoadFailedView = findViewById;
            View findViewById2 = findViewById.findViewById(ResUtils.id(this.mActivity, "bd_wallet_do"));
            this.f27161c = findViewById2;
            findViewById2.setOnClickListener(this);
            this.mLoadingLayout = (LinearLayout) viewGroup.findViewById(ResUtils.id(this.mActivity, "loading_page_layout"));
            this.mLoadingView = (ImageView) viewGroup.findViewById(ResUtils.id(this.mActivity, "img_anim"));
            this.mLoadingLayout.setVisibility(8);
            ((TextView) ((ViewGroup) viewGroup.findViewById(ResUtils.id(this.mActivity, "wallet_base_logo_layout_scrollview_bottom"))).findViewById(ResUtils.id(this.mActivity, "brand_text"))).setText(ResUtils.string(this.mActivity, "dxm_finance_brand"));
            return viewGroup;
        }
        return (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f27165g = new LoginBackListenerProxy(this.mActivity, new ILoginBackListener(this) { // from class: com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CardListBaseFragment f27180a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27180a = this;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f27180a.f27165g);
                        } else {
                            this.f27180a.mActivity.finish();
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.f27180a.syncData();
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f27165g);
        }
    }

    private void a() {
        CardListResponse cardListResponse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.isViewCreated) {
            if (this.f27162d && (cardListResponse = this.mCardListResponse) != null && cardListResponse.checkResponseValidity()) {
                bindData(true);
            } else if (!WalletLoginHelper.getInstance().isLogin()) {
                this.mBankLayout.setData(false, null, 0, true, null);
                this.f27160b.setVisibility(0);
            } else {
                getCacheData();
                syncData();
            }
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            super.onAttach(activity);
            if (Build.VERSION.SDK_INT < 23) {
                a(activity);
            }
        }
    }

    private void a(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, this, i2, obj, str) == null) {
            CardListCache.getInstance().updateCardList(i2, (CardListResponse) obj);
        }
    }
}
