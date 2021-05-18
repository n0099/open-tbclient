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
    public static final String f24057a = "BaiduTraffic";

    /* renamed from: b  reason: collision with root package name */
    public Context f24058b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, a> f24059c;

    /* renamed from: com.baidu.wallet.fastpay.sdk.BaiduTraffic$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements PayCallBack {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetTrafficOrderResponse f24060a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f24061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaiduTraffic f24062c;

        @Override // com.baidu.android.pay.PayCallBack
        public boolean isHideLoadingDialog() {
            return false;
        }

        @Override // com.baidu.android.pay.PayCallBack
        public void onPayResult(final int i2, String str) {
            if (i2 != 0 && i2 != 1) {
                a a2 = this.f24062c.a(this.f24061b);
                if (a2 != null) {
                    a2.a(this.f24061b, 0, new a.C0232a(i2, ""));
                    this.f24062c.b(this.f24061b);
                    return;
                }
                return;
            }
            GetTrafficOrderResponse getTrafficOrderResponse = this.f24060a;
            if (getTrafficOrderResponse != null && !TextUtils.isEmpty(getTrafficOrderResponse.orderNo) && this.f24060a.isGotoResultActivity()) {
                GetTrafficOrderResponse.Params params = this.f24060a.params;
                WalletMobileResultActivity.gotoBusniessResultPage(this.f24062c.f24058b, false, this.f24060a.orderNo, params != null ? params.pay_desc : "", i2 == 1, new ResultPageStateListener() { // from class: com.baidu.wallet.fastpay.sdk.BaiduTraffic.1.1
                    @Override // com.baidu.wallet.api.ResultPageStateListener
                    public void onConfirm() {
                        PayStateTrafficModle payStateTrafficModle = new PayStateTrafficModle(i2);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a a3 = anonymousClass1.f24062c.a(anonymousClass1.f24061b);
                        if (a3 != null) {
                            a3.a(AnonymousClass1.this.f24061b, 1, payStateTrafficModle);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f24062c.b(anonymousClass12.f24061b);
                        }
                    }
                });
                return;
            }
            PayStateTrafficModle payStateTrafficModle = new PayStateTrafficModle(i2);
            a a3 = this.f24062c.a(this.f24061b);
            if (a3 != null) {
                a3.a(this.f24061b, 1, payStateTrafficModle);
                this.f24062c.b(this.f24061b);
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

        public PayStateTrafficModle(int i2) {
            this.statecode = i2;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2, int i3, a.C0232a c0232a);

        void a(int i2, int i3, Object obj);
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static BaiduTraffic f24065a = new BaiduTraffic(null);
    }

    public /* synthetic */ BaiduTraffic(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(int i2) {
        Map<Integer, a> map = this.f24059c;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f24059c.remove(Integer.valueOf(i2));
    }

    public BaiduTraffic() {
        this.f24059c = new HashMap();
    }

    public static BaiduTraffic a() {
        return b.f24065a;
    }

    public boolean a(String str) {
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }

    public a a(int i2) {
        Map<Integer, a> map = this.f24059c;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return this.f24059c.get(Integer.valueOf(i2));
    }
}
