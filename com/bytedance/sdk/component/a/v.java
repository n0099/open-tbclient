package com.bytedance.sdk.component.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<b>> f64174a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, c> f64175b;

    /* renamed from: c  reason: collision with root package name */
    public final k.a f64176c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64177d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f64178e;

    /* loaded from: classes9.dex */
    public static class a extends IllegalStateException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Pattern f64181a;

        /* renamed from: b  reason: collision with root package name */
        public x f64182b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f64183c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f64184d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public x f64185a;

        /* renamed from: b  reason: collision with root package name */
        public Set<String> f64186b;

        /* renamed from: c  reason: collision with root package name */
        public Set<String> f64187c;

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
            this.f64185a = x.f64192a;
            this.f64186b = new HashSet();
            this.f64187c = new HashSet();
        }
    }

    @WorkerThread
    public v(@NonNull String str, int i2, @NonNull k.a aVar, @NonNull Executor executor, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), aVar, executor, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64174a = new ConcurrentHashMap();
        this.f64178e = false;
        this.f64177d = str;
        if (i2 <= 0) {
            this.f64175b = new LruCache<>(16);
        } else {
            this.f64175b = new LruCache<>(i2);
        }
        this.f64176c = aVar;
        if (jSONObject == null) {
            aVar.a(d(str), new k.a.InterfaceC1878a(this, executor) { // from class: com.bytedance.sdk.component.a.v.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Executor f64179a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ v f64180b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, executor};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f64180b = this;
                    this.f64179a = executor;
                }
            });
        } else {
            a(jSONObject);
        }
    }

    @WorkerThread
    private void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) {
            this.f64174a.clear();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject2.getJSONArray(next);
                    LinkedList linkedList = new LinkedList();
                    this.f64174a.put(next, linkedList);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        linkedList.add(c(jSONArray.getJSONObject(i2)));
                    }
                }
            } catch (JSONException e2) {
                i.b("Parse configurations failed, response: " + jSONObject.toString(), e2);
            }
            this.f64178e = true;
        }
    }

    private List<b> c(String str) throws a {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (this.f64178e) {
                return this.f64174a.get(str);
            }
            throw new a("Permission config is outdated!");
        }
        return (List) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return "com.bytedance.ies.web.jsbridge2.PermissionConfig." + str;
        }
        return (String) invokeL.objValue;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            b(jSONObject);
            this.f64176c.a(d(this.f64177d), jSONObject.toString());
        }
    }

    @NonNull
    public c a(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, set)) == null) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
            c cVar = new c();
            if (authority != null && !authority.isEmpty()) {
                for (String str2 : set) {
                    if (!authority.equals(str2)) {
                        if (authority.endsWith("." + str2)) {
                        }
                    }
                    cVar.f64185a = x.f64194c;
                    return cVar;
                }
                c cVar2 = this.f64175b.get(builder);
                return cVar2 != null ? cVar2 : a(builder);
            }
            cVar.f64185a = x.f64192a;
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @WorkerThread
    public static b c(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            b bVar = new b();
            bVar.f64181a = Pattern.compile(jSONObject.getString("pattern"));
            bVar.f64182b = x.a(jSONObject.getString("group"));
            bVar.f64183c = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    bVar.f64183c.add(optJSONArray.getString(i2));
                }
            }
            bVar.f64184d = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    bVar.f64184d.add(optJSONArray2.getString(i3));
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String[] split;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && (length = (split = str.split("[.]")).length) >= 2) {
                if (length == 2) {
                    return str;
                }
                return split[length - 2] + "." + split[length - 1];
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    private c a(String str) throws a {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            c cVar = new c();
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            String b2 = b(authority);
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && b2 != null) {
                List<b> c2 = c(b2);
                if (c2 == null) {
                    return cVar;
                }
                for (b bVar : c2) {
                    if (bVar.f64181a.matcher(str).find()) {
                        if (bVar.f64182b.compareTo(cVar.f64185a) >= 0) {
                            cVar.f64185a = bVar.f64182b;
                        }
                        cVar.f64186b.addAll(bVar.f64183c);
                        cVar.f64187c.addAll(bVar.f64184d);
                    }
                }
                this.f64175b.put(str, cVar);
                return cVar;
            }
            cVar.f64185a = x.f64192a;
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
