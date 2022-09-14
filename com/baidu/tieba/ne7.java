package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
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
public class ne7 extends w45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes5.dex */
    public class a implements v45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me7 a;
        public final /* synthetic */ ne7 b;

        public a(ne7 ne7Var, me7 me7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ne7Var, me7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ne7Var;
            this.a = me7Var;
        }

        @Override // com.baidu.tieba.v45
        public void B(u45 u45Var) {
            me7 me7Var;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, u45Var) == null) || (me7Var = this.a) == null || me7Var.a() == null || u45Var == null) {
                return;
            }
            int i = u45Var.a;
            if (i == 4) {
                this.a.e0(u45Var.c.toString());
                Object obj = u45Var.c;
                if (obj instanceof SpanGroupManager) {
                    this.a.j0((SpanGroupManager) obj);
                }
                this.b.d = false;
            } else if (i == 32) {
                this.a.a().A(new u45(1, 11, null));
            } else if (i == 36) {
                if (this.b.j(this.a.getContext(), 11040)) {
                    this.a.S();
                }
            } else if (i == 7) {
                ej.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d37);
                this.b.d = true;
            } else if (i == 8) {
                if (this.b.j(this.a.getContext(), 11001)) {
                    this.a.G(null, null);
                }
            } else if (i == 10) {
                Object obj2 = u45Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.m0((VoiceData.VoiceModel) obj2);
                    this.a.w(true, null);
                }
            } else if (i != 11) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.v().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.b.b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.b.b);
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (s65.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.a.v() != null) {
                                this.a.v().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.v() != null) {
                            this.a.v().setMaxImagesAllowed(9);
                        }
                        ej.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) u45Var.c).intValue();
                        if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.b.d) {
                            ej.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d37);
                        }
                        if (this.b.j(this.a.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                            if (this.a.u() != null) {
                                atListActivityConfig.setSelectedAtList(this.a.u().w());
                            }
                            atListActivityConfig.setFromTid(this.b.c);
                            atListActivityConfig.setFromFid(this.b.b);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.addParam("tid", this.b.c);
                            statisticItem.addParam("fid", this.b.b);
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.a.m0(null);
            }
        }
    }

    public ne7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
    }

    @Override // com.baidu.tieba.w45
    public y45 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(this.e ? 2 : 3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            return new me7(editorTools);
        }
        return (y45) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w45
    public void c(y45 y45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y45Var) == null) && (y45Var instanceof me7)) {
            EditorTools a2 = y45Var.a();
            a aVar = new a(this, (me7) y45Var);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
        }
    }

    @Override // com.baidu.tieba.w45
    public void d(y45 y45Var) {
        CustomResponsedMessage runTask;
        f55 f55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y45Var) == null) {
            EditorTools a2 = y45Var.a();
            if (no8.a() && tl8.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), f55.class)) != null && (f55Var = (f55) runTask.getData()) != null) {
                f55Var.l = 2;
                a2.d(f55Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            f55 n = a2.n(5);
            if (n != null) {
                n.e(!this.e);
                n.f(!this.e);
                n.l = this.e ? 1 : 3;
            }
            h55 h55Var = new h55(a2.getContext(), 4);
            h55Var.i = false;
            a2.d(h55Var);
            if (!this.e) {
                a2.d(new q55(a2.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), f55.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    f55 f55Var2 = (f55) runTask2.getData();
                    f55Var2.l = 6;
                    a2.d(f55Var2);
                }
                a2.d(new x65(a2.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), f55.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    f55 f55Var3 = (f55) runTask3.getData();
                    f55Var3.l = 7;
                    a2.d(f55Var3);
                }
                a2.d(new o55(a2.getContext(), 5));
            } else {
                a2.d(new x65(a2.getContext(), false, false, 12004));
            }
            a2.f();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (y95.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.b = str2;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }
}
