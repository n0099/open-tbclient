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
/* loaded from: classes6.dex */
public class rf5 extends ld5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ rf5 c;

        public a(rf5 rf5Var, qf5 qf5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf5Var, qf5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rf5Var;
            this.a = qf5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.kd5
        public void C(jd5 jd5Var) {
            ud5 p;
            vd5 vd5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jd5Var) != null) || jd5Var == null) {
                return;
            }
            int i = jd5Var.a;
            if (i != 4) {
                if (i != 16) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i == 11) {
                                    this.a.e0(null);
                                    EditorTools editorTools = this.b;
                                    if (editorTools != null && (p = editorTools.p(6)) != null && (vd5Var = p.m) != null) {
                                        vd5Var.C(new jd5(52, 0, null));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            Object obj = jd5Var.c;
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
                    this.a.getContext().showToast((int) R.string.over_limit_tip);
                    this.c.a = true;
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
            Object obj2 = jd5Var.c;
            if (obj2 instanceof sf5) {
                this.a.a0((sf5) obj2);
                this.a.Z(((sf5) jd5Var.c).c);
            } else if (obj2 instanceof String) {
                this.a.T((String) obj2);
            } else if (obj2 instanceof SpanGroupManager) {
                this.a.T(obj2.toString());
                this.a.Z((SpanGroupManager) jd5Var.c);
            }
            this.c.a = false;
        }
    }

    public rf5(boolean z) {
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

    @Override // com.baidu.tieba.ld5
    public nd5 b(Context context) {
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
            qf5 qf5Var = new qf5(editorTools);
            qf5Var.s = this.c;
            return qf5Var;
        }
        return (nd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ld5
    public void c(nd5 nd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd5Var) != null) || nd5Var == null) {
            return;
        }
        EditorTools b = nd5Var.b();
        a aVar = new a(this, (qf5) nd5Var, b);
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

    @Override // com.baidu.tieba.ld5
    public void d(nd5 nd5Var) {
        CustomResponsedMessage runTask;
        ud5 ud5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nd5Var) == null) {
            EditorTools b = nd5Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            ud5 p = b.p(5);
            if (p != null) {
                p.e(false);
                p.f(false);
                p.l = 1;
            }
            if (!this.c) {
                if (jr9.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), ud5.class)) != null && (ud5Var = (ud5) runTask.getData()) != null) {
                    ud5Var.l = 2;
                    b.d(ud5Var);
                }
                b.d(new wd5(b.getContext(), 4));
            }
            nf5 nf5Var = new nf5(b.getContext(), this.c, false, 12005);
            if (!hi.isEmpty(this.b)) {
                nf5Var.m(this.b);
            }
            b.d(nf5Var);
            b.f();
            b.C(new jd5(35, 5, Boolean.FALSE));
            b.s();
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
