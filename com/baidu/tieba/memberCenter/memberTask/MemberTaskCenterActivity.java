package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import c.a.d.f.p.l;
import c.a.o0.r.t.a;
import c.a.p0.j2.c.b.r;
import c.a.p0.j2.e.a;
import c.a.p0.j2.e.c;
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
/* loaded from: classes5.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String imageUrl;
    public boolean isFromH5;
    public String jumpUrl;
    public View.OnClickListener mCommenClickListener;
    public a.b mFinishMemberTaskCallbak;
    public c.a.p0.j2.e.a mFinishMemberTaskModel;
    public c.a.p0.j2.e.c mModel;
    public c.b mTaskLoadCallback;
    public c.a.p0.j2.e.d mView;
    public int type;

    /* loaded from: classes5.dex */
    public class a implements a.b {
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

        @Override // c.a.p0.j2.e.a.b
        public void a(int i, String str, int i2, int i3, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) && i == 0 && this.a.mView != null) {
                this.a.showGetScoresSuccessDialog(i3);
                r rVar = new r();
                rVar.h(j);
                if (this.a.type == 1 && i2 == 2) {
                    this.a.mModel.l(this.a.mModel.h() + i3);
                }
                if (this.a.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                rVar.g(i2);
                this.a.refreshDataWithScores(rVar, i3);
                if (this.a.type == 2) {
                    TiebaStatic.log(new StatisticItem("c11744"));
                }
                if (this.a.type == 1) {
                    TiebaStatic.log(new StatisticItem("c11745"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.b {
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

        @Override // c.a.p0.j2.e.c.b
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

        @Override // c.a.p0.j2.e.c.b
        public void b(List<ImgInfo> list, List<r> list2, long j) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f090147) {
                MemberCenterStatic.a(this.a.getPageContext(), new String[]{this.a.jumpUrl});
                this.a.isFromH5 = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view.getId() == R.id.obfuscated_res_0x7f091ef7 && (view.getTag() instanceof r)) {
                r rVar = (r) view.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else if (rVar.getType() == 2) {
                    this.a.type = 2;
                    this.a.showDialog(rVar);
                } else if (rVar.getType() == 1) {
                    this.a.type = 1;
                    if (this.a.mFinishMemberTaskModel != null) {
                        this.a.mFinishMemberTaskModel.f(rVar.c(), rVar.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f34492b;

        public d(MemberTaskCenterActivity memberTaskCenterActivity, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34492b = memberTaskCenterActivity;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
                ViewHelper.skipToLoginActivity(this.f34492b.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f34493b;

        public e(MemberTaskCenterActivity memberTaskCenterActivity, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34493b = memberTaskCenterActivity;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f34494b;

        public f(MemberTaskCenterActivity memberTaskCenterActivity, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34494b = memberTaskCenterActivity;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f34494b.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MemberTaskCenterActivity f34495b;

        public g(MemberTaskCenterActivity memberTaskCenterActivity, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberTaskCenterActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34495b = memberTaskCenterActivity;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
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
    public void showDialog(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, rVar) == null) || rVar == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setTitle(R.string.obfuscated_res_0x7f0f13e2);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0a4b, new d(this, aVar));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new e(this, aVar));
            aVar.create(getPageContext());
            aVar.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            c.a.p0.j2.e.a aVar2 = this.mFinishMemberTaskModel;
            if (aVar2 != null) {
                aVar2.f(rVar.c(), rVar.a());
            }
        } else {
            c.a.o0.r.t.a aVar3 = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar3.setTitle(R.string.obfuscated_res_0x7f0f13e3);
            aVar3.setButtonTextColor(R.color.CAM_X0305);
            aVar3.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new f(this, aVar3));
            aVar3.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new g(this, aVar3));
            aVar3.create(getPageContext());
            aVar3.show();
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
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f13e1), Integer.valueOf(i)));
        } else if (i2 == 2) {
            showToast(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f13e0), Integer.valueOf(i)));
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
            this.mView = new c.a.p0.j2.e.d(this, this.mCommenClickListener);
            c.a.p0.j2.e.c cVar = new c.a.p0.j2.e.c();
            this.mModel = cVar;
            cVar.m(this.mTaskLoadCallback);
            c.a.p0.j2.e.a aVar = new c.a.p0.j2.e.a();
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
            c.a.p0.j2.e.a aVar = this.mFinishMemberTaskModel;
            if (aVar != null) {
                aVar.g();
            }
            c.a.p0.j2.e.c cVar = this.mModel;
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
            if (this.isFromH5 && l.z()) {
                this.isFromH5 = false;
                this.mModel.j();
            }
        }
    }

    public void refreshDataWithScores(r rVar, int i) {
        List<r> i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, rVar, i) == null) || rVar == null || i <= 0) {
            return;
        }
        if (this.mModel.i() != null && (i2 = this.mModel.i()) != null && i2.size() > 0) {
            Iterator<r> it = i2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r next = it.next();
                if (next != null && next.c() == rVar.c()) {
                    next.g(rVar.e());
                    break;
                }
            }
        }
        this.mView.e(this.imageUrl, this.mModel.i(), this.mModel.h());
    }
}
