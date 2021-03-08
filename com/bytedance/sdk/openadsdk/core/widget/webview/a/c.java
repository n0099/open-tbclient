package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f4631a;
    private Object c = new Object();
    private LruCache<String, r> d = new LruCache<String, r>(2000) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, r rVar) {
            return 1;
        }
    };
    private Set<String> b = Collections.synchronizedSet(new HashSet());

    public static c a() {
        if (f4631a == null) {
            synchronized (c.class) {
                if (f4631a == null) {
                    f4631a = new c();
                }
            }
        }
        return f4631a;
    }

    private c() {
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4, 126=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public r a(String str) {
        r rVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.c) {
            rVar = this.d.get(String.valueOf(str));
        }
        if (rVar != null) {
            return rVar;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (a2 != null) {
            try {
                if (!a2.moveToNext()) {
                    if (a2 != null) {
                        a2.close();
                        return null;
                    }
                    return null;
                }
                String string = a2.getString(a2.getColumnIndex("rit"));
                String string2 = a2.getString(a2.getColumnIndex("id"));
                String string3 = a2.getString(a2.getColumnIndex("md5"));
                String string4 = a2.getString(a2.getColumnIndex("url"));
                String string5 = a2.getString(a2.getColumnIndex("data"));
                r a3 = new r().a(string).b(string2).c(string3).d(string4).e(string5).f(a2.getString(a2.getColumnIndex("version"))).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time"))));
                synchronized (this.c) {
                    this.d.put(string2, a3);
                }
                this.b.add(string2);
                return a3;
            } catch (Throwable th) {
                try {
                    u.c("TmplDbHelper", "getTemplate error", th);
                    if (a2 != null) {
                        a2.close();
                        return null;
                    }
                    return null;
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
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
    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.d.r> */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public List<r> b() {
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
                    arrayList.add(new r().a(string).b(string2).c(string3).d(string4).e(string5).f(string6).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time")))));
                    synchronized (this.c) {
                        this.d.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.b.add(string2);
                } catch (Throwable th) {
                    try {
                        u.c("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        if (a2 != null) {
                            a2.close();
                        }
                    }
                }
            }
            if (a2 != null) {
                a2.close();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(r rVar) {
        if (rVar != null && !TextUtils.isEmpty(rVar.b())) {
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "id=?", new String[]{rVar.b()}, null, null, null);
            boolean z = a2 != null && a2.getCount() > 0;
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable th) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("rit", rVar.a());
            contentValues.put("id", rVar.b());
            contentValues.put("md5", rVar.c());
            contentValues.put("url", rVar.d());
            contentValues.put("data", rVar.e());
            contentValues.put("version", rVar.f());
            contentValues.put("update_time", rVar.g());
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", contentValues, "id=?", new String[]{rVar.b()});
            } else {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", contentValues);
            }
            synchronized (this.c) {
                this.d.put(rVar.b(), rVar);
            }
            this.b.add(rVar.b());
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
        if (!TextUtils.isEmpty(str) && this.d != null && this.d.size() > 0) {
            synchronized (this.c) {
                this.d.remove(str);
            }
        }
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }
}
