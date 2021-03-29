package com.baidu.wallet.paysdk.payresult.presenter;

import android.os.Bundle;
import com.baidu.wallet.paysdk.datamodel.Compliance;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();

        boolean a(Bundle bundle);

        void b(Bundle bundle);

        boolean b();

        void c();

        boolean c(Bundle bundle);

        ArrayList<String> f();

        void g();

        void h();

        boolean j();

        FeedbackDialog.a k();
    }

    /* renamed from: com.baidu.wallet.paysdk.payresult.presenter.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0268b {
        void finishPage();

        void initActionBar(String str);

        void initViewElements();

        void setOKBtnText(String str);

        void setTitleLogo(String str);

        boolean showAuthDialog(Compliance compliance);

        void showAuthorizeMsg(String str);

        void showDiscountTypeInfo(String[][] strArr, String str, String str2);

        void showExpectedTime(String str);

        void showMarketDialog(String str, String str2);

        void showPayResultMoneyLayoutVisible(boolean z);

        void showPayResultRealMoneyText(String str);

        void showPaySuccess(HashMap<String, String> hashMap);

        void showPayTypeInfo(String[][] strArr, String str, String str2, String str3);

        void showPaying(HashMap<String, String> hashMap);

        void showTotalAmountInfo(String str, String str2, String str3);
    }
}
