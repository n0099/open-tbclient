package com.baidu.tieba.myCollection.baseEditMark;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.ax4;
import com.baidu.tieba.l9;
import com.baidu.tieba.s95;
import com.baidu.tieba.t99;
import com.baidu.tieba.v99;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MarkModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public MarkData b;
    public a c;
    public ax4.a d;

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
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public boolean b;
        public v99 c;
        public final /* synthetic */ MarkModel d;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        public a(MarkModel markModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {markModel, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = markModel;
            this.a = null;
            this.b = true;
            this.c = null;
            this.b = z;
            this.c = new v99();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                boolean z = false;
                if (this.b) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                    t99 t99Var = new t99();
                    t99Var.j(this.d.b);
                    this.a.addPostData("data", t99Var.E(0, 1));
                } else {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                    this.a = netWork;
                    netWork.addPostData("user_id", this.d.b.getAccount());
                    this.a.addPostData("tid", this.d.b.getId());
                    this.a.addPostData("fid", this.d.b.getForumId());
                }
                this.c.c(this.a.postNetData());
                if (this.c.a() == 0) {
                    z = true;
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess() && z) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                try {
                    if (this.c != null) {
                        s95.a("collection", 0L, 0, "add_collection_thread", this.c.a(), this.c.b(), new Object[0]);
                    }
                    if (bool.booleanValue()) {
                        if (this.d.d != null) {
                            this.d.d.a(true, this.b, null);
                        }
                    } else if (this.d.d != null) {
                        if (this.a != null && !this.a.getNetContext().getResponse().isRequestSuccess()) {
                            this.d.d.a(false, this.b, this.a.getErrorString());
                        } else {
                            ax4.a aVar = this.d.d;
                            boolean z = this.b;
                            if (this.c != null) {
                                str = this.c.b();
                            } else {
                                str = "";
                            }
                            aVar.a(false, z, str);
                        }
                    }
                    this.d.c = null;
                } catch (Throwable th) {
                    BdLog.e(th.toString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.d.c = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
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
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = new MarkData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = new MarkData();
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a = z;
        }
    }

    public void e0(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, markData) == null) {
            this.b = markData;
        }
    }

    public void f0(ax4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, true);
            this.c = aVar2;
            aVar2.setPriority(3);
            this.c.execute(new Boolean[0]);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, false);
            this.c = aVar2;
            aVar2.setPriority(3);
            this.c.execute(new Boolean[0]);
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public MarkData b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (MarkData) invokeV.objValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MarkData markData = this.b;
            if (markData != null) {
                return markData.getPostId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
