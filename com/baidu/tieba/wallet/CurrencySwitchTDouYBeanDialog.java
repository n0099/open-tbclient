package com.baidu.tieba.wallet;

import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.s.t.a;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.wallet.CurrencySwitchModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class CurrencySwitchTDouYBeanDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_RETRY_TIME = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int countNum;
    public a dialog;
    public CurrencySwitchModel mCurrencySwitchModel;
    public TbPageContext mPageContext;

    public CurrencySwitchTDouYBeanDialog(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.wallet.CurrencySwitchModel.OnPostDataCallBack
            public void callback(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    this.this$0.dealSwitchCurrencyResult(z, i4, str);
                }
            }
        });
    }

    public void dealSwitchCurrencyResult(boolean z, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) {
            if (!z) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_FAIL_REASON).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 2));
                if (m.isEmpty(str)) {
                    n.M(TbadkCoreApplication.getInst().getContext(), j.default_t_dou_switching_fail_toast);
                } else {
                    n.N(TbadkCoreApplication.getInst().getContext(), str);
                }
                showDialog();
            } else if (i2 == 0) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_SUCCESS).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TbSingleton.getInstance().getYYLiveConfig().updateStatusAndCache(1);
                a aVar = this.dialog;
                if (aVar == null || !aVar.isShowing()) {
                    return;
                }
                this.dialog.dismiss();
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_FAIL_REASON).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 1));
                if (m.isEmpty(str)) {
                    n.M(TbadkCoreApplication.getInst().getContext(), j.default_t_dou_switching_fail_toast);
                } else {
                    n.N(TbadkCoreApplication.getInst().getContext(), str);
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
            a aVar = this.dialog;
            if (aVar == null || !aVar.isShowing()) {
                return;
            }
            this.dialog.dismiss();
        }
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.dialog;
            if (aVar != null) {
                aVar.dismiss();
                this.dialog = null;
            }
            int i2 = this.countNum;
            if (i2 >= 3) {
                return;
            }
            this.countNum = i2 + 1;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            a aVar2 = new a(this.mPageContext.getPageActivity());
            this.dialog = aVar2;
            aVar2.setCanceledOnTouchOutside(false);
            this.dialog.setMessageShowCenter(true);
            this.dialog.setMessage(this.mPageContext.getResources().getString(j.wallet_t_dou_switch_to_y_bean_tip));
            this.dialog.setPositiveButton(j.wallet_t_dou_switch_to_y_bean_i_know, new a.e(this) { // from class: com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog.2
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // c.a.t0.s.t.a.e
                public void onClick(a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) {
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
