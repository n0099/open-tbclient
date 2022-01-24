package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.download.PayDownloadModule;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes13.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IDetectionListener a;

    /* renamed from: b  reason: collision with root package name */
    public Context f50471b;

    /* renamed from: c  reason: collision with root package name */
    public int f50472c;

    /* renamed from: d  reason: collision with root package name */
    public String f50473d;

    /* renamed from: com.baidu.wallet.bankdetection.BankcardDetectionController$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BankcardDetectionController f50475c;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50475c.f50471b == null) {
                return;
            }
            PayDownloadModule payDownloadModule = new PayDownloadModule(this.f50475c.f50471b, BeanConstants.SDK_DOWNLOAD_FILE_OCR_BANKCARD_MODULE_NAME);
            payDownloadModule.setPayDownloadCallBack(new PayDownloadModule.PayDownloadCallBack(this, payDownloadModule) { // from class: com.baidu.wallet.bankdetection.BankcardDetectionController.1.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayDownloadModule a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass1 f50476b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, payDownloadModule};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50476b = this;
                    this.a = payDownloadModule;
                }

                @Override // com.dxmpay.wallet.download.PayDownloadModule.PayDownloadCallBack
                public void onDownloadStatus(String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) {
                        LogUtil.i("WLLLL", "-----成功---downloadPath--->" + str + " ，status=" + i2);
                        if (i2 != 1) {
                            StatisticManager.onEvent(PayStatServiceEvent.BANKCARD_OCR_DOWNLOAD_STATUS, i2 + "");
                        }
                        if (this.a != null) {
                            if (i2 == 2 || i2 == 3) {
                                this.a.resetMD5AndDeleteDownloadFiles(this.f50476b.f50475c.f50471b);
                            }
                        }
                    }
                }
            });
            payDownloadModule.download(this.a, this.f50474b, ".zip");
        }
    }

    /* loaded from: classes13.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i2, String str);

        void onResult(String str);
    }

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static BankcardDetectionController a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2137959831, "Lcom/baidu/wallet/bankdetection/BankcardDetectionController$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2137959831, "Lcom/baidu/wallet/bankdetection/BankcardDetectionController$a;");
                    return;
                }
            }
            a = new BankcardDetectionController(null);
        }
    }

    public /* synthetic */ BankcardDetectionController(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BankcardDetectionController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (BankcardDetectionController) invokeV.objValue;
    }

    public void clearCardDetectionCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iDetectionListener) == null) || iDetectionListener == null) {
            return;
        }
        this.f50471b = context;
        this.a = iDetectionListener;
        StatHelper.cacheUseOcrBankCard(this.f50472c);
        StatHelper.cacheRealityBankCard(0);
        Intent intent = new Intent(context, BankCardDetectionActivity.class);
        StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ENTER, "");
        StatHelper.cacheBankCardStartTime(System.currentTimeMillis());
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void initBankCardDetect(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f50471b = context;
            EventBus.getInstance().registerSticky(this, BeanConstants.SDKINIT_EVENTBUS_EVENTKEY, 0, EventBus.ThreadMode.MainThread);
            EventBus.getInstance().registerSticky(this, BeanConstants.SDKINIT_FAIL_EVENTBUS_EVENTKEY, 0, EventBus.ThreadMode.MainThread);
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            EventBus.getInstance().unregister(this, BeanConstants.SDKINIT_EVENTBUS_EVENTKEY);
            EventBus.getInstance().unregister(this, BeanConstants.SDKINIT_FAIL_EVENTBUS_EVENTKEY);
            String str = SdkInitResponse.getInstance().bankcard_detect;
            LogUtil.d("----d", "sdk/init--成功--" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                LogUtil.d("----d", "obj:" + jSONObject.toString());
                int optInt = jSONObject.optInt("useOcrBankCard", 0);
                this.f50472c = optInt;
                StatHelper.cacheUseOcrBankCard(optInt);
                if (this.f50472c != 1) {
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add("-1");
                arrayList.add(e2.getMessage());
                StatisticManager.onEventWithValues(PayStatServiceEvent.BANKCARD_INIT_STATUS, arrayList);
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, observable, obj) == null) {
            if (this.a != null) {
                this.a.onResult(obj == null ? "" : (String) obj);
                this.a = null;
            }
            this.a = null;
        }
    }

    public void updateFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            IDetectionListener iDetectionListener = this.a;
            if (iDetectionListener != null) {
                iDetectionListener.onFail(i2, str);
                this.a = null;
            }
            this.a = null;
        }
    }

    public BankcardDetectionController() {
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
        this.f50472c = 0;
        this.f50473d = "armeabi-v7a";
    }
}
