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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* loaded from: classes5.dex */
public class UpdateGroupActivity extends BaseActivity<UpdateGroupActivity> {
    private UpdateGroupModel gKe;
    private a gKd = null;
    private int gKf = 1;
    a.b gxB = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.bDZ();
        }
    };
    a.b gxC = new a.b() { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            UpdateGroupActivity.this.setResult(0);
            UpdateGroupActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(103102) { // from class: com.baidu.tieba.im.updategroup.UpdateGroupActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103102) {
                UpdateGroupActivity.this.gKd.setIsLoading(false);
                if (!(socketResponsedMessage instanceof ResponseUpdateGroupMessage)) {
                    UpdateGroupActivity.this.showToast(R.string.group_update_fail);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    UpdateGroupActivity.this.aC(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? UpdateGroupActivity.this.getResources().getString(R.string.neterror) : responseUpdateGroupMessage.getErrorString(), responseUpdateGroupMessage.getError());
                    return;
                }
                UpdateGroupActivity.this.showToast(R.string.group_update_success);
                Intent intent = UpdateGroupActivity.this.getIntent();
                intent.putExtra(UpdateGroupActivityConfig.GROUP_TEXT, UpdateGroupActivity.this.gKd.getText());
                UpdateGroupActivity.this.setResult(-1, intent);
                UpdateGroupActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(String str, int i) {
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
        t(intExtra, longExtra);
        this.gKe = new UpdateGroupModel(getPageContext());
        this.gKe.setUniqueId(getUniqueId());
        this.gKd.yL(stringExtra);
        this.gKd.b(this.gxC);
        this.gKd.c(this.gxB);
        initListener();
    }

    private void initListener() {
        registerListener(this.grM);
    }

    private void t(int i, long j) {
        if (i == 1) {
            this.gKd = new c(this);
        } else if (i == 2) {
            this.gKd = new b(this);
        }
        this.gKf = i;
        this.gKd.setGroupId(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gKd.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gKd.bzz()) {
            if (((d) this.gKd).bEa()) {
                finish();
            } else if (this.gKd.bDX() && this.gKd.bzp()) {
                bDZ();
            } else {
                showToast(this.gKd.bDW());
            }
        } else if (view == this.gKd.byN()) {
            this.gKd.clearText();
        } else if (view == this.gKd.bDU() && !bDY()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bDY()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean bDY() {
        if (TextUtils.isEmpty(this.gKd.getText()) || !this.gKd.bzp() || this.gKd.getText().equals(this.gKd.bDT())) {
            return false;
        }
        this.gKd.showDialog();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDZ() {
        this.gKd.setIsLoading(true);
        this.gKe.setGroupId(this.gKd.getGroupId());
        if (this.gKf == 1) {
            this.gKe.setName(this.gKd.getText());
            this.gKe.sendMessage(2);
        } else if (this.gKf == 2) {
            this.gKe.setIntro(this.gKd.getText());
            this.gKe.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.gKe.cancelMessage();
        this.gKd.release();
    }
}
