package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.pb.NewPbActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.f f1590a = null;
    private z b = null;
    private int c = -1;
    private ArrayList d = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1590a = new com.baidu.tieba.model.f();
        this.f1590a.a(new x(this, this));
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
        if (this.f1590a.h() < 0) {
            this.f1590a.a((Boolean) true);
        } else if (this.f1590a.d() == 0 || this.f1590a.h() < 0) {
            this.f1590a.a((Boolean) true);
        } else {
            this.b.g();
            this.f1590a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1590a.c() != null && this.f1590a.c().size() == 0) {
            com.baidu.tieba.mention.r.a().e(0L);
        }
        com.baidu.tieba.mention.r.a().e(this.f1590a.b());
        this.b.j();
        this.f1590a.i();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            finish();
        } else if (view == this.b.b()) {
            this.b.c();
        } else if (view.getId() == this.b.d()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.b.h();
            this.f1590a.b(intValue);
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i < 0 || i >= this.f1590a.c().size()) {
            this.b.a(this.f1590a.a());
            this.f1590a.a((Boolean) false);
        } else {
            this.c = i;
            MarkData markData = (MarkData) this.f1590a.c().get(i);
            MarkData markData2 = (MarkData) this.d.get(i);
            int b = this.f1590a.b();
            long k = com.baidu.tieba.mention.r.a().k();
            if (markData2.getNewCounts() > 0) {
                if (k > 0) {
                    com.baidu.tieba.mention.r.a().e(k - 1);
                } else {
                    com.baidu.tieba.mention.r.a().e(0L);
                }
                if (b > 0) {
                    this.f1590a.a(b - 1);
                } else {
                    this.f1590a.a(0);
                }
            }
            markData2.setNewCounts(0);
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
        this.b.a(this.d);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 17001:
                    MarkData markData = (MarkData) intent.getSerializableExtra("mark");
                    if (markData != null && this.f1590a.c().size() > this.c && this.c >= 0) {
                        ((MarkData) this.f1590a.c().get(this.c)).setPostId(markData.getPostId());
                        ((MarkData) this.f1590a.c().get(this.c)).setHostMode(markData.getHostMode());
                        ((MarkData) this.f1590a.c().get(this.c)).setSequence(markData.getSequence());
                        this.b.i();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.f1590a.c().size() > this.c && this.c >= 0) {
                        this.f1590a.c().remove(this.c);
                        this.b.i();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
