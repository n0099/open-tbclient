package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.bl8;
import com.baidu.tieba.c05;
import com.baidu.tieba.dl8;
import com.baidu.tieba.fl8;
import com.baidu.tieba.gl8;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
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
    public fl8 a;
    public gl8 b;
    public String c;
    public String d;
    public int e;
    public dl8 f;
    public boolean g;
    public dl8.b h;
    public fl8.b i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements dl8.b {
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

        @Override // com.baidu.tieba.dl8.b
        public void a(int i, String str, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) != null) || i != 0 || this.a.b == null) {
                return;
            }
            this.a.N1(i3);
            bl8 bl8Var = new bl8();
            bl8Var.h(j);
            if (this.a.e == 1 && i2 == 2) {
                this.a.a.l(this.a.a.h() + i3);
            }
            if (this.a.e == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i3)));
            }
            if (i2 >= 1) {
                i2 = 1;
            }
            bl8Var.g(i2);
            this.a.L1(bl8Var, i3);
            if (this.a.e == 2) {
                TiebaStatic.log(new StatisticItem("c11744"));
            }
            if (this.a.e == 1) {
                TiebaStatic.log(new StatisticItem("c11745"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements fl8.b {
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

        @Override // com.baidu.tieba.fl8.b
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

        @Override // com.baidu.tieba.fl8.b
        public void b(List<ImgInfo> list, List<bl8> list2, long j) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09014a) {
                MemberCenterStatic.a(this.a.getPageContext(), new String[]{this.a.c});
                this.a.g = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922b7 && (view2.getTag() instanceof bl8)) {
                bl8 bl8Var = (bl8) view2.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else if (bl8Var.getType() != 2) {
                    if (bl8Var.getType() != 1) {
                        return;
                    }
                    this.a.e = 1;
                    if (this.a.f != null) {
                        this.a.f.f(bl8Var.c(), bl8Var.a());
                    }
                } else {
                    this.a.e = 2;
                    this.a.M1(bl8Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public d(MemberTaskCenterActivity memberTaskCenterActivity, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, c05Var};
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
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.dismiss();
                ViewHelper.skipToLoginActivity(this.b.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public e(MemberTaskCenterActivity memberTaskCenterActivity, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, c05Var};
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
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public f(MemberTaskCenterActivity memberTaskCenterActivity, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, c05Var};
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
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.b.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public g(MemberTaskCenterActivity memberTaskCenterActivity, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, c05Var};
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
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
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

    public void L1(bl8 bl8Var, int i) {
        List<bl8> i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, bl8Var, i) == null) && bl8Var != null && i > 0) {
            if (this.a.i() != null && (i2 = this.a.i()) != null && i2.size() > 0) {
                Iterator<bl8> it = i2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    bl8 next = it.next();
                    if (next != null && next.c() == bl8Var.c()) {
                        next.g(bl8Var.e());
                        break;
                    }
                }
            }
            this.b.e(this.d, this.a.i(), this.a.h());
        }
    }

    public final void M1(bl8 bl8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bl8Var) != null) || bl8Var == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            c05 c05Var = new c05(getPageContext().getPageActivity());
            c05Var.setTitle(R.string.obfuscated_res_0x7f0f1510);
            c05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b21, new d(this, c05Var));
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new e(this, c05Var));
            c05Var.create(getPageContext());
            c05Var.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            dl8 dl8Var = this.f;
            if (dl8Var != null) {
                dl8Var.f(bl8Var.c(), bl8Var.a());
            }
        } else {
            c05 c05Var2 = new c05(getPageContext().getPageActivity());
            c05Var2.setTitle(R.string.obfuscated_res_0x7f0f1511);
            c05Var2.setButtonTextColor(R.color.CAM_X0305);
            c05Var2.setPositiveButton(R.string.open_now, new f(this, c05Var2));
            c05Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new g(this, c05Var2));
            c05Var2.create(getPageContext());
            c05Var2.show();
        }
    }

    public final void N1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i <= 0) {
            return;
        }
        int i2 = this.e;
        if (i2 == 1) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f150f), Integer.valueOf(i)));
        } else if (i2 == 2) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f150e), Integer.valueOf(i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.b = new gl8(this, this.j);
            fl8 fl8Var = new fl8();
            this.a = fl8Var;
            fl8Var.m(this.i);
            dl8 dl8Var = new dl8();
            this.f = dl8Var;
            dl8Var.h(this.h);
            this.a.j();
            showLoadingView(this.b.c());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            dl8 dl8Var = this.f;
            if (dl8Var != null) {
                dl8Var.g();
            }
            fl8 fl8Var = this.a;
            if (fl8Var != null) {
                fl8Var.k();
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
