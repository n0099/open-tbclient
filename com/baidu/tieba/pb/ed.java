package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ed implements com.baidu.tieba.view.ap {
    protected Handler E;
    protected ProgressBar G;
    protected BdListView c;
    protected com.baidu.tieba.j e;
    protected ClickableLayout4Frame f;
    protected HeadImageView g;
    protected TextView h;
    protected TextView i;
    protected TextView j;
    protected ImageView k;
    protected TextView l;
    protected TbRichTextView m;
    protected Button n;
    protected Button o;
    protected com.baidu.tieba.view.bi p;
    protected LinearLayout q;
    protected TextView r;
    protected View s;
    protected UserIconBox t;
    protected View.OnClickListener v;
    protected View.OnClickListener w;
    protected View.OnClickListener x;
    protected View.OnClickListener y;

    /* renamed from: a  reason: collision with root package name */
    protected View f2251a = null;
    protected View b = null;
    protected ca d = null;
    protected LinearLayout u = null;
    protected com.baidu.tieba.util.i z = null;
    protected int A = 0;
    protected boolean B = true;
    protected boolean C = true;
    protected Button D = null;
    protected com.baidu.tbadk.widget.richText.o F = null;
    protected View.OnLongClickListener H = null;
    private LinkedList<IconData> L = null;
    protected PbEditor I = null;
    private String M = null;
    protected AdapterView.OnItemClickListener J = new ef(this);
    protected AdapterView.OnItemLongClickListener K = new eo(this);

    public ed(com.baidu.tieba.j jVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.c = null;
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
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.E = null;
        this.G = null;
        this.e = jVar;
        this.E = new Handler();
        this.v = onClickListener;
        this.x = onClickListener2;
        this.w = onClickListener3;
        this.y = onClickListener4;
        h();
        this.f = (ClickableLayout4Frame) this.f2251a.findViewById(R.id.sub_pb_body_layout);
        this.c = (BdListView) this.f2251a.findViewById(R.id.new_sub_pb_list);
        this.b.setOnClickListener(new ee(this));
        this.q = (LinearLayout) this.f2251a.findViewById(R.id.sub_pb_bottom_layout);
        b();
        this.r = (TextView) this.f2251a.findViewById(R.id.sub_pb_bottom_text);
        this.g = (HeadImageView) this.b.findViewById(R.id.photo);
        this.g.setIsRound(true);
        this.h = (TextView) this.b.findViewById(R.id.user_name);
        this.i = (TextView) this.b.findViewById(R.id.user_rank);
        this.n = (Button) this.b.findViewById(R.id.reply);
        this.o = (Button) this.b.findViewById(R.id.manage_btn);
        this.j = (TextView) this.b.findViewById(R.id.floor);
        this.k = (ImageView) this.b.findViewById(R.id.floor_owner);
        this.l = (TextView) this.b.findViewById(R.id.time);
        this.t = (UserIconBox) this.b.findViewById(R.id.user_icon_box);
        this.m = (TbRichTextView) this.b.findViewById(R.id.richText);
        this.m.setTextSize(com.baidu.tieba.data.h.o());
        this.m.setVoiceViewRes(R.layout.voice_play_btn);
        this.c.addHeaderView(this.b);
        a(onClickListener3);
        this.p = new com.baidu.tieba.view.bi(this.e);
        this.s = this.p.b();
        this.c.setNextPage(this.p);
        this.p.a(this.v);
        this.c.setOnItemClickListener(this.J);
        this.c.setOnItemLongClickListener(this.K);
        this.q.setOnClickListener(this.v);
        this.G = (ProgressBar) this.f2251a.findViewById(R.id.progress);
        this.g.setOnClickListener(onClickListener3);
        i();
    }

    protected void b() {
        this.I = (SubPbEditor) this.f2251a.findViewById(R.id.sub_pb_editor);
        this.I.v();
    }

    protected void a(View.OnClickListener onClickListener) {
        this.d = new ca(this.e, onClickListener);
        this.d.a(this.x);
        this.c.setAdapter((ListAdapter) this.d);
    }

    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.f2251a = from.inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
    }

    protected void i() {
        this.A = Math.min(com.baidu.adp.lib.h.g.a((Context) this.e, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        k();
        b(TiebaApplication.h().an());
    }

    public void j() {
        if (!this.I.i()) {
            c((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, View view) {
        new Handler().postDelayed(new ej(this, i, view), 300L);
    }

    protected void k() {
        TextView textView = new TextView(this.e);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.h.o());
        this.z = new com.baidu.tieba.util.i(this.e);
        this.z.f("pb");
        this.z.a(this.A, (int) (this.A * 1.62f));
    }

    public void a(boolean z) {
        this.I.setAudioFocusable(z);
    }

    public boolean a() {
        if (this.I.p()) {
            this.I.g();
            this.I.o();
            this.q.setEnabled(true);
            return true;
        }
        this.I.m();
        this.M = null;
        return false;
    }

    public void b(boolean z) {
        this.C = z;
        this.d.a(z);
    }

    public void a(com.baidu.tbadk.widget.richText.o oVar) {
        this.F = oVar;
    }

    public void c(int i) {
        this.m.setMaxImageWidth(i);
        this.m.setMaxImageHeight((int) (i * 1.618f));
    }

    public void a(com.baidu.tieba.util.i iVar) {
        this.z = iVar;
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.c.setOnScrollListener(onScrollListener);
    }

    public void l() {
        this.I.q();
    }

    public void m() {
        this.I.r();
    }

    public View n() {
        return this.f2251a;
    }

    public VoiceManager.VoiceModel o() {
        return this.I.getAudioData();
    }

    public void p() {
        this.I.s();
    }

    public void b(String str) {
        this.I.getEditText().getText().insert(this.I.getEditText().getSelectionStart(), "@" + str + " ");
    }

    public void a(String str, String str2) {
        c(str);
        new Handler().postDelayed(new ek(this, str2), 200L);
    }

    public void c(String str) {
        this.I.n();
        this.q.setEnabled(false);
        if (str != null) {
            this.I.getEditText().setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", str));
            this.I.getEditText().setSelection(this.I.getEditText().getText().length());
        }
        if (this.I.i()) {
            this.I.l();
        } else {
            this.I.getEditText().requestFocus();
            this.I.a(this.I.getEditText());
        }
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.e, "subpb_write", "subpbclick", 1);
        }
    }

    public void q() {
        this.I.o();
        this.q.setEnabled(true);
    }

    public void r() {
        this.c.setNextPage(this.p);
        this.p.c();
    }

    public void c(boolean z) {
        this.B = z;
    }

    public void s() {
        this.d.a((ArrayList<com.baidu.tieba.data.ar>) null);
        this.d.notifyDataSetChanged();
        this.I.getEditText().setText("");
        this.I.m();
    }

    public String t() {
        return this.M;
    }

    protected void u() {
        com.baidu.tieba.util.i a2 = this.d != null ? this.d.a() : null;
        if (a2 != null) {
            Object tag = this.g.getTag();
            String obj = tag != null ? tag.toString() : null;
            if (obj != null) {
                a2.d(obj, new el(this));
            }
        }
    }

    public void a(com.baidu.tieba.data.av avVar, int i) {
        String id;
        boolean z = true;
        if (avVar != null) {
            if (avVar.a() != null) {
                this.M = avVar.a().d();
            }
            if (avVar.l()) {
                this.c.setNextPage(this.p);
                this.d.b(true);
            } else {
                this.c.setNextPage(null);
                this.d.b(false);
            }
            this.p.a(a(avVar));
            this.d.a(avVar.c());
            if (avVar.m() == null || avVar.m().j() == null || (id = avVar.m().j().getId()) == null || !id.equals(TiebaApplication.B())) {
                z = false;
            }
            this.d.a(i, z);
            this.d.notifyDataSetChanged();
            a(avVar.a(), avVar.j(), avVar.k());
            x();
            u();
        }
    }

    public void a(com.baidu.tieba.editortool.h hVar) {
        if (hVar != null) {
            this.I.setOnActionListener(new em(this, hVar));
        }
    }

    protected int a(com.baidu.tieba.data.av avVar) {
        return avVar.e() - avVar.c().size();
    }

    public void d(int i) {
        this.c.setSelection(i);
        this.c.invalidate();
    }

    public void d(String str) {
        int a2;
        if (str != null && !str.equals("") && (a2 = this.d.a(str)) >= 0) {
            this.c.setSelection(a2 + 1);
            this.c.invalidate();
        }
    }

    public void v() {
        this.I.m();
    }

    public View w() {
        return this.n;
    }

    public void d(boolean z) {
        if (TiebaApplication.h().an() == 1) {
            com.baidu.tieba.util.ba.e((View) this.j, (int) R.drawable.pb_list_floor_number_1);
            if (z) {
                this.j.setBackgroundResource(R.drawable.icon_collect_s_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.icon_collect_n_1);
                return;
            }
        }
        com.baidu.tieba.util.ba.e((View) this.j, (int) R.drawable.pb_list_floor_number);
        if (z) {
            this.j.setBackgroundResource(R.drawable.icon_collect_s);
        } else {
            this.j.setBackgroundResource(R.drawable.icon_collect_n);
        }
    }

    protected void a(com.baidu.tieba.data.ar arVar, boolean z, boolean z2) {
        if (arVar != null) {
            this.g.setTag(null);
            this.g.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.b.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.b.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, arVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            if (!this.C) {
                this.g.setVisibility(8);
            }
            this.h.setOnClickListener(this.w);
            this.h.setText((CharSequence) null);
            this.i.setText((CharSequence) null);
            this.i.setBackgroundDrawable(null);
            this.k.setVisibility(8);
            this.j.setTag(sparseArray);
            this.j.setText((CharSequence) null);
            this.j.setOnClickListener(this.v);
            this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.n.setOnClickListener(this.v);
            int an = TiebaApplication.h().an();
            Resources resources = this.e.getResources();
            this.l.setTextColor(this.e.getResources().getColor(an == 1 ? R.color.pb_listitem_post_time_1 : R.color.pb_listitem_post_time));
            this.h.setTextColor(this.e.getResources().getColor(an == 1 ? R.color.pb_user_name_text_1 : R.color.pb_user_name_text));
            this.l.setText(com.baidu.tieba.util.bb.b(arVar.f()));
            if (z) {
                this.k.setVisibility(0);
                if (an == 1) {
                    this.k.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    this.k.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (an == 1) {
                if (this.B) {
                    this.m.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                } else {
                    this.m.setDefaultImageId(R.drawable.icon_click_1);
                }
            } else if (this.B) {
                this.m.setDefaultImageId(R.drawable.pic_baidu_logo_d);
            } else {
                this.m.setDefaultImageId(R.drawable.icon_click);
            }
            d(z2);
            this.j.setText(String.valueOf(arVar.e()) + resources.getString(R.string.floor));
            this.n.setTag(arVar.d());
            String portrait = arVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.e c = this.z.c(portrait);
            if (arVar.g() != null) {
                this.h.setText(arVar.g().getName_show());
                int level_id = arVar.g().getLevel_id();
                int isLike = arVar.g().getIsLike();
                int is_bawu = arVar.g().getIs_bawu();
                String bawu_type = arVar.g().getBawu_type();
                int i = 6;
                if (level_id != 0 && isLike != 0) {
                    this.i.setVisibility(0);
                    this.i.setText(String.valueOf(level_id));
                    this.i.setBackgroundResource(com.baidu.tieba.util.m.b(level_id));
                    this.i.setOnClickListener(null);
                    i = 5;
                } else {
                    this.i.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.i.setText((CharSequence) null);
                        this.i.setBackgroundResource(an == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        this.i.setOnClickListener(this.y);
                    } else if (bawu_type.equals("assist")) {
                        this.i.setText((CharSequence) null);
                        this.i.setBackgroundResource(an == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        this.i.setOnClickListener(this.y);
                    }
                }
                this.L = arVar.g().getIconInfo();
                if (this.t != null) {
                    this.t.setOnClickListener(this.y);
                    this.t.a(this.L, i, this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
            }
            this.g.setUserId(arVar.g().getId());
            this.h.setTag(arVar.g().getId());
            if (c != null) {
                c.a(this.g);
            } else {
                this.g.setTag(portrait);
                this.g.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
            }
            this.m.a(this.B, false);
            this.m.setText(arVar.h());
            this.m.setOnImageClickListener(this.F);
            this.o.setVisibility(8);
        }
    }

    public void x() {
        int i;
        int i2 = 0;
        try {
            if (this.C) {
                int firstVisiblePosition = this.c.getFirstVisiblePosition();
                int lastVisiblePosition = this.c.getLastVisiblePosition();
                UtilHelper.NetworkStateInfo g = UtilHelper.g(this.e);
                this.d.a().a();
                boolean z = g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG;
                this.d.a().a(z);
                int i3 = firstVisiblePosition;
                while (i3 < this.d.getCount()) {
                    if (z || i3 <= lastVisiblePosition) {
                        String portrait = ((com.baidu.tieba.data.ar) this.d.getItem(i3)).g().getPortrait();
                        if (portrait == null || portrait.length() <= 0 || i2 >= 30) {
                            i = i2;
                        } else {
                            i = i2 + 1;
                            this.d.a().d(portrait, new en(this));
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
            com.baidu.tieba.util.bd.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public View y() {
        return this.s;
    }

    public String z() {
        return this.I.getEditText().getText().toString();
    }

    public void b(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a(this.f2251a);
        this.e.getLayoutMode().a(this.b);
        this.e.getLayoutMode().a(this.s);
        if (i == 1) {
            this.s.setBackgroundResource(R.drawable.bg_floor_new_foot_1);
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_upward_footer_1, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.gray_night_1));
            this.m.setVideoImageId(R.drawable.pic_video_1);
            com.baidu.tieba.util.ba.e((View) this.D, (int) R.drawable.btn_post_dl_selector_1);
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            this.s.setBackgroundResource(R.drawable.bg_floor_new_foot);
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_upward_footer, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.search_text_content));
            this.m.setVideoImageId(R.drawable.pic_video);
            com.baidu.tieba.util.ba.e((View) this.D, (int) R.drawable.btn_post_dl_selector);
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        this.I.d(i);
    }

    public void A() {
        this.c.setVisibility(8);
        this.G.setVisibility(0);
    }

    public void B() {
        this.G.setVisibility(0);
    }

    public void C() {
        this.G.setVisibility(8);
    }

    public void D() {
        this.c.setVisibility(0);
        this.G.setVisibility(8);
        this.p.d();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.H = onLongClickListener;
        this.b.setOnLongClickListener(this.H);
    }

    public View E() {
        return this.b;
    }

    @Override // com.baidu.tieba.view.ap
    public void a(int i) {
        this.I.a(i);
    }

    public void a(String str) {
        int a2 = this.d.a(str);
        if (a2 > -1) {
            this.c.setSelection(a2 + 1);
            this.c.invalidate();
        }
    }
}
