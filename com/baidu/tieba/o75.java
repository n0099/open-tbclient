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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class o75 extends j55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements i55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n75 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ o75 c;

        public a(o75 o75Var, n75 n75Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o75Var, n75Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o75Var;
            this.a = n75Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.i55
        public void B(h55 h55Var) {
            s55 n;
            t55 t55Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) || h55Var == null) {
                return;
            }
            int i = h55Var.a;
            if (i == 4) {
                Object obj = h55Var.c;
                if (obj instanceof p75) {
                    this.a.a0((p75) obj);
                    this.a.Z(((p75) h55Var.c).c);
                } else if (obj instanceof String) {
                    this.a.T((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.a.T(obj.toString());
                    this.a.Z((SpanGroupManager) h55Var.c);
                }
                this.c.a = false;
            } else if (i == 16) {
                if (this.c.a) {
                    this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                }
                if (this.c.h(this.a.getContext(), 11025)) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12005, true);
                    if (this.a.v() != null) {
                        atListActivityConfig.setSelectedAtList(this.a.v().w());
                    }
                    EditorTools editorTools = this.b;
                    if (editorTools != null) {
                        atListActivityConfig.setFromTid(editorTools.getTid());
                        atListActivityConfig.setFromFid(String.valueOf(this.b.getFid()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    EditorTools editorTools2 = this.b;
                    if (editorTools2 != null) {
                        statisticItem.addParam("tid", editorTools2.getTid());
                        statisticItem.addParam("fid", this.b.getFid());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (i == 7) {
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                this.c.a = true;
            } else if (i == 8) {
                if (this.c.h(this.a.getContext(), 11001)) {
                    this.a.G();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i == 10) {
                Object obj2 = h55Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.e0((VoiceData.VoiceModel) obj2);
                    this.a.w(null);
                }
            } else if (i != 11) {
            } else {
                this.a.e0(null);
                EditorTools editorTools3 = this.b;
                if (editorTools3 == null || (n = editorTools3.n(6)) == null || (t55Var = n.m) == null) {
                    return;
                }
                t55Var.B(new h55(52, 0, null));
            }
        }
    }

    public o75(boolean z) {
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

    @Override // com.baidu.tieba.j55
    public l55 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(this.c ? 5 : 2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            n75 n75Var = new n75(editorTools);
            n75Var.s = this.c;
            return n75Var;
        }
        return (l55) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j55
    public void c(l55 l55Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l55Var) == null) || l55Var == null) {
            return;
        }
        EditorTools a2 = l55Var.a();
        a aVar = new a(this, (n75) l55Var, a2);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
    }

    @Override // com.baidu.tieba.j55
    public void d(l55 l55Var) {
        CustomResponsedMessage runTask;
        s55 s55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l55Var) == null) {
            EditorTools a2 = l55Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            s55 n = a2.n(5);
            if (n != null) {
                n.e(false);
                n.f(false);
                n.l = 1;
            }
            if (!this.c) {
                if (cp8.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), s55.class)) != null && (s55Var = (s55) runTask.getData()) != null) {
                    s55Var.l = 2;
                    a2.d(s55Var);
                }
                a2.d(new u55(a2.getContext(), 4));
            }
            k75 k75Var = new k75(a2.getContext(), this.c, false, 12005);
            if (!dj.isEmpty(this.b)) {
                k75Var.m(this.b);
            }
            a2.d(k75Var);
            a2.f();
            a2.A(new h55(35, 5, Boolean.FALSE));
            a2.q();
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }
}
