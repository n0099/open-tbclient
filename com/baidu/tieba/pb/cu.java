package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.img.WriteImagesInfo;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class cu {
    private View.OnClickListener C;
    private View.OnClickListener L;
    NavigationBar a;
    private View an;
    private View ao;
    private View ap;
    private com.baidu.tieba.editortool.aa ar;
    private LinearLayout as;
    private PbListView at;
    private cb aw;
    ImageView b;
    TextView c;
    ImageView d;
    ImageView e;
    public PbEditor f;
    cc g;
    private NewPbActivity h;
    private FrameLayout i;
    private BdListView j;
    private NoNetworkView k;
    private View l;
    private View m;
    private RelativeLayout n;
    private cd o;
    private com.baidu.tieba.view.ct w;
    private PbListView x;
    private View y;
    private Dialog p = null;
    private Dialog q = null;
    private Dialog r = null;
    private ed s = null;
    private View t = null;
    private EditText u = null;
    private View v = null;
    private FrameLayout z = null;
    private View A = null;
    private DialogInterface.OnClickListener B = null;
    private View.OnClickListener D = null;
    private View.OnClickListener E = null;
    private View.OnClickListener F = null;
    private AbsListView.OnScrollListener G = null;
    private com.baidu.tbadk.widget.richText.r H = null;
    private com.baidu.tbadk.widget.richText.q I = null;
    private com.baidu.tieba.view.by J = null;
    private Dialog K = null;
    private Dialog M = null;
    private View N = null;
    private Button O = null;
    private Button P = null;
    private TextView Q = null;
    private Dialog R = null;
    private View S = null;
    private int T = 0;
    private RadioGroup U = null;
    private RadioButton V = null;
    private RadioButton W = null;
    private RadioButton X = null;
    private Button Y = null;
    private Button Z = null;
    private TextView aa = null;
    private Dialog ab = null;
    private View ac = null;
    private RadioGroup ad = null;
    private CompoundButton.OnCheckedChangeListener ae = null;
    private Button af = null;
    private Button ag = null;
    private String ah = null;
    private boolean ai = false;
    private dy aj = null;
    private Dialog ak = null;
    private boolean al = false;
    private Button aq = null;
    private boolean au = false;
    private View.OnClickListener av = new cv(this);
    private boolean ax = false;
    private List<com.baidu.tieba.view.cb> ay = new ArrayList();
    private com.baidu.tbadk.imageManager.d az = new de(this);
    private com.baidu.tbadk.imageManager.d aA = new dr(this);
    private com.baidu.tbadk.imageManager.d aB = new ds(this);
    private com.baidu.tieba.g.a am = new com.baidu.tieba.g.a(new dt(this));

    public final NoNetworkView a() {
        return this.k;
    }

    public cu(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
        this.h = null;
        this.i = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.C = null;
        this.L = null;
        this.an = null;
        this.ao = null;
        this.ap = null;
        this.as = null;
        this.at = null;
        this.h = newPbActivity;
        this.C = onClickListener;
        LayoutInflater from = LayoutInflater.from(this.h);
        this.i = (FrameLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.h.addContentView(this.i, new FrameLayout.LayoutParams(-1, -1));
        this.n = (RelativeLayout) this.h.findViewById(R.id.title_wrapper);
        this.k = (NoNetworkView) this.h.findViewById(R.id.view_no_network);
        this.j = (BdListView) this.h.findViewById(R.id.new_pb_list);
        View view = new View(this.h);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.h.getResources().getDimensionPixelSize(R.dimen.navi_height)));
        this.j.addHeaderView(view);
        View view2 = new View(this.h);
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.h.getResources().getDimensionPixelSize(R.dimen.pb_editor_height)));
        this.j.addFooterView(view2);
        this.a = (NavigationBar) this.h.findViewById(R.id.view_navigation_bar);
        this.a.setOnClickListener(new du(this));
        this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.C);
        this.c = this.a.a("");
        this.d = (ImageView) this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_host, this.C);
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.MORE_BUTTON, this.C);
        this.f = (PbEditor) this.h.findViewById(R.id.pb_editor_view);
        this.f.setFrom(1);
        this.f.a(false);
        C();
        this.m = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.l = (LinearLayout) this.m.findViewById(R.id.pb_header_container);
        this.an = this.l.findViewById(R.id.pb_header_divider);
        this.m.setOnTouchListener(this.am);
        this.m.setOnLongClickListener(new dv(this));
        this.as = (LinearLayout) this.m.findViewById(R.id.btn_show_passed_pb);
        this.at = new PbListView(this.h, PbListView.IconType.ICON_UP_WARD);
        View a = this.at.a();
        this.at.a(this.h.getResources().getString(R.string.btn_show_passed_pb));
        this.at.b(this.h.getResources().getDimensionPixelSize(R.dimen.pb_header_long_button_height));
        a.setOnClickListener(this.av);
        this.as.addView(a);
        this.as.requestLayout();
        this.as.invalidate();
        this.at.a(TiebaApplication.g().ae() == 1 ? R.drawable.button_load_next_1 : R.drawable.button_load_next);
        Z();
        this.o = new cd(this.h);
        this.o.d(this.C);
        this.o.a(this.am);
        this.o.a(this.H);
        this.L = new dw(this);
        this.o.e(this.L);
        this.j.setAdapter((ListAdapter) this.o);
        this.j.addHeaderView(this.m);
        this.w = new com.baidu.tieba.view.ct(this.h);
        this.w.a();
        this.x = new PbListView(this.h);
        this.y = this.x.b().findViewById(R.id.pb_more_view);
        if (this.y != null) {
            this.y.setOnClickListener(this.C);
        }
        this.c.setOnClickListener(this.C);
        this.ao = this.m.findViewById(R.id.border_top);
        this.ap = this.m.findViewById(R.id.border_bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(cu cuVar, boolean z) {
        if (cuVar.j != null) {
            if (z) {
                cuVar.j.postDelayed(new dx(cuVar, z), 10L);
            } else {
                cuVar.j.setEnabled(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(cu cuVar, View view) {
        com.baidu.adp.lib.util.e.e("PbView", "showHideToolbar", "toggle");
        if (cuVar.n == null || cuVar.f == null || view == null) {
            return;
        }
        if (!(cuVar.n.getVisibility() == 0 || cuVar.f.getVisibility() == 0)) {
            Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.top_fold_down);
            loadAnimation.setAnimationListener(new cy(cuVar));
            cuVar.n.startAnimation(loadAnimation);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.bottom_fold_up);
            loadAnimation2.setAnimationListener(new cz(cuVar));
            cuVar.f.startAnimation(loadAnimation2);
            return;
        }
        Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), R.anim.top_fold_up);
        loadAnimation3.setAnimationListener(new cw(cuVar));
        cuVar.n.startAnimation(loadAnimation3);
        cuVar.f.f();
        Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), R.anim.bottom_fold_down);
        loadAnimation4.setAnimationListener(new cx(cuVar));
        cuVar.f.startAnimation(loadAnimation4);
    }

    public final void b() {
        if (this.s != null) {
            this.s.j();
        }
    }

    public final void c() {
        if (this.s != null) {
            this.s.k();
        }
    }

    public final VoiceManager.VoiceModel d() {
        if (this.s != null) {
            return this.s.m();
        }
        return null;
    }

    public final void e() {
        if (this.s != null) {
            this.s.n();
        }
    }

    public final TextView f() {
        if (this.s == null || !(this.s instanceof ea)) {
            return null;
        }
        return ((ea) this.s).c();
    }

    public final cd g() {
        return this.o;
    }

    public final void h() {
        if (this.ai && this.h.getCurrentFocus() != null) {
            this.ai = false;
            BdUtilHelper.a(this.h, this.h.getCurrentFocus());
        }
    }

    public final void a(View view) {
        if (this.K == null) {
            this.K = new Dialog(this.h, R.style.common_alert_dialog);
            this.K.setCanceledOnTouchOutside(true);
            this.K.setCancelable(true);
            this.K.setContentView(this.h.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
            attributes.width = (int) (BdUtilHelper.b(this.h) * 0.9d);
            this.K.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.K.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.K.findViewById(R.id.forbid_user_btn);
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
                button.setOnClickListener(new da(this));
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
                button2.setOnClickListener(new db(this));
            }
            this.K.show();
        }
    }

    public final void a(cb cbVar) {
        this.aw = cbVar;
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.M == null) {
            this.M = new Dialog(this.h, R.style.common_alert_dialog);
            this.M.setCanceledOnTouchOutside(true);
            this.M.setCancelable(true);
            this.N = this.h.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.M.setContentView(this.N);
            WindowManager.LayoutParams attributes = this.M.getWindow().getAttributes();
            attributes.width = (int) (BdUtilHelper.b(this.h) * 0.9d);
            this.M.getWindow().setAttributes(attributes);
            this.O = (Button) this.N.findViewById(R.id.dialog_button_ok);
            this.O.setOnClickListener(this.C);
            this.P = (Button) this.N.findViewById(R.id.dialog_button_cancel);
            this.P.setOnClickListener(new dc(this));
            this.Q = (TextView) this.N.findViewById(R.id.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.O.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.O.setTag(sparseArray);
        }
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.Q.setText(R.string.del_thread_confirm);
        } else {
            this.Q.setText(R.string.del_post_confirm);
        }
        this.M.show();
    }

    public final void a(ArrayList<com.baidu.tieba.data.z> arrayList) {
        if (this.ab == null) {
            this.ab = new Dialog(this.h, R.style.common_alert_dialog);
            this.ab.setCanceledOnTouchOutside(true);
            this.ab.setCancelable(true);
            this.ac = this.h.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.ab.setContentView(this.ac);
            WindowManager.LayoutParams attributes = this.ab.getWindow().getAttributes();
            attributes.width = (int) (BdUtilHelper.b(this.h) * 0.9d);
            this.ab.getWindow().setAttributes(attributes);
            this.ae = new dd(this);
            this.ad = (RadioGroup) this.ac.findViewById(R.id.good_class_group);
            this.ag = (Button) this.ac.findViewById(R.id.dialog_button_cancel);
            this.ag.setOnClickListener(new df(this));
            this.af = (Button) this.ac.findViewById(R.id.dialog_button_ok);
            this.af.setOnClickListener(this.C);
        }
        this.ad.removeAllViews();
        LayoutInflater layoutInflater = this.h.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag(SocialConstants.FALSE);
        radioButton.setText(this.h.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ae);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(BdUtilHelper.a((Context) this.h, 10.0f), BdUtilHelper.a((Context) this.h, 5.0f), BdUtilHelper.a((Context) this.h, 10.0f), BdUtilHelper.a((Context) this.h, 5.0f));
        this.ad.addView(radioButton, layoutParams);
        this.ad.requestLayout();
        this.ad.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.ae);
                this.ad.addView(radioButton2, layoutParams);
                this.ad.requestLayout();
                i = i2 + 1;
            }
        }
        this.ab.show();
    }

    public final void i() {
        this.h.showProgressBar();
    }

    public final void a(boolean z, String str, boolean z2) {
        this.h.hideProgressBar();
        if (z && z2) {
            this.h.showToast(this.h.getString(R.string.success));
        } else if (str != null && z2) {
            this.h.showToast(str);
        }
    }

    public final void j() {
        this.i.removeView(this.z);
    }

    public final View k() {
        if (this.N != null) {
            return this.N.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public final View l() {
        if (this.ac != null) {
            return this.ac.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public final String m() {
        return this.ah;
    }

    public final View n() {
        if (this.s != null) {
            return this.s.v();
        }
        return null;
    }

    public final void o() {
        this.h.showProgressBar();
        BdUtilHelper.a(this.h, this.f.getEditText());
    }

    public final void p() {
        if (this.s != null) {
            this.s.y();
        } else {
            this.h.showProgressBar();
        }
    }

    public final void a(boolean z) {
        if (this.s != null) {
            this.s.z();
        } else {
            this.h.hideProgressBar();
        }
        R();
        if (z) {
            this.f.getEditText().setText("");
            this.f.b();
            this.f.k();
            if (this.s != null) {
                this.s.s();
            }
        }
    }

    public final void q() {
        this.x.c();
    }

    public final void r() {
        this.h.hideProgressBar();
        this.x.d();
        this.at.d();
        this.j.a();
        Z();
    }

    public final void s() {
        this.j.a();
        this.as.setVisibility(8);
        Z();
    }

    public final void b(boolean z) {
        if (!z) {
            this.f.d();
        } else if (this.s != null) {
            this.s.b((String) null);
        }
    }

    public final void t() {
        if (x() && this.s != null) {
            this.s.i();
        }
    }

    public final void u() {
        if (this.s == null) {
            NewPbActivity newPbActivity = this.h;
            boolean z = this.ax;
            this.s = new ed(newPbActivity, this.C, this.L, this.D, this.E, this.F);
            this.s.a(this.ar);
            this.s.a(this.o.a());
            this.s.a(this.G);
            this.s.c(this.o.c());
            this.s.b(this.o.d());
            this.A = this.s.l();
            this.s.a(this.H);
            this.s.a(this.I);
            this.s.a(this.o.b());
        }
        this.A.setVisibility(0);
        this.s.x();
        this.i.addView(this.A);
        aa();
    }

    public final void a(com.baidu.tieba.editortool.aa aaVar) {
        if (aaVar != null) {
            this.f.setOnActionListener(new dg(this, aaVar));
            this.ar = aaVar;
            if (this.s != null) {
                this.s.a(aaVar);
            }
        }
    }

    public final void a(dy dyVar) {
        this.aj = dyVar;
    }

    public final void a(boolean z, com.baidu.tieba.data.av avVar, String str, String str2, View view, int i) {
        Bitmap bitmap;
        int i2;
        Bitmap bitmap2;
        if (avVar != null && view != null) {
            com.baidu.tieba.util.cb.a(this.h, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.s == null) {
                NewPbActivity newPbActivity = this.h;
                boolean z2 = this.ax;
                this.s = new ed(newPbActivity, this.C, this.L, this.D, this.E, this.F);
                this.s.a(this.ar);
                this.s.a(this.o.a());
                this.s.a(this.G);
                this.s.c(this.o.c());
                this.s.b(this.o.d());
                this.A = this.s.l();
                this.s.a(this.H);
                this.s.a(this.I);
                this.s.a(this.o.b());
            }
            this.s.b(this.o.e());
            this.s.a(avVar, i);
            if (str2 != null && !str2.equals("")) {
                this.s.c(str2);
            } else {
                this.s.c(1);
            }
            int i3 = 0;
            if (this.n.getVisibility() == 0) {
                i3 = this.n.getHeight();
            }
            int top = view.getTop();
            int bottom = view.getBottom();
            if (!z) {
                this.s.o();
            }
            int height = ((view.getHeight() + this.h.getResources().getDimensionPixelSize(R.dimen.subpb_listitem_packup_min_height)) - this.h.getResources().getDimensionPixelSize(R.dimen.pb_list_item_border_bottom_margin_top)) - this.i.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.A.setAnimation(translateAnimation);
            this.i.invalidate();
            this.i.buildDrawingCache();
            Bitmap drawingCache = this.i.getDrawingCache();
            Bitmap bitmap3 = null;
            if (drawingCache == null) {
                bitmap = null;
                i2 = top;
                bitmap2 = null;
            } else {
                if (bottom > 0 && bottom < drawingCache.getHeight()) {
                    try {
                        bitmap3 = Bitmap.createBitmap(drawingCache, 0, bottom, drawingCache.getWidth(), drawingCache.getHeight() - bottom);
                    } catch (OutOfMemoryError e) {
                        bitmap3 = null;
                    }
                }
                if (top < i3) {
                    top = i3;
                }
                if (top <= 0 || top >= drawingCache.getHeight()) {
                    bitmap = null;
                    i2 = top;
                    bitmap2 = bitmap3;
                } else {
                    try {
                        bitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), top);
                        i2 = top;
                        bitmap2 = bitmap3;
                    } catch (OutOfMemoryError e2) {
                        bitmap = null;
                        i2 = top;
                        bitmap2 = bitmap3;
                    }
                }
            }
            this.A.setVisibility(0);
            if (this.A.getParent() == this.i) {
                this.i.removeView(this.A);
            }
            this.i.addView(this.A);
            if (bitmap != null) {
                ImageView imageView = new ImageView(this.h);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 48));
                imageView.setImageBitmap(bitmap);
                this.i.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i2);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new dh(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.h);
            imageView2.setImageBitmap(bitmap2);
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            this.i.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap2 == null ? 0 : bitmap2.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new dj(this, imageView2));
            translateAnimation.setAnimationListener(new dl(this, avVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.o.a(onLongClickListener);
        if (this.s != null) {
            this.s.a(onLongClickListener);
        }
    }

    public final void v() {
        if (x()) {
            this.s.p();
        }
    }

    public final void w() {
        if (x() && (this.s instanceof ea)) {
            ((ea) this.s).d();
        }
    }

    public final boolean x() {
        return (this.A == null || this.A.getVisibility() == 8) ? false : true;
    }

    public final void y() {
        if (this.A != null) {
            this.A.setVisibility(8);
            this.i.removeView(this.A);
            this.s.q();
        }
        R();
        if (this.a != null) {
            this.a.setVisibility(0);
        }
        if (this.j != null) {
            this.j.setVisibility(0);
        }
        if (this.f != null) {
            this.f.setVisibility(this.n != null ? this.n.getVisibility() : 0);
        }
    }

    public final void z() {
        if (this.s != null) {
            this.s.A();
            if (this.s instanceof ea) {
                ((ea) this.s).e();
            }
        }
    }

    public final void a(com.baidu.tieba.data.av avVar, int i) {
        if (this.s != null) {
            this.s.A();
            this.s.b(this.o.e());
            this.s.a(avVar, i);
        }
    }

    public final void A() {
        if (this.s == null) {
            this.s = new ea(this.h, this.ax, this.C, this.L, this.D, this.E, this.F);
            this.s.a(this.ar);
            this.s.a(this.o.a());
            this.s.a(this.G);
            this.s.c(this.o.c());
            this.s.b(this.o.d());
            this.A = this.s.l();
            this.s.a(this.H);
            this.s.a(this.I);
            this.s.a(this.o.b());
        }
        this.A.setVisibility(0);
        this.s.x();
        this.i.addView(this.A);
        aa();
    }

    public final void a(com.baidu.tieba.data.av avVar, int i, String str, boolean z, boolean z2) {
        if (this.s != null && (this.s instanceof ea)) {
            ea eaVar = (ea) this.s;
            this.s.A();
            this.s.b(this.o.e());
            this.s.a(avVar, i);
            if (z2) {
                eaVar.a(str);
            }
            if (!z) {
                eaVar.f();
            } else {
                eaVar.g();
            }
        }
    }

    public final void b(ArrayList<String> arrayList) {
        if (this.s != null) {
            this.s.a(arrayList);
        }
    }

    public final void B() {
        this.ax = true;
        this.f.o();
    }

    public final void C() {
        this.ax = false;
        this.f.p();
    }

    public final void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.ak != null) {
            this.ak.dismiss();
            this.ak = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setTitle(R.string.operation);
        if (z2) {
            builder.setItems(new String[]{this.h.getString(R.string.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.h.getString(R.string.copy), this.h.getString(R.string.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.h.getString(R.string.copy), this.h.getString(R.string.remove_mark)}, onClickListener);
        }
        this.ak = builder.create();
        this.ak.setCanceledOnTouchOutside(true);
        this.ak.show();
    }

    public final void c(boolean z) {
        this.f.setAudioFocusable(z);
    }

    public final void d(boolean z) {
        if (this.s != null) {
            this.s.a(z);
        }
    }

    public final int D() {
        int firstVisiblePosition = this.j.getFirstVisiblePosition();
        int i = (this.j.getChildAt(0) == null || this.j.getChildAt(0).getBottom() >= this.j.getHeight()) ? firstVisiblePosition : firstVisiblePosition + 1;
        int c = (this.j.getAdapter() == null || !(this.j.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.j.getAdapter()).c();
        if (i > c) {
            return i - c;
        }
        return 0;
    }

    public final int E() {
        try {
            return Integer.parseInt(this.u.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public final String F() {
        if (this.s == null) {
            return null;
        }
        return this.s.w();
    }

    public final String G() {
        if (this.s != null) {
            return this.s.r();
        }
        return null;
    }

    public final void a(com.baidu.tieba.data.am amVar) {
        this.o.a(amVar);
        this.o.notifyDataSetChanged();
        Z();
        if (this.s != null) {
            this.s.d(amVar.i());
        }
    }

    public final void a(com.baidu.tieba.data.am amVar, int i, int i2, boolean z, int i3) {
        cs csVar;
        cs csVar2;
        this.ao.setVisibility(0);
        this.ap.setVisibility(0);
        this.au = z;
        r();
        this.o.a(amVar);
        this.o.notifyDataSetChanged();
        this.c.setText(String.valueOf(amVar.c().getName()) + this.h.getString(R.string.bar));
        if (amVar.f().f() == 0 && !z) {
            this.j.setNextPage(null);
        } else {
            this.j.setNextPage(this.x);
            this.at.d();
        }
        if (amVar.f().g() == 0 && z) {
            this.j.setPullRefresh(null);
            this.as.setVisibility(8);
        } else {
            this.j.setPullRefresh(this.w);
            if (this.w != null) {
                this.w.a(TiebaApplication.g().ae());
            }
            this.as.setVisibility(0);
            this.at.d();
        }
        Z();
        if (z) {
            if (amVar.f().f() == 0) {
                this.x.a(this.h.getResources().getString(R.string.no_more_to_load));
            } else {
                this.x.a(this.h.getResources().getString(R.string.pb_load_more));
            }
            this.at.a(this.h.getResources().getString(R.string.btn_show_passed_pb));
        } else {
            this.at.a(this.h.getResources().getString(R.string.btn_show_passed_pb_aftre));
        }
        if (amVar.d() != null && amVar.d().i() != null && amVar.d().i().getType() == 0) {
            this.d.setVisibility(4);
            this.d.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.j.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.j, -this.l.getHeight(), 0);
                return;
            case 3:
                if (i3 == 1) {
                    csVar2 = ct.a;
                    Parcelable c = csVar2.c();
                    if (c != null) {
                        this.j.onRestoreInstanceState(c);
                        return;
                    }
                }
                this.j.setSelection(0);
                return;
            case 4:
                if (z) {
                    this.j.setSelection(0);
                    return;
                } else if (amVar.e() != null) {
                    if (amVar.f() != null && amVar.f().g() != 0) {
                        this.j.setSelection(amVar.e().size() + 1);
                        return;
                    } else {
                        this.j.setSelection(amVar.e().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.j.setSelection(0);
                return;
            case 6:
                if (i3 == 1) {
                    csVar = ct.a;
                    Parcelable c2 = csVar.c();
                    if (c2 != null) {
                        this.j.onRestoreInstanceState(c2);
                        return;
                    }
                }
                if (z) {
                    this.j.setSelection(0);
                    return;
                } else if (amVar.e() != null) {
                    if (amVar.f() != null && amVar.f().g() != 0) {
                        this.j.setSelection(amVar.e().size() + 1);
                        return;
                    } else {
                        this.j.setSelection(amVar.e().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void e(boolean z) {
        this.al = z;
        if (TiebaApplication.g().ae() == 1) {
            if (z) {
                this.d.setImageResource(R.drawable.icon_floor_host_s_1);
            } else {
                this.d.setImageResource(R.drawable.icon_floor_host_n_1);
            }
        } else if (z) {
            this.d.setImageResource(R.drawable.icon_floor_host_s);
        } else {
            this.d.setImageResource(R.drawable.icon_floor_host_n);
        }
    }

    public final void H() {
        if (this.x != null) {
            this.x.d();
        }
        if (this.at != null) {
            this.at.d();
        }
    }

    public final void a(boolean z, boolean z2) {
        if (!this.h.isProgressBarShown()) {
            if (this.p == null) {
                this.p = new com.baidu.tieba.view.bw(this.h);
                this.v = this.h.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
                this.v.setOnTouchListener(new Cdo(this));
                this.p.setCanceledOnTouchOutside(true);
            }
            this.p.show();
            this.p.setContentView(this.v);
            TextView textView = (TextView) this.v.findViewById(R.id.reverse_txt);
            TextView textView2 = (TextView) this.v.findViewById(R.id.skip_txt);
            TextView textView3 = (TextView) this.v.findViewById(R.id.share_txt);
            TextView textView4 = (TextView) this.v.findViewById(R.id.mark_txt);
            textView.setOnClickListener(this.C);
            textView2.setOnClickListener(this.C);
            textView4.setOnClickListener(this.C);
            boolean a = com.baidu.tieba.widget.share.g.a(this.h);
            if (a) {
                textView3.setOnClickListener(this.C);
            } else {
                textView3.setVisibility(8);
            }
            int ae = TiebaApplication.g().ae();
            this.h.getLayoutMode().a(ae == 1);
            this.h.getLayoutMode().a(this.v);
            if (ae == 1) {
                textView4.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color_1));
                textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_n_1, 0, 0);
                if (a) {
                    textView3.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color_1));
                    textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_share_n_1, 0, 0);
                }
                textView2.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color_1));
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_jump_n_1, 0, 0);
                textView.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color_1));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_n_1, 0, 0);
                if (!z) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_s_1, 0, 0);
                }
                if (z2) {
                    textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_s_1, 0, 0);
                }
            } else {
                textView4.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color));
                textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_n, 0, 0);
                if (a) {
                    textView3.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color));
                    textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_share_n, 0, 0);
                }
                textView2.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color));
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_jump_n, 0, 0);
                textView.setTextColor(this.h.getResources().getColor(R.color.pb_more_txt_color));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_n, 0, 0);
                if (!z) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_s, 0, 0);
                }
                if (z2) {
                    textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_s, 0, 0);
                }
            }
            int height = this.a.getHeight();
            WindowManager.LayoutParams attributes = this.p.getWindow().getAttributes();
            attributes.gravity = 53;
            attributes.x = 0;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = -1;
            attributes.height = -2;
            this.p.getWindow().setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        View findViewById = this.h.findViewById(R.id.manage_bottom_bar);
        View findViewById2 = this.h.findViewById(R.id.go_to_live_post);
        View findViewById3 = this.h.findViewById(R.id.btn_show_passed_pb);
        if ((findViewById != null && findViewById.getVisibility() == 0) || ((findViewById2 != null && findViewById2.getVisibility() == 0) || (findViewById3 != null && findViewById3.getVisibility() == 0))) {
            this.an.setVisibility(0);
        } else {
            this.an.setVisibility(8);
        }
    }

    public final void a(com.baidu.tieba.data.am amVar, boolean z) {
        com.baidu.tieba.data.bc h;
        if (amVar != null) {
            TextView textView = (TextView) this.l.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.data.i.C());
            TextView textView2 = (TextView) this.l.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.l.findViewById(R.id.pb_list_header_reply);
            TextView textView4 = (TextView) this.l.findViewById(R.id.pb_list_header_bar);
            textView4.setOnClickListener(this.C);
            if (amVar.c() != null && amVar.c().getName() != null) {
                String name = amVar.c().getName();
                if (name.length() > 6) {
                    name = String.valueOf(name.substring(0, 5)) + this.h.getResources().getString(R.string.three_point);
                }
                textView4.setText(String.valueOf(name) + this.h.getResources().getString(R.string.bar));
            }
            amVar.d().q();
            textView.setText(amVar.d().p());
            if (amVar.d().d() != 0) {
                textView3.setText(String.valueOf(amVar.d().d()));
            } else {
                textView3.setVisibility(8);
            }
            this.l.setVisibility(0);
            ArrayList<com.baidu.tieba.data.aq> e = amVar.e();
            long j = -1;
            if (e.size() > 0) {
                com.baidu.tieba.data.aq aqVar = e.get(0);
                if (aqVar.e() == 1) {
                    j = aqVar.f();
                }
                com.baidu.tieba.data.aq aqVar2 = e.get(e.size() - 1);
                if (aqVar2.e() == 1) {
                    j = aqVar2.f();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.util.bs.a(j));
            }
            this.aq = (Button) this.l.findViewById(R.id.go_to_live_post);
            com.baidu.tieba.data.az d = amVar.d();
            if (d != null && (h = d.h()) != null && h.a() != 0) {
                int b = h.b();
                String string = this.h.getString(R.string.go_to_live_post_prefix);
                if (b == 0) {
                    string = String.valueOf(string) + this.h.getString(R.string.go_to_interview_post);
                } else if (b == 1) {
                    string = String.valueOf(string) + this.h.getString(R.string.go_to_discuss_post);
                }
                this.aq.setText(string);
                this.aq.setVisibility(0);
                this.aq.setOnClickListener(this.C);
                Z();
            }
            Button button = (Button) this.l.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.l.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (amVar.l() == 1) {
                button.setVisibility(0);
            } else {
                button.setVisibility(8);
            }
            button.setOnClickListener(new dn(this));
            Button button2 = (Button) this.l.findViewById(R.id.commit_top);
            button2.setOnClickListener(this.C);
            Button button3 = (Button) this.l.findViewById(R.id.cancel_top);
            button3.setOnClickListener(this.C);
            Button button4 = (Button) this.l.findViewById(R.id.commit_good);
            button4.setOnClickListener(this.C);
            Button button5 = (Button) this.l.findViewById(R.id.cancel_good);
            button5.setOnClickListener(this.C);
            if (amVar.d().g() == 1) {
                button4.setVisibility(8);
                button5.setVisibility(0);
            } else {
                button4.setVisibility(0);
                button5.setVisibility(8);
            }
            if (amVar.d().f() == 1) {
                button2.setVisibility(8);
                button3.setVisibility(0);
            } else {
                button2.setVisibility(0);
                button3.setVisibility(8);
            }
            Z();
        }
    }

    public final View I() {
        return this.y;
    }

    public final BdListView J() {
        return this.j;
    }

    public final Button K() {
        return (Button) this.l.findViewById(R.id.commit_good);
    }

    public final Button L() {
        return (Button) this.l.findViewById(R.id.cancel_good);
    }

    public final Button M() {
        return (Button) this.l.findViewById(R.id.commit_top);
    }

    public final Button N() {
        return (Button) this.l.findViewById(R.id.cancel_top);
    }

    public final View O() {
        if (this.s == null) {
            return null;
        }
        return this.s.t();
    }

    public final void a(com.baidu.adp.widget.ListView.r rVar) {
        this.j.setOnSrollToBottomListener(rVar);
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.j.setOnSrollToTopListener(tVar);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.B = onClickListener;
    }

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.w.a(bVar);
    }

    public final void a(com.baidu.tieba.data.al alVar) {
        if (alVar != null) {
            int d = alVar.d();
            int a = alVar.a();
            if (this.q == null) {
                this.q = new Dialog(this.h, R.style.common_alert_dialog);
                this.q.setCanceledOnTouchOutside(true);
                this.q.setCancelable(true);
                this.t = this.h.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.q.setContentView(this.t);
                WindowManager.LayoutParams attributes = this.q.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = BdUtilHelper.a((Context) this.h, 54.0f);
                attributes.width = (int) (BdUtilHelper.b(this.h) * 0.9d);
                this.q.getWindow().setAttributes(attributes);
                this.q.setOnKeyListener(new dp(this));
            }
            this.q.show();
            ((Button) this.t.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.C);
            ((Button) this.t.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.C);
            this.u = (EditText) this.t.findViewById(R.id.input_page_number);
            this.u.setText("");
            this.u.setOnFocusChangeListener(new dq(this));
            TextView textView = (TextView) this.t.findViewById(R.id.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.h.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(d), Integer.valueOf(a <= 0 ? 1 : a)));
            this.h.ShowSoftKeyPadDelay(this.u, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    public final void a(AbsListView.OnScrollListener onScrollListener) {
        this.j.setOnScrollListener(onScrollListener);
    }

    public final void b(AbsListView.OnScrollListener onScrollListener) {
        this.G = onScrollListener;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.D = onClickListener;
        this.o.a(onClickListener);
    }

    public final void b(View.OnClickListener onClickListener) {
        this.E = onClickListener;
        this.o.b(onClickListener);
    }

    public final void c(View.OnClickListener onClickListener) {
        this.F = onClickListener;
        this.o.c(onClickListener);
    }

    public final void a(String str) {
        this.h.showToast(str);
    }

    public final boolean f(boolean z) {
        if (this.s == null || !this.s.a()) {
            if (!z) {
                if (x()) {
                    y();
                    return true;
                } else if (this.f.h()) {
                    this.f.g();
                    return true;
                }
            } else if (x()) {
                y();
                return true;
            }
            return false;
        }
        return true;
    }

    public final void a(com.baidu.tieba.view.cb cbVar) {
        if (cbVar != null) {
            this.ay.remove(cbVar);
        }
    }

    public final void P() {
        if (this.ay != null) {
            while (this.ay.size() > 0) {
                com.baidu.tieba.view.cb remove = this.ay.remove(0);
                if (remove != null) {
                    remove.a(false);
                }
            }
        }
    }

    public final void Q() {
        this.h.hideProgressBar();
        if (this.k != null && this.J != null) {
            this.k.b(this.J);
        }
        R();
        this.x.d();
        try {
            this.o.a().c();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public final void R() {
        BdUtilHelper.a(this.h, this.u);
        this.f.e();
        if (this.p != null) {
            this.p.dismiss();
        }
        if (this.q != null) {
            this.q.dismiss();
        }
        if (this.ak != null) {
            this.ak.dismiss();
        }
        if (this.s != null) {
            this.s.o();
        }
        S();
    }

    public final void g(boolean z) {
        this.o.a(z);
        if (this.s != null) {
            this.s.c(z);
        }
    }

    public final void h(boolean z) {
        this.o.b(z);
        if (this.s != null) {
            this.s.b(z);
        }
    }

    public final void S() {
        if (this.M != null) {
            this.M.dismiss();
        }
        if (this.R != null) {
            this.R.dismiss();
        }
        if (this.ab != null) {
            this.ab.dismiss();
        }
        if (this.K != null) {
            this.K.dismiss();
        }
    }

    public final void T() {
        if (this.s != null) {
            this.s.u();
        }
    }

    public final com.baidu.adp.widget.ImageView.b a(View view, String str) {
        com.baidu.tieba.view.cb cbVar;
        com.baidu.adp.widget.ImageView.b a = this.o.a().a(str, this.aB, true, true);
        if (a == null && view != null && (view instanceof com.baidu.tieba.view.cb) && (cbVar = (com.baidu.tieba.view.cb) view) != null) {
            if (UtilHelper.b()) {
                cbVar.e();
                if (this.ay != null) {
                    this.ay.add(cbVar);
                }
            } else {
                BdUtilHelper.a((Context) this.h, (int) R.string.neterror);
            }
        }
        return a;
    }

    public final void U() {
        this.h.l();
        com.baidu.tieba.util.ap.a(this.j, this.o.a(), this.aA, this.az, null, this.o.c() ? 0 : 1, 0);
    }

    public final void a(int i) {
        this.h.getLayoutMode().a(i == 1);
        this.h.getLayoutMode().a(this.i);
        this.h.getLayoutMode().a(this.v);
        this.h.getLayoutMode().a(this.m);
        this.h.getLayoutMode().a(this.y);
        this.a.b(i);
        try {
            Button button = (Button) this.l.findViewById(R.id.pb_list_header_manage_btn);
            if (i == 1) {
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
            } else {
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
        this.h.getLayoutMode().a(i == 1);
        this.h.getLayoutMode().a(this.i);
        TextView textView = (TextView) this.l.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.l.findViewById(R.id.pb_list_header_reply);
        com.baidu.tieba.util.bq.a(this.b, i);
        e(this.al);
        this.o.notifyDataSetChanged();
        if (i == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_n_1, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_n, 0, 0, 0);
        }
        this.f.c(i);
        if (this.s != null) {
            this.s.a(i);
            this.h.getLayoutMode().a(this.x.b());
        }
        if (this.w != null) {
            this.w.a(i);
        }
        if (this.x != null) {
            this.x.c(i);
        }
        if (this.at != null) {
            this.at.c(i);
            this.at.a(i == 1 ? R.drawable.button_load_next_1 : R.drawable.button_load_next);
        }
        this.f.c(i);
    }

    public final boolean V() {
        return this.ai;
    }

    public final void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.H = rVar;
        this.o.a(this.H);
        if (this.s != null) {
            this.s.a(this.H);
        }
    }

    public final void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.I = qVar;
        this.o.a(this.I);
        if (this.s != null) {
            this.s.a(this.I);
        }
    }

    public final void a(com.baidu.tieba.view.by byVar) {
        this.J = byVar;
        if (this.k != null) {
            this.k.a(this.J);
        }
    }

    public final void i(boolean z) {
        this.o.a().a(z);
    }

    public final View W() {
        if (this.s == null) {
            return null;
        }
        return this.s.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
    }

    public final Button X() {
        return this.aq;
    }

    public final void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.f.c.a(writeImagesInfo, z);
    }

    public final void Y() {
        this.f.c.n();
    }
}
