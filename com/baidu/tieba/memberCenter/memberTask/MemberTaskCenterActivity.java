package com.baidu.tieba.memberCenter.memberTask;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.a.r;
import com.baidu.tieba.memberCenter.memberTask.a;
import com.baidu.tieba.memberCenter.memberTask.c;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes8.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    private String aIQ;
    private String imageUrl;
    private c lqg;
    private d lqh;
    private a lqi;
    private int type;
    private boolean lqj = false;
    private a.InterfaceC0799a lqk = new a.InterfaceC0799a() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.1
        @Override // com.baidu.tieba.memberCenter.memberTask.a.InterfaceC0799a
        public void a(int i, String str, int i2, int i3, long j) {
            if (i == 0 && MemberTaskCenterActivity.this.lqh != null) {
                MemberTaskCenterActivity.this.Ex(i3);
                r rVar = new r();
                rVar.setTaskId(j);
                if (MemberTaskCenterActivity.this.type == 1 && i2 == 2) {
                    MemberTaskCenterActivity.this.lqg.hj(MemberTaskCenterActivity.this.lqg.dfy() + i3);
                }
                if (MemberTaskCenterActivity.this.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMBER_CENTER_UPDATE_ACTIVE_SCORES, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                rVar.Ew(i2);
                MemberTaskCenterActivity.this.a(rVar, i3);
                if (MemberTaskCenterActivity.this.type == 2) {
                    TiebaStatic.log(new ar("c11744"));
                }
                if (MemberTaskCenterActivity.this.type == 1) {
                    TiebaStatic.log(new ar("c11745"));
                }
            }
        }
    };
    private c.a lql = new c.a() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.2
        @Override // com.baidu.tieba.memberCenter.memberTask.c.a
        public void bJ(int i, String str) {
            MemberTaskCenterActivity.this.lqh.getListView().setVisibility(8);
            MemberTaskCenterActivity.this.hideLoadingView(MemberTaskCenterActivity.this.lqh.getRootView());
            MemberTaskCenterActivity.this.showNetRefreshView(MemberTaskCenterActivity.this.lqh.getRootView(), str, true);
            MemberTaskCenterActivity.this.setNetRefreshViewEmotionDefMarginTop();
        }

        @Override // com.baidu.tieba.memberCenter.memberTask.c.a
        public void a(List<ImgInfo> list, List<r> list2, long j) {
            MemberTaskCenterActivity.this.lqh.getListView().setVisibility(0);
            MemberTaskCenterActivity.this.hideNetRefreshView(MemberTaskCenterActivity.this.lqh.getRootView());
            MemberTaskCenterActivity.this.hideLoadingView(MemberTaskCenterActivity.this.lqh.getRootView());
            if (list != null && list.size() >= 1 && list.get(0) != null) {
                MemberTaskCenterActivity.this.aIQ = list.get(0).jump_url;
                MemberTaskCenterActivity.this.imageUrl = list.get(0).img_url;
            }
            MemberTaskCenterActivity.this.lqh.a(MemberTaskCenterActivity.this.imageUrl, list2, j);
        }
    };
    private View.OnClickListener jXv = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() == R.id.advert_image_view) {
                    MemberCenterStatic.c(MemberTaskCenterActivity.this.getPageContext(), new String[]{MemberTaskCenterActivity.this.aIQ});
                    MemberTaskCenterActivity.this.lqj = true;
                    TiebaStatic.log(new ar("c11747"));
                } else if (view.getId() == R.id.task_status && (view.getTag() instanceof r)) {
                    r rVar = (r) view.getTag();
                    if (!TbadkCoreApplication.isLogin()) {
                        bh.skipToLoginActivity(MemberTaskCenterActivity.this.getPageContext().getPageActivity());
                    } else if (rVar.getType() == 2) {
                        MemberTaskCenterActivity.this.type = 2;
                        MemberTaskCenterActivity.this.a(rVar);
                    } else if (rVar.getType() == 1) {
                        MemberTaskCenterActivity.this.type = 1;
                        if (MemberTaskCenterActivity.this.lqi != null) {
                            MemberTaskCenterActivity.this.lqi.z(rVar.getId(), rVar.dfw());
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lqh = new d(this, this.jXv);
        this.lqg = new c();
        this.lqg.a(this.lql);
        this.lqi = new a();
        this.lqi.a(this.lqk);
        this.lqg.loadData();
        showLoadingView(this.lqh.getRootView());
    }

    public void a(r rVar, int i) {
        List<r> taskList;
        if (rVar != null && i > 0) {
            if (this.lqg.getTaskList() != null && (taskList = this.lqg.getTaskList()) != null && taskList.size() > 0) {
                Iterator<r> it = taskList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    r next = it.next();
                    if (next != null && next.getId() == rVar.getId()) {
                        next.Ew(rVar.getStatus());
                        break;
                    }
                }
            }
            this.lqh.a(this.imageUrl, this.lqg.getTaskList(), this.lqg.dfy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ex(int i) {
        if (i > 0) {
            if (this.type != 1) {
                if (this.type == 2) {
                    showToast(String.format(getResources().getString(R.string.tips_get_scores_success), Integer.valueOf(i)));
                    return;
                }
                return;
            }
            showToast(String.format(getResources().getString(R.string.tips_get_task_success), Integer.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        showLoadingView(this.lqh.getRootView());
        hideNetRefreshView(this.lqh.getRootView());
        this.lqg.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lqh.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar) {
        if (rVar != null) {
            if (!TbadkCoreApplication.isLogin()) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nx(R.string.tips_login_and_get_scores);
                aVar.a(R.string.login, new a.b() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        bh.skipToLoginActivity(MemberTaskCenterActivity.this.getPageContext().getPageActivity());
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.bqz();
            } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                if (this.lqi != null) {
                    this.lqi.z(rVar.getId(), rVar.dfw());
                }
            } else {
                final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar2.nx(R.string.tips_nomal_member_get_scores);
                aVar2.nz(R.color.CAM_X0305);
                aVar2.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                        aVar2.dismiss();
                        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(MemberTaskCenterActivity.this.getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 0);
                        memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MISSION_CENTER_NATIVE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    }
                });
                aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                        aVar2.dismiss();
                    }
                });
                aVar2.b(getPageContext());
                aVar2.bqz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lqi != null) {
            this.lqi.onDestroy();
        }
        if (this.lqg != null) {
            this.lqg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lqj && j.isNetWorkAvailable()) {
            this.lqj = false;
            this.lqg.loadData();
        }
    }
}
