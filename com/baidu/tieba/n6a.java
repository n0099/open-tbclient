package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.c0a;
import com.baidu.tieba.f05;
import com.baidu.tieba.g05;
import com.baidu.tieba.hj5;
import com.baidu.tieba.p05;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
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
/* loaded from: classes7.dex */
public class n6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextMemeInfo A;
    public BdUniqueId B;
    public Object C;
    public PermissionJudgePolicy D;
    public nwa E;
    public String F;
    public Runnable G;
    public u45 H;
    public AgreeMessageData I;
    public final View.OnLongClickListener J;
    public p05.f K;
    public boolean L;
    public final g05.c M;
    public AbsVideoPbFragment a;
    public n05 b;
    public p05 c;
    public n05 d;
    public Dialog e;
    public Dialog f;
    public i05 g;
    public View h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public List<CustomBlueCheckRadioButton> l;
    public String m;
    public ScrollView n;
    public CompoundButton.OnCheckedChangeListener o;
    public n05 p;
    public BlueCircleProgressDialog q;
    public g05 r;
    public AlertDialog s;
    public w0a t;
    public c0a u;
    public i5a v;
    public PbFragment.k3 w;
    public t1a x;
    public BdImage y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947955792, "Lcom/baidu/tieba/n6a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947955792, "Lcom/baidu/tieba/n6a;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public a(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log("c10025");
                f05Var.dismiss();
                r4a.a(this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
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

    /* loaded from: classes7.dex */
    public class c implements g05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public c(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.g05.c
        public void a(g05 g05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, g05Var, i, view2) == null) {
                if (g05Var != null) {
                    g05Var.e();
                }
                if (this.a.y != null && !TextUtils.isEmpty(this.a.z)) {
                    if (i == 0) {
                        if (this.a.A == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.z));
                        } else {
                            hj5.a aVar = new hj5.a();
                            aVar.a = this.a.z;
                            String str = "";
                            if (this.a.A.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.A.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                    } else if (i == 1) {
                        if (this.a.D == null) {
                            this.a.D = new PermissionJudgePolicy();
                        }
                        this.a.D.clearRequestPermissionList();
                        this.a.D.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.D.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.x == null) {
                            n6a n6aVar = this.a;
                            n6aVar.x = new t1a(n6aVar.a.getPageContext());
                        }
                        this.a.x.b(this.a.z, this.a.y.getImageByte());
                    }
                    this.a.y = null;
                    this.a.z = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ n6a b;

        public d(n6a n6aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6aVar;
            this.a = z;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.p.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.c0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.w != null) {
                            this.b.w.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.R(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment != null && absVideoPbFragment.n4() != null) {
                            this.b.a.n4().u3(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements g05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public e(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.g05.c
        public void a(g05 g05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, g05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    n6a n6aVar = this.a;
                    n6aVar.F = n6aVar.F.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.F);
                    new qz9(this.a.a.l0().M1(), this.a.F, "1").start();
                    g05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    n6a n6aVar2 = this.a;
                    n6aVar2.F = n6aVar2.F.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.F);
                    new qz9(this.a.a.l0().M1(), this.a.F, "2").start();
                    g05Var.e();
                } else if (i == 2) {
                    n6a n6aVar3 = this.a;
                    n6aVar3.F = n6aVar3.F.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.F);
                    g05Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n05 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ n6a c;

        public f(n6a n6aVar, n05 n05Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, n05Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n6aVar;
            this.a = n05Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.l0().K1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.p05.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void E0(p05 p05Var, int i, View view2) {
            boolean k3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.a.dismiss();
                int i2 = 3;
                int i3 = 0;
                if (this.c.a.l0().K1() != 1 || i != 1) {
                    if (this.c.a.l0().K1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.l0().K1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091c33) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.l0().s1().f != null && this.c.a.l0().s1().f.size() > i) {
                        i = this.c.a.l0().s1().f.get(i).sort_type.intValue();
                    }
                    k3 = this.c.a.l0().k3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.l0().J1()));
                    if (!k3) {
                        this.c.a.s5(true);
                        return;
                    }
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                StatisticItem statisticItem2 = new StatisticItem("c12097");
                if (this.b.getId() != R.id.obfuscated_res_0x7f091c33) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.l0().s1().f != null) {
                    i = this.c.a.l0().s1().f.get(i).sort_type.intValue();
                }
                k3 = this.c.a.l0().k3(i);
                this.b.setTag(Integer.valueOf(this.c.a.l0().J1()));
                if (!k3) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
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

    /* loaded from: classes7.dex */
    public class h implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ n6a b;

        public h(n6a n6aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6aVar;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.b.o0();
                MessageManager.getInstance().sendMessage(this.a);
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public i(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.s != null) {
                yb.a(this.a.s, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
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

    /* loaded from: classes7.dex */
    public class k implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g05.c a;
        public final /* synthetic */ n6a b;

        public k(n6a n6aVar, g05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6aVar;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public l(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.m = (String) compoundButton.getTag();
                if (this.a.l != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.l) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.m != null && !str.equals(this.a.m)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public m(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.f instanceof Dialog)) {
                yb.b(this.a.f, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements p05.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public n(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.p05.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.s(j4a.f(this.a.E));
                ArrayList arrayList = new ArrayList();
                for (o05 o05Var : this.a.c.h()) {
                    if (o05Var instanceof l05) {
                        arrayList.add((l05) o05Var);
                    }
                }
                j4a.d(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public o(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
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

    /* loaded from: classes7.dex */
    public class p implements PbFragment.k3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public p(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.k3
        public void callback(Object obj) {
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
                String valueOf = String.valueOf(this.a.a.l0().s1().Y().getUserId());
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
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.l0().s1().n().getId(), this.a.a.l0().s1().n().getName(), this.a.a.l0().s1().R().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements c0a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public q(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.c0a.a
        public void b(@Nullable f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                this.a.a.d4(f05Var, null);
            }
        }

        @Override // com.baidu.tieba.c0a.a
        public void a(@NonNull f05 f05Var, @Nullable JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, f05Var, jSONArray) == null) {
                this.a.a.d4(f05Var, jSONArray);
            }
        }

        @Override // com.baidu.tieba.c0a.a
        public void c(@Nullable SparseArray<Object> sparseArray, @Nullable JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sparseArray, jSONArray) == null) {
                this.a.a.c4(sparseArray, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public r(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.w0(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.y != null && !TextUtils.isEmpty(this.a.z)) {
                                                if (this.a.A == null) {
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.z));
                                                } else {
                                                    hj5.a aVar = new hj5.a();
                                                    aVar.a = this.a.z;
                                                    String str = "";
                                                    if (this.a.A.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.A.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                }
                                                this.a.y = null;
                                                this.a.z = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.y != null && !TextUtils.isEmpty(this.a.z)) {
                                                if (this.a.D == null) {
                                                    this.a.D = new PermissionJudgePolicy();
                                                }
                                                this.a.D.clearRequestPermissionList();
                                                this.a.D.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.D.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.x == null) {
                                                    n6a n6aVar = this.a;
                                                    n6aVar.x = new t1a(n6aVar.a.getPageContext());
                                                }
                                                this.a.x.b(this.a.z, this.a.y.getImageByte());
                                                this.a.y = null;
                                                this.a.z = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            nwa nwaVar = this.a.E;
                                            if (nwaVar != null) {
                                                nwaVar.V0();
                                                this.a.E = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (this.a.a.checkUpIsLogin()) {
                                                if (view2 != null) {
                                                    this.a.a0(m4a.c(view2));
                                                }
                                                if (this.a.a.l0().s1().R() != null && this.a.a.l0().s1().R().getAuthor() != null && this.a.a.l0().s1().R().getAuthor().getUserId() != null && this.a.a.v4() != null) {
                                                    int d = m4a.d(this.a.a.l0().s1());
                                                    ThreadData R = this.a.a.l0().s1().R();
                                                    if (R.isBJHArticleThreadType()) {
                                                        i2 = 2;
                                                    } else if (R.isBJHVideoThreadType()) {
                                                        i2 = 3;
                                                    } else if (!R.isBJHNormalThreadType()) {
                                                        if (R.isBJHVideoDynamicThreadType()) {
                                                            i2 = 5;
                                                        } else {
                                                            i2 = 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.l0().M1()).param("obj_locate", 2).param("obj_id", this.a.a.l0().s1().R().getAuthor().getUserId()).param("obj_type", !this.a.a.v4().e()).param("obj_source", d).param("obj_param1", i2));
                                                    return;
                                                }
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
                                                this.a.S((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.B(sparseArray2);
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
                                                if (absVideoPbFragment != null && absVideoPbFragment.u0() != null) {
                                                    boolean Z = this.a.a.u0().Z(TbadkCoreApplication.getCurrentAccount());
                                                    if (Z) {
                                                        if (booleanValue2) {
                                                            this.a.e0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, Z);
                                                            return;
                                                        } else {
                                                            this.a.m0(sparseArray3, intValue, booleanValue);
                                                            return;
                                                        }
                                                    } else if (!booleanValue || booleanValue2) {
                                                        this.a.c0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                        return;
                                                    } else {
                                                        this.a.m0(sparseArray3, intValue, booleanValue);
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
                                                    this.a.B(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                sparseArray4.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                                                this.a.h0(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.c0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!ViewHelper.checkUpIsLogin(this.a.a.getContext()) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            nwa nwaVar2 = (nwa) sparseArray.get(R.id.tag_clip_board);
                                            if (nwaVar2.p() == null) {
                                                return;
                                            }
                                            xo5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                nwaVar2.p().objSource = findPageExtraByView.a();
                                            }
                                            this.a.C(nwaVar2.p());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.l0() != null && this.a.a.l0().s1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.u0() != null) {
                                                this.a.a.u0().P1(e5b.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                                if (absVideoPbFragment3 != null && absVideoPbFragment3.n4() != null) {
                                    this.a.a.n4().u3(true);
                                    return;
                                }
                                return;
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            this.a.i0(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView != null && agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView2 = (AgreeView) view4;
                        this.a.i0(view4);
                        if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                    this.a.i0(view5);
                    if (view5 != null) {
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.i0(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ n6a d;

        public s(n6a n6aVar, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n6aVar;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                if (f05Var != null) {
                    f05Var.dismiss();
                }
                this.d.a.e4(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
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

    /* loaded from: classes7.dex */
    public class u implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ n6a e;

        public u(n6a n6aVar, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n6aVar;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.c0(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.B);
                    userMuteAddAndDelCustomMessage.setTag(this.e.B);
                    this.e.v0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    public n6a(AbsVideoPbFragment absVideoPbFragment) {
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
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.E = null;
        this.J = new o(this);
        this.K = new r(this);
        this.M = new c(this);
        this.a = absVideoPbFragment;
        this.B = absVideoPbFragment.getUniqueId();
        i5a i5aVar = new i5a(this.a.getContext());
        this.v = i5aVar;
        i5aVar.b(this.a.getUniqueId());
        this.w = new p(this);
        U();
    }

    public final boolean Y(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            if (this.a.l0() != null && this.a.l0().s1() != null) {
                if (this.a.l0().s1().Z() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || this.a.l0().s1().R() == null || this.a.l0().s1().R().getAuthor() == null || TextUtils.equals(this.a.l0().s1().R().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                return !z;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean X(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this.a.getContext(), "", str, false, true, true, bundle);
        }
    }

    public void h0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        g0(sparseArray, false);
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.L = z;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.F = str;
        }
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            o0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.B;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.C = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void i0(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.L) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.l0().M1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(j4a.j(i2))));
        }
    }

    public final void C(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.H == null) {
            this.H = new u45();
        }
        if (this.I == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.I = agreeMessageData;
            agreeMessageData.uniqueId = this.a.getUniqueId();
        }
        lw4 lw4Var = new lw4();
        lw4Var.b = 5;
        lw4Var.h = 8;
        lw4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment = this.a;
        if (absVideoPbFragment != null && absVideoPbFragment.l0() != null) {
            lw4Var.f = this.a.l0().r1();
        }
        lw4Var.a = 2;
        this.H.c(agreeData, m4a.e(agreeData, lw4Var), this.a.getUniqueId(), false);
        this.H.d(agreeData, this.I);
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.l0() != null && this.a.l0().s1() != null) {
            this.H.b(this.a.u0(), lw4Var, agreeData, this.a.l0().s1().R());
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (this.a.l0() != null && this.a.l0().s1() != null && this.a.l0().s1().a()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.l0().M1(), str);
                ThreadData R = this.a.l0().s1().R();
                if (R.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (R.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (R.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                Z(format);
                return;
            }
            this.v.a(str);
        }
    }

    public void a0(nwa nwaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, nwaVar) != null) || nwaVar == null) {
            return;
        }
        if (nwaVar.U() != null && nwaVar.U().equals(this.a.l0().n1())) {
            z = true;
        } else {
            z = false;
        }
        MarkData m1 = this.a.l0().m1(nwaVar);
        if (this.a.l0().s1() != null && this.a.l0().s1().a()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            nwa o4 = absVideoPbFragment.o4(absVideoPbFragment.l0().s1());
            if (o4 != null) {
                m1 = this.a.l0().m1(o4);
            }
        }
        if (m1 == null) {
            return;
        }
        this.a.w5();
        if (this.a.v4() != null) {
            this.a.v4().i(m1);
            if (!z) {
                this.a.v4().a();
            } else {
                this.a.v4().d();
            }
        }
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.o);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        l05 l05Var;
        BdImage bdImage;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e2) {
                    e2.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (X(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.y = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.z = url;
                            if (this.y == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.A = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.A = null;
                            }
                        } else if (view2 instanceof GifView) {
                            GifView gifView = (GifView) view2;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.y = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                                this.z = gifView.getBdImage().getUrl();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.A = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.A = null;
                            }
                        } else if (view2 instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.y = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                                    this.z = tbMemeImageView.getBdImage().getUrl();
                                }
                                if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.A = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                                } else {
                                    this.A = null;
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
                            r0(this.M, this.y.isGif());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                nwa nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board);
                this.E = nwaVar;
                if (nwaVar == null || this.a.v4() == null) {
                    return true;
                }
                if (this.a.v4().e() && this.E.U() != null && this.E.U().equals(this.a.l0().n1())) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.a.l0().s1() != null && this.a.l0().s1().a()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.c == null) {
                    p05 p05Var = new p05(this.a.getContext());
                    this.c = p05Var;
                    p05Var.r(this.K);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (X(view2) && !z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (X(view2) && (bdImage = this.y) != null && !bdImage.isGif()) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean b2 = p4a.b(sparseArray, R.id.tag_is_subpb, false);
                    boolean b3 = p4a.b(sparseArray, R.id.tag_del_post_is_self, false);
                    boolean b4 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                    boolean b5 = p4a.b(sparseArray, R.id.tag_should_manage_visible, false);
                    boolean b6 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                    boolean b7 = p4a.b(sparseArray, R.id.tag_should_delete_visible, false);
                    boolean b8 = p4a.b(sparseArray, R.id.tag_is_self_post, false);
                    boolean b9 = p4a.b(sparseArray, R.id.tag_mul_del_post_type, false);
                    String c2 = p4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
                    if (z3) {
                        arrayList.add(new l05(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.c));
                    }
                    if (z4) {
                        arrayList.add(new l05(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.c));
                    }
                    if (!z3 && !z4) {
                        l05 l05Var2 = new l05(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f5), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.E);
                        l05Var2.d.setTag(sparseArray3);
                        arrayList.add(l05Var2);
                    }
                    if (!b2 && !z2) {
                        if (z) {
                            l05Var = new l05(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.c);
                        } else {
                            l05Var = new l05(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c89), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.E);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        l05Var.d.setTag(sparseArray4);
                        arrayList.add(l05Var);
                    }
                    boolean isLogin = TbadkCoreApplication.isLogin();
                    g4a.d(this.c, b5, b4, sparseArray, arrayList, isLogin, W());
                    g4a.e(this.c, b5, b4, arrayList, z2, c2, isLogin, W(), Y(b3));
                    g4a.b(this.c, sparseArray, arrayList, b3, b5, b6, b7, b8, c2, isLogin, W());
                    g4a.a(this.c, sparseArray, arrayList, b3, b5, b6, b7, b8, c2, isLogin, W(), this.a.l0().s1().Z());
                    g4a.c(this.c, arrayList, b5, b7, b9, isLogin);
                    p4a.a(arrayList, this.c, this.E, this.a.l0().s1(), TbadkCoreApplication.isLogin());
                    List<l05> a2 = j4a.a(arrayList, this.E.p(), sparseArray, this.c);
                    j4a.i(a2, this.L);
                    j4a.d(a2);
                    this.c.s(j4a.f(this.E));
                    this.c.n(a2, true);
                    this.b = new n05(this.a.getPageContext(), this.c);
                    this.c.q(new n(this));
                    this.b.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.l0().M1()).param("fid", this.a.l0().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.l0().Q());
                    if (b2) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    TiebaStatic.log(param.param("obj_source", i2));
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            I();
            this.a.G4();
            n05 n05Var = this.b;
            if (n05Var != null) {
                n05Var.dismiss();
            }
            this.a.I4();
            K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I();
            this.a.G4();
            n05 n05Var = this.b;
            if (n05Var != null) {
                n05Var.dismiss();
            }
            K();
        }
    }

    public void H() {
        n05 n05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (n05Var = this.b) != null) {
            n05Var.dismiss();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.G == null) {
                this.G = new i(this);
            }
            SafeHandler.getInst().postDelayed(this.G, 100L);
        }
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alertDialog = this.s) != null) {
            yb.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            View view2 = this.h;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public Object N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.C;
        }
        return invokeV.objValue;
    }

    public View.OnLongClickListener O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.J;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public w0a P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.t;
        }
        return (w0a) invokeV.objValue;
    }

    public g05 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.r;
        }
        return (g05) invokeV.objValue;
    }

    public void T() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (blueCircleProgressDialog = this.q) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c0a c0aVar = new c0a(this.a.getPageContext(), this.a.l0());
            this.u = c0aVar;
            c0aVar.f(new q(this));
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.l0() != null) {
                return p4a.d(this.a.l0().s1());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.v.i();
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.q == null) {
                this.q = new BlueCircleProgressDialog(this.a.getPageContext());
            }
            this.q.setDialogVisiable(true);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c0a c0aVar = this.u;
            if (c0aVar != null) {
                c0aVar.a();
            }
            Dialog dialog = this.e;
            if (dialog != null) {
                yb.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.f;
            if (dialog2 != null) {
                yb.b(dialog2, this.a.getPageContext());
            }
            n05 n05Var = this.p;
            if (n05Var != null) {
                n05Var.dismiss();
            }
        }
    }

    public void R(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.B);
            userMuteAddAndDelCustomMessage.setTag(this.B);
            v0(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.r != null) {
            return;
        }
        this.r = new g05(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.call_phone), this.a.getPageContext().getString(R.string.sms_phone), this.a.getPageContext().getString(R.string.search_in_baidu)};
        g05 g05Var = this.r;
        g05Var.j(strArr, new e(this));
        g05Var.g(g05.b.a);
        g05Var.h(17);
        g05Var.c(this.a.getPageContext());
    }

    public void b0(ArrayList<wx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) {
            if (this.h == null) {
                this.h = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.h);
            if (this.f == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c6);
                this.f = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f.setCancelable(true);
                this.n = (ScrollView) this.h.findViewById(R.id.good_scroll);
                this.f.setContentView(this.h);
                WindowManager.LayoutParams attributes = this.f.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f6);
                this.f.getWindow().setAttributes(attributes);
                this.o = new l(this);
                this.i = (LinearLayout) this.h.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.h.findViewById(R.id.dialog_button_cancel);
                this.k = textView;
                textView.setOnClickListener(new m(this));
                TextView textView2 = (TextView) this.h.findViewById(R.id.dialog_button_ok);
                this.j = textView2;
                textView2.setOnClickListener(this.a.s4());
            }
            this.i.removeAllViews();
            this.l = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.thread_good_class));
            this.l.add(D);
            D.setChecked(true);
            this.i.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    wx4 wx4Var = arrayList.get(i2);
                    if (wx4Var != null && !TextUtils.isEmpty(wx4Var.b()) && wx4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(wx4Var.a()), wx4Var.b());
                        this.l.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.i.addView(view2);
                        this.i.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = BdUtilHelper.dip2px(this.a.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = BdUtilHelper.dip2px(this.a.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = BdUtilHelper.dip2px(this.a.getPageContext().getPageActivity(), 120.0f);
                }
                this.n.setLayoutParams(layoutParams2);
                this.n.removeAllViews();
                LinearLayout linearLayout = this.i;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.n.addView(this.i);
                }
            }
            yb.j(this.f, this.a.getPageContext());
        }
    }

    public void c0(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            d0(i2, str, i3, z, null);
        }
    }

    public void f0(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.u.e(this.a.getView(), i2, str, i3, z);
        }
    }

    public void d0(int i2, String str, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2}) == null) {
            e0(i2, str, i3, z, str2, false);
        }
    }

    public void e0(int i2, String str, int i3, boolean z, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            this.u.b(this.a.getView(), i2, str, i3, z, str2, z2);
        }
    }

    public void g0(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        l05 l05Var;
        l05 l05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, sparseArray, z) == null) {
            p05 p05Var = new p05(this.a.getContext());
            p05Var.u(this.a.getString(R.string.obfuscated_res_0x7f0f032e));
            p05Var.r(new d(this, z));
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
                    l05Var2 = new l05(10, this.a.getString(R.string.obfuscated_res_0x7f0f056a), p05Var);
                } else {
                    l05Var2 = new l05(10, this.a.getString(R.string.obfuscated_res_0x7f0f055b), p05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                l05Var2.d.setTag(sparseArray2);
                arrayList.add(l05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                l05 l05Var3 = new l05(13, this.a.getString(R.string.multi_delete), p05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                l05Var3.d.setTag(sparseArray3);
                arrayList.add(l05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                l05 l05Var4 = new l05(11, this.a.getString(R.string.forbidden_person), p05Var);
                l05Var4.d.setTag(sparseArray4);
                arrayList.add(l05Var4);
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
                if (z) {
                    l05Var = new l05(12, this.a.getString(R.string.un_mute), p05Var);
                } else {
                    l05Var = new l05(12, this.a.getString(R.string.obfuscated_res_0x7f0f0d47), p05Var);
                }
                l05Var.d.setTag(sparseArray5);
                arrayList.add(l05Var);
            }
            j4a.d(arrayList);
            p05Var.n(arrayList, true);
            n05 n05Var = this.p;
            if (n05Var == null) {
                this.p = new n05(this.a.getPageContext(), p05Var);
            } else {
                n05Var.h(p05Var);
            }
            this.p.l();
        }
    }

    public final void m0(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            j4a.c(this.a.getActivity(), this.a.getPageContext(), new s(this, sparseArray, i2, z), new t(this));
        }
    }

    public void n0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        nwa nwaVar;
        boolean z;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.l0() == null || sparseArray == null || (nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.c == null) {
            p05 p05Var = new p05(this.a.getContext());
            this.c = p05Var;
            p05Var.r(this.K);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.l0().s1() != null && this.a.l0().s1().a()) {
            z = true;
        } else {
            z = false;
        }
        if (sparseArray != null) {
            boolean b2 = p4a.b(sparseArray, R.id.tag_del_post_is_self, false);
            boolean b3 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
            boolean b4 = p4a.b(sparseArray, R.id.tag_should_manage_visible, false);
            boolean b5 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
            boolean b6 = p4a.b(sparseArray, R.id.tag_should_delete_visible, false);
            boolean b7 = p4a.b(sparseArray, R.id.tag_is_self_post, false);
            String c2 = p4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
            if (nwaVar.p() != null) {
                boolean z2 = nwaVar.p().hasAgree;
                int q2 = nwaVar.q();
                if (z2 && q2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_dislike;
                }
                l05 l05Var = new l05(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, nwaVar);
                l05Var.d.setTag(sparseArray2);
                arrayList.add(l05Var);
            }
            g4a.d(this.c, b4, b3, sparseArray, arrayList, TbadkCoreApplication.isLogin(), W());
            g4a.e(this.c, b4, b3, arrayList, z, c2, TbadkCoreApplication.isLogin(), W(), Y(b2));
            g4a.b(this.c, sparseArray, arrayList, b2, b4, b5, b6, b7, c2, TbadkCoreApplication.isLogin(), W());
            g4a.a(this.c, sparseArray, arrayList, b2, b4, b5, b6, b7, c2, TbadkCoreApplication.isLogin(), W(), this.a.l0().s1().Z());
            p4a.a(arrayList, this.c, nwaVar, this.a.l0().s1(), TbadkCoreApplication.isLogin());
            this.c.m(arrayList);
            n05 n05Var = new n05(this.a.getPageContext(), this.c);
            this.b = n05Var;
            n05Var.l();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            f05 f05Var = new f05(this.a.getPageContext().getPageActivity());
            f05Var.setMessage(this.a.getResources().getString(R.string.mute_is_super_member_function));
            f05Var.setPositiveButton(R.string.open_now, new a(this));
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
            f05Var.create(this.a.getPageContext()).show();
        }
    }

    public void q0(boolean z, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048617, this, z, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            n05 n05Var = this.b;
            if (n05Var != null && n05Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            p05 p05Var = new p05(this.a.getBaseFragmentActivity());
            p05Var.r(new u(this, sparseArray, z, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new l05(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f055b), p05Var));
            }
            if (z) {
                arrayList.add(new l05(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), p05Var));
            } else {
                arrayList.add(new l05(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d47), p05Var));
            }
            p05Var.m(arrayList);
            n05 n05Var2 = new n05(this.a.getPageContext(), p05Var);
            this.b = n05Var2;
            n05Var2.l();
        }
    }

    public void r0(g05.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048618, this, cVar, z) == null) {
            n05 n05Var = this.d;
            if (n05Var != null) {
                n05Var.dismiss();
                this.d = null;
            }
            p05 p05Var = new p05(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.l0().s1() != null && this.a.l0().s1().R() != null && !this.a.l0().s1().R().isBjh()) {
                arrayList.add(new l05(0, this.a.getPageContext().getString(R.string.save_to_emotion), p05Var));
            }
            if (!z) {
                arrayList.add(new l05(1, this.a.getPageContext().getString(R.string.save_to_local), p05Var));
            }
            p05Var.m(arrayList);
            p05Var.r(new k(this, cVar));
            n05 n05Var2 = new n05(this.a.getPageContext(), p05Var);
            this.d = n05Var2;
            n05Var2.l();
        }
    }

    public void s0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onItemClickListener) == null) {
            i05 i05Var = this.g;
            if (i05Var != null) {
                i05Var.d();
                this.g = null;
            }
            if (this.a.l0() == null) {
                return;
            }
            ArrayList<r05> arrayList = new ArrayList<>();
            String string = this.a.getContext().getString(R.string.all_person);
            boolean z4 = false;
            if (this.a.l0().C1() == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new r05(string, "", z, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.my_fans);
            if (this.a.l0().C1() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new r05(string2, "", z2, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.my_attentions);
            if (this.a.l0().C1() == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new r05(string3, "", z3, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.myself_only);
            if (this.a.l0().C1() == 4) {
                z4 = true;
            }
            arrayList.add(new r05(string4, "", z4, Integer.toString(7)));
            i05 i05Var2 = new i05(this.a.getPageContext());
            i05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.g = i05Var2;
            i05Var2.k(arrayList, onItemClickListener);
            i05Var2.c();
            this.g.n();
        }
    }

    public void t0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.l0() != null) {
            n05 n05Var = new n05(this.a.getPageContext());
            if (this.a.l0().s1().f == null || this.a.l0().s1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                strArr = new String[this.a.l0().s1().f.size()];
                for (int i2 = 0; i2 < this.a.l0().s1().f.size(); i2++) {
                    strArr[i2] = this.a.l0().s1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                }
            }
            n05Var.i(null, strArr, new f(this, n05Var, view2));
            n05Var.l();
        }
    }

    public void u0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.getPageContext() != null) {
                f05 f05Var = new f05(this.a.getPageContext().getPageActivity());
                f05Var.setMessage(str);
                f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b86, new g(this));
                f05Var.create(this.a.getPageContext()).show();
            }
        }
    }

    public final void v0(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                o0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            f05 f05Var = new f05(this.a.getBaseFragmentActivity());
            if (!rd.isEmpty(str)) {
                f05Var.setMessage(str);
            } else {
                f05Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            }
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new h(this, userMuteAddAndDelCustomMessage));
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new j(this));
            f05Var.create(this.a.getPageContext()).show();
        }
    }
}
