package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a59;
import com.baidu.tieba.m45;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.v49;
import com.baidu.tieba.x49;
import com.baidu.tieba.z49;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes7.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z49 a;
    public a59 b;
    public String c;
    public String d;
    public int e;
    public x49 f;
    public boolean g;
    public x49.b h;
    public z49.b i;
    public View.OnClickListener j;

    /* loaded from: classes7.dex */
    public class a implements x49.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberTaskCenterActivity a;

        public a(MemberTaskCenterActivity memberTaskCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberTaskCenterActivity;
        }

        @Override // com.baidu.tieba.x49.b
        public void a(int i, String str, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) && i == 0 && this.a.b != null) {
                this.a.K1(i3);
                v49 v49Var = new v49();
                v49Var.h(j);
                if (this.a.e == 1 && i2 == 2) {
                    this.a.a.l(this.a.a.h() + i3);
                }
                if (this.a.e == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                v49Var.g(i2);
                this.a.I1(v49Var, i3);
                if (this.a.e == 2) {
                    TiebaStatic.log(new StatisticItem("c11744"));
                }
                if (this.a.e == 1) {
                    TiebaStatic.log(new StatisticItem("c11745"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements z49.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberTaskCenterActivity a;

        public b(MemberTaskCenterActivity memberTaskCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberTaskCenterActivity;
        }

        @Override // com.baidu.tieba.z49.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.b.b().setVisibility(8);
                MemberTaskCenterActivity memberTaskCenterActivity = this.a;
                memberTaskCenterActivity.hideLoadingView(memberTaskCenterActivity.b.c());
                MemberTaskCenterActivity memberTaskCenterActivity2 = this.a;
                memberTaskCenterActivity2.showNetRefreshView(memberTaskCenterActivity2.b.c(), str, true);
                this.a.setNetRefreshViewEmotionDefMarginTop();
            }
        }

        @Override // com.baidu.tieba.z49.b
        public void b(List<ImgInfo> list, List<v49> list2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, list2, Long.valueOf(j)}) == null) {
                this.a.b.b().setVisibility(0);
                MemberTaskCenterActivity memberTaskCenterActivity = this.a;
                memberTaskCenterActivity.hideNetRefreshView(memberTaskCenterActivity.b.c());
                MemberTaskCenterActivity memberTaskCenterActivity2 = this.a;
                memberTaskCenterActivity2.hideLoadingView(memberTaskCenterActivity2.b.c());
                if (list != null && list.size() >= 1 && list.get(0) != null) {
                    this.a.c = list.get(0).jump_url;
                    this.a.d = list.get(0).img_url;
                }
                this.a.b.e(this.a.d, list2, j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberTaskCenterActivity a;

        public c(MemberTaskCenterActivity memberTaskCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberTaskCenterActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090158) {
                MemberCenterStatic.a(this.a.getPageContext(), new String[]{this.a.c});
                this.a.g = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092423 && (view2.getTag() instanceof v49)) {
                v49 v49Var = (v49) view2.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else if (v49Var.getType() == 2) {
                    this.a.e = 2;
                    this.a.J1(v49Var);
                } else if (v49Var.getType() == 1) {
                    this.a.e = 1;
                    if (this.a.f != null) {
                        this.a.f.f(v49Var.c(), v49Var.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public d(MemberTaskCenterActivity memberTaskCenterActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = memberTaskCenterActivity;
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
                ViewHelper.skipToLoginActivity(this.b.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public e(MemberTaskCenterActivity memberTaskCenterActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = memberTaskCenterActivity;
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public f(MemberTaskCenterActivity memberTaskCenterActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = memberTaskCenterActivity;
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
                PayPanelUtils.launchPayPanel(this.b.getPageContext(), IMConstants.IM_MSG_TYPE_ADVISORY_NEGATIVE_RECOMMEND_HIT_KEY_WORD, MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public g(MemberTaskCenterActivity memberTaskCenterActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = memberTaskCenterActivity;
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public MemberTaskCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new a(this);
        this.i = new b(this);
        this.j = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.d(i);
        }
    }

    public void I1(v49 v49Var, int i) {
        List<v49> i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, v49Var, i) == null) && v49Var != null && i > 0) {
            if (this.a.i() != null && (i2 = this.a.i()) != null && i2.size() > 0) {
                Iterator<v49> it = i2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    v49 next = it.next();
                    if (next != null && next.c() == v49Var.c()) {
                        next.g(v49Var.e());
                        break;
                    }
                }
            }
            this.b.e(this.d, this.a.i(), this.a.h());
        }
    }

    public final void J1(v49 v49Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v49Var) != null) || v49Var == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            m45 m45Var = new m45(getPageContext().getPageActivity());
            m45Var.setTitle(R.string.obfuscated_res_0x7f0f1694);
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0c04, new d(this, m45Var));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new e(this, m45Var));
            m45Var.create(getPageContext());
            m45Var.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            x49 x49Var = this.f;
            if (x49Var != null) {
                x49Var.f(v49Var.c(), v49Var.a());
            }
        } else {
            m45 m45Var2 = new m45(getPageContext().getPageActivity());
            m45Var2.setTitle(R.string.obfuscated_res_0x7f0f1696);
            m45Var2.setButtonTextColor(R.color.CAM_X0305);
            m45Var2.setPositiveButton(R.string.open_now, new f(this, m45Var2));
            m45Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new g(this, m45Var2));
            m45Var2.create(getPageContext());
            m45Var2.show();
        }
    }

    public final void K1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i <= 0) {
            return;
        }
        int i2 = this.e;
        if (i2 == 1) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f1693), Integer.valueOf(i)));
        } else if (i2 == 2) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f1692), Integer.valueOf(i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.b = new a59(this, this.j);
            z49 z49Var = new z49();
            this.a = z49Var;
            z49Var.m(this.i);
            x49 x49Var = new x49();
            this.f = x49Var;
            x49Var.h(this.h);
            this.a.j();
            showLoadingView(this.b.c());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            x49 x49Var = this.f;
            if (x49Var != null) {
                x49Var.g();
            }
            z49 z49Var = this.a;
            if (z49Var != null) {
                z49Var.k();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            showLoadingView(this.b.c());
            hideNetRefreshView(this.b.c());
            this.a.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (this.g && BdNetTypeUtil.isNetWorkAvailable()) {
                this.g = false;
                this.a.j();
            }
        }
    }
}
