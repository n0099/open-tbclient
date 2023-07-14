package com.baidu.tieba.square.square;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.g9a;
import com.baidu.tieba.l9;
import com.baidu.tieba.o55;
import com.baidu.tieba.q9a;
import com.baidu.tieba.ye;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SquareModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public q9a b;
    public a c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, String str, q9a q9aVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, q9a, q9a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public g9a a;
        public int b;
        public ye<String> c;
        public final /* synthetic */ SquareModel d;

        public b(SquareModel squareModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {squareModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = squareModel;
            this.a = null;
            this.b = 1;
            this.c = null;
            this.b = i;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public q9a doInBackground(Object... objArr) {
            InterceptResult invokeL;
            q9a q9aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.a = new g9a();
                o55.e();
                ye<String> f = o55.f("tb.square");
                this.c = f;
                String str = null;
                if (this.b == 0) {
                    String str2 = f.get("square_cache_key");
                    if (str2 == null) {
                        return null;
                    }
                    q9a q9aVar2 = new q9a();
                    q9aVar2.j(str2);
                    this.d.h = q9aVar2.f();
                    if (q9aVar2.g()) {
                        this.d.h = 0L;
                    }
                    if (q9aVar2.c()) {
                        return q9aVar2;
                    }
                    this.b = 1;
                    str = str2;
                    q9aVar = q9aVar2;
                } else {
                    q9aVar = null;
                }
                if (this.b == 1) {
                    this.d.d = System.currentTimeMillis();
                    this.a.a("prevtime", this.d.h + "");
                    str = this.a.i();
                    this.d.e = this.a.h();
                    this.d.f = this.a.g();
                    this.d.g = System.currentTimeMillis();
                }
                if (this.a.e()) {
                    q9aVar = new q9a();
                    q9aVar.j(str);
                    Long valueOf = Long.valueOf(q9aVar.f());
                    if (valueOf.longValue() > this.d.h) {
                        this.c.e("square_cache_key", str, 86400000L);
                    } else {
                        String str3 = this.c.get("square_cache_key");
                        if (str3 != null) {
                            q9a q9aVar3 = new q9a();
                            q9aVar3.j(str3);
                            q9aVar3.m(q9aVar.e());
                            q9aVar3.n(valueOf.longValue());
                            this.c.e("square_cache_key", q9aVar3.d(), 86400000L);
                            q9aVar = q9aVar3;
                        } else {
                            this.c.e("square_cache_key", str, 86400000L);
                        }
                    }
                    this.d.h = valueOf.longValue();
                }
                return q9aVar;
            }
            return (q9a) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(q9a q9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q9aVar) == null) {
                this.d.a = null;
                this.d.b = q9aVar;
                if (this.d.c != null) {
                    if (this.b != 0 && !this.a.e()) {
                        this.d.c.a(false, this.a.c(), q9aVar);
                        return;
                    }
                    this.d.c.a(true, null, q9aVar);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                g9a g9aVar = this.a;
                if (g9aVar != null) {
                    g9aVar.b();
                }
                this.d.a = null;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.b = new q9a();
    }

    public boolean j0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a != null) {
                return false;
            }
            b bVar = new b(this, i);
            this.a = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void m0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.c = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public q9a e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (q9a) invokeV.objValue;
    }

    public long f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public long g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public long i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return j0(0);
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return j0(1);
        }
        return invokeV.booleanValue;
    }
}
