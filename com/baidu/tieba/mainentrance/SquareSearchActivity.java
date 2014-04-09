package com.baidu.tieba.mainentrance;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.al;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends com.baidu.tbadk.a {
    private FragmentTabWidget E;
    private NavigationBar i;
    private EditText c = null;
    private Button d = null;
    private TextView e = null;
    private LinearLayout f = null;
    private FrameLayout g = null;
    private LinearLayoutDetectsSoftKeyboard h = null;
    ImageView a = null;
    private FrameLayout j = null;
    private ListView k = null;
    private a l = null;
    private ListView m = null;
    private a n = null;
    private ad o = null;
    private c p = null;
    private ProgressBar q = null;
    private Button r = null;
    private View s = null;
    private TextView t = null;
    private BarSuggestModel u = null;
    private SearchPostModel v = null;
    private ab w = null;
    private ac x = null;
    private String y = null;
    private int z = 0;
    private String A = null;
    final View.OnClickListener b = new s(this);
    private final Handler B = new Handler();
    private final Runnable C = new u(this);
    private boolean D = true;
    private com.baidu.adp.framework.c.a F = new v(this, 2009002);
    private com.baidu.adp.framework.c.a G = new w(this, 2009001);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new x());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2009001, new y());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2015002, new f());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask3);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.home_dialog_search);
        this.E = (FragmentTabWidget) findViewById(com.baidu.tieba.a.h.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.a.f.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.b = com.baidu.tieba.a.e.main_bottom_button_color_1;
        fragmentTabIndicator.a = com.baidu.tieba.a.e.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.a.k.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.b = com.baidu.tieba.a.e.main_bottom_button_color_1;
        fragmentTabIndicator2.a = com.baidu.tieba.a.e.main_bottom_button_color;
        fragmentTabIndicator2.a(0, getResources().getDimension(com.baidu.tieba.a.f.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.a.k.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(this);
        fragmentTabIndicator3.b = com.baidu.tieba.a.e.main_bottom_button_color_1;
        fragmentTabIndicator3.a = com.baidu.tieba.a.e.main_bottom_button_color;
        fragmentTabIndicator3.a(0, getResources().getDimension(com.baidu.tieba.a.f.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.a.k.search_in_baidu_text));
        this.E.addView(fragmentTabIndicator);
        this.E.addView(fragmentTabIndicator2);
        this.E.addView(fragmentTabIndicator3);
        this.E.a(0, true);
        this.E.setTabSelectionListener(new t(this));
        this.i = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new r(this));
        View a = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.a.i.square_search_navigation_view, (View.OnClickListener) null);
        this.a = (ImageView) a.findViewById(com.baidu.tieba.a.h.search_bar_icon);
        this.c = (EditText) a.findViewById(com.baidu.tieba.a.h.home_et_search);
        this.d = (Button) a.findViewById(com.baidu.tieba.a.h.home_bt_search_del);
        this.e = (TextView) a.findViewById(com.baidu.tieba.a.h.home_bt_search_s);
        this.s = getLayoutInflater().inflate(com.baidu.tieba.a.i.home_dialog_search_footer, (ViewGroup) null);
        this.t = (TextView) findViewById(com.baidu.tieba.a.h.text_no_data);
        this.c.setOnFocusChangeListener(new aa(this));
        this.e.setText(getString(com.baidu.tieba.a.k.enter_forum));
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(com.baidu.tieba.a.h.search_tap_text_layout);
        this.g = (FrameLayout) findViewById(com.baidu.tieba.a.h.frame_layout);
        this.h = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.a.h.parent);
        this.h.setOnSoftKeyBoardShownListener(new g(this));
        this.h.setOnTouchListener(new h(this));
        this.c.setOnEditorActionListener(new i(this));
        this.d.setOnClickListener(new j(this));
        this.c.addTextChangedListener(new k(this));
        this.j = (FrameLayout) findViewById(com.baidu.tieba.a.h.home_search_list);
        this.k = (ListView) findViewById(com.baidu.tieba.a.h.home_lv_search);
        this.r = (Button) this.s.findViewById(com.baidu.tieba.a.h.home_bt_search_footer);
        this.r.setOnClickListener(new l(this));
        this.k.addFooterView(this.s, null, true);
        this.o = new ad(this, null);
        this.l = new a(this, null);
        this.k.setAdapter((ListAdapter) this.l);
        this.k.setOnItemClickListener(new o(this));
        this.m = (ListView) findViewById(com.baidu.tieba.a.h.home_lv_suggest);
        this.n = new a(this, null);
        this.p = new c(this);
        this.m.setAdapter((ListAdapter) this.n);
        this.m.setOnItemClickListener(new p(this));
        q qVar = new q(this);
        this.m.setOnScrollListener(qVar);
        this.k.setOnScrollListener(qVar);
        this.q = (ProgressBar) findViewById(com.baidu.tieba.a.h.home_progress_search);
        this.q.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        c();
        ShowSoftKeyPadDelay(this.c, 150);
        if (com.baidu.tieba.p.c().i()) {
            a(0);
        } else {
            a(1);
        }
        getWindow().setSoftInputMode(1);
        com.baidu.adp.framework.c.a().a(this.F);
        com.baidu.adp.framework.c.a().a(this.G);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.D) {
            com.baidu.adp.lib.util.f.e("simon", "onResume", "show keyboard");
            this.B.post(new z(this));
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.z = 0;
        if (this.z == 0) {
            com.baidu.tieba.p.c().b(true);
        } else {
            com.baidu.tieba.p.c().b(false);
        }
        if (this.q != null) {
            this.q.setVisibility(8);
        }
        if (this.p != null) {
            this.p.a();
        }
        a();
        com.baidu.adp.framework.c.a().b(this.F);
        com.baidu.adp.framework.c.a().b(this.G);
    }

    public final void a() {
        this.B.removeCallbacks(this.C);
        if (this.w != null) {
            this.w.cancel();
            this.w = null;
        }
        if (this.x != null) {
            this.x.cancel();
            this.x = null;
        }
    }

    public final void a(int i) {
        switch (i) {
            case 0:
                if (this.z != 0) {
                    this.z = 0;
                    this.e.setText(getString(com.baidu.tieba.a.k.enter_forum));
                    this.c.setHint(com.baidu.tieba.a.k.search_bar);
                    a();
                    if (this.y.trim().length() > 0) {
                        e();
                        return;
                    } else {
                        c();
                        return;
                    }
                }
                return;
            case 1:
                if (this.z != 1) {
                    this.z = 1;
                    this.e.setText(getString(com.baidu.tieba.a.k.search));
                    this.c.setHint(com.baidu.tieba.a.k.search_post_hint);
                    a();
                    if (this.y.trim().length() > 0) {
                        this.m.setVisibility(8);
                        a(1, this.y);
                        return;
                    }
                    d();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b() {
        sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this).a(this.c.getText().toString().trim(), "tb_searchlist", 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.m.setVisibility(8);
        a(true, (ArrayList<String>) null);
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.m.setVisibility(8);
        a(false, (ArrayList<String>) null);
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0 || ((z && this.z != 0) || (!z && this.z != 1))) {
            this.j.setVisibility(8);
            this.t.setVisibility(0);
            this.t.setText(com.baidu.tieba.a.k.text_no_search_record);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        this.t.setVisibility(8);
        this.l.a(arrayList);
        this.l.a(z);
        this.l.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.j.setVisibility(8);
        this.B.removeCallbacks(this.C);
        this.B.postDelayed(this.C, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.k.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tbadk.core.data.n.a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    a();
                    this.x = new ac(this, stringBuffer.toString(), arrayList);
                    this.x.setPriority(3);
                    this.x.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(SquareSearchActivity squareSearchActivity) {
        try {
            if (squareSearchActivity.z == 0) {
                if (squareSearchActivity.u != null) {
                    if (squareSearchActivity.u.forum_list == null || squareSearchActivity.u.forum_list.size() <= 0) {
                        squareSearchActivity.j.setVisibility(8);
                        squareSearchActivity.t.setVisibility(0);
                        squareSearchActivity.t.setText(com.baidu.tieba.a.k.text_no_suggest);
                    } else {
                        squareSearchActivity.j.setVisibility(0);
                        squareSearchActivity.k.setVisibility(8);
                        squareSearchActivity.m.setVisibility(0);
                        squareSearchActivity.m.setAdapter((ListAdapter) squareSearchActivity.o);
                        squareSearchActivity.o.a(squareSearchActivity.u.forum_list);
                        squareSearchActivity.o.notifyDataSetInvalidated();
                    }
                }
            } else if (squareSearchActivity.v != null) {
                ArrayList<al> data = squareSearchActivity.v.getData();
                if (data == null || data.size() <= 0) {
                    squareSearchActivity.j.setVisibility(8);
                    squareSearchActivity.t.setVisibility(0);
                    squareSearchActivity.t.setText(com.baidu.tieba.a.k.text_no_suggest);
                } else {
                    squareSearchActivity.j.setVisibility(0);
                    squareSearchActivity.k.setVisibility(8);
                    squareSearchActivity.m.setVisibility(0);
                    squareSearchActivity.m.setAdapter((ListAdapter) squareSearchActivity.p);
                    squareSearchActivity.p.a(squareSearchActivity.v);
                    squareSearchActivity.p.notifyDataSetInvalidated();
                    if (squareSearchActivity.v.hasPre()) {
                        squareSearchActivity.m.setSelection(1);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(squareSearchActivity.getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.a
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.i.b(i);
        this.E.a(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.h);
        ba.a(this.h, i);
        if (i == 1) {
            this.g.setBackgroundResource(com.baidu.tieba.a.e.square_listview_bg_1);
            this.s.setBackgroundResource(com.baidu.tieba.a.e.square_listview_bg_1);
            this.c.setTextColor(-6574132);
            this.c.setHintTextColor(-11643034);
            this.r.setTextColor(getResources().getColor(com.baidu.tieba.a.e.no_data_search_text_content_night));
            this.a.setImageResource(com.baidu.tieba.a.g.icon_search_ba_1);
            ba.e((View) this.r, com.baidu.tieba.a.g.clear_search_btn_drawable_1);
            ba.e(this.f, com.baidu.tieba.a.g.inputbox_top_1);
            this.e.setTextColor(getResources().getColor(com.baidu.tieba.a.e.common_new_page_title_1));
            this.t.setTextColor(-11446171);
            this.t.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.a.g.pic_search_fruitless_1, 0, 0);
            return;
        }
        this.g.setBackgroundResource(com.baidu.tieba.a.e.square_listview_bg);
        this.s.setBackgroundResource(com.baidu.tieba.a.e.square_listview_bg);
        this.a.setImageResource(com.baidu.tieba.a.g.icon_search_ba);
        this.e.setTextColor(getResources().getColor(com.baidu.tieba.a.e.white));
        this.c.setTextColor(-2300171);
        this.c.setHintTextColor(-10195067);
        this.r.setTextColor(getResources().getColor(com.baidu.tieba.a.e.no_data_search_text_content));
        ba.e((View) this.r, com.baidu.tieba.a.g.clear_search_btn_drawable);
        ba.e(this.f, com.baidu.tieba.a.g.inputbox_top);
        this.t.setTextColor(-3618616);
        this.t.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.a.g.pic_search_fruitless, 0, 0);
    }

    @Override // com.baidu.tbadk.a
    protected void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        this.t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
