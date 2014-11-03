package com.baidu.tieba.im.updategroup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.UpdateGroupModel;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class UpdateGroupActivity extends BaseActivity {
    private UpdateGroupModel biM;
    private a biL = null;
    private int JB = 1;
    DialogInterface.OnClickListener aUJ = new b(this);
    DialogInterface.OnClickListener aUK = new c(this);
    private com.baidu.adp.framework.listener.e ayS = new d(this, 103102);

    public static void a(Activity activity, int i, int i2, int i3, String str) {
        Intent intent = new Intent(activity, UpdateGroupActivity.class);
        intent.putExtra("group_id", i2);
        intent.putExtra("edit_type", i3);
        intent.putExtra("group_text", str);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, int i) {
        if (i < 0) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("edit_type", 1);
        int intExtra2 = intent.getIntExtra("group_id", 0);
        String stringExtra = intent.getStringExtra("group_text");
        Q(intExtra, intExtra2);
        this.biM = new UpdateGroupModel(this);
        this.biM.setUniqueId(getUniqueId());
        this.biL.gE(stringExtra);
        this.biL.c(this.aUK);
        this.biL.d(this.aUJ);
        HN();
    }

    private void HN() {
        registerListener(this.ayS);
    }

    private void Q(int i, int i2) {
        if (i == 1) {
            this.biL = new f(this);
        } else if (i == 2) {
            this.biL = new e(this);
        }
        this.JB = i;
        this.biL.setGroupId(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.biL.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.biL.LZ()) {
            if (((g) this.biL).RS()) {
                finish();
            } else if (this.biL.RP() && this.biL.LP()) {
                RR();
            } else {
                showToast(this.biL.RO());
            }
        } else if (view == this.biL.Lm()) {
            this.biL.clearText();
        } else if (view == this.biL.RM() && !RQ()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && RQ()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean RQ() {
        if (TextUtils.isEmpty(this.biL.getText()) || !this.biL.LP() || this.biL.getText().equals(this.biL.RL())) {
            return false;
        }
        this.biL.Ml();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RR() {
        this.biL.setIsLoading(true);
        this.biM.setGroupId(this.biL.getGroupId());
        if (this.JB == 1) {
            this.biM.setName(this.biL.getText());
            this.biM.sendMessage(2);
        } else if (this.JB == 2) {
            this.biM.setIntro(this.biL.getText());
            this.biM.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.biM.cancelMessage();
    }
}
