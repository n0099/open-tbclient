package com.baidu.tieba.signall;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.ge8;
import com.repackage.he8;
import com.repackage.ie8;
import com.repackage.le8;
import com.repackage.ni;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class SignAllForumModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public le8 b;
    public a c;
    public ge8 d;
    public String e;
    public boolean isRunning;

    /* loaded from: classes4.dex */
    public interface a {
        void a(le8 le8Var);

        void d(String str);
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Integer, le8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ie8 a;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public le8 doInBackground(String... strArr) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (c() || !(strArr == null || strArr.length == 0 || strArr[0] == null)) {
                    if (c()) {
                        ie8 ie8Var = new ie8();
                        this.a = ie8Var;
                        ie8Var.d(this.c.e);
                        if (ni.z()) {
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
                            ie8 ie8Var2 = new ie8();
                            this.a = ie8Var2;
                            ie8Var2.d(this.c.e);
                            if (ni.z()) {
                                d(sb.toString());
                            }
                        }
                    }
                    return this.c.b;
                }
                return null;
            }
            return (le8) invokeL.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.booleanValue;
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

        public final le8 d(String str) {
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
            return (le8) invokeL.objValue;
        }

        public final le8 e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String f = this.a.f();
                if (this.a.c()) {
                    this.c.b.i(f);
                    return this.c.b;
                }
                this.c.b = null;
                AuthTokenData.parse(f);
                return null;
            }
            return (le8) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(le8 le8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, le8Var) == null) {
                SignAllForumModel signAllForumModel = this.c;
                signAllForumModel.isRunning = false;
                signAllForumModel.a = null;
                if (this.c.c != null) {
                    if (this.c.b != null) {
                        this.c.c.a(this.c.b);
                        return;
                    }
                    ie8 ie8Var = this.a;
                    this.c.c.d(ie8Var != null ? ie8Var.b() : null);
                }
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.b = z;
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.b = new le8();
    }

    public final String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<he8> x = this.d.x();
            if (x == null) {
                return "";
            }
            if (!this.d.B()) {
                ArrayList arrayList = new ArrayList();
                Iterator<he8> it = x.iterator();
                while (it.hasNext()) {
                    he8 next = it.next();
                    if (next.i() < this.d.l()) {
                        arrayList.add(next);
                    }
                }
                x.removeAll(arrayList);
            }
            int size = x.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                he8 he8Var = x.get(i);
                if (he8Var.j()) {
                    if (!he8Var.k()) {
                        he8Var.t(true);
                    }
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(he8Var.c());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ge8 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (ge8) invokeV.objValue;
    }

    public void H(ge8 ge8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ge8Var) == null) {
            this.d = ge8Var;
        }
    }

    public void I(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.c = aVar;
        }
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
            this.a = new b(this);
            boolean n = this.d.n();
            String F = n ? null : F();
            this.a.g(n);
            this.a.execute(F);
            return true;
        }
        return invokeV.booleanValue;
    }
}
