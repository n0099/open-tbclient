package com.baidu.tieba.medialive.player.strategy;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public interface IVideoUpdateStrategy {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class VolumeIconState {
        public static final /* synthetic */ VolumeIconState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VolumeIconState ALWAYS_SHOW;
        public static final VolumeIconState FORCE_CLOSE;
        public static final VolumeIconState NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1637173128, "Lcom/baidu/tieba/medialive/player/strategy/IVideoUpdateStrategy$VolumeIconState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1637173128, "Lcom/baidu/tieba/medialive/player/strategy/IVideoUpdateStrategy$VolumeIconState;");
                    return;
                }
            }
            FORCE_CLOSE = new VolumeIconState("FORCE_CLOSE", 0);
            ALWAYS_SHOW = new VolumeIconState("ALWAYS_SHOW", 1);
            VolumeIconState volumeIconState = new VolumeIconState("NORMAL", 2);
            NORMAL = volumeIconState;
            $VALUES = new VolumeIconState[]{FORCE_CLOSE, ALWAYS_SHOW, volumeIconState};
        }

        public VolumeIconState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static VolumeIconState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VolumeIconState) Enum.valueOf(VolumeIconState.class, str) : (VolumeIconState) invokeL.objValue;
        }

        public static VolumeIconState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VolumeIconState[]) $VALUES.clone() : (VolumeIconState[]) invokeV.objValue;
        }
    }

    boolean a();
}
