package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ti5 {
    public static /* synthetic */ Interceptable $ic;
    public static og0 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements og0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.ti5$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0489a implements ui5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ng0 a;

            @Override // com.baidu.tieba.ui5
            public boolean onFileDownloaded(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            public C0489a(a aVar, ng0 ng0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ng0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ng0Var;
            }

            @Override // com.baidu.tieba.ui5
            public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
                ng0 ng0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) && (ng0Var = this.a) != null) {
                    ng0Var.onFailed(new Exception(str));
                }
            }

            @Override // com.baidu.tieba.ui5
            public void onFileDownloadSucceed(DownloadData downloadData) {
                ng0 ng0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && (ng0Var = this.a) != null) {
                    ng0Var.b(downloadData.getPath());
                }
            }

            @Override // com.baidu.tieba.ui5
            public void onFileUpdateProgress(DownloadData downloadData) {
                ng0 ng0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && (ng0Var = this.a) != null) {
                    ng0Var.a(0L, 100L, (int) (downloadData.getLength() / downloadData.getSize()));
                }
            }

            @Override // com.baidu.tieba.ui5
            public boolean onPreDownload(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                    ng0 ng0Var = this.a;
                    if (ng0Var != null) {
                        ng0Var.onStarted();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        public a() {
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

        @Override // com.baidu.tieba.og0
        public void a(String str, String str2, String str3, ng0 ng0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, ng0Var) == null) {
                DownloadData downloadData = new DownloadData();
                downloadData.setPath(str2 + "/" + str3);
                downloadData.setUrl(str);
                downloadData.setCallback(new C0489a(this, ng0Var));
                vi5.k().l(downloadData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182185, "Lcom/baidu/tieba/ti5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182185, "Lcom/baidu/tieba/ti5;");
                return;
            }
        }
        a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            hg0.q(a);
        }
    }
}
