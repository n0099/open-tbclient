package com.baidu.wallet.bankdetection.entrance;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.bankdetection.BankcardDetectionController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.utils.BdWalletUtils;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class BankCardDetectionAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BankCardDetectionAction() {
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
        BdWalletUtils.putFunctionNameList("detectBankCard");
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            BankcardDetectionController.getInstance().gotoDetctionCard(context, new BankcardDetectionController.IDetectionListener(this, routerCallback) { // from class: com.baidu.wallet.bankdetection.entrance.BankCardDetectionAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RouterCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDetectionAction f49065b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, routerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f49065b = this;
                    this.a = routerCallback;
                }

                @Override // com.baidu.wallet.bankdetection.BankcardDetectionController.IDetectionListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.a == null) {
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errorMsg", str);
                    hashMap2.put("errCode", Integer.valueOf(i2));
                    this.a.onResult(1, hashMap2);
                }

                @Override // com.baidu.wallet.bankdetection.BankcardDetectionController.IDetectionListener
                public void onResult(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.a == null) {
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("card_num", str);
                    this.a.onResult(0, hashMap2);
                }
            });
        }
    }
}
