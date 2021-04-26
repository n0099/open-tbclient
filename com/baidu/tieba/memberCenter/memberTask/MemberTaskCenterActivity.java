package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import d.a.c.e.p.j;
import d.a.i0.r.s.a;
import d.a.j0.r1.c.b.r;
import d.a.j0.r1.e.a;
import d.a.j0.r1.e.c;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public String imageUrl;
    public String jumpUrl;
    public d.a.j0.r1.e.a mFinishMemberTaskModel;
    public d.a.j0.r1.e.c mModel;
    public d.a.j0.r1.e.d mView;
    public int type;
    public boolean isFromH5 = false;
    public a.b mFinishMemberTaskCallbak = new a();
    public c.b mTaskLoadCallback = new b();
    public View.OnClickListener mCommenClickListener = new c();

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.j0.r1.e.a.b
        public void a(int i2, String str, int i3, int i4, long j) {
            if (i2 == 0 && MemberTaskCenterActivity.this.mView != null) {
                MemberTaskCenterActivity.this.showGetScoresSuccessDialog(i4);
                r rVar = new r();
                rVar.i(j);
                if (MemberTaskCenterActivity.this.type == 1 && i3 == 2) {
                    MemberTaskCenterActivity.this.mModel.l(MemberTaskCenterActivity.this.mModel.h() + i4);
                }
                if (MemberTaskCenterActivity.this.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i4)));
                }
                if (i3 >= 1) {
                    i3 = 1;
                }
                rVar.h(i3);
                MemberTaskCenterActivity.this.refreshDataWithScores(rVar, i4);
                if (MemberTaskCenterActivity.this.type == 2) {
                    TiebaStatic.log(new StatisticItem("c11744"));
                }
                if (MemberTaskCenterActivity.this.type == 1) {
                    TiebaStatic.log(new StatisticItem("c11745"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.b {
        public b() {
        }

        @Override // d.a.j0.r1.e.c.b
        public void a(int i2, String str) {
            MemberTaskCenterActivity.this.mView.b().setVisibility(8);
            MemberTaskCenterActivity memberTaskCenterActivity = MemberTaskCenterActivity.this;
            memberTaskCenterActivity.hideLoadingView(memberTaskCenterActivity.mView.c());
            MemberTaskCenterActivity memberTaskCenterActivity2 = MemberTaskCenterActivity.this;
            memberTaskCenterActivity2.showNetRefreshView(memberTaskCenterActivity2.mView.c(), str, true);
            MemberTaskCenterActivity.this.setNetRefreshViewEmotionDefMarginTop();
        }

        @Override // d.a.j0.r1.e.c.b
        public void b(List<ImgInfo> list, List<r> list2, long j) {
            MemberTaskCenterActivity.this.mView.b().setVisibility(0);
            MemberTaskCenterActivity memberTaskCenterActivity = MemberTaskCenterActivity.this;
            memberTaskCenterActivity.hideNetRefreshView(memberTaskCenterActivity.mView.c());
            MemberTaskCenterActivity memberTaskCenterActivity2 = MemberTaskCenterActivity.this;
            memberTaskCenterActivity2.hideLoadingView(memberTaskCenterActivity2.mView.c());
            if (list != null && list.size() >= 1 && list.get(0) != null) {
                MemberTaskCenterActivity.this.jumpUrl = list.get(0).jump_url;
                MemberTaskCenterActivity.this.imageUrl = list.get(0).img_url;
            }
            MemberTaskCenterActivity.this.mView.e(MemberTaskCenterActivity.this.imageUrl, list2, j);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            if (view.getId() == R.id.advert_image_view) {
                MemberCenterStatic.a(MemberTaskCenterActivity.this.getPageContext(), new String[]{MemberTaskCenterActivity.this.jumpUrl});
                MemberTaskCenterActivity.this.isFromH5 = true;
                TiebaStatic.log(new StatisticItem("c11747"));
            } else if (view.getId() == R.id.task_status && (view.getTag() instanceof r)) {
                r rVar = (r) view.getTag();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(MemberTaskCenterActivity.this.getPageContext().getPageActivity());
                } else if (rVar.g() == 2) {
                    MemberTaskCenterActivity.this.type = 2;
                    MemberTaskCenterActivity.this.showDialog(rVar);
                } else if (rVar.g() == 1) {
                    MemberTaskCenterActivity.this.type = 1;
                    if (MemberTaskCenterActivity.this.mFinishMemberTaskModel != null) {
                        MemberTaskCenterActivity.this.mFinishMemberTaskModel.f(rVar.c(), rVar.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f19059e;

        public d(d.a.i0.r.s.a aVar) {
            this.f19059e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f19059e.dismiss();
            ViewHelper.skipToLoginActivity(MemberTaskCenterActivity.this.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f19061e;

        public e(d.a.i0.r.s.a aVar) {
            this.f19061e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f19061e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f19063e;

        public f(d.a.i0.r.s.a aVar) {
            this.f19063e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f19063e.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(MemberTaskCenterActivity.this.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f19065e;

        public g(d.a.i0.r.s.a aVar) {
            this.f19065e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f19065e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(r rVar) {
        if (rVar == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getPageContext().getPageActivity());
            aVar.setTitle(R.string.tips_login_and_get_scores);
            aVar.setPositiveButton(R.string.login, new d(aVar));
            aVar.setNegativeButton(R.string.cancel, new e(aVar));
            aVar.create(getPageContext());
            aVar.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            d.a.j0.r1.e.a aVar2 = this.mFinishMemberTaskModel;
            if (aVar2 != null) {
                aVar2.f(rVar.c(), rVar.a());
            }
        } else {
            d.a.i0.r.s.a aVar3 = new d.a.i0.r.s.a(getPageContext().getPageActivity());
            aVar3.setTitle(R.string.tips_nomal_member_get_scores);
            aVar3.setButtonTextColor(R.color.CAM_X0305);
            aVar3.setPositiveButton(R.string.open_now, new f(aVar3));
            aVar3.setNegativeButton(R.string.cancel, new g(aVar3));
            aVar3.create(getPageContext());
            aVar3.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGetScoresSuccessDialog(int i2) {
        if (i2 <= 0) {
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
        super.onChangeSkinType(i2);
        this.mView.d(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.a.j0.r1.e.d(this, this.mCommenClickListener);
        d.a.j0.r1.e.c cVar = new d.a.j0.r1.e.c();
        this.mModel = cVar;
        cVar.m(this.mTaskLoadCallback);
        d.a.j0.r1.e.a aVar = new d.a.j0.r1.e.a();
        this.mFinishMemberTaskModel = aVar;
        aVar.h(this.mFinishMemberTaskCallbak);
        this.mModel.j();
        showLoadingView(this.mView.c());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.r1.e.a aVar = this.mFinishMemberTaskModel;
        if (aVar != null) {
            aVar.g();
        }
        d.a.j0.r1.e.c cVar = this.mModel;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        showLoadingView(this.mView.c());
        hideNetRefreshView(this.mView.c());
        this.mModel.j();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFromH5 && j.z()) {
            this.isFromH5 = false;
            this.mModel.j();
        }
    }

    public void refreshDataWithScores(r rVar, int i2) {
        List<r> i3;
        if (rVar == null || i2 <= 0) {
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
                    next.h(rVar.e());
                    break;
                }
            }
        }
        this.mView.e(this.imageUrl, this.mModel.i(), this.mModel.h());
    }
}
