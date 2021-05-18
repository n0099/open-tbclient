package com.baidu.wallet.paysdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0245a> f25080a;

    /* renamed from: com.baidu.wallet.paysdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0245a {
        boolean a(CharSequence charSequence);
    }

    /* loaded from: classes5.dex */
    public static class b implements InterfaceC0245a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25082a = Pattern.compile("^[A-z0-9*]{1,50}$");

        public b() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0245a
        public boolean a(CharSequence charSequence) {
            return f25082a.matcher(charSequence).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements InterfaceC0245a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25083a = Pattern.compile("^[HM]\\d{8,10}$");

        public c() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0245a
        public boolean a(CharSequence charSequence) {
            return f25083a.matcher(charSequence).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements InterfaceC0245a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25084a = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");

        public d() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0245a
        public boolean a(CharSequence charSequence) {
            return f25084a.matcher(charSequence).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements InterfaceC0245a {
        public e() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0245a
        public boolean a(CharSequence charSequence) {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements InterfaceC0245a {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25085a = Pattern.compile("^[A-Za-z0-9]{1,18}$");

        public f() {
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0245a
        public boolean a(CharSequence charSequence) {
            return f25085a.matcher(charSequence).matches();
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
        for (InterfaceC0245a interfaceC0245a : this.f25080a) {
            if (interfaceC0245a.a(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public a(long j) {
        this.f25080a = new ArrayList();
        if (a(j, 2L)) {
            this.f25080a.add(new d());
        }
        if (a(j, 4L)) {
            this.f25080a.add(new f());
        }
        if (a(j, 8L)) {
            this.f25080a.add(new c());
        }
        if (a(j, 16L)) {
            this.f25080a.add(new e());
        }
        if (a(j, 1L)) {
            this.f25080a.add(new b());
        }
    }
}
