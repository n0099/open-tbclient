package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.au4;
import com.baidu.tieba.p65;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class oe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public ne7 c;
    public me7 d;
    public me7 e;
    public me7 f;
    public ViewTreeObserver.OnGlobalLayoutListener g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public int i;
    public String j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public cz7 o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public t65 r;
    public final NewWriteModel.d s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe7 a;

        public a(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.j)) {
                return;
            }
            ej.N(this.a.a.getPageActivity(), this.a.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements t65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe7 a;

        public b(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe7Var;
        }

        @Override // com.baidu.tieba.t65
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.k == null) {
                    return false;
                }
                oe7 oe7Var = this.a;
                if (oe7Var.o != null) {
                    a19 e = oe7Var.k.isFirstPost ? this.a.o.e() : this.a.o.g();
                    if (e != null && e.d()) {
                        this.a.a.showToast(e.c());
                        if (this.a.d != null && (this.a.d.x() || this.a.d.z())) {
                            this.a.d.w(false, this.a.o.h());
                        }
                        if (this.a.k.isFirstPost) {
                            this.a.o.a(true);
                        } else {
                            this.a.o.b(true);
                        }
                        return true;
                    }
                }
                return !this.a.p.showToastForPrivacy(this.a.i);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe7 a;

        /* loaded from: classes5.dex */
        public class a implements au4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements au4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
                    this.a.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.a.getPageActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public c(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l15 l15Var, WriteData writeData, AntiData antiData) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l15Var, writeData, antiData}) == null) {
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                    i = -1;
                }
                if (z) {
                    this.a.k();
                    if (this.a.a != null && (this.a.a.getPageActivity() instanceof BaseActivity)) {
                        ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                        showReplyInPbEvent.writeData = postWriteCallBackData;
                        showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                        ((BaseActivity) this.a.a.getPageActivity()).publishEvent(showReplyInPbEvent);
                    }
                    if (postWriteCallBackData != null) {
                        TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                    }
                } else if (i == 220015) {
                    this.a.a.showToast(str);
                    if (this.a.d != null && (this.a.d.x() || this.a.d.z())) {
                        this.a.d.w(false, postWriteCallBackData);
                        this.a.k();
                    }
                    if (this.a.k.isFirstPost) {
                        this.a.o.k(postWriteCallBackData);
                    } else {
                        this.a.o.l(postWriteCallBackData);
                    }
                } else if (i == 238010) {
                    if (!dj.isEmpty(str)) {
                        this.a.a.showToast(str);
                    } else {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0ae5);
                    }
                    this.a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (!dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    au4 au4Var = new au4(this.a.a.getPageActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        au4Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f0d11));
                    } else {
                        au4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                    au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b(this));
                    au4Var.create(this.a.a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (st8.d(i)) {
                    this.a.k();
                } else if (l15Var != null || i == 227001) {
                } else {
                    this.a.t(i, str);
                    this.a.k();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe7 a;

        public d(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 0) {
                    return true;
                }
                this.a.k();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
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
        public void onNavigationButtonClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements p65.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe7 a;

        public g(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe7Var;
        }

        @Override // com.baidu.tieba.p65.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.e.a().b.o();
                } else {
                    this.a.e.a().b.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements p65.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe7 a;

        public h(oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe7Var;
        }

        @Override // com.baidu.tieba.p65.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.f.a().b.o();
                } else {
                    this.a.f.a().b.setVisibility(0);
                }
            }
        }
    }

    public oe7(TbPageContext tbPageContext, LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.a = tbPageContext;
        this.b = linearLayout;
        linearLayout.setOnTouchListener(new d(this));
        this.b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i, Intent intent) {
        g55 g55Var;
        me7 me7Var;
        g55 g55Var2;
        me7 me7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, intent) == null) {
            if (i == 0 && (me7Var2 = this.d) != null) {
                me7Var2.a().q();
            } else {
                k();
            }
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                int editorType = pbEditorData.getEditorType();
                if (editorType != 0) {
                    if (editorType == 1 && (me7Var = this.f) != null) {
                        me7Var.B(writeData);
                        this.f.m0(pbEditorData.getVoiceModel());
                        f55 n = this.f.a().n(6);
                        if (n != null && (g55Var2 = n.m) != null) {
                            g55Var2.B(new u45(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.f.G(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                me7 me7Var3 = this.e;
                if (me7Var3 != null) {
                    me7Var3.L();
                    this.e.m0(pbEditorData.getVoiceModel());
                    this.e.B(writeData);
                    f55 n2 = this.e.a().n(6);
                    if (n2 != null && (g55Var = n2.m) != null) {
                        g55Var.B(new u45(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i == -1) {
                        this.e.G(null, null);
                    }
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            me7 me7Var = this.d;
            if (me7Var != null && me7Var.a() != null) {
                this.d.a().o();
            }
            ej.x(this.a.getPageActivity(), this.b);
            this.b.setVisibility(8);
        }
    }

    public void l(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            this.m = true;
            me7 me7Var = this.d;
            if (me7Var != null) {
                if (i == 25035) {
                    j(i2, intent);
                    k();
                    return;
                }
                me7Var.C(i, i2, intent);
            }
        }
    }

    public void m(int i) {
        me7 me7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (me7Var = this.d) == null) {
            return;
        }
        me7Var.a().w(i);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (this.g != null) {
                p65.c(this.a.getPageActivity(), this.g);
            }
            if (this.h != null) {
                p65.c(this.a.getPageActivity(), this.h);
            }
        }
    }

    public void o() {
        me7 me7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k == null || (me7Var = this.d) == null) {
            return;
        }
        me7Var.N(this.k.threadId + "");
    }

    public void p() {
        me7 me7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k == null || (me7Var = this.d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        me7Var.i();
        me7 me7Var2 = this.d;
        me7Var2.q(this.k.threadId + "");
        this.d.a().q();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019b A[Catch: Exception -> 0x01a4, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a4, blocks: (B:45:0x0193, B:47:0x019b), top: B:85:0x0193 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, fe7 fe7Var) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        b55 m;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, fe7Var) == null) || imageUrlData == null || fe7Var == null) {
            return;
        }
        if (this.c == null) {
            ne7 ne7Var = new ne7();
            this.c = ne7Var;
            ne7Var.k(imageUrlData.forumName, imageUrlData.forumId);
            this.c.l(String.valueOf(imageUrlData.threadId));
        }
        if (imageUrlData.isFirstPost && this.e == null) {
            ne7 ne7Var2 = this.c;
            ne7Var2.e = false;
            this.e = (me7) ne7Var2.a(this.a.getPageActivity());
            this.g = p65.b(this.a.getPageActivity(), this.e.a().b, new g(this));
        } else if (!imageUrlData.isFirstPost && this.f == null) {
            ne7 ne7Var3 = this.c;
            ne7Var3.e = true;
            this.f = (me7) ne7Var3.a(this.a.getPageActivity());
            this.h = p65.b(this.a.getPageActivity(), this.f.a().b, new h(this));
        } else {
            z = false;
            me7 me7Var = !imageUrlData.isFirstPost ? this.e : this.f;
            this.d = me7Var;
            jSONArray = null;
            if (z) {
                me7Var.W(this.a);
                this.d.f0(this.s);
                this.d.V(this.r);
                this.d.A(this.a, null);
                this.d.I(fe7Var.P, null);
                this.d.Z(fe7Var.O);
                me7 me7Var2 = this.d;
                me7Var2.I = this.l;
                MetaData metaData = fe7Var.M;
                if (metaData == null) {
                    me7Var2.l0(imageUrlData.threadId + "");
                } else {
                    me7Var2.J(metaData, imageUrlData.threadId + "", fe7Var.N);
                }
                this.d.a().a.setPadding(0, 0, 0, 0);
                this.d.a().A(new u45(45, 27, null));
                this.d.a().w(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    me7 me7Var3 = this.d;
                    me7Var3.N(this.k.threadId + "");
                }
                this.d.i();
                this.d.L();
                me7 me7Var4 = this.d;
                me7Var4.F = !imageUrlData.isFirstPost;
                me7Var4.G = imageUrlData.postId + "";
                me7 me7Var5 = this.d;
                me7Var5.H = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && me7Var5.a() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100c);
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.d.a().A(new u45(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.U(jSONArray, false).toString())));
                }
                this.i = fe7Var.L;
                this.j = fe7Var.K;
                if (this.d.a() != null && !StringUtils.isNull(this.j) && (m = this.d.a().m(6)) != null && !TextUtils.isEmpty(this.j)) {
                    ((View) m).setOnClickListener(this.q);
                }
                me7 me7Var6 = this.d;
                me7Var6.q(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.d.a() != null) {
                    this.b.removeAllViews();
                    this.b.addView(this.d.a());
                }
                if (this.o == null) {
                    this.o = new cz7();
                }
                if (this.d.s() != null) {
                    this.o.m(this.d.s().i());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.d = me7Var;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.d.i();
        this.d.L();
        me7 me7Var42 = this.d;
        me7Var42.F = !imageUrlData.isFirstPost;
        me7Var42.G = imageUrlData.postId + "";
        me7 me7Var52 = this.d;
        me7Var52.H = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100c);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.d.a().A(new u45(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.U(jSONArray, false).toString())));
        }
        this.i = fe7Var.L;
        this.j = fe7Var.K;
        if (this.d.a() != null) {
            ((View) m).setOnClickListener(this.q);
        }
        me7 me7Var62 = this.d;
        me7Var62.q(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.d.s() != null) {
        }
        this.k = imageUrlData;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.n = i;
        }
    }

    public final void t(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                AntiHelper.w(this.a.getPageActivity(), str, i, new e(this));
            } else if (i == 230277) {
                v(str);
            } else {
                this.a.showToast(str);
            }
        }
    }

    public void u(ImageUrlData imageUrlData, fe7 fe7Var) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, imageUrlData, fe7Var) == null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || fe7Var == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(fe7Var.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.d == null) {
            q(imageUrlData, fe7Var);
        }
        me7 me7Var = this.d;
        if (me7Var != null) {
            if (!me7Var.x() && !this.d.z()) {
                this.b.setVisibility(0);
                if (this.d.a() != null) {
                    this.d.a().j();
                    this.d.a().q();
                    return;
                }
                return;
            }
            this.d.w(false, null);
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return;
            }
            au4 au4Var = new au4(tbPageContext.getPageActivity());
            au4Var.setMessage(str);
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new f(this));
            au4Var.create(this.a).show();
        }
    }
}
