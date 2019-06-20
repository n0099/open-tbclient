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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController gQe;
    private m gQf;
    private boolean gQg;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener gOH = new CustomMessageListener(2016321) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.gQe != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.gQe.aZa();
                }
            }
        }
    };
    private CustomMessageListener eSa = new CustomMessageListener(2001628) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.gQg) {
                        if (ReplyMessageFragment.this.gQf != null) {
                            ReplyMessageFragment.this.gQf.mC(true);
                            return;
                        }
                        return;
                    }
                    ReplyMessageFragment.this.gQg = true;
                    ReplyMessageFragment.this.gQf.mC(true);
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView);
                    ReplyMessageFragment.this.gQe.aZa();
                    return;
                }
                ReplyMessageFragment.this.bmw();
            }
        }
    };
    private final CustomMessageListener fqh = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.gQf != null) {
                ReplyMessageFragment.this.gQf.a((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener gQh = new CustomMessageListener(2016010) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010 && ReplyMessageFragment.this.gQf != null) {
                ReplyMessageFragment.this.gQf.bFz();
            }
        }
    };
    private s gQi = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                if (aVar.isNew()) {
                    aVar.mD(false);
                    if (ReplyMessageFragment.this.gQf != null) {
                        ReplyMessageFragment.this.gQf.notifyDataSetChanged();
                    }
                }
                if (aVar.bFB()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.bFD() != null) {
                    am P = new am(aVar.bFD()).P("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gQC) {
                        P.P("obj_type", 1);
                    } else {
                        P.P("obj_type", 2);
                    }
                    TiebaStatic.log(P);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.gOH);
        registerListener(this.eSa);
        btY();
        this.gQe = new ReplyMeModelController(this);
        this.gQe.K(bundle);
        this.gQe.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        this.gQf = new m(this);
        this.gQf.onCreateView(this.mRootView);
        this.gQf.d(this.gQi);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.gQf.mC(true);
                showLoadingView(this.mRootView);
                this.gQe.aZa();
                this.gQg = true;
            }
        } else {
            this.gQf.mC(true);
            showLoadingView(this.mRootView);
            this.gQe.aZa();
        }
        registerListener(this.fqh);
        registerListener(this.gQh);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.gQf.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gQf != null) {
                this.gQf.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(2016322);
        MessageManager.getInstance().unRegisterListener(this.gOH);
        MessageManager.getInstance().unRegisterListener(this.eSa);
        MessageManager.getInstance().unRegisterListener(this.fqh);
        MessageManager.getInstance().unRegisterListener(this.gQh);
        if (this.gQf != null) {
            this.gQf.destroy();
        }
        if (this.gQe != null) {
            this.gQe.onDestroy();
        }
    }

    public void bmw() {
        if (this.gQe != null) {
            this.gQe.boI();
        }
    }

    public void aWs() {
        if (this.gQe != null) {
            this.gQe.aZb();
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
        if (this.gQf != null) {
            this.gQf.a(errorData);
        }
    }

    public void b(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.gQf != null) {
            hideLoadingView(this.mRootView);
            this.gQf.a(z, arrayList);
        }
    }

    public void bFA() {
        this.gQf.mC(false);
    }

    private void btY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.gQf != null ? new CustomResponsedMessage<>(2016322, Boolean.valueOf(ReplyMessageFragment.this.gQf.onBackPressed())) : new CustomResponsedMessage<>(2016322, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.getThread_id(), aVar.getPost_id(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.getPost_id(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            createSubPbActivityConfig.setHighLightPostId(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gQf != null) {
            this.gQf.onBackPressed();
        }
    }
}
