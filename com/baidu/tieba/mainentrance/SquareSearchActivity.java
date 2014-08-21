package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.at;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity {
    private FragmentTabWidget I;
    private NavigationBar h;
    private EditText c = null;
    private Button d = null;
    private TextView e = null;
    private FrameLayout f = null;
    private LinearLayoutDetectsSoftKeyboard g = null;
    ImageView a = null;
    private FrameLayout i = null;
    private ListView j = null;
    private a k = null;
    private ListView l = null;
    private a m = null;
    private aj n = null;
    private e o = null;
    private ProgressBar p = null;
    private Button q = null;
    private View r = null;
    private TextView s = null;
    private Bitmap t = null;
    private BarSuggestModel u = null;
    private SearchPostModel v = null;
    private ah w = null;
    private ai x = null;
    private String y = null;
    private int z = 0;
    private String A = null;
    private String B = null;
    final View.OnClickListener b = new v(this);
    private CustomMessageListener C = new aa(this, 2001195);
    private CustomMessageListener D = new ab(this, 2001194);
    private HttpMessageListener E = new ac(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Handler F = new Handler();
    private final Runnable G = new ad(this);
    private boolean H = true;
    private CustomMessageListener J = new ae(this, 2009002);
    private CustomMessageListener K = new af(this, 2009001);

    static {
        e();
        f();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new ag());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void g() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!h()) {
            setContentView(com.baidu.tieba.v.home_dialog_search);
            b();
            getWindow().setSoftInputMode(1);
            g();
            registerListener(this.C);
            registerListener(this.D);
            registerListener(this.J);
            registerListener(this.K);
            registerListener(this.E);
        }
    }

    private boolean h() {
        if ("from_hao123".equals(getIntent().getStringExtra("start_from")) && com.baidu.tieba.util.r.a((Activity) this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 18);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new as(this, intent)));
            finish();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.H) {
            this.F.post(new j(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.z = 0;
        if (this.z == 0) {
            com.baidu.tieba.ai.c().c(true);
        } else {
            com.baidu.tieba.ai.c().c(false);
        }
        c();
        a();
    }

    public void a() {
        this.F.removeCallbacks(this.G);
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
        j();
        i();
        this.r = com.baidu.adp.lib.e.b.a().a(this, com.baidu.tieba.v.home_dialog_search_footer, null);
        this.s = (TextView) findViewById(com.baidu.tieba.u.text_no_data);
        this.c.setOnFocusChangeListener(new k(this));
        this.e.setText(getString(com.baidu.tieba.x.enter_forum));
        this.e.setOnClickListener(this.b);
        this.f = (FrameLayout) findViewById(com.baidu.tieba.u.frame_layout);
        this.g = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.u.parent);
        this.g.setOnSoftKeyBoardShownListener(new l(this));
        this.g.setOnTouchListener(new m(this));
        this.c.setOnEditorActionListener(new n(this));
        this.d.setOnClickListener(new o(this));
        this.c.addTextChangedListener(new p(this));
        this.i = (FrameLayout) findViewById(com.baidu.tieba.u.home_search_list);
        this.j = (ListView) findViewById(com.baidu.tieba.u.home_lv_search);
        this.q = (Button) this.r.findViewById(com.baidu.tieba.u.home_bt_search_footer);
        this.q.setOnClickListener(new q(this));
        this.j.addFooterView(this.r, null, true);
        this.n = new aj(this, null);
        this.k = new a(this, null);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnItemClickListener(new u(this));
        this.l = (ListView) findViewById(com.baidu.tieba.u.home_lv_suggest);
        this.m = new a(this, null);
        this.o = new e(this);
        this.l.setAdapter((ListAdapter) this.m);
        this.l.setOnItemClickListener(new w(this));
        x xVar = new x(this);
        this.l.setOnScrollListener(xVar);
        this.j.setOnScrollListener(xVar);
        this.p = (ProgressBar) findViewById(com.baidu.tieba.u.home_progress_search);
        this.p.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        k();
        ShowSoftKeyPadDelay(this.c, 150);
        if (com.baidu.tieba.ai.c().l()) {
            a(0);
        } else {
            a(1);
        }
    }

    private void i() {
        this.h = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new y(this));
        View a = this.h.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.v.square_search_navigation_view, (View.OnClickListener) null);
        this.a = (ImageView) a.findViewById(com.baidu.tieba.u.search_bar_icon);
        this.c = (EditText) a.findViewById(com.baidu.tieba.u.home_et_search);
        this.d = (Button) a.findViewById(com.baidu.tieba.u.home_bt_search_del);
        this.e = (TextView) a.findViewById(com.baidu.tieba.u.home_bt_search_s);
    }

    private void j() {
        this.I = (FragmentTabWidget) findViewById(com.baidu.tieba.u.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.s.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.b = com.baidu.tieba.r.main_bottom_button_color_1;
        fragmentTabIndicator.a = com.baidu.tieba.r.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.x.search_bar_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.b = com.baidu.tieba.r.main_bottom_button_color_1;
        fragmentTabIndicator2.a = com.baidu.tieba.r.main_bottom_button_color;
        fragmentTabIndicator2.a(0, getResources().getDimension(com.baidu.tieba.s.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.x.search_post_text));
        FragmentTabIndicator fragmentTabIndicator3 = new FragmentTabIndicator(this);
        fragmentTabIndicator3.b = com.baidu.tieba.r.main_bottom_button_color_1;
        fragmentTabIndicator3.a = com.baidu.tieba.r.main_bottom_button_color;
        fragmentTabIndicator3.a(0, getResources().getDimension(com.baidu.tieba.s.ds32));
        fragmentTabIndicator3.setGravity(17);
        fragmentTabIndicator3.setText(getResources().getString(com.baidu.tieba.x.search_person));
        FragmentTabIndicator fragmentTabIndicator4 = new FragmentTabIndicator(this);
        fragmentTabIndicator4.b = com.baidu.tieba.r.main_bottom_button_color_1;
        fragmentTabIndicator4.a = com.baidu.tieba.r.main_bottom_button_color;
        fragmentTabIndicator4.a(0, getResources().getDimension(com.baidu.tieba.s.ds32));
        fragmentTabIndicator4.setGravity(17);
        fragmentTabIndicator4.setText(getResources().getString(com.baidu.tieba.x.search_in_baidu_text));
        this.I.addView(fragmentTabIndicator);
        this.I.addView(fragmentTabIndicator2);
        this.I.addView(fragmentTabIndicator3);
        this.I.addView(fragmentTabIndicator4);
        this.I.a(0, true);
        this.I.setTabSelectionListener(new z(this));
    }

    public void c() {
        if (this.p != null) {
            this.p.setVisibility(8);
        }
        if (this.o != null) {
            this.o.a();
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.z != 0) {
                    this.z = 0;
                    this.e.setText(getString(com.baidu.tieba.x.enter_forum));
                    this.c.setHint(com.baidu.tieba.x.search_bar);
                    a();
                    if (this.y.trim().length() > 0) {
                        n();
                        return;
                    } else {
                        k();
                        return;
                    }
                }
                return;
            case 1:
                if (this.z != 1) {
                    this.z = 1;
                    this.e.setText(getString(com.baidu.tieba.x.search));
                    this.c.setHint(com.baidu.tieba.x.search_post_hint);
                    a();
                    if (this.y.trim().length() > 0) {
                        this.l.setVisibility(8);
                        a(1, this.y);
                        return;
                    }
                    l();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.z != 3) {
                    this.z = 3;
                    this.l.setVisibility(8);
                    this.e.setText(com.baidu.tieba.x.search);
                    this.c.setHint(com.baidu.tieba.x.search_friend_tip);
                    a();
                    if (this.y.trim().length() <= 0) {
                        m();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void d() {
        String trim = this.c.getText().toString().trim();
        if (UtilHelper.isNetOk()) {
            sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this).a(trim, "tb_searchlist", 1)));
        } else {
            showToast(com.baidu.tieba.x.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.l.setVisibility(8);
        a(4, (ArrayList<String>) null);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.l.setVisibility(8);
        a(5, (ArrayList<String>) null);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.l.setVisibility(8);
        a(6, (ArrayList<String>) null);
        sendMessage(new RequestSearchPersonHistoryReadMessage());
        showProgressBarWithOffset(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((4 == i && this.z != 0) || ((5 == i && this.z != 1) || (6 == i && this.z != 3)))) {
            this.i.setVisibility(8);
            this.s.setVisibility(0);
            this.s.setText(com.baidu.tieba.x.text_no_search_record);
            return;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.s.setVisibility(8);
        this.k.a(arrayList);
        this.k.a(4 == i);
        this.k.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.i.setVisibility(8);
        if (this.y != null) {
            if (this.y.equals(this.A)) {
                o();
                return;
            }
            this.F.removeCallbacks(this.G);
            this.F.postDelayed(this.G, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.j.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    if (str.equals(this.B)) {
                        o();
                    } else {
                        StringBuffer stringBuffer = new StringBuffer(30);
                        stringBuffer.append(TbConfig.SERVER_ADDRESS);
                        stringBuffer.append("c/s/searchpost");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("word", str));
                        arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                        arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                        arrayList.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, "search_post"));
                        a();
                        this.x = new ai(this, stringBuffer.toString(), arrayList);
                        this.x.setPriority(3);
                        this.x.execute(new Object[0]);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            if (this.z == 0) {
                if (this.u != null) {
                    if (this.u.forum_list != null && this.u.forum_list.size() > 0) {
                        this.i.setVisibility(0);
                        this.j.setVisibility(8);
                        this.l.setVisibility(0);
                        this.l.setAdapter((ListAdapter) this.n);
                        this.n.a(this.u.forum_list);
                        this.n.notifyDataSetInvalidated();
                    } else {
                        this.i.setVisibility(8);
                        this.s.setVisibility(0);
                        this.s.setText(com.baidu.tieba.x.text_no_suggest);
                    }
                }
            } else if (this.v != null) {
                ArrayList<at> data = this.v.getData();
                if (data != null && data.size() > 0) {
                    this.i.setVisibility(0);
                    this.j.setVisibility(8);
                    this.l.setVisibility(0);
                    this.l.setAdapter((ListAdapter) this.o);
                    this.o.a(this.v);
                    this.o.notifyDataSetInvalidated();
                    if (this.v.hasPre()) {
                        this.l.setSelection(1);
                    }
                } else {
                    this.i.setVisibility(8);
                    this.s.setVisibility(0);
                    this.s.setText(com.baidu.tieba.x.text_no_suggest);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.h.c(i);
        this.I.a(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.g);
        ay.a(this.g, i);
        if (this.k != null) {
            this.k.notifyDataSetChanged();
        }
        if (this.m != null) {
            this.m.notifyDataSetChanged();
        }
        if (this.n != null) {
            this.n.notifyDataSetChanged();
        }
        if (this.o != null) {
            this.o.notifyDataSetChanged();
        }
        if (i == 1) {
            this.f.setBackgroundResource(com.baidu.tieba.r.square_listview_bg_1);
            this.r.setBackgroundResource(com.baidu.tieba.r.square_listview_bg_1);
            this.c.setTextColor(-6574132);
            this.c.setHintTextColor(-11643034);
            this.q.setTextColor(getResources().getColor(com.baidu.tieba.r.no_data_search_text_content_night));
            this.a.setImageResource(com.baidu.tieba.t.icon_search_ba_1);
            ay.e((View) this.q, com.baidu.tieba.t.clear_search_btn_drawable_1);
            this.e.setTextColor(getResources().getColor(com.baidu.tieba.r.common_new_page_title_1));
            this.s.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
            this.t = com.baidu.tbadk.core.util.d.b(getApplicationContext(), com.baidu.tieba.t.pic_emotion05_1);
            if (this.t != null) {
                this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), this.t), (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        this.f.setBackgroundResource(com.baidu.tieba.r.square_listview_bg);
        this.r.setBackgroundResource(com.baidu.tieba.r.square_listview_bg);
        this.a.setImageResource(com.baidu.tieba.t.icon_search_ba);
        this.e.setTextColor(getResources().getColor(com.baidu.tieba.r.white));
        this.c.setTextColor(-2300171);
        this.c.setHintTextColor(-10195067);
        this.q.setTextColor(getResources().getColor(com.baidu.tieba.r.no_data_search_text_content));
        ay.e((View) this.q, com.baidu.tieba.t.clear_search_btn_drawable);
        this.s.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_d));
        this.t = com.baidu.tbadk.core.util.d.b(getApplicationContext(), com.baidu.tieba.t.pic_emotion05);
        if (this.t != null) {
            this.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), this.t), (Drawable) null, (Drawable) null);
        }
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
        this.s.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if (this.t != null) {
            if (!this.t.isRecycled()) {
                this.t.recycle();
            }
            this.t = null;
        }
    }
}
