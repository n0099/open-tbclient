package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public TbPageContext b;
    public FastRequest c;
    public boolean d;
    public d e;

    /* loaded from: classes7.dex */
    public interface c {
        void a(g78 g78Var);

        void onFail();
    }

    /* loaded from: classes7.dex */
    public class a implements FastRequest.e<g78> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s78 a;

        public a(s78 s78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.e
        @Nullable
        /* renamed from: b */
        public g78 a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
                return (g78) invokeL.objValue;
            }
            return this.a.l(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends FastRequest.b<g78> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ s78 e;

        public b(s78 s78Var, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s78Var, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s78Var;
            this.c = str;
            this.d = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: i */
        public void d(int i, @NonNull String str, @Nullable g78 g78Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, g78Var) == null) {
                super.d(i, str, g78Var);
                this.e.d = true;
                this.e.a.onFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: j */
        public void g(@NonNull g78 g78Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, g78Var) == null) {
                super.g(g78Var);
                this.e.d = true;
                g78Var.g(this.c);
                g78Var.f(String.valueOf(this.d));
                this.e.j(this.d);
                s78 s78Var = this.e;
                if (s78Var.i(s78Var.e)) {
                    this.e.a.a(g78Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public d(s78 s78Var, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s78Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = j2;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.longValue;
        }
    }

    public s78(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.b = tbPageContext;
    }

    @NonNull
    public final List<d> g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return DataExt.toEntityList(str, d.class);
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public final String h(@NonNull List<d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            return DataExt.toJson(list);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public final d j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            d dVar = new d(this, j, System.currentTimeMillis());
            this.e = dVar;
            return dVar;
        }
        return (d) invokeJ.objValue;
    }

    public final g78 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return g78.e(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (g78) invokeL.objValue;
    }

    public void n(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            o(threadData.getForum_name(), threadData.getFid(), threadData.getTid());
        }
    }

    public final void p(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            synchronized (this) {
                SharedPrefHelper.getInstance().putString("key_homepage_rec_forum_record_info", str);
            }
        }
    }

    public void q(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public final boolean i(@Nullable d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            List<d> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(m())) {
                arrayList = g(m());
            }
            long j = dVar.a;
            long j2 = dVar.b;
            d dVar2 = (d) ListUtils.getItem(arrayList, 1);
            d dVar3 = (d) ListUtils.getItem(arrayList, 0);
            if (dVar2 != null) {
                if (dVar3 == null || j2 - dVar2.c() < 86400000) {
                    return false;
                }
                if (j2 - dVar3.c() < 86400000 && j == dVar3.a) {
                    return false;
                }
                return true;
            } else if (dVar3 != null && j2 - dVar3.c() < 86400000 && j == dVar3.a) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.e == null) {
                return false;
            }
            List<d> list = null;
            if (!TextUtils.isEmpty(m())) {
                list = g(m());
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ListUtils.add(list, 0, this.e);
            if (ListUtils.getCount(list) > 2) {
                list = list.subList(0, 2);
            }
            String h = h(list);
            if (TextUtils.isEmpty(h)) {
                return false;
            }
            p(h);
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final String m() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                string = SharedPrefHelper.getInstance().getString("key_homepage_rec_forum_record_info", "");
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void o(@Nullable String str, long j, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), str2}) != null) || this.a == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || j <= 0 || !this.d) {
            return;
        }
        if (this.c == null) {
            this.c = new FastRequest(this.b, CmdConfigHttp.CMD_GET_HOMEPAGE_REC_FORUM_INFO, TbConfig.GET_HOMEPAGE_REC_FORUM_INFO);
        }
        this.d = false;
        FastRequest fastRequest = this.c;
        fastRequest.N("forum_id", Long.valueOf(j));
        fastRequest.N("forum_name", str);
        fastRequest.S(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.P(new b(this, str2, j));
        fastRequest.U(new a(this));
        fastRequest.O();
    }
}
