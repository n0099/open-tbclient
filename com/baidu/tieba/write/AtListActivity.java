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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity implements AdapterView.OnItemClickListener, l {
    private AtSelectFriendList e;
    private LinearLayout f;
    private Button g;
    private View n;
    private com.baidu.tbadk.core.view.k o;
    private NavigationBar r;
    private LinearLayout s;
    private LinearLayout t;
    private ImageView u;
    public List<com.baidu.tbadk.coreExtra.relationship.b> a = null;
    private EditText b = null;
    private Button c = null;
    private BdListView d = null;
    private final Handler h = new Handler();
    private j i = null;
    private String j = null;
    private ProgressBar k = null;
    private RelativeLayout l = null;
    private AtomicBoolean m = new AtomicBoolean(false);
    private final int p = 5;
    private boolean q = true;
    private final Runnable v = new a(this);
    private CustomMessageListener w = new b(this, 2001188);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.d.class, AtListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.at_list_activity);
        this.o = new com.baidu.tbadk.core.view.k(this, com.baidu.tieba.u.individual_center_like, com.baidu.tieba.u.individual_center_like_1, com.baidu.tieba.v.no_data_container, com.baidu.tieba.v.no_data_image, com.baidu.tieba.v.no_data_image_text);
        a(bundle);
        a();
        registerListener(this.w);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.l);
        this.o.a(i);
        this.r.c(i);
        this.i.notifyDataSetChanged();
        if (i == 1) {
            this.s.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d_1);
            this.t.setBackgroundResource(com.baidu.tieba.u.inputbox_top_1);
            this.u.setImageResource(com.baidu.tieba.u.icon_head_bar_search_1);
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.s.widget_searchbox_text_1));
            this.b.setHintTextColor(getResources().getColor(com.baidu.tieba.s.widget_searchbox_text_1));
            this.c.setBackgroundResource(com.baidu.tieba.u.search_delete_button_1);
            this.n.setBackgroundResource(com.baidu.tieba.u.invite_friend_list_item_bg_color_1);
        } else {
            this.s.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d);
            this.t.setBackgroundResource(com.baidu.tieba.u.inputbox_top);
            this.u.setImageResource(com.baidu.tieba.u.icon_head_bar_search);
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.s.widget_searchbox_text));
            this.b.setHintTextColor(getResources().getColor(com.baidu.tieba.s.widget_searchbox_text));
            this.c.setBackgroundResource(com.baidu.tieba.u.search_delete_button);
            this.n.setBackgroundResource(com.baidu.tieba.u.invite_friend_list_item_bg_color);
        }
        this.n.setEnabled(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.o.a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.o.b();
    }

    private void a(boolean z) {
        if (z) {
            this.d.setVisibility(8);
            this.o.b(0);
            this.f.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.o.b(8);
        if (this.q) {
            this.f.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) this.i.getItem(i);
        if (bVar != null) {
            if (this.q) {
                if (!this.m.get()) {
                    if (bVar.isChecked()) {
                        b(bVar);
                    } else if (5 <= this.e.getItemLength()) {
                        showToast(String.format(getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        a(bVar);
                    }
                    bVar.setChecked(bVar.isChecked() ? false : true);
                    this.i.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, bVar.b());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_NAME, bVar.b());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, new StringBuilder(String.valueOf(bVar.c())).toString());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, bVar.d());
            intent.putExtras(bundle);
            com.baidu.adp.lib.util.j.a(this, this.b);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.h.removeCallbacks(this.v);
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    private void a() {
        this.l = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.r = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.r.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.r.a(getString(com.baidu.tieba.y.select_friend));
        this.k = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.s = (LinearLayout) findViewById(com.baidu.tieba.v.search);
        this.t = (LinearLayout) findViewById(com.baidu.tieba.v.search_tap_text_layout);
        this.u = (ImageView) findViewById(com.baidu.tieba.v.at_search_logo);
        this.b = (EditText) findViewById(com.baidu.tieba.v.at_search_edit);
        this.b.addTextChangedListener(new d(this));
        this.c = (Button) findViewById(com.baidu.tieba.v.at_search_del);
        this.c.setOnClickListener(new e(this));
        this.d = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.i = new j(this, this.q);
        this.i.a(this);
        this.i.a(new f(this));
        this.d.setAdapter((ListAdapter) this.i);
        this.d.setOnItemClickListener(this);
        this.d.setOnScrollListener(new g(this));
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.b.getParent() != null) {
            ((View) this.b.getParent()).setFocusable(true);
            ((View) this.b.getParent()).setFocusableInTouchMode(true);
        }
        this.f = (LinearLayout) this.l.findViewById(com.baidu.tieba.v.invite_candidate);
        this.g = (Button) this.l.findViewById(com.baidu.tieba.v.button_send);
        this.g.setOnClickListener(new h(this));
        a(0);
        this.e = (AtSelectFriendList) this.l.findViewById(com.baidu.tieba.v.candidate_list);
        this.e.setMaxCount(5);
        this.e.setItemOPerationHandler(new i(this));
        b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [409=4] */
    private void b() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.n = new View(this);
        this.n.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.d.addFooterView(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!isFinishing()) {
            if (this.a == null) {
                if (!this.m.get()) {
                    this.k.setVisibility(0);
                    this.m.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            if (this.a.isEmpty()) {
                a(true);
            } else {
                a(false);
            }
            String a = com.baidu.adp.lib.util.i.a(this.b.getText(), "");
            if (a.length() == 0) {
                this.i.a(this.a);
            } else {
                LinkedList linkedList = new LinkedList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.a) {
                    String a2 = bVar.a();
                    if (a2 != null && a2.contains(a)) {
                        linkedList.add(bVar);
                    }
                }
                this.i.a(linkedList);
            }
            this.i.notifyDataSetChanged();
            this.d.setSelection(0);
        }
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.q = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.q = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.e.a(bVar);
            a(this.e.getItemLength());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.e.c(bVar);
            a(this.e.getItemLength());
            d();
        }
    }

    private void d() {
        if (this.e.getItemLength() > 0) {
            this.g.setEnabled(true);
        } else {
            this.g.setEnabled(false);
        }
    }

    private void a(int i) {
        this.g.setText(String.format(getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.l
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (bVar != null) {
            this.e.b(bVar);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.d;
    }
}
