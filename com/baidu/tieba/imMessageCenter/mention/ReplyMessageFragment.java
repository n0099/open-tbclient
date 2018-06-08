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
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController eAI;
    private m eAJ;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener ezi = new CustomMessageListener(2016321) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.eAI != null) {
                    ReplyMessageFragment.this.showLoadingView(ReplyMessageFragment.this.mRootView, true);
                    ReplyMessageFragment.this.eAI.aks();
                }
            }
        }
    };
    private CustomMessageListener eAK = new CustomMessageListener(2001628) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                    if (ReplyMessageFragment.this.eAJ != null) {
                        ReplyMessageFragment.this.eAJ.hU(true);
                        return;
                    }
                    return;
                }
                ReplyMessageFragment.this.aNG();
            }
        }
    };
    private final CustomMessageListener diF = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.eAJ != null) {
                ReplyMessageFragment.this.eAJ.a((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener eAL = new CustomMessageListener(2016010) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010 && ReplyMessageFragment.this.eAJ != null) {
                ReplyMessageFragment.this.eAJ.aNF();
            }
        }
    };
    private n eAM = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                if (aVar.isNew()) {
                    aVar.hV(false);
                    if (ReplyMessageFragment.this.eAJ != null) {
                        ReplyMessageFragment.this.eAJ.notifyDataSetChanged();
                    }
                }
                if (aVar.aNK()) {
                    ReplyMessageFragment.this.b(aVar);
                } else {
                    ReplyMessageFragment.this.a(aVar);
                }
                if (aVar.aNM() != null) {
                    am r = new am(aVar.aNM()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eBg) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.ezi);
        registerListener(this.eAK);
        aNJ();
        this.eAI = new ReplyMeModelController(this);
        this.eAI.i(bundle);
        this.eAI.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(d.i.reply_me_activity, viewGroup, false);
        this.eAJ = new m(this);
        this.eAJ.onCreateView(this.mRootView);
        this.eAJ.d(this.eAM);
        this.eAJ.hU(true);
        showLoadingView(this.mRootView);
        this.eAI.aks();
        registerListener(this.diF);
        registerListener(this.eAL);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.eAJ.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eAJ != null) {
                this.eAJ.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(2016322);
        MessageManager.getInstance().unRegisterListener(this.ezi);
        MessageManager.getInstance().unRegisterListener(this.eAK);
        MessageManager.getInstance().unRegisterListener(this.diF);
        MessageManager.getInstance().unRegisterListener(this.eAL);
        if (this.eAJ != null) {
            this.eAJ.destroy();
        }
        if (this.eAI != null) {
            this.eAI.onDestroy();
        }
    }

    public void aNG() {
        if (this.eAI != null) {
            this.eAI.avn();
        }
    }

    public void aNH() {
        if (this.eAI != null) {
            this.eAI.akt();
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(d.k.im_error_default);
            }
        }
        if (this.eAJ != null) {
            this.eAJ.a(errorData);
        }
    }

    public void b(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.eAJ != null) {
            hideLoadingView(this.mRootView);
            this.eAJ.a(z, arrayList);
        }
    }

    public void aNI() {
        this.eAJ.hU(false);
    }

    private void aNJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageFragment.this.eAJ != null ? new CustomResponsedMessage<>(2016322, Boolean.valueOf(ReplyMessageFragment.this.eAJ.onBackPressed())) : new CustomResponsedMessage<>(2016322, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.getThread_id(), aVar.getPost_id(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.getPost_id(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eAJ != null) {
            this.eAJ.onBackPressed();
        }
    }
}
