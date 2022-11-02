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
/* loaded from: classes4.dex */
public class l85 extends g65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes4.dex */
    public class a implements f65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k85 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ l85 c;

        public a(l85 l85Var, k85 k85Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l85Var, k85Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l85Var;
            this.a = k85Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.f65
        public void B(e65 e65Var) {
            p65 n;
            q65 q65Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, e65Var) != null) || e65Var == null) {
                return;
            }
            int i = e65Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i == 11) {
                                    this.a.e0(null);
                                    EditorTools editorTools = this.b;
                                    if (editorTools != null && (n = editorTools.n(6)) != null && (q65Var = n.m) != null) {
                                        q65Var.B(new e65(52, 0, null));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            Object obj = e65Var.c;
                            if (obj instanceof VoiceData.VoiceModel) {
                                this.a.e0((VoiceData.VoiceModel) obj);
                                this.a.w(null);
                                return;
                            }
                            return;
                        } else if (!this.c.h(this.a.getContext(), 11001)) {
                            return;
                        } else {
                            this.a.G();
                            TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                            return;
                        }
                    }
                    this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d5f);
                    this.c.a = true;
                    return;
                }
                if (this.c.a) {
                    this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d5f);
                }
                if (!this.c.h(this.a.getContext(), 11025)) {
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12005, true);
                if (this.a.v() != null) {
                    atListActivityConfig.setSelectedAtList(this.a.v().u());
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
            Object obj2 = e65Var.c;
            if (obj2 instanceof m85) {
                this.a.a0((m85) obj2);
                this.a.Z(((m85) e65Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.T((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.T(obj2.toString());
                this.a.Z((SpanGroupManager) e65Var.c);
            }
            this.c.a = false;
        }
    }

    public l85(boolean z) {
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

    @Override // com.baidu.tieba.g65
    public i65 b(Context context) {
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
            editorTools.D(false);
            k85 k85Var = new k85(editorTools);
            k85Var.s = this.c;
            return k85Var;
        }
        return (i65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g65
    public void c(i65 i65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i65Var) != null) || i65Var == null) {
            return;
        }
        EditorTools b = i65Var.b();
        a aVar = new a(this, (k85) i65Var, b);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.g65
    public void d(i65 i65Var) {
        CustomResponsedMessage runTask;
        p65 p65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i65Var) == null) {
            EditorTools b = i65Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            p65 n = b.n(5);
            if (n != null) {
                n.e(false);
                n.f(false);
                n.l = 1;
            }
            if (!this.c) {
                if (tq8.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), p65.class)) != null && (p65Var = (p65) runTask.getData()) != null) {
                    p65Var.l = 2;
                    b.d(p65Var);
                }
                b.d(new r65(b.getContext(), 4));
            }
            h85 h85Var = new h85(b.getContext(), this.c, false, 12005);
            if (!wi.isEmpty(this.b)) {
                h85Var.m(this.b);
            }
            b.d(h85Var);
            b.f();
            b.A(new e65(35, 5, Boolean.FALSE));
            b.q();
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
