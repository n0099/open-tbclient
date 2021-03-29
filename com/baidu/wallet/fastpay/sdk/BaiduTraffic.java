package com.baidu.wallet.fastpay.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.ResultPageStateListener;
import com.baidu.wallet.fastpay.datamodel.GetTrafficOrderResponse;
import com.baidu.wallet.fastpay.sdk.a;
import com.baidu.wallet.paysdk.ui.WalletMobileResultActivity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
@SuppressLint({"UseSparseArrays", "StaticFieldLeak"})
/* loaded from: classes5.dex */
public class BaiduTraffic {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24370a = "BaiduTraffic";

    /* renamed from: b  reason: collision with root package name */
    public Context f24371b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, a> f24372c;

    /* renamed from: com.baidu.wallet.fastpay.sdk.BaiduTraffic$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements PayCallBack {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetTrafficOrderResponse f24373a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f24374b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaiduTraffic f24375c;

        @Override // com.baidu.android.pay.PayCallBack
        public boolean isHideLoadingDialog() {
            return false;
        }

        @Override // com.baidu.android.pay.PayCallBack
        public void onPayResult(final int i, String str) {
            if (i != 0 && i != 1) {
                a a2 = this.f24375c.a(this.f24374b);
                if (a2 != null) {
                    a2.a(this.f24374b, 0, new a.C0246a(i, ""));
                    this.f24375c.b(this.f24374b);
                    return;
                }
                return;
            }
            GetTrafficOrderResponse getTrafficOrderResponse = this.f24373a;
            if (getTrafficOrderResponse != null && !TextUtils.isEmpty(getTrafficOrderResponse.orderNo) && this.f24373a.isGotoResultActivity()) {
                GetTrafficOrderResponse.Params params = this.f24373a.params;
                WalletMobileResultActivity.gotoBusniessResultPage(this.f24375c.f24371b, false, this.f24373a.orderNo, params != null ? params.pay_desc : "", i == 1, new ResultPageStateListener() { // from class: com.baidu.wallet.fastpay.sdk.BaiduTraffic.1.1
                    @Override // com.baidu.wallet.api.ResultPageStateListener
                    public void onConfirm() {
                        PayStateTrafficModle payStateTrafficModle = new PayStateTrafficModle(i);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a a3 = anonymousClass1.f24375c.a(anonymousClass1.f24374b);
                        if (a3 != null) {
                            a3.a(AnonymousClass1.this.f24374b, 1, payStateTrafficModle);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f24375c.b(anonymousClass12.f24374b);
                        }
                    }
                });
                return;
            }
            PayStateTrafficModle payStateTrafficModle = new PayStateTrafficModle(i);
            a a3 = this.f24375c.a(this.f24374b);
            if (a3 != null) {
                a3.a(this.f24374b, 1, payStateTrafficModle);
                this.f24375c.b(this.f24374b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class PayStateTrafficModle implements Serializable {
        public static final int PAY_STATUS_CANCEL = 2;
        public static final int PAY_STATUS_PAYING = 1;
        public static final int PAY_STATUS_SUCCESS = 0;
        public static final long serialVersionUID = 393136306694361260L;
        public int statecode;

        public PayStateTrafficModle(int i) {
            this.statecode = i;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, int i2, a.C0246a c0246a);

        void a(int i, int i2, Object obj);
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static BaiduTraffic f24378a = new BaiduTraffic(null);
    }

    public /* synthetic */ BaiduTraffic(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(int i) {
        Map<Integer, a> map = this.f24372c;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f24372c.remove(Integer.valueOf(i));
    }

    public BaiduTraffic() {
        this.f24372c = new HashMap();
    }

    public static BaiduTraffic a() {
        return b.f24378a;
    }

    public boolean a(String str) {
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }

    public a a(int i) {
        Map<Integer, a> map = this.f24372c;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return this.f24372c.get(Integer.valueOf(i));
    }
}
