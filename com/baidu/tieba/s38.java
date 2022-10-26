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
import com.baidu.tieba.av4;
import com.baidu.tieba.ho5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.m85;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pu4;
import com.baidu.tieba.ru4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
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
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class s38 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int P = 0;
    public static int Q = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public pn A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public qx4 J;
    public hn8 K;
    public final View.OnLongClickListener L;
    public av4.e M;
    public boolean N;
    public final ru4.c O;
    public AbsVideoPbFragment a;
    public yu4 b;
    public av4 c;
    public yu4 d;
    public pu4 e;
    public Dialog f;
    public Dialog g;
    public tu4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public yu4 q;
    public yx4 r;
    public ru4 s;
    public AlertDialog t;
    public fz7 u;
    public ho5 v;
    public ko5 w;
    public a28 x;
    public PbFragment.h3 y;
    public d08 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948100593, "Lcom/baidu/tieba/s38;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948100593, "Lcom/baidu/tieba/s38;");
        }
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ru4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public a(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.baidu.tieba.ru4.c
        public void a(ru4 ru4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, ru4Var, i, view2) == null) {
                if (ru4Var != null) {
                    ru4Var.e();
                }
                if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                    if (i == 0) {
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            m85.a aVar = new m85.a();
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
                            s38 s38Var = this.a;
                            s38Var.z = new d08(s38Var.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.n());
                    }
                    this.a.A = null;
                    this.a.B = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ s38 e;

        public a0(s38 s38Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s38Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203e), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092095);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092097);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092096);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092093));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public b(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.a.v3(pu4Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public b0(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log("c10025");
                pu4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ s38 c;

        public d(s38 s38Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s38Var;
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
                    fj.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c68);
                } else {
                    this.c.a.u3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(s38 s38Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, alertDialog};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ s38 c;

        public f(s38 s38Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s38Var;
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
                    fj.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c68);
                } else {
                    this.c.a.u3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(s38 s38Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, alertDialog};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ho5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ s38 b;

        public h(s38 s38Var, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s38Var;
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.ho5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.v3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ko5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ s38 b;

        public i(s38 s38Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s38Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.ko5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.u3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ s38 b;

        public j(s38 s38Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s38Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09205c), sparseArray.get(R.id.obfuscated_res_0x7f092049), sparseArray.get(R.id.obfuscated_res_0x7f09204c), sparseArray.get(R.id.obfuscated_res_0x7f09204a), sparseArray.get(R.id.obfuscated_res_0x7f09204b)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092094), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment != null && absVideoPbFragment.H3() != null) {
                            this.b.a.H3().l2(true);
                            return;
                        }
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
        public final /* synthetic */ s38 a;

        public k(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                jh.a(this.a.t, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements ru4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public l(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.baidu.tieba.ru4.c
        public void a(ru4 ru4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, ru4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    s38 s38Var = this.a;
                    s38Var.H = s38Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new ay7(this.a.a.K().m2(), this.a.H, "1").start();
                    ru4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    s38 s38Var2 = this.a;
                    s38Var2.H = s38Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new ay7(this.a.a.K().m2(), this.a.H, "2").start();
                    ru4Var.e();
                } else if (i == 2) {
                    s38 s38Var3 = this.a;
                    s38Var3.H = s38Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    ru4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ s38 c;

        public m(s38 s38Var, yu4 yu4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, yu4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s38Var;
            this.a = yu4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.K().j2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.av4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void n0(av4 av4Var, int i, View view2) {
            boolean L3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.a.dismiss();
                int i2 = 3;
                int i3 = 0;
                if (this.c.a.K().j2() != 1 || i != 1) {
                    if (this.c.a.K().j2() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.K().j2() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091870) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.K().S1().f != null && this.c.a.K().S1().f.size() > i) {
                        i = ((PbSortType) this.c.a.K().S1().f.get(i)).sort_type.intValue();
                    }
                    L3 = this.c.a.K().L3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                    if (!L3) {
                        this.c.a.g5(true);
                        return;
                    }
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                StatisticItem statisticItem2 = new StatisticItem("c12097");
                if (this.b.getId() != R.id.obfuscated_res_0x7f091870) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.K().S1().f != null) {
                    i = ((PbSortType) this.c.a.K().S1().f.get(i)).sort_type.intValue();
                }
                L3 = this.c.a.K().L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                if (!L3) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(s38 s38Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, metaData};
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ s38 b;

        public o(s38 s38Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s38Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                pu4Var.dismiss();
                if (this.b.a.E3() != null) {
                    this.b.a.E3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.K().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ s38 b;

        public q(s38 s38Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s38Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru4.c a;
        public final /* synthetic */ s38 b;

        public s(s38 s38Var, ru4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s38Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public t(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
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
        public final /* synthetic */ s38 a;

        public u(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.E(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public v(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                jh.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public w(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.K().S1().W().getUserId());
                if (objArr.length <= 1) {
                    str = "";
                } else {
                    str = String.valueOf(objArr[1]);
                }
                if (objArr.length <= 2) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(objArr[2]);
                }
                if (objArr.length <= 3) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(objArr[3]);
                }
                if (objArr.length <= 4) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(objArr[4]);
                }
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.K().S1().l().getId(), this.a.a.K().S1().l().getName(), this.a.a.K().S1().P().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public x(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.N0(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                                                if (this.a.C == null) {
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                                                } else {
                                                    m85.a aVar = new m85.a();
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
                                            }
                                            return;
                                        case 2:
                                            if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                                                if (this.a.F == null) {
                                                    this.a.F = new PermissionJudgePolicy();
                                                }
                                                this.a.F.clearRequestPermissionList();
                                                this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.z == null) {
                                                    s38 s38Var = this.a;
                                                    s38Var.z = new d08(s38Var.a.getPageContext());
                                                }
                                                this.a.z.b(this.a.B, this.a.A.n());
                                                this.a.A = null;
                                                this.a.B = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.G;
                                            if (postData != null) {
                                                postData.D0();
                                                this.a.G = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (this.a.a.checkUpIsLogin()) {
                                                this.a.d0(view2);
                                                if (this.a.a.K().S1().P() != null && this.a.a.K().S1().P().getAuthor() != null && this.a.a.K().S1().P().getAuthor().getUserId() != null && this.a.a.R3() != null) {
                                                    s38 s38Var2 = this.a;
                                                    int S = s38Var2.S(s38Var2.a.K().S1());
                                                    ThreadData P = this.a.a.K().S1().P();
                                                    if (P.isBJHArticleThreadType()) {
                                                        i2 = 2;
                                                    } else if (P.isBJHVideoThreadType()) {
                                                        i2 = 3;
                                                    } else if (!P.isBJHNormalThreadType()) {
                                                        if (P.isBJHVideoDynamicThreadType()) {
                                                            i2 = 5;
                                                        } else {
                                                            i2 = 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.K().m2()).param("obj_locate", 2).param("obj_id", this.a.a.K().S1().P().getAuthor().getUserId()).param("obj_type", !this.a.a.R3().e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                return;
                                            }
                                            Object tag = view2.getTag();
                                            if (tag instanceof String) {
                                                TiebaStatic.log(new StatisticItem("c13079"));
                                                this.a.U((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f09204f, 0);
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f092038, 2);
                                                    this.a.B(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092040) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203e) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09205c) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09205c)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092050)).booleanValue();
                                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                                if (absVideoPbFragment != null && absVideoPbFragment.P() != null) {
                                                    boolean F = this.a.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                                    if (F) {
                                                        if (booleanValue2) {
                                                            this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203e), intValue, booleanValue, null, F);
                                                            return;
                                                        } else {
                                                            this.a.u0(sparseArray3, intValue, booleanValue);
                                                            return;
                                                        }
                                                    } else if (!booleanValue || booleanValue2) {
                                                        this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203e), intValue, booleanValue);
                                                        return;
                                                    } else {
                                                        this.a.u0(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        case 7:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                                                return;
                                            }
                                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                                            if (sparseArray4.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092054)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f09204f, 1);
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092038, 2);
                                                    this.a.B(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092038, 2);
                                                }
                                                sparseArray4.put(R.id.obfuscated_res_0x7f09205d, Boolean.TRUE);
                                                this.a.l0(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!ViewHelper.checkUpIsLogin(this.a.a.getContext()) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
                                            if (postData2.q() == null) {
                                                return;
                                            }
                                            tc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                postData2.q().objSource = findPageExtraByView.a();
                                            }
                                            this.a.C(postData2.q());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null && this.a.a.K().S1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.P() != null) {
                                                this.a.a.P().t1(ru8.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                                if (absVideoPbFragment3 != null && absVideoPbFragment3.H3() != null) {
                                    this.a.a.H3().l2(true);
                                    return;
                                }
                                return;
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e2);
                            this.a.n0(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView != null && agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e2);
                        AgreeView agreeView2 = (AgreeView) view4;
                        this.a.n0(view4);
                        if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917df);
                    this.a.n0(view5);
                    if (view5 != null) {
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e0);
                this.a.n0(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ s38 d;

        public y(s38 s38Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s38Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                if (pu4Var != null) {
                    pu4Var.dismiss();
                }
                this.d.a.w3(((Integer) this.a.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203e), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    public s38(AbsVideoPbFragment absVideoPbFragment) {
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
        this.L = new u(this);
        this.M = new x(this);
        this.O = new a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        a28 a28Var = new a28(this.a.getContext());
        this.x = a28Var;
        a28Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) != null) || metaData == null) {
            return;
        }
        pu4 pu4Var = new pu4(this.a.getActivity());
        pu4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aba));
        pu4Var.setTitleShowCenter(true);
        pu4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0abb));
        pu4Var.setMessageShowCenter(true);
        pu4Var.setCancelable(false);
        pu4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0abc), new n(this, metaData));
        pu4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0abd), new o(this, metaData));
        pu4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        boolean z2;
        List forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            if (i2 == 1) {
                return true;
            }
            if (i2 != 2 && i2 != 3 && i2 != 4) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && this.a.K().S1().W() != null && (forumToolAuth = this.a.K().S1().W().getForumToolAuth()) != null) {
                for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                    ForumToolPerm forumToolPerm = (ForumToolPerm) forumToolAuth.get(i3);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z2)) == null) {
            if (this.a.K() != null && this.a.K().S1() != null) {
                if (this.a.K().S1().X() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.K().S1().P() == null || this.a.K().S1().P().getAuthor() == null || TextUtils.equals(this.a.K().S1().P().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void s0(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f11a9, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b54);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b55);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new f(this, w2, sparseArray));
        aVar2.a(new g(this, w2));
    }

    public boolean Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void l0(View view2) {
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.N = z2;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || !this.a.K().k2()) {
                return false;
            }
            if (this.a.K().Q1() != null && this.a.K().Q1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            pu4 pu4Var = new pu4(this.a.getPageContext().getPageActivity());
            pu4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b5b));
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new b0(this));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c0(this));
            pu4Var.create(this.a.getPageContext()).show();
        }
    }

    public void B(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            C0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = eh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = eh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092094), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(r18.m(i2))));
        }
    }

    public int S(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, uv7Var)) == null) {
            if (uv7Var != null && uv7Var.P() != null) {
                if (uv7Var.P().getThreadType() == 0) {
                    return 1;
                }
                if (uv7Var.P().getThreadType() == 54) {
                    return 2;
                }
                if (uv7Var.P().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void n0(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.N) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09187f, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new qx4();
        }
        if (this.K == null) {
            hn8 hn8Var = new hn8();
            this.K = hn8Var;
            hn8Var.a = this.a.getUniqueId();
        }
        gr4 gr4Var = new gr4();
        gr4Var.b = 5;
        gr4Var.h = 8;
        gr4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null) {
            gr4Var.f = this.a.K().R1();
        }
        gr4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                gr4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment == null && absVideoPbFragment.K() != null && this.a.K().S1() != null) {
                    this.J.b(this.a.P(), gr4Var, agreeData, this.a.K().S1().P());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            gr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            gr4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment == null) {
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().k0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.K().m2(), str);
                ThreadData P2 = this.a.K().S1().P();
                if (P2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (P2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (P2.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, postData) != null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.M() != null && postData.M().equals(this.a.K().N1())) {
            z2 = true;
        }
        MarkData M1 = this.a.K().M1(postData);
        if (this.a.K().S1() != null && this.a.K().S1().k0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData J3 = absVideoPbFragment.J3(absVideoPbFragment.K().S1());
            if (J3 != null) {
                M1 = this.a.K().M1(J3);
            }
        }
        if (M1 == null) {
            return;
        }
        this.a.m5();
        if (this.a.R3() != null) {
            this.a.R3().i(M1);
            if (!z2) {
                this.a.R3().a();
            } else {
                this.a.R3().d();
            }
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
            uv7 S1 = this.a.K().S1();
            if ((S1.P() != null && S1.P().getAuthor() != null && S1.P().getAuthor().isForumBusinessAccount() && !xi6.isOn()) || this.a.K().H()) {
                return false;
            }
            if ((S1.P() != null && S1.P().isBlocked()) || this.a.K().S1().X() == 0 || this.a.K().S1().X() == 3) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.r == null) {
                this.r = new yx4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.e4();
            yu4 yu4Var = this.b;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
            this.a.f4();
            K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.e4();
            yu4 yu4Var = this.b;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
            K();
        }
    }

    public void H() {
        yu4 yu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (yu4Var = this.b) != null) {
            yu4Var.dismiss();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            hh.a().postDelayed(this.I, 100L);
        }
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (alertDialog = this.t) != null) {
            jh.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907c2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.E;
        }
        return invokeV.objValue;
    }

    public final void O0() {
        fz7 fz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (fz7Var = this.u) == null) {
            return;
        }
        fz7Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.L;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public fz7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.u;
        }
        return (fz7) invokeV.objValue;
    }

    public ru4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.s;
        }
        return (ru4) invokeV.objValue;
    }

    public void V() {
        yx4 yx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (yx4Var = this.r) != null) {
            yx4Var.h(false);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return r18.i(this.a.K());
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.i();
        }
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, fj.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray sparseArray, int i2, jo5 jo5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), jo5Var, userData, Boolean.valueOf(z2)}) != null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new ko5(this.a.getPageContext(), this.a.getView(), jo5Var, userData);
        }
        this.w.F(z2);
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
        xs4 xs4Var = new xs4();
        xs4Var.j(sparseArray2);
        this.w.H(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cc), this.a.getString(R.string.obfuscated_res_0x7f0f04cd), this.a.getString(R.string.obfuscated_res_0x7f0f04ce), this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0)});
        this.w.G(xs4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.w.J(str);
        this.w.I(new i(this, sparseArray));
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        List<? extends zu4> c2;
        int i2;
        boolean z17;
        wu4 wu4Var;
        wu4 wu4Var2;
        wu4 wu4Var3;
        wu4 wu4Var4;
        wu4 wu4Var5;
        wu4 wu4Var6;
        pn pnVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
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
                                if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextImageInfo)) {
                                    this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
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
                            G0(this.O, this.A.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
                this.G = postData;
                if (postData == null || this.a.R3() == null) {
                    return true;
                }
                if (this.a.R3().e() && this.G.M() != null && this.G.M().equals(this.a.K().N1())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.a.K().S1() != null && this.a.K().S1().k0()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c == null) {
                    av4 av4Var = new av4(this.a.getContext());
                    this.c = av4Var;
                    av4Var.n(this.M);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (Y(view2) && !z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (Y(view2) && (pnVar = this.A) != null && !pnVar.t()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean) {
                        z6 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092055)).booleanValue();
                    } else {
                        z6 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean) {
                        z7 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                    } else {
                        z7 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                        z8 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                    } else {
                        z8 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean) {
                        z9 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
                    } else {
                        z9 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                        z10 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                    } else {
                        z10 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean) {
                        z11 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                    } else {
                        z11 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f09204c) instanceof String) {
                        str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09204c);
                    } else {
                        str = null;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean) {
                        z12 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092054)).booleanValue();
                    } else {
                        z12 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f09205d) instanceof Boolean) {
                        z13 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).booleanValue();
                    } else {
                        z13 = false;
                    }
                    boolean z18 = z13;
                    if (z4) {
                        z16 = z12;
                        z15 = z11;
                        z14 = z10;
                        arrayList.add(new wu4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10c1), this.c));
                    } else {
                        z14 = z10;
                        z15 = z11;
                        z16 = z12;
                    }
                    if (z5) {
                        arrayList.add(new wu4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10c2), this.c));
                    }
                    if (!z4 && !z5) {
                        wu4 wu4Var7 = new wu4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0459), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.obfuscated_res_0x7f09203c, this.G);
                        wu4Var7.d.setTag(sparseArray3);
                        arrayList.add(wu4Var7);
                    }
                    if (!z6 && !z3) {
                        if (z2) {
                            wu4Var6 = new wu4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1004), this.c);
                        } else {
                            wu4Var6 = new wu4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ab8), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203c, this.G);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
                        wu4Var6.d.setTag(sparseArray4);
                        arrayList.add(wu4Var6);
                    }
                    if (TbadkCoreApplication.isLogin()) {
                        if (!X() && !z9 && z8) {
                            wu4 wu4Var8 = new wu4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b5c), this.c);
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                            sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                            sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                            sparseArray5.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                            wu4Var8.d.setTag(sparseArray5);
                            arrayList.add(wu4Var8);
                        } else {
                            if (b0(z7) && TbadkCoreApplication.isLogin()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !z3) {
                                wu4 wu4Var9 = new wu4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1029), this.c);
                                wu4Var9.d.setTag(str);
                                arrayList.add(wu4Var9);
                            }
                        }
                        if (z9) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                            sparseArray6.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                            sparseArray6.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                            sparseArray6.put(R.id.obfuscated_res_0x7f09204c, str);
                            if (!X() && z14) {
                                sparseArray6.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                                sparseArray6.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                            } else {
                                sparseArray6.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                            }
                            if (z15) {
                                sparseArray6.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                                sparseArray6.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z7));
                                sparseArray6.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                                if (z16) {
                                    wu4Var5 = new wu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b8), this.c);
                                    wu4Var5.d.setTag(sparseArray6);
                                    wu4Var2 = new wu4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                                    wu4Var2.d.setTag(sparseArray6);
                                    wu4Var3 = wu4Var5;
                                    wu4Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                            }
                            wu4Var5 = null;
                            wu4Var2 = new wu4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                            wu4Var2.d.setTag(sparseArray6);
                            wu4Var3 = wu4Var5;
                            wu4Var = null;
                        } else if (z15) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                            sparseArray7.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                            sparseArray7.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                            sparseArray7.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                            sparseArray7.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z7));
                            sparseArray7.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                            sparseArray7.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                            sparseArray7.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                            if (this.a.K().S1().X() == 1002 && !z7) {
                                wu4Var4 = new wu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1029), this.c);
                            } else {
                                wu4Var4 = new wu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b8), this.c);
                            }
                            wu4Var4.d.setTag(sparseArray7);
                            if (z18) {
                                wu4Var = new wu4(13, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b4c), this.c);
                                wu4Var3 = wu4Var4;
                            } else {
                                wu4Var3 = wu4Var4;
                                wu4Var = null;
                            }
                            wu4Var2 = null;
                        } else {
                            wu4Var = null;
                            wu4Var2 = null;
                            wu4Var3 = null;
                        }
                        if (wu4Var3 != null) {
                            arrayList.add(wu4Var3);
                        }
                        if (wu4Var != null) {
                            arrayList.add(wu4Var);
                        }
                        if (wu4Var2 != null) {
                            arrayList.add(wu4Var2);
                        }
                        r18.b(arrayList, this.c, this.G, this.a.K());
                    }
                    if (UbsABTestHelper.isPBPlanA()) {
                        c2 = r18.d(arrayList, this.G.q(), sparseArray, this.c);
                    } else {
                        c2 = r18.c(arrayList, this.G.q(), sparseArray, this.c);
                    }
                    r18.l(c2, this.N);
                    r18.f(c2);
                    this.c.o(r18.g(this.G));
                    if (UbsABTestHelper.isPBPlanA()) {
                        this.c.k(c2, false);
                    } else {
                        this.c.k(c2, true);
                    }
                    yu4 yu4Var = new yu4(this.a.getPageContext(), this.c);
                    this.b = yu4Var;
                    yu4Var.k();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.K().m2()).param("fid", this.a.K().getForumId()).param("uid", this.a.K().S1().P().getAuthor().getUserId()).param("post_id", this.a.K().B());
                    if (z6) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    TiebaStatic.log(param.param("obj_source", i2));
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F0(boolean z2, SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092038) instanceof Integer)) {
            yu4 yu4Var = this.b;
            if (yu4Var != null && yu4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092092);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092094);
            if (!((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                return;
            }
            av4 av4Var = new av4(this.a.getBaseFragmentActivity());
            av4Var.n(new a0(this, sparseArray, z2, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092038) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092038)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new wu4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04b8), av4Var));
            }
            if (z2) {
                arrayList.add(new wu4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14d6), av4Var));
            } else {
                arrayList.add(new wu4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b58), av4Var));
            }
            av4Var.j(arrayList);
            yu4 yu4Var2 = new yu4(this.a.getPageContext(), av4Var);
            this.b = yu4Var2;
            yu4Var2.k();
        }
    }

    public final void J0(pu4 pu4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, pu4Var, i2) == null) && (absVideoPbFragment = this.a) != null && pu4Var != null) {
            if (this.v == null && absVideoPbFragment.getView() != null) {
                this.v = new ho5(this.a.getPageContext(), this.a.getView());
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
            xs4 xs4Var = new xs4();
            xs4Var.j(sparseArray);
            this.v.B(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cc), this.a.getString(R.string.obfuscated_res_0x7f0f04cd), this.a.getString(R.string.obfuscated_res_0x7f0f04ce), this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0)});
            this.v.A(xs4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.v.D(str);
            this.v.C(new h(this, pu4Var));
        }
    }

    public final void t0(int i2, SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048635, this, i2, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.TRUE);
        }
        jo5 jo5Var = new jo5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
        jo5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
        jo5Var.h(this.a.K().S1().l().getImage_url());
        jo5Var.j(this.a.K().S1().l().getUser_level());
        D0(sparseArray, i2, jo5Var, this.a.K().S1().W(), true);
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        fs4 fs4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                return false;
            }
            uv7 S1 = this.a.K().S1();
            ThreadData P2 = S1.P();
            if (P2 != null) {
                if (P2.isBJHArticleThreadType() || P2.isBJHVideoThreadType()) {
                    return false;
                }
                if (P2.isBJHNormalThreadType() || P2.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((P2 != null && P2.getAuthor() != null && P2.getAuthor().isForumBusinessAccount() && !xi6.isOn()) || this.a.K().H() || P2.isWorksInfo() || P2.isScoreThread() || z3) {
                return false;
            }
            if (S1.l() != null && S1.l().isBlockBawuDelete) {
                return false;
            }
            if (S1.P() != null && S1.P().isBlocked()) {
                return false;
            }
            if (S1.X() != 0) {
                if (S1.X() == 3) {
                    return false;
                }
                return true;
            }
            List<zt4> p2 = S1.p();
            if (ListUtils.getCount(p2) <= 0) {
                return false;
            }
            for (zt4 zt4Var : p2) {
                if (zt4Var != null && (fs4Var = zt4Var.f) != null && fs4Var.a && !fs4Var.c && ((i2 = fs4Var.b) == 1 || i2 == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void G0(ru4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            yu4 yu4Var = this.d;
            if (yu4Var != null) {
                yu4Var.dismiss();
                this.d = null;
            }
            av4 av4Var = new av4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.K().S1() != null && this.a.K().S1().P() != null && !this.a.K().S1().P().isBjh()) {
                arrayList.add(new wu4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c1), av4Var));
            }
            if (!z2) {
                arrayList.add(new wu4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c2), av4Var));
            }
            av4Var.j(arrayList);
            av4Var.n(new s(this, cVar));
            yu4 yu4Var2 = new yu4(this.a.getPageContext(), av4Var);
            this.d = yu4Var2;
            yu4Var2.k();
        }
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            tu4 tu4Var = this.h;
            if (tu4Var != null) {
                tu4Var.d();
                this.h = null;
            }
            if (this.a.K() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            String string = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0275);
            boolean z5 = false;
            if (this.a.K().b2() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new cv4(string, "", z2, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b68);
            if (this.a.K().b2() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new cv4(string2, "", z3, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b65);
            if (this.a.K().b2() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new cv4(string3, "", z4, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b86);
            if (this.a.K().b2() == 4) {
                z5 = true;
            }
            arrayList.add(new cv4(string4, "", z5, Integer.toString(7)));
            tu4 tu4Var2 = new tu4(this.a.getPageContext());
            tu4Var2.l(R.string.obfuscated_res_0x7f0f0e14);
            this.h = tu4Var2;
            tu4Var2.k(arrayList, onItemClickListener);
            tu4Var2.c();
            this.h.n();
        }
    }

    public void K0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.K() != null) {
            yu4 yu4Var = new yu4(this.a.getPageContext());
            if (this.a.K().S1().f == null || this.a.K().S1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11e6), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11e7)};
            } else {
                strArr = new String[this.a.K().S1().f.size()];
                for (int i2 = 0; i2 < this.a.K().S1().f.size(); i2++) {
                    strArr[i2] = ((PbSortType) this.a.K().S1().f.get(i2)).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11e4);
                }
            }
            yu4Var.i(null, strArr, new m(this, yu4Var, view2));
            yu4Var.k();
        }
    }

    public void I0(gz7 gz7Var) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, gz7Var) != null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new fz7(absVideoPbFragment, absVideoPbFragment.A1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        boolean z16 = true;
        create.setCanceledOnTouchOutside(true);
        jh.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = fj.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f8);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        fz7 fz7Var = this.u;
        boolean z17 = false;
        if (gz7Var == null) {
            z2 = false;
        } else {
            z2 = gz7Var.a;
        }
        fz7Var.Q(z2);
        fz7 fz7Var2 = this.u;
        if (gz7Var == null) {
            z3 = false;
        } else {
            z3 = gz7Var.n;
        }
        fz7Var2.D(z3);
        fz7 fz7Var3 = this.u;
        if (gz7Var == null) {
            z4 = false;
        } else {
            z4 = gz7Var.e;
        }
        fz7Var3.F(z4);
        fz7 fz7Var4 = this.u;
        if (gz7Var == null) {
            z5 = false;
        } else {
            z5 = gz7Var.i;
        }
        fz7Var4.L(z5);
        fz7 fz7Var5 = this.u;
        if (gz7Var == null) {
            z6 = false;
        } else {
            z6 = gz7Var.f;
        }
        fz7Var5.G(z6);
        fz7 fz7Var6 = this.u;
        if (gz7Var != null) {
            z16 = gz7Var.c;
        }
        fz7Var6.S(z16);
        fz7 fz7Var7 = this.u;
        if (gz7Var == null) {
            z7 = false;
        } else {
            z7 = gz7Var.k;
        }
        fz7Var7.P(z7);
        fz7 fz7Var8 = this.u;
        if (gz7Var == null) {
            z8 = false;
        } else {
            z8 = gz7Var.l;
        }
        fz7Var8.H(z8, gz7Var.t);
        if (gz7Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(gz7Var.g, gz7Var.s);
            this.u.M(gz7Var.h, gz7Var.r);
        }
        if (gz7Var == null) {
            z9 = false;
        } else {
            z9 = gz7Var.q;
        }
        if (gz7Var == null) {
            z10 = false;
        } else {
            z10 = gz7Var.o;
        }
        if (gz7Var == null) {
            z11 = false;
        } else {
            z11 = gz7Var.d;
        }
        if (gz7Var == null) {
            z12 = false;
        } else {
            z12 = gz7Var.b;
        }
        if (gz7Var == null) {
            z13 = false;
        } else {
            z13 = gz7Var.p;
        }
        if (gz7Var == null) {
            z14 = false;
        } else {
            z14 = gz7Var.j;
        }
        if (gz7Var == null) {
            z15 = false;
        } else {
            z15 = gz7Var.m;
        }
        this.u.I(z11, z10);
        this.u.R(z12, z9);
        this.u.O(z14, z13);
        this.u.U(z15);
        if (gz7Var != null) {
            fz7 fz7Var9 = this.u;
            boolean z18 = gz7Var.u;
            fz7Var9.w = z18;
            if (z18) {
                fz7Var9.m().setText(R.string.obfuscated_res_0x7f0f1029);
                this.u.G(false);
            }
        }
        fz7 fz7Var10 = this.u;
        if (gz7Var != null) {
            z17 = gz7Var.v;
        }
        fz7Var10.E(z17);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().R() != null && this.a.K().S1().R().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.obfuscated_res_0x7f0f0857);
        }
        O0();
    }

    public void f0(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e5, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090ce8);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090ce7);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907c1);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907c2);
                this.k = textView2;
                textView2.setOnClickListener(this.a.O3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1400));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ns4 ns4Var = (ns4) arrayList.get(i2);
                    if (ns4Var != null && !TextUtils.isEmpty(ns4Var.b()) && ns4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(ns4Var.a()), ns4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = fj.d(this.a.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = fj.d(this.a.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = fj.d(this.a.getPageContext().getPageActivity(), 120.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            jh.j(this.g, this.a.getPageContext());
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            pu4 pu4Var = this.e;
            if (pu4Var != null) {
                pu4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                jh.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                jh.b(dialog2, this.a.getPageContext());
            }
            yu4 yu4Var = this.q;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.K() != null && this.a.K().S1() != null) {
                return this.a.K().S1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.getPageContext() != null) {
                pu4 pu4Var = new pu4(this.a.getPageContext().getPageActivity());
                pu4Var.setMessage(str);
                pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09c4, new p(this));
                pu4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    public final void M0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                C0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            pu4 pu4Var = new pu4(this.a.getBaseFragmentActivity());
            if (!ej.isEmpty(str)) {
                pu4Var.setMessage(str);
            } else {
                pu4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            }
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043d, new q(this, userMuteAddAndDelCustomMessage));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new r(this));
            pu4Var.create(this.a.getPageContext()).show();
        }
    }

    public void T(boolean z2, String str, SparseArray sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092095);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092097);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092096);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092092) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092092);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092093);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            M0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || this.s != null) {
            return;
        }
        this.s = new ru4(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11e0), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10f3)};
        ru4 ru4Var = this.s;
        ru4Var.j(strArr, new l(this));
        ru4Var.g(ru4.b.obfuscated_res_0x7f1003ad);
        ru4Var.h(17);
        ru4Var.c(this.a.getPageContext());
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
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (i3 == 1002 && !z2) {
                i4 = R.string.obfuscated_res_0x7f0f1026;
            } else {
                i4 = R.string.obfuscated_res_0x7f0f04ad;
            }
            int i5 = R.string.obfuscated_res_0x7f0f0445;
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.obfuscated_res_0x7f0f102a;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f04b1;
                    i4 = R.string.obfuscated_res_0x7f0f04b2;
                }
            }
            this.e = new pu4(this.a.getActivity());
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
                jo5 jo5Var = new jo5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
                jo5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
                jo5Var.h(this.a.K().S1().l().getImage_url());
                jo5Var.j(this.a.K().S1().l().getUser_level());
                D0(sparseArray, i2, jo5Var, this.a.K().S1().W(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray sparseArray, boolean z2) {
        int i2;
        wu4 wu4Var;
        wu4 wu4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            av4 av4Var = new av4(this.a.getContext());
            av4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e8));
            av4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092038) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092038)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09203e)) && i2 != 2) {
                if (sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue();
                }
                if (i3 == 0) {
                    wu4Var2 = new wu4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04c3), av4Var);
                } else {
                    wu4Var2 = new wu4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), av4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray2.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray2.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                wu4Var2.d.setTag(sparseArray2);
                arrayList.add(wu4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09205d) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).booleanValue()) {
                wu4 wu4Var3 = new wu4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b4c), av4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray3.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                wu4Var3.d.setTag(sparseArray3);
                arrayList.add(wu4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092049)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09204a))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                sparseArray4.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                wu4 wu4Var4 = new wu4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0671), av4Var);
                wu4Var4.d.setTag(sparseArray4);
                arrayList.add(wu4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray5.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                if (z2) {
                    wu4Var = new wu4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14d6), av4Var);
                } else {
                    wu4Var = new wu4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b58), av4Var);
                }
                wu4Var.d.setTag(sparseArray5);
                arrayList.add(wu4Var);
            }
            r18.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                av4Var.k(arrayList, false);
            } else {
                av4Var.k(arrayList, true);
            }
            yu4 yu4Var = this.q;
            if (yu4Var == null) {
                this.q = new yu4(this.a.getPageContext(), av4Var);
            } else {
                yu4Var.h(av4Var);
            }
            this.q.k();
        }
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        uv7 S1;
        ThreadData P2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.K() != null && this.a.K().S1() != null && (P2 = (S1 = this.a.K().S1()).P()) != null && P2.getAuthor() != null) {
            this.a.e4();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), P2.getAuthor().getUserId());
            gz7 gz7Var = new gz7();
            int X = this.a.K().S1().X();
            boolean z6 = true;
            if (X != 1 && X != 3) {
                gz7Var.g = false;
            } else {
                gz7Var.g = true;
                if (P2.getIs_top() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                gz7Var.s = z2;
            }
            if (Z(X)) {
                gz7Var.h = true;
                if (P2.getIs_good() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                gz7Var.r = z5;
            } else {
                gz7Var.h = false;
            }
            if (X == 1002 && !equals) {
                gz7Var.u = true;
            }
            gz7Var.n = z0(P2.isBlocked(), S1.n0(), equals, X, P2.isWorksInfo(), P2.isScoreThread());
            gz7Var.e = v0(equals, S1.n0());
            gz7Var.i = A0();
            gz7Var.f = y0(equals);
            if (equals && S1.W() != null && S1.W().showPbPrivate()) {
                z3 = true;
            } else {
                z3 = false;
            }
            gz7Var.k = z3;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                gz7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            gz7Var.t = equals;
            gz7Var.q = this.a.K().k2();
            gz7Var.b = true;
            gz7Var.a = b0(equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            gz7Var.p = z4;
            gz7Var.j = true;
            gz7Var.o = this.a.K().v1();
            gz7Var.d = true;
            if (P2.getThreadVideoInfo() == null) {
                gz7Var.c = true;
            } else {
                gz7Var.c = false;
            }
            if (S1.k0()) {
                gz7Var.b = false;
                gz7Var.d = false;
                gz7Var.c = false;
                gz7Var.g = false;
                gz7Var.h = false;
            }
            gz7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S1.k0()) ? false : false;
            AbsVideoPbFragment absVideoPbFragment2 = this.a;
            if (absVideoPbFragment2.J3(absVideoPbFragment2.K().S1()) != null) {
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                gz7Var.w = absVideoPbFragment3.J3(absVideoPbFragment3.K().S1()).R;
            }
            if (P2.isBlocked()) {
                gz7Var.n = false;
                gz7Var.g = false;
                gz7Var.h = false;
            }
            I0(gz7Var);
        }
    }

    public final void u0(SparseArray sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            r18.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final void w0(SparseArray sparseArray, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048638, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04b8, TBAlertConfig.OperateBtnStyle.MAIN);
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

    public void x0(SparseArray sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        wu4 wu4Var;
        wu4 wu4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null) {
            return;
        }
        if (this.c == null) {
            av4 av4Var = new av4(this.a.getContext());
            this.c = av4Var;
            av4Var.n(this.M);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.K().S1() != null && this.a.K().S1().k0()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (sparseArray != null) {
            if (sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
            } else {
                z3 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                z4 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
            } else {
                z4 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean) {
                z5 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
            } else {
                z5 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                z6 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
            } else {
                z6 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean) {
                z7 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
            } else {
                z7 = false;
            }
            wu4 wu4Var3 = null;
            if (sparseArray.get(R.id.obfuscated_res_0x7f09204c) instanceof String) {
                str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09204c);
            } else {
                str = null;
            }
            if (postData.q() != null) {
                boolean z9 = postData.q().hasAgree;
                int r2 = postData.r();
                if (z9 && r2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0085;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0087;
                }
                wu4 wu4Var4 = new wu4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203c, postData);
                wu4Var4.d.setTag(sparseArray2);
                arrayList.add(wu4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!z5 && z4) {
                    wu4 wu4Var5 = new wu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b5c), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                    wu4Var5.d.setTag(sparseArray3);
                    arrayList.add(wu4Var5);
                } else {
                    if (b0(z3) && TbadkCoreApplication.isLogin()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 && !z2) {
                        wu4 wu4Var6 = new wu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1029), this.c);
                        wu4Var6.d.setTag(str);
                        arrayList.add(wu4Var6);
                    }
                }
                if (z5) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                    sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204c, str);
                    if (z6) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                    }
                    if (z7) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                        wu4 wu4Var7 = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.c);
                        wu4Var7.d.setTag(sparseArray4);
                        wu4Var3 = wu4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                    }
                    wu4 wu4Var8 = new wu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                    wu4Var8.d.setTag(sparseArray4);
                    wu4Var2 = wu4Var8;
                    wu4Var = wu4Var3;
                } else if (z7) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                    if (this.a.K().S1().X() == 1002 && !z3) {
                        wu4Var = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1029), this.c);
                    } else {
                        wu4Var = new wu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.c);
                    }
                    wu4Var.d.setTag(sparseArray5);
                    wu4Var2 = null;
                } else {
                    wu4Var = null;
                    wu4Var2 = null;
                }
                if (wu4Var != null) {
                    arrayList.add(wu4Var);
                }
                if (wu4Var2 != null) {
                    arrayList.add(wu4Var2);
                }
                if (!z3) {
                    arrayList.add(new wu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), this.c));
                }
            }
            this.c.j(arrayList);
            yu4 yu4Var = new yu4(this.a.getPageContext(), this.c);
            this.b = yu4Var;
            yu4Var.k();
        }
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
            if (!z3 || (!z4 && !a0(i2))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
