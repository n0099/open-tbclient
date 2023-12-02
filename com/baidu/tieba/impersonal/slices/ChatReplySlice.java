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
import com.baidu.tieba.fd9;
import com.baidu.tieba.ie9;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.data.QuickReplyData;
import com.baidu.tieba.impersonal.databinding.SlicePersonalReplyBinding;
import com.baidu.tieba.impersonal.reply.ChatReplyAdapter;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.lk5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb9;
import com.baidu.tieba.rd;
import com.baidu.tieba.ub9;
import com.baidu.tieba.vb9;
import com.baidu.tieba.yb9;
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
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\f\u0018\u0000 -2\u00020\u0001:\u0001-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J$\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatReplySlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "behaviorExt", "Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;Lcom/baidu/tieba/impersonal/data/BehaviorExt;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalReplyBinding;", "clickTime", "", "fetchNewCallback", "com/baidu/tieba/impersonal/slices/ChatReplySlice$fetchNewCallback$1", "Lcom/baidu/tieba/impersonal/slices/ChatReplySlice$fetchNewCallback$1;", "isSpriteReply", "", "mChatReplyAdapter", "Lcom/baidu/tieba/impersonal/reply/ChatReplyAdapter;", "mOnItemClickListener", "Lcom/baidu/adp/widget/ListView/BdRecyclerView$OnItemClickListener;", "request", "Lcom/baidu/tbadk/net/FastRequest;", "requestCallback", "Lcom/baidu/tbadk/net/FastRequest$Callback;", "Lcom/baidu/tieba/impersonal/data/QuickReplyData;", "isFastClick", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "registerMsgListener", "requestQuestionData", "sendMessage", "text", "", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatReplySlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fd9 j;
    public final BehaviorExt k;
    public SlicePersonalReplyBinding l;
    public long m;
    public ChatReplyAdapter n;
    public FastRequest o;
    public boolean p;
    public final a q;
    public final FastRequest.b<QuickReplyData> r;
    public final BdRecyclerView.i<?> s;

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
    public static final class a extends fd9.a {
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

        @Override // com.baidu.tieba.fd9.b
        public void a(List<? extends pb9> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "list");
                for (pb9 pb9Var : list) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("sendSpriteMsg", "新消息返回：" + pb9Var.b());
                    if (rd.isEquals(pb9Var.b(), lk5.d())) {
                        DefaultLog.getInstance().i("sendSpriteMsg", "命中匹配，是通过sendSpriteMsg发送的");
                        return;
                    }
                }
                this.a.p = true;
                this.a.m0();
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && !this.a.k0()) {
                ChatReplyAdapter chatReplyAdapter = this.a.n;
                if (chatReplyAdapter != null) {
                    questionData = chatReplyAdapter.l(i);
                } else {
                    questionData = null;
                }
                if (questionData != null && (question = questionData.getQuestion()) != null) {
                    ChatReplySlice chatReplySlice = this.a;
                    if (StringUtils.isNull(questionData.getQuestion())) {
                        return;
                    }
                    chatReplySlice.n0(question);
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (currentAccount == null) {
                        currentAccount = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(currentAccount, "TbadkApplication.getCurrentAccount() ?: \"\"");
                    ie9.a("c15230", currentAccount, questionData.getQuestion());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends FastRequest.b<QuickReplyData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatReplySlice d;

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
            this.d = chatReplySlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, QuickReplyData quickReplyData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, quickReplyData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, quickReplyData);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(QuickReplyData result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                if (!ListUtils.isEmpty(result.getQuestionList())) {
                    ChatReplyAdapter chatReplyAdapter = this.d.n;
                    if (chatReplyAdapter != null) {
                        chatReplyAdapter.setData(result.getQuestionList());
                    }
                    if (this.d.p) {
                        SlicePersonalReplyBinding slicePersonalReplyBinding = this.d.l;
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

    public ChatReplySlice(fd9 repo, BehaviorExt behaviorExt) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo, behaviorExt};
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
        Intrinsics.checkNotNullParameter(behaviorExt, "behaviorExt");
        this.j = repo;
        this.k = behaviorExt;
        this.q = new a(this);
        this.r = new c(this);
        this.s = new b(this);
    }

    public final void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ub9<vb9> a2 = yb9.a(str);
            Intrinsics.checkNotNullExpressionValue(a2, "genTextMsg(text)");
            this.j.u(a2);
            ie9.b(TbadkCoreApplication.getCurrentAccount(), "3", this.k);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            ChatReplyAdapter chatReplyAdapter = this.n;
            if (chatReplyAdapter != null) {
                chatReplyAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalReplyBinding it = SlicePersonalReplyBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.l = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(View view2, Bundle bundle) {
        ChatReplyAdapter chatReplyAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            Context context = K().getContext();
            SlicePersonalReplyBinding slicePersonalReplyBinding = null;
            if (context != null) {
                chatReplyAdapter = new ChatReplyAdapter(context);
            } else {
                chatReplyAdapter = null;
            }
            this.n = chatReplyAdapter;
            SlicePersonalReplyBinding slicePersonalReplyBinding2 = this.l;
            if (slicePersonalReplyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding2 = null;
            }
            slicePersonalReplyBinding2.c.setHorizontalFadingEdgeEnabled(true);
            SlicePersonalReplyBinding slicePersonalReplyBinding3 = this.l;
            if (slicePersonalReplyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding3 = null;
            }
            slicePersonalReplyBinding3.c.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds60));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(K().getContext(), 0, false);
            SlicePersonalReplyBinding slicePersonalReplyBinding4 = this.l;
            if (slicePersonalReplyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding4 = null;
            }
            slicePersonalReplyBinding4.c.setLayoutManager(linearLayoutManager);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X008);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            SlicePersonalReplyBinding slicePersonalReplyBinding5 = this.l;
            if (slicePersonalReplyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding5 = null;
            }
            slicePersonalReplyBinding5.c.addItemDecoration(new SpaceItemDecoration(0, dimenPixelSize2, dimenPixelSize));
            SlicePersonalReplyBinding slicePersonalReplyBinding6 = this.l;
            if (slicePersonalReplyBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalReplyBinding6 = null;
            }
            slicePersonalReplyBinding6.c.setAdapter(this.n);
            SlicePersonalReplyBinding slicePersonalReplyBinding7 = this.l;
            if (slicePersonalReplyBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                slicePersonalReplyBinding = slicePersonalReplyBinding7;
            }
            slicePersonalReplyBinding.c.setOnItemClickListener(this.s);
            l0();
            m0();
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (System.currentTimeMillis() - this.m < 800) {
                return true;
            }
            this.m = System.currentTimeMillis();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.a(this.q);
        }
    }

    public final void m0() {
        String talkPrologue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.o == null) {
                this.o = new FastRequest(K().getPageContext(), CmdConfigHttp.CMD_REQUEST_SPRITE_QUESTION_REPLY, TbConfig.REQUEST_SPRITE_QUESTION_REPLY);
            }
            FastRequest fastRequest = this.o;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.P("rn", 5);
            fastRequest.P("uk", BIMManager.getBdUKFromBdUid(String.valueOf(SpriteMsgProcessor.n.a())));
            fastRequest.R(this.r);
            if (this.k.getForumId() != null && StringUtils.isNotNull(this.k.getForumId())) {
                FastRequest fastRequest2 = this.o;
                Intrinsics.checkNotNull(fastRequest2);
                fastRequest2.P("forum_id", this.k.getForumId());
            }
            if (!this.p && !TextUtils.isEmpty(this.k.getTalkPrologue()) && ((TextUtils.equals(this.k.getTalkType(), "2") || TextUtils.equals(this.k.getTalkType(), "1")) && (talkPrologue = this.k.getTalkPrologue()) != null)) {
                FastRequest fastRequest3 = this.o;
                Intrinsics.checkNotNull(fastRequest3);
                fastRequest3.P("query", talkPrologue);
            }
            FastRequest fastRequest4 = this.o;
            Intrinsics.checkNotNull(fastRequest4);
            fastRequest4.Q();
        }
    }
}
