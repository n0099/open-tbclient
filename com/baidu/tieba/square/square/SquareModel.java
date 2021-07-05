package com.baidu.tieba.square.square;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import d.a.s0.e3.j.f;
/* loaded from: classes5.dex */
public class SquareModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f21016e;

    /* renamed from: f  reason: collision with root package name */
    public f f21017f;

    /* renamed from: g  reason: collision with root package name */
    public a f21018g;

    /* renamed from: h  reason: collision with root package name */
    public long f21019h;

    /* renamed from: i  reason: collision with root package name */
    public long f21020i;
    public long j;
    public long k;
    public long l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, f fVar);
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, f, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.s0.e3.g.a f21021a;

        /* renamed from: b  reason: collision with root package name */
        public int f21022b;

        /* renamed from: c  reason: collision with root package name */
        public l<String> f21023c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SquareModel f21024d;

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
            this.f21024d = squareModel;
            this.f21021a = null;
            this.f21022b = 1;
            this.f21023c = null;
            this.f21022b = i2;
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
                this.f21021a = new d.a.s0.e3.g.a();
                l<String> g2 = d.a.r0.r.r.a.f().g("tb.square");
                this.f21023c = g2;
                String str = null;
                if (this.f21022b == 0) {
                    String str2 = g2.get("square_cache_key");
                    if (str2 == null) {
                        return null;
                    }
                    f fVar2 = new f();
                    fVar2.j(str2);
                    this.f21024d.l = fVar2.f();
                    if (fVar2.g()) {
                        this.f21024d.l = 0L;
                    }
                    if (fVar2.c()) {
                        return fVar2;
                    }
                    this.f21022b = 1;
                    str = str2;
                    fVar = fVar2;
                } else {
                    fVar = null;
                }
                if (this.f21022b == 1) {
                    this.f21024d.f21019h = System.currentTimeMillis();
                    this.f21021a.a("prevtime", this.f21024d.l + "");
                    str = this.f21021a.i();
                    this.f21024d.f21020i = this.f21021a.h();
                    this.f21024d.j = this.f21021a.g();
                    this.f21024d.k = System.currentTimeMillis();
                }
                if (this.f21021a.e()) {
                    fVar = new f();
                    fVar.j(str);
                    Long valueOf = Long.valueOf(fVar.f());
                    if (valueOf.longValue() > this.f21024d.l) {
                        this.f21023c.e("square_cache_key", str, 86400000L);
                    } else {
                        String str3 = this.f21023c.get("square_cache_key");
                        if (str3 != null) {
                            f fVar3 = new f();
                            fVar3.j(str3);
                            fVar3.m(fVar.e());
                            fVar3.n(valueOf.longValue());
                            this.f21023c.e("square_cache_key", fVar3.d(), 86400000L);
                            fVar = fVar3;
                        } else {
                            this.f21023c.e("square_cache_key", str, 86400000L);
                        }
                    }
                    this.f21024d.l = valueOf.longValue();
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
                this.f21024d.f21016e = null;
                this.f21024d.f21017f = fVar;
                if (this.f21024d.f21018g != null) {
                    if (this.f21022b == 0 || this.f21021a.e()) {
                        this.f21024d.f21018g.a(true, null, fVar);
                        return;
                    }
                    this.f21024d.f21018g.a(false, this.f21021a.c(), fVar);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                d.a.s0.e3.g.a aVar = this.f21021a;
                if (aVar != null) {
                    aVar.b();
                }
                this.f21024d.f21016e = null;
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21016e = null;
        this.f21017f = null;
        this.f21018g = null;
        this.f21019h = 0L;
        this.f21020i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.f21017f = new f();
    }

    public f F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21017f : (f) invokeV.objValue;
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.longValue;
    }

    public long H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21019h : invokeV.longValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : invokeV.longValue;
    }

    public long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21020i : invokeV.longValue;
    }

    public boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f21016e != null) {
                return false;
            }
            b bVar = new b(this, i2);
            this.f21016e = bVar;
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? K(1) : invokeV.booleanValue;
    }

    public void N(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f21018g = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b bVar = this.f21016e;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
