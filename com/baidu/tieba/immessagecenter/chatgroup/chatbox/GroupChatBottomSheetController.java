package com.baidu.tieba.immessagecenter.chatgroup.chatbox;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes6.dex */
public class GroupChatBottomSheetController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void a(int i);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class BaManagerState {
        public static final /* synthetic */ BaManagerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BaManagerState NONE;
        public static final BaManagerState REQUESTING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1695417034, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/GroupChatBottomSheetController$BaManagerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1695417034, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/GroupChatBottomSheetController$BaManagerState;");
                    return;
                }
            }
            REQUESTING = new BaManagerState("REQUESTING", 0);
            BaManagerState baManagerState = new BaManagerState(HlsPlaylistParser.METHOD_NONE, 1);
            NONE = baManagerState;
            $VALUES = new BaManagerState[]{REQUESTING, baManagerState};
        }

        public BaManagerState(String str, int i) {
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

        public static BaManagerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BaManagerState) Enum.valueOf(BaManagerState.class, str);
            }
            return (BaManagerState) invokeL.objValue;
        }

        public static BaManagerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BaManagerState[]) $VALUES.clone();
            }
            return (BaManagerState[]) invokeV.objValue;
        }
    }
}
