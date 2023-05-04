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
public class v48 extends ld5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes6.dex */
    public class a implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;
        public final /* synthetic */ v48 b;

        public a(v48 v48Var, u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v48Var, u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v48Var;
            this.a = u48Var;
        }

        @Override // com.baidu.tieba.kd5
        public void C(jd5 jd5Var) {
            u48 u48Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jd5Var) != null) || (u48Var = this.a) == null || u48Var.b() == null || jd5Var == null) {
                return;
            }
            int i = jd5Var.a;
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
                                                if (hf5.a().b() == 1) {
                                                    albumFloatActivityConfig.setRequestFrom(2);
                                                    if (this.a.v() != null) {
                                                        this.a.v().setMaxImagesAllowed(1);
                                                    }
                                                } else if (this.a.v() != null) {
                                                    this.a.v().setMaxImagesAllowed(9);
                                                }
                                                ii.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                return;
                                            case 15:
                                                int intValue = ((Integer) jd5Var.c).intValue();
                                                if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                                    return;
                                                }
                                                return;
                                            case 16:
                                                if (this.b.d) {
                                                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
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
                                    this.a.m0(null);
                                    return;
                                }
                                Object obj = jd5Var.c;
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
                        ii.P(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        this.b.d = true;
                        return;
                    } else if (!this.b.j(this.a.getContext(), 11040)) {
                        return;
                    } else {
                        this.a.S();
                        return;
                    }
                }
                this.a.b().C(new jd5(1, 11, null));
                return;
            }
            this.a.e0(jd5Var.c.toString());
            Object obj2 = jd5Var.c;
            if (obj2 instanceof SpanGroupManager) {
                this.a.j0((SpanGroupManager) obj2);
            }
            this.b.d = false;
        }
    }

    public v48() {
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

    @Override // com.baidu.tieba.ld5
    public nd5 b(Context context) {
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
            editorTools.F(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            return new u48(editorTools);
        }
        return (nd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ld5
    public void c(nd5 nd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd5Var) != null) || !(nd5Var instanceof u48)) {
            return;
        }
        EditorTools b = nd5Var.b();
        a aVar = new a(this, (u48) nd5Var);
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

    @Override // com.baidu.tieba.ld5
    public void d(nd5 nd5Var) {
        int i;
        CustomResponsedMessage runTask;
        ud5 ud5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nd5Var) == null) {
            EditorTools b = nd5Var.b();
            if (jr9.a() && no9.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), ud5.class)) != null && (ud5Var = (ud5) runTask.getData()) != null) {
                ud5Var.l = 2;
                b.d(ud5Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            ud5 p = b.p(5);
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
            wd5 wd5Var = new wd5(b.getContext(), 4);
            wd5Var.i = false;
            b.d(wd5Var);
            if (!this.e) {
                b.d(new fe5(b.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), ud5.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    ud5 ud5Var2 = (ud5) runTask2.getData();
                    ud5Var2.l = 6;
                    b.d(ud5Var2);
                }
                b.d(new nf5(b.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), ud5.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    ud5 ud5Var3 = (ud5) runTask3.getData();
                    ud5Var3.l = 7;
                    b.d(ud5Var3);
                }
                b.d(new de5(b.getContext(), 5));
            } else {
                b.d(new nf5(b.getContext(), false, false, 12004));
            }
            b.f();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (tj5.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
