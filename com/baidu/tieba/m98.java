package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.era;
import com.baidu.tieba.j98;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m98 extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j98 d;
    public boolean e;
    public LikeModel f;
    public era g;
    public b h;
    public u55 i;
    public u55 j;
    public TbPageContext<?> k;
    public byte l;
    public TextView m;
    public LinearLayout[] n;
    public BarImageView[] o;
    public TextView[] p;
    public TextView[] q;
    public TextView[] r;
    public TextView[] s;
    public TextView[] t;
    public FollowUserButton[] u;
    public View[] v;
    public final int[] w;
    public final int[] x;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends w4 implements era.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public j98.a a;
        public FollowUserButton b;
        public final /* synthetic */ m98 c;

        public b(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m98Var;
        }

        public /* synthetic */ b(m98 m98Var, a aVar) {
            this(m98Var);
        }

        @Override // com.baidu.tieba.era.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.c.e = false;
            }
        }

        @Override // com.baidu.tieba.era.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.c.e = false;
                this.c.u(this.b, false);
                this.a.i(false);
                this.c.r(false, this.a.e());
            }
        }

        public void d(FollowUserButton followUserButton, j98.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.a = aVar;
                this.b = followUserButton;
            }
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.c.e = false;
                if (this.c.f.getErrorCode() == 22) {
                    BdUtilHelper.showToast(this.c.k.getPageActivity(), this.c.k.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.c.f.getErrorCode() != 0) {
                        BdUtilHelper.showToast(this.c.k.getPageActivity(), this.c.f.getErrorString());
                        return;
                    }
                    this.c.u(this.b, true);
                    this.a.i(true);
                    this.c.r(true, this.a.e());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m98(View view2, TbPageContext<?> tbPageContext, byte b2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.i = new u55();
        this.j = new u55();
        this.n = new LinearLayout[3];
        this.o = new BarImageView[3];
        this.p = new TextView[3];
        this.q = new TextView[3];
        this.r = new TextView[3];
        this.s = new TextView[3];
        this.t = new TextView[3];
        this.u = new FollowUserButton[3];
        this.v = new View[3];
        this.w = new int[]{R.id.obfuscated_res_0x7f091ed1, R.id.obfuscated_res_0x7f091ed2, R.id.obfuscated_res_0x7f091ed3};
        this.x = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.k = tbPageContext;
        this.l = b2;
        o(view2);
    }

    public void s(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            TextView textView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void c(oi oiVar) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, oiVar) != null) || !(oiVar instanceof j98)) {
            return;
        }
        j98 j98Var = (j98) oiVar;
        this.d = j98Var;
        this.m.setText(j98Var.a);
        j98.a[] aVarArr = this.d.g;
        if (aVarArr != null && aVarArr.length != 0) {
            int min = Math.min(3, aVarArr.length);
            for (int i4 = 0; i4 < min; i4++) {
                if (this.d.g[i4] != null) {
                    View[] viewArr = this.v;
                    if (viewArr[i4] != null && this.n[i4] != null && this.t[i4] != null && this.o[i4] != null && this.q[i4] != null && this.p[i4] != null && this.r[i4] != null && this.u[i4] != null && this.s[i4] != null) {
                        viewArr[i4].setVisibility(0);
                        this.n[i4].setTag(Integer.valueOf(i4));
                        TextView textView = this.t[i4];
                        int i5 = 8;
                        if (this.d.d()) {
                            i = 8;
                        } else {
                            i = 0;
                        }
                        textView.setVisibility(i);
                        TextView textView2 = this.s[i4];
                        if (this.d.d()) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        textView2.setVisibility(i2);
                        this.o[i4].startLoad(this.d.g[i4].b(), 10, false);
                        this.o[i4].setTag(Integer.valueOf(i4));
                        this.q[i4].setText(this.d.g[i4].c());
                        this.t[i4].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1225, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.g[i4].d())}));
                        this.s[i4].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1223, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.g[i4].a())}));
                        this.u[i4].setTag(Integer.valueOf(i4));
                        u(this.u[i4], this.d.g[i4].g());
                        TextView textView3 = this.p[i4];
                        if (this.d.b) {
                            i5 = 0;
                        }
                        textView3.setVisibility(i5);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q[i4].getLayoutParams();
                        Activity pageActivity = this.k.getPageActivity();
                        if (this.d.b) {
                            i3 = R.dimen.tbds15;
                        } else {
                            i3 = R.dimen.tbds0;
                        }
                        layoutParams.leftMargin = BdUtilHelper.getDimens(pageActivity, i3);
                        if (!StringUtils.isNull(this.d.g[i4].f())) {
                            this.r[i4].setText(this.d.g[i4].f());
                        } else {
                            this.r[i4].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1224));
                        }
                    }
                }
            }
        }
    }

    public final void i(@NonNull j98.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) || this.d == null) {
            return;
        }
        String c = aVar.c();
        if (aVar.h() && !TextUtils.isEmpty(c) && c.length() > 1 && c.endsWith("吧")) {
            aVar.o(c.substring(0, c.length() - 1));
        }
        FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageActivity()).createNormalCfg(aVar.c(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
        if (this.d.c()) {
            callFrom.setCallFrom(11);
        }
        this.k.sendMessage(new CustomMessage(2003000, callFrom));
        StatisticItem param = new StatisticItem("c13988").param("fid", aVar.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
        if (!StringUtils.isNull(this.d.a)) {
            param = param.param("obj_name", this.d.a);
        }
        TiebaStatic.log(param);
    }

    public final void k(j98.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!BdUtilHelper.isNetOk()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0e61));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.e() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.f == null) {
                LikeModel likeModel = new LikeModel(this.k);
                this.f = likeModel;
                likeModel.setLoadDataCallBack(this.h);
            }
            this.h.d(followUserButton, aVar);
            if (qd.isForumName(aVar.c())) {
                this.e = true;
                this.f.c0();
                this.f.g0(aVar.c(), String.valueOf(aVar.e()));
            }
        }
    }

    public final void l(j98.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!BdUtilHelper.isNetOk()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0e61));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.e() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.g == null) {
                era eraVar = new era();
                this.g = eraVar;
                eraVar.b(this.h);
            }
            this.h.d(followUserButton, aVar);
            this.e = true;
            this.g.c(aVar.c(), aVar.e());
        }
    }

    public void t(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        if (z) {
            u(this.u[i], true);
            this.d.g[i].i(true);
            r(true, this.d.g[i].e());
            return;
        }
        u(this.u[i], false);
        this.d.g[i].i(false);
        r(false, this.d.g[i].e());
    }

    public j98 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (j98) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            j98 j98Var = this.d;
            if (j98Var != null && j98Var.f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, str, i) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_HOMEPAGE_REC_FORUM_CARD_CLICK);
        statisticItem.addParam("fid", str);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.addParam("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public final void q(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048585, this, str, i) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c15343");
        statisticItem.addParam("fid", str);
        statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.addParam("obj_locate", i);
        TiebaStatic.log(statisticItem);
    }

    public final void r(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            em6 em6Var = new em6();
            em6Var.d(z);
            em6Var.c(j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921806, em6Var));
        }
    }

    public final void o(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ed4);
            this.i.v(R.color.CAM_X0109);
            this.i.j(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.u(R.color.CAM_X0304);
            this.j.j(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.g(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i = 0;
            while (i < 3) {
                View findViewById = view2.findViewById(this.w[i]);
                findViewById.setVisibility(8);
                findViewById.setTag(Integer.valueOf(i));
                findViewById.setOnClickListener(this);
                this.v[i] = findViewById;
                this.n[i] = (LinearLayout) findViewById.findViewById(R.id.obfuscated_res_0x7f091ecb);
                this.n[i].setOnClickListener(this);
                this.o[i] = (BarImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f091ed0);
                this.o[i].setOnClickListener(this);
                this.p[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091eda);
                this.q[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091ed6);
                this.r[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091ecf);
                this.s[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091ecd);
                this.t[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091ed8);
                this.u[i] = (FollowUserButton) findViewById.findViewById(R.id.obfuscated_res_0x7f091ecc);
                this.u[i].setOnClickListener(this);
                int i2 = i + 1;
                this.p[i].setText(String.valueOf(i2));
                this.o[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.o[i].setShowInnerBorder(true);
                this.o[i].setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.o[i].setShowOval(true);
                this.o[i].setPlaceHolder(2);
                this.o[i].setShowOuterBorder(false);
                this.o[i].setStrokeColorResId(R.color.CAM_X0401);
                i = i2;
            }
            p(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && this.d != null && view2 != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            j98.a aVar = this.d.g[intValue];
            if (aVar == null) {
                return;
            }
            if (view2 instanceof TBSpecificationBtn) {
                if (aVar.g()) {
                    if (x()) {
                        i(aVar);
                        n(String.valueOf(aVar.e()), 6);
                    } else {
                        l(aVar, this.u[intValue]);
                    }
                } else {
                    k(aVar, this.u[intValue]);
                    if (x()) {
                        n(String.valueOf(aVar.e()), 5);
                    } else {
                        StatisticItem param = new StatisticItem("c13644").param("fid", aVar.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
                        if (!StringUtils.isNull(this.d.a)) {
                            param = param.param("obj_name", this.d.a);
                        }
                        TiebaStatic.log(param);
                    }
                }
                q(String.valueOf(aVar.e()), 3);
            } else if (id == R.id.obfuscated_res_0x7f091ecb || id == R.id.obfuscated_res_0x7f091ed0) {
                i(aVar);
                n(String.valueOf(aVar.e()), 4);
                if (id == R.id.obfuscated_res_0x7f091ed0) {
                    q(String.valueOf(aVar.e()), 1);
                } else if (id == R.id.obfuscated_res_0x7f091ecb) {
                    q(String.valueOf(aVar.e()), 2);
                }
            }
            SharedPrefHelper.getInstance().putInt("key_home_show_card_not_click", 0);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.p[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.p[i2], (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.x[i2]).cornerRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.p[i2]);
            }
            this.u[i2].onChangeSkinType(i);
            SkinManager.setViewTextColor(this.q[i2], (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t[i2], (int) R.color.CAM_X0109);
        }
    }

    public final void u(FollowUserButton followUserButton, boolean z) {
        u55 u55Var;
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048589, this, followUserButton, z) != null) || followUserButton == null) {
            return;
        }
        boolean x = x();
        int i = R.string.obfuscated_res_0x7f0f02ec;
        if (x) {
            u55Var = this.j;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (z) {
                i = R.string.enter_forum;
            }
            string = inst.getString(i);
        } else {
            if (z) {
                u55Var = this.i;
            } else {
                u55Var = this.j;
            }
            TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
            if (z) {
                i = R.string.obfuscated_res_0x7f0f0772;
            }
            string = inst2.getString(i);
        }
        followUserButton.setConfig(u55Var);
        followUserButton.setText(string);
        followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
