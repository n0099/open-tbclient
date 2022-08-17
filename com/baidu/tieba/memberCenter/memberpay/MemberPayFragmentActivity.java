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
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa5;
import com.repackage.ba5;
import com.repackage.da5;
import com.repackage.fy4;
import com.repackage.kl7;
import com.repackage.ll7;
import com.repackage.ms4;
import com.repackage.qi;
import com.repackage.ru4;
import com.repackage.ul5;
import com.repackage.ur4;
import com.repackage.x95;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayFragmentActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VipAdFreeGuideLayout A;
    public String B;
    public TbImageView C;
    public View D;
    public View E;
    public TbImageView F;
    public HttpMessageListener G;
    public HttpMessageListener H;
    public final CustomMessageListener I;
    public int a;
    public String b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public RoundRelativeLayout i;
    public RelativeLayout j;
    public View k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public LinearLayout o;
    public IndicatorView p;
    public FragmentTabHost q;
    public MemberPayListAdapter r;
    public int s;
    public int t;
    public boolean u;
    public PayConfigModel v;
    public Boolean w;
    public String x;
    public int y;
    public boolean z;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505 && (httpResponsedMessage instanceof ResponseGetPayinfoMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0) {
                    ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                    if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (pay_status != 1 && pay_status == 3) {
                            }
                            return;
                        }
                        this.a.T0();
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001194, Integer.valueOf(this.a.s)));
                        this.a.setResult(-1);
                        ru4.k().u("show_member_deid_line", true);
                        if (!this.a.h) {
                            this.a.i1();
                        } else {
                            this.a.finish();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if ((httpResponsedMessage instanceof ResponseMemberPayMessage) && httpResponsedMessage.getCmd() == 1001532) {
                    ResponseMemberPayMessage responseMemberPayMessage = (ResponseMemberPayMessage) httpResponsedMessage;
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        if (responseMemberPayMessage.getMemberPayResult() != null) {
                            kl7 memberPayResult = responseMemberPayMessage.getMemberPayResult();
                            this.a.b1(memberPayResult);
                            if (this.a.r != null) {
                                int count = this.a.r.getCount();
                                for (int i = 0; i < count; i++) {
                                    this.a.r.getItem(i).s1(memberPayResult);
                                }
                                return;
                            }
                            return;
                        }
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                        return;
                    }
                    String errorString = responseMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d);
                    }
                    this.a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016525 && this.a.r != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                int count = this.a.r.getCount();
                for (int i = 0; i < count; i++) {
                    this.a.r.getItem(i).r1(bool);
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f1412);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k1();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k1();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ba5 {
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

        @Override // com.repackage.ba5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                da5 c = da5.c();
                c.b("https://tieba.baidu.com/mo/q/tbeantshow?refer_page=" + this.a.f + "&click_zone=" + this.a.g, this.a.getPageContext());
                this.a.finish();
            }
        }

        @Override // com.repackage.ba5
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i1();
            }
        }

        @Override // com.repackage.ba5
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.i1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem("c13202").param("obj_locate", 0));
                ur4Var.dismiss();
                if (this.a.k != null) {
                    this.a.k.setBackgroundColor(this.a.getPageContext().getPageActivity().getResources().getColor(R.color.transparent));
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
        this.t = 0;
        this.u = false;
        this.w = Boolean.FALSE;
        this.x = "c10482";
        this.G = new a(this, CmdConfigHttp.GETPAYINFO_CMD);
        this.H = new b(this, CmdConfigHttp.MEMBER_PAY_CMD);
        this.I = new c(this, 2016525);
    }

    public final void S0() {
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

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.c;
            if (i2 == 2) {
                U0("consume_10");
            } else if (i2 == 1) {
                U0("consume_5");
            } else if (i2 == 3) {
                U0("consume_35");
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

    public final void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click");
        }
    }

    public final void V0(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.c = fragment;
        bVar.a = i2;
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.b = fragmentTabIndicator;
        this.q.c(bVar);
    }

    public final String W0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 != 2) {
                return getResources().getString(R.string.obfuscated_res_0x7f0f1395);
            }
            return getResources().getString(R.string.obfuscated_res_0x7f0f1398);
        }
        return (String) invokeI.objValue;
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.a = getIntent().getExtras().getInt("member_type");
                this.b = getIntent().getExtras().getString("st_type");
                this.c = getIntent().getExtras().getInt("from", 0);
                this.h = getIntent().getExtras().getBoolean("close");
                this.d = getIntent().getExtras().getInt(MemberPayActivityConfig.FROM_SCENE, 0);
                this.e = getIntent().getExtras().getString(MemberPayActivityConfig.SCENE_ID);
                this.z = getIntent().getExtras().getBoolean(MemberPayActivityConfig.SHOW_VIP_TIP);
                this.B = getIntent().getExtras().getString("fid");
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
            this.f = getIntent().getExtras().getString(MemberPayStatistic.REFER_PAGE);
            this.g = getIntent().getExtras().getString(MemberPayStatistic.CLICK_ZONE);
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h1();
            PayConfigModel payConfigModel = new PayConfigModel(getPageContext(), new g(this));
            this.v = payConfigModel;
            payConfigModel.E();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b1(kl7 kl7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, kl7Var) == null) || this.u) {
            return;
        }
        this.u = true;
        boolean z = kl7Var.a.a.a == 2 || this.a == 2;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString("member_refer_page", this.f);
        bundle.putString("member_click_zone", this.g);
        bundle.putBoolean("member_is_pay_dialog", this.w.booleanValue());
        bundle.putInt("member_from_type", this.c);
        bundle.putInt("member_from_scene", this.d);
        bundle.putString("member_fid", this.B);
        if (!z) {
            kl7.c cVar = kl7Var.b;
            if (cVar.a != null) {
                if (cVar.b == null) {
                    MemberPayFragment memberPayFragment = new MemberPayFragment();
                    bundle.putInt("member_type", 1);
                    this.s = 1;
                    memberPayFragment.setArguments(bundle);
                    arrayList.add(memberPayFragment);
                } else {
                    MemberPayFragment memberPayFragment2 = new MemberPayFragment();
                    Bundle bundle2 = (Bundle) bundle.clone();
                    bundle2.putInt("member_type", 2);
                    this.s = 2;
                    memberPayFragment2.setArguments(bundle2);
                    arrayList.add(memberPayFragment2);
                    MemberPayFragment memberPayFragment3 = new MemberPayFragment();
                    Bundle bundle3 = (Bundle) bundle.clone();
                    bundle3.putInt("member_type", 1);
                    memberPayFragment3.setArguments(bundle3);
                    arrayList.add(memberPayFragment3);
                }
                if (this.r != null) {
                    this.r = new MemberPayListAdapter(getSupportFragmentManager());
                    f1(arrayList);
                    c1(this.r.getCount());
                    this.q.setCurrentTab(0);
                    return;
                }
                return;
            }
        }
        MemberPayFragment memberPayFragment4 = new MemberPayFragment();
        bundle.putInt("member_type", 2);
        this.s = 2;
        memberPayFragment4.setArguments(bundle);
        arrayList.add(memberPayFragment4);
        if (this.r != null) {
        }
    }

    public final void c1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 >= 2) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(4);
            }
            this.p.setCount(i2);
            j1();
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            registerListener(this.H);
            registerListener(this.G);
            registerListener(this.I);
        }
    }

    public final void f1(List<MemberPayFragment> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.r.c(list);
            int count = this.r.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                V0(this.r.getItem(i2), i2, W0(this.r.getItem(i2).getType()));
            }
            this.q.o();
            this.q.f(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "b001" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public x95 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            x95 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (x95) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PAY);
            tbHttpMessageTask.setResponsedClass(ResponseMemberPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PAY_CMD);
            String str = this.b;
            if (str != null) {
                httpMessage.addParam("st_type", str);
            }
            httpMessage.addParam(MemberPayActivityConfig.FROM_SCENE, this.d);
            sendMessage(httpMessage);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0564);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092256);
            this.k = findViewById;
            findViewById.setOnClickListener(new d(this));
            this.i = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09145a);
            int f2 = qi.f(getPageContext().getContext(), R.dimen.tbds43);
            this.y = f2;
            this.i.setRoundLayoutRadius(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091624);
            this.C = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091628);
            this.F = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092243);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090411);
            this.l = imageView;
            imageView.setOnClickListener(new e(this));
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922f0);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0922fe);
            this.A = (VipAdFreeGuideLayout) findViewById(R.id.obfuscated_res_0x7f09257f);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f08);
            this.p = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f0914d6);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091fc1);
            this.q = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.q.setOnPageChangeListener(this);
            this.q.setTabWidgetViewHeight(0);
            this.q.u();
            this.q.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b));
            this.q.getFragmentTabWidget().setDviderRectWidth(-2);
            this.q.getFragmentTabWidget().setDviderRectHeight(qi.f(getActivity(), R.dimen.obfuscated_res_0x7f070224));
            this.C.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092243);
            this.q.setLayoutParams(layoutParams);
            if (this.z) {
                this.A.setGuideContent(ul5.e().h(), ul5.e().g());
                this.A.setVisibility(0);
                this.j.setVisibility(8);
                this.o.setVisibility(8);
                this.A.setCloseClickListener(new f(this));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(3, R.id.obfuscated_res_0x7f09257f);
                this.q.setLayoutParams(layoutParams2);
            }
            this.D = findViewById(R.id.obfuscated_res_0x7f0914bf);
            this.E = findViewById(R.id.obfuscated_res_0x7f0914c0);
            this.k.setLayoutParams(new LinearLayout.LayoutParams(-2, qi.i(TbadkCoreApplication.getInst()) - qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07078b)));
            this.k.setVisibility(0);
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.p.setPosition(this.t);
            this.n.setText(W0(this.s));
            if (this.s == 2) {
                SkinManager.setImageResource(this.m, R.drawable.obfuscated_res_0x7f080a96, TbadkCoreApplication.getInst().getSkinType());
            } else {
                SkinManager.setImageResource(this.m, R.drawable.icon_tbvip_commonvip, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setAutoNight(true);
            ur4Var.setCancelable(true);
            ur4Var.setTitleShowCenter(true);
            ur4Var.setMessageShowCenter(true);
            ur4Var.setTitle(getString(R.string.obfuscated_res_0x7f0f1391));
            ur4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f138f));
            ur4Var.setPositiveButton(getString(R.string.obfuscated_res_0x7f0f07ce), new h(this));
            ur4Var.setNegativeButton(getString(R.string.obfuscated_res_0x7f0f1390), new i(this));
            ur4Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f080a2b, R.color.CAM_X0626, null);
            ms4 d2 = ms4.d(this.n);
            d2.v(R.color.CAM_X0311);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            this.A.f();
            SkinManager.setImageResource(this.C, R.drawable.obfuscated_res_0x7f080e1f);
            SkinManager.setImageResource(this.F, R.drawable.obfuscated_res_0x7f081251);
            if (this.s == 2) {
                SkinManager.setImageResource(this.m, R.drawable.obfuscated_res_0x7f080a96, i2);
            } else {
                SkinManager.setImageResource(this.m, R.drawable.icon_tbvip_commonvip, i2);
            }
            this.p.setSelector(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_a));
            this.p.setDrawable(SkinManager.getDrawable(R.drawable.white_circle_size15_cp_bg_line_c));
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0201);
            MemberPayListAdapter memberPayListAdapter = this.r;
            if (memberPayListAdapter != null) {
                int count = memberPayListAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    this.r.getItem(i3).changeSkinType(i2);
                }
            }
            ms4.d(this.D).p(new int[]{R.color.CAM_X0201, R.color.CAM_X0202}, Direction.TOP);
            ms4.d(this.E).f(R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            TiebaStatic.log(this.x);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getActivity());
                finish();
                return;
            }
            Z0();
            fy4 consumePathData = TbadkCoreApplication.getInst().getConsumePathData();
            if (consumePathData != null) {
                this.w = Boolean.valueOf(consumePathData.b(1, this.e));
            }
            initView();
            d1();
            a1();
            S0();
            if (TbSingleton.getInstance().isUserBan()) {
                aa5.a(this);
            }
            ll7.a(this.d, this.B);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            PayConfigModel payConfigModel = this.v;
            if (payConfigModel != null) {
                payConfigModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048597, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                k1();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.t = i2;
            MemberPayListAdapter memberPayListAdapter = this.r;
            if (memberPayListAdapter != null) {
                this.s = memberPayListAdapter.getItem(i2).getType();
            }
            j1();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01002c, R.anim.obfuscated_res_0x7f010036);
        }
    }
}
