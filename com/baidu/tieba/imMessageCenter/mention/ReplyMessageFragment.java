package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController jig;
    private m jih;
    private boolean jii;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener jgy = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.jig != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.jig.bPj();
                }
            }
        }
    };
    private CustomMessageListener hcu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.jii) {
                        if (ReplyMessageFragment.this.jih != null) {
                            ReplyMessageFragment.this.jih.pY(true);
                            return;
                        }
                        return;
                    }
                    ReplyMessageFragment.this.jii = true;
                    ReplyMessageFragment.this.jih.pY(true);
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView);
                    ReplyMessageFragment.this.jig.bPj();
                    return;
                }
                ReplyMessageFragment.this.caX();
            }
        }
    };
    private final CustomMessageListener hBd = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.jih != null) {
                ReplyMessageFragment.this.jih.a((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener jij = new CustomMessageListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010 && ReplyMessageFragment.this.jih != null) {
                ReplyMessageFragment.this.jih.cvg();
            }
        }
    };
    private z jik = new z() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
                if (aVar.isNew()) {
                    aVar.qa(false);
                    if (ReplyMessageFragment.this.jih != null) {
                        ReplyMessageFragment.this.jih.notifyDataSetChanged();
                    }
                }
                if (aVar.isBjh()) {
                    if (aVar.cvj()) {
                        ReplyMessageFragment.this.d(aVar);
                    } else {
                        ReplyMessageFragment.this.c(aVar);
                    }
                } else if (aVar.cvj()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.cvl() != null) {
                    ao ag = new ao(aVar.cvl()).ag("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jiF) {
                        ag.ag("obj_type", 1);
                    } else {
                        ag.ag("obj_type", 2);
                    }
                    TiebaStatic.log(ag);
                }
                if (aVar != null) {
                    ao aoVar = new ao("c13720");
                    aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                    aoVar.dk("tid", aVar.getThread_id());
                    aoVar.dk("fname", aVar.getFname());
                    aoVar.ag("obj_type", 3);
                    TiebaStatic.log(aoVar);
                }
                ao aoVar2 = new ao("c13784");
                aoVar2.s("uid", TbadkApplication.getCurrentAccountId());
                TiebaStatic.log(aoVar2);
            }
        }
    };
    private aa jil = new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.7
        @Override // com.baidu.adp.widget.ListView.aa
        public boolean b(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, final int i, long j) {
            if (!(qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                return false;
            }
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
            com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar2 = new com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a();
            aVar2.type = 1;
            aVar2.threadId = com.baidu.adp.lib.f.b.toLong(aVar.getThread_id(), 0L);
            aVar2.postId = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
            aVar2.nid = aVar.getBaijiahaoData() != null ? aVar.getBaijiahaoData().oriUgcNid : "";
            com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b bVar = new com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b(ReplyMessageFragment.this.getPageContext());
            bVar.a(aVar2);
            bVar.a(new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.7.1
                @Override // com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.a
                public void cuI() {
                    ReplyMessageFragment.this.jih.zg(i);
                    ReplyMessageFragment.this.jig.zd(i);
                }
            });
            bVar.show();
            return true;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.jgy);
        registerListener(this.hcu);
        cjA();
        this.jig = new ReplyMeModelController(this);
        this.jig.aj(bundle);
        this.jig.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        this.jih = new m(this);
        this.jih.bV(this.mRootView);
        this.jih.e(this.jik);
        this.jih.b(this.jil);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.jih.pY(true);
                showLoadingView(this.mRootView);
                this.jig.bPj();
                this.jii = true;
            }
        } else {
            this.jih.pY(true);
            showLoadingView(this.mRootView);
            this.jig.bPj();
        }
        registerListener(this.hBd);
        registerListener(this.jij);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jih.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.jih != null) {
                this.jih.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
        MessageManager.getInstance().unRegisterListener(this.jgy);
        MessageManager.getInstance().unRegisterListener(this.hcu);
        MessageManager.getInstance().unRegisterListener(this.hBd);
        MessageManager.getInstance().unRegisterListener(this.jij);
        if (this.jih != null) {
            this.jih.destroy();
        }
        if (this.jig != null) {
            this.jig.onDestroy();
        }
    }

    public void caX() {
        if (this.jig != null) {
            this.jig.cdm();
        }
    }

    public void bMW() {
        if (this.jig != null) {
            this.jig.bPk();
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (this.jih != null) {
            this.jih.a(errorData);
        }
        showNetRefreshView(this.mRootView, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.jih != null) {
            this.jih.pY(true);
            caX();
        }
    }

    public void b(boolean z, ArrayList<q> arrayList) {
        if (this.jih != null) {
            hideLoadingView(this.mRootView);
            hideNetRefreshView(this.mRootView);
            this.jih.a(z, arrayList);
        }
    }

    public void cvi() {
        this.jih.pY(false);
    }

    private void cjA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.jih != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageFragment.this.jih.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setBjhData(aVar.getBaijiahaoData());
            createNormalCfg.setHighLightPostId(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.getThread_id(), aVar.getPost_id(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.getPost_id(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            createSubPbActivityConfig.setHighLightPostId(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.getThread_id(), aVar.getPost_id(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.getPost_id(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(aVar.getPost_id());
            createSubPbActivityConfig.setKeyOriUgcTopPid("0");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.getThread_id(), aVar.cvk(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.cvk(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(aVar.getPost_id());
            createSubPbActivityConfig.setKeyOriUgcTopPid(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jih != null) {
            this.jih.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.jih != null) {
            this.jih.onPrimary();
        }
    }
}
