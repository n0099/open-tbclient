package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.x19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class t19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BottomSheetDialog a;
    public final Context b;
    public final x19 c;
    public final int d;
    public final String e;
    public ForumWriteData f;
    public String g;
    public LinearLayout h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public int s;
    public int t;
    public xg5 u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t19 a;

        public a(t19 t19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.k(this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t19 a;

        public b(t19 t19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.f(this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t19 a;

        public c(t19 t19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.h(this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t19 a;

        public d(t19 t19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u.n(false);
                this.a.a.dismiss();
                this.a.c.p(this.a.f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t19 a;

        public e(t19 t19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.j(this.a.f, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_HOME_VIDEO, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t19 a;

        /* loaded from: classes5.dex */
        public class a implements x19.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.baidu.tieba.x19.d
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = this.a.a.f != null ? this.a.a.f.forumId : "0";
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.a.a.e).param("obj_type", 4));
                    if (this.a.a.d != 1) {
                        if (this.a.a.d == 2) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
                }
            }
        }

        public f(t19 t19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.d(this.a.f, new a(this));
            }
        }
    }

    public t19(Context context, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 3;
        this.b = context;
        this.d = i;
        this.e = str2;
        x19 x19Var = new x19(((TbPageContextSupport) this.b).getPageContext(), str);
        this.c = x19Var;
        x19Var.s(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.b instanceof TbPageContextSupport)) {
            this.a = new BottomSheetDialog(this.b, R.style.obfuscated_res_0x7f1000fa);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0938, (ViewGroup) null);
            this.h = linearLayout;
            this.i = linearLayout.findViewById(R.id.obfuscated_res_0x7f0926c9);
            this.j = (LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926b5);
            this.k = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926b7);
            this.l = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926b6);
            this.j.setOnClickListener(new a(this));
            this.m = (ImageView) this.h.findViewById(R.id.obfuscated_res_0x7f0926bd);
            this.n = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926bf);
            ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926be)).setOnClickListener(new b(this));
            this.o = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926b1);
            ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926b0)).setOnClickListener(new c(this));
            this.p = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926c4);
            xg5 c2 = xg5.c(this.b);
            c2.h(BadgeDrawable.TOP_END);
            c2.g(-65536);
            c2.m(R.dimen.tbds12, false);
            c2.k(R.dimen.tbds15, true);
            c2.i(R.dimen.tbds9);
            c2.f(false);
            c2.l("WriteBottomSheetController.sendHelp");
            c2.b(this.p);
            this.u = c2;
            ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926c3)).setOnClickListener(new d(this));
            this.q = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926cc);
            ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926ca)).setOnClickListener(new e(this));
            this.r = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926af);
            ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926ae)).setOnClickListener(new f(this));
            this.a.setContentView(this.h);
            if (this.a.getWindow() != null && this.a.getWindow().getAttributes() != null) {
                this.t = this.a.getWindow().getAttributes().windowAnimations;
            }
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == null || i == this.s) {
            return;
        }
        hv4 d2 = hv4.d(this.h);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0211);
        hv4 d3 = hv4.d(this.i);
        d3.m(0);
        d3.n(R.string.J_X03);
        d3.f(R.color.CAM_X1112);
        hv4 d4 = hv4.d(this.j);
        d4.m(0);
        d4.n(R.string.J_X06);
        d4.f(R.color.CAM_X0206);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0110);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bd, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
    }

    public void j(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData) == null) {
            this.f = forumWriteData;
        }
    }

    public void k(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.g = str;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a == null) {
                h();
            } else if (this.u.e() && !this.u.d()) {
                this.u.n(false);
            }
            if (this.a.getWindow() != null && this.t > 0) {
                this.a.getWindow().setWindowAnimations(this.t);
            }
            this.a.show();
            if (this.a.getWindow() != null) {
                this.a.getWindow().setWindowAnimations(-1);
            }
        }
    }
}
