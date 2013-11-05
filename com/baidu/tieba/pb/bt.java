package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ClickableLayout;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.AudioIcon;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bt {
    private ProgressBar A;
    private com.baidu.tieba.view.bb I;
    private PbListView J;
    private View K;
    private GridView M;
    private com.baidu.tieba.write.p N;
    private View.OnClickListener P;
    private Handler U;
    private View.OnClickListener W;

    /* renamed from: a  reason: collision with root package name */
    public EditText f2081a;
    private RecordVoiceBnt ax;
    bn b;
    private NewPbActivity c;
    private KeyboardEventLayout d;
    private ClickableLayout e;
    private ClickableLayout4Frame f;
    private BdListView g;
    private NoNetworkView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private Button l;
    private ImageButton m;
    private AudioIcon n;
    private ImageButton o;
    private ImageButton p;
    private ImageButton q;
    private AudioIcon r;
    private ImageButton s;
    private TextView t;
    private View u;
    private View v;
    private LinearLayout w;
    private LinearLayout x;
    private LinearLayout y;
    private bo z;
    private Dialog B = null;
    private Dialog C = null;
    private Dialog D = null;
    private dd E = null;
    private View F = null;
    private EditText G = null;
    private View H = null;
    private View L = null;
    private DialogInterface.OnClickListener O = null;
    private View.OnClickListener Q = null;
    private AbsListView.OnScrollListener R = null;
    private com.baidu.tbadk.widget.richText.m S = null;
    private com.baidu.tieba.view.az T = null;
    private Dialog V = null;
    private Dialog X = null;
    private View Y = null;
    private Button Z = null;
    private Button aa = null;
    private TextView ab = null;
    private Dialog ac = null;
    private View ad = null;
    private int ae = 0;
    private RadioGroup af = null;
    private RadioButton ag = null;
    private RadioButton ah = null;
    private RadioButton ai = null;
    private Button aj = null;
    private Button ak = null;
    private TextView al = null;
    private Dialog am = null;
    private View an = null;
    private RadioGroup ao = null;
    private CompoundButton.OnCheckedChangeListener ap = null;
    private Button aq = null;
    private Button ar = null;
    private String as = null;
    private boolean at = false;
    private db au = null;
    private Dialog av = null;
    private boolean aw = false;
    private boolean ay = false;
    private LinearLayout az = null;
    private PbListView aA = null;
    private boolean aB = false;
    private View.OnClickListener aC = new cx(this);
    private Runnable aD = new cf(this);
    private Runnable aE = new cg(this);
    private boolean aF = false;
    private View.OnTouchListener aG = new ck(this);
    private com.baidu.tbadk.imageManager.c aH = new cn(this);
    private com.baidu.tieba.view.ao aI = new co(this);
    private TextWatcher aJ = new ct(this);

    public NoNetworkView a() {
        return this.h;
    }

    public bt(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
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
        this.f2081a = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.M = null;
        this.N = null;
        this.P = null;
        this.U = null;
        this.W = null;
        this.c = newPbActivity;
        this.P = onClickListener;
        this.U = new Handler();
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = (KeyboardEventLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.c.addContentView(this.d, new FrameLayout.LayoutParams(-2, -2));
        this.x = (LinearLayout) from.inflate(R.layout.reply_post, (ViewGroup) null);
        this.y = (LinearLayout) this.x.findViewById(R.id.extern);
        this.e = (ClickableLayout) this.c.findViewById(R.id.pb_title);
        this.e.setOnkeyUpListener(new bu(this));
        this.f = (ClickableLayout4Frame) this.c.findViewById(R.id.pb_center);
        this.f.setOnkeyUpListener(new ci(this));
        this.h = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        this.g = (BdListView) this.c.findViewById(R.id.new_pb_list);
        this.i = (ImageView) this.c.findViewById(R.id.pb_title_back);
        this.t = (TextView) this.c.findViewById(R.id.pb_title_forum);
        this.k = (ImageView) this.c.findViewById(R.id.pb_title_more);
        this.j = (ImageView) this.c.findViewById(R.id.pb_title_host);
        this.k.setScaleType(ImageView.ScaleType.CENTER);
        this.j.setScaleType(ImageView.ScaleType.CENTER);
        this.A = (ProgressBar) this.c.findViewById(R.id.progress);
        this.w = (LinearLayout) this.c.findViewById(R.id.pb_reply);
        this.w.addView(this.x);
        this.l = (Button) this.x.findViewById(R.id.pb_reply_post);
        this.m = (ImageButton) this.x.findViewById(R.id.pb_button_face);
        this.n = (AudioIcon) this.x.findViewById(R.id.audio_button);
        this.o = (ImageButton) this.x.findViewById(R.id.pb_button_camera);
        this.f2081a = (EditText) this.x.findViewById(R.id.reply_content);
        this.p = (ImageButton) this.y.findViewById(R.id.pb_button_face1);
        this.r = (AudioIcon) this.y.findViewById(R.id.audio_button1);
        this.s = (ImageButton) this.y.findViewById(R.id.pb_button_camera1);
        this.q = (ImageButton) this.y.findViewById(R.id.pb_button_at1);
        this.v = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.u = (LinearLayout) this.v.findViewById(R.id.pb_header_container);
        aj();
        this.z = new bo(this.c);
        this.z.b(this.P);
        this.z.a(this.S);
        this.W = new cu(this);
        this.z.c(this.W);
        this.g.setAdapter((ListAdapter) this.z);
        this.g.addHeaderView(this.v);
        this.I = new com.baidu.tieba.view.bb(this.c);
        this.I.a();
        this.J = new PbListView(this.c);
        this.K = this.J.b().findViewById(R.id.pb_more_view);
        if (this.K != null) {
            this.K.setOnClickListener(this.P);
        }
        this.M = (GridView) this.c.findViewById(R.id.face_view);
        this.N = new com.baidu.tieba.write.p(this.c);
        this.M.setAdapter((ListAdapter) this.N);
        this.M.setOnItemClickListener(new cv(this));
        this.ax = (RecordVoiceBnt) this.c.findViewById(R.id.record_voice_view);
        this.ax.setCallback(new cw(this));
        this.i.setOnClickListener(this.P);
        this.t.setOnClickListener(this.P);
        this.k.setOnClickListener(this.P);
        this.j.setOnClickListener(this.P);
        this.l.setOnClickListener(this.P);
        this.o.setOnClickListener(this.P);
        this.m.setOnClickListener(this.P);
        this.n.setOnClickListener(this.P);
        this.r.setOnClickListener(this.P);
        this.s.setOnClickListener(this.P);
        this.p.setOnClickListener(this.P);
        this.q.setOnClickListener(this.P);
        this.f2081a.addTextChangedListener(this.aJ);
        this.f2081a.setOnTouchListener(this.aG);
        this.d.setOnKeyStateChangedListener(this.aI);
        this.f2081a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
    }

    public boolean b() {
        Editable text = this.f2081a.getText();
        if ((text == null || text.length() <= 0) && this.s.getTag() == null) {
            VoiceManager.VoiceModel voiceModel = this.ax.getVoiceModel();
            return (voiceModel == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
        }
        return true;
    }

    public RecordVoiceBnt c() {
        return this.ax;
    }

    public AudioIcon d() {
        return this.n;
    }

    public AudioIcon e() {
        return this.r;
    }

    public AudioIcon f() {
        if (this.E != null) {
            return this.E.c();
        }
        return null;
    }

    public RecordVoiceBnt g() {
        if (this.E != null) {
            return this.E.k();
        }
        return null;
    }

    public void h() {
        if (this.E != null) {
            this.E.b();
        }
    }

    public void i() {
        int i = R.drawable.new_pb_face_btn_1;
        ak();
        this.f2081a.requestFocus();
        this.M.setVisibility(8);
        this.p.setBackgroundResource(al() ? R.drawable.new_pb_face_btn_1 : R.drawable.new_pb_face_btn);
        ImageButton imageButton = this.m;
        if (!al()) {
            i = R.drawable.new_pb_face_btn;
        }
        imageButton.setBackgroundResource(i);
        if (this.ax.getVisibility() == 8) {
            UtilHelper.a(this.c, this.f2081a);
            this.n.e();
            this.r.e();
            this.U.postDelayed(this.aD, 200L);
            return;
        }
        this.f2081a.setSelection(this.f2081a.getText().length());
        this.n.f();
        this.r.f();
        this.ax.setVisibility(8);
        this.c.a(this.f2081a, 200);
    }

    public void j() {
        I();
        this.n.f();
        this.r.f();
        this.ax.setVisibility(8);
    }

    public void k() {
        int i = R.drawable.new_pb_face_btn_1;
        this.n.f();
        this.m.setBackgroundResource(al() ? R.drawable.new_pb_face_btn_1 : R.drawable.new_pb_face_btn);
        ImageButton imageButton = this.p;
        if (!al()) {
            i = R.drawable.new_pb_face_btn;
        }
        imageButton.setBackgroundResource(i);
        this.r.f();
        this.ax.setVisibility(8);
        this.M.setVisibility(8);
    }

    public void a(bn bnVar) {
        this.b = bnVar;
    }

    public void l() {
        if (this.at && this.c.getCurrentFocus() != null) {
            this.at = false;
            UtilHelper.a(this.c, this.c.getCurrentFocus());
        }
    }

    private void aj() {
        this.az = (LinearLayout) this.v.findViewById(R.id.btn_show_passed_pb);
        this.aA = new PbListView(this.c, PbListView.IconType.ICON_UP_WARD);
        View a2 = this.aA.a();
        this.aA.a(this.c.getResources().getString(R.string.btn_show_passed_pb));
        a2.setOnClickListener(this.aC);
        a2.setPadding(UtilHelper.a(a2.getContext(), 6.0f), UtilHelper.a(a2.getContext(), 6.0f), UtilHelper.a(a2.getContext(), 6.0f), UtilHelper.a(a2.getContext(), 2.0f));
        this.az.addView(a2);
        this.az.requestLayout();
        this.az.invalidate();
    }

    public void a(View view) {
        if (this.V == null) {
            this.V = new Dialog(this.c, R.style.common_alert_dialog);
            this.V.setCanceledOnTouchOutside(true);
            this.V.setCancelable(true);
            this.V.setContentView(this.c.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.V.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.c) * 0.9d);
            this.V.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.V.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.V.findViewById(R.id.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(R.id.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                button.setOnClickListener(new cy(this));
            }
            if ("".equals(sparseArray.get(R.id.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                button2.setOnClickListener(new cz(this));
            }
            this.V.show();
        }
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.X == null) {
            this.X = new Dialog(this.c, R.style.common_alert_dialog);
            this.X.setCanceledOnTouchOutside(true);
            this.X.setCancelable(true);
            this.Y = this.c.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.X.setContentView(this.Y);
            WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.c) * 0.9d);
            this.X.getWindow().setAttributes(attributes);
            this.Z = (Button) this.Y.findViewById(R.id.dialog_button_ok);
            this.Z.setOnClickListener(this.P);
            this.aa = (Button) this.Y.findViewById(R.id.dialog_button_cancel);
            this.aa.setOnClickListener(new da(this));
            this.ab = (TextView) this.Y.findViewById(R.id.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.Z.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.Z.setTag(sparseArray);
        }
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.ab.setText(R.string.del_thread_confirm);
        } else {
            this.ab.setText(R.string.del_post_confirm);
        }
        this.X.show();
    }

    public void a(String str, int i) {
        if (this.ac == null) {
            this.ac = new Dialog(this.c, R.style.common_alert_dialog);
            this.ac.setCanceledOnTouchOutside(true);
            this.ac.setCancelable(true);
            this.ad = this.c.getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.ac.setContentView(this.ad);
            WindowManager.LayoutParams attributes = this.ac.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.c) * 0.9d);
            this.ac.getWindow().setAttributes(attributes);
            this.af = (RadioGroup) this.ad.findViewById(R.id.radio_group);
            this.ag = (RadioButton) this.ad.findViewById(R.id.radio_button_1day);
            this.ah = (RadioButton) this.ad.findViewById(R.id.radio_button_3day);
            this.ai = (RadioButton) this.ad.findViewById(R.id.radio_button_10day);
            bv bvVar = new bv(this);
            this.ag.setOnCheckedChangeListener(bvVar);
            this.ah.setOnCheckedChangeListener(bvVar);
            this.ai.setOnCheckedChangeListener(bvVar);
            this.aj = (Button) this.ad.findViewById(R.id.dialog_button_ok);
            this.aj.setOnClickListener(this.P);
            this.ak = (Button) this.ad.findViewById(R.id.dialog_button_cancel);
            this.ak.setOnClickListener(new bw(this));
            this.al = (TextView) this.ad.findViewById(R.id.user_name);
        }
        this.al.setText(str);
        this.af.check(R.id.radio_button_1day);
        if (i == 2) {
            this.ah.setVisibility(8);
            this.ai.setVisibility(8);
        }
        this.aj.setTag(str);
        this.ac.show();
    }

    public void a(ArrayList<com.baidu.tieba.data.aa> arrayList) {
        if (this.am == null) {
            this.am = new Dialog(this.c, R.style.common_alert_dialog);
            this.am.setCanceledOnTouchOutside(true);
            this.am.setCancelable(true);
            this.an = this.c.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.am.setContentView(this.an);
            WindowManager.LayoutParams attributes = this.am.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.c) * 0.9d);
            this.am.getWindow().setAttributes(attributes);
            this.ap = new bx(this);
            this.ao = (RadioGroup) this.an.findViewById(R.id.good_class_group);
            this.ar = (Button) this.an.findViewById(R.id.dialog_button_cancel);
            this.ar.setOnClickListener(new by(this));
            this.aq = (Button) this.an.findViewById(R.id.dialog_button_ok);
            this.aq.setOnClickListener(this.P);
        }
        this.ao.removeAllViews();
        LayoutInflater layoutInflater = this.c.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag(SocialConstants.FALSE);
        radioButton.setText(this.c.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ap);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(UtilHelper.a((Context) this.c, 10.0f), UtilHelper.a((Context) this.c, 5.0f), UtilHelper.a((Context) this.c, 10.0f), UtilHelper.a((Context) this.c, 5.0f));
        this.ao.addView(radioButton, layoutParams);
        this.ao.requestLayout();
        this.ao.check(radioButton.getId());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.ap);
                this.ao.addView(radioButton2, layoutParams);
                this.ao.requestLayout();
                i = i2 + 1;
            } else {
                this.am.show();
                return;
            }
        }
    }

    public void m() {
        this.A.setVisibility(0);
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.A.setVisibility(8);
        if (z && z2) {
            this.c.a(this.c.getString(R.string.success));
        } else if (str != null && z2) {
            this.c.a(str);
        }
    }

    public View n() {
        if (this.Y != null) {
            return this.Y.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public View o() {
        if (this.ad != null) {
            return this.ad.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public int p() {
        return this.ae;
    }

    public View q() {
        if (this.an != null) {
            return this.an.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String r() {
        return this.as;
    }

    public View s() {
        if (this.E == null) {
            return null;
        }
        return this.E.h();
    }

    public View t() {
        if (this.E == null) {
            return null;
        }
        return this.E.j();
    }

    public View u() {
        if (this.E != null) {
            return this.E.s();
        }
        return null;
    }

    public View v() {
        if (this.E == null) {
            return null;
        }
        return this.E.i();
    }

    public void w() {
        if (this.E != null) {
            this.E.e();
            this.E.d();
        }
    }

    public void x() {
        this.A.setVisibility(0);
        UtilHelper.a(this.c, this.f2081a);
    }

    public void y() {
        this.A.setVisibility(0);
        if (this.E != null) {
            this.E.w();
        }
    }

    public void a(boolean z) {
        this.A.setVisibility(8);
        if (this.E != null) {
            this.E.x();
        }
        ac();
        if (z) {
            this.f2081a.setText("");
            this.l.setEnabled(false);
            this.n.h();
            this.r.h();
            this.ax.a();
            H();
            if (this.E != null) {
                this.E.p();
                this.E.c().h();
                this.E.k().a();
            }
        }
    }

    public void z() {
        this.J.c();
    }

    public void A() {
        this.A.setVisibility(8);
        this.J.d();
        this.aA.d();
        this.g.a();
    }

    public void B() {
        this.g.a();
        this.az.setVisibility(8);
    }

    public void a(String str) {
        this.t.setText(str + this.c.getString(R.string.bar));
    }

    public void b(boolean z) {
        if (!z) {
            N();
            j();
            ak();
            this.f2081a.requestFocus();
            this.c.a(this.f2081a, 200);
        } else if (this.E != null) {
            this.E.b((String) null);
        }
    }

    public void C() {
        if (this.E == null) {
            this.E = new dd(this.c, this.aF, this.P, this.W, this.Q);
            this.E.a(this.z.a());
            this.E.a(this.R);
            this.E.b(this.z.c());
            this.E.a(this.z.d());
            this.L = this.E.g();
            this.E.a(this.S);
            this.E.a(this.z.b());
        }
        this.L.setVisibility(0);
        this.E.v();
        this.d.addView(this.L);
    }

    public void a(db dbVar) {
        this.au = dbVar;
    }

    public void a(boolean z, com.baidu.tieba.data.bb bbVar, boolean z2, String str, View view, int i) {
        int i2;
        int i3;
        if (bbVar != null && view != null) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.c, "pb_tosubpb", "pbclick", 1);
            }
            if (this.E == null) {
                this.E = new dd(this.c, this.aF, this.P, this.W, this.Q);
                this.E.a(this.z.a());
                this.E.a(this.R);
                this.E.b(this.z.c());
                this.E.a(this.z.d());
                this.L = this.E.g();
                this.E.a(this.S);
                this.E.a(this.z.b());
            }
            this.E.a(this.z.e());
            this.E.a(bbVar, i);
            this.E.b(1);
            int height = this.e.getHeight();
            if (view == null) {
                i2 = 0;
                i3 = 0;
            } else {
                int top = view.getTop() + height;
                i2 = view.getBottom() + height;
                i3 = top;
            }
            if (!z) {
                this.E.m();
            }
            int height2 = (view.getHeight() + this.g.getDividerHeight()) - (this.d.getHeight() - UtilHelper.a((Context) this.c, 43.0f));
            if (view.findViewById(R.id.sub_pb_more) == null) {
            }
            if (height2 > 0) {
                i3 += height2;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0.0f);
            translateAnimation.setDuration(300L);
            this.L.setAnimation(translateAnimation);
            this.d.invalidate();
            this.d.buildDrawingCache();
            Bitmap drawingCache = this.d.getDrawingCache();
            Bitmap bitmap = null;
            Bitmap bitmap2 = null;
            if (drawingCache != null) {
                if (i2 > 0 && i2 < drawingCache.getHeight()) {
                    try {
                        bitmap = Bitmap.createBitmap(drawingCache, 0, i2, drawingCache.getWidth(), drawingCache.getHeight() - i2);
                    } catch (OutOfMemoryError e) {
                        bitmap = null;
                    }
                }
                if (i3 < height) {
                    i3 = height;
                }
                if (i3 > 0 && i3 < drawingCache.getHeight()) {
                    try {
                        bitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), i3);
                    } catch (OutOfMemoryError e2) {
                        bitmap2 = null;
                    }
                }
            }
            this.L.setVisibility(0);
            if (this.L.getParent() == this.d) {
                this.d.removeView(this.L);
            }
            this.d.addView(this.L);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.c);
                imageView.setImageBitmap(bitmap2);
                this.d.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i3);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new bz(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.c);
            imageView2.setImageBitmap(bitmap);
            this.d.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, i2, this.d.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new cb(this, imageView2));
            translateAnimation.setAnimationListener(new cd(this, bbVar, z, str));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.z.a(onLongClickListener);
        if (this.E != null) {
            this.E.a(onLongClickListener);
        }
    }

    public void D() {
        if (E()) {
            this.E.n();
        }
    }

    public boolean E() {
        return (this.L == null || this.L.getVisibility() == 8) ? false : true;
    }

    public void F() {
        if (this.L != null) {
            this.L.setVisibility(8);
            this.d.removeView(this.L);
            this.E.o();
        }
        ac();
    }

    public void G() {
        if (this.E != null) {
            this.E.y();
        }
    }

    public void a(com.baidu.tieba.data.bb bbVar, int i) {
        if (this.E != null) {
            this.E.y();
            this.E.a(this.z.e());
            this.E.a(bbVar, i);
        }
    }

    public void b(String str) {
        this.f2081a.getText().insert(this.f2081a.getSelectionStart(), "@" + str + " ");
    }

    public void c(String str) {
        if (this.E != null) {
            this.E.a(str);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.o.setImageBitmap(bitmap);
            this.o.setBackgroundDrawable(null);
            this.o.setTag(bitmap);
            this.s.setImageBitmap(bitmap);
            this.s.setTag(bitmap);
            this.s.setBackgroundDrawable(null);
            this.l.setEnabled(true);
        }
    }

    public void H() {
        int i = R.drawable.new_pb_camera_btn_1;
        this.o.setImageBitmap(null);
        this.o.setBackgroundResource(al() ? R.drawable.new_pb_camera_btn_1 : R.drawable.new_pb_camera_btn);
        this.o.setTag(null);
        this.s.setImageBitmap(null);
        ImageButton imageButton = this.s;
        if (!al()) {
            i = R.drawable.new_pb_camera_btn;
        }
        imageButton.setBackgroundResource(i);
        this.s.setTag(null);
    }

    public void I() {
        if (this.aF) {
            this.m.setVisibility(0);
        } else {
            this.n.setVisibility(0);
        }
        this.o.setVisibility(0);
        this.y.setVisibility(8);
    }

    public void J() {
        this.aF = true;
        this.n.b();
        this.r.b();
        this.m.setVisibility(0);
    }

    public void K() {
        this.aF = false;
        if (this.y.getVisibility() != 0) {
            this.n.c();
        }
        this.r.c();
        if (!this.ay) {
            this.n.d();
            this.ay = true;
        }
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.y.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean al() {
        return TiebaApplication.g().as() == 1;
    }

    public void L() {
        int i = R.drawable.new_pb_keyboard_btn_1;
        int i2 = R.drawable.new_pb_face_btn_1;
        ak();
        this.f2081a.requestFocus();
        this.ax.setVisibility(8);
        this.r.f();
        if (this.M.getVisibility() == 8) {
            this.m.setBackgroundResource(al() ? R.drawable.new_pb_keyboard_btn_1 : R.drawable.new_pb_keyboard_btn);
            ImageButton imageButton = this.p;
            if (!al()) {
                i = R.drawable.new_pb_keyboard_btn;
            }
            imageButton.setBackgroundResource(i);
            UtilHelper.a(this.c, this.f2081a);
            this.U.postDelayed(this.aE, 200L);
            return;
        }
        this.f2081a.setSelection(this.f2081a.getText().length());
        this.m.setBackgroundResource(al() ? R.drawable.new_pb_face_btn_1 : R.drawable.new_pb_face_btn);
        ImageButton imageButton2 = this.p;
        if (!al()) {
            i2 = R.drawable.new_pb_face_btn;
        }
        imageButton2.setBackgroundResource(i2);
        this.M.setVisibility(8);
        this.c.a(this.f2081a, 200);
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.av != null) {
            this.av.dismiss();
            this.av = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(R.string.operation);
        if (z2) {
            builder.setItems(new String[]{this.c.getString(R.string.copy)}, onClickListener);
        } else if (z) {
            builder.setItems(new String[]{this.c.getString(R.string.copy), this.c.getString(R.string.remove_mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.c.getString(R.string.copy), this.c.getString(R.string.mark)}, onClickListener);
        }
        this.av = builder.create();
        this.av.setCanceledOnTouchOutside(true);
        this.av.show();
    }

    public boolean M() {
        return this.M.getVisibility() == 0;
    }

    public void N() {
        int i = R.drawable.new_pb_face_btn_1;
        I();
        this.p.setBackgroundResource(al() ? R.drawable.new_pb_face_btn_1 : R.drawable.new_pb_face_btn);
        ImageButton imageButton = this.m;
        if (!al()) {
            i = R.drawable.new_pb_face_btn;
        }
        imageButton.setBackgroundResource(i);
        this.M.setVisibility(8);
    }

    public void O() {
        if (this.D == null) {
            an();
        }
        this.D.show();
    }

    public int P() {
        int firstVisiblePosition = this.g.getFirstVisiblePosition();
        int i = (this.g.getChildAt(0) == null || this.g.getChildAt(0).getBottom() >= this.g.getHeight()) ? firstVisiblePosition : firstVisiblePosition + 1;
        int c = (this.g.getAdapter() == null || !(this.g.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.g.getAdapter()).c();
        if (i > c) {
            return i - c;
        }
        return 0;
    }

    public void a(int i) {
        this.g.setSelection(i);
    }

    public int Q() {
        try {
            return Integer.parseInt(this.G.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String R() {
        return this.f2081a.getText().toString();
    }

    public String S() {
        if (this.E == null) {
            return null;
        }
        return this.E.t();
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.z.a(aoVar);
        this.z.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.data.ao aoVar, int i, int i2, boolean z) {
        this.aB = z;
        A();
        this.z.a(aoVar);
        this.z.notifyDataSetChanged();
        a(aoVar.b().getName());
        if (aoVar.e().f() == 0 && !z) {
            this.g.setNextPage(null);
        } else {
            this.g.setNextPage(this.J);
            this.aA.d();
        }
        if (aoVar.e().g() == 0 && z) {
            this.g.setPullRefresh(null);
            this.az.setVisibility(8);
        } else {
            this.g.setPullRefresh(this.I);
            if (this.I != null) {
                this.I.a(TiebaApplication.g().as());
            }
            this.az.setVisibility(0);
            this.aA.d();
        }
        if (z) {
            if (aoVar.e().f() == 0) {
                this.J.a(this.c.getResources().getString(R.string.no_more_to_load));
            } else {
                this.J.a(this.c.getResources().getString(R.string.load_more));
            }
            this.aA.a(this.c.getResources().getString(R.string.btn_show_passed_pb));
        } else {
            this.aA.a(this.c.getResources().getString(R.string.btn_show_passed_pb_aftre));
        }
        if (aoVar.c() != null && aoVar.c().g() != null && aoVar.c().g().getType() == 0) {
            this.j.setVisibility(4);
            this.j.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.g.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.g, -this.u.getHeight(), 0);
                return;
            case 3:
            case 5:
                this.g.setSelection(0);
                return;
            case 4:
            case 6:
                if (z) {
                    this.g.setSelection(0);
                    return;
                } else if (aoVar.d() != null) {
                    if (aoVar.e() != null && aoVar.e().g() != 0) {
                        this.g.setSelection(aoVar.d().size() + 1);
                        return;
                    } else {
                        this.g.setSelection(aoVar.d().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void c(boolean z) {
        this.aw = z;
        if (TiebaApplication.g().as() == 1) {
            if (z) {
                this.j.setImageResource(R.drawable.icon_floor_host_s_1);
            } else {
                this.j.setImageResource(R.drawable.icon_floor_host_n_1);
            }
        } else if (z) {
            this.j.setImageResource(R.drawable.icon_floor_host_s);
        } else {
            this.j.setImageResource(R.drawable.icon_floor_host_n);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.A.getVisibility() != 0) {
            if (this.B == null) {
                am();
            }
            this.B.show();
            this.B.setContentView(this.H);
            ((LinearLayout) this.H.findViewById(R.id.reverse_layout)).setOnClickListener(this.P);
            ((LinearLayout) this.H.findViewById(R.id.skip_layout)).setOnClickListener(this.P);
            ((LinearLayout) this.H.findViewById(R.id.share_layout)).setOnClickListener(this.P);
            ((LinearLayout) this.H.findViewById(R.id.mark_layout)).setOnClickListener(this.P);
            ImageView imageView = (ImageView) this.H.findViewById(R.id.reverse_image);
            ImageView imageView2 = (ImageView) this.H.findViewById(R.id.mark_image);
            if (!z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
            }
            if (z2) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(4);
            }
            int height = this.e.getHeight();
            WindowManager.LayoutParams attributes = this.B.getWindow().getAttributes();
            attributes.gravity = 53;
            attributes.x = 0;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = UtilHelper.a((Context) this.c, 134.0f);
            attributes.height = -2;
            this.B.getWindow().setAttributes(attributes);
        }
    }

    public void a(com.baidu.tieba.data.ao aoVar, boolean z) {
        if (aoVar != null) {
            TextView textView = (TextView) this.u.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.data.h.p());
            TextView textView2 = (TextView) this.u.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.u.findViewById(R.id.pb_list_header_reply);
            Button button = (Button) this.u.findViewById(R.id.pb_list_header_bar);
            button.setOnClickListener(this.P);
            if (aoVar.b() != null && aoVar.b().getName() != null) {
                String name = aoVar.b().getName();
                if (name.length() > 6) {
                    name = name.substring(0, 5) + this.c.getResources().getString(R.string.three_point);
                }
                button.setText(name + this.c.getResources().getString(R.string.bar));
            }
            aoVar.c().p();
            textView.setText(aoVar.c().o());
            if (aoVar.c().c() != 0) {
                textView3.setText(String.valueOf(aoVar.c().c()));
            } else {
                textView3.setVisibility(8);
            }
            this.u.setVisibility(0);
            ArrayList<com.baidu.tieba.data.as> d = aoVar.d();
            long j = -1;
            if (d.size() > 0) {
                com.baidu.tieba.data.as asVar = d.get(0);
                if (asVar.e() == 1) {
                    j = asVar.f();
                }
                com.baidu.tieba.data.as asVar2 = d.get(d.size() - 1);
                if (asVar2.e() == 1) {
                    j = asVar2.f();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.util.bc.a(j));
            }
            Button button2 = (Button) this.u.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (aoVar.j() == 1) {
                button2.setVisibility(0);
            } else {
                button2.setVisibility(8);
            }
            button2.setOnClickListener(new ch(this));
            Button button3 = (Button) this.u.findViewById(R.id.commit_top);
            button3.setOnClickListener(this.P);
            Button button4 = (Button) this.u.findViewById(R.id.cancel_top);
            button4.setOnClickListener(this.P);
            Button button5 = (Button) this.u.findViewById(R.id.commit_good);
            button5.setOnClickListener(this.P);
            Button button6 = (Button) this.u.findViewById(R.id.cancel_good);
            button6.setOnClickListener(this.P);
            if (aoVar.c().f() == 1) {
                button5.setVisibility(8);
                button6.setVisibility(0);
            } else {
                button5.setVisibility(0);
                button6.setVisibility(8);
            }
            if (aoVar.c().e() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
                return;
            }
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
    }

    private void c(int i) {
        TextView textView = (TextView) this.u.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.u.findViewById(R.id.pb_list_header_reply);
        Button button = (Button) this.u.findViewById(R.id.pb_list_header_bar);
        com.baidu.tieba.util.bb.d(this.e, i);
        com.baidu.tieba.util.bb.a(this.i, i);
        c(this.aw);
        this.z.notifyDataSetChanged();
        if (i == 1) {
            com.baidu.tieba.util.bb.e((View) this.l, (int) R.drawable.btn_post_dl_selector_1);
            this.l.setTextColor(this.c.getResources().getColorStateList(R.color.post_image_btn_color_1));
            this.d.setBackgroundResource(R.drawable.common_bg_1);
            com.baidu.tieba.util.bb.e((View) button, (int) R.drawable.pb_button_bar_drawable_1);
            button.setTextColor(this.c.getResources().getColorStateList(R.color.text_blue_white_color_1));
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_1, 0, 0, 0);
            return;
        }
        com.baidu.tieba.util.bb.e((View) this.l, (int) R.drawable.btn_post_dl_selector);
        this.l.setTextColor(this.c.getResources().getColorStateList(R.color.post_image_btn_color));
        this.d.setBackgroundResource(R.drawable.common_bg);
        com.baidu.tieba.util.bb.e((View) button, (int) R.drawable.pb_button_bar_drawable);
        button.setTextColor(this.c.getResources().getColorStateList(R.color.text_blue_white_color));
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment, 0, 0, 0);
    }

    private void d(int i) {
        try {
            Button button = (Button) this.u.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.manage_bottom_bar);
            Button button2 = (Button) this.u.findViewById(R.id.commit_top);
            Button button3 = (Button) this.u.findViewById(R.id.cancel_top);
            Button button4 = (Button) this.u.findViewById(R.id.commit_good);
            Button button5 = (Button) this.u.findViewById(R.id.cancel_good);
            this.u.findViewById(R.id.line2);
            if (i == 1) {
                com.baidu.tieba.util.bb.e((View) button, (int) R.drawable.common_image_btn_selector_1);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                button.setTextColor(this.c.getResources().getColorStateList(R.color.common_image_btn_color_1));
                button2.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button3.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button4.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button5.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
            } else {
                com.baidu.tieba.util.bb.e((View) button, (int) R.drawable.common_image_btn_selector);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                button.setTextColor(this.c.getResources().getColorStateList(R.color.common_image_btn_color));
                button2.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button3.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button4.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button5.setTextColor(this.c.getResources().getColorStateList(R.color.forum_manage_btn_color));
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    public View T() {
        return this.K;
    }

    public BdListView U() {
        return this.g;
    }

    public int V() {
        return R.id.richText;
    }

    public Button W() {
        return (Button) this.u.findViewById(R.id.commit_good);
    }

    public Button X() {
        return (Button) this.u.findViewById(R.id.cancel_good);
    }

    public Button Y() {
        return (Button) this.u.findViewById(R.id.commit_top);
    }

    public Button Z() {
        return (Button) this.u.findViewById(R.id.cancel_top);
    }

    public View aa() {
        if (this.E == null) {
            return null;
        }
        return this.E.q();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.g.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.g.setOnSrollToTopListener(sVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.O = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.I.a(bVar);
    }

    private void am() {
        this.B = new com.baidu.tieba.view.aw(this.c);
        this.H = this.c.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
        this.H.setOnTouchListener(new cj(this));
        this.B.setCanceledOnTouchOutside(true);
    }

    private void an() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(this.c.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.c.getResources().getString(R.string.take_photo), this.c.getResources().getString(R.string.album)}, this.O);
        this.D = builder.create();
        this.D.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.tieba.data.an anVar) {
        if (anVar != null) {
            int d = anVar.d();
            int a2 = anVar.a();
            if (this.C == null) {
                this.C = new Dialog(this.c, R.style.common_alert_dialog);
                this.C.setCanceledOnTouchOutside(true);
                this.C.setCancelable(true);
                this.F = this.c.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.C.setContentView(this.F);
                WindowManager.LayoutParams attributes = this.C.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = UtilHelper.a((Context) this.c, 54.0f);
                attributes.width = (int) (UtilHelper.a((Context) this.c) * 0.9d);
                this.C.getWindow().setAttributes(attributes);
                this.C.setOnKeyListener(new cl(this));
            }
            this.C.show();
            ((Button) this.F.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.P);
            ((Button) this.F.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.P);
            this.G = (EditText) this.F.findViewById(R.id.input_page_number);
            this.G.setText("");
            this.G.setOnFocusChangeListener(new cm(this));
            TextView textView = (TextView) this.F.findViewById(R.id.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.c.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(d), Integer.valueOf(a2 <= 0 ? 1 : a2)));
            this.c.a(this.G, 150);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.g.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.R = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.Q = onClickListener;
        this.z.a(onClickListener);
    }

    public void d(String str) {
        this.c.a(str);
    }

    public boolean d(boolean z) {
        if (this.E == null || !this.E.a()) {
            if (!z) {
                if (E()) {
                    F();
                    return true;
                } else if (this.M.getVisibility() == 0 || this.ax.getVisibility() == 0) {
                    this.M.setVisibility(8);
                    this.ax.setVisibility(8);
                    k();
                    I();
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void ab() {
        if (this.A != null) {
            this.A.setVisibility(8);
        }
        if (this.h != null && this.T != null) {
            this.h.b(this.T);
        }
        ac();
        this.J.d();
        ag();
    }

    public void ac() {
        N();
        j();
        I();
        UtilHelper.a(this.c, this.G);
        UtilHelper.a(this.c, this.f2081a);
        if (this.B != null) {
            this.B.dismiss();
        }
        if (this.C != null) {
            this.C.dismiss();
        }
        if (this.av != null) {
            this.av.dismiss();
        }
        if (this.E != null) {
            this.E.m();
        }
        ad();
    }

    public void e(boolean z) {
        this.z.a(z);
        if (this.E != null) {
            this.E.b(z);
        }
    }

    public void f(boolean z) {
        this.z.b(z);
        if (this.E != null) {
            this.E.a(z);
        }
    }

    public void ad() {
        if (this.X != null) {
            this.X.dismiss();
        }
        if (this.ac != null) {
            this.ac.dismiss();
        }
        if (this.am != null) {
            this.am.dismiss();
        }
        if (this.V != null) {
            this.V.dismiss();
        }
    }

    public void ae() {
        if (this.E != null) {
            this.E.r();
        }
    }

    public com.baidu.adp.widget.ImageView.e e(String str) {
        return this.z.a().a(str, this.aH);
    }

    public void af() {
        com.baidu.tieba.util.ab.a(this.g, this.z.a(), this.z.c() ? 0 : 1, 0);
    }

    public void ag() {
        try {
            this.z.a().b();
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public void b(int i) {
        this.c.m().a(i == 1);
        this.c.m().a(this.d);
        this.c.m().a(this.v);
        this.c.m().a(this.K);
        this.n.a(i);
        this.r.a(i);
        this.c.m().a(this.o);
        this.c.m().a(this.p);
        this.c.m().a(this.m);
        this.c.m().a(this.q);
        this.c.m().a(this.s);
        d(i);
        c(i);
        if (this.E != null) {
            this.E.c(i);
        }
        if (this.I != null) {
            this.I.a(i);
        }
        if (this.J != null) {
            this.J.a(i);
        }
        if (this.aA != null) {
            this.aA.a(i);
        }
        if (i == 1) {
            this.t.setShadowLayer(2.0f, 0.0f, 2.0f, -16777216);
        } else {
            this.t.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
        }
    }

    public boolean ah() {
        return this.at;
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.S = mVar;
        this.z.a(this.S);
        if (this.E != null) {
            this.E.a(this.S);
        }
    }

    public void a(com.baidu.tieba.view.az azVar) {
        this.T = azVar;
        if (this.h != null) {
            this.h.a(this.T);
        }
    }

    public void g(boolean z) {
        this.z.a().d(z);
    }

    public View ai() {
        if (this.E == null) {
            return null;
        }
        return this.E.z();
    }
}
