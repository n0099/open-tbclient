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
public class r85 extends m65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements l65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q85 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ r85 c;

        public a(r85 r85Var, q85 q85Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r85Var, q85Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r85Var;
            this.a = q85Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.l65
        public void B(k65 k65Var) {
            v65 n;
            w65 w65Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, k65Var) != null) || k65Var == null) {
                return;
            }
            int i = k65Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i == 11) {
                                    this.a.e0(null);
                                    EditorTools editorTools = this.b;
                                    if (editorTools != null && (n = editorTools.n(6)) != null && (w65Var = n.m) != null) {
                                        w65Var.B(new k65(52, 0, null));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            Object obj = k65Var.c;
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
                    this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d61);
                    this.c.a = true;
                    return;
                }
                if (this.c.a) {
                    this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d61);
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
            Object obj2 = k65Var.c;
            if (obj2 instanceof s85) {
                this.a.a0((s85) obj2);
                this.a.Z(((s85) k65Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.T((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.T(obj2.toString());
                this.a.Z((SpanGroupManager) k65Var.c);
            }
            this.c.a = false;
        }
    }

    public r85(boolean z) {
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

    @Override // com.baidu.tieba.m65
    public o65 b(Context context) {
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
            q85 q85Var = new q85(editorTools);
            q85Var.s = this.c;
            return q85Var;
        }
        return (o65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m65
    public void c(o65 o65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o65Var) != null) || o65Var == null) {
            return;
        }
        EditorTools b = o65Var.b();
        a aVar = new a(this, (q85) o65Var, b);
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

    @Override // com.baidu.tieba.m65
    public void d(o65 o65Var) {
        CustomResponsedMessage runTask;
        v65 v65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o65Var) == null) {
            EditorTools b = o65Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            v65 n = b.n(5);
            if (n != null) {
                n.e(false);
                n.f(false);
                n.l = 1;
            }
            if (!this.c) {
                if (er8.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), v65.class)) != null && (v65Var = (v65) runTask.getData()) != null) {
                    v65Var.l = 2;
                    b.d(v65Var);
                }
                b.d(new x65(b.getContext(), 4));
            }
            n85 n85Var = new n85(b.getContext(), this.c, false, 12005);
            if (!xi.isEmpty(this.b)) {
                n85Var.m(this.b);
            }
            b.d(n85Var);
            b.f();
            b.A(new k65(35, 5, Boolean.FALSE));
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
