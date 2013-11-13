package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EditBarActivity extends com.baidu.tieba.j {
    private NavigationBar c;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.e f2198a = null;
    private ListView b = null;
    private TextView d = null;
    private TextView e = null;
    private i f = null;
    private ProgressBar g = null;
    private g h = null;
    private int i = -1;
    private String j = null;
    private h k = null;
    private RelativeLayout l = null;
    private FrameLayout m = null;
    private TextView n = null;
    private String o = null;
    private int p = 0;

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, EditBarActivity.class);
        if (str != null) {
            intent.putExtra("view_user_id", str);
            intent.putExtra("user_sex", i2);
        }
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_bar_activity);
        b();
        c();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.h = new g(this, null);
        this.h.setPriority(3);
        this.h.execute(new Object[0]);
    }

    private void b() {
        this.f2198a = new com.baidu.tieba.model.e();
        this.o = getIntent().getStringExtra("view_user_id");
        this.p = getIntent().getIntExtra("user_sex", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.c(i);
        com.baidu.tieba.util.bd.a(this.l, i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.b.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.b.setSelector(R.drawable.list_selector_1);
            this.n.setTextColor(getResources().getColor(R.color.person_post_header_uname_1));
            return;
        }
        this.b.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.b.setSelector(R.drawable.list_selector);
        this.n.setTextColor(getResources().getColor(R.color.person_post_header_uname));
    }

    private void c() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.c = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.e = this.c.a("");
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.edit));
        this.m = (FrameLayout) findViewById(R.id.empty_textview_container);
        this.n = (TextView) findViewById(R.id.empty_textview);
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.f = new i(this, this.f2198a);
        this.f.a(new d(this));
        this.b = (ListView) findViewById(R.id.list);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setOnItemClickListener(new e(this));
        this.d.setOnClickListener(new f(this));
        if (this.o != null) {
            this.d.setVisibility(4);
            if (this.p == 2) {
                this.e.setText(getString(R.string.her_attention_forums));
                this.n.setText(getString(R.string.she_no_like_forum_other));
                return;
            } else if (this.p == 1) {
                this.e.setText(getString(R.string.his_attention_forums));
                this.n.setText(getString(R.string.he_no_like_forum_other));
                return;
            } else {
                this.e.setText(getString(R.string.ta_attention_forums));
                this.n.setText(getString(R.string.no_like_forum_other));
                return;
            }
        }
        this.n.setText(getString(R.string.not_have_like_bars));
        this.e.setText(getString(R.string.my_bar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f != null) {
            this.f.b();
            if (this.f.c()) {
                if (z) {
                    this.d.setVisibility(4);
                    this.f.a(false);
                    this.m.setVisibility(0);
                }
            } else if (this.o == null) {
                this.d.setVisibility(0);
                this.m.setVisibility(8);
            }
        }
    }
}
