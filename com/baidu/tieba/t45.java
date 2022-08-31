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
public class t45 extends n25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements m25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ t45 c;

        public a(t45 t45Var, s45 s45Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t45Var, s45Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t45Var;
            this.a = s45Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.m25
        public void A(l25 l25Var) {
            w25 n;
            x25 x25Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, l25Var) == null) || l25Var == null) {
                return;
            }
            int i = l25Var.a;
            if (i == 4) {
                Object obj = l25Var.c;
                if (obj instanceof u45) {
                    this.a.Z((u45) obj);
                    this.a.Y(((u45) l25Var.c).c);
                } else if (obj instanceof String) {
                    this.a.S((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.a.S(obj.toString());
                    this.a.Y((SpanGroupManager) l25Var.c);
                }
                this.c.a = false;
            } else if (i == 16) {
                if (this.c.a) {
                    this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d1d);
                }
                if (this.c.h(this.a.getContext(), 11025)) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12005, true);
                    if (this.a.u() != null) {
                        atListActivityConfig.setSelectedAtList(this.a.u().w());
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
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d1d);
                this.c.a = true;
            } else if (i == 8) {
                if (this.c.h(this.a.getContext(), 11001)) {
                    this.a.F();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i == 10) {
                Object obj2 = l25Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.d0((VoiceData.VoiceModel) obj2);
                    this.a.v(null);
                }
            } else if (i != 11) {
            } else {
                this.a.d0(null);
                EditorTools editorTools3 = this.b;
                if (editorTools3 == null || (n = editorTools3.n(6)) == null || (x25Var = n.m) == null) {
                    return;
                }
                x25Var.A(new l25(52, 0, null));
            }
        }
    }

    public t45(boolean z) {
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

    @Override // com.baidu.tieba.n25
    public p25 b(Context context) {
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
            s45 s45Var = new s45(editorTools);
            s45Var.s = this.c;
            return s45Var;
        }
        return (p25) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n25
    public void c(p25 p25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p25Var) == null) || p25Var == null) {
            return;
        }
        EditorTools a2 = p25Var.a();
        a aVar = new a(this, (s45) p25Var, a2);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
    }

    @Override // com.baidu.tieba.n25
    public void d(p25 p25Var) {
        CustomResponsedMessage runTask;
        w25 w25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p25Var) == null) {
            EditorTools a2 = p25Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            w25 n = a2.n(5);
            if (n != null) {
                n.e(false);
                n.f(false);
                n.l = 1;
            }
            if (!this.c) {
                if (zm8.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), w25.class)) != null && (w25Var = (w25) runTask.getData()) != null) {
                    w25Var.l = 2;
                    a2.d(w25Var);
                }
                a2.d(new y25(a2.getContext(), 4));
            }
            p45 p45Var = new p45(a2.getContext(), this.c, false, 12005);
            if (!qi.isEmpty(this.b)) {
                p45Var.m(this.b);
            }
            a2.d(p45Var);
            a2.f();
            a2.A(new l25(35, 5, Boolean.FALSE));
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
