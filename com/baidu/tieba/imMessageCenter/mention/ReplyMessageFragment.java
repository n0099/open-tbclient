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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.ac;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController jFM;
    private m jFN;
    private boolean jFO;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener jDU = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.jFM != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.jFM.ccH();
                }
            }
        }
    };
    private CustomMessageListener hvd = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.jFO) {
                        if (ReplyMessageFragment.this.jFN != null) {
                            ReplyMessageFragment.this.jFN.rh(true);
                            return;
                        }
                        return;
                    }
                    ReplyMessageFragment.this.jFO = true;
                    ReplyMessageFragment.this.jFN.rh(true);
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView);
                    ReplyMessageFragment.this.jFM.ccH();
                    return;
                }
                ReplyMessageFragment.this.cpa();
            }
        }
    };
    private final CustomMessageListener hUo = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.jFN != null) {
                ReplyMessageFragment.this.jFN.b((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener jFP = new CustomMessageListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010) {
            }
        }
    };
    private ab jFQ = new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
                if (aVar.isNew()) {
                    aVar.rn(false);
                    if (ReplyMessageFragment.this.jFN != null) {
                        ReplyMessageFragment.this.jFN.notifyDataSetChanged();
                    }
                }
                if (aVar.isBjh()) {
                    if (aVar.cJY()) {
                        ReplyMessageFragment.this.d(aVar);
                    } else {
                        ReplyMessageFragment.this.c(aVar);
                    }
                } else if (aVar.cJY()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.cKa() != null) {
                    aq ai = new aq(aVar.cKa()).ai("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jGl) {
                        ai.ai("obj_type", 1);
                    } else {
                        ai.ai("obj_type", 2);
                    }
                    TiebaStatic.log(ai);
                }
                if (aVar != null) {
                    aq aqVar = new aq("c13720");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.dD("tid", aVar.getThread_id());
                    aqVar.dD("fname", aVar.getFname());
                    aqVar.ai("obj_type", 3);
                    TiebaStatic.log(aqVar);
                }
                aq aqVar2 = new aq("c13784");
                aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private ac jFR = new ac() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.7
        @Override // com.baidu.adp.widget.ListView.ac
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
                public void cJD() {
                    ReplyMessageFragment.this.jFN.BY(i);
                    ReplyMessageFragment.this.jFM.BX(i);
                }
            });
            bVar.show();
            return true;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.jDU);
        registerListener(this.hvd);
        cxR();
        this.jFM = new ReplyMeModelController(this);
        this.jFM.aj(bundle);
        this.jFM.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        this.jFN = new m(this);
        this.jFN.bS(this.mRootView);
        this.jFN.e(this.jFQ);
        this.jFN.b(this.jFR);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.jFN.rh(true);
                showLoadingView(this.mRootView);
                this.jFM.ccH();
                this.jFO = true;
            }
        } else {
            this.jFN.rh(true);
            showLoadingView(this.mRootView);
            this.jFM.ccH();
        }
        registerListener(this.hUo);
        registerListener(this.jFP);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jFN.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.jFN != null) {
                this.jFN.onChangeSkinType(i);
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
        MessageManager.getInstance().unRegisterListener(this.jDU);
        MessageManager.getInstance().unRegisterListener(this.hvd);
        MessageManager.getInstance().unRegisterListener(this.hUo);
        MessageManager.getInstance().unRegisterListener(this.jFP);
        if (this.jFN != null) {
            this.jFN.destroy();
        }
        if (this.jFM != null) {
            this.jFM.onDestroy();
        }
    }

    public void cpa() {
        if (this.jFM != null) {
            this.jFM.crr();
        }
    }

    public void cat() {
        if (this.jFM != null) {
            this.jFM.ccI();
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
        if (this.jFN != null) {
            this.jFN.a(errorData);
        }
        showNetRefreshView(this.mRootView, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.jFN != null) {
            this.jFN.rh(true);
            cpa();
        }
    }

    public void b(boolean z, ArrayList<q> arrayList) {
        if (this.jFN != null) {
            hideLoadingView(this.mRootView);
            hideNetRefreshView(this.mRootView);
            this.jFN.a(z, arrayList);
        }
    }

    public void cJX() {
        this.jFN.rh(false);
    }

    private void cxR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.jFN != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageFragment.this.jFN.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
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
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.getThread_id(), aVar.cJZ(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.cJZ(), 0);
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
        if (this.jFN != null) {
            this.jFN.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.jFN != null) {
            this.jFN.onPrimary();
        }
    }
}
