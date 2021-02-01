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
    final String pto;

    /* renamed from: a  reason: collision with root package name */
    static final Comparator<String> f5965a = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.k.1
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
    private static final Map<String, k> prf = new TreeMap(f5965a);
    public static final k prg = ck("SSL_RSA_WITH_NULL_MD5", 1);
    public static final k prh = ck("SSL_RSA_WITH_NULL_SHA", 2);
    public static final k pri = ck("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final k prj = ck("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final k prk = ck("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final k prl = ck("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final k prm = ck("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final k prn = ck("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final k pro = ck("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final k prp = ck("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final k prq = ck("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final k prr = ck("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final k prs = ck("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final k prt = ck("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final k pru = ck("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final k prv = ck("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final k prw = ck("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final k prx = ck("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final k pry = ck("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final k prz = ck("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final k prA = ck("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final k prB = ck("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final k prC = ck("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final k prD = ck("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final k prE = ck("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final k prF = ck("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final k prG = ck("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final k prH = ck("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final k prI = ck("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final k prJ = ck("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final k prK = ck("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final k prL = ck("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final k prM = ck("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final k prN = ck("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final k prO = ck("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final k prP = ck("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final k prQ = ck("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final k prR = ck("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final k prS = ck("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final k prT = ck("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final k prU = ck("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final k prV = ck("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final k prW = ck("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final k prX = ck("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final k prY = ck("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final k prZ = ck("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final k psa = ck("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final k psb = ck("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final k psc = ck("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final k psd = ck("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
    public static final k pse = ck("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final k psf = ck("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final k psg = ck("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final k psh = ck("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final k psi = ck("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final k psj = ck("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final k psk = ck("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final k psl = ck("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final k psm = ck("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final k psn = ck("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Opcodes.IFLE);
    public static final k pso = ck("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
    public static final k psp = ck("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final k psq = ck("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
    public static final k psr = ck("TLS_DH_anon_WITH_AES_128_GCM_SHA256", Opcodes.IF_ACMPNE);
    public static final k pss = ck("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final k pst = ck("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final k psu = ck("TLS_FALLBACK_SCSV", 22016);
    public static final k psv = ck("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final k psw = ck("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final k psx = ck("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final k psy = ck("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final k psz = ck("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final k psA = ck("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final k psB = ck("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final k psC = ck("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final k psD = ck("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final k psE = ck("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final k psF = ck("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final k psG = ck("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final k psH = ck("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final k psI = ck("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final k psJ = ck("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final k psK = ck("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final k psL = ck("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final k psM = ck("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final k psN = ck("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final k psO = ck("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final k psP = ck("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final k psQ = ck("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final k psR = ck("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final k psS = ck("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final k psT = ck("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final k psU = ck("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final k psV = ck("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final k psW = ck("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final k psX = ck("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final k psY = ck("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final k psZ = ck("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final k pta = ck("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final k ptb = ck("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final k ptc = ck("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final k ptd = ck("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final k pte = ck("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final k ptf = ck("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final k ptg = ck("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final k pth = ck("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final k pti = ck("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final k ptj = ck("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final k ptk = ck("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final k ptl = ck("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final k ptm = ck("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final k ptn = ck("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    public static synchronized k YD(String str) {
        k kVar;
        synchronized (k.class) {
            kVar = prf.get(str);
            if (kVar == null) {
                kVar = new k(str);
                prf.put(str, kVar);
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<k> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(YD(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private k(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.pto = str;
    }

    private static k ck(String str, int i) {
        return YD(str);
    }

    public String toString() {
        return this.pto;
    }
}
