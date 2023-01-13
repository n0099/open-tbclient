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
public class jc7 extends b75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public class a implements a75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic7 a;
        public final /* synthetic */ jc7 b;

        public a(jc7 jc7Var, ic7 ic7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc7Var, ic7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jc7Var;
            this.a = ic7Var;
        }

        @Override // com.baidu.tieba.a75
        public void A(z65 z65Var) {
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, z65Var) != null) || z65Var == null) {
                return;
            }
            int i = z65Var.a;
            if (i != 4 && i != 6) {
                if (i != 7) {
                    if (i != 8) {
                        if (i != 14) {
                            if (i == 15) {
                                int intValue = ((Integer) z65Var.c).intValue();
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
                        if (x85.a().b() == 1) {
                            albumActivityConfig.setRequestFrom(4);
                            if (this.a.r() != null) {
                                this.a.r().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.r() != null) {
                            this.a.r().setMaxImagesAllowed(10);
                        }
                        zi.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
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
            this.a.H((String) z65Var.c);
            this.b.a = false;
        }
    }

    public jc7() {
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

    @Override // com.baidu.tieba.b75
    public d75 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.F(false);
            return new ic7(editorTools);
        }
        return (d75) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b75
    public void c(d75 d75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d75Var) != null) || d75Var == null) {
            return;
        }
        EditorTools b = d75Var.b();
        a aVar = new a(this, (ic7) d75Var);
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

    @Override // com.baidu.tieba.b75
    public void d(d75 d75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d75Var) == null) {
            EditorTools b = d75Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            k75 p = b.p(5);
            if (p != null) {
                p.e(false);
                p.l = 1;
            }
            b.d(new v75(b.getContext(), 3));
            kc7 kc7Var = new kc7(b.getContext());
            if (kc7Var.g() != null) {
                kc7Var.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
            }
            b.d(kc7Var);
            b.f();
            b.C(new z65(35, 5, Boolean.FALSE));
            b.s();
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
