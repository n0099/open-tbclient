package com.baidu.tieba.log;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007JF\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0007J0\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J \u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J \u0010!\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J\b\u0010\"\u001a\u00020\bH\u0007J\b\u0010#\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/tieba/log/TbLogManager;", "", "()V", "DEFAULT_SPACE", "", "mTbUbcLog", "Lcom/baidu/tieba/log/TbLogManager$ITbUbcLog;", StatConstants.VALUE_FROM_AC_UPLOAD, "", "type", "dataId", "spaces", "", "activeUploadListener", "Lcom/baidu/tieba/log/TbLogManager$IUploadListener;", "maxSizeLimit", "", "startTime", "endTime", "flush", "space", "waitForFinish", "", "flushDefault", "initTbUbcLog", "impl", LocalFilesFilterKt.FILTER_NAME_LOG, "level", "Lcom/baidu/tieba/log/TbLogManager$Level;", "logId", "tag", "msg", "logE", "logI", "reinitializeSdk", "requestCleanOverQuotaLog", "ITbUbcLog", "IUploadListener", "Level", "TbLogCore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TbLogManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_SPACE = "default";
    public static final TbLogManager INSTANCE;
    public static a mTbUbcLog;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b(String str, Level level, String str2, String str3, String str4);

        void c(String str, String str2, List<String> list, long j, long j2, long j3, b bVar);

        void d(String str, boolean z);

        void e(String str, String str2, List<String> list, b bVar);

        void f();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onFailure(String str);

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-851769717, "Lcom/baidu/tieba/log/TbLogManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-851769717, "Lcom/baidu/tieba/log/TbLogManager;");
                return;
            }
        }
        INSTANCE = new TbLogManager();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tieba/log/TbLogManager$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "TbLogCore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Level {
        public static final /* synthetic */ Level[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Level DEBUG;
        public static final Level ERROR;
        public static final Level INFO;
        public static final Level VERBOSE;
        public static final Level WARN;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ Level[] $values() {
            return new Level[]{VERBOSE, DEBUG, INFO, WARN, ERROR};
        }

        public static Level valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Level) Enum.valueOf(Level.class, str) : (Level) invokeL.objValue;
        }

        public static Level[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Level[]) $VALUES.clone() : (Level[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1708646197, "Lcom/baidu/tieba/log/TbLogManager$Level;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1708646197, "Lcom/baidu/tieba/log/TbLogManager$Level;");
                    return;
                }
            }
            VERBOSE = new Level("VERBOSE", 0);
            DEBUG = new Level("DEBUG", 1);
            INFO = new Level("INFO", 2);
            WARN = new Level("WARN", 3);
            ERROR = new Level("ERROR", 4);
            $VALUES = $values();
        }

        public Level(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    public TbLogManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void flushDefault() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            flush("default", true);
        }
    }

    @JvmStatic
    public static final void reinitializeSdk() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (aVar = mTbUbcLog) != null) {
            aVar.f();
        }
    }

    @JvmStatic
    public static final void requestCleanOverQuotaLog() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, null) == null) && (aVar = mTbUbcLog) != null) {
            aVar.a();
        }
    }

    @JvmStatic
    public static final void activeUpload(String type, String dataId, List<String> spaces, long j, long j2, long j3, b activeUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{type, dataId, spaces, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), activeUploadListener}) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(dataId, "dataId");
            Intrinsics.checkNotNullParameter(spaces, "spaces");
            Intrinsics.checkNotNullParameter(activeUploadListener, "activeUploadListener");
            a aVar = mTbUbcLog;
            if (aVar != null) {
                aVar.c(type, dataId, spaces, j, j2, j3, activeUploadListener);
            }
        }
    }

    @JvmStatic
    public static final void activeUpload(String type, String dataId, List<String> spaces, b activeUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, type, dataId, spaces, activeUploadListener) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(dataId, "dataId");
            Intrinsics.checkNotNullParameter(spaces, "spaces");
            Intrinsics.checkNotNullParameter(activeUploadListener, "activeUploadListener");
            a aVar = mTbUbcLog;
            if (aVar != null) {
                aVar.e(type, dataId, spaces, activeUploadListener);
            }
        }
    }

    @JvmStatic
    public static final void flush(String space, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, space, z) == null) {
            Intrinsics.checkNotNullParameter(space, "space");
            a aVar = mTbUbcLog;
            if (aVar != null) {
                aVar.d(space, z);
            }
        }
    }

    @JvmStatic
    public static final void initTbUbcLog(a impl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, impl) == null) {
            Intrinsics.checkNotNullParameter(impl, "impl");
            mTbUbcLog = impl;
        }
    }

    @JvmStatic
    public static final void log(String space, Level level, String logId, String tag, String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, space, level, logId, tag, msg) == null) {
            Intrinsics.checkNotNullParameter(space, "space");
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(logId, "logId");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            a aVar = mTbUbcLog;
            if (aVar != null) {
                aVar.b(space, level, logId, tag, msg);
            }
        }
    }

    @JvmStatic
    public static final void logE(String logId, String tag, String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, logId, tag, msg) == null) {
            Intrinsics.checkNotNullParameter(logId, "logId");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            a aVar = mTbUbcLog;
            if (aVar != null) {
                aVar.b("default", Level.ERROR, logId, tag, msg);
            }
        }
    }

    @JvmStatic
    public static final void logI(String logId, String tag, String msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, logId, tag, msg) == null) {
            Intrinsics.checkNotNullParameter(logId, "logId");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            a aVar = mTbUbcLog;
            if (aVar != null) {
                aVar.b("default", Level.INFO, logId, tag, msg);
            }
        }
    }
}
