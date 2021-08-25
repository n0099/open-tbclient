package com.baidu.tieba.signall;

import c.a.e.a.f;
import c.a.e.e.p.j;
import c.a.q0.e3.c;
import c.a.q0.e3.d;
import c.a.q0.e3.e;
import c.a.q0.e3.h;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f56683e;

    /* renamed from: f  reason: collision with root package name */
    public h f56684f;

    /* renamed from: g  reason: collision with root package name */
    public a f56685g;

    /* renamed from: h  reason: collision with root package name */
    public c f56686h;

    /* renamed from: i  reason: collision with root package name */
    public String f56687i;
    public boolean isRunning;

    /* loaded from: classes7.dex */
    public interface a {
        void a(h hVar);

        void onNetError(String str);
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Integer, h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e f56688a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f56689b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SignAllForumModel f56690c;

        public b(SignAllForumModel signAllForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56690c = signAllForumModel;
            this.f56688a = null;
            this.f56689b = false;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public h doInBackground(String... strArr) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (c() || !(strArr == null || strArr.length == 0 || strArr[0] == null)) {
                    if (c()) {
                        e eVar = new e();
                        this.f56688a = eVar;
                        eVar.d(this.f56690c.f56687i);
                        if (j.z()) {
                            e();
                        }
                    } else {
                        String[] split = strArr[0].split(",");
                        int ceil = (int) Math.ceil(split.length / 50.0f);
                        for (int i3 = 0; i3 < ceil; i3++) {
                            int i4 = i3 * 50;
                            StringBuilder sb = new StringBuilder();
                            for (int i5 = 0; i5 < 50 && (i2 = i4 + i5) < split.length; i5++) {
                                if (i2 == split.length - 1) {
                                    sb.append(split[i2]);
                                } else {
                                    sb.append(split[i2] + ",");
                                }
                            }
                            e eVar2 = new e();
                            this.f56688a = eVar2;
                            eVar2.d(this.f56690c.f56687i);
                            if (j.z()) {
                                d(sb.toString());
                            }
                        }
                    }
                    return this.f56690c.f56684f;
                }
                return null;
            }
            return (h) invokeL.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56689b : invokeV.booleanValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                this.f56688a.a();
                this.f56688a = null;
                this.f56690c.f56683e = null;
                this.f56690c.isRunning = false;
            }
        }

        public final h d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                String e2 = this.f56688a.e(str);
                if (this.f56688a.c()) {
                    this.f56690c.f56684f.i(e2);
                    return this.f56690c.f56684f;
                }
                this.f56690c.f56684f = null;
                AuthTokenData.parse(e2);
                return null;
            }
            return (h) invokeL.objValue;
        }

        public final h e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String f2 = this.f56688a.f();
                if (this.f56688a.c()) {
                    this.f56690c.f56684f.i(f2);
                    return this.f56690c.f56684f;
                }
                this.f56690c.f56684f = null;
                AuthTokenData.parse(f2);
                return null;
            }
            return (h) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
                SignAllForumModel signAllForumModel = this.f56690c;
                signAllForumModel.isRunning = false;
                signAllForumModel.f56683e = null;
                if (this.f56690c.f56685g != null) {
                    if (this.f56690c.f56684f != null) {
                        this.f56690c.f56685g.a(this.f56690c.f56684f);
                        return;
                    }
                    e eVar = this.f56688a;
                    this.f56690c.f56685g.onNetError(eVar != null ? eVar.b() : null);
                }
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.f56689b = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                super.onPreExecute();
                this.f56690c.isRunning = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignAllForumModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56683e = null;
        this.f56684f = null;
        this.f56685g = null;
        this.f56684f = new h();
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<d> x = this.f56686h.x();
            if (x == null) {
                return "";
            }
            if (!this.f56686h.B()) {
                ArrayList arrayList = new ArrayList();
                Iterator<d> it = x.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next.i() < this.f56686h.l()) {
                        arrayList.add(next);
                    }
                }
                x.removeAll(arrayList);
            }
            int size = x.size();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = x.get(i2);
                if (dVar.j()) {
                    if (!dVar.k()) {
                        dVar.t(true);
                    }
                }
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(dVar.c());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public c C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56686h : (c) invokeV.objValue;
    }

    public void D(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f56686h = cVar;
        }
    }

    public void E(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f56685g = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f56683e != null) {
                return false;
            }
            this.f56683e = new b(this);
            boolean n = this.f56686h.n();
            String B = n ? null : B();
            this.f56683e.g(n);
            this.f56683e.execute(B);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b bVar = this.f56683e;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
