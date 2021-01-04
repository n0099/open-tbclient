package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f7128a;
    private LruCache<String, q> c = new LruCache<String, q>(524288) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, q qVar) {
            int i = 0;
            if (qVar != null) {
                if (!TextUtils.isEmpty(qVar.b())) {
                    try {
                        i = 0 + qVar.b().getBytes().length;
                    } catch (Throwable th) {
                    }
                }
                if (!TextUtils.isEmpty(qVar.c())) {
                    try {
                        i += qVar.c().getBytes().length;
                    } catch (Throwable th2) {
                    }
                }
                if (!TextUtils.isEmpty(qVar.a())) {
                    try {
                        i += qVar.a().getBytes().length;
                    } catch (Throwable th3) {
                    }
                }
                if (!TextUtils.isEmpty(qVar.d())) {
                    try {
                        i += qVar.d().getBytes().length;
                    } catch (Throwable th4) {
                    }
                }
                if (!TextUtils.isEmpty(qVar.f())) {
                    try {
                        i += qVar.f().getBytes().length;
                    } catch (Throwable th5) {
                    }
                }
                if (!TextUtils.isEmpty(qVar.e())) {
                    try {
                        i += qVar.e().getBytes().length;
                    } catch (Throwable th6) {
                    }
                }
                if (qVar.g() != null) {
                    try {
                        i += qVar.g().byteValue();
                    } catch (Throwable th7) {
                    }
                }
            }
            return i > 0 ? i : super.sizeOf(str, qVar);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f7129b = Collections.synchronizedSet(new HashSet());

    public static c a() {
        if (f7128a == null) {
            synchronized (c.class) {
                if (f7128a == null) {
                    f7128a = new c();
                }
            }
        }
        return f7128a;
    }

    private c() {
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: package-private */
    public q a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        q qVar = this.c.get(String.valueOf(str));
        if (qVar != null) {
            return qVar;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (a2 != null) {
            try {
                if (a2.moveToNext()) {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex("id"));
                    String string3 = a2.getString(a2.getColumnIndex("md5"));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    q a3 = new q().a(string).b(string2).c(string3).d(string4).e(a2.getString(a2.getColumnIndex("data"))).f(a2.getString(a2.getColumnIndex("version"))).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time"))));
                    this.c.put(string2, a3);
                    this.f7129b.add(string2);
                } else if (a2 != null) {
                    a2.close();
                    return null;
                } else {
                    return null;
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    hashSet.add(a2.getString(a2.getColumnIndex("id")));
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
            return hashSet;
        }
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.d.q> */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public List<q> b() {
        ArrayList arrayList = new ArrayList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, null, null, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex("id"));
                    String string3 = a2.getString(a2.getColumnIndex("md5"));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    String string5 = a2.getString(a2.getColumnIndex("data"));
                    String string6 = a2.getString(a2.getColumnIndex("version"));
                    arrayList.add(new q().a(string).b(string2).c(string3).d(string4).e(string5).f(string6).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time")))));
                    this.c.put(string2, arrayList.get(arrayList.size() - 1));
                    this.f7129b.add(string2);
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.b())) {
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "id=?", new String[]{qVar.b()}, null, null, null);
            boolean z = a2 != null && a2.getCount() > 0;
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable th) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("rit", qVar.a());
            contentValues.put("id", qVar.b());
            contentValues.put("md5", qVar.c());
            contentValues.put("url", qVar.d());
            contentValues.put("data", qVar.e());
            contentValues.put("version", qVar.f());
            contentValues.put("update_time", qVar.g());
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", contentValues, "id=?", new String[]{qVar.b()});
            } else {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", contentValues);
            }
            this.c.put(qVar.b(), qVar);
            this.f7129b.add(qVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            String[] strArr = (String[]) set.toArray(new String[set.size()]);
            if (strArr.length > 0) {
                for (int i = 0; i < strArr.length; i++) {
                    c(strArr[i]);
                    com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", "id=?", new String[]{strArr[i]});
                }
            }
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.c != null && this.c.size() > 0) {
            this.c.remove(str);
        }
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }
}
