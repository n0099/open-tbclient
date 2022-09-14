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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.au4;
import com.baidu.tieba.cu4;
import com.baidu.tieba.lu4;
import com.baidu.tieba.nn5;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.qn5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.v75;
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
public class t28 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public on A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public xw4 J;
    public lm8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public lu4.e N;
    public boolean O;
    public final cu4.c P;
    public AbsVideoPbFragment a;
    public ju4 b;
    public lu4 c;
    public ju4 d;
    public au4 e;
    public Dialog f;
    public Dialog g;
    public eu4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public ju4 q;
    public fx4 r;
    public cu4 s;
    public AlertDialog t;
    public gy7 u;
    public nn5 v;
    public qn5 w;
    public b18 x;
    public PbFragment.h3 y;
    public ez7 z;

    /* loaded from: classes5.dex */
    public class a implements cu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public a(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.cu4.c
        public void a(cu4 cu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cu4Var, i, view2) == null) {
                if (cu4Var != null) {
                    cu4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        v75.a aVar = new v75.a();
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
                        t28 t28Var = this.a;
                        t28Var.z = new ez7(t28Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ t28 e;

        public a0(t28 t28Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t28Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203c), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f09203d)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092093);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092095);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092094);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092091));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public b(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.a.a.w3(au4Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public b0(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                TiebaStatic.log("c10025");
                au4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
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
    public class c0 implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ t28 c;

        public d(t28 t28Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t28Var;
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
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.c.a.v3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(t28 t28Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, alertDialog};
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
        public final /* synthetic */ t28 c;

        public f(t28 t28Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t28Var;
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
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.c.a.v3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(t28 t28Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, alertDialog};
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
    public class h implements nn5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ t28 b;

        public h(t28 t28Var, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = au4Var;
        }

        @Override // com.baidu.tieba.nn5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.w3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements qn5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ t28 b;

        public i(t28 t28Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.qn5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.v3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t28 b;

        public j(t28 t28Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09205a), sparseArray.get(R.id.obfuscated_res_0x7f092047), sparseArray.get(R.id.obfuscated_res_0x7f09204a), sparseArray.get(R.id.obfuscated_res_0x7f092048), sparseArray.get(R.id.obfuscated_res_0x7f092049)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092092), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment == null || absVideoPbFragment.I3() == null) {
                            return;
                        }
                        this.b.a.I3().l2(true);
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
        public final /* synthetic */ t28 a;

        public k(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            ih.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class l implements cu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public l(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.cu4.c
        public void a(cu4 cu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cu4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    t28 t28Var = this.a;
                    t28Var.H = t28Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new bx7(this.a.a.K().m2(), this.a.H, "1").start();
                    cu4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    t28 t28Var2 = this.a;
                    t28Var2.H = t28Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new bx7(this.a.a.K().m2(), this.a.H, "2").start();
                    cu4Var.e();
                } else if (i == 2) {
                    t28 t28Var3 = this.a;
                    t28Var3.H = t28Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    cu4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ t28 c;

        public m(t28 t28Var, ju4 ju4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, ju4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t28Var;
            this.a = ju4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.K().j2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.lu4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void n0(lu4 lu4Var, int i, View view2) {
            boolean L3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, lu4Var, i, view2) != null) {
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
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09187b ? 1 : 0).param("obj_type", i2));
                if (this.c.a.K().S1().f != null && this.c.a.K().S1().f.size() > i) {
                    i = this.c.a.K().S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.K().L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                if (L3) {
                    return;
                }
                this.c.a.h5(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09187b ? 1 : 0).param("obj_type", i2));
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
    public class n implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(t28 t28Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, metaData};
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ t28 b;

        public o(t28 t28Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                au4Var.dismiss();
                if (this.b.a.F3() != null) {
                    this.b.a.F3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.K().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
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
    public class q implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ t28 b;

        public q(t28 t28Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
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
    public class s implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu4.c a;
        public final /* synthetic */ t28 b;

        public s(t28 t28Var, cu4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public t(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
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
        public final /* synthetic */ t28 a;

        public u(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
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
        public final /* synthetic */ t28 a;

        public v(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                ih.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public w(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.K().S1().l().getId(), this.a.a.K().S1().l().getName(), this.a.a.K().S1().O().getId(), String.valueOf(this.a.a.K().S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public x(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.N0(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ee);
                    this.a.n0(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ed);
                    this.a.n0(view4);
                    if (view4 != null) {
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                    AgreeView agreeView = (AgreeView) view5;
                    this.a.n0(view5);
                    if (agreeView == null || agreeView.getImgDisagree() == null) {
                        return;
                    }
                    agreeView.getImgDisagree().performClick();
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
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
                                v75.a aVar = new v75.a();
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
                                t28 t28Var = this.a;
                                t28Var.z = new ez7(t28Var.a.getPageContext());
                            }
                            this.a.z.b(this.a.B, this.a.A.n());
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 3:
                            PostData postData = this.a.G;
                            if (postData != null) {
                                postData.C0();
                                this.a.G = null;
                                return;
                            }
                            return;
                        case 4:
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            if (this.a.a.checkUpIsLogin()) {
                                this.a.d0(view2);
                                if (this.a.a.K().S1().O() == null || this.a.a.K().S1().O().getAuthor() == null || this.a.a.K().S1().O().getAuthor().getUserId() == null || this.a.a.S3() == null) {
                                    return;
                                }
                                t28 t28Var2 = this.a;
                                int S = t28Var2.S(t28Var2.a.K().S1());
                                ThreadData O = this.a.a.K().S1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.K().m2()).param("obj_locate", 2).param("obj_id", this.a.a.K().S1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.S3().e()).param("obj_source", S).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
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
                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                                    sparseArray2.put(R.id.obfuscated_res_0x7f09204d, 0);
                                    sparseArray2.put(R.id.obfuscated_res_0x7f092036, 2);
                                    this.a.B(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f09203e) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203c) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09205a) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203d) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09203d)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09205a)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09204e)).booleanValue();
                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                if (absVideoPbFragment == null || absVideoPbFragment.P() == null) {
                                    return;
                                }
                                boolean F = this.a.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                if (F) {
                                    if (!booleanValue2) {
                                        this.a.u0(sparseArray3, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203c), intValue, booleanValue, null, F);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.u0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203c), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                return;
                            }
                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092080)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092096)).booleanValue();
                            boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092052) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092052)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203c), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09203d)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (booleanValue5) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f09204d, 1);
                                sparseArray4.put(R.id.obfuscated_res_0x7f092036, 2);
                                this.a.B(sparseArray4);
                                return;
                            } else {
                                if (booleanValue6) {
                                    sparseArray4.put(R.id.obfuscated_res_0x7f092036, 2);
                                }
                                sparseArray4.put(R.id.obfuscated_res_0x7f09205b, Boolean.TRUE);
                                this.a.l0(view2);
                                return;
                            }
                        case 8:
                            if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a);
                                if (postData2.q() == null) {
                                    return;
                                }
                                bc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
                            this.a.a.P().u1(st8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else {
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                    if (absVideoPbFragment3 == null || absVideoPbFragment3.I3() == null) {
                        return;
                    }
                    this.a.a.I3().l2(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ t28 d;

        public y(t28 t28Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t28Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                if (au4Var != null) {
                    au4Var.dismiss();
                }
                this.d.a.x3(((Integer) this.a.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203c), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948129423, "Lcom/baidu/tieba/t28;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948129423, "Lcom/baidu/tieba/t28;");
        }
    }

    public t28(AbsVideoPbFragment absVideoPbFragment) {
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
        b18 b18Var = new b18(this.a.getContext());
        this.x = b18Var;
        b18Var.b(this.a.getUniqueId());
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
            userMuteCheckCustomMessage.userIdF = dh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = dh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092092), 0L);
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
        au4 au4Var = new au4(this.a.getActivity());
        au4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aac));
        au4Var.setTitleShowCenter(true);
        au4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aad));
        au4Var.setMessageShowCenter(true);
        au4Var.setCancelable(false);
        au4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aae), new n(this, metaData));
        au4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aaf), new o(this, metaData));
        au4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new xw4();
        }
        if (this.K == null) {
            lm8 lm8Var = new lm8();
            this.K = lm8Var;
            lm8Var.a = this.a.getUniqueId();
        }
        rq4 rq4Var = new rq4();
        rq4Var.b = 5;
        rq4Var.h = 8;
        rq4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null) {
            rq4Var.f = this.a.K().R1();
        }
        rq4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                rq4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                    return;
                }
                this.J.b(this.a.P(), rq4Var, agreeData, this.a.K().S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            rq4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            rq4Var.i = 1;
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
                this.r = new fx4(this.a.getPageContext());
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
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ej.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray<Object> sparseArray, int i2, pn5 pn5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), pn5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new qn5(this.a.getPageContext(), this.a.getView(), pn5Var, userData);
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
        is4 is4Var = new is4();
        is4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c4), this.a.getString(R.string.obfuscated_res_0x7f0f04c5), this.a.getString(R.string.obfuscated_res_0x7f0f04c6), this.a.getString(R.string.obfuscated_res_0x7f0f04c7), this.a.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.w.D(is4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<hu4> c2;
        hu4 hu4Var;
        hu4 hu4Var2;
        hu4 hu4Var3;
        hu4 hu4Var4;
        hu4 hu4Var5;
        hu4 hu4Var6;
        on onVar;
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
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
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a);
            this.G = postData;
            if (postData == null || this.a.S3() == null) {
                return true;
            }
            boolean z5 = this.a.S3().e() && this.G.L() != null && this.G.L().equals(this.a.K().N1());
            boolean z6 = this.a.K().S1() != null && this.a.K().S1().i0();
            if (this.c == null) {
                lu4 lu4Var = new lu4(this.a.getContext());
                this.c = lu4Var;
                lu4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (onVar = this.A) == null || onVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092053) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092053)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f09203d) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092080) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092080)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f09204a) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204a) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092052) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092052)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f09205b) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205b)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new hu4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10ae), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new hu4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10af), this.c));
            }
            if (!z7 && !z8) {
                hu4 hu4Var7 = new hu4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0452), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203a, this.G);
                hu4Var7.d.setTag(sparseArray3);
                arrayList.add(hu4Var7);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    hu4Var6 = new hu4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff1), this.c);
                } else {
                    hu4Var6 = new hu4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aaa), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f09203a, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f092053, Boolean.FALSE);
                hu4Var6.d.setTag(sparseArray4);
                arrayList.add(hu4Var6);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    hu4 hu4Var8 = new hu4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b4d), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    hu4Var8.d.setTag(sparseArray5);
                    arrayList.add(hu4Var8);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        hu4 hu4Var9 = new hu4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1016), this.c);
                        hu4Var9.d.setTag(str);
                        arrayList.add(hu4Var9);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    sparseArray6.put(R.id.obfuscated_res_0x7f092047, sparseArray.get(R.id.obfuscated_res_0x7f092047));
                    sparseArray6.put(R.id.obfuscated_res_0x7f092048, sparseArray.get(R.id.obfuscated_res_0x7f092048));
                    sparseArray6.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                    sparseArray6.put(R.id.obfuscated_res_0x7f09204a, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                        if (z4) {
                            hu4Var5 = new hu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                            hu4Var5.d.setTag(sparseArray6);
                            hu4Var2 = new hu4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                            hu4Var2.d.setTag(sparseArray6);
                            hu4Var3 = hu4Var5;
                            hu4Var = null;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092080, Boolean.FALSE);
                    }
                    hu4Var5 = null;
                    hu4Var2 = new hu4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                    hu4Var2.d.setTag(sparseArray6);
                    hu4Var3 = hu4Var5;
                    hu4Var = null;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    sparseArray7.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                    sparseArray7.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray7.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                    if (this.a.K().S1().W() == 1002 && !booleanValue2) {
                        hu4Var4 = new hu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1016), this.c);
                    } else {
                        hu4Var4 = new hu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                    }
                    hu4Var4.d.setTag(sparseArray7);
                    if (booleanValue8) {
                        hu4Var = new hu4(13, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b3d), this.c);
                        hu4Var3 = hu4Var4;
                    } else {
                        hu4Var3 = hu4Var4;
                        hu4Var = null;
                    }
                    hu4Var2 = null;
                } else {
                    hu4Var = null;
                    hu4Var2 = null;
                    hu4Var3 = null;
                }
                if (hu4Var3 != null) {
                    arrayList.add(hu4Var3);
                }
                if (hu4Var != null) {
                    arrayList.add(hu4Var);
                }
                if (hu4Var2 != null) {
                    arrayList.add(hu4Var2);
                }
                s08.b(arrayList, this.c, this.G, this.a.K());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = s08.d(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                c2 = s08.c(arrayList, this.G.q(), sparseArray, this.c);
            }
            s08.l(c2, this.O);
            s08.f(c2);
            this.c.o(s08.g(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(c2, false);
            } else {
                this.c.k(c2, true);
            }
            ju4 ju4Var = new ju4(this.a.getPageContext(), this.c);
            this.b = ju4Var;
            ju4Var.k();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.K().m2()).param("fid", this.a.K().getForumId()).param("uid", this.a.K().S1().O().getAuthor().getUserId()).param("post_id", this.a.K().B()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            au4 au4Var = new au4(this.a.getPageContext().getPageActivity());
            au4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b4c));
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b0(this));
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c0(this));
            au4Var.create(this.a.getPageContext()).show();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.f4();
            ju4 ju4Var = this.b;
            if (ju4Var != null) {
                ju4Var.dismiss();
            }
            this.a.g4();
            K();
        }
    }

    public void F0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092092) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092036) instanceof Integer)) {
            ju4 ju4Var = this.b;
            if (ju4Var != null && ju4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092090);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092092);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                lu4 lu4Var = new lu4(this.a.getBaseFragmentActivity());
                lu4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f092036) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092036)).intValue() : -1) == 1) {
                    arrayList.add(new hu4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04b0), lu4Var));
                }
                if (z2) {
                    arrayList.add(new hu4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14bc), lu4Var));
                } else {
                    arrayList.add(new hu4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b49), lu4Var));
                }
                lu4Var.j(arrayList);
                ju4 ju4Var2 = new ju4(this.a.getPageContext(), lu4Var);
                this.b = ju4Var2;
                ju4Var2.k();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.f4();
            ju4 ju4Var = this.b;
            if (ju4Var != null) {
                ju4Var.dismiss();
            }
            K();
        }
    }

    public void G0(cu4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            ju4 ju4Var = this.d;
            if (ju4Var != null) {
                ju4Var.dismiss();
                this.d = null;
            }
            lu4 lu4Var = new lu4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.K().S1() != null && this.a.K().S1().O() != null && !this.a.K().S1().O().isBjh()) {
                arrayList.add(new hu4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ae), lu4Var));
            }
            if (!z2) {
                arrayList.add(new hu4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10af), lu4Var));
            }
            lu4Var.j(arrayList);
            lu4Var.n(new s(this, cVar));
            ju4 ju4Var2 = new ju4(this.a.getPageContext(), lu4Var);
            this.d = ju4Var2;
            ju4Var2.k();
        }
    }

    public void H() {
        ju4 ju4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ju4Var = this.b) == null) {
            return;
        }
        ju4Var.dismiss();
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            eu4 eu4Var = this.h;
            if (eu4Var != null) {
                eu4Var.d();
                this.h = null;
            }
            if (this.a.K() == null) {
                return;
            }
            ArrayList<nu4> arrayList = new ArrayList<>();
            arrayList.add(new nu4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0275), "", this.a.K().b2() == 1, Integer.toString(1)));
            arrayList.add(new nu4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b59), "", this.a.K().b2() == 2, Integer.toString(5)));
            arrayList.add(new nu4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b56), "", this.a.K().b2() == 3, Integer.toString(6)));
            arrayList.add(new nu4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b77), "", this.a.K().b2() == 4, Integer.toString(7)));
            eu4 eu4Var2 = new eu4(this.a.getPageContext());
            eu4Var2.l(R.string.obfuscated_res_0x7f0f0e03);
            this.h = eu4Var2;
            eu4Var2.k(arrayList, onItemClickListener);
            eu4Var2.c();
            this.h.n();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            gh.a().postDelayed(this.I, 100L);
        }
    }

    public void I0(hy7 hy7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, hy7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new gy7(absVideoPbFragment, absVideoPbFragment.B1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        ih.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = ej.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f7);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        this.u.Q(hy7Var == null ? false : hy7Var.a);
        this.u.D(hy7Var == null ? false : hy7Var.n);
        this.u.F(hy7Var == null ? false : hy7Var.e);
        this.u.L(hy7Var == null ? false : hy7Var.i);
        this.u.G(hy7Var == null ? false : hy7Var.f);
        this.u.S(hy7Var != null ? hy7Var.c : true);
        this.u.P(hy7Var == null ? false : hy7Var.k);
        this.u.H(hy7Var == null ? false : hy7Var.l, hy7Var.t);
        if (hy7Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(hy7Var.g, hy7Var.s);
            this.u.M(hy7Var.h, hy7Var.r);
        }
        boolean z2 = hy7Var == null ? false : hy7Var.q;
        boolean z3 = hy7Var == null ? false : hy7Var.o;
        boolean z4 = hy7Var == null ? false : hy7Var.d;
        boolean z5 = hy7Var == null ? false : hy7Var.b;
        boolean z6 = hy7Var == null ? false : hy7Var.p;
        boolean z7 = hy7Var == null ? false : hy7Var.j;
        boolean z8 = hy7Var == null ? false : hy7Var.m;
        this.u.I(z4, z3);
        this.u.R(z5, z2);
        this.u.O(z7, z6);
        this.u.U(z8);
        if (hy7Var != null) {
            gy7 gy7Var = this.u;
            boolean z9 = hy7Var.u;
            gy7Var.w = z9;
            if (z9) {
                gy7Var.m().setText(R.string.obfuscated_res_0x7f0f1016);
                this.u.G(false);
            }
        }
        this.u.E(hy7Var != null ? hy7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().Q() != null && this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.obfuscated_res_0x7f0f084b);
        }
        O0();
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        ih.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public final void J0(au4 au4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, au4Var, i2) == null) || (absVideoPbFragment = this.a) == null || au4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new nn5(this.a.getPageContext(), this.a.getView());
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
        is4 is4Var = new is4();
        is4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c4), this.a.getString(R.string.obfuscated_res_0x7f0f04c5), this.a.getString(R.string.obfuscated_res_0x7f0f04c6), this.a.getString(R.string.obfuscated_res_0x7f0f04c7), this.a.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.v.x(is4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, au4Var));
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            au4 au4Var = this.e;
            if (au4Var != null) {
                au4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                ih.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                ih.b(dialog2, this.a.getPageContext());
            }
            ju4 ju4Var = this.q;
            if (ju4Var != null) {
                ju4Var.dismiss();
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
        ju4 ju4Var = new ju4(this.a.getPageContext());
        if (this.a.K().S1().f == null || this.a.K().S1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11d1), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11d2)};
        } else {
            strArr = new String[this.a.K().S1().f.size()];
            for (int i2 = 0; i2 < this.a.K().S1().f.size(); i2++) {
                strArr[i2] = this.a.K().S1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11cf);
            }
        }
        ju4Var.i(null, strArr, new m(this, ju4Var, view2));
        ju4Var.k();
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
            au4 au4Var = new au4(this.a.getPageContext().getPageActivity());
            au4Var.setMessage(str);
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new p(this));
            au4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907b9);
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
            au4 au4Var = new au4(this.a.getBaseFragmentActivity());
            if (dj.isEmpty(str)) {
                au4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            } else {
                au4Var.setMessage(str);
            }
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new q(this, userMuteAddAndDelCustomMessage));
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new r(this));
            au4Var.create(this.a.getPageContext()).show();
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
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(s08.m(i2))));
        }
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public final void O0() {
        gy7 gy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (gy7Var = this.u) == null) {
            return;
        }
        gy7Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public gy7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : (gy7) invokeV.objValue;
    }

    public cu4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : (cu4) invokeV.objValue;
    }

    public int S(vu7 vu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.O() == null) {
                return 0;
            }
            if (vu7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (vu7Var.O().getThreadType() == 54) {
                return 2;
            }
            return vu7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092093) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092095) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092094) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092090) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092091) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092091) : "";
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
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (fx4Var = this.r) == null) {
            return;
        }
        fx4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.s == null) {
            this.s = new cu4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11cb), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e0)};
            cu4 cu4Var = this.s;
            cu4Var.j(strArr, new l(this));
            cu4Var.g(cu4.b.obfuscated_res_0x7f1003ad);
            cu4Var.h(17);
            cu4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? s08.i(this.a.K()) : invokeV.booleanValue;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a)) == null) {
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
        if (postData.L() != null && postData.L().equals(this.a.K().N1())) {
            z2 = true;
        }
        MarkData M1 = this.a.K().M1(postData);
        if (this.a.K().S1() != null && this.a.K().S1().i0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData K3 = absVideoPbFragment.K3(absVideoPbFragment.K().S1());
            if (K3 != null) {
                M1 = this.a.K().M1(K3);
            }
        }
        if (M1 == null) {
            return;
        }
        this.a.n5();
        if (this.a.S3() != null) {
            this.a.S3().i(M1);
            if (!z2) {
                this.a.S3().a();
            } else {
                this.a.S3().d();
            }
        }
    }

    public void f0(ArrayList<yr4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e6, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090cdf);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cde);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907b8);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907b9);
                this.k = textView2;
                textView2.setOnClickListener(this.a.P3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13eb));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    yr4 yr4Var = arrayList.get(i2);
                    if (yr4Var != null && !TextUtils.isEmpty(yr4Var.b()) && yr4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(yr4Var.a()), yr4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = ej.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = ej.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = ej.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            ih.j(this.g, this.a.getPageContext());
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
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, str);
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a5 : R.string.obfuscated_res_0x7f0f1013;
            int i5 = R.string.obfuscated_res_0x7f0f043e;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f04a9;
                    i4 = R.string.obfuscated_res_0x7f0f04aa;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f1017;
                }
            }
            this.e = new au4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.dialog_ok, new b(this));
            this.e.setNegativeButton(R.string.dialog_cancel, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                w0(sparseArray, i5, i4);
            } else if (z2) {
                w0(sparseArray, i5, i4);
            } else if (r0()) {
                pn5 pn5Var = new pn5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
                pn5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
                pn5Var.h(this.a.K().S1().l().getImage_url());
                pn5Var.j(this.a.K().S1().l().getUser_level());
                D0(sparseArray, i2, pn5Var, this.a.K().S1().V(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, str);
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        hu4 hu4Var;
        hu4 hu4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            lu4 lu4Var = new lu4(this.a.getContext());
            lu4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e8));
            lu4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f092036) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092036)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09203c)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue() : -1) == 0) {
                    hu4Var2 = new hu4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), lu4Var);
                } else {
                    hu4Var2 = new hu4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), lu4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                sparseArray2.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                hu4Var2.d.setTag(sparseArray2);
                arrayList.add(hu4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09205b) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205b)).booleanValue()) {
                hu4 hu4Var3 = new hu4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b3d), lu4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray3.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                sparseArray3.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                hu4Var3.d.setTag(sparseArray3);
                arrayList.add(hu4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092047)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092048))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f092047, sparseArray.get(R.id.obfuscated_res_0x7f092047));
                sparseArray4.put(R.id.obfuscated_res_0x7f092048, sparseArray.get(R.id.obfuscated_res_0x7f092048));
                sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                sparseArray4.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                hu4 hu4Var4 = new hu4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0668), lu4Var);
                hu4Var4.d.setTag(sparseArray4);
                arrayList.add(hu4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                sparseArray5.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                sparseArray5.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                sparseArray5.put(R.id.obfuscated_res_0x7f092090, sparseArray.get(R.id.obfuscated_res_0x7f092090));
                if (z2) {
                    hu4Var = new hu4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14bc), lu4Var);
                } else {
                    hu4Var = new hu4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b49), lu4Var);
                }
                hu4Var.d.setTag(sparseArray5);
                arrayList.add(hu4Var);
            }
            s08.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                lu4Var.k(arrayList, false);
            } else {
                lu4Var.k(arrayList, true);
            }
            ju4 ju4Var = this.q;
            if (ju4Var == null) {
                this.q = new ju4(this.a.getPageContext(), lu4Var);
            } else {
                ju4Var.h(lu4Var);
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
        vu7 S1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (O = (S1 = this.a.K().S1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.f4();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        hy7 hy7Var = new hy7();
        int W = this.a.K().S1().W();
        boolean z2 = true;
        if (W != 1 && W != 3) {
            hy7Var.g = false;
        } else {
            hy7Var.g = true;
            hy7Var.s = O.getIs_top() == 1;
        }
        if (Z(W)) {
            hy7Var.h = true;
            hy7Var.r = O.getIs_good() == 1;
        } else {
            hy7Var.h = false;
        }
        if (W == 1002 && !equals) {
            hy7Var.u = true;
        }
        hy7Var.n = z0(O.isBlocked(), S1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        hy7Var.e = v0(equals, S1.k0());
        hy7Var.i = A0();
        hy7Var.f = y0(equals);
        hy7Var.k = equals && S1.V() != null && S1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            hy7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        hy7Var.t = equals;
        hy7Var.q = this.a.K().k2();
        hy7Var.b = true;
        hy7Var.a = b0(equals);
        hy7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        hy7Var.j = true;
        hy7Var.o = this.a.K().v1();
        hy7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            hy7Var.c = true;
        } else {
            hy7Var.c = false;
        }
        if (S1.i0()) {
            hy7Var.b = false;
            hy7Var.d = false;
            hy7Var.c = false;
            hy7Var.g = false;
            hy7Var.h = false;
        }
        hy7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S1.i0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.K3(absVideoPbFragment2.K().S1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            hy7Var.w = absVideoPbFragment3.K3(absVideoPbFragment3.K().S1()).Q;
        }
        if (O.isBlocked()) {
            hy7Var.n = false;
            hy7Var.g = false;
            hy7Var.h = false;
        }
        I0(hy7Var);
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
        sparseArray.put(R.id.obfuscated_res_0x7f09188a, Integer.valueOf(this.O ? 2 : 3));
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
            sparseArray.put(R.id.obfuscated_res_0x7f092050, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1194, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b45);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b46);
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
            sparseArray.put(R.id.obfuscated_res_0x7f092050, Boolean.TRUE);
        }
        pn5 pn5Var = new pn5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
        pn5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
        pn5Var.h(this.a.K().S1().l().getImage_url());
        pn5Var.j(this.a.K().S1().l().getUser_level());
        D0(sparseArray, i2, pn5Var, this.a.K().S1().V(), true);
    }

    public final void u0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            s08.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        qr4 qr4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                return false;
            }
            vu7 S1 = this.a.K().S1();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !di6.isOn()) || this.a.K().H() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (S1.l() == null || !S1.l().isBlockBawuDelete) {
                if (S1.O() == null || !S1.O().isBlocked()) {
                    if (S1.W() != 0) {
                        return S1.W() != 3;
                    }
                    List<kt4> p2 = S1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (kt4 kt4Var : p2) {
                            if (kt4Var != null && (qr4Var = kt4Var.g) != null && qr4Var.a && !qr4Var.c && ((i2 = qr4Var.b) == 1 || i2 == 2)) {
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04b0, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
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
        hu4 hu4Var;
        hu4 hu4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a)) == null) {
            return;
        }
        if (this.c == null) {
            lu4 lu4Var = new lu4(this.a.getContext());
            this.c = lu4Var;
            lu4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.K().S1() != null && this.a.K().S1().i0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f09203d) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092080) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092080)).booleanValue() : false;
            hu4 hu4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f09204a) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204a) : null;
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
                hu4 hu4Var4 = new hu4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203a, postData);
                hu4Var4.d.setTag(sparseArray2);
                arrayList.add(hu4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    hu4 hu4Var5 = new hu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b4d), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    hu4Var5.d.setTag(sparseArray3);
                    arrayList.add(hu4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        hu4 hu4Var6 = new hu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1016), this.c);
                        hu4Var6.d.setTag(str);
                        arrayList.add(hu4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092047, sparseArray.get(R.id.obfuscated_res_0x7f092047));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092048, sparseArray.get(R.id.obfuscated_res_0x7f092048));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204a, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                        hu4 hu4Var7 = new hu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                        hu4Var7.d.setTag(sparseArray4);
                        hu4Var3 = hu4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092080, Boolean.FALSE);
                    }
                    hu4 hu4Var8 = new hu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                    hu4Var8.d.setTag(sparseArray4);
                    hu4Var2 = hu4Var8;
                    hu4Var = hu4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                    if (this.a.K().S1().W() == 1002 && !booleanValue) {
                        hu4Var = new hu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1016), this.c);
                    } else {
                        hu4Var = new hu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                    }
                    hu4Var.d.setTag(sparseArray5);
                    hu4Var2 = null;
                } else {
                    hu4Var = null;
                    hu4Var2 = null;
                }
                if (hu4Var != null) {
                    arrayList.add(hu4Var);
                }
                if (hu4Var2 != null) {
                    arrayList.add(hu4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new hu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), this.c));
                }
            }
            this.c.j(arrayList);
            ju4 ju4Var = new ju4(this.a.getPageContext(), this.c);
            this.b = ju4Var;
            ju4Var.k();
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
            vu7 S1 = this.a.K().S1();
            if ((S1.O() == null || S1.O().getAuthor() == null || !S1.O().getAuthor().isForumBusinessAccount() || di6.isOn()) && !this.a.K().H()) {
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
