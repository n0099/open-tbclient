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
    private com.baidu.tieba.model.o f2200a = null;
    private aa b = null;
    private int c = -1;
    private ArrayList<MarkData> d = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2200a = new com.baidu.tieba.model.o();
        this.f2200a.a(new y(this));
        this.b = new aa(this);
        this.b.a(new z(this));
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b(i);
    }

    private void a() {
        if (this.f2200a.h() < 0) {
            this.f2200a.a((Boolean) true);
        } else if (this.f2200a.d() == 0 || this.f2200a.h() < 0) {
            this.f2200a.a((Boolean) true);
        } else {
            this.b.e();
            this.f2200a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f2200a.c() != null && this.f2200a.c().size() == 0) {
            com.baidu.tieba.mention.t.a().e(0L);
        }
        com.baidu.tieba.mention.t.a().e(this.f2200a.b());
        this.b.h();
        this.f2200a.i();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            this.b.b();
        } else if (view.getId() == this.b.c()) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.b.f();
            this.f2200a.b(intValue);
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 0 || i >= this.f2200a.c().size()) {
            this.b.a(this.f2200a.a());
            this.f2200a.a((Boolean) false);
        } else {
            this.c = i;
            MarkData markData = this.f2200a.c().get(i);
            MarkData markData2 = this.d.get(i);
            int b = this.f2200a.b();
            long q = com.baidu.tieba.mention.t.a().q();
            if (markData2.getNewCounts() > 0) {
                if (q > 0) {
                    com.baidu.tieba.mention.t.a().e(q - 1);
                } else {
                    com.baidu.tieba.mention.t.a().e(0L);
                }
                if (b > 0) {
                    this.f2200a.a(b - 1);
                } else {
                    this.f2200a.a(0);
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
                    if (markData != null && this.f2200a.c().size() > this.c && this.c >= 0) {
                        this.f2200a.c().get(this.c).setPostId(markData.getPostId());
                        this.f2200a.c().get(this.c).setHostMode(markData.getHostMode());
                        this.f2200a.c().get(this.c).setSequence(markData.getSequence());
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
                    if (this.f2200a.c().size() > this.c && this.c >= 0) {
                        this.f2200a.c().remove(this.c);
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
