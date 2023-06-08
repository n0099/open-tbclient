package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
import com.baidu.tieba.gw7;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iw7 extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gw7 d;
    public boolean e;
    public LikeModel f;
    public tx9 g;
    public b h;
    public la5 i;
    public la5 j;
    public TbPageContext<?> k;
    public byte l;
    public TextView m;
    public BarImageView[] n;
    public TextView[] o;
    public TextView[] p;
    public TextView[] q;
    public TextView[] r;
    public TextView[] s;
    public FollowUserButton[] t;
    public View[] u;
    public final int[] v;
    public final int[] w;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends j9 implements tx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gw7.a a;
        public FollowUserButton b;
        public final /* synthetic */ iw7 c;

        public b(iw7 iw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iw7Var;
        }

        public /* synthetic */ b(iw7 iw7Var, a aVar) {
            this(iw7Var);
        }

        @Override // com.baidu.tieba.tx9.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.c.e = false;
            }
        }

        @Override // com.baidu.tieba.tx9.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.c.e = false;
                this.c.s(this.b, false);
                this.a.m(false);
                this.c.p(false, this.a.e());
            }
        }

        public void d(FollowUserButton followUserButton, gw7.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.a = aVar;
                this.b = followUserButton;
            }
        }

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.c.e = false;
                if (this.c.f.getErrorCode() == 22) {
                    vi.Q(this.c.k.getPageActivity(), this.c.k.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.c.f.getErrorCode() != 0) {
                        vi.Q(this.c.k.getPageActivity(), this.c.f.getErrorString());
                        return;
                    }
                    this.c.s(this.b, true);
                    this.a.m(true);
                    this.c.p(true, this.a.e());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iw7(View view2, TbPageContext<?> tbPageContext, byte b2) {
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
        this.i = new la5();
        this.j = new la5();
        this.n = new BarImageView[3];
        this.o = new TextView[3];
        this.p = new TextView[3];
        this.q = new TextView[3];
        this.r = new TextView[3];
        this.s = new TextView[3];
        this.t = new FollowUserButton[3];
        this.u = new View[3];
        this.v = new int[]{R.id.obfuscated_res_0x7f091dae, R.id.obfuscated_res_0x7f091daf, R.id.obfuscated_res_0x7f091db0};
        this.w = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.k = tbPageContext;
        this.l = b2;
        n(view2);
    }

    public void q(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
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
    public void c(vn vnVar) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, vnVar) != null) || !(vnVar instanceof gw7)) {
            return;
        }
        gw7 gw7Var = (gw7) vnVar;
        this.d = gw7Var;
        this.m.setText(gw7Var.a);
        gw7.a[] aVarArr = this.d.g;
        if (aVarArr != null && aVarArr.length != 0) {
            int min = Math.min(3, aVarArr.length);
            for (int i4 = 0; i4 < min; i4++) {
                if (this.d.g[i4] != null) {
                    View[] viewArr = this.u;
                    if (viewArr[i4] != null && this.s[i4] != null && this.n[i4] != null && this.p[i4] != null && this.o[i4] != null && this.q[i4] != null && this.t[i4] != null && this.r[i4] != null) {
                        viewArr[i4].setVisibility(0);
                        TextView textView = this.s[i4];
                        int i5 = 8;
                        if (this.d.d()) {
                            i = 8;
                        } else {
                            i = 0;
                        }
                        textView.setVisibility(i);
                        TextView textView2 = this.r[i4];
                        if (this.d.d()) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        textView2.setVisibility(i2);
                        this.n[i4].N(this.d.g[i4].b(), 10, false);
                        this.p[i4].setText(this.d.g[i4].c());
                        this.s[i4].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11a6, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.g[i4].d())}));
                        this.r[i4].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11a4, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.g[i4].a())}));
                        this.t[i4].setTag(Integer.valueOf(i4));
                        s(this.t[i4], this.d.g[i4].k());
                        TextView textView3 = this.o[i4];
                        if (this.d.b) {
                            i5 = 0;
                        }
                        textView3.setVisibility(i5);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p[i4].getLayoutParams();
                        Activity pageActivity = this.k.getPageActivity();
                        if (this.d.b) {
                            i3 = R.dimen.tbds15;
                        } else {
                            i3 = R.dimen.tbds0;
                        }
                        layoutParams.leftMargin = vi.g(pageActivity, i3);
                        if (!StringUtils.isNull(this.d.g[i4].i())) {
                            this.q[i4].setText(this.d.g[i4].i());
                        } else if (!StringUtils.isNull(this.d.g[i4].f()) && UbsABTestHelper.isRecommendBarHotText()) {
                            this.q[i4].setText(this.d.g[i4].f());
                        } else {
                            this.q[i4].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11a5));
                        }
                    }
                }
            }
        }
    }

    public final void i(@NonNull gw7.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) || this.d == null) {
            return;
        }
        String c = aVar.c();
        if (aVar.l() && !TextUtils.isEmpty(c) && c.length() > 1 && c.endsWith("吧")) {
            aVar.p(c.substring(0, c.length() - 1));
        }
        FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageActivity()).createNormalCfg(aVar.c(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
        if (this.d.c()) {
            callFrom.setCallFrom(11);
        }
        if (UbsABTestHelper.isRecommendBarHotText()) {
            Intent intent = callFrom.getIntent();
            if (aVar.h() != 0 && intent != null) {
                intent.putExtra("transition_type", 0);
                intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.h());
            }
        }
        this.k.sendMessage(new CustomMessage(2003000, callFrom));
        StatisticItem param = new StatisticItem("c13988").param("fid", aVar.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
        if (!StringUtils.isNull(this.d.a)) {
            param = param.param("obj_name", this.d.a);
        }
        TiebaStatic.log(param);
    }

    public final void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091db1);
            this.i.v(R.color.CAM_X0109);
            this.i.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.t(R.color.CAM_X0304);
            this.j.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i = 0;
            while (i < 3) {
                View findViewById = view2.findViewById(this.v[i]);
                findViewById.setVisibility(8);
                findViewById.setTag(Integer.valueOf(i));
                findViewById.setOnClickListener(this);
                this.u[i] = findViewById;
                this.n[i] = (BarImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f091dad);
                this.o[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091db7);
                this.p[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091db3);
                this.q[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091dac);
                this.r[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091daa);
                this.s[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091db5);
                this.t[i] = (FollowUserButton) findViewById.findViewById(R.id.obfuscated_res_0x7f091da9);
                this.t[i].setOnClickListener(this);
                int i2 = i + 1;
                this.o[i].setText(String.valueOf(i2));
                this.n[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.n[i].setShowInnerBorder(true);
                this.n[i].setStrokeWith(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.n[i].setShowOval(true);
                this.n[i].setPlaceHolder(2);
                this.n[i].setShowOuterBorder(false);
                this.n[i].setStrokeColorResId(R.color.CAM_X0401);
                i = i2;
            }
            o(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && this.d != null && view2 != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            gw7.a aVar = this.d.g[intValue];
            if (aVar == null) {
                return;
            }
            if (view2 instanceof TBSpecificationBtn) {
                if (aVar.k()) {
                    if (t()) {
                        i(aVar);
                        m(String.valueOf(aVar.e()), 6);
                        return;
                    }
                    k(aVar, this.t[intValue]);
                    return;
                }
                j(aVar, this.t[intValue]);
                if (t()) {
                    m(String.valueOf(aVar.e()), 5);
                    return;
                }
                StatisticItem param = new StatisticItem("c13644").param("fid", aVar.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
                if (!StringUtils.isNull(this.d.a)) {
                    param = param.param("obj_name", this.d.a);
                }
                TiebaStatic.log(param);
            } else if (id == R.id.obfuscated_res_0x7f091dae || id == R.id.obfuscated_res_0x7f091daf || id == R.id.obfuscated_res_0x7f091db0) {
                i(aVar);
                m(String.valueOf(aVar.e()), 4);
            }
        }
    }

    public final void j(gw7.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!vi.F()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0def));
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
            if (ui.isForumName(aVar.c())) {
                this.e = true;
                this.f.i0();
                this.f.m0(aVar.c(), String.valueOf(aVar.e()));
            }
        }
    }

    public final void k(gw7.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!vi.F()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0def));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.e() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.g == null) {
                tx9 tx9Var = new tx9();
                this.g = tx9Var;
                tx9Var.b(this.h);
            }
            this.h.d(followUserButton, aVar);
            this.e = true;
            this.g.c(aVar.c(), aVar.e());
        }
    }

    public void r(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        if (z) {
            s(this.t[i], true);
            this.d.g[i].m(true);
            p(true, this.d.g[i].e());
            return;
        }
        s(this.t[i], false);
        this.d.g[i].m(false);
        p(false, this.d.g[i].e());
    }

    public gw7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (gw7) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            gw7 gw7Var = this.d;
            if (gw7Var != null && gw7Var.f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m(String str, int i) {
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

    public final void p(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            no6 no6Var = new no6();
            no6Var.d(z);
            no6Var.c(j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921806, no6Var));
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.o[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.o[i2], (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.w[i2]).cornerRadius(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.o[i2]);
            }
            this.t[i2].onChangeSkinType(i);
            SkinManager.setViewTextColor(this.p[i2], (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s[i2], (int) R.color.CAM_X0109);
        }
    }

    public final void s(FollowUserButton followUserButton, boolean z) {
        la5 la5Var;
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048588, this, followUserButton, z) != null) || followUserButton == null) {
            return;
        }
        boolean t = t();
        int i = R.string.obfuscated_res_0x7f0f02e5;
        if (t) {
            la5Var = this.j;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (z) {
                i = R.string.enter_forum;
            }
            string = inst.getString(i);
        } else {
            if (z) {
                la5Var = this.i;
            } else {
                la5Var = this.j;
            }
            TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
            if (z) {
                i = R.string.obfuscated_res_0x7f0f0751;
            }
            string = inst2.getString(i);
        }
        followUserButton.setConfig(la5Var);
        followUserButton.setText(string);
        followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
