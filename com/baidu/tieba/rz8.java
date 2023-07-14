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
/* loaded from: classes7.dex */
public class rz8 extends zv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zv4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CommandUBCHelper.COMMAND_UBC_SOURCE_SEND : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, ew4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public String b;
        public String c;
        public HashMap<String, String> d;
        public k9 e;

        public a(rz8 rz8Var, String str, String str2, HashMap<String, String> hashMap, k9 k9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz8Var, str, str2, hashMap, k9Var};
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
            this.e = k9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ew4 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                ew4 ew4Var = new ew4();
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
                        ew4Var.b = this.a.getNetErrorCode();
                        ew4Var.c = this.a.getNetString();
                    } else {
                        ew4Var.b = this.a.getServerErrorCode();
                        ew4Var.c = this.a.getErrorString();
                    }
                    if (this.a.getNetContext().getResponse().isRequestSuccess() && postNetData != null) {
                        if (ew4Var.b != 0) {
                            z = false;
                        }
                        ew4Var.a = z;
                        return ew4Var;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                ew4Var.a = false;
                return ew4Var;
            }
            return (ew4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ew4 ew4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ew4Var) == null) {
                k9 k9Var = this.e;
                if (k9Var != null) {
                    k9Var.c(ew4Var);
                }
                nz8.a().d(this.c, this.d, ew4Var);
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
                k9 k9Var = this.e;
                if (k9Var != null) {
                    k9Var.c(null);
                }
            }
        }
    }

    public rz8() {
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

    @Override // com.baidu.tieba.zv4, com.baidu.tieba.cw4
    public void a(Object obj, HashMap<String, String> hashMap, String str, k9 k9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, obj, hashMap, str, k9Var) == null) && hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("url")) {
            String str2 = hashMap.get("url");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            a aVar = new a(this, str, str2, hashMap, k9Var);
            aVar.setPriority(2);
            aVar.execute(new Object[0]);
        }
    }
}
