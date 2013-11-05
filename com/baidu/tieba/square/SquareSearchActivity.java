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
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends com.baidu.tieba.j {
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private LinearLayout g = null;
    private FrameLayout j = null;

    /* renamed from: a  reason: collision with root package name */
    ImageView f2331a = null;
    private LinearLayout k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private Button n = null;
    private ImageView o = null;
    private FrameLayout p = null;
    private ListView q = null;
    private com.baidu.tieba.home.ar r = null;
    private ListView s = null;
    private com.baidu.tieba.home.ar t = null;
    private au u = null;
    private com.baidu.tieba.home.au v = null;
    private ProgressBar w = null;
    private Button x = null;
    private View y = null;
    private TextView z = null;
    private BarSuggestModel A = null;
    private SearchPostModel B = null;
    private as C = null;
    private at D = null;
    private String E = null;
    private int F = 0;
    final View.OnClickListener b = new ac(this);
    private Handler G = new Handler();
    private Runnable H = new ak(this);

    public static void a(Context context, String str) {
        context.startActivity(new Intent(context, SquareSearchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.F == 0) {
            TiebaApplication.g().b(true);
        } else {
            TiebaApplication.g().b(false);
        }
        d();
        b();
    }

    public void b() {
        this.G.removeCallbacks(this.H);
        if (this.C != null) {
            this.C.cancel();
            this.C = null;
        }
        if (this.D != null) {
            this.D.cancel();
            this.D = null;
        }
    }

    public void c() {
        this.y = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.z = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new al(this));
        this.f2331a = (ImageView) findViewById(R.id.search_bar_icon);
        this.o = (ImageView) findViewById(R.id.back);
        this.o.setOnClickListener(new am(this));
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.j = (FrameLayout) findViewById(R.id.frame_layout);
        this.c.setOnEditorActionListener(new an(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new ao(this));
        this.c.addTextChangedListener(new ap(this));
        this.k = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.l = (RadioButton) findViewById(R.id.search_forum_btn);
        this.m = (RadioButton) findViewById(R.id.search_post_btn);
        this.n = (Button) findViewById(R.id.search_in_baidu_btn);
        this.l.setOnCheckedChangeListener(new aq(this));
        this.m.setOnCheckedChangeListener(new ar(this));
        this.n.setOnClickListener(new ad(this));
        this.p = (FrameLayout) findViewById(R.id.home_search_list);
        this.q = (ListView) findViewById(R.id.home_lv_search);
        this.x = (Button) this.y.findViewById(R.id.home_bt_search_footer);
        this.x.setOnClickListener(new ae(this));
        this.q.addFooterView(this.y, null, true);
        this.u = new au(this, null);
        this.r = new com.baidu.tieba.home.ar(this, null);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new ah(this));
        this.s = (ListView) findViewById(R.id.home_lv_suggest);
        this.t = new com.baidu.tieba.home.ar(this, null);
        this.v = new com.baidu.tieba.home.au(this);
        this.s.setAdapter((ListAdapter) this.t);
        this.s.setOnItemClickListener(new ai(this));
        aj ajVar = new aj(this);
        this.s.setOnScrollListener(ajVar);
        this.q.setOnScrollListener(ajVar);
        this.w = (ProgressBar) findViewById(R.id.home_progress_search);
        this.w.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        n();
        a(this.c, 150);
        if (TiebaApplication.g().r()) {
            this.l.setChecked(true);
            d(0);
            return;
        }
        this.m.setChecked(true);
        d(1);
    }

    public void d() {
        if (this.w != null) {
            this.w.setVisibility(8);
        }
        if (this.v != null) {
            this.v.a();
        }
    }

    public void d(int i) {
        switch (i) {
            case 0:
                if (this.F != 0) {
                    this.F = 0;
                    this.c.setHint(R.string.search_bar);
                    b();
                    if (this.E.trim().length() > 0) {
                        o();
                        return;
                    } else {
                        n();
                        return;
                    }
                }
                return;
            case 1:
                if (this.F != 1) {
                    this.F = 1;
                    this.c.setHint(R.string.search_post_hint);
                    b();
                    if (this.E.trim().length() > 0) {
                        this.s.setVisibility(8);
                        a(1, this.E);
                        return;
                    }
                    p();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void e() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            f();
        }
    }

    public void f() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.s.setVisibility(8);
        ArrayList<String> o = DatabaseService.o();
        if (o != null && o.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.s.setVisibility(8);
            this.z.setVisibility(8);
            this.r.a(o);
            this.r.a(true);
            this.r.notifyDataSetInvalidated();
            return;
        }
        this.p.setVisibility(8);
        this.z.setVisibility(0);
        this.z.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.p.setVisibility(8);
        this.G.removeCallbacks(this.H);
        this.G.postDelayed(this.H, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.q.setVisibility(8);
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.f1165a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    b();
                    this.D = new at(this, stringBuffer.toString(), arrayList);
                    this.D.setPriority(3);
                    this.D.execute(new Object[0]);
                }
            } catch (Exception e) {
                be.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.s.setVisibility(8);
        ArrayList<String> p = DatabaseService.p();
        if (p != null && p.size() > 0) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.s.setVisibility(8);
            this.z.setVisibility(8);
            this.r.a(p);
            this.r.a(false);
            this.r.notifyDataSetInvalidated();
            return;
        }
        this.p.setVisibility(8);
        this.z.setVisibility(0);
        this.z.setText(R.string.text_no_search_record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            if (this.F == 0) {
                if (this.A != null) {
                    if (this.A.forum_list != null && this.A.forum_list.size() > 0) {
                        this.p.setVisibility(0);
                        this.q.setVisibility(8);
                        this.s.setVisibility(0);
                        this.s.setAdapter((ListAdapter) this.u);
                        this.u.a(this.A.forum_list);
                        this.u.notifyDataSetInvalidated();
                    } else {
                        this.p.setVisibility(8);
                        this.z.setVisibility(0);
                        this.z.setText(R.string.text_no_suggest);
                    }
                }
            } else if (this.B != null) {
                ArrayList<com.baidu.tieba.data.ax> data = this.B.getData();
                if (data != null && data.size() > 0) {
                    this.p.setVisibility(0);
                    this.q.setVisibility(8);
                    this.s.setVisibility(0);
                    this.s.setAdapter((ListAdapter) this.v);
                    this.v.a(this.B);
                    this.v.notifyDataSetInvalidated();
                    if (this.B.hasPre()) {
                        this.s.setSelection(1);
                    }
                } else {
                    this.p.setVisibility(8);
                    this.z.setVisibility(0);
                    this.z.setText(R.string.text_no_suggest);
                }
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        bb.a(this.o, i);
        bb.d(this.g, i);
        bb.a(this.q, i);
        bb.a(this.s, i);
        bb.a(this.j, i);
        if (i == 1) {
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.x.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.f2331a.setImageResource(R.drawable.icon_head_bar_search_1);
            bb.e((View) this.x, (int) R.drawable.btn_w_square_1);
            bb.e(this.f, (int) R.drawable.inputbox_top_1);
            bb.e(this.k, (int) R.drawable.inputbox_topbg_1);
            this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            bb.e((View) this.n, (int) R.drawable.search_baidu_btn_drawable_1);
            bb.e((View) this.l, (int) R.drawable.search_forum_btn_drawable_1);
            bb.e((View) this.m, (int) R.drawable.search_post_btn_drawable_1);
            this.z.setTextColor(-11446171);
            this.z.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            bb.e((View) this.d, (int) R.drawable.search_delete_button_1);
            return;
        }
        bb.e((View) this.d, (int) R.drawable.search_delete_button);
        this.f2331a.setImageResource(R.drawable.icon_head_bar_search);
        this.n.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.x.setTextColor(getResources().getColor(R.color.reg_font_color));
        bb.e((View) this.x, (int) R.drawable.btn_w_square);
        bb.e(this.f, (int) R.drawable.inputbox_top);
        bb.e(this.k, (int) R.drawable.inputbox_topbg);
        bb.e((View) this.n, (int) R.drawable.search_baidu_btn_drawable);
        bb.e((View) this.l, (int) R.drawable.search_forum_btn_drawable);
        bb.e((View) this.m, (int) R.drawable.search_post_btn_drawable);
        this.z.setTextColor(-3618616);
        this.z.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void k() {
        super.k();
        c(-1);
        this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
