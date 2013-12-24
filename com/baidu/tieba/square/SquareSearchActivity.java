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
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends com.baidu.tieba.j {
    private NavigationBar h;
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private FrameLayout g = null;
    ImageView a = null;
    private LinearLayout i = null;
    private RadioButton j = null;
    private RadioButton k = null;
    private Button l = null;
    private FrameLayout m = null;
    private ListView n = null;
    private com.baidu.tieba.home.av o = null;
    private ListView p = null;
    private com.baidu.tieba.home.av q = null;
    private br r = null;
    private com.baidu.tieba.home.ay s = null;
    private ProgressBar t = null;
    private Button u = null;
    private View v = null;
    private TextView w = null;
    private BarSuggestModel x = null;
    private SearchPostModel y = null;
    private bp z = null;
    private bq A = null;
    private String B = null;
    private int C = 0;
    final View.OnClickListener b = new az(this);
    private Handler D = new Handler();
    private Runnable E = new bh(this);

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
        this.D.post(new bi(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.C == 0) {
            TiebaApplication.h().b(true);
        } else {
            TiebaApplication.h().b(false);
        }
        c();
        a();
    }

    public void a() {
        this.D.removeCallbacks(this.E);
        if (this.z != null) {
            this.z.cancel();
            this.z = null;
        }
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
    }

    public void b() {
        this.h = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        View a = this.h.a(R.layout.nb_item_search_dialog, (View.OnClickListener) null);
        this.v = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.w = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new bj(this));
        this.a = (ImageView) findViewById(R.id.search_bar_icon);
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new bk(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new bl(this));
        this.c.addTextChangedListener(new bm(this));
        this.i = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.j = (RadioButton) a.findViewById(R.id.search_forum_btn);
        this.k = (RadioButton) a.findViewById(R.id.search_post_btn);
        this.l = (Button) a.findViewById(R.id.search_in_baidu_btn);
        this.j.setOnCheckedChangeListener(new bn(this));
        this.k.setOnCheckedChangeListener(new bo(this));
        this.l.setOnClickListener(new ba(this));
        this.m = (FrameLayout) findViewById(R.id.home_search_list);
        this.n = (ListView) findViewById(R.id.home_lv_search);
        this.u = (Button) this.v.findViewById(R.id.home_bt_search_footer);
        this.u.setOnClickListener(new bb(this));
        this.n.addFooterView(this.v, null, true);
        this.r = new br(this, null);
        this.o = new com.baidu.tieba.home.av(this, null);
        this.n.setAdapter((ListAdapter) this.o);
        this.n.setOnItemClickListener(new be(this));
        this.p = (ListView) findViewById(R.id.home_lv_suggest);
        this.q = new com.baidu.tieba.home.av(this, null);
        this.s = new com.baidu.tieba.home.ay(this);
        this.p.setAdapter((ListAdapter) this.q);
        this.p.setOnItemClickListener(new bf(this));
        bg bgVar = new bg(this);
        this.p.setOnScrollListener(bgVar);
        this.n.setOnScrollListener(bgVar);
        this.t = (ProgressBar) findViewById(R.id.home_progress_search);
        this.t.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        f();
        ShowSoftKeyPadDelay(this.c, 150);
        if (TiebaApplication.h().s()) {
            this.j.setSelected(true);
            this.j.setChecked(true);
            a(0);
            return;
        }
        this.k.setSelected(true);
        this.k.setChecked(true);
        a(1);
    }

    public void c() {
        if (this.t != null) {
            this.t.setVisibility(8);
        }
        if (this.s != null) {
            this.s.a();
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                if (this.C != 0) {
                    this.C = 0;
                    this.c.setHint(R.string.search_bar);
                    a();
                    if (this.B.trim().length() > 0) {
                        g();
                        return;
                    } else {
                        f();
                        return;
                    }
                }
                return;
            case 1:
                if (this.C != 1) {
                    this.C = 1;
                    this.c.setHint(R.string.search_post_hint);
                    a();
                    if (this.B.trim().length() > 0) {
                        this.p.setVisibility(8);
                        a(1, this.B);
                        return;
                    }
                    h();
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
        this.p.setVisibility(8);
        ArrayList<String> o = DatabaseService.o();
        if (o != null && o.size() > 0) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.w.setVisibility(8);
            this.o.a(o);
            this.o.a(true);
            this.o.notifyDataSetInvalidated();
            return;
        }
        this.m.setVisibility(8);
        this.w.setVisibility(0);
        this.w.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.m.setVisibility(8);
        this.D.removeCallbacks(this.E);
        this.D.postDelayed(this.E, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.n.setVisibility(8);
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
                    this.A = new bq(this, stringBuffer.toString(), arrayList);
                    this.A.setPriority(3);
                    this.A.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.p.setVisibility(8);
        ArrayList<String> p = DatabaseService.p();
        if (p != null && p.size() > 0) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.w.setVisibility(8);
            this.o.a(p);
            this.o.a(false);
            this.o.notifyDataSetInvalidated();
            return;
        }
        this.m.setVisibility(8);
        this.w.setVisibility(0);
        this.w.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.C == 0) {
                if (this.x != null) {
                    if (this.x.forum_list != null && this.x.forum_list.size() > 0) {
                        this.m.setVisibility(0);
                        this.n.setVisibility(8);
                        this.p.setVisibility(0);
                        this.p.setAdapter((ListAdapter) this.r);
                        this.r.a(this.x.forum_list);
                        this.r.notifyDataSetInvalidated();
                    } else {
                        this.m.setVisibility(8);
                        this.w.setVisibility(0);
                        this.w.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.y != null) {
                ArrayList<com.baidu.tieba.data.au> data = this.y.getData();
                if (data != null && data.size() > 0) {
                    this.m.setVisibility(0);
                    this.n.setVisibility(8);
                    this.p.setVisibility(0);
                    this.p.setAdapter((ListAdapter) this.s);
                    this.s.a(this.y);
                    this.s.notifyDataSetInvalidated();
                    if (this.y.hasPre()) {
                        this.p.setSelection(1);
                    }
                } else {
                    this.m.setVisibility(8);
                    this.w.setVisibility(0);
                    this.w.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.h.c(i);
        com.baidu.tieba.util.bb.a(this.n, i);
        com.baidu.tieba.util.bb.a(this.p, i);
        com.baidu.tieba.util.bb.a(this.g, i);
        if (i == 1) {
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.u.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.a.setImageResource(R.drawable.icon_head_bar_search_1);
            com.baidu.tieba.util.bb.e((View) this.u, (int) R.drawable.clear_search_btn_drawable_1);
            com.baidu.tieba.util.bb.e(this.f, (int) R.drawable.inputbox_top_1);
            this.i.setBackgroundColor(getResources().getColor(R.color.search_box_bg_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            com.baidu.tieba.util.bb.e((View) this.l, (int) R.drawable.multiview_right_drawable_1);
            com.baidu.tieba.util.bb.e((View) this.j, (int) R.drawable.multiview_left_drawable_1);
            com.baidu.tieba.util.bb.e((View) this.k, (int) R.drawable.multiview_center_drawable_1);
            this.w.setTextColor(-11446171);
            this.w.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            com.baidu.tieba.util.bb.e((View) this.d, (int) R.drawable.search_delete_button_1);
            this.e.setTextColor(getResources().getColor(R.color.navi_multiview_text_n));
            com.baidu.tieba.util.bb.e((View) this.e, (int) R.drawable.btn_post_dl_selector_1);
            return;
        }
        com.baidu.tieba.util.bb.e((View) this.d, (int) R.drawable.search_delete_button);
        this.a.setImageResource(R.drawable.icon_head_bar_search);
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.j.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.u.setTextColor(getResources().getColor(R.color.reg_font_color));
        com.baidu.tieba.util.bb.e((View) this.u, (int) R.drawable.clear_search_btn_drawable);
        com.baidu.tieba.util.bb.e(this.f, (int) R.drawable.inputbox_top);
        this.i.setBackgroundColor(getResources().getColor(R.color.search_box_bg));
        com.baidu.tieba.util.bb.e((View) this.l, (int) R.drawable.multiview_right_drawable);
        com.baidu.tieba.util.bb.e((View) this.j, (int) R.drawable.multiview_left_drawable);
        com.baidu.tieba.util.bb.e((View) this.k, (int) R.drawable.multiview_center_drawable);
        this.w.setTextColor(-3618616);
        this.w.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
        this.e.setTextColor(getResources().getColor(R.color.navi_multiview_text_s));
        com.baidu.tieba.util.bb.e((View) this.e, (int) R.drawable.btn_post_dl_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        this.w.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
