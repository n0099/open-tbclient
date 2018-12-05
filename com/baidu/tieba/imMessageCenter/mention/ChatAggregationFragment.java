package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes4.dex */
public class ChatAggregationFragment extends BaseFragment implements NoNetworkView.a, com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter fdR;
    private e fdU;
    private CustomMessageListener bQv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (ChatAggregationFragment.this.fdU != null) {
                    ChatAggregationFragment.this.fdU.jf(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (ChatAggregationFragment.this.fdU != null) {
                    ChatAggregationFragment.this.fdU.aEb();
                    ChatAggregationFragment.this.fdU.K(TbadkCoreApplication.isLogin(), TbadkCoreApplication.isLogin() ? false : true);
                }
            }
        }
    };
    private CustomMessageListener fdS = new CustomMessageListener(2016321) { // from class: com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ChatAggregationFragment.this.fdU != null) {
                    ChatAggregationFragment.this.fdU.onNewIntent(intent);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fdU = new e(this);
        if (bundle != null) {
            this.fdU.t(bundle);
        } else {
            this.fdU.t(null);
        }
        View acb = this.fdU.acb();
        this.fdU.b(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        OL().addEventDelegate(this);
        registerListener(this.bQv);
        registerListener(this.fdS);
        return acb;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && T(getActivity().getIntent())) {
            this.fdU.onNewIntent(getActivity().getIntent());
        } else {
            this.fdU.aEb();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean T(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Oc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter OL() {
        if (this.fdR == null) {
            this.fdR = new ViewEventCenter();
        }
        return this.fdR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fdU != null) {
            this.fdU.b(getPageContext(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE /* 12011 */:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString("name_show");
                    String string4 = extras.getString(IntentConfig.PORTRAIT);
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, string4, 0)));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bQv);
        MessageManager.getInstance().unRegisterListener(this.fdS);
        if (this.fdU != null) {
            this.fdU.onActivityDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bF(boolean z) {
        if (this.fdU != null) {
            this.fdU.jd(z);
        }
    }
}
