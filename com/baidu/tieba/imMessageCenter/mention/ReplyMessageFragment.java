package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController kSO;
    private m kSP;
    private boolean kSQ;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener kQW = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.kSO != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.kSO.ctl();
                }
            }
        }
    };
    private CustomMessageListener iIU = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.kSQ) {
                        if (ReplyMessageFragment.this.kSP != null) {
                            ReplyMessageFragment.this.kSP.tn(true);
                            return;
                        }
                        return;
                    }
                    ReplyMessageFragment.this.kSQ = true;
                    ReplyMessageFragment.this.kSP.tn(true);
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView);
                    ReplyMessageFragment.this.kSO.ctl();
                    return;
                }
                ReplyMessageFragment.this.cFL();
            }
        }
    };
    private final CustomMessageListener jhV = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.kSP != null) {
                ReplyMessageFragment.this.kSP.b((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener kSR = new CustomMessageListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010) {
            }
        }
    };
    private w kSS = new w() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) nVar;
                if (aVar.isNew()) {
                    aVar.tt(false);
                    if (ReplyMessageFragment.this.kSP != null) {
                        ReplyMessageFragment.this.kSP.notifyDataSetChanged();
                    }
                }
                if (aVar.isBjh()) {
                    if (aVar.cZH()) {
                        ReplyMessageFragment.this.d(aVar);
                    } else {
                        ReplyMessageFragment.this.c(aVar);
                    }
                } else if (aVar.cZH()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.cZJ() != null) {
                    ar ap = new ar(aVar.cZJ()).ap("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kTn) {
                        ap.ap("obj_type", 1);
                    } else {
                        ap.ap("obj_type", 2);
                    }
                    TiebaStatic.log(ap);
                }
                if (aVar != null) {
                    ar arVar = new ar("c13720");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar.dR("tid", aVar.getThread_id());
                    arVar.dR("fname", aVar.getFname());
                    arVar.ap("obj_type", 3);
                    TiebaStatic.log(arVar);
                }
                ar arVar2 = new ar("c13784");
                arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                TiebaStatic.log(arVar2);
            }
        }
    };
    private x kST = new x() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.7
        @Override // com.baidu.adp.widget.ListView.x
        public boolean b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, final int i, long j) {
            if (!(nVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                return false;
            }
            com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) nVar;
            com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar2 = new com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a();
            aVar2.type = 1;
            aVar2.threadId = com.baidu.adp.lib.f.b.toLong(aVar.getThread_id(), 0L);
            aVar2.postId = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
            aVar2.nid = aVar.getBaijiahaoData() != null ? aVar.getBaijiahaoData().oriUgcNid : "";
            com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b bVar = new com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b(ReplyMessageFragment.this.getPageContext());
            bVar.a(aVar2);
            bVar.a(new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.7.1
                @Override // com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.a
                public void cZk() {
                    ReplyMessageFragment.this.kSP.DB(i);
                    ReplyMessageFragment.this.kSO.DA(i);
                }
            });
            bVar.show();
            return true;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.kQW);
        registerListener(this.iIU);
        cRi();
        this.kSO = new ReplyMeModelController(this);
        this.kSO.aj(bundle);
        this.kSO.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        this.kSP = new m(this);
        this.kSP.cj(this.mRootView);
        this.kSP.e(this.kSS);
        this.kSP.b(this.kST);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.kSP.tn(false);
                showLoadingView(this.mRootView);
                this.kSO.ctl();
                this.kSQ = true;
            }
        } else {
            this.kSP.tn(false);
            showLoadingView(this.mRootView);
            this.kSO.ctl();
        }
        registerListener(this.jhV);
        registerListener(this.kSR);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kSP.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.kSP != null) {
                this.kSP.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
        MessageManager.getInstance().unRegisterListener(this.kQW);
        MessageManager.getInstance().unRegisterListener(this.iIU);
        MessageManager.getInstance().unRegisterListener(this.jhV);
        MessageManager.getInstance().unRegisterListener(this.kSR);
        if (this.kSP != null) {
            this.kSP.destroy();
        }
        if (this.kSO != null) {
            this.kSO.onDestroy();
        }
    }

    public void cFL() {
        if (this.kSO != null) {
            this.kSO.cJh();
        }
    }

    public void cqU() {
        if (this.kSO != null) {
            this.kSO.ctm();
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
        if (this.kSP != null) {
            this.kSP.a(errorData);
        }
        if (this.kSP != null && this.kSP.cZF() != null) {
            this.kSP.cZF().setVisibility(8);
        }
        showNetRefreshView(this.mRootView, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.kSP != null) {
            this.kSP.tn(true);
            cFL();
        }
    }

    public void b(boolean z, ArrayList<n> arrayList) {
        if (this.kSP != null) {
            hideLoadingView(this.mRootView);
            hideNetRefreshView(this.mRootView);
            this.kSP.a(z, arrayList);
        }
    }

    public void cZG() {
        this.kSP.tn(false);
    }

    private void cRi() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.kSP != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageFragment.this.kSP.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
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
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.getThread_id(), aVar.cZI(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.cZI(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(aVar.getPost_id());
            createSubPbActivityConfig.setKeyOriUgcTopPid(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.kSP != null) {
            this.kSP.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.kSP != null) {
            this.kSP.onPrimary();
        }
    }
}
