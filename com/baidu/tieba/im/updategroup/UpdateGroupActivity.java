package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes3.dex */
public class UpdateGroupActivity extends BaseActivity<UpdateGroupActivity> {
    private UpdateGroupModel eZq;
    private a eZp = null;
    private int eZr = 1;
    a.b eMR = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.aUy();
        }
    };
    a.b eMS = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.setResult(0);
            UpdateGroupActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.c eHa = new com.baidu.adp.framework.listener.c(103102) { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
                UpdateGroupActivity.this.eZp.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                    UpdateGroupActivity.this.showToast(e.j.group_update_fail);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    UpdateGroupActivity.this.ak(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? UpdateGroupActivity.this.getResources().getString(e.j.neterror) : responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                    return;
                }
                UpdateGroupActivity.this.showToast(e.j.group_update_success);
                Intent intent = UpdateGroupActivity.this.getIntent();
                intent.putExtra(UpdateGroupActivityConfig.GROUP_TEXT, UpdateGroupActivity.this.eZp.getText());
                UpdateGroupActivity.this.setResult(-1, intent);
                UpdateGroupActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(String str, int i) {
        if (i < 0) {
            showToast(e.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("edit_type", 1);
        long longExtra = intent.getLongExtra("group_id", 0L);
        String stringExtra = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
        l(intExtra, longExtra);
        this.eZq = new UpdateGroupModel(getPageContext());
        this.eZq.setUniqueId(getUniqueId());
        this.eZp.qy(stringExtra);
        this.eZp.a(this.eMS);
        this.eZp.b(this.eMR);
        initListener();
    }

    private void initListener() {
        registerListener(this.eHa);
    }

    private void l(int i, long j) {
        if (i == 1) {
            this.eZp = new c(this);
        } else if (i == 2) {
            this.eZp = new b(this);
        }
        this.eZr = i;
        this.eZp.setGroupId(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eZp.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eZp.aPU()) {
            if (((d) this.eZp).aUz()) {
                finish();
            } else if (this.eZp.aUw() && this.eZp.aPK()) {
                aUy();
            } else {
                showToast(this.eZp.aUv());
            }
        } else if (view == this.eZp.aPi()) {
            this.eZp.clearText();
        } else if (view == this.eZp.aUt() && !aUx()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aUx()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean aUx() {
        if (TextUtils.isEmpty(this.eZp.getText()) || !this.eZp.aPK() || this.eZp.getText().equals(this.eZp.aUs())) {
            return false;
        }
        this.eZp.showDialog();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUy() {
        this.eZp.setIsLoading(true);
        this.eZq.setGroupId(this.eZp.getGroupId());
        if (this.eZr == 1) {
            this.eZq.setName(this.eZp.getText());
            this.eZq.sendMessage(2);
        } else if (this.eZr == 2) {
            this.eZq.setIntro(this.eZp.getText());
            this.eZq.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.eZq.cancelMessage();
        this.eZp.release();
    }
}
