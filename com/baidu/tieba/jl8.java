package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.immessagecenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.immessagecenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes6.dex */
public class jl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public BdUniqueId b;
    public long c;
    public c d;
    public ArrayList<xn> e;
    public boolean f;
    public kb g;
    @Nullable
    public BdAsyncTask<Void, Void, ArrayList<ll8>> h;

    /* loaded from: classes6.dex */
    public interface c {
        void k(ArrayList<xn> arrayList);

        void onFailed(String str);
    }

    /* loaded from: classes6.dex */
    public class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jl8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jl8 jl8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl8Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jl8Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                if (this.a.d != null) {
                    this.a.d.onFailed(responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            boolean z = false;
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) responsedMessage.getOrginalMessage().getExtra()).id == 0) {
                z = true;
            }
            if (responsedMessage instanceof AgreeMeHTTPResponseMessage) {
                AgreeMeHTTPResponseMessage agreeMeHTTPResponseMessage = (AgreeMeHTTPResponseMessage) responsedMessage;
                this.a.j(agreeMeHTTPResponseMessage.datas, z);
                this.a.f = agreeMeHTTPResponseMessage.hasMore;
            } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                this.a.j(agreeMeSocketResponseMessage.datas, z);
                this.a.f = agreeMeSocketResponseMessage.hasMore;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, ArrayList<ll8>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jl8 a;

        public b(jl8 jl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<ll8> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList == null) {
                    return;
                }
                this.a.i(arrayList);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<ll8> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<ll8> arrayList = new ArrayList<>();
                f55.d();
                xe<byte[]> c = f55.c("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (c != null && (bArr = c.get("agree_me_cache_key")) != null) {
                    try {
                        boolean z = false;
                        AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
                        if (agreeMeResIdl.data != null) {
                            jl8 jl8Var = this.a;
                            if (agreeMeResIdl.data.has_more.intValue() == 1) {
                                z = true;
                            }
                            jl8Var.f = z;
                            for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                                if (agreeList != null) {
                                    ll8 ll8Var = new ll8();
                                    ll8Var.E(agreeList);
                                    arrayList.add(ll8Var);
                                }
                            }
                            return arrayList;
                        }
                        return arrayList;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return arrayList;
            }
            return (ArrayList) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947887251, "Lcom/baidu/tieba/jl8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947887251, "Lcom/baidu/tieba/jl8;");
                return;
            }
        }
        v3a.h(309593, AgreeMeSocketResponseMessage.class, false, false);
        v3a.c(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public jl8(TbPageContext tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = 0L;
        this.g = new a(this, CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593);
        if (tbPageContext != null) {
            this.b = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.g);
            this.d = cVar;
        }
    }

    public final void j(ArrayList<ll8> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, arrayList, z) == null) {
            this.a = true;
            if (ListUtils.isEmpty(this.e)) {
                this.e = new ArrayList<>();
            }
            if (!z) {
                this.e.addAll(arrayList);
            } else {
                this.e.clear();
                this.e.addAll(0, arrayList);
            }
            ArrayList<xn> arrayList2 = this.e;
            xn xnVar = (xn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
            if (xnVar instanceof ll8) {
                this.c = ((ll8) xnVar).i();
            }
            c cVar = this.d;
            if (cVar != null) {
                cVar.k(this.e);
            }
        }
    }

    public void d() {
        BdAsyncTask<Void, Void, ArrayList<ll8>> bdAsyncTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bdAsyncTask = this.h) != null) {
            bdAsyncTask.cancel();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f();
            g();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = new b(this).execute(new Void[0]);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
            agreeMeRequestMessage.id = this.c;
            agreeMeRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c = 0L;
            g();
        }
    }

    public final void i(ArrayList<ll8> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, arrayList) != null) || this.a) {
            return;
        }
        if (ListUtils.isEmpty(this.e)) {
            this.e = new ArrayList<>();
        } else {
            this.e.clear();
        }
        this.e.addAll(arrayList);
        ArrayList<xn> arrayList2 = this.e;
        xn xnVar = (xn) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
        if (xnVar instanceof ll8) {
            this.c = ((ll8) xnVar).i();
        }
        if (this.d != null && !ListUtils.isEmpty(this.e)) {
            this.d.k(this.e);
        }
    }
}
