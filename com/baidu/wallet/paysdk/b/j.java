package com.baidu.wallet.paysdk.b;

import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public interface j {
    public static final String q = "j";

    boolean C();

    String D();

    boolean E();

    boolean F();

    com.baidu.wallet.paysdk.datamodel.a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo);

    void a();

    void a(BindFastRequest bindFastRequest);

    void a(BindCardBaseActivity bindCardBaseActivity);

    void a(String str);

    String[] a(int i2);

    void b(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo);

    boolean b();

    String c();

    void c(String... strArr);

    void d(String... strArr);

    boolean d();

    boolean e();

    void f();

    boolean g();

    String h();

    boolean i();

    boolean j();

    boolean k();

    boolean l();

    boolean m();

    boolean n();

    void o();

    String p();

    boolean q();

    void r();

    boolean s();

    boolean t();

    com.baidu.wallet.paysdk.datamodel.a u();

    GetCardInfoResponse.CertificateTypeInfo[] v();

    GetCardInfoResponse.CertificateTypeInfo w();

    int x();

    boolean y();

    ArrayList<CharSequence> z();
}
