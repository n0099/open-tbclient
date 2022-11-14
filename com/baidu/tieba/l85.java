package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class l85 extends o85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements l65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m85 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ l85 c;

        public a(l85 l85Var, m85 m85Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l85Var, m85Var, editorTools};
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
            this.a = m85Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.l65
        public void B(k65 k65Var) {
            m85 m85Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, k65Var) != null) || (m85Var = this.a) == null || m85Var.b() == null || k65Var == null) {
                return;
            }
            int i = k65Var.a;
            if (i != 4) {
                if (i != 5) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 14) {
                                if (i == 15) {
                                    int intValue = ((Integer) k65Var.c).intValue();
                                    if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (this.a.v() != null) {
                                this.a.v().setMaxImagesAllowed(1);
                            }
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getContext().getPageActivity(), this.a.v().toJsonString(), true, true);
                            if (!StringUtils.isNull(this.c.m(), true)) {
                                albumActivityConfig.getIntent().putExtra("from", this.c.m());
                            }
                            if (this.c.l() != null && !StringUtils.isNull(this.c.l().getId(), true)) {
                                albumActivityConfig.getIntent().putExtra("forum_id", this.c.l().getId());
                            }
                            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                            yi.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        } else if (!this.c.k(this.a.getContext(), 11001)) {
                            return;
                        } else {
                            this.a.G(null, null);
                            return;
                        }
                    }
                    this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d61);
                    return;
                } else if (!this.b.u()) {
                    TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                    return;
                } else {
                    return;
                }
            }
            this.a.e0(k65Var.c.toString());
        }
    }

    public l85() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.o85, com.baidu.tieba.m65
    public o65 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            m85 m85Var = new m85(editorTools);
            m85Var.b0(n());
            m85Var.t = true;
            return m85Var;
        }
        return (o65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o85, com.baidu.tieba.m65
    public void c(o65 o65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o65Var) != null) || !(o65Var instanceof m85)) {
            return;
        }
        EditorTools b = o65Var.b();
        a aVar = new a(this, (m85) o65Var, b);
        b.setActionListener(5, aVar);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(32, aVar);
        b.setActionListener(45, aVar);
    }

    @Override // com.baidu.tieba.o85, com.baidu.tieba.m65
    public void d(o65 o65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o65Var) == null) {
            EditorTools b = o65Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.d(new g75(b.getContext(), 1));
            b.d(new n85(b.getContext(), true, false, 12004));
            b.h(arrayList);
            v65 n = b.n(5);
            if (n != null) {
                n.l = 2;
                n.e(false);
            }
            b.f();
            b.A(new k65(35, 5, Boolean.FALSE));
        }
    }
}
