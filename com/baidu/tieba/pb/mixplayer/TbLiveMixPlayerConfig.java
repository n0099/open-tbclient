package com.baidu.tieba.pb.mixplayer;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tieba.um9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig;", "Lcom/baidu/tieba/pb/mixplayer/TbMixPlayerConfig;", "alaInfoData", "Lcom/baidu/tbadk/core/data/AlaInfoData;", "(Lcom/baidu/tbadk/core/data/AlaInfoData;)V", "getAlaInfoData", "()Lcom/baidu/tbadk/core/data/AlaInfoData;", "Companion", "LiveStatus", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TbLiveMixPlayerConfig implements um9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlaInfoData a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1815708887, "Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1815708887, "Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig$LiveStatus;", "", "(Ljava/lang/String;I)V", TornadoLiteRuntime.STATE_INIT, "LOADING", "PLAY", "ERROR", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class LiveStatus {
        public static final /* synthetic */ LiveStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LiveStatus ERROR;
        public static final LiveStatus INIT;
        public static final LiveStatus LOADING;
        public static final LiveStatus PLAY;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ LiveStatus[] $values() {
            return new LiveStatus[]{INIT, LOADING, PLAY, ERROR};
        }

        public static LiveStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LiveStatus) Enum.valueOf(LiveStatus.class, str) : (LiveStatus) invokeL.objValue;
        }

        public static LiveStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LiveStatus[]) $VALUES.clone() : (LiveStatus[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-265085155, "Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig$LiveStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-265085155, "Lcom/baidu/tieba/pb/mixplayer/TbLiveMixPlayerConfig$LiveStatus;");
                    return;
                }
            }
            INIT = new LiveStatus(TornadoLiteRuntime.STATE_INIT, 0);
            LOADING = new LiveStatus("LOADING", 1);
            PLAY = new LiveStatus("PLAY", 2);
            ERROR = new LiveStatus("ERROR", 3);
            $VALUES = $values();
        }

        public LiveStatus(String str, int i) {
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

    public TbLiveMixPlayerConfig(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaInfoData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(alaInfoData, "alaInfoData");
        this.a = alaInfoData;
    }

    public final AlaInfoData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (AlaInfoData) invokeV.objValue;
    }
}
