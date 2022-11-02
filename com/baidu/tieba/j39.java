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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.m39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class j39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BottomSheetDialog a;
    public final Context b;
    public final m39 c;
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
    public zh5 u;

    public void k(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j39 a;

        /* loaded from: classes4.dex */
        public class a implements m39.d {
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

            @Override // com.baidu.tieba.m39.d
            public void onSuccess() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.a.f != null) {
                        str = this.a.a.f.forumId;
                    } else {
                        str = "0";
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.a.a.e).param("obj_type", 4));
                    if (this.a.a.d == 1) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
                    } else if (this.a.a.d == 2) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                    }
                }
            }
        }

        public f(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j39Var;
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j39 a;

        public a(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j39Var;
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j39 a;

        public b(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j39Var;
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

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j39 a;

        public c(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j39Var;
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

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j39 a;

        public d(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u.m(false);
                this.a.a.dismiss();
                this.a.c.n(this.a.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j39 a;

        public e(j39 j39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j39Var;
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

    public j39(Context context, String str, int i, String str2) {
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
        m39 m39Var = new m39(((TbPageContextSupport) this.b).getPageContext(), str);
        this.c = m39Var;
        m39Var.q(true);
    }

    public void j(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData) == null) {
            this.f = forumWriteData;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.g = str;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !(this.b instanceof TbPageContextSupport)) {
            return;
        }
        this.a = new BottomSheetDialog(this.b, R.style.obfuscated_res_0x7f1000fa);
        this.h = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d094d, (ViewGroup) null);
        if (UtilHelper.isFoldScreen()) {
            this.a.getBehavior().setSkipCollapsed(true);
            this.a.getBehavior().setState(3);
        }
        this.i = this.h.findViewById(R.id.obfuscated_res_0x7f092707);
        this.j = (LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926f5);
        this.k = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926f7);
        this.l = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926f6);
        this.j.setOnClickListener(new a(this));
        this.m = (ImageView) this.h.findViewById(R.id.obfuscated_res_0x7f0926fd);
        this.n = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926ff);
        ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926fe)).setOnClickListener(new b(this));
        this.o = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926f2);
        ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926f1)).setOnClickListener(new c(this));
        this.p = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f092704);
        zh5 c2 = zh5.c(this.b);
        c2.h(BadgeDrawable.TOP_END);
        c2.g(-65536);
        c2.l(R.dimen.tbds12, false);
        c2.j(R.dimen.tbds15, true);
        c2.i(R.dimen.tbds9);
        c2.f(false);
        c2.k("WriteBottomSheetController.sendHelp");
        c2.b(this.p);
        this.u = c2;
        ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f092703)).setOnClickListener(new d(this));
        this.q = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f092709);
        ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f092708)).setOnClickListener(new e(this));
        this.r = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f0926f0);
        ((LinearLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0926ef)).setOnClickListener(new f(this));
        this.a.setContentView(this.h);
        if (this.a.getWindow() != null && this.a.getWindow().getAttributes() != null) {
            this.t = this.a.getWindow().getAttributes().windowAnimations;
        }
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a != null && i != this.s) {
            kw4 d2 = kw4.d(this.h);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0211);
            kw4 d3 = kw4.d(this.i);
            d3.m(0);
            d3.n(R.string.J_X03);
            d3.f(R.color.CAM_X1112);
            kw4 d4 = kw4.d(this.j);
            d4.m(0);
            d4.n(R.string.J_X06);
            d4.f(R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0110);
            this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d6, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a == null) {
                h();
            } else if (this.u.e() && !this.u.d()) {
                this.u.m(false);
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
