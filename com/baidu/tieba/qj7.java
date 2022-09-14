package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.realauth.LiveRealAuthCallback;
import com.baidu.searchbox.live.interfaces.service.LiveRealAuthService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.wallet.ICertification;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class qj7 implements LiveRealAuthService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ICertification.CertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRealAuthCallback a;

        public a(qj7 qj7Var, LiveRealAuthCallback liveRealAuthCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj7Var, liveRealAuthCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveRealAuthCallback;
        }

        @Override // com.baidu.tieba.wallet.ICertification.CertificationCallback
        public void onResult(int i, Map<String, Object> map) {
            LiveRealAuthCallback liveRealAuthCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, map) == null) || (liveRealAuthCallback = this.a) == null) {
                return;
            }
            liveRealAuthCallback.onRealAuthResult(i, map);
        }
    }

    public qj7() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.LiveRealAuthService
    public void doAuth(Map<String, ?> map, LiveRealAuthCallback liveRealAuthCallback) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, map, liveRealAuthCallback) == null) || (runTask = MessageManager.getInstance().runTask(2921433, ICertification.class)) == null || runTask.getData() == null) {
            return;
        }
        ((ICertification) runTask.getData()).certification(TbadkCoreApplication.getInst(), map, new a(this, liveRealAuthCallback));
    }
}
