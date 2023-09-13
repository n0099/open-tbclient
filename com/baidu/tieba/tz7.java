package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.rz7;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tz7 extends BdBaseView<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyGiftListActivity a;
    public NavigationBar b;
    public NoNetworkView c;
    public wn5 d;
    public BdListView e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public aa5 k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public sz7 s;
    public boolean t;
    public LinearLayout u;
    public View v;
    public TextView w;
    public ImageView x;
    public AdapterView.OnItemClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;

        public a(tz7 tz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F();
                this.a.N();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;

        public b(tz7 tz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            rz7.a item;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (item = this.a.s.getItem(i)) != null && item.a > 0 && !StringUtils.isNull(item.b)) {
                if (this.a.t) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.a.a.getPageContext().getPageActivity(), item.a, item.b, item.i, GiftTabActivityConfig.FROM_PERSON_CENTER)));
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.a), item.b)));
                } else {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;

        public c(tz7 tz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2 == this.a.o) {
                if (!BdUtilHelper.isNetOk()) {
                    UtilHelper.showToast(this.a.a.getPageContext().getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e40));
                } else {
                    CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tz7(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, pVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.y = new b(this);
        this.z = new c(this);
        this.a = myGiftListActivity;
        this.t = z;
        this.l = pVar;
        H();
        G();
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void L(z95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.k.a(gVar);
        }
    }

    public void z(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.c.addNetworkChangeListener(bVar);
        }
    }

    public final SpannableString C(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i);
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070201);
            boolean z = false;
            if (i2 == 2) {
                drawable.setBounds(0, 3, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701f0));
            } else {
                drawable.setBounds(0, 0, dimens, dimens);
            }
            if (TbadkApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            if (z) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            VCenterTextSpan vCenterTextSpan = new VCenterTextSpan(drawable);
            vCenterTextSpan.setPaddingRight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07035d));
            UtilHelper.setSpan(spannableString, str2, "[icon]", vCenterTextSpan);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07045c));
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.z(0L);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public void F() {
        wn5 wn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (wn5Var = this.d) != null) {
            wn5Var.dettachView(this.f);
            this.d = null;
            this.e.setVisibility(0);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.setVisibility(0);
            this.e.E();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.u = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090e48);
            this.w = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090e49);
            this.u.setOnClickListener(this.a.x1());
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f090e4b);
            this.x = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090e4a);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0680);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091fd6);
            this.f = findViewById;
            this.e = (BdListView) findViewById.findViewById(R.id.obfuscated_res_0x7f091561);
            NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.navigation_bar);
            this.b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.a;
            if (myGiftListActivity.j == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f07a3));
            } else {
                String format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f09bb), myGiftListActivity.y1());
                if (this.t) {
                    this.b.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d30));
                } else {
                    this.b.setTitleText(format);
                }
            }
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f0919a2);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0684, (ViewGroup) null, false);
            this.h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0682, (ViewGroup) null, false);
            this.g = inflate2;
            inflate2.setVisibility(8);
            this.r = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0929b4);
            this.m = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09251e);
            this.n = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092524);
            this.p = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092525);
            this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0929af);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09251d);
            this.o.setOnClickListener(this.z);
            View inflate3 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0681, (ViewGroup) null, false);
            this.i = inflate3;
            this.j = inflate3.findViewById(R.id.obfuscated_res_0x7f090e3b);
            if (this.t) {
                this.e.addHeaderView(this.g);
            } else {
                if (this.a.j == 1) {
                    this.h.setVisibility(0);
                    this.e.addHeaderView(this.h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.i.setPadding(0, 0, 0, BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07037c));
                }
            }
            this.e.addFooterView(this.i);
            sz7 sz7Var = new sz7(this.a, this.t);
            this.s = sz7Var;
            this.e.setAdapter((ListAdapter) sz7Var);
            aa5 aa5Var = new aa5(this.a.getPageContext());
            this.k = aa5Var;
            this.e.setPullRefresh(aa5Var);
            this.e.setOnSrollToBottomListener(this.l);
            this.e.setOnItemClickListener(this.y);
        }
    }

    public final void I(rz7 rz7Var) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rz7Var) == null) {
            if (rz7Var != null && this.t) {
                this.g.setVisibility(0);
                String str = rz7Var.d().b;
                String str2 = rz7Var.d().a;
                String str3 = rz7Var.g.b;
                this.m.setText(C(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(rz7Var.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(rz7Var.h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(rz7Var.h, rz7Var.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(rz7Var.e());
                }
                this.n.setText(C(CurrencySwitchUtil.getGiftMoneyIconResId(rz7Var.h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(rz7Var.h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void J(rz7 rz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rz7Var) == null) {
            if (rz7Var != null && rz7Var.a() != null && rz7Var.a().size() > 0) {
                if (rz7Var.c() != null) {
                    if (rz7Var.c().b == 1) {
                        this.i.setVisibility(0);
                    } else {
                        this.i.setVisibility(8);
                    }
                }
                this.s.e(rz7Var.a(), rz7Var.h);
                return;
            }
            this.i.setVisibility(8);
            this.u.setVisibility(8);
            this.s.e(null, -1);
        }
    }

    public void K(rz7 rz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rz7Var) == null) {
            if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            if (rz7Var != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = rz7Var.e();
            }
            F();
            I(rz7Var);
            J(rz7Var);
        }
    }

    public void M(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            if (this.d == null) {
                this.d = new wn5(this.mContext.getContext(), new a(this));
            }
            this.d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b4));
            this.d.attachView(this.f, z);
            this.d.o();
            this.u.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.f);
            this.a.getLayoutMode().onModeChanged(this.g);
            this.a.getLayoutMode().onModeChanged(this.h);
            this.a.getLayoutMode().onModeChanged(this.i);
            this.b.onChangeSkinType(getPageContext(), i);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.k.C(i);
            sz7 sz7Var = this.s;
            if (sz7Var != null) {
                sz7Var.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0302);
            SkinManager.setImageResource(this.x, R.drawable.icon_gift_list);
            EMManager.from(this.p).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.q).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.n).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.g).setAlpha(R.string.A_X02).setBackGroundColor(R.color.CAM_X0310);
        }
    }
}
