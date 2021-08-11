package com.baidu.wallet.paysdk.precashier;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.beans.PrecashierModifyPayTypeBean;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.base.widget.LoadingDialog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes8.dex */
public class PrecashierModifyPayTypeManager implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LoadingDialog f62247a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f62248b;

    /* renamed from: c  reason: collision with root package name */
    public PrecashierModifyPayTypeBean f62249c;

    /* renamed from: d  reason: collision with root package name */
    public TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> f62250d;

    /* renamed from: e  reason: collision with root package name */
    public String f62251e;

    /* loaded from: classes8.dex */
    public static class TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PrecashierModifyPayTypeDefaultData datas;
        public final Boolean isFromChange;

        public TwoTupleForPrecashier(Boolean r6, PrecashierModifyPayTypeDefaultData precashiermodifypaytypedefaultdata) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r6, precashiermodifypaytypedefaultdata};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isFromChange = r6;
            this.datas = precashiermodifypaytypedefaultdata;
        }

        public Boolean isFromChange() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isFromChange : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PrecashierModifyPayTypeManager f62257a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-617913185, "Lcom/baidu/wallet/paysdk/precashier/PrecashierModifyPayTypeManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-617913185, "Lcom/baidu/wallet/paysdk/precashier/PrecashierModifyPayTypeManager$a;");
                    return;
                }
            }
            f62257a = new PrecashierModifyPayTypeManager();
        }
    }

    public static PrecashierModifyPayTypeManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.f62257a : (PrecashierModifyPayTypeManager) invokeV.objValue;
    }

    public void dismissLoadingDialog() {
        LoadingDialog loadingDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (loadingDialog = this.f62247a) == null) {
            return;
        }
        loadingDialog.dismiss();
        this.f62247a = null;
    }

    public TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> generateTwoTupleForPrecashier(boolean z, PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, precashierModifyPayTypeDefaultData)) == null) ? new TwoTupleForPrecashier<>(Boolean.valueOf(z), precashierModifyPayTypeDefaultData) : (TwoTupleForPrecashier) invokeZL.objValue;
    }

    public void getModifyPayType(Activity activity, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, map) == null) {
            setTwoTupleForPrecashier(new TwoTupleForPrecashier<>(Boolean.TRUE, a(map)));
            this.f62248b = new WeakReference<>(activity);
            showLoadingDialog();
            if (this.f62249c == null) {
                this.f62249c = new PrecashierModifyPayTypeBean(activity);
            }
            PrecashierModifyPayTypeBean precashierModifyPayTypeBean = this.f62249c;
            precashierModifyPayTypeBean.rec_params = map;
            precashierModifyPayTypeBean.setResponseCallback(this);
            this.f62249c.execBean();
        }
    }

    public String getSpNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62251e : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
            this.f62249c = null;
            dismissLoadingDialog();
            new Handler(Looper.getMainLooper()).post(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62255a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PrecashierModifyPayTypeManager f62256b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62256b = this;
                    this.f62255a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f62256b.f62248b != null && this.f62256b.f62248b.get() != null) {
                            GlobalUtils.toast((Context) this.f62256b.f62248b.get(), this.f62255a);
                        }
                        PayController.getInstance().clearPreModifiedCallBack();
                    }
                }
            });
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) {
            dismissLoadingDialog();
            new Handler(Looper.getMainLooper()).post(new Runnable(this, obj, i2) { // from class: com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object f62252a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f62253b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PrecashierModifyPayTypeManager f62254c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62254c = this;
                    this.f62252a = obj;
                    this.f62253b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Object obj2 = this.f62252a;
                        if (obj2 != null) {
                            if (this.f62253b != 2) {
                                this.f62254c.f62249c = null;
                                return;
                            }
                            PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse = (PrecashierModifyPayTypeResponse) obj2;
                            if (this.f62254c.f62249c != null) {
                                precashierModifyPayTypeResponse.setOriginHttpResponse(this.f62254c.f62249c.getHttpRealContent());
                            }
                            if (precashierModifyPayTypeResponse.checkResponseValidity()) {
                                if (this.f62254c.f62248b != null && this.f62254c.f62248b.get() != null) {
                                    PayController.getInstance().modifyPayType((Context) this.f62254c.f62248b.get(), this.f62254c.f62250d);
                                    return;
                                } else {
                                    this.f62254c.f62249c = null;
                                    return;
                                }
                            }
                            this.f62254c.f62249c = null;
                            return;
                        }
                        this.f62254c.f62249c = null;
                    }
                }
            });
        }
    }

    public void setSpNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f62251e = str;
        }
    }

    public void setTwoTupleForPrecashier(TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, twoTupleForPrecashier) == null) {
            this.f62250d = twoTupleForPrecashier;
        }
    }

    public void showLoadingDialog() {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f62247a == null && (weakReference = this.f62248b) != null && weakReference.get() != null && (this.f62248b.get() instanceof Activity) && !this.f62248b.get().isFinishing()) {
                this.f62247a = new LoadingDialog(this.f62248b.get());
            }
            LoadingDialog loadingDialog = this.f62247a;
            if (loadingDialog != null) {
                loadingDialog.show();
            }
        }
    }

    public PrecashierModifyPayTypeManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private PrecashierModifyPayTypeDefaultData a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
            PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
            if (map != null && !map.isEmpty()) {
                Object obj = map.get("pay_type");
                String str = (obj == null || !(obj instanceof String)) ? null : (String) obj;
                if (TextUtils.isEmpty(str)) {
                    return precashierModifyPayTypeDefaultData;
                }
                if ("balance".equals(str)) {
                    precashierModifyPayTypeDefaultData.setDatas(str, "", null);
                } else if ("easypay".equals(str)) {
                    Object obj2 = map.get("account_no");
                    String str2 = (obj2 == null || !(obj2 instanceof String)) ? null : (String) obj2;
                    PrecashierModifyPayTypeDefaultData.Card card = new PrecashierModifyPayTypeDefaultData.Card();
                    card.account_no = str2;
                    precashierModifyPayTypeDefaultData.setDatas(str, null, card);
                }
                map.remove("pay_type");
                map.remove("account_no");
            }
            return precashierModifyPayTypeDefaultData;
        }
        return (PrecashierModifyPayTypeDefaultData) invokeL.objValue;
    }
}
