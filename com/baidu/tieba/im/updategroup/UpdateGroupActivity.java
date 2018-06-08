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
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes3.dex */
public class UpdateGroupActivity extends BaseActivity<UpdateGroupActivity> {
    private UpdateGroupModel euE;
    private a euD = null;
    private int euF = 1;
    a.b ehT = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.aMd();
        }
    };
    a.b ehU = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.setResult(0);
            UpdateGroupActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(103102) { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
                UpdateGroupActivity.this.euD.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                    UpdateGroupActivity.this.showToast(d.k.group_update_fail);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    UpdateGroupActivity.this.af(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? UpdateGroupActivity.this.getResources().getString(d.k.neterror) : responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                    return;
                }
                UpdateGroupActivity.this.showToast(d.k.group_update_success);
                Intent intent = UpdateGroupActivity.this.getIntent();
                intent.putExtra(UpdateGroupActivityConfig.GROUP_TEXT, UpdateGroupActivity.this.euD.getText());
                UpdateGroupActivity.this.setResult(-1, intent);
                UpdateGroupActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str, int i) {
        if (i < 0) {
            showToast(d.k.neterror);
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
        i(intExtra, longExtra);
        this.euE = new UpdateGroupModel(getPageContext());
        this.euE.setUniqueId(getUniqueId());
        this.euD.oJ(stringExtra);
        this.euD.a(this.ehU);
        this.euD.b(this.ehT);
        initListener();
    }

    private void initListener() {
        registerListener(this.ecb);
    }

    private void i(int i, long j) {
        if (i == 1) {
            this.euD = new c(this);
        } else if (i == 2) {
            this.euD = new b(this);
        }
        this.euF = i;
        this.euD.setGroupId(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.euD.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.euD.aHw()) {
            if (((d) this.euD).aMe()) {
                finish();
            } else if (this.euD.aMb() && this.euD.aHn()) {
                aMd();
            } else {
                showToast(this.euD.aMa());
            }
        } else if (view == this.euD.aGK()) {
            this.euD.clearText();
        } else if (view == this.euD.aLY() && !aMc()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && aMc()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean aMc() {
        if (TextUtils.isEmpty(this.euD.getText()) || !this.euD.aHn() || this.euD.getText().equals(this.euD.aLX())) {
            return false;
        }
        this.euD.showDialog();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMd() {
        this.euD.setIsLoading(true);
        this.euE.setGroupId(this.euD.getGroupId());
        if (this.euF == 1) {
            this.euE.setName(this.euD.getText());
            this.euE.sendMessage(2);
        } else if (this.euF == 2) {
            this.euE.setIntro(this.euD.getText());
            this.euE.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.euE.cancelMessage();
        this.euD.release();
    }
}
