package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtListActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MetaData> f2759a = new ArrayList<>();
    private com.baidu.tieba.aq m;
    private NavigationBar n;
    private LinearLayout o;
    private LinearLayout p;
    private ImageView q;
    private EditText b = null;
    private Button c = null;
    private ListView d = null;
    private Handler e = new Handler();
    private i f = null;
    private j g = null;
    private com.baidu.tieba.model.d h = null;
    private k i = null;
    private String j = null;
    private ProgressBar k = null;
    private RelativeLayout l = null;
    private Runnable r = new a(this);
    private Runnable s = new b(this);

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, AtListActivity.class);
        if (i == 12011) {
            intent.putExtra("keyboard", false);
        }
        activity.startActivityForResult(intent, i);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("name_show");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        this.m = new com.baidu.tieba.aq(this, (int) R.drawable.individual_center_like, (int) R.drawable.individual_center_like_1);
        a(bundle);
        a();
        a((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.m.a(i);
        com.baidu.tieba.util.ba.a(this.l, i);
        this.n.c(i);
        this.i.notifyDataSetChanged();
        if (i == 1) {
            this.d.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            com.baidu.tieba.util.ba.e(this.o, (int) R.drawable.inputbox_topbg_1);
            this.p.setBackgroundResource(R.drawable.inputbox_top_1);
            this.q.setImageResource(R.drawable.icon_head_bar_search_1);
            this.b.setTextColor(-11446171);
            this.b.setHintTextColor(-11446171);
            this.c.setBackgroundResource(R.drawable.search_delete_button_1);
            return;
        }
        this.d.setDivider(getResources().getDrawable(R.drawable.list_divider));
        com.baidu.tieba.util.ba.e(this.o, (int) R.drawable.tabbar_bj_tab);
        this.p.setBackgroundResource(R.drawable.inputbox_top);
        this.q.setImageResource(R.drawable.icon_head_bar_search);
        this.b.setTextColor(-5921112);
        this.b.setHintTextColor(-5921112);
        this.c.setBackgroundResource(R.drawable.search_delete_button);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.m.a();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.m.b();
    }

    public void a(boolean z) {
        if (z) {
            this.d.setVisibility(8);
            this.m.b(0);
            return;
        }
        this.d.setVisibility(0);
        this.m.b(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.f != null) {
            this.f.cancel();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        this.e.removeCallbacks(this.r);
        this.e.removeCallbacks(this.s);
        if (this.i != null) {
            this.i.a();
            if (this.i.b() != null) {
                this.i.b().b();
            }
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.n = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.n.a(getString(R.string.select_friend));
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.k = (ProgressBar) findViewById(R.id.progress);
        this.o = (LinearLayout) findViewById(R.id.search);
        this.p = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.q = (ImageView) findViewById(R.id.at_search_logo);
        this.b = (EditText) findViewById(R.id.at_search_edit);
        this.b.addTextChangedListener(new e(this));
        this.c = (Button) findViewById(R.id.at_search_del);
        this.c.setOnClickListener(new f(this));
        this.d = (ListView) findViewById(R.id.list);
        this.i = new k(this, false, true);
        this.d.setAdapter((ListAdapter) this.i);
        this.d.setOnItemClickListener(new g(this));
        this.d.setOnScrollListener(new h(this));
        if (!getIntent().getBooleanExtra("keyboard", true) && this.b.getParent() != null) {
            ((View) this.b.getParent()).setFocusable(true);
            ((View) this.b.getParent()).setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!isFinishing()) {
            this.i.a(null);
            if (this.f != null) {
                this.f.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.h.a() != null) {
                    this.i.a(this.h.a().a());
                } else {
                    this.i.a(null);
                    if (this.g == null) {
                        this.g = new j(this, null);
                        this.g.setPriority(3);
                        this.g.execute("");
                    }
                }
            } else {
                this.f = new i(this, null);
                this.f.setPriority(2);
                this.f.execute(str);
                if (this.g == null && this.h.a() == null) {
                    this.g = new j(this, null);
                    this.g.setPriority(3);
                    this.g.execute("");
                }
            }
            this.i.notifyDataSetInvalidated();
            this.d.setSelection(0);
        }
    }

    private void a(Bundle bundle) {
        this.h = new com.baidu.tieba.model.d();
    }
}
