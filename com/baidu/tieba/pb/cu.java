package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class cu {
    private GridView A;
    private com.baidu.tieba.write.m B;
    private Button C;
    private Button D;
    private Button E;
    private EditText F;
    private Handler G;
    private ProgressBar I;

    /* renamed from: a  reason: collision with root package name */
    private View f1512a;
    private View b;
    private BdListView c;
    private bl d;
    private com.baidu.tieba.g e;
    private ClickableLayout4Frame f;
    private HeadImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TbRichTextView l;
    private Button m;
    private Button n;
    private com.baidu.tieba.view.bf o;
    private LinearLayout p;
    private TextView q;
    private View r;
    private LinearLayout s;
    private View.OnClickListener t;
    private View.OnClickListener u;
    private View.OnClickListener v;
    private com.baidu.tieba.util.a w = null;
    private int x = 0;
    private boolean y = true;
    private boolean z = true;
    private com.baidu.tbadk.widget.richText.m H = null;
    private View.OnLongClickListener J = null;
    private Runnable K = new cv(this);
    private AdapterView.OnItemClickListener L = new cw(this);
    private TextWatcher M = new cx(this);
    private AdapterView.OnItemLongClickListener N = new cy(this);

    public cu(com.baidu.tieba.g gVar, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f1512a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = null;
        this.e = gVar;
        this.G = new Handler();
        this.t = onClickListener;
        this.v = onClickListener2;
        this.u = onClickListener3;
        LayoutInflater from = LayoutInflater.from(this.e);
        this.f1512a = from.inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.f = (ClickableLayout4Frame) this.f1512a.findViewById(R.id.sub_pb_body_layout);
        this.f.setOnClickListener(new cz(this));
        this.c = (BdListView) this.f1512a.findViewById(R.id.new_sub_pb_list);
        this.p = (LinearLayout) this.f1512a.findViewById(R.id.sub_pb_buttom_layout);
        this.q = (TextView) this.f1512a.findViewById(R.id.sub_pb_bottom_text);
        this.g = (HeadImageView) this.b.findViewById(R.id.photo);
        this.h = (TextView) this.b.findViewById(R.id.user_name);
        this.i = (TextView) this.b.findViewById(R.id.user_rank);
        this.m = (Button) this.b.findViewById(R.id.reply);
        this.n = (Button) this.b.findViewById(R.id.manage_btn);
        this.j = (TextView) this.b.findViewById(R.id.floor);
        this.k = (TextView) this.b.findViewById(R.id.time);
        this.l = (TbRichTextView) this.b.findViewById(R.id.richText);
        this.l.setTextSize(com.baidu.tieba.data.g.n());
        this.c.addHeaderView(this.b);
        this.d = new bl(this.e, onClickListener3);
        this.d.a(this.v);
        this.c.setAdapter((ListAdapter) this.d);
        this.o = new com.baidu.tieba.view.bf(this.e);
        this.r = this.o.b();
        this.c.setNextPage(this.o);
        this.o.a(this.t);
        this.c.setOnItemClickListener(this.L);
        this.c.setOnItemLongClickListener(this.N);
        this.p.setOnClickListener(this.t);
        this.s = (LinearLayout) this.f1512a.findViewById(R.id.sub_pb_reply);
        this.I = (ProgressBar) this.f1512a.findViewById(R.id.progress);
        this.F = (EditText) this.f1512a.findViewById(R.id.reply_content);
        this.F.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.C = (Button) this.f1512a.findViewById(R.id.pb_reply_post);
        this.D = (Button) this.f1512a.findViewById(R.id.pb_button_face);
        this.E = (Button) this.f1512a.findViewById(R.id.pb_button_at);
        this.A = (GridView) this.f1512a.findViewById(R.id.face_view);
        this.B = new com.baidu.tieba.write.m(this.e);
        this.A.setAdapter((ListAdapter) this.B);
        this.C.setOnClickListener(this.t);
        this.D.setOnClickListener(this.t);
        this.E.setOnClickListener(this.t);
        this.g.setOnClickListener(onClickListener3);
        this.F.addTextChangedListener(this.M);
        this.A.setOnItemClickListener(new da(this));
        t();
    }

    private void t() {
        this.x = Math.min(com.baidu.tieba.util.am.a((Context) this.e, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        u();
        c(TiebaApplication.f().au());
    }

    private void u() {
        TextView textView = new TextView(this.e);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.g.n());
        this.w = new com.baidu.tieba.util.a(this.e);
        this.w.a(this.x, (int) (this.x * 1.62f));
    }

    public boolean a() {
        if (this.A.getVisibility() == 0) {
            this.A.setVisibility(8);
            this.s.setVisibility(8);
            this.p.setEnabled(true);
            return true;
        }
        return false;
    }

    public void a(boolean z) {
        this.z = z;
        this.d.a(z);
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.H = mVar;
    }

    public void a(int i) {
        this.l.setMaxImageWidth(i);
        this.l.setMaxImageHeight((int) (i * 1.618f));
    }

    public void a(com.baidu.tieba.util.a aVar) {
        this.w = aVar;
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.c.setOnScrollListener(onScrollListener);
    }

    public void b() {
        this.F.requestFocus();
        if (this.A.getVisibility() == 8) {
            this.D.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            com.baidu.tieba.util.am.a(this.e, this.F);
            this.G.postDelayed(this.K, 300L);
            return;
        }
        this.D.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.A.setVisibility(8);
        this.s.setVisibility(0);
        this.p.setEnabled(false);
        this.F.requestFocus();
        this.F.setSelection(this.F.getText().length());
        this.e.a(this.F, 300);
    }

    public void c() {
        this.A.setVisibility(8);
    }

    public View d() {
        return this.f1512a;
    }

    public View e() {
        return this.D;
    }

    public View f() {
        return this.E;
    }

    public View g() {
        return this.C;
    }

    public void a(String str) {
        this.F.getText().insert(this.F.getSelectionStart(), "@" + str + " ");
    }

    public void b(String str) {
        this.D.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.A.setVisibility(8);
        this.s.setVisibility(0);
        this.p.setEnabled(false);
        if (str != null) {
            this.F.setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", str));
            this.F.setSelection(this.F.getText().length());
        }
        this.F.requestFocus();
        this.e.a(this.F, 200);
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.e, "subpb_write", "subpbclick", 1);
        }
    }

    public void h() {
        this.A.setVisibility(8);
        this.D.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
        com.baidu.tieba.util.am.a(this.e, this.F);
        this.s.setVisibility(8);
        this.p.setEnabled(true);
    }

    public void i() {
        this.c.setNextPage(this.o);
        this.o.c();
    }

    public void b(boolean z) {
        this.y = z;
    }

    public void j() {
        this.d.a((ArrayList) null);
        this.d.notifyDataSetChanged();
        this.F.setText("");
    }

    public void a(com.baidu.tieba.data.bh bhVar, int i) {
        String id;
        if (bhVar != null) {
            if (bhVar.a() != null) {
                this.C.setTag(bhVar.a().d());
            }
            if (bhVar.k()) {
                this.c.setNextPage(this.o);
            } else {
                this.c.setNextPage(null);
            }
            this.o.a(bhVar.d() - bhVar.b().size());
            this.d.a(bhVar.b());
            boolean z = false;
            if (bhVar.l() != null && bhVar.l().g() != null && (id = bhVar.l().g().getId()) != null && id.equals(TiebaApplication.E())) {
                z = true;
            }
            this.d.a(i, z);
            this.d.notifyDataSetChanged();
            a(bhVar.a(), bhVar.i(), bhVar.j());
            m();
        }
    }

    public void b(int i) {
        this.c.setSelection(i);
        this.c.invalidate();
    }

    public void k() {
        this.F.setText("");
    }

    public View l() {
        return this.m;
    }

    private void a(com.baidu.tieba.data.aw awVar, boolean z, boolean z2) {
        if (awVar != null) {
            this.g.setTag(null);
            this.g.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.b.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.b.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, awVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            if (!this.z) {
                this.g.setVisibility(8);
            }
            this.h.setOnClickListener(this.u);
            this.h.setText((CharSequence) null);
            this.i.setText((CharSequence) null);
            this.i.setBackgroundResource(0);
            this.j.setText((CharSequence) null);
            this.m.setOnClickListener(this.t);
            this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            int au = TiebaApplication.f().au();
            Resources resources = this.e.getResources();
            com.baidu.tieba.util.ah.d(this.k, au);
            com.baidu.tieba.util.ah.e(this.h, au);
            this.k.setText(com.baidu.tieba.util.ai.e(new Date(awVar.f())));
            if (z) {
                if (au == 1) {
                    if (z2) {
                        this.j.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        this.j.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z2) {
                    this.j.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    this.j.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (au == 1) {
                    com.baidu.tieba.util.ah.h((View) this.j, (int) R.drawable.pb_list_floor_number_1);
                    if (z2) {
                        this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.util.ah.h((View) this.j, (int) R.drawable.pb_list_floor_number);
                    if (z2) {
                        this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                this.j.setText(String.valueOf(String.valueOf(awVar.e())) + resources.getString(R.string.floor));
            }
            this.m.setTag(awVar.d());
            String portrait = awVar.g().getPortrait();
            com.baidu.adp.widget.a.b c = this.w.c(portrait);
            if (awVar.g() != null) {
                this.h.setText(awVar.g().getName_show());
                int level_id = awVar.g().getLevel_id();
                int isLike = awVar.g().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    this.i.setText(String.valueOf(level_id));
                    this.i.setBackgroundResource(com.baidu.tieba.util.e.b(level_id));
                }
            }
            this.g.setUserId(awVar.g().getId());
            this.h.setTag(awVar.g().getId());
            if (c != null) {
                c.b(this.g);
            } else {
                this.g.setTag(portrait);
                this.g.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
            }
            this.l.setDisplayImage(this.y);
            this.l.setText(awVar.h());
            this.l.setOnImageClickListener(this.H);
            this.n.setVisibility(8);
        }
    }

    public void m() {
        int i;
        int i2 = 0;
        try {
            if (this.z) {
                int firstVisiblePosition = this.c.getFirstVisiblePosition();
                int lastVisiblePosition = this.c.getLastVisiblePosition();
                NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this.e);
                this.d.a().a();
                boolean z = c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG;
                this.d.a().a(z);
                int i3 = firstVisiblePosition;
                while (i3 < this.d.getCount()) {
                    if (z || i3 <= lastVisiblePosition) {
                        String portrait = ((com.baidu.tieba.data.aw) this.d.getItem(i3)).g().getPortrait();
                        if (portrait == null || portrait.length() <= 0 || i2 >= 30) {
                            i = i2;
                        } else {
                            i = i2 + 1;
                            this.d.a().d(portrait, new db(this));
                        }
                        if (z) {
                        }
                        i3++;
                        i2 = i;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public View n() {
        return this.r;
    }

    public String o() {
        return this.F.getText().toString();
    }

    public void c(int i) {
        com.baidu.tieba.util.ah.e(this.b, i);
        com.baidu.tieba.util.ah.f(this.c, i);
        if (i == 1) {
            this.p.setBackgroundResource(R.drawable.bg_retract_1);
            this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ico_upward_1, 0);
            this.l.setTextColor(this.e.getResources().getColor(R.color.gray_night_1));
            this.l.setVideoImageId(R.drawable.pic_video_1);
            this.D.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.E.setBackgroundResource(R.drawable.new_pb_at_btn_1);
            com.baidu.tieba.util.ah.h((View) this.C, (int) R.drawable.btn_post_dl_selector_1);
            this.C.setTextColor(this.e.getResources().getColorStateList(R.color.post_image_btn_color_1));
            this.f1512a.setBackgroundResource(R.drawable.common_bg_1);
            com.baidu.tieba.util.ah.h((View) this.m, (int) R.drawable.common_image_btn_selector_1);
            this.m.setTextColor(this.e.getResources().getColorStateList(R.color.common_image_btn_color_1));
            this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
            this.c.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.p.setBackgroundResource(R.drawable.bg_retract);
        this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ico_upward, 0);
        this.l.setTextColor(this.e.getResources().getColor(R.color.search_text_content));
        this.l.setVideoImageId(R.drawable.pic_video);
        this.D.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.E.setBackgroundResource(R.drawable.new_pb_at_btn);
        com.baidu.tieba.util.ah.h((View) this.C, (int) R.drawable.btn_post_dl_selector);
        this.C.setTextColor(this.e.getResources().getColorStateList(R.color.post_image_btn_color));
        this.f1512a.setBackgroundResource(R.drawable.common_bg);
        com.baidu.tieba.util.ah.h((View) this.m, (int) R.drawable.common_image_btn_selector);
        this.m.setTextColor(this.e.getResources().getColorStateList(R.color.common_image_btn_color));
        this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        this.c.setSelector(R.drawable.list_selector);
    }

    public void p() {
        this.c.setVisibility(8);
        this.I.setVisibility(0);
    }

    public void q() {
        this.I.setVisibility(0);
    }

    public void r() {
        this.I.setVisibility(8);
    }

    public void s() {
        this.c.setVisibility(0);
        this.I.setVisibility(8);
        this.o.d();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.J = onLongClickListener;
        this.b.setOnLongClickListener(this.J);
    }
}
