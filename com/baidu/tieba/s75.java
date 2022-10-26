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
public class s75 extends n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements m55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r75 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ s75 c;

        public a(s75 s75Var, r75 r75Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s75Var, r75Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s75Var;
            this.a = r75Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.m55
        public void B(l55 l55Var) {
            w55 n;
            x55 x55Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l55Var) != null) || l55Var == null) {
                return;
            }
            int i = l55Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i == 11) {
                                    this.a.e0(null);
                                    EditorTools editorTools = this.b;
                                    if (editorTools != null && (n = editorTools.n(6)) != null && (x55Var = n.m) != null) {
                                        x55Var.B(new l55(52, 0, null));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            Object obj = l55Var.c;
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
                    this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d48);
                    this.c.a = true;
                    return;
                }
                if (this.c.a) {
                    this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d48);
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
            Object obj2 = l55Var.c;
            if (obj2 instanceof t75) {
                this.a.a0((t75) obj2);
                this.a.Z(((t75) l55Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.T((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.T(obj2.toString());
                this.a.Z((SpanGroupManager) l55Var.c);
            }
            this.c.a = false;
        }
    }

    public s75(boolean z) {
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

    @Override // com.baidu.tieba.n55
    public p55 b(Context context) {
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
            r75 r75Var = new r75(editorTools);
            r75Var.s = this.c;
            return r75Var;
        }
        return (p55) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n55
    public void c(p55 p55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) != null) || p55Var == null) {
            return;
        }
        EditorTools b = p55Var.b();
        a aVar = new a(this, (r75) p55Var, b);
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

    @Override // com.baidu.tieba.n55
    public void d(p55 p55Var) {
        CustomResponsedMessage runTask;
        w55 w55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p55Var) == null) {
            EditorTools b = p55Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            w55 n = b.n(5);
            if (n != null) {
                n.e(false);
                n.f(false);
                n.l = 1;
            }
            if (!this.c) {
                if (jp8.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage(2001448, b.getContext()), w55.class)) != null && (w55Var = (w55) runTask.getData()) != null) {
                    w55Var.l = 2;
                    b.d(w55Var);
                }
                b.d(new y55(b.getContext(), 4));
            }
            o75 o75Var = new o75(b.getContext(), this.c, false, 12005);
            if (!ej.isEmpty(this.b)) {
                o75Var.m(this.b);
            }
            b.d(o75Var);
            b.f();
            b.A(new l55(35, 5, Boolean.FALSE));
            b.q();
        }
    }

    public final boolean h(TbPageContext tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
