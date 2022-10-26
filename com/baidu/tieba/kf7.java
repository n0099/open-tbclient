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
/* loaded from: classes4.dex */
public class kf7 extends n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes4.dex */
    public class a implements m55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jf7 a;
        public final /* synthetic */ kf7 b;

        public a(kf7 kf7Var, jf7 jf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kf7Var, jf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kf7Var;
            this.a = jf7Var;
        }

        @Override // com.baidu.tieba.m55
        public void B(l55 l55Var) {
            jf7 jf7Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l55Var) != null) || (jf7Var = this.a) == null || jf7Var.b() == null || l55Var == null) {
                return;
            }
            int i = l55Var.a;
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
                                                if (j75.a().b() == 1) {
                                                    albumFloatActivityConfig.setRequestFrom(2);
                                                    if (this.a.v() != null) {
                                                        this.a.v().setMaxImagesAllowed(1);
                                                    }
                                                } else if (this.a.v() != null) {
                                                    this.a.v().setMaxImagesAllowed(9);
                                                }
                                                fj.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                return;
                                            case 15:
                                                int intValue = ((Integer) l55Var.c).intValue();
                                                if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                                    return;
                                                }
                                                return;
                                            case 16:
                                                if (this.b.d) {
                                                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d48);
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
                                Object obj = l55Var.c;
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
                        fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d48);
                        this.b.d = true;
                        return;
                    } else if (!this.b.j(this.a.getContext(), 11040)) {
                        return;
                    } else {
                        this.a.S();
                        return;
                    }
                }
                this.a.b().A(new l55(1, 11, null));
                return;
            }
            this.a.e0(l55Var.c.toString());
            Object obj2 = l55Var.c;
            if (obj2 instanceof SpanGroupManager) {
                this.a.j0((SpanGroupManager) obj2);
            }
            this.b.d = false;
        }
    }

    public kf7() {
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

    @Override // com.baidu.tieba.n55
    public p55 b(Context context) {
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
            return new jf7(editorTools);
        }
        return (p55) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n55
    public void c(p55 p55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) != null) || !(p55Var instanceof jf7)) {
            return;
        }
        EditorTools b = p55Var.b();
        a aVar = new a(this, (jf7) p55Var);
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

    @Override // com.baidu.tieba.n55
    public void d(p55 p55Var) {
        int i;
        CustomResponsedMessage runTask;
        w55 w55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p55Var) == null) {
            EditorTools b = p55Var.b();
            if (jp8.a() && pm8.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage(2001448, b.getContext()), w55.class)) != null && (w55Var = (w55) runTask.getData()) != null) {
                w55Var.l = 2;
                b.d(w55Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            w55 n = b.n(5);
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
            y55 y55Var = new y55(b.getContext(), 4);
            y55Var.i = false;
            b.d(y55Var);
            if (!this.e) {
                b.d(new h65(b.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage(2001339, b.getContext()), w55.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    w55 w55Var2 = (w55) runTask2.getData();
                    w55Var2.l = 6;
                    b.d(w55Var2);
                }
                b.d(new o75(b.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage(2001342, b.getContext()), w55.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    w55 w55Var3 = (w55) runTask3.getData();
                    w55Var3.l = 7;
                    b.d(w55Var3);
                }
                b.d(new f65(b.getContext(), 5));
            } else {
                b.d(new o75(b.getContext(), false, false, 12004));
            }
            b.f();
        }
    }

    public final boolean j(TbPageContext tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (pa5.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
