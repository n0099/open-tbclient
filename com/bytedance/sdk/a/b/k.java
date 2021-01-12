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
    final String piY;

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
    private static final Map<String, k> pgM = new TreeMap(f5963a);
    public static final k pgN = ci("SSL_RSA_WITH_NULL_MD5", 1);
    public static final k pgO = ci("SSL_RSA_WITH_NULL_SHA", 2);
    public static final k pgP = ci("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final k pgQ = ci("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final k pgR = ci("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final k pgS = ci("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final k pgT = ci("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final k pgU = ci("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final k pgV = ci("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final k pgW = ci("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final k pgX = ci("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final k pgY = ci("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final k pgZ = ci("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final k pha = ci("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final k phb = ci("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final k phc = ci("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final k phd = ci("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final k phe = ci("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final k phf = ci("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final k phg = ci("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final k phh = ci("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final k phi = ci("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final k phj = ci("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final k phk = ci("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final k phl = ci("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final k phm = ci("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final k phn = ci("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final k pho = ci("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final k php = ci("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final k phq = ci("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final k phr = ci("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final k phs = ci("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final k pht = ci("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final k phu = ci("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final k phv = ci("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final k phw = ci("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final k phx = ci("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final k phy = ci("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final k phz = ci("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final k phA = ci("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final k phB = ci("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final k phC = ci("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final k phD = ci("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final k phE = ci("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final k phF = ci("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final k phG = ci("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final k phH = ci("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final k phI = ci("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final k phJ = ci("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final k phK = ci("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
    public static final k phL = ci("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final k phM = ci("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final k phN = ci("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final k phO = ci("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final k phP = ci("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final k phQ = ci("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final k phR = ci("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final k phS = ci("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final k phT = ci("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final k phU = ci("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Opcodes.IFLE);
    public static final k phV = ci("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
    public static final k phW = ci("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final k phX = ci("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
    public static final k phY = ci("TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
    public static final k phZ = ci("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final k pia = ci("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final k pib = ci("TLS_FALLBACK_SCSV", 22016);
    public static final k pie = ci("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final k pif = ci("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final k pig = ci("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final k pih = ci("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final k pii = ci("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final k pij = ci("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final k pik = ci("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final k pil = ci("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final k pim = ci("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final k pio = ci("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final k pip = ci("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final k piq = ci("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final k pir = ci("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final k pis = ci("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final k pit = ci("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final k piu = ci("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final k piv = ci("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final k piw = ci("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final k pix = ci("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final k piy = ci("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final k piz = ci("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final k piA = ci("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final k piB = ci("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final k piC = ci("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final k piD = ci("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final k piE = ci("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final k piF = ci("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final k piG = ci("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final k piH = ci("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final k piI = ci("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final k piJ = ci("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final k piK = ci("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final k piL = ci("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final k piM = ci("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final k piN = ci("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final k piO = ci("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final k piP = ci("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final k piQ = ci("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final k piR = ci("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final k piS = ci("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final k piT = ci("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final k piU = ci("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final k piV = ci("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final k piW = ci("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final k piX = ci("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    public static synchronized k XB(String str) {
        k kVar;
        synchronized (k.class) {
            kVar = pgM.get(str);
            if (kVar == null) {
                kVar = new k(str);
                pgM.put(str, kVar);
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<k> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(XB(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private k(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.piY = str;
    }

    private static k ci(String str, int i) {
        return XB(str);
    }

    public String toString() {
        return this.piY;
    }
}
