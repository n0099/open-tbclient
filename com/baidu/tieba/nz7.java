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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.jv4;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.sp5;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.uv4;
import com.baidu.tieba.vp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class nz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public View B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.y E;
    public qy7 F;
    public View.OnLongClickListener G;
    public sv4 H;
    public jv4 I;
    public int J;
    public PbFragment.h3 K;
    public ty4 L;
    public sp5 M;
    public vp5 N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public l08 U;
    public List<String> V;
    public r28 W;
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
    public a48 p;
    public ProgressBar q;
    public lz7 r;
    public ox7 s;
    public boolean t;
    public MaskView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public RelativeLayout y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.l != null) {
                    this.a.a.l.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
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
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.a.a.s.S()).param("fname", this.a.a.s.n()).param("fid", this.a.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0419));
                if (this.a.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.a.s.S()).param("fname", this.a.s.n()).param("fid", this.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f09d4, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.a.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a.a);
                textView.setText(R.string.obfuscated_res_0x7f0f15ae);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.a.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(yi.g(this.a.a, R.dimen.tbds36), yi.g(this.a.a, R.dimen.tbds36)));
                nz7 nz7Var = this.a;
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(nz7Var.a);
                tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0418);
                tBAlertBuilder.o(spannableString);
                tBAlertBuilder.l(3);
                tBAlertBuilder.i(linearLayout);
                tBAlertBuilder.m(true);
                tBAlertBuilder.n(LinkMovementMethod.getInstance());
                tBAlertBuilder.r(aVar);
                tBAlertBuilder.h(true);
                nz7Var.l = tBAlertBuilder.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public a(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
            } else {
                z3 = false;
            }
            if (z) {
                if (z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a7, 1);
                    this.a.a.K1(sparseArray);
                    return;
                }
                this.a.P(view2);
            } else if (z2) {
                sparseArray.put(R.id.obfuscated_res_0x7f0920a7, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092090, 1);
                this.a.a.K1(sparseArray);
            } else if (z3) {
                this.a.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public b(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.T2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements uv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ nz7 b;

        public c(nz7 nz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz7Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.uv4.e
        public void n0(uv4 uv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
                this.b.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                        return;
                    case 11:
                        if (this.b.K != null) {
                            this.b.K.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f0920b4), sparseArray.get(R.id.obfuscated_res_0x7f0920a1), sparseArray.get(R.id.obfuscated_res_0x7f0920a4), sparseArray.get(R.id.obfuscated_res_0x7f0920a2), sparseArray.get(R.id.obfuscated_res_0x7f0920a3)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.a.h2(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed), sparseArray);
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

    /* loaded from: classes5.dex */
    public class d implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ nz7 c;

        public e(nz7 nz7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz7Var;
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
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    yi.O(this.c.a, R.string.obfuscated_res_0x7f0f0c81);
                } else {
                    this.c.a.Q1(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public f(nz7 nz7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, alertDialog};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements vp5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ nz7 b;

        public g(nz7 nz7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz7Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.vp5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.Q1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements sp5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv4 a;
        public final /* synthetic */ nz7 b;

        public h(nz7 nz7Var, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, jv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz7Var;
            this.a = jv4Var;
        }

        @Override // com.baidu.tieba.sp5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.R1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public i(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements l65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public j(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // com.baidu.tieba.l65
        public void B(k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k65Var) == null) {
                Object obj = k65Var.c;
                if ((obj instanceof e25) && EmotionGroupType.isSendAsPic(((e25) obj).getType())) {
                    if (this.a.P == null) {
                        this.a.P = new PermissionJudgePolicy();
                    }
                    this.a.P.clearRequestPermissionList();
                    this.a.P.appendRequestPermission(this.a.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.P.startRequestPermission(this.a.a)) {
                        return;
                    }
                    this.a.a.d2().f((e25) k65Var.c);
                    this.a.a.d2().w(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public k(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public l(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.a.s != null && this.a.a.s.e() != null) {
                if (!this.a.a.s.e().e()) {
                    this.a.a.s.a(false);
                }
                this.a.a.s.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.T != null && this.a.T.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.W == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.T.getId());
                    nz7 nz7Var = this.a;
                    nz7Var.W = new r28(nz7Var.a.getPageContext(), this.a.e, layoutParams);
                    if (!ListUtils.isEmpty(this.a.V)) {
                        this.a.W.q(this.a.V);
                    }
                    this.a.W.r(this.a.T);
                }
                this.a.W.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(nz7 nz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var, Integer.valueOf(i)};
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
            this.a = nz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof fy7)) {
                fy7 fy7Var = (fy7) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.setSubPbViewData(fy7Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public n(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.J();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public o(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.a.x2();
            if (this.a.a != null && this.a.a.a2() != null && this.a.a.a2().S1() != null && this.a.a.a2().S1().Q() != null && this.a.a.a2().S1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.a.a2().n2()).param("fid", this.a.a.a2().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.a.a2().m2()).param("fid", this.a.a.a2().S1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public p(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public q(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
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

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public r(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                this.a.e.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz7 a;

        public s(nz7 nz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    public nz7(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.y yVar, qy7 qy7Var, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, yVar, qy7Var, onLongClickListener};
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
        this.F = qy7Var;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04ac, (ViewGroup) null);
        this.e = subPbView;
        this.f = (LinearLayout) subPbView.findViewById(R.id.obfuscated_res_0x7f091692);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a3d);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090a3e);
        this.w = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a41);
        this.x = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a40);
        this.c = (NoNetworkView) this.e.findViewById(R.id.obfuscated_res_0x7f092615);
        G();
        this.n = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a3b);
        this.o = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f090a42);
        View view2 = new View(foldCommentActivity.getActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.x(view2, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.e.setTopView(view2);
        this.e.setNavigationView(this.f);
        this.e.setListView(this.o);
        this.e.setContentView(this.n);
        a48 a48Var = new a48(foldCommentActivity.getPageContext());
        this.p = a48Var;
        a48Var.z();
        this.p.D(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091b07);
        this.u = (MaskView) this.e.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.B = this.e.findViewById(R.id.obfuscated_res_0x7f0925fb);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a3c);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a3f);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(yi.g(this.a, R.dimen.L_X01));
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
        l08 l08Var = new l08(this.a.getPageContext(), this.X, this.n);
        this.U = l08Var;
        l08Var.k(new p(this));
        this.U.n(this.a.U);
        this.X.U(new q(this));
        this.a.registerListener(this.Z);
    }

    public void P(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        O(sparseArray, false);
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

    public void Y(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbModel) == null) {
            this.b = pbModel;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048602, this, z) != null) || this.y == null) {
            return;
        }
        W(this.a.d2().y());
        if (this.Q) {
            c0(z);
        } else {
            C(z);
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f100d)));
            this.y.setVisibility(8);
        }
    }

    public void i0(boolean z) {
        lz7 lz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (lz7Var = this.r) != null) {
            lz7Var.f(z);
            this.r.b();
        }
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (SubPbView) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.y == null) {
            return;
        }
        this.B.setVisibility(8);
        this.y.setVisibility(8);
        PbEmotionBar pbEmotionBar = this.S;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
        }
    }

    public void D() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (editorTools = this.T) != null) {
            editorTools.o();
            r28 r28Var = this.W;
            if (r28Var != null) {
                r28Var.m();
            }
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (noDataView = this.d) != null) {
            noDataView.setVisibility(8);
            this.o.setVisibility(0);
        }
    }

    public void I() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a != null && (editorTools = this.T) != null) {
            editorTools.j();
            B();
        }
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

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.f();
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.T();
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.L == null) {
                this.L = new ty4(this.a.getPageContext());
            }
            this.L.h(true);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            D();
        }
    }

    public BdTypeListView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public PbFakeFloorModel x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.X;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public l08 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.U;
        }
        return (l08) invokeV.objValue;
    }

    public void C(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.y != null && this.R != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            PbModel pbModel = this.b;
            boolean z3 = true;
            if (pbModel != null && pbModel.S1() != null && this.b.S1().r0()) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.R.setText(tbSingleton.getAdVertiComment(z2, (this.b.S1() == null || !this.b.S1().s0()) ? false : false, z()));
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y.startAnimation(alphaAnimation);
            }
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f100c), new b(this)));
            if (this.d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, yi.g(pageActivity, R.dimen.obfuscated_res_0x7f070288)), eVar, a2);
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

    public void T(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.T = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.T.setId(R.id.obfuscated_res_0x7f09182c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.T.getParent() == null) {
                this.n.addView(this.T, layoutParams);
            }
            this.T.w(TbadkCoreApplication.getInst().getSkinType());
            this.T.setActionListener(24, new j(this));
            D();
            this.a.d2().g(new l(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            lz7 lz7Var = new lz7(this.a, this.o);
            this.r = lz7Var;
            lz7Var.j(this.a.y0());
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

    public final void J() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbModel = this.b) != null && pbModel.S1() != null && this.b.S1().z() != null && yi.F()) {
            if (this.b.S1().z().b() == 0) {
                U();
                return;
            }
            a48 a48Var = this.p;
            if (a48Var != null) {
                a48Var.S();
            }
            if (this.b.N2(false)) {
                X();
            } else {
                U();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || !this.a.checkUpIsLogin() || !this.a.L1()) {
            return;
        }
        m85 d2 = this.a.d2();
        if (d2 != null && (d2.x() || d2.z())) {
            this.a.d2().w(false, null);
            return;
        }
        if (this.T != null) {
            I();
        }
        B();
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int g2 = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070306);
            int g3 = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.obfuscated_res_0x7f092613);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0662));
            this.i = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04ad, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09169c);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096b, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.g.getBackImageView();
            this.h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.i;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.i.setLayoutParams(layoutParams2);
            }
            this.g.setIsClose(true);
            this.g.setIsCorner(true);
            this.g.isShowBottomLine(true);
            this.g.setBottomLineHeight(3);
            this.g.setStatusBarVisibility(8);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            rq4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.e);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            this.g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.C2() || this.b.B2())) {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080b14, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a31, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.c.d(this.a.getPageContext(), i2);
            this.a.getLayoutMode().k(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0110);
            this.v.setAlpha(0.95f);
            lz7 lz7Var = this.r;
            if (lz7Var != null) {
                lz7Var.b();
            }
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(yi.g(this.a, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            pw4.d(this.y).f(R.color.CAM_X0208);
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
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            if (i3 == 1002 && !z) {
                i4 = R.string.obfuscated_res_0x7f0f1047;
            } else {
                i4 = R.string.obfuscated_res_0x7f0f04b0;
            }
            int i5 = R.string.obfuscated_res_0x7f0f0448;
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.obfuscated_res_0x7f0f104b;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f04b4;
                    i4 = R.string.obfuscated_res_0x7f0f04b5;
                }
            }
            this.I = new jv4(this.a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(R.string.dialog_ok, this.a);
            this.I.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.a.getPageContext());
            if (z2) {
                b0(sparseArray, i5, i4);
            } else if (z) {
                b0(sparseArray, i5, i4);
            } else if (Z()) {
                up5 up5Var = new up5(this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.b.S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.b.S1().o().has_forum_rule.intValue());
                up5Var.i(this.b.S1().l().getId(), this.b.S1().l().getName());
                up5Var.h(this.b.S1().l().getImage_url());
                up5Var.j(this.b.S1().l().getUser_level());
                e0(sparseArray, i2, up5Var, this.b.S1().X(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        qv4 qv4Var;
        qv4 qv4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            uv4 uv4Var = new uv4(this.a);
            uv4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e9));
            uv4Var.n(new c(this, z));
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
                    qv4Var2 = new qv4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04c6), uv4Var);
                } else {
                    qv4Var2 = new qv4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), uv4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray2.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray2.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                qv4Var2.d.setTag(sparseArray2);
                arrayList.add(qv4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920b5) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920b5)).booleanValue()) {
                qv4 qv4Var3 = new qv4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b5a), uv4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                qv4Var3.d.setTag(sparseArray3);
                arrayList.add(qv4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f0920a1)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f0920a2))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a4, sparseArray.get(R.id.obfuscated_res_0x7f0920a4));
                qv4 qv4Var4 = new qv4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0675), uv4Var);
                qv4Var4.d.setTag(sparseArray4);
                arrayList.add(qv4Var4);
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
                if (z) {
                    qv4Var = new qv4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14fb), uv4Var);
                } else {
                    qv4Var = new qv4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b66), uv4Var);
                }
                qv4Var.d.setTag(sparseArray5);
                arrayList.add(qv4Var);
            }
            m38.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                uv4Var.k(arrayList, false);
            } else {
                uv4Var.k(arrayList, true);
            }
            sv4 sv4Var = new sv4(this.a.getPageContext(), uv4Var);
            this.H = sv4Var;
            sv4Var.k();
        }
    }

    public final void Q() {
        FoldCommentActivity foldCommentActivity;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (foldCommentActivity = this.a) != null && foldCommentActivity.d2() != null && this.T != null) {
            i85.a().c(0);
            m85 d2 = this.a.d2();
            d2.M();
            d2.K();
            if (d2.v() != null) {
                WriteImagesInfo v = d2.v();
                if (d2.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v.setMaxImagesAllowed(i2);
            }
            d2.d0(SendView.h);
            d2.h(SendView.h);
            r65 m2 = this.T.m(23);
            r65 m3 = this.T.m(2);
            r65 m4 = this.T.m(5);
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
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.m = new BlankView(this.a.getPageContext().getPageActivity());
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.C2() || this.b.B2())) {
                this.J = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070252);
            }
            this.f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.e.setBlankView(this.m);
        }
    }

    public void S(ox7 ox7Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048594, this, ox7Var, z) != null) || ox7Var == null) {
            return;
        }
        this.s = ox7Var;
        this.t = z;
        if (ox7Var.e0()) {
            this.p.S();
        } else {
            this.p.f();
        }
        this.r.d(this.t);
        this.r.i(ox7Var);
        this.e.setEnableDragExit(true);
        String adVertiComment = TbSingleton.getInstance().getAdVertiComment(ox7Var.r0(), ox7Var.s0(), z());
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(adVertiComment);
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.a == null || this.b.S1().l().getDeletedReasonInfo() == null || 1 != this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!xi.isEmpty(this.O)) {
                return this.O;
            }
            if (this.a != null) {
                this.O = TbadkCoreApplication.getInst().getResources().getString(q18.g());
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    public final void b0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048603, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04bb, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0377, TBAlertConfig.OperateBtnStyle.SECONDARY);
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
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && this.y != null && (textView = this.R) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0531);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y.startAnimation(alphaAnimation);
            }
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, up5 up5Var, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), up5Var, userData, Boolean.valueOf(z)}) != null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new vp5(foldCommentActivity.getPageContext(), null, up5Var, userData);
        }
        this.N.F(z);
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
        pt4 pt4Var = new pt4();
        pt4Var.j(sparseArray2);
        this.N.H(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0), this.a.getString(R.string.obfuscated_res_0x7f0f04d1), this.a.getString(R.string.obfuscated_res_0x7f0f04d2), this.a.getString(R.string.obfuscated_res_0x7f0f04d3)});
        this.N.G(pt4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.N.J(str);
        this.N.I(new g(this, sparseArray));
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f100d)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(jv4 jv4Var, int i2) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048609, this, jv4Var, i2) == null) && (foldCommentActivity = this.a) != null && jv4Var != null) {
            if (this.M == null) {
                this.M = new sp5(foldCommentActivity.getPageContext(), null);
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
            pt4 pt4Var = new pt4();
            pt4Var.j(sparseArray);
            this.M.B(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0), this.a.getString(R.string.obfuscated_res_0x7f0f04d1), this.a.getString(R.string.obfuscated_res_0x7f0f04d2), this.a.getString(R.string.obfuscated_res_0x7f0f04d3)});
            this.M.A(pt4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.M.D(str);
            this.M.C(new h(this, jv4Var));
        }
    }

    public void v(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1276));
            } else if (z2) {
                if (xi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
                }
                this.a.showToast(str);
            }
        }
    }
}
