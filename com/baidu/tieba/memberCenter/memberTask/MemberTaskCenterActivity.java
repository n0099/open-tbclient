package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.jl7;
import com.baidu.tieba.ll7;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.tieba.nl7;
import com.baidu.tieba.ol7;
import com.baidu.tieba.pi;
import com.baidu.tieba.wr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes5.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nl7 a;
    public ol7 b;
    public String c;
    public String d;
    public int e;
    public ll7 f;
    public boolean g;
    public ll7.b h;
    public nl7.b i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements ll7.b {
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

        @Override // com.baidu.tieba.ll7.b
        public void a(int i, String str, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) && i == 0 && this.a.b != null) {
                this.a.N1(i3);
                jl7 jl7Var = new jl7();
                jl7Var.h(j);
                if (this.a.e == 1 && i2 == 2) {
                    this.a.a.l(this.a.a.h() + i3);
                }
                if (this.a.e == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                jl7Var.g(i2);
                this.a.L1(jl7Var, i3);
                if (this.a.e == 2) {
                    TiebaStatic.log(new StatisticItem("c11744"));
                }
                if (this.a.e == 1) {
                    TiebaStatic.log(new StatisticItem("c11745"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nl7.b {
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

        @Override // com.baidu.tieba.nl7.b
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

        @Override // com.baidu.tieba.nl7.b
        public void b(List<ImgInfo> list, List<jl7> list2, long j) {
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

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09014a) {
                MemberCenterStatic.a(this.a.getPageContext(), new String[]{this.a.c});
                this.a.g = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09207e && (view2.getTag() instanceof jl7)) {
                jl7 jl7Var = (jl7) view2.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else if (jl7Var.getType() == 2) {
                    this.a.e = 2;
                    this.a.M1(jl7Var);
                } else if (jl7Var.getType() == 1) {
                    this.a.e = 1;
                    if (this.a.f != null) {
                        this.a.f.f(jl7Var.c(), jl7Var.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public d(MemberTaskCenterActivity memberTaskCenterActivity, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, wr4Var};
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
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.dismiss();
                ViewHelper.skipToLoginActivity(this.b.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public e(MemberTaskCenterActivity memberTaskCenterActivity, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, wr4Var};
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
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public f(MemberTaskCenterActivity memberTaskCenterActivity, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, wr4Var};
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
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.b.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public g(MemberTaskCenterActivity memberTaskCenterActivity, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, wr4Var};
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
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
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

    public void L1(jl7 jl7Var, int i) {
        List<jl7> i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, jl7Var, i) == null) || jl7Var == null || i <= 0) {
            return;
        }
        if (this.a.i() != null && (i2 = this.a.i()) != null && i2.size() > 0) {
            Iterator<jl7> it = i2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                jl7 next = it.next();
                if (next != null && next.c() == jl7Var.c()) {
                    next.g(jl7Var.e());
                    break;
                }
            }
        }
        this.b.e(this.d, this.a.i(), this.a.h());
    }

    public final void M1(jl7 jl7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jl7Var) == null) || jl7Var == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            wr4 wr4Var = new wr4(getPageContext().getPageActivity());
            wr4Var.setTitle(R.string.obfuscated_res_0x7f0f1418);
            wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0a5f, new d(this, wr4Var));
            wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new e(this, wr4Var));
            wr4Var.create(getPageContext());
            wr4Var.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            ll7 ll7Var = this.f;
            if (ll7Var != null) {
                ll7Var.f(jl7Var.c(), jl7Var.a());
            }
        } else {
            wr4 wr4Var2 = new wr4(getPageContext().getPageActivity());
            wr4Var2.setTitle(R.string.obfuscated_res_0x7f0f1419);
            wr4Var2.setButtonTextColor(R.color.CAM_X0305);
            wr4Var2.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf9, new f(this, wr4Var2));
            wr4Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new g(this, wr4Var2));
            wr4Var2.create(getPageContext());
            wr4Var2.show();
        }
    }

    public final void N1(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i <= 0) {
            return;
        }
        int i2 = this.e;
        if (i2 == 1) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f1417), Integer.valueOf(i)));
        } else if (i2 == 2) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f1416), Integer.valueOf(i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.d(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.b = new ol7(this, this.j);
            nl7 nl7Var = new nl7();
            this.a = nl7Var;
            nl7Var.m(this.i);
            ll7 ll7Var = new ll7();
            this.f = ll7Var;
            ll7Var.h(this.h);
            this.a.j();
            showLoadingView(this.b.c());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            ll7 ll7Var = this.f;
            if (ll7Var != null) {
                ll7Var.g();
            }
            nl7 nl7Var = this.a;
            if (nl7Var != null) {
                nl7Var.k();
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
            if (this.g && pi.z()) {
                this.g = false;
                this.a.j();
            }
        }
    }
}
