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
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController gXb;
    private m gXc;
    private boolean gXd;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener gVE = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.gXb != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.gXb.bbK();
                }
            }
        }
    };
    private CustomMessageListener fbB = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REFRESH_REPLY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.gXd) {
                        if (ReplyMessageFragment.this.gXc != null) {
                            ReplyMessageFragment.this.gXc.mH(true);
                            return;
                        }
                        return;
                    }
                    ReplyMessageFragment.this.gXd = true;
                    ReplyMessageFragment.this.gXc.mH(true);
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView);
                    ReplyMessageFragment.this.gXb.bbK();
                    return;
                }
                ReplyMessageFragment.this.bmA();
            }
        }
    };
    private final CustomMessageListener fwF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.gXc != null) {
                ReplyMessageFragment.this.gXc.a((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener gXe = new CustomMessageListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010 && ReplyMessageFragment.this.gXc != null) {
                ReplyMessageFragment.this.gXc.bFS();
            }
        }
    };
    private s gXf = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                if (aVar.isNew()) {
                    aVar.mI(false);
                    if (ReplyMessageFragment.this.gXc != null) {
                        ReplyMessageFragment.this.gXc.notifyDataSetChanged();
                    }
                }
                if (aVar.bFU()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.bFW() != null) {
                    an O = new an(aVar.bFW()).O("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gXz) {
                        O.O("obj_type", 1);
                    } else {
                        O.O("obj_type", 2);
                    }
                    TiebaStatic.log(O);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.gVE);
        registerListener(this.fbB);
        buJ();
        this.gXb = new ReplyMeModelController(this);
        this.gXb.K(bundle);
        this.gXb.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        this.gXc = new m(this);
        this.gXc.bz(this.mRootView);
        this.gXc.e(this.gXf);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.gXc.mH(true);
                showLoadingView(this.mRootView);
                this.gXb.bbK();
                this.gXd = true;
            }
        } else {
            this.gXc.mH(true);
            showLoadingView(this.mRootView);
            this.gXb.bbK();
        }
        registerListener(this.fwF);
        registerListener(this.gXe);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gXc.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gXc != null) {
                this.gXc.onChangeSkinType(i);
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
        MessageManager.getInstance().unRegisterListener(this.gVE);
        MessageManager.getInstance().unRegisterListener(this.fbB);
        MessageManager.getInstance().unRegisterListener(this.fwF);
        MessageManager.getInstance().unRegisterListener(this.gXe);
        if (this.gXc != null) {
            this.gXc.destroy();
        }
        if (this.gXb != null) {
            this.gXb.onDestroy();
        }
    }

    public void bmA() {
        if (this.gXb != null) {
            this.gXb.boL();
        }
    }

    public void aYY() {
        if (this.gXb != null) {
            this.gXb.bbL();
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
        if (this.gXc != null) {
            this.gXc.a(errorData);
        }
    }

    public void b(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.gXc != null) {
            hideLoadingView(this.mRootView);
            this.gXc.a(z, arrayList);
        }
    }

    public void bFT() {
        this.gXc.mH(false);
    }

    private void buJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.gXc != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageFragment.this.gXc.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gXc != null) {
            this.gXc.onBackPressed();
        }
    }
}
