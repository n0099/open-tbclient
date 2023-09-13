package com.baidu.tieba.square.square;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.bea;
import com.baidu.tieba.lea;
import com.baidu.tieba.oe;
import com.baidu.tieba.x45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SquareModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public lea b;
    public a c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z, String str, lea leaVar);
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

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Object, lea, lea> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bea a;
        public int b;
        public oe<String> c;
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
        public lea doInBackground(Object... objArr) {
            InterceptResult invokeL;
            lea leaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.a = new bea();
                x45.k();
                oe<String> l = x45.l("tb.square");
                this.c = l;
                String str = null;
                if (this.b == 0) {
                    String str2 = l.get("square_cache_key");
                    if (str2 == null) {
                        return null;
                    }
                    lea leaVar2 = new lea();
                    leaVar2.j(str2);
                    this.d.h = leaVar2.f();
                    if (leaVar2.g()) {
                        this.d.h = 0L;
                    }
                    if (leaVar2.c()) {
                        return leaVar2;
                    }
                    this.b = 1;
                    str = str2;
                    leaVar = leaVar2;
                } else {
                    leaVar = null;
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
                    leaVar = new lea();
                    leaVar.j(str);
                    Long valueOf = Long.valueOf(leaVar.f());
                    if (valueOf.longValue() > this.d.h) {
                        this.c.e("square_cache_key", str, 86400000L);
                    } else {
                        String str3 = this.c.get("square_cache_key");
                        if (str3 != null) {
                            lea leaVar3 = new lea();
                            leaVar3.j(str3);
                            leaVar3.m(leaVar.e());
                            leaVar3.n(valueOf.longValue());
                            this.c.e("square_cache_key", leaVar3.d(), 86400000L);
                            leaVar = leaVar3;
                        } else {
                            this.c.e("square_cache_key", str, 86400000L);
                        }
                    }
                    this.d.h = valueOf.longValue();
                }
                return leaVar;
            }
            return (lea) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(lea leaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, leaVar) == null) {
                this.d.a = null;
                this.d.b = leaVar;
                if (this.d.c != null) {
                    if (this.b != 0 && !this.a.e()) {
                        this.d.c.a(false, this.a.c(), leaVar);
                        return;
                    }
                    this.d.c.a(true, null, leaVar);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                bea beaVar = this.a;
                if (beaVar != null) {
                    beaVar.b();
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
                super((BdPageContext) newInitContext.callArgs[0]);
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
        this.b = new lea();
    }

    public boolean a0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
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

    public void d0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public lea V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (lea) invokeV.objValue;
    }

    public long W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public long Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return a0(0);
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return a0(1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
