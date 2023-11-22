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
public class zg5 extends ae5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes9.dex */
    public class a implements zd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ zg5 c;

        public a(zg5 zg5Var, yg5 yg5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg5Var, yg5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zg5Var;
            this.a = yg5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.zd5
        public void S(yd5 yd5Var) {
            le5 u;
            me5 me5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yd5Var) != null) || yd5Var == null) {
                return;
            }
            int i = yd5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 77) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i == 11) {
                                        this.a.h0(null);
                                        EditorTools editorTools = this.b;
                                        if (editorTools != null && (u = editorTools.u(6)) != null && (me5Var = u.m) != null) {
                                            me5Var.S(new yd5(52, 0, null));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                Object obj = yd5Var.c;
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
            Object obj2 = yd5Var.c;
            if (obj2 instanceof ah5) {
                this.a.d0((ah5) obj2);
                this.a.c0(((ah5) yd5Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.W((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.W(obj2.toString());
                this.a.c0((SpanGroupManager) yd5Var.c);
            }
            this.c.a = false;
        }
    }

    public zg5(boolean z) {
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

    @Override // com.baidu.tieba.ae5
    public ce5 b(Context context) {
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
            yg5 yg5Var = new yg5(editorTools);
            yg5Var.s = this.c;
            return yg5Var;
        }
        return (ce5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ae5
    public void c(ce5 ce5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ce5Var) != null) || ce5Var == null) {
            return;
        }
        EditorTools a2 = ce5Var.a();
        a aVar = new a(this, (yg5) ce5Var, a2);
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

    @Override // com.baidu.tieba.ae5
    public void d(ce5 ce5Var) {
        CustomResponsedMessage runTask;
        le5 le5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ce5Var) == null) {
            EditorTools a2 = ce5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.k(arrayList);
            le5 u = a2.u(5);
            if (u != null) {
                u.f(false);
                u.g(false);
                u.l = 1;
            }
            if (!this.c) {
                if (rta.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), le5.class)) != null && (le5Var = (le5) runTask.getData()) != null) {
                    le5Var.l = 2;
                    a2.f(le5Var);
                }
                a2.f(new ne5(a2.getContext(), 4));
            }
            PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(a2.getContext(), this.c, false, 12005);
            if (!qd.isEmpty(this.b)) {
                pbNewEditorTool.p(this.b);
            }
            pbNewEditorTool.o(PbNewEditorTool.InputShowType.REPLY_FLOOR);
            a2.f(pbNewEditorTool);
            a2.h();
            a2.K(new yd5(35, 5, Boolean.FALSE));
            a2.y();
            if (dh5.isOn()) {
                a2.K(new yd5(76, 27, Long.valueOf(a2.getFid())));
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
