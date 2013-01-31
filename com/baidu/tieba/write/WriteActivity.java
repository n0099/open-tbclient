package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.w c = null;
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
    private ImageView o = null;
    private TextView p = null;
    private GridView q = null;
    private AlertDialog r = null;
    private m s = null;
    private an t = null;
    private ao u = null;
    private DialogInterface.OnCancelListener v = null;
    private AlertDialog w = null;
    private Bitmap x = null;
    private Handler y = new Handler();
    private boolean z = false;
    private boolean A = false;
    private String B = null;
    private RelativeLayout C = null;
    private LinearLayout D = null;
    private Runnable E = new t(this);
    private Runnable F = new ae(this);
    private Runnable G = new ag(this);
    private View.OnClickListener H = new ah(this);
    private View.OnFocusChangeListener I = new ai(this);

    public static void a(Activity activity, String str, String str2, com.baidu.tieba.a.b bVar, boolean z, String str3) {
        a(activity, 0, str, str2, null, null, 0, bVar, 1300003, false, false, null, false, z, str3);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4) {
        a(activity, 1, str, str2, str3, null, 0, null, 1300002, false, false, null, false, true, str4);
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

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, String str5, com.baidu.tieba.a.b bVar, boolean z) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, bVar, 1300001, false, z, str5, false, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, bVar, 1300002, false, z, str5, false, false, null);
        }
    }

    private static void a(Activity activity, int i, String str, String str2, String str3, String str4, int i2, com.baidu.tieba.a.b bVar, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6) {
        if (bVar != null && bVar.a() == 0) {
            com.baidu.tieba.c.ah.a((Context) activity, bVar.e());
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
        k();
        if (TiebaApplication.b().l() && getIntent().getExtras().getInt("type") == 0 && !com.baidu.tieba.a.i.f().equals(getIntent().getStringExtra("forum_id"))) {
            TiebaApplication.b().au();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.t != null) {
            this.t.a();
            this.t = null;
        }
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        l();
        this.o.setImageBitmap(null);
        if (this.x != null && !this.x.isRecycled()) {
            this.x.recycle();
            this.x = null;
        }
        this.y.removeCallbacks(this.F);
        TiebaApplication.b().av();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.c != null && this.c.a() == 2 && this.A) {
            finish();
        } else if (this.w != null && (this.g.getText().toString().length() > 0 || this.h.getText().toString().length() > 0)) {
            if (this.e) {
                this.w.show();
                Button button = this.w.getButton(-3);
                if (button != null) {
                    ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                    layoutParams.width = -2;
                    button.setLayoutParams(layoutParams);
                }
                Button button2 = this.w.getButton(-2);
                if (button2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                    layoutParams2.width = -2;
                    button2.setLayoutParams(layoutParams2);
                }
                Button button3 = this.w.getButton(-1);
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
            j();
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
        com.baidu.tieba.c.ad.a(this.C, i);
        com.baidu.tieba.c.ad.c(this.D, i);
        com.baidu.tieba.c.ad.c(this.p, i);
        com.baidu.tieba.c.ad.e((TextView) this.i, i);
        com.baidu.tieba.c.ad.d((TextView) this.j, i);
        if (i == 1) {
            this.g.setBackgroundResource(R.drawable.write_title_bg_1);
            this.h.setBackgroundColor(com.baidu.tieba.c.ad.d(i));
            color = com.baidu.tieba.c.ad.a(i);
            color2 = com.baidu.tieba.c.ad.c(i);
            this.q.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
        } else {
            this.g.setBackgroundResource(R.drawable.write_title_bg);
            this.h.setBackgroundColor(-526345);
            color = getResources().getColor(R.color.write_color);
            color2 = getResources().getColor(R.color.write_hint_color);
            this.q.setBackgroundColor(-1644826);
        }
        this.g.setTextColor(color);
        this.h.setTextColor(color);
        Editable text = this.g.getText();
        this.g.setText((CharSequence) null);
        this.g.setHintTextColor(color2);
        this.g.setText(text);
        Editable text2 = this.h.getText();
        this.h.setText((CharSequence) null);
        this.h.setHintTextColor(color2);
        this.h.setText(text2);
        m();
    }

    private void k() {
        setContentView(R.layout.write_activity);
        this.C = (RelativeLayout) findViewById(R.id.parent);
        this.D = (LinearLayout) findViewById(R.id.title);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new aj(this));
        if (this.r == null) {
            this.r = builder.create();
            this.r.setCanceledOnTouchOutside(true);
        }
        this.j = (Button) findViewById(R.id.post);
        this.j.setOnFocusChangeListener(this.I);
        this.n = (ProgressBar) findViewById(R.id.image_progress);
        this.o = (ImageView) findViewById(R.id.image);
        this.o.setOnClickListener(new ak(this));
        this.g = (EditText) findViewById(R.id.post_title);
        this.g.setOnClickListener(this.H);
        this.g.setOnFocusChangeListener(this.I);
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
        this.g.addTextChangedListener(new al(this));
        this.y.postDelayed(this.E, 200L);
        this.s = new m(this);
        this.q = (GridView) findViewById(R.id.face_view);
        this.q.setAdapter((ListAdapter) this.s);
        this.q.setOnItemClickListener(new am(this));
        this.h = (EditText) findViewById(R.id.post_content);
        this.h.setOnClickListener(this.H);
        this.m = (ImageView) findViewById(R.id.select_image);
        this.m.setOnClickListener(new u(this));
        if (this.c.c() != null && this.c.c().length() > 0) {
            this.h.setText(com.baidu.tieba.c.n.b(this, this.c.c()));
        } else if (this.c.a() == 2) {
            if (this.A) {
                this.m.setVisibility(8);
                if (this.B != null && this.B.length() > 0) {
                    this.h.setText(getString(R.string.reply_sub_floor, new Object[]{this.B}));
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
        this.h.setOnFocusChangeListener(this.I);
        this.h.setOnTouchListener(new v(this));
        this.h.addTextChangedListener(new w(this));
        this.i = (Button) findViewById(R.id.back);
        this.i.setOnFocusChangeListener(this.I);
        this.p = (TextView) findViewById(R.id.name);
        this.i.setOnClickListener(new x(this));
        this.l = (ImageView) findViewById(R.id.select_at);
        this.l.setOnClickListener(new y(this));
        this.j.setOnClickListener(new z(this));
        this.k = (ImageView) findViewById(R.id.select_face);
        this.k.setOnClickListener(new aa(this));
        if (this.c.a() == 0) {
            if (this.d) {
                this.p.setText(R.string.feedback);
            } else {
                this.p.setText(R.string.post_new_thread);
            }
            this.g.setVisibility(0);
        } else {
            this.p.setText(R.string.send_reply);
            this.g.setVisibility(8);
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new ab(this)).setNeutralButton(getString(R.string.not_save), new ac(this)).setNegativeButton(getString(R.string.cancel), new ad(this));
        this.w = builder2.create();
        m();
        n();
    }

    private void l() {
        try {
            if (this.w != null && this.w.isShowing()) {
                this.w.dismiss();
            }
            if (this.r != null && this.r.isShowing()) {
                this.r.dismiss();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "closeDialog", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String trim;
        if (this.c.a() == 0) {
            trim = this.g.getText().toString().trim();
        } else if (this.x != null) {
            trim = "1";
        } else {
            trim = this.h.getText().toString().trim();
        }
        if (this.z || trim == null || trim.length() <= 0 || this.t != null) {
            this.j.setEnabled(false);
            if (this.b == 1) {
                this.j.setTextColor(com.baidu.tieba.c.ad.c(this.b));
                return;
            } else {
                this.j.setTextColor(-7688462);
                return;
            }
        }
        this.j.setEnabled(true);
        if (this.b == 1) {
            this.j.setTextColor(com.baidu.tieba.c.ad.a(this.b));
        } else {
            this.j.setTextColor(-1);
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.v = new af(this);
        this.c = new com.baidu.tieba.b.w();
        if (bundle != null) {
            this.c.a(bundle.getInt("type", 0));
            this.c.e(bundle.getString("forum_id"));
            this.c.f(bundle.getString("forum_name"));
            this.c.c(bundle.getString("thread_id"));
            this.c.d(bundle.getString("floor_id"));
            intExtra = bundle.getInt("floor_num", 0);
            this.c.b(intExtra);
            this.d = bundle.getBoolean("feed_back", false);
            this.A = bundle.getBoolean("reply_sub_pb", false);
            this.B = bundle.getString("sub_user_name");
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
            this.A = intent.getBooleanExtra("reply_sub_pb", false);
            this.B = intent.getStringExtra("sub_user_name");
        }
        com.baidu.tieba.b.w a = com.baidu.tieba.c.k.a(this.c.a(), this.c.f(), this.c.d(), this.c.e());
        if (a != null) {
            this.c = a;
            this.c.b(intExtra);
            this.c.a(true);
        }
    }

    private void n() {
        if (getIntent().getBooleanExtra("refresh_pic", false)) {
            if (this.t != null) {
                this.t.a();
            }
            this.t = null;
            o();
            if (getIntent().getStringExtra("file_name") != null) {
                this.t = new an(this, getIntent().getStringExtra("file_name"));
                this.t.execute(new Object[0]);
            } else {
                this.t = new an(this, "tieba_resized_image_display");
                this.t.execute(new Object[0]);
            }
            this.y.removeCallbacks(this.F);
            this.y.postDelayed(this.F, 10000L);
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
        bundle.putBoolean("reply_sub_pb", this.A);
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
        a(getString(R.string.sending), this.v);
        if (this.u != null) {
            this.u.a();
        }
        this.c.g(null);
        this.u = new ao(this, this.c);
        this.u.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1200003) {
                if (intent.getBooleanExtra("delete", false)) {
                    this.x = null;
                    this.o.setVisibility(8);
                    return;
                }
                if (intent.getBooleanExtra("change", false)) {
                    if (this.t != null) {
                        this.t.a();
                    }
                    this.t = null;
                    o();
                    if (this.t != null) {
                        this.t.a();
                    }
                    this.t = null;
                    if (intent.getStringExtra("file_name") != null) {
                        this.t = new an(this, intent.getStringExtra("file_name"));
                    } else {
                        this.t = new an(this, "tieba_resized_image_display");
                    }
                    this.t.execute(new Object[0]);
                    this.y.removeCallbacks(this.F);
                    this.y.postDelayed(this.F, 10000L);
                }
                m();
            } else if (i == 12000010 || i == 1200008) {
                o();
                if (this.t != null) {
                    this.t.a();
                }
                this.t = null;
                if (intent.getStringExtra("file_name") != null) {
                    this.t = new an(this, intent.getStringExtra("file_name"));
                } else {
                    this.t = new an(this, "tieba_resized_image_display");
                }
                this.t.execute(new Object[0]);
                this.y.removeCallbacks(this.F);
                this.y.postDelayed(this.F, 10000L);
                m();
                a(this.h, 300);
            } else if (i == 1200004) {
                String a = AtListActivity.a(intent);
                if (a != null) {
                    this.h.getText().insert(this.h.getSelectionStart(), "@" + a + " ");
                }
            } else if (i == 1200005) {
                com.baidu.tieba.c.k.a(this.c);
                setResult(-1);
                finish();
            } else {
                if (this.t != null) {
                    this.t.a();
                }
                this.t = null;
                if (i == 1200002) {
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), null, null, null);
                    } else {
                        ba.b(this);
                    }
                } else if (i == 1200001) {
                    WriteImageActivity.a(this, 1200001, 12000010, null, null, null, null);
                }
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200001:
                case 1200002:
                    this.r.show();
                    return;
                case 1200008:
                    ba.b(this);
                    return;
                case 12000010:
                    ba.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void o() {
        this.z = true;
        this.o.setVisibility(8);
        this.o.setImageBitmap(null);
        if (this.x != null && !this.x.isRecycled()) {
            this.x.recycle();
        }
        this.x = null;
        this.c.a((com.baidu.tieba.a.x) null);
        this.n.setVisibility(0);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        this.y.removeCallbacks(this.F);
        this.z = false;
        this.n.setVisibility(8);
        if (bitmap != null) {
            this.x = bitmap;
            this.c.a((com.baidu.tieba.a.x) null);
            this.o.setImageBitmap(this.x);
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
            b(getString(R.string.pic_parser_error));
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        a(this.f, this.g);
        a(this.f, this.h);
        if (this.q.getVisibility() == 0) {
            this.q.setVisibility(8);
        }
        super.onPause();
    }
}
