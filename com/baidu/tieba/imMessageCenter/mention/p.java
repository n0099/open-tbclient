package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class p extends BaseFragment implements NoNetworkView.a {
    private ReplyMeModelController eTD;
    private o eTE;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private CustomMessageListener eSu = new CustomMessageListener(2016321) { // from class: com.baidu.tieba.imMessageCenter.mention.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (p.this.eTD != null) {
                    p.this.showLoadingView(p.this.mRootView, true);
                    p.this.eTD.amM();
                }
            }
        }
    };
    private final CustomMessageListener dFw = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.mention.p.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && p.this.eTE != null) {
                p.this.eTE.b((NewsNotifyMessage) customResponsedMessage);
            }
        }
    };
    private final CustomMessageListener eTF = new CustomMessageListener(2016010) { // from class: com.baidu.tieba.imMessageCenter.mention.p.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016010 && p.this.eTE != null) {
                p.this.eTE.aNJ();
            }
        }
    };
    private com.baidu.adp.widget.ListView.o eTG = new com.baidu.adp.widget.ListView.o() { // from class: com.baidu.tieba.imMessageCenter.mention.p.4
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, com.baidu.adp.widget.ListView.i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (iVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) iVar;
                if (aVar.isNew()) {
                    aVar.il(false);
                    if (p.this.eTE != null) {
                        p.this.eTE.notifyDataSetChanged();
                    }
                }
                if (aVar.aNO()) {
                    p.this.b(aVar);
                } else {
                    p.this.a(aVar);
                }
                if (aVar.aNQ() != null) {
                    ak s = new ak(aVar.aNQ()).s("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eUa) {
                        s.s("obj_type", 1);
                    } else {
                        s.s("obj_type", 2);
                    }
                    TiebaStatic.log(s);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        registerListener(this.eSu);
        aNN();
        this.eTD = new ReplyMeModelController(this);
        this.eTD.l(bundle);
        this.eTD.setUniqueId(getUniqueId());
        this.mRootView = (ViewGroup) layoutInflater.inflate(d.h.reply_me_activity, viewGroup, false);
        this.eTE = new o(this);
        this.eTE.onCreateView(this.mRootView);
        this.eTE.d(this.eTG);
        this.eTE.ik(true);
        showLoadingView(this.mRootView);
        this.eTD.amM();
        registerListener(this.dFw);
        registerListener(this.eTF);
        return this.mRootView;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.eTE.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eTE != null) {
                this.eTE.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bu(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(2016322);
    }

    public void aNK() {
        if (this.eTD != null) {
            this.eTD.aNs();
        }
    }

    public void aNL() {
        if (this.eTD != null) {
            this.eTD.amN();
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(d.j.im_error_default);
            }
        }
        if (this.eTE != null) {
            this.eTE.a(errorData);
        }
    }

    public void b(boolean z, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (this.eTE != null) {
            hideLoadingView(this.mRootView);
            this.eTE.a(z, arrayList);
        }
    }

    public void aNM() {
        this.eTE.ik(false);
    }

    private void aNN() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.p.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return p.this.eTE != null ? new CustomResponsedMessage<>(2016322, Boolean.valueOf(p.this.eTE.onBackPressed())) : new CustomResponsedMessage<>(2016322, false);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (aVar.getThreadType() == 33) {
                TiebaStatic.log("c10384");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(getPageContext().getContext(), aVar.getThread_id()).cP(aVar.getPost_id()).cQ("mention").xD()));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (aVar.getThreadType() == 33) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveCommentActivityConfig(getPageContext().getContext()).createPhotoLiveCommentActivityConfig(aVar.getThread_id(), aVar.getPost_id(), false)));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.getThread_id(), aVar.getPost_id(), "mention", false, aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName(), false, aVar.getPost_id(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(12);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
        }
    }
}
