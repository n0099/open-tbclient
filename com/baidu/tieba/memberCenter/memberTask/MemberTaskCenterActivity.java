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
import d.b.c.e.p.j;
import d.b.i0.r.s.a;
import d.b.j0.r1.c.b.r;
import d.b.j0.r1.e.a;
import d.b.j0.r1.e.c;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes3.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    public String imageUrl;
    public String jumpUrl;
    public d.b.j0.r1.e.a mFinishMemberTaskModel;
    public d.b.j0.r1.e.c mModel;
    public d.b.j0.r1.e.d mView;
    public int type;
    public boolean isFromH5 = false;
    public a.b mFinishMemberTaskCallbak = new a();
    public c.b mTaskLoadCallback = new b();
    public View.OnClickListener mCommenClickListener = new c();

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.j0.r1.e.a.b
        public void a(int i, String str, int i2, int i3, long j) {
            if (i == 0 && MemberTaskCenterActivity.this.mView != null) {
                MemberTaskCenterActivity.this.showGetScoresSuccessDialog(i3);
                r rVar = new r();
                rVar.i(j);
                if (MemberTaskCenterActivity.this.type == 1 && i2 == 2) {
                    MemberTaskCenterActivity.this.mModel.l(MemberTaskCenterActivity.this.mModel.h() + i3);
                }
                if (MemberTaskCenterActivity.this.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016498, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                rVar.h(i2);
                MemberTaskCenterActivity.this.refreshDataWithScores(rVar, i3);
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

        @Override // d.b.j0.r1.e.c.b
        public void a(int i, String str) {
            MemberTaskCenterActivity.this.mView.b().setVisibility(8);
            MemberTaskCenterActivity memberTaskCenterActivity = MemberTaskCenterActivity.this;
            memberTaskCenterActivity.hideLoadingView(memberTaskCenterActivity.mView.c());
            MemberTaskCenterActivity memberTaskCenterActivity2 = MemberTaskCenterActivity.this;
            memberTaskCenterActivity2.showNetRefreshView(memberTaskCenterActivity2.mView.c(), str, true);
            MemberTaskCenterActivity.this.setNetRefreshViewEmotionDefMarginTop();
        }

        @Override // d.b.j0.r1.e.c.b
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
        public final /* synthetic */ d.b.i0.r.s.a f18636e;

        public d(d.b.i0.r.s.a aVar) {
            this.f18636e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f18636e.dismiss();
            ViewHelper.skipToLoginActivity(MemberTaskCenterActivity.this.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f18638e;

        public e(d.b.i0.r.s.a aVar) {
            this.f18638e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f18638e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f18640e;

        public f(d.b.i0.r.s.a aVar) {
            this.f18640e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f18640e.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(MemberTaskCenterActivity.this.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f18642e;

        public g(d.b.i0.r.s.a aVar) {
            this.f18642e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f18642e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(r rVar) {
        if (rVar == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getPageContext().getPageActivity());
            aVar.setTitle(R.string.tips_login_and_get_scores);
            aVar.setPositiveButton(R.string.login, new d(aVar));
            aVar.setNegativeButton(R.string.cancel, new e(aVar));
            aVar.create(getPageContext());
            aVar.show();
        } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
            d.b.j0.r1.e.a aVar2 = this.mFinishMemberTaskModel;
            if (aVar2 != null) {
                aVar2.f(rVar.c(), rVar.a());
            }
        } else {
            d.b.i0.r.s.a aVar3 = new d.b.i0.r.s.a(getPageContext().getPageActivity());
            aVar3.setTitle(R.string.tips_nomal_member_get_scores);
            aVar3.setButtonTextColor(R.color.CAM_X0305);
            aVar3.setPositiveButton(R.string.open_now, new f(aVar3));
            aVar3.setNegativeButton(R.string.cancel, new g(aVar3));
            aVar3.create(getPageContext());
            aVar3.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGetScoresSuccessDialog(int i) {
        if (i <= 0) {
            return;
        }
        int i2 = this.type;
        if (i2 == 1) {
            showToast(String.format(getResources().getString(R.string.tips_get_task_success), Integer.valueOf(i)));
        } else if (i2 == 2) {
            showToast(String.format(getResources().getString(R.string.tips_get_scores_success), Integer.valueOf(i)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.d(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.b.j0.r1.e.d(this, this.mCommenClickListener);
        d.b.j0.r1.e.c cVar = new d.b.j0.r1.e.c();
        this.mModel = cVar;
        cVar.m(this.mTaskLoadCallback);
        d.b.j0.r1.e.a aVar = new d.b.j0.r1.e.a();
        this.mFinishMemberTaskModel = aVar;
        aVar.h(this.mFinishMemberTaskCallbak);
        this.mModel.j();
        showLoadingView(this.mView.c());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.j0.r1.e.a aVar = this.mFinishMemberTaskModel;
        if (aVar != null) {
            aVar.g();
        }
        d.b.j0.r1.e.c cVar = this.mModel;
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

    public void refreshDataWithScores(r rVar, int i) {
        List<r> i2;
        if (rVar == null || i <= 0) {
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
                    next.h(rVar.e());
                    break;
                }
            }
        }
        this.mView.e(this.imageUrl, this.mModel.i(), this.mModel.h());
    }
}
