package com.bytedance.sdk.openadsdk.d.b.a;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.bytedance.sdk.openadsdk.d.o;
import com.bytedance.sdk.openadsdk.d.q;
import com.bytedance.sdk.openadsdk.d.t;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final v<Class> f7203a = new v<Class>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Class b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }.a();

    /* renamed from: b  reason: collision with root package name */
    public static final w f7204b = a(Class.class, f7203a);
    public static final v<BitSet> c = new v<BitSet>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public BitSet b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            boolean z2;
            BitSet bitSet = new BitSet();
            aVar.a();
            com.bytedance.sdk.openadsdk.d.d.b f2 = aVar.f();
            int i2 = 0;
            while (f2 != com.bytedance.sdk.openadsdk.d.d.b.END_ARRAY) {
                switch (AnonymousClass30.f7219a[f2.ordinal()]) {
                    case 1:
                        if (aVar.m() == 0) {
                            z2 = false;
                            break;
                        } else {
                            z2 = true;
                            break;
                        }
                    case 2:
                        z2 = aVar.i();
                        break;
                    case 3:
                        String h2 = aVar.h();
                        try {
                            if (Integer.parseInt(h2) == 0) {
                                z2 = false;
                                break;
                            } else {
                                z2 = true;
                                break;
                            }
                        } catch (NumberFormatException e2) {
                            throw new t("Error: Expecting: bitset number value (1, 0), Found: " + h2);
                        }
                    default:
                        throw new t("Invalid bitset value type: " + f2);
                }
                if (z2) {
                    bitSet.set(i2);
                }
                i2++;
                f2 = aVar.f();
            }
            aVar.b();
            return bitSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, BitSet bitSet) throws IOException {
            cVar.b();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.a(bitSet.get(i2) ? 1 : 0);
            }
            cVar.c();
        }
    }.a();
    public static final w d = a(BitSet.class, c);
    public static final v<Boolean> e = new v<Boolean>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Boolean b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.d.d.b f2 = aVar.f();
            if (f2 == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            } else if (f2 == com.bytedance.sdk.openadsdk.d.d.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
            } else {
                return Boolean.valueOf(aVar.i());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Boolean bool) throws IOException {
            cVar.a(bool);
        }
    };
    public static final v<Boolean> f = new v<Boolean>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Boolean b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return Boolean.valueOf(aVar.h());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Boolean bool) throws IOException {
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final w g = a(Boolean.TYPE, Boolean.class, e);
    public static final v<Number> h = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.m());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w i = a(Byte.TYPE, Byte.class, h);
    public static final v<Number> j = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.m());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w k = a(Short.TYPE, Short.class, j);
    public static final v<Number> l = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w m = a(Integer.TYPE, Integer.class, l);
    public static final v<AtomicInteger> n = new v<AtomicInteger>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public AtomicInteger b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.m());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.a(atomicInteger.get());
        }
    }.a();
    public static final w o = a(AtomicInteger.class, n);
    public static final v<AtomicBoolean> p = new v<AtomicBoolean>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public AtomicBoolean b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            return new AtomicBoolean(aVar.i());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.a(atomicBoolean.get());
        }
    }.a();
    public static final w q = a(AtomicBoolean.class, p);
    public static final v<AtomicIntegerArray> r = new v<AtomicIntegerArray>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public AtomicIntegerArray b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.m()));
                } catch (NumberFormatException e2) {
                    throw new t(e2);
                }
            }
            aVar.b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.b();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.a(atomicIntegerArray.get(i2));
            }
            cVar.c();
        }
    }.a();
    public static final w s = a(AtomicIntegerArray.class, r);
    public static final v<Number> t = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final v<Number> u = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return Float.valueOf((float) aVar.k());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final v<Number> v = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return Double.valueOf(aVar.k());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final v<Number> w = new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.d.d.b f2 = aVar.f();
            switch (f2) {
                case NUMBER:
                case STRING:
                    return new com.bytedance.sdk.openadsdk.d.b.g(aVar.h());
                case BOOLEAN:
                default:
                    throw new t("Expecting number, got: " + f2);
                case NULL:
                    aVar.j();
                    return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w x = a(Number.class, w);
    public static final v<Character> y = new v<Character>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Character b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            String h2 = aVar.h();
            if (h2.length() != 1) {
                throw new t("Expecting character, got: " + h2);
            }
            return Character.valueOf(h2.charAt(0));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Character ch) throws IOException {
            cVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final w z = a(Character.TYPE, Character.class, y);
    public static final v<String> A = new v<String>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public String b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.d.d.b f2 = aVar.f();
            if (f2 == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            } else if (f2 == com.bytedance.sdk.openadsdk.d.d.b.BOOLEAN) {
                return Boolean.toString(aVar.i());
            } else {
                return aVar.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, String str) throws IOException {
            cVar.b(str);
        }
    };
    public static final v<BigDecimal> B = new v<BigDecimal>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public BigDecimal b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.a(bigDecimal);
        }
    };
    public static final v<BigInteger> C = new v<BigInteger>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public BigInteger b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (NumberFormatException e2) {
                throw new t(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, BigInteger bigInteger) throws IOException {
            cVar.a(bigInteger);
        }
    };
    public static final w D = a(String.class, A);
    public static final v<StringBuilder> E = new v<StringBuilder>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public StringBuilder b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return new StringBuilder(aVar.h());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, StringBuilder sb) throws IOException {
            cVar.b(sb == null ? null : sb.toString());
        }
    };
    public static final w F = a(StringBuilder.class, E);
    public static final v<StringBuffer> G = new v<StringBuffer>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public StringBuffer b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return new StringBuffer(aVar.h());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final w H = a(StringBuffer.class, G);
    public static final v<URL> I = new v<URL>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public URL b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            String h2 = aVar.h();
            if ("null".equals(h2)) {
                return null;
            }
            return new URL(h2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, URL url) throws IOException {
            cVar.b(url == null ? null : url.toExternalForm());
        }
    };
    public static final w J = a(URL.class, I);
    public static final v<URI> K = new v<URI>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public URI b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            try {
                String h2 = aVar.h();
                if ("null".equals(h2)) {
                    return null;
                }
                return new URI(h2);
            } catch (URISyntaxException e2) {
                throw new com.bytedance.sdk.openadsdk.d.m(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, URI uri) throws IOException {
            cVar.b(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final w L = a(URI.class, K);
    public static final v<InetAddress> M = new v<InetAddress>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public InetAddress b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return InetAddress.getByName(aVar.h());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, InetAddress inetAddress) throws IOException {
            cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final w N = b(InetAddress.class, M);
    public static final v<UUID> O = new v<UUID>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public UUID b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return UUID.fromString(aVar.h());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, UUID uuid) throws IOException {
            cVar.b(uuid == null ? null : uuid.toString());
        }
    };
    public static final w P = a(UUID.class, O);
    public static final v<Currency> Q = new v<Currency>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Currency b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            return Currency.getInstance(aVar.h());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Currency currency) throws IOException {
            cVar.b(currency.getCurrencyCode());
        }
    }.a();
    public static final w R = a(Currency.class, Q);
    public static final w S = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.19
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            if (aVar.a() != Timestamp.class) {
                return null;
            }
            final v<T> a2 = fVar.a((Class) Date.class);
            return (v<T>) new v<Timestamp>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.19.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.d.v
                /* renamed from: a */
                public Timestamp b(com.bytedance.sdk.openadsdk.d.d.a aVar2) throws IOException {
                    Date date = (Date) a2.b(aVar2);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.d.v
                public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Timestamp timestamp) throws IOException {
                    a2.a(cVar, timestamp);
                }
            };
        }
    };
    public static final v<Calendar> T = new v<Calendar>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Calendar b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.f() != com.bytedance.sdk.openadsdk.d.d.b.END_OBJECT) {
                String g2 = aVar.g();
                int m2 = aVar.m();
                if ("year".equals(g2)) {
                    i7 = m2;
                } else if ("month".equals(g2)) {
                    i6 = m2;
                } else if ("dayOfMonth".equals(g2)) {
                    i5 = m2;
                } else if ("hourOfDay".equals(g2)) {
                    i4 = m2;
                } else if ("minute".equals(g2)) {
                    i3 = m2;
                } else if ("second".equals(g2)) {
                    i2 = m2;
                }
            }
            aVar.d();
            return new GregorianCalendar(i7, i6, i5, i4, i3, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.f();
                return;
            }
            cVar.d();
            cVar.a("year");
            cVar.a(calendar.get(1));
            cVar.a("month");
            cVar.a(calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a(calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a(calendar.get(11));
            cVar.a("minute");
            cVar.a(calendar.get(12));
            cVar.a("second");
            cVar.a(calendar.get(13));
            cVar.e();
        }
    };
    public static final w U = b(Calendar.class, GregorianCalendar.class, T);
    public static final v<Locale> V = new v<Locale>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Locale b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Locale locale) throws IOException {
            cVar.b(locale == null ? null : locale.toString());
        }
    };
    public static final w W = a(Locale.class, V);
    public static final v<com.bytedance.sdk.openadsdk.d.l> X = new v<com.bytedance.sdk.openadsdk.d.l>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public com.bytedance.sdk.openadsdk.d.l b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            switch (AnonymousClass30.f7219a[aVar.f().ordinal()]) {
                case 1:
                    return new q(new com.bytedance.sdk.openadsdk.d.b.g(aVar.h()));
                case 2:
                    return new q(Boolean.valueOf(aVar.i()));
                case 3:
                    return new q(aVar.h());
                case 4:
                    aVar.j();
                    return com.bytedance.sdk.openadsdk.d.n.f7297a;
                case 5:
                    com.bytedance.sdk.openadsdk.d.i iVar = new com.bytedance.sdk.openadsdk.d.i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(b(aVar));
                    }
                    aVar.b();
                    return iVar;
                case 6:
                    o oVar = new o();
                    aVar.c();
                    while (aVar.e()) {
                        oVar.a(aVar.g(), b(aVar));
                    }
                    aVar.d();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, com.bytedance.sdk.openadsdk.d.l lVar) throws IOException {
            if (lVar == null || lVar.j()) {
                cVar.f();
            } else if (lVar.i()) {
                q m2 = lVar.m();
                if (m2.o()) {
                    cVar.a(m2.a());
                } else if (m2.n()) {
                    cVar.a(m2.f());
                } else {
                    cVar.b(m2.b());
                }
            } else if (lVar.g()) {
                cVar.b();
                Iterator<com.bytedance.sdk.openadsdk.d.l> it = lVar.l().iterator();
                while (it.hasNext()) {
                    a(cVar, it.next());
                }
                cVar.c();
            } else if (lVar.h()) {
                cVar.d();
                for (Map.Entry<String, com.bytedance.sdk.openadsdk.d.l> entry : lVar.k().n()) {
                    cVar.a(entry.getKey());
                    a(cVar, entry.getValue());
                }
                cVar.e();
            } else {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
        }
    };
    public static final w Y = b(com.bytedance.sdk.openadsdk.d.l.class, X);
    public static final w Z = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.24
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            Class a2 = aVar.a();
            if (!Enum.class.isAssignableFrom(a2) || a2 == Enum.class) {
                return null;
            }
            if (!a2.isEnum()) {
                a2 = (Class<? super Object>) a2.getSuperclass();
            }
            return new a(a2);
        }
    };

    /* loaded from: classes4.dex */
    private static final class a<T extends Enum<T>> extends v<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f7220a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f7221b = new HashMap();

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.openadsdk.d.b.a.n$a<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.sdk.openadsdk.d.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException {
            a(cVar, (com.bytedance.sdk.openadsdk.d.d.c) ((Enum) obj));
        }

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.bytedance.sdk.openadsdk.d.a.c cVar = (com.bytedance.sdk.openadsdk.d.a.c) cls.getField(name).getAnnotation(com.bytedance.sdk.openadsdk.d.a.c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        String[] b2 = cVar.b();
                        for (String str : b2) {
                            this.f7220a.put(str, t);
                        }
                    }
                    String str2 = name;
                    this.f7220a.put(str2, t);
                    this.f7221b.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            return this.f7220a.get(aVar.h());
        }

        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
            cVar.b(t == null ? null : this.f7221b.get(t));
        }
    }

    public static <TT> w a(final com.bytedance.sdk.openadsdk.d.c.a<TT> aVar, final v<TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.25
            @Override // com.bytedance.sdk.openadsdk.d.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar2) {
                if (aVar2.equals(com.bytedance.sdk.openadsdk.d.c.a.this)) {
                    return vVar;
                }
                return null;
            }
        };
    }

    public static <TT> w a(final Class<TT> cls, final v<TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.26
            @Override // com.bytedance.sdk.openadsdk.d.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> w a(final Class<TT> cls, final Class<TT> cls2, final v<? super TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.27
            @Override // com.bytedance.sdk.openadsdk.d.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> w b(final Class<TT> cls, final Class<? extends TT> cls2, final v<? super TT> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.28
            @Override // com.bytedance.sdk.openadsdk.d.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <T1> w b(final Class<T1> cls, final v<T1> vVar) {
        return new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.29
            @Override // com.bytedance.sdk.openadsdk.d.w
            public <T2> v<T2> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T2> aVar) {
                final Class<? super T2> a2 = aVar.a();
                if (cls.isAssignableFrom(a2)) {
                    return (v<T2>) new v<T1>() { // from class: com.bytedance.sdk.openadsdk.d.b.a.n.29.1
                        @Override // com.bytedance.sdk.openadsdk.d.v
                        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T1 t1) throws IOException {
                            vVar.a(cVar, t1);
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, T1] */
                        @Override // com.bytedance.sdk.openadsdk.d.v
                        public T1 b(com.bytedance.sdk.openadsdk.d.d.a aVar2) throws IOException {
                            ?? b2 = vVar.b(aVar2);
                            if (b2 != 0 && !a2.isInstance(b2)) {
                                throw new t("Expected a " + a2.getName() + " but was " + b2.getClass().getName());
                            }
                            return b2;
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }
}
