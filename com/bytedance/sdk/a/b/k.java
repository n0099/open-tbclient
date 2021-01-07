package com.bytedance.sdk.a.b;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public final class k {
    final String pnB;

    /* renamed from: a  reason: collision with root package name */
    static final Comparator<String> f6263a = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length >= length2 ? 1 : -1;
            }
            return 0;
        }
    };
    private static final Map<String, k> pls = new TreeMap(f6263a);
    public static final k plt = ci("SSL_RSA_WITH_NULL_MD5", 1);
    public static final k plu = ci("SSL_RSA_WITH_NULL_SHA", 2);
    public static final k plv = ci("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final k plw = ci("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final k plx = ci("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final k ply = ci("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final k plz = ci("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final k plA = ci("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final k plB = ci("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final k plC = ci("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final k plD = ci("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final k plE = ci("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final k plF = ci("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final k plG = ci("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final k plH = ci("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final k plI = ci("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final k plJ = ci("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final k plK = ci("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final k plL = ci("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final k plM = ci("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final k plN = ci("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final k plO = ci("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final k plP = ci("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final k plQ = ci("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final k plR = ci("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final k plS = ci("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final k plT = ci("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final k plU = ci("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final k plV = ci("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final k plW = ci("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final k plX = ci("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final k plY = ci("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final k plZ = ci("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final k pma = ci("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final k pmb = ci("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final k pmc = ci("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final k pmd = ci("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final k pme = ci("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final k pmf = ci("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final k pmg = ci("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final k pmh = ci("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final k pmi = ci("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final k pmj = ci("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final k pmk = ci("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final k pml = ci("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final k pmm = ci("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final k pmn = ci("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final k pmo = ci("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final k pmp = ci("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final k pmq = ci("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
    public static final k pmr = ci("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final k pms = ci("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final k pmt = ci("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final k pmu = ci("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final k pmv = ci("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final k pmw = ci("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final k pmx = ci("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final k pmy = ci("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final k pmz = ci("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final k pmA = ci("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Opcodes.IFLE);
    public static final k pmB = ci("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
    public static final k pmC = ci("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final k pmD = ci("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
    public static final k pmE = ci("TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
    public static final k pmF = ci("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final k pmG = ci("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final k pmH = ci("TLS_FALLBACK_SCSV", 22016);
    public static final k pmI = ci("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final k pmJ = ci("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final k pmK = ci("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final k pmL = ci("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final k pmM = ci("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final k pmN = ci("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final k pmO = ci("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final k pmP = ci("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final k pmQ = ci("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final k pmR = ci("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final k pmS = ci("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final k pmT = ci("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final k pmU = ci("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final k pmV = ci("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final k pmW = ci("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final k pmX = ci("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final k pmY = ci("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final k pmZ = ci("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final k pna = ci("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final k pnb = ci("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final k pnc = ci("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final k pnd = ci("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final k pne = ci("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final k pnf = ci("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final k png = ci("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final k pnh = ci("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final k pni = ci("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final k pnj = ci("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final k pnk = ci("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final k pnl = ci("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final k pnm = ci("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final k pnn = ci("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final k pno = ci("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final k pnp = ci("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final k pnq = ci("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final k pnr = ci("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final k pns = ci("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final k pnt = ci("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final k pnu = ci("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final k pnv = ci("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final k pnw = ci("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final k pnx = ci("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final k pny = ci("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final k pnz = ci("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final k pnA = ci("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    public static synchronized k YJ(String str) {
        k kVar;
        synchronized (k.class) {
            kVar = pls.get(str);
            if (kVar == null) {
                kVar = new k(str);
                pls.put(str, kVar);
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<k> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(YJ(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private k(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.pnB = str;
    }

    private static k ci(String str, int i) {
        return YJ(str);
    }

    public String toString() {
        return this.pnB;
    }
}
