package com.bytedance.embedapplog;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ad {
    private final cn ppj;
    private final m ppk;
    private final a ppl;
    private static int b = 0;
    private static String c = "SELECT * FROM " + ak.h + " WHERE " + LuaMessageHelper.KEY_EVENT_NAME + " =?  AND monitor_status=?";
    private static String d = "UPDATE " + ak.h + " SET monitor_num =? WHERE " + LuaMessageHelper.KEY_EVENT_NAME + " =? AND monitor_status =?";
    private static String e = "SELECT * FROM " + ak.h + " WHERE date<? ORDER BY local_time_ms LIMIT ?";
    private static String f = "DELETE FROM " + ak.h + " WHERE local_time_ms <= ?";

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<String, ac> f3900a = new HashMap<>();

    static {
        a(new aj());
        a(new ae());
        a(new ag(null, false, null));
        a(new ah());
        a(new am());
        a(new ai());
        a(new af("", new JSONObject()));
        a(new ak());
    }

    private String a(ac acVar, String str, int i) {
        return "SELECT * FROM " + acVar.d() + " WHERE session_id='" + str + "' ORDER BY local_time_ms LIMIT " + i;
    }

    private String a(ac acVar, String str, long j) {
        return "DELETE FROM " + acVar.d() + " WHERE session_id='" + str + "' AND local_time_ms<=" + j;
    }

    private String K(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE local_time_ms=" + j;
    }

    public ad(Application application, m mVar, cn cnVar) {
        this.ppl = new a(application, "bd_embed_tea_agent.db", null, 29);
        this.ppk = mVar;
        this.ppj = cnVar;
    }

    private static void a(ac acVar) {
        f3900a.put(acVar.d(), acVar);
    }

    public boolean a(JSONObject jSONObject, ah ahVar, boolean z) {
        ag agVar = (ag) f3900a.get("eventv3");
        ae aeVar = (ae) f3900a.get("event");
        af afVar = (af) f3900a.get("event_misc");
        ai aiVar = (ai) f3900a.get("pack");
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.ppl.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                ac[] acVarArr = {aeVar, agVar, afVar};
                JSONArray[] jSONArrayArr = new JSONArray[3];
                int a2 = a(acVarArr, 0, sQLiteDatabase, ahVar.c, jSONArrayArr);
                if ((jSONArrayArr[0] != null && jSONArrayArr[0].length() > 0) || ((jSONArrayArr[1] != null && jSONArrayArr[1].length() > 0) || ((jSONArrayArr[2] != null && jSONArrayArr[2].length() > 0) || a(ahVar, z)))) {
                    aiVar.a(System.currentTimeMillis(), jSONObject, a(ahVar, z) ? ahVar : null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                    ContentValues e2 = aiVar.e(contentValues);
                    sQLiteDatabase.insert("pack", null, e2);
                    if (au.b && a(ahVar, z)) {
                        au.a("send launch, " + ahVar.c + ", hadUI:" + z, null);
                    }
                    ahVar.k = true;
                    contentValues = e2;
                }
                while (a2 < acVarArr.length) {
                    a2 = a(acVarArr, a2, sQLiteDatabase, ahVar.c, jSONArrayArr);
                    if ((jSONArrayArr[0] != null && jSONArrayArr[0].length() > 0) || (jSONArrayArr[1] != null && jSONArrayArr[1].length() > 0)) {
                        aiVar.a(System.currentTimeMillis(), jSONObject, null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        ContentValues e3 = aiVar.e(contentValues);
                        sQLiteDatabase.insert("pack", null, e3);
                        contentValues = e3;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                return true;
            } catch (Exception e4) {
                au.a(e4);
                if (sQLiteDatabase == null) {
                    return false;
                }
                try {
                    sQLiteDatabase.endTransaction();
                    return false;
                } catch (Exception e5) {
                    au.a(e5);
                    return false;
                }
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e6) {
                    au.a(e6);
                }
            }
        }
    }

    private boolean a(ah ahVar, boolean z) {
        return !ahVar.k && z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [255=4] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0232 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(JSONObject jSONObject) {
        Cursor cursor;
        ah ahVar = (ah) f3900a.get(Config.LAUNCH);
        am amVar = (am) f3900a.get("terminate");
        aj ajVar = (aj) f3900a.get("page");
        ag agVar = (ag) f3900a.get("eventv3");
        ae aeVar = (ae) f3900a.get("event");
        af afVar = (af) f3900a.get("event_misc");
        ai aiVar = (ai) f3900a.get("pack");
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase = null;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = this.ppl.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM launch ORDER BY local_time_ms DESC LIMIT 5", null);
            long j = Long.MAX_VALUE;
            long j2 = Long.MIN_VALUE;
            ContentValues contentValues2 = contentValues;
            JSONObject jSONObject2 = jSONObject;
            while (cursor.moveToNext()) {
                try {
                    ahVar.C(cursor);
                    if (!TextUtils.equals(ahVar.c, bx.c())) {
                        if (!TextUtils.equals(ahVar.i, this.ppk.d()) || ahVar.h != this.ppk.c()) {
                            JSONObject jSONObject3 = new JSONObject();
                            av.e(jSONObject3, jSONObject2);
                            jSONObject3.put("app_version", ahVar.i);
                            jSONObject3.put("version_code", ahVar.h);
                            jSONObject2 = jSONObject3;
                        }
                        long j3 = ahVar.f3899a < j ? ahVar.f3899a : j;
                        long j4 = ahVar.f3899a > j2 ? ahVar.f3899a : j2;
                        JSONArray a2 = a(ahVar, amVar, ajVar, sQLiteDatabase);
                        ac[] acVarArr = {aeVar, agVar, afVar};
                        JSONArray[] jSONArrayArr = new JSONArray[3];
                        int a3 = a(acVarArr, 0, sQLiteDatabase, ahVar.c, jSONArrayArr);
                        if (a2.length() > 0) {
                            aiVar.a(ahVar.f3899a, jSONObject2, null, amVar, a2, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        } else {
                            ahVar.j = true;
                            aiVar.a(ahVar.f3899a, jSONObject2, ahVar, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        }
                        if (au.b) {
                            au.a("packer launch, " + (a2.length() <= 0) + ", sid:" + ahVar.c, null);
                        }
                        ContentValues e2 = aiVar.e(contentValues2);
                        sQLiteDatabase.insert("pack", null, e2);
                        ContentValues contentValues3 = e2;
                        while (a3 < acVarArr.length) {
                            a3 = a(acVarArr, a3, sQLiteDatabase, ahVar.c, jSONArrayArr);
                            if (jSONArrayArr[0] != null || jSONArrayArr[1] != null || jSONArrayArr[2] != null) {
                                aiVar.a(ahVar.f3899a, jSONObject2, null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                                ContentValues e3 = aiVar.e(contentValues3);
                                sQLiteDatabase.insert("pack", null, e3);
                                contentValues3 = e3;
                            }
                        }
                        j2 = j4;
                        j = j3;
                        contentValues2 = contentValues3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor2 = cursor;
                    try {
                        au.a(e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                                return false;
                            } catch (Exception e5) {
                                au.a(e5);
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Exception e6) {
                                au.a(e6);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    throw th;
                }
            }
            if (j != Long.MAX_VALUE && j2 != Long.MIN_VALUE) {
                sQLiteDatabase.execSQL("DELETE FROM launch WHERE local_time_ms>=? AND local_time_ms<=?", new String[]{String.valueOf(j), String.valueOf(j2)});
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e7) {
                    au.a(e7);
                }
            }
            return true;
        } catch (Exception e8) {
            e = e8;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    private int a(ac[] acVarArr, int i, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr) {
        int i2 = 0;
        while (i2 < i) {
            jSONArrayArr[i2] = null;
            i2++;
        }
        int i3 = 200;
        while (i3 > 0 && i2 < acVarArr.length) {
            jSONArrayArr[i2] = a(sQLiteDatabase, acVarArr[i2], str, i3);
            i3 -= jSONArrayArr[i2].length();
            if (i3 > 0) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [318=4] */
    private JSONArray a(SQLiteDatabase sQLiteDatabase, ac acVar, String str, int i) {
        long j;
        Cursor cursor;
        JSONArray jSONArray = new JSONArray();
        try {
            cursor = sQLiteDatabase.rawQuery(a(acVar, str, i), null);
            j = 0;
            while (cursor.moveToNext()) {
                try {
                    acVar.C(cursor);
                    if (au.b) {
                        au.a("queryEvnetInner, " + str + ", " + acVar, null);
                    }
                    jSONArray.put(acVar.f());
                    if (acVar.f3899a > j) {
                        j = acVar.f3899a;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        au.a(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        au.a("queryEvent, " + acVar + ", " + jSONArray.length() + ", " + j, null);
                        return jSONArray;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (j > 0) {
                sQLiteDatabase.execSQL(a(acVar, str, j));
            }
        } catch (Throwable th2) {
            th = th2;
            j = 0;
            cursor = null;
        }
        au.a("queryEvent, " + acVar + ", " + jSONArray.length() + ", " + j, null);
        return jSONArray;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private JSONArray a(ah ahVar, am amVar, aj ajVar, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {ahVar.c};
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM page WHERE session_id=? LIMIT 500", strArr);
            boolean z = false;
            while (cursor.moveToNext()) {
                ajVar.C(cursor);
                if (au.b) {
                    au.a("queryPageInner, " + strArr + ", " + ajVar, null);
                }
                if (ajVar.i()) {
                    jSONArray.put(ajVar.f());
                } else {
                    j += ajVar.h;
                }
                z = true;
            }
            if (z) {
                sQLiteDatabase.execSQL("DELETE FROM page WHERE session_id=?", strArr);
            }
        } catch (Throwable th) {
            try {
                au.a(th);
                if (cursor != null) {
                    cursor.close();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (jSONArray.length() > 0) {
            if (j <= 1000) {
                j = 1000;
            }
            amVar.h = j;
            amVar.c = ahVar.c;
            amVar.f3899a = ahVar.f3899a;
            amVar.i = (j + ahVar.f3899a) / 1000;
            amVar.b = ce.a(this.ppj);
            amVar.e = ahVar.e;
            amVar.f = ahVar.f;
        }
        if (au.b) {
            au.a("queryPage, " + amVar + ", " + jSONArray.length(), null);
        }
        return jSONArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [396=4] */
    @NonNull
    public ArrayList<ai> a() {
        Cursor cursor;
        ArrayList<ai> arrayList = new ArrayList<>();
        ai aiVar = (ai) f3900a.get("pack");
        try {
            cursor = this.ppl.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2", null);
            while (cursor.moveToNext()) {
                try {
                    aiVar = (ai) aiVar.clone();
                    aiVar.C(cursor);
                    arrayList.add(aiVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        au.a(th);
                        au.a("queryPack, " + arrayList.size() + ", " + arrayList, null);
                        return arrayList;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        au.a("queryPack, " + arrayList.size() + ", " + arrayList, null);
        return arrayList;
    }

    public void j(ArrayList<ai> arrayList, ArrayList<ai> arrayList2) {
        au.a("setResult, " + arrayList + ", " + arrayList2, null);
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        HashMap<String, Integer> hashMap5 = new HashMap<>();
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i2).i == 0) {
                    a(arrayList.get(i2), hashMap, true);
                } else {
                    a(arrayList.get(i2), hashMap4, false);
                }
                i = i2 + 1;
            }
        }
        Iterator<ai> it = arrayList2.iterator();
        while (it.hasNext()) {
            ai next = it.next();
            if (next.i == 0) {
                HashMap<String, Integer> hashMap6 = (HashMap) hashMap2.get(Integer.valueOf(next.j));
                if (hashMap6 == null) {
                    hashMap6 = new HashMap<>();
                    hashMap2.put(Integer.valueOf(next.j), hashMap6);
                }
                a(next, hashMap6, false);
            } else if (next.i + 1 > 5) {
                a(next, hashMap3, false);
                arrayList.add(next);
                it.remove();
            } else {
                a(next, hashMap5, false);
            }
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.ppl.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            Iterator<ai> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sQLiteDatabase.execSQL("DELETE FROM pack WHERE local_time_ms=?", new String[]{String.valueOf(it2.next().f3899a)});
            }
            Iterator<ai> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ai next2 = it3.next();
                long j = next2.f3899a;
                int i3 = next2.i + 1;
                next2.i = i3;
                sQLiteDatabase.execSQL(K(j, i3));
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    au.a(e2);
                }
            }
        } catch (Throwable th) {
            try {
                au.a(th);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        au.a(e3);
                    }
                }
            } catch (Throwable th2) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e4) {
                        au.a(e4);
                    }
                }
                throw th2;
            }
        }
    }

    private void a(ai aiVar, HashMap<String, Integer> hashMap, boolean z) {
    }

    public void a(@NonNull ArrayList<ac> arrayList) {
        SQLiteDatabase sQLiteDatabase;
        ContentValues contentValues = null;
        au.a("save, " + arrayList.toString(), null);
        try {
            sQLiteDatabase = this.ppl.getWritableDatabase();
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ac> it = arrayList.iterator();
                while (it.hasNext()) {
                    ac next = it.next();
                    String d2 = next.d();
                    contentValues = next.e(contentValues);
                    sQLiteDatabase.insert(d2, null, contentValues);
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th) {
                        au.a(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    b += arrayList.size();
                    au.a(th);
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th3) {
                            au.a(th3);
                        }
                    }
                } catch (Throwable th4) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th5) {
                            au.a(th5);
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
        }
    }

    /* loaded from: classes6.dex */
    static class a extends SQLiteOpenHelper {
        a(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (ac acVar : ad.f3900a.values()) {
                    String c = acVar.c();
                    if (c != null) {
                        sQLiteDatabase.execSQL(c);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    au.a(e);
                }
            } catch (Throwable th) {
                try {
                    au.a(th);
                } finally {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        au.a(e2);
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            au.d("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ac> it = ad.f3900a.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().d());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    au.a(e);
                }
            } catch (Throwable th) {
                try {
                    au.c("", th);
                } finally {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        au.a(e2);
                    }
                }
            }
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
