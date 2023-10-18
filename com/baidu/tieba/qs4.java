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
public final class qs4 extends ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final os4 a;
    public boolean b;

    public qs4(os4 mConfig) {
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

    @Override // com.baidu.tieba.ed5
    public void c(final gd5 editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            if (!(editor instanceof ps4)) {
                return;
            }
            final EditorTools a = editor.a();
            dd5 dd5Var = new dd5() { // from class: com.baidu.tieba.ls4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.dd5
                public final void O(cd5 cd5Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cd5Var) == null) {
                        qs4.e(gd5.this, this, a, cd5Var);
                    }
                }
            };
            a.setActionListener(4, dd5Var);
            a.setActionListener(7, dd5Var);
            a.setActionListener(16, dd5Var);
            a.setActionListener(8, dd5Var);
        }
    }

    public static final void e(gd5 editor, qs4 this$0, EditorTools editorTools, cd5 cd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, editor, this$0, editorTools, cd5Var) == null) {
            Intrinsics.checkNotNullParameter(editor, "$editor");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ps4 ps4Var = (ps4) editor;
            if (ps4Var.a() == null || cd5Var == null) {
                return;
            }
            int i = cd5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8 || !this$0.f(ps4Var.e(), 12015)) {
                            return;
                        }
                        ps4Var.m();
                        return;
                    }
                    ps4Var.e().showToast((int) R.string.over_limit_tip);
                    this$0.b = true;
                    return;
                }
                if (this$0.b) {
                    ps4Var.e().showToast((int) R.string.over_limit_tip);
                }
                if (!this$0.f(ps4Var.e(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(ps4Var.e().getPageActivity(), 12005, true);
                editorTools.setPadding(0, 0, 0, 0);
                if (ps4Var.g() != null) {
                    SpanGroupManager g = ps4Var.g();
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
            Object obj = cd5Var.c;
            if (obj instanceof mf5) {
                if (obj != null) {
                    String str = ((mf5) obj).a;
                    Intrinsics.checkNotNullExpressionValue(str, "action.data as SubPbInputContentData).mContent");
                    ps4Var.r(str);
                    Object obj2 = cd5Var.c;
                    if (obj2 != null) {
                        ps4Var.s(((mf5) obj2).c);
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

    @Override // com.baidu.tieba.ed5
    public gd5 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            gd5 a = super.a(context);
            Intrinsics.checkNotNullExpressionValue(a, "super.build(context)");
            return a;
        }
        return (gd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed5
    public gd5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(10);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.transparent);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.setIsShowAllBg(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setHideBigEmotion(true);
            editorTools.setClearEbPadding(true);
            return new ps4(editorTools);
        }
        return (gd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed5
    public void d(gd5 editor) {
        od5 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            EditorTools a = editor.a();
            if (this.a.f) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                a.h(arrayList);
                if (!this.a.g && (p = a.p(5)) != null) {
                    p.f(false);
                    p.g(false);
                    p.l = 2;
                }
            }
            if (this.a.h) {
                qd5 qd5Var = new qd5(a.getContext(), 7);
                qd5Var.i = false;
                a.d(qd5Var);
            }
            rs4 rs4Var = new rs4(a.getContext());
            rs4Var.h(this.a);
            a.d(rs4Var);
            a.f();
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
