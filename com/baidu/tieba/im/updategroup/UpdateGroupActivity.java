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
/* loaded from: classes23.dex */
public class UpdateGroupActivity extends BaseActivity<UpdateGroupActivity> {
    private UpdateGroupModel kpr;
    private a kpq = null;
    private int kps = 1;
    a.b kbA = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.cVu();
        }
    };
    a.b kbB = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.setResult(0);
            UpdateGroupActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_GROUP) { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
                UpdateGroupActivity.this.kpq.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                    UpdateGroupActivity.this.showToast(R.string.group_update_fail);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    UpdateGroupActivity.this.aY(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? UpdateGroupActivity.this.getResources().getString(R.string.neterror) : responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                    return;
                }
                UpdateGroupActivity.this.showToast(R.string.group_update_success);
                Intent intent = UpdateGroupActivity.this.getIntent();
                intent.putExtra(UpdateGroupActivityConfig.GROUP_TEXT, UpdateGroupActivity.this.kpq.getText());
                UpdateGroupActivity.this.setResult(-1, intent);
                UpdateGroupActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, int i) {
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
        z(intExtra, longExtra);
        this.kpr = new UpdateGroupModel(getPageContext());
        this.kpr.setUniqueId(getUniqueId());
        this.kpq.Ni(stringExtra);
        this.kpq.b(this.kbB);
        this.kpq.c(this.kbA);
        initListener();
    }

    private void initListener() {
        registerListener(this.jUQ);
    }

    private void z(int i, long j) {
        if (i == 1) {
            this.kpq = new c(this);
        } else if (i == 2) {
            this.kpq = new b(this);
        }
        this.kps = i;
        this.kpq.setGroupId(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kpq.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kpq.cQA()) {
            if (((d) this.kpq).cVv()) {
                finish();
            } else if (this.kpq.cVs() && this.kpq.cQq()) {
                cVu();
            } else {
                showToast(this.kpq.cVr());
            }
        } else if (view == this.kpq.cPP()) {
            this.kpq.Ng();
        } else if (view == this.kpq.cVp() && !cVt()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cVt()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean cVt() {
        if (TextUtils.isEmpty(this.kpq.getText()) || !this.kpq.cQq() || this.kpq.getText().equals(this.kpq.cVo())) {
            return false;
        }
        this.kpq.Qj();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVu() {
        this.kpq.setIsLoading(true);
        this.kpr.setGroupId(this.kpq.getGroupId());
        if (this.kps == 1) {
            this.kpr.setName(this.kpq.getText());
            this.kpr.sendMessage(2);
        } else if (this.kps == 2) {
            this.kpr.setIntro(this.kpq.getText());
            this.kpr.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.kpr.cancelMessage();
        this.kpq.release();
    }
}
