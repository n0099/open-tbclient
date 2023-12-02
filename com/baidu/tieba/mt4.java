package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mt4 extends je5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kt4 a;
    public boolean b;

    public mt4(kt4 mConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mConfig, "mConfig");
        this.a = mConfig;
    }

    @Override // com.baidu.tieba.je5
    public void c(final le5 editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            if (!(editor instanceof lt4)) {
                return;
            }
            final EditorTools a = editor.a();
            ie5 ie5Var = new ie5() { // from class: com.baidu.tieba.ht4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ie5
                public final void U(he5 he5Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, he5Var) == null) {
                        mt4.e(le5.this, this, a, he5Var);
                    }
                }
            };
            a.setActionListener(4, ie5Var);
            a.setActionListener(7, ie5Var);
            a.setActionListener(16, ie5Var);
            a.setActionListener(8, ie5Var);
        }
    }

    public static final void e(le5 editor, mt4 this$0, EditorTools editorTools, he5 he5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, editor, this$0, editorTools, he5Var) == null) {
            Intrinsics.checkNotNullParameter(editor, "$editor");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            lt4 lt4Var = (lt4) editor;
            if (lt4Var.a() == null || he5Var == null) {
                return;
            }
            int i = he5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8 || !this$0.f(lt4Var.e(), 12015)) {
                            return;
                        }
                        lt4Var.m();
                        return;
                    }
                    lt4Var.e().showToast((int) R.string.over_limit_tip);
                    this$0.b = true;
                    return;
                }
                if (this$0.b) {
                    lt4Var.e().showToast((int) R.string.over_limit_tip);
                }
                if (!this$0.f(lt4Var.e(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(lt4Var.e().getPageActivity(), 12005, true);
                editorTools.setPadding(0, 0, 0, 0);
                if (lt4Var.g() != null) {
                    SpanGroupManager g = lt4Var.g();
                    Intrinsics.checkNotNull(g);
                    atListActivityConfig.setSelectedAtList(g.x());
                }
                atListActivityConfig.setFromTid(editorTools.getTid());
                atListActivityConfig.setFromFid(String.valueOf(editorTools.getFid()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("tid", editorTools.getTid());
                statisticItem.addParam("fid", editorTools.getFid());
                TiebaStatic.log(statisticItem);
                return;
            }
            Object obj = he5Var.c;
            if (obj instanceof jh5) {
                if (obj != null) {
                    String str = ((jh5) obj).a;
                    Intrinsics.checkNotNullExpressionValue(str, "action.data as SubPbInputContentData).mContent");
                    lt4Var.r(str);
                    Object obj2 = he5Var.c;
                    if (obj2 != null) {
                        lt4Var.s(((jh5) obj2).c);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.pb.SubPbInputContentData");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.pb.SubPbInputContentData");
                }
            }
            this$0.b = false;
        }
    }

    @Override // com.baidu.tieba.je5
    public le5 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            le5 a = super.a(context);
            Intrinsics.checkNotNullExpressionValue(a, "super.build(context)");
            return a;
        }
        return (le5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.je5
    public le5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(10);
            editorTools.M(true);
            editorTools.N(false);
            editorTools.setBackgroundColorId(R.color.transparent);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.setIsShowAllBg(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setHideBigEmotion(true);
            editorTools.setClearEbPadding(true);
            return new lt4(editorTools);
        }
        return (le5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.je5
    public void d(le5 editor) {
        ue5 u;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            EditorTools a = editor.a();
            if (this.a.f) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                a.k(arrayList);
                if (!this.a.g && (u = a.u(5)) != null) {
                    u.f(false);
                    u.g(false);
                    u.l = 2;
                }
            }
            if (this.a.h) {
                we5 we5Var = new we5(a.getContext(), 7);
                we5Var.i = false;
                a.f(we5Var);
            }
            nt4 nt4Var = new nt4(a.getContext());
            nt4Var.i(this.a);
            a.f(nt4Var);
            a.h();
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, tbPageContext, i)) == null) {
            if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNull(tbPageContext);
            inst.login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
