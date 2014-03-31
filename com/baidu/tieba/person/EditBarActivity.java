package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class EditBarActivity extends com.baidu.tbadk.a {
    private NavigationBar f;
    private LinearLayout p;
    private TextView q;
    private com.baidu.tieba.model.d a = null;
    private ListView b = null;
    private View c = null;
    private View d = null;
    private TextView e = null;
    private TextView g = null;
    private TextView h = null;
    private g i = null;
    private ProgressBar j = null;
    private e k = null;
    private int l = -1;
    private String m = null;
    private f n = null;
    private RelativeLayout o = null;
    private String r = null;
    private int s = 0;

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, EditBarActivity.class);
        if (str != null) {
            intent.putExtra("view_user_id", str);
            intent.putExtra("user_sex", i2);
        }
        activity.startActivityForResult(intent, PersonInfoActivity.REQUSET_MY_BAR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.edit_bar_activity);
        this.a = new com.baidu.tieba.model.d();
        this.r = getIntent().getStringExtra("view_user_id");
        this.s = getIntent().getIntExtra("user_sex", 0);
        this.o = (RelativeLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.f = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.h = this.f.a("");
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.a.k.edit));
        this.p = (LinearLayout) findViewById(com.baidu.tieba.a.h.no_data_container);
        this.q = (TextView) findViewById(com.baidu.tieba.a.h.no_data_image_text);
        this.j = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.i = new g(this, this.a, this.r == null);
        this.i.a(new a(this));
        this.i.b(new b(this));
        this.b = (ListView) findViewById(com.baidu.tieba.a.h.list);
        this.c = LayoutInflater.from(this).inflate(com.baidu.tieba.a.i.person_list_newheader, (ViewGroup) null);
        this.d = this.c.findViewById(com.baidu.tieba.a.h.newheader_root);
        this.c.setVisibility(8);
        this.c.setClickable(false);
        this.c.setEnabled(false);
        this.e = (TextView) this.c.findViewById(com.baidu.tieba.a.h.person_list_title);
        this.b.addHeaderView(this.c, null, false);
        this.b.setAdapter((ListAdapter) this.i);
        this.b.setOnScrollListener(this.i);
        this.b.setOnItemClickListener(new c(this));
        this.g.setOnClickListener(new d(this));
        if (this.r != null) {
            this.g.setVisibility(4);
            if (this.s == 2) {
                this.h.setText(getString(com.baidu.tieba.a.k.her_attention_forums));
                this.q.setText(getString(com.baidu.tieba.a.k.she_no_like_forum_other));
            } else if (this.s == 1) {
                this.h.setText(getString(com.baidu.tieba.a.k.his_attention_forums));
                this.q.setText(getString(com.baidu.tieba.a.k.he_no_like_forum_other));
            } else {
                this.h.setText(getString(com.baidu.tieba.a.k.ta_attention_forums));
                this.q.setText(getString(com.baidu.tieba.a.k.no_like_forum_other));
            }
        } else {
            this.q.setText(getString(com.baidu.tieba.a.k.not_have_like_bars));
            this.h.setText(getString(com.baidu.tieba.a.k.my_bar));
        }
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new e(this, (byte) 0);
        this.k.setPriority(3);
        this.k.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.o);
        this.f.b(i);
        this.i.notifyDataSetChanged();
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(EditBarActivity editBarActivity, boolean z) {
        if (editBarActivity.i != null) {
            editBarActivity.i.b();
            if (!editBarActivity.i.c()) {
                editBarActivity.p.setVisibility(8);
                editBarActivity.b.setVisibility(0);
                if (editBarActivity.r == null) {
                    editBarActivity.g.setVisibility(0);
                }
            } else if (z) {
                editBarActivity.g.setVisibility(4);
                editBarActivity.i.a(false);
                editBarActivity.p.setVisibility(0);
                editBarActivity.b.setVisibility(8);
            }
        }
    }
}
