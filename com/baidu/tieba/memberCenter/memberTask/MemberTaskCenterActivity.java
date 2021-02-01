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
/* loaded from: classes9.dex */
public class MemberTaskCenterActivity extends BaseActivity<MemberTaskCenterActivity> {
    private String aHq;
    private String imageUrl;
    private c lnM;
    private d lnN;
    private a lnO;
    private int type;
    private boolean lnP = false;
    private a.InterfaceC0792a lnQ = new a.InterfaceC0792a() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.1
        @Override // com.baidu.tieba.memberCenter.memberTask.a.InterfaceC0792a
        public void a(int i, String str, int i2, int i3, long j) {
            if (i == 0 && MemberTaskCenterActivity.this.lnN != null) {
                MemberTaskCenterActivity.this.Eu(i3);
                r rVar = new r();
                rVar.setTaskId(j);
                if (MemberTaskCenterActivity.this.type == 1 && i2 == 2) {
                    MemberTaskCenterActivity.this.lnM.hj(MemberTaskCenterActivity.this.lnM.dfi() + i3);
                }
                if (MemberTaskCenterActivity.this.type == 2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MEMBER_CENTER_UPDATE_ACTIVE_SCORES, Integer.valueOf(i3)));
                }
                if (i2 >= 1) {
                    i2 = 1;
                }
                rVar.Et(i2);
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
    private c.a lnR = new c.a() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.2
        @Override // com.baidu.tieba.memberCenter.memberTask.c.a
        public void bJ(int i, String str) {
            MemberTaskCenterActivity.this.lnN.getListView().setVisibility(8);
            MemberTaskCenterActivity.this.hideLoadingView(MemberTaskCenterActivity.this.lnN.getRootView());
            MemberTaskCenterActivity.this.showNetRefreshView(MemberTaskCenterActivity.this.lnN.getRootView(), str, true);
            MemberTaskCenterActivity.this.setNetRefreshViewEmotionDefMarginTop();
        }

        @Override // com.baidu.tieba.memberCenter.memberTask.c.a
        public void a(List<ImgInfo> list, List<r> list2, long j) {
            MemberTaskCenterActivity.this.lnN.getListView().setVisibility(0);
            MemberTaskCenterActivity.this.hideNetRefreshView(MemberTaskCenterActivity.this.lnN.getRootView());
            MemberTaskCenterActivity.this.hideLoadingView(MemberTaskCenterActivity.this.lnN.getRootView());
            if (list != null && list.size() >= 1 && list.get(0) != null) {
                MemberTaskCenterActivity.this.aHq = list.get(0).jump_url;
                MemberTaskCenterActivity.this.imageUrl = list.get(0).img_url;
            }
            MemberTaskCenterActivity.this.lnN.a(MemberTaskCenterActivity.this.imageUrl, list2, j);
        }
    };
    private View.OnClickListener jVf = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() == R.id.advert_image_view) {
                    MemberCenterStatic.c(MemberTaskCenterActivity.this.getPageContext(), new String[]{MemberTaskCenterActivity.this.aHq});
                    MemberTaskCenterActivity.this.lnP = true;
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
                        if (MemberTaskCenterActivity.this.lnO != null) {
                            MemberTaskCenterActivity.this.lnO.z(rVar.getId(), rVar.dfg());
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
        this.lnN = new d(this, this.jVf);
        this.lnM = new c();
        this.lnM.a(this.lnR);
        this.lnO = new a();
        this.lnO.a(this.lnQ);
        this.lnM.loadData();
        showLoadingView(this.lnN.getRootView());
    }

    public void a(r rVar, int i) {
        List<r> taskList;
        if (rVar != null && i > 0) {
            if (this.lnM.getTaskList() != null && (taskList = this.lnM.getTaskList()) != null && taskList.size() > 0) {
                Iterator<r> it = taskList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    r next = it.next();
                    if (next != null && next.getId() == rVar.getId()) {
                        next.Et(rVar.getStatus());
                        break;
                    }
                }
            }
            this.lnN.a(this.imageUrl, this.lnM.getTaskList(), this.lnM.dfi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu(int i) {
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
        showLoadingView(this.lnN.getRootView());
        hideNetRefreshView(this.lnN.getRootView());
        this.lnM.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lnN.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar) {
        if (rVar != null) {
            if (!TbadkCoreApplication.isLogin()) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nw(R.string.tips_login_and_get_scores);
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
                aVar.bqx();
            } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                if (this.lnO != null) {
                    this.lnO.z(rVar.getId(), rVar.dfg());
                }
            } else {
                final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar2.nw(R.string.tips_nomal_member_get_scores);
                aVar2.ny(R.color.CAM_X0305);
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
                aVar2.bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lnO != null) {
            this.lnO.onDestroy();
        }
        if (this.lnM != null) {
            this.lnM.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lnP && j.isNetWorkAvailable()) {
            this.lnP = false;
            this.lnM.loadData();
        }
    }
}
