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
    private UpdateGroupModel biy;
    private a bix = null;
    private int JA = 1;
    DialogInterface.OnClickListener aUv = new b(this);
    DialogInterface.OnClickListener aUw = new c(this);
    private com.baidu.adp.framework.listener.e ayJ = new d(this, 103102);

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
        this.biy = new UpdateGroupModel(this);
        this.biy.setUniqueId(getUniqueId());
        this.bix.gE(stringExtra);
        this.bix.c(this.aUw);
        this.bix.d(this.aUv);
        HJ();
    }

    private void HJ() {
        registerListener(this.ayJ);
    }

    private void Q(int i, int i2) {
        if (i == 1) {
            this.bix = new f(this);
        } else if (i == 2) {
            this.bix = new e(this);
        }
        this.JA = i;
        this.bix.setGroupId(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bix.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bix.LV()) {
            if (((g) this.bix).RP()) {
                finish();
            } else if (this.bix.RM() && this.bix.LL()) {
                RO();
            } else {
                showToast(this.bix.RL());
            }
        } else if (view == this.bix.Li()) {
            this.bix.clearText();
        } else if (view == this.bix.RJ() && !RN()) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && RN()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean RN() {
        if (TextUtils.isEmpty(this.bix.getText()) || !this.bix.LL() || this.bix.getText().equals(this.bix.RI())) {
            return false;
        }
        this.bix.Mh();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RO() {
        this.bix.setIsLoading(true);
        this.biy.setGroupId(this.bix.getGroupId());
        if (this.JA == 1) {
            this.biy.setName(this.bix.getText());
            this.biy.sendMessage(2);
        } else if (this.JA == 2) {
            this.biy.setIntro(this.bix.getText());
            this.biy.sendMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.biy.cancelMessage();
    }
}
