package com.baidu.tieba;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class k87 extends o65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public class a implements n65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j87 a;
        public final /* synthetic */ k87 b;

        public a(k87 k87Var, j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k87Var, j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k87Var;
            this.a = j87Var;
        }

        @Override // com.baidu.tieba.n65
        public void A(m65 m65Var) {
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, m65Var) != null) || m65Var == null) {
                return;
            }
            int i = m65Var.a;
            if (i != 4 && i != 6) {
                if (i != 7) {
                    if (i != 8) {
                        if (i != 14) {
                            if (i == 15) {
                                int intValue = ((Integer) m65Var.c).intValue();
                                if (this.a.r() != null && this.a.r().getChosedFiles() != null && (size = this.a.r().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.r(), intValue)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getContext().getPageActivity(), this.a.r().toJsonString(), true, true);
                        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (k85.a().b() == 1) {
                            albumActivityConfig.setRequestFrom(4);
                            if (this.a.r() != null) {
                                this.a.r().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.r() != null) {
                            this.a.r().setMaxImagesAllowed(10);
                        }
                        yi.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        return;
                    } else if (!this.b.g(this.a.getContext(), 11001)) {
                        return;
                    } else {
                        this.a.y();
                        TiebaStatic.log(new StatisticItem("c13363").param("topic_id", String.valueOf(this.a.s())));
                        return;
                    }
                }
                this.a.getContext().showToast((int) R.string.over_limit_tip);
                this.b.a = true;
                return;
            }
            this.a.H((String) m65Var.c);
            this.b.a = false;
        }
    }

    public k87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.o65
    public q65 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.E(false);
            return new j87(editorTools);
        }
        return (q65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o65
    public void c(q65 q65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q65Var) != null) || q65Var == null) {
            return;
        }
        EditorTools b = q65Var.b();
        a aVar = new a(this, (j87) q65Var);
        b.setActionListener(5, aVar);
        b.setActionListener(4, aVar);
        b.setActionListener(6, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(32, aVar);
        b.setActionListener(45, aVar);
    }

    @Override // com.baidu.tieba.o65
    public void d(q65 q65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q65Var) == null) {
            EditorTools b = q65Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            x65 o = b.o(5);
            if (o != null) {
                o.e(false);
                o.l = 1;
            }
            b.d(new i75(b.getContext(), 3));
            l87 l87Var = new l87(b.getContext());
            if (l87Var.g() != null) {
                l87Var.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
            }
            b.d(l87Var);
            b.f();
            b.B(new m65(35, 5, Boolean.FALSE));
            b.r();
        }
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i) {
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
