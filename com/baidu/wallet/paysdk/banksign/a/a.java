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
    public static Pattern f25188a = Pattern.compile("(.*)(selected_card_no=[^&]+)(.*)");

    /* renamed from: b  reason: collision with root package name */
    public String f25189b;

    /* renamed from: c  reason: collision with root package name */
    public String f25190c;

    /* renamed from: d  reason: collision with root package name */
    public String f25191d;

    /* renamed from: e  reason: collision with root package name */
    public String f25192e;

    /* renamed from: f  reason: collision with root package name */
    public String f25193f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f25194g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25195h;

    /* renamed from: i  reason: collision with root package name */
    public String f25196i;
    public j j;
    public PayTypeActivity k;
    public OrderConfirmActivity l;

    /* renamed from: com.baidu.wallet.paysdk.banksign.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0254a {

        /* renamed from: a  reason: collision with root package name */
        public static a f25197a = new a();
    }

    public static a a() {
        return C0254a.f25197a;
    }

    public String b() {
        return this.f25196i;
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
        return this.f25195h;
    }

    public String g() {
        return this.f25191d;
    }

    public String h() {
        return this.f25190c;
    }

    public String i() {
        return this.f25192e;
    }

    public String j() {
        return this.f25193f;
    }

    public byte[] k() {
        return this.f25194g;
    }

    public String l() {
        return this.f25189b;
    }

    public void m() {
        this.f25194g = null;
        this.j = null;
        this.l = null;
        this.k = null;
    }

    public a() {
        this.f25195h = false;
    }

    public void a(String str) {
        this.f25196i = str;
    }

    public void b(String str) {
        this.f25191d = str;
    }

    public void c(String str) {
        this.f25190c = str;
    }

    public void d(String str) {
        this.f25192e = str;
    }

    public void e(String str) {
        this.f25193f = str;
    }

    public void f(String str) {
        this.f25189b = str;
    }

    public String g(String str) {
        String group;
        String orderExtraInfo = PayDataCache.getInstance().getOrderExtraInfo();
        PayDataCache.getInstance().getPayResponse().pay.selected_card_no = str;
        if (TextUtils.isEmpty(orderExtraInfo)) {
            return null;
        }
        Matcher matcher = f25188a.matcher(orderExtraInfo);
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
        this.f25195h = z;
    }

    public void a(byte[] bArr) {
        this.f25194g = bArr;
    }
}
