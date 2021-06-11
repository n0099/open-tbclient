package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f28841a;

    /* renamed from: c  reason: collision with root package name */
    public Object f28843c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public LruCache<String, t> f28844d = new LruCache<String, t>(2000) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, t tVar) {
            return 1;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f28842b = Collections.synchronizedSet(new HashSet());

    public static c a() {
        if (f28841a == null) {
            synchronized (c.class) {
                if (f28841a == null) {
                    f28841a = new c();
                }
            }
        }
        return f28841a;
    }

    private void c(String str) {
        LruCache<String, t> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.f28844d) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.f28843c) {
            this.f28844d.remove(str);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
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

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE," + PackageTable.MD5 + " TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT" + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bb, code lost:
        if (r12 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c9, code lost:
        if (r12 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t a(String str) {
        t tVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f28843c) {
            tVar = this.f28844d.get(String.valueOf(str));
        }
        if (tVar != null) {
            return tVar;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (a2 != null) {
            try {
                if (a2.moveToNext()) {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex("id"));
                    String string3 = a2.getString(a2.getColumnIndex(PackageTable.MD5));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    String string5 = a2.getString(a2.getColumnIndex("data"));
                    t a3 = new t().a(string).b(string2).c(string3).d(string4).e(string5).f(a2.getString(a2.getColumnIndex("version"))).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time"))));
                    synchronized (this.f28843c) {
                        this.f28844d.put(string2, a3);
                    }
                    this.f28842b.add(string2);
                    return a3;
                }
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
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.d.t> */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b6, code lost:
        if (r1 == null) goto L3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<t> b() {
        ArrayList arrayList = new ArrayList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, null, null, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    String string = a2.getString(a2.getColumnIndex("rit"));
                    String string2 = a2.getString(a2.getColumnIndex("id"));
                    String string3 = a2.getString(a2.getColumnIndex(PackageTable.MD5));
                    String string4 = a2.getString(a2.getColumnIndex("url"));
                    String string5 = a2.getString(a2.getColumnIndex("data"));
                    String string6 = a2.getString(a2.getColumnIndex("version"));
                    arrayList.add(new t().a(string).b(string2).c(string3).d(string4).e(string5).f(string6).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time")))));
                    synchronized (this.f28843c) {
                        this.f28844d.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.f28842b.add(string2);
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
        }
        return arrayList;
    }

    public void a(t tVar) {
        if (tVar == null || TextUtils.isEmpty(tVar.b())) {
            return;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", null, "id=?", new String[]{tVar.b()}, null, null, null);
        boolean z = a2 != null && a2.getCount() > 0;
        if (a2 != null) {
            try {
                a2.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", tVar.a());
        contentValues.put("id", tVar.b());
        contentValues.put(PackageTable.MD5, tVar.c());
        contentValues.put("url", tVar.d());
        contentValues.put("data", tVar.e());
        contentValues.put("version", tVar.f());
        contentValues.put("update_time", tVar.g());
        if (z) {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", contentValues, "id=?", new String[]{tVar.b()});
        } else {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", contentValues);
        }
        synchronized (this.f28843c) {
            this.f28844d.put(tVar.b(), tVar);
        }
        this.f28842b.add(tVar.b());
    }

    public void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                c(strArr[i2]);
                com.bytedance.sdk.openadsdk.multipro.a.a.a(p.a(), "template_diff_new", "id=?", new String[]{strArr[i2]});
            }
        }
    }
}
