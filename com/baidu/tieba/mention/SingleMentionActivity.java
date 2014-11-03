package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public class SingleMentionActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.voice.o {
    VoiceManager ayx;
    r boj;
    private boolean bok;
    private CustomMessageListener bol = new ap(this, 2001229);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SingleMentionActivityConfig.class, SingleMentionActivity.class);
        SingleMentionActivityConfig.setMentionActivityClass(SingleMentionActivity.class);
        HQ();
    }

    private static void HQ() {
        com.baidu.tieba.ai.a(303007, ReplyMeSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPLYME_HTTP_CMD, com.baidu.tieba.ai.s("c/u/feed/replyme", 303007));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ReplyMeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        MentionActivityConfig.newJumpIn = true;
        Bundle j = j(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.boj = new r();
        this.boj.setArguments(j);
        this.bok = this.boj.getArguments().getBoolean(SingleMentionActivityConfig.KEY_IS_SHOW_CHAT);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (this.bok) {
            str = "tag_three";
        } else {
            str = "tag_two";
        }
        beginTransaction.add(16908290, this.boj, str);
        beginTransaction.commitAllowingStateLoss();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onCreate(this);
        }
        Tc();
        registerListener(this.bol);
        addGlobalLayoutListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        String str;
        String str2;
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra(SingleMentionActivityConfig.KEY_IS_SHOW_CHAT, false);
        if (this.bok != booleanExtra) {
            if (this.bok) {
                str = "tag_three";
            } else {
                str = "tag_two";
            }
            this.bok = booleanExtra;
            if (this.bok) {
                str2 = "tag_three";
            } else {
                str2 = "tag_two";
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            Bundle k = k(intent);
            this.boj = null;
            this.boj = new r();
            this.boj.setArguments(k);
            beginTransaction.add(16908290, this.boj, str2);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(SingleMentionActivityConfig.KEY_IS_SHOW_CHAT, this.bok);
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onSaveInstanceState(this);
        }
    }

    private Bundle k(Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        return bundle;
    }

    private Bundle j(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                bundle2.putAll(intent.getExtras());
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onResume(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.boj != null) {
            this.boj.onActivityResult(i, i2, intent);
            if (this.boj.ST() != null) {
                this.boj.ST().onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.boj.ST() == null) {
                finish();
                return true;
            }
            PbEditor EQ = this.boj.ST().EQ();
            if (EQ != null && EQ.isVisible()) {
                this.boj.ST().ER();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.ayx == null) {
            this.ayx = VoiceManager.instance();
        }
        return this.ayx;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onPause(this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onStop(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onStart(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onDestory(this);
        }
    }

    private void Tc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001229, new aq(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE() {
        com.baidu.tbadk.core.a.a.kS().F("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.lib.cache.t<byte[]> wQ() {
        return com.baidu.tbadk.core.a.a.kS().C("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }
}
