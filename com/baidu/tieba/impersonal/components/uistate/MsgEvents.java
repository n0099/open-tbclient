package com.baidu.tieba.impersonal.components.uistate;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.an8;
import com.baidu.tieba.bm8;
import com.baidu.tieba.impersonal.data.VoiceMsgContent;
import com.baidu.tieba.tk8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0004J$\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/impersonal/components/uistate/MsgEvents;", "", "()V", "genDefaultMsgLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/baidu/tieba/impersonal/data/PersonalChatMsgData;", "", "genDefaultMsgResendClick", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgEvents {
    public static /* synthetic */ Interceptable $ic;
    public static final MsgEvents a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-505774993, "Lcom/baidu/tieba/impersonal/components/uistate/MsgEvents;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-505774993, "Lcom/baidu/tieba/impersonal/components/uistate/MsgEvents;");
                return;
            }
        }
        a = new MsgEvents();
    }

    /* loaded from: classes6.dex */
    public static final class a implements Function2<View, tk8<?>, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm8 a;

        public a(bm8 bm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm8Var;
        }

        public void a(View view2, tk8<?> data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, data) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(data, "data");
                view2.setVisibility(8);
                this.a.q(data);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view2, tk8<?> tk8Var) {
            a(view2, tk8Var);
            return Unit.INSTANCE;
        }
    }

    public MsgEvents() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final Function2<View, tk8<?>, Unit> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new Function2<View, tk8<?>, Unit>() { // from class: com.baidu.tieba.impersonal.components.uistate.MsgEvents$genDefaultMsgLongClick$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                public void a(View view2, tk8<?> data) {
                    VoiceMsgContent voiceMsgContent;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, data) == null) {
                        Intrinsics.checkNotNullParameter(view2, "view");
                        Intrinsics.checkNotNullParameter(data, "data");
                        Object f = data.f();
                        final TbPageContextSupport tbPageContextSupport = null;
                        if (f instanceof VoiceMsgContent) {
                            voiceMsgContent = (VoiceMsgContent) f;
                        } else {
                            voiceMsgContent = null;
                        }
                        if (voiceMsgContent != null) {
                            Context context = view2.getContext();
                            if (context instanceof TbPageContextSupport) {
                                tbPageContextSupport = (TbPageContextSupport) context;
                            }
                            if (tbPageContextSupport != null) {
                                an8 an8Var = an8.a;
                                TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                                Intrinsics.checkNotNullExpressionValue(pageContext, "context.pageContext");
                                an8Var.a(pageContext, new Function1<Integer, Unit>(tbPageContextSupport) { // from class: com.baidu.tieba.impersonal.components.uistate.MsgEvents$genDefaultMsgLongClick$1$invoke$1$1
                                    public static /* synthetic */ Interceptable $ic;
                                    public final /* synthetic */ TbPageContextSupport $context;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {tbPageContextSupport};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.$context = tbPageContextSupport;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i) {
                                        VoiceManager y0;
                                        VoiceManager y02;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                                            VoiceManager.j jVar = null;
                                            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                                                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                                                TbPageContextSupport tbPageContextSupport2 = this.$context;
                                                if (tbPageContextSupport2 instanceof VoiceManager.j) {
                                                    jVar = (VoiceManager.j) tbPageContextSupport2;
                                                }
                                                if (jVar != null && (y02 = jVar.y0()) != null) {
                                                    y02.setSpeakerphoneOn(true);
                                                    return;
                                                }
                                                return;
                                            }
                                            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
                                            TbPageContextSupport tbPageContextSupport3 = this.$context;
                                            if (tbPageContextSupport3 instanceof VoiceManager.j) {
                                                jVar = (VoiceManager.j) tbPageContextSupport3;
                                            }
                                            if (jVar != null && (y0 = jVar.y0()) != null) {
                                                y0.setSpeakerphoneOn(false);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view2, tk8<?> tk8Var) {
                    a(view2, tk8Var);
                    return Unit.INSTANCE;
                }
            };
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, tk8<?>, Unit> b(bm8 repo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, repo)) == null) {
            Intrinsics.checkNotNullParameter(repo, "repo");
            return new a(repo);
        }
        return (Function2) invokeL.objValue;
    }
}
