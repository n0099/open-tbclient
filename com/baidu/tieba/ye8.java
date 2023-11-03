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
/* loaded from: classes9.dex */
public class ye8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public TbPageContext b;
    public FastRequest c;
    public boolean d;
    public d e;

    /* loaded from: classes9.dex */
    public interface c {
        void a(me8 me8Var);

        void onFail();
    }

    /* loaded from: classes9.dex */
    public class a implements FastRequest.e<me8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye8 a;

        public a(ye8 ye8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.e
        @Nullable
        /* renamed from: b */
        public me8 a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
                return (me8) invokeL.objValue;
            }
            return this.a.l(str);
        }
    }

    /* loaded from: classes9.dex */
    public class b extends FastRequest.b<me8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ ye8 f;

        public b(ye8 ye8Var, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye8Var, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ye8Var;
            this.d = str;
            this.e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable me8 me8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, me8Var) == null) {
                super.f(i, str, me8Var);
                this.f.d = true;
                this.f.a.onFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull me8 me8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, me8Var) == null) {
                super.i(me8Var);
                this.f.d = true;
                me8Var.g(this.d);
                me8Var.f(String.valueOf(this.e));
                this.f.j(this.e);
                ye8 ye8Var = this.f;
                if (ye8Var.i(ye8Var.e)) {
                    this.f.a.a(me8Var);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public d(ye8 ye8Var, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye8Var, Long.valueOf(j), Long.valueOf(j2)};
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

    public ye8(TbPageContext<?> tbPageContext) {
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

    public final me8 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return me8.e(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (me8) invokeL.objValue;
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
        fastRequest.P("forum_id", Long.valueOf(j));
        fastRequest.P("forum_name", str);
        fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.R(new b(this, str2, j));
        fastRequest.W(new a(this));
        fastRequest.Q();
    }
}
