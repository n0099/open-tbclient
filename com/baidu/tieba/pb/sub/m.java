package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortool.x;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.ap;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class m {
    protected View.OnClickListener A;
    protected View.OnClickListener B;
    protected Handler G;
    protected ProgressBar J;
    protected BdListView d;
    protected BaseActivity f;
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
    protected int C = 0;
    protected boolean D = true;
    protected boolean E = true;
    private boolean a = true;
    protected Button F = null;
    protected com.baidu.tbadk.widget.richText.s H = null;
    protected com.baidu.tbadk.widget.richText.r I = null;
    protected View.OnLongClickListener K = null;
    private LinkedList<IconData> O = null;
    private LinkedList<IconData> P = null;
    protected PbEditor L = null;
    private String Q = null;
    private boolean R = false;
    protected AdapterView.OnItemClickListener M = new n(this);
    protected AdapterView.OnItemLongClickListener N = new r(this);

    public m(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
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
        this.G = null;
        this.J = null;
        this.f = baseActivity;
        this.G = new Handler();
        this.x = onClickListener;
        this.z = onClickListener2;
        this.y = onClickListener3;
        this.A = onClickListener4;
        this.B = onClickListener5;
        h();
        this.g = (ClickableLayout4Frame) this.b.findViewById(com.baidu.tieba.v.sub_pb_body_layout);
        this.d = (BdListView) this.b.findViewById(com.baidu.tieba.v.new_sub_pb_list);
        this.c.setOnClickListener(new s(this));
        this.r = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.sub_pb_bottom_layout);
        b();
        this.s = (TextView) this.b.findViewById(com.baidu.tieba.v.sub_pb_bottom_text);
        this.h = (HeadImageView) this.c.findViewById(com.baidu.tieba.v.photo);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.v.user_name);
        this.j = (TextView) this.c.findViewById(com.baidu.tieba.v.user_rank);
        this.o = (ImageView) this.c.findViewById(com.baidu.tieba.v.reply);
        this.p = (Button) this.c.findViewById(com.baidu.tieba.v.manage_btn);
        this.k = (TextView) this.c.findViewById(com.baidu.tieba.v.floor);
        this.l = (ImageView) this.c.findViewById(com.baidu.tieba.v.floor_owner);
        this.m = (TextView) this.c.findViewById(com.baidu.tieba.v.time);
        this.u = (UserIconBox) this.c.findViewById(com.baidu.tieba.v.user_icon_box);
        this.v = (UserIconBox) this.c.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.n = (TbRichTextView) this.c.findViewById(com.baidu.tieba.v.richText);
        this.n.setTextSize(TbConfig.getContentSize());
        this.n.setVoiceViewRes(com.baidu.tieba.w.voice_play_btn);
        this.d.addHeaderView(this.c);
        a(onClickListener3);
        this.q = new e(this.f);
        this.t = this.q.b();
        this.d.setNextPage(this.q);
        this.q.a(this.x);
        this.d.setOnItemClickListener(this.M);
        this.d.setOnItemLongClickListener(this.N);
        this.r.setOnClickListener(this.x);
        this.J = (ProgressBar) this.b.findViewById(com.baidu.tieba.v.progress);
        this.h.setOnClickListener(onClickListener3);
        i();
    }

    protected void b() {
        this.L = (PbEditor) this.b.findViewById(com.baidu.tieba.v.sub_pb_editor);
        this.L.a(true);
        this.L.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.L.setMaxTextCount(140);
    }

    protected void a(View.OnClickListener onClickListener) {
        this.e = new b(this.f, onClickListener);
        this.e.a(this.z);
        this.e.a(this.a);
        this.d.setAdapter((ListAdapter) this.e);
    }

    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.f);
        this.b = from.inflate(com.baidu.tieba.w.new_sub_pb_layout, (ViewGroup) null);
        this.c = from.inflate(com.baidu.tieba.w.new_sub_pb_head, (ViewGroup) null);
    }

    protected void i() {
        this.C = Math.min(com.baidu.adp.lib.util.k.a((Context) this.f, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        k();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void j() {
        if (!this.L.h()) {
            b((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, View view) {
        new Handler().postDelayed(new t(this, i, view), 300L);
    }

    protected void k() {
        TextView textView = new TextView(this.f);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void a(boolean z) {
        this.L.setAudioFocusable(z);
    }

    public boolean a() {
        this.R = false;
        if (this.L.p()) {
            this.L.f();
            this.L.o();
            this.r.setEnabled(true);
            return true;
        }
        this.L.m();
        this.Q = null;
        return false;
    }

    public void b(boolean z) {
        this.E = z;
        this.e.b(z);
    }

    public void a(com.baidu.tbadk.widget.richText.s sVar) {
        this.H = sVar;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.I = rVar;
    }

    public void b(int i) {
        this.n.setMaxImageWidth(i);
        this.n.setMaxImageHeight((int) (i * 1.618f));
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.d.setOnScrollListener(onScrollListener);
    }

    public void l() {
        this.L.q();
    }

    public void m() {
        this.L.r();
    }

    public View n() {
        return this.b;
    }

    public VoiceData.VoiceModel o() {
        return this.L.getAudioData();
    }

    public void p() {
        this.L.s();
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
        new Handler().postDelayed(new u(this, str2), 200L);
    }

    public void b(String str) {
        this.R = true;
        this.L.n();
        this.r.setEnabled(false);
        if (str != null) {
            this.L.getEditText().setText(this.f.getResources().getString(y.reply_sub_floor).replace("%s", str));
            this.L.getEditText().setSelection(this.L.getEditText().getText().length());
        }
        if (this.L.h()) {
            this.L.k();
        } else {
            this.L.getEditText().requestFocus();
            this.f.ShowSoftKeyPadDelay(this.L.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.f, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void q() {
        this.R = false;
        this.L.o();
        this.r.setEnabled(true);
    }

    public void r() {
        this.d.setNextPage(this.q);
        this.q.c();
    }

    public void c(boolean z) {
        this.D = z;
    }

    public void s() {
        this.e.a((ArrayList<ai>) null);
        this.e.notifyDataSetChanged();
        this.L.getEditText().setText("");
        this.L.m();
    }

    public String t() {
        return this.Q;
    }

    public void a(ap apVar, int i) {
        String userId;
        boolean z = true;
        if (apVar != null) {
            if (apVar.a() != null) {
                this.Q = apVar.a().l();
            }
            if (apVar.l()) {
                this.d.setNextPage(this.q);
                this.e.c(true);
            } else {
                this.d.setNextPage(null);
                this.e.c(false);
            }
            this.q.a(a(apVar));
            this.e.a(apVar.c());
            if (apVar.m() == null || apVar.m().y() == null || (userId = apVar.m().y().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
                z = false;
            }
            this.e.a(i, z);
            this.e.notifyDataSetChanged();
            a(apVar.a(), apVar.j(), apVar.k());
        }
    }

    public void a(x xVar) {
        if (xVar != null) {
            this.L.setOnActionListener(new v(this, xVar));
        }
    }

    protected int a(ap apVar) {
        return apVar.e() - apVar.c().size();
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
        this.L.m();
    }

    public View v() {
        return this.o;
    }

    protected void a(ai aiVar, boolean z, boolean z2) {
        int i;
        if (aiVar != null) {
            this.h.setTag(null);
            this.h.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.c.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.c.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, aiVar);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            this.o.setTag(sparseArray);
            if (!this.E) {
                this.h.setVisibility(8);
            }
            this.i.setOnClickListener(this.y);
            this.i.setText((CharSequence) null);
            this.j.setText((CharSequence) null);
            this.j.setBackgroundDrawable(null);
            this.l.setVisibility(8);
            this.k.setText((CharSequence) null);
            this.o.setOnClickListener(this.x);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            this.m.setTextColor(this.f.getResources().getColor(skinType == 1 ? com.baidu.tieba.s.pb_listitem_post_time_1 : com.baidu.tieba.s.pb_listitem_post_time));
            this.m.setText(bg.a(aiVar.n()));
            if (z) {
                this.l.setVisibility(0);
                if (skinType == 1) {
                    this.l.setImageResource(com.baidu.tieba.u.icon_floorhost_1);
                } else {
                    this.l.setImageResource(com.baidu.tieba.u.icon_floorhost);
                }
            }
            if (skinType == 1) {
                this.n.setDefaultGifId(com.baidu.tieba.u.pic_expression_upload_selector_1);
                if (this.D) {
                    this.n.setDefaultImageId(com.baidu.tieba.u.pic_baidu_logo_d_1);
                    this.n.setShowEmotion(true);
                } else {
                    this.n.setDefaultImageId(com.baidu.tieba.u.icon_click_1);
                    this.n.setShowEmotion(false);
                }
            } else {
                this.n.setDefaultGifId(com.baidu.tieba.u.pic_expression_upload_selector);
                if (this.D) {
                    this.n.setDefaultImageId(com.baidu.tieba.u.pic_baidu_logo_d);
                    this.n.setShowEmotion(true);
                } else {
                    this.n.setDefaultImageId(com.baidu.tieba.u.icon_click);
                    this.n.setShowEmotion(false);
                }
            }
            this.k.setText(String.format(this.f.getString(y.is_floor), Integer.valueOf(aiVar.m())));
            String portrait = aiVar.o().getPortrait();
            if (aiVar.o() != null) {
                this.i.setText(aiVar.o().getName_show());
                LinkedList<IconData> tShowInfo = aiVar.o().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    TextView textView = this.i;
                    Resources resources = this.f.getResources();
                    if (skinType == 1) {
                        i = com.baidu.tieba.s.cp_cont_h_1;
                    } else {
                        i = com.baidu.tieba.s.cp_cont_h;
                    }
                    textView.setTextColor(resources.getColor(i));
                } else {
                    this.i.setTextColor(this.f.getResources().getColor(skinType == 1 ? com.baidu.tieba.s.cp_cont_f_1 : com.baidu.tieba.s.cp_cont_f));
                }
                int level_id = aiVar.o().getLevel_id();
                int is_bawu = aiVar.o().getIs_bawu();
                String bawu_type = aiVar.o().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.j.setVisibility(0);
                    this.j.setText(String.valueOf(level_id));
                    this.j.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                    this.j.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.j.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.j.setText((CharSequence) null);
                        this.j.setBackgroundResource(skinType == 1 ? com.baidu.tieba.u.pb_manager_1 : com.baidu.tieba.u.pb_manager);
                        this.j.setOnClickListener(this.A);
                    } else if (bawu_type.equals("assist")) {
                        this.j.setText((CharSequence) null);
                        this.j.setBackgroundResource(skinType == 1 ? com.baidu.tieba.u.pb_assist_1 : com.baidu.tieba.u.pb_assist);
                        this.j.setOnClickListener(this.A);
                    }
                }
                this.O = aiVar.o().getIconInfo();
                this.P = aiVar.o().getTShowInfo();
                if (this.u != null) {
                    this.u.setOnClickListener(this.A);
                    this.u.a(this.O, i2, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.v != null) {
                    this.v.setOnClickListener(this.B);
                    this.v.a(this.P, 2, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.f.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
            }
            this.h.setUserId(aiVar.o().getUserId());
            this.i.setTag(aiVar.o().getUserId());
            this.h.setDefaultResource(com.baidu.tieba.u.photo);
            this.h.a(portrait, 12, false);
            this.n.a(this.D, false);
            this.n.setIsFromCDN(this.a);
            this.n.setText(aiVar.p());
            this.n.setOnImageClickListener(this.H);
            this.n.setOnEmotionClickListener(this.I);
            this.p.setVisibility(8);
            if (!TextUtils.isEmpty(aiVar.q()) && this.D) {
                this.n.setBackgroundDrawable(null);
                this.n.setTag(aiVar.q());
                (this.e != null ? this.e.a() : null).f(aiVar.q(), new w(this));
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.n.setPadding(0, 0, 0, 0);
            this.n.setLayoutParams(layoutParams);
            this.n.setBackgroundDrawable(null);
        }
    }

    public View w() {
        return this.t;
    }

    public String x() {
        return this.L.getEditText().getText().toString();
    }

    public void a(int i) {
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a(this.b);
        this.f.getLayoutMode().a(this.c);
        this.f.getLayoutMode().a(this.t);
        if (i == 1) {
            this.o.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector_1);
            this.n.setTextColor(this.f.getResources().getColor(com.baidu.tieba.s.pb_listitem_content_1));
            this.n.setVideoImageId(com.baidu.tieba.u.pic_video_1);
            be.e((View) this.F, com.baidu.tieba.u.btn_post_dl_selector_1);
        } else {
            this.o.setImageResource(com.baidu.tieba.u.btn_pb_reply_selector);
            this.n.setTextColor(this.f.getResources().getColor(com.baidu.tieba.s.pb_listitem_content));
            this.n.setVideoImageId(com.baidu.tieba.u.pic_video);
            be.e((View) this.F, com.baidu.tieba.u.btn_post_dl_selector);
        }
        this.L.c(i);
    }

    public void y() {
        this.d.setVisibility(8);
        this.J.setVisibility(0);
    }

    public void z() {
        this.J.setVisibility(0);
    }

    public void A() {
        this.J.setVisibility(8);
    }

    public void B() {
        this.d.setVisibility(0);
        this.J.setVisibility(8);
        this.q.d();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.K = onLongClickListener;
        this.c.setOnLongClickListener(this.K);
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
        return this.L.l();
    }
}
