package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.el5;
import com.baidu.tieba.gs4;
import com.baidu.tieba.hl5;
import com.baidu.tieba.n55;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.vr4;
import com.baidu.tieba.xr4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes5.dex */
public class m18 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public an A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public ou4 J;
    public xk8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public gs4.e N;
    public boolean O;
    public final xr4.c P;
    public AbsVideoPbFragment a;
    public es4 b;
    public gs4 c;
    public es4 d;
    public vr4 e;
    public Dialog f;
    public Dialog g;
    public zr4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public es4 q;
    public vu4 r;
    public xr4 s;
    public AlertDialog t;
    public ax7 u;
    public el5 v;
    public hl5 w;
    public tz7 x;
    public PbFragment.h3 y;
    public xx7 z;

    /* loaded from: classes5.dex */
    public class a implements xr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public a(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.xr4.c
        public void a(xr4 xr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, xr4Var, i, view2) == null) {
                if (xr4Var != null) {
                    xr4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        n55.a aVar = new n55.a();
                        aVar.a = this.a.B;
                        String str = "";
                        if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.C.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.F == null) {
                        this.a.F = new PermissionJudgePolicy();
                    }
                    this.a.F.clearRequestPermissionList();
                    this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.z == null) {
                        m18 m18Var = this.a;
                        m18Var.z = new xx7(m18Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements gs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ m18 e;

        public a0(m18 m18Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m18Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.gs4.e
        public void i0(gs4 gs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, gs4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fec), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092043);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092045);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092044);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092041));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public b(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                this.a.a.y3(vr4Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public b0(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                TiebaStatic.log("c10025");
                vr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ m18 c;

        public d(m18 m18Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m18Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!pi.A()) {
                    ri.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c40);
                } else {
                    this.c.a.x3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(m18 m18Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ m18 c;

        public f(m18 m18Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m18Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!pi.A()) {
                    ri.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c40);
                } else {
                    this.c.a.x3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(m18 m18Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements el5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr4 a;
        public final /* synthetic */ m18 b;

        public h(m18 m18Var, vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, vr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m18Var;
            this.a = vr4Var;
        }

        @Override // com.baidu.tieba.el5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.y3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements hl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ m18 b;

        public i(m18 m18Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m18Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.hl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.x3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements gs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ m18 b;

        public j(m18 m18Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m18Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.gs4.e
        public void i0(gs4 gs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, gs4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09200a), sparseArray.get(R.id.obfuscated_res_0x7f091ff7), sparseArray.get(R.id.obfuscated_res_0x7f091ffa), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff9)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092042), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment == null || absVideoPbFragment.K3() == null) {
                            return;
                        }
                        this.b.a.K3().m2(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public k(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            ug.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class l implements xr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public l(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.xr4.c
        public void a(xr4 xr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, xr4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    m18 m18Var = this.a;
                    m18Var.H = m18Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new vv7(this.a.a.K().m2(), this.a.H, "1").start();
                    xr4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    m18 m18Var2 = this.a;
                    m18Var2.H = m18Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new vv7(this.a.a.K().m2(), this.a.H, "2").start();
                    xr4Var.e();
                } else if (i == 2) {
                    m18 m18Var3 = this.a;
                    m18Var3.H = m18Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    xr4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements gs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ m18 c;

        public m(m18 m18Var, es4 es4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, es4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m18Var;
            this.a = es4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.K().j2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.gs4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i0(gs4 gs4Var, int i, View view2) {
            boolean L3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, gs4Var, i, view2) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.c.a.K().j2() != 1 || i != 1) {
                if (this.c.a.K().j2() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.c.a.K().j2() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091845 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.K().S1().f != null && this.c.a.K().S1().f.size() > i) {
                    i = this.c.a.K().S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.K().L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                if (L3) {
                    return;
                }
                this.c.a.l5(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091845 ? 1 : 0).param("obj_type", i2));
            if (this.c.a.K().S1().f != null) {
                i = this.c.a.K().S1().f.get(i).sort_type.intValue();
            }
            L3 = this.c.a.K().L3(i);
            this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
            if (L3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(m18 m18Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = metaData;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ m18 b;

        public o(m18 m18Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m18Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                vr4Var.dismiss();
                if (this.b.a.H3() != null) {
                    this.b.a.H3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.K().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ m18 b;

        public q(m18 m18Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m18Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements gs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr4.c a;
        public final /* synthetic */ m18 b;

        public s(m18 m18Var, xr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m18Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.gs4.e
        public void i0(gs4 gs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, gs4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public t(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.n = (String) compoundButton.getTag();
                if (this.a.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.n != null && !str.equals(this.a.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public u(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.E(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public v(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                ug.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public w(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!pi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.K().S1().l().getId(), this.a.a.K().S1().l().getName(), this.a.a.K().S1().O().getId(), String.valueOf(this.a.a.K().S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements gs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m18 a;

        public x(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m18Var;
        }

        @Override // com.baidu.tieba.gs4.e
        public void i0(gs4 gs4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, gs4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.N0(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                    this.a.n0(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b8);
                    this.a.n0(view4);
                    if (view4 != null) {
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917bb);
                    AgreeView agreeView = (AgreeView) view5;
                    this.a.n0(view5);
                    if (agreeView == null || agreeView.getImgDisagree() == null) {
                        return;
                    }
                    agreeView.getImgDisagree().performClick();
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917bb);
                    this.a.n0(view6);
                    AgreeView agreeView2 = (AgreeView) view6;
                    if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                        return;
                    }
                    agreeView2.getImgAgree().performClick();
                } else if (i != 13) {
                    int i2 = 4;
                    switch (i) {
                        case 1:
                            if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                                return;
                            }
                            if (this.a.C == null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                            } else {
                                n55.a aVar = new n55.a();
                                aVar.a = this.a.B;
                                String str = "";
                                if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.C.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 2:
                            if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                                return;
                            }
                            if (this.a.F == null) {
                                this.a.F = new PermissionJudgePolicy();
                            }
                            this.a.F.clearRequestPermissionList();
                            this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.z == null) {
                                m18 m18Var = this.a;
                                m18Var.z = new xx7(m18Var.a.getPageContext());
                            }
                            this.a.z.b(this.a.B, this.a.A.n());
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 3:
                            PostData postData = this.a.G;
                            if (postData != null) {
                                postData.B0();
                                this.a.G = null;
                                return;
                            }
                            return;
                        case 4:
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            if (this.a.a.checkUpIsLogin()) {
                                this.a.d0(view2);
                                if (this.a.a.K().S1().O() == null || this.a.a.K().S1().O().getAuthor() == null || this.a.a.K().S1().O().getAuthor().getUserId() == null || this.a.a.U3() == null) {
                                    return;
                                }
                                m18 m18Var2 = this.a;
                                int S = m18Var2.S(m18Var2.a.K().S1());
                                ThreadData O = this.a.a.K().S1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.K().m2()).param("obj_locate", 2).param("obj_id", this.a.a.K().S1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.U3().e()).param("obj_source", S).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!pi.z()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                return;
                            }
                            Object tag = view2.getTag();
                            if (tag instanceof String) {
                                TiebaStatic.log(new StatisticItem("c13079"));
                                this.a.U((String) tag);
                                return;
                            } else if (tag instanceof SparseArray) {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092046)).booleanValue()) {
                                    sparseArray2.put(R.id.obfuscated_res_0x7f091ffd, 0);
                                    sparseArray2.put(R.id.obfuscated_res_0x7f091fe6, 2);
                                    this.a.B(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091fee) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091fec) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09200a) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091fed)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09200a)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ffe)).booleanValue();
                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                if (absVideoPbFragment == null || absVideoPbFragment.P() == null) {
                                    return;
                                }
                                boolean E = this.a.a.P().E(TbadkCoreApplication.getCurrentAccount());
                                if (E) {
                                    if (!booleanValue2) {
                                        this.a.u0(sparseArray3, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091fec), intValue, booleanValue, null, E);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.u0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091fec), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!pi.z()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c41);
                                return;
                            }
                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092032)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092030)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092046)).booleanValue();
                            boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092002)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (booleanValue5) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091ffd, 1);
                                sparseArray4.put(R.id.obfuscated_res_0x7f091fe6, 2);
                                this.a.B(sparseArray4);
                                return;
                            } else {
                                if (booleanValue6) {
                                    sparseArray4.put(R.id.obfuscated_res_0x7f091fe6, 2);
                                }
                                sparseArray4.put(R.id.obfuscated_res_0x7f09200b, Boolean.TRUE);
                                this.a.l0(view2);
                                return;
                            }
                        case 8:
                            if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                                if (postData2.q() == null) {
                                    return;
                                }
                                t95 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                if (findPageExtraByView != null) {
                                    postData2.q().objSource = findPageExtraByView.a();
                                }
                                this.a.C(postData2.q());
                                return;
                            }
                            return;
                        case 9:
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                            if (absVideoPbFragment2 == null || absVideoPbFragment2.K() == null || this.a.a.K().S1() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.P() == null) {
                                return;
                            }
                            this.a.a.P().o1(bs8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else {
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                    if (absVideoPbFragment3 == null || absVideoPbFragment3.K3() == null) {
                        return;
                    }
                    this.a.a.K3().m2(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ m18 d;

        public y(m18 m18Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = m18Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                if (vr4Var != null) {
                    vr4Var.dismiss();
                }
                this.d.a.z3(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fec), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                vr4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947919925, "Lcom/baidu/tieba/m18;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947919925, "Lcom/baidu/tieba/m18;");
        }
    }

    public m18(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.G = null;
        this.L = UbsABTestHelper.showTrisectionAndFeedback();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        tz7 tz7Var = new tz7(this.a.getContext());
        this.x = tz7Var;
        tz7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || !this.a.K().k2()) {
                return false;
            }
            return this.a.K().Q1() == null || this.a.K().Q1().c() != 0;
        }
        return invokeV.booleanValue;
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            C0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = pg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = pg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092042), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) || metaData == null) {
            return;
        }
        vr4 vr4Var = new vr4(this.a.getActivity());
        vr4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a96));
        vr4Var.setTitleShowCenter(true);
        vr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a97));
        vr4Var.setMessageShowCenter(true);
        vr4Var.setCancelable(false);
        vr4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a98), new n(this, metaData));
        vr4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a99), new o(this, metaData));
        vr4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new ou4();
        }
        if (this.K == null) {
            xk8 xk8Var = new xk8();
            this.K = xk8Var;
            xk8Var.a = this.a.getUniqueId();
        }
        mo4 mo4Var = new mo4();
        mo4Var.b = 5;
        mo4Var.h = 8;
        mo4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null) {
            mo4Var.f = this.a.K().R1();
        }
        mo4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                mo4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                    return;
                }
                this.J.b(this.a.P(), mo4Var, agreeData, this.a.K().S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            mo4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            mo4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.r == null) {
                this.r = new vu4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ri.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray<Object> sparseArray, int i2, gl5 gl5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), gl5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new hl5(this.a.getPageContext(), this.a.getView(), gl5Var, userData);
        }
        this.w.C(z2);
        AntiData L = L();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        dq4 dq4Var = new dq4();
        dq4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3), this.a.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.w.D(dq4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<cs4> c2;
        cs4 cs4Var;
        cs4 cs4Var2;
        cs4 cs4Var3;
        cs4 cs4Var4;
        cs4 cs4Var5;
        cs4 cs4Var6;
        an anVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || !absVideoPbFragment.isAdded()) {
                return true;
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.A = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.B = url;
                        if (this.A == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092026) != null && (view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                        } else {
                            this.C = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.A = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.B = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092026) != null && (view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                        } else {
                            this.C = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.A = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.B = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092026) != null && (view2.getTag(R.id.obfuscated_res_0x7f092026) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092026);
                            } else {
                                this.C = null;
                            }
                        }
                    }
                    if (view2.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view2.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        G0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
            this.G = postData;
            if (postData == null || this.a.U3() == null) {
                return true;
            }
            boolean z5 = this.a.U3().e() && this.G.K() != null && this.G.K().equals(this.a.K().N1());
            boolean z6 = this.a.K().S1() != null && this.a.K().S1().i0();
            if (this.c == null) {
                gs4 gs4Var = new gs4(this.a.getContext());
                this.c = gs4Var;
                gs4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (anVar = this.A) == null || anVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092003) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092003)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ffa) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ffa) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092002)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f09200b) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09200b)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new cs4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1091), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new cs4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1092), this.c));
            }
            if (!z7 && !z8) {
                cs4 cs4Var7 = new cs4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f044e), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fea, this.G);
                cs4Var7.d.setTag(sparseArray3);
                arrayList.add(cs4Var7);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    cs4Var6 = new cs4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fd5), this.c);
                } else {
                    cs4Var6 = new cs4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a94), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091fea, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f092003, Boolean.FALSE);
                cs4Var6.d.setTag(sparseArray4);
                arrayList.add(cs4Var6);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    cs4 cs4Var8 = new cs4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b37), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                    cs4Var8.d.setTag(sparseArray5);
                    arrayList.add(cs4Var8);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        cs4 cs4Var9 = new cs4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffa), this.c);
                        cs4Var9.d.setTag(str);
                        arrayList.add(cs4Var9);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ffa, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                        if (z4) {
                            cs4Var5 = new cs4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ac), this.c);
                            cs4Var5.d.setTag(sparseArray6);
                            cs4Var2 = new cs4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e4), this.c);
                            cs4Var2.d.setTag(sparseArray6);
                            cs4Var3 = cs4Var5;
                            cs4Var = null;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                    }
                    cs4Var5 = null;
                    cs4Var2 = new cs4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e4), this.c);
                    cs4Var2.d.setTag(sparseArray6);
                    cs4Var3 = cs4Var5;
                    cs4Var = null;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                    if (this.a.K().S1().W() == 1002 && !booleanValue2) {
                        cs4Var4 = new cs4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffa), this.c);
                    } else {
                        cs4Var4 = new cs4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ac), this.c);
                    }
                    cs4Var4.d.setTag(sparseArray7);
                    if (booleanValue8) {
                        cs4Var = new cs4(13, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b27), this.c);
                        cs4Var3 = cs4Var4;
                    } else {
                        cs4Var3 = cs4Var4;
                        cs4Var = null;
                    }
                    cs4Var2 = null;
                } else {
                    cs4Var = null;
                    cs4Var2 = null;
                    cs4Var3 = null;
                }
                if (cs4Var3 != null) {
                    arrayList.add(cs4Var3);
                }
                if (cs4Var != null) {
                    arrayList.add(cs4Var);
                }
                if (cs4Var2 != null) {
                    arrayList.add(cs4Var2);
                }
                kz7.b(arrayList, this.c, this.G, this.a.K());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = kz7.d(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                c2 = kz7.c(arrayList, this.G.q(), sparseArray, this.c);
            }
            kz7.l(c2, this.O);
            kz7.f(c2);
            this.c.o(kz7.g(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(c2, false);
            } else {
                this.c.k(c2, true);
            }
            es4 es4Var = new es4(this.a.getPageContext(), this.c);
            this.b = es4Var;
            es4Var.k();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.K().m2()).param("fid", this.a.K().getForumId()).param("uid", this.a.K().S1().O().getAuthor().getUserId()).param("post_id", this.a.K().B()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            vr4 vr4Var = new vr4(this.a.getPageContext().getPageActivity());
            vr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b36));
            vr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf9, new b0(this));
            vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new c0(this));
            vr4Var.create(this.a.getPageContext()).show();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.h4();
            es4 es4Var = this.b;
            if (es4Var != null) {
                es4Var.dismiss();
            }
            this.a.i4();
            K();
        }
    }

    public void F0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092042) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer)) {
            es4 es4Var = this.b;
            if (es4Var != null && es4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092040);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092042);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue()) {
                gs4 gs4Var = new gs4(this.a.getBaseFragmentActivity());
                gs4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe6)).intValue() : -1) == 1) {
                    arrayList.add(new cs4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04ac), gs4Var));
                }
                if (z2) {
                    arrayList.add(new cs4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f149c), gs4Var));
                } else {
                    arrayList.add(new cs4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b33), gs4Var));
                }
                gs4Var.j(arrayList);
                es4 es4Var2 = new es4(this.a.getPageContext(), gs4Var);
                this.b = es4Var2;
                es4Var2.k();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.h4();
            es4 es4Var = this.b;
            if (es4Var != null) {
                es4Var.dismiss();
            }
            K();
        }
    }

    public void G0(xr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            es4 es4Var = this.d;
            if (es4Var != null) {
                es4Var.dismiss();
                this.d = null;
            }
            gs4 gs4Var = new gs4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.K().S1() != null && this.a.K().S1().O() != null && !this.a.K().S1().O().isBjh()) {
                arrayList.add(new cs4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1091), gs4Var));
            }
            if (!z2) {
                arrayList.add(new cs4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1092), gs4Var));
            }
            gs4Var.j(arrayList);
            gs4Var.n(new s(this, cVar));
            es4 es4Var2 = new es4(this.a.getPageContext(), gs4Var);
            this.d = es4Var2;
            es4Var2.k();
        }
    }

    public void H() {
        es4 es4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (es4Var = this.b) == null) {
            return;
        }
        es4Var.dismiss();
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            zr4 zr4Var = this.h;
            if (zr4Var != null) {
                zr4Var.d();
                this.h = null;
            }
            if (this.a.K() == null) {
                return;
            }
            ArrayList<is4> arrayList = new ArrayList<>();
            arrayList.add(new is4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0271), "", this.a.K().b2() == 1, Integer.toString(1)));
            arrayList.add(new is4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b43), "", this.a.K().b2() == 2, Integer.toString(5)));
            arrayList.add(new is4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b40), "", this.a.K().b2() == 3, Integer.toString(6)));
            arrayList.add(new is4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b5e), "", this.a.K().b2() == 4, Integer.toString(7)));
            zr4 zr4Var2 = new zr4(this.a.getPageContext());
            zr4Var2.l(R.string.obfuscated_res_0x7f0f0de9);
            this.h = zr4Var2;
            zr4Var2.k(arrayList, onItemClickListener);
            zr4Var2.c();
            this.h.n();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            sg.a().postDelayed(this.I, 100L);
        }
    }

    public void I0(bx7 bx7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, bx7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new ax7(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        ug.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = ri.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f6);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        this.u.Q(bx7Var == null ? false : bx7Var.a);
        this.u.D(bx7Var == null ? false : bx7Var.n);
        this.u.F(bx7Var == null ? false : bx7Var.e);
        this.u.L(bx7Var == null ? false : bx7Var.i);
        this.u.G(bx7Var == null ? false : bx7Var.f);
        this.u.S(bx7Var != null ? bx7Var.c : true);
        this.u.P(bx7Var == null ? false : bx7Var.k);
        this.u.H(bx7Var == null ? false : bx7Var.l, bx7Var.t);
        if (bx7Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(bx7Var.g, bx7Var.s);
            this.u.M(bx7Var.h, bx7Var.r);
        }
        boolean z2 = bx7Var == null ? false : bx7Var.q;
        boolean z3 = bx7Var == null ? false : bx7Var.o;
        boolean z4 = bx7Var == null ? false : bx7Var.d;
        boolean z5 = bx7Var == null ? false : bx7Var.b;
        boolean z6 = bx7Var == null ? false : bx7Var.p;
        boolean z7 = bx7Var == null ? false : bx7Var.j;
        boolean z8 = bx7Var == null ? false : bx7Var.m;
        this.u.J(z4, z3);
        this.u.R(z5, z2);
        this.u.O(z7, z6);
        this.u.U(z8);
        if (bx7Var != null) {
            ax7 ax7Var = this.u;
            boolean z9 = bx7Var.u;
            ax7Var.w = z9;
            if (z9) {
                ax7Var.m().setText(R.string.obfuscated_res_0x7f0f0ffa);
                this.u.G(false);
            }
        }
        this.u.E(bx7Var != null ? bx7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().Q() != null && this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.obfuscated_res_0x7f0f0838);
        }
        O0();
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        ug.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public final void J0(vr4 vr4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, vr4Var, i2) == null) || (absVideoPbFragment = this.a) == null || vr4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new el5(this.a.getPageContext(), this.a.getView());
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        dq4 dq4Var = new dq4();
        dq4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3), this.a.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.v.x(dq4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, vr4Var));
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            vr4 vr4Var = this.e;
            if (vr4Var != null) {
                vr4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                ug.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                ug.b(dialog2, this.a.getPageContext());
            }
            es4 es4Var = this.q;
            if (es4Var != null) {
                es4Var.dismiss();
            }
        }
    }

    public void K0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null) {
            return;
        }
        es4 es4Var = new es4(this.a.getPageContext());
        if (this.a.K().S1().f == null || this.a.K().S1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11b4), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11b5)};
        } else {
            strArr = new String[this.a.K().S1().f.size()];
            for (int i2 = 0; i2 < this.a.K().S1().f.size(); i2++) {
                strArr[i2] = this.a.K().S1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11b2);
            }
        }
        es4Var.i(null, strArr, new m(this, es4Var, view2));
        es4Var.k();
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.K() == null || this.a.K().S1() == null) {
                return null;
            }
            return this.a.K().S1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            vr4 vr4Var = new vr4(this.a.getPageContext().getPageActivity());
            vr4Var.setMessage(str);
            vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a4, new p(this));
            vr4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                C0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            vr4 vr4Var = new vr4(this.a.getBaseFragmentActivity());
            if (qi.isEmpty(str)) {
                vr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f031f, str3));
            } else {
                vr4Var.setMessage(str);
            }
            vr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0432, new q(this, userMuteAddAndDelCustomMessage));
            vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new r(this));
            vr4Var.create(this.a.getPageContext()).show();
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(kz7.m(i2))));
        }
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public final void O0() {
        ax7 ax7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (ax7Var = this.u) == null) {
            return;
        }
        ax7Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public ax7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : (ax7) invokeV.objValue;
    }

    public xr4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : (xr4) invokeV.objValue;
    }

    public int S(kt7 kt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, kt7Var)) == null) {
            if (kt7Var == null || kt7Var.O() == null) {
                return 0;
            }
            if (kt7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (kt7Var.O().getThreadType() == 54) {
                return 2;
            }
            return kt7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092043) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092045) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092045) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092044) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092040) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092041) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            M0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.K().m2(), str);
                ThreadData O = this.a.K().S1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        vu4 vu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (vu4Var = this.r) == null) {
            return;
        }
        vu4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.s == null) {
            this.s = new xr4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0366), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11ae), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c3)};
            xr4 xr4Var = this.s;
            xr4Var.j(strArr, new l(this));
            xr4Var.g(xr4.b.obfuscated_res_0x7f1003ac);
            xr4Var.h(17);
            xr4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? kz7.i(this.a.K()) : invokeV.booleanValue;
    }

    public boolean Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.K().S1().V() != null && (forumToolAuth = this.a.K().S1().V().getForumToolAuth()) != null) {
                    for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                        ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                        if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z2)) == null) {
            if (this.a.K() != null && this.a.K().S1() != null) {
                return ((this.a.K().S1().W() != 0) || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null || TextUtils.equals(this.a.K().S1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void d0(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.K() != null && postData.K().equals(this.a.K().N1())) {
            z2 = true;
        }
        MarkData M1 = this.a.K().M1(postData);
        if (this.a.K().S1() != null && this.a.K().S1().i0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData M3 = absVideoPbFragment.M3(absVideoPbFragment.K().S1());
            if (M3 != null) {
                M1 = this.a.K().M1(M3);
            }
        }
        if (M1 == null) {
            return;
        }
        this.a.r5();
        if (this.a.U3() != null) {
            this.a.U3().i(M1);
            if (!z2) {
                this.a.U3().a();
            } else {
                this.a.U3().d();
            }
        }
    }

    public void f0(ArrayList<tp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e3, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a7);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090cc4);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cc3);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a2);
                this.k = textView2;
                textView2.setOnClickListener(this.a.R3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13cd));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    tp4 tp4Var = arrayList.get(i2);
                    if (tp4Var != null && !TextUtils.isEmpty(tp4Var.b()) && tp4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(tp4Var.a()), tp4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = ri.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = ri.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = ri.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            ug.j(this.g, this.a.getPageContext());
        }
    }

    public void g0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            h0(i2, str, i3, z2, null);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            i0(i2, str, i3, z2, str2, false);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a1 : R.string.obfuscated_res_0x7f0f0ff7;
            int i5 = R.string.obfuscated_res_0x7f0f043a;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f04a5;
                    i4 = R.string.obfuscated_res_0x7f0f04a6;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0ffb;
                }
            }
            this.e = new vr4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04ef, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04ea, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                w0(sparseArray, i5, i4);
            } else if (z2) {
                w0(sparseArray, i5, i4);
            } else if (r0()) {
                gl5 gl5Var = new gl5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
                gl5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
                gl5Var.h(this.a.K().S1().l().getImage_url());
                gl5Var.j(this.a.K().S1().l().getUser_level());
                D0(sparseArray, i2, gl5Var, this.a.K().S1().V(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        cs4 cs4Var;
        cs4 cs4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            gs4 gs4Var = new gs4(this.a.getContext());
            gs4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e4));
            gs4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe6)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091fec)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fee) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue() : -1) == 0) {
                    cs4Var2 = new cs4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04b7), gs4Var);
                } else {
                    cs4Var2 = new cs4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), gs4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                sparseArray2.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                cs4Var2.d.setTag(sparseArray2);
                arrayList.add(cs4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09200b) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09200b)).booleanValue()) {
                cs4 cs4Var3 = new cs4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b27), gs4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                sparseArray3.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                cs4Var3.d.setTag(sparseArray3);
                arrayList.add(cs4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff7)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff8))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                sparseArray4.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ffa, sparseArray.get(R.id.obfuscated_res_0x7f091ffa));
                cs4 cs4Var4 = new cs4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0655), gs4Var);
                cs4Var4.d.setTag(sparseArray4);
                arrayList.add(cs4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                sparseArray5.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                sparseArray5.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                if (z2) {
                    cs4Var = new cs4(12, this.a.getString(R.string.obfuscated_res_0x7f0f149c), gs4Var);
                } else {
                    cs4Var = new cs4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b33), gs4Var);
                }
                cs4Var.d.setTag(sparseArray5);
                arrayList.add(cs4Var);
            }
            kz7.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                gs4Var.k(arrayList, false);
            } else {
                gs4Var.k(arrayList, true);
            }
            es4 es4Var = this.q;
            if (es4Var == null) {
                this.q = new es4(this.a.getPageContext(), gs4Var);
            } else {
                es4Var.h(gs4Var);
            }
            this.q.k();
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        kt7 S1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (O = (S1 = this.a.K().S1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.h4();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        bx7 bx7Var = new bx7();
        int W = this.a.K().S1().W();
        boolean z2 = true;
        if (W != 1 && W != 3) {
            bx7Var.g = false;
        } else {
            bx7Var.g = true;
            bx7Var.s = O.getIs_top() == 1;
        }
        if (Z(W)) {
            bx7Var.h = true;
            bx7Var.r = O.getIs_good() == 1;
        } else {
            bx7Var.h = false;
        }
        if (W == 1002 && !equals) {
            bx7Var.u = true;
        }
        bx7Var.n = z0(O.isBlocked(), S1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        bx7Var.e = v0(equals, S1.k0());
        bx7Var.i = A0();
        bx7Var.f = y0(equals);
        bx7Var.k = equals && S1.V() != null && S1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            bx7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        bx7Var.t = equals;
        bx7Var.q = this.a.K().k2();
        bx7Var.b = true;
        bx7Var.a = b0(equals);
        bx7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        bx7Var.j = true;
        bx7Var.o = this.a.K().v1();
        bx7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            bx7Var.c = true;
        } else {
            bx7Var.c = false;
        }
        if (S1.i0()) {
            bx7Var.b = false;
            bx7Var.d = false;
            bx7Var.c = false;
            bx7Var.g = false;
            bx7Var.h = false;
        }
        bx7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S1.i0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.M3(absVideoPbFragment2.K().S1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            bx7Var.w = absVideoPbFragment3.M3(absVideoPbFragment3.K().S1()).Q;
        }
        if (O.isBlocked()) {
            bx7Var.n = false;
            bx7Var.g = false;
            bx7Var.h = false;
        }
        I0(bx7Var);
    }

    public final void n0(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091854, Integer.valueOf(this.O ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.i();
        }
    }

    public void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.O = z2;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            return (absVideoPbFragment == null || absVideoPbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void s0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1177, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0371, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b2f);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b30);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new f(this, w2, sparseArray));
        aVar2.a(new g(this, w2));
    }

    public final void t0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048635, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.TRUE);
        }
        gl5 gl5Var = new gl5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
        gl5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
        gl5Var.h(this.a.K().S1().l().getImage_url());
        gl5Var.j(this.a.K().S1().l().getUser_level());
        D0(sparseArray, i2, gl5Var, this.a.K().S1().V(), true);
    }

    public final void u0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            kz7.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        lp4 lp4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                return false;
            }
            kt7 S1 = this.a.K().S1();
            ThreadData O = S1.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !mg6.isOn()) || this.a.K().H() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (S1.l() == null || !S1.l().isBlockBawuDelete) {
                if (S1.O() == null || !S1.O().isBlocked()) {
                    if (S1.W() != 0) {
                        return S1.W() != 3;
                    }
                    List<fr4> p2 = S1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (fr4 fr4Var : p2) {
                            if (fr4Var != null && (lp4Var = fr4Var.g) != null && lp4Var.a && !lp4Var.c && ((i2 = lp4Var.b) == 1 || i2 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void w0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048638, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ac, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0371, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(i2);
        tBAlertBuilder.k(i3);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new d(this, w2, sparseArray));
        aVar2.a(new e(this, w2));
    }

    public void x0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        cs4 cs4Var;
        cs4 cs4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fea)) == null) {
            return;
        }
        if (this.c == null) {
            gs4 gs4Var = new gs4(this.a.getContext());
            this.c = gs4Var;
            gs4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.K().S1() != null && this.a.K().S1().i0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091fed) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            cs4 cs4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ffa) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ffa) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int r2 = postData.r();
                if (z3 && r2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0085;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0087;
                }
                cs4 cs4Var4 = new cs4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fea, postData);
                cs4Var4.d.setTag(sparseArray2);
                arrayList.add(cs4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    cs4 cs4Var5 = new cs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b37), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                    cs4Var5.d.setTag(sparseArray3);
                    arrayList.add(cs4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        cs4 cs4Var6 = new cs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ffa), this.c);
                        cs4Var6.d.setTag(str);
                        arrayList.add(cs4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ffa, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                        cs4 cs4Var7 = new cs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.c);
                        cs4Var7.d.setTag(sparseArray4);
                        cs4Var3 = cs4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                    }
                    cs4 cs4Var8 = new cs4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e4), this.c);
                    cs4Var8.d.setTag(sparseArray4);
                    cs4Var2 = cs4Var8;
                    cs4Var = cs4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ffe, sparseArray.get(R.id.obfuscated_res_0x7f091ffe));
                    if (this.a.K().S1().W() == 1002 && !booleanValue) {
                        cs4Var = new cs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0ffa), this.c);
                    } else {
                        cs4Var = new cs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.c);
                    }
                    cs4Var.d.setTag(sparseArray5);
                    cs4Var2 = null;
                } else {
                    cs4Var = null;
                    cs4Var2 = null;
                }
                if (cs4Var != null) {
                    arrayList.add(cs4Var);
                }
                if (cs4Var2 != null) {
                    arrayList.add(cs4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new cs4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0320), this.c));
                }
            }
            this.c.j(arrayList);
            es4 es4Var = new es4(this.a.getPageContext(), this.c);
            this.b = es4Var;
            es4Var.k();
        }
    }

    public final boolean y0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (this.a.K().S1().l() != null && this.a.K().S1().l().isBlockBawuDelete)) {
                return false;
            }
            kt7 S1 = this.a.K().S1();
            if ((S1.O() == null || S1.O().getAuthor() == null || !S1.O().getAuthor().isForumBusinessAccount() || mg6.isOn()) && !this.a.K().H()) {
                return ((S1.O() != null && S1.O().isBlocked()) || this.a.K().S1().W() == 0 || this.a.K().S1().W() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final boolean z0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            if (z2) {
                return false;
            }
            if (z5 || z6) {
                return true;
            }
            return z3 && (z4 || a0(i2));
        }
        return invokeCommon.booleanValue;
    }
}
