package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public ArrayList b;
    public ArrayList c;
    public boolean d;
    public long e;
    public ArrayList f;

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public boolean d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public boolean c;
        public int d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public long j;
        public long k;
        public String l;
        public int m;
        public int n;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public long d;
        public long e;
        public String f;
        public String g;
        public String h;
        public String i;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;
        public String d;
        public ArrayList e;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public zk8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.f = new ArrayList();
        this.d = true;
    }

    public boolean g() {
        InterceptResult invokeV;
        ArrayList arrayList;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.d) {
                return true;
            }
            ArrayList arrayList3 = this.a;
            if ((arrayList3 == null || arrayList3.size() == 0) && (((arrayList = this.b) == null || arrayList.size() == 0) && ((arrayList2 = this.c) == null || arrayList2.size() == 0))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ArrayList a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            try {
                if (this.a != null && this.a.size() != 0) {
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        au4 au4Var = (au4) it.next();
                        if (au4Var != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("pic_url_bigger", au4Var.a());
                            jSONObject2.put("link", au4Var.b());
                            jSONArray2.put(jSONObject2);
                        }
                    }
                    jSONObject.put(SpeedStatsUtils.UBC_VALUE_BANNER, jSONArray2);
                }
                jSONObject.put("prevtime", this.e);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
            if (this.f != null && this.f.size() != 0) {
                Iterator it2 = this.f.iterator();
                while (it2.hasNext()) {
                    d dVar = (d) it2.next();
                    if (dVar != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("title", dVar.a);
                        jSONObject3.put("type", dVar.b);
                        jSONObject3.put("pic", dVar.c);
                        jSONObject3.put("link", dVar.d);
                        ArrayList arrayList = dVar.e;
                        if (arrayList != null && arrayList.size() != 0) {
                            JSONArray jSONArray3 = new JSONArray();
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                c cVar = (c) it3.next();
                                if (cVar != null) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("forum_id", cVar.a);
                                    jSONObject4.put("forum_name", cVar.b);
                                    jSONObject4.put("avatar", cVar.c);
                                    jSONObject4.put("explain", cVar.f);
                                    jSONObject4.put("desc", cVar.g);
                                    jSONObject4.put("tag", cVar.h);
                                    jSONObject4.put("thread_num", cVar.e);
                                    jSONObject4.put("member_count", cVar.d);
                                    jSONObject4.put("link", cVar.i);
                                    jSONArray3.put(jSONObject4);
                                }
                            }
                            jSONObject3.put("forum_list", jSONArray3);
                            jSONArray.put(jSONObject3);
                        }
                        jSONArray.put(jSONObject3);
                    }
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("new_list", jSONArray);
                jSONObject.put("new_recommend_topic", jSONObject5);
                return jSONObject.toString();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void h(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, jSONArray) == null) && jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("pic_url_bigger", "");
                            String optString2 = jSONObject.optString("link", "");
                            String optString3 = jSONObject.optString("template_id", "");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                au4 au4Var = new au4();
                                au4Var.d(optString);
                                au4Var.e(optString2);
                                au4Var.f(optString3);
                                this.a.add(au4Var);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void i(JSONArray jSONArray) {
        int optInt;
        JSONArray optJSONArray;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray) == null) && jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    boolean z = false;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && (optInt = jSONObject.optInt("type", -1)) != -1) {
                            boolean z2 = true;
                            String str2 = "";
                            if (optInt == 1) {
                                i3++;
                                a aVar = new a();
                                aVar.a = jSONObject.optString("title", "");
                                aVar.b = jSONObject.optString("link", "");
                                aVar.c = jSONObject.optString("pic", "");
                                aVar.d = z;
                                this.b.add(aVar);
                            } else if (optInt == 3) {
                                i3++;
                                a aVar2 = new a();
                                aVar2.a = jSONObject.optString("title", "");
                                aVar2.b = jSONObject.optString("link", "");
                                aVar2.c = jSONObject.optString("pic", "");
                                aVar2.d = true;
                                this.b.add(aVar2);
                            } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                                b bVar = new b();
                                bVar.a = true;
                                int i4 = i2 - i3;
                                bVar.m = i4;
                                if (optInt == 2) {
                                    bVar.c = true;
                                } else {
                                    bVar.c = z;
                                }
                                bVar.l = jSONObject.optString("link", "");
                                bVar.b = jSONObject.optString("title", "");
                                this.c.add(bVar);
                                int i5 = 0;
                                ?? r2 = z;
                                while (i5 < optJSONArray.length()) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                                    if (jSONObject2 == null) {
                                        i = i2;
                                        str = str2;
                                    } else {
                                        b bVar2 = new b();
                                        if (optInt == 2) {
                                            bVar2.c = z2;
                                        } else {
                                            bVar2.c = r2;
                                        }
                                        bVar2.a = r2;
                                        bVar2.m = i4;
                                        bVar2.n = i5;
                                        bVar2.d = jSONObject2.optInt("forum_id", r2);
                                        bVar2.e = jSONObject2.optString("forum_name", str2);
                                        bVar2.f = jSONObject2.optString("avatar", str2);
                                        bVar2.h = jSONObject2.optString("explain", str2);
                                        bVar2.i = jSONObject2.optString("desc", str2);
                                        bVar2.g = jSONObject2.optString("tag", str2);
                                        i = i2;
                                        bVar2.j = jSONObject2.optLong("member_count", 0L);
                                        bVar2.k = jSONObject2.optLong("thread_num", 0L);
                                        str = str2;
                                        bVar2.l = jSONObject2.optString("link", str);
                                        this.c.add(bVar2);
                                    }
                                    i5++;
                                    str2 = str;
                                    i2 = i;
                                    r2 = 0;
                                    z2 = true;
                                }
                            }
                        }
                        i2++;
                        z = false;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str != null && str.length() >= 1) {
                try {
                    k(new JSONObject(str));
                    l(str);
                    return;
                } catch (Exception e) {
                    this.d = false;
                    BdLog.e(e.toString());
                    return;
                }
            }
            this.d = false;
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            h(jSONObject.optJSONArray(SpeedStatsUtils.UBC_VALUE_BANNER));
            this.e = jSONObject.optLong("prevtime");
            JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
            if (optJSONObject == null) {
                return;
            }
            i(optJSONObject.optJSONArray("new_list"));
        } catch (Exception e) {
            this.d = false;
            BdLog.e(e.toString());
        }
    }

    public final void l(String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || str == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        d dVar = new d();
                        this.f.add(dVar);
                        dVar.e = new ArrayList();
                        dVar.a = jSONObject.optString("title", "");
                        dVar.b = jSONObject.optInt("type", -1);
                        dVar.c = jSONObject.optString("pic", "");
                        dVar.d = jSONObject.optString("link", "");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                if (jSONObject2 != null) {
                                    c cVar = new c();
                                    cVar.a = jSONObject2.optInt("forum_id", 0);
                                    cVar.b = jSONObject2.optString("forum_name", "");
                                    cVar.c = jSONObject2.optString("avatar", "");
                                    cVar.f = jSONObject2.optString("explain", "");
                                    cVar.g = jSONObject2.optString("desc", "");
                                    cVar.h = jSONObject2.optString("tag", "");
                                    cVar.d = jSONObject2.optLong("member_count", 0L);
                                    cVar.e = jSONObject2.optLong("thread_num", 0L);
                                    cVar.i = jSONObject2.optString("link", "");
                                    dVar.e.add(cVar);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void m(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.e = j;
        }
    }
}
