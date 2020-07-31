package com.baidu.tieba.im.updategroup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes17.dex */
public class UpdateGroupActivity extends BaseActivity<UpdateGroupActivity> {
    private UpdateGroupModel jkp;
    private a jko = null;
    private int jkq = 1;
    a.b iWw = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.cxG();
        }
    };
    a.b iWx = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.setResult(0);
            UpdateGroupActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.c iPM = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_GROUP) { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
                UpdateGroupActivity.this.jko.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                    UpdateGroupActivity.this.showToast(R.string.group_update_fail);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    UpdateGroupActivity.this.aR(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? UpdateGroupActivity.this.getResources().getString(R.string.neterror) : responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                    return;
                }
                UpdateGroupActivity.this.showToast(R.string.group_update_success);
                Intent intent = UpdateGroupActivity.this.getIntent();
                intent.putExtra(UpdateGroupActivityConfig.GROUP_TEXT, UpdateGroupActivity.this.jko.getText());
                UpdateGroupActivity.this.setResult(-1, intent);
                UpdateGroupActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
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
        y(intExtra, longExtra);
        this.jkp = new UpdateGroupModel(getPageContext());
        this.jkp.setUniqueId(getUniqueId());
        this.jko.Ij(stringExtra);
        this.jko.b(this.iWx);
        this.jko.c(this.iWw);
        initListener();
    }

    private void initListener() {
        registerListener(this.iPM);
    }

    private void y(int i, long j) {
        if (i == 1) {
            this.jko = new c(this);
        } else if (i == 2) {
            this.jko = new b(this);
        }
        this.jkq = i;
        this.jko.setGroupId(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jko.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jko.csL()) {
            if (((d) this.jko).cxH()) {
                finish();
            } else if (this.jko.cxE() && this.jko.csB()) {
                cxG();
            } else {
                showToast(this.jko.cxD());
            }
        } else if (view == this.jko.csa()) {
            this.jko.EV();
        } else if (view == this.jko.cxB() && !cxF()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cxF()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean cxF() {
        if (TextUtils.isEmpty(this.jko.getText()) || !this.jko.csB() || this.jko.getText().equals(this.jko.cxA())) {
            return false;
        }
        this.jko.showDialog();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        this.jko.setIsLoading(true);
        this.jkp.setGroupId(this.jko.getGroupId());
        if (this.jkq == 1) {
            this.jkp.setName(this.jko.getText());
            this.jkp.sendMessage(2);
        } else if (this.jkq == 2) {
            this.jkp.setIntro(this.jko.getText());
            this.jkp.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.jkp.cancelMessage();
        this.jko.release();
    }
}
