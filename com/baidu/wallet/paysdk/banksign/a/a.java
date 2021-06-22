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
    public static Pattern f25270a = Pattern.compile("(.*)(selected_card_no=[^&]+)(.*)");

    /* renamed from: b  reason: collision with root package name */
    public String f25271b;

    /* renamed from: c  reason: collision with root package name */
    public String f25272c;

    /* renamed from: d  reason: collision with root package name */
    public String f25273d;

    /* renamed from: e  reason: collision with root package name */
    public String f25274e;

    /* renamed from: f  reason: collision with root package name */
    public String f25275f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f25276g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25277h;

    /* renamed from: i  reason: collision with root package name */
    public String f25278i;
    public j j;
    public PayTypeActivity k;
    public OrderConfirmActivity l;

    /* renamed from: com.baidu.wallet.paysdk.banksign.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0257a {

        /* renamed from: a  reason: collision with root package name */
        public static a f25279a = new a();
    }

    public static a a() {
        return C0257a.f25279a;
    }

    public String b() {
        return this.f25278i;
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
        return this.f25277h;
    }

    public String g() {
        return this.f25273d;
    }

    public String h() {
        return this.f25272c;
    }

    public String i() {
        return this.f25274e;
    }

    public String j() {
        return this.f25275f;
    }

    public byte[] k() {
        return this.f25276g;
    }

    public String l() {
        return this.f25271b;
    }

    public void m() {
        this.f25276g = null;
        this.j = null;
        this.l = null;
        this.k = null;
    }

    public a() {
        this.f25277h = false;
    }

    public void a(String str) {
        this.f25278i = str;
    }

    public void b(String str) {
        this.f25273d = str;
    }

    public void c(String str) {
        this.f25272c = str;
    }

    public void d(String str) {
        this.f25274e = str;
    }

    public void e(String str) {
        this.f25275f = str;
    }

    public void f(String str) {
        this.f25271b = str;
    }

    public String g(String str) {
        String group;
        String orderExtraInfo = PayDataCache.getInstance().getOrderExtraInfo();
        PayDataCache.getInstance().getPayResponse().pay.selected_card_no = str;
        if (TextUtils.isEmpty(orderExtraInfo)) {
            return null;
        }
        Matcher matcher = f25270a.matcher(orderExtraInfo);
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
        this.f25277h = z;
    }

    public void a(byte[] bArr) {
        this.f25276g = bArr;
    }
}
