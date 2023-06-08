package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.as5;
import com.baidu.tieba.bd5;
import com.baidu.tieba.c55;
import com.baidu.tieba.cs5;
import com.baidu.tieba.ds5;
import com.baidu.tieba.l56;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResult;
import com.baidu.tieba.n95;
import com.baidu.tieba.o75;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.vr5;
import com.baidu.tieba.xv8;
import com.baidu.tieba.zr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MemberPayFragmentActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public VipAdFreeGuideLayout B;
    public String C;
    public String D;
    public TbImageView E;
    public View F;
    public View G;
    public TbImageView H;
    public BdToastData I;
    public final StatisticItem J;
    public HttpMessageListener K;
    public HttpMessageListener L;
    public final CustomMessageListener M;
    public int a;
    public String b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public RoundRelativeLayout j;
    public RelativeLayout k;
    public View l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public LinearLayout p;
    public IndicatorView q;
    public FragmentTabHost r;
    public MemberPayListAdapter s;
    public int t;
    public int u;
    public boolean v;
    public PayConfigModel w;
    public Boolean x;
    public String y;
    public int z;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.sr5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "b001" : (String) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MemberPayFragmentActivity memberPayFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i)};
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
            this.a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505 || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage)) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0) {
                ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                    int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                    this.a.I = responseGetPayinfoMessage.getPayInfoResultData().getToast();
                    if (pay_status == 0) {
                        this.a.J1();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(this.a.t)));
                        this.a.setResult(-1);
                        n95.m().w("show_member_deid_line", true);
                        if (!this.a.i) {
                            this.a.V1();
                            return;
                        } else {
                            this.a.finish();
                            return;
                        }
                    }
                    if (pay_status != 1 && pay_status == 3) {
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MemberPayFragmentActivity memberPayFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i)};
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
            this.a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                if (!(httpResponsedMessage instanceof ResponseMemberPayMessage) || httpResponsedMessage.getCmd() != 1001532) {
                    return;
                }
                ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (responseMemberPayMessage.getMemberPayResult() != null) {
                        MemberPayResult memberPayResult = responseMemberPayMessage.getMemberPayResult();
                        this.a.Q1(memberPayResult);
                        if (this.a.s != null) {
                            int count = this.a.s.getCount();
                            for (int i = 0; i < count; i++) {
                                this.a.s.getItem(i).I1(memberPayResult);
                            }
                        }
                        this.a.K1(TiebaStatic.Params.OBJ_PARAM6);
                        TiebaStatic.log(this.a.J);
                        return;
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
                    return;
                }
                String errorString = responseMemberPayMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                }
                this.a.showToast(errorString);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MemberPayFragmentActivity memberPayFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity, Integer.valueOf(i)};
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
            this.a = memberPayFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && this.a.s != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                int count = this.a.s.getCount();
                for (int i = 0; i < count; i++) {
                    this.a.s.getItem(i).H1(bool);
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f1656);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public d(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.X1();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public e(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.X1();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public f(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.X1();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements as5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public g(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // com.baidu.tieba.as5
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.V1();
        }

        @Override // com.baidu.tieba.as5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ds5 c = ds5.c();
                c.b(cs5.a + "?refer_page=" + this.a.g + "&click_zone=" + this.a.h, this.a.getPageContext());
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.as5
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.V1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public h(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayFragmentActivity a;

        public i(MemberPayFragmentActivity memberPayFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPayFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberPayFragmentActivity;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 0));
                c55Var.dismiss();
                if (this.a.l != null) {
                    this.a.l.setBackgroundColor(this.a.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
                }
                this.a.finish();
            }
        }
    }

    public MemberPayFragmentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 0;
        this.v = false;
        this.x = Boolean.FALSE;
        this.y = "c10482";
        this.J = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_source", TiebaStatic.DQPay.TYPE_VALUE);
        this.K = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.L = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);
        this.M = new c(this, 2016525);
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.c;
            if (i2 == 6) {
                TiebaStatic.log("consume_24");
            } else if (i2 == 2) {
                TiebaStatic.log(TbadkCoreStatisticKey.FRS_EXPERIENCE_SPEED);
            } else if (i2 == 4) {
                TiebaStatic.log("c10751");
            } else if (i2 == 5) {
                TiebaStatic.log("c10750");
            } else if (i2 == 26) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW).param("obj_source", 1));
            }
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.c;
            if (i2 == 2) {
                L1("consume_10");
            } else if (i2 == 1) {
                L1("consume_5");
            } else if (i2 == 3) {
                L1("consume_35");
            } else if (i2 == 4) {
                TiebaStatic.log("c10032");
            } else if (i2 == 5) {
                TiebaStatic.log("c10039");
            } else if (i2 == 6) {
                TiebaStatic.log(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS);
            } else if (i2 == 7) {
                TiebaStatic.log(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS);
            }
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q.setPosition(this.u);
            this.o.setText(N1(this.t));
            if (this.t == 2) {
                SkinManager.setImageResource(this.n, R.drawable.obfuscated_res_0x7f080ca0, TbadkCoreApplication.getInst().getSkinType());
            } else {
                SkinManager.setImageResource(this.n, R.drawable.icon_tbvip_commonvip, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void K1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.J.getIndex(str) < 0) {
            this.J.addParam(str, System.currentTimeMillis());
        }
    }

    public final void L1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click");
        }
    }

    public final String N1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 != 2) {
                return getResources().getString(R.string.obfuscated_res_0x7f0f15c6);
            }
            return getResources().getString(R.string.obfuscated_res_0x7f0f15c9);
        }
        return (String) invokeI.objValue;
    }

    public final void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 >= 2) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(4);
            }
            this.q.setCount(i2);
            W1();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.u = i2;
            MemberPayListAdapter memberPayListAdapter = this.s;
            if (memberPayListAdapter != null) {
                this.t = memberPayListAdapter.getItem(i2).getType();
            }
            W1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                X1();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.anim_alpha_0_to_1_duration_300, R.anim.anim_alpha_1_to_0_duration_300);
        }
    }

    public final void M1(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048580, this, fragment, i2, str) != null) || fragment == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        cVar.c = fragment;
        cVar.a = i2;
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setContentWidthWrapContent();
        cVar.b = fragmentTabIndicator;
        this.r.b(cVar);
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.a = getIntent().getExtras().getInt(MemberPayActivityConfig.MEMBER_TYPE);
                this.b = getIntent().getExtras().getString("st_type");
                this.c = getIntent().getExtras().getInt("from", 0);
                this.i = getIntent().getExtras().getBoolean("close");
                this.d = getIntent().getExtras().getInt(MemberPayActivityConfig.FROM_SCENE, 0);
                this.f = getIntent().getExtras().getString(MemberPayActivityConfig.DEFAULT_GOODS);
                this.e = getIntent().getExtras().getString(MemberPayActivityConfig.SCENE_ID);
                this.A = getIntent().getExtras().getBoolean(MemberPayActivityConfig.SHOW_VIP_TIP);
                this.C = getIntent().getExtras().getString("fid");
                this.D = getIntent().getExtras().getString(MemberPayActivityConfig.SHOW_PRICE);
                if (this.J.getIndex("obj_param1") < 0) {
                    this.J.addParam("obj_param1", getIntent().getExtras().getLong("start_time", 0L));
                }
            }
            int i2 = this.d;
            if (i2 == 3) {
                this.e = "4001001001";
            } else if (i2 == 4) {
                this.e = "4001001002";
            }
            if (StringUtils.isNull(this.e)) {
                this.e = "4008001000";
            }
            this.g = getIntent().getExtras().getString(MemberPayStatistic.REFER_PAGE);
            this.h = getIntent().getExtras().getString(MemberPayStatistic.CLICK_ZONE);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            K1(TiebaStatic.Params.OBJ_PARAM3);
            U1();
            PayConfigModel payConfigModel = new PayConfigModel(getPageContext(), new g(this));
            this.w = payConfigModel;
            payConfigModel.Z();
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            registerListener(this.L);
            registerListener(this.K);
            registerListener(this.M);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public vr5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            vr5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (vr5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            PayConfigModel payConfigModel = this.w;
            if (payConfigModel != null) {
                payConfigModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            K1(TiebaStatic.Params.OBJ_PARAM4);
            super.onResume();
            BdToastData bdToastData = this.I;
            if (bdToastData != null) {
                BdToastHelper.toast(bdToastData);
                this.I = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q1(MemberPayResult memberPayResult) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, memberPayResult) != null) || this.v) {
            return;
        }
        K1(TiebaStatic.Params.OBJ_PARAM5);
        this.v = true;
        if (memberPayResult.a.a.a != 2 && this.a != 2) {
            z = false;
        } else {
            z = true;
        }
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString("member_refer_page", this.g);
        bundle.putString("member_click_zone", this.h);
        bundle.putBoolean("member_is_pay_dialog", this.x.booleanValue());
        bundle.putInt("member_from_type", this.c);
        bundle.putInt("member_from_scene", this.d);
        bundle.putString("member_fid", this.C);
        bundle.putString("member_pay_show_price", this.D);
        if (!z) {
            MemberPayResult.c cVar = memberPayResult.b;
            if (cVar.a != null) {
                if (cVar.b == null) {
                    MemberPayFragment memberPayFragment = new MemberPayFragment();
                    bundle.putInt(MemberPayActivityConfig.MEMBER_TYPE, 1);
                    this.t = 1;
                    memberPayFragment.setArguments(bundle);
                    arrayList.add(memberPayFragment);
                } else {
                    MemberPayFragment memberPayFragment2 = new MemberPayFragment();
                    Bundle bundle2 = (Bundle) bundle.clone();
                    bundle2.putInt(MemberPayActivityConfig.MEMBER_TYPE, 2);
                    this.t = 2;
                    memberPayFragment2.setArguments(bundle2);
                    arrayList.add(memberPayFragment2);
                    MemberPayFragment memberPayFragment3 = new MemberPayFragment();
                    Bundle bundle3 = (Bundle) bundle.clone();
                    bundle3.putInt(MemberPayActivityConfig.MEMBER_TYPE, 1);
                    memberPayFragment3.setArguments(bundle3);
                    arrayList.add(memberPayFragment3);
                }
                if (this.s != null) {
                    this.s = new MemberPayListAdapter(getSupportFragmentManager());
                    T1(arrayList);
                    R1(this.s.getCount());
                    this.r.setCurrentTab(0);
                    return;
                }
                return;
            }
        }
        MemberPayFragment memberPayFragment4 = new MemberPayFragment();
        bundle.putInt(MemberPayActivityConfig.MEMBER_TYPE, 2);
        this.t = 2;
        memberPayFragment4.setArguments(bundle);
        arrayList.add(memberPayFragment4);
        if (this.s != null) {
        }
    }

    public final void T1(List<MemberPayFragment> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.s.c(list);
            int count = this.s.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                M1(this.s.getItem(i2), i2, N1(this.s.getItem(i2).getType()));
            }
            this.r.l();
            this.r.e(0);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
            tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
            String str = this.b;
            if (str != null) {
                httpMessage.addParam("st_type", str);
            }
            httpMessage.addParam(MemberPayActivityConfig.FROM_SCENE, this.d);
            httpMessage.addParam(MemberPayActivityConfig.DEFAULT_GOODS, this.f);
            httpMessage.addParam(MemberPayStatistic.REFER_PAGE, this.g);
            httpMessage.addParam(MemberPayStatistic.CLICK_ZONE, this.h);
            sendMessage(httpMessage);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c55 c55Var = new c55(getPageContext().getPageActivity());
            c55Var.setAutoNight(true);
            c55Var.setCancelable(true);
            c55Var.setTitleShowCenter(true);
            c55Var.setMessageShowCenter(true);
            c55Var.setTitle(getString(R.string.obfuscated_res_0x7f0f15c1));
            c55Var.setMessage(getString(R.string.obfuscated_res_0x7f0f15bf));
            c55Var.setPositiveButton(getString(R.string.obfuscated_res_0x7f0f08e1), new h(this));
            c55Var.setNegativeButton(getString(R.string.obfuscated_res_0x7f0f15c0), new i(this));
            c55Var.create(getPageContext()).show();
        }
    }

    public final void initView() {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d05f5);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09254f);
            this.l = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.j = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091661);
            int g2 = vi.g(getPageContext().getContext(), R.dimen.tbds43);
            this.z = g2;
            this.j.setRoundLayoutRadius(new float[]{g2, g2, g2, g2, 0.0f, 0.0f, 0.0f, 0.0f});
            this.k = (RelativeLayout) findViewById(R.id.navigation_bar);
            this.E = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09185a);
            this.H = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092539);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090492);
            this.m = imageView;
            imageView.setOnClickListener(new e(this));
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925eb);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f0925f8);
            this.B = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f0928af);
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0910e8);
            this.q = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f0916eb);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f092291);
            this.r = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.r.setOnPageChangeListener(this);
            this.r.setTabWidgetViewHeight(0);
            this.r.t();
            this.r.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035d));
            this.r.getFragmentTabWidget().setDviderRectWidth(-2);
            this.r.getFragmentTabWidget().setDviderRectHeight(vi.g(getActivity(), R.dimen.obfuscated_res_0x7f070224));
            this.E.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(3, R.id.obfuscated_res_0x7f092539);
            this.r.setLayoutParams(layoutParams2);
            if (this.A) {
                this.B.setGuideContent(l56.e().h(), l56.e().g());
                this.B.setVisibility(0);
                this.k.setVisibility(8);
                this.p.setVisibility(8);
                this.B.setCloseClickListener(new f(this));
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(3, R.id.obfuscated_res_0x7f0928af);
                this.r.setLayoutParams(layoutParams3);
            }
            this.F = findViewById(R.id.obfuscated_res_0x7f0916d2);
            this.G = findViewById(R.id.obfuscated_res_0x7f0916d3);
            if (StringHelper.equals(this.D, "1") && getActivity() != null) {
                if (TbDimenManager.getInstance().needAdapt()) {
                    TbDimenManager.getInstance().adaptDimen(getActivity().getBaseContext());
                }
                layoutParams = new LinearLayout.LayoutParams(-2, (vi.j(getActivity().getBaseContext()) - this.k.getHeight()) - vi.g(getActivity().getBaseContext(), R.dimen.tbds828));
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, vi.j(TbadkCoreApplication.getInst()) - vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070900));
            }
            this.l.setLayoutParams(layoutParams);
            this.l.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_vip_ad_free_guide_del, R.color.CAM_X0626, null);
            o75 d2 = o75.d(this.o);
            d2.w(R.color.CAM_X0311);
            d2.B(R.dimen.T_X05);
            d2.C(R.string.F_X02);
            this.B.f();
            SkinManager.setImageResource(this.E, R.drawable.obfuscated_res_0x7f08105b);
            SkinManager.setImageResource(this.H, R.drawable.obfuscated_res_0x7f081516);
            if (this.t == 2) {
                SkinManager.setImageResource(this.n, R.drawable.obfuscated_res_0x7f080ca0, i2);
            } else {
                SkinManager.setImageResource(this.n, R.drawable.icon_tbvip_commonvip, i2);
            }
            this.q.setSelector(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
            this.q.setDrawable(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            MemberPayListAdapter memberPayListAdapter = this.s;
            if (memberPayListAdapter != null) {
                int count = memberPayListAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    this.s.getItem(i3).changeSkinType(i2);
                }
            }
            o75.d(this.F).q(new int[]{R.color.CAM_X0201, R.color.CAM_X0202}, Direction.TOP);
            o75.d(this.G).f(R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            K1(TiebaStatic.Params.OBJ_PARAM2);
            super.onCreate(bundle);
            TiebaStatic.log(this.y);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getActivity());
                finish();
                return;
            }
            O1();
            bd5 consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
            if (consumePathData != null) {
                this.x = Boolean.valueOf(consumePathData.b(1, this.e));
            }
            initView();
            S1();
            P1();
            I1();
            if (TbSingleton.getInstance().isUserBan()) {
                zr5.a(this);
            }
            xv8.a(this.g, this.h, this.C);
        }
    }
}
