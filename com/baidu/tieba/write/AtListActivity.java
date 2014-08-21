package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity implements AdapterView.OnItemClickListener, l {
    private AtSelectFriendList e;
    private LinearLayout f;
    private Button g;
    private View p;
    private com.baidu.tbadk.core.view.p q;
    private NavigationBar t;
    private LinearLayout u;
    private LinearLayout v;
    private ImageView w;
    protected ArrayList<MetaData> a = new ArrayList<>();
    private EditText b = null;
    private Button c = null;
    private BdListView d = null;
    private final Handler h = new Handler();
    private h i = null;
    private i j = null;
    private com.baidu.tieba.model.c k = null;
    private j l = null;
    private String m = null;
    private ProgressBar n = null;
    private RelativeLayout o = null;
    private final int r = 5;
    private boolean s = true;
    private final Runnable x = new a(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.d.class, AtListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.at_list_activity);
        this.q = new com.baidu.tbadk.core.view.p(this, com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1, com.baidu.tieba.u.no_data_container, com.baidu.tieba.u.no_data_image, com.baidu.tieba.u.no_data_image_text);
        a(bundle);
        a();
        a((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.o);
        this.q.a(i);
        this.t.c(i);
        this.l.notifyDataSetChanged();
        if (i == 1) {
            this.u.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
            this.v.setBackgroundResource(com.baidu.tieba.t.inputbox_top_1);
            this.w.setImageResource(com.baidu.tieba.t.icon_head_bar_search_1);
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text_1));
            this.b.setHintTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text_1));
            this.c.setBackgroundResource(com.baidu.tieba.t.search_delete_button_1);
            this.p.setBackgroundResource(com.baidu.tieba.t.invite_friend_list_item_bg_color_1);
        } else {
            this.u.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
            this.v.setBackgroundResource(com.baidu.tieba.t.inputbox_top);
            this.w.setImageResource(com.baidu.tieba.t.icon_head_bar_search);
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text));
            this.b.setHintTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text));
            this.c.setBackgroundResource(com.baidu.tieba.t.search_delete_button);
            this.p.setBackgroundResource(com.baidu.tieba.t.invite_friend_list_item_bg_color);
        }
        this.p.setEnabled(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.q.a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.q.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.d.setVisibility(8);
            this.q.b(0);
            this.f.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.q.b(8);
        if (this.s) {
            this.f.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.l.getItem(i);
        if (item != null) {
            if (this.s) {
                if (this.i == null && this.j == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.e.getItemLength()) {
                        showToast(String.format(getString(com.baidu.tieba.x.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.l.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, item.getName_show());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_NAME, item.getUserName());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, item.getUserId());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            com.baidu.adp.lib.util.j.a(this, this.b);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
        this.h.removeCallbacks(this.x);
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a() {
        this.o = (RelativeLayout) findViewById(com.baidu.tieba.u.parent);
        this.t = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.t.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.t.a(getString(com.baidu.tieba.x.select_friend));
        this.n = (ProgressBar) findViewById(com.baidu.tieba.u.progress);
        this.u = (LinearLayout) findViewById(com.baidu.tieba.u.search);
        this.v = (LinearLayout) findViewById(com.baidu.tieba.u.search_tap_text_layout);
        this.w = (ImageView) findViewById(com.baidu.tieba.u.at_search_logo);
        this.b = (EditText) findViewById(com.baidu.tieba.u.at_search_edit);
        this.b.addTextChangedListener(new c(this));
        this.c = (Button) findViewById(com.baidu.tieba.u.at_search_del);
        this.c.setOnClickListener(new d(this));
        this.d = (BdListView) findViewById(com.baidu.tieba.u.list);
        this.l = new j(this, this.s);
        this.l.a(this);
        this.l.a(new e(this));
        this.d.setAdapter((ListAdapter) this.l);
        this.d.setOnItemClickListener(this);
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.b.getParent() != null) {
            ((View) this.b.getParent()).setFocusable(true);
            ((View) this.b.getParent()).setFocusableInTouchMode(true);
        }
        this.f = (LinearLayout) this.o.findViewById(com.baidu.tieba.u.invite_candidate);
        this.g = (Button) this.o.findViewById(com.baidu.tieba.u.button_send);
        this.g.setOnClickListener(new f(this));
        a(0);
        this.e = (AtSelectFriendList) this.o.findViewById(com.baidu.tieba.u.candidate_list);
        this.e.setMaxCount(5);
        this.e.setItemOPerationHandler(new g(this));
        b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [398=4] */
    private void b() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.s.invite_friend_candidate_padding_top);
        this.p = new View(this);
        this.p.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.d.addFooterView(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!isFinishing()) {
            this.l.a((ArrayList<MetaData>) null);
            if (this.i != null) {
                this.i.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.k.a() != null) {
                    ArrayList<MetaData> a = this.k.a().a();
                    Iterator<MetaData> it = a.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    this.l.a(a);
                } else {
                    this.l.a((ArrayList<MetaData>) null);
                    if (this.j == null) {
                        this.j = new i(this, null);
                        this.j.setPriority(3);
                        this.j.execute("");
                    }
                }
            } else {
                this.i = new h(this, null);
                this.i.setPriority(2);
                this.i.execute(str);
                if (this.j == null && this.k.a() == null) {
                    this.j = new i(this, null);
                    this.j.setPriority(3);
                    this.j.execute("");
                }
            }
            this.l.notifyDataSetInvalidated();
            this.d.setSelection(0);
        }
    }

    private void a(Bundle bundle) {
        this.k = new com.baidu.tieba.model.c();
        if (bundle != null) {
            this.s = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.s = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.e.a(metaData);
            a(this.e.getItemLength());
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.e.c(metaData);
            a(this.e.getItemLength());
            c();
        }
    }

    private void c() {
        if (this.e.getItemLength() > 0) {
            this.g.setEnabled(true);
        } else {
            this.g.setEnabled(false);
        }
    }

    private void a(int i) {
        this.g.setText(String.format(getString(com.baidu.tieba.x.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.l
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.e.b(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.d;
    }
}
