package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.nm8;
import com.baidu.tieba.nu4;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class n75 extends l55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public p75 c;
    public String d;
    public String e;
    public String f;
    public VoiceData.VoiceModel g;
    public NewWriteModel h;
    public SpanGroupManager i;
    public DataModel<?> j;
    public boolean k;
    public h75 l;
    public g75 m;
    public NewWriteModel.d n;
    public String o;
    public k75 p;
    public ThreadData q;
    public nm8.g r;
    public boolean s;
    public int t;
    public int u;
    public NewWriteModel.d v;
    public AntiHelper.k w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n75 a;

        public a(n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n75Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
                if (this.a.n != null) {
                    this.a.n.callback(z, postWriteCallBackData, y15Var, writeData, antiData);
                }
                if (z) {
                    this.a.c = null;
                    this.a.d = null;
                    this.a.L(true);
                    this.a.r();
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z && this.a.q != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                    statisticItem.param("tid", this.a.q.getId());
                    statisticItem.param("fid", this.a.q.getFid());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    oc5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.b.getPageActivity());
                    if (currentVisiblePageExtra != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    if (this.a.u != 0) {
                        if (this.a.u != 1) {
                            if (this.a.u != 2) {
                                if (this.a.u != 3) {
                                    if (this.a.u != 4) {
                                        if (this.a.u != 5) {
                                            if (this.a.u == 6) {
                                                statisticItem.param("obj_locate", 7);
                                            }
                                        } else {
                                            statisticItem.param("obj_locate", 1);
                                        }
                                    } else {
                                        statisticItem.param("obj_locate", 3);
                                    }
                                } else {
                                    statisticItem.param("obj_locate", 2);
                                }
                            } else {
                                statisticItem.param("obj_locate", 5);
                            }
                        } else {
                            statisticItem.param("obj_locate", 4);
                        }
                    } else {
                        statisticItem.param("obj_locate", 6);
                    }
                    if (this.a.q.isVideoThreadType()) {
                        String content = writeData != null ? writeData.getContent() : "";
                        if (ji5.d(content) > 40) {
                            content = ji5.n(content, 40);
                        }
                        statisticItem.param(TiebaStatic.Params.POST_CONTENT, content);
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (z && this.a.q != null) {
                    StatisticItem statisticItem2 = new StatisticItem("c14303");
                    statisticItem2.param("tid", this.a.q.getId());
                    statisticItem2.param("fid", this.a.q.getFid());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_type", 2);
                    if (this.a.u != 1) {
                        if (this.a.u != 2) {
                            if (this.a.u != 3) {
                                if (this.a.u == 4) {
                                    statisticItem2.param("obj_locate", 4);
                                }
                            } else {
                                statisticItem2.param("obj_locate", 3);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 2);
                        }
                    } else {
                        statisticItem2.param("obj_locate", 1);
                    }
                    TiebaStatic.log(statisticItem2);
                }
                if (z) {
                    WriteData S = this.a.h.S();
                    this.a.h.setWriteData(null);
                    this.a.h.Z(false);
                    this.a.g = null;
                    if (S == null || S == null || S.getType() != 2) {
                        return;
                    }
                    this.a.j.K();
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (y15Var == null || writeData == null || StringUtils.isNull(y15Var.c())) {
                        if (postWriteCallBackData != null && i == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else if (i == 238010 || hu8.d(i)) {
                            return;
                        } else {
                            this.a.getContext().showToast(str);
                            return;
                        }
                    }
                    writeData.setVcodeMD5(y15Var.b());
                    writeData.setVcodeUrl(y15Var.c());
                    writeData.setVcodeExtra(y15Var.a());
                    if (this.a.q != null) {
                        writeData.setBaijiahaoData(this.a.q.getBaijiahaoData());
                    }
                    if (vi5.b(y15Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, y15Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                    }
                } else {
                    this.a.f0(i, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements nm8.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n75 a;

        public c(n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n75Var;
        }

        @Override // com.baidu.tieba.nm8.g
        public void k(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.a.c == null) {
                        this.a.c = new p75();
                    }
                    this.a.c.a = writeData.getContent();
                    this.a.c.b = writeData.getSubPbReplyPrefix();
                    this.a.c.d = writeData.getPortrait();
                    this.a.c.e = writeData.getName();
                    n75 n75Var = this.a;
                    n75Var.M(n75Var.c);
                }
                if (this.a.r != null) {
                    this.a.r.k(writeData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n75 a;

        public d(n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.o)) {
                return;
            }
            ej.N(this.a.getContext().getPageActivity(), this.a.o);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n75(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.k = false;
        this.o = null;
        this.t = 0;
        this.u = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new d(this);
    }

    public void A(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.h = newWriteModel;
        newWriteModel.b0(this.v);
        nm8.q(this.j.B(), new c(this));
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void C(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.c == null) {
            this.c = new p75();
        }
        this.c.a = writeData.getContent();
        this.c.b = writeData.getSubPbReplyPrefix();
        this.c.d = writeData.getPortrait();
        this.c.e = writeData.getName();
        M(this.c);
    }

    public void D(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 != -1) {
                if (i2 == 0 && i == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.d dVar = this.n;
                    if (dVar != null) {
                        dVar.callback(false, postWriteCallBackData2, null, this.h.S(), null);
                    }
                }
            } else if (i == 12005) {
                if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                    return;
                }
                K(parcelableArrayListExtra);
            } else if (i != 12006) {
            } else {
                if (a() != null) {
                    a().o();
                }
                r();
                L(true);
                WriteData S = this.h.S();
                this.h.setWriteData(null);
                this.h.Z(false);
                if (S == null || S == null || S.getType() != 2) {
                    return;
                }
                this.j.K();
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            J();
            this.h.cancelLoadData();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void G() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.h.S() == null) {
                DataModel<?> dataModel = this.j;
                WriteData G = dataModel.G(dataModel.B());
                if (G != null && (threadData = this.q) != null) {
                    G.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.h.setWriteData(G);
            }
            if (this.h.S() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            this.h.setSpanGroupManager(this.i);
            if (this.c != null) {
                this.h.S().setContent(this.c.a);
                this.h.S().setSubPbReplyPrefix(this.c.b);
                this.h.S().setPortrait(this.c.d);
                this.h.S().setName(this.c.e);
                if (this.q != null) {
                    this.h.S().setBaijiahaoData(this.q.getBaijiahaoData());
                }
            }
            this.h.S().setReplyId(this.d);
            if (this.e != null) {
                this.h.S().setRepostId(this.j.B());
            }
            if (this.f != null) {
                this.h.S().setReSubPostId(this.f);
            }
            VoiceData.VoiceModel voiceModel = this.g;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.S().setVoice(this.g.getId());
                    this.h.S().setVoiceDuringTime(this.g.duration);
                } else {
                    this.h.S().setVoice(null);
                    this.h.S().setVoiceDuringTime(-1);
                }
            } else {
                this.h.S().setVoice(null);
                this.h.S().setVoiceDuringTime(-1);
            }
            if (!this.h.Q()) {
                getContext().showToast((int) R.string.obfuscated_res_0x7f0f15f4);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            g75 g75Var = this.m;
            if (g75Var != null && g75Var.a()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            h75 h75Var = this.l;
            if (h75Var != null) {
                h75Var.a();
            }
            t(this.h.S());
            s();
            if (!this.h.e0()) {
            }
        }
    }

    public void H(AntiData antiData) {
        o55 m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, antiData) == null) || antiData == null) {
            return;
        }
        String voice_message = antiData.getVoice_message();
        this.o = voice_message;
        if (StringUtils.isNull(voice_message) || a() == null || (m = a().m(6)) == null || TextUtils.isEmpty(this.o)) {
            return;
        }
        ((View) m).setOnClickListener(this.x);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h.setWriteData(null);
            this.h.Z(false);
            this.g = null;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            WriteData writeData = new WriteData(2);
            p75 p75Var = this.c;
            if (p75Var != null) {
                writeData.setContent(p75Var.a);
                writeData.setPortrait(this.c.d);
                writeData.setName(this.c.e);
                writeData.setSubPbReplyPrefix(this.c.b);
            }
            writeData.setReplyId(this.d);
            writeData.setThreadId(this.e);
            nm8.A(this.e, writeData);
        }
    }

    public final void K(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new h55(17, 27, arrayList));
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || a() == null) {
            return;
        }
        a().A(new h55(9, -1, Boolean.valueOf(z)));
    }

    public final void M(p75 p75Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, p75Var) == null) || a() == null) {
            return;
        }
        a().A(new h55(6, 27, p75Var));
    }

    public void N(g75 g75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, g75Var) == null) {
            this.m = g75Var;
        }
    }

    public void O(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.t = i;
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.u = i;
        }
    }

    public void R(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void S(nm8.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
            this.r = gVar;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.c == null) {
                this.c = new p75();
            }
            this.c.a = str;
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.e = str;
        }
    }

    public void V(h75 h75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, h75Var) == null) {
            this.l = h75Var;
        }
    }

    public void W(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100c).replace("%s", str);
        p75 p75Var = this.c;
        if (p75Var != null) {
            if (TextUtils.isEmpty(p75Var.b) && TextUtils.isEmpty(this.c.a)) {
                l0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.c.b) && this.c.b.equals(replace)) {
                h0(this.c);
                return;
            } else {
                l0(str, str2);
                return;
            }
        }
        l0(str, str2);
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.d = str;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.k = z;
        }
    }

    public void Z(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, spanGroupManager) == null) {
            this.i = spanGroupManager;
        }
    }

    public void a0(p75 p75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, p75Var) == null) {
            this.c = p75Var;
        }
    }

    public void b0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, dataModel) == null) {
            this.j = dataModel;
            if (dataModel != null) {
                this.e = dataModel.B();
            }
        }
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.f = str;
        }
    }

    public void d0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) {
            this.q = threadData;
            if (a() == null || this.q == null) {
                return;
            }
            a().setFid(this.q.getFid());
            a().setTid(this.q.getTid());
        }
    }

    public void e0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, voiceModel) == null) {
            this.g = voiceModel;
        }
    }

    public void f0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048607, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.b.getPageActivity(), str, i, this.w) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                getContext().showToast(str);
            } else {
                j0(str);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Y(true);
            a().k(false, false);
            a().x((View) a().m(5));
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.b : (TbPageContext) invokeV.objValue;
    }

    public final void h0(p75 p75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, p75Var) == null) {
            Y(true);
            a().j();
            M(p75Var);
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Y(true);
            a().j();
            a().x((View) a().m(2));
        }
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            nu4 nu4Var = new nu4(getContext().getPageActivity());
            nu4Var.setMessage(str);
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new e(this));
            nu4Var.create(getContext()).show();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Y(true);
            a().j();
        }
    }

    public void l0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, str2) == null) {
            Y(true);
            a().j();
            if (str != null && str.length() != 0) {
                String replace = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f100c).replace("%s", str);
                p75 p75Var = new p75();
                p75Var.b = replace;
                p75Var.d = str2;
                p75Var.e = str;
                M(p75Var);
            } else {
                p75 p75Var2 = new p75();
                p75Var2.a = "";
                M(p75Var2);
            }
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || StringUtils.isNull(str) || a() == null) {
            return;
        }
        a().A(new h55(45, 27, str));
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            nm8.A(this.e, null);
        }
    }

    public final void s() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.q == null || (dataModel = this.j) == null || !dataModel.I()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 2);
        if (this.q.isVideoWorksInfo()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.q.isVideoThreadType()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.q.getTid());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.q.getFid());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.j.z());
        statisticItem.addParam("order_id", this.j.E());
        TiebaStatic.log(statisticItem);
        vn4.a(vn4.f, vn4.c, this.j.E(), this.j.F(), this.j.D(), this.j.A());
    }

    public void t(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, writeData) == null) || writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.t > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.t);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i++;
            }
        }
        if (i <= 0 || this.t <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i);
        statisticItem2.param("obj_source", this.t);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public k75 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.p == null && a() != null) {
                this.p = (k75) a().n(27);
            }
            return this.p;
        }
        return (k75) invokeV.objValue;
    }

    public SpanGroupManager v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.i : (SpanGroupManager) invokeV.objValue;
    }

    public void w(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            p75 p75Var = this.c;
            if (p75Var != null) {
                pbEditorData.setContent(p75Var.a);
                pbEditorData.setSubPbReplyPrefix(this.c.b);
            }
            pbEditorData.setVoiceModel(this.g);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.b.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            p75 p75Var = this.c;
            return (p75Var == null || dj.isEmpty(p75Var.a)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.g;
            return (voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || this.g.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            c0(null);
            Y(false);
            a().o();
        }
    }
}
