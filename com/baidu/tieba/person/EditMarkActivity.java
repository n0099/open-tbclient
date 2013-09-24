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
public class EditMarkActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.h f1640a = null;
    private y b = null;
    private int c = -1;
    private ArrayList<MarkData> d = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1640a = new com.baidu.tieba.model.h();
        this.f1640a.a(new w(this, this));
        this.b = new y(this);
        this.b.a(new x(this));
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.b.b(i);
    }

    private void b() {
        if (this.f1640a.h() < 0) {
            this.f1640a.a((Boolean) true);
        } else if (this.f1640a.d() == 0 || this.f1640a.h() < 0) {
            this.f1640a.a((Boolean) true);
        } else {
            this.b.f();
            this.f1640a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1640a.c() != null && this.f1640a.c().size() == 0) {
            com.baidu.tieba.mention.s.a().e(0L);
        }
        com.baidu.tieba.mention.s.a().e(this.f1640a.b());
        this.b.i();
        this.f1640a.i();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            this.b.b();
        } else if (view.getId() == this.b.c()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.b.g();
            this.f1640a.b(intValue);
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 0 || i >= this.f1640a.c().size()) {
            this.b.a(this.f1640a.a());
            this.f1640a.a((Boolean) false);
        } else {
            this.c = i;
            MarkData markData = this.f1640a.c().get(i);
            MarkData markData2 = this.d.get(i);
            int b = this.f1640a.b();
            long m = com.baidu.tieba.mention.s.a().m();
            if (markData2.getNewCounts() > 0) {
                if (m > 0) {
                    com.baidu.tieba.mention.s.a().e(m - 1);
                } else {
                    com.baidu.tieba.mention.s.a().e(0L);
                }
                if (b > 0) {
                    this.f1640a.a(b - 1);
                } else {
                    this.f1640a.a(0);
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
    @Override // com.baidu.tieba.j, android.app.Activity
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
                    if (markData != null && this.f1640a.c().size() > this.c && this.c >= 0) {
                        this.f1640a.c().get(this.c).setPostId(markData.getPostId());
                        this.f1640a.c().get(this.c).setHostMode(markData.getHostMode());
                        this.f1640a.c().get(this.c).setSequence(markData.getSequence());
                        this.b.h();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.f1640a.c().size() > this.c && this.c >= 0) {
                        this.f1640a.c().remove(this.c);
                        this.b.h();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
