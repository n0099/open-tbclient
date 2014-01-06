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
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.gif.GifView;
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
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ed implements com.baidu.tieba.view.av {
    protected View.OnClickListener A;
    protected Handler G;
    protected ProgressBar J;
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
    protected com.baidu.tieba.view.br p;
    protected LinearLayout q;
    protected TextView r;
    protected View s;
    protected UserIconBox t;
    protected UserIconBox u;
    protected View.OnClickListener w;
    protected View.OnClickListener x;
    protected View.OnClickListener y;
    protected View.OnClickListener z;
    protected View a = null;
    protected View b = null;
    protected cc d = null;
    protected LinearLayout v = null;
    protected com.baidu.tieba.util.i B = null;
    protected int C = 0;
    protected boolean D = true;
    protected boolean E = true;
    protected Button F = null;
    protected com.baidu.tbadk.widget.richText.r H = null;
    protected com.baidu.tbadk.widget.richText.q I = null;
    protected View.OnLongClickListener K = null;
    private LinkedList<IconData> O = null;
    private LinkedList<IconData> P = null;
    protected PbEditor L = null;
    private String Q = null;
    protected AdapterView.OnItemClickListener M = new ef(this);
    protected AdapterView.OnItemLongClickListener N = new ep(this);

    public ed(com.baidu.tieba.j jVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
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
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.G = null;
        this.J = null;
        this.e = jVar;
        this.G = new Handler();
        this.w = onClickListener;
        this.y = onClickListener2;
        this.x = onClickListener3;
        this.z = onClickListener4;
        this.A = onClickListener5;
        h();
        this.f = (ClickableLayout4Frame) this.a.findViewById(R.id.sub_pb_body_layout);
        this.c = (BdListView) this.a.findViewById(R.id.new_sub_pb_list);
        this.b.setOnClickListener(new ee(this));
        this.q = (LinearLayout) this.a.findViewById(R.id.sub_pb_bottom_layout);
        b();
        this.r = (TextView) this.a.findViewById(R.id.sub_pb_bottom_text);
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
        this.u = (UserIconBox) this.b.findViewById(R.id.user_tshow_icon_box);
        this.m = (TbRichTextView) this.b.findViewById(R.id.richText);
        this.m.setTextSize(com.baidu.tieba.data.h.r());
        this.m.setVoiceViewRes(R.layout.voice_play_btn);
        this.c.addHeaderView(this.b);
        a(onClickListener3);
        this.p = new com.baidu.tieba.view.br(this.e);
        this.s = this.p.b();
        this.c.setNextPage(this.p);
        this.p.a(this.w);
        this.c.setOnItemClickListener(this.M);
        this.c.setOnItemLongClickListener(this.N);
        this.q.setOnClickListener(this.w);
        this.J = (ProgressBar) this.a.findViewById(R.id.progress);
        this.g.setOnClickListener(onClickListener3);
        i();
    }

    protected void b() {
        this.L = (PbEditor) this.a.findViewById(R.id.sub_pb_editor);
        this.L.a(true);
    }

    protected void a(View.OnClickListener onClickListener) {
        this.d = new cc(this.e, onClickListener);
        this.d.a(this.y);
        this.c.setAdapter((ListAdapter) this.d);
    }

    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.a = from.inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
    }

    protected void i() {
        this.C = Math.min(com.baidu.adp.lib.h.g.a((Context) this.e, 427.0f), 640);
        k();
        b(TiebaApplication.g().an());
    }

    public void j() {
        if (!this.L.h()) {
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
        textView.setTextSize(com.baidu.tieba.data.h.r());
        this.B = new com.baidu.tieba.util.i(this.e);
        this.B.f("pb");
        this.B.a(this.C, (int) (this.C * 1.6f));
    }

    public void a(boolean z) {
        this.L.setAudioFocusable(z);
    }

    public boolean a() {
        if (this.L.o()) {
            this.L.f();
            this.L.n();
            this.q.setEnabled(true);
            return true;
        }
        this.L.l();
        this.Q = null;
        return false;
    }

    public void b(boolean z) {
        this.E = z;
        this.d.a(z);
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.H = rVar;
    }

    public void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.I = qVar;
    }

    public void c(int i) {
        this.m.setMaxImageWidth(i);
        this.m.setMaxImageHeight((int) (i * 1.618f));
    }

    public void a(com.baidu.tieba.util.i iVar) {
        this.B = iVar;
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.c.setOnScrollListener(onScrollListener);
    }

    public void l() {
        this.L.p();
    }

    public void m() {
        this.L.q();
    }

    public View n() {
        return this.a;
    }

    public VoiceManager.VoiceModel o() {
        return this.L.getAudioData();
    }

    public void p() {
        this.L.r();
    }

    public void b(String str) {
        this.L.getEditText().getText().insert(this.L.getEditText().getSelectionStart(), "@" + str + " ");
    }

    public void a(String str, String str2) {
        c(str);
        new Handler().postDelayed(new ek(this, str2), 200L);
    }

    public void c(String str) {
        this.L.m();
        this.q.setEnabled(false);
        if (str != null) {
            this.L.getEditText().setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", str));
            this.L.getEditText().setSelection(this.L.getEditText().getText().length());
        }
        if (this.L.h()) {
            this.L.k();
        } else {
            this.L.getEditText().requestFocus();
            this.L.a(this.L.getEditText());
        }
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.e, "subpb_write", "subpbclick", 1);
        }
    }

    public void q() {
        this.L.n();
        this.q.setEnabled(true);
    }

    public void r() {
        this.c.setNextPage(this.p);
        this.p.c();
    }

    public void c(boolean z) {
        this.D = z;
    }

    public void s() {
        this.d.a((ArrayList<com.baidu.tieba.data.as>) null);
        this.d.notifyDataSetChanged();
        this.L.getEditText().setText("");
        this.L.l();
    }

    public String t() {
        return this.Q;
    }

    protected void u() {
        com.baidu.tieba.util.i a = this.d != null ? this.d.a() : null;
        if (a != null) {
            Object tag = this.g.getTag();
            String obj = tag != null ? tag.toString() : null;
            if (obj != null) {
                a.d(obj, new el(this));
            }
        }
    }

    public void a(com.baidu.tieba.data.ax axVar, int i) {
        String id;
        boolean z = true;
        if (axVar != null) {
            if (axVar.a() != null) {
                this.Q = axVar.a().d();
            }
            if (axVar.l()) {
                this.c.setNextPage(this.p);
                this.d.b(true);
            } else {
                this.c.setNextPage(null);
                this.d.b(false);
            }
            this.p.a(a(axVar));
            this.d.a(axVar.c());
            if (axVar.m() == null || axVar.m().j() == null || (id = axVar.m().j().getId()) == null || !id.equals(TiebaApplication.A())) {
                z = false;
            }
            this.d.a(i, z);
            this.d.notifyDataSetChanged();
            a(axVar.a(), axVar.j(), axVar.k());
            x();
            u();
        }
    }

    public void a(com.baidu.tieba.editortool.t tVar) {
        if (tVar != null) {
            this.L.setOnActionListener(new em(this, tVar));
        }
    }

    protected int a(com.baidu.tieba.data.ax axVar) {
        return axVar.e() - axVar.c().size();
    }

    public void d(int i) {
        this.c.setSelection(i);
        this.c.invalidate();
    }

    public void d(String str) {
        int a;
        if (str != null && !str.equals("") && (a = this.d.a(str)) >= 0) {
            this.c.setSelection(a + 1);
            this.c.invalidate();
        }
    }

    public void v() {
        this.L.l();
    }

    public View w() {
        return this.n;
    }

    public void d(boolean z) {
        if (TiebaApplication.g().an() == 1) {
            com.baidu.tieba.util.bl.e((View) this.j, (int) R.drawable.pb_list_floor_number_1);
            if (z) {
                this.j.setBackgroundResource(R.drawable.icon_collect_s_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.icon_collect_n_1);
                return;
            }
        }
        com.baidu.tieba.util.bl.e((View) this.j, (int) R.drawable.pb_list_floor_number);
        if (z) {
            this.j.setBackgroundResource(R.drawable.icon_collect_s);
        } else {
            this.j.setBackgroundResource(R.drawable.icon_collect_n);
        }
    }

    protected void a(com.baidu.tieba.data.as asVar, boolean z, boolean z2) {
        if (asVar != null) {
            this.g.setTag(null);
            this.g.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.b.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.b.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, asVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            if (!this.E) {
                this.g.setVisibility(8);
            }
            this.h.setOnClickListener(this.x);
            this.h.setText((CharSequence) null);
            this.i.setText((CharSequence) null);
            this.i.setBackgroundDrawable(null);
            this.k.setVisibility(8);
            this.j.setTag(sparseArray);
            this.j.setText((CharSequence) null);
            this.j.setOnClickListener(this.w);
            this.j.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.n.setOnClickListener(this.w);
            int an = TiebaApplication.g().an();
            Resources resources = this.e.getResources();
            this.l.setTextColor(this.e.getResources().getColor(an == 1 ? R.color.pb_listitem_post_time_1 : R.color.pb_listitem_post_time));
            this.h.setTextColor(this.e.getResources().getColor(an == 1 ? R.color.pb_user_name_text_1 : R.color.pb_user_name_text));
            this.l.setText(com.baidu.tieba.util.bm.b(asVar.f()));
            if (z) {
                this.k.setVisibility(0);
                if (an == 1) {
                    this.k.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    this.k.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (an == 1) {
                if (this.D) {
                    this.m.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                    this.m.setShowEmotion(true);
                } else {
                    this.m.setDefaultImageId(R.drawable.icon_click_1);
                    this.m.setShowEmotion(false);
                }
            } else if (this.D) {
                this.m.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                this.m.setShowEmotion(true);
            } else {
                this.m.setDefaultImageId(R.drawable.icon_click);
                this.m.setShowEmotion(false);
            }
            d(z2);
            this.j.setText(String.valueOf(asVar.e()) + resources.getString(R.string.floor));
            this.n.setTag(asVar.d());
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.d c = this.B.c(portrait);
            if (asVar.g() != null) {
                this.h.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                int is_bawu = asVar.g().getIs_bawu();
                String bawu_type = asVar.g().getBawu_type();
                int i = 3;
                if (level_id != 0 && isLike != 0) {
                    this.i.setVisibility(0);
                    this.i.setText(String.valueOf(level_id));
                    this.i.setBackgroundResource(com.baidu.tieba.util.m.b(level_id));
                    this.i.setOnClickListener(null);
                    i = 2;
                } else {
                    this.i.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.i.setText((CharSequence) null);
                        this.i.setBackgroundResource(an == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        this.i.setOnClickListener(this.z);
                    } else if (bawu_type.equals("assist")) {
                        this.i.setText((CharSequence) null);
                        this.i.setBackgroundResource(an == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        this.i.setOnClickListener(this.z);
                    }
                }
                this.O = asVar.g().getIconInfo();
                this.P = asVar.g().getTShowInfo();
                if (this.t != null) {
                    this.t.setOnClickListener(this.z);
                    this.t.a(this.O, i, this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
                if (this.u != null) {
                    this.u.setOnClickListener(this.A);
                    this.u.a(this.P, 2, this.e.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.e.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.e.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
            }
            this.g.setUserId(asVar.g().getId());
            this.h.setTag(asVar.g().getId());
            if (c != null) {
                c.a(this.g);
            } else {
                this.g.setTag(portrait);
                this.g.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
            }
            this.m.a(this.D, false);
            this.m.setText(asVar.h());
            this.m.setOnImageClickListener(this.H);
            this.m.setOnEmotionClickListener(this.I);
            a(asVar);
            this.o.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.data.as asVar) {
        com.baidu.adp.widget.ImageView.d a;
        Iterator<com.baidu.tbadk.widget.richText.c> it = asVar.h().a().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            switch (next.a()) {
                case 17:
                    com.baidu.tbadk.widget.richText.e g = next.g();
                    if (g != null) {
                        en enVar = new en(this);
                        if (com.baidu.tieba.util.i.b()) {
                            a = this.B.a(g.e, g.c, g.b, true, enVar);
                        } else {
                            a = this.B.a(g.e, g.c, g.a, false, enVar);
                        }
                        if (a == null) {
                            GifView gifView = (GifView) this.m.findViewWithTag(g.c);
                            if (gifView != null) {
                                if (next.g().j) {
                                    gifView.setGif(null);
                                    break;
                                } else {
                                    gifView.setIsLoading(true);
                                    break;
                                }
                            } else {
                                return;
                            }
                        } else {
                            GifView gifView2 = (GifView) this.m.findViewWithTag(g.c);
                            if (gifView2 != null) {
                                gifView2.setGif(a);
                                break;
                            } else {
                                return;
                            }
                        }
                    } else {
                        continue;
                    }
            }
        }
    }

    public void x() {
        int i;
        int i2 = 0;
        try {
            if (this.E) {
                int firstVisiblePosition = this.c.getFirstVisiblePosition();
                int lastVisiblePosition = this.c.getLastVisiblePosition();
                UtilHelper.NetworkStateInfo g = UtilHelper.g(this.e);
                this.d.a().a();
                boolean z = g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG;
                this.d.a().a(z);
                int i3 = firstVisiblePosition;
                while (i3 < this.d.getCount()) {
                    if (z || i3 <= lastVisiblePosition) {
                        String portrait = ((com.baidu.tieba.data.as) this.d.getItem(i3)).g().getPortrait();
                        if (portrait == null || portrait.length() <= 0 || i2 >= 30) {
                            i = i2;
                        } else {
                            i = i2 + 1;
                            this.d.a().d(portrait, new eo(this));
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
            com.baidu.tieba.util.bo.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public View y() {
        return this.s;
    }

    public String z() {
        return this.L.getEditText().getText().toString();
    }

    public void b(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a(this.a);
        this.e.getLayoutMode().a(this.b);
        this.e.getLayoutMode().a(this.s);
        if (i == 1) {
            this.s.setBackgroundResource(R.drawable.bg_floor_new_foot_1);
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_upward_footer_1, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.gray_night_1));
            this.m.setVideoImageId(R.drawable.pic_video_1);
            com.baidu.tieba.util.bl.e((View) this.F, (int) R.drawable.btn_post_dl_selector_1);
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            this.s.setBackgroundResource(R.drawable.bg_floor_new_foot);
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_upward_footer, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.search_text_content));
            this.m.setVideoImageId(R.drawable.pic_video);
            com.baidu.tieba.util.bl.e((View) this.F, (int) R.drawable.btn_post_dl_selector);
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        this.L.d(i);
    }

    public void A() {
        this.c.setVisibility(8);
        this.J.setVisibility(0);
    }

    public void B() {
        this.J.setVisibility(0);
    }

    public void C() {
        this.J.setVisibility(8);
    }

    public void D() {
        this.c.setVisibility(0);
        this.J.setVisibility(8);
        this.p.d();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.K = onLongClickListener;
        this.b.setOnLongClickListener(this.K);
    }

    public View E() {
        return this.b;
    }

    @Override // com.baidu.tieba.view.av
    public void a(int i) {
        this.L.a(i);
    }

    public void a(String str) {
        int a = this.d.a(str);
        if (a > -1) {
            this.c.setSelection(a + 1);
            this.c.invalidate();
        }
    }
}
