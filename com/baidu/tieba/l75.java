package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class l75 extends j55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public String b;
    public String c;
    public boolean d;
    public DataModel<?> e;

    /* loaded from: classes4.dex */
    public class a implements i55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j75 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ l75 c;

        public a(l75 l75Var, j75 j75Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l75Var, j75Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l75Var;
            this.a = j75Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.i55
        public void B(h55 h55Var) {
            j75 j75Var;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) || (j75Var = this.a) == null || j75Var.a() == null || h55Var == null) {
                return;
            }
            int i = h55Var.a;
            if (i == 4) {
                this.a.e0(h55Var.c.toString());
                Object obj = h55Var.c;
                if (obj instanceof SpanGroupManager) {
                    this.a.j0((SpanGroupManager) obj);
                }
                this.c.d = false;
            } else if (i == 5) {
                if (this.b.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d37);
                this.c.d = true;
            } else if (i == 8) {
                if (!this.c.k(this.a.getContext(), 11001)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                } else {
                    this.a.G(null, null);
                }
            } else if (i == 10) {
                Object obj2 = h55Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.m0((VoiceData.VoiceModel) obj2);
                    this.a.w(true, null);
                }
            } else if (i == 11) {
                this.a.m0(null);
            } else if (i == 29) {
                this.a.a().A(new h55(2, 19, null));
                this.a.a().A(new h55(1, 2, null));
                this.a.j();
            } else if (i == 32) {
                this.a.a().A(new h55(1, 11, null));
            } else if (i == 36) {
                if (this.c.k(this.a.getContext(), 11040)) {
                    this.a.S();
                }
            } else if (i == 43) {
                if (hh5.c(this.a.getContext(), true, false)) {
                    return;
                }
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.c.a != null) {
                    hotSelectActivityConfig.setForumExtra(dh.g(this.c.a.getId(), 0L), this.c.a.getFirst_class(), this.c.a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            } else if (i != 67) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.v().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.c.c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.c.c);
                        }
                        if (this.c.a != null && !StringUtils.isNull(this.c.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (f75.a().b() == 1) {
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
                        int intValue = ((Integer) h55Var.c).intValue();
                        if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.c.d) {
                            this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d37);
                        }
                        if (this.c.k(this.a.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                            if (this.a.u() != null) {
                                atListActivityConfig.setSelectedAtList(this.a.u().w());
                            }
                            if (this.c.e != null) {
                                atListActivityConfig.setFromTid(this.c.e.C());
                                atListActivityConfig.setFromFid(this.c.e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.c.e != null) {
                                statisticItem.addParam("tid", this.c.e.C());
                                statisticItem.addParam("fid", this.c.e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                Object obj3 = h55Var.c;
                if (obj3 == null || !(obj3 instanceof Boolean)) {
                    return;
                }
                this.a.h0(((Boolean) obj3).booleanValue());
            }
        }
    }

    public l75() {
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
        this.b = null;
        this.c = null;
        this.d = false;
    }

    @Override // com.baidu.tieba.j55
    public l55 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            j75 j75Var = new j75(editorTools);
            j75Var.b0(this.e);
            return j75Var;
        }
        return (l55) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j55
    public void c(l55 l55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l55Var) == null) && (l55Var instanceof j75)) {
            EditorTools a2 = l55Var.a();
            a aVar = new a(this, (j75) l55Var, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(27, aVar);
            a2.setActionListener(29, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
            a2.setActionListener(67, aVar);
        }
    }

    @Override // com.baidu.tieba.j55
    public void d(l55 l55Var) {
        CustomResponsedMessage runTask;
        s55 s55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l55Var) == null) {
            EditorTools a2 = l55Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.d(new d65(a2.getContext(), 1));
            if (cp8.a() && im8.a(this.b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), s55.class)) != null && (s55Var = (s55) runTask.getData()) != null) {
                s55Var.l = 2;
                a2.d(s55Var);
            }
            u55 u55Var = new u55(a2.getContext(), 4);
            u55Var.i = false;
            a2.d(u55Var);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), s55.class);
            if (runTask2 != null && runTask2.getData() != null) {
                s55 s55Var2 = (s55) runTask2.getData();
                s55Var2.l = 6;
                a2.d(s55Var2);
            }
            a2.d(new k75(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), s55.class);
            if (runTask3 != null && runTask3.getData() != null) {
                s55 s55Var3 = (s55) runTask3.getData();
                s55Var3.l = 7;
                a2.d(s55Var3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.d(new b65(a2.getContext(), 5));
            }
            a2.h(arrayList);
            s55 n = a2.n(5);
            if (n != null) {
                n.l = 3;
            }
            a2.f();
        }
    }

    public final boolean k(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ForumData) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (DataModel) invokeV.objValue;
    }

    public void o(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.e = dataModel;
        }
    }
}
