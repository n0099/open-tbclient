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
import com.baidu.tbadk.core.util.GreyUtil;
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
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.kv4;
import com.baidu.tieba.m95;
import com.baidu.tieba.mv4;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tp5;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.vv4;
import com.baidu.tieba.wp5;
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
public class o58 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int P = 0;
    public static int Q = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public in A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public my4 J;
    public cp8 K;
    public final View.OnLongClickListener L;
    public vv4.e M;
    public boolean N;
    public final mv4.c O;
    public AbsVideoPbFragment a;
    public tv4 b;
    public vv4 c;
    public tv4 d;
    public kv4 e;
    public Dialog f;
    public Dialog g;
    public ov4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public tv4 q;
    public uy4 r;
    public mv4 s;
    public AlertDialog t;
    public a18 u;
    public tp5 v;
    public wp5 w;
    public w38 x;
    public PbFragment.h3 y;
    public y18 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947983351, "Lcom/baidu/tieba/o58;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947983351, "Lcom/baidu/tieba/o58;");
        }
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements mv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public a(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.mv4.c
        public void a(mv4 mv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, mv4Var, i, view2) == null) {
                if (mv4Var != null) {
                    mv4Var.e();
                }
                if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                    if (i == 0) {
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            m95.a aVar = new m95.a();
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
                            o58 o58Var = this.a;
                            o58Var.z = new y18(o58Var.a.getPageContext());
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
    public class a0 implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ o58 e;

        public a0(o58 o58Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o58Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f092096), ((Integer) this.a.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f0920ee);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f0920f0);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f0920ef);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f0920ec));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public b(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.a.v3(kv4Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public b0(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                TiebaStatic.log("c10025");
                kv4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ o58 c;

        public d(o58 o58Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o58Var;
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
                    yi.O(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c81);
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

        public e(o58 o58Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, alertDialog};
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
        public final /* synthetic */ o58 c;

        public f(o58 o58Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o58Var;
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
                    yi.O(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c81);
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

        public g(o58 o58Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, alertDialog};
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
    public class h implements tp5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ o58 b;

        public h(o58 o58Var, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, kv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.tp5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.v3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements wp5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ o58 b;

        public i(o58 o58Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.wp5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.u3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ o58 b;

        public j(o58 o58Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f0920b4), sparseArray.get(R.id.obfuscated_res_0x7f0920a1), sparseArray.get(R.id.obfuscated_res_0x7f0920a4), sparseArray.get(R.id.obfuscated_res_0x7f0920a2), sparseArray.get(R.id.obfuscated_res_0x7f0920a3)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed), sparseArray);
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
        public final /* synthetic */ o58 a;

        public k(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                ch.a(this.a.t, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements mv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public l(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.mv4.c
        public void a(mv4 mv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, mv4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    o58 o58Var = this.a;
                    o58Var.H = o58Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new vz7(this.a.a.K().m2(), this.a.H, "1").start();
                    mv4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    o58 o58Var2 = this.a;
                    o58Var2.H = o58Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new vz7(this.a.a.K().m2(), this.a.H, "2").start();
                    mv4Var.e();
                } else if (i == 2) {
                    o58 o58Var3 = this.a;
                    o58Var3.H = o58Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    mv4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ o58 c;

        public m(o58 o58Var, tv4 tv4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, tv4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o58Var;
            this.a = tv4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.K().j2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.vv4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void n0(vv4 vv4Var, int i, View view2) {
            boolean L3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
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
                    if (this.b.getId() != R.id.obfuscated_res_0x7f0918bb) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.K().S1().f != null && this.c.a.K().S1().f.size() > i) {
                        i = this.c.a.K().S1().f.get(i).sort_type.intValue();
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
                if (this.b.getId() != R.id.obfuscated_res_0x7f0918bb) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.K().S1().f != null) {
                    i = this.c.a.K().S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.K().L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                if (!L3) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(o58 o58Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, metaData};
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

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ o58 b;

        public o(o58 o58Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                kv4Var.dismiss();
                if (this.b.a.E3() != null) {
                    this.b.a.E3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.K().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ o58 b;

        public q(o58 o58Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv4.c a;
        public final /* synthetic */ o58 b;

        public s(o58 o58Var, mv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public t(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
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
        public final /* synthetic */ o58 a;

        public u(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
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
        public final /* synthetic */ o58 a;

        public v(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                ch.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public w(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
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
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.K().S1().X().getUserId());
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
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.K().S1().l().getId(), this.a.a.K().S1().l().getName(), this.a.a.K().S1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public x(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
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
                                                    m95.a aVar = new m95.a();
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
                                                    o58 o58Var = this.a;
                                                    o58Var.z = new y18(o58Var.a.getPageContext());
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
                                                postData.F0();
                                                this.a.G = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (this.a.a.checkUpIsLogin()) {
                                                this.a.d0(view2);
                                                if (this.a.a.K().S1().Q() != null && this.a.a.K().S1().Q().getAuthor() != null && this.a.a.K().S1().Q().getAuthor().getUserId() != null && this.a.a.R3() != null) {
                                                    o58 o58Var2 = this.a;
                                                    int S = o58Var2.S(o58Var2.a.K().S1());
                                                    ThreadData Q = this.a.a.K().S1().Q();
                                                    if (Q.isBJHArticleThreadType()) {
                                                        i2 = 2;
                                                    } else if (Q.isBJHVideoThreadType()) {
                                                        i2 = 3;
                                                    } else if (!Q.isBJHNormalThreadType()) {
                                                        if (Q.isBJHVideoDynamicThreadType()) {
                                                            i2 = 5;
                                                        } else {
                                                            i2 = 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.K().m2()).param("obj_locate", 2).param("obj_id", this.a.a.K().S1().Q().getAuthor().getUserId()).param("obj_type", !this.a.a.R3().e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
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
                                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f0920a7, 0);
                                                    sparseArray2.put(R.id.obfuscated_res_0x7f092090, 2);
                                                    this.a.B(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092098) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092096) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f0920b4) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f0920b4)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f0920a8)).booleanValue();
                                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                                if (absVideoPbFragment != null && absVideoPbFragment.P() != null) {
                                                    boolean F = this.a.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                                    if (F) {
                                                        if (booleanValue2) {
                                                            this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f092096), intValue, booleanValue, null, F);
                                                            return;
                                                        } else {
                                                            this.a.u0(sparseArray3, intValue, booleanValue);
                                                            return;
                                                        }
                                                    } else if (!booleanValue || booleanValue2) {
                                                        this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f092096), intValue, booleanValue);
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
                                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                                                return;
                                            }
                                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                                            if (sparseArray4.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a7, 1);
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092090, 2);
                                                    this.a.B(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.obfuscated_res_0x7f092090, 2);
                                                }
                                                sparseArray4.put(R.id.obfuscated_res_0x7f0920b5, Boolean.TRUE);
                                                this.a.l0(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!ViewHelper.checkUpIsLogin(this.a.a.getContext()) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
                                            if (postData2.q() == null) {
                                                return;
                                            }
                                            xd5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                postData2.q().objSource = findPageExtraByView.a();
                                            }
                                            this.a.C(postData2.q());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null && this.a.a.K().S1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.P() != null) {
                                                this.a.a.P().u1(mw8.c(view2));
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
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09182a);
                            this.a.n0(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView != null && agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09182a);
                        AgreeView agreeView2 = (AgreeView) view4;
                        this.a.n0(view4);
                        if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091827);
                    this.a.n0(view5);
                    if (view5 != null) {
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091828);
                this.a.n0(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ o58 d;

        public y(o58 o58Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o58Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                if (kv4Var != null) {
                    kv4Var.dismiss();
                }
                this.d.a.w3(((Integer) this.a.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f092096), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    public o58(AbsVideoPbFragment absVideoPbFragment) {
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
        w38 w38Var = new w38(this.a.getContext());
        this.x = w38Var;
        w38Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) != null) || metaData == null) {
            return;
        }
        kv4 kv4Var = new kv4(this.a.getActivity());
        kv4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ac8));
        kv4Var.setTitleShowCenter(true);
        kv4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ac9));
        kv4Var.setMessageShowCenter(true);
        kv4Var.setCancelable(false);
        kv4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aca), new n(this, metaData));
        kv4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0acb), new o(this, metaData));
        kv4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        boolean z2;
        List<ForumToolPerm> forumToolAuth;
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
            if (z2 && this.a.K().S1().X() != null && (forumToolAuth = this.a.K().S1().X().getForumToolAuth()) != null) {
                for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
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
                if (this.a.K().S1().Y() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.K().S1().Q() == null || this.a.K().S1().Q().getAuthor() == null || TextUtils.equals(this.a.K().S1().Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void s0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f0920aa, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f11cd, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0377, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b62);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b63);
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
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
            kv4 kv4Var = new kv4(this.a.getPageContext().getPageActivity());
            kv4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b69));
            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3d, new b0(this));
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new c0(this));
            kv4Var.create(this.a.getPageContext()).show();
        }
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            C0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = xg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = xg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed), 0L);
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
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(n38.n(i2))));
        }
    }

    public int S(px7 px7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, px7Var)) == null) {
            if (px7Var != null && px7Var.Q() != null) {
                if (px7Var.Q().getThreadType() == 0) {
                    return 1;
                }
                if (px7Var.Q().getThreadType() == 54) {
                    return 2;
                }
                if (px7Var.Q().getThreadType() == 40) {
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
        sparseArray.put(R.id.obfuscated_res_0x7f0918cb, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new my4();
        }
        if (this.K == null) {
            cp8 cp8Var = new cp8();
            this.K = cp8Var;
            cp8Var.a = this.a.getUniqueId();
        }
        zr4 zr4Var = new zr4();
        zr4Var.b = 5;
        zr4Var.h = 8;
        zr4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null) {
            zr4Var.f = this.a.K().R1();
        }
        zr4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                zr4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment == null && absVideoPbFragment.K() != null && this.a.K().S1() != null) {
                    this.J.b(this.a.P(), zr4Var, agreeData, this.a.K().S1().Q());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            zr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            zr4Var.i = 1;
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
            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.K().m2(), str);
                ThreadData Q2 = this.a.K().S1().Q();
                if (Q2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q2.isBJHVideoThreadType()) {
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
        if (this.a.K().S1() != null && this.a.K().S1().l0()) {
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
            px7 S1 = this.a.K().S1();
            if ((S1.Q() != null && S1.Q().getAuthor() != null && S1.Q().getAuthor().isForumBusinessAccount() && !uk6.isOn()) || this.a.K().H()) {
                return false;
            }
            if ((S1.Q() != null && S1.Q().isBlocked()) || this.a.K().S1().Y() == 0 || this.a.K().S1().Y() == 3) {
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
                this.r = new uy4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.e4();
            tv4 tv4Var = this.b;
            if (tv4Var != null) {
                tv4Var.dismiss();
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
            tv4 tv4Var = this.b;
            if (tv4Var != null) {
                tv4Var.dismiss();
            }
            K();
        }
    }

    public void H() {
        tv4 tv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (tv4Var = this.b) != null) {
            tv4Var.dismiss();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            ah.a().postDelayed(this.I, 100L);
        }
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (alertDialog = this.t) != null) {
            ch.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907d1);
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
        a18 a18Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (a18Var = this.u) == null) {
            return;
        }
        a18Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.L;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public a18 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.u;
        }
        return (a18) invokeV.objValue;
    }

    public mv4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.s;
        }
        return (mv4) invokeV.objValue;
    }

    public void V() {
        uy4 uy4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (uy4Var = this.r) != null) {
            uy4Var.h(false);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return n38.j(this.a.K());
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
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, yi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray<Object> sparseArray, int i2, vp5 vp5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), vp5Var, userData, Boolean.valueOf(z2)}) != null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new wp5(this.a.getPageContext(), this.a.getView(), vp5Var, userData);
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
        qt4 qt4Var = new qt4();
        qt4Var.j(sparseArray2);
        this.w.H(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0), this.a.getString(R.string.obfuscated_res_0x7f0f04d1), this.a.getString(R.string.obfuscated_res_0x7f0f04d2), this.a.getString(R.string.obfuscated_res_0x7f0f04d3)});
        this.w.G(qt4Var);
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
        List<rv4> c2;
        int i2;
        boolean z17;
        rv4 rv4Var;
        rv4 rv4Var2;
        rv4 rv4Var3;
        rv4 rv4Var4;
        rv4 rv4Var5;
        rv4 rv4Var6;
        in inVar;
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
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
                                if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextImageInfo)) {
                                    this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
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
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
                this.G = postData;
                if (postData == null || this.a.R3() == null) {
                    return true;
                }
                if (this.a.R3().e() && this.G.M() != null && this.G.M().equals(this.a.K().N1())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.a.K().S1() != null && this.a.K().S1().l0()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c == null) {
                    vv4 vv4Var = new vv4(this.a.getContext());
                    this.c = vv4Var;
                    vv4Var.n(this.M);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (Y(view2) && !z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (Y(view2) && (inVar = this.A) != null && !inVar.t()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920ad) instanceof Boolean) {
                        z6 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ad)).booleanValue();
                    } else {
                        z6 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean) {
                        z7 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                    } else {
                        z7 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                        z8 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                    } else {
                        z8 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean) {
                        z9 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
                    } else {
                        z9 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                        z10 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                    } else {
                        z10 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean) {
                        z11 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
                    } else {
                        z11 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof String) {
                        str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920a4);
                    } else {
                        str = null;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean) {
                        z12 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue();
                    } else {
                        z12 = false;
                    }
                    if (sparseArray.get(R.id.obfuscated_res_0x7f0920b5) instanceof Boolean) {
                        z13 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920b5)).booleanValue();
                    } else {
                        z13 = false;
                    }
                    boolean z18 = z13;
                    if (z4) {
                        z16 = z12;
                        z15 = z11;
                        z14 = z10;
                        arrayList.add(new rv4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10e2), this.c));
                    } else {
                        z14 = z10;
                        z15 = z11;
                        z16 = z12;
                    }
                    if (z5) {
                        arrayList.add(new rv4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10e3), this.c));
                    }
                    if (!z4 && !z5) {
                        rv4 rv4Var7 = new rv4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f045c), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.obfuscated_res_0x7f092094, this.G);
                        rv4Var7.d.setTag(sparseArray3);
                        arrayList.add(rv4Var7);
                    }
                    if (!z6 && !z3) {
                        if (z2) {
                            rv4Var6 = new rv4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1025), this.c);
                        } else {
                            rv4Var6 = new rv4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ac6), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.obfuscated_res_0x7f092094, this.G);
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
                        rv4Var6.d.setTag(sparseArray4);
                        arrayList.add(rv4Var6);
                    }
                    if (TbadkCoreApplication.isLogin()) {
                        if (!X() && !z9 && z8) {
                            rv4 rv4Var8 = new rv4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b6a), this.c);
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                            rv4Var8.d.setTag(sparseArray5);
                            arrayList.add(rv4Var8);
                        } else {
                            if (b0(z7) && TbadkCoreApplication.isLogin()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !z3) {
                                rv4 rv4Var9 = new rv4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f104a), this.c);
                                rv4Var9.d.setTag(str);
                                arrayList.add(rv4Var9);
                            }
                        }
                        if (z9) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                            sparseArray6.put(R.id.obfuscated_res_0x7f0920a4, str);
                            if (!X() && z14) {
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                            } else {
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                            }
                            if (z15) {
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                                sparseArray6.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z7));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                                sparseArray6.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                                if (z16) {
                                    rv4Var5 = new rv4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bb), this.c);
                                    rv4Var5.d.setTag(sparseArray6);
                                    rv4Var2 = new rv4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e9), this.c);
                                    rv4Var2.d.setTag(sparseArray6);
                                    rv4Var3 = rv4Var5;
                                    rv4Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                            }
                            rv4Var5 = null;
                            rv4Var2 = new rv4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e9), this.c);
                            rv4Var2.d.setTag(sparseArray6);
                            rv4Var3 = rv4Var5;
                            rv4Var = null;
                        } else if (z15) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                            sparseArray7.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                            sparseArray7.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                            sparseArray7.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                            sparseArray7.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z7));
                            sparseArray7.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray7.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                            sparseArray7.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                            if (this.a.K().S1().Y() == 1002 && !z7) {
                                rv4Var4 = new rv4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f104a), this.c);
                            } else {
                                rv4Var4 = new rv4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bb), this.c);
                            }
                            rv4Var4.d.setTag(sparseArray7);
                            if (z18) {
                                rv4Var = new rv4(13, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b5a), this.c);
                                rv4Var3 = rv4Var4;
                            } else {
                                rv4Var3 = rv4Var4;
                                rv4Var = null;
                            }
                            rv4Var2 = null;
                        } else {
                            rv4Var = null;
                            rv4Var2 = null;
                            rv4Var3 = null;
                        }
                        if (rv4Var3 != null) {
                            arrayList.add(rv4Var3);
                        }
                        if (rv4Var != null) {
                            arrayList.add(rv4Var);
                        }
                        if (rv4Var2 != null) {
                            arrayList.add(rv4Var2);
                        }
                        n38.b(arrayList, this.c, this.G, this.a.K());
                    }
                    if (UbsABTestHelper.isPBPlanA()) {
                        c2 = n38.d(arrayList, this.G.q(), sparseArray, this.c);
                    } else {
                        c2 = n38.c(arrayList, this.G.q(), sparseArray, this.c);
                    }
                    n38.m(c2, this.N);
                    n38.f(c2);
                    this.c.o(n38.h(this.G));
                    if (UbsABTestHelper.isPBPlanA()) {
                        this.c.k(c2, false);
                    } else {
                        this.c.k(c2, true);
                    }
                    tv4 tv4Var = new tv4(this.a.getPageContext(), this.c);
                    this.b = tv4Var;
                    tv4Var.k();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.K().m2()).param("fid", this.a.K().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.K().B());
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

    public void F0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f0920ed) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof Integer)) {
            tv4 tv4Var = this.b;
            if (tv4Var != null && tv4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920eb);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed);
            if (!((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                return;
            }
            vv4 vv4Var = new vv4(this.a.getBaseFragmentActivity());
            vv4Var.n(new a0(this, sparseArray, z2, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092090)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new rv4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04bb), vv4Var));
            }
            if (z2) {
                arrayList.add(new rv4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14fb), vv4Var));
            } else {
                arrayList.add(new rv4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b66), vv4Var));
            }
            vv4Var.j(arrayList);
            tv4 tv4Var2 = new tv4(this.a.getPageContext(), vv4Var);
            this.b = tv4Var2;
            tv4Var2.k();
        }
    }

    public final void J0(kv4 kv4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, kv4Var, i2) == null) && (absVideoPbFragment = this.a) != null && kv4Var != null) {
            if (this.v == null && absVideoPbFragment.getView() != null) {
                this.v = new tp5(this.a.getPageContext(), this.a.getView());
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
            qt4 qt4Var = new qt4();
            qt4Var.j(sparseArray);
            this.v.B(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0), this.a.getString(R.string.obfuscated_res_0x7f0f04d1), this.a.getString(R.string.obfuscated_res_0x7f0f04d2), this.a.getString(R.string.obfuscated_res_0x7f0f04d3)});
            this.v.A(qt4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.v.D(str);
            this.v.C(new h(this, kv4Var));
        }
    }

    public final void t0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048635, this, i2, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f0920aa, Boolean.TRUE);
        }
        vp5 vp5Var = new vp5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
        vp5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
        vp5Var.h(this.a.K().S1().l().getImage_url());
        vp5Var.j(this.a.K().S1().l().getUser_level());
        D0(sparseArray, i2, vp5Var, this.a.K().S1().X(), true);
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        ys4 ys4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                return false;
            }
            px7 S1 = this.a.K().S1();
            ThreadData Q2 = S1.Q();
            if (Q2 != null) {
                if (Q2.isBJHArticleThreadType() || Q2.isBJHVideoThreadType()) {
                    return false;
                }
                if (Q2.isBJHNormalThreadType() || Q2.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((Q2 != null && Q2.getAuthor() != null && Q2.getAuthor().isForumBusinessAccount() && !uk6.isOn()) || this.a.K().H() || Q2.isWorksInfo() || Q2.isScoreThread() || z3) {
                return false;
            }
            if (S1.l() != null && S1.l().isBlockBawuDelete) {
                return false;
            }
            if (S1.Q() != null && S1.Q().isBlocked()) {
                return false;
            }
            if (S1.Y() != 0) {
                if (S1.Y() == 3) {
                    return false;
                }
                return true;
            }
            List<tu4> p2 = S1.p();
            if (ListUtils.getCount(p2) <= 0) {
                return false;
            }
            for (tu4 tu4Var : p2) {
                if (tu4Var != null && (ys4Var = tu4Var.f) != null && ys4Var.a && !ys4Var.c && ((i2 = ys4Var.b) == 1 || i2 == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void G0(mv4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            tv4 tv4Var = this.d;
            if (tv4Var != null) {
                tv4Var.dismiss();
                this.d = null;
            }
            vv4 vv4Var = new vv4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.K().S1() != null && this.a.K().S1().Q() != null && !this.a.K().S1().Q().isBjh()) {
                arrayList.add(new rv4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e2), vv4Var));
            }
            if (!z2) {
                arrayList.add(new rv4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e3), vv4Var));
            }
            vv4Var.j(arrayList);
            vv4Var.n(new s(this, cVar));
            tv4 tv4Var2 = new tv4(this.a.getPageContext(), vv4Var);
            this.d = tv4Var2;
            tv4Var2.k();
        }
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            ov4 ov4Var = this.h;
            if (ov4Var != null) {
                ov4Var.d();
                this.h = null;
            }
            if (this.a.K() == null) {
                return;
            }
            ArrayList<xv4> arrayList = new ArrayList<>();
            String string = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0276);
            boolean z5 = false;
            if (this.a.K().b2() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new xv4(string, "", z2, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b76);
            if (this.a.K().b2() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new xv4(string2, "", z3, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b73);
            if (this.a.K().b2() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new xv4(string3, "", z4, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b94);
            if (this.a.K().b2() == 4) {
                z5 = true;
            }
            arrayList.add(new xv4(string4, "", z5, Integer.toString(7)));
            ov4 ov4Var2 = new ov4(this.a.getPageContext());
            ov4Var2.l(R.string.obfuscated_res_0x7f0f0e30);
            this.h = ov4Var2;
            ov4Var2.k(arrayList, onItemClickListener);
            ov4Var2.c();
            this.h.n();
        }
    }

    public void K0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.K() != null) {
            tv4 tv4Var = new tv4(this.a.getPageContext());
            if (this.a.K().S1().f == null || this.a.K().S1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f120a), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f120b)};
            } else {
                strArr = new String[this.a.K().S1().f.size()];
                for (int i2 = 0; i2 < this.a.K().S1().f.size(); i2++) {
                    strArr[i2] = this.a.K().S1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1208);
                }
            }
            tv4Var.i(null, strArr, new m(this, tv4Var, view2));
            tv4Var.k();
        }
    }

    public void I0(b18 b18Var) {
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
        if ((interceptable != null && interceptable.invokeL(1048592, this, b18Var) != null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new a18(absVideoPbFragment, absVideoPbFragment.A1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        GreyUtil.grey(create);
        boolean z16 = true;
        this.t.setCanceledOnTouchOutside(true);
        ch.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = yi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f9);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        if (WindowGreySwitch.getIsOn()) {
            u9.b(window.getDecorView());
        }
        a18 a18Var = this.u;
        boolean z17 = false;
        if (b18Var == null) {
            z2 = false;
        } else {
            z2 = b18Var.a;
        }
        a18Var.Q(z2);
        a18 a18Var2 = this.u;
        if (b18Var == null) {
            z3 = false;
        } else {
            z3 = b18Var.n;
        }
        a18Var2.D(z3);
        a18 a18Var3 = this.u;
        if (b18Var == null) {
            z4 = false;
        } else {
            z4 = b18Var.e;
        }
        a18Var3.F(z4);
        a18 a18Var4 = this.u;
        if (b18Var == null) {
            z5 = false;
        } else {
            z5 = b18Var.i;
        }
        a18Var4.L(z5);
        a18 a18Var5 = this.u;
        if (b18Var == null) {
            z6 = false;
        } else {
            z6 = b18Var.f;
        }
        a18Var5.G(z6);
        a18 a18Var6 = this.u;
        if (b18Var != null) {
            z16 = b18Var.c;
        }
        a18Var6.S(z16);
        a18 a18Var7 = this.u;
        if (b18Var == null) {
            z7 = false;
        } else {
            z7 = b18Var.k;
        }
        a18Var7.P(z7);
        a18 a18Var8 = this.u;
        if (b18Var == null) {
            z8 = false;
        } else {
            z8 = b18Var.l;
        }
        a18Var8.H(z8, b18Var.t);
        if (b18Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(b18Var.g, b18Var.s);
            this.u.M(b18Var.h, b18Var.r);
        }
        if (b18Var == null) {
            z9 = false;
        } else {
            z9 = b18Var.q;
        }
        if (b18Var == null) {
            z10 = false;
        } else {
            z10 = b18Var.o;
        }
        if (b18Var == null) {
            z11 = false;
        } else {
            z11 = b18Var.d;
        }
        if (b18Var == null) {
            z12 = false;
        } else {
            z12 = b18Var.b;
        }
        if (b18Var == null) {
            z13 = false;
        } else {
            z13 = b18Var.p;
        }
        if (b18Var == null) {
            z14 = false;
        } else {
            z14 = b18Var.j;
        }
        if (b18Var == null) {
            z15 = false;
        } else {
            z15 = b18Var.m;
        }
        this.u.I(z11, z10);
        this.u.R(z12, z9);
        this.u.O(z14, z13);
        this.u.U(z15);
        if (b18Var != null) {
            a18 a18Var9 = this.u;
            boolean z18 = b18Var.u;
            a18Var9.w = z18;
            if (z18) {
                a18Var9.m().setText(R.string.obfuscated_res_0x7f0f104a);
                this.u.G(false);
            }
        }
        a18 a18Var10 = this.u;
        if (b18Var != null) {
            z17 = b18Var.v;
        }
        a18Var10.E(z17);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().S() != null && this.a.K().S1().S().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.obfuscated_res_0x7f0f085f);
        }
        O0();
    }

    public void f0(ArrayList<gt4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e7, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090d08);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090d07);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907d0);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907d1);
                this.k = textView2;
                textView2.setOnClickListener(this.a.O3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1425));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    gt4 gt4Var = arrayList.get(i2);
                    if (gt4Var != null && !TextUtils.isEmpty(gt4Var.b()) && gt4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(gt4Var.a()), gt4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
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
                        layoutParams2.height = yi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = yi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = yi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            ch.j(this.g, this.a.getPageContext());
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            kv4 kv4Var = this.e;
            if (kv4Var != null) {
                kv4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                ch.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                ch.b(dialog2, this.a.getPageContext());
            }
            tv4 tv4Var = this.q;
            if (tv4Var != null) {
                tv4Var.dismiss();
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
                kv4 kv4Var = new kv4(this.a.getPageContext().getPageActivity());
                kv4Var.setMessage(str);
                kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d4, new p(this));
                kv4Var.create(this.a.getPageContext()).show();
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
            kv4 kv4Var = new kv4(this.a.getBaseFragmentActivity());
            if (!xi.isEmpty(str)) {
                kv4Var.setMessage(str);
            } else {
                kv4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0324, str3));
            }
            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0440, new q(this, userMuteAddAndDelCustomMessage));
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new r(this));
            kv4Var.create(this.a.getPageContext()).show();
        }
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920ee) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ee);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920f0) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920f0);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920ef) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ef);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920eb) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920eb);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920ec) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ec);
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
        this.s = new mv4(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f036b), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1204), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1114)};
        mv4 mv4Var = this.s;
        mv4Var.j(strArr, new l(this));
        mv4Var.g(mv4.b.obfuscated_res_0x7f1003ad);
        mv4Var.h(17);
        mv4Var.c(this.a.getPageContext());
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
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (i3 == 1002 && !z2) {
                i4 = R.string.obfuscated_res_0x7f0f1047;
            } else {
                i4 = R.string.obfuscated_res_0x7f0f04b0;
            }
            int i5 = R.string.obfuscated_res_0x7f0f0448;
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.obfuscated_res_0x7f0f104b;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f04b4;
                    i4 = R.string.obfuscated_res_0x7f0f04b5;
                }
            }
            this.e = new kv4(this.a.getActivity());
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
                vp5 vp5Var = new vp5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
                vp5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
                vp5Var.h(this.a.K().S1().l().getImage_url());
                vp5Var.j(this.a.K().S1().l().getUser_level());
                D0(sparseArray, i2, vp5Var, this.a.K().S1().X(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        rv4 rv4Var;
        rv4 rv4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            vv4 vv4Var = new vv4(this.a.getContext());
            vv4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e9));
            vv4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092090)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092096)) && i2 != 2) {
                if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue();
                }
                if (i3 == 0) {
                    rv4Var2 = new rv4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04c6), vv4Var);
                } else {
                    rv4Var2 = new rv4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), vv4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray2.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray2.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                rv4Var2.d.setTag(sparseArray2);
                arrayList.add(rv4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920b5) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920b5)).booleanValue()) {
                rv4 rv4Var3 = new rv4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b5a), vv4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                rv4Var3.d.setTag(sparseArray3);
                arrayList.add(rv4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f0920a1)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f0920a2))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a4, sparseArray.get(R.id.obfuscated_res_0x7f0920a4));
                rv4 rv4Var4 = new rv4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0675), vv4Var);
                rv4Var4.d.setTag(sparseArray4);
                arrayList.add(rv4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920eb, sparseArray.get(R.id.obfuscated_res_0x7f0920eb));
                if (z2) {
                    rv4Var = new rv4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14fb), vv4Var);
                } else {
                    rv4Var = new rv4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b66), vv4Var);
                }
                rv4Var.d.setTag(sparseArray5);
                arrayList.add(rv4Var);
            }
            n38.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                vv4Var.k(arrayList, false);
            } else {
                vv4Var.k(arrayList, true);
            }
            tv4 tv4Var = this.q;
            if (tv4Var == null) {
                this.q = new tv4(this.a.getPageContext(), vv4Var);
            } else {
                tv4Var.h(vv4Var);
            }
            this.q.k();
        }
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        px7 S1;
        ThreadData Q2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.K() != null && this.a.K().S1() != null && (Q2 = (S1 = this.a.K().S1()).Q()) != null && Q2.getAuthor() != null) {
            this.a.e4();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q2.getAuthor().getUserId());
            b18 b18Var = new b18();
            int Y = this.a.K().S1().Y();
            boolean z6 = true;
            if (Y != 1 && Y != 3) {
                b18Var.g = false;
            } else {
                b18Var.g = true;
                if (Q2.getIs_top() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                b18Var.s = z2;
            }
            if (Z(Y)) {
                b18Var.h = true;
                if (Q2.getIs_good() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                b18Var.r = z5;
            } else {
                b18Var.h = false;
            }
            if (Y == 1002 && !equals) {
                b18Var.u = true;
            }
            b18Var.n = z0(Q2.isBlocked(), S1.o0(), equals, Y, Q2.isWorksInfo(), Q2.isScoreThread());
            b18Var.e = v0(equals, S1.o0());
            b18Var.i = A0();
            b18Var.f = y0(equals);
            if (equals && S1.X() != null && S1.X().showPbPrivate()) {
                z3 = true;
            } else {
                z3 = false;
            }
            b18Var.k = z3;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                b18Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            b18Var.t = equals;
            b18Var.q = this.a.K().k2();
            b18Var.b = true;
            b18Var.a = b0(equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            b18Var.p = z4;
            b18Var.j = true;
            b18Var.o = this.a.K().v1();
            b18Var.d = true;
            if (Q2.getThreadVideoInfo() == null) {
                b18Var.c = true;
            } else {
                b18Var.c = false;
            }
            if (S1.l0()) {
                b18Var.b = false;
                b18Var.d = false;
                b18Var.c = false;
                b18Var.g = false;
                b18Var.h = false;
            }
            b18Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S1.l0()) ? false : false;
            AbsVideoPbFragment absVideoPbFragment2 = this.a;
            if (absVideoPbFragment2.J3(absVideoPbFragment2.K().S1()) != null) {
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                b18Var.w = absVideoPbFragment3.J3(absVideoPbFragment3.K().S1()).S;
            }
            if (Q2.isBlocked()) {
                b18Var.n = false;
                b18Var.g = false;
                b18Var.h = false;
            }
            I0(b18Var);
        }
    }

    public final void u0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            n38.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final void w0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048638, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04bb, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0377, TBAlertConfig.OperateBtnStyle.SECONDARY);
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
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        rv4 rv4Var;
        rv4 rv4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) == null) {
            return;
        }
        if (this.c == null) {
            vv4 vv4Var = new vv4(this.a.getContext());
            this.c = vv4Var;
            vv4Var.n(this.M);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.K().S1() != null && this.a.K().S1().l0()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (sparseArray != null) {
            if (sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
            } else {
                z3 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                z4 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
            } else {
                z4 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean) {
                z5 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
            } else {
                z5 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                z6 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
            } else {
                z6 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean) {
                z7 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
            } else {
                z7 = false;
            }
            rv4 rv4Var3 = null;
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof String) {
                str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920a4);
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
                rv4 rv4Var4 = new rv4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f092094, postData);
                rv4Var4.d.setTag(sparseArray2);
                arrayList.add(rv4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!z5 && z4) {
                    rv4 rv4Var5 = new rv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b6a), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                    rv4Var5.d.setTag(sparseArray3);
                    arrayList.add(rv4Var5);
                } else {
                    if (b0(z3) && TbadkCoreApplication.isLogin()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 && !z2) {
                        rv4 rv4Var6 = new rv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f104a), this.c);
                        rv4Var6.d.setTag(str);
                        arrayList.add(rv4Var6);
                    }
                }
                if (z5) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                    sparseArray4.put(R.id.obfuscated_res_0x7f0920a4, str);
                    if (z6) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                    }
                    if (z7) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                        rv4 rv4Var7 = new rv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.c);
                        rv4Var7.d.setTag(sparseArray4);
                        rv4Var3 = rv4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                    }
                    rv4 rv4Var8 = new rv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e9), this.c);
                    rv4Var8.d.setTag(sparseArray4);
                    rv4Var2 = rv4Var8;
                    rv4Var = rv4Var3;
                } else if (z7) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                    sparseArray5.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                    if (this.a.K().S1().Y() == 1002 && !z3) {
                        rv4Var = new rv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f104a), this.c);
                    } else {
                        rv4Var = new rv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.c);
                    }
                    rv4Var.d.setTag(sparseArray5);
                    rv4Var2 = null;
                } else {
                    rv4Var = null;
                    rv4Var2 = null;
                }
                if (rv4Var != null) {
                    arrayList.add(rv4Var);
                }
                if (rv4Var2 != null) {
                    arrayList.add(rv4Var2);
                }
                if (!z3) {
                    arrayList.add(new rv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), this.c));
                }
            }
            this.c.j(arrayList);
            tv4 tv4Var = new tv4(this.a.getPageContext(), this.c);
            this.b = tv4Var;
            tv4Var.k();
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
