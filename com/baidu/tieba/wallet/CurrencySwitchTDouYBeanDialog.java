package com.baidu.tieba.wallet;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencySwitchModel;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
/* loaded from: classes5.dex */
public class CurrencySwitchTDouYBeanDialog {
    public static final int MAX_RETRY_TIME = 3;
    public int countNum = 0;
    public a dialog;
    public CurrencySwitchModel mCurrencySwitchModel;
    public TbPageContext mPageContext;

    public CurrencySwitchTDouYBeanDialog(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        CurrencySwitchModel currencySwitchModel = new CurrencySwitchModel(tbPageContext);
        this.mCurrencySwitchModel = currencySwitchModel;
        currencySwitchModel.setOnPostDataCallBack(new CurrencySwitchModel.OnPostDataCallBack() { // from class: com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog.1
            @Override // com.baidu.tieba.wallet.CurrencySwitchModel.OnPostDataCallBack
            public void callback(boolean z, int i2, String str) {
                CurrencySwitchTDouYBeanDialog.this.dealSwitchCurrencyResult(z, i2, str);
            }
        });
    }

    public void dealSwitchCurrencyResult(boolean z, int i2, String str) {
        if (!z) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK_FAIL_REASON).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 2));
            if (k.isEmpty(str)) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.default_t_dou_switching_fail_toast);
            } else {
                l.M(TbadkCoreApplication.getInst().getContext(), str);
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
            if (k.isEmpty(str)) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.default_t_dou_switching_fail_toast);
            } else {
                l.M(TbadkCoreApplication.getInst().getContext(), str);
            }
            showDialog();
        }
    }

    public void onDestroy() {
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

    public void showDialog() {
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
        this.dialog.setMessage(this.mPageContext.getResources().getString(R.string.wallet_t_dou_switch_to_y_bean_tip));
        this.dialog.setPositiveButton(R.string.wallet_t_dou_switch_to_y_bean_i_know, new a.e() { // from class: com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog.2
            @Override // d.a.n0.r.s.a.e
            public void onClick(a aVar3) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CURRENCY_SWITCH_DIALOG_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                if (CurrencySwitchTDouYBeanDialog.this.mCurrencySwitchModel != null) {
                    CurrencySwitchTDouYBeanDialog.this.mCurrencySwitchModel.sendSwitchRequest();
                }
            }
        });
        this.dialog.create(this.mPageContext).show();
    }
}
