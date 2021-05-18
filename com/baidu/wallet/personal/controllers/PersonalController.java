package com.baidu.wallet.personal.controllers;

import android.content.Context;
import android.content.Intent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.personal.PersonWalletSmsActivity;
/* loaded from: classes5.dex */
public class PersonalController {

    /* renamed from: a  reason: collision with root package name */
    public a f26310a;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str);

        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static PersonalController f26311a = new PersonalController();
    }

    public static PersonalController getInstance() {
        return b.f26311a;
    }

    public void onReceiveFailed(String str) {
        a aVar = this.f26310a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void onReceiveSuccess(boolean z) {
        a aVar = this.f26310a;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void receive(Context context, a aVar) {
        this.f26310a = aVar;
        Intent intent = new Intent(context, WalletPayResultCommonActivity.class);
        intent.putExtra(BeanConstants.KEY_PAY_RESULT_TYPE, 3);
        context.startActivity(intent);
    }

    public void receiveWithSms(Context context, a aVar) {
        this.f26310a = aVar;
        Intent intent = new Intent();
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 3);
        intent.setClass(context, PersonWalletSmsActivity.class);
        context.startActivity(intent);
    }

    public void removeCallBack() {
        this.f26310a = null;
    }

    public PersonalController() {
    }
}
