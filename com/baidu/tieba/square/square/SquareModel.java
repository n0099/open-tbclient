package com.baidu.tieba.square.square;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.t0.s3.j.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class SquareModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f48044e;

    /* renamed from: f  reason: collision with root package name */
    public f f48045f;

    /* renamed from: g  reason: collision with root package name */
    public a f48046g;

    /* renamed from: h  reason: collision with root package name */
    public long f48047h;

    /* renamed from: i  reason: collision with root package name */
    public long f48048i;

    /* renamed from: j  reason: collision with root package name */
    public long f48049j;
    public long k;
    public long l;

    /* loaded from: classes12.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    /* loaded from: classes12.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.t0.s3.g.a a;

        /* renamed from: b  reason: collision with root package name */
        public int f48050b;

        /* renamed from: c  reason: collision with root package name */
        public l<String> f48051c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SquareModel f48052d;

        public b(SquareModel squareModel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48052d = squareModel;
            this.a = null;
            this.f48050b = 1;
            this.f48051c = null;
            this.f48050b = i2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Object... objArr) {
            InterceptResult invokeL;
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.a = new c.a.t0.s3.g.a();
                c.a.s0.s.r.a.f();
                l<String> g2 = c.a.s0.s.r.a.g("tb.square");
                this.f48051c = g2;
                String str = null;
                if (this.f48050b == 0) {
                    String str2 = g2.get("square_cache_key");
                    if (str2 == null) {
                        return null;
                    }
                    f fVar2 = new f();
                    fVar2.j(str2);
                    this.f48052d.l = fVar2.f();
                    if (fVar2.g()) {
                        this.f48052d.l = 0L;
                    }
                    if (fVar2.c()) {
                        return fVar2;
                    }
                    this.f48050b = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    fVar = null;
                }
                if (this.f48050b == 1) {
                    this.f48052d.f48047h = System.currentTimeMillis();
                    this.a.a("prevtime", this.f48052d.l + "");
                    str = this.a.i();
                    this.f48052d.f48048i = this.a.h();
                    this.f48052d.f48049j = this.a.g();
                    this.f48052d.k = System.currentTimeMillis();
                }
                if (this.a.e()) {
                    fVar = new f();
                    fVar.j(str);
                    Long valueOf = Long.valueOf(fVar.f());
                    if (valueOf.longValue() > this.f48052d.l) {
                        this.f48051c.e("square_cache_key", str, 86400000L);
                    } else {
                        String str3 = this.f48051c.get("square_cache_key");
                        if (str3 != null) {
                            f fVar3 = new f();
                            fVar3.j(str3);
                            fVar3.m(fVar.e());
                            fVar3.n(valueOf.longValue());
                            this.f48051c.e("square_cache_key", fVar3.d(), 86400000L);
                            fVar = fVar3;
                        } else {
                            this.f48051c.e("square_cache_key", str, 86400000L);
                        }
                    }
                    this.f48052d.l = valueOf.longValue();
                }
                return fVar;
            }
            return (f) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.f48052d.f48044e = null;
                this.f48052d.f48045f = fVar;
                if (this.f48052d.f48046g != null) {
                    if (this.f48050b == 0 || this.a.e()) {
                        this.f48052d.f48046g.a(true, null, fVar);
                        return;
                    }
                    this.f48052d.f48046g.a(false, this.a.c(), fVar);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                c.a.t0.s3.g.a aVar = this.a;
                if (aVar != null) {
                    aVar.b();
                }
                this.f48052d.f48044e = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareModel(TbPageContext<Object> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48044e = null;
        this.f48045f = null;
        this.f48046g = null;
        this.f48047h = 0L;
        this.f48048i = 0L;
        this.f48049j = 0L;
        this.k = 0L;
        this.f48045f = new f();
    }

    public f F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48045f : (f) invokeV.objValue;
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.longValue;
    }

    public long H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48047h : invokeV.longValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48049j : invokeV.longValue;
    }

    public long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48048i : invokeV.longValue;
    }

    public boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f48044e != null) {
                return false;
            }
            b bVar = new b(this, i2);
            this.f48044e = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? K(0) : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? K(1) : invokeV.booleanValue;
    }

    public void N(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f48046g = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b bVar = this.f48044e;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
