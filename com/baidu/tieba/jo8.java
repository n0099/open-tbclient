package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes6.dex */
public class jo8 extends cw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.cw4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CommandUBCHelper.COMMAND_UBC_SOURCE_SEND : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, hw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public String b;
        public String c;
        public HashMap<String, String> d;
        public j9 e;

        public a(jo8 jo8Var, String str, String str2, HashMap<String, String> hashMap, j9 j9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo8Var, str, str2, hashMap, j9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = str;
            this.c = str2;
            this.d = hashMap;
            this.e = j9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public hw4 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                hw4 hw4Var = new hw4();
                try {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + this.c);
                    Set<String> keySet = this.d.keySet();
                    if (keySet.size() > 0) {
                        for (String str : keySet) {
                            if (!"url".equalsIgnoreCase(str)) {
                                this.a.addPostData(str, this.d.get(str));
                            }
                        }
                    }
                    this.a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                    this.a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                    boolean z = true;
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    String postNetData = this.a.postNetData();
                    if (!this.a.getNetContext().getResponse().isNetSuccess()) {
                        hw4Var.b = this.a.getNetErrorCode();
                        hw4Var.c = this.a.getNetString();
                    } else {
                        hw4Var.b = this.a.getServerErrorCode();
                        hw4Var.c = this.a.getErrorString();
                    }
                    if (this.a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (hw4Var.b != 0) {
                            z = false;
                        }
                        hw4Var.a = z;
                        return hw4Var;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                hw4Var.a = false;
                return hw4Var;
            }
            return (hw4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hw4Var) == null) {
                j9 j9Var = this.e;
                if (j9Var != null) {
                    j9Var.c(hw4Var);
                }
                fo8.a().d(this.c, this.d, hw4Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null) {
                    this.a.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
                j9 j9Var = this.e;
                if (j9Var != null) {
                    j9Var.c(null);
                }
            }
        }
    }

    public jo8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.cw4, com.baidu.tieba.fw4
    public void a(Object obj, HashMap<String, String> hashMap, String str, j9 j9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, obj, hashMap, str, j9Var) == null) && hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            a aVar = new a(this, str, str2, hashMap, j9Var);
            aVar.setPriority(2);
            aVar.execute(new Object[0]);
        }
    }
}
