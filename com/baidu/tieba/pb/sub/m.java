package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.am;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.view.ClickableLayout4Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import protobuf.Im;
/* loaded from: classes.dex */
public class m {
    protected View.OnClickListener A;
    protected View.OnClickListener B;
    protected ab C;
    protected int D;
    protected Handler H;
    protected ProgressBar K;
    protected BdListView d;
    protected com.baidu.tbadk.a f;
    protected ClickableLayout4Frame g;
    protected HeadImageView h;
    protected TextView i;
    protected TextView j;
    protected TextView k;
    protected ImageView l;
    protected TextView m;
    protected TbRichTextView n;
    protected ImageView o;
    protected Button p;
    protected e q;
    protected LinearLayout r;
    protected TextView s;
    protected View t;
    protected UserIconBox u;
    protected UserIconBox v;
    protected View.OnClickListener x;
    protected View.OnClickListener y;
    protected View.OnClickListener z;
    protected View b = null;
    protected View c = null;
    protected b e = null;
    protected LinearLayout w = null;
    protected boolean E = true;
    protected boolean F = true;
    protected Button G = null;
    protected com.baidu.tbadk.widget.richText.r I = null;
    protected com.baidu.tbadk.widget.richText.q J = null;
    protected View.OnLongClickListener L = null;
    private LinkedList<IconData> a = null;
    private LinkedList<IconData> P = null;
    protected PbEditor M = null;
    private String Q = null;
    private boolean R = false;
    protected AdapterView.OnItemClickListener N = new n(this);
    protected AdapterView.OnItemLongClickListener O = new s(this);

    public m(com.baidu.tbadk.a aVar, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.d = null;
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
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = 0;
        this.H = null;
        this.K = null;
        this.f = aVar;
        this.H = new Handler();
        this.x = onClickListener;
        this.z = onClickListener2;
        this.y = onClickListener3;
        this.A = onClickListener4;
        this.B = onClickListener5;
        h();
        this.g = (ClickableLayout4Frame) this.b.findViewById(com.baidu.tieba.a.h.sub_pb_body_layout);
        this.d = (BdListView) this.b.findViewById(com.baidu.tieba.a.h.new_sub_pb_list);
        this.c.setOnClickListener(new t(this));
        this.r = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.sub_pb_bottom_layout);
        b();
        this.s = (TextView) this.b.findViewById(com.baidu.tieba.a.h.sub_pb_bottom_text);
        this.h = (HeadImageView) this.c.findViewById(com.baidu.tieba.a.h.photo);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.a.h.user_name);
        this.j = (TextView) this.c.findViewById(com.baidu.tieba.a.h.user_rank);
        this.o = (ImageView) this.c.findViewById(com.baidu.tieba.a.h.reply);
        this.p = (Button) this.c.findViewById(com.baidu.tieba.a.h.manage_btn);
        this.k = (TextView) this.c.findViewById(com.baidu.tieba.a.h.floor);
        this.l = (ImageView) this.c.findViewById(com.baidu.tieba.a.h.floor_owner);
        this.m = (TextView) this.c.findViewById(com.baidu.tieba.a.h.time);
        this.u = (UserIconBox) this.c.findViewById(com.baidu.tieba.a.h.user_icon_box);
        this.v = (UserIconBox) this.c.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        this.n = (TbRichTextView) this.c.findViewById(com.baidu.tieba.a.h.richText);
        this.n.setTextSize(com.baidu.tbadk.core.data.n.p());
        this.n.setVoiceViewRes(com.baidu.tieba.a.i.voice_play_btn);
        this.d.addHeaderView(this.c);
        a(onClickListener3);
        this.q = new e(this.f);
        this.t = this.q.b();
        this.d.setNextPage(this.q);
        this.q.a(this.x);
        this.d.setOnItemClickListener(this.N);
        this.d.setOnItemLongClickListener(this.O);
        this.r.setOnClickListener(this.x);
        this.K = (ProgressBar) this.b.findViewById(com.baidu.tieba.a.h.progress);
        this.h.setOnClickListener(onClickListener3);
        this.D = Math.min(com.baidu.adp.lib.util.i.a((Context) this.f, 427.0f), 640);
        TextView textView = new TextView(this.f);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tbadk.core.data.n.p());
        this.C = new ab(this.f);
        this.C.b("pb");
        this.C.a(this.D, (int) (this.D * 1.6f));
        a(TbadkApplication.j().l());
    }

    protected void b() {
        this.M = (PbEditor) this.b.findViewById(com.baidu.tieba.a.h.sub_pb_editor);
        this.M.a(true);
        this.M.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
    }

    protected void a(View.OnClickListener onClickListener) {
        this.e = new b(this.f, onClickListener);
        this.e.a(this.z);
        this.d.setAdapter((ListAdapter) this.e);
    }

    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.f);
        this.b = from.inflate(com.baidu.tieba.a.i.new_sub_pb_layout, (ViewGroup) null);
        this.c = from.inflate(com.baidu.tieba.a.i.new_sub_pb_head, (ViewGroup) null);
    }

    public final void i() {
        if (!this.M.h()) {
            b((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, View view) {
        new Handler().postDelayed(new u(this, i, view), 300L);
    }

    public final void a(boolean z) {
        this.M.setAudioFocusable(z);
    }

    public boolean a() {
        this.R = false;
        if (this.M.n()) {
            this.M.f();
            this.M.m();
            this.r.setEnabled(true);
            return true;
        }
        this.M.k();
        this.Q = null;
        return false;
    }

    public final void b(boolean z) {
        this.F = z;
        this.e.b();
    }

    public final void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.I = rVar;
    }

    public final void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.J = qVar;
    }

    public final void b(int i) {
        this.n.setMaxImageWidth(i);
        this.n.setMaxImageHeight((int) (i * 1.618f));
    }

    public final void a(ab abVar) {
        this.C = abVar;
    }

    public final void a(AbsListView.OnScrollListener onScrollListener) {
        this.d.setOnScrollListener(onScrollListener);
    }

    public final void j() {
        this.M.o();
    }

    public final void k() {
        this.M.p();
    }

    public final View l() {
        return this.b;
    }

    public final VoiceData.VoiceModel m() {
        return this.M.getAudioData();
    }

    public final void n() {
        this.M.q();
    }

    public final void a(ArrayList<String> arrayList) {
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
                    this.M.getEditText().getText().insert(this.M.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public final void a(String str, String str2) {
        b(str);
        new Handler().postDelayed(new v(this, str2), 200L);
    }

    public final void b(String str) {
        this.R = true;
        this.M.l();
        this.r.setEnabled(false);
        if (str != null) {
            this.M.getEditText().setText(this.f.getResources().getString(com.baidu.tieba.a.k.reply_sub_floor).replace("%s", str));
            this.M.getEditText().setSelection(this.M.getEditText().getText().length());
        }
        if (this.M.h()) {
            this.M.j();
        } else {
            this.M.getEditText().requestFocus();
            this.f.ShowSoftKeyPadDelay(this.M.getEditText(), 200);
        }
        TiebaStatic.a(this.f, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public final void o() {
        this.R = false;
        this.M.m();
        this.r.setEnabled(true);
    }

    public final void p() {
        this.d.setNextPage(this.q);
        this.q.c();
    }

    public final void c(boolean z) {
        this.E = z;
    }

    public final void q() {
        this.e.a((ArrayList<ai>) null);
        this.e.notifyDataSetChanged();
        this.M.getEditText().setText("");
        this.M.k();
    }

    public final String r() {
        return this.Q;
    }

    public final void a(am amVar, int i) {
        String userId;
        if (amVar != null) {
            if (amVar.a() != null) {
                this.Q = amVar.a().d();
            }
            if (amVar.k()) {
                this.d.setNextPage(this.q);
                this.e.a(true);
            } else {
                this.d.setNextPage(null);
                this.e.a(false);
            }
            this.q.a(a(amVar));
            this.e.a(amVar.c());
            boolean z = false;
            if (amVar.l() != null && amVar.l().t() != null && (userId = amVar.l().t().getUserId()) != null && userId.equals(TbadkApplication.E())) {
                z = true;
            }
            this.e.a(i, z);
            this.e.notifyDataSetChanged();
            ai a = amVar.a();
            boolean i2 = amVar.i();
            amVar.j();
            if (a != null) {
                this.h.setTag(null);
                this.h.setUserId(null);
                SparseArray sparseArray = (SparseArray) this.c.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.c.setTag(sparseArray);
                }
                sparseArray.clear();
                sparseArray.put(com.baidu.tieba.a.h.tag_clip_board, a);
                sparseArray.put(com.baidu.tieba.a.h.tag_is_subpb, false);
                this.o.setTag(sparseArray);
                if (!this.F) {
                    this.h.setVisibility(8);
                }
                this.i.setOnClickListener(this.y);
                this.i.setText((CharSequence) null);
                this.j.setText((CharSequence) null);
                this.j.setBackgroundDrawable(null);
                this.l.setVisibility(8);
                this.k.setText((CharSequence) null);
                this.o.setOnClickListener(this.x);
                int l = TbadkApplication.j().l();
                this.m.setTextColor(this.f.getResources().getColor(l == 1 ? com.baidu.tieba.a.e.pb_listitem_post_time_1 : com.baidu.tieba.a.e.pb_listitem_post_time));
                this.m.setText(bc.a(a.f()));
                if (i2) {
                    this.l.setVisibility(0);
                    if (l == 1) {
                        this.l.setImageResource(com.baidu.tieba.a.g.icon_floorhost_1);
                    } else {
                        this.l.setImageResource(com.baidu.tieba.a.g.icon_floorhost);
                    }
                }
                if (l == 1) {
                    this.n.setDefaultGifId(com.baidu.tieba.a.g.pic_expression_upload_selector_1);
                    if (this.E) {
                        this.n.setDefaultImageId(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                        this.n.setShowEmotion(true);
                    } else {
                        this.n.setDefaultImageId(com.baidu.tieba.a.g.icon_click_1);
                        this.n.setShowEmotion(false);
                    }
                } else {
                    this.n.setDefaultGifId(com.baidu.tieba.a.g.pic_expression_upload_selector);
                    if (this.E) {
                        this.n.setDefaultImageId(com.baidu.tieba.a.g.pic_baidu_logo_d);
                        this.n.setShowEmotion(true);
                    } else {
                        this.n.setDefaultImageId(com.baidu.tieba.a.g.icon_click);
                        this.n.setShowEmotion(false);
                    }
                }
                this.k.setText(String.format(this.f.getString(com.baidu.tieba.a.k.is_floor), Integer.valueOf(a.e())));
                String portrait = a.g().getPortrait();
                ab abVar = this.C;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (a.g() != null) {
                    this.i.setText(a.g().getName_show());
                    LinkedList<IconData> iconInfo = a.g().getIconInfo();
                    if (iconInfo == null || iconInfo.size() <= 0) {
                        this.i.setTextColor(this.f.getResources().getColor(l == 1 ? com.baidu.tieba.a.e.pb_user_name_text_1 : com.baidu.tieba.a.e.pb_user_name_text));
                    } else {
                        this.i.setTextColor(this.f.getResources().getColor(l == 1 ? com.baidu.tieba.a.e.frs_lv_item_user_name_vip_1 : com.baidu.tieba.a.e.frs_lv_item_user_name_vip));
                    }
                    int level_id = a.g().getLevel_id();
                    int isLike = a.g().getIsLike();
                    int is_bawu = a.g().getIs_bawu();
                    String bawu_type = a.g().getBawu_type();
                    int i3 = 3;
                    if (level_id == 0 || isLike == 0) {
                        this.j.setVisibility(8);
                    } else {
                        this.j.setVisibility(0);
                        this.j.setText(String.valueOf(level_id));
                        this.j.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                        this.j.setOnClickListener(null);
                        i3 = 2;
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            this.j.setText((CharSequence) null);
                            this.j.setBackgroundResource(l == 1 ? com.baidu.tieba.a.g.pb_manager_1 : com.baidu.tieba.a.g.pb_manager);
                            this.j.setOnClickListener(this.A);
                        } else if (bawu_type.equals("assist")) {
                            this.j.setText((CharSequence) null);
                            this.j.setBackgroundResource(l == 1 ? com.baidu.tieba.a.g.pb_assist_1 : com.baidu.tieba.a.g.pb_assist);
                            this.j.setOnClickListener(this.A);
                        }
                    }
                    this.a = a.g().getIconInfo();
                    this.P = a.g().getTShowInfo();
                    if (this.u != null) {
                        this.u.setOnClickListener(this.A);
                        this.u.a(this.a, i3, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_width), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_height), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_margin));
                    }
                    if (this.v != null) {
                        this.v.setOnClickListener(this.B);
                        this.v.a(this.P, 2, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_width), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_height), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_margin), true);
                    }
                }
                this.h.setUserId(a.g().getUserId());
                this.i.setTag(a.g().getUserId());
                if (b != null) {
                    b.a(this.h);
                } else {
                    this.h.setTag(portrait);
                    this.h.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
                }
                this.n.a(this.E, false);
                this.n.setText(a.h());
                this.n.setOnImageClickListener(this.I);
                this.n.setOnEmotionClickListener(this.J);
                a(a);
                this.p.setVisibility(8);
                if (TextUtils.isEmpty(a.i()) || !this.E) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    this.n.setPadding(0, 0, 0, 0);
                    this.n.setLayoutParams(layoutParams);
                    this.n.setBackgroundDrawable(null);
                } else {
                    this.n.setBackgroundDrawable(null);
                    this.n.setTag(a.i());
                    (this.e != null ? this.e.a() : null).g(a.i(), new y(this));
                }
            }
            u();
            ab a2 = this.e != null ? this.e.a() : null;
            if (a2 != null) {
                Object tag = this.h.getTag();
                String obj = tag != null ? tag.toString() : null;
                if (obj != null) {
                    a2.d(obj, new w(this));
                }
            }
        }
    }

    public void a(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            this.M.setOnActionListener(new x(this, xVar));
        }
    }

    protected int a(am amVar) {
        return amVar.d() - amVar.c().size();
    }

    public final void c(int i) {
        this.d.setSelection(1);
        this.d.invalidate();
    }

    public final void c(String str) {
        int a;
        if (str != null && !str.equals("") && (a = this.e.a(str)) >= 0) {
            this.d.setSelection(a + 1);
            this.d.invalidate();
        }
    }

    public final void s() {
        this.M.k();
    }

    public final View t() {
        return this.o;
    }

    private void a(ai aiVar) {
        com.baidu.adp.widget.ImageView.b a;
        if (aiVar != null && aiVar.h() != null && aiVar.h().a() != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = aiVar.h().a().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                switch (next.a()) {
                    case Im.GroupInfo.CREATETIME_FIELD_NUMBER /* 17 */:
                        com.baidu.tbadk.widget.richText.e g = next.g();
                        if (g != null && !g.k) {
                            z zVar = new z(this);
                            if (com.baidu.tbadk.core.util.b.b()) {
                                a = this.C.a(g.e, g.c, g.b, true, (com.baidu.tbadk.imageManager.d) zVar);
                            } else {
                                a = this.C.a(g.e, g.c, g.a, false, (com.baidu.tbadk.imageManager.d) zVar);
                            }
                            if (a == null) {
                                GifView gifView = (GifView) this.n.findViewWithTag(g.c);
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
                                GifView gifView2 = (GifView) this.n.findViewWithTag(g.c);
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
    }

    public final void u() {
        int i;
        int i2 = 0;
        try {
            if (this.F) {
                int firstVisiblePosition = this.d.getFirstVisiblePosition();
                int lastVisiblePosition = this.d.getLastVisiblePosition();
                UtilHelper.NetworkStateInfo d = UtilHelper.d(this.f);
                this.e.a().a();
                boolean z = d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG;
                this.e.a();
                int i3 = firstVisiblePosition;
                while (i3 < this.e.getCount()) {
                    if (z || i3 <= lastVisiblePosition) {
                        String portrait = ((ai) this.e.getItem(i3)).g().getPortrait();
                        if (portrait == null || portrait.length() <= 0 || i2 >= 30) {
                            i = i2;
                        } else {
                            i = i2 + 1;
                            this.e.a().d(portrait, new r(this));
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

    public final View v() {
        return this.t;
    }

    public final String w() {
        return this.M.getEditText().getText().toString();
    }

    public void a(int i) {
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a(this.b);
        this.f.getLayoutMode().a(this.c);
        this.f.getLayoutMode().a(this.t);
        if (i == 1) {
            this.o.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector_1);
            this.n.setTextColor(this.f.getResources().getColor(com.baidu.tieba.a.e.pb_listitem_content_1));
            this.n.setVideoImageId(com.baidu.tieba.a.g.pic_video_1);
            ba.e((View) this.G, com.baidu.tieba.a.g.btn_post_dl_selector_1);
        } else {
            this.o.setImageResource(com.baidu.tieba.a.g.btn_pb_reply_selector);
            this.n.setTextColor(this.f.getResources().getColor(com.baidu.tieba.a.e.pb_listitem_content));
            this.n.setVideoImageId(com.baidu.tieba.a.g.pic_video);
            ba.e((View) this.G, com.baidu.tieba.a.g.btn_post_dl_selector);
        }
        this.M.c(i);
    }

    public final void x() {
        this.d.setVisibility(8);
        this.K.setVisibility(0);
    }

    public final void y() {
        this.K.setVisibility(0);
    }

    public final void z() {
        this.K.setVisibility(8);
    }

    public final void A() {
        this.d.setVisibility(0);
        this.K.setVisibility(8);
        this.q.d();
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.L = onLongClickListener;
        this.c.setOnLongClickListener(this.L);
    }

    public final View B() {
        return this.c;
    }

    public void a(String str) {
        int a = this.e.a(str);
        if (a >= 0) {
            this.d.setSelection(a + 1);
            this.d.invalidate();
        }
    }
}
