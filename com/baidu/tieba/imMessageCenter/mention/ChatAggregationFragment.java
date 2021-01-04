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
/* loaded from: classes2.dex */
public class ChatAggregationFragment extends BaseFragment implements NoNetworkView.a, com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter kNj;
    private e kNm;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (ChatAggregationFragment.this.kNm != null) {
                    ChatAggregationFragment.this.kNm.tg(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (ChatAggregationFragment.this.kNm != null) {
                    ChatAggregationFragment.this.kNm.cNw();
                    ChatAggregationFragment.this.kNm.al(TbadkCoreApplication.isLogin(), TbadkCoreApplication.isLogin() ? false : true);
                }
            }
        }
    };
    private CustomMessageListener kNk = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ChatAggregationFragment.this.kNm != null) {
                    ChatAggregationFragment.this.kNm.onNewIntent(intent);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kNm = new e(this);
        if (bundle != null) {
            this.kNm.as(bundle);
        } else {
            this.kNm.as(null);
        }
        View bYm = this.kNm.bYm();
        this.kNm.b(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        bHi().addEventDelegate(this);
        registerListener(this.mAccountChangedListener);
        registerListener(this.kNk);
        return bYm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && Y(getActivity().getIntent())) {
            this.kNm.onNewIntent(getActivity().getIntent());
        } else {
            this.kNm.cNw();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean Y(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bGM() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter bHi() {
        if (this.kNj == null) {
            this.kNj = new ViewEventCenter();
        }
        return this.kNj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.kNm != null) {
            this.kNm.b(getPageContext(), i);
        }
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        MessageManager.getInstance().unRegisterListener(this.kNk);
        if (this.kNm != null) {
            this.kNm.cLD();
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.kNm != null) {
            this.kNm.td(z);
        }
    }

    public void WE() {
        if (this.kNm != null) {
            this.kNm.WE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.kNm != null) {
            this.kNm.daX();
        }
    }
}
