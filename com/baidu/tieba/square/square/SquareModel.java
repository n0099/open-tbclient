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
import com.repackage.d9;
import com.repackage.mq4;
import com.repackage.pe8;
import com.repackage.te;
import com.repackage.ze8;
/* loaded from: classes4.dex */
public class SquareModel extends BdBaseModel<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public ze8 b;
    public a c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, String str, ze8 ze8Var);
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, ze8, ze8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pe8 a;
        public int b;
        public te<String> c;
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
        public ze8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            ze8 ze8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.a = new pe8();
                mq4.f();
                te<String> g = mq4.g("tb.square");
                this.c = g;
                String str = null;
                if (this.b == 0) {
                    String str2 = g.get("square_cache_key");
                    if (str2 == null) {
                        return null;
                    }
                    ze8 ze8Var2 = new ze8();
                    ze8Var2.j(str2);
                    this.d.h = ze8Var2.f();
                    if (ze8Var2.g()) {
                        this.d.h = 0L;
                    }
                    if (ze8Var2.c()) {
                        return ze8Var2;
                    }
                    this.b = 1;
                    str = str2;
                    ze8Var = ze8Var2;
                } else {
                    ze8Var = null;
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
                    ze8Var = new ze8();
                    ze8Var.j(str);
                    Long valueOf = Long.valueOf(ze8Var.f());
                    if (valueOf.longValue() > this.d.h) {
                        this.c.e("square_cache_key", str, 86400000L);
                    } else {
                        String str3 = this.c.get("square_cache_key");
                        if (str3 != null) {
                            ze8 ze8Var3 = new ze8();
                            ze8Var3.j(str3);
                            ze8Var3.m(ze8Var.e());
                            ze8Var3.n(valueOf.longValue());
                            this.c.e("square_cache_key", ze8Var3.d(), 86400000L);
                            ze8Var = ze8Var3;
                        } else {
                            this.c.e("square_cache_key", str, 86400000L);
                        }
                    }
                    this.d.h = valueOf.longValue();
                }
                return ze8Var;
            }
            return (ze8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ze8 ze8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ze8Var) == null) {
                this.d.a = null;
                this.d.b = ze8Var;
                if (this.d.c != null) {
                    if (this.b == 0 || this.a.e()) {
                        this.d.c.a(true, null, ze8Var);
                        return;
                    }
                    this.d.c.a(false, this.a.c(), ze8Var);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                pe8 pe8Var = this.a;
                if (pe8Var != null) {
                    pe8Var.b();
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
                super((d9) newInitContext.callArgs[0]);
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
        this.b = new ze8();
    }

    public ze8 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (ze8) invokeV.objValue;
    }

    public long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : invokeV.longValue;
    }

    public long K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.longValue;
    }

    public long L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.longValue;
    }

    public long M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : invokeV.longValue;
    }

    public boolean N(int i) {
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

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? N(0) : invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? N(1) : invokeV.booleanValue;
    }

    public void Q(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.c = aVar;
        }
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
