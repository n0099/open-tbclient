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
/* loaded from: classes6.dex */
public final class iy4 extends ui5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gy4 a;
    public boolean b;

    public iy4(gy4 mConfig) {
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

    @Override // com.baidu.tieba.ui5
    public void c(final wi5 editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            if (!(editor instanceof hy4)) {
                return;
            }
            final EditorTools a = editor.a();
            ti5 ti5Var = new ti5() { // from class: com.baidu.tieba.dy4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ti5
                public final void G(si5 si5Var) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, si5Var) == null) {
                        iy4.e(wi5.this, this, a, si5Var);
                    }
                }
            };
            a.setActionListener(4, ti5Var);
            a.setActionListener(7, ti5Var);
            a.setActionListener(16, ti5Var);
            a.setActionListener(8, ti5Var);
        }
    }

    public static final void e(wi5 editor, iy4 this$0, EditorTools editorTools, si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, editor, this$0, editorTools, si5Var) == null) {
            Intrinsics.checkNotNullParameter(editor, "$editor");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            hy4 hy4Var = (hy4) editor;
            if (hy4Var.a() == null || si5Var == null) {
                return;
            }
            int i = si5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8 || !this$0.f(hy4Var.getContext(), 12015)) {
                            return;
                        }
                        hy4Var.l();
                        return;
                    }
                    hy4Var.getContext().showToast((int) R.string.over_limit_tip);
                    this$0.b = true;
                    return;
                }
                if (this$0.b) {
                    hy4Var.getContext().showToast((int) R.string.over_limit_tip);
                }
                if (!this$0.f(hy4Var.getContext(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(hy4Var.getContext().getPageActivity(), 12005, true);
                editorTools.setPadding(0, 0, 0, 0);
                if (hy4Var.f() != null) {
                    SpanGroupManager f = hy4Var.f();
                    Intrinsics.checkNotNull(f);
                    atListActivityConfig.setSelectedAtList(f.w());
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
            Object obj = si5Var.c;
            if (obj instanceof cl5) {
                if (obj != null) {
                    String str = ((cl5) obj).a;
                    Intrinsics.checkNotNullExpressionValue(str, "action.data as SubPbInputContentData).mContent");
                    hy4Var.q(str);
                    Object obj2 = si5Var.c;
                    if (obj2 != null) {
                        hy4Var.r(((cl5) obj2).c);
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

    @Override // com.baidu.tieba.ui5
    public wi5 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            wi5 a = super.a(context);
            Intrinsics.checkNotNullExpressionValue(a, "super.build(context)");
            return a;
        }
        return (wi5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ui5
    public wi5 b(Context context) {
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
            return new hy4(editorTools);
        }
        return (wi5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ui5
    public void d(wi5 editor) {
        ej5 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editor) == null) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            EditorTools a = editor.a();
            if (this.a.f) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                a.h(arrayList);
                if (!this.a.g && (p = a.p(5)) != null) {
                    p.e(false);
                    p.f(false);
                    p.l = 2;
                }
            }
            if (this.a.h) {
                gj5 gj5Var = new gj5(a.getContext(), 7);
                gj5Var.i = false;
                a.d(gj5Var);
            }
            jy4 jy4Var = new jy4(a.getContext());
            jy4Var.g(this.a);
            a.d(jy4Var);
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
