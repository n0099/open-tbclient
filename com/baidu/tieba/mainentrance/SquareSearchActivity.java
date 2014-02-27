package com.baidu.tieba.mainentrance;

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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.au;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends com.baidu.tieba.f {
    private NavigationBar i;
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private FrameLayout g = null;
    private LinearLayoutDetectsSoftKeyboard h = null;
    ImageView a = null;
    private LinearLayout j = null;
    private RadioButton k = null;
    private RadioButton l = null;
    private Button m = null;
    private FrameLayout n = null;
    private ListView o = null;
    private f p = null;
    private ListView q = null;
    private f r = null;
    private ah s = null;
    private h t = null;
    private ProgressBar u = null;
    private Button v = null;
    private View w = null;
    private TextView x = null;
    private BarSuggestModel y = null;
    private SearchPostModel z = null;
    private af A = null;
    private ag B = null;
    private String C = null;
    private int D = 0;
    final View.OnClickListener b = new k(this);
    private final Handler E = new Handler();
    private final Runnable F = new x(this);
    private boolean G = true;

    public static void a(Context context) {
        context.startActivity(new Intent(context, SquareSearchActivity.class));
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_dialog_search);
        this.i = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        View a = this.i.a(R.layout.nb_item_search_dialog, (View.OnClickListener) null);
        this.w = getLayoutInflater().inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.x = (TextView) findViewById(R.id.text_no_data);
        this.c = (EditText) findViewById(R.id.home_et_search);
        this.c.setOnFocusChangeListener(new z(this));
        this.a = (ImageView) findViewById(R.id.search_bar_icon);
        this.e = (Button) findViewById(R.id.home_bt_search_s);
        this.e.setText(getString(R.string.enter_forum));
        this.e.setOnClickListener(this.b);
        this.f = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.g = (FrameLayout) findViewById(R.id.frame_layout);
        this.h = (LinearLayoutDetectsSoftKeyboard) findViewById(R.id.parent);
        this.h.setOnSoftKeyBoardShownListener(new aa(this));
        this.c.setOnEditorActionListener(new ab(this));
        this.d = (Button) findViewById(R.id.home_bt_search_del);
        this.d.setOnClickListener(new ac(this));
        this.c.addTextChangedListener(new ad(this));
        this.j = (LinearLayout) findViewById(R.id.search_tab_bg);
        this.k = (RadioButton) a.findViewById(R.id.search_forum_btn);
        this.l = (RadioButton) a.findViewById(R.id.search_post_btn);
        this.m = (Button) a.findViewById(R.id.search_in_baidu_btn);
        this.k.setOnCheckedChangeListener(new ae(this));
        this.l.setOnCheckedChangeListener(new l(this));
        this.m.setOnClickListener(new m(this));
        this.n = (FrameLayout) findViewById(R.id.home_search_list);
        this.o = (ListView) findViewById(R.id.home_lv_search);
        this.v = (Button) this.w.findViewById(R.id.home_bt_search_footer);
        this.v.setOnClickListener(new n(this));
        this.o.addFooterView(this.w, null, true);
        this.s = new ah(this, null);
        this.p = new f(this, null);
        this.o.setAdapter((ListAdapter) this.p);
        this.o.setOnItemClickListener(new q(this));
        this.q = (ListView) findViewById(R.id.home_lv_suggest);
        this.r = new f(this, null);
        this.t = new h(this);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new r(this));
        s sVar = new s(this);
        this.q.setOnScrollListener(sVar);
        this.o.setOnScrollListener(sVar);
        this.u = (ProgressBar) findViewById(R.id.home_progress_search);
        this.u.setVisibility(8);
        this.c.setText("");
        this.c.requestFocus();
        c();
        ShowSoftKeyPadDelay(this.c, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        if (TiebaApplication.g().m()) {
            this.k.setSelected(true);
            this.k.setChecked(true);
            a(0);
        } else {
            this.l.setSelected(true);
            this.l.setChecked(true);
            a(1);
        }
        getWindow().setSoftInputMode(1);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.G) {
            com.baidu.adp.lib.util.e.e("simon", "onResume", "show keyboard");
            this.E.post(new y(this));
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.D = 0;
        if (this.D == 0) {
            TiebaApplication.g().a(true);
        } else {
            TiebaApplication.g().a(false);
        }
        if (this.u != null) {
            this.u.setVisibility(8);
        }
        if (this.t != null) {
            this.t.a();
        }
        a();
    }

    public final void a() {
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

    public final void a(int i) {
        switch (i) {
            case 0:
                if (this.D != 0) {
                    this.D = 0;
                    this.e.setText(getString(R.string.enter_forum));
                    this.c.setHint(R.string.search_bar);
                    a();
                    if (this.C.trim().length() > 0) {
                        e();
                        return;
                    } else {
                        c();
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
                    d();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void b() {
        String trim = this.c.getText().toString().trim();
        FrsActivity.a(this, trim, "tb_searchlist", 1);
        if (trim != null && trim.length() != 0) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.q.setVisibility(8);
        a(true, (ArrayList<String>) null);
        com.baidu.tieba.im.i.a(new t(this), new u(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.q.setVisibility(8);
        a(false, (ArrayList<String>) null);
        com.baidu.tieba.im.i.a(new v(this), new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0 || ((z && this.D != 0) || (!z && this.D != 1))) {
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
    public void e() {
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
                    stringBuffer.append(com.baidu.tieba.data.i.a);
                    stringBuffer.append("c/s/searchpost");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("word", str));
                    arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
                    arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
                    arrayList.add(new BasicNameValuePair("st_type", "search_post"));
                    a();
                    this.B = new ag(this, stringBuffer.toString(), arrayList);
                    this.B.setPriority(3);
                    this.B.execute(new Object[0]);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "startSearchPost.run", "error = " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(SquareSearchActivity squareSearchActivity) {
        try {
            if (squareSearchActivity.D == 0) {
                if (squareSearchActivity.y != null) {
                    if (squareSearchActivity.y.forum_list == null || squareSearchActivity.y.forum_list.size() <= 0) {
                        squareSearchActivity.n.setVisibility(8);
                        squareSearchActivity.x.setVisibility(0);
                        squareSearchActivity.x.setText(R.string.text_no_suggest);
                    } else {
                        squareSearchActivity.n.setVisibility(0);
                        squareSearchActivity.o.setVisibility(8);
                        squareSearchActivity.q.setVisibility(0);
                        squareSearchActivity.q.setAdapter((ListAdapter) squareSearchActivity.s);
                        squareSearchActivity.s.a(squareSearchActivity.y.forum_list);
                        squareSearchActivity.s.notifyDataSetInvalidated();
                    }
                }
            } else if (squareSearchActivity.z != null) {
                ArrayList<au> data = squareSearchActivity.z.getData();
                if (data == null || data.size() <= 0) {
                    squareSearchActivity.n.setVisibility(8);
                    squareSearchActivity.x.setVisibility(0);
                    squareSearchActivity.x.setText(R.string.text_no_suggest);
                } else {
                    squareSearchActivity.n.setVisibility(0);
                    squareSearchActivity.o.setVisibility(8);
                    squareSearchActivity.q.setVisibility(0);
                    squareSearchActivity.q.setAdapter((ListAdapter) squareSearchActivity.t);
                    squareSearchActivity.t.a(squareSearchActivity.z);
                    squareSearchActivity.t.notifyDataSetInvalidated();
                    if (squareSearchActivity.z.hasPre()) {
                        squareSearchActivity.q.setSelection(1);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(squareSearchActivity.getClass().getName(), "", "HomeActivity.refresh error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.f
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.i.b(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.h);
        bq.a(this.h, i);
        if (i == 1) {
            this.g.setBackgroundResource(R.color.square_listview_bg_1);
            this.w.setBackgroundResource(R.color.square_listview_bg_1);
            this.c.setTextColor(-11446171);
            this.c.setHintTextColor(-11446171);
            this.v.setTextColor(getResources().getColor(R.color.search_text_content_night));
            this.a.setImageResource(R.drawable.icon_head_bar_search_1);
            bq.e((View) this.v, (int) R.drawable.clear_search_btn_drawable_1);
            bq.e(this.f, (int) R.drawable.inputbox_top_1);
            this.j.setBackgroundColor(getResources().getColor(R.color.search_box_bg_1));
            this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color_1));
            bq.e((View) this.m, (int) R.drawable.multiview_right_drawable_1);
            bq.e((View) this.k, (int) R.drawable.multiview_left_drawable_1);
            bq.e((View) this.l, (int) R.drawable.multiview_center_drawable_1);
            this.x.setTextColor(-11446171);
            this.x.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless_1, 0, 0);
            bq.e((View) this.d, (int) R.drawable.search_delete_button_1);
            this.e.setTextColor(getResources().getColor(R.color.navi_multiview_text_n));
            bq.e((View) this.e, (int) R.drawable.btn_post_dl_selector_1);
            return;
        }
        this.g.setBackgroundResource(R.color.square_listview_bg);
        this.w.setBackgroundResource(R.color.square_listview_bg);
        bq.e((View) this.d, (int) R.drawable.search_delete_button);
        this.a.setImageResource(R.drawable.icon_head_bar_search);
        this.m.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.k.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.l.setTextColor(getResources().getColorStateList(R.color.search_tab_btn_color));
        this.c.setTextColor(-10066329);
        this.c.setHintTextColor(-4144186);
        this.v.setTextColor(getResources().getColor(R.color.reg_font_color));
        bq.e((View) this.v, (int) R.drawable.clear_search_btn_drawable);
        bq.e(this.f, (int) R.drawable.inputbox_top);
        this.j.setBackgroundColor(getResources().getColor(R.color.search_box_bg));
        bq.e((View) this.m, (int) R.drawable.multiview_right_drawable);
        bq.e((View) this.k, (int) R.drawable.multiview_left_drawable);
        bq.e((View) this.l, (int) R.drawable.multiview_center_drawable);
        this.x.setTextColor(-3618616);
        this.x.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pic_search_fruitless, 0, 0);
        this.e.setTextColor(getResources().getColor(R.color.navi_multiview_text_s));
        bq.e((View) this.e, (int) R.drawable.btn_post_dl_selector);
    }

    @Override // com.baidu.tieba.f
    protected void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        this.x.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
