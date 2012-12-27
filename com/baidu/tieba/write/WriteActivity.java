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
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.u b = null;
    private boolean c = false;
    private boolean d = false;
    private InputMethodManager e = null;
    private EditText f = null;
    private EditText g = null;
    private Button h = null;
    private Button i = null;
    private ImageView j = null;
    private ImageView k = null;
    private ImageView l = null;
    private ProgressBar m = null;
    private ImageView n = null;
    private TextView o = null;
    private GridView p = null;
    private AlertDialog q = null;
    private m r = null;
    private an s = null;
    private ao t = null;
    private DialogInterface.OnCancelListener u = null;
    private AlertDialog v = null;
    private Bitmap w = null;
    private Handler x = new Handler();
    private boolean y = false;
    private boolean z = false;
    private String A = null;
    private Runnable B = new t(this);
    private Runnable C = new ae(this);
    private Runnable D = new ag(this);
    private View.OnClickListener E = new ah(this);
    private View.OnFocusChangeListener F = new ai(this);

    private static void a(Activity activity, int i, String str, String str2, String str3, String str4, int i2, com.baidu.tieba.a.b bVar, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6) {
        if (bVar != null && bVar.a() == 0) {
            com.baidu.tieba.c.ag.a((Context) activity, bVar.e());
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

    public static void a(Activity activity, String str, String str2, com.baidu.tieba.a.b bVar) {
        a(activity, 0, str, str2, null, null, 0, bVar, 1300003, true, false, null, false, false, null);
    }

    public static void a(Activity activity, String str, String str2, com.baidu.tieba.a.b bVar, boolean z, String str3) {
        a(activity, 0, str, str2, null, null, 0, bVar, 1300003, false, false, null, false, z, str3);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4) {
        a(activity, 1, str, str2, str3, null, 0, null, 1300002, false, false, null, false, true, str4);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, String str5, com.baidu.tieba.a.b bVar, boolean z) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, bVar, 1300001, false, z, str5, false, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, bVar, 1300002, false, z, str5, false, false, null);
        }
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, int i, boolean z, com.baidu.tieba.a.b bVar) {
        if (str4 != null) {
            a(activity, 2, str, str2, str3, str4, i, bVar, 1300001, false, false, null, z, false, null);
        } else {
            a(activity, 1, str, str2, str3, null, i, bVar, 1300002, false, false, null, z, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        this.x.removeCallbacks(this.C);
        this.y = false;
        this.m.setVisibility(8);
        if (bitmap != null) {
            this.w = bitmap;
            this.b.a((com.baidu.tieba.a.w) null);
            this.n.setImageBitmap(this.w);
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
            b(getString(R.string.pic_parser_error));
        }
        k();
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.u = new af(this);
        this.b = new com.baidu.tieba.b.u();
        if (bundle != null) {
            this.b.a(bundle.getInt("type", 0));
            this.b.e(bundle.getString("forum_id"));
            this.b.f(bundle.getString("forum_name"));
            this.b.c(bundle.getString("thread_id"));
            this.b.d(bundle.getString("floor_id"));
            intExtra = bundle.getInt("floor_num", 0);
            this.b.b(intExtra);
            this.c = bundle.getBoolean("feed_back", false);
            this.z = bundle.getBoolean("reply_sub_pb", false);
            this.A = bundle.getString("sub_user_name");
        } else {
            Intent intent = getIntent();
            this.b.a(intent.getIntExtra("type", 0));
            this.b.e(intent.getStringExtra("forum_id"));
            this.b.f(intent.getStringExtra("forum_name"));
            this.b.c(intent.getStringExtra("thread_id"));
            this.b.d(intent.getStringExtra("floor_id"));
            intExtra = intent.getIntExtra("floor_num", 0);
            this.b.b(intExtra);
            this.c = intent.getBooleanExtra("feed_back", false);
            this.z = intent.getBooleanExtra("reply_sub_pb", false);
            this.A = intent.getStringExtra("sub_user_name");
        }
        com.baidu.tieba.b.u a = com.baidu.tieba.c.k.a(this.b.a(), this.b.f(), this.b.d(), this.b.e());
        if (a != null) {
            this.b = a;
            this.b.b(intExtra);
            this.b.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.b != null && this.b.a() == 2 && this.z) {
            finish();
        } else if (this.v == null || (this.f.getText().toString().length() <= 0 && this.g.getText().toString().length() <= 0)) {
            if (this.b.m()) {
                com.baidu.tieba.c.k.a(this.b);
            }
            finish();
        } else if (!this.d) {
            finish();
        } else {
            this.v.show();
            Button button = this.v.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.v.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.v.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }

    private void i() {
        setContentView(R.layout.write_activity);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new aj(this));
        if (this.q == null) {
            this.q = builder.create();
            this.q.setCanceledOnTouchOutside(true);
        }
        this.i = (Button) findViewById(R.id.post);
        this.i.setOnFocusChangeListener(this.F);
        this.m = (ProgressBar) findViewById(R.id.image_progress);
        this.n = (ImageView) findViewById(R.id.image);
        this.n.setOnClickListener(new ak(this));
        this.f = (EditText) findViewById(R.id.post_title);
        this.f.setOnClickListener(this.E);
        this.f.setOnFocusChangeListener(this.F);
        if (this.b.a() == 0) {
            if (this.b.b() != null) {
                this.f.setText(this.b.b());
            } else if (this.c) {
                this.f.setText(getResources().getString(R.string.android_feedback));
                this.f.setSelection(getResources().getString(R.string.android_feedback).length());
            }
        } else if (this.b.a() != 1) {
            this.b.a();
        }
        this.f.addTextChangedListener(new al(this));
        this.x.postDelayed(this.B, 200L);
        this.r = new m(this);
        this.p = (GridView) findViewById(R.id.face_view);
        this.p.setAdapter((ListAdapter) this.r);
        this.p.setOnItemClickListener(new am(this));
        this.g = (EditText) findViewById(R.id.post_content);
        this.g.setOnClickListener(this.E);
        this.l = (ImageView) findViewById(R.id.select_image);
        this.l.setOnClickListener(new u(this));
        if (this.b.c() != null && this.b.c().length() > 0) {
            this.g.setText(com.baidu.tieba.c.n.b(this, this.b.c()));
        } else if (this.b.a() == 2) {
            if (this.z) {
                this.l.setVisibility(8);
                if (this.A != null && this.A.length() > 0) {
                    this.g.setText(getString(R.string.reply_sub_floor, new Object[]{this.A}));
                    this.g.setSelection(this.g.getText().length());
                }
            } else if (this.b.h() > 0) {
                String format = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.b.h()));
                this.g.setText(format);
                this.g.setSelection(format.length());
            }
        } else if (this.b.a() == 0 && this.c) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(R.string.tieba_client));
            stringBuffer.append(com.baidu.tieba.a.h.h());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(":");
            this.g.setText(stringBuffer);
        }
        this.g.setOnFocusChangeListener(this.F);
        this.g.setOnTouchListener(new v(this));
        this.g.addTextChangedListener(new w(this));
        this.h = (Button) findViewById(R.id.back);
        this.h.setOnFocusChangeListener(this.F);
        this.o = (TextView) findViewById(R.id.name);
        this.h.setOnClickListener(new x(this));
        this.k = (ImageView) findViewById(R.id.select_at);
        this.k.setOnClickListener(new y(this));
        this.i.setOnClickListener(new z(this));
        this.j = (ImageView) findViewById(R.id.select_face);
        this.j.setOnClickListener(new aa(this));
        if (this.b.a() == 0) {
            if (this.c) {
                this.o.setText(R.string.feedback);
            } else {
                this.o.setText(R.string.post_new_thread);
            }
            this.f.setVisibility(0);
        } else {
            this.o.setText(R.string.send_reply);
            this.f.setVisibility(8);
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new ab(this)).setNeutralButton(getString(R.string.not_save), new ac(this)).setNegativeButton(getString(R.string.cancel), new ad(this));
        this.v = builder2.create();
        k();
        l();
    }

    private void j() {
        try {
            if (this.v != null && this.v.isShowing()) {
                this.v.dismiss();
            }
            if (this.q == null || !this.q.isShowing()) {
                return;
            }
            this.q.dismiss();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "closeDialog", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String trim = this.b.a() == 0 ? this.f.getText().toString().trim() : this.w != null ? "1" : this.g.getText().toString().trim();
        if (this.y || trim == null || trim.length() <= 0 || this.s != null) {
            this.i.setEnabled(false);
            this.i.setTextColor(-7688462);
            return;
        }
        this.i.setEnabled(true);
        this.i.setTextColor(-1);
    }

    private void l() {
        if (getIntent().getBooleanExtra("refresh_pic", false)) {
            if (this.s != null) {
                this.s.a();
            }
            this.s = null;
            m();
            if (getIntent().getStringExtra("file_name") != null) {
                this.s = new an(this, getIntent().getStringExtra("file_name"));
                this.s.execute(new Object[0]);
            } else {
                this.s = new an(this, "tieba_resized_image_display");
                this.s.execute(new Object[0]);
            }
            this.x.removeCallbacks(this.C);
            this.x.postDelayed(this.C, 10000L);
        }
    }

    private void m() {
        this.y = true;
        this.n.setVisibility(8);
        this.n.setImageBitmap(null);
        if (this.w != null && !this.w.isRecycled()) {
            this.w.recycle();
        }
        this.w = null;
        this.b.a((com.baidu.tieba.a.w) null);
        this.m.setVisibility(0);
        k();
    }

    public void g() {
        this.b.a(this.f.getText().toString());
        this.b.b(this.g.getText().toString());
        a(getString(R.string.sending), this.u);
        if (this.t != null) {
            this.t.a();
        }
        this.b.g(null);
        this.t = new ao(this, this.b);
        this.t.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 0) {
                switch (i) {
                    case 1200001:
                    case 1200002:
                        this.q.show();
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
        } else if (i == 1200003) {
            if (intent.getBooleanExtra("delete", false)) {
                this.w = null;
                this.n.setVisibility(8);
                return;
            }
            if (intent.getBooleanExtra("change", false)) {
                if (this.s != null) {
                    this.s.a();
                }
                this.s = null;
                m();
                if (this.s != null) {
                    this.s.a();
                }
                this.s = null;
                if (intent.getStringExtra("file_name") != null) {
                    this.s = new an(this, intent.getStringExtra("file_name"));
                } else {
                    this.s = new an(this, "tieba_resized_image_display");
                }
                this.s.execute(new Object[0]);
                this.x.removeCallbacks(this.C);
                this.x.postDelayed(this.C, 10000L);
            }
            k();
        } else if (i == 12000010 || i == 1200008) {
            m();
            if (this.s != null) {
                this.s.a();
            }
            this.s = null;
            if (intent.getStringExtra("file_name") != null) {
                this.s = new an(this, intent.getStringExtra("file_name"));
            } else {
                this.s = new an(this, "tieba_resized_image_display");
            }
            this.s.execute(new Object[0]);
            this.x.removeCallbacks(this.C);
            this.x.postDelayed(this.C, 10000L);
            k();
            a(this.g, 300);
        } else if (i == 1200004) {
            String a = AtListActivity.a(intent);
            if (a != null) {
                this.g.getText().insert(this.g.getSelectionStart(), "@" + a + " ");
            }
        } else if (i == 1200005) {
            com.baidu.tieba.c.k.a(this.b);
            setResult(-1);
            finish();
        } else {
            if (this.s != null) {
                this.s.a();
            }
            this.s = null;
            if (i != 1200002) {
                if (i == 1200001) {
                    WriteImageActivity.a(this, 1200001, 12000010, null, null, null, null);
                }
            } else if (intent == null || intent.getData() == null) {
                ba.b(this);
            } else {
                WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), null, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        i();
        if (TiebaApplication.a().j() && getIntent().getExtras().getInt("type") == 0 && !com.baidu.tieba.a.h.f().equals(getIntent().getStringExtra("forum_id"))) {
            TiebaApplication.a().ar();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.s != null) {
            this.s.a();
            this.s = null;
        }
        if (this.t != null) {
            this.t.a();
            this.t = null;
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        j();
        this.n.setImageBitmap(null);
        if (this.w != null && !this.w.isRecycled()) {
            this.w.recycle();
            this.w = null;
        }
        this.x.removeCallbacks(this.C);
        TiebaApplication.a().as();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            h();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        a(this.e, this.f);
        a(this.e, this.g);
        if (this.p.getVisibility() == 0) {
            this.p.setVisibility(8);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.g.getEditableText().toString();
        if (editable != null) {
            this.g.setText(com.baidu.tieba.c.n.b(this, editable));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.b.a());
        bundle.putString("forum_id", this.b.f());
        bundle.putString("forum_name", this.b.g());
        bundle.putString("thread_id", this.b.d());
        bundle.putString("floor_id", this.b.e());
        bundle.putInt("floor_num", this.b.h());
        bundle.putBoolean("reply_sub_pb", this.z);
        if (this.c) {
            bundle.putBoolean("feed_back", true);
        }
        super.onSaveInstanceState(bundle);
    }
}
