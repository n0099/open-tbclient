package com.baidu.tieba;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.RadiusProgressView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class s68 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TbImageView B;
    public BdListView C;
    public b D;
    public RadiusProgressView E;
    public c68 F;
    public TbPageContext i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public ImageView r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0703 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List a;
        public LayoutInflater b;
        public final /* synthetic */ s68 c;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a55 a;
            public final /* synthetic */ b b;

            public a(b bVar, a55 a55Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, a55Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = a55Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    String a = this.a.a();
                    a78.a("2");
                    if (UserGrowthTaskRequestMessage.SET_USER_AVATAR.equals(a)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.c.i.getPageActivity(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountNameShow())));
                    } else if (UserGrowthTaskRequestMessage.SET_USER_NICK.equals(a)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.c.i.getPageActivity(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountNameShow())));
                    } else if ("set_user_profile".equals(a)) {
                        this.b.d();
                    } else if ("page_sign".equals(a)) {
                        UrlManager.getInstance().dealOneLink(this.b.c.i, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                    } else if ("follow".equals(a)) {
                        MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.b.c.i.getPageActivity()).createNormalCfg(1);
                        createNormalCfg.setSubTab(1, "吧广场");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, createNormalCfg));
                    } else if (UserGrowthTaskRequestMessage.SHARE_THREAD.equals(a)) {
                        UrlManager.getInstance().dealOneLink(this.b.c.i, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                    } else if ("add_post".equals(a)) {
                        WriteActivityConfig.newInstance(this.b.c.i.getPageActivity()).setCallFrom("2").setType(9).setFrom("main_tab").send();
                    } else {
                        UrlManager.getInstance().dealOneLink(this.b.c.i, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.s68$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0401b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public TbImageView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public TBSpecificationBtn f;

            public C0401b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = 3;
            }

            public /* synthetic */ C0401b(b bVar, a aVar) {
                this(bVar);
            }
        }

        public b(s68 s68Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s68Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s68Var;
            this.a = new ArrayList();
            this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: c */
        public a55 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return (a55) this.a.get(i);
            }
            return (a55) invokeI.objValue;
        }

        public void e(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a.clear();
                if (list != null) {
                    this.a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }

        public final void b(C0401b c0401b, View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, c0401b, view2, i) == null) && c0401b != null && c0401b.a != i) {
                nv4.d(c0401b.c).v(R.color.CAM_X0105);
                nv4.d(c0401b.e).v(R.color.CAM_X0109);
                nv4.d(c0401b.d).v(R.color.CAM_X0118);
                ty4 ty4Var = new ty4();
                ty4Var.r(R.color.CAM_X0118);
                c0401b.f.setConfig(ty4Var);
                c0401b.a = i;
            }
        }

        public final void d() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        str = "&skin=dart";
                    } else if (skinType == 1) {
                        str = "&skin=night";
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.c.i, new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            C0401b c0401b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
                a55 item = getItem(i);
                if (item == null) {
                    return view2;
                }
                if (view2 != null && (view2.getTag() instanceof C0401b)) {
                    c0401b = (C0401b) view2.getTag();
                } else {
                    view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d08ba, (ViewGroup) null);
                    c0401b = new C0401b(this, null);
                    c0401b.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092484);
                    c0401b.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092486);
                    c0401b.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092487);
                    c0401b.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092483);
                    c0401b.f = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f092482);
                    view2.setTag(c0401b);
                }
                c0401b.b.L(item.e(), 10, false);
                c0401b.c.setText(item.c());
                c0401b.d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151f), Integer.valueOf(item.f())));
                c0401b.e.setText(item.b());
                if (item.d() == 2) {
                    c0401b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1521));
                    c0401b.f.setUseDisableState(true);
                } else {
                    c0401b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1520));
                    c0401b.f.setUseDisableState(false);
                    c0401b.f.setOnClickListener(new a(this, item));
                }
                b(c0401b, view2, TbadkCoreApplication.getInst().getSkinType());
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s68(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = new c68();
        this.i = tbPageContext;
        View k = k();
        int f = fj.f(this.c, R.dimen.M_W_X003);
        k.setPadding(f, 0, f, 0);
        this.j = k.findViewById(R.id.obfuscated_res_0x7f091903);
        this.k = k.findViewById(R.id.obfuscated_res_0x7f091902);
        this.l = k.findViewById(R.id.obfuscated_res_0x7f091901);
        View findViewById = k.findViewById(R.id.obfuscated_res_0x7f092283);
        this.m = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = k.findViewById(R.id.obfuscated_res_0x7f091523);
        this.n = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = k.findViewById(R.id.obfuscated_res_0x7f0903e9);
        this.o = findViewById3;
        findViewById3.setOnClickListener(this);
        View findViewById4 = k.findViewById(R.id.obfuscated_res_0x7f092480);
        this.p = findViewById4;
        findViewById4.setOnClickListener(this);
        this.q = k.findViewById(R.id.obfuscated_res_0x7f09247f);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092203);
        this.u = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092125);
        this.v = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090d0f);
        this.w = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092425);
        this.x = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092253);
        this.y = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09242e);
        this.z = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09242f);
        this.A = (TextView) k.findViewById(R.id.obfuscated_res_0x7f092488);
        this.r = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090ebc);
        this.s = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f092489);
        this.C = (BdListView) k.findViewById(R.id.obfuscated_res_0x7f092485);
        b bVar = new b(this, this.i);
        this.D = bVar;
        this.C.setAdapter((ListAdapter) bVar);
        TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f09247d);
        this.B = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.B.setDrawCorner(true);
        this.B.setRadiusById(R.string.J_X14);
        this.B.setConrers(3);
        RadiusProgressView radiusProgressView = (RadiusProgressView) k.findViewById(R.id.obfuscated_res_0x7f092481);
        this.E = radiusProgressView;
        radiusProgressView.setOnClickListener(this);
        m(g(), TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: s */
    public void l(c68 c68Var) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, c68Var) == null) && c68Var != null && c68Var.c() != null) {
            if (TbSingleton.getInstance().isUserGrowthOpen()) {
                this.j.setVisibility(0);
                this.l.setVisibility(0);
                this.k.setVisibility(0);
                this.B.setVisibility(0);
            } else {
                this.j.setVisibility(8);
                this.l.setVisibility(8);
                this.k.setVisibility(8);
                this.B.setVisibility(8);
            }
            this.F = c68Var;
            this.v.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151b), Integer.valueOf(c68Var.c().a())));
            this.x.setText(String.valueOf((int) c68Var.c().e()));
            long b2 = c68Var.c().b();
            long c = c68Var.c().c();
            long j = c - b2;
            SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151d), Long.valueOf(b2), Long.valueOf(c)));
            spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
            this.y.setText(spannableString2);
            if (this.F.c().a() == 10) {
                spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151c));
            } else {
                spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151e), Long.valueOf(j)));
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 9, String.valueOf(j).length() + 9, 18);
            }
            this.z.setText(spannableString);
            if (b2 > 0) {
                if (b2 < c) {
                    this.E.setProgress((int) ((b2 * 100) / c));
                } else {
                    this.E.setProgress(100);
                }
            } else {
                this.E.setProgress(0);
            }
            this.D.e(c68Var.c().d());
            m(g(), TbadkCoreApplication.getInst().getSkinType());
            if (c68Var != null) {
                a78.b();
            }
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.B.L(String.valueOf((int) R.drawable.obfuscated_res_0x7f08083e), 24, false);
            if (i != 1 && i != 4) {
                this.B.setAlpha(1.0f);
            } else {
                this.B.setAlpha(0.3f);
            }
            nv4 d = nv4.d(this.l);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            nv4.d(this.q).f(R.color.CAM_X0401);
            nv4.d(this.t).v(R.color.CAM_X0105);
            nv4.d(this.u).v(R.color.CAM_X0118);
            nv4.d(this.v).v(R.color.CAM_X0105);
            nv4.d(this.w).v(R.color.CAM_X0107);
            nv4.d(this.x).v(R.color.CAM_X0105);
            nv4.d(this.y).v(R.color.CAM_X0107);
            nv4.d(this.z).v(R.color.CAM_X0107);
            if (this.F.c() != null) {
                long b2 = this.F.c().b();
                long c = this.F.c().c();
                long j = c - b2;
                SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151d), Long.valueOf(b2), Long.valueOf(c)));
                spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
                this.y.setText(spannableString2);
                if (this.F.c().a() == 10) {
                    spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151c));
                } else {
                    spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151e), Long.valueOf(j)));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 9, String.valueOf(j).length() + 9, 18);
                }
                this.z.setText(spannableString);
                if (b2 > 0) {
                    if (b2 < c) {
                        this.E.setProgress((int) ((b2 * 100) / c));
                    } else {
                        this.E.setProgress(100);
                    }
                } else {
                    this.E.setProgress(0);
                }
            }
            nv4.d(this.A).v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0118, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f092480) {
                UrlManager.getInstance().dealOneLink(this.i, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                a78.a("2");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092283 || view2.getId() == R.id.obfuscated_res_0x7f091523 || view2.getId() == R.id.obfuscated_res_0x7f092481 || view2.getId() == R.id.obfuscated_res_0x7f0903e9) {
                UrlManager.getInstance().dealOneLink(this.i, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                a78.a("1");
            }
        }
    }
}
