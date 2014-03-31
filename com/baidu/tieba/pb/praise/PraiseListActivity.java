package com.baidu.tieba.pb.praise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ag;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends com.baidu.tbadk.a implements View.OnClickListener, AdapterView.OnItemClickListener, h {
    private i a = null;
    private f b = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001007, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, String str, String str2) {
        if (com.baidu.adp.lib.util.h.b(str)) {
            return;
        }
        Intent intent = new Intent(context, PraiseListActivity.class);
        intent.putExtra("KeyIntentPostId", str);
        intent.putExtra("KeyIntentPostDesc", str2);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = new f(bundle.getString("KeyIntentPostId"), bundle.getString("KeyIntentPostDesc"), this);
            this.b.a(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.b = new f(getIntent().getStringExtra("KeyIntentPostId"), getIntent().getStringExtra("KeyIntentPostDesc"), this);
        }
        if (this.b == null) {
            this.b = new f();
        }
        this.a = new i(this, this.b.b());
        this.a.d();
        this.b.c();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.g()) {
            if (this.b != null) {
                this.b.a();
            }
            finish();
        } else if (view == this.a.h() && !this.a.f()) {
            this.a.d();
            this.b.c();
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a b = this.b.b(i);
        if (b != null) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(this, b.a(), b.d())));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle, "KeyIntentPostId");
        this.b.b(bundle, "KeyIntentPostDesc");
        this.b.c(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.tieba.pb.praise.h
    public final void a(String str) {
        if (!com.baidu.adp.lib.util.h.b(str)) {
            showToast(str, true);
        }
        this.a.e();
    }

    @Override // com.baidu.tieba.pb.praise.h
    public final void a(int i, List<a> list, int i2, int i3) {
        this.a.a(i, list, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.a.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().a(TbadkApplication.j().l() == 1);
        getLayoutMode().a(view);
    }
}
