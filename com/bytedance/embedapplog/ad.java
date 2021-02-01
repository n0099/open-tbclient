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
    private final cn pmA;
    private final m pmB;
    private final a pmC;

    /* renamed from: b  reason: collision with root package name */
    private static int f5779b = 0;
    private static String c = "SELECT * FROM " + ak.h + " WHERE " + LuaMessageHelper.KEY_EVENT_NAME + " =?  AND monitor_status=?";
    private static String d = "UPDATE " + ak.h + " SET monitor_num =? WHERE " + LuaMessageHelper.KEY_EVENT_NAME + " =? AND monitor_status =?";
    private static String e = "SELECT * FROM " + ak.h + " WHERE date<? ORDER BY local_time_ms LIMIT ?";
    private static String f = "DELETE FROM " + ak.h + " WHERE local_time_ms <= ?";

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<String, ac> f5778a = new HashMap<>();

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
        this.pmC = new a(application, "bd_embed_tea_agent.db", null, 29);
        this.pmB = mVar;
        this.pmA = cnVar;
    }

    private static void a(ac acVar) {
        f5778a.put(acVar.d(), acVar);
    }

    public boolean a(JSONObject jSONObject, ah ahVar, boolean z) {
        ag agVar = (ag) f5778a.get("eventv3");
        ae aeVar = (ae) f5778a.get("event");
        af afVar = (af) f5778a.get("event_misc");
        ai aiVar = (ai) f5778a.get("pack");
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.pmC.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                ac[] acVarArr = {aeVar, agVar, afVar};
                JSONArray[] jSONArrayArr = new JSONArray[3];
                int a2 = a(acVarArr, 0, sQLiteDatabase, ahVar.c, jSONArrayArr);
                if ((jSONArrayArr[0] != null && jSONArrayArr[0].length() > 0) || ((jSONArrayArr[1] != null && jSONArrayArr[1].length() > 0) || ((jSONArrayArr[2] != null && jSONArrayArr[2].length() > 0) || a(ahVar, z)))) {
                    aiVar.a(System.currentTimeMillis(), jSONObject, a(ahVar, z) ? ahVar : null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                    ContentValues e2 = aiVar.e(contentValues);
                    sQLiteDatabase.insert("pack", null, e2);
                    if (au.f5788b && a(ahVar, z)) {
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
        ah ahVar = (ah) f5778a.get(Config.LAUNCH);
        am amVar = (am) f5778a.get("terminate");
        aj ajVar = (aj) f5778a.get("page");
        ag agVar = (ag) f5778a.get("eventv3");
        ae aeVar = (ae) f5778a.get("event");
        af afVar = (af) f5778a.get("event_misc");
        ai aiVar = (ai) f5778a.get("pack");
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase = null;
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = this.pmC.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM launch ORDER BY local_time_ms DESC LIMIT 5", null);
            long j = Long.MAX_VALUE;
            long j2 = Long.MIN_VALUE;
            ContentValues contentValues2 = contentValues;
            JSONObject jSONObject2 = jSONObject;
            while (cursor.moveToNext()) {
                try {
                    ahVar.B(cursor);
                    if (!TextUtils.equals(ahVar.c, bx.c())) {
                        if (!TextUtils.equals(ahVar.i, this.pmB.d()) || ahVar.h != this.pmB.c()) {
                            JSONObject jSONObject3 = new JSONObject();
                            av.e(jSONObject3, jSONObject2);
                            jSONObject3.put("app_version", ahVar.i);
                            jSONObject3.put("version_code", ahVar.h);
                            jSONObject2 = jSONObject3;
                        }
                        long j3 = ahVar.f5776a < j ? ahVar.f5776a : j;
                        long j4 = ahVar.f5776a > j2 ? ahVar.f5776a : j2;
                        JSONArray a2 = a(ahVar, amVar, ajVar, sQLiteDatabase);
                        ac[] acVarArr = {aeVar, agVar, afVar};
                        JSONArray[] jSONArrayArr = new JSONArray[3];
                        int a3 = a(acVarArr, 0, sQLiteDatabase, ahVar.c, jSONArrayArr);
                        if (a2.length() > 0) {
                            aiVar.a(ahVar.f5776a, jSONObject2, null, amVar, a2, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        } else {
                            ahVar.j = true;
                            aiVar.a(ahVar.f5776a, jSONObject2, ahVar, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
                        }
                        if (au.f5788b) {
                            au.a("packer launch, " + (a2.length() <= 0) + ", sid:" + ahVar.c, null);
                        }
                        ContentValues e2 = aiVar.e(contentValues2);
                        sQLiteDatabase.insert("pack", null, e2);
                        ContentValues contentValues3 = e2;
                        while (a3 < acVarArr.length) {
                            a3 = a(acVarArr, a3, sQLiteDatabase, ahVar.c, jSONArrayArr);
                            if (jSONArrayArr[0] != null || jSONArrayArr[1] != null || jSONArrayArr[2] != null) {
                                aiVar.a(ahVar.f5776a, jSONObject2, null, null, null, jSONArrayArr[0], jSONArrayArr[1], jSONArrayArr[2]);
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

    public void a(Context context, JSONObject jSONObject) {
        if (at.d()) {
            ai aiVar = (ai) f5778a.get("pack");
            long a2 = a(jSONObject, aiVar);
            if (a2 > 0) {
                if (a(context, aiVar)) {
                    a(a2);
                    return;
                }
                if (au.f5788b) {
                    au.a("s succ:fail", null);
                }
                at.b();
                return;
            }
            at.e();
        }
    }

    public void a(Context context) {
        if (f5779b > 0) {
            ai aiVar = new ai();
            int i = f5779b;
            ag agVar = new ag("bav2b_monitor", true, new ak("db_monitor", "db_fail", i).f().toString());
            if (bx.enW() != null) {
                bx.enW().c(agVar);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(agVar.f());
            aiVar.a(System.currentTimeMillis(), this.pmB.a(), null, null, null, null, jSONArray, null);
            if (a(context, aiVar)) {
                f5779b -= i;
            }
        }
    }

    private void a(long j) {
        if (j > 0) {
            au.a("d succ:maxTs =" + j, null);
            this.pmC.getWritableDatabase().execSQL(f, new String[]{String.valueOf(j)});
        }
    }

    private boolean a(Context context, ai aiVar) {
        return aa.a(new String[]{ab.n(context, this.pmB.a())}, b.Yu(aiVar.f().toString()), this.pmA) == 200;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long a(JSONObject jSONObject, ai aiVar) {
        SQLiteDatabase sQLiteDatabase;
        long j;
        ak akVar = (ak) f5778a.get(ak.h);
        SQLiteDatabase sQLiteDatabase2 = null;
        JSONArray jSONArray = new JSONArray();
        ag agVar = new ag("bav2b_monitor", true, null);
        long j2 = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            sQLiteDatabase = this.pmC.getWritableDatabase();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor rawQuery = sQLiteDatabase.rawQuery(e, new String[]{String.valueOf(at.a()), String.valueOf(200)});
                while (rawQuery.moveToNext()) {
                    akVar.B(rawQuery);
                    JSONObject f2 = akVar.f();
                    agVar.p = f2.toString();
                    if (bx.enW() != null) {
                        bx.enW().c(agVar);
                    }
                    if (akVar.f5776a > j2) {
                        j2 = akVar.f5776a;
                    }
                    sb.append(f2.toString()).append(",");
                    jSONArray.put(agVar.f());
                }
                sb.append("]");
                rawQuery.close();
                if (au.f5788b) {
                    au.a("p succ:" + sb.toString(), null);
                }
                aiVar.a(System.currentTimeMillis(), jSONObject, null, null, null, null, jSONArray, null);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        au.a(e2);
                    }
                }
                return j2;
            } catch (Exception e3) {
                e = e3;
                j = j2;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    au.a(e);
                    if (sQLiteDatabase2 == null) {
                        return j;
                    }
                    try {
                        sQLiteDatabase2.endTransaction();
                        return j;
                    } catch (Exception e4) {
                        au.a(e4);
                        return j;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = sQLiteDatabase2;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e5) {
                            au.a(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            j = 0;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [415=4] */
    private JSONArray a(SQLiteDatabase sQLiteDatabase, ac acVar, String str, int i) {
        long j;
        Cursor cursor;
        JSONArray jSONArray = new JSONArray();
        try {
            cursor = sQLiteDatabase.rawQuery(a(acVar, str, i), null);
            j = 0;
            while (cursor.moveToNext()) {
                try {
                    acVar.B(cursor);
                    if (au.f5788b) {
                        au.a("queryEvnetInner, " + str + ", " + acVar, null);
                    }
                    jSONArray.put(acVar.f());
                    if (acVar.f5776a > j) {
                        j = acVar.f5776a;
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
                ajVar.B(cursor);
                if (au.f5788b) {
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
            amVar.f5776a = ahVar.f5776a;
            amVar.i = (j + ahVar.f5776a) / 1000;
            amVar.f5777b = ce.a(this.pmA);
            amVar.e = ahVar.e;
            amVar.f = ahVar.f;
        }
        if (au.f5788b) {
            au.a("queryPage, " + amVar + ", " + jSONArray.length(), null);
        }
        return jSONArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [493=4] */
    @NonNull
    public ArrayList<ai> a() {
        Cursor cursor;
        ArrayList<ai> arrayList = new ArrayList<>();
        ai aiVar = (ai) f5778a.get("pack");
        try {
            cursor = this.pmC.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2", null);
            while (cursor.moveToNext()) {
                try {
                    aiVar = (ai) aiVar.clone();
                    aiVar.B(cursor);
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void j(java.util.ArrayList<com.bytedance.embedapplog.ai> r17, java.util.ArrayList<com.bytedance.embedapplog.ai> r18) {
        /*
            r16 = this;
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setResult, "
            java.lang.StringBuilder r2 = r2.append(r3)
            r0 = r17
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = ", "
            java.lang.StringBuilder r2 = r2.append(r3)
            r0 = r18
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            r3 = 0
            com.bytedance.embedapplog.au.a(r2, r3)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            if (r17 == 0) goto L7d
            int r2 = r17.size()
            if (r2 <= 0) goto L7d
            r2 = 0
            r3 = r2
        L4a:
            int r2 = r17.size()
            if (r3 >= r2) goto L7d
            r0 = r17
            java.lang.Object r2 = r0.get(r3)
            com.bytedance.embedapplog.ai r2 = (com.bytedance.embedapplog.ai) r2
            int r2 = r2.i
            if (r2 != 0) goto L6e
            r0 = r17
            java.lang.Object r2 = r0.get(r3)
            com.bytedance.embedapplog.ai r2 = (com.bytedance.embedapplog.ai) r2
            r4 = 1
            r0 = r16
            r0.a(r2, r5, r4)
        L6a:
            int r2 = r3 + 1
            r3 = r2
            goto L4a
        L6e:
            r0 = r17
            java.lang.Object r2 = r0.get(r3)
            com.bytedance.embedapplog.ai r2 = (com.bytedance.embedapplog.ai) r2
            r4 = 0
            r0 = r16
            r0.a(r2, r8, r4)
            goto L6a
        L7d:
            java.util.Iterator r4 = r18.iterator()
        L81:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto Ld5
            java.lang.Object r2 = r4.next()
            com.bytedance.embedapplog.ai r2 = (com.bytedance.embedapplog.ai) r2
            int r3 = r2.i
            if (r3 != 0) goto Lb4
            int r3 = r2.j
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r6.get(r3)
            java.util.HashMap r3 = (java.util.HashMap) r3
            if (r3 != 0) goto Lad
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            int r10 = r2.j
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r6.put(r10, r3)
        Lad:
            r10 = 0
            r0 = r16
            r0.a(r2, r3, r10)
            goto L81
        Lb4:
            int r3 = r2.i
            int r3 = r3 + 1
            long r10 = (long) r3
            r12 = 5
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 <= 0) goto Lce
            r3 = 0
            r0 = r16
            r0.a(r2, r7, r3)
            r0 = r17
            r0.add(r2)
            r4.remove()
            goto L81
        Lce:
            r3 = 0
            r0 = r16
            r0.a(r2, r9, r3)
            goto L81
        Ld5:
            r3 = 0
            r0 = r16
            com.bytedance.embedapplog.ad$a r2 = r0.pmC     // Catch: java.lang.Throwable -> L19a
            android.database.sqlite.SQLiteDatabase r4 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L19a
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L104
            java.util.Iterator r3 = r17.iterator()     // Catch: java.lang.Throwable -> L104
        Le5:
            boolean r2 = r3.hasNext()     // Catch: java.lang.Throwable -> L104
            if (r2 == 0) goto L10f
            java.lang.Object r2 = r3.next()     // Catch: java.lang.Throwable -> L104
            com.bytedance.embedapplog.ai r2 = (com.bytedance.embedapplog.ai) r2     // Catch: java.lang.Throwable -> L104
            java.lang.String r10 = "DELETE FROM pack WHERE local_time_ms=?"
            r11 = 1
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L104
            r12 = 0
            long r14 = r2.f5776a     // Catch: java.lang.Throwable -> L104
            java.lang.String r2 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L104
            r11[r12] = r2     // Catch: java.lang.Throwable -> L104
            r4.execSQL(r10, r11)     // Catch: java.lang.Throwable -> L104
            goto Le5
        L104:
            r2 = move-exception
            r3 = r4
        L106:
            com.bytedance.embedapplog.au.a(r2)     // Catch: java.lang.Throwable -> L197
            if (r3 == 0) goto L10e
            r3.endTransaction()     // Catch: java.lang.Exception -> L18a
        L10e:
            return
        L10f:
            java.util.Iterator r3 = r18.iterator()     // Catch: java.lang.Throwable -> L104
        L113:
            boolean r2 = r3.hasNext()     // Catch: java.lang.Throwable -> L104
            if (r2 == 0) goto L138
            java.lang.Object r2 = r3.next()     // Catch: java.lang.Throwable -> L104
            com.bytedance.embedapplog.ai r2 = (com.bytedance.embedapplog.ai) r2     // Catch: java.lang.Throwable -> L104
            long r10 = r2.f5776a     // Catch: java.lang.Throwable -> L104
            int r12 = r2.i     // Catch: java.lang.Throwable -> L104
            int r12 = r12 + 1
            r2.i = r12     // Catch: java.lang.Throwable -> L104
            r0 = r16
            java.lang.String r2 = r0.K(r10, r12)     // Catch: java.lang.Throwable -> L104
            r4.execSQL(r2)     // Catch: java.lang.Throwable -> L104
            goto L113
        L131:
            r2 = move-exception
        L132:
            if (r4 == 0) goto L137
            r4.endTransaction()     // Catch: java.lang.Exception -> L18f
        L137:
            throw r2
        L138:
            java.util.Set r2 = r6.keySet()     // Catch: java.lang.Throwable -> L104
            java.util.Iterator r10 = r2.iterator()     // Catch: java.lang.Throwable -> L104
        L140:
            boolean r2 = r10.hasNext()     // Catch: java.lang.Throwable -> L104
            if (r2 == 0) goto L15c
            java.lang.Object r2 = r10.next()     // Catch: java.lang.Throwable -> L104
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L104
            java.lang.Object r3 = r6.get(r2)     // Catch: java.lang.Throwable -> L104
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch: java.lang.Throwable -> L104
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L104
            r0 = r16
            r0.a(r3, r4, r2)     // Catch: java.lang.Throwable -> L104
            goto L140
        L15c:
            java.lang.String r2 = "success"
            r0 = r16
            r0.a(r5, r4, r2)     // Catch: java.lang.Throwable -> L104
            java.lang.String r2 = "retry_success"
            r0 = r16
            r0.a(r8, r4, r2)     // Catch: java.lang.Throwable -> L104
            java.lang.String r2 = "13"
            r0 = r16
            r0.a(r7, r4, r2)     // Catch: java.lang.Throwable -> L104
            java.lang.String r2 = "22"
            r0 = r16
            r0.a(r9, r4, r2)     // Catch: java.lang.Throwable -> L104
            r4.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L104
            if (r4 == 0) goto L10e
            r4.endTransaction()     // Catch: java.lang.Exception -> L185
            goto L10e
        L185:
            r2 = move-exception
            com.bytedance.embedapplog.au.a(r2)
            goto L10e
        L18a:
            r2 = move-exception
            com.bytedance.embedapplog.au.a(r2)
            goto L10e
        L18f:
            r3 = move-exception
            com.bytedance.embedapplog.au.a(r3)
            goto L137
        L194:
            r2 = move-exception
            r4 = r3
            goto L132
        L197:
            r2 = move-exception
            r4 = r3
            goto L132
        L19a:
            r2 = move-exception
            goto L106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ad.j(java.util.ArrayList, java.util.ArrayList):void");
    }

    private void a(ai aiVar, HashMap<String, Integer> hashMap, boolean z) {
    }

    private void a(HashMap<String, Integer> hashMap, SQLiteDatabase sQLiteDatabase, String str) {
        ContentValues e2;
        if (hashMap != null && hashMap.size() != 0 && at.c()) {
            ContentValues contentValues = null;
            for (String str2 : hashMap.keySet()) {
                Cursor rawQuery = sQLiteDatabase.rawQuery(c, new String[]{str2, str});
                Integer num = hashMap.get(str2);
                if (au.f5788b) {
                    au.a("i succ:" + str2 + " r:" + str + " count:" + num + " date:" + at.a(), null);
                }
                if (rawQuery.moveToNext()) {
                    sQLiteDatabase.execSQL(d, new String[]{String.valueOf(num.intValue() + rawQuery.getInt(8)), str2, str});
                    e2 = contentValues;
                } else {
                    ak akVar = new ak(str2, str, num.intValue());
                    String d2 = akVar.d();
                    e2 = akVar.e(contentValues);
                    sQLiteDatabase.insert(d2, null, e2);
                }
                rawQuery.close();
                contentValues = e2;
            }
        }
    }

    public void a(@NonNull ArrayList<ac> arrayList) {
        SQLiteDatabase sQLiteDatabase;
        ContentValues contentValues = null;
        au.a("save, " + arrayList.toString(), null);
        try {
            sQLiteDatabase = this.pmC.getWritableDatabase();
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
                    f5779b += arrayList.size();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends SQLiteOpenHelper {
        a(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                for (ac acVar : ad.f5778a.values()) {
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
                Iterator<ac> it = ad.f5778a.values().iterator();
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
