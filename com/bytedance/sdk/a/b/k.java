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
    final String piZ;

    /* renamed from: a  reason: collision with root package name */
    static final Comparator<String> f5963a = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.k.1
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
    private static final Map<String, k> pgN = new TreeMap(f5963a);
    public static final k pgO = cj("SSL_RSA_WITH_NULL_MD5", 1);
    public static final k pgP = cj("SSL_RSA_WITH_NULL_SHA", 2);
    public static final k pgQ = cj("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final k pgR = cj("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final k pgS = cj("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final k pgT = cj("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final k pgU = cj("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final k pgV = cj("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final k pgW = cj("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final k pgX = cj("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final k pgY = cj("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final k pgZ = cj("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final k pha = cj("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final k phb = cj("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final k phc = cj("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final k phd = cj("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final k phe = cj("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final k phf = cj("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final k phg = cj("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final k phh = cj("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final k phi = cj("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final k phj = cj("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final k phk = cj("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final k phl = cj("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final k phm = cj("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final k phn = cj("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final k pho = cj("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final k php = cj("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final k phq = cj("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final k phr = cj("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final k phs = cj("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final k pht = cj("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final k phu = cj("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final k phv = cj("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final k phw = cj("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final k phx = cj("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final k phy = cj("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final k phz = cj("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final k phA = cj("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final k phB = cj("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final k phC = cj("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final k phD = cj("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final k phE = cj("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final k phF = cj("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final k phG = cj("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final k phH = cj("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final k phI = cj("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final k phJ = cj("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final k phK = cj("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final k phL = cj("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
    public static final k phM = cj("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final k phN = cj("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final k phO = cj("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final k phP = cj("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final k phQ = cj("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final k phR = cj("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final k phS = cj("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final k phT = cj("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final k phU = cj("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final k phV = cj("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Opcodes.IFLE);
    public static final k phW = cj("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
    public static final k phX = cj("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final k phY = cj("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
    public static final k phZ = cj("TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
    public static final k pia = cj("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final k pib = cj("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final k pie = cj("TLS_FALLBACK_SCSV", 22016);
    public static final k pif = cj("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final k pig = cj("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final k pih = cj("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final k pii = cj("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final k pij = cj("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final k pik = cj("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final k pil = cj("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final k pim = cj("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final k pio = cj("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final k pip = cj("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final k piq = cj("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final k pir = cj("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final k pis = cj("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final k pit = cj("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final k piu = cj("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final k piv = cj("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final k piw = cj("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final k pix = cj("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final k piy = cj("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final k piz = cj("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final k piA = cj("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final k piB = cj("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final k piC = cj("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final k piD = cj("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final k piE = cj("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final k piF = cj("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final k piG = cj("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final k piH = cj("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final k piI = cj("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final k piJ = cj("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final k piK = cj("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final k piL = cj("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final k piM = cj("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final k piN = cj("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final k piO = cj("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final k piP = cj("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final k piQ = cj("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final k piR = cj("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final k piS = cj("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final k piT = cj("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final k piU = cj("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final k piV = cj("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final k piW = cj("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final k piX = cj("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final k piY = cj("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    public static synchronized k XC(String str) {
        k kVar;
        synchronized (k.class) {
            kVar = pgN.get(str);
            if (kVar == null) {
                kVar = new k(str);
                pgN.put(str, kVar);
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<k> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(XC(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private k(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.piZ = str;
    }

    private static k cj(String str, int i) {
        return XC(str);
    }

    public String toString() {
        return this.piZ;
    }
}
