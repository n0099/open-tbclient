package com.baidu.wallet.paysdk.banksign.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.presenter.j;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f25134a = Pattern.compile("(.*)(selected_card_no=[^&]+)(.*)");

    /* renamed from: b  reason: collision with root package name */
    public String f25135b;

    /* renamed from: c  reason: collision with root package name */
    public String f25136c;

    /* renamed from: d  reason: collision with root package name */
    public String f25137d;

    /* renamed from: e  reason: collision with root package name */
    public String f25138e;

    /* renamed from: f  reason: collision with root package name */
    public String f25139f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f25140g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25141h;
    public String i;
    public j j;
    public PayTypeActivity k;
    public OrderConfirmActivity l;

    /* renamed from: com.baidu.wallet.paysdk.banksign.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0267a {

        /* renamed from: a  reason: collision with root package name */
        public static a f25142a = new a();
    }

    public static a a() {
        return C0267a.f25142a;
    }

    public String b() {
        return this.i;
    }

    public OrderConfirmActivity c() {
        return this.l;
    }

    public PayTypeActivity d() {
        return this.k;
    }

    public j e() {
        return this.j;
    }

    public boolean f() {
        return this.f25141h;
    }

    public String g() {
        return this.f25137d;
    }

    public String h() {
        return this.f25136c;
    }

    public String i() {
        return this.f25138e;
    }

    public String j() {
        return this.f25139f;
    }

    public byte[] k() {
        return this.f25140g;
    }

    public String l() {
        return this.f25135b;
    }

    public void m() {
        this.f25140g = null;
        this.j = null;
        this.l = null;
        this.k = null;
    }

    public a() {
        this.f25141h = false;
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.f25137d = str;
    }

    public void c(String str) {
        this.f25136c = str;
    }

    public void d(String str) {
        this.f25138e = str;
    }

    public void e(String str) {
        this.f25139f = str;
    }

    public void f(String str) {
        this.f25135b = str;
    }

    public String g(String str) {
        String group;
        String orderExtraInfo = PayDataCache.getInstance().getOrderExtraInfo();
        PayDataCache.getInstance().getPayResponse().pay.selected_card_no = str;
        if (TextUtils.isEmpty(orderExtraInfo)) {
            return null;
        }
        Matcher matcher = f25134a.matcher(orderExtraInfo);
        if (!matcher.matches() || 3 != matcher.groupCount() || (group = matcher.group(2)) == null || str == null) {
            return orderExtraInfo;
        }
        String encode = Uri.encode(str);
        return orderExtraInfo.replace(group, "selected_card_no=" + encode);
    }

    public void a(OrderConfirmActivity orderConfirmActivity) {
        this.l = orderConfirmActivity;
    }

    public void a(PayTypeActivity payTypeActivity) {
        this.k = payTypeActivity;
    }

    public void a(j jVar) {
        this.j = jVar;
    }

    public void a(boolean z) {
        this.f25141h = z;
    }

    public void a(byte[] bArr) {
        this.f25140g = bArr;
    }
}
