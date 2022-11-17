package com.baidu.webkit.internal.resource;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes7.dex */
public interface IResourceTask extends INoProGuard {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class OutputType {
        public static final /* synthetic */ OutputType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OutputType FILE;
        public static final OutputType STRING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1103516054, "Lcom/baidu/webkit/internal/resource/IResourceTask$OutputType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1103516054, "Lcom/baidu/webkit/internal/resource/IResourceTask$OutputType;");
                    return;
                }
            }
            FILE = new OutputType("FILE", 0);
            OutputType outputType = new OutputType("STRING", 1);
            STRING = outputType;
            $VALUES = new OutputType[]{FILE, outputType};
        }

        public OutputType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OutputType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OutputType) Enum.valueOf(OutputType.class, str) : (OutputType) invokeL.objValue;
        }

        public static OutputType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OutputType[]) $VALUES.clone() : (OutputType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ResultType {
        public static final /* synthetic */ ResultType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ResultType RESULT_CACHE;
        public static final ResultType RESULT_FAILED;
        public static final ResultType RESULT_OK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-816181042, "Lcom/baidu/webkit/internal/resource/IResourceTask$ResultType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-816181042, "Lcom/baidu/webkit/internal/resource/IResourceTask$ResultType;");
                    return;
                }
            }
            RESULT_OK = new ResultType("RESULT_OK", 0);
            RESULT_CACHE = new ResultType("RESULT_CACHE", 1);
            ResultType resultType = new ResultType("RESULT_FAILED", 2);
            RESULT_FAILED = resultType;
            $VALUES = new ResultType[]{RESULT_OK, RESULT_CACHE, resultType};
        }

        public ResultType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ResultType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ResultType) Enum.valueOf(ResultType.class, str) : (ResultType) invokeL.objValue;
        }

        public static ResultType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ResultType[]) $VALUES.clone() : (ResultType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface TaskPriority extends INoProGuard {
        public static final int HIGH = 1;
        public static final int IDLE = 4;
        public static final int LOW = 3;
        public static final int MEDIUM = 2;
        public static final int URGANT = 0;
    }

    String getCacheFileName();

    OutputType getOutputType();

    String getPMSPackageName();

    int getPriority();

    String getTaskName();

    String getTaskUrl();

    void onResourceReady(String str, ResultType resultType);

    boolean shouldBeUnZip();

    boolean shouldForceLoadFromFile();
}
