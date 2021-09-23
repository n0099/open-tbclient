package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.v;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f67742a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f67743b;

    /* renamed from: c  reason: collision with root package name */
    public Object f67744c;

    /* renamed from: d  reason: collision with root package name */
    public LruCache<String, v> f67745d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67744c = new Object();
        this.f67745d = new LruCache<String, v>(this, 2000) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f67746a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67746a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.LruCache
            /* renamed from: a */
            public int sizeOf(String str, v vVar) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, vVar)) == null) {
                    return 1;
                }
                return invokeLL.intValue;
            }
        };
        this.f67743b = Collections.synchronizedSet(new HashSet());
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f67742a == null) {
                synchronized (c.class) {
                    if (f67742a == null) {
                        f67742a = new c();
                    }
                }
            }
            return f67742a;
        }
        return (c) invokeV.objValue;
    }

    private void c(String str) {
        LruCache<String, v> lruCache;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || TextUtils.isEmpty(str) || (lruCache = this.f67745d) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.f67744c) {
            this.f67745d.remove(str);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public Set<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
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
        return (Set) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE," + PackageTable.MD5 + " TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT" + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bf, code lost:
        if (r12 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c1, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cd, code lost:
        if (r12 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v a(String str) {
        InterceptResult invokeL;
        v vVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (this.f67744c) {
                vVar = this.f67745d.get(String.valueOf(str));
            }
            if (vVar != null) {
                return vVar;
            }
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", null, "id=?", new String[]{str}, null, null, null);
            if (a2 != null) {
                try {
                    if (a2.moveToNext()) {
                        String string = a2.getString(a2.getColumnIndex("rit"));
                        String string2 = a2.getString(a2.getColumnIndex("id"));
                        String string3 = a2.getString(a2.getColumnIndex(PackageTable.MD5));
                        String string4 = a2.getString(a2.getColumnIndex("url"));
                        v a3 = new v().a(string).b(string2).c(string3).d(string4).e(a2.getString(a2.getColumnIndex("data"))).f(a2.getString(a2.getColumnIndex("version"))).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time"))));
                        synchronized (this.f67744c) {
                            this.f67745d.put(string2, a3);
                        }
                        this.f67743b.add(string2);
                        return a3;
                    }
                } catch (Throwable th) {
                    try {
                        k.c("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        if (a2 != null) {
                            a2.close();
                        }
                    }
                }
            }
            return null;
        }
        return (v) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: android.util.LruCache<java.lang.String, com.bytedance.sdk.openadsdk.core.e.v> */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ba, code lost:
        if (r1 == null) goto L5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<v> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", null, null, null, null, null, null);
            if (a2 != null) {
                while (a2.moveToNext()) {
                    try {
                        String string = a2.getString(a2.getColumnIndex("rit"));
                        String string2 = a2.getString(a2.getColumnIndex("id"));
                        String string3 = a2.getString(a2.getColumnIndex(PackageTable.MD5));
                        String string4 = a2.getString(a2.getColumnIndex("url"));
                        String string5 = a2.getString(a2.getColumnIndex("data"));
                        arrayList.add(new v().a(string).b(string2).c(string3).d(string4).e(string5).f(a2.getString(a2.getColumnIndex("version"))).a(Long.valueOf(a2.getLong(a2.getColumnIndex("update_time")))));
                        synchronized (this.f67744c) {
                            this.f67745d.put(string2, arrayList.get(arrayList.size() - 1));
                        }
                        this.f67743b.add(string2);
                    } catch (Throwable th) {
                        try {
                            k.c("TmplDbHelper", "getTemplate error", th);
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
        return (List) invokeV.objValue;
    }

    public void a(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar) == null) || vVar == null || TextUtils.isEmpty(vVar.b())) {
            return;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", null, "id=?", new String[]{vVar.b()}, null, null, null);
        boolean z = a2 != null && a2.getCount() > 0;
        if (a2 != null) {
            try {
                a2.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", vVar.a());
        contentValues.put("id", vVar.b());
        contentValues.put(PackageTable.MD5, vVar.c());
        contentValues.put("url", vVar.d());
        contentValues.put("data", vVar.e());
        contentValues.put("version", vVar.f());
        contentValues.put("update_time", vVar.g());
        if (z) {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", contentValues, "id=?", new String[]{vVar.b()});
        } else {
            com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", contentValues);
        }
        synchronized (this.f67744c) {
            this.f67745d.put(vVar.b(), vVar);
        }
        this.f67743b.add(vVar.b());
    }

    public void a(Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set) == null) || set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                c(strArr[i2]);
                com.bytedance.sdk.openadsdk.multipro.a.a.a(o.a(), "template_diff_new", "id=?", new String[]{strArr[i2]});
            }
        }
    }
}
