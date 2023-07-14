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
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class wh8 extends bj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes8.dex */
    public class a implements aj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh8 a;
        public final /* synthetic */ wh8 b;

        public a(wh8 wh8Var, vh8 vh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh8Var, vh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wh8Var;
            this.a = vh8Var;
        }

        @Override // com.baidu.tieba.aj5
        public void B(zi5 zi5Var) {
            vh8 vh8Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zi5Var) != null) || (vh8Var = this.a) == null || vh8Var.b() == null || zi5Var == null) {
                return;
            }
            int i = zi5Var.a;
            if (i != 4) {
                if (i != 32) {
                    if (i != 36) {
                        if (i != 77) {
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
                                                    if (zk5.a().b() == 1) {
                                                        albumFloatActivityConfig.setRequestFrom(2);
                                                        if (this.a.v() != null) {
                                                            this.a.v().setMaxImagesAllowed(1);
                                                        }
                                                    } else if (this.a.v() != null) {
                                                        this.a.v().setMaxImagesAllowed(9);
                                                    }
                                                    yi.A(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                    return;
                                                case 15:
                                                    int intValue = ((Integer) zi5Var.c).intValue();
                                                    if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                                        return;
                                                    }
                                                    return;
                                                case 16:
                                                    if (this.b.d) {
                                                        yi.Q(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                                                    }
                                                    if (!this.b.j(this.a.getContext(), 11025)) {
                                                        return;
                                                    }
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
                                                default:
                                                    return;
                                            }
                                        }
                                        this.a.n0(null);
                                        return;
                                    }
                                    Object obj = zi5Var.c;
                                    if (obj instanceof VoiceData.VoiceModel) {
                                        this.a.n0((VoiceData.VoiceModel) obj);
                                        this.a.w(true, null);
                                        return;
                                    }
                                    return;
                                } else if (!this.b.j(this.a.getContext(), 11001)) {
                                    return;
                                } else {
                                    this.a.H(null, null);
                                    return;
                                }
                            }
                            yi.Q(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                            this.b.d = true;
                            return;
                        }
                        this.a.x();
                        return;
                    } else if (!this.b.j(this.a.getContext(), 11040)) {
                        return;
                    } else {
                        this.a.T();
                        return;
                    }
                }
                this.a.b().D(new zi5(1, 11, null));
                return;
            }
            this.a.f0(zi5Var.c.toString());
            Object obj2 = zi5Var.c;
            if (obj2 instanceof SpanGroupManager) {
                this.a.k0((SpanGroupManager) obj2);
            }
            this.b.d = false;
        }
    }

    public wh8() {
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

    @Override // com.baidu.tieba.bj5
    public dj5 b(Context context) {
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
            editorTools.G(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            return new vh8(editorTools);
        }
        return (dj5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bj5
    public void c(dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj5Var) != null) || !(dj5Var instanceof vh8)) {
            return;
        }
        EditorTools b = dj5Var.b();
        a aVar = new a(this, (vh8) dj5Var);
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
        b.setActionListener(77, aVar);
    }

    @Override // com.baidu.tieba.bj5
    public void d(dj5 dj5Var) {
        int i;
        CustomResponsedMessage runTask;
        lj5 lj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dj5Var) == null) {
            EditorTools b = dj5Var.b();
            if (sea.a() && wba.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), lj5.class)) != null && (lj5Var = (lj5) runTask.getData()) != null) {
                lj5Var.l = 2;
                b.d(lj5Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            lj5 p = b.p(5);
            if (p != null) {
                p.e(!this.e);
                p.f(!this.e);
                if (this.e) {
                    i = 1;
                } else {
                    i = 3;
                }
                p.l = i;
            }
            nj5 nj5Var = new nj5(b.getContext(), 4);
            nj5Var.i = false;
            b.d(nj5Var);
            if (!this.e) {
                b.d(new wj5(b.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), lj5.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    lj5 lj5Var2 = (lj5) runTask2.getData();
                    lj5Var2.l = 6;
                    b.d(lj5Var2);
                }
                PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(b.getContext(), false, true, 12004);
                pbNewEditorTool.m(PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE);
                b.d(pbNewEditorTool);
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), lj5.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    lj5 lj5Var3 = (lj5) runTask3.getData();
                    lj5Var3.l = 7;
                    b.d(lj5Var3);
                }
                b.d(new uj5(b.getContext(), 5));
            } else {
                PbNewEditorTool pbNewEditorTool2 = new PbNewEditorTool(b.getContext(), false, false, 12004);
                pbNewEditorTool2.m(PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE);
                b.d(pbNewEditorTool2);
            }
            b.f();
            if (ml5.isOn()) {
                b.D(new zi5(76, 27, this.b));
            }
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (uq5.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
