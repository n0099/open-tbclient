package com.baidu.tieba;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.forum.model.FrsPageHttpResponseMessage;
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.tieba.forum.model.FrsThreadListHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class sl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public BdUniqueId b;
    public final NetMessageListener c;

    /* loaded from: classes8.dex */
    public interface a {
        void a(vi7 vi7Var);

        void onError(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948155339, "Lcom/baidu/tieba/sl7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948155339, "Lcom/baidu/tieba/sl7;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends nu5<List<? extends GroupChatRoomPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'java.util.List<com.baidu.tieba.im.db.pojo.GroupChatRoomPojo>' to match base method */
        @Override // com.baidu.tieba.nu5
        public List<? extends GroupChatRoomPojo> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return bu8.j().i(TbadkCoreApplication.getCurrentAccount(), this.a);
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sl7 sl7Var) {
            super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                a a2 = this.a.a();
                if (a2 != null) {
                    a2.onError(responsedMessage.getError());
                }
            } else if ((responsedMessage instanceof FrsPageHttpResponseMessage) && (a = this.a.a()) != null) {
                a.a(((FrsPageHttpResponseMessage) responsedMessage).getFrsPageData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements sm8<vi7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl7 a;

        public d(sl7 sl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl7Var;
        }

        @Override // com.baidu.tieba.sm8
        public void a(um8<vi7> request, Throwable t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, request, t) == null) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(t, "t");
                a a = this.a.a();
                if (a != null) {
                    a.onError(-1);
                }
            }
        }

        @Override // com.baidu.tieba.sm8
        public void b(um8<vi7> request, wm8<vi7> response) {
            a a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, response) == null) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(response, "response");
                vi7 a2 = response.a();
                if (a2 != null && (a = this.a.a()) != null) {
                    a.a(a2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends xm8<vi7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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
        @Override // com.baidu.tieba.xm8
        /* renamed from: b */
        public vi7 a(byte[] bArr, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, str)) == null) {
                try {
                    return new kj7().b(bArr);
                } catch (Exception unused) {
                    DefaultLog.getInstance().e("FrsPageResParser", "新FRS数据解析失败");
                    return new vi7();
                }
            }
            return (vi7) invokeLL.objValue;
        }
    }

    public sl7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = ci7.a(activity);
        this.c = new c(this);
        f();
        g();
        this.c.setTag(this.b);
        this.c.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.c);
    }

    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            final FrsPageRequestMessage a2 = zl7.a(bundle);
            a2.setTag(this.b);
            a2.setSortType(-1);
            a2.setDefaultSortType(0);
            a2.setPn(1);
            a2.setRn(90);
            a2.setRnNeed(30);
            String g = c37.g(null, true);
            Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(null, true)");
            a2.setAdFloorInfo(g);
            final String string = bundle.getString("name");
            if (string == null) {
                string = "";
            }
            ru5.c(new b(string), new st5() { // from class: com.baidu.tieba.ql7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.st5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        sl7.c(sl7.this, a2, string, (List) obj);
                    }
                }
            });
        }
    }

    public static final void c(sl7 this$0, FrsPageRequestMessage requestMessage, String forumName, List list) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, this$0, requestMessage, forumName, list) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(requestMessage, "$requestMessage");
            Intrinsics.checkNotNullParameter(forumName, "$forumName");
            if (list != null && (a2 = z49.a(list)) != null) {
                requestMessage.setChatroomNewMsg(a2);
            }
            if (UbsABTestHelper.isExistSid("new_frs_new_network_12_51")) {
                this$0.d(requestMessage);
            } else {
                MessageManager.getInstance().sendMessage(requestMessage);
            }
            jk7.a();
            jk7.b(forumName);
        }
    }

    public final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (a) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }

    public final void d(FrsPageRequestMessage frsPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsPageRequestMessage) == null) {
            rm8 rm8Var = new rm8();
            String SERVER_ADDRESS = TbConfig.SERVER_ADDRESS;
            Intrinsics.checkNotNullExpressionValue(SERVER_ADDRESS, "SERVER_ADDRESS");
            rm8Var.x(SERVER_ADDRESS);
            rm8Var.y(false);
            rm8Var.z(UbsABTestHelper.isAddBaidIdCookie());
            rm8Var.A(4);
            rm8Var.D("c/f/frs/page?cmd=301001&format=protobuf");
            rm8Var.a("forum_name", frsPageRequestMessage.getKw());
            rm8Var.a("client_type", "2");
            HashMap<String, Object> params = frsPageRequestMessage.getHttpMessage().getParams();
            Intrinsics.checkNotNullExpressionValue(params, "requestMessage.httpMessage.params");
            rm8Var.b(params);
            rm8Var.C(1);
            rm8Var.B(2);
            rm8Var.w(new e());
            rm8Var.c().a(new d(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, wva.a(TbConfig.FRS_ADDRESS, 301001));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsNeedCookie(UbsABTestHelper.isAddBaidIdCookie());
            tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, wva.a(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsThreadListHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.a = aVar;
        }
    }
}
