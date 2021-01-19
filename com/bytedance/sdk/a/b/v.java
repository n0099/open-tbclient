package com.bytedance.sdk.a.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f5978a;

    v(a aVar) {
        this.f5978a = (String[]) aVar.f5979a.toArray(new String[aVar.f5979a.size()]);
    }

    public String a(String str) {
        return a(this.f5978a, str);
    }

    public int a() {
        return this.f5978a.length / 2;
    }

    public String a(int i) {
        return this.f5978a[i * 2];
    }

    public String b(int i) {
        return this.f5978a[(i * 2) + 1];
    }

    public Set<String> b() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            treeSet.add(a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public List<String> b(String str) {
        ArrayList arrayList = null;
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public a enB() {
        a aVar = new a();
        Collections.addAll(aVar.f5979a, this.f5978a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && Arrays.equals(((v) obj).f5978a, this.f5978a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5978a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            sb.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return sb.toString();
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f5979a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a XD(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return hd(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return hd("", str.substring(1));
            }
            return hd("", str);
        }

        public a hc(String str, String str2) {
            d(str, str2);
            return hd(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a hd(String str, String str2) {
            this.f5979a.add(str);
            this.f5979a.add(str2.trim());
            return this;
        }

        public a XE(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f5979a.size()) {
                    if (str.equalsIgnoreCase(this.f5979a.get(i2))) {
                        this.f5979a.remove(i2);
                        this.f5979a.remove(i2);
                        i2 -= 2;
                    }
                    i = i2 + 2;
                } else {
                    return this;
                }
            }
        }

        public a he(String str, String str2) {
            d(str, str2);
            XE(str);
            hd(str, str2);
            return this;
        }

        private void d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public v enC() {
            return new v(this);
        }
    }
}
