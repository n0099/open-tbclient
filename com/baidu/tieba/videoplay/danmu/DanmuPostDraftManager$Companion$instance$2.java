package com.baidu.tieba.videoplay.danmu;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/videoplay/danmu/DanmuPostDraftManager;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class DanmuPostDraftManager$Companion$instance$2 extends Lambda implements Function0<DanmuPostDraftManager> {
    public static /* synthetic */ Interceptable $ic;
    public static final DanmuPostDraftManager$Companion$instance$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1626027933, "Lcom/baidu/tieba/videoplay/danmu/DanmuPostDraftManager$Companion$instance$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1626027933, "Lcom/baidu/tieba/videoplay/danmu/DanmuPostDraftManager$Companion$instance$2;");
                return;
            }
        }
        INSTANCE = new DanmuPostDraftManager$Companion$instance$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmuPostDraftManager$Companion$instance$2() {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DanmuPostDraftManager invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new DanmuPostDraftManager(null) : (DanmuPostDraftManager) invokeV.objValue;
    }
}
