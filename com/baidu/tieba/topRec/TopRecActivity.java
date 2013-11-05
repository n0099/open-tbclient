package com.baidu.tieba.topRec;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ba;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private h f2384a;
    private e b;
    private l c;
    private ba d;
    private d e;
    private TRForumListData f;
    private List<d> j;
    private List<ba> k;
    private int g = 0;
    private int l = 0;
    private o m = new a(this);
    private com.baidu.adp.widget.ListView.b n = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
    }

    private void b() {
        this.f2384a = new h(this);
        this.f2384a.a(true);
    }

    private void c() {
        this.b = new e(this);
        this.f2384a.a(this.b);
        this.c = new l();
        this.c.a(this.m);
        this.c.LoadData();
        this.j = new LinkedList();
        this.k = new LinkedList();
        this.f2384a.a(this.n);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, TopRecActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i, int i2) {
        if (this.f != null && i < this.f.forum_list.length) {
            this.f.forum_list[i].is_like = 1;
            this.b.notifyDataSetChanged();
            this.g++;
            this.f2384a.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i, int i2) {
        if (this.f != null && i < this.f.forum_list.length) {
            this.f.forum_list[i].is_like = 0;
            this.b.notifyDataSetChanged();
            if (this.g != 0) {
                this.g--;
            }
            this.f2384a.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.l++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        if (this.l != 0) {
            this.l--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (this.j.get(i) != null) {
                this.j.get(i).cancel();
            }
        }
        int size2 = this.k.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.k.get(i2) != null) {
                this.k.get(i2).a();
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
                this.l = c + this.l;
                this.f2384a.a(this.g);
            }
            this.b.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f2384a.b(i);
        if (i == 1) {
            this.b.a(R.drawable.btn_add_1, R.drawable.btn_add_end_1);
        } else {
            this.b.a(R.drawable.btn_add, R.drawable.btn_add_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i) {
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
        if (view == this.f2384a.a()) {
            this.b.a();
            if (this.b.b()) {
                this.f2384a.e();
            }
        } else if (view == this.f2384a.b()) {
            if (this.l != 0) {
                a(getString(R.string.top_rec_like_finish_a) + this.l + getString(R.string.top_rec_like_finish_b));
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "top_rec_have_like", "people_number", 1);
                }
            } else if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "top_rec_no_like", "people_number", 1);
            }
            finish();
            MainTabActivity.a(this, 1);
        } else if (this.f != null || this.f.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f.forum_list.length != 0) {
                int d = d(intValue);
                if (this.f.forum_list[d].is_like == 1) {
                    c(d, intValue);
                    this.e = new d(this, null);
                    this.j.add(this.e);
                    this.e.setPriority(2);
                    this.e.execute(Integer.valueOf(intValue));
                    return;
                }
                this.d = new ba();
                if (!this.d.b()) {
                    this.k.add(this.d);
                    b(d, intValue);
                    this.d.setLoadDataCallBack(new c(this, d, intValue));
                    this.d.a("from_topRec");
                    this.d.a(this.f.forum_list[d].forum_name, String.valueOf(this.f.forum_list[d].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.l != 0) {
            a(getString(R.string.top_rec_like_finish_a) + this.l + getString(R.string.top_rec_like_finish_b));
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
