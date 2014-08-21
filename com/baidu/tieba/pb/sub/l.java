package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortool.w;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.au;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class l {
    protected View.OnClickListener A;
    protected View.OnClickListener B;
    protected View.OnClickListener C;
    protected Handler H;
    protected ProgressBar K;
    protected BdListView d;
    protected BaseActivity f;
    protected ClickableLayout4Frame g;
    protected HeadImageView h;
    protected TextView i;
    protected TextView j;
    protected ImageView k;
    protected TextView l;
    protected ImageView m;
    protected TextView n;
    protected TbRichTextView o;
    protected ImageView p;
    protected Button q;
    protected d r;
    protected LinearLayout s;
    protected TextView t;
    protected View u;
    protected UserIconBox v;
    protected UserIconBox w;
    protected View.OnClickListener y;
    protected View.OnClickListener z;
    protected View b = null;
    protected View c = null;
    protected a e = null;
    protected LinearLayout x = null;
    protected int D = 0;
    protected boolean E = true;
    protected boolean F = true;
    private boolean a = true;
    protected Button G = null;
    protected com.baidu.tbadk.widget.richText.s I = null;
    protected com.baidu.tbadk.widget.richText.r J = null;
    protected View.OnLongClickListener L = null;
    private LinkedList<IconData> P = null;
    private LinkedList<IconData> Q = null;
    protected PbEditor M = null;
    private String R = null;
    private String S = null;
    private boolean T = false;
    protected AdapterView.OnItemClickListener N = new m(this);
    protected AdapterView.OnItemLongClickListener O = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
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
        this.w = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.H = null;
        this.K = null;
        this.f = baseActivity;
        this.H = new Handler();
        this.y = onClickListener;
        this.A = onClickListener2;
        this.z = onClickListener3;
        this.B = onClickListener4;
        this.C = onClickListener5;
        h();
        this.g = (ClickableLayout4Frame) this.b.findViewById(u.sub_pb_body_layout);
        this.d = (BdListView) this.b.findViewById(u.new_sub_pb_list);
        this.c.setOnClickListener(new o(this));
        this.s = (LinearLayout) this.b.findViewById(u.sub_pb_bottom_layout);
        b();
        this.t = (TextView) this.b.findViewById(u.sub_pb_bottom_text);
        this.h = (HeadImageView) this.c.findViewById(u.photo);
        this.i = (TextView) this.c.findViewById(u.user_name);
        this.j = (TextView) this.c.findViewById(u.user_rank);
        this.k = (ImageView) this.c.findViewById(u.user_gender);
        this.p = (ImageView) this.c.findViewById(u.reply);
        this.q = (Button) this.c.findViewById(u.manage_btn);
        this.l = (TextView) this.c.findViewById(u.floor);
        this.m = (ImageView) this.c.findViewById(u.floor_owner);
        this.n = (TextView) this.c.findViewById(u.time);
        this.v = (UserIconBox) this.c.findViewById(u.user_icon_box);
        this.w = (UserIconBox) this.c.findViewById(u.user_tshow_icon_box);
        this.o = (TbRichTextView) this.c.findViewById(u.richText);
        this.o.setTextSize(TbConfig.getContentSize());
        this.o.setVoiceViewRes(v.voice_play_btn);
        this.d.addHeaderView(this.c);
        a(onClickListener3);
        this.r = new d(this.f);
        this.u = this.r.b();
        this.d.setNextPage(this.r);
        this.r.a(this.y);
        this.d.setOnItemClickListener(this.N);
        this.d.setOnItemLongClickListener(this.O);
        this.s.setOnClickListener(this.y);
        this.K = (ProgressBar) this.b.findViewById(u.progress);
        this.h.setOnClickListener(onClickListener3);
        i();
        if (this.c != null) {
            this.c.setVisibility(4);
        }
        if (this.g != null) {
            this.g.setVisibility(4);
        }
        if (this.s != null) {
            this.s.setVisibility(4);
        }
    }

    protected void b() {
        this.M = (PbEditor) this.b.findViewById(u.sub_pb_editor);
        this.M.a(true);
        this.M.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.M.setMaxTextCount(140);
    }

    protected void a(View.OnClickListener onClickListener) {
        this.e = new a(this.f, onClickListener);
        this.e.a(this.A);
        this.e.a(this.a);
        this.d.setAdapter((ListAdapter) this.e);
    }

    protected void h() {
        this.b = com.baidu.adp.lib.e.b.a().a(this.f, v.new_sub_pb_layout, null);
        this.c = com.baidu.adp.lib.e.b.a().a(this.f, v.new_sub_pb_head, null);
    }

    protected void i() {
        this.D = Math.min(com.baidu.adp.lib.util.j.a((Context) this.f, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        k();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void j() {
        if (!this.M.h()) {
            b((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, View view) {
        new Handler().postDelayed(new p(this, view, i), 300L);
    }

    protected void k() {
        TextView textView = new TextView(this.f);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void a(boolean z) {
        this.M.setAudioFocusable(z);
    }

    public boolean a() {
        this.T = false;
        if (this.M.p()) {
            this.M.f();
            this.M.o();
            this.s.setEnabled(true);
            return true;
        }
        this.M.m();
        this.R = null;
        return false;
    }

    public void b(boolean z) {
        this.F = z;
        this.e.b(z);
    }

    public void a(com.baidu.tbadk.widget.richText.s sVar) {
        this.I = sVar;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.J = rVar;
    }

    public void b(int i) {
        this.o.setMaxImageWidth(i);
        this.o.setMaxImageHeight((int) (i * 1.618f));
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.d.setOnScrollListener(onScrollListener);
    }

    public void l() {
        this.M.q();
    }

    public void m() {
        this.M.r();
    }

    public View n() {
        return this.b;
    }

    public VoiceData.VoiceModel o() {
        return this.M.getAudioData();
    }

    public void p() {
        this.M.s();
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
                    this.M.getEditText().getText().insert(this.M.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void a(String str, String str2) {
        b(str);
        new Handler().postDelayed(new q(this, str2), 200L);
    }

    public void b(String str) {
        this.T = true;
        this.M.n();
        this.s.setEnabled(false);
        if (str != null) {
            this.M.getEditText().setText(this.f.getResources().getString(x.reply_sub_floor).replace("%s", str));
            this.M.getEditText().setSelection(this.M.getEditText().getText().length());
        }
        if (this.M.h()) {
            this.M.e();
            this.M.k();
        } else {
            this.M.getEditText().requestFocus();
            this.f.ShowSoftKeyPadDelay(this.M.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.f, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.T = true;
        this.M.n();
        this.s.setEnabled(false);
        this.M.getEditText().setText(str);
        this.M.getEditText().setSelection(this.M.getEditText().getText().length());
        if (this.M.h()) {
            this.M.e();
            this.M.k();
        } else {
            this.M.getEditText().requestFocus();
            this.f.ShowSoftKeyPadDelay(this.M.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.f, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void q() {
        this.T = false;
        this.M.o();
        this.s.setEnabled(true);
    }

    public void r() {
        this.d.setNextPage(this.r);
        this.r.c();
    }

    public void c(boolean z) {
        this.E = z;
    }

    public void s() {
        this.e.a((ArrayList<an>) null);
        this.e.notifyDataSetChanged();
        this.M.getEditText().setText("");
        this.M.m();
    }

    public String t() {
        return this.R;
    }

    public void a(au auVar, int i) {
        String userId;
        boolean z = true;
        if (auVar != null) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            if (this.g != null) {
                this.g.setVisibility(0);
            }
            if (this.s != null) {
                this.s.setVisibility(0);
            }
            if (auVar.b() != null) {
                this.R = auVar.b().d();
            }
            if (auVar.m()) {
                this.d.setNextPage(this.r);
                this.e.c(true);
            } else {
                this.d.setNextPage(null);
                this.e.c(false);
            }
            this.r.a(a(auVar));
            this.e.a(auVar.d());
            if (auVar.n() == null || auVar.n().q() == null || (userId = auVar.n().q().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
                z = false;
            }
            this.e.a(i, z);
            this.e.notifyDataSetChanged();
            a(auVar.b(), auVar.k(), auVar.l());
        }
    }

    public void a(w wVar) {
        if (wVar != null) {
            this.M.setOnActionListener(new r(this, wVar));
        }
    }

    protected int a(au auVar) {
        if (auVar == null) {
            return 0;
        }
        return auVar.f() - auVar.d().size();
    }

    public void c(int i) {
        this.d.setSelection(i);
        this.d.invalidate();
    }

    public void c(String str) {
        int a;
        if (str != null && !str.equals("") && (a = this.e.a(str)) >= 0) {
            this.d.setSelection(a + 1);
            this.d.invalidate();
        }
    }

    public void u() {
        this.M.m();
    }

    public View v() {
        return this.p;
    }

    protected void a(an anVar, boolean z, boolean z2) {
        int i;
        if (anVar != null) {
            this.h.setTag(null);
            this.h.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.c.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.c.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(u.tag_clip_board, anVar);
            sparseArray.put(u.tag_is_subpb, false);
            this.p.setTag(sparseArray);
            if (!this.F) {
                this.h.setVisibility(8);
            }
            this.i.setOnClickListener(this.z);
            this.i.setText((CharSequence) null);
            this.j.setText((CharSequence) null);
            this.j.setBackgroundDrawable(null);
            this.m.setVisibility(8);
            this.l.setText((CharSequence) null);
            this.p.setOnClickListener(this.y);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            this.n.setTextColor(this.f.getResources().getColor(skinType == 1 ? com.baidu.tieba.r.pb_listitem_post_time_1 : com.baidu.tieba.r.pb_listitem_post_time));
            this.n.setText(ba.a(anVar.o_()));
            if (z) {
                this.m.setVisibility(0);
                if (skinType == 1) {
                    this.m.setImageResource(t.icon_floorhost_1);
                } else {
                    this.m.setImageResource(t.icon_floorhost);
                }
            }
            if (skinType == 1) {
                if (this.E) {
                    this.o.setDefaultImageId(t.img_default_100);
                } else {
                    this.o.setDefaultImageId(t.icon_click_1);
                }
            } else if (this.E) {
                this.o.setDefaultImageId(t.img_default_100_1);
            } else {
                this.o.setDefaultImageId(t.icon_click);
            }
            this.l.setText(String.format(this.f.getString(x.is_floor), Integer.valueOf(anVar.e())));
            String portrait = anVar.g().getPortrait();
            if (anVar.g() != null) {
                this.i.setText(anVar.g().getName_show());
                LinkedList<IconData> tShowInfo = anVar.g().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    TextView textView = this.i;
                    Resources resources = this.f.getResources();
                    if (skinType == 1) {
                        i = com.baidu.tieba.r.cp_cont_h_1;
                    } else {
                        i = com.baidu.tieba.r.cp_cont_h;
                    }
                    textView.setTextColor(resources.getColor(i));
                } else {
                    this.i.setTextColor(this.f.getResources().getColor(skinType == 1 ? com.baidu.tieba.r.cp_cont_f_1 : com.baidu.tieba.r.cp_cont_f));
                }
                int level_id = anVar.g().getLevel_id();
                int is_bawu = anVar.g().getIs_bawu();
                String bawu_type = anVar.g().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.j.setVisibility(0);
                    this.j.setText(String.valueOf(level_id));
                    this.j.setBackgroundResource(com.baidu.tbadk.core.util.d.b(level_id));
                    this.j.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.j.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.j.setText((CharSequence) null);
                        this.j.setBackgroundResource(skinType == 1 ? t.pb_manager_1 : t.pb_manager);
                        this.j.setOnClickListener(this.B);
                    } else if (bawu_type.equals("assist")) {
                        this.j.setText((CharSequence) null);
                        this.j.setBackgroundResource(skinType == 1 ? t.pb_assist_1 : t.pb_assist);
                        this.j.setOnClickListener(this.B);
                    }
                }
                if (anVar.g().getGender() == 2) {
                    this.k.setImageResource(skinType == 1 ? t.icon_pop_girl_square_1 : t.icon_pop_girl_square);
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                this.P = anVar.g().getIconInfo();
                this.Q = anVar.g().getTShowInfo();
                if (this.v != null) {
                    this.v.setOnClickListener(this.B);
                    this.v.a(this.P, i2, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_width), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_height), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_margin));
                }
                if (this.w != null) {
                    this.w.setOnClickListener(this.C);
                    this.w.a(this.Q, 2, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_width), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_height), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_margin), true);
                }
            }
            this.h.setUserId(anVar.g().getUserId());
            this.i.setTag(anVar.g().getUserId());
            this.h.setDefaultResource(t.photo);
            this.h.a(portrait, 12, false);
            this.o.a(this.E, false);
            this.o.setIsFromCDN(this.a);
            this.o.setText(anVar.h());
            this.o.setOnImageClickListener(this.I);
            this.o.setOnEmotionClickListener(this.J);
            this.q.setVisibility(8);
            if (!TextUtils.isEmpty(anVar.i()) && this.E) {
                this.o.setBackgroundDrawable(null);
                this.o.setTag(anVar.i());
                com.baidu.adp.lib.resourceLoader.d.a().a(anVar.i(), 19, new s(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.o.setPadding(0, 0, 0, 0);
            this.o.setLayoutParams(layoutParams);
            this.o.setBackgroundDrawable(null);
        }
    }

    public View w() {
        return this.u;
    }

    public String x() {
        return this.M.getEditText().getText().toString();
    }

    public void a(int i) {
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a(this.b);
        this.f.getLayoutMode().a(this.c);
        this.f.getLayoutMode().a(this.u);
        if (i == 1) {
            this.p.setImageResource(t.btn_pb_reply_selector_1);
            this.o.setTextColor(this.f.getResources().getColor(com.baidu.tieba.r.pb_listitem_content_1));
            this.o.setVideoImageId(t.pic_video_1);
            ay.e((View) this.G, t.btn_post_dl_selector_1);
        } else {
            this.p.setImageResource(t.btn_pb_reply_selector);
            this.o.setTextColor(this.f.getResources().getColor(com.baidu.tieba.r.pb_listitem_content));
            this.o.setVideoImageId(t.pic_video);
            ay.e((View) this.G, t.btn_post_dl_selector);
        }
        this.M.c(i);
    }

    public void y() {
        this.d.setVisibility(8);
        this.K.setVisibility(0);
    }

    public void z() {
        this.K.setVisibility(0);
    }

    public void A() {
        this.K.setVisibility(8);
    }

    public void B() {
        this.d.setVisibility(0);
        this.K.setVisibility(8);
        this.r.d();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.L = onLongClickListener;
        this.c.setOnLongClickListener(this.L);
    }

    public View C() {
        return this.c;
    }

    public void a(String str) {
        int a = this.e.a(str);
        if (a > -1) {
            this.d.setSelection(a + 1);
            this.d.invalidate();
        }
    }

    public void d(boolean z) {
        this.a = z;
    }

    public boolean D() {
        return this.M.l();
    }
}
