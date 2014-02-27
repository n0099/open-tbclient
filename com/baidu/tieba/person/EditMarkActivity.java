package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.ListView.b, com.baidu.adp.widget.ListView.r {
    private com.baidu.tieba.model.g a = null;
    private ad b = null;
    private int c = -1;
    private ArrayList<MarkData> d = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new com.baidu.tieba.model.g();
        this.a.a(new ab(this, this));
        this.b = new ad(this);
        this.b.b = new ac(this);
        com.baidu.tieba.model.g gVar = this.a;
        if (com.baidu.tieba.model.g.k() >= 0) {
            if (this.a.g() != 0) {
                com.baidu.tieba.model.g gVar2 = this.a;
                if (com.baidu.tieba.model.g.k() >= 0) {
                    ad adVar = this.b;
                    adVar.a.showLoadingDialog(adVar.a.getString(R.string.syncing));
                    this.a.j();
                    return;
                }
            }
            this.a.a((Boolean) true);
            return;
        }
        this.a.a((Boolean) true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.f();
        this.a.l();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            this.b.b();
        } else {
            int id = view.getId();
            ad adVar = this.b;
            if (id == R.id.home_lv_markitem_delete) {
                int intValue = ((Integer) view.getTag()).intValue();
                this.b.d();
                if (!this.a.b(intValue)) {
                    this.b.c();
                }
            }
        }
        super.onClick(view);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.a.f().size()) {
            this.c = i;
            MarkData markData = this.a.f().get(i);
            MarkData markData2 = this.d.get(i);
            int b = this.a.b();
            int p = com.baidu.tieba.mention.v.a().p();
            if (markData2.getNewCounts() > 0) {
                if (p > 0) {
                    com.baidu.tieba.mention.v.a().f(p - 1);
                } else {
                    com.baidu.tieba.mention.v.a().f(0);
                }
                if (b > 0) {
                    this.a.a(b - 1);
                } else {
                    this.a.a(0);
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
    @Override // com.baidu.tieba.f, android.app.Activity
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
                    if (markData != null && this.a.f().size() > this.c && this.c >= 0) {
                        this.a.f().get(this.c).setPostId(markData.getPostId());
                        this.a.f().get(this.c).setHostMode(markData.getHostMode());
                        this.a.f().get(this.c).setSequence(markData.getSequence());
                        this.b.e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 17001:
                    if (this.a.f().size() > this.c && this.c >= 0) {
                        this.a.f().remove(this.c);
                        this.b.e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.b
    public final void a(boolean z) {
        if (this.a != null && this.b != null) {
            this.a.d();
            this.b.a(true);
            this.a.a((Boolean) false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.r
    public final void b() {
        if (this.b != null && this.a != null && this.a.c()) {
            this.b.a(this.a.a());
            this.a.a((Boolean) false);
        }
    }
}
