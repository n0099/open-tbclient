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
    private e dJK;
    private ViewEventCenter dJx;
    private boolean dJL = false;
    private CustomMessageListener dJM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.imMessageCenter.mention.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (g.this.dJK != null) {
                    g.this.dJK.gV(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (g.this.dJK != null) {
                    g.this.dJK.ajr();
                    g.this.dJK.C(TbadkCoreApplication.isLogin(), TbadkCoreApplication.isLogin() ? false : true);
                }
            }
        }
    };
    private CustomMessageListener dJy = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (g.this.dJK != null) {
                    g.this.dJK.onNewIntent(intent);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dJK = new e(this);
        if (bundle != null) {
            this.dJK.l(bundle);
        } else {
            this.dJK.l((Bundle) null);
        }
        View Ze = this.dJK.Ze();
        this.dJK.gX(this.dJL);
        this.dJK.b(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        Fk().addEventDelegate(this);
        registerListener(this.dJM);
        registerListener(this.dJy);
        TiebaStatic.log(new ak("c11941"));
        return Ze;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && Q(getActivity().getIntent())) {
            this.dJK.onNewIntent(getActivity().getIntent());
        } else {
            this.dJK.ajr();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean Q(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EB() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter Fk() {
        if (this.dJx == null) {
            this.dJx = new ViewEventCenter();
        }
        return this.dJx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dJK != null) {
            this.dJK.b(getPageContext(), i);
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
        this.dJK.onActivityDestroy();
    }

    public void gY(boolean z) {
        this.dJL = z;
    }
}
