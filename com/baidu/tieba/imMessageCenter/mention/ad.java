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
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
public class ad extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter dmj;
    private l dmw;
    private boolean dmx = false;
    private CustomMessageListener dmy = new ae(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener dmk = new af(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dmw = new l(this);
        if (bundle != null) {
            this.dmw.h(bundle);
            this.dmw.h(bundle);
        } else {
            this.dmw.h((Bundle) null);
            this.dmw.h((Bundle) null);
        }
        View VN = this.dmw.VN();
        this.dmw.gt(this.dmx);
        this.dmw.b(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        ES().addEventDelegate(this);
        registerListener(this.dmy);
        registerListener(this.dmk);
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11941"));
        return VN;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && R(getActivity().getIntent())) {
            this.dmw.onNewIntent(getActivity().getIntent());
        } else {
            this.dmw.abW();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean R(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Ei() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter ES() {
        if (this.dmj == null) {
            this.dmj = new ViewEventCenter();
        }
        return this.dmj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dmw != null) {
            this.dmw.b(getPageContext(), i);
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
        this.dmw.onActivityDestroy();
    }

    public void gu(boolean z) {
        this.dmx = z;
    }
}
