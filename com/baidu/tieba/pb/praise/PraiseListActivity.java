package com.baidu.tieba.pb.praise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.atomData.at;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, h {
    private i a = null;
    private f b = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003007, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3, boolean z) {
        if (!j.b(str2)) {
            Intent intent = new Intent(context, PraiseListActivity.class);
            intent.putExtra("KeyIntentThreadId", str);
            intent.putExtra("KeyIntentPostId", str2);
            intent.putExtra("KeyIntentPostDesc", str3);
            intent.putExtra("KeyIntentIsFromPb", z);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = new f(bundle.getString("KeyIntentThreadId"), bundle.getString("KeyIntentPostId"), bundle.getString("KeyIntentPostDesc"), bundle.getBoolean("KeyIntentIsFromPb", true), this);
            this.b.a(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.b = new f(getIntent().getStringExtra("KeyIntentThreadId"), getIntent().getStringExtra("KeyIntentPostId"), getIntent().getStringExtra("KeyIntentPostDesc"), getIntent().getBooleanExtra("KeyIntentIsFromPb", true), this);
        }
        if (this.b == null) {
            this.b = new f();
        }
        this.a = new i(this, this.b.d());
        this.a.b();
        this.b.e();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.f()) {
            a();
            if (this.b.b()) {
                finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new as(this).a(this.b.a(), null, "praise_list")));
            finish();
        } else if (view == this.a.g() && !this.a.d()) {
            this.a.b();
            this.b.e();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a b = this.b.b(i);
        if (b != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new at(this, b.a(), b.d())));
        }
    }

    private void a() {
        if (this.b != null) {
            this.b.c();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle, "KeyIntentIsFromPb");
        this.b.b(bundle, "KeyIntentThreadId");
        this.b.c(bundle, "KeyIntentPostId");
        this.b.d(bundle, "KeyIntentPostDesc");
        this.b.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.tieba.pb.praise.h
    public void a(String str) {
        if (!j.b(str)) {
            showToast(str, true);
        }
        this.a.c();
    }

    @Override // com.baidu.tieba.pb.praise.h
    public void a(int i, List<a> list, int i2, int i3) {
        this.a.a(i, list, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        getLayoutMode().a(view);
    }
}
