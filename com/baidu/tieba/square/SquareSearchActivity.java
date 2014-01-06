package com.baidu.tieba.square;

import android.content.Context;
import android.content.Intent;
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
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends com.baidu.tieba.j {
    private NavigationBar i;
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private FrameLayout g = null;
    private View h = null;
    ImageView a = null;
    private LinearLayout j = null;
    private RadioButton k = null;
    private RadioButton l = null;
    private Button m = null;
    private FrameLayout n = null;
    private ListView o = null;
    private com.baidu.tieba.home.aw p = null;
    private ListView q = null;
    private com.baidu.tieba.home.aw r = null;
    private bv s = null;
    private com.baidu.tieba.home.az t = null;
    private ProgressBar u = null;
    private Button v = null;
    private View w = null;
    private TextView x = null;
    private BarSuggestModel y = null;
    private SearchPostModel z = null;
    private bt A = null;
    private bu B = null;
    private String C = null;
    private int D = 0;
    final View.OnClickListener b = new az(this);
    private Handler E = new Handler();
    private Runnable F = new bl(this);

    public static void a(Context context, String str) {
        context.startActivity(new Intent(context, SquareSearchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.E.post(new bm(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.D = 0;
        if (this.D == 0) {
            TiebaApplication.g().b(true);
        } else {
            TiebaApplication.g().b(false);
        }
        c();
        a();
    }

    public void a() {
        this.E.removeCallbacks(this.F);
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
        if (this.B != null) {
            this.B.cancel();
            this.B = null;
        }
    }

    public void b() {
        this.i = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        View a = this.i.a(R.layout.nb_item_search_dialog, (View.OnClickListener) null);
        this.w = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.x = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new bn(this));
        this.a = (ImageView) findViewById(R.id.search_bar_icon);
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setText(getString(R.string.enter_forum));
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (FrameLayout) findViewById(R.id.frame_layout);
        this.h = findViewById(R.id.parent);
        this.c.setOnEditorActionListener(new bo(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new bp(this));
        this.c.addTextChangedListener(new bq(this));
        this.j = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.k = (RadioButton) a.findViewById(R.id.search_forum_btn);
        this.l = (RadioButton) a.findViewById(R.id.search_post_btn);
        this.m = (Button) a.findViewById(R.id.search_in_baidu_btn);
        this.k.setOnCheckedChangeListener(new br(this));
        this.l.setOnCheckedChangeListener(new bs(this));
        this.m.setOnClickListener(new ba(this));
        this.n = (FrameLayout) findViewById(R.id.home_search_list);
        this.o = (ListView) findViewById(R.id.home_lv_search);
        this.v = (Button) this.w.findViewById(R.id.home_bt_search_footer);
        this.v.setOnClickListener(new bb(this));
        this.o.addFooterView(this.w, null, true);
        this.s = new bv(this, null);
        this.p = new com.baidu.tieba.home.aw(this, null);
        this.o.setAdapter((ListAdapter) this.p);
        this.o.setOnItemClickListener(new be(this));
        this.q = (ListView) findViewById(R.id.home_lv_suggest);
        this.r = new com.baidu.tieba.home.aw(this, null);
        this.t = new com.baidu.tieba.home.az(this);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new bf(this));
        bg bgVar = new bg(this);
        this.q.setOnScrollListener(bgVar);
        this.o.setOnScrollListener(bgVar);
        this.u = (ProgressBar) findViewById(R.id.home_progress_search);
        this.u.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        f();
        ShowSoftKeyPadDelay(this.c, 150);
        if (TiebaApplication.g().r()) {
            this.k.setSelected(true);
            this.k.setChecked(true);
            a(0);
            return;
        }
        this.l.setSelected(true);
        this.l.setChecked(true);
        a(1);
    }

    public void c() {
        if (this.u != null) {
            this.u.setVisibility(8);
        }
        if (this.t != null) {
            this.t.a();
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.D != 0) {
                    this.D = 0;
                    this.e.setText(getString(R.string.enter_forum));
                    this.c.setHint(R.string.search_bar);
                    a();
                    if (this.C.trim().length() > 0) {
                        h();
                        return;
                    } else {
                        f();
                        return;
                    }
                }
                return;
            case 1:
                if (this.D != 1) {
                    this.D = 1;
                    this.e.setText(getString(R.string.search));
                    this.c.setHint(R.string.search_post_hint);
                    a();
                    if (this.C.trim().length() > 0) {
                        this.q.setVisibility(8);
                        a(1, this.C);
                        return;
                    }
                    g();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void d() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            e();
        }
    }

    public void e() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.q.setVisibility(8);
        a(true, (ArrayList<String>) null);
        com.baidu.tieba.im.m.a(new bh(this), new bi(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.q.setVisibility(8);
        a(false, (ArrayList<String>) null);
        com.baidu.tieba.im.m.a(new bj(this), new bk(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() < 1 || ((z && this.D != 0) || (!z && this.D != 1))) {
            this.n.setVisibility(8);
            this.x.setVisibility(0);
            this.x.setText(R.string.text_no_search_record);
            return;
        }
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.q.setVisibility(8);
        this.x.setVisibility(8);
        this.p.a(arrayList);
        this.p.a(z);
        this.p.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.n.setVisibility(8);
        this.E.removeCallbacks(this.F);
        this.E.postDelayed(this.F, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.o.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    a();
                    this.B = new bu(this, stringBuffer.toString(), arrayList);
                    this.B.setPriority(3);
                    this.B.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.D == 0) {
                if (this.y != null) {
                    if (this.y.forum_list != null && this.y.forum_list.size() > 0) {
                        this.n.setVisibility(0);
                        this.o.setVisibility(8);
                        this.q.setVisibility(0);
                        this.q.setAdapter((ListAdapter) this.s);
                        this.s.a(this.y.forum_list);
                        this.s.notifyDataSetInvalidated();
                    } else {
                        this.n.setVisibility(8);
                        this.x.setVisibility(0);
                        this.x.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.z != null) {
                ArrayList<com.baidu.tieba.data.aw> data = this.z.getData();
                if (data != null && data.size() > 0) {
                    this.n.setVisibility(0);
                    this.o.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setAdapter((ListAdapter) this.t);
                    this.t.a(this.z);
                    this.t.notifyDataSetInvalidated();
                    if (this.z.hasPre()) {
                        this.q.setSelection(1);
                    }
                } else {
                    this.n.setVisibility(8);
                    this.x.setVisibility(0);
                    this.x.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.i.c(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.h);
        com.baidu.tieba.util.bl.a(this.h, i);
        if (i == 1) {
            this.g.setBackgroundResource(R.color.square_listview_bg_1);
            this.w.setBackgroundResource(R.color.square_listview_bg_1);
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.v.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.a.setImageResource(R.drawable.icon_head_bar_search_1);
            com.baidu.tieba.util.bl.e((View) this.v, (int) R.drawable.clear_search_btn_drawable_1);
            com.baidu.tieba.util.bl.e(this.f, (int) R.drawable.inputbox_top_1);
            this.j.setBackgroundColor(getResources().getColor(R.color.search_box_bg_1));
            this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            com.baidu.tieba.util.bl.e((View) this.m, (int) R.drawable.multiview_right_drawable_1);
            com.baidu.tieba.util.bl.e((View) this.k, (int) R.drawable.multiview_left_drawable_1);
            com.baidu.tieba.util.bl.e((View) this.l, (int) R.drawable.multiview_center_drawable_1);
            this.x.setTextColor(-11446171);
            this.x.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            com.baidu.tieba.util.bl.e((View) this.d, (int) R.drawable.search_delete_button_1);
            this.e.setTextColor(getResources().getColor(R.color.navi_multiview_text_n));
            com.baidu.tieba.util.bl.e((View) this.e, (int) R.drawable.btn_post_dl_selector_1);
            return;
        }
        this.g.setBackgroundResource(R.color.square_listview_bg);
        this.w.setBackgroundResource(R.color.square_listview_bg);
        com.baidu.tieba.util.bl.e((View) this.d, (int) R.drawable.search_delete_button);
        this.a.setImageResource(R.drawable.icon_head_bar_search);
        this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.v.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.util.bl.e((View) this.v, (int) R.drawable.clear_search_btn_drawable);
        com.baidu.tieba.util.bl.e(this.f, (int) R.drawable.inputbox_top);
        this.j.setBackgroundColor(getResources().getColor(R.color.search_box_bg));
        com.baidu.tieba.util.bl.e((View) this.m, (int) R.drawable.multiview_right_drawable);
        com.baidu.tieba.util.bl.e((View) this.k, (int) R.drawable.multiview_left_drawable);
        com.baidu.tieba.util.bl.e((View) this.l, (int) R.drawable.multiview_center_drawable);
        this.x.setTextColor(-3618616);
        this.x.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
        this.e.setTextColor(getResources().getColor(R.color.navi_multiview_text_s));
        com.baidu.tieba.util.bl.e((View) this.e, (int) R.drawable.btn_post_dl_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        this.x.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
