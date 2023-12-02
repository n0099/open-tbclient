package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.dqa;
import com.baidu.tieba.eqa;
import com.baidu.tieba.fqa;
import com.baidu.tieba.iqa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public iqa b;
    public a c;
    public dqa d;
    public String e;
    public boolean isRunning;

    /* loaded from: classes8.dex */
    public interface a {
        void a(iqa iqaVar);

        void c(String str);
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, iqa> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fqa a;
        public boolean b;
        public final /* synthetic */ SignAllForumModel c;

        public b(SignAllForumModel signAllForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signAllForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = signAllForumModel;
            this.a = null;
            this.b = false;
            setPriority(3);
        }

        public final iqa d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                String e = this.a.e(str);
                if (this.a.c()) {
                    this.c.b.i(e);
                    return this.c.b;
                }
                this.c.b = null;
                AuthTokenData.parse(e);
                return null;
            }
            return (iqa) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public iqa doInBackground(String... strArr) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (!c() && (strArr == null || strArr.length == 0 || strArr[0] == null)) {
                    return null;
                }
                if (c()) {
                    fqa fqaVar = new fqa();
                    this.a = fqaVar;
                    fqaVar.d(this.c.e);
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        e();
                    }
                } else {
                    String[] split = strArr[0].split(",");
                    int ceil = (int) Math.ceil(split.length / 50.0f);
                    for (int i2 = 0; i2 < ceil; i2++) {
                        int i3 = i2 * 50;
                        StringBuilder sb = new StringBuilder();
                        for (int i4 = 0; i4 < 50 && (i = i3 + i4) < split.length; i4++) {
                            if (i == split.length - 1) {
                                sb.append(split[i]);
                            } else {
                                sb.append(split[i] + ",");
                            }
                        }
                        fqa fqaVar2 = new fqa();
                        this.a = fqaVar2;
                        fqaVar2.d(this.c.e);
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d(sb.toString());
                        }
                    }
                }
                return this.c.b;
            }
            return (iqa) invokeL.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                this.a.a();
                this.a = null;
                this.c.a = null;
                this.c.isRunning = false;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                super.onPreExecute();
                this.c.isRunning = true;
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.b = z;
            }
        }

        public final iqa e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String f = this.a.f();
                if (!this.a.c()) {
                    this.c.b = null;
                    AuthTokenData.parse(f);
                    return null;
                }
                this.c.b.i(f);
                return this.c.b;
            }
            return (iqa) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(iqa iqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iqaVar) == null) {
                SignAllForumModel signAllForumModel = this.c;
                signAllForumModel.isRunning = false;
                String str = null;
                signAllForumModel.a = null;
                if (this.c.c != null) {
                    if (this.c.b != null) {
                        this.c.c.a(this.c.b);
                        return;
                    }
                    fqa fqaVar = this.a;
                    if (fqaVar != null) {
                        str = fqaVar.b();
                    }
                    this.c.c.c(str);
                }
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
        this.b = new iqa();
    }

    public void V(dqa dqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dqaVar) == null) {
            this.d = dqaVar;
        }
    }

    public void W(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<eqa> x = this.d.x();
            if (x == null) {
                return "";
            }
            if (!this.d.B()) {
                ArrayList arrayList = new ArrayList();
                Iterator<eqa> it = x.iterator();
                while (it.hasNext()) {
                    eqa next = it.next();
                    if (next.i() < this.d.l()) {
                        arrayList.add(next);
                    }
                }
                x.removeAll(arrayList);
            }
            int size = x.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                eqa eqaVar = x.get(i);
                if (eqaVar.j()) {
                    if (!eqaVar.k()) {
                        eqaVar.t(true);
                    }
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(eqaVar.c());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public dqa U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (dqa) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a != null) {
                return false;
            }
            String str = null;
            this.a = new b(this);
            boolean n = this.d.n();
            if (!n) {
                str = T();
            }
            this.a.g(n);
            this.a.execute(str);
            return true;
        }
        return invokeV.booleanValue;
    }
}
