package com.baidu.tieba;

import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.impersonal.data.SpriteChatDetail;
import com.baidu.tieba.impersonal.dispatcher.PersonalChatDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final String b;
    public final String c;
    public final gd9 d;
    public FastRequest e;
    public final FastRequest.b<SpriteChatDetail> f;

    /* loaded from: classes6.dex */
    public static final class a extends FastRequest.b<SpriteChatDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd9 d;

        public a(jd9 jd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jd9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(SpriteChatDetail result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                SpriteChatDetail.GuideInfo guideInfo = result.getGuideInfo();
                if (guideInfo != null) {
                    jd9 jd9Var = this.d;
                    if (guideInfo.isNeedLoading()) {
                        jd9Var.d.b();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void e(int i, String errMsg, Exception exc, SpriteChatDetail spriteChatDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), errMsg, exc, spriteChatDetail}) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.e(i, errMsg, exc, spriteChatDetail);
            }
        }
    }

    public jd9(TbPageContext<BaseFragmentActivity> pageContext, String from, String query, gd9 repo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, from, query, repo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.a = pageContext;
        this.b = from;
        this.c = query;
        this.d = repo;
        this.f = new a(this);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.e == null) {
                this.e = new FastRequest(this.a, CmdConfigHttp.CMD_GET_SPRITE_CHAT_DETAIL_MESSAGE, TbConfig.REQUEST_SPRITE_CHAT_DETAIL);
            }
            FastRequest fastRequest = this.e;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.P(PersonalChatDispatcher.OPEN_PAGE_FROM, this.b);
            fastRequest.P("query", this.c);
            fastRequest.R(this.f);
            fastRequest.Q();
        }
    }
}
