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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes9.dex */
public class ChatAggregationFragment extends BaseFragment implements NoNetworkView.a, com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter hQd;
    private e hQg;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (ChatAggregationFragment.this.hQg != null) {
                    ChatAggregationFragment.this.hQg.ok(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (ChatAggregationFragment.this.hQg != null) {
                    ChatAggregationFragment.this.hQg.bKE();
                    ChatAggregationFragment.this.hQg.W(TbadkCoreApplication.isLogin(), TbadkCoreApplication.isLogin() ? false : true);
                }
            }
        }
    };
    private CustomMessageListener hQe = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ChatAggregationFragment.this.hQg != null) {
                    ChatAggregationFragment.this.hQg.onNewIntent(intent);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.hQg = new e(this);
        if (bundle != null) {
            this.hQg.aj(bundle);
        } else {
            this.hQg.aj(null);
        }
        View beY = this.hQg.beY();
        this.hQg.b(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        aQU().addEventDelegate(this);
        registerListener(this.mAccountChangedListener);
        registerListener(this.hQe);
        return beY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && aq(getActivity().getIntent())) {
            this.hQg.onNewIntent(getActivity().getIntent());
        } else {
            this.hQg.bKE();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean aq(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean aQr() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter aQU() {
        if (this.hQd == null) {
            this.hQd = new ViewEventCenter();
        }
        return this.hQd;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hQg != null) {
            this.hQg.b(getPageContext(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_CHAT_SELECT /* 12011 */:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString("name_show");
                    String string4 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, string4, 0)));
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
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        MessageManager.getInstance().unRegisterListener(this.hQe);
        if (this.hQg != null) {
            this.hQg.aiL();
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hQg != null) {
            this.hQg.oi(z);
        }
    }
}
