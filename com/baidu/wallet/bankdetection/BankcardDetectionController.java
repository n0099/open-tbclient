package com.baidu.wallet.bankdetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes8.dex */
public class BankcardDetectionController extends Observable implements NoProguard, Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IDetectionListener f60214a;

    /* renamed from: com.baidu.wallet.bankdetection.BankcardDetectionController$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface IDetectionListener extends NoProguard {
        void onFail(int i2, String str);

        void onResult(String str);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BankcardDetectionController f60215a;
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
            f60215a = new BankcardDetectionController(null);
        }
    }

    public /* synthetic */ BankcardDetectionController(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BankcardDetectionController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f60215a : (BankcardDetectionController) invokeV.objValue;
    }

    public void clearCardDetectionCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60214a = null;
        }
    }

    public void gotoDetctionCard(Context context, IDetectionListener iDetectionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iDetectionListener) == null) {
            StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ENTER, "");
            if (iDetectionListener == null) {
                return;
            }
            StatHelper.cacheBankCardStartTime(System.currentTimeMillis());
            this.f60214a = iDetectionListener;
            Intent intent = new Intent(context, BankCardDetectionActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, observable, obj) == null) {
            if (this.f60214a != null) {
                this.f60214a.onResult(obj == null ? "" : (String) obj);
                this.f60214a = null;
            }
            this.f60214a = null;
        }
    }

    public void updateFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            IDetectionListener iDetectionListener = this.f60214a;
            if (iDetectionListener != null) {
                iDetectionListener.onFail(i2, str);
                this.f60214a = null;
            }
            this.f60214a = null;
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
            }
        }
    }
}
