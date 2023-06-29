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
/* loaded from: classes6.dex */
public class lk5 extends ei5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements di5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ lk5 c;

        public a(lk5 lk5Var, kk5 kk5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lk5Var, kk5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lk5Var;
            this.a = kk5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.di5
        public void C(ci5 ci5Var) {
            oi5 p;
            pi5 pi5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ci5Var) != null) || ci5Var == null) {
                return;
            }
            int i = ci5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 77) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i == 11) {
                                        this.a.f0(null);
                                        EditorTools editorTools = this.b;
                                        if (editorTools != null && (p = editorTools.p(6)) != null && (pi5Var = p.m) != null) {
                                            pi5Var.C(new ci5(52, 0, null));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Object obj = ci5Var.c;
                                if (obj instanceof VoiceData.VoiceModel) {
                                    this.a.f0((VoiceData.VoiceModel) obj);
                                    this.a.w(null);
                                    return;
                                }
                                return;
                            } else if (!this.c.h(this.a.getContext(), 11001)) {
                                return;
                            } else {
                                this.a.H();
                                TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                                return;
                            }
                        }
                        this.a.getContext().showToast((int) R.string.over_limit_tip);
                        this.c.a = true;
                        return;
                    }
                    this.a.x();
                    return;
                }
                if (this.c.a) {
                    this.a.getContext().showToast((int) R.string.over_limit_tip);
                }
                if (!this.c.h(this.a.getContext(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12005, true);
                if (this.a.v() != null) {
                    atListActivityConfig.setSelectedAtList(this.a.v().w());
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
            Object obj2 = ci5Var.c;
            if (obj2 instanceof mk5) {
                this.a.b0((mk5) obj2);
                this.a.a0(((mk5) ci5Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.U((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.U(obj2.toString());
                this.a.a0((SpanGroupManager) ci5Var.c);
            }
            this.c.a = false;
        }
    }

    public lk5(boolean z) {
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

    @Override // com.baidu.tieba.ei5
    public gi5 b(Context context) {
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
            editorTools.F(false);
            kk5 kk5Var = new kk5(editorTools);
            kk5Var.s = this.c;
            return kk5Var;
        }
        return (gi5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ei5
    public void c(gi5 gi5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gi5Var) != null) || gi5Var == null) {
            return;
        }
        EditorTools b = gi5Var.b();
        a aVar = new a(this, (kk5) gi5Var, b);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(77, aVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.ei5
    public void d(gi5 gi5Var) {
        CustomResponsedMessage runTask;
        oi5 oi5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gi5Var) == null) {
            EditorTools b = gi5Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            oi5 p = b.p(5);
            if (p != null) {
                p.e(false);
                p.f(false);
                p.l = 1;
            }
            if (!this.c) {
                if (h6a.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), oi5.class)) != null && (oi5Var = (oi5) runTask.getData()) != null) {
                    oi5Var.l = 2;
                    b.d(oi5Var);
                }
                b.d(new qi5(b.getContext(), 4));
            }
            PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(b.getContext(), this.c, false, 12005);
            if (!wi.isEmpty(this.b)) {
                pbNewEditorTool.n(this.b);
            }
            pbNewEditorTool.m(PbNewEditorTool.InputShowType.REPLY_FLOOR);
            b.d(pbNewEditorTool);
            b.f();
            b.C(new ci5(35, 5, Boolean.FALSE));
            b.s();
            if (pk5.isOn()) {
                b.C(new ci5(76, 27, Long.valueOf(b.getFid())));
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
