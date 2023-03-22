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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.b05;
import com.baidu.tieba.k05;
import com.baidu.tieba.ne5;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.qw5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tw5;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.zz4;
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
public class kq8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int P = 0;
    public static int Q = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public rm A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public bc9 G;
    public String H;
    public Runnable I;
    public i35 J;
    public rb9 K;
    public final View.OnLongClickListener L;
    public k05.f M;
    public boolean N;
    public final b05.c O;
    public AbsVideoPbFragment a;
    public i05 b;
    public k05 c;
    public i05 d;
    public zz4 e;
    public Dialog f;
    public Dialog g;
    public d05 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public i05 q;
    public p35 r;
    public b05 s;
    public AlertDialog t;
    public vl8 u;
    public qw5 v;
    public tw5 w;
    public so8 x;
    public PbFragment.h3 y;
    public tm8 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947921847, "Lcom/baidu/tieba/kq8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947921847, "Lcom/baidu/tieba/kq8;");
        }
    }

    public boolean b0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ kq8 d;

        public a0(kq8 kq8Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kq8Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (zz4Var != null) {
                    zz4Var.dismiss();
                }
                this.d.a.K3(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public b(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.b05.c
        public void a(b05 b05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b05Var, i, view2) == null) {
                if (b05Var != null) {
                    b05Var.e();
                }
                if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                    if (i == 0) {
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            ne5.a aVar = new ne5.a();
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
                            kq8 kq8Var = this.a;
                            kq8Var.z = new tm8(kq8Var.a.getPageContext());
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
    public class b0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b0(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public c(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.a.J3(zz4Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ kq8 e;

        public c0(kq8 kq8Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kq8Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.h0(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.N0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public d0(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log("c10025");
                zz4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ kq8 c;

        public e(kq8 kq8Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kq8Var;
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
                    hi.P(this.c.a.M(), R.string.obfuscated_res_0x7f0f0d1f);
                } else {
                    this.c.a.I3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public f(kq8 kq8Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, alertDialog};
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ kq8 c;

        public g(kq8 kq8Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kq8Var;
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
                    hi.P(this.c.a.M(), R.string.obfuscated_res_0x7f0f0d1f);
                } else {
                    this.c.a.I3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public h(kq8 kq8Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, alertDialog};
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
    public class i implements qw5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;
        public final /* synthetic */ kq8 b;

        public i(kq8 kq8Var, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, zz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq8Var;
            this.a = zz4Var;
        }

        @Override // com.baidu.tieba.qw5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.J3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements tw5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ kq8 b;

        public j(kq8 kq8Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq8Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.tw5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.I3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public k(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                lg.a(this.a.t, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ kq8 b;

        public l(kq8 kq8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq8Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.h0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.U(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment != null && absVideoPbFragment.V3() != null) {
                            this.b.a.V3().y2(true);
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
    public class m implements b05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public m(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.b05.c
        public void a(b05 b05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, b05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    kq8 kq8Var = this.a;
                    kq8Var.H = kq8Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new qk8(this.a.a.L().Q1(), this.a.H, "1").start();
                    b05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    kq8 kq8Var2 = this.a;
                    kq8Var2.H = kq8Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new qk8(this.a.a.L().Q1(), this.a.H, "2").start();
                    b05Var.e();
                } else if (i == 2) {
                    kq8 kq8Var3 = this.a;
                    kq8Var3.H = kq8Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    b05Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i05 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ kq8 c;

        public n(kq8 kq8Var, i05 i05Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, i05Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kq8Var;
            this.a = i05Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.L().N1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.k05.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void M0(k05 k05Var, int i, View view2) {
            boolean u3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.a.dismiss();
                int i2 = 3;
                int i3 = 0;
                if (this.c.a.L().N1() != 1 || i != 1) {
                    if (this.c.a.L().N1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.L().N1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091a0d) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.L().w1().f != null && this.c.a.L().w1().f.size() > i) {
                        i = this.c.a.L().w1().f.get(i).sort_type.intValue();
                    }
                    u3 = this.c.a.L().u3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.L().M1()));
                    if (!u3) {
                        this.c.a.t5(true);
                        return;
                    }
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                StatisticItem statisticItem2 = new StatisticItem("c12097");
                if (this.b.getId() != R.id.obfuscated_res_0x7f091a0d) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.L().w1().f != null) {
                    i = this.c.a.L().w1().f.get(i).sort_type.intValue();
                }
                u3 = this.c.a.L().u3(i);
                this.b.setTag(Integer.valueOf(this.c.a.L().M1()));
                if (!u3) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public o(kq8 kq8Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, metaData};
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ kq8 b;

        public p(kq8 kq8Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq8Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                zz4Var.dismiss();
                if (this.b.a.S3() != null) {
                    this.b.a.S3().i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.L().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ kq8 b;

        public r(kq8 kq8Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq8Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.b.D0();
                MessageManager.getInstance().sendMessage(this.a);
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b05.c a;
        public final /* synthetic */ kq8 b;

        public t(kq8 kq8Var, b05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq8Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements k05.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public u(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.k05.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.q(jo8.h(this.a.G));
                ArrayList arrayList = new ArrayList();
                for (j05 j05Var : this.a.c.g()) {
                    if (j05Var instanceof g05) {
                        arrayList.add((g05) j05Var);
                    }
                }
                jo8.f(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public v(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
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
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public w(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                lg.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public x(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.F(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class y implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public y(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
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
                    this.a.a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.L().w1().X().getUserId());
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
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.L().w1().l().getId(), this.a.a.L().w1().l().getName(), this.a.a.L().w1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public z(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.O0(i);
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
                                                    ne5.a aVar = new ne5.a();
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
                                                    kq8 kq8Var = this.a;
                                                    kq8Var.z = new tm8(kq8Var.a.getPageContext());
                                                }
                                                this.a.z.b(this.a.B, this.a.A.n());
                                                this.a.A = null;
                                                this.a.B = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            bc9 bc9Var = this.a.G;
                                            if (bc9Var != null) {
                                                bc9Var.H0();
                                                this.a.G = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.e0(view2);
                                            if (this.a.a.L().w1().Q() != null && this.a.a.L().w1().Q().getAuthor() != null && this.a.a.L().w1().Q().getAuthor().getUserId() != null && this.a.a.f4() != null) {
                                                kq8 kq8Var2 = this.a;
                                                int T = kq8Var2.T(kq8Var2.a.L().w1());
                                                ThreadData Q = this.a.a.L().w1().Q();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.L().Q1()).param("obj_locate", 2).param("obj_id", this.a.a.L().w1().Q().getAuthor().getUserId()).param("obj_type", !this.a.a.f4().e()).param("obj_source", T).param("obj_param1", i2));
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag = view2.getTag();
                                            if (tag instanceof String) {
                                                TiebaStatic.log(new StatisticItem("c13079"));
                                                this.a.V((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.C(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                                if (absVideoPbFragment != null && absVideoPbFragment.M() != null) {
                                                    boolean G = this.a.a.M().G(TbadkCoreApplication.getCurrentAccount());
                                                    if (G) {
                                                        if (booleanValue2) {
                                                            this.a.j0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                                            return;
                                                        } else {
                                                            this.a.v0(sparseArray3, intValue, booleanValue);
                                                            return;
                                                        }
                                                    } else if (!booleanValue || booleanValue2) {
                                                        this.a.h0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                        return;
                                                    } else {
                                                        this.a.v0(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        case 7:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                            if (sparseArray4.get(R.id.tag_is_self_post) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.tag_is_self_post)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.tag_from, 1);
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                    this.a.C(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                sparseArray4.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                                                this.a.m0(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.h0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!ViewHelper.checkUpIsLogin(this.a.a.getContext()) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            bc9 bc9Var2 = (bc9) sparseArray.get(R.id.tag_clip_board);
                                            if (bc9Var2.o() == null) {
                                                return;
                                            }
                                            zj5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                bc9Var2.o().objSource = findPageExtraByView.a();
                                            }
                                            this.a.D(bc9Var2.o());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.L() != null && this.a.a.L().w1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.M() != null) {
                                                this.a.a.M().V1(nj9.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                                if (absVideoPbFragment3 != null && absVideoPbFragment3.V3() != null) {
                                    this.a.a.V3().y2(true);
                                    return;
                                }
                                return;
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            this.a.o0(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView != null && agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView2 = (AgreeView) view4;
                        this.a.o0(view4);
                        if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                    this.a.o0(view5);
                    if (view5 != null) {
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.o0(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    public kq8(AbsVideoPbFragment absVideoPbFragment) {
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
        this.L = new x(this);
        this.M = new z(this);
        this.O = new b(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        so8 so8Var = new so8(this.a.getContext());
        this.x = so8Var;
        so8Var.b(this.a.getUniqueId());
        this.y = new y(this);
    }

    public void C0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, metaData) != null) || metaData == null) {
            return;
        }
        zz4 zz4Var = new zz4(this.a.getActivity());
        zz4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b5e));
        zz4Var.setTitleShowCenter(true);
        zz4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b5f));
        zz4Var.setMessageShowCenter(true);
        zz4Var.setCancelable(false);
        zz4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b60), new o(this, metaData));
        zz4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b61), new p(this, metaData));
        zz4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        boolean z2;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            if (i2 == 1) {
                return true;
            }
            if (i2 != 2 && i2 != 3 && i2 != 4) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && this.a.L().w1().X() != null && (forumToolAuth = this.a.L().w1().X().getForumToolAuth()) != null) {
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

    public final boolean c0(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z2)) == null) {
            if (this.a.L() != null && this.a.L().w1() != null) {
                if (this.a.L().w1().Y() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.L().w1().Q() == null || this.a.L().w1().Q().getAuthor() == null || TextUtils.equals(this.a.L().w1().Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void t0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1260, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.M());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        androidx.appcompat.app.AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new g(this, z2, sparseArray));
        aVar2.a(new h(this, z2));
    }

    public boolean Z(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void e0(View view2) {
        SparseArray sparseArray;
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            f0(bc9Var);
        }
    }

    public void m0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        l0(sparseArray, false);
    }

    public void q0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            this.N = z2;
        }
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean A0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            if (z2) {
                return false;
            }
            if (z5 || z6) {
                return true;
            }
            if (!z3 || (!z4 && !b0(i2))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.L() == null || !this.a.L().O1()) {
                return false;
            }
            if (this.a.L().u1() != null && this.a.L().u1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            zz4 zz4Var = new zz4(this.a.getPageContext().getPageActivity());
            zz4Var.setMessage(this.a.getResources().getString(R.string.mute_is_super_member_function));
            zz4Var.setPositiveButton(R.string.open_now, new d0(this));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new a(this));
            zz4Var.create(this.a.getPageContext()).show();
        }
    }

    public void C(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            D0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = gg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = gg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void O0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.L().Q1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(jo8.n(i2))));
        }
    }

    public int T(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, ki8Var)) == null) {
            if (ki8Var != null && ki8Var.Q() != null) {
                if (ki8Var.Q().getThreadType() == 0) {
                    return 1;
                }
                if (ki8Var.Q().getThreadType() == 54) {
                    return 2;
                }
                if (ki8Var.Q().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void o0(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, view2) != null) || view2 == null) {
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
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void D(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new i35();
        }
        if (this.K == null) {
            rb9 rb9Var = new rb9();
            this.K = rb9Var;
            rb9Var.a = this.a.getUniqueId();
        }
        nw4 nw4Var = new nw4();
        nw4Var.b = 5;
        nw4Var.h = 8;
        nw4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.L() != null) {
            nw4Var.f = this.a.L().v1();
        }
        nw4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                nw4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment == null && absVideoPbFragment.L() != null && this.a.L().w1() != null) {
                    this.J.b(this.a.M(), nw4Var, agreeData, this.a.L().w1().Q());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            nw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            nw4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment == null) {
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            if (this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.L().Q1(), str);
                ThreadData Q2 = this.a.L().w1().Q();
                if (Q2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q2.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                d0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void f0(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, bc9Var) != null) || bc9Var == null) {
            return;
        }
        boolean z2 = false;
        if (bc9Var.O() != null && bc9Var.O().equals(this.a.L().r1())) {
            z2 = true;
        }
        MarkData q1 = this.a.L().q1(bc9Var);
        if (this.a.L().w1() != null && this.a.L().w1().l0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            bc9 X3 = absVideoPbFragment.X3(absVideoPbFragment.L().w1());
            if (X3 != null) {
                q1 = this.a.L().q1(X3);
            }
        }
        if (q1 == null) {
            return;
        }
        this.a.z5();
        if (this.a.f4() != null) {
            this.a.f4().i(q1);
            if (!z2) {
                this.a.f4().a();
            } else {
                this.a.f4().d();
            }
        }
    }

    public final boolean z0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.L() == null || this.a.L().w1() == null || (this.a.L().w1().l() != null && this.a.L().w1().l().isBlockBawuDelete)) {
                return false;
            }
            ki8 w1 = this.a.L().w1();
            if ((w1.Q() != null && w1.Q().getAuthor() != null && w1.Q().getAuthor().isForumBusinessAccount() && !sx6.isOn()) || this.a.L().Z()) {
                return false;
            }
            if ((w1.Q() != null && w1.Q().isBlocked()) || this.a.L().w1().Y() == 0 || this.a.L().w1().Y() == 3) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.r == null) {
                this.r = new p35(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            J();
            this.a.s4();
            i05 i05Var = this.b;
            if (i05Var != null) {
                i05Var.dismiss();
            }
            this.a.t4();
            L();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            J();
            this.a.s4();
            i05 i05Var = this.b;
            if (i05Var != null) {
                i05Var.dismiss();
            }
            L();
        }
    }

    public void I() {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (i05Var = this.b) != null) {
            i05Var.dismiss();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            jg.a().postDelayed(this.I, 100L);
        }
    }

    public void K() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (alertDialog = this.t) != null) {
            lg.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public Object P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.E;
        }
        return invokeV.objValue;
    }

    public final void P0() {
        vl8 vl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || (vl8Var = this.u) == null) {
            return;
        }
        vl8Var.F();
    }

    public View.OnLongClickListener Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.L;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public vl8 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.u;
        }
        return (vl8) invokeV.objValue;
    }

    public b05 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.s;
        }
        return (b05) invokeV.objValue;
    }

    public void W() {
        p35 p35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (p35Var = this.r) != null) {
            p35Var.h(false);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return jo8.j(this.a.L());
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.x.i();
        }
    }

    public final CustomBlueCheckRadioButton E(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, hi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void E0(SparseArray<Object> sparseArray, int i2, sw5 sw5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{sparseArray, Integer.valueOf(i2), sw5Var, userData, Boolean.valueOf(z2)}) != null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new tw5(this.a.getPageContext(), this.a.getView(), sw5Var, userData);
        }
        this.w.F(z2);
        AntiData M = M();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (M != null && M.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = M.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        fy4 fy4Var = new fy4();
        fy4Var.j(sparseArray2);
        this.w.H(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
        this.w.G(fy4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.w.J(str);
        this.w.I(new j(this, sparseArray));
    }

    public final boolean F(View view2) {
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
        List<g05> c2;
        int i2;
        boolean z17;
        g05 g05Var;
        g05 g05Var2;
        g05 g05Var3;
        g05 g05Var4;
        g05 g05Var5;
        g05 g05Var6;
        rm rmVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e2) {
                    e2.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (Z(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.A = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.B = url;
                            if (this.A == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
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
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
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
                                if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.C = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
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
                            H0(this.O, this.A.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                bc9 bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board);
                this.G = bc9Var;
                if (bc9Var == null || this.a.f4() == null) {
                    return true;
                }
                if (this.a.f4().e() && this.G.O() != null && this.G.O().equals(this.a.L().r1())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.a.L().w1() != null && this.a.L().w1().l0()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c == null) {
                    k05 k05Var = new k05(this.a.getContext());
                    this.c = k05Var;
                    k05Var.p(this.M);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (Z(view2) && !z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (Z(view2) && (rmVar = this.A) != null && !rmVar.t()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (sparseArray.get(R.id.tag_is_subpb) instanceof Boolean) {
                        z6 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                    } else {
                        z6 = false;
                    }
                    if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                        z7 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    } else {
                        z7 = false;
                    }
                    if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z8 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z8 = false;
                    }
                    if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                        z9 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                    } else {
                        z9 = false;
                    }
                    if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z10 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z10 = false;
                    }
                    if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                        z11 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                    } else {
                        z11 = false;
                    }
                    if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                        str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                    } else {
                        str = null;
                    }
                    if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                        z12 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
                    } else {
                        z12 = false;
                    }
                    if (sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) {
                        z13 = ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue();
                    } else {
                        z13 = false;
                    }
                    boolean z18 = z13;
                    if (z4) {
                        z16 = z12;
                        z15 = z11;
                        z14 = z10;
                        arrayList.add(new g05(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.c));
                    } else {
                        z14 = z10;
                        z15 = z11;
                        z16 = z12;
                    }
                    if (z5) {
                        arrayList.add(new g05(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.c));
                    }
                    if (!z4 && !z5) {
                        g05 g05Var7 = new g05(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f047b), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.G);
                        g05Var7.d.setTag(sparseArray3);
                        arrayList.add(g05Var7);
                    }
                    if (!z6 && !z3) {
                        if (z2) {
                            g05Var6 = new g05(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.c);
                        } else {
                            g05Var6 = new g05(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b5c), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.G);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        g05Var6.d.setTag(sparseArray4);
                        arrayList.add(g05Var6);
                    }
                    if (TbadkCoreApplication.isLogin()) {
                        if (!Y() && !z9 && z8) {
                            g05 g05Var8 = new g05(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c00), this.c);
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            sparseArray5.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            g05Var8.d.setTag(sparseArray5);
                            arrayList.add(g05Var8);
                        } else {
                            if (c0(z7) && TbadkCoreApplication.isLogin()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !z3) {
                                g05 g05Var9 = new g05(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                                g05Var9.d.setTag(str);
                                arrayList.add(g05Var9);
                            }
                        }
                        if (z9) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray6.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                            sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                            sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                            sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                            if (!Y() && z14) {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            } else {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            }
                            if (z15) {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray6.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                sparseArray6.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                sparseArray6.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                                if (z16) {
                                    g05Var5 = new g05(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04db), this.c);
                                    g05Var5.d.setTag(sparseArray6);
                                    g05Var2 = new g05(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02f2), this.c);
                                    g05Var2.d.setTag(sparseArray6);
                                    g05Var3 = g05Var5;
                                    g05Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            g05Var5 = null;
                            g05Var2 = new g05(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02f2), this.c);
                            g05Var2.d.setTag(sparseArray6);
                            g05Var3 = g05Var5;
                            g05Var = null;
                        } else if (z15) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray7.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (this.a.L().w1().Y() == 1002 && !z7) {
                                g05Var4 = new g05(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                            } else {
                                g05Var4 = new g05(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04db), this.c);
                            }
                            g05Var4.d.setTag(sparseArray7);
                            if (z18) {
                                g05Var = new g05(13, TbadkCoreApplication.getInst().getString(R.string.multi_delete), this.c);
                                g05Var3 = g05Var4;
                            } else {
                                g05Var3 = g05Var4;
                                g05Var = null;
                            }
                            g05Var2 = null;
                        } else {
                            g05Var = null;
                            g05Var2 = null;
                            g05Var3 = null;
                        }
                        if (g05Var3 != null) {
                            arrayList.add(g05Var3);
                        }
                        if (g05Var != null) {
                            arrayList.add(g05Var);
                        }
                        if (g05Var2 != null) {
                            arrayList.add(g05Var2);
                        }
                        jo8.b(arrayList, this.c, this.G, this.a.L());
                    }
                    if (UbsABTestHelper.isPBPlanA()) {
                        c2 = jo8.d(arrayList, this.G.o(), sparseArray, this.c);
                    } else {
                        c2 = jo8.c(arrayList, this.G.o(), sparseArray, this.c);
                    }
                    jo8.m(c2, this.N);
                    jo8.f(c2);
                    this.c.q(jo8.h(this.G));
                    this.c.l(c2, !UbsABTestHelper.isPBPlanA());
                    this.b = new i05(this.a.getPageContext(), this.c);
                    this.c.o(new u(this));
                    this.b.k();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.L().Q1()).param("fid", this.a.L().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.L().T());
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

    public void G0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048587, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            i05 i05Var = this.b;
            if (i05Var != null && i05Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            k05 k05Var = new k05(this.a.getBaseFragmentActivity());
            k05Var.p(new c0(this, sparseArray, z2, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new g05(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04db), k05Var));
            }
            if (z2) {
                arrayList.add(new g05(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), k05Var));
            } else {
                arrayList.add(new g05(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0bfc), k05Var));
            }
            k05Var.k(arrayList);
            i05 i05Var2 = new i05(this.a.getPageContext(), k05Var);
            this.b = i05Var2;
            i05Var2.k();
        }
    }

    public final void K0(zz4 zz4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048595, this, zz4Var, i2) == null) && (absVideoPbFragment = this.a) != null && zz4Var != null) {
            if (this.v == null && absVideoPbFragment.getView() != null) {
                this.v = new qw5(this.a.getPageContext(), this.a.getView());
            }
            AntiData M = M();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (M != null && M.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = M.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            fy4 fy4Var = new fy4();
            fy4Var.j(sparseArray);
            this.v.B(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
            this.v.A(fy4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.v.D(str);
            this.v.C(new i(this, zz4Var));
        }
    }

    public final void u0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048636, this, i2, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        sw5 sw5Var = new sw5(this.a.L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.L().w1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.L().w1().o().has_forum_rule.intValue());
        sw5Var.i(this.a.L().w1().l().getId(), this.a.L().w1().l().getName());
        sw5Var.h(this.a.L().w1().l().getImage_url());
        sw5Var.j(this.a.L().w1().l().getUser_level());
        E0(sparseArray, i2, sw5Var, this.a.L().w1().X(), true);
    }

    public final boolean w0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        nx4 nx4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.L() == null || this.a.L().w1() == null) {
                return false;
            }
            ki8 w1 = this.a.L().w1();
            ThreadData Q2 = w1.Q();
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
            if ((Q2 != null && Q2.getAuthor() != null && Q2.getAuthor().isForumBusinessAccount() && !sx6.isOn()) || this.a.L().Z() || Q2.isWorksInfo() || Q2.isScoreThread() || z3) {
                return false;
            }
            if (w1.l() != null && w1.l().isBlockBawuDelete) {
                return false;
            }
            if (w1.Q() != null && w1.Q().isBlocked()) {
                return false;
            }
            if (w1.Y() != 0) {
                if (w1.Y() == 3) {
                    return false;
                }
                return true;
            }
            List<iz4> p2 = w1.p();
            if (ListUtils.getCount(p2) <= 0) {
                return false;
            }
            for (iz4 iz4Var : p2) {
                if (iz4Var != null && (nx4Var = iz4Var.f) != null && nx4Var.a && !nx4Var.c && ((i2 = nx4Var.b) == 1 || i2 == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void H0(b05.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, cVar, z2) == null) {
            i05 i05Var = this.d;
            if (i05Var != null) {
                i05Var.dismiss();
                this.d = null;
            }
            k05 k05Var = new k05(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.L().w1() != null && this.a.L().w1().Q() != null && !this.a.L().w1().Q().isBjh()) {
                arrayList.add(new g05(0, this.a.getPageContext().getString(R.string.save_to_emotion), k05Var));
            }
            if (!z2) {
                arrayList.add(new g05(1, this.a.getPageContext().getString(R.string.save_to_local), k05Var));
            }
            k05Var.k(arrayList);
            k05Var.p(new t(this, cVar));
            i05 i05Var2 = new i05(this.a.getPageContext(), k05Var);
            this.d = i05Var2;
            i05Var2.k();
        }
    }

    public void I0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onItemClickListener) == null) {
            d05 d05Var = this.h;
            if (d05Var != null) {
                d05Var.d();
                this.h = null;
            }
            if (this.a.L() == null) {
                return;
            }
            ArrayList<m05> arrayList = new ArrayList<>();
            String string = this.a.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.a.L().F1() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new m05(string, "", z2, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.my_fans);
            if (this.a.L().F1() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new m05(string2, "", z3, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.my_attentions);
            if (this.a.L().F1() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new m05(string3, "", z4, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.myself_only);
            if (this.a.L().F1() == 4) {
                z5 = true;
            }
            arrayList.add(new m05(string4, "", z5, Integer.toString(7)));
            d05 d05Var2 = new d05(this.a.getPageContext());
            d05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.h = d05Var2;
            d05Var2.k(arrayList, onItemClickListener);
            d05Var2.c();
            this.h.n();
        }
    }

    public void L0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.L() != null) {
            i05 i05Var = new i05(this.a.getPageContext());
            if (this.a.L().w1().f == null || this.a.L().w1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                strArr = new String[this.a.L().w1().f.size()];
                for (int i2 = 0; i2 < this.a.L().w1().f.size(); i2++) {
                    strArr[i2] = this.a.L().w1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                }
            }
            i05Var.i(null, strArr, new n(this, i05Var, view2));
            i05Var.k();
        }
    }

    public void J0(wl8 wl8Var) {
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
        if ((interceptable != null && interceptable.invokeL(1048593, this, wl8Var) != null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new vl8(absVideoPbFragment, absVideoPbFragment.z1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100108).create();
        this.t = create;
        GreyUtil.grey(create);
        boolean z16 = true;
        this.t.setCanceledOnTouchOutside(true);
        lg.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = hi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f100404);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.B());
        vl8 vl8Var = this.u;
        boolean z17 = false;
        if (wl8Var == null) {
            z2 = false;
        } else {
            z2 = wl8Var.a;
        }
        vl8Var.T(z2);
        vl8 vl8Var2 = this.u;
        if (wl8Var == null) {
            z3 = false;
        } else {
            z3 = wl8Var.n;
        }
        vl8Var2.G(z3);
        vl8 vl8Var3 = this.u;
        if (wl8Var == null) {
            z4 = false;
        } else {
            z4 = wl8Var.e;
        }
        vl8Var3.I(z4);
        vl8 vl8Var4 = this.u;
        if (wl8Var == null) {
            z5 = false;
        } else {
            z5 = wl8Var.i;
        }
        vl8Var4.O(z5);
        vl8 vl8Var5 = this.u;
        if (wl8Var == null) {
            z6 = false;
        } else {
            z6 = wl8Var.f;
        }
        vl8Var5.J(z6);
        vl8 vl8Var6 = this.u;
        if (wl8Var != null) {
            z16 = wl8Var.c;
        }
        vl8Var6.V(z16);
        vl8 vl8Var7 = this.u;
        if (wl8Var == null) {
            z7 = false;
        } else {
            z7 = wl8Var.k;
        }
        vl8Var7.S(z7);
        vl8 vl8Var8 = this.u;
        if (wl8Var == null) {
            z8 = false;
        } else {
            z8 = wl8Var.l;
        }
        vl8Var8.L(z8, wl8Var.t);
        if (wl8Var == null) {
            this.u.Q(false, false);
            this.u.P(false, false);
        } else {
            this.u.Q(wl8Var.g, wl8Var.s);
            this.u.P(wl8Var.h, wl8Var.r);
        }
        if (wl8Var == null) {
            z9 = false;
        } else {
            z9 = wl8Var.q;
        }
        if (wl8Var == null) {
            z10 = false;
        } else {
            z10 = wl8Var.o;
        }
        if (wl8Var == null) {
            z11 = false;
        } else {
            z11 = wl8Var.d;
        }
        if (wl8Var == null) {
            z12 = false;
        } else {
            z12 = wl8Var.b;
        }
        if (wl8Var == null) {
            z13 = false;
        } else {
            z13 = wl8Var.p;
        }
        if (wl8Var == null) {
            z14 = false;
        } else {
            z14 = wl8Var.j;
        }
        if (wl8Var == null) {
            z15 = false;
        } else {
            z15 = wl8Var.m;
        }
        this.u.M(z11, z10);
        this.u.U(z12, z9);
        this.u.R(z14, z13);
        this.u.Y(z15);
        if (wl8Var != null) {
            vl8 vl8Var9 = this.u;
            boolean z18 = wl8Var.u;
            vl8Var9.A = z18;
            if (z18) {
                vl8Var9.n().setText(R.string.report_text);
                this.u.J(false);
            }
        }
        vl8 vl8Var10 = this.u;
        if (wl8Var != null) {
            z17 = wl8Var.v;
        }
        vl8Var10.H(z17);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().S() != null && this.a.L().w1().S().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.l().setText(R.string.have_called_fans_short);
        }
        P0();
    }

    public void g0(ArrayList<vx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003b0);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.good_scroll);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dc);
                this.g.getWindow().setAttributes(attributes);
                this.p = new v(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new w(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.a.c4());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton E = E("0", this.a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(E);
            E.setChecked(true);
            this.j.addView(E);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    vx4 vx4Var = arrayList.get(i2);
                    if (vx4Var != null && !TextUtils.isEmpty(vx4Var.b()) && vx4Var.a() > 0) {
                        CustomBlueCheckRadioButton E2 = E(String.valueOf(vx4Var.a()), vx4Var.b());
                        this.m.add(E2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(E2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = hi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = hi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = hi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            lg.j(this.g, this.a.getPageContext());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            zz4 zz4Var = this.e;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                lg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                lg.b(dialog2, this.a.getPageContext());
            }
            i05 i05Var = this.q;
            if (i05Var != null) {
                i05Var.dismiss();
            }
        }
    }

    public AntiData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.a.L() != null && this.a.L().w1() != null) {
                return this.a.L().w1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.L().w1().l().getDeletedReasonInfo() == null || 1 != this.a.L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.getPageContext() != null) {
                zz4 zz4Var = new zz4(this.a.getPageContext().getPageActivity());
                zz4Var.setMessage(str);
                zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a66, new q(this));
                zz4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    public final void N0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                D0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            zz4 zz4Var = new zz4(this.a.getBaseFragmentActivity());
            if (!gi.isEmpty(str)) {
                zz4Var.setMessage(str);
            } else {
                zz4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            }
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045e, new r(this, userMuteAddAndDelCustomMessage));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new s(this));
            zz4Var.create(this.a.getPageContext()).show();
        }
    }

    public void U(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_msg) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
            }
            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            N0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || this.s != null) {
            return;
        }
        this.s = new b05(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.call_phone), this.a.getPageContext().getString(R.string.sms_phone), this.a.getPageContext().getString(R.string.search_in_baidu)};
        b05 b05Var = this.s;
        b05Var.j(strArr, new m(this));
        b05Var.g(b05.b.a);
        b05Var.h(17);
        b05Var.c(this.a.getPageContext());
    }

    public void h0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            i0(i2, str, i3, z2, null);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            j0(i2, str, i3, z2, str2, false);
        }
    }

    public void j0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_post_confirm;
            } else {
                i4 = R.string.del_all_post_confirm;
            }
            int i5 = R.string.confirm_title;
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i5 = R.string.del_my_thread_confirm;
                    i4 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.e = new zz4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f0523, new c(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f051b, new d(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                x0(sparseArray, i5, i4);
            } else if (z2) {
                x0(sparseArray, i5, i4);
            } else if (s0()) {
                sw5 sw5Var = new sw5(this.a.L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.L().w1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.L().w1().o().has_forum_rule.intValue());
                sw5Var.i(this.a.L().w1().l().getId(), this.a.L().w1().l().getName());
                sw5Var.h(this.a.L().w1().l().getImage_url());
                sw5Var.j(this.a.L().w1().l().getUser_level());
                E0(sparseArray, i2, sw5Var, this.a.L().w1().X(), false);
            } else {
                K0(this.e, i2);
            }
        }
    }

    public void k0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (z2) {
                t0(sparseArray);
            } else {
                u0(i2, sparseArray);
            }
        }
    }

    public void l0(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        g05 g05Var;
        g05 g05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, sparseArray, z2) == null) {
            k05 k05Var = new k05(this.a.getContext());
            k05Var.s(this.a.getString(R.string.obfuscated_res_0x7f0f02f2));
            k05Var.p(new l(this, z2));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i2 != 2) {
                if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                }
                if (i3 == 0) {
                    g05Var2 = new g05(10, this.a.getString(R.string.obfuscated_res_0x7f0f04e8), k05Var);
                } else {
                    g05Var2 = new g05(10, this.a.getString(R.string.obfuscated_res_0x7f0f04db), k05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                g05Var2.d.setTag(sparseArray2);
                arrayList.add(g05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                g05 g05Var3 = new g05(13, this.a.getString(R.string.multi_delete), k05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                g05Var3.d.setTag(sparseArray3);
                arrayList.add(g05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                g05 g05Var4 = new g05(11, this.a.getString(R.string.forbidden_person), k05Var);
                g05Var4.d.setTag(sparseArray4);
                arrayList.add(g05Var4);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray5.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
                if (z2) {
                    g05Var = new g05(12, this.a.getString(R.string.un_mute), k05Var);
                } else {
                    g05Var = new g05(12, this.a.getString(R.string.obfuscated_res_0x7f0f0bfc), k05Var);
                }
                g05Var.d.setTag(sparseArray5);
                arrayList.add(g05Var);
            }
            jo8.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                k05Var.l(arrayList, false);
            } else {
                k05Var.l(arrayList, true);
            }
            i05 i05Var = this.q;
            if (i05Var == null) {
                this.q = new i05(this.a.getPageContext(), k05Var);
            } else {
                i05Var.h(k05Var);
            }
            this.q.k();
        }
    }

    public void n0() {
        AbsVideoPbFragment absVideoPbFragment;
        ki8 w1;
        ThreadData Q2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.L() != null && this.a.L().w1() != null && (Q2 = (w1 = this.a.L().w1()).Q()) != null && Q2.getAuthor() != null) {
            this.a.s4();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q2.getAuthor().getUserId());
            wl8 wl8Var = new wl8();
            int Y = this.a.L().w1().Y();
            boolean z6 = true;
            if (Y != 1 && Y != 3) {
                wl8Var.g = false;
            } else {
                wl8Var.g = true;
                if (Q2.getIs_top() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                wl8Var.s = z2;
            }
            if (a0(Y)) {
                wl8Var.h = true;
                if (Q2.getIs_good() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                wl8Var.r = z5;
            } else {
                wl8Var.h = false;
            }
            if (Y == 1002 && !equals) {
                wl8Var.u = true;
            }
            wl8Var.n = A0(Q2.isBlocked(), w1.o0(), equals, Y, Q2.isWorksInfo(), Q2.isScoreThread());
            wl8Var.e = w0(equals, w1.o0());
            wl8Var.i = B0();
            wl8Var.f = z0(equals);
            if (equals && w1.X() != null && w1.X().showPbPrivate()) {
                z3 = true;
            } else {
                z3 = false;
            }
            wl8Var.k = z3;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                wl8Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            wl8Var.t = equals;
            wl8Var.q = this.a.L().O1();
            wl8Var.b = true;
            wl8Var.a = c0(equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            wl8Var.p = z4;
            wl8Var.j = true;
            wl8Var.o = this.a.L().Z0();
            wl8Var.d = true;
            if (Q2.getThreadVideoInfo() == null) {
                wl8Var.c = true;
            } else {
                wl8Var.c = false;
            }
            if (w1.l0()) {
                wl8Var.b = false;
                wl8Var.d = false;
                wl8Var.c = false;
                wl8Var.g = false;
                wl8Var.h = false;
            }
            wl8Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !w1.l0()) ? false : false;
            AbsVideoPbFragment absVideoPbFragment2 = this.a;
            if (absVideoPbFragment2.X3(absVideoPbFragment2.L().w1()) != null) {
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                wl8Var.w = absVideoPbFragment3.X3(absVideoPbFragment3.L().w1()).S;
            }
            if (Q2.isBlocked()) {
                wl8Var.n = false;
                wl8Var.g = false;
                wl8Var.h = false;
            }
            J0(wl8Var);
        }
    }

    public final void v0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            jo8.e(this.a.getActivity(), this.a.getPageContext(), new a0(this, sparseArray, i2, z2), new b0(this));
        }
    }

    public final void x0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048639, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04db, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f038e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.M());
        tBAlertBuilder.w(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        androidx.appcompat.app.AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new e(this, z2, sparseArray));
        aVar2.a(new f(this, z2));
    }

    public void y0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        bc9 bc9Var;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        g05 g05Var;
        g05 g05Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.L() == null || sparseArray == null || (bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.c == null) {
            k05 k05Var = new k05(this.a.getContext());
            this.c = k05Var;
            k05Var.p(this.M);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.L().w1() != null && this.a.L().w1().l0()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (sparseArray != null) {
            if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            } else {
                z3 = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z4 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z4 = false;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z5 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z5 = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z6 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z6 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z7 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z7 = false;
            }
            g05 g05Var3 = null;
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            } else {
                str = null;
            }
            if (bc9Var.o() != null) {
                boolean z9 = bc9Var.o().hasAgree;
                int p2 = bc9Var.p();
                if (z9 && p2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_dislike;
                }
                g05 g05Var4 = new g05(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, bc9Var);
                g05Var4.d.setTag(sparseArray2);
                arrayList.add(g05Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!z5 && z4) {
                    g05 g05Var5 = new g05(5, this.a.getString(R.string.obfuscated_res_0x7f0f0c00), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                    sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                    sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                    sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                    sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                    sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                    sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                    g05Var5.d.setTag(sparseArray3);
                    arrayList.add(g05Var5);
                } else {
                    if (c0(z3) && TbadkCoreApplication.isLogin()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 && !z2) {
                        g05 g05Var6 = new g05(5, this.a.getString(R.string.report_text), this.c);
                        g05Var6.d.setTag(str);
                        arrayList.add(g05Var6);
                    }
                }
                if (z5) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                    sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                    sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                    sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                    sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                    if (z6) {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                    } else {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z7) {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                        g05 g05Var7 = new g05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04db), this.c);
                        g05Var7.d.setTag(sparseArray4);
                        g05Var3 = g05Var7;
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    g05 g05Var8 = new g05(7, this.a.getString(R.string.obfuscated_res_0x7f0f02f2), this.c);
                    g05Var8.d.setTag(sparseArray4);
                    g05Var2 = g05Var8;
                    g05Var = g05Var3;
                } else if (z7) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                    sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    sparseArray5.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                    if (this.a.L().w1().Y() == 1002 && !z3) {
                        g05Var = new g05(6, this.a.getString(R.string.report_text), this.c);
                    } else {
                        g05Var = new g05(6, this.a.getString(R.string.obfuscated_res_0x7f0f04db), this.c);
                    }
                    g05Var.d.setTag(sparseArray5);
                    g05Var2 = null;
                } else {
                    g05Var = null;
                    g05Var2 = null;
                }
                if (g05Var != null) {
                    arrayList.add(g05Var);
                }
                if (g05Var2 != null) {
                    arrayList.add(g05Var2);
                }
                if (!z3) {
                    arrayList.add(new g05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032f), this.c));
                }
            }
            this.c.k(arrayList);
            i05 i05Var = new i05(this.a.getPageContext(), this.c);
            this.b = i05Var;
            i05Var.k();
        }
    }
}
