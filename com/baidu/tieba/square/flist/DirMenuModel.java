package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.l9;
import com.baidu.tieba.n9a;
import com.baidu.tieba.o55;
import com.baidu.tieba.o9a;
import com.baidu.tieba.ye;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public c b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z, int i, o9a o9aVar, String str, boolean z2);
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, Integer, n9a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public n9a b;
        public final /* synthetic */ DirMenuModel c;

        public b(DirMenuModel dirMenuModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dirMenuModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dirMenuModel;
            this.a = null;
            this.b = new n9a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, numArr) == null) {
                super.onProgressUpdate(numArr);
                if (this.b != null) {
                    this.c.b.a(true, this.b.a(), this.b.h(), this.b.b(), this.c.g);
                }
            }
        }

        public /* synthetic */ b(DirMenuModel dirMenuModel, a aVar) {
            this(dirMenuModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public n9a doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                o55.e();
                ye<String> f = o55.f("tb.my_posts");
                if (f != null) {
                    str = f.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.c.c + "_dir");
                } else {
                    str = null;
                }
                if (str != null) {
                    this.b.e(str);
                    this.c.g = true;
                    publishProgress(new Integer[0]);
                }
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                    this.a = netWork;
                    netWork.addPostData("menu_name", this.c.c);
                    this.a.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, this.c.d);
                    this.a.addPostData("menu_id", this.c.e);
                    postNetData = this.a.postNetData();
                } catch (Exception e) {
                    this.b.g(e.getMessage());
                    BdLog.detailException(e);
                }
                if (postNetData == null) {
                    return this.b;
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.b.e(postNetData);
                    this.c.f = true;
                    if (f != null) {
                        f.e(TbadkCoreApplication.getCurrentAccount() + "_" + this.c.c + "_dir", postNetData, 86400000L);
                    }
                } else {
                    this.b.g(this.a.getErrorString());
                    this.c.f = false;
                }
                return this.b;
            }
            return (n9a) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(n9a n9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n9aVar) == null) {
                if (!this.c.f) {
                    this.c.b.a(false, -1, null, n9aVar.b(), this.c.g);
                } else if (n9aVar.h() != null) {
                    this.c.b.a(true, n9aVar.a(), n9aVar.h(), n9aVar.b(), this.c.g);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, str3};
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
        this.f = false;
        this.g = false;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public void d0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.b = cVar;
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = new b(this, null);
            this.a = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeV.booleanValue;
    }
}
