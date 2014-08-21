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
import com.baidu.tbadk.core.atomData.bx;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public class SingleMentionActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.voice.aa {
    p d;
    VoiceManager e;
    private boolean f;
    private CustomMessageListener g = new aw(this, 2001229);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bx.class, SingleMentionActivity.class);
        bx.a(SingleMentionActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle a = a(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.d = new p();
        this.d.setArguments(a);
        this.f = this.d.getArguments().getBoolean("is_show_chat");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (this.f) {
            str = "tag_three";
        } else {
            str = "tag_two";
        }
        beginTransaction.add(16908290, this.d, str);
        beginTransaction.commitAllowingStateLoss();
        this.e = d();
        if (this.e != null) {
            this.e.onCreate(this);
        }
        g();
        a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        String str;
        String str2;
        super.onNewIntent(intent);
        boolean booleanExtra = intent.getBooleanExtra("is_show_chat", false);
        if (this.f != booleanExtra) {
            if (this.f) {
                str = "tag_three";
            } else {
                str = "tag_two";
            }
            this.f = booleanExtra;
            if (this.f) {
                str2 = "tag_three";
            } else {
                str2 = "tag_two";
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            Bundle a = a(intent);
            this.d = null;
            this.d = new p();
            this.d.setArguments(a);
            beginTransaction.add(16908290, this.d, str2);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_show_chat", this.f);
        this.e = d();
        if (this.e != null) {
            this.e.onSaveInstanceState(this);
        }
    }

    private Bundle a(Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        return bundle;
    }

    private Bundle a(Bundle bundle) {
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
        this.e = d();
        if (this.e != null) {
            this.e.onResume(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.d != null) {
            this.d.onActivityResult(i, i2, intent);
            if (this.d.a() != null) {
                this.d.a().onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.d.a() == null) {
                finish();
                return true;
            }
            PbEditor j = this.d.a().j();
            if (j != null && j.p()) {
                this.d.a().i();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        if (this.e == null) {
            this.e = VoiceManager.instance();
        }
        return this.e;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.e = d();
        if (this.e != null) {
            this.e.onPause(this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.e = d();
        if (this.e != null) {
            this.e.onStop(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.e = d();
        if (this.e != null) {
            this.e.onStart(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e = d();
        if (this.e != null) {
            this.e.onDestory(this);
        }
    }

    private void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001229, new ax(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.baidu.tbadk.core.a.a.a().d("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.lib.cache.t<byte[]> i() {
        return com.baidu.tbadk.core.a.a.a().a("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }
}
