package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
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
import com.baidu.location.LocationClientOption;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.view.ClickableLayout;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bk {
    private com.baidu.tieba.view.ao D;
    private com.baidu.tieba.view.an E;
    private View F;
    private GridView H;
    private com.baidu.tieba.write.m I;
    private View.OnClickListener K;
    private Handler O;
    private View.OnClickListener Q;
    public EditText a;
    private com.baidu.tieba.g b;
    private KeyboardEventLayout c;
    private ClickableLayout d;
    private ClickableLayout4Frame e;
    private BdListView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private Button j;
    private Button k;
    private ImageButton l;
    private Button m;
    private Button n;
    private ImageButton o;
    private TextView p;
    private View q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private bg u;
    private ProgressBar v;
    private Dialog w = null;
    private Dialog x = null;
    private Dialog y = null;
    private cr z = null;
    private View A = null;
    private EditText B = null;
    private View C = null;
    private View G = null;
    private DialogInterface.OnClickListener J = null;
    private View.OnClickListener L = null;
    private AbsListView.OnScrollListener M = null;
    private com.baidu.tbadk.widget.richText.m N = null;
    private Dialog P = null;
    private Dialog R = null;
    private View S = null;
    private Button T = null;
    private Button U = null;
    private TextView V = null;
    private Dialog W = null;
    private View X = null;
    private int Y = 0;
    private RadioGroup Z = null;
    private RadioButton aa = null;
    private RadioButton ab = null;
    private RadioButton ac = null;
    private Button ad = null;
    private Button ae = null;
    private TextView af = null;
    private Dialog ag = null;
    private View ah = null;
    private RadioGroup ai = null;
    private CompoundButton.OnCheckedChangeListener aj = null;
    private Button ak = null;
    private Button al = null;
    private String am = null;
    private boolean an = false;
    private cq ao = null;
    private Dialog ap = null;
    private boolean aq = false;
    private Runnable ar = new bl(this);
    private View.OnTouchListener as = new by(this);
    private com.baidu.tbadk.a.d at = new cf(this);
    private com.baidu.tbadk.a.d au = new cg(this);
    private com.baidu.tieba.view.ae av = new ch(this);
    private TextWatcher aw = new cm(this);

    public bk(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
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
        this.a = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.K = null;
        this.O = null;
        this.Q = null;
        this.b = newPbActivity;
        this.K = onClickListener;
        this.O = new Handler();
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = (KeyboardEventLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.b.addContentView(this.c, new FrameLayout.LayoutParams(-2, -2));
        this.s = (LinearLayout) from.inflate(R.layout.reply_post, (ViewGroup) null);
        this.t = (LinearLayout) this.s.findViewById(R.id.extern);
        this.d = (ClickableLayout) this.b.findViewById(R.id.pb_title);
        this.d.setOnkeyUpListener(new cn(this));
        this.e = (ClickableLayout4Frame) this.b.findViewById(R.id.pb_center);
        this.e.setOnkeyUpListener(new co(this));
        this.f = (BdListView) this.b.findViewById(R.id.new_pb_list);
        this.g = (ImageView) this.b.findViewById(R.id.pb_title_back);
        this.p = (TextView) this.b.findViewById(R.id.pb_title_forum);
        this.i = (ImageView) this.b.findViewById(R.id.pb_title_more);
        this.h = (ImageView) this.b.findViewById(R.id.pb_title_host);
        this.i.setScaleType(ImageView.ScaleType.CENTER);
        this.h.setScaleType(ImageView.ScaleType.CENTER);
        this.v = (ProgressBar) this.b.findViewById(R.id.progress);
        this.r = (LinearLayout) this.b.findViewById(R.id.pb_reply);
        this.r.addView(this.s);
        this.j = (Button) this.s.findViewById(R.id.pb_reply_post);
        this.k = (Button) this.s.findViewById(R.id.pb_button_face);
        this.l = (ImageButton) this.s.findViewById(R.id.pb_button_camera);
        this.a = (EditText) this.s.findViewById(R.id.reply_content);
        this.m = (Button) this.t.findViewById(R.id.pb_button_face1);
        this.o = (ImageButton) this.t.findViewById(R.id.pb_button_camera1);
        this.n = (Button) this.t.findViewById(R.id.pb_button_at1);
        this.q = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.u = new bg(this.b);
        this.u.b(this.K);
        this.u.a(this.N);
        this.Q = new cp(this);
        this.u.c(this.Q);
        this.f.setAdapter((ListAdapter) this.u);
        this.f.addHeaderView(this.q);
        this.D = new com.baidu.tieba.view.ao(this.b);
        this.f.setPullRefresh(this.D);
        this.E = new com.baidu.tieba.view.an(this.b);
        this.F = this.E.b().findViewById(R.id.pb_more_view);
        if (this.F != null) {
            this.F.setOnClickListener(this.K);
        }
        this.H = (GridView) this.b.findViewById(R.id.face_view);
        this.I = new com.baidu.tieba.write.m(this.b);
        this.H.setAdapter((ListAdapter) this.I);
        this.H.setOnItemClickListener(new bm(this));
        this.g.setOnClickListener(this.K);
        this.p.setOnClickListener(this.K);
        this.i.setOnClickListener(this.K);
        this.h.setOnClickListener(this.K);
        this.j.setOnClickListener(this.K);
        this.l.setOnClickListener(this.K);
        this.k.setOnClickListener(this.K);
        this.o.setOnClickListener(this.K);
        this.m.setOnClickListener(this.K);
        this.n.setOnClickListener(this.K);
        this.a.addTextChangedListener(this.aw);
        this.a.setOnTouchListener(this.as);
        this.c.setOnKeyStateChangedListener(this.av);
        this.a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
    }

    public void a() {
        if (this.an && this.b.getCurrentFocus() != null) {
            this.an = false;
            com.baidu.tieba.util.ab.a(this.b, this.b.getCurrentFocus());
        }
    }

    public void a(View view) {
        if (this.P == null) {
            this.P = new Dialog(this.b, R.style.common_alert_dialog);
            this.P.setCanceledOnTouchOutside(true);
            this.P.setCancelable(true);
            this.P.setContentView(this.b.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.P.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.util.ab.a((Context) this.b) * 0.9d);
            this.P.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.P.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.P.findViewById(R.id.forbid_user_btn);
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
                button.setOnClickListener(new bn(this));
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
                button2.setOnClickListener(new bo(this));
            }
            this.P.show();
        }
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.R == null) {
            this.R = new Dialog(this.b, R.style.common_alert_dialog);
            this.R.setCanceledOnTouchOutside(true);
            this.R.setCancelable(true);
            this.S = this.b.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.R.setContentView(this.S);
            WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.util.ab.a((Context) this.b) * 0.9d);
            this.R.getWindow().setAttributes(attributes);
            this.T = (Button) this.S.findViewById(R.id.dialog_button_ok);
            this.T.setOnClickListener(this.K);
            this.U = (Button) this.S.findViewById(R.id.dialog_button_cancel);
            this.U.setOnClickListener(new bp(this));
            this.V = (TextView) this.S.findViewById(R.id.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.T.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.T.setTag(sparseArray);
        }
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.V.setText(R.string.del_thread_confirm);
        } else {
            this.V.setText(R.string.del_post_confirm);
        }
        this.R.show();
    }

    public void a(String str, int i) {
        if (this.W == null) {
            this.W = new Dialog(this.b, R.style.common_alert_dialog);
            this.W.setCanceledOnTouchOutside(true);
            this.W.setCancelable(true);
            this.X = this.b.getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.W.setContentView(this.X);
            WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.util.ab.a((Context) this.b) * 0.9d);
            this.W.getWindow().setAttributes(attributes);
            this.Z = (RadioGroup) this.X.findViewById(R.id.radio_group);
            this.aa = (RadioButton) this.X.findViewById(R.id.radio_button_1day);
            this.ab = (RadioButton) this.X.findViewById(R.id.radio_button_3day);
            this.ac = (RadioButton) this.X.findViewById(R.id.radio_button_10day);
            bq bqVar = new bq(this);
            this.aa.setOnCheckedChangeListener(bqVar);
            this.ab.setOnCheckedChangeListener(bqVar);
            this.ac.setOnCheckedChangeListener(bqVar);
            this.ad = (Button) this.X.findViewById(R.id.dialog_button_ok);
            this.ad.setOnClickListener(this.K);
            this.ae = (Button) this.X.findViewById(R.id.dialog_button_cancel);
            this.ae.setOnClickListener(new br(this));
            this.af = (TextView) this.X.findViewById(R.id.user_name);
        }
        this.af.setText(str);
        this.Z.check(R.id.radio_button_1day);
        if (i == 2) {
            this.ab.setVisibility(8);
            this.ac.setVisibility(8);
        }
        this.ad.setTag(str);
        this.W.show();
    }

    public void a(ArrayList arrayList) {
        if (this.ag == null) {
            this.ag = new Dialog(this.b, R.style.common_alert_dialog);
            this.ag.setCanceledOnTouchOutside(true);
            this.ag.setCancelable(true);
            this.ah = this.b.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.ag.setContentView(this.ah);
            WindowManager.LayoutParams attributes = this.ag.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.util.ab.a((Context) this.b) * 0.9d);
            this.ag.getWindow().setAttributes(attributes);
            this.aj = new bs(this);
            this.ai = (RadioGroup) this.ah.findViewById(R.id.good_class_group);
            this.al = (Button) this.ah.findViewById(R.id.dialog_button_cancel);
            this.al.setOnClickListener(new bt(this));
            this.ak = (Button) this.ah.findViewById(R.id.dialog_button_ok);
            this.ak.setOnClickListener(this.K);
        }
        this.ai.removeAllViews();
        LayoutInflater layoutInflater = this.b.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag("0");
        radioButton.setText(this.b.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.aj);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.tieba.util.ab.a(this.b, 10.0f), com.baidu.tieba.util.ab.a(this.b, 5.0f), com.baidu.tieba.util.ab.a(this.b, 10.0f), com.baidu.tieba.util.ab.a(this.b, 5.0f));
        this.ai.addView(radioButton, layoutParams);
        this.ai.requestLayout();
        this.ai.check(radioButton.getId());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(((com.baidu.tieba.data.u) arrayList.get(i2)).b()));
                radioButton2.setText(((com.baidu.tieba.data.u) arrayList.get(i2)).a());
                radioButton2.setOnCheckedChangeListener(this.aj);
                this.ai.addView(radioButton2, layoutParams);
                this.ai.requestLayout();
                i = i2 + 1;
            } else {
                this.ag.show();
                return;
            }
        }
    }

    public void b() {
        this.v.setVisibility(0);
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.v.setVisibility(8);
        if (z && z2) {
            this.b.a(this.b.getString(R.string.success));
        } else if (str != null && z2) {
            this.b.a(str);
        }
    }

    public View c() {
        if (this.S != null) {
            return this.S.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public View d() {
        if (this.X != null) {
            return this.X.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public int e() {
        return this.Y;
    }

    public View f() {
        if (this.ah != null) {
            return this.ah.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String g() {
        return this.am;
    }

    public View h() {
        if (this.z == null) {
            return null;
        }
        return this.z.e();
    }

    public View i() {
        if (this.z == null) {
            return null;
        }
        return this.z.g();
    }

    public View j() {
        if (this.z != null) {
            return this.z.n();
        }
        return null;
    }

    public View k() {
        if (this.z == null) {
            return null;
        }
        return this.z.f();
    }

    public void l() {
        if (this.z != null) {
            this.z.b();
        }
    }

    public void m() {
        this.v.setVisibility(0);
        com.baidu.tieba.util.ab.a(this.b, this.a);
    }

    public void n() {
        this.v.setVisibility(0);
    }

    public void a(boolean z) {
        this.v.setVisibility(8);
        O();
        if (z) {
            this.a.setText("");
            this.j.setEnabled(false);
            w();
            if (this.z != null) {
                this.z.k();
            }
        }
    }

    public void o() {
        this.E.c();
    }

    public void p() {
        this.v.setVisibility(8);
        this.E.d();
        this.f.a();
    }

    public void q() {
        this.f.a();
    }

    public void a(String str) {
        this.p.setText(String.valueOf(str) + this.b.getString(R.string.bar));
    }

    public void b(boolean z) {
        if (!z) {
            z();
            V();
            this.a.requestFocus();
            this.b.a(this.a, 200);
        } else if (this.z != null) {
            this.z.b((String) null);
        }
    }

    public void r() {
        if (this.z == null) {
            this.z = new cr(this.b, this.K, this.Q, this.L);
            this.z.a(this.u.a());
            this.z.a(this.M);
            this.z.b(this.u.c());
            this.z.a(this.u.d());
            this.G = this.z.d();
            this.z.a(this.N);
            this.z.a(this.u.b());
        }
        this.G.setVisibility(0);
        this.z.p();
        this.c.addView(this.G);
    }

    public void a(cq cqVar) {
        this.ao = cqVar;
    }

    public void a(boolean z, com.baidu.tieba.data.aw awVar, boolean z2, String str, View view, int i) {
        int i2;
        int i3;
        if (awVar != null && view != null) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this.b, "pb_tosubpb", "pbclick", 1);
            }
            if (this.z == null) {
                this.z = new cr(this.b, this.K, this.Q, this.L);
                this.z.a(this.u.a());
                this.z.a(this.M);
                this.z.b(this.u.c());
                this.z.a(this.u.d());
                this.G = this.z.d();
                this.z.a(this.N);
                this.z.a(this.u.b());
            }
            this.z.a(this.u.e());
            this.z.a(awVar, i);
            this.z.b(1);
            int height = this.d.getHeight();
            if (view == null) {
                i2 = 0;
                i3 = 0;
            } else {
                int top = view.getTop() + height;
                i2 = view.getBottom() + height;
                i3 = top;
            }
            if (!z) {
                this.z.h();
            }
            int height2 = (view.getHeight() + this.f.getDividerHeight()) - (this.c.getHeight() - com.baidu.tieba.util.ab.a(this.b, 43.0f));
            view.findViewById(R.id.sub_pb_more);
            if (height2 > 0) {
                i3 += height2;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0.0f);
            translateAnimation.setDuration(300L);
            this.G.setAnimation(translateAnimation);
            this.c.invalidate();
            this.c.buildDrawingCache();
            Bitmap drawingCache = this.c.getDrawingCache();
            Bitmap bitmap = null;
            Bitmap bitmap2 = null;
            if (drawingCache != null) {
                if (i2 > 0 && i2 < drawingCache.getHeight()) {
                    bitmap = Bitmap.createBitmap(drawingCache, 0, i2, drawingCache.getWidth(), drawingCache.getHeight() - i2);
                }
                if (i3 < height) {
                    i3 = height;
                }
                if (i3 > 0 && i3 < drawingCache.getHeight()) {
                    bitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), i3);
                }
            }
            this.G.setVisibility(0);
            if (this.G.getParent() == this.c) {
                this.c.removeView(this.G);
            }
            this.c.addView(this.G);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.b);
                imageView.setImageBitmap(bitmap2);
                this.c.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i3);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new bu(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.b);
            imageView2.setImageBitmap(bitmap);
            this.c.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, i2, this.c.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new bw(this, imageView2));
            translateAnimation.setAnimationListener(new bz(this, awVar, z, str));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.u.a(onLongClickListener);
        if (this.z != null) {
            this.z.a(onLongClickListener);
        }
    }

    public void s() {
        if (t()) {
            this.z.i();
        }
    }

    public boolean t() {
        return (this.G == null || this.G.getVisibility() == 8) ? false : true;
    }

    public void u() {
        if (this.G != null) {
            this.G.setVisibility(8);
            this.c.removeView(this.G);
            this.z.j();
        }
        O();
    }

    public void v() {
        if (this.z != null) {
            this.z.q();
        }
    }

    public void a(com.baidu.tieba.data.aw awVar, int i) {
        if (this.z != null) {
            this.z.q();
            this.z.a(this.u.e());
            this.z.a(awVar, i);
        }
    }

    public void b(String str) {
        this.a.getText().insert(this.a.getSelectionStart(), "@" + str + " ");
    }

    public void c(String str) {
        if (this.z != null) {
            this.z.a(str);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.l.setImageBitmap(bitmap);
            this.l.setTag(bitmap);
            this.o.setImageBitmap(bitmap);
            this.o.setTag(bitmap);
            this.j.setEnabled(true);
        }
    }

    public void w() {
        this.l.setImageBitmap(null);
        this.l.setTag(null);
        this.o.setImageBitmap(null);
        this.o.setTag(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.t.setVisibility(0);
    }

    public void x() {
        V();
        this.a.requestFocus();
        if (this.H.getVisibility() == 8) {
            this.k.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            this.m.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            com.baidu.tieba.util.ab.a(this.b, this.a);
            this.O.postDelayed(this.ar, 200L);
            return;
        }
        this.a.setSelection(this.a.getText().length());
        this.k.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.H.setVisibility(8);
        this.b.a(this.a, 200);
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z) {
        if (this.ap != null) {
            this.ap.dismiss();
            this.ap = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(R.string.operation);
        if (!z) {
            builder.setItems(new String[]{this.b.getString(R.string.copy), this.b.getString(R.string.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.b.getString(R.string.copy), this.b.getString(R.string.remove_mark)}, onClickListener);
        }
        this.ap = builder.create();
        this.ap.setCanceledOnTouchOutside(true);
        this.ap.show();
    }

    public boolean y() {
        return this.H.getVisibility() == 0;
    }

    public void z() {
        U();
        this.k.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.H.setVisibility(8);
    }

    public void A() {
        if (this.y == null) {
            X();
        }
        this.y.show();
    }

    public int B() {
        int firstVisiblePosition = this.f.getFirstVisiblePosition();
        int i = (this.f.getChildAt(0) == null || this.f.getChildAt(0).getBottom() >= this.f.getHeight()) ? firstVisiblePosition : firstVisiblePosition + 1;
        int c = (this.f.getAdapter() == null || !(this.f.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.f.getAdapter()).c();
        if (i > c) {
            return i - c;
        }
        return 0;
    }

    public void a(int i) {
        this.f.setSelection(i);
    }

    public int C() {
        try {
            return Integer.parseInt(this.B.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String D() {
        return this.a.getText().toString();
    }

    public String E() {
        if (this.z == null) {
            return null;
        }
        return this.z.o();
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        this.u.a(ajVar);
        this.u.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.data.aj ajVar, int i, int i2, boolean z) {
        p();
        this.u.a(ajVar);
        this.u.notifyDataSetChanged();
        a(ajVar.a().b());
        if (ajVar.e().f() == 0 && !z) {
            this.f.setNextPage(null);
        } else {
            this.f.setNextPage(this.E);
        }
        if (ajVar.e().g() == 0 && z) {
            this.f.setPullRefresh(null);
        } else {
            this.f.setPullRefresh(this.D);
        }
        if (z) {
            if (ajVar.e().f() == 0) {
                this.E.a(this.b.getResources().getString(R.string.no_more_to_load));
            } else {
                this.E.a(this.b.getResources().getString(R.string.load_more));
            }
        }
        if (ajVar.b() != null && ajVar.b().g() != null && ajVar.b().g().getType() == 0) {
            this.h.setVisibility(4);
            this.h.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.f.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.f, -this.q.getHeight(), 0);
                return;
            case 3:
            case 5:
                this.f.setSelection(0);
                return;
            case 4:
            case 6:
                if (z) {
                    this.f.setSelection(0);
                    return;
                } else if (ajVar.d() != null) {
                    if (ajVar.e() != null && ajVar.e().g() != 0) {
                        this.f.setSelection(ajVar.d().size() + 1);
                        return;
                    } else {
                        this.f.setSelection(ajVar.d().size());
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
        this.aq = z;
        if (TiebaApplication.f().at() == 1) {
            if (z) {
                this.h.setImageResource(R.drawable.icon_floor_host_s_1);
            } else {
                this.h.setImageResource(R.drawable.icon_floor_host_n_1);
            }
        } else if (z) {
            this.h.setImageResource(R.drawable.icon_floor_host_s);
        } else {
            this.h.setImageResource(R.drawable.icon_floor_host_n);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.w == null) {
            W();
        }
        this.w.show();
        this.w.setContentView(this.C);
        ((LinearLayout) this.C.findViewById(R.id.reverse_layout)).setOnClickListener(this.K);
        ((LinearLayout) this.C.findViewById(R.id.skip_layout)).setOnClickListener(this.K);
        ((LinearLayout) this.C.findViewById(R.id.share_layout)).setOnClickListener(this.K);
        ((LinearLayout) this.C.findViewById(R.id.mark_layout)).setOnClickListener(this.K);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.reverse_image);
        ImageView imageView2 = (ImageView) this.C.findViewById(R.id.mark_image);
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
        int height = this.d.getHeight();
        WindowManager.LayoutParams attributes = this.w.getWindow().getAttributes();
        attributes.gravity = 53;
        attributes.x = 0;
        attributes.y = height;
        attributes.alpha = 1.0f;
        attributes.width = com.baidu.tieba.util.ab.a(this.b, 134.0f);
        attributes.height = -2;
        this.w.getWindow().setAttributes(attributes);
    }

    public void a(com.baidu.tieba.data.aj ajVar, boolean z) {
        if (ajVar != null) {
            TextView textView = (TextView) this.q.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.data.g.o());
            TextView textView2 = (TextView) this.q.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.q.findViewById(R.id.pb_list_header_reply);
            Button button = (Button) this.q.findViewById(R.id.pb_list_header_bar);
            button.setOnClickListener(this.K);
            if (ajVar.a() != null && ajVar.a().b() != null) {
                String b = ajVar.a().b();
                if (b.length() > 6) {
                    b = String.valueOf(b.substring(0, 5)) + this.b.getResources().getString(R.string.three_point);
                }
                button.setText(String.valueOf(b) + this.b.getResources().getString(R.string.bar));
            }
            ajVar.b().o();
            textView.setText(ajVar.b().n());
            if (ajVar.b().c() != 0) {
                textView3.setText(String.valueOf(ajVar.b().c()));
            } else {
                textView3.setVisibility(8);
            }
            this.q.setVisibility(0);
            ArrayList d = ajVar.d();
            long j = -1;
            if (d.size() > 0) {
                com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) d.get(0);
                if (anVar.f() == 1) {
                    j = anVar.g();
                }
                com.baidu.tieba.data.an anVar2 = (com.baidu.tieba.data.an) d.get(d.size() - 1);
                if (anVar2.f() == 1) {
                    j = anVar2.g();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.util.y.a(j));
            }
            Button button2 = (Button) this.q.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (ajVar.l() == 1) {
                button2.setVisibility(0);
            } else {
                button2.setVisibility(8);
            }
            button2.setOnClickListener(new cb(this));
            Button button3 = (Button) this.q.findViewById(R.id.commit_top);
            button3.setOnClickListener(this.K);
            Button button4 = (Button) this.q.findViewById(R.id.cancel_top);
            button4.setOnClickListener(this.K);
            Button button5 = (Button) this.q.findViewById(R.id.commit_good);
            button5.setOnClickListener(this.K);
            Button button6 = (Button) this.q.findViewById(R.id.cancel_good);
            button6.setOnClickListener(this.K);
            if (ajVar.b().f() == 1) {
                button5.setVisibility(8);
                button6.setVisibility(0);
            } else {
                button5.setVisibility(0);
                button6.setVisibility(8);
            }
            if (ajVar.b().e() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
                return;
            }
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
    }

    private void c(int i) {
        TextView textView = (TextView) this.q.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.q.findViewById(R.id.pb_list_header_reply);
        Button button = (Button) this.q.findViewById(R.id.pb_list_header_bar);
        com.baidu.tieba.util.x.c((TextView) this.q.findViewById(R.id.pb_header_title), i);
        com.baidu.tieba.util.x.d(textView, i);
        com.baidu.tieba.util.x.d(textView2, i);
        com.baidu.tieba.util.x.d(this.d, i);
        com.baidu.tieba.util.x.a(this.g, i);
        this.D.a(i);
        c(this.aq);
        this.u.notifyDataSetChanged();
        if (i == 1) {
            this.k.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.l.setBackgroundResource(R.drawable.new_pb_camera_btn_1);
            this.m.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.o.setBackgroundResource(R.drawable.new_pb_camera_btn_1);
            this.n.setBackgroundResource(R.drawable.new_pb_at_btn_1);
            this.q.setBackgroundResource(R.drawable.bg_topbar_1);
            com.baidu.tieba.util.x.h((View) this.j, (int) R.drawable.btn_post_dl_selector_1);
            this.j.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color_1));
            this.c.setBackgroundResource(R.drawable.common_bg_1);
            this.h.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.i.setBackgroundResource(R.drawable.title_icon_bg_1);
            com.baidu.tieba.util.x.h((View) button, (int) R.drawable.pb_button_bar_drawable_1);
            button.setTextColor(this.b.getResources().getColorStateList(R.color.text_blue_white_color_1));
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_1, 0, 0, 0);
            com.baidu.tieba.util.x.h(this.F, (int) R.drawable.bg_list_all_1);
            return;
        }
        this.k.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.l.setBackgroundResource(R.drawable.new_pb_camera_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.o.setBackgroundResource(R.drawable.new_pb_camera_btn);
        this.n.setBackgroundResource(R.drawable.new_pb_at_btn);
        this.q.setBackgroundResource(R.drawable.bg_topbar);
        com.baidu.tieba.util.x.h((View) this.j, (int) R.drawable.btn_post_dl_selector);
        this.j.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color));
        this.c.setBackgroundResource(R.drawable.common_bg);
        this.h.setBackgroundResource(R.drawable.title_icon_bg);
        this.i.setBackgroundResource(R.drawable.title_icon_bg);
        com.baidu.tieba.util.x.h((View) button, (int) R.drawable.pb_button_bar_drawable);
        button.setTextColor(this.b.getResources().getColorStateList(R.color.text_blue_white_color));
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment, 0, 0, 0);
        com.baidu.tieba.util.x.h(this.F, (int) R.drawable.bg_list_all);
    }

    private void d(int i) {
        try {
            Button button = (Button) this.q.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.manage_bottom_bar);
            Button button2 = (Button) this.q.findViewById(R.id.commit_top);
            Button button3 = (Button) this.q.findViewById(R.id.cancel_top);
            Button button4 = (Button) this.q.findViewById(R.id.commit_good);
            Button button5 = (Button) this.q.findViewById(R.id.cancel_good);
            View findViewById = this.q.findViewById(R.id.line2);
            if (i == 1) {
                linearLayout.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg_1);
                com.baidu.tieba.util.x.h((View) button, (int) R.drawable.common_image_btn_selector_1);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                button.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
                button2.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button3.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button4.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button5.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button2.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                button3.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                button4.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                button5.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                findViewById.setBackgroundColor(-14144716);
            } else {
                linearLayout.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg);
                com.baidu.tieba.util.x.h((View) button, (int) R.drawable.common_image_btn_selector);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                button.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
                button2.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button3.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button4.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button5.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button2.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                button3.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                button4.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                button5.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                findViewById.setBackgroundColor(-2696478);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    public View F() {
        return this.F;
    }

    public BdListView G() {
        return this.f;
    }

    public int H() {
        return R.id.richText;
    }

    public Button I() {
        return (Button) this.q.findViewById(R.id.commit_good);
    }

    public Button J() {
        return (Button) this.q.findViewById(R.id.cancel_good);
    }

    public Button K() {
        return (Button) this.q.findViewById(R.id.commit_top);
    }

    public Button L() {
        return (Button) this.q.findViewById(R.id.cancel_top);
    }

    public View M() {
        if (this.z == null) {
            return null;
        }
        return this.z.l();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.f.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.f.setOnSrollToTopListener(sVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.J = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.D.a(bVar);
    }

    private void W() {
        this.w = new com.baidu.tieba.view.am(this.b);
        this.C = this.b.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
        this.C.setOnTouchListener(new cc(this));
        this.w.setCanceledOnTouchOutside(true);
    }

    private void X() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(this.b.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.b.getResources().getString(R.string.take_photo), this.b.getResources().getString(R.string.album)}, this.J);
        this.y = builder.create();
        this.y.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.tieba.data.ai aiVar) {
        if (aiVar != null) {
            int d = aiVar.d();
            int a = aiVar.a();
            if (this.x == null) {
                this.x = new Dialog(this.b, R.style.common_alert_dialog);
                this.x.setCanceledOnTouchOutside(true);
                this.x.setCancelable(true);
                this.A = this.b.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.x.setContentView(this.A);
                WindowManager.LayoutParams attributes = this.x.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.tieba.util.ab.a(this.b, 54.0f);
                attributes.width = (int) (com.baidu.tieba.util.ab.a((Context) this.b) * 0.9d);
                this.x.getWindow().setAttributes(attributes);
                this.x.setOnKeyListener(new cd(this));
            }
            this.x.show();
            ((Button) this.A.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.K);
            ((Button) this.A.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.K);
            this.B = (EditText) this.A.findViewById(R.id.input_page_number);
            this.B.setText("");
            this.B.setOnFocusChangeListener(new ce(this));
            TextView textView = (TextView) this.A.findViewById(R.id.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.b.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(d), Integer.valueOf(a <= 0 ? 1 : a)));
            this.b.a(this.B, WebChromeClient.STRING_DLG_BTN_SET);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.f.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.M = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.L = onClickListener;
        this.u.a(onClickListener);
    }

    public void d(String str) {
        this.b.a(str);
    }

    public boolean d(boolean z) {
        if (this.z == null || !this.z.a()) {
            if (!z) {
                if (t()) {
                    u();
                    return true;
                } else if (this.H.getVisibility() == 0) {
                    this.H.setVisibility(8);
                    U();
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void N() {
        if (this.v != null) {
            this.v.setVisibility(8);
        }
        O();
        this.E.d();
        S();
    }

    public void O() {
        z();
        U();
        com.baidu.tieba.util.ab.a(this.b, this.B);
        com.baidu.tieba.util.ab.a(this.b, this.a);
        if (this.w != null) {
            this.w.dismiss();
        }
        if (this.x != null) {
            this.x.dismiss();
        }
        if (this.ap != null) {
            this.ap.dismiss();
        }
        if (this.z != null) {
            this.z.h();
        }
        P();
    }

    public void e(boolean z) {
        this.u.a(z);
        if (this.z != null) {
            this.z.b(z);
        }
    }

    public void f(boolean z) {
        this.u.b(z);
        if (this.z != null) {
            this.z.a(z);
        }
    }

    public void P() {
        if (this.R != null) {
            this.R.dismiss();
        }
        if (this.W != null) {
            this.W.dismiss();
        }
        if (this.ag != null) {
            this.ag.dismiss();
        }
        if (this.P != null) {
            this.P.dismiss();
        }
    }

    public void Q() {
        if (this.z != null) {
            this.z.m();
        }
    }

    public com.baidu.adp.widget.a.b e(String str) {
        return this.u.a().a(str, this.at);
    }

    public void R() {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            int c = ((com.baidu.adp.widget.ListView.e) this.f.getAdapter()).c();
            int firstVisiblePosition = this.f.getFirstVisiblePosition() - c;
            int lastVisiblePosition = this.f.getLastVisiblePosition() - c;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            NetWorkCore.NetworkStateInfo c2 = NetWorkCore.c(this.b);
            this.u.a().a();
            boolean z = c2 == NetWorkCore.NetworkStateInfo.WIFI || c2 == NetWorkCore.NetworkStateInfo.ThreeG;
            this.u.a().a(z);
            int i5 = firstVisiblePosition;
            int i6 = 0;
            int i7 = 0;
            while (i5 < this.u.getCount()) {
                if (z || i5 <= lastVisiblePosition) {
                    com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) this.u.getItem(i5);
                    if (anVar != null) {
                        ArrayList a = anVar.i().a();
                        int size = a.size();
                        if (!this.u.c() || i7 >= 13) {
                            i3 = i7;
                        } else {
                            int i8 = 0;
                            int i9 = i7;
                            while (true) {
                                if (i8 >= size) {
                                    i3 = i9;
                                    break;
                                }
                                if (((com.baidu.tbadk.widget.richText.c) a.get(i8)).a() == 8) {
                                    if (i9 >= 13) {
                                        i3 = i9;
                                        break;
                                    } else {
                                        i9++;
                                        this.u.a().a(((com.baidu.tbadk.widget.richText.c) a.get(i8)).c().d(), this.at);
                                    }
                                }
                                i8++;
                                i9 = i9;
                            }
                        }
                        String portrait = anVar.h().getPortrait();
                        if (!this.u.d() || portrait == null || portrait.length() <= 0 || i6 >= 30) {
                            i4 = i6;
                        } else {
                            i4 = i6 + 1;
                            this.u.a().d(portrait, this.au);
                        }
                        int i10 = 0;
                        while (true) {
                            i = i4;
                            if (i10 >= anVar.a().size()) {
                                break;
                            }
                            String portrait2 = ((com.baidu.tieba.data.an) anVar.a().get(i10)).h().getPortrait();
                            if (!this.u.d() || portrait2 == null || portrait2.length() <= 0 || i >= 30) {
                                i4 = i;
                            } else {
                                i4 = i + 1;
                                this.u.a().d(portrait2, this.au);
                            }
                            i10++;
                        }
                        if (z && i3 >= 13 && i >= 30) {
                            return;
                        }
                        i2 = i3;
                    } else {
                        i = i6;
                        i2 = i7;
                    }
                    i5++;
                    i6 = i;
                    i7 = i2;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public void S() {
        try {
            this.u.a().b();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public void b(int i) {
        d(i);
        c(i);
        if (this.z != null) {
            this.z.c(i);
        }
        if (i == 1) {
            this.p.setTextColor(-5524539);
            this.p.setShadowLayer(2.0f, 0.0f, 2.0f, -16777216);
            return;
        }
        this.p.setTextColor(-1);
        this.p.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
    }

    public boolean T() {
        return this.an;
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.N = mVar;
        this.u.a(this.N);
        if (this.z != null) {
            this.z.a(this.N);
        }
    }
}
