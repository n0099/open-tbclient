package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class zz4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 604800000;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948377237, "Lcom/baidu/tieba/zz4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948377237, "Lcom/baidu/tieba/zz4;");
        }
    }

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.zz4$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC0548a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0548a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ChunkUploadDatabaseService.delOverdueChunkUploadData();
                        zz4.c(TbadkCoreApplication.getInst().getCacheDir());
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                long j = SharedPrefHelper.getInstance().getLong("key_clear_resource", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j == 0) {
                    SharedPrefHelper.getInstance().putLong("key_clear_resource", currentTimeMillis);
                    j = currentTimeMillis;
                }
                if (currentTimeMillis - j > zz4.a) {
                    vu6.a(new RunnableC0548a(this), "clearResource", 3);
                    SharedPrefHelper.getInstance().putLong("key_clear_resource", currentTimeMillis);
                }
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            MessageManager.getInstance().registerListener(new a(2005016));
        }
    }

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, file) != null) || file == null) {
            return;
        }
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            c(listFiles[i]);
                        } else {
                            listFiles[i].delete();
                        }
                    }
                    return;
                }
                return;
            }
            file.delete();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
