package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.f f1552a = null;
    private z b = null;
    private int c = -1;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1552a = new com.baidu.tieba.model.f();
        this.f1552a.a(new x(this, this));
        this.b = new z(this);
        this.b.a(new y(this));
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.b.b(i);
    }

    private void b() {
        this.b.a(this.f1552a.a());
        if (this.f1552a.h() < 0) {
            this.f1552a.f();
            return;
        }
        c();
        if (this.f1552a.c() == 0 || this.f1552a.h() < 0) {
            this.f1552a.f();
            return;
        }
        this.b.e();
        this.f1552a.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.h();
        this.f1552a.i();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            finish();
        } else if (view == this.b.b()) {
            this.b.c();
        } else if (view.getId() == this.b.d()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.b.f();
            this.f1552a.a(intValue);
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i < 0 || i >= this.f1552a.b().size()) {
            this.b.a(this.f1552a.a());
            this.f1552a.f();
        } else {
            this.c = i;
            MarkData markData = (MarkData) this.f1552a.b().get(i);
            if (markData != null) {
                NewPbActivity.a(this, markData, (String) null);
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void c() {
        this.f1552a.a(DatabaseService.u());
        this.b.a(this.f1552a.b());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.f1552a.b().size() > this.c && this.c >= 0) {
                        ((MarkData) this.f1552a.b().get(this.c)).setPostId(markData.getPostId());
                        ((MarkData) this.f1552a.b().get(this.c)).setHostMode(markData.getHostMode());
                        ((MarkData) this.f1552a.b().get(this.c)).setSequence(markData.getSequence());
                        this.b.g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.f1552a.b().size() > this.c && this.c >= 0) {
                        this.f1552a.b().remove(this.c);
                        this.b.g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
