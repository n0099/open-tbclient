package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import b.a.e.e.p.j;
import b.a.q0.s.s.a;
import b.a.r0.y1.c.k.r;
import b.a.r0.y1.e.a;
import b.a.r0.y1.e.c;
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
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes9.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String imageUrl;
    public boolean isFromH5;
    public String jumpUrl;
    public View.OnClickListener mCommenClickListener;
    public a.b mFinishMemberTaskCallbak;
    public b.a.r0.y1.e.a mFinishMemberTaskModel;
    public b.a.r0.y1.e.c mModel;
    public c.b mTaskLoadCallback;
    public b.a.r0.y1.e.d mView;
    public int type;

    /* loaded from: classes9.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51541a;

        public a(MemberTaskCenterActivity memberTaskCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51541a = memberTaskCenterActivity;
        }

        @Override // b.a.r0.y1.e.a.b
        public void a(int i2, String str, int i3, int i4, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) && i2 == 0 && this.f51541a.mView != null) {
                this.f51541a.showGetScoresSuccessDialog(i4);
                r rVar = new r();
                rVar.i(j);
                if (this.f51541a.type == 1 && i3 == 2) {
                    this.f51541a.mModel.l(this.f51541a.mModel.h() + i4);
                }
                if (this.f51541a.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i4)));
                }
                if (i3 >= 1) {
                    i3 = 1;
                }
                rVar.h(i3);
                this.f51541a.refreshDataWithScores(rVar, i4);
                if (this.f51541a.type == 2) {
                    TiebaStatic.log(new StatisticItem("c11744"));
                }
                if (this.f51541a.type == 1) {
                    TiebaStatic.log(new StatisticItem("c11745"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51542a;

        public b(MemberTaskCenterActivity memberTaskCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51542a = memberTaskCenterActivity;
        }

        @Override // b.a.r0.y1.e.c.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f51542a.mView.b().setVisibility(8);
                MemberTaskCenterActivity memberTaskCenterActivity = this.f51542a;
                memberTaskCenterActivity.hideLoadingView(memberTaskCenterActivity.mView.c());
                MemberTaskCenterActivity memberTaskCenterActivity2 = this.f51542a;
                memberTaskCenterActivity2.showNetRefreshView(memberTaskCenterActivity2.mView.c(), str, true);
                this.f51542a.setNetRefreshViewEmotionDefMarginTop();
            }
        }

        @Override // b.a.r0.y1.e.c.b
        public void b(List<ImgInfo> list, List<r> list2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, list2, Long.valueOf(j)}) == null) {
                this.f51542a.mView.b().setVisibility(0);
                MemberTaskCenterActivity memberTaskCenterActivity = this.f51542a;
                memberTaskCenterActivity.hideNetRefreshView(memberTaskCenterActivity.mView.c());
                MemberTaskCenterActivity memberTaskCenterActivity2 = this.f51542a;
                memberTaskCenterActivity2.hideLoadingView(memberTaskCenterActivity2.mView.c());
                if (list != null && list.size() >= 1 && list.get(0) != null) {
                    this.f51542a.jumpUrl = list.get(0).jump_url;
                    this.f51542a.imageUrl = list.get(0).img_url;
                }
                this.f51542a.mView.e(this.f51542a.imageUrl, list2, j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51543e;

        public c(MemberTaskCenterActivity memberTaskCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51543e = memberTaskCenterActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == R.id.advert_image_view) {
                MemberCenterStatic.a(this.f51543e.getPageContext(), new String[]{this.f51543e.jumpUrl});
                this.f51543e.isFromH5 = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view.getId() == R.id.task_status && (view.getTag() instanceof r)) {
                r rVar = (r) view.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f51543e.getPageContext().getPageActivity());
                } else if (rVar.getType() == 2) {
                    this.f51543e.type = 2;
                    this.f51543e.showDialog(rVar);
                } else if (rVar.getType() == 1) {
                    this.f51543e.type = 1;
                    if (this.f51543e.mFinishMemberTaskModel != null) {
                        this.f51543e.mFinishMemberTaskModel.f(rVar.c(), rVar.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f51544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51545f;

        public d(MemberTaskCenterActivity memberTaskCenterActivity, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51545f = memberTaskCenterActivity;
            this.f51544e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f51544e.dismiss();
                ViewHelper.skipToLoginActivity(this.f51545f.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f51546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51547f;

        public e(MemberTaskCenterActivity memberTaskCenterActivity, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51547f = memberTaskCenterActivity;
            this.f51546e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f51546e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f51548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51549f;

        public f(MemberTaskCenterActivity memberTaskCenterActivity, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51549f = memberTaskCenterActivity;
            this.f51548e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f51548e.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f51549f.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f51550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f51551f;

        public g(MemberTaskCenterActivity memberTaskCenterActivity, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51551f = memberTaskCenterActivity;
            this.f51550e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f51550e.dismiss();
            }
        }
    }

    public MemberTaskCenterActivity() {
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
        this.isFromH5 = false;
        this.mFinishMemberTaskCallbak = new a(this);
        this.mTaskLoadCallback = new b(this);
        this.mCommenClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, rVar) == null) || rVar == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setTitle(R.string.tips_login_and_get_scores);
            aVar.setPositiveButton(R.string.login, new d(this, aVar));
            aVar.setNegativeButton(R.string.cancel, new e(this, aVar));
            aVar.create(getPageContext());
            aVar.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            b.a.r0.y1.e.a aVar2 = this.mFinishMemberTaskModel;
            if (aVar2 != null) {
                aVar2.f(rVar.c(), rVar.a());
            }
        } else {
            b.a.q0.s.s.a aVar3 = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar3.setTitle(R.string.tips_nomal_member_get_scores);
            aVar3.setButtonTextColor(R.color.CAM_X0305);
            aVar3.setPositiveButton(R.string.open_now, new f(this, aVar3));
            aVar3.setNegativeButton(R.string.cancel, new g(this, aVar3));
            aVar3.create(getPageContext());
            aVar3.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGetScoresSuccessDialog(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || i2 <= 0) {
            return;
        }
        int i3 = this.type;
        if (i3 == 1) {
            showToast(String.format(getResources().getString(R.string.tips_get_task_success), Integer.valueOf(i2)));
        } else if (i3 == 2) {
            showToast(String.format(getResources().getString(R.string.tips_get_scores_success), Integer.valueOf(i2)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.d(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new b.a.r0.y1.e.d(this, this.mCommenClickListener);
            b.a.r0.y1.e.c cVar = new b.a.r0.y1.e.c();
            this.mModel = cVar;
            cVar.m(this.mTaskLoadCallback);
            b.a.r0.y1.e.a aVar = new b.a.r0.y1.e.a();
            this.mFinishMemberTaskModel = aVar;
            aVar.h(this.mFinishMemberTaskCallbak);
            this.mModel.j();
            showLoadingView(this.mView.c());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            b.a.r0.y1.e.a aVar = this.mFinishMemberTaskModel;
            if (aVar != null) {
                aVar.g();
            }
            b.a.r0.y1.e.c cVar = this.mModel;
            if (cVar != null) {
                cVar.k();
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
            if (this.isFromH5 && j.z()) {
                this.isFromH5 = false;
                this.mModel.j();
            }
        }
    }

    public void refreshDataWithScores(r rVar, int i2) {
        List<r> i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, rVar, i2) == null) || rVar == null || i2 <= 0) {
            return;
        }
        if (this.mModel.i() != null && (i3 = this.mModel.i()) != null && i3.size() > 0) {
            Iterator<r> it = i3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r next = it.next();
                if (next != null && next.c() == rVar.c()) {
                    next.h(rVar.f());
                    break;
                }
            }
        }
        this.mView.e(this.imageUrl, this.mModel.i(), this.mModel.h());
    }
}
