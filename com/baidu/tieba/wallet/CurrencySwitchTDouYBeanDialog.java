package com.baidu.tieba.wallet;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.au4;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.wallet.CurrencySwitchModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CurrencySwitchTDouYBeanDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_RETRY_TIME = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int countNum;
    public au4 dialog;
    public CurrencySwitchModel mCurrencySwitchModel;
    public TbPageContext mPageContext;

    public CurrencySwitchTDouYBeanDialog(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.countNum = 0;
        this.mPageContext = tbPageContext;
        CurrencySwitchModel currencySwitchModel = new CurrencySwitchModel(tbPageContext);
        this.mCurrencySwitchModel = currencySwitchModel;
        currencySwitchModel.setOnPostDataCallBack(new CurrencySwitchModel.OnPostDataCallBack(this) { // from class: com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CurrencySwitchTDouYBeanDialog this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.wallet.CurrencySwitchModel.OnPostDataCallBack
            public void callback(boolean z, int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i3), str}) == null) {
                    this.this$0.dealSwitchCurrencyResult(z, i3, str);
                }
            }
        });
    }

    public void dealSwitchCurrencyResult(boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
            if (!z) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_FAIL_REASON).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 2));
                if (dj.isEmpty(str)) {
                    ej.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f04a1);
                } else {
                    ej.N(TbadkCoreApplication.getInst().getContext(), str);
                }
                showDialog();
            } else if (i == 0) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_SUCCESS).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TbSingleton.getInstance().getYYLiveConfig().updateStatusAndCache(1);
                au4 au4Var = this.dialog;
                if (au4Var == null || !au4Var.isShowing()) {
                    return;
                }
                this.dialog.dismiss();
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_FAIL_REASON).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 1));
                if (dj.isEmpty(str)) {
                    ej.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f04a1);
                } else {
                    ej.N(TbadkCoreApplication.getInst().getContext(), str);
                }
                showDialog();
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CurrencySwitchModel currencySwitchModel = this.mCurrencySwitchModel;
            if (currencySwitchModel != null) {
                currencySwitchModel.onDestroy();
                this.mCurrencySwitchModel = null;
            }
            au4 au4Var = this.dialog;
            if (au4Var == null || !au4Var.isShowing()) {
                return;
            }
            this.dialog.dismiss();
        }
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            au4 au4Var = this.dialog;
            if (au4Var != null) {
                au4Var.dismiss();
                this.dialog = null;
            }
            int i = this.countNum;
            if (i >= 3) {
                return;
            }
            this.countNum = i + 1;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            au4 au4Var2 = new au4(this.mPageContext.getPageActivity());
            this.dialog = au4Var2;
            au4Var2.setCanceledOnTouchOutside(false);
            this.dialog.setMessageShowCenter(true);
            this.dialog.setMessage(this.mPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f15b6));
            this.dialog.setPositiveButton(R.string.obfuscated_res_0x7f0f15b5, new au4.e(this) { // from class: com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CurrencySwitchTDouYBeanDialog this$0;

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
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.au4.e
                public void onClick(au4 au4Var3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, au4Var3) == null) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                        if (this.this$0.mCurrencySwitchModel != null) {
                            this.this$0.mCurrencySwitchModel.sendSwitchRequest();
                        }
                    }
                }
            });
            this.dialog.create(this.mPageContext).show();
        }
    }
}
