package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.InputFilter;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
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
public class ed {
    protected View.OnClickListener A;
    protected Handler G;
    protected ProgressBar J;
    protected BdListView c;
    protected com.baidu.tieba.f e;
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
    protected com.baidu.tieba.view.co p;
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
    protected cf d = null;
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
    protected AdapterView.OnItemClickListener M = new ee(this);
    protected AdapterView.OnItemLongClickListener N = new ei(this);

    public ed(com.baidu.tieba.f fVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
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
        this.e = fVar;
        this.G = new Handler();
        this.w = onClickListener;
        this.y = onClickListener2;
        this.x = onClickListener3;
        this.z = onClickListener4;
        this.A = onClickListener5;
        h();
        this.f = (ClickableLayout4Frame) this.a.findViewById(R.id.sub_pb_body_layout);
        this.c = (BdListView) this.a.findViewById(R.id.new_sub_pb_list);
        this.b.setOnClickListener(new ej(this));
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
        this.m.setTextSize(com.baidu.tieba.data.i.B());
        this.m.setVoiceViewRes(R.layout.voice_play_btn);
        this.c.addHeaderView(this.b);
        a(onClickListener3);
        this.p = new com.baidu.tieba.view.co(this.e);
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
        this.L.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
    }

    protected void a(View.OnClickListener onClickListener) {
        this.d = new cf(this.e, onClickListener);
        this.d.a(this.y);
        this.c.setAdapter((ListAdapter) this.d);
    }

    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.a = from.inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
    }

    protected void i() {
        this.C = Math.min(BdUtilHelper.a((Context) this.e, 427.0f), 640);
        k();
        a(TiebaApplication.g().al());
    }

    public void j() {
        if (!this.L.h()) {
            b((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, View view) {
        new Handler().postDelayed(new ek(this, i, view), 300L);
    }

    protected void k() {
        TextView textView = new TextView(this.e);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.i.B());
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

    public void b(int i) {
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

    public void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.L.getEditText().getText().insert(this.L.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void a(String str, String str2) {
        b(str);
        new Handler().postDelayed(new el(this, str2), 200L);
    }

    public void b(String str) {
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
        com.baidu.tieba.util.cb.a(this.e, "subpb_write", "subpbclick", 1, new Object[0]);
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
        this.d.a((ArrayList<com.baidu.tieba.data.aq>) null);
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
                a.d(obj, new em(this));
            }
        }
    }

    public void a(com.baidu.tieba.data.av avVar, int i) {
        String userId;
        boolean z = true;
        if (avVar != null) {
            if (avVar.a() != null) {
                this.Q = avVar.a().d();
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
            if (avVar.m() == null || avVar.m().j() == null || (userId = avVar.m().j().getUserId()) == null || !userId.equals(TiebaApplication.A())) {
                z = false;
            }
            this.d.a(i, z);
            this.d.notifyDataSetChanged();
            a(avVar.a(), avVar.j(), avVar.k());
            x();
            u();
        }
    }

    public void a(com.baidu.tieba.editortool.z zVar) {
        if (zVar != null) {
            this.L.setOnActionListener(new en(this, zVar));
        }
    }

    protected int a(com.baidu.tieba.data.av avVar) {
        return avVar.e() - avVar.c().size();
    }

    public void c(int i) {
        this.c.setSelection(i);
        this.c.invalidate();
    }

    public void c(String str) {
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
        if (TiebaApplication.g().al() == 1) {
            com.baidu.tieba.util.bq.e((View) this.j, (int) R.drawable.pb_list_floor_number_1);
            if (z) {
                this.j.setBackgroundResource(R.drawable.icon_collect_s_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.icon_collect_n_1);
                return;
            }
        }
        com.baidu.tieba.util.bq.e((View) this.j, (int) R.drawable.pb_list_floor_number);
        if (z) {
            this.j.setBackgroundResource(R.drawable.icon_collect_s);
        } else {
            this.j.setBackgroundResource(R.drawable.icon_collect_n);
        }
    }

    protected void a(com.baidu.tieba.data.aq aqVar, boolean z, boolean z2) {
        if (aqVar != null) {
            this.g.setTag(null);
            this.g.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.b.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.b.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, aqVar);
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
            int al = TiebaApplication.g().al();
            Resources resources = this.e.getResources();
            this.l.setTextColor(this.e.getResources().getColor(al == 1 ? R.color.pb_listitem_post_time_1 : R.color.pb_listitem_post_time));
            this.h.setTextColor(this.e.getResources().getColor(al == 1 ? R.color.pb_user_name_text_1 : R.color.pb_user_name_text));
            this.l.setText(com.baidu.tieba.util.bs.a(aqVar.f()));
            if (z) {
                this.k.setVisibility(0);
                if (al == 1) {
                    this.k.setImageResource(R.drawable.icon_floorhost_1);
                } else {
                    this.k.setImageResource(R.drawable.icon_floorhost);
                }
            }
            if (al == 1) {
                this.m.setDefaultGifId(R.drawable.pic_expression_upload_selector_1);
                if (this.D) {
                    this.m.setDefaultImageId(R.drawable.pic_baidu_logo_d_1);
                    this.m.setShowEmotion(true);
                } else {
                    this.m.setDefaultImageId(R.drawable.icon_click_1);
                    this.m.setShowEmotion(false);
                }
            } else {
                this.m.setDefaultGifId(R.drawable.pic_expression_upload_selector);
                if (this.D) {
                    this.m.setDefaultImageId(R.drawable.pic_baidu_logo_d);
                    this.m.setShowEmotion(true);
                } else {
                    this.m.setDefaultImageId(R.drawable.icon_click);
                    this.m.setShowEmotion(false);
                }
            }
            d(z2);
            this.j.setText(String.valueOf(String.valueOf(aqVar.e())) + resources.getString(R.string.floor));
            this.n.setTag(aqVar.d());
            String portrait = aqVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.b c = this.B.c(portrait);
            if (aqVar.g() != null) {
                this.h.setText(aqVar.g().getName_show());
                int level_id = aqVar.g().getLevel_id();
                int isLike = aqVar.g().getIsLike();
                int is_bawu = aqVar.g().getIs_bawu();
                String bawu_type = aqVar.g().getBawu_type();
                int i = 3;
                if (level_id != 0 && isLike != 0) {
                    this.i.setVisibility(0);
                    this.i.setText(String.valueOf(level_id));
                    this.i.setBackgroundResource(com.baidu.tieba.util.n.b(level_id));
                    this.i.setOnClickListener(null);
                    i = 2;
                } else {
                    this.i.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.i.setText((CharSequence) null);
                        this.i.setBackgroundResource(al == 1 ? R.drawable.pb_manager_1 : R.drawable.pb_manager);
                        this.i.setOnClickListener(this.z);
                    } else if (bawu_type.equals("assist")) {
                        this.i.setText((CharSequence) null);
                        this.i.setBackgroundResource(al == 1 ? R.drawable.pb_assist_1 : R.drawable.pb_assist);
                        this.i.setOnClickListener(this.z);
                    }
                }
                this.O = aqVar.g().getIconInfo();
                this.P = aqVar.g().getTShowInfo();
                if (this.t != null) {
                    this.t.setOnClickListener(this.z);
                    this.t.a(this.O, i, this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_width), this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_height), this.e.getResources().getDimensionPixelSize(R.dimen.pb_icon_margin));
                }
                if (this.u != null) {
                    this.u.setOnClickListener(this.A);
                    this.u.a(this.P, 2, this.e.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.e.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.e.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
            }
            this.g.setUserId(aqVar.g().getUserId());
            this.h.setTag(aqVar.g().getUserId());
            if (c != null) {
                c.a(this.g);
            } else {
                this.g.setTag(portrait);
                this.g.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
            }
            this.m.a(this.D, false);
            this.m.setText(aqVar.h());
            this.m.setOnImageClickListener(this.H);
            this.m.setOnEmotionClickListener(this.I);
            a(aqVar);
            this.o.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.data.aq aqVar) {
        com.baidu.adp.widget.ImageView.b a;
        Iterator<com.baidu.tbadk.widget.richText.c> it = aqVar.h().a().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            switch (next.a()) {
                case 17:
                    com.baidu.tbadk.widget.richText.e g = next.g();
                    if (g != null && !g.k) {
                        eo eoVar = new eo(this);
                        if (com.baidu.tieba.util.i.b()) {
                            a = this.B.a(g.e, g.c, g.b, true, (com.baidu.tbadk.imageManager.d) eoVar);
                        } else {
                            a = this.B.a(g.e, g.c, g.a, false, (com.baidu.tbadk.imageManager.d) eoVar);
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
                    }
                    break;
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
                UtilHelper.NetworkStateInfo h = UtilHelper.h(this.e);
                this.d.a().a();
                boolean z = h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG;
                this.d.a().a(z);
                int i3 = firstVisiblePosition;
                while (i3 < this.d.getCount()) {
                    if (z || i3 <= lastVisiblePosition) {
                        String portrait = ((com.baidu.tieba.data.aq) this.d.getItem(i3)).g().getPortrait();
                        if (portrait == null || portrait.length() <= 0 || i2 >= 30) {
                            i = i2;
                        } else {
                            i = i2 + 1;
                            this.d.a().d(portrait, new ep(this));
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public View y() {
        return this.s;
    }

    public String z() {
        return this.L.getEditText().getText().toString();
    }

    public void a(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a(this.a);
        this.e.getLayoutMode().a(this.b);
        this.e.getLayoutMode().a(this.s);
        if (i == 1) {
            this.s.setBackgroundResource(R.drawable.bg_floor_new_foot_1);
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_upward_footer_1, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.gray_night_1));
            this.m.setVideoImageId(R.drawable.pic_video_1);
            com.baidu.tieba.util.bq.e((View) this.F, (int) R.drawable.btn_post_dl_selector_1);
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
        } else {
            this.s.setBackgroundResource(R.drawable.bg_floor_new_foot);
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_upward_footer, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.search_text_content));
            this.m.setVideoImageId(R.drawable.pic_video);
            com.baidu.tieba.util.bq.e((View) this.F, (int) R.drawable.btn_post_dl_selector);
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        }
        this.L.c(i);
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

    public void a(String str) {
        int a = this.d.a(str);
        if (a > -1) {
            this.c.setSelection(a + 1);
            this.c.invalidate();
        }
    }
}
