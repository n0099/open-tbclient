package com.baidu.tieba.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.t {
    private com.baidu.tieba.model.k a = null;
    private m b = null;
    private int c = -1;
    private ArrayList<MarkData> d = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new com.baidu.tieba.model.k();
        this.a.a(new k(this, this));
        this.b = new m(this);
        this.b.b = new l(this);
        com.baidu.tieba.model.k kVar = this.a;
        if (com.baidu.tieba.model.k.k() >= 0) {
            if (this.a.g() != 0) {
                com.baidu.tieba.model.k kVar2 = this.a;
                if (com.baidu.tieba.model.k.k() >= 0) {
                    m mVar = this.b;
                    mVar.a.showLoadingDialog(mVar.a.getString(com.baidu.tieba.a.k.syncing));
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
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
            m mVar = this.b;
            if (id == com.baidu.tieba.a.h.home_lv_markitem_delete) {
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
            int n = com.baidu.tbadk.coreExtra.messageCenter.a.a().n();
            if (markData2.getNewCounts() > 0) {
                if (n > 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().f(n - 1);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().f(0);
                }
                if (b > 0) {
                    this.a.a(b - 1);
                } else {
                    this.a.a(0);
                }
            }
            markData2.setNewCounts(0);
            if (markData != null) {
                com.baidu.tbadk.core.b.af afVar = new com.baidu.tbadk.core.b.af(this);
                String threadId = markData.getThreadId();
                String postId = markData.getPostId();
                boolean hostMode = markData.getHostMode();
                boolean booleanValue = markData.getSequence().booleanValue();
                Intent d = afVar.d();
                d.putExtra("thread_id", threadId);
                d.putExtra("post_id", postId);
                d.putExtra("host_only", hostMode);
                d.putExtra("squence", booleanValue);
                d.putExtra("st_type", (String) null);
                d.putExtra("from_mark", true);
                d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
                d.putExtra("is_start_for_result", "1");
                d.putExtra("request_code", 17001);
                sendMessage(new com.baidu.adp.framework.message.a(2004001, afVar));
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
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

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        if (this.a != null && this.b != null) {
            this.a.d();
            this.b.a(true);
            this.a.a((Boolean) false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (this.b != null && this.a != null && this.a.c()) {
            this.b.a(this.a.a());
            this.a.a((Boolean) false);
        }
    }
}
