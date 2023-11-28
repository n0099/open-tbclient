package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
/* loaded from: classes7.dex */
public class o09 extends ge5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes7.dex */
    public class a implements fe5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n09 a;
        public final /* synthetic */ o09 b;

        public a(o09 o09Var, n09 n09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o09Var, n09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o09Var;
            this.a = n09Var;
        }

        @Override // com.baidu.tieba.fe5
        public void U(ee5 ee5Var) {
            n09 n09Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ee5Var) != null) || (n09Var = this.a) == null || n09Var.a() == null || ee5Var == null) {
                return;
            }
            int i = ee5Var.a;
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
                                                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.s().getPageActivity(), this.a.y().toJsonString(), true, true);
                                                    if (!StringUtils.isNull(this.b.b, true)) {
                                                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.b.b);
                                                    }
                                                    albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                                                    if (wg5.a().b() == 1) {
                                                        albumFloatActivityConfig.setRequestFrom(2);
                                                        if (this.a.y() != null) {
                                                            this.a.y().setMaxImagesAllowed(1);
                                                        }
                                                    } else if (this.a.y() != null) {
                                                        this.a.y().setMaxImagesAllowed(9);
                                                    }
                                                    BdUtilHelper.hideSoftKeyPad(this.a.s().getPageActivity(), this.a.s().getPageActivity().getCurrentFocus());
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                    return;
                                                case 15:
                                                    int intValue = ((Integer) ee5Var.c).intValue();
                                                    if (this.a.y() != null && this.a.y().getChosedFiles() != null && (size = this.a.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.s().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, this.a.y(), intValue)));
                                                        return;
                                                    }
                                                    return;
                                                case 16:
                                                    if (this.b.d) {
                                                        BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.over_limit_tip);
                                                    }
                                                    if (!this.b.j(this.a.s(), 11025)) {
                                                        return;
                                                    }
                                                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.s().getPageActivity(), 12004, true);
                                                    if (this.a.x() != null) {
                                                        atListActivityConfig.setSelectedAtList(this.a.x().x());
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
                                        this.a.q0(null);
                                        return;
                                    }
                                    Object obj = ee5Var.c;
                                    if (obj instanceof VoiceData.VoiceModel) {
                                        this.a.q0((VoiceData.VoiceModel) obj);
                                        this.a.z(true, null);
                                        return;
                                    }
                                    return;
                                } else if (!this.b.j(this.a.s(), 11001)) {
                                    return;
                                } else {
                                    this.a.K(null, null);
                                    return;
                                }
                            }
                            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.over_limit_tip);
                            this.b.d = true;
                            return;
                        }
                        this.a.A();
                        return;
                    } else if (!this.b.j(this.a.s(), 11040)) {
                        return;
                    } else {
                        this.a.W();
                        return;
                    }
                }
                this.a.a().K(new ee5(1, 11, null));
                return;
            }
            this.a.i0(ee5Var.c.toString());
            Object obj2 = ee5Var.c;
            if (obj2 instanceof SpanGroupManager) {
                this.a.n0((SpanGroupManager) obj2);
            }
            this.b.d = false;
        }
    }

    public o09() {
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

    @Override // com.baidu.tieba.ge5
    public ie5 b(Context context) {
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
            editorTools.N(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            editorTools.setFid(JavaTypesHelper.toLong(this.b, 0L));
            editorTools.setFname(this.a);
            editorTools.setTid(this.c);
            return new n09(editorTools);
        }
        return (ie5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ge5
    public void c(ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ie5Var) != null) || !(ie5Var instanceof n09)) {
            return;
        }
        EditorTools a2 = ie5Var.a();
        a aVar = new a(this, (n09) ie5Var);
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
        a2.setActionListener(77, aVar);
    }

    @Override // com.baidu.tieba.ge5
    public void d(ie5 ie5Var) {
        CustomResponsedMessage runTask;
        int i;
        CustomResponsedMessage runTask2;
        re5 re5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ie5Var) == null) {
            EditorTools a2 = ie5Var.a();
            if (kya.a() && nva.a(this.a, Boolean.TRUE) && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), re5.class)) != null && (re5Var = (re5) runTask2.getData()) != null) {
                re5Var.l = 2;
                a2.f(re5Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.k(arrayList);
            re5 u = a2.u(5);
            if (u != null) {
                u.f(!this.e);
                u.g(!this.e);
                if (this.e) {
                    i = 1;
                } else {
                    i = 3;
                }
                u.l = i;
            }
            te5 te5Var = new te5(a2.getContext(), 4);
            te5Var.i = false;
            a2.f(te5Var);
            if (!this.e) {
                a2.f(new cf5(a2.getContext(), 1));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), re5.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    re5 re5Var2 = (re5) runTask3.getData();
                    re5Var2.l = 6;
                    a2.f(re5Var2);
                }
                PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(a2.getContext(), false, true, 12004);
                pbNewEditorTool.o(PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE);
                a2.f(pbNewEditorTool);
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), re5.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    re5 re5Var3 = (re5) runTask4.getData();
                    re5Var3.l = 7;
                    a2.f(re5Var3);
                }
                if (fg5.isOn() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2921824, a2.getContext()), re5.class)) != null && runTask.getData() != null) {
                    re5 re5Var4 = (re5) runTask.getData();
                    re5Var4.l = 8;
                    a2.f(re5Var4);
                }
                a2.f(new af5(a2.getContext(), 5));
            } else {
                PbNewEditorTool pbNewEditorTool2 = new PbNewEditorTool(a2.getContext(), false, false, 12004);
                pbNewEditorTool2.o(PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE_FLOOR);
                a2.f(pbNewEditorTool2);
            }
            a2.h();
            if (jh5.isOn()) {
                a2.K(new ee5(76, 27, this.b));
            }
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (pm5.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
