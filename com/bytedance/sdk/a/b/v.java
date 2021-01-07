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
    private final String[] f6278a;

    v(a aVar) {
        this.f6278a = (String[]) aVar.f6279a.toArray(new String[aVar.f6279a.size()]);
    }

    public String a(String str) {
        return a(this.f6278a, str);
    }

    public int a() {
        return this.f6278a.length / 2;
    }

    public String a(int i) {
        return this.f6278a[i * 2];
    }

    public String b(int i) {
        return this.f6278a[(i * 2) + 1];
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

    public a erx() {
        a aVar = new a();
        Collections.addAll(aVar.f6279a, this.f6278a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && Arrays.equals(((v) obj).f6278a, this.f6278a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f6278a);
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
        final List<String> f6279a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a YK(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return he(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return he("", str.substring(1));
            }
            return he("", str);
        }

        public a hd(String str, String str2) {
            d(str, str2);
            return he(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a he(String str, String str2) {
            this.f6279a.add(str);
            this.f6279a.add(str2.trim());
            return this;
        }

        public a YL(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f6279a.size()) {
                    if (str.equalsIgnoreCase(this.f6279a.get(i2))) {
                        this.f6279a.remove(i2);
                        this.f6279a.remove(i2);
                        i2 -= 2;
                    }
                    i = i2 + 2;
                } else {
                    return this;
                }
            }
        }

        public a hf(String str, String str2) {
            d(str, str2);
            YL(str);
            he(str, str2);
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

        public v ery() {
            return new v(this);
        }
    }
}
