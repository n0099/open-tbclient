package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.vj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class qj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public pj8 c;
    public oj8 d;
    public oj8 e;
    public oj8 f;
    public ViewTreeObserver.OnGlobalLayoutListener g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public int i;
    public String j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public km9 o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public ak5 r;
    public final NewWriteModel.d s;

    /* loaded from: classes7.dex */
    public class c implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        /* loaded from: classes7.dex */
        public class a implements s45.e {
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

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements s45.e {
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

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                    PayPanelUtils.launchPayPanel(this.a.a.a, IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public c(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) == null) {
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
                    if (this.a.d != null && (this.a.d.y() || this.a.d.A())) {
                        this.a.d.w(false, postWriteCallBackData);
                        this.a.k();
                    }
                    if (this.a.k.isFirstPost) {
                        this.a.o.k(postWriteCallBackData);
                    } else {
                        this.a.o.l(postWriteCallBackData);
                    }
                } else if (i == 238010) {
                    if (!di.isEmpty(str)) {
                        this.a.a.showToast(str);
                    } else {
                        this.a.a.showToast(R.string.message_privacy_fans_can_reply);
                    }
                    this.a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.a.getPageActivity(), this.a.a.getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    s45 s45Var = new s45(this.a.a.getPageActivity());
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        s45Var.setMessage(this.a.a.getString(R.string.open_member_and_add_more_links));
                    } else {
                        s45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new a(this));
                    s45Var.setPositiveButton(R.string.open_now, new b(this));
                    s45Var.create(this.a.a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (koa.d(i)) {
                    this.a.k();
                } else if (qd5Var != null || i == 227001) {
                } else {
                    this.a.t(i, str);
                    this.a.k();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        public a(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.j)) {
                BdUtilHelper.showToast(this.a.a.getPageActivity(), this.a.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ak5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        public b(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // com.baidu.tieba.ak5
        public boolean a() {
            InterceptResult invokeV;
            zwa g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.k == null) {
                    return false;
                }
                qj8 qj8Var = this.a;
                if (qj8Var.o != null) {
                    if (qj8Var.k.isFirstPost) {
                        g = this.a.o.e();
                    } else {
                        g = this.a.o.g();
                    }
                    if (g != null && g.d()) {
                        this.a.a.showToast(g.c());
                        if (this.a.d != null && (this.a.d.y() || this.a.d.A())) {
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
                if (this.a.p.showToastForPrivacy(this.a.i)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        public d(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    this.a.k();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
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
        public void onNavigationButtonClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements vj5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        public g(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // com.baidu.tieba.vj5.b
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

    /* loaded from: classes7.dex */
    public class h implements vj5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        public h(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // com.baidu.tieba.vj5.b
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

    /* loaded from: classes7.dex */
    public class i implements ai5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj8 a;

        public i(qj8 qj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj8Var;
        }

        @Override // com.baidu.tieba.ai5
        public void E(zh5 zh5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, zh5Var) == null) && this.a.k != null && this.a.d != null) {
                if (zh5Var.c instanceof String) {
                    this.a.d.f0((String) zh5Var.c);
                }
                this.a.d.O(String.valueOf(this.a.k.threadId));
            }
        }
    }

    public qj8(TbPageContext tbPageContext, LinearLayout linearLayout) {
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
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.a = tbPageContext;
        this.b = linearLayout;
        linearLayout.setOnTouchListener(new d(this));
        this.b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public void m(int i2) {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (oj8Var = this.d) != null) {
            oj8Var.a().z(i2);
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
            oj8 oj8Var = this.d;
            if (oj8Var != null) {
                if (i2 == 25035) {
                    j(i3, intent);
                    k();
                    return;
                }
                oj8Var.D(i2, i3, intent);
            }
        }
    }

    public final void j(int i2, Intent intent) {
        mi5 mi5Var;
        oj8 oj8Var;
        mi5 mi5Var2;
        oj8 oj8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, intent) == null) {
            if (i2 == 0 && (oj8Var2 = this.d) != null) {
                oj8Var2.a().t();
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
                if (editorType == 1 && (oj8Var = this.f) != null) {
                    oj8Var.C(writeData);
                    this.f.n0(pbEditorData.getVoiceModel());
                    li5 p = this.f.a().p(6);
                    if (p != null && (mi5Var2 = p.m) != null) {
                        mi5Var2.E(new zh5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.f.H(null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            oj8 oj8Var3 = this.e;
            if (oj8Var3 != null) {
                oj8Var3.M();
                this.e.n0(pbEditorData.getVoiceModel());
                this.e.C(writeData);
                li5 p2 = this.e.a().p(6);
                if (p2 != null && (mi5Var = p2.m) != null) {
                    mi5Var.E(new zh5(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.e.H(null, null);
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            oj8 oj8Var = this.d;
            if (oj8Var != null && oj8Var.a() != null) {
                this.d.a().q();
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
                vj5.c(this.a.getPageActivity(), this.g);
            }
            if (this.h != null) {
                vj5.c(this.a.getPageActivity(), this.h);
            }
            oj8 oj8Var = this.d;
            if (oj8Var != null) {
                oj8Var.E();
            }
        }
    }

    public void p() {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.k != null && (oj8Var = this.d) != null) {
            if (this.m) {
                this.m = false;
                return;
            }
            oj8Var.j();
            oj8 oj8Var2 = this.d;
            oj8Var2.q(this.k.threadId + "");
            this.d.a().t();
        }
    }

    public void o() {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.k != null && (oj8Var = this.d) != null) {
            oj8Var.O(this.k.threadId + "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c6 A[Catch: Exception -> 0x01cf, TRY_LEAVE, TryCatch #0 {Exception -> 0x01cf, blocks: (B:45:0x01be, B:47:0x01c6), top: B:85:0x01be }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, fj8 fj8Var) {
        boolean z;
        oj8 oj8Var;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        hi5 o;
        String str;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, fj8Var) == null) && imageUrlData != null && fj8Var != null) {
            if (this.c == null) {
                pj8 pj8Var = new pj8();
                this.c = pj8Var;
                pj8Var.k(imageUrlData.forumName, imageUrlData.forumId);
                this.c.l(String.valueOf(imageUrlData.threadId));
            }
            if (imageUrlData.isFirstPost && this.e == null) {
                pj8 pj8Var2 = this.c;
                pj8Var2.e = false;
                this.e = (oj8) pj8Var2.a(this.a.getPageActivity());
                this.g = vj5.b(this.a.getPageActivity(), this.e.a().b, new g(this));
            } else if (!imageUrlData.isFirstPost && this.f == null) {
                pj8 pj8Var3 = this.c;
                pj8Var3.e = true;
                this.f = (oj8) pj8Var3.a(this.a.getPageActivity());
                this.h = vj5.b(this.a.getPageActivity(), this.f.a().b, new h(this));
            } else {
                z = false;
                if (!imageUrlData.isFirstPost) {
                    oj8Var = this.e;
                } else {
                    oj8Var = this.f;
                }
                this.d = oj8Var;
                oj8Var.a().D(new zh5(70, -1, String.valueOf(String.valueOf(imageUrlData.threadId))));
                this.d.a().setActionListener(78, new i(this));
                jSONArray = null;
                if (z) {
                    this.d.X(this.a);
                    this.d.g0(this.s);
                    this.d.W(this.r);
                    this.d.B(this.a, null);
                    this.d.J(fj8Var.R, null);
                    this.d.a0(fj8Var.Q);
                    oj8 oj8Var2 = this.d;
                    oj8Var2.I = this.l;
                    MetaData metaData = fj8Var.O;
                    if (metaData == null) {
                        oj8Var2.m0(imageUrlData.threadId + "");
                    } else {
                        oj8Var2.K(metaData, imageUrlData.threadId + "", fj8Var.P);
                    }
                    this.d.a().a.setPadding(0, 0, 0, 0);
                    this.d.a().D(new zh5(45, 27, null));
                    this.d.a().z(this.n);
                }
                imageUrlData2 = this.k;
                if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                    if (this.k != null) {
                        oj8 oj8Var3 = this.d;
                        oj8Var3.O(this.k.threadId + "");
                    }
                    this.d.j();
                    this.d.M();
                    oj8 oj8Var4 = this.d;
                    oj8Var4.F = !imageUrlData.isFirstPost;
                    oj8Var4.G = imageUrlData.postId + "";
                    oj8 oj8Var5 = this.d;
                    oj8Var5.H = imageUrlData.userId;
                    if (!imageUrlData.isFirstPost && oj8Var5.a() != null) {
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
                        this.d.a().D(new zh5(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    this.i = fj8Var.N;
                    this.j = fj8Var.M;
                    if (this.d.a() != null && !StringUtils.isNull(this.j) && (o = this.d.a().o(6)) != null && !TextUtils.isEmpty(this.j)) {
                        ((View) o).setOnClickListener(this.q);
                    }
                    oj8 oj8Var6 = this.d;
                    oj8Var6.q(imageUrlData.threadId + "");
                }
                imageUrlData3 = this.k;
                if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                    if (this.d.a() != null) {
                        this.b.removeAllViews();
                        this.b.addView(this.d.a());
                    }
                    if (this.o == null) {
                        this.o = new km9();
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
            this.d = oj8Var;
            oj8Var.a().D(new zh5(70, -1, String.valueOf(String.valueOf(imageUrlData.threadId))));
            this.d.a().setActionListener(78, new i(this));
            jSONArray = null;
            if (z) {
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null) {
            }
            if (this.k != null) {
            }
            this.d.j();
            this.d.M();
            oj8 oj8Var42 = this.d;
            oj8Var42.F = !imageUrlData.isFirstPost;
            oj8Var42.G = imageUrlData.postId + "";
            oj8 oj8Var52 = this.d;
            oj8Var52.H = imageUrlData.userId;
            if (!imageUrlData.isFirstPost) {
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                }
                if (jSONArray != null) {
                }
                str = "";
                this.d.a().D(new zh5(45, 27, String.format(string2, imageUrlData.userNameShow, str)));
            }
            this.i = fj8Var.N;
            this.j = fj8Var.M;
            if (this.d.a() != null) {
                ((View) o).setOnClickListener(this.q);
            }
            oj8 oj8Var62 = this.d;
            oj8Var62.q(imageUrlData.threadId + "");
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

    public void u(ImageUrlData imageUrlData, fj8 fj8Var) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, imageUrlData, fj8Var) != null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || fj8Var == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(fj8Var.N)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.d == null) {
            q(imageUrlData, fj8Var);
        }
        oj8 oj8Var = this.d;
        if (oj8Var != null) {
            if (!oj8Var.y() && !this.d.A()) {
                this.b.setVisibility(0);
                if (this.d.a() != null) {
                    this.d.a().j();
                    this.d.a().t();
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
            s45 s45Var = new s45(tbPageContext.getPageActivity());
            s45Var.setMessage(str);
            s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b46, new f(this));
            s45Var.create(this.a).show();
        }
    }
}
