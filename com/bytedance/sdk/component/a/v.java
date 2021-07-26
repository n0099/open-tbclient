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
/* loaded from: classes5.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<b>> f27957a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, c> f27958b;

    /* renamed from: c  reason: collision with root package name */
    public final k.a f27959c;

    /* renamed from: d  reason: collision with root package name */
    public final String f27960d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f27961e;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Pattern f27964a;

        /* renamed from: b  reason: collision with root package name */
        public x f27965b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f27966c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f27967d;

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

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public x f27968a;

        /* renamed from: b  reason: collision with root package name */
        public Set<String> f27969b;

        /* renamed from: c  reason: collision with root package name */
        public Set<String> f27970c;

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
            this.f27968a = x.f27975a;
            this.f27969b = new HashSet();
            this.f27970c = new HashSet();
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
        this.f27957a = new ConcurrentHashMap();
        this.f27961e = false;
        this.f27960d = str;
        if (i2 <= 0) {
            this.f27958b = new LruCache<>(16);
        } else {
            this.f27958b = new LruCache<>(i2);
        }
        this.f27959c = aVar;
        if (jSONObject == null) {
            aVar.a(d(str), new k.a.InterfaceC0314a(this, executor) { // from class: com.bytedance.sdk.component.a.v.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Executor f27962a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ v f27963b;

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
                    this.f27963b = this;
                    this.f27962a = executor;
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
            this.f27957a.clear();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject2.getJSONArray(next);
                    LinkedList linkedList = new LinkedList();
                    this.f27957a.put(next, linkedList);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        linkedList.add(c(jSONArray.getJSONObject(i2)));
                    }
                }
            } catch (JSONException e2) {
                i.b("Parse configurations failed, response: " + jSONObject.toString(), e2);
            }
            this.f27961e = true;
        }
    }

    private List<b> c(String str) throws a {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (this.f27961e) {
                return this.f27957a.get(str);
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
            this.f27959c.a(d(this.f27960d), jSONObject.toString());
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
                    cVar.f27968a = x.f27977c;
                    return cVar;
                }
                c cVar2 = this.f27958b.get(builder);
                return cVar2 != null ? cVar2 : a(builder);
            }
            cVar.f27968a = x.f27975a;
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
            bVar.f27964a = Pattern.compile(jSONObject.getString("pattern"));
            bVar.f27965b = x.a(jSONObject.getString("group"));
            bVar.f27966c = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    bVar.f27966c.add(optJSONArray.getString(i2));
                }
            }
            bVar.f27967d = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    bVar.f27967d.add(optJSONArray2.getString(i3));
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
                    if (bVar.f27964a.matcher(str).find()) {
                        if (bVar.f27965b.compareTo(cVar.f27968a) >= 0) {
                            cVar.f27968a = bVar.f27965b;
                        }
                        cVar.f27969b.addAll(bVar.f27966c);
                        cVar.f27970c.addAll(bVar.f27967d);
                    }
                }
                this.f27958b.put(str, cVar);
                return cVar;
            }
            cVar.f27968a = x.f27975a;
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
