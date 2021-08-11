package com.baidu.wallet.personal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.a.c;
import com.baidu.wallet.personal.beans.QueryCouponListBean;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UnuseCouponListFragment extends CouponBaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_ID = "UnuseCouponListFragment";
    public static final String KEY = "last_coupon_receive_timestamp_key";
    public static final int REQUEST_CODE_COUPON_DETAIL = 1;
    public static final String TAG;
    public static final String TIMESTAMP = "coupon_recive_timestamp";
    public transient /* synthetic */ FieldHolder $fh;
    public int coupon_receive_timestamp;
    public int last_coupon_receive_timestamp;
    public int mCurrPage;
    public Handler mHandler;
    public c mUnuseCouponAdapter;
    public boolean needRefresh;
    public int recvCount;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-942783571, "Lcom/baidu/wallet/personal/ui/UnuseCouponListFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-942783571, "Lcom/baidu/wallet/personal/ui/UnuseCouponListFragment;");
                return;
            }
        }
        TAG = UnuseCouponListFragment.class.getSimpleName();
    }

    public UnuseCouponListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUnuseCouponAdapter = null;
        this.mHandler = new Handler();
        this.needRefresh = true;
        this.mCurrPage = 0;
        this.last_coupon_receive_timestamp = 0;
        this.recvCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65553, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(((BaseFragment) this).mAct, -1);
            if (i3 == 5003) {
                showEmptyView(i3);
                if (WalletLoginHelper.getInstance().isPassLogin()) {
                    WalletLoginHelper.getInstance().handlerWalletError(5003);
                    if (!TextUtils.isEmpty(str)) {
                        GlobalUtils.toast(((BaseFragment) this).mAct, str);
                    }
                    ((BaseFragment) this).mAct.finish();
                }
            } else if ((this.mCurrPage == 0 && this.mUnuseCouponAdapter == null) || this.mUnuseCouponAdapter.getCount() <= 0) {
                showEmptyView(i3);
                ((CouponBaseFragment) this).mContainer.setVisibility(4);
            } else {
                BaseActivity baseActivity = ((BaseFragment) this).mAct;
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(((BaseFragment) this).mAct, "fp_get_data_fail");
                }
                GlobalUtils.toast(baseActivity, str);
                ((CouponBaseFragment) this).mContainer.onPullDownRefreshComplete();
                ((CouponBaseFragment) this).mContainer.onPullUpRefreshComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryCoupon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            DXMSdkSAUtils.onEventStart("CouponListRequest");
            queryCoupon(((BaseFragment) this).mAct, FRAGMENT_ID, z, this.mCurrPage, QueryCouponListBean.CouponStatus.UNUSE, this);
        }
    }

    private void refreshUI(CouponListResponse couponListResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, this, couponListResponse) == null) && couponListResponse != null && couponListResponse.checkResponseValidity()) {
            ((CouponBaseFragment) this).mContainer.setVisibility(0);
        }
    }

    private void updateData(CouponListResponse couponListResponse) {
        CouponList[] couponListArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, couponListResponse) == null) || couponListResponse == null || (couponListArr = couponListResponse.coupon_list) == null || couponListArr.length < 1) {
            return;
        }
        int i2 = 0;
        while (true) {
            CouponList[] couponListArr2 = couponListResponse.coupon_list;
            if (i2 >= couponListArr2.length) {
                this.mUnuseCouponAdapter.notifyDataSetChanged();
                return;
            }
            String str = couponListArr2[i2].desc;
            if (couponListArr2[i2].coupons != null && couponListArr2[i2].coupons.length > 0) {
                int i3 = 0;
                while (true) {
                    CouponList[] couponListArr3 = couponListResponse.coupon_list;
                    if (i3 < couponListArr3[i2].coupons.length) {
                        if (couponListArr3[i2].coupons[i3].coupon_receive_timestamp > this.coupon_receive_timestamp) {
                            this.coupon_receive_timestamp = couponListArr3[i2].coupons[i3].coupon_receive_timestamp;
                        }
                        CouponList[] couponListArr4 = couponListResponse.coupon_list;
                        couponListArr4[i2].coupons[i3].groupDesc = str;
                        this.recvCount++;
                        this.mUnuseCouponAdapter.a((c) couponListArr4[i2].coupons[i3]);
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseFragment
    public View addCusterview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            init();
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseFragment
    public void handleEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void handleResSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(((BaseFragment) this).mAct, -1);
            if (i2 != 515 || ((BaseFragment) this).mAct == null || str == null || !(obj instanceof CouponListResponse)) {
                return;
            }
            ((CouponBaseFragment) this).mContainer.onPullUpRefreshComplete();
            ((CouponBaseFragment) this).mContainer.onPullDownRefreshComplete();
            CouponListResponse couponListResponse = (CouponListResponse) obj;
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            EventBus.getInstance().post(new EventBus.Event(eventBus, "showTitleBarRightZone", couponListResponse.code_equity));
            if (!(couponListResponse.coupon_list != null && couponListResponse.total_count > 0)) {
                showEmptyView(-1);
                ((CouponBaseFragment) this).mContainer.setVisibility(4);
                return;
            }
            hideEmptyView();
            refreshUI(couponListResponse);
            if (this.mCurrPage == 0) {
                this.mUnuseCouponAdapter.a();
                this.recvCount = 0;
            }
            this.mCurrPage++;
            updateData(couponListResponse);
            LogUtil.d("queryRecords. handleMessage. list size = " + this.recvCount);
            configHasMore(this.recvCount < couponListResponse.total_count, couponListResponse.limit_desc);
            configDxmLogo();
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = getContext();
            if (this.mUnuseCouponAdapter == null) {
                this.mUnuseCouponAdapter = new c(this.mListView, context);
            }
            this.mListView.setAdapter((ListAdapter) this.mUnuseCouponAdapter);
            PassUtil.onCreate();
            ((CouponBaseFragment) this).mContainer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>(this) { // from class: com.baidu.wallet.personal.ui.UnuseCouponListFragment.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ UnuseCouponListFragment f63097a;

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
                    this.f63097a = this;
                }

                @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
                public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, pullToRefreshBase) == null) {
                        this.f63097a.mCurrPage = 0;
                        this.f63097a.queryCoupon(false);
                    }
                }

                @Override // com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener
                public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pullToRefreshBase) == null) {
                        this.f63097a.queryCoupon(false);
                    }
                }
            });
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.personal.ui.UnuseCouponListFragment.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ UnuseCouponListFragment f63098a;

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
                    this.f63098a = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    CouponList.Coupon item;
                    BaiduWalletDelegate baiduWalletDelegate;
                    BaseActivity baseActivity;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f63098a.getActivity() == null || CheckUtils.isFastDoubleClick() || (item = this.f63098a.mUnuseCouponAdapter.getItem(i2)) == null) {
                        return;
                    }
                    if (item.coupon_receive_timestamp > this.f63098a.last_coupon_receive_timestamp) {
                        UnuseCouponListFragment unuseCouponListFragment = this.f63098a;
                        unuseCouponListFragment.last_coupon_receive_timestamp = unuseCouponListFragment.coupon_receive_timestamp;
                        SharedPreferencesUtils.setParam(((BaseFragment) this.f63098a).mAct, UnuseCouponListFragment.TIMESTAMP, UnuseCouponListFragment.KEY, Integer.valueOf(this.f63098a.last_coupon_receive_timestamp));
                        this.f63098a.mUnuseCouponAdapter.b(this.f63098a.last_coupon_receive_timestamp);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("coupon_name", item.coupon_name);
                        jSONObject.put("template_num", item.template_num);
                        jSONObject.put("coupon_num", item.coupon_num);
                        jSONObject.put("card_type", item.card_type);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    DXMSdkSAUtils.onEventWithValues("CouponListToUseBtnClick", Arrays.asList(jSONObject.toString()));
                    CouponList.Coupon.AppSceneService appSceneService = item.app_scene_service;
                    if (appSceneService != null) {
                        if (appSceneService.f63060android > 0) {
                            BaiduWalletServiceController.getInstance().gotoWalletService(((BaseFragment) this.f63098a).mAct, item.app_scene_service.f63060android, "");
                        } else if (!TextUtils.isEmpty(appSceneService.url)) {
                            baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                            baseActivity = ((BaseFragment) this.f63098a).mAct;
                            str = item.app_scene_service.url;
                            baiduWalletDelegate.openH5Module(baseActivity, str, true);
                        }
                    } else if (TextUtils.isEmpty(item.list_scene_service_label_URL)) {
                        Intent intent = new Intent();
                        intent.setClass(((BaseFragment) this.f63098a).mAct, MyCouponDetailActivity.class);
                        intent.putExtra("cardType", item.card_type);
                        intent.putExtra("couponNum", item.coupon_num);
                        intent.putExtra("templateNum", item.template_num);
                        ((BaseFragment) this.f63098a).mAct.startActivityForResult(intent, 1);
                    } else {
                        baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                        baseActivity = ((BaseFragment) this.f63098a).mAct;
                        str = item.list_scene_service_label_URL;
                        baiduWalletDelegate.openH5Module(baseActivity, str, true);
                    }
                    this.f63098a.needRefresh = true;
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.widget.DialogFragment, com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
            DXMSdkSAUtils.onEventEndWithValues("CouponListRequest", 1, Arrays.asList(QueryCouponListBean.CouponStatus.UNUSE.getVal()));
            BaseActivity baseActivity = ((BaseFragment) this).mAct;
            if (baseActivity == null) {
                return;
            }
            baseActivity.runOnUiThread(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.personal.ui.UnuseCouponListFragment.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f63103a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f63104b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f63105c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ UnuseCouponListFragment f63106d;

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
                    this.f63106d = this;
                    this.f63103a = i2;
                    this.f63104b = i3;
                    this.f63105c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((BaseFragment) this.f63106d).mAct == null) {
                        return;
                    }
                    this.f63106d.handleResFailure(this.f63103a, this.f63104b, this.f63105c);
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.widget.DialogFragment, com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) {
            DXMSdkSAUtils.onEventEndWithValues("CouponListRequest", 0, Arrays.asList(QueryCouponListBean.CouponStatus.UNUSE.getVal()));
            this.mHandler.post(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.personal.ui.UnuseCouponListFragment.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f63099a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f63100b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f63101c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ UnuseCouponListFragment f63102d;

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
                    this.f63102d = this;
                    this.f63099a = i2;
                    this.f63100b = obj;
                    this.f63101c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f63102d.handleResSuccess(this.f63099a, this.f63100b, this.f63101c);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            LogUtil.d("coupon", "UnuseCouponListFragment onCreate");
            int intValue = ((Integer) SharedPreferencesUtils.getParam(((BaseFragment) this).mAct, TIMESTAMP, KEY, 0)).intValue();
            this.last_coupon_receive_timestamp = intValue;
            this.coupon_receive_timestamp = intValue;
            if (this.mUnuseCouponAdapter == null) {
                this.mUnuseCouponAdapter = new c(this.mListView, ((BaseFragment) this).mAct);
            }
            this.mUnuseCouponAdapter.b(this.last_coupon_receive_timestamp);
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) ? super.onCreateView(layoutInflater, viewGroup, bundle) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LogUtil.d("coupon", "UnuseCouponListFragment onDestroy");
            int i2 = this.coupon_receive_timestamp;
            if (i2 > this.last_coupon_receive_timestamp) {
                this.last_coupon_receive_timestamp = i2;
                SharedPreferencesUtils.setParam(((BaseFragment) this).mAct, TIMESTAMP, KEY, Integer.valueOf(i2));
                this.mUnuseCouponAdapter.b(this.last_coupon_receive_timestamp);
            }
            BeanManager beanManager = BeanManager.getInstance();
            beanManager.removeAllBeans(FRAGMENT_ID + hashCode());
            this.mUnuseCouponAdapter.a();
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.base.widget.DialogFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            LogUtil.d("coupon", "UnuseCouponListFragment onPause");
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseFragment, com.baidu.wallet.base.widget.DialogFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LogUtil.d("coupon", "UnuseCouponListFragment onResume adapter = " + this.mUnuseCouponAdapter);
            super.onResume();
            if (this.needRefresh) {
                this.needRefresh = false;
                this.mCurrPage = 0;
                queryCoupon(true);
            }
            c cVar = this.mUnuseCouponAdapter;
            if (cVar == null || cVar.getCount() <= 0) {
                return;
            }
            LogUtil.d("coupon", "UnuseCouponListFragment onResume adapterSize = " + this.mUnuseCouponAdapter.getCount());
            this.mUnuseCouponAdapter.notifyDataSetChanged();
            configDxmLogo();
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseFragment
    public void reQueryCoupon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mCurrPage = 0;
            this.mUnuseCouponAdapter.a();
            LogUtil.d("onActivityCreated. onRefresh. curr page = " + this.mCurrPage);
            queryCoupon(true);
        }
    }
}
