package com.baidu.tieba.square.square;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ef;
import com.baidu.tieba.hu8;
import com.baidu.tieba.ru8;
import com.baidu.tieba.s9;
import com.baidu.tieba.vv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SquareModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public ru8 b;
    public a c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, String str, ru8 ru8Var);
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

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, ru8, ru8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hu8 a;
        public int b;
        public ef<String> c;
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
        public ru8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            ru8 ru8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.a = new hu8();
                vv4.d();
                ef<String> e = vv4.e("tb.square");
                this.c = e;
                String str = null;
                if (this.b == 0) {
                    String str2 = e.get("square_cache_key");
                    if (str2 == null) {
                        return null;
                    }
                    ru8 ru8Var2 = new ru8();
                    ru8Var2.j(str2);
                    this.d.h = ru8Var2.f();
                    if (ru8Var2.g()) {
                        this.d.h = 0L;
                    }
                    if (ru8Var2.c()) {
                        return ru8Var2;
                    }
                    this.b = 1;
                    str = str2;
                    ru8Var = ru8Var2;
                } else {
                    ru8Var = null;
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
                    ru8Var = new ru8();
                    ru8Var.j(str);
                    Long valueOf = Long.valueOf(ru8Var.f());
                    if (valueOf.longValue() > this.d.h) {
                        this.c.e("square_cache_key", str, 86400000L);
                    } else {
                        String str3 = this.c.get("square_cache_key");
                        if (str3 != null) {
                            ru8 ru8Var3 = new ru8();
                            ru8Var3.j(str3);
                            ru8Var3.m(ru8Var.e());
                            ru8Var3.n(valueOf.longValue());
                            this.c.e("square_cache_key", ru8Var3.d(), 86400000L);
                            ru8Var = ru8Var3;
                        } else {
                            this.c.e("square_cache_key", str, 86400000L);
                        }
                    }
                    this.d.h = valueOf.longValue();
                }
                return ru8Var;
            }
            return (ru8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ru8 ru8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ru8Var) == null) {
                this.d.a = null;
                this.d.b = ru8Var;
                if (this.d.c != null) {
                    if (this.b != 0 && !this.a.e()) {
                        this.d.c.a(false, this.a.c(), ru8Var);
                        return;
                    }
                    this.d.c.a(true, null, ru8Var);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                hu8 hu8Var = this.a;
                if (hu8Var != null) {
                    hu8Var.b();
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
                super((s9) newInitContext.callArgs[0]);
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
        this.b = new ru8();
    }

    public boolean U(int i) {
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

    public void X(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public ru8 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ru8) invokeV.objValue;
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public long S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return U(0);
        }
        return invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return U(1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
