package com.baidu.tieba;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.gl5;
import com.baidu.tieba.hs4;
import com.baidu.tieba.jl5;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.wr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class lv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public View B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.y E;
    public ou7 F;
    public View.OnLongClickListener G;
    public fs4 H;
    public wr4 I;
    public int J;
    public PbFragment.h3 K;
    public xu4 L;
    public gl5 M;
    public jl5 N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public ow7 U;
    public List<String> V;
    public sy7 W;
    public PbFakeFloorModel X;
    public BdListView.p Y;
    public CustomMessageListener Z;
    public FoldCommentActivity a;
    public PbModel b;
    public NoNetworkView c;
    public NoDataView d;
    public SubPbView e;
    public LinearLayout f;
    public NavigationBar g;
    public ImageView h;
    public View i;
    public View j;
    public ImageView k;
    public AlertDialog l;
    public BlankView m;
    public RelativeLayout n;
    public BdTypeListView o;
    public a08 p;
    public ProgressBar q;
    public jv7 r;
    public mt7 s;
    public boolean t;
    public MaskView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public RelativeLayout y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public a(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffd, 1);
                    this.a.a.K1(sparseArray);
                    return;
                }
                this.a.P(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091ffd, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091fe6, 1);
                this.a.a.K1(sparseArray);
            } else if (booleanValue3) {
                this.a.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public b(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.T2();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements hs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ lv7 b;

        public c(lv7 lv7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lv7Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.hs4.e
        public void i0(hs4 hs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hs4Var, i, view2) == null) {
                this.b.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                        return;
                    case 11:
                        if (this.b.K != null) {
                            this.b.K.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09200a), sparseArray.get(R.id.obfuscated_res_0x7f091ff7), sparseArray.get(R.id.obfuscated_res_0x7f091ffa), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff9)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.a.h2(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092042), sparseArray);
                        return;
                    case 13:
                        this.b.i0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ lv7 c;

        public e(lv7 lv7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lv7Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!pi.A()) {
                    ri.M(this.c.a, R.string.obfuscated_res_0x7f0f0c40);
                } else {
                    this.c.a.Q1(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public f(lv7 lv7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var, alertDialog};
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
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements jl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ lv7 b;

        public g(lv7 lv7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lv7Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.jl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.Q1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements gl5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ lv7 b;

        public h(lv7 lv7Var, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var, wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lv7Var;
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.gl5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.R1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public i(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements o25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public j(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // com.baidu.tieba.o25
        public void A(n25 n25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n25Var) == null) {
                Object obj = n25Var.c;
                if ((obj instanceof jy4) && EmotionGroupType.isSendAsPic(((jy4) obj).getType())) {
                    if (this.a.P == null) {
                        this.a.P = new PermissionJudgePolicy();
                    }
                    this.a.P.clearRequestPermissionList();
                    this.a.P.appendRequestPermission(this.a.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.P.startRequestPermission(this.a.a)) {
                        return;
                    }
                    this.a.a.d2().h((jy4) n25Var.c);
                    this.a.a.d2().z(false, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public k(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public l(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.a.s == null || this.a.a.s.e() == null) {
                return;
            }
            if (!this.a.a.s.e().e()) {
                this.a.a.s.a(false);
            }
            this.a.a.s.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.T == null || this.a.T.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i)) {
                return;
            }
            String substring = charSequence.toString().substring(i, i4);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.a.W == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.T.getId());
                lv7 lv7Var = this.a;
                lv7Var.W = new sy7(lv7Var.a.getPageContext(), this.a.e, layoutParams);
                if (!ListUtils.isEmpty(this.a.V)) {
                    this.a.W.q(this.a.V);
                }
                this.a.W.r(this.a.T);
            }
            this.a.W.p(substring);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(lv7 lv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof du7)) {
                du7 du7Var = (du7) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.setSubPbViewData(du7Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public n(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public o(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.a.x2();
                if (this.a.a == null || this.a.a.a2() == null || this.a.a.a2().S1() == null || this.a.a.a2().S1().O() == null || this.a.a.a2().S1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.a.a2().n2()).param("fid", this.a.a.a2().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.a.a2().m2()).param("fid", this.a.a.a2().S1().m()).param("obj_locate", 1).param("uid", this.a.a.a2().S1().O().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public p(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public q(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.X.Q(postData);
                this.a.r.b();
                this.a.U.c();
                this.a.T.q();
                this.a.a0(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public r(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            this.a.e.g();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        public s(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv7 a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.l == null) {
                    return;
                }
                this.a.a.l.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public b(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "3").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    UrlManager.getInstance().dealOneLink(this.a.a.a.getPageContext(), new String[]{TbConfig.COMMUNITY_CONVENTION});
                    if (this.a.a.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.a.a.s.Q()).param("fname", this.a.a.s.n()).param("fid", this.a.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f040b));
                if (this.a.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.a.s.Q()).param("fname", this.a.s.n()).param("fid", this.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f09a4, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.a.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a.a);
                textView.setText(R.string.obfuscated_res_0x7f0f154e);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.a.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(ri.f(this.a.a, R.dimen.tbds36), ri.f(this.a.a, R.dimen.tbds36)));
                lv7 lv7Var = this.a;
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(lv7Var.a);
                tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f040a);
                tBAlertBuilder.o(spannableString);
                tBAlertBuilder.l(3);
                tBAlertBuilder.i(linearLayout);
                tBAlertBuilder.m(true);
                tBAlertBuilder.n(LinkMovementMethod.getInstance());
                tBAlertBuilder.r(aVar);
                tBAlertBuilder.h(true);
                lv7Var.l = tBAlertBuilder.w();
            }
        }
    }

    public lv7(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.y yVar, ou7 ou7Var, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, yVar, ou7Var, onLongClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.q = null;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.L = null;
        this.Q = false;
        this.Y = new k(this);
        this.Z = new m(this, 2921597);
        this.a = foldCommentActivity;
        this.b = foldCommentActivity.a2();
        this.C = onClickListener;
        this.E = yVar;
        this.F = ou7Var;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0496, (ViewGroup) null);
        this.e = subPbView;
        this.f = (LinearLayout) subPbView.findViewById(R.id.obfuscated_res_0x7f091629);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a05);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090a06);
        this.w = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a09);
        this.x = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a08);
        this.c = (NoNetworkView) this.e.findViewById(R.id.obfuscated_res_0x7f092568);
        G();
        this.n = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a03);
        this.o = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f090a0a);
        View view2 = new View(foldCommentActivity.getActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.x(view2, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.e.setTopView(view2);
        this.e.setNavigationView(this.f);
        this.e.setListView(this.o);
        this.e.setContentView(this.n);
        a08 a08Var = new a08(foldCommentActivity.getPageContext());
        this.p = a08Var;
        a08Var.x();
        this.p.B(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091a7a);
        this.u = (MaskView) this.e.findViewById(R.id.obfuscated_res_0x7f0914a2);
        this.B = this.e.findViewById(R.id.obfuscated_res_0x7f09254e);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a04);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a07);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(ri.f(this.a, R.dimen.L_X01));
        this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.X = pbFakeFloorModel;
        pbFakeFloorModel.S(this.b.I(), this.b.E(), this.b.F(), this.b.D(), this.b.J());
        ow7 ow7Var = new ow7(this.a.getPageContext(), this.X, this.n);
        this.U = ow7Var;
        ow7Var.k(new p(this));
        this.U.n(this.a.W);
        this.X.U(new q(this));
        this.a.registerListener(this.Z);
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (SubPbView) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y == null) {
            return;
        }
        this.B.setVisibility(8);
        this.y.setVisibility(8);
        PbEmotionBar pbEmotionBar = this.S;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.y == null || this.R == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        PbModel pbModel = this.b;
        boolean z2 = true;
        this.R.setText(tbSingleton.getAdVertiComment((pbModel == null || pbModel.S1() == null || !this.b.S1().n0()) ? false : true, (this.b.S1() == null || !this.b.S1().o0()) ? false : false, z()));
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void D() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (editorTools = this.T) == null) {
            return;
        }
        editorTools.o();
        sy7 sy7Var = this.W;
        if (sy7Var != null) {
            sy7Var.m();
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (noDataView = this.d) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.o.setVisibility(0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            jv7 jv7Var = new jv7(this.a, this.o);
            this.r = jv7Var;
            jv7Var.j(this.a.z0());
            this.r.k(this.a.e2());
            this.r.g(this.E);
            this.r.c(this.C);
            this.r.l(this.F);
            this.r.g(this.E);
            this.r.h(this.G);
            a aVar = new a(this);
            this.D = aVar;
            this.r.e(aVar);
            this.r.a();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int f2 = ri.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070306);
            int f3 = ri.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.obfuscated_res_0x7f092566);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0642));
            this.i = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0497, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091633);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080931, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.g.getBackImageView();
            this.h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.height = f2;
                layoutParams.width = f2;
                layoutParams.leftMargin = f3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.i;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.width = f2;
                layoutParams2.height = f2;
                this.i.setLayoutParams(layoutParams2);
            }
            this.g.setIsClose(true);
            this.g.setIsCorner(true);
            this.g.isShowBottomLine(true);
            this.g.setBottomLineHeight(3);
            this.g.setStatusBarVisibility(8);
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fbc), new b(this)));
            if (this.d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, ri.f(pageActivity, R.dimen.obfuscated_res_0x7f070288)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.d.setClickable(true);
            this.d.setTextOption(eVar);
            this.d.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.d.setVisibility(0);
        }
    }

    public void I() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || (editorTools = this.T) == null) {
            return;
        }
        editorTools.j();
        if (this.a.d2() != null) {
            this.a.d2().Q();
        }
        B();
    }

    public final void J() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.b) == null || pbModel.S1() == null || this.b.S1().y() == null || !ri.D()) {
            return;
        }
        if (this.b.S1().y().b() == 0) {
            U();
            return;
        }
        a08 a08Var = this.p;
        if (a08Var != null) {
            a08Var.Q();
        }
        if (this.b.N2(false)) {
            X();
        } else {
            U();
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.a.getLayoutMode().l(i2 == 1);
            this.a.getLayoutMode().k(this.e);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            this.g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.C2() || this.b.B2())) {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080ac6, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f0809f4, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.c.d(this.a.getPageContext(), i2);
            this.a.getLayoutMode().k(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0110);
            this.v.setAlpha(0.95f);
            jv7 jv7Var = this.r;
            if (jv7Var != null) {
                jv7Var.b();
            }
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ri.f(this.a, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            os4.d(this.y).f(R.color.CAM_X0208);
        }
    }

    public void L(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            M(i2, str, i3, z, null);
        }
    }

    public void M(int i2, String str, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2}) == null) {
            N(i2, str, i3, z, str2, false);
        }
    }

    public void N(int i2, String str, int i3, boolean z, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            int i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f04a1 : R.string.obfuscated_res_0x7f0f0ff7;
            int i5 = R.string.obfuscated_res_0x7f0f043a;
            if (i2 == 0) {
                if (i3 != 1002 || z) {
                    i5 = R.string.obfuscated_res_0x7f0f04a5;
                    i4 = R.string.obfuscated_res_0x7f0f04a6;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0ffb;
                }
            }
            this.I = new wr4(this.a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(R.string.obfuscated_res_0x7f0f04ef, this.a);
            this.I.setNegativeButton(R.string.obfuscated_res_0x7f0f04ea, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.a.getPageContext());
            if (z2) {
                b0(sparseArray, i5, i4);
            } else if (z) {
                b0(sparseArray, i5, i4);
            } else if (Z()) {
                il5 il5Var = new il5(this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.b.S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.b.S1().o().has_forum_rule.intValue());
                il5Var.i(this.b.S1().l().getId(), this.b.S1().l().getName());
                il5Var.h(this.b.S1().l().getImage_url());
                il5Var.j(this.b.S1().l().getUser_level());
                e0(sparseArray, i2, il5Var, this.b.S1().V(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray<Object> sparseArray, boolean z) {
        ds4 ds4Var;
        ds4 ds4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            hs4 hs4Var = new hs4(this.a);
            hs4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e4));
            hs4Var.n(new c(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe6)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091fec)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fee) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue() : -1) == 0) {
                    ds4Var2 = new ds4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04b7), hs4Var);
                } else {
                    ds4Var2 = new ds4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04ac), hs4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                sparseArray2.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                ds4Var2.d.setTag(sparseArray2);
                arrayList.add(ds4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09200b) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09200b)).booleanValue()) {
                ds4 ds4Var3 = new ds4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b27), hs4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                sparseArray3.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                ds4Var3.d.setTag(sparseArray3);
                arrayList.add(ds4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff7)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff8))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                sparseArray4.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ffa, sparseArray.get(R.id.obfuscated_res_0x7f091ffa));
                ds4 ds4Var4 = new ds4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0655), hs4Var);
                ds4Var4.d.setTag(sparseArray4);
                arrayList.add(ds4Var4);
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
                if (z) {
                    ds4Var = new ds4(12, this.a.getString(R.string.obfuscated_res_0x7f0f149c), hs4Var);
                } else {
                    ds4Var = new ds4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b33), hs4Var);
                }
                ds4Var.d.setTag(sparseArray5);
                arrayList.add(ds4Var);
            }
            mz7.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                hs4Var.k(arrayList, false);
            } else {
                hs4Var.k(arrayList, true);
            }
            fs4 fs4Var = new fs4(this.a.getPageContext(), hs4Var);
            this.H = fs4Var;
            fs4Var.k();
        }
    }

    public void P(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        O(sparseArray, false);
    }

    public final void Q() {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (foldCommentActivity = this.a) == null || foldCommentActivity.d2() == null || this.T == null) {
            return;
        }
        m45.a().c(0);
        q45 d2 = this.a.d2();
        d2.U();
        d2.S();
        if (d2.y() != null) {
            d2.y().setMaxImagesAllowed(d2.v ? 1 : 9);
        }
        d2.n0(SendView.h);
        d2.j(SendView.h);
        u25 m2 = this.T.m(23);
        u25 m3 = this.T.m(2);
        u25 m4 = this.T.m(5);
        if (m3 != null) {
            m3.display();
        }
        if (m4 != null) {
            m4.display();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.T.invalidate();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Q();
            D();
            this.U.c();
            a0(false);
        }
    }

    public void S(mt7 mt7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, mt7Var, z) == null) || mt7Var == null) {
            return;
        }
        this.s = mt7Var;
        this.t = z;
        if (mt7Var.b0()) {
            this.p.Q();
        } else {
            this.p.f();
        }
        this.r.d(this.t);
        this.r.i(mt7Var);
        this.e.setEnableDragExit(true);
        String adVertiComment = TbSingleton.getInstance().getAdVertiComment(mt7Var.n0(), mt7Var.o0(), z());
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(adVertiComment);
        }
    }

    public void T(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.T = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.T.setId(R.id.obfuscated_res_0x7f0917bd);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.T.getParent() == null) {
                this.n.addView(this.T, layoutParams);
            }
            this.T.w(TbadkCoreApplication.getInst().getSkinType());
            this.T.setActionListener(24, new j(this));
            D();
            this.a.d2().i(new l(this));
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.f();
        }
    }

    public void V(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, h3Var) == null) {
            this.K = h3Var;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.Q = z;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.R();
        }
    }

    public void Y(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbModel) == null) {
            this.b = pbModel;
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.a == null || this.b.S1().l().getDeletedReasonInfo() == null || 1 != this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true : invokeV.booleanValue;
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || this.y == null) {
            return;
        }
        W(this.a.d2().C());
        if (this.Q) {
            c0(z);
        } else {
            C(z);
        }
    }

    public final void b0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048603, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ac, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0371, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a);
        tBAlertBuilder.t(i2);
        tBAlertBuilder.k(i3);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w = tBAlertBuilder.w();
        aVar.a(new e(this, w, sparseArray));
        aVar2.a(new f(this, w));
    }

    public void c0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.y == null || (textView = this.R) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f051a);
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.L == null) {
                this.L = new xu4(this.a.getPageContext());
            }
            this.L.h(true);
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, il5 il5Var, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), il5Var, userData, Boolean.valueOf(z)}) == null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new jl5(foldCommentActivity.getPageContext(), null, il5Var, userData);
        }
        this.N.C(z);
        AntiData U1 = this.a.U1();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (U1 != null && U1.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = U1.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        eq4 eq4Var = new eq4();
        eq4Var.j(sparseArray2);
        this.N.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3), this.a.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.N.D(eq4Var);
        this.N.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.N.F(new g(this, sparseArray));
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fbd)));
            this.y.setVisibility(8);
        }
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fbd)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(wr4 wr4Var, int i2) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048609, this, wr4Var, i2) == null) || (foldCommentActivity = this.a) == null || wr4Var == null) {
            return;
        }
        if (this.M == null) {
            this.M = new gl5(foldCommentActivity.getPageContext(), null);
        }
        AntiData U1 = this.a.U1();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (U1 != null && U1.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = U1.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        eq4 eq4Var = new eq4();
        eq4Var.j(sparseArray);
        this.M.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3), this.a.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.M.x(eq4Var);
        this.M.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.M.z(new h(this, wr4Var));
    }

    public void i0(boolean z) {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (jv7Var = this.r) == null) {
            return;
        }
        jv7Var.f(z);
        this.r.b();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.m = new BlankView(this.a.getPageContext().getPageActivity());
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.C2() || this.b.B2())) {
                this.J = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070252);
            }
            this.f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.e.setBlankView(this.m);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.a.checkUpIsLogin() && this.a.L1()) {
            q45 d2 = this.a.d2();
            if (d2 != null && (d2.B() || d2.D())) {
                this.a.d2().z(false, null);
                return;
            }
            if (this.T != null) {
                I();
            }
            B();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            D();
        }
    }

    public void v(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f121f));
            } else if (z2) {
                if (qi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c40);
                }
                this.a.showToast(str);
            }
        }
    }

    public BdTypeListView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.o : (BdTypeListView) invokeV.objValue;
    }

    public PbFakeFloorModel x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.X : (PbFakeFloorModel) invokeV.objValue;
    }

    public ow7 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.U : (ow7) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!qi.isEmpty(this.O)) {
                return this.O;
            }
            if (this.a != null) {
                this.O = TbadkCoreApplication.getInst().getResources().getString(sx7.b());
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }
}
