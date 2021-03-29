package com.baidu.wallet.paysdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0259a> f25375a;

    /* renamed from: com.baidu.wallet.paysdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0259a {
        boolean a(CharSequence charSequence);
    }

    /* loaded from: classes5.dex */
    public static class b implements InterfaceC0259a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25377a = Pattern.compile("^[A-z0-9*]{1,50}$");

        public b() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0259a
        public boolean a(CharSequence charSequence) {
            return f25377a.matcher(charSequence).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements InterfaceC0259a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25378a = Pattern.compile("^[HM]\\d{8,10}$");

        public c() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0259a
        public boolean a(CharSequence charSequence) {
            return f25378a.matcher(charSequence).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements InterfaceC0259a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25379a = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");

        public d() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0259a
        public boolean a(CharSequence charSequence) {
            return f25379a.matcher(charSequence).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements InterfaceC0259a {
        public e() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0259a
        public boolean a(CharSequence charSequence) {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements InterfaceC0259a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25380a = Pattern.compile("^[A-Za-z0-9]{1,18}$");

        public f() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0259a
        public boolean a(CharSequence charSequence) {
            return f25380a.matcher(charSequence).matches();
        }
    }

    public a() {
        this(14L);
    }

    private boolean a(long j, long j2) {
        return (j & j2) > 0;
    }

    public boolean a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        for (InterfaceC0259a interfaceC0259a : this.f25375a) {
            if (interfaceC0259a.a(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public a(long j) {
        this.f25375a = new ArrayList();
        if (a(j, 2L)) {
            this.f25375a.add(new d());
        }
        if (a(j, 4L)) {
            this.f25375a.add(new f());
        }
        if (a(j, 8L)) {
            this.f25375a.add(new c());
        }
        if (a(j, 16L)) {
            this.f25375a.add(new e());
        }
        if (a(j, 1L)) {
            this.f25375a.add(new b());
        }
    }
}
