package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class yg5 extends zd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes9.dex */
    public class a implements yd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ yg5 c;

        public a(yg5 yg5Var, xg5 xg5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg5Var, xg5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yg5Var;
            this.a = xg5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.yd5
        public void S(xd5 xd5Var) {
            ke5 u;
            le5 le5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, xd5Var) != null) || xd5Var == null) {
                return;
            }
            int i = xd5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 77) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i == 11) {
                                        this.a.h0(null);
                                        EditorTools editorTools = this.b;
                                        if (editorTools != null && (u = editorTools.u(6)) != null && (le5Var = u.m) != null) {
                                            le5Var.S(new xd5(52, 0, null));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Object obj = xd5Var.c;
                                if (obj instanceof VoiceData.VoiceModel) {
                                    this.a.h0((VoiceData.VoiceModel) obj);
                                    this.a.x(null);
                                    return;
                                }
                                return;
                            } else if (!this.c.h(this.a.u(), 11001)) {
                                return;
                            } else {
                                this.a.J();
                                TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                                return;
                            }
                        }
                        this.a.u().showToast((int) R.string.over_limit_tip);
                        this.c.a = true;
                        return;
                    }
                    this.a.y();
                    return;
                }
                if (this.c.a) {
                    this.a.u().showToast((int) R.string.over_limit_tip);
                }
                if (!this.c.h(this.a.u(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.u().getPageActivity(), 12005, true);
                if (this.a.w() != null) {
                    atListActivityConfig.setSelectedAtList(this.a.w().x());
                }
                EditorTools editorTools2 = this.b;
                if (editorTools2 != null) {
                    atListActivityConfig.setFromTid(editorTools2.getTid());
                    atListActivityConfig.setFromFid(String.valueOf(this.b.getFid()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                EditorTools editorTools3 = this.b;
                if (editorTools3 != null) {
                    statisticItem.addParam("tid", editorTools3.getTid());
                    statisticItem.addParam("fid", this.b.getFid());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            Object obj2 = xd5Var.c;
            if (obj2 instanceof zg5) {
                this.a.d0((zg5) obj2);
                this.a.c0(((zg5) xd5Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.W((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.W(obj2.toString());
                this.a.c0((SpanGroupManager) xd5Var.c);
            }
            this.c.a = false;
        }
    }

    public yg5(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = false;
        this.c = z;
    }

    @Override // com.baidu.tieba.zd5
    public be5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            int i = 5;
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            if (!this.c) {
                i = 2;
            }
            editorTools.setBarLauncherType(i);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.N(false);
            xg5 xg5Var = new xg5(editorTools);
            xg5Var.s = this.c;
            return xg5Var;
        }
        return (be5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zd5
    public void c(be5 be5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, be5Var) != null) || be5Var == null) {
            return;
        }
        EditorTools a2 = be5Var.a();
        a aVar = new a(this, (xg5) be5Var, a2);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
        a2.setActionListener(77, aVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.zd5
    public void d(be5 be5Var) {
        CustomResponsedMessage runTask;
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, be5Var) == null) {
            EditorTools a2 = be5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.k(arrayList);
            ke5 u = a2.u(5);
            if (u != null) {
                u.f(false);
                u.g(false);
                u.l = 1;
            }
            if (!this.c) {
                if (qta.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), ke5.class)) != null && (ke5Var = (ke5) runTask.getData()) != null) {
                    ke5Var.l = 2;
                    a2.f(ke5Var);
                }
                a2.f(new me5(a2.getContext(), 4));
            }
            PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(a2.getContext(), this.c, false, 12005);
            if (!qd.isEmpty(this.b)) {
                pbNewEditorTool.p(this.b);
            }
            pbNewEditorTool.o(PbNewEditorTool.InputShowType.REPLY_FLOOR);
            a2.f(pbNewEditorTool);
            a2.h();
            a2.K(new xd5(35, 5, Boolean.FALSE));
            a2.y();
            if (ch5.isOn()) {
                a2.K(new xd5(76, 27, Long.valueOf(a2.getFid())));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
