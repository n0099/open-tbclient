package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f05;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.vg5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class t09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public s09 c;
    public r09 d;
    public r09 e;
    public r09 f;
    public ViewTreeObserver.OnGlobalLayoutListener g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public int i;
    public String j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public q1a o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public ah5 r;
    public final NewWriteModel.d s;

    /* loaded from: classes8.dex */
    public class d implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        /* loaded from: classes8.dex */
        public class a implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    PayPanelUtils.launchPayPanel(this.a.a.a, IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public d(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
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
                    if (this.a.d != null && (this.a.d.B() || this.a.d.D())) {
                        this.a.d.z(false, postWriteCallBackData);
                        this.a.k();
                    }
                    if (this.a.k.isFirstPost) {
                        this.a.o.k(postWriteCallBackData);
                    } else {
                        this.a.o.l(postWriteCallBackData);
                    }
                } else if (i == 238010) {
                    if (!rd.isEmpty(str)) {
                        this.a.a.showToast(str);
                    } else {
                        this.a.a.showToast(R.string.message_privacy_fans_can_reply);
                    }
                    this.a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.a.getPageActivity(), this.a.a.getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    f05 f05Var = new f05(this.a.a.getPageActivity());
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        f05Var.setMessage(this.a.a.getString(R.string.open_member_and_add_more_links));
                    } else {
                        f05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new a(this));
                    f05Var.setPositiveButton(R.string.open_now, new b(this));
                    f05Var.create(this.a.a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (d5b.d(i)) {
                    this.a.k();
                } else if (o95Var != null || i == 227001) {
                } else {
                    this.a.t(i, str);
                    this.a.k();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ie5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public a(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // com.baidu.tieba.ie5
        public void U(he5 he5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, he5Var) == null) && this.a.k != null && this.a.d != null) {
                if (he5Var.c instanceof String) {
                    this.a.d.i0((String) he5Var.c);
                }
                this.a.d.R(String.valueOf(this.a.k.threadId));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public b(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.j)) {
                BdUtilHelper.showToast(this.a.a.getPageActivity(), this.a.j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ah5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public c(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // com.baidu.tieba.ah5
        public boolean a() {
            InterceptResult invokeV;
            odb g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.k == null) {
                    return false;
                }
                t09 t09Var = this.a;
                if (t09Var.o != null) {
                    if (t09Var.k.isFirstPost) {
                        g = this.a.o.e();
                    } else {
                        g = this.a.o.g();
                    }
                    if (g != null && g.d()) {
                        this.a.a.showToast(g.c());
                        if (this.a.d != null && (this.a.d.B() || this.a.d.D())) {
                            this.a.d.z(false, this.a.o.h());
                        }
                        if (this.a.k.isFirstPost) {
                            this.a.o.a(true);
                        } else {
                            this.a.o.b(true);
                        }
                        return true;
                    }
                }
                if (this.a.p.showToastForPrivacy(this.a.i)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public g(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements vg5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public h(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // com.baidu.tieba.vg5.b
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

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public i(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements vg5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t09 a;

        public j(t09 t09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t09Var;
        }

        @Override // com.baidu.tieba.vg5.b
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

    public t09(TbPageContext tbPageContext, LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = tbPageContext;
        this.b = linearLayout;
        linearLayout.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public void m(int i2) {
        r09 r09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (r09Var = this.d) != null) {
            r09Var.a().F(i2);
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.n = i2;
        }
    }

    public void l(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            this.m = true;
            r09 r09Var = this.d;
            if (r09Var != null) {
                if (i2 == 25035) {
                    j(i3, intent);
                    k();
                    return;
                }
                r09Var.G(i2, i3, intent);
            }
        }
    }

    public final void j(int i2, Intent intent) {
        ve5 ve5Var;
        r09 r09Var;
        ve5 ve5Var2;
        r09 r09Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, intent) == null) {
            if (i2 == 0 && (r09Var2 = this.d) != null) {
                r09Var2.a().y();
            } else {
                k();
            }
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && (r09Var = this.f) != null) {
                    r09Var.F(writeData);
                    this.f.q0(pbEditorData.getVoiceModel());
                    ue5 u = this.f.a().u(6);
                    if (u != null && (ve5Var2 = u.m) != null) {
                        ve5Var2.U(new he5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.f.K(null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            r09 r09Var3 = this.e;
            if (r09Var3 != null) {
                r09Var3.P();
                this.e.q0(pbEditorData.getVoiceModel());
                this.e.F(writeData);
                ue5 u2 = this.e.a().u(6);
                if (u2 != null && (ve5Var = u2.m) != null) {
                    ve5Var.U(new he5(52, 0, pbEditorData.getVoiceModel()));
                }
                ue5 u3 = this.e.a().u(41);
                if (u3 != null) {
                    u3.h();
                    DLauncher dLauncher = (DLauncher) this.e.a().t(41);
                    if (dLauncher != null) {
                        dLauncher.setIcon();
                    }
                }
                if (i2 == -1) {
                    if (StringUtils.isNotNull(pbEditorData.getMemeQuery()) || pbEditorData.getMemeId() != 0) {
                        this.e.P = true;
                        if (StringUtils.isNotNull(pbEditorData.getMemeQuery())) {
                            this.e.Q = pbEditorData.getMemeQuery();
                        }
                        if (pbEditorData.getMemeId() != 0) {
                            this.e.R = pbEditorData.getMemeId();
                        }
                    }
                    this.e.K(null, null);
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r09 r09Var = this.d;
            if (r09Var != null && r09Var.a() != null) {
                this.d.a().v();
            }
            BdUtilHelper.hideSoftKeyPad(this.a.getPageActivity(), this.b);
            this.b.setVisibility(8);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (this.g != null) {
                vg5.c(this.a.getPageActivity(), this.g);
            }
            if (this.h != null) {
                vg5.c(this.a.getPageActivity(), this.h);
            }
            r09 r09Var = this.d;
            if (r09Var != null) {
                r09Var.H();
            }
        }
    }

    public void p() {
        r09 r09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.k != null && (r09Var = this.d) != null) {
            if (this.m) {
                this.m = false;
                return;
            }
            r09Var.l();
            r09 r09Var2 = this.d;
            r09Var2.t(this.k.threadId + "");
            this.d.a().y();
        }
    }

    public void o() {
        r09 r09Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.k != null && (r09Var = this.d) != null) {
            r09Var.R(this.k.threadId + "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01de A[Catch: Exception -> 0x01e7, TRY_LEAVE, TryCatch #0 {Exception -> 0x01e7, blocks: (B:45:0x01d6, B:47:0x01de), top: B:85:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, h09 h09Var) {
        boolean z;
        r09 r09Var;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        qe5 t;
        String str;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, h09Var) == null) && imageUrlData != null && h09Var != null) {
            if (this.c == null) {
                s09 s09Var = new s09();
                this.c = s09Var;
                s09Var.k(imageUrlData.forumName, imageUrlData.forumId);
                this.c.l(String.valueOf(imageUrlData.threadId));
            }
            if (imageUrlData.isFirstPost && this.e == null) {
                s09 s09Var2 = this.c;
                s09Var2.e = false;
                r09 r09Var2 = (r09) s09Var2.a(this.a.getPageActivity());
                this.e = r09Var2;
                r09Var2.a().setOnCancelClickListener(new g(this));
                this.g = vg5.b(this.a.getPageActivity(), this.e.a().b, new h(this));
            } else if (!imageUrlData.isFirstPost && this.f == null) {
                s09 s09Var3 = this.c;
                s09Var3.e = true;
                r09 r09Var3 = (r09) s09Var3.a(this.a.getPageActivity());
                this.f = r09Var3;
                r09Var3.a().setOnCancelClickListener(new i(this));
                this.h = vg5.b(this.a.getPageActivity(), this.f.a().b, new j(this));
            } else {
                z = false;
                if (!imageUrlData.isFirstPost) {
                    r09Var = this.e;
                } else {
                    r09Var = this.f;
                }
                this.d = r09Var;
                r09Var.a().K(new he5(70, -1, String.valueOf(String.valueOf(imageUrlData.threadId))));
                this.d.a().setActionListener(78, new a(this));
                jSONArray = null;
                if (z) {
                    this.d.a0(this.a);
                    this.d.j0(this.s);
                    this.d.Z(this.r);
                    this.d.E(this.a, null);
                    this.d.M(h09Var.R, null);
                    this.d.d0(h09Var.Q);
                    r09 r09Var4 = this.d;
                    r09Var4.O = this.l;
                    MetaData metaData = h09Var.O;
                    if (metaData == null) {
                        r09Var4.p0(imageUrlData.threadId + "");
                    } else {
                        r09Var4.N(metaData, imageUrlData.threadId + "", h09Var.P);
                    }
                    this.d.a().a.setPadding(0, 0, 0, 0);
                    this.d.a().K(new he5(45, 27, null));
                    this.d.a().F(this.n);
                }
                imageUrlData2 = this.k;
                if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                    if (this.k != null) {
                        r09 r09Var5 = this.d;
                        r09Var5.R(this.k.threadId + "");
                    }
                    this.d.l();
                    this.d.P();
                    r09 r09Var6 = this.d;
                    r09Var6.L = !imageUrlData.isFirstPost;
                    r09Var6.M = imageUrlData.postId + "";
                    r09 r09Var7 = this.d;
                    r09Var7.N = imageUrlData.userId;
                    if (!imageUrlData.isFirstPost && r09Var7.a() != null) {
                        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                        try {
                            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                                jSONArray = new JSONArray(imageUrlData.richTextArray);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (jSONArray != null || jSONArray.length() <= 0) {
                            str = "";
                        } else {
                            str = TbRichTextView.Z(jSONArray, false).toString();
                        }
                        this.d.a().K(new he5(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    this.i = h09Var.N;
                    this.j = h09Var.M;
                    if (this.d.a() != null && !StringUtils.isNull(this.j) && (t = this.d.a().t(6)) != null && !TextUtils.isEmpty(this.j)) {
                        ((View) t).setOnClickListener(this.q);
                    }
                    r09 r09Var8 = this.d;
                    r09Var8.t(imageUrlData.threadId + "");
                }
                imageUrlData3 = this.k;
                if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                    if (this.d.a() != null) {
                        this.b.removeAllViews();
                        this.b.addView(this.d.a());
                    }
                    if (this.o == null) {
                        this.o = new q1a();
                    }
                    if (this.d.v() != null) {
                        this.o.m(this.d.v().k());
                    }
                }
                this.k = imageUrlData;
            }
            z = true;
            if (!imageUrlData.isFirstPost) {
            }
            this.d = r09Var;
            r09Var.a().K(new he5(70, -1, String.valueOf(String.valueOf(imageUrlData.threadId))));
            this.d.a().setActionListener(78, new a(this));
            jSONArray = null;
            if (z) {
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null) {
            }
            if (this.k != null) {
            }
            this.d.l();
            this.d.P();
            r09 r09Var62 = this.d;
            r09Var62.L = !imageUrlData.isFirstPost;
            r09Var62.M = imageUrlData.postId + "";
            r09 r09Var72 = this.d;
            r09Var72.N = imageUrlData.userId;
            if (!imageUrlData.isFirstPost) {
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                }
                if (jSONArray != null) {
                }
                str = "";
                this.d.a().K(new he5(45, 27, String.format(string2, imageUrlData.userNameShow, str)));
            }
            this.i = h09Var.N;
            this.j = h09Var.M;
            if (this.d.a() != null) {
                ((View) t).setOnClickListener(this.q);
            }
            r09 r09Var82 = this.d;
            r09Var82.t(imageUrlData.threadId + "");
            imageUrlData3 = this.k;
            if (imageUrlData3 != null) {
            }
            if (this.d.a() != null) {
            }
            if (this.o == null) {
            }
            if (this.d.v() != null) {
            }
            this.k = imageUrlData;
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                AntiHelper.w(this.a.getPageActivity(), str, i2, new e(this));
            } else if (i2 == 230277) {
                v(str);
            } else {
                this.a.showToast(str);
            }
        }
    }

    public void u(ImageUrlData imageUrlData, h09 h09Var) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, imageUrlData, h09Var) != null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || h09Var == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(h09Var.N)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.d == null) {
            q(imageUrlData, h09Var);
        }
        r09 r09Var = this.d;
        if (r09Var != null) {
            if (!r09Var.B() && !this.d.D()) {
                this.b.setVisibility(0);
                if (this.d.a() != null) {
                    this.d.a().m();
                    this.d.a().y();
                    return;
                }
                return;
            }
            this.d.z(false, null);
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
            f05 f05Var = new f05(tbPageContext.getPageActivity());
            f05Var.setMessage(str);
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b86, new f(this));
            f05Var.create(this.a).show();
        }
    }
}
