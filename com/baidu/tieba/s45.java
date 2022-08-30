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
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class s45 extends p25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public String b;
    public String c;
    public boolean d;
    public DataModel<?> e;

    /* loaded from: classes5.dex */
    public class a implements o25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q45 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ s45 c;

        public a(s45 s45Var, q45 q45Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var, q45Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s45Var;
            this.a = q45Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.o25
        public void A(n25 n25Var) {
            q45 q45Var;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, n25Var) == null) || (q45Var = this.a) == null || q45Var.a() == null || n25Var == null) {
                return;
            }
            int i = n25Var.a;
            if (i == 4) {
                this.a.o0(n25Var.c.toString());
                Object obj = n25Var.c;
                if (obj instanceof SpanGroupManager) {
                    this.a.t0((SpanGroupManager) obj);
                }
                this.c.d = false;
            } else if (i == 5) {
                if (this.b.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d1d);
                this.c.d = true;
            } else if (i == 8) {
                if (!this.c.k(this.a.getContext(), 11001)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                } else {
                    this.a.M(null, null);
                }
            } else if (i == 10) {
                Object obj2 = n25Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.w0((VoiceData.VoiceModel) obj2);
                    this.a.z(true, null);
                }
            } else if (i == 11) {
                this.a.w0(null);
            } else if (i == 18) {
                boolean h = tu4.k().h("key_post_thread_has_request_location", false);
                if (n25Var.c != null) {
                    if (h) {
                        this.a.R();
                        return;
                    }
                    return;
                }
                int t = this.a.t();
                if (t == 0) {
                    this.a.J(h);
                } else if (t != 2) {
                } else {
                    this.a.A();
                }
            } else if (i == 20) {
                this.a.a().A(new n25(2, 7, null));
                gm8.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 29) {
                this.a.a().A(new n25(2, 19, null));
                this.a.a().A(new n25(1, 2, null));
                this.a.m();
            } else if (i == 32) {
                this.a.a().A(new n25(1, 11, null));
            } else if (i == 36) {
                if (this.c.k(this.a.getContext(), 11040)) {
                    this.a.a0();
                }
            } else if (i == 43) {
                if (pe5.c(this.a.getContext(), true, false)) {
                    return;
                }
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.c.a != null) {
                    hotSelectActivityConfig.setForumExtra(pg.g(this.c.a.getId(), 0L), this.c.a.getFirst_class(), this.c.a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            } else if (i != 67) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.c.c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.c.c);
                        }
                        if (this.c.a != null && !StringUtils.isNull(this.c.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (m45.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.a.y() != null) {
                                this.a.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.y() != null) {
                            this.a.y().setMaxImagesAllowed(9);
                        }
                        ri.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) n25Var.c).intValue();
                        if (this.a.y() != null && this.a.y().getChosedFiles() != null && (size = this.a.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.c.d) {
                            this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d1d);
                        }
                        if (this.c.k(this.a.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                            if (this.a.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.a.x().w());
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
                Object obj3 = n25Var.c;
                if (obj3 == null || !(obj3 instanceof Boolean)) {
                    return;
                }
                this.a.r0(((Boolean) obj3).booleanValue());
            }
        }
    }

    public s45() {
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

    @Override // com.baidu.tieba.p25
    public r25 b(Context context) {
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
            q45 q45Var = new q45(editorTools);
            q45Var.l0(this.e);
            return q45Var;
        }
        return (r25) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p25
    public void c(r25 r25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r25Var) == null) && (r25Var instanceof q45)) {
            EditorTools a2 = r25Var.a();
            a aVar = new a(this, (q45) r25Var, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
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

    @Override // com.baidu.tieba.p25
    public void d(r25 r25Var) {
        CustomResponsedMessage runTask;
        y25 y25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r25Var) == null) {
            EditorTools a2 = r25Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.d(new j35(a2.getContext(), 1));
            if (bn8.a() && hk8.a(this.b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), y25.class)) != null && (y25Var = (y25) runTask.getData()) != null) {
                y25Var.l = 2;
                a2.d(y25Var);
            }
            a35 a35Var = new a35(a2.getContext(), 4);
            a35Var.i = false;
            a2.d(a35Var);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), y25.class);
            if (runTask2 != null && runTask2.getData() != null) {
                y25 y25Var2 = (y25) runTask2.getData();
                y25Var2.l = 6;
                a2.d(y25Var2);
            }
            a2.d(new r45(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), y25.class);
            if (runTask3 != null && runTask3.getData() != null) {
                y25 y25Var3 = (y25) runTask3.getData();
                y25Var3.l = 7;
                a2.d(y25Var3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.d(new h35(a2.getContext(), 5));
            }
            a2.h(arrayList);
            y25 n = a2.n(5);
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
