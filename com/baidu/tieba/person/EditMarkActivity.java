package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.c.c c = null;
    private y d = null;
    private int e = -1;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new com.baidu.tieba.c.c();
        this.c.a(new w(this, this));
        this.d = new y(this);
        this.d.a(new x(this));
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.d.b(i);
    }

    private void b() {
        this.d.a(this.c.a());
        if (this.c.h() < 0) {
            this.c.f();
            return;
        }
        c();
        if (this.c.c() == 0 || this.c.h() < 0) {
            this.c.f();
            return;
        }
        this.d.e();
        this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.h();
        this.c.i();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.a()) {
            finish();
        } else if (view == this.d.b()) {
            this.d.c();
        } else if (view.getId() == this.d.d()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.d.f();
            this.c.a(intValue);
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i < 0 || i >= this.c.b().size()) {
            this.d.a(this.c.a());
            this.c.f();
        } else {
            this.e = i;
            com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) this.c.b().get(i);
            if (afVar != null) {
                NewPbActivity.a(this, afVar, (String) null);
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void c() {
        this.c.a(com.baidu.tieba.d.k.r());
        this.d.a(this.c.b());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1700001:
                    com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) intent.getSerializableExtra("mark");
                    if (afVar != null && this.c.b().size() > this.e && this.e >= 0) {
                        ((com.baidu.tieba.a.af) this.c.b().get(this.e)).d(afVar.h());
                        ((com.baidu.tieba.a.af) this.c.b().get(this.e)).a(afVar.g());
                        ((com.baidu.tieba.a.af) this.c.b().get(this.e)).a(afVar.f());
                        this.d.g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 1700001:
                    if (this.c.b().size() > this.e && this.e >= 0) {
                        this.c.b().remove(this.e);
                        this.d.g();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
