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
/* loaded from: classes6.dex */
public class u58 extends v06<e58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TbImageView B;
    public BdListView C;
    public b D;
    public RadiusProgressView E;
    public e58 F;
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<i45> a;
        public LayoutInflater b;
        public final /* synthetic */ u58 c;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i45 a;
            public final /* synthetic */ b b;

            public a(b bVar, i45 i45Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, i45Var};
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
                this.a = i45Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    String a = this.a.a();
                    c68.a("2");
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
                    } else if (!"add_post".equals(a)) {
                        UrlManager.getInstance().dealOneLink(this.b.c.i, new String[]{TbConfig.USER_GROWTH_GUIDE_MAIN_URL});
                    } else {
                        WriteActivityConfig.newInstance(this.b.c.i.getPageActivity()).setCallFrom("2").setType(9).setFrom("main_tab").send();
                    }
                }
            }
        }

        public b(u58 u58Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u58Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u58Var;
            this.a = new ArrayList();
            this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        }

        public final void b(C0428b c0428b, View view2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, c0428b, view2, i) == null) || c0428b == null || c0428b.a == i) {
                return;
            }
            uu4.d(c0428b.c).v(R.color.CAM_X0105);
            uu4.d(c0428b.e).v(R.color.CAM_X0109);
            uu4.d(c0428b.d).v(R.color.CAM_X0118);
            ay4 ay4Var = new ay4();
            ay4Var.r(R.color.CAM_X0118);
            c0428b.f.setConfig(ay4Var);
            c0428b.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: c */
        public i45 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.a.get(i) : (i45) invokeI.objValue;
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

        public void e(List<i45> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a.clear();
                if (list != null) {
                    this.a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            C0428b c0428b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
                i45 item = getItem(i);
                if (item == null) {
                    return view2;
                }
                if (view2 != null && (view2.getTag() instanceof C0428b)) {
                    c0428b = (C0428b) view2.getTag();
                } else {
                    view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d08b9, (ViewGroup) null);
                    c0428b = new C0428b(this, null);
                    c0428b.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092497);
                    c0428b.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092499);
                    c0428b.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09249a);
                    c0428b.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092496);
                    c0428b.f = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f092495);
                    view2.setTag(c0428b);
                }
                c0428b.b.K(item.e(), 10, false);
                c0428b.c.setText(item.c());
                c0428b.d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1505), Integer.valueOf(item.f())));
                c0428b.e.setText(item.b());
                if (item.d() == 2) {
                    c0428b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1507));
                    c0428b.f.setUseDisableState(true);
                } else {
                    c0428b.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1506));
                    c0428b.f.setUseDisableState(false);
                    c0428b.f.setOnClickListener(new a(this, item));
                }
                b(c0428b, view2, TbadkCoreApplication.getInst().getSkinType());
                return view2;
            }
            return (View) invokeILL.objValue;
        }

        /* renamed from: com.baidu.tieba.u58$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0428b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public TbImageView b;
            public TextView c;
            public TextView d;
            public TextView e;
            public TBSpecificationBtn f;

            public C0428b(b bVar) {
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

            public /* synthetic */ C0428b(b bVar, a aVar) {
                this(bVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u58(TbPageContext<?> tbPageContext) {
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
        this.F = new e58();
        this.i = tbPageContext;
        View h = h();
        this.j = h.findViewById(R.id.obfuscated_res_0x7f09190d);
        this.k = h.findViewById(R.id.obfuscated_res_0x7f09190c);
        this.l = h.findViewById(R.id.obfuscated_res_0x7f09190b);
        View findViewById = h.findViewById(R.id.obfuscated_res_0x7f092296);
        this.m = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = h.findViewById(R.id.obfuscated_res_0x7f091531);
        this.n = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = h.findViewById(R.id.obfuscated_res_0x7f0903e1);
        this.o = findViewById3;
        findViewById3.setOnClickListener(this);
        View findViewById4 = h.findViewById(R.id.obfuscated_res_0x7f092493);
        this.p = findViewById4;
        findViewById4.setOnClickListener(this);
        this.q = h.findViewById(R.id.obfuscated_res_0x7f092492);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092216);
        this.u = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092123);
        this.v = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090d03);
        this.w = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092438);
        this.x = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092266);
        this.y = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092441);
        this.z = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092442);
        this.A = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09249b);
        this.r = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090ec8);
        this.s = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f09249c);
        this.C = (BdListView) h.findViewById(R.id.obfuscated_res_0x7f092498);
        b bVar = new b(this, this.i);
        this.D = bVar;
        this.C.setAdapter((ListAdapter) bVar);
        TbImageView tbImageView = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f092490);
        this.B = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.B.setDrawCorner(true);
        this.B.setRadiusById(R.string.J_X14);
        this.B.setConrers(3);
        RadiusProgressView radiusProgressView = (RadiusProgressView) h.findViewById(R.id.obfuscated_res_0x7f092494);
        this.E = radiusProgressView;
        radiusProgressView.setOnClickListener(this);
        j(g(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.v06
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0703 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.v06
    public void j(TbPageContext<?> tbPageContext, int i) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.B.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080840), 24, false);
            if (i != 1 && i != 4) {
                this.B.setAlpha(1.0f);
            } else {
                this.B.setAlpha(0.3f);
            }
            uu4 d = uu4.d(this.l);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            uu4.d(this.q).f(R.color.CAM_X0401);
            uu4.d(this.t).v(R.color.CAM_X0105);
            uu4.d(this.u).v(R.color.CAM_X0118);
            uu4.d(this.v).v(R.color.CAM_X0105);
            uu4.d(this.w).v(R.color.CAM_X0107);
            uu4.d(this.x).v(R.color.CAM_X0105);
            uu4.d(this.y).v(R.color.CAM_X0107);
            uu4.d(this.z).v(R.color.CAM_X0107);
            if (this.F.c() != null) {
                long b2 = this.F.c().b();
                long c = this.F.c().c();
                long j = c - b2;
                SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1503), Long.valueOf(b2), Long.valueOf(c)));
                spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
                this.y.setText(spannableString2);
                if (this.F.c().a() == 10) {
                    spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1502));
                } else {
                    spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1504), Long.valueOf(j)));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 9, String.valueOf(j).length() + 9, 18);
                }
                this.z.setText(spannableString);
                if (b2 <= 0) {
                    this.E.setProgress(0);
                } else if (b2 < c) {
                    this.E.setProgress((int) ((b2 * 100) / c));
                } else {
                    this.E.setProgress(100);
                }
            }
            uu4.d(this.A).v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0118, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f092493) {
                UrlManager.getInstance().dealOneLink(this.i, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                c68.a("2");
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092296 || view2.getId() == R.id.obfuscated_res_0x7f091531 || view2.getId() == R.id.obfuscated_res_0x7f092494 || view2.getId() == R.id.obfuscated_res_0x7f0903e1) {
                UrlManager.getInstance().dealOneLink(this.i, new String[]{TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL});
                c68.a("1");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v06
    /* renamed from: s */
    public void i(e58 e58Var) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e58Var) == null) || e58Var == null || e58Var.c() == null) {
            return;
        }
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
        this.F = e58Var;
        this.v.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1501), Integer.valueOf(e58Var.c().a())));
        this.x.setText(String.valueOf((int) e58Var.c().e()));
        long b2 = e58Var.c().b();
        long c = e58Var.c().c();
        long j = c - b2;
        SpannableString spannableString2 = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1503), Long.valueOf(b2), Long.valueOf(c)));
        spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 4, String.valueOf(b2).length() + 4, 18);
        this.y.setText(spannableString2);
        if (this.F.c().a() == 10) {
            spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1502));
        } else {
            spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1504), Long.valueOf(j)));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 9, String.valueOf(j).length() + 9, 18);
        }
        this.z.setText(spannableString);
        if (b2 <= 0) {
            this.E.setProgress(0);
        } else if (b2 < c) {
            this.E.setProgress((int) ((b2 * 100) / c));
        } else {
            this.E.setProgress(100);
        }
        this.D.e(e58Var.c().d());
        j(g(), TbadkCoreApplication.getInst().getSkinType());
        if (e58Var != null) {
            c68.b();
        }
    }
}
