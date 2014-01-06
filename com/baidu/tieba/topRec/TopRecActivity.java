package com.baidu.tieba.topRec;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ax;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends com.baidu.tieba.j {
    private h a;
    private e b;
    private l c;
    private ax d;
    private d e;
    private TRForumListData f;
    private List<d> h;
    private List<ax> i;
    private int g = 0;
    private int j = 0;
    private o k = new a(this);
    private com.baidu.adp.widget.ListView.b l = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
    }

    private void a() {
        this.a = new h(this);
        this.a.a(true);
    }

    private void b() {
        this.b = new e(this);
        this.a.a(this.b);
        this.c = new l();
        this.c.a(this.k);
        this.c.LoadData();
        this.h = new LinkedList();
        this.i = new LinkedList();
        this.a.a(this.l);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, TopRecActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, int i2) {
        if (this.f != null && i < this.f.forum_list.length) {
            this.f.forum_list[i].is_like = 1;
            this.b.notifyDataSetChanged();
            this.g++;
            this.a.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i, int i2) {
        if (this.f != null && i < this.f.forum_list.length) {
            this.f.forum_list[i].is_like = 0;
            this.b.notifyDataSetChanged();
            if (this.g != 0) {
                this.g--;
            }
            this.a.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.j++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.j != 0) {
            this.j--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            if (this.h.get(i) != null) {
                this.h.get(i).cancel();
            }
        }
        int size2 = this.i.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.i.get(i2) != null) {
                this.i.get(i2).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null) {
            int c = this.b.c();
            if (c != 0) {
                this.g += c;
                this.j = c + this.j;
                this.a.a(this.g);
            }
            this.b.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b(i);
        if (i == 1) {
            this.b.a(R.drawable.btn_add_1, R.drawable.btn_add_end_1);
        } else {
            this.b.a(R.drawable.btn_add, R.drawable.btn_add_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        if (this.f == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f.forum_list.length; i2++) {
            if (this.f.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.a()) {
            this.b.a();
            if (this.b.b()) {
                this.a.e();
            }
        } else if (view == this.a.b()) {
            if (this.j != 0) {
                showToast(getString(R.string.top_rec_like_finish_a) + this.j + getString(R.string.top_rec_like_finish_b));
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "top_rec_have_like", "people_number", 1);
                }
            } else if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "top_rec_no_like", "people_number", 1);
            }
            finish();
            MainTabActivity.a(this, 1);
        } else if (this.f != null && this.f.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f.forum_list.length != 0) {
                int a = a(intValue);
                if (this.f.forum_list[a].is_like == 1) {
                    b(a, intValue);
                    this.e = new d(this, null);
                    this.h.add(this.e);
                    this.e.setPriority(2);
                    this.e.execute(Integer.valueOf(intValue));
                    return;
                }
                this.d = new ax();
                if (!this.d.b()) {
                    this.i.add(this.d);
                    a(a, intValue);
                    this.d.setLoadDataCallBack(new c(this, a, intValue));
                    this.d.a("from_topRec");
                    this.d.a(this.f.forum_list[a].forum_name, String.valueOf(this.f.forum_list[a].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.j != 0) {
            showToast(getString(R.string.top_rec_like_finish_a) + this.j + getString(R.string.top_rec_like_finish_b));
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "top_rec_have_like", "people_number", 1);
            }
        } else if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "top_rec_no_like", "people_number", 1);
        }
        finish();
        MainTabActivity.a(this, 1);
    }
}
