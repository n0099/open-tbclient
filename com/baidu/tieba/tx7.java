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
import com.baidu.tieba.av4;
import com.baidu.tieba.ho5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pu4;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class tx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public View B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.y E;
    public ww7 F;
    public View.OnLongClickListener G;
    public yu4 H;
    public pu4 I;
    public int J;
    public PbFragment.h3 K;
    public yx4 L;
    public ho5 M;
    public ko5 N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public ry7 U;
    public List V;
    public w08 W;
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
    public f28 p;
    public ProgressBar q;
    public rx7 r;
    public uv7 s;
    public boolean t;
    public MaskView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public RelativeLayout y;
    public LinearLayout z;

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        /* loaded from: classes6.dex */
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

        /* loaded from: classes6.dex */
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
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.a.a.s.R()).param("fname", this.a.a.s.n()).param("fid", this.a.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0416));
                if (this.a.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.a.s.R()).param("fname", this.a.s.n()).param("fid", this.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f09c4, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.a.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a.a);
                textView.setText(R.string.obfuscated_res_0x7f0f1589);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.a.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(fj.f(this.a.a, R.dimen.tbds36), fj.f(this.a.a, R.dimen.tbds36)));
                tx7 tx7Var = this.a;
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(tx7Var.a);
                tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0415);
                tBAlertBuilder.o(spannableString);
                tBAlertBuilder.l(3);
                tBAlertBuilder.i(linearLayout);
                tBAlertBuilder.m(true);
                tBAlertBuilder.n(LinkMovementMethod.getInstance());
                tBAlertBuilder.r(aVar);
                tBAlertBuilder.h(true);
                tx7Var.l = tBAlertBuilder.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public a(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
            } else {
                z3 = false;
            }
            if (z) {
                if (z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09204f, 1);
                    this.a.a.J1(sparseArray);
                    return;
                }
                this.a.P(view2);
            } else if (z2) {
                sparseArray.put(R.id.obfuscated_res_0x7f09204f, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092038, 1);
                this.a.a.J1(sparseArray);
            } else if (z3) {
                this.a.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public b(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.T2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ tx7 b;

        public c(tx7 tx7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.b.H.dismiss();
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                        return;
                    case 11:
                        if (this.b.K != null) {
                            this.b.K.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09205c), sparseArray.get(R.id.obfuscated_res_0x7f092049), sparseArray.get(R.id.obfuscated_res_0x7f09204c), sparseArray.get(R.id.obfuscated_res_0x7f09204a), sparseArray.get(R.id.obfuscated_res_0x7f09204b)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.a.g2(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092094), sparseArray);
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

    /* loaded from: classes6.dex */
    public class d implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
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

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ tx7 c;

        public e(tx7 tx7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tx7Var;
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
                    fj.M(this.c.a, R.string.obfuscated_res_0x7f0f0c68);
                } else {
                    this.c.a.P1(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public f(tx7 tx7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, alertDialog};
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

    /* loaded from: classes6.dex */
    public class g implements ko5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ tx7 b;

        public g(tx7 tx7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.ko5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.P1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ho5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ tx7 b;

        public h(tx7 tx7Var, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.ho5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.Q1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public i(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements m55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public j(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // com.baidu.tieba.m55
        public void B(l55 l55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l55Var) == null) {
                Object obj = l55Var.c;
                if ((obj instanceof j15) && EmotionGroupType.isSendAsPic(((j15) obj).getType())) {
                    if (this.a.P == null) {
                        this.a.P = new PermissionJudgePolicy();
                    }
                    this.a.P.clearRequestPermissionList();
                    this.a.P.appendRequestPermission(this.a.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.P.startRequestPermission(this.a.a)) {
                        return;
                    }
                    this.a.a.c2().f((j15) l55Var.c);
                    this.a.a.c2().w(false, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public k(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public l(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
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
                    tx7 tx7Var = this.a;
                    tx7Var.W = new w08(tx7Var.a.getPageContext(), this.a.e, layoutParams);
                    if (!ListUtils.isEmpty(this.a.V)) {
                        this.a.W.q(this.a.V);
                    }
                    this.a.W.r(this.a.T);
                }
                this.a.W.p(substring);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(tx7 tx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, Integer.valueOf(i)};
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
            this.a = tx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lw7)) {
                lw7 lw7Var = (lw7) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.setSubPbViewData(lw7Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public n(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
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

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public o(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.a.w2();
            if (this.a.a != null && this.a.a.Z1() != null && this.a.a.Z1().S1() != null && this.a.a.Z1().S1().P() != null && this.a.a.Z1().S1().P().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.a.Z1().n2()).param("fid", this.a.a.Z1().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.a.Z1().m2()).param("fid", this.a.a.Z1().S1().m()).param("obj_locate", 1).param("uid", this.a.a.Z1().S1().P().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public p(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public q(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
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

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public r(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                this.a.e.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public s(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    public tx7(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.y yVar, ww7 ww7Var, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, yVar, ww7Var, onLongClickListener};
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
        this.b = foldCommentActivity.Z1();
        this.C = onClickListener;
        this.E = yVar;
        this.F = ww7Var;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d049b, (ViewGroup) null);
        this.e = subPbView;
        this.f = (LinearLayout) subPbView.findViewById(R.id.obfuscated_res_0x7f09164c);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a29);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090a2a);
        this.w = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a2d);
        this.x = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a2c);
        this.c = (NoNetworkView) this.e.findViewById(R.id.obfuscated_res_0x7f0925af);
        G();
        this.n = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a27);
        this.o = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f090a2e);
        View view2 = new View(foldCommentActivity.getActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.x(view2, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.e.setTopView(view2);
        this.e.setNavigationView(this.f);
        this.e.setListView(this.o);
        this.e.setContentView(this.n);
        f28 f28Var = new f28(foldCommentActivity.getPageContext());
        this.p = f28Var;
        f28Var.y();
        this.p.C(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091ab9);
        this.u = (MaskView) this.e.findViewById(R.id.obfuscated_res_0x7f0914b9);
        this.B = this.e.findViewById(R.id.obfuscated_res_0x7f092595);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a28);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a2b);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(fj.f(this.a, R.dimen.L_X01));
        this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.L(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.X = pbFakeFloorModel;
        pbFakeFloorModel.S(this.b.I(), this.b.E(), this.b.F(), this.b.D(), this.b.J());
        ry7 ry7Var = new ry7(this.a.getPageContext(), this.X, this.n);
        this.U = ry7Var;
        ry7Var.k(new p(this));
        this.U.n(this.a.U);
        this.X.U(new q(this));
        this.a.registerListener(this.Z);
    }

    public void P(View view2) {
        SparseArray sparseArray;
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
        W(this.a.c2().y());
        if (this.Q) {
            c0(z);
        } else {
            C(z);
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fec)));
            this.y.setVisibility(8);
        }
    }

    public void i0(boolean z) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (rx7Var = this.r) != null) {
            rx7Var.f(z);
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
            w08 w08Var = this.W;
            if (w08Var != null) {
                w08Var.m();
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
            this.p.S();
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.L == null) {
                this.L = new yx4(this.a.getPageContext());
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

    public ry7 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.U;
        }
        return (ry7) invokeV.objValue;
    }

    public void C(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.y != null && this.R != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            PbModel pbModel = this.b;
            boolean z3 = true;
            if (pbModel != null && pbModel.S1() != null && this.b.S1().q0()) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.R.setText(tbSingleton.getAdVertiComment(z2, (this.b.S1() == null || !this.b.S1().r0()) ? false : false, z()));
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
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0feb), new b(this)));
            if (this.d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, fj.f(pageActivity, R.dimen.obfuscated_res_0x7f070288)), eVar, a2);
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
            this.T.setId(R.id.obfuscated_res_0x7f0917e4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.T.getParent() == null) {
                this.n.addView(this.T, layoutParams);
            }
            this.T.w(TbadkCoreApplication.getInst().getSkinType());
            this.T.setActionListener(24, new j(this));
            D();
            this.a.c2().g(new l(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            rx7 rx7Var = new rx7(this.a, this.o);
            this.r = rx7Var;
            rx7Var.j(this.a.z0());
            this.r.k(this.a.d2());
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbModel = this.b) != null && pbModel.S1() != null && this.b.S1().y() != null && fj.D()) {
            if (this.b.S1().y().b() == 0) {
                U();
                return;
            }
            f28 f28Var = this.p;
            if (f28Var != null) {
                f28Var.R();
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
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || !this.a.checkUpIsLogin() || !this.a.K1()) {
            return;
        }
        n75 c2 = this.a.c2();
        if (c2 != null && (c2.x() || c2.z())) {
            this.a.c2().w(false, null);
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
            int f2 = fj.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070306);
            int f3 = fj.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.obfuscated_res_0x7f0925ad);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f065e));
            this.i = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d049c, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091656);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094f, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
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

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            zp4 layoutMode = this.a.getLayoutMode();
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
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080af5, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a13, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.c.d(this.a.getPageContext(), i2);
            this.a.getLayoutMode().k(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0110);
            this.v.setAlpha(0.95f);
            rx7 rx7Var = this.r;
            if (rx7Var != null) {
                rx7Var.b();
            }
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(fj.f(this.a, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            nv4.d(this.y).f(R.color.CAM_X0208);
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
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            if (i3 == 1002 && !z) {
                i4 = R.string.obfuscated_res_0x7f0f1026;
            } else {
                i4 = R.string.obfuscated_res_0x7f0f04ad;
            }
            int i5 = R.string.obfuscated_res_0x7f0f0445;
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.obfuscated_res_0x7f0f102a;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f04b1;
                    i4 = R.string.obfuscated_res_0x7f0f04b2;
                }
            }
            this.I = new pu4(this.a);
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
                jo5 jo5Var = new jo5(this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.b.S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.b.S1().o().has_forum_rule.intValue());
                jo5Var.i(this.b.S1().l().getId(), this.b.S1().l().getName());
                jo5Var.h(this.b.S1().l().getImage_url());
                jo5Var.j(this.b.S1().l().getUser_level());
                e0(sparseArray, i2, jo5Var, this.b.S1().W(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray sparseArray, boolean z) {
        int i2;
        wu4 wu4Var;
        wu4 wu4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            av4 av4Var = new av4(this.a);
            av4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e8));
            av4Var.n(new c(this, z));
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
                if (z) {
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
            yu4 yu4Var = new yu4(this.a.getPageContext(), av4Var);
            this.H = yu4Var;
            yu4Var.k();
        }
    }

    public final void Q() {
        FoldCommentActivity foldCommentActivity;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (foldCommentActivity = this.a) != null && foldCommentActivity.c2() != null && this.T != null) {
            j75.a().c(0);
            n75 c2 = this.a.c2();
            c2.M();
            c2.K();
            if (c2.v() != null) {
                WriteImagesInfo v = c2.v();
                if (c2.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v.setMaxImagesAllowed(i2);
            }
            c2.d0(SendView.h);
            c2.h(SendView.h);
            s55 m2 = this.T.m(23);
            s55 m3 = this.T.m(2);
            s55 m4 = this.T.m(5);
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
                this.J = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070252);
            }
            this.f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.e.setBlankView(this.m);
        }
    }

    public void S(uv7 uv7Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048594, this, uv7Var, z) != null) || uv7Var == null) {
            return;
        }
        this.s = uv7Var;
        this.t = z;
        if (uv7Var.d0()) {
            this.p.R();
        } else {
            this.p.f();
        }
        this.r.d(this.t);
        this.r.i(uv7Var);
        this.e.setEnableDragExit(true);
        String adVertiComment = TbSingleton.getInstance().getAdVertiComment(uv7Var.q0(), uv7Var.r0(), z());
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
            if (!ej.isEmpty(this.O)) {
                return this.O;
            }
            if (this.a != null) {
                this.O = TbadkCoreApplication.getInst().getResources().getString(wz7.b());
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    public final void b0(SparseArray sparseArray, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048603, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04b8, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
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
            textView.setText(R.string.obfuscated_res_0x7f0f052e);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y.startAnimation(alphaAnimation);
            }
        }
    }

    public final void e0(SparseArray sparseArray, int i2, jo5 jo5Var, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), jo5Var, userData, Boolean.valueOf(z)}) != null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new ko5(foldCommentActivity.getPageContext(), null, jo5Var, userData);
        }
        this.N.F(z);
        AntiData T1 = this.a.T1();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (T1 != null && T1.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = T1.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        xs4 xs4Var = new xs4();
        xs4Var.j(sparseArray2);
        this.N.H(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cc), this.a.getString(R.string.obfuscated_res_0x7f0f04cd), this.a.getString(R.string.obfuscated_res_0x7f0f04ce), this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0)});
        this.N.G(xs4Var);
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
                H(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fec)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(pu4 pu4Var, int i2) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048609, this, pu4Var, i2) == null) && (foldCommentActivity = this.a) != null && pu4Var != null) {
            if (this.M == null) {
                this.M = new ho5(foldCommentActivity.getPageContext(), null);
            }
            AntiData T1 = this.a.T1();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (T1 != null && T1.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = T1.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            xs4 xs4Var = new xs4();
            xs4Var.j(sparseArray);
            this.M.B(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04cc), this.a.getString(R.string.obfuscated_res_0x7f0f04cd), this.a.getString(R.string.obfuscated_res_0x7f0f04ce), this.a.getString(R.string.obfuscated_res_0x7f0f04cf), this.a.getString(R.string.obfuscated_res_0x7f0f04d0)});
            this.M.A(xs4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.M.D(str);
            this.M.C(new h(this, pu4Var));
        }
    }

    public void v(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1252));
            } else if (z2) {
                if (ej.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                }
                this.a.showToast(str);
            }
        }
    }
}
