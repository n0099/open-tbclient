package com.bytedance.sdk.a.b;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class k {
    final String pvU;

    /* renamed from: a  reason: collision with root package name */
    static final Comparator<String> f4004a = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.k.1
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
    private static final Map<String, k> ptL = new TreeMap(f4004a);
    public static final k ptM = ck("SSL_RSA_WITH_NULL_MD5", 1);
    public static final k ptN = ck("SSL_RSA_WITH_NULL_SHA", 2);
    public static final k ptO = ck("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final k ptP = ck("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final k ptQ = ck("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final k ptR = ck("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final k ptS = ck("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final k ptT = ck("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final k ptU = ck("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final k ptV = ck("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final k ptW = ck("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final k ptX = ck("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final k ptY = ck("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final k ptZ = ck("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final k pua = ck("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final k pub = ck("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final k puc = ck("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final k pud = ck("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final k pue = ck("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final k puf = ck("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final k pug = ck("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final k puh = ck("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final k pui = ck("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final k puj = ck("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final k puk = ck("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final k pul = ck("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final k pum = ck("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final k pun = ck("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final k puo = ck("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final k pup = ck("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final k puq = ck("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final k pur = ck("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final k pus = ck("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final k put = ck("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final k puu = ck("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final k puv = ck("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final k puw = ck("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final k pux = ck("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final k puy = ck("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final k puz = ck("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final k puA = ck("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final k puB = ck("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final k puC = ck("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final k puD = ck("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final k puE = ck("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final k puF = ck("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final k puG = ck("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final k puH = ck("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final k puI = ck("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final k puJ = ck("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
    public static final k puK = ck("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final k puL = ck("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final k puM = ck("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final k puN = ck("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final k puO = ck("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final k puP = ck("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final k puQ = ck("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final k puR = ck("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final k puS = ck("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final k puT = ck("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Opcodes.IFLE);
    public static final k puU = ck("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
    public static final k puV = ck("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final k puW = ck("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
    public static final k puX = ck("TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
    public static final k puY = ck("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final k puZ = ck("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final k pva = ck("TLS_FALLBACK_SCSV", 22016);
    public static final k pvb = ck("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final k pvc = ck("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final k pvd = ck("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final k pve = ck("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final k pvf = ck("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final k pvg = ck("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final k pvh = ck("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final k pvi = ck("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final k pvj = ck("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final k pvk = ck("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final k pvl = ck("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final k pvm = ck("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final k pvn = ck("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final k pvo = ck("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final k pvp = ck("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final k pvq = ck("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final k pvr = ck("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final k pvs = ck("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final k pvt = ck("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final k pvu = ck("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final k pvv = ck("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final k pvw = ck("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final k pvx = ck("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final k pvy = ck("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final k pvz = ck("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final k pvA = ck("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final k pvB = ck("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final k pvC = ck("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final k pvD = ck("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final k pvE = ck("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final k pvF = ck("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final k pvG = ck("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final k pvH = ck("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final k pvI = ck("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final k pvJ = ck("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final k pvK = ck("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final k pvL = ck("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final k pvM = ck("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final k pvN = ck("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final k pvO = ck("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final k pvP = ck("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final k pvQ = ck("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final k pvR = ck("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final k pvS = ck("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final k pvT = ck("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    public static synchronized k YW(String str) {
        k kVar;
        synchronized (k.class) {
            kVar = ptL.get(str);
            if (kVar == null) {
                kVar = new k(str);
                ptL.put(str, kVar);
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<k> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(YW(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private k(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.pvU = str;
    }

    private static k ck(String str, int i) {
        return YW(str);
    }

    public String toString() {
        return this.pvU;
    }
}
