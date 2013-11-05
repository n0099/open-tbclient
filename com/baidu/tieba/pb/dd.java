package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.AudioIcon;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class dd {
    private GridView B;
    private com.baidu.tieba.write.p C;
    private Button D;
    private EditText E;
    private Handler F;
    private ProgressBar H;
    private RecordVoiceBnt J;

    /* renamed from: a  reason: collision with root package name */
    private View f2117a;
    private View b;
    private BdListView c;
    private br d;
    private com.baidu.tieba.j e;
    private PbWriteToolView f;
    private ClickableLayout4Frame g;
    private HeadImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TbRichTextView m;
    private Button n;
    private Button o;
    private com.baidu.tieba.view.bj p;
    private LinearLayout q;
    private TextView r;
    private View s;
    private LinearLayout t;
    private View.OnClickListener u;
    private View.OnClickListener v;
    private View.OnClickListener w;
    private com.baidu.tieba.util.a x = null;
    private int y = 0;
    private boolean z = true;
    private boolean A = true;
    private com.baidu.tbadk.widget.richText.m G = null;
    private View.OnLongClickListener I = null;
    private boolean K = true;
    private boolean L = false;
    private Runnable M = new de(this);
    private Runnable N = new df(this);
    private AdapterView.OnItemClickListener O = new dj(this);
    private TextWatcher P = new dl(this);
    private AdapterView.OnItemLongClickListener Q = new dm(this);

    public dd(com.baidu.tieba.j jVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f2117a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
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
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.e = jVar;
        this.F = new Handler();
        this.u = onClickListener;
        this.w = onClickListener2;
        this.v = onClickListener3;
        LayoutInflater from = LayoutInflater.from(this.e);
        this.f2117a = from.inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.g = (ClickableLayout4Frame) this.f2117a.findViewById(R.id.sub_pb_body_layout);
        this.g.setOnClickListener(new dg(this));
        this.c = (BdListView) this.f2117a.findViewById(R.id.new_sub_pb_list);
        this.q = (LinearLayout) this.f2117a.findViewById(R.id.sub_pb_buttom_layout);
        this.r = (TextView) this.f2117a.findViewById(R.id.sub_pb_bottom_text);
        this.h = (HeadImageView) this.b.findViewById(R.id.photo);
        this.i = (TextView) this.b.findViewById(R.id.user_name);
        this.j = (TextView) this.b.findViewById(R.id.user_rank);
        this.n = (Button) this.b.findViewById(R.id.reply);
        this.o = (Button) this.b.findViewById(R.id.manage_btn);
        this.k = (TextView) this.b.findViewById(R.id.floor);
        this.l = (TextView) this.b.findViewById(R.id.time);
        this.m = (TbRichTextView) this.b.findViewById(R.id.richText);
        this.m.setTextSize(com.baidu.tieba.data.h.o());
        this.c.addHeaderView(this.b);
        this.d = new br(this.e, onClickListener3);
        this.d.a(this.w);
        this.c.setAdapter((ListAdapter) this.d);
        this.p = new com.baidu.tieba.view.bj(this.e);
        this.s = this.p.b();
        this.c.setNextPage(this.p);
        this.p.a(this.u);
        this.c.setOnItemClickListener(this.O);
        this.c.setOnItemLongClickListener(this.Q);
        this.q.setOnClickListener(this.u);
        this.t = (LinearLayout) this.f2117a.findViewById(R.id.sub_pb_reply);
        this.H = (ProgressBar) this.f2117a.findViewById(R.id.progress);
        this.E = (EditText) this.f2117a.findViewById(R.id.reply_content);
        this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.D = (Button) this.f2117a.findViewById(R.id.pb_reply_post);
        this.f = (PbWriteToolView) this.f2117a.findViewById(R.id.pb_write_tool_view);
        this.B = (GridView) this.f2117a.findViewById(R.id.face_view);
        this.J = (RecordVoiceBnt) this.f2117a.findViewById(R.id.record_voice_view);
        this.J.setCallback(new dh(this));
        this.C = new com.baidu.tieba.write.p(this.e);
        this.B.setAdapter((ListAdapter) this.C);
        this.D.setOnClickListener(this.u);
        this.f.getFaceButton().setOnClickListener(this.u);
        this.f.getAtButton().setOnClickListener(this.u);
        this.f.getAudioButton().setOnClickListener(this.u);
        this.h.setOnClickListener(onClickListener3);
        this.E.addTextChangedListener(this.P);
        this.B.setOnItemClickListener(new di(this));
        A();
    }

    private void A() {
        this.y = Math.min(UtilHelper.a((Context) this.e, 267.0f), (int) BdWebErrorView.ERROR_CODE_400);
        B();
        c(TiebaApplication.g().as());
    }

    private void B() {
        TextView textView = new TextView(this.e);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.data.h.o());
        this.x = new com.baidu.tieba.util.a(this.e);
        this.x.a(this.y, (int) (this.y * 1.62f));
    }

    public boolean a() {
        if (this.B.getVisibility() == 0 || this.J.getVisibility() == 0) {
            this.B.setVisibility(8);
            this.J.setVisibility(8);
            this.t.setVisibility(8);
            this.q.setEnabled(true);
            this.f.e();
            this.f.a();
            return true;
        }
        this.f.getAudioButton().h();
        this.J.a();
        return false;
    }

    public void a(boolean z) {
        this.A = z;
        this.d.a(z);
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.G = mVar;
    }

    public void a(int i) {
        this.m.setMaxImageWidth(i);
        this.m.setMaxImageHeight((int) (i * 1.618f));
    }

    public void a(com.baidu.tieba.util.a aVar) {
        this.x = aVar;
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.c.setOnScrollListener(onScrollListener);
    }

    public void b() {
        this.E.requestFocus();
        if (this.J.getVisibility() == 8) {
            this.B.setVisibility(8);
            this.f.f();
            this.f.d();
            UtilHelper.a(this.e, this.E);
            this.F.postDelayed(this.N, 300L);
            return;
        }
        this.f.d();
        this.f.g();
        this.B.setVisibility(8);
        this.J.setVisibility(8);
        this.t.setVisibility(0);
        this.q.setEnabled(false);
        this.E.requestFocus();
        this.E.setSelection(this.E.getText().length());
        this.e.a(this.E, 300);
    }

    public AudioIcon c() {
        return this.f.getAudioButton();
    }

    public void d() {
        this.J.setVisibility(8);
        this.f.g();
    }

    public void e() {
        this.E.requestFocus();
        if (this.B.getVisibility() == 8) {
            this.f.c();
            this.f.g();
            UtilHelper.a(this.e, this.E);
            this.F.postDelayed(this.M, 300L);
            return;
        }
        this.f.d();
        this.f.g();
        this.B.setVisibility(8);
        this.t.setVisibility(0);
        this.q.setEnabled(false);
        this.E.requestFocus();
        this.E.setSelection(this.E.getText().length());
        this.e.a(this.E, 300);
    }

    public void f() {
        this.B.setVisibility(8);
        this.f.d();
    }

    public View g() {
        return this.f2117a;
    }

    public View h() {
        return this.f.getFaceButton();
    }

    public View i() {
        return this.f.getAtButton();
    }

    public View j() {
        return this.D;
    }

    public RecordVoiceBnt k() {
        return this.J;
    }

    public void a(String str) {
        this.E.getText().insert(this.E.getSelectionStart(), "@" + str + " ");
    }

    public void b(String str) {
        this.f.b();
        if (!this.L) {
            this.f.getAudioButton().d();
            this.L = true;
        }
        this.B.setVisibility(8);
        this.J.setVisibility(8);
        this.t.setVisibility(0);
        this.q.setEnabled(false);
        if (str != null) {
            this.E.setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", str));
            this.E.setSelection(this.E.getText().length());
        }
        this.E.requestFocus();
        this.e.a(this.E, 200);
        this.f.d();
        this.f.g();
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.e, "subpb_write", "subpbclick", 1);
        }
    }

    public View l() {
        return this.B;
    }

    public void m() {
        this.B.setVisibility(8);
        this.J.setVisibility(8);
        this.f.a();
        UtilHelper.a(this.e, this.E);
        this.t.setVisibility(8);
        this.q.setEnabled(true);
    }

    public void n() {
        this.c.setNextPage(this.p);
        this.p.c();
    }

    public void b(boolean z) {
        this.z = z;
    }

    public void o() {
        this.d.a((ArrayList<com.baidu.tieba.data.as>) null);
        this.d.notifyDataSetChanged();
        this.E.setText("");
        this.f.getAudioButton().h();
        this.J.a();
    }

    public void a(com.baidu.tieba.data.bb bbVar, int i) {
        String id;
        boolean z = true;
        if (bbVar != null) {
            if (bbVar.a() != null) {
                this.D.setTag(bbVar.a().d());
            }
            if (bbVar.k()) {
                this.c.setNextPage(this.p);
            } else {
                this.c.setNextPage(null);
            }
            this.p.a(bbVar.d() - bbVar.b().size());
            this.d.a(bbVar.b());
            if (bbVar.l() == null || bbVar.l().g() == null || (id = bbVar.l().g().getId()) == null || !id.equals(TiebaApplication.C())) {
                z = false;
            }
            this.d.a(i, z);
            this.d.notifyDataSetChanged();
            a(bbVar.a(), bbVar.i(), bbVar.j());
            r();
        }
    }

    public void b(int i) {
        this.c.setSelection(i);
        this.c.invalidate();
    }

    public void p() {
        this.J.a();
        this.E.setText("");
    }

    public View q() {
        return this.n;
    }

    private void a(com.baidu.tieba.data.as asVar, boolean z, boolean z2) {
        if (asVar != null) {
            this.h.setTag(null);
            this.h.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.b.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.b.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, asVar);
            sparseArray.put(R.id.tag_is_subpb, false);
            if (!this.A) {
                this.h.setVisibility(8);
            }
            this.i.setOnClickListener(this.v);
            this.i.setText((CharSequence) null);
            this.j.setText((CharSequence) null);
            this.j.setBackgroundDrawable(null);
            this.k.setText((CharSequence) null);
            this.n.setOnClickListener(this.u);
            this.k.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            int as = TiebaApplication.g().as();
            Resources resources = this.e.getResources();
            com.baidu.tieba.util.bb.d(this.l, as);
            com.baidu.tieba.util.bb.e(this.i, as);
            this.l.setText(com.baidu.tieba.util.bc.h(new Date(asVar.f())));
            if (z) {
                if (as == 1) {
                    if (z2) {
                        this.k.setBackgroundResource(R.drawable.icon_floorhost_collect_1);
                    } else {
                        this.k.setBackgroundResource(R.drawable.icon_floorhost_1);
                    }
                } else if (z2) {
                    this.k.setBackgroundResource(R.drawable.icon_floorhost_collect);
                } else {
                    this.k.setBackgroundResource(R.drawable.icon_floorhost);
                }
            } else {
                if (as == 1) {
                    com.baidu.tieba.util.bb.e((View) this.k, (int) R.drawable.pb_list_floor_number_1);
                    if (z2) {
                        this.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect_1, 0, 0, 0);
                    } else {
                        this.k.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                } else {
                    com.baidu.tieba.util.bb.e((View) this.k, (int) R.drawable.pb_list_floor_number);
                    if (z2) {
                        this.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_collect, 0, 0, 0);
                    } else {
                        this.k.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                }
                this.k.setText(String.valueOf(asVar.e()) + resources.getString(R.string.floor));
            }
            this.n.setTag(asVar.d());
            String portrait = asVar.g().getPortrait();
            com.baidu.adp.widget.ImageView.e c = this.x.c(portrait);
            if (asVar.g() != null) {
                this.i.setText(asVar.g().getName_show());
                int level_id = asVar.g().getLevel_id();
                int isLike = asVar.g().getIsLike();
                if (level_id != 0 && isLike != 0) {
                    this.j.setText(String.valueOf(level_id));
                    this.j.setBackgroundResource(com.baidu.tieba.util.e.b(level_id));
                }
            }
            this.h.setUserId(asVar.g().getId());
            this.i.setTag(asVar.g().getId());
            if (c != null) {
                c.a(this.h);
            } else {
                this.h.setTag(portrait);
                this.h.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
            }
            this.m.setDisplayImage(this.z);
            this.m.setVoiceViewRes(R.layout.voice_play_btn);
            this.m.setText(asVar.h());
            this.m.setOnImageClickListener(this.G);
            this.o.setVisibility(8);
        }
    }

    public void r() {
        int i;
        int i2 = 0;
        try {
            if (this.A) {
                int firstVisiblePosition = this.c.getFirstVisiblePosition();
                int lastVisiblePosition = this.c.getLastVisiblePosition();
                UtilHelper.NetworkStateInfo i3 = UtilHelper.i(this.e);
                this.d.a().a();
                boolean z = i3 == UtilHelper.NetworkStateInfo.WIFI || i3 == UtilHelper.NetworkStateInfo.ThreeG;
                this.d.a().a(z);
                int i4 = firstVisiblePosition;
                while (i4 < this.d.getCount()) {
                    if (z || i4 <= lastVisiblePosition) {
                        String portrait = ((com.baidu.tieba.data.as) this.d.getItem(i4)).g().getPortrait();
                        if (portrait == null || portrait.length() <= 0 || i2 >= 30) {
                            i = i2;
                        } else {
                            i = i2 + 1;
                            this.d.a().d(portrait, new dk(this));
                        }
                        if (z) {
                        }
                        i4++;
                        i2 = i;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public View s() {
        return this.s;
    }

    public String t() {
        return this.E.getText().toString();
    }

    public boolean u() {
        Editable text = this.E.getText();
        if (text == null || text.length() <= 0) {
            VoiceManager.VoiceModel voiceModel = this.J.getVoiceModel();
            return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
        }
        return true;
    }

    public void c(int i) {
        this.e.m().a(i == 1);
        this.e.m().a(this.f2117a);
        this.e.m().a(this.b);
        if (i == 1) {
            this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ico_upward_1, 0);
            this.m.setTextColor(this.e.getResources().getColor(R.color.gray_night_1));
            this.m.setVideoImageId(R.drawable.pic_video_1);
            com.baidu.tieba.util.bb.e((View) this.D, (int) R.drawable.btn_post_dl_selector_1);
            this.D.setTextColor(this.e.getResources().getColorStateList(R.color.post_image_btn_color_1));
            this.f2117a.setBackgroundResource(R.drawable.common_bg_1);
            com.baidu.tieba.util.bb.e((View) this.n, (int) R.drawable.common_image_btn_selector_1);
            this.n.setTextColor(this.e.getResources().getColorStateList(R.color.common_image_btn_color_1));
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector_1, 0, 0, 0);
            this.c.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ico_upward, 0);
        this.m.setTextColor(this.e.getResources().getColor(R.color.search_text_content));
        this.m.setVideoImageId(R.drawable.pic_video);
        com.baidu.tieba.util.bb.e((View) this.D, (int) R.drawable.btn_post_dl_selector);
        this.D.setTextColor(this.e.getResources().getColorStateList(R.color.post_image_btn_color));
        this.f2117a.setBackgroundResource(R.drawable.common_bg);
        com.baidu.tieba.util.bb.e((View) this.n, (int) R.drawable.common_image_btn_selector);
        this.n.setTextColor(this.e.getResources().getColorStateList(R.color.common_image_btn_color));
        this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_discuss_dl_selector, 0, 0, 0);
        this.c.setSelector(R.drawable.list_selector);
    }

    public void v() {
        this.c.setVisibility(8);
        this.H.setVisibility(0);
    }

    public void w() {
        this.H.setVisibility(0);
    }

    public void x() {
        this.H.setVisibility(8);
    }

    public void y() {
        this.c.setVisibility(0);
        this.H.setVisibility(8);
        this.p.d();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.I = onLongClickListener;
        this.b.setOnLongClickListener(this.I);
    }

    public View z() {
        return this.b;
    }
}
