package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.y c = null;
    private boolean d = false;
    private boolean e = false;
    private InputMethodManager f = null;
    private EditText g = null;
    private EditText h = null;
    private Button i = null;
    private Button j = null;
    private ImageView k = null;
    private ImageView l = null;
    private ImageView m = null;
    private ProgressBar n = null;
    private FrameLayout o = null;
    private ImageView p = null;
    private TextView q = null;
    private GridView r = null;
    private AlertDialog s = null;
    private m t = null;
    private ao u = null;
    private ap v = null;
    private DialogInterface.OnCancelListener w = null;
    private AlertDialog x = null;
    private Bitmap y = null;
    private Handler z = new Handler();
    private boolean A = false;
    private boolean B = false;
    private String C = null;
    private RelativeLayout D = null;
    private LinearLayout E = null;
    private TextView F = null;
    private com.baidu.tieba.y G = null;
    private Address H = null;
    private LinearLayout I = null;
    private RelativeLayout J = null;
    private Runnable K = new t(this);
    private Runnable L = new ae(this);
    private Runnable M = new ah(this);
    private View.OnClickListener N = new ai(this);
    private View.OnFocusChangeListener O = new aj(this);

    public static void a(Activity activity, String str, String str2, com.baidu.tieba.a.b bVar, boolean z, String str3) {
        a(activity, 0, str, str2, null, null, 0, bVar, 1300003, false, false, null, false, z, str3);
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        a(activity, 4, str, str2, str3, null, 0, null, 1300006, false, false, null, false, false, null);
    }

    public static void a(Activity activity, String str, String str2, com.baidu.tieba.a.b bVar) {
        a(activity, 0, str, str2, null, null, 0, bVar, 1300003, true, false, null, false, false, null);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, boolean z, com.baidu.tieba.a.b bVar) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, bVar, 1300001, false, false, null, z, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, bVar, 1300002, false, false, null, z, false, null);
        }
    }

    public static void a(Activity activity) {
        a(activity, false, (String) null);
    }

    public static void a(Activity activity, boolean z, String str) {
        a(activity, 3, "", "", null, null, 0, null, 1300005, false, false, null, false, z, str);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, String str5, com.baidu.tieba.a.b bVar, boolean z) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, bVar, 1300001, false, z, str5, false, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, bVar, 1300002, false, z, str5, false, false, null);
        }
    }

    private static void a(Activity activity, int i, String str, String str2, String str3, String str4, int i2, com.baidu.tieba.a.b bVar, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6) {
        if (bVar != null && bVar.a() == 0) {
            com.baidu.tieba.c.ai.a((Context) activity, bVar.e());
            return;
        }
        Intent intent = new Intent(activity, WriteActivity.class);
        intent.putExtra("type", i);
        intent.putExtra("forum_id", str);
        intent.putExtra("forum_name", str2);
        intent.putExtra("reply_sub_pb", z2);
        intent.putExtra("is_ad", z3);
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
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        m();
        if (TiebaApplication.b().l()) {
            if ((getIntent().getExtras().getInt("type") == 0 || getIntent().getExtras().getInt("type") == 3) && !com.baidu.tieba.a.i.f().equals(getIntent().getStringExtra("forum_id"))) {
                j();
            }
        }
    }

    private void j() {
        this.G = new ak(this);
        this.H = TiebaApplication.b().a(this.G);
        if (this.H != null) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.H != null && this.H.getMaxAddressLineIndex() >= 0) {
            this.F.setText(this.H.getAddressLine(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        n();
        this.p.setImageBitmap(null);
        if (this.y != null && !this.y.isRecycled()) {
            this.y.recycle();
            this.y = null;
        }
        this.z.removeCallbacks(this.L);
        TiebaApplication.b().aw();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.c != null && this.c.a() == 2 && this.B) {
            finish();
        } else if (this.x != null && (this.g.getText().toString().length() > 0 || this.h.getText().toString().length() > 0)) {
            if (this.e) {
                this.x.show();
                Button button = this.x.getButton(-3);
                if (button != null) {
                    ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                    layoutParams.width = -2;
                    button.setLayoutParams(layoutParams);
                }
                Button button2 = this.x.getButton(-2);
                if (button2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                    layoutParams2.width = -2;
                    button2.setLayoutParams(layoutParams2);
                }
                Button button3 = this.x.getButton(-1);
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
            if (this.c.m()) {
                com.baidu.tieba.c.k.a(this.c);
            }
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            l();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int color;
        int color2;
        super.b(i);
        com.baidu.tieba.c.ae.c(this.I, i);
        com.baidu.tieba.c.ae.c(this.q, i);
        com.baidu.tieba.c.ae.e((TextView) this.i, i);
        com.baidu.tieba.c.ae.d((TextView) this.j, i);
        if (i == 1) {
            this.D.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.g.setBackgroundResource(R.drawable.write_title_bg_1);
            this.h.setBackgroundColor(com.baidu.tieba.c.ae.d(i));
            this.J.setBackgroundColor(com.baidu.tieba.c.ae.d(i));
            color = com.baidu.tieba.c.ae.a(i);
            color2 = com.baidu.tieba.c.ae.c(i);
            this.r.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
        } else {
            this.D.setBackgroundColor(getResources().getColor(R.color.white));
            this.g.setBackgroundResource(R.drawable.write_title_bg);
            this.h.setBackgroundColor(-526345);
            this.J.setBackgroundColor(-526345);
            color = getResources().getColor(R.color.write_color);
            color2 = getResources().getColor(R.color.write_hint_color);
            this.r.setBackgroundColor(-1644826);
        }
        this.g.setTextColor(color);
        this.h.setTextColor(color);
        this.F.setTextColor(color);
        Editable text = this.g.getText();
        this.g.setText((CharSequence) null);
        this.g.setHintTextColor(color2);
        this.g.setText(text);
        Editable text2 = this.h.getText();
        this.h.setText((CharSequence) null);
        this.h.setHintTextColor(color2);
        this.h.setText(text2);
        o();
    }

    private void m() {
        setContentView(R.layout.write_activity);
        this.J = (RelativeLayout) findViewById(R.id.tools);
        this.D = (RelativeLayout) findViewById(R.id.parent);
        this.I = (LinearLayout) findViewById(R.id.title);
        this.E = (LinearLayout) findViewById(R.id.location_container);
        this.F = (TextView) findViewById(R.id.location_text);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new al(this));
        if (this.s == null) {
            this.s = builder.create();
            this.s.setCanceledOnTouchOutside(true);
        }
        this.j = (Button) findViewById(R.id.post);
        this.j.setOnFocusChangeListener(this.O);
        this.o = (FrameLayout) findViewById(R.id.image_container);
        this.n = (ProgressBar) findViewById(R.id.image_progress);
        this.p = (ImageView) findViewById(R.id.image);
        this.p.setOnClickListener(new am(this));
        this.g = (EditText) findViewById(R.id.post_title);
        this.g.setOnClickListener(this.N);
        this.g.setOnFocusChangeListener(this.O);
        if (this.c.a() == 0) {
            if (this.c.b() != null) {
                this.g.setText(this.c.b());
            } else if (this.d) {
                this.g.setText(getResources().getString(R.string.android_feedback));
                this.g.setSelection(getResources().getString(R.string.android_feedback).length());
            }
        } else if (this.c.a() != 1) {
            this.c.a();
        }
        this.g.addTextChangedListener(new an(this));
        this.z.postDelayed(this.K, 200L);
        this.t = new m(this);
        this.r = (GridView) findViewById(R.id.face_view);
        this.r.setAdapter((ListAdapter) this.t);
        this.r.setOnItemClickListener(new u(this));
        this.h = (EditText) findViewById(R.id.post_content);
        this.h.setOnClickListener(this.N);
        this.m = (ImageView) findViewById(R.id.select_image);
        this.m.setOnClickListener(new v(this));
        if (this.c.c() != null && this.c.c().length() > 0) {
            this.h.setText(com.baidu.tieba.c.n.b(this, this.c.c()));
        } else if (this.c.a() == 2) {
            if (this.B) {
                this.m.setVisibility(8);
                if (this.C != null && this.C.length() > 0) {
                    this.h.setText(getString(R.string.reply_sub_floor, new Object[]{this.C}));
                    this.h.setSelection(this.h.getText().length());
                }
            } else if (this.c.h() > 0) {
                String format = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.c.h()));
                this.h.setText(format);
                this.h.setSelection(format.length());
            }
        } else if (this.c.a() == 0 && this.d) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(R.string.tieba_client));
            stringBuffer.append(com.baidu.tieba.a.i.h());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(":");
            this.h.setText(stringBuffer);
        }
        this.h.setOnFocusChangeListener(this.O);
        this.h.setOnTouchListener(new w(this));
        this.h.addTextChangedListener(new x(this));
        this.i = (Button) findViewById(R.id.back);
        this.i.setOnFocusChangeListener(this.O);
        this.q = (TextView) findViewById(R.id.name);
        this.i.setOnClickListener(new y(this));
        this.l = (ImageView) findViewById(R.id.select_at);
        this.l.setOnClickListener(new z(this));
        this.j.setOnClickListener(new aa(this));
        this.k = (ImageView) findViewById(R.id.select_face);
        this.k.setOnClickListener(new ab(this));
        if (this.c.a() == 0) {
            if (this.d) {
                this.q.setText(R.string.feedback);
            } else {
                this.q.setText(R.string.post_new_thread);
            }
            this.g.setVisibility(0);
            this.E.setVisibility(8);
        } else {
            if (this.c.a() == 3) {
                this.l.setVisibility(8);
                this.q.setText(R.string.lbs_post);
                this.E.setVisibility(0);
                this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(BdWebErrorView.ERROR_CODE_500)});
            } else if (this.c.a() == 4) {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.q.setText(R.string.lbs_reply);
                this.E.setVisibility(8);
                this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(BdWebErrorView.ERROR_CODE_500)});
            } else {
                this.l.setVisibility(0);
                this.q.setText(R.string.send_reply);
                this.E.setVisibility(8);
                this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
            }
            this.g.setVisibility(8);
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new ac(this)).setNeutralButton(getString(R.string.not_save), new ad(this)).setNegativeButton(getString(R.string.cancel), new af(this));
        this.x = builder2.create();
        o();
        p();
    }

    private void n() {
        try {
            if (this.x != null && this.x.isShowing()) {
                this.x.dismiss();
            }
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "closeDialog", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String trim;
        if (this.c.a() == 0) {
            trim = this.g.getText().toString().trim();
        } else if (this.y != null) {
            trim = "1";
        } else {
            trim = this.h.getText().toString().trim();
        }
        if (this.A || trim == null || trim.length() <= 0 || this.u != null) {
            this.j.setEnabled(false);
            if (this.b == 1) {
                this.j.setTextColor(com.baidu.tieba.c.ae.c(this.b));
                return;
            } else {
                this.j.setTextColor(-7688462);
                return;
            }
        }
        this.j.setEnabled(true);
        if (this.b == 1) {
            this.j.setTextColor(com.baidu.tieba.c.ae.a(this.b));
        } else {
            this.j.setTextColor(-1);
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.w = new ag(this);
        this.c = new com.baidu.tieba.b.y();
        if (bundle != null) {
            this.c.a(bundle.getInt("type", 0));
            this.c.e(bundle.getString("forum_id"));
            this.c.f(bundle.getString("forum_name"));
            this.c.c(bundle.getString("thread_id"));
            this.c.d(bundle.getString("floor_id"));
            intExtra = bundle.getInt("floor_num", 0);
            this.c.b(intExtra);
            this.d = bundle.getBoolean("feed_back", false);
            this.B = bundle.getBoolean("reply_sub_pb", false);
            this.C = bundle.getString("sub_user_name");
        } else {
            Intent intent = getIntent();
            this.c.a(intent.getIntExtra("type", 0));
            this.c.e(intent.getStringExtra("forum_id"));
            this.c.f(intent.getStringExtra("forum_name"));
            this.c.c(intent.getStringExtra("thread_id"));
            this.c.d(intent.getStringExtra("floor_id"));
            intExtra = intent.getIntExtra("floor_num", 0);
            this.c.b(intExtra);
            this.d = intent.getBooleanExtra("feed_back", false);
            this.B = intent.getBooleanExtra("reply_sub_pb", false);
            this.C = intent.getStringExtra("sub_user_name");
        }
        com.baidu.tieba.b.y a = com.baidu.tieba.c.k.a(this.c.a(), this.c.f(), this.c.d(), this.c.e());
        if (a != null) {
            this.c = a;
            this.c.b(intExtra);
            this.c.a(true);
        }
    }

    private void p() {
        if (getIntent().getBooleanExtra("refresh_pic", false)) {
            if (this.u != null) {
                this.u.a();
            }
            this.u = null;
            q();
            if (getIntent().getStringExtra("file_name") != null) {
                this.u = new ao(this, getIntent().getStringExtra("file_name"));
                this.u.execute(new Object[0]);
            } else {
                this.u = new ao(this, "tieba_resized_image_display");
                this.u.execute(new Object[0]);
            }
            this.z.removeCallbacks(this.L);
            this.z.postDelayed(this.L, 10000L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.c.a());
        bundle.putString("forum_id", this.c.f());
        bundle.putString("forum_name", this.c.g());
        bundle.putString("thread_id", this.c.d());
        bundle.putString("floor_id", this.c.e());
        bundle.putInt("floor_num", this.c.h());
        bundle.putBoolean("reply_sub_pb", this.B);
        if (this.d) {
            bundle.putBoolean("feed_back", true);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.h.getEditableText().toString();
        if (editable != null) {
            this.h.setText(com.baidu.tieba.c.n.b(this, editable));
        }
    }

    public void i() {
        this.c.a(this.g.getText().toString());
        this.c.b(this.h.getText().toString());
        a(getString(R.string.sending), this.w);
        if (this.v != null) {
            this.v.a();
        }
        this.c.g(null);
        this.v = new ap(this, this.c);
        this.v.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1200003) {
                if (intent.getBooleanExtra("delete", false)) {
                    this.y = null;
                    this.p.setVisibility(8);
                    this.o.setVisibility(8);
                    return;
                }
                if (intent.getBooleanExtra("change", false)) {
                    if (this.u != null) {
                        this.u.a();
                    }
                    this.u = null;
                    q();
                    if (this.u != null) {
                        this.u.a();
                    }
                    this.u = null;
                    if (intent.getStringExtra("file_name") != null) {
                        this.u = new ao(this, intent.getStringExtra("file_name"));
                    } else {
                        this.u = new ao(this, "tieba_resized_image_display");
                    }
                    this.u.execute(new Object[0]);
                    this.z.removeCallbacks(this.L);
                    this.z.postDelayed(this.L, 10000L);
                }
                o();
            } else if (i == 12000010 || i == 1200008) {
                q();
                if (this.u != null) {
                    this.u.a();
                }
                this.u = null;
                if (intent.getStringExtra("file_name") != null) {
                    this.u = new ao(this, intent.getStringExtra("file_name"));
                } else {
                    this.u = new ao(this, "tieba_resized_image_display");
                }
                this.u.execute(new Object[0]);
                this.z.removeCallbacks(this.L);
                this.z.postDelayed(this.L, 10000L);
                o();
                a(this.h, MKEvent.ERROR_PERMISSION_DENIED);
            } else if (i == 1200004) {
                String a = AtListActivity.a(intent);
                if (a != null) {
                    this.h.getText().insert(this.h.getSelectionStart(), "@" + a + " ");
                }
            } else if (i == 1200005) {
                com.baidu.tieba.c.k.a(this.c);
                if (this.c.a() == 4) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("reply_content", this.c.c());
                    intent2.putExtra("reply_tid", this.c.d());
                    setResult(-1, intent2);
                } else {
                    setResult(-1);
                }
                finish();
            } else {
                if (this.u != null) {
                    this.u.a();
                }
                this.u = null;
                if (i == 1200002) {
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), null, null, null);
                    } else {
                        bb.b(this);
                    }
                } else if (i == 1200001) {
                    WriteImageActivity.a(this, 1200001, 12000010, null, null, null, null);
                }
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200001:
                case 1200002:
                    this.s.show();
                    return;
                case 1200008:
                    bb.b(this);
                    return;
                case 12000010:
                    bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void q() {
        this.A = true;
        this.p.setVisibility(8);
        this.p.setImageBitmap(null);
        this.o.setVisibility(8);
        if (this.y != null && !this.y.isRecycled()) {
            this.y.recycle();
        }
        this.y = null;
        this.c.a((com.baidu.tieba.a.x) null);
        this.n.setVisibility(0);
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        this.z.removeCallbacks(this.L);
        this.A = false;
        this.n.setVisibility(8);
        if (bitmap != null) {
            this.y = bitmap;
            this.c.a((com.baidu.tieba.a.x) null);
            this.p.setImageBitmap(this.y);
            this.p.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            b(getString(R.string.pic_parser_error));
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        a(this.f, this.g);
        a(this.f, this.h);
        if (this.r.getVisibility() == 0) {
            this.r.setVisibility(8);
        }
        super.onPause();
    }
}
