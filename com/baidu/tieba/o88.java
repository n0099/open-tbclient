package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.bt5;
import com.baidu.tieba.ca8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.PicCreateInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.PicQueryInfoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class o88 extends u88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;
    public FastRequest c;
    public FastRequest d;
    public GroupChatFragment e;
    public final bt5 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947986234, "Lcom/baidu/tieba/o88;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947986234, "Lcom/baidu/tieba/o88;");
        }
    }

    @Override // com.baidu.tieba.u88
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pic_gen_commit" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class b extends FastRequest.b<PicQueryInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o88 b;
        public final /* synthetic */ ca8.e c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ bt5.c<Void> e;

        /* loaded from: classes6.dex */
        public static final class a extends TypeToken<AbilityItem> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
        }

        public b(o88 o88Var, ca8.e eVar, boolean z, bt5.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o88Var, eVar, Boolean.valueOf(z), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o88Var;
            this.c = eVar;
            this.d = z;
            this.e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, String errMsg, PicQueryInfoData picQueryInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, picQueryInfoData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, picQueryInfoData);
                this.b.l(R.string.obfuscated_res_0x7f0f04fc);
                this.c.onFail();
                this.b.i().h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(PicQueryInfoData result) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.e(result);
                Integer status = result.getStatus();
                if (status != null) {
                    i = status.intValue();
                } else {
                    i = 2;
                }
                String str = null;
                if (i != 1) {
                    if (i == 2) {
                        this.b.l(R.string.obfuscated_res_0x7f0f04fc);
                        this.c.onFail();
                        this.b.i().h();
                    } else if (i == 3) {
                        Object abilityItem = result.getAbilityItem();
                        if (abilityItem != null) {
                            str = DataExt.toJson(abilityItem);
                        }
                        Object fromJson = new Gson().fromJson(str, new a().getType());
                        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(str, type)");
                        this.c.a((AbilityItem) fromJson);
                        this.c.onFinish();
                        this.b.i().h();
                    }
                } else if (this.d) {
                    this.b.l(R.string.obfuscated_res_0x7f0f04fd);
                    this.c.onFail();
                    this.b.i().h();
                } else {
                    this.e.call(false, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends FastRequest.b<PicCreateInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca8.e b;
        public final /* synthetic */ o88 c;

        public a(ca8.e eVar, o88 o88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, o88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eVar;
            this.c = o88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, String errMsg, PicCreateInfoData picCreateInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, errMsg, picCreateInfoData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, picCreateInfoData);
                this.c.l(R.string.obfuscated_res_0x7f0f04fc);
                this.b.onFail();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(PicCreateInfoData result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.e(result);
                if (result.getRequestId() != null) {
                    this.c.j(result.getRequestId(), this.b);
                    return;
                }
                this.c.l(R.string.obfuscated_res_0x7f0f04fc);
                this.b.onFail();
            }
        }
    }

    public o88(ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatPage};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(chatPage, "chatPage");
        this.b = chatPage;
        GroupChatFragment E0 = chatPage.E0();
        Intrinsics.checkNotNullExpressionValue(E0, "chatPage.groupChatFragment");
        this.e = E0;
        this.f = new bt5(15, 2000, TimeUnit.MILLISECONDS);
    }

    public final void h(ca8.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (this.c == null) {
                this.c = new FastRequest(this.e.getPageContext(), CmdConfigHttp.CMD_REQUEST_CREATE_MEME, TbConfig.REQUEST_SPRITE_CREATE_MEME);
            }
            GroupInputViewController l2 = this.e.l2();
            String str = (l2 == null || (str = l2.F0()) == null) ? "" : "";
            FastRequest fastRequest = this.c;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.Z(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.V("prompt", str);
            fastRequest.X(new a(eVar, this));
            fastRequest.W();
        }
    }

    @Override // com.baidu.tieba.u88
    public void b(AbilityItem abilityItem, BaseMsg baseMsg, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseMsg, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (obj instanceof ca8.e) {
                h((ca8.e) obj);
            }
        }
    }

    public final void j(final String str, final ca8.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, eVar) == null) {
            this.f.i(new bt5.c() { // from class: com.baidu.tieba.m88
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.bt5.c
                public final void call(boolean z, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                        o88.k(o88.this, str, eVar, z, (bt5.c) obj);
                    }
                }
            });
        }
    }

    public static final void k(o88 this$0, String requestId, ca8.e callback, boolean z, bt5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, requestId, callback, Boolean.valueOf(z), cVar}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(requestId, "$requestId");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            if (this$0.d == null) {
                this$0.d = new FastRequest(this$0.e.getPageContext(), CmdConfigHttp.CMD_REQUEST_QUERY_MEME, TbConfig.REQUEST_SPRITE_QUERY_MEME);
            }
            FastRequest fastRequest = this$0.d;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.Z(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.V(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, requestId);
            fastRequest.X(new b(this$0, callback, z, cVar));
            fastRequest.W();
        }
    }

    public final bt5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (bt5) invokeV.objValue;
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b.n1(i);
        }
    }
}
