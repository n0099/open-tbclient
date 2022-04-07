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
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dr4;
import com.repackage.mi;
import com.repackage.nj7;
import com.repackage.qj7;
import com.repackage.sj7;
import com.repackage.tj7;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String imageUrl;
    public boolean isFromH5;
    public String jumpUrl;
    public View.OnClickListener mCommenClickListener;
    public qj7.b mFinishMemberTaskCallbak;
    public qj7 mFinishMemberTaskModel;
    public sj7 mModel;
    public sj7.b mTaskLoadCallback;
    public tj7 mView;
    public int type;

    /* loaded from: classes3.dex */
    public class a implements qj7.b {
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

        @Override // com.repackage.qj7.b
        public void a(int i, String str, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) && i == 0 && this.a.mView != null) {
                this.a.showGetScoresSuccessDialog(i3);
                nj7 nj7Var = new nj7();
                nj7Var.h(j);
                if (this.a.type == 1 && i2 == 2) {
                    this.a.mModel.l(this.a.mModel.h() + i3);
                }
                if (this.a.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                nj7Var.g(i2);
                this.a.refreshDataWithScores(nj7Var, i3);
                if (this.a.type == 2) {
                    TiebaStatic.log(new StatisticItem("c11744"));
                }
                if (this.a.type == 1) {
                    TiebaStatic.log(new StatisticItem("c11745"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements sj7.b {
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

        @Override // com.repackage.sj7.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.mView.b().setVisibility(8);
                MemberTaskCenterActivity memberTaskCenterActivity = this.a;
                memberTaskCenterActivity.hideLoadingView(memberTaskCenterActivity.mView.c());
                MemberTaskCenterActivity memberTaskCenterActivity2 = this.a;
                memberTaskCenterActivity2.showNetRefreshView(memberTaskCenterActivity2.mView.c(), str, true);
                this.a.setNetRefreshViewEmotionDefMarginTop();
            }
        }

        @Override // com.repackage.sj7.b
        public void b(List<ImgInfo> list, List<nj7> list2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, list2, Long.valueOf(j)}) == null) {
                this.a.mView.b().setVisibility(0);
                MemberTaskCenterActivity memberTaskCenterActivity = this.a;
                memberTaskCenterActivity.hideNetRefreshView(memberTaskCenterActivity.mView.c());
                MemberTaskCenterActivity memberTaskCenterActivity2 = this.a;
                memberTaskCenterActivity2.hideLoadingView(memberTaskCenterActivity2.mView.c());
                if (list != null && list.size() >= 1 && list.get(0) != null) {
                    this.a.jumpUrl = list.get(0).jump_url;
                    this.a.imageUrl = list.get(0).img_url;
                }
                this.a.mView.e(this.a.imageUrl, list2, j);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (view2.getId() == R.id.obfuscated_res_0x7f090150) {
                MemberCenterStatic.a(this.a.getPageContext(), new String[]{this.a.jumpUrl});
                this.a.isFromH5 = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ee3 && (view2.getTag() instanceof nj7)) {
                nj7 nj7Var = (nj7) view2.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else if (nj7Var.getType() == 2) {
                    this.a.type = 2;
                    this.a.showDialog(nj7Var);
                } else if (nj7Var.getType() == 1) {
                    this.a.type = 1;
                    if (this.a.mFinishMemberTaskModel != null) {
                        this.a.mFinishMemberTaskModel.f(nj7Var.c(), nj7Var.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public d(MemberTaskCenterActivity memberTaskCenterActivity, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
                ViewHelper.skipToLoginActivity(this.b.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public e(MemberTaskCenterActivity memberTaskCenterActivity, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public f(MemberTaskCenterActivity memberTaskCenterActivity, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.b.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ MemberTaskCenterActivity b;

        public g(MemberTaskCenterActivity memberTaskCenterActivity, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, dr4Var};
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
            this.a = dr4Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
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
        this.isFromH5 = false;
        this.mFinishMemberTaskCallbak = new a(this);
        this.mTaskLoadCallback = new b(this);
        this.mCommenClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(nj7 nj7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, nj7Var) == null) || nj7Var == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            dr4 dr4Var = new dr4(getPageContext().getPageActivity());
            dr4Var.setTitle(R.string.obfuscated_res_0x7f0f13ea);
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0a4d, new d(this, dr4Var));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new e(this, dr4Var));
            dr4Var.create(getPageContext());
            dr4Var.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            qj7 qj7Var = this.mFinishMemberTaskModel;
            if (qj7Var != null) {
                qj7Var.f(nj7Var.c(), nj7Var.a());
            }
        } else {
            dr4 dr4Var2 = new dr4(getPageContext().getPageActivity());
            dr4Var2.setTitle(R.string.obfuscated_res_0x7f0f13eb);
            dr4Var2.setButtonTextColor(R.color.CAM_X0305);
            dr4Var2.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccc, new f(this, dr4Var2));
            dr4Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new g(this, dr4Var2));
            dr4Var2.create(getPageContext());
            dr4Var2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGetScoresSuccessDialog(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i) == null) || i <= 0) {
            return;
        }
        int i2 = this.type;
        if (i2 == 1) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f13e9), Integer.valueOf(i)));
        } else if (i2 == 2) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f13e8), Integer.valueOf(i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.d(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new tj7(this, this.mCommenClickListener);
            sj7 sj7Var = new sj7();
            this.mModel = sj7Var;
            sj7Var.m(this.mTaskLoadCallback);
            qj7 qj7Var = new qj7();
            this.mFinishMemberTaskModel = qj7Var;
            qj7Var.h(this.mFinishMemberTaskCallbak);
            this.mModel.j();
            showLoadingView(this.mView.c());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            qj7 qj7Var = this.mFinishMemberTaskModel;
            if (qj7Var != null) {
                qj7Var.g();
            }
            sj7 sj7Var = this.mModel;
            if (sj7Var != null) {
                sj7Var.k();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            showLoadingView(this.mView.c());
            hideNetRefreshView(this.mView.c());
            this.mModel.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            if (this.isFromH5 && mi.z()) {
                this.isFromH5 = false;
                this.mModel.j();
            }
        }
    }

    public void refreshDataWithScores(nj7 nj7Var, int i) {
        List<nj7> i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, nj7Var, i) == null) || nj7Var == null || i <= 0) {
            return;
        }
        if (this.mModel.i() != null && (i2 = this.mModel.i()) != null && i2.size() > 0) {
            Iterator<nj7> it = i2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                nj7 next = it.next();
                if (next != null && next.c() == nj7Var.c()) {
                    next.g(nj7Var.e());
                    break;
                }
            }
        }
        this.mView.e(this.imageUrl, this.mModel.i(), this.mModel.h());
    }
}
