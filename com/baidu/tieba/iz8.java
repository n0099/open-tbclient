package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iz8 extends sk1<dn5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements dn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.iz8$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0363a implements SendMsgParam.SendMsgParamConstruct {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gn5 a;
            public final /* synthetic */ Context b;

            public C0363a(a aVar, gn5 gn5Var, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gn5Var, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gn5Var;
                this.b = context;
            }

            @Override // com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.SendMsgParamConstruct
            public void construct(SendMsgParam sendMsgParam) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, sendMsgParam) == null) && sendMsgParam != null && sendMsgParam.getChatMsg() != null) {
                    this.a.a(sendMsgParam.getChatMsg());
                    BIMManager.sendChatMsg(this.b, sendMsgParam);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements BIMValueCallBack<SendMsgResponse> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gn5 a;

            public b(a aVar, gn5 gn5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gn5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gn5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            /* renamed from: a */
            public void onResult(int i, String str, SendMsgResponse sendMsgResponse) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, sendMsgResponse) == null) && str != null && sendMsgResponse != null && sendMsgResponse.msg != null) {
                    this.a.b(i, str, sendMsgResponse);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a this$1;
            public final /* synthetic */ fn5 val$listener;

            public c(a aVar, fn5 fn5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fn5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = aVar;
                this.val$listener = fn5Var;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && IMConstants.MESSAGE_ACTION.equals(intent.getAction())) {
                    this.val$listener.onReceiveMessage(0, 0, intent.getParcelableArrayListExtra(IMConstants.MESSAGE));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements FetchMsgParam.FetchMsgParamConstruct {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            public d(a aVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = context;
            }

            @Override // com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam.FetchMsgParamConstruct
            public void construct(FetchMsgParam fetchMsgParam) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fetchMsgParam) == null) {
                    BIMManager.fetchMsg(this.a, fetchMsgParam);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e implements BIMValueCallBack<FetchMsgResponse> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ en5 a;

            public e(a aVar, en5 en5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, en5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = en5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            /* renamed from: a */
            public void onResult(int i, String str, FetchMsgResponse fetchMsgResponse) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, fetchMsgResponse) == null) && fetchMsgResponse != null) {
                    this.a.a(i, str, new PersonFetchMsgResponse(fetchMsgResponse));
                }
            }
        }

        public a(iz8 iz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            AlaLiveSdkStatic.l();
        }

        @Override // com.baidu.tieba.dn5
        public BroadcastReceiver a(@NonNull Context context, @NonNull fn5 fn5Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, fn5Var)) == null) {
                IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
                c cVar = new c(this, fn5Var);
                context.registerReceiver(cVar, intentFilter);
                return cVar;
            }
            return (BroadcastReceiver) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.dn5
        public void c(@NonNull Context context, @NonNull BroadcastReceiver broadcastReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, broadcastReceiver) == null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        }

        @Override // com.baidu.tieba.dn5
        public void b(@NonNull Context context, long j, long j2, int i, long j3, en5 en5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), en5Var}) == null) {
                FetchMsgParam.newInstanceByPa(context, j, j2, i, 0, j3, "", new e(this, en5Var), new d(this, context));
            }
        }

        @Override // com.baidu.tieba.dn5
        public void d(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, @NonNull gn5 gn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, chatMsg, Long.valueOf(j), gn5Var}) == null) {
                SendMsgParam.newInstanceByPa(context, chatMsg, j, new b(this, gn5Var), new C0363a(this, gn5Var, context));
            }
        }
    }

    public iz8() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sk1
    /* renamed from: a */
    public dn5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (dn5) invokeV.objValue;
    }
}
