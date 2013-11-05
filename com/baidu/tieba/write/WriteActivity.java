package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.j implements com.baidu.tieba.voice.ag {
    private Toast M;
    private RecordVoiceBnt N;
    private FrameLayout O;
    private VoiceManager Y;

    /* renamed from: a  reason: collision with root package name */
    private WriteData f2619a = null;
    private boolean b = false;
    private boolean c = false;
    private InputMethodManager d = null;
    private EditText e = null;
    private FrameLayout f = null;
    private EditText g = null;
    private NavigationBar j = null;
    private ImageView k = null;
    private Button l = null;
    private ImageView m = null;
    private AudioIcon n = null;
    private ImageView o = null;
    private ImageView p = null;
    private ProgressBar q = null;
    private FrameLayout r = null;
    private ImageView s = null;
    private TextView t = null;
    private GridView u = null;
    private AlertDialog v = null;
    private p w = null;
    private at x = null;
    private au y = null;
    private DialogInterface.OnCancelListener z = null;
    private AlertDialog A = null;
    private Bitmap B = null;
    private Handler C = new Handler();
    private boolean D = false;
    private boolean E = false;
    private String F = null;
    private RelativeLayout G = null;
    private LinearLayout H = null;
    private TextView I = null;
    private com.baidu.tieba.au J = null;
    private Address K = null;
    private RelativeLayout L = null;
    private boolean P = false;
    private String Q = null;
    private Runnable R = new w(this);
    private Runnable S = new ah(this);
    private Runnable T = new am(this);
    private Runnable U = new an(this);
    private View.OnClickListener V = new ao(this);
    private boolean W = true;
    private View.OnFocusChangeListener X = new ap(this);

    @Override // com.baidu.tieba.j
    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.a(str, onCancelListener);
        this.h.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        int i2;
        int i3;
        int i4;
        if (TiebaApplication.g().as() == 1) {
            i = R.drawable.write_face_1;
            i2 = R.drawable.write_at_1;
            i3 = R.drawable.write_image_1;
            i4 = R.drawable.write_audio_1;
        } else {
            i = R.drawable.write_face;
            i2 = R.drawable.write_at;
            i3 = R.drawable.write_image;
            i4 = R.drawable.write_audio;
        }
        boolean z = this.W ? false : true;
        this.m.setEnabled(z);
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        this.p.setEnabled(z);
        this.m.setImageResource(i);
        this.o.setImageResource(i2);
        this.p.setImageResource(i3);
        this.n.getView().setImageResource(i4);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        g_().c(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        g_().b((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.N != null) {
            this.N.C();
        }
        g_().f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.N.setVisibility(8);
        this.O.setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.N.setVisibility(0);
        this.O.setPadding(0, UtilHelper.a((Context) this, 1.0f), 0, 0);
    }

    public static void a(Activity activity, String str, String str2, AntiData antiData, boolean z, String str3) {
        a(activity, 0, str, str2, null, null, 0, antiData, 13003, false, false, null, false, z, str3);
    }

    public static void a(Activity activity, String str, String str2, AntiData antiData) {
        antiData.setIfVoice(false);
        a(activity, 0, str, str2, null, null, 0, antiData, 13003, true, false, null, false, false, null);
    }

    public static void a(Activity activity, String str, String str2, String str3, AntiData antiData, String str4) {
        a(activity, 1, str, str2, str3, null, 0, antiData, 13002, false, false, null, false, true, str4);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, String str5, AntiData antiData, boolean z) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, antiData, 13001, false, z, str5, false, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, antiData, 13002, false, z, str5, false, false, null);
        }
    }

    private static void a(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6) {
        if (antiData != null && antiData.getIfpost() == 0) {
            UtilHelper.a((Context) activity, antiData.getForbid_info());
            return;
        }
        Intent intent = new Intent(activity, WriteActivity.class);
        intent.putExtra("type", i);
        intent.putExtra("forum_id", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra("reply_sub_pb", z2);
        intent.putExtra("is_ad", z3);
        if (antiData != null) {
            intent.putExtra("enable_audio", antiData.isIfvoice());
            intent.putExtra("disable_audio_message", antiData.getVoice_message());
        }
        if (str6 != null) {
            intent.putExtra("file_name", str6);
        }
        intent.putExtra("refresh_pic", z4);
        if (z) {
            intent.putExtra("feed_back", true);
        }
        if (str3 != null) {
            intent.putExtra("thread_id", str3);
        }
        if (str4 != null) {
            intent.putExtra("floor_id", str4);
        }
        if (i2 > 0) {
            intent.putExtra("floor_num", i2);
        }
        if (str5 != null) {
            intent.putExtra("sub_user_name", str5);
        }
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        r();
        if (TiebaApplication.g().t() && getIntent().getExtras().getInt("type") == 0 && !com.baidu.tieba.data.h.h().equals(getIntent().getStringExtra("forum_id"))) {
            o();
        }
    }

    private void o() {
        this.J = new aq(this);
        this.K = TiebaApplication.g().a(this.J);
        if (this.K != null) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.K != null && this.K.getMaxAddressLineIndex() >= 0) {
            this.I.setText(this.K.getAddressLine(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.x != null) {
            this.x.cancel();
            this.x = null;
        }
        if (this.y != null) {
            this.y.cancel();
            this.y = null;
        }
        if (this.q != null) {
            this.q.setVisibility(8);
        }
        v();
        this.s.setImageBitmap(null);
        if (this.B != null && !this.B.isRecycled()) {
            this.B.recycle();
            this.B = null;
        }
        this.C.removeCallbacks(this.S);
        TiebaApplication.g().aO();
        super.onDestroy();
        g_().g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f2619a != null && this.f2619a.getType() == 2 && this.E) {
            finish();
        } else if (this.A != null && (this.e.getText().toString().length() > 0 || this.g.getText().toString().length() > 0)) {
            if (this.c) {
                this.A.show();
                this.A.setCanceledOnTouchOutside(true);
                Button button = this.A.getButton(-3);
                if (button != null) {
                    ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                    layoutParams.width = -2;
                    button.setLayoutParams(layoutParams);
                }
                Button button2 = this.A.getButton(-2);
                if (button2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                    layoutParams2.width = -2;
                    button2.setLayoutParams(layoutParams2);
                }
                Button button3 = this.A.getButton(-1);
                if (button3 != null) {
                    ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                    layoutParams3.width = -2;
                    button3.setLayoutParams(layoutParams3);
                    return;
                }
                return;
            }
            finish();
        } else {
            if (this.f2619a.getHaveDraft()) {
                DatabaseService.a(this.f2619a);
            }
            finish();
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.u.getVisibility() == 0 || this.N.getVisibility() == 0) {
                this.u.setVisibility(8);
                f();
                d(7);
                return false;
            }
            q();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        int color;
        int color2;
        super.a(i);
        m().a(i == 1);
        m().a(this.G);
        this.j.b(i);
        com.baidu.tieba.util.bb.h(this.l, i);
        e();
        if (i == 1) {
            this.G.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.e.setBackgroundColor(com.baidu.tieba.util.bb.d(i));
            this.f.setBackgroundColor(-14210511);
            this.g.setBackgroundColor(com.baidu.tieba.util.bb.d(i));
            this.L.setBackgroundColor(com.baidu.tieba.util.bb.d(i));
            color = com.baidu.tieba.util.bb.a(i);
            color2 = -11446171;
            this.u.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
            this.L.setBackgroundResource(R.drawable.bg_posts_bar_1);
            this.l.setTextColor(-11446171);
        } else {
            this.G.setBackgroundColor(getResources().getColor(R.color.white));
            this.f.setBackgroundColor(-2894893);
            this.e.setBackgroundColor(-526345);
            this.g.setBackgroundColor(-526345);
            this.L.setBackgroundColor(-526345);
            this.L.setBackgroundResource(R.drawable.bg_posts_bar);
            color = getResources().getColor(R.color.write_color);
            color2 = getResources().getColor(R.color.write_hint_color);
            this.u.setBackgroundColor(-1644826);
            this.l.setTextColor(-1);
        }
        this.e.setTextColor(color);
        this.g.setTextColor(color);
        this.I.setTextColor(color);
        Editable text = this.e.getText();
        int selectionStart = this.e.getSelectionStart();
        int selectionEnd = this.e.getSelectionEnd();
        this.e.setText((CharSequence) null);
        this.e.setHintTextColor(color2);
        this.e.setText(text);
        this.e.setSelection(selectionStart, selectionEnd);
        Editable text2 = this.g.getText();
        int selectionStart2 = this.g.getSelectionStart();
        int selectionEnd2 = this.g.getSelectionEnd();
        this.g.setText((CharSequence) null);
        this.g.setHintTextColor(color2);
        this.g.setText(text2);
        this.g.setSelection(selectionStart2, selectionEnd2);
        y();
    }

    private void r() {
        setContentView(R.layout.write_activity);
        this.j = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.t = this.j.a("");
        this.k = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.send));
        this.l.setOnFocusChangeListener(this.X);
        this.L = (RelativeLayout) findViewById(R.id.tools);
        this.G = (RelativeLayout) findViewById(R.id.parent);
        this.H = (LinearLayout) findViewById(R.id.location_container);
        this.I = (TextView) findViewById(R.id.location_text);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ar(this));
        if (this.v == null) {
            this.v = builder.create();
            this.v.setCanceledOnTouchOutside(true);
        }
        this.r = (FrameLayout) findViewById(R.id.image_container);
        this.q = (ProgressBar) findViewById(R.id.image_progress);
        this.s = (ImageView) findViewById(R.id.image);
        this.s.setOnClickListener(new as(this));
        this.e = (EditText) findViewById(R.id.post_title);
        this.f = (FrameLayout) findViewById(R.id.interval_view);
        this.e.setOnClickListener(this.V);
        this.e.setOnFocusChangeListener(this.X);
        if (this.f2619a.getType() == 0) {
            if (this.f2619a.getTitle() != null) {
                this.e.setText(this.f2619a.getTitle());
            } else if (this.b) {
                this.e.setText(getResources().getString(R.string.android_feedback));
                this.e.setSelection(getResources().getString(R.string.android_feedback).length());
            }
        } else if (this.f2619a.getType() == 1 || this.f2619a.getType() != 2) {
        }
        this.e.addTextChangedListener(new x(this));
        this.C.postDelayed(this.R, 200L);
        this.w = new p(this);
        this.u = (GridView) findViewById(R.id.face_view);
        this.u.setAdapter((ListAdapter) this.w);
        this.u.setOnItemClickListener(new y(this));
        this.g = (EditText) findViewById(R.id.post_content);
        this.g.setOnClickListener(this.V);
        this.n = (AudioIcon) findViewById(R.id.audio_button);
        this.p = (ImageView) findViewById(R.id.select_image);
        this.p.setOnClickListener(new z(this));
        if (this.f2619a.getContent() != null && this.f2619a.getContent().length() > 0) {
            this.g.setText(TbFaceManager.a().a(this, this.f2619a.getContent()));
        } else if (this.f2619a.getType() == 2) {
            if (this.E) {
                this.p.setVisibility(8);
                if (this.F != null && this.F.length() > 0) {
                    this.g.setText(getString(R.string.reply_sub_floor, new Object[]{this.F}));
                    this.g.setSelection(this.g.getText().length());
                }
            } else if (this.f2619a.getFloorNum() > 0) {
                String format = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.f2619a.getFloorNum()));
                this.g.setText(format);
                this.g.setSelection(format.length());
            }
        } else if (this.f2619a.getType() == 0 && this.b) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(R.string.tieba_client));
            stringBuffer.append(com.baidu.tieba.data.h.j());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(":");
            this.g.setText(stringBuffer);
        }
        this.g.setOnFocusChangeListener(this.X);
        this.g.setOnTouchListener(new aa(this));
        this.g.addTextChangedListener(new ab(this));
        this.k.setOnFocusChangeListener(this.X);
        this.k.setOnClickListener(new ac(this));
        this.o = (ImageView) findViewById(R.id.select_at);
        this.o.setOnClickListener(new ad(this));
        this.l.setOnClickListener(new ae(this));
        this.m = (ImageView) findViewById(R.id.select_face);
        this.m.setOnClickListener(new af(this));
        if (this.f2619a.getType() == 0) {
            if (this.b) {
                this.t.setText(R.string.feedback);
            } else {
                this.t.setText(R.string.post_new_thread);
            }
            this.e.setVisibility(0);
            this.H.setVisibility(8);
        } else {
            this.o.setVisibility(0);
            this.t.setText(R.string.send_reply);
            this.H.setVisibility(8);
            this.g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
            this.e.setVisibility(8);
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new ai(this)).setNeutralButton(getString(R.string.not_save), new ag(this));
        this.A = builder2.create();
        y();
        z();
        s();
        a(x());
        e();
    }

    private void a(Boolean bool) {
        String str = null;
        if (this.f2619a != null) {
            str = this.f2619a.getForumName();
        }
        if (com.baidu.tieba.c.a.a(str, bool)) {
            c();
        } else {
            w();
        }
    }

    private void s() {
        this.N = (RecordVoiceBnt) findViewById(R.id.record_voice_view);
        this.O = (FrameLayout) findViewById(R.id.bottom_view);
        g_().a((Activity) this);
        this.N.setCallback(new aj(this));
        this.n.setOnClickListener(new ak(this));
    }

    private void t() {
        this.n.getView().setImageDrawable(getResources().getDrawable(TiebaApplication.g().as() == 1 ? R.drawable.write_audio_1 : R.drawable.write_audio));
    }

    private void u() {
        this.n.getView().setImageDrawable(getResources().getDrawable(TiebaApplication.g().as() == 1 ? R.drawable.write_keyboard_1 : R.drawable.write_keyboard));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        int i2 = R.drawable.write_face_1;
        boolean z = TiebaApplication.g().as() == 1;
        if (i == 0) {
            a(this.d, this.e);
            a(this.d, this.g);
            this.u.setVisibility(8);
            this.n.setVisibility(8);
        } else if (i == 1) {
            a(this.d, this.e);
            a(this.d, this.g);
            this.C.postDelayed(this.T, 200L);
            f();
            t();
            this.m.setImageDrawable(getResources().getDrawable(z ? R.drawable.write_keyboard_1 : R.drawable.write_keyboard));
        } else if (i == 2) {
            this.g.requestFocus();
            this.u.setVisibility(8);
            f();
            t();
            b(this.d, this.g);
            ImageView imageView = this.m;
            Resources resources = getResources();
            if (!z) {
                i2 = R.drawable.write_face;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
        } else if (i != 3) {
            if (i == 4) {
                a(this.d, this.e);
                a(this.d, this.g);
                this.u.setVisibility(8);
                u();
                ImageView imageView2 = this.m;
                Resources resources2 = getResources();
                if (!z) {
                    i2 = R.drawable.write_face;
                }
                imageView2.setImageDrawable(resources2.getDrawable(i2));
                this.C.postDelayed(this.U, 200L);
            } else if (i == 5) {
                f();
                this.g.requestFocus();
                this.u.setVisibility(8);
                b(this.d, this.g);
                t();
                ImageView imageView3 = this.m;
                Resources resources3 = getResources();
                if (!z) {
                    i2 = R.drawable.write_face;
                }
                imageView3.setImageDrawable(resources3.getDrawable(i2));
            } else if (i == 6) {
                this.u.setVisibility(8);
                f();
                ImageView imageView4 = this.m;
                Resources resources4 = getResources();
                if (!z) {
                    i2 = R.drawable.write_face;
                }
                imageView4.setImageDrawable(resources4.getDrawable(i2));
                t();
            } else if (i == 7) {
                ImageView imageView5 = this.m;
                Resources resources5 = getResources();
                if (!z) {
                    i2 = R.drawable.write_face;
                }
                imageView5.setImageDrawable(resources5.getDrawable(i2));
                t();
            } else if (i == 8) {
                this.m.setImageDrawable(getResources().getDrawable(z ? R.drawable.but_posts_expression_d_1 : R.drawable.but_posts_expression_d));
                this.n.getView().setImageResource(z ? R.drawable.but_posts_microphone_d_1 : R.drawable.but_posts_microphone_d);
            }
        }
    }

    private void v() {
        try {
            if (this.A != null && this.A.isShowing()) {
                this.A.dismiss();
            }
            if (this.v != null && this.v.isShowing()) {
                this.v.dismiss();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "closeDialog", e.getMessage());
        }
    }

    private void w() {
        if (this.n != null) {
            this.n.b();
        }
    }

    public void c() {
        if (this.n != null) {
            this.n.c();
            if (!this.P) {
                this.n.d();
                this.P = true;
            }
        }
    }

    private Boolean x() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("enable_audio")) {
                bool = Boolean.valueOf(intent.getBooleanExtra("enable_audio", true));
            }
            if (intent.hasExtra("disable_audio_message")) {
                this.Q = intent.getStringExtra("disable_audio_message");
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        String trim;
        if (this.f2619a.getType() == 0) {
            trim = this.e.getText().toString().trim();
        } else if (this.B != null) {
            trim = SocialConstants.TRUE;
        } else {
            trim = this.g.getText().toString().trim();
        }
        if (this.D || trim == null || trim.length() <= 0 || this.x != null) {
            this.l.setEnabled(false);
            if (this.i == 1) {
                this.l.setTextColor(-11446171);
                return;
            } else {
                this.l.setTextColor(-11313038);
                return;
            }
        }
        this.l.setEnabled(true);
        if (this.i == 1) {
            this.l.setTextColor(com.baidu.tieba.util.bb.a(this.i));
        } else {
            this.l.setTextColor(-1);
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.z = new al(this);
        this.f2619a = new WriteData();
        if (bundle != null) {
            this.f2619a.setType(bundle.getInt("type", 0));
            this.f2619a.setForumId(bundle.getString("forum_id"));
            this.f2619a.setForumName(bundle.getString("forum_name"));
            this.f2619a.setThreadId(bundle.getString("thread_id"));
            this.f2619a.setFloor(bundle.getString("floor_id"));
            intExtra = bundle.getInt("floor_num", 0);
            this.f2619a.setFloorNum(intExtra);
            this.b = bundle.getBoolean("feed_back", false);
            this.E = bundle.getBoolean("reply_sub_pb", false);
            this.F = bundle.getString("sub_user_name");
        } else {
            Intent intent = getIntent();
            this.f2619a.setType(intent.getIntExtra("type", 0));
            this.f2619a.setForumId(intent.getStringExtra("forum_id"));
            this.f2619a.setForumName(intent.getStringExtra("forum_name"));
            this.f2619a.setThreadId(intent.getStringExtra("thread_id"));
            this.f2619a.setFloor(intent.getStringExtra("floor_id"));
            intExtra = intent.getIntExtra("floor_num", 0);
            this.f2619a.setFloorNum(intExtra);
            this.b = intent.getBooleanExtra("feed_back", false);
            this.E = intent.getBooleanExtra("reply_sub_pb", false);
            this.F = intent.getStringExtra("sub_user_name");
        }
        WriteData a2 = DatabaseService.a(this.f2619a.getType(), this.f2619a.getForumId(), this.f2619a.getThreadId(), this.f2619a.getFloor());
        if (a2 != null) {
            this.f2619a = a2;
            this.f2619a.setFloorNum(intExtra);
            this.f2619a.setHaveDraft(true);
        }
    }

    private void z() {
        if (getIntent().getBooleanExtra("refresh_pic", false)) {
            if (this.x != null) {
                this.x.cancel();
            }
            this.x = null;
            A();
            if (getIntent().getStringExtra("file_name") != null) {
                this.x = new at(this, getIntent().getStringExtra("file_name"));
                this.x.execute(new Object[0]);
            } else {
                this.x = new at(this, "tieba_resized_image_display");
                this.x.execute(new Object[0]);
            }
            this.C.removeCallbacks(this.S);
            this.C.postDelayed(this.S, 10000L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.f2619a.getType());
        bundle.putString("forum_id", this.f2619a.getForumId());
        bundle.putString("forum_name", this.f2619a.getForumName());
        bundle.putString("thread_id", this.f2619a.getThreadId());
        bundle.putString("floor_id", this.f2619a.getFloor());
        bundle.putInt("floor_num", this.f2619a.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.E);
        if (this.b) {
            bundle.putBoolean("feed_back", true);
        }
        super.onSaveInstanceState(bundle);
        g_().e(this);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = this.g.getEditableText().toString();
        if (obj != null) {
            this.g.setText(TbFaceManager.a().a(this, obj));
        }
    }

    public void d() {
        this.f2619a.setTitle(this.e.getText().toString());
        this.f2619a.setContent(this.g.getText().toString());
        a(getString(R.string.sending), this.z);
        if (this.y != null) {
            this.y.cancel();
        }
        this.f2619a.setVcode(null);
        this.y = new au(this, this.f2619a);
        this.y.setPriority(3);
        this.y.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12003) {
                if (intent.getBooleanExtra("delete", false)) {
                    this.B = null;
                    this.s.setVisibility(8);
                    this.r.setVisibility(8);
                    return;
                }
                if (intent.getBooleanExtra("change", false)) {
                    if (this.x != null) {
                        this.x.cancel();
                    }
                    this.x = null;
                    A();
                    if (this.x != null) {
                        this.x.cancel();
                    }
                    this.x = null;
                    if (intent.getStringExtra("file_name") != null) {
                        this.x = new at(this, intent.getStringExtra("file_name"));
                    } else {
                        this.x = new at(this, "tieba_resized_image");
                    }
                    this.x.execute(new Object[0]);
                    this.C.removeCallbacks(this.S);
                    this.C.postDelayed(this.S, 10000L);
                }
                y();
            } else if (i == 12010 || i == 12009) {
                A();
                if (this.x != null) {
                    this.x.cancel();
                }
                this.x = null;
                if (intent.getStringExtra("file_name") != null) {
                    this.x = new at(this, intent.getStringExtra("file_name"));
                } else {
                    this.x = new at(this, "tieba_resized_image");
                }
                this.x.execute(new Object[0]);
                this.C.removeCallbacks(this.S);
                this.C.postDelayed(this.S, 10000L);
                y();
                a(this.g, 300);
            } else if (i == 12004) {
                String a2 = AtListActivity.a(intent);
                if (a2 != null) {
                    this.g.getText().insert(this.g.getSelectionStart(), "@" + a2 + " ");
                }
            } else if (i == 12006) {
                DatabaseService.a(this.f2619a);
                setResult(-1);
                finish();
            } else {
                if (this.x != null) {
                    this.x.cancel();
                }
                this.x = null;
                if (i == 12002) {
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), null, null, null);
                    } else {
                        bg.b(this);
                    }
                } else if (i == 12001) {
                    WriteImageActivity.a(this, 12001, 12010, null, null, null, null);
                }
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                case 12002:
                    this.v.show();
                    return;
                case 12009:
                    bg.b(this);
                    return;
                case 12010:
                    bg.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void A() {
        this.D = true;
        this.s.setVisibility(8);
        this.s.setImageBitmap(null);
        this.r.setVisibility(8);
        if (this.B != null && !this.B.isRecycled()) {
            this.B.recycle();
        }
        this.B = null;
        this.f2619a.setBitmapId(null);
        this.q.setVisibility(0);
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        this.C.removeCallbacks(this.S);
        this.D = false;
        this.q.setVisibility(8);
        if (bitmap != null) {
            this.B = bitmap;
            this.f2619a.setBitmapId(null);
            this.s.setImageBitmap(this.B);
            this.s.setVisibility(0);
            this.r.setVisibility(0);
        } else {
            this.s.setVisibility(8);
            this.r.setVisibility(8);
            a(getString(R.string.pic_parser_error));
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        a(this.d, this.e);
        a(this.d, this.g);
        if (this.u.getVisibility() == 0 || this.N.getVisibility() == 0) {
            this.u.setVisibility(8);
            f();
            d(7);
        }
        super.onPause();
        g_().d(this);
    }

    @Override // com.baidu.tieba.voice.ag
    public synchronized VoiceManager g_() {
        if (this.Y == null) {
            this.Y = VoiceManager.c();
        }
        return this.Y;
    }

    @Override // com.baidu.tieba.voice.ag
    public com.baidu.tieba.voice.ae a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }
}
