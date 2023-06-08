package com.baidu.tieba.impersonal.slices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.ak8;
import com.baidu.tieba.bm8;
import com.baidu.tieba.fn5;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.impersonal.data.QuickReplyData;
import com.baidu.tieba.impersonal.databinding.SlicePersonalReplyBinding;
import com.baidu.tieba.impersonal.reply.ChatReplyAdapter;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.ok8;
import com.baidu.tieba.tk8;
import com.baidu.tieba.ui;
import com.baidu.tieba.uk8;
import com.baidu.tieba.xk8;
import com.baidu.tieba.zq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\r\u0018\u0000 -2\u00020\u0001:\u0001-B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J$\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatReplySlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "talkType", "", "talkPrologue", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalReplyBinding;", "clickTime", "", "fetchNewCallback", "com/baidu/tieba/impersonal/slices/ChatReplySlice$fetchNewCallback$1", "Lcom/baidu/tieba/impersonal/slices/ChatReplySlice$fetchNewCallback$1;", "isSpriteReply", "", "mChatReplyAdapter", "Lcom/baidu/tieba/impersonal/reply/ChatReplyAdapter;", "mOnItemClickListener", "Lcom/baidu/adp/widget/ListView/BdRecyclerView$OnItemClickListener;", "request", "Lcom/baidu/tbadk/net/FastRequest;", "requestCallback", "Lcom/baidu/tbadk/net/FastRequest$Callback;", "Lcom/baidu/tieba/impersonal/data/QuickReplyData;", "isFastClick", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "registerMsgListener", "requestQuestionData", "sendMessage", "text", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatReplySlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bm8 j;
    public final String k;
    public final String l;
    public SlicePersonalReplyBinding m;
    public long n;
    public ChatReplyAdapter o;
    public FastRequest p;
    public boolean q;
    public final a r;
    public final FastRequest.b<QuickReplyData> s;
    public final BdRecyclerView.i<?> t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1723223062, "Lcom/baidu/tieba/impersonal/slices/ChatReplySlice;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1723223062, "Lcom/baidu/tieba/impersonal/slices/ChatReplySlice;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends bm8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatReplySlice a;

        public a(ChatReplySlice chatReplySlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatReplySlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatReplySlice;
        }

        @Override // com.baidu.tieba.bm8.b
        public void a(List<? extends ok8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
                for (ok8 ok8Var : list) {
                    zq8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c("sendSpriteMsg", "新消息返回：" + ok8Var.b());
                    if (ui.isEquals(ok8Var.b(), fn5.c())) {
                        DefaultLog.getInstance().c("sendSpriteMsg", "命中匹配，是通过sendSpriteMsg发送的");
                        return;
                    }
                }
                this.a.q = true;
                this.a.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements BdRecyclerView.i<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatReplySlice a;

        public b(ChatReplySlice chatReplySlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatReplySlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatReplySlice;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            QuickReplyData.QuestionData questionData;
            String question;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && !this.a.d0()) {
                ChatReplyAdapter chatReplyAdapter = this.a.o;
                if (chatReplyAdapter != null) {
                    questionData = chatReplyAdapter.k(i);
                } else {
                    questionData = null;
                }
                if (questionData != null && (question = questionData.getQuestion()) != null) {
                    ChatReplySlice chatReplySlice = this.a;
                    if (StringUtils.isNull(questionData.getQuestion())) {
                        return;
                    }
                    chatReplySlice.g0(question);
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    Intrinsics.checkNotNullExpressionValue(currentAccount, "getCurrentAccount()");
                    ak8.a("c15230", currentAccount, questionData.getQuestion());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends FastRequest.b<QuickReplyData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatReplySlice b;

        public c(ChatReplySlice chatReplySlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatReplySlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatReplySlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, String errMsg, QuickReplyData quickReplyData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, quickReplyData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, quickReplyData);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(QuickReplyData result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.e(result);
                if (!ListUtils.isEmpty(result.getQuestionList())) {
                    ChatReplyAdapter chatReplyAdapter = this.b.o;
                    if (chatReplyAdapter != null) {
                        chatReplyAdapter.setData(result.getQuestionList());
                    }
                    if (this.b.q) {
                        SlicePersonalReplyBinding slicePersonalReplyBinding = this.b.m;
                        if (slicePersonalReplyBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            slicePersonalReplyBinding = null;
                        }
                        slicePersonalReplyBinding.c.smoothScrollToPosition(0);
                    }
                }
            }
        }
    }

    public ChatReplySlice(bm8 repo, String talkType, String talkPrologue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo, talkType, talkPrologue};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(talkType, "talkType");
        Intrinsics.checkNotNullParameter(talkPrologue, "talkPrologue");
        this.j = repo;
        this.k = talkType;
        this.l = talkPrologue;
        this.r = new a(this);
        this.s = new c(this);
        this.t = new b(this);
    }

    public final void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            tk8<uk8> a2 = xk8.a(str);
            Intrinsics.checkNotNullExpressionValue(a2, "genTextMsg(text)");
            this.j.t(a2);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            ChatReplyAdapter chatReplyAdapter = this.o;
            if (chatReplyAdapter != null) {
                chatReplyAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View M(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalReplyBinding it = SlicePersonalReplyBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.m = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void T(View view2, Bundle bundle) {
        ChatReplyAdapter chatReplyAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.T(view2, bundle);
            Context context = D().getContext();
            SlicePersonalReplyBinding slicePersonalReplyBinding = null;
            if (context != null) {
                chatReplyAdapter = new ChatReplyAdapter(context);
            } else {
                chatReplyAdapter = null;
            }
            this.o = chatReplyAdapter;
            SlicePersonalReplyBinding slicePersonalReplyBinding2 = this.m;
            if (slicePersonalReplyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding2 = null;
            }
            slicePersonalReplyBinding2.c.setHorizontalFadingEdgeEnabled(true);
            SlicePersonalReplyBinding slicePersonalReplyBinding3 = this.m;
            if (slicePersonalReplyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding3 = null;
            }
            slicePersonalReplyBinding3.c.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds60));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(D().getContext(), 0, false);
            SlicePersonalReplyBinding slicePersonalReplyBinding4 = this.m;
            if (slicePersonalReplyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding4 = null;
            }
            slicePersonalReplyBinding4.c.setLayoutManager(linearLayoutManager);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X008);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            SlicePersonalReplyBinding slicePersonalReplyBinding5 = this.m;
            if (slicePersonalReplyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding5 = null;
            }
            slicePersonalReplyBinding5.c.addItemDecoration(new SpaceItemDecoration(0, dimenPixelSize2, dimenPixelSize));
            SlicePersonalReplyBinding slicePersonalReplyBinding6 = this.m;
            if (slicePersonalReplyBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding6 = null;
            }
            slicePersonalReplyBinding6.c.setAdapter(this.o);
            SlicePersonalReplyBinding slicePersonalReplyBinding7 = this.m;
            if (slicePersonalReplyBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                slicePersonalReplyBinding = slicePersonalReplyBinding7;
            }
            slicePersonalReplyBinding.c.setOnItemClickListener(this.t);
            e0();
            f0();
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (System.currentTimeMillis() - this.n < 800) {
                return true;
            }
            this.n = System.currentTimeMillis();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.a(this.r);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.p == null) {
                this.p = new FastRequest(D().getPageContext(), CmdConfigHttp.CMD_REQUEST_SPRITE_QUESTION_REPLY, TbConfig.REQUEST_SPRITE_QUESTION_REPLY);
            }
            FastRequest fastRequest = this.p;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.Z(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.V("rn", 5);
            fastRequest.V("uk", BIMManager.getBdUKFromBdUid(String.valueOf(SpriteMsgProcessor.m.a())));
            fastRequest.X(this.s);
            if (!this.q && !TextUtils.isEmpty(this.l) && (TextUtils.equals(this.k, "2") || TextUtils.equals(this.k, "1"))) {
                FastRequest fastRequest2 = this.p;
                Intrinsics.checkNotNull(fastRequest2);
                fastRequest2.V("query", this.l);
            }
            FastRequest fastRequest3 = this.p;
            Intrinsics.checkNotNull(fastRequest3);
            fastRequest3.W();
        }
    }
}
