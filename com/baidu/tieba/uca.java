package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.log.TbLogManager;
import com.baidu.tieba.qca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class uca implements TbLogManager.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-378281479, "Lcom/baidu/tieba/uca$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-378281479, "Lcom/baidu/tieba/uca$a;");
                    return;
                }
            }
            int[] iArr = new int[TbLogManager.Level.values().length];
            iArr[TbLogManager.Level.VERBOSE.ordinal()] = 1;
            iArr[TbLogManager.Level.DEBUG.ordinal()] = 2;
            iArr[TbLogManager.Level.INFO.ordinal()] = 3;
            iArr[TbLogManager.Level.WARN.ordinal()] = 4;
            iArr[TbLogManager.Level.ERROR.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements IActiveUploadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbLogManager.b a;

        public b(TbLogManager.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
        public void onFailure(String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, errMsg) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                TbLogManager.b bVar = this.a;
                if (bVar != null) {
                    bVar.onFailure(errMsg);
                }
            }
        }

        @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
        public void onSuccess() {
            TbLogManager.b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bVar = this.a) != null) {
                bVar.onSuccess();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements IActiveUploadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbLogManager.b a;

        public c(TbLogManager.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
        public void onFailure(String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, errMsg) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                TbLogManager.b bVar = this.a;
                if (bVar != null) {
                    bVar.onFailure(errMsg);
                }
            }
        }

        @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
        public void onSuccess() {
            TbLogManager.b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bVar = this.a) != null) {
                bVar.onSuccess();
            }
        }
    }

    public uca() {
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

    public static final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            LoggerManager.reinitialize();
        }
    }

    @Override // com.baidu.tieba.log.TbLogManager.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LoggerManager.requestCleanOverQuotaLog();
        }
    }

    @Override // com.baidu.tieba.log.TbLogManager.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            qca.c(new qca.d() { // from class: com.baidu.tieba.oca
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.qca.d
                public final void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        uca.g();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.log.TbLogManager.a
    public void b(String space, TbLogManager.Level level, String logId, String tag, String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, space, level, logId, tag, msg) == null) {
            Intrinsics.checkNotNullParameter(space, "space");
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(logId, "logId");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Logger logger = LoggerManager.getLogger(space);
            if (logger == null) {
                return;
            }
            int i = a.$EnumSwitchMapping$0[level.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                logger.e(logId, tag, msg);
                            }
                        } else {
                            logger.w(logId, tag, msg);
                        }
                    } else {
                        logger.i(logId, tag, msg);
                    }
                } else {
                    logger.d(logId, tag, msg);
                }
            } else {
                logger.v(logId, tag, msg);
            }
            if (TbadkCoreApplication.getInst().isDebugMode() || aw4.h()) {
                System.out.println((Object) ("TbUbcLog space:" + space + " tag:" + tag + " msg:" + msg));
            }
        }
    }

    @Override // com.baidu.tieba.log.TbLogManager.a
    public void c(String type, String dataId, List<String> spaces, long j, long j2, long j3, TbLogManager.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{type, dataId, spaces, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bVar}) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(dataId, "dataId");
            Intrinsics.checkNotNullParameter(spaces, "spaces");
            ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUpload(type, dataId, spaces, j, j2, j3, new c(bVar));
        }
    }

    @Override // com.baidu.tieba.log.TbLogManager.a
    public void d(String space, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, space, z) == null) {
            Intrinsics.checkNotNullParameter(space, "space");
            Logger logger = LoggerManager.getLogger(space);
            if (logger == null) {
                return;
            }
            logger.flush(z);
        }
    }

    @Override // com.baidu.tieba.log.TbLogManager.a
    public void e(String type, String dataId, List<String> spaces, TbLogManager.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, type, dataId, spaces, bVar) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(dataId, "dataId");
            Intrinsics.checkNotNullParameter(spaces, "spaces");
            ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUpload(type, dataId, spaces, new b(bVar));
        }
    }
}
