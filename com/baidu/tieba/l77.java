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
/* loaded from: classes4.dex */
public class l77 extends m65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes4.dex */
    public class a implements l65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k77 a;
        public final /* synthetic */ l77 b;

        public a(l77 l77Var, k77 k77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l77Var, k77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l77Var;
            this.a = k77Var;
        }

        @Override // com.baidu.tieba.l65
        public void B(k65 k65Var) {
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, k65Var) != null) || k65Var == null) {
                return;
            }
            int i = k65Var.a;
            if (i != 4 && i != 6) {
                if (i != 7) {
                    if (i != 8) {
                        if (i != 14) {
                            if (i == 15) {
                                int intValue = ((Integer) k65Var.c).intValue();
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
                        if (i85.a().b() == 1) {
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
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d61);
                this.b.a = true;
                return;
            }
            this.a.H((String) k65Var.c);
            this.b.a = false;
        }
    }

    public l77() {
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

    @Override // com.baidu.tieba.m65
    public o65 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            return new k77(editorTools);
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
        a aVar = new a(this, (k77) o65Var);
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

    @Override // com.baidu.tieba.m65
    public void d(o65 o65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o65Var) == null) {
            EditorTools b = o65Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            v65 n = b.n(5);
            if (n != null) {
                n.e(false);
                n.l = 1;
            }
            b.d(new g75(b.getContext(), 3));
            m77 m77Var = new m77(b.getContext());
            if (m77Var.g() != null) {
                m77Var.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
            }
            b.d(m77Var);
            b.f();
            b.A(new k65(35, 5, Boolean.FALSE));
            b.q();
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
