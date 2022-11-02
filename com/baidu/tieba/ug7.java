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
/* loaded from: classes6.dex */
public class ug7 extends g65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes6.dex */
    public class a implements f65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg7 a;
        public final /* synthetic */ ug7 b;

        public a(ug7 ug7Var, tg7 tg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug7Var, tg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ug7Var;
            this.a = tg7Var;
        }

        @Override // com.baidu.tieba.f65
        public void B(e65 e65Var) {
            tg7 tg7Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, e65Var) != null) || (tg7Var = this.a) == null || tg7Var.b() == null || e65Var == null) {
                return;
            }
            int i = e65Var.a;
            if (i != 4) {
                if (i != 32) {
                    if (i != 36) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i != 11) {
                                        switch (i) {
                                            case 14:
                                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.v().toJsonString(), true, true);
                                                if (!StringUtils.isNull(this.b.b, true)) {
                                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", this.b.b);
                                                }
                                                albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                                                if (c85.a().b() == 1) {
                                                    albumFloatActivityConfig.setRequestFrom(2);
                                                    if (this.a.v() != null) {
                                                        this.a.v().setMaxImagesAllowed(1);
                                                    }
                                                } else if (this.a.v() != null) {
                                                    this.a.v().setMaxImagesAllowed(9);
                                                }
                                                xi.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                return;
                                            case 15:
                                                int intValue = ((Integer) e65Var.c).intValue();
                                                if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                                    return;
                                                }
                                                return;
                                            case 16:
                                                if (this.b.d) {
                                                    xi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d5f);
                                                }
                                                if (!this.b.j(this.a.getContext(), 11025)) {
                                                    return;
                                                }
                                                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                                                if (this.a.u() != null) {
                                                    atListActivityConfig.setSelectedAtList(this.a.u().u());
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
                                            default:
                                                return;
                                        }
                                    }
                                    this.a.m0(null);
                                    return;
                                }
                                Object obj = e65Var.c;
                                if (obj instanceof VoiceData.VoiceModel) {
                                    this.a.m0((VoiceData.VoiceModel) obj);
                                    this.a.w(true, null);
                                    return;
                                }
                                return;
                            } else if (!this.b.j(this.a.getContext(), 11001)) {
                                return;
                            } else {
                                this.a.G(null, null);
                                return;
                            }
                        }
                        xi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d5f);
                        this.b.d = true;
                        return;
                    } else if (!this.b.j(this.a.getContext(), 11040)) {
                        return;
                    } else {
                        this.a.S();
                        return;
                    }
                }
                this.a.b().A(new e65(1, 11, null));
                return;
            }
            this.a.e0(e65Var.c.toString());
            Object obj2 = e65Var.c;
            if (obj2 instanceof SpanGroupManager) {
                this.a.j0((SpanGroupManager) obj2);
            }
            this.b.d = false;
        }
    }

    public ug7() {
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

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.b = str2;
        }
    }

    @Override // com.baidu.tieba.g65
    public i65 b(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            if (this.e) {
                i = 2;
            } else {
                i = 3;
            }
            editorTools.setBarLauncherType(i);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            return new tg7(editorTools);
        }
        return (i65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g65
    public void c(i65 i65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i65Var) != null) || !(i65Var instanceof tg7)) {
            return;
        }
        EditorTools b = i65Var.b();
        a aVar = new a(this, (tg7) i65Var);
        b.setActionListener(5, aVar);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(36, aVar);
        b.setActionListener(32, aVar);
    }

    @Override // com.baidu.tieba.g65
    public void d(i65 i65Var) {
        int i;
        CustomResponsedMessage runTask;
        p65 p65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i65Var) == null) {
            EditorTools b = i65Var.b();
            if (tq8.a() && yn8.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), p65.class)) != null && (p65Var = (p65) runTask.getData()) != null) {
                p65Var.l = 2;
                b.d(p65Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            p65 n = b.n(5);
            if (n != null) {
                n.e(!this.e);
                n.f(!this.e);
                if (this.e) {
                    i = 1;
                } else {
                    i = 3;
                }
                n.l = i;
            }
            r65 r65Var = new r65(b.getContext(), 4);
            r65Var.i = false;
            b.d(r65Var);
            if (!this.e) {
                b.d(new a75(b.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), p65.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    p65 p65Var2 = (p65) runTask2.getData();
                    p65Var2.l = 6;
                    b.d(p65Var2);
                }
                b.d(new h85(b.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), p65.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    p65 p65Var3 = (p65) runTask3.getData();
                    p65Var3.l = 7;
                    b.d(p65Var3);
                }
                b.d(new y65(b.getContext(), 5));
            } else {
                b.d(new h85(b.getContext(), false, false, 12004));
            }
            b.f();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (kb5.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
