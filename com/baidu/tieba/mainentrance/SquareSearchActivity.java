package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ao;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity {
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
    private CustomMessageListener F = new v(this, 2009002);
    private CustomMessageListener G = new w(this, 2009001);

    static {
        e();
        f();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new f());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new x());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new y());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!g()) {
            setContentView(com.baidu.tieba.w.home_dialog_search);
            b();
            getWindow().setSoftInputMode(1);
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.G);
        }
    }

    private boolean g() {
        if ("from_hao123".equals(getIntent().getStringExtra("start_from")) && com.baidu.tieba.util.r.a((Activity) this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 18);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ao(this, intent)));
            finish();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.D) {
            this.B.post(new z(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.z = 0;
        if (this.z == 0) {
            ai.c().c(true);
        } else {
            ai.c().c(false);
        }
        c();
        a();
        MessageManager.getInstance().unRegisterListener(this.F);
        MessageManager.getInstance().unRegisterListener(this.G);
    }

    public void a() {
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

    public void b() {
        i();
        h();
        this.s = getLayoutInflater().inflate(com.baidu.tieba.w.home_dialog_search_footer, (ViewGroup) null);
        this.t = (TextView) findViewById(com.baidu.tieba.v.text_no_data);
        this.c.setOnFocusChangeListener(new aa(this));
        this.e.setText(getString(com.baidu.tieba.y.enter_forum));
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(com.baidu.tieba.v.search_tap_text_layout);
        this.g = (FrameLayout) findViewById(com.baidu.tieba.v.frame_layout);
        this.h = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.v.parent);
        this.h.setOnSoftKeyBoardShownListener(new g(this));
        this.h.setOnTouchListener(new h(this));
        this.c.setOnEditorActionListener(new i(this));
        this.d.setOnClickListener(new j(this));
        this.c.addTextChangedListener(new k(this));
        this.j = (FrameLayout) findViewById(com.baidu.tieba.v.home_search_list);
        this.k = (ListView) findViewById(com.baidu.tieba.v.home_lv_search);
        this.r = (Button) this.s.findViewById(com.baidu.tieba.v.home_bt_search_footer);
        this.r.setOnClickListener(new l(this));
        this.k.addFooterView(this.s, null, true);
        this.o = new ad(this, null);
        this.l = new a(this, null);
        this.k.setAdapter((ListAdapter) this.l);
        this.k.setOnItemClickListener(new o(this));
        this.m = (ListView) findViewById(com.baidu.tieba.v.home_lv_suggest);
        this.n = new a(this, null);
        this.p = new c(this);
        this.m.setAdapter((ListAdapter) this.n);
        this.m.setOnItemClickListener(new p(this));
        q qVar = new q(this);
        this.m.setOnScrollListener(qVar);
        this.k.setOnScrollListener(qVar);
        this.q = (ProgressBar) findViewById(com.baidu.tieba.v.home_progress_search);
        this.q.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        j();
        ShowSoftKeyPadDelay(this.c, 150);
        if (ai.c().l()) {
            a(0);
        } else {
            a(1);
        }
    }

    private void h() {
        this.i = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new r(this));
        View a = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.square_search_navigation_view, (View.OnClickListener) null);
        this.a = (ImageView) a.findViewById(com.baidu.tieba.v.search_bar_icon);
        this.c = (EditText) a.findViewById(com.baidu.tieba.v.home_et_search);
        this.d = (Button) a.findViewById(com.baidu.tieba.v.home_bt_search_del);
        this.e = (TextView) a.findViewById(com.baidu.tieba.v.home_bt_search_s);
    }

    private void i() {
        this.E = (FragmentTabWidget) findViewById(com.baidu.tieba.v.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.b = com.baidu.tieba.s.main_bottom_button_color_1;
        fragmentTabIndicator.a = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.b = com.baidu.tieba.s.main_bottom_button_color_1;
        fragmentTabIndicator2.a = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.a(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(this);
        fragmentTabIndicator3.b = com.baidu.tieba.s.main_bottom_button_color_1;
        fragmentTabIndicator3.a = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator3.a(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.y.search_in_baidu_text));
        this.E.addView(fragmentTabIndicator);
        this.E.addView(fragmentTabIndicator2);
        this.E.addView(fragmentTabIndicator3);
        this.E.a(0, true);
        this.E.setTabSelectionListener(new t(this));
    }

    public void c() {
        if (this.q != null) {
            this.q.setVisibility(8);
        }
        if (this.p != null) {
            this.p.a();
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.z != 0) {
                    this.z = 0;
                    this.e.setText(getString(com.baidu.tieba.y.enter_forum));
                    this.c.setHint(com.baidu.tieba.y.search_bar);
                    a();
                    if (this.y.trim().length() > 0) {
                        l();
                        return;
                    } else {
                        j();
                        return;
                    }
                }
                return;
            case 1:
                if (this.z != 1) {
                    this.z = 1;
                    this.e.setText(getString(com.baidu.tieba.y.search));
                    this.c.setHint(com.baidu.tieba.y.search_post_hint);
                    a();
                    if (this.y.trim().length() > 0) {
                        this.m.setVisibility(8);
                        a(1, this.y);
                        return;
                    }
                    k();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void d() {
        sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this).a(this.c.getText().toString().trim(), "tb_searchlist", 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.m.setVisibility(8);
        a(true, (ArrayList<String>) null);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.m.setVisibility(8);
        a(false, (ArrayList<String>) null);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((z && this.z != 0) || (!z && this.z != 1))) {
            this.j.setVisibility(8);
            this.t.setVisibility(0);
            this.t.setText(com.baidu.tieba.y.text_no_search_record);
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
    public void l() {
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
                    stringBuffer.append(TbConfig.SERVER_ADDRESS);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "search_post"));
                    a();
                    this.x = new ac(this, stringBuffer.toString(), arrayList);
                    this.x.setPriority(3);
                    this.x.execute(new Object[0]);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            if (this.z == 0) {
                if (this.u != null) {
                    if (this.u.forum_list != null && this.u.forum_list.size() > 0) {
                        this.j.setVisibility(0);
                        this.k.setVisibility(8);
                        this.m.setVisibility(0);
                        this.m.setAdapter((ListAdapter) this.o);
                        this.o.a(this.u.forum_list);
                        this.o.notifyDataSetInvalidated();
                    } else {
                        this.j.setVisibility(8);
                        this.t.setVisibility(0);
                        this.t.setText(com.baidu.tieba.y.text_no_suggest);
                    }
                }
            } else if (this.v != null) {
                ArrayList<as> data = this.v.getData();
                if (data != null && data.size() > 0) {
                    this.j.setVisibility(0);
                    this.k.setVisibility(8);
                    this.m.setVisibility(0);
                    this.m.setAdapter((ListAdapter) this.p);
                    this.p.a(this.v);
                    this.p.notifyDataSetInvalidated();
                    if (this.v.hasPre()) {
                        this.m.setSelection(1);
                    }
                } else {
                    this.j.setVisibility(8);
                    this.t.setVisibility(0);
                    this.t.setText(com.baidu.tieba.y.text_no_suggest);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.i.c(i);
        this.E.a(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.h);
        bk.a(this.h, i);
        if (this.l != null) {
            this.l.notifyDataSetChanged();
        }
        if (this.n != null) {
            this.n.notifyDataSetChanged();
        }
        if (this.o != null) {
            this.o.notifyDataSetChanged();
        }
        if (this.p != null) {
            this.p.notifyDataSetChanged();
        }
        if (i == 1) {
            this.g.setBackgroundResource(com.baidu.tieba.s.square_listview_bg_1);
            this.s.setBackgroundResource(com.baidu.tieba.s.square_listview_bg_1);
            this.c.setTextColor(-6574132);
            this.c.setHintTextColor(-11643034);
            this.r.setTextColor(getResources().getColor(com.baidu.tieba.s.no_data_search_text_content_night));
            this.a.setImageResource(com.baidu.tieba.u.icon_search_ba_1);
            bk.e((View) this.r, com.baidu.tieba.u.clear_search_btn_drawable_1);
            bk.e(this.f, com.baidu.tieba.u.square_inputbox_top_1);
            this.e.setTextColor(getResources().getColor(com.baidu.tieba.s.common_new_page_title_1));
            this.t.setTextColor(-11446171);
            this.t.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.u.pic_search_fruitless_1, 0, 0);
            return;
        }
        this.g.setBackgroundResource(com.baidu.tieba.s.square_listview_bg);
        this.s.setBackgroundResource(com.baidu.tieba.s.square_listview_bg);
        this.a.setImageResource(com.baidu.tieba.u.icon_search_ba);
        this.e.setTextColor(getResources().getColor(com.baidu.tieba.s.white));
        this.c.setTextColor(-2300171);
        this.c.setHintTextColor(-10195067);
        this.r.setTextColor(getResources().getColor(com.baidu.tieba.s.no_data_search_text_content));
        bk.e((View) this.r, com.baidu.tieba.u.clear_search_btn_drawable);
        bk.e(this.f, com.baidu.tieba.u.square_inputbox_top);
        this.t.setTextColor(-3618616);
        this.t.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.u.pic_search_fruitless, 0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.b.b.a(this, 1);
        } else {
            com.baidu.tbadk.core.b.b.a(this, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        this.t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
