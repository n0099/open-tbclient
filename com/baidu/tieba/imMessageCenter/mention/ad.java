package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class ad extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter dmJ;
    private l dmW;
    private boolean dmX = false;
    private CustomMessageListener dmY = new ae(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener dmK = new af(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dmW = new l(this);
        if (bundle != null) {
            this.dmW.h(bundle);
            this.dmW.h(bundle);
        } else {
            this.dmW.h((Bundle) null);
            this.dmW.h((Bundle) null);
        }
        View Vr = this.dmW.Vr();
        this.dmW.gF(this.dmX);
        this.dmW.b(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        FU().addEventDelegate(this);
        registerListener(this.dmY);
        registerListener(this.dmK);
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11941"));
        return Vr;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && P(getActivity().getIntent())) {
            this.dmW.onNewIntent(getActivity().getIntent());
        } else {
            this.dmW.acF();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean P(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return bVar == null;
    }

    public ViewEventCenter FU() {
        if (this.dmJ == null) {
            this.dmJ = new ViewEventCenter();
        }
        return this.dmJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dmW != null) {
            this.dmW.b(getPageContext(), i);
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
        super.onDestroy();
        this.dmW.onActivityDestroy();
    }

    public void gG(boolean z) {
        this.dmX = z;
    }
}
