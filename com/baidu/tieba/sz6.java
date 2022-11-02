package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.ko8;
import com.baidu.tieba.qz6;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class sz6 extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qz6 d;
    public boolean e;
    public LikeModel f;
    public ko8 g;
    public b h;
    public jz4 i;
    public jz4 j;
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
    public final int[] u;
    public final int[] v;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends q9 implements ko8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qz6.a a;
        public FollowUserButton b;
        public final /* synthetic */ sz6 c;

        public b(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sz6Var;
        }

        public /* synthetic */ b(sz6 sz6Var, a aVar) {
            this(sz6Var);
        }

        @Override // com.baidu.tieba.ko8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.c.e = false;
            }
        }

        @Override // com.baidu.tieba.ko8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.c.e = false;
                this.c.o(this.b, false);
                this.a.n(false);
            }
        }

        public void d(FollowUserButton followUserButton, qz6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.a = aVar;
                this.b = followUserButton;
            }
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.c.e = false;
                if (this.c.f.getErrorCode() == 22) {
                    xi.P(this.c.k.getPageActivity(), this.c.k.getString(R.string.obfuscated_res_0x7f0f084e));
                } else if (obj == null) {
                } else {
                    if (this.c.f.getErrorCode() != 0) {
                        xi.P(this.c.k.getPageActivity(), this.c.f.getErrorString());
                        return;
                    }
                    this.c.o(this.b, true);
                    this.a.n(true);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz6(View view2, TbPageContext<?> tbPageContext, byte b2) {
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
        this.i = new jz4();
        this.j = new jz4();
        this.n = new BarImageView[3];
        this.o = new TextView[3];
        this.p = new TextView[3];
        this.q = new TextView[3];
        this.r = new TextView[3];
        this.s = new TextView[3];
        this.t = new FollowUserButton[3];
        this.u = new int[]{R.id.obfuscated_res_0x7f091bca, R.id.obfuscated_res_0x7f091bcb, R.id.obfuscated_res_0x7f091bcc};
        this.v = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.k = tbPageContext;
        this.l = b2;
        k(view2);
    }

    public void m(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
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
    public void c(wn wnVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, wnVar) != null) || !(wnVar instanceof qz6)) {
            return;
        }
        qz6 qz6Var = (qz6) wnVar;
        this.d = qz6Var;
        this.m.setText(qz6Var.a);
        for (int i3 = 0; i3 < 3; i3++) {
            this.n[i3].K(this.d.d[i3].b(), 10, false);
            this.p[i3].setText(this.d.d[i3].c());
            this.s[i3].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe3, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.d[i3].f())}));
            this.r[i3].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe1, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.d[i3].a())}));
            this.t[i3].setTag(Integer.valueOf(i3));
            o(this.t[i3], this.d.d[i3].l());
            TextView textView = this.o[i3];
            if (this.d.b) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p[i3].getLayoutParams();
            Activity pageActivity = this.k.getPageActivity();
            if (this.d.b) {
                i2 = R.dimen.tbds15;
            } else {
                i2 = R.dimen.tbds0;
            }
            layoutParams.leftMargin = xi.g(pageActivity, i2);
            if (!StringUtils.isNull(this.d.d[i3].k())) {
                this.q[i3].setText(this.d.d[i3].k());
            } else if (!StringUtils.isNull(this.d.d[i3].h()) && UbsABTestHelper.isRecommendBarHotText()) {
                this.q[i3].setText(this.d.d[i3].h());
            } else {
                this.q[i3].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe2));
            }
        }
    }

    public final void h(qz6.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!xi.F()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0c7f));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
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
            if (wi.isForumName(aVar.c())) {
                this.e = true;
                this.f.M();
                this.f.Q(aVar.c(), String.valueOf(aVar.g()));
            }
        }
    }

    public final void i(qz6.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!xi.F()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0c7f));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.g == null) {
                ko8 ko8Var = new ko8();
                this.g = ko8Var;
                ko8Var.b(this.h);
            }
            this.h.d(followUserButton, aVar);
            this.e = true;
            this.g.c(aVar.c(), aVar.g());
        }
    }

    public qz6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (qz6) invokeV.objValue;
    }

    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bcd);
            this.i.t(R.color.CAM_X0109);
            this.i.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.r(R.color.CAM_X0304);
            this.j.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i = 0;
            while (i < 3) {
                View findViewById = view2.findViewById(this.u[i]);
                findViewById.setTag(Integer.valueOf(i));
                findViewById.setOnClickListener(this);
                this.n[i] = (BarImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f091bc9);
                this.o[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091bd3);
                this.p[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091bcf);
                this.q[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091bc8);
                this.r[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091bc6);
                this.s[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091bd1);
                this.t[i] = (FollowUserButton) findViewById.findViewById(R.id.obfuscated_res_0x7f091bc5);
                this.t[i].setOnClickListener(this);
                int i2 = i + 1;
                this.o[i].setText(String.valueOf(i2));
                this.n[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.n[i].setShowInnerBorder(true);
                this.n[i].setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.n[i].setShowOval(true);
                this.n[i].setPlaceHolder(2);
                this.n[i].setShowOuterBorder(false);
                this.n[i].setStrokeColorResId(R.color.CAM_X0401);
                i = i2;
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view2) == null) && this.d != null && view2 != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            qz6.a aVar = this.d.d[intValue];
            if (view2 instanceof TBSpecificationBtn) {
                if (aVar.l()) {
                    i(aVar, this.t[intValue]);
                    return;
                }
                h(aVar, this.t[intValue]);
                StatisticItem param = new StatisticItem("c13644").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
                if (!StringUtils.isNull(this.d.a)) {
                    param = param.param("obj_name", this.d.a);
                }
                TiebaStatic.log(param);
            } else if (id == R.id.obfuscated_res_0x7f091bca || id == R.id.obfuscated_res_0x7f091bcb || id == R.id.obfuscated_res_0x7f091bcc) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageActivity()).createNormalCfg(aVar.c(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (UbsABTestHelper.isRecommendBarHotText()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.j() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.j());
                    }
                }
                this.k.sendMessage(new CustomMessage(2003000, callFrom));
                StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
                if (!StringUtils.isNull(this.d.a)) {
                    param2 = param2.param("obj_name", this.d.a);
                }
                TiebaStatic.log(param2);
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.o[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.o[i2], (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.v[i2]).cornerRadius(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.o[i2]);
            }
            this.t[i2].r(i);
            SkinManager.setViewTextColor(this.p[i2], (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s[i2], (int) R.color.CAM_X0109);
        }
    }

    public void n(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        if (z) {
            o(this.t[i], true);
            this.d.d[i].n(true);
            return;
        }
        o(this.t[i], false);
        this.d.d[i].n(false);
    }

    public final void o(FollowUserButton followUserButton, boolean z) {
        jz4 jz4Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, followUserButton, z) != null) || followUserButton == null) {
            return;
        }
        if (z) {
            jz4Var = this.i;
        } else {
            jz4Var = this.j;
        }
        followUserButton.setConfig(jz4Var);
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        if (z) {
            i = R.string.obfuscated_res_0x7f0f0665;
        } else {
            i = R.string.obfuscated_res_0x7f0f02b1;
        }
        followUserButton.setText(inst.getString(i));
        followUserButton.r(TbadkCoreApplication.getInst().getSkinType());
    }
}
