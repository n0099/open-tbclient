package com.baidu.tieba.wallet;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class WalletStatisticKey {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_PURCHASE_MEMBER_CLICK = "c10596";
    public static final String KEY_PURCHASE_MEMBER_VISIT = "c10608";
    public static final String KEY_PURCHASE_TDOU_CLICK = "c10611";
    public static final String KEY_PURCHASE_TDOU_VISIT = "c10615";
    public transient /* synthetic */ FieldHolder $fh;

    public WalletStatisticKey() {
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
