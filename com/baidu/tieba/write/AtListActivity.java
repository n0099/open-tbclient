package com.baidu.tieba.write;

import android.app.Activity;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends com.baidu.tieba.f implements AdapterView.OnItemClickListener, p {
    public static ArrayList<MetaData> a = new ArrayList<>();
    private AtSelectFriendList e;
    private LinearLayout f;
    private Button g;
    private View p;
    private com.baidu.tieba.aj q;
    private NavigationBar t;
    private LinearLayout u;
    private LinearLayout v;
    private ImageView w;
    private EditText b = null;
    private Button c = null;
    private BdListView d = null;
    private final Handler h = new Handler();
    private l i = null;
    private m j = null;
    private com.baidu.tieba.model.c k = null;
    private n l = null;
    private String m = null;
    private ProgressBar n = null;
    private RelativeLayout o = null;
    private final int r = 5;
    private boolean s = true;
    private final Runnable x = new a(this);
    private final Runnable y = new b(this);

    public static void a(Activity activity, int i, boolean z) {
        Intent intent = new Intent(activity, AtListActivity.class);
        if (i == 12011) {
            intent.putExtra("keyboard", false);
        }
        intent.putExtra("is_need_multiple", z);
        activity.startActivityForResult(intent, i);
    }

    public static ArrayList<String> a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringArrayListExtra("name_show");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        this.q = new com.baidu.tieba.aj(this, (int) R.drawable.individual_center_like, (int) R.drawable.individual_center_like_1);
        a(bundle);
        a();
        a((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.o);
        this.q.a(i);
        this.t.c(i);
        this.l.notifyDataSetChanged();
        if (i == 1) {
            this.u.setBackgroundResource(R.color.search_box_bg_1);
            this.v.setBackgroundResource(R.drawable.inputbox_top_1);
            this.w.setImageResource(R.drawable.icon_head_bar_search_1);
            this.b.setTextColor(-11446171);
            this.b.setHintTextColor(-11446171);
            this.c.setBackgroundResource(R.drawable.search_delete_button_1);
            this.p.setBackgroundResource(R.drawable.invite_friend_list_item_bg_color_1);
            return;
        }
        this.u.setBackgroundResource(R.color.search_box_bg);
        this.v.setBackgroundResource(R.drawable.inputbox_top);
        this.w.setImageResource(R.drawable.icon_head_bar_search);
        this.b.setTextColor(-5921112);
        this.b.setHintTextColor(-5921112);
        this.c.setBackgroundResource(R.drawable.search_delete_button);
        this.p.setBackgroundResource(R.drawable.invite_friend_list_item_bg_color);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.q.a();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.q.b();
    }

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

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData metaData = (MetaData) this.l.getItem(i);
        if (metaData != null) {
            if (this.s) {
                if (this.i == null && this.j == null) {
                    if (metaData.isChecked()) {
                        b(metaData);
                    } else if (5 <= this.e.getItemLength()) {
                        showToast(String.format(getString(R.string.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        a(metaData);
                    }
                    metaData.setChecked(metaData.isChecked() ? false : true);
                    this.l.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", metaData.getName_show());
            bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, metaData.getUserName());
            bundle.putString("id", metaData.getUserId());
            bundle.putString("portrait", metaData.getPortrait());
            intent.putExtras(bundle);
            BdUtilHelper.a(this, this.b);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
        this.h.removeCallbacks(this.x);
        this.h.removeCallbacks(this.y);
        if (this.l != null && this.l.a() != null) {
            this.l.a().d();
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        super.onDestroy();
    }

    private void a() {
        this.o = (RelativeLayout) findViewById(R.id.parent);
        this.t = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.t.a(getString(R.string.select_friend));
        this.t.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.u = (LinearLayout) findViewById(R.id.search);
        this.v = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.w = (ImageView) findViewById(R.id.at_search_logo);
        this.b = (EditText) findViewById(R.id.at_search_edit);
        this.b.addTextChangedListener(new f(this));
        this.c = (Button) findViewById(R.id.at_search_del);
        this.c.setOnClickListener(new g(this));
        this.d = (BdListView) findViewById(R.id.list);
        this.l = new n(this, this.s);
        this.l.a(this);
        this.l.a(new h(this));
        this.d.setAdapter((ListAdapter) this.l);
        this.d.setOnItemClickListener(this);
        this.d.setOnScrollListener(new i(this));
        if (!getIntent().getBooleanExtra("keyboard", false) && this.b.getParent() != null) {
            ((View) this.b.getParent()).setFocusable(true);
            ((View) this.b.getParent()).setFocusableInTouchMode(true);
        }
        this.f = (LinearLayout) this.o.findViewById(R.id.invite_candidate);
        this.g = (Button) this.o.findViewById(R.id.button_send);
        this.g.setOnClickListener(new j(this));
        a(0);
        this.e = (AtSelectFriendList) this.o.findViewById(R.id.candidate_list);
        this.e.setMaxCount(5);
        this.e.setImageLoader(this.l.a());
        this.e.setItemOPerationHandler(new k(this));
        b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [501=4] */
    private void b() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(R.dimen.invite_friend_candidate_padding_top);
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
                    ArrayList<MetaData> a2 = this.k.a().a();
                    Iterator<MetaData> it = a2.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    this.l.a(a2);
                } else {
                    this.l.a((ArrayList<MetaData>) null);
                    if (this.j == null) {
                        this.j = new m(this, null);
                        this.j.setPriority(3);
                        this.j.execute("");
                    }
                }
            } else {
                this.i = new l(this, null);
                this.i.setPriority(2);
                this.i.execute(str);
                if (this.j == null && this.k.a() == null) {
                    this.j = new m(this, null);
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
            this.s = bundle.getBoolean("is_need_multiple");
        } else {
            this.s = getIntent().getBooleanExtra("is_need_multiple", true);
        }
    }

    public void a(MetaData metaData) {
        if (metaData != null) {
            this.e.a(metaData);
            a(this.e.getItemLength());
            c();
        }
    }

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
        this.g.setText(String.format(getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.p
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.e.b(metaData);
        }
    }
}
