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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
public class g extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private e dMM;
    private ViewEventCenter dMz;
    private boolean dMN = false;
    private CustomMessageListener dMO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (g.this.dMM != null) {
                    g.this.dMM.hi(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (g.this.dMM != null) {
                    g.this.dMM.ajg();
                    g.this.dMM.B(TbadkCoreApplication.isLogin(), TbadkCoreApplication.isLogin() ? false : true);
                }
            }
        }
    };
    private CustomMessageListener dMA = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (g.this.dMM != null) {
                    g.this.dMM.onNewIntent(intent);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dMM = new e(this);
        if (bundle != null) {
            this.dMM.l(bundle);
        } else {
            this.dMM.l((Bundle) null);
        }
        View Zm = this.dMM.Zm();
        this.dMM.hk(this.dMN);
        this.dMM.b(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        FL().addEventDelegate(this);
        registerListener(this.dMO);
        registerListener(this.dMA);
        TiebaStatic.log(new ak("c11941"));
        return Zm;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && V(getActivity().getIntent())) {
            this.dMM.onNewIntent(getActivity().getIntent());
        } else {
            this.dMM.ajg();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean V(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fc() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter FL() {
        if (this.dMz == null) {
            this.dMz = new ViewEventCenter();
        }
        return this.dMz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dMM != null) {
            this.dMM.b(getPageContext(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString(IntentConfig.PORTRAIT);
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, 0)));
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_NOTIFY_MSG, false));
        super.onDestroy();
        this.dMM.onActivityDestroy();
    }

    public void hl(boolean z) {
        this.dMN = z;
    }
}
