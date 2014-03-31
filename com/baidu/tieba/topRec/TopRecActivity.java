package com.baidu.tieba.topRec;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.model.af;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends com.baidu.tbadk.a {
    private h a;
    private e b;
    private l c;
    private af d;
    private d e;
    private TRForumListData f;
    private List<d> h;
    private List<af> i;
    private int g = 0;
    private int j = 0;
    private n k = new a(this);
    private com.baidu.adp.widget.ListView.d l = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new h(this);
        this.a.a(true);
        this.b = new e(this);
        this.a.a(this.b);
        this.c = new l();
        this.c.b = this.k;
        this.c.LoadData();
        this.h = new LinkedList();
        this.i = new LinkedList();
        this.a.a(this.l);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, TopRecActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i) {
        if (this.f != null && i < this.f.forum_list.length) {
            this.f.forum_list[i].is_like = 1;
            this.b.notifyDataSetChanged();
            this.g++;
            this.a.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i) {
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
    public synchronized void a() {
        this.j++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (this.j != 0) {
            this.j--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tbadk.a, android.app.Activity
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b(i);
        if (i == 1) {
            this.b.a(com.baidu.tieba.a.g.btn_add_1, com.baidu.tieba.a.g.btn_add_end_1);
        } else {
            this.b.a(com.baidu.tieba.a.g.btn_add, com.baidu.tieba.a.g.btn_add_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i) {
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
                this.a.d();
            }
        } else if (view == this.a.b()) {
            if (this.j != 0) {
                showToast(String.valueOf(getString(com.baidu.tieba.a.k.top_rec_like_finish_a)) + this.j + getString(com.baidu.tieba.a.k.top_rec_like_finish_b));
                TiebaStatic.a(this, "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.a(this, "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.a(this, 1);
        } else if (this.f != null && this.f.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f.forum_list.length != 0) {
                int c = c(intValue);
                if (this.f.forum_list[c].is_like == 1) {
                    b(c);
                    this.e = new d(this, (byte) 0);
                    this.h.add(this.e);
                    this.e.setPriority(2);
                    this.e.execute(Integer.valueOf(intValue));
                    return;
                }
                this.d = new af();
                if (!this.d.b()) {
                    this.i.add(this.d);
                    a(c);
                    this.d.setLoadDataCallBack(new c(this, c, intValue));
                    this.d.a("from_topRec");
                    this.d.a(this.f.forum_list[c].forum_name, String.valueOf(this.f.forum_list[c].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.j != 0) {
            showToast(String.valueOf(getString(com.baidu.tieba.a.k.top_rec_like_finish_a)) + this.j + getString(com.baidu.tieba.a.k.top_rec_like_finish_b));
            TiebaStatic.a(this, "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.a(this, "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.a(this, 1);
    }
}
