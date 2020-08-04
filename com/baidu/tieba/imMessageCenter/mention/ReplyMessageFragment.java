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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController jqO;
    private m jqP;
    private boolean jqQ;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener joW = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.jqO != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.jqO.bSv();
                }
            }
        }
    };
    private CustomMessageListener hie = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.jqQ) {
                        if (ReplyMessageFragment.this.jqP != null) {
                            ReplyMessageFragment.this.jqP.qB(true);
                            return;
                        }
                        return;
                    }
                    ReplyMessageFragment.this.jqQ = true;
                    ReplyMessageFragment.this.jqP.qB(true);
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView);
                    ReplyMessageFragment.this.jqO.bSv();
                    return;
                }
                ReplyMessageFragment.this.cew();
            }
        }
    };
    private final CustomMessageListener hGY = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.jqP != null) {
                ReplyMessageFragment.this.jqP.b((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener jqR = new CustomMessageListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010) {
            }
        }
    };
    private z jqS = new z() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
                if (aVar.isNew()) {
                    aVar.qH(false);
                    if (ReplyMessageFragment.this.jqP != null) {
                        ReplyMessageFragment.this.jqP.notifyDataSetChanged();
                    }
                }
                if (aVar.isBjh()) {
                    if (aVar.czh()) {
                        ReplyMessageFragment.this.d(aVar);
                    } else {
                        ReplyMessageFragment.this.c(aVar);
                    }
                } else if (aVar.czh()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.czj() != null) {
                    ap ah = new ap(aVar.czj()).ah("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jrn) {
                        ah.ah("obj_type", 1);
                    } else {
                        ah.ah("obj_type", 2);
                    }
                    TiebaStatic.log(ah);
                }
                if (aVar != null) {
                    ap apVar = new ap("c13720");
                    apVar.t("uid", TbadkApplication.getCurrentAccountId());
                    apVar.dn("tid", aVar.getThread_id());
                    apVar.dn("fname", aVar.getFname());
                    apVar.ah("obj_type", 3);
                    TiebaStatic.log(apVar);
                }
                ap apVar2 = new ap("c13784");
                apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                TiebaStatic.log(apVar2);
            }
        }
    };
    private aa jqT = new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.7
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
                public void cyM() {
                    ReplyMessageFragment.this.jqP.zF(i);
                    ReplyMessageFragment.this.jqO.zE(i);
                }
            });
            bVar.show();
            return true;
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.joW);
        registerListener(this.hie);
        cnc();
        this.jqO = new ReplyMeModelController(this);
        this.jqO.ak(bundle);
        this.jqO.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        this.jqP = new m(this);
        this.jqP.bW(this.mRootView);
        this.jqP.e(this.jqS);
        this.jqP.b(this.jqT);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.jqP.qB(true);
                showLoadingView(this.mRootView);
                this.jqO.bSv();
                this.jqQ = true;
            }
        } else {
            this.jqP.qB(true);
            showLoadingView(this.mRootView);
            this.jqO.bSv();
        }
        registerListener(this.hGY);
        registerListener(this.jqR);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jqP.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.jqP != null) {
                this.jqP.onChangeSkinType(i);
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
        MessageManager.getInstance().unRegisterListener(this.joW);
        MessageManager.getInstance().unRegisterListener(this.hie);
        MessageManager.getInstance().unRegisterListener(this.hGY);
        MessageManager.getInstance().unRegisterListener(this.jqR);
        if (this.jqP != null) {
            this.jqP.destroy();
        }
        if (this.jqO != null) {
            this.jqO.onDestroy();
        }
    }

    public void cew() {
        if (this.jqO != null) {
            this.jqO.cgM();
        }
    }

    public void bQi() {
        if (this.jqO != null) {
            this.jqO.bSw();
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
        if (this.jqP != null) {
            this.jqP.a(errorData);
        }
        showNetRefreshView(this.mRootView, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.jqP != null) {
            this.jqP.qB(true);
            cew();
        }
    }

    public void b(boolean z, ArrayList<q> arrayList) {
        if (this.jqP != null) {
            hideLoadingView(this.mRootView);
            hideNetRefreshView(this.mRootView);
            this.jqP.a(z, arrayList);
        }
    }

    public void czg() {
        this.jqP.qB(false);
    }

    private void cnc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.jqP != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageFragment.this.jqP.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
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
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.getThread_id(), aVar.czi(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.czi(), 0);
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
        if (this.jqP != null) {
            this.jqP.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.jqP != null) {
            this.jqP.onPrimary();
        }
    }
}
