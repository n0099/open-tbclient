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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WriteActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private WriteData f1897a = null;
    private boolean b = false;
    private boolean c = false;
    private InputMethodManager d = null;
    private EditText e = null;
    private EditText f = null;
    private ImageView g = null;
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
    private an u = null;
    private ao v = null;
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
    private com.baidu.tieba.ak G = null;
    private Address H = null;
    private LinearLayout I = null;
    private RelativeLayout J = null;
    private Runnable K = new t(this);
    private Runnable L = new ae(this);
    private Runnable M = new ag(this);
    private View.OnClickListener N = new ah(this);
    private View.OnFocusChangeListener O = new ai(this);

    public static void a(Activity activity, String str, String str2, AntiData antiData, boolean z, String str3) {
        a(activity, 0, str, str2, null, null, 0, antiData, 13003, false, false, null, false, z, str3);
    }

    public static void a(Activity activity, String str, String str2, AntiData antiData) {
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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        l();
        if (TiebaApplication.g().v() && getIntent().getExtras().getInt("type") == 0 && !com.baidu.tieba.data.g.h().equals(getIntent().getStringExtra("forum_id"))) {
            c();
        }
    }

    private void c() {
        this.G = new aj(this);
        this.H = TiebaApplication.g().a(this.G);
        if (this.H != null) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.H != null && this.H.getMaxAddressLineIndex() >= 0) {
            this.F.setText(this.H.getAddressLine(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        if (this.u != null) {
            this.u.cancel();
            this.u = null;
        }
        if (this.v != null) {
            this.v.cancel();
            this.v = null;
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        m();
        this.p.setImageBitmap(null);
        if (this.y != null && !this.y.isRecycled()) {
            this.y.recycle();
            this.y = null;
        }
        this.z.removeCallbacks(this.L);
        TiebaApplication.g().aJ();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f1897a != null && this.f1897a.getType() == 2 && this.B) {
            finish();
        } else if (this.x != null && (this.e.getText().toString().length() > 0 || this.f.getText().toString().length() > 0)) {
            if (this.c) {
                this.x.show();
                this.x.setCanceledOnTouchOutside(true);
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
            if (this.f1897a.getHaveDraft()) {
                DatabaseService.a(this.f1897a);
            }
            finish();
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            k();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        int color;
        int color2;
        super.a(i);
        com.baidu.tieba.util.ao.d(this.I, i);
        com.baidu.tieba.util.ao.f(this.q, i);
        com.baidu.tieba.util.ao.a(this.g, i);
        com.baidu.tieba.util.ao.h(this.j, i);
        if (i == 1) {
            this.D.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
            this.e.setBackgroundResource(R.drawable.write_title_bg_1);
            this.f.setBackgroundColor(com.baidu.tieba.util.ao.d(i));
            this.J.setBackgroundColor(com.baidu.tieba.util.ao.d(i));
            color = com.baidu.tieba.util.ao.a(i);
            color2 = com.baidu.tieba.util.ao.c(i);
            this.r.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
        } else {
            this.D.setBackgroundColor(getResources().getColor(R.color.white));
            this.e.setBackgroundResource(R.drawable.write_title_bg);
            this.f.setBackgroundColor(-526345);
            this.J.setBackgroundColor(-526345);
            color = getResources().getColor(R.color.write_color);
            color2 = getResources().getColor(R.color.write_hint_color);
            this.r.setBackgroundColor(-1644826);
        }
        this.e.setTextColor(color);
        this.f.setTextColor(color);
        this.F.setTextColor(color);
        Editable text = this.e.getText();
        int selectionStart = this.e.getSelectionStart();
        int selectionEnd = this.e.getSelectionEnd();
        this.e.setText((CharSequence) null);
        this.e.setHintTextColor(color2);
        this.e.setText(text);
        this.e.setSelection(selectionStart, selectionEnd);
        Editable text2 = this.f.getText();
        int selectionStart2 = this.f.getSelectionStart();
        int selectionEnd2 = this.f.getSelectionEnd();
        this.f.setText((CharSequence) null);
        this.f.setHintTextColor(color2);
        this.f.setText(text2);
        this.f.setSelection(selectionStart2, selectionEnd2);
        n();
    }

    private void l() {
        setContentView(R.layout.write_activity);
        this.J = (RelativeLayout) findViewById(R.id.tools);
        this.D = (RelativeLayout) findViewById(R.id.parent);
        this.I = (LinearLayout) findViewById(R.id.title);
        this.E = (LinearLayout) findViewById(R.id.location_container);
        this.F = (TextView) findViewById(R.id.location_text);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ak(this));
        if (this.s == null) {
            this.s = builder.create();
            this.s.setCanceledOnTouchOutside(true);
        }
        this.j = (Button) findViewById(R.id.post);
        this.j.setOnFocusChangeListener(this.O);
        this.o = (FrameLayout) findViewById(R.id.image_container);
        this.n = (ProgressBar) findViewById(R.id.image_progress);
        this.p = (ImageView) findViewById(R.id.image);
        this.p.setOnClickListener(new al(this));
        this.e = (EditText) findViewById(R.id.post_title);
        this.e.setOnClickListener(this.N);
        this.e.setOnFocusChangeListener(this.O);
        if (this.f1897a.getType() == 0) {
            if (this.f1897a.getTitle() != null) {
                this.e.setText(this.f1897a.getTitle());
            } else if (this.b) {
                this.e.setText(getResources().getString(R.string.android_feedback));
                this.e.setSelection(getResources().getString(R.string.android_feedback).length());
            }
        } else if (this.f1897a.getType() != 1) {
            this.f1897a.getType();
        }
        this.e.addTextChangedListener(new am(this));
        this.z.postDelayed(this.K, 200L);
        this.t = new m(this);
        this.r = (GridView) findViewById(R.id.face_view);
        this.r.setAdapter((ListAdapter) this.t);
        this.r.setOnItemClickListener(new u(this));
        this.f = (EditText) findViewById(R.id.post_content);
        this.f.setOnClickListener(this.N);
        this.m = (ImageView) findViewById(R.id.select_image);
        this.m.setOnClickListener(new v(this));
        if (this.f1897a.getContent() != null && this.f1897a.getContent().length() > 0) {
            this.f.setText(com.baidu.tbadk.a.a.a().a(this, this.f1897a.getContent()));
        } else if (this.f1897a.getType() == 2) {
            if (this.B) {
                this.m.setVisibility(8);
                if (this.C != null && this.C.length() > 0) {
                    this.f.setText(getString(R.string.reply_sub_floor, new Object[]{this.C}));
                    this.f.setSelection(this.f.getText().length());
                }
            } else if (this.f1897a.getFloorNum() > 0) {
                String format = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.f1897a.getFloorNum()));
                this.f.setText(format);
                this.f.setSelection(format.length());
            }
        } else if (this.f1897a.getType() == 0 && this.b) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(getResources().getString(R.string.tieba_client));
            stringBuffer.append(com.baidu.tieba.data.g.j());
            stringBuffer.append(", ");
            stringBuffer.append(Build.VERSION.RELEASE);
            stringBuffer.append(", ");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(":");
            this.f.setText(stringBuffer);
        }
        this.f.setOnFocusChangeListener(this.O);
        this.f.setOnTouchListener(new w(this));
        this.f.addTextChangedListener(new x(this));
        this.g = (ImageView) findViewById(R.id.back);
        this.g.setOnFocusChangeListener(this.O);
        this.q = (TextView) findViewById(R.id.name);
        this.g.setOnClickListener(new y(this));
        this.l = (ImageView) findViewById(R.id.select_at);
        this.l.setOnClickListener(new z(this));
        this.j.setOnClickListener(new aa(this));
        this.k = (ImageView) findViewById(R.id.select_face);
        this.k.setOnClickListener(new ab(this));
        if (this.f1897a.getType() == 0) {
            if (this.b) {
                this.q.setText(R.string.feedback);
            } else {
                this.q.setText(R.string.post_new_thread);
            }
            this.e.setVisibility(0);
            this.E.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.q.setText(R.string.send_reply);
            this.E.setVisibility(8);
            this.f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
            this.e.setVisibility(8);
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new ac(this)).setNeutralButton(getString(R.string.not_save), new ad(this));
        this.x = builder2.create();
        n();
        o();
    }

    private void m() {
        try {
            if (this.x != null && this.x.isShowing()) {
                this.x.dismiss();
            }
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "closeDialog", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String trim;
        if (this.f1897a.getType() == 0) {
            trim = this.e.getText().toString().trim();
        } else if (this.y != null) {
            trim = "1";
        } else {
            trim = this.f.getText().toString().trim();
        }
        if (this.A || trim == null || trim.length() <= 0 || this.u != null) {
            this.j.setEnabled(false);
            if (this.i == 1) {
                this.j.setTextColor(com.baidu.tieba.util.ao.c(this.i));
                return;
            } else {
                this.j.setTextColor(-11313038);
                return;
            }
        }
        this.j.setEnabled(true);
        if (this.i == 1) {
            this.j.setTextColor(com.baidu.tieba.util.ao.a(this.i));
        } else {
            this.j.setTextColor(-1);
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.w = new af(this);
        this.f1897a = new WriteData();
        if (bundle != null) {
            this.f1897a.setType(bundle.getInt("type", 0));
            this.f1897a.setForumId(bundle.getString("forum_id"));
            this.f1897a.setForumName(bundle.getString("forum_name"));
            this.f1897a.setThreadId(bundle.getString("thread_id"));
            this.f1897a.setFloor(bundle.getString("floor_id"));
            intExtra = bundle.getInt("floor_num", 0);
            this.f1897a.setFloorNum(intExtra);
            this.b = bundle.getBoolean("feed_back", false);
            this.B = bundle.getBoolean("reply_sub_pb", false);
            this.C = bundle.getString("sub_user_name");
        } else {
            Intent intent = getIntent();
            this.f1897a.setType(intent.getIntExtra("type", 0));
            this.f1897a.setForumId(intent.getStringExtra("forum_id"));
            this.f1897a.setForumName(intent.getStringExtra("forum_name"));
            this.f1897a.setThreadId(intent.getStringExtra("thread_id"));
            this.f1897a.setFloor(intent.getStringExtra("floor_id"));
            intExtra = intent.getIntExtra("floor_num", 0);
            this.f1897a.setFloorNum(intExtra);
            this.b = intent.getBooleanExtra("feed_back", false);
            this.B = intent.getBooleanExtra("reply_sub_pb", false);
            this.C = intent.getStringExtra("sub_user_name");
        }
        WriteData a2 = DatabaseService.a(this.f1897a.getType(), this.f1897a.getForumId(), this.f1897a.getThreadId(), this.f1897a.getFloor());
        if (a2 != null) {
            this.f1897a = a2;
            this.f1897a.setFloorNum(intExtra);
            this.f1897a.setHaveDraft(true);
        }
    }

    private void o() {
        if (getIntent().getBooleanExtra("refresh_pic", false)) {
            if (this.u != null) {
                this.u.cancel();
            }
            this.u = null;
            p();
            if (getIntent().getStringExtra("file_name") != null) {
                this.u = new an(this, getIntent().getStringExtra("file_name"));
                this.u.execute(new Object[0]);
            } else {
                this.u = new an(this, "tieba_resized_image_display");
                this.u.execute(new Object[0]);
            }
            this.z.removeCallbacks(this.L);
            this.z.postDelayed(this.L, 10000L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.f1897a.getType());
        bundle.putString("forum_id", this.f1897a.getForumId());
        bundle.putString("forum_name", this.f1897a.getForumName());
        bundle.putString("thread_id", this.f1897a.getThreadId());
        bundle.putString("floor_id", this.f1897a.getFloor());
        bundle.putInt("floor_num", this.f1897a.getFloorNum());
        bundle.putBoolean("reply_sub_pb", this.B);
        if (this.b) {
            bundle.putBoolean("feed_back", true);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.f.getEditableText().toString();
        if (editable != null) {
            this.f.setText(com.baidu.tbadk.a.a.a().a(this, editable));
        }
    }

    public void b() {
        this.f1897a.setTitle(this.e.getText().toString());
        this.f1897a.setContent(this.f.getText().toString());
        a(getString(R.string.sending), this.w);
        if (this.v != null) {
            this.v.cancel();
        }
        this.f1897a.setVcode(null);
        this.v = new ao(this, this.f1897a);
        this.v.setPriority(3);
        this.v.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12003) {
                if (intent.getBooleanExtra("delete", false)) {
                    this.y = null;
                    this.p.setVisibility(8);
                    this.o.setVisibility(8);
                    return;
                }
                if (intent.getBooleanExtra("change", false)) {
                    if (this.u != null) {
                        this.u.cancel();
                    }
                    this.u = null;
                    p();
                    if (this.u != null) {
                        this.u.cancel();
                    }
                    this.u = null;
                    if (intent.getStringExtra("file_name") != null) {
                        this.u = new an(this, intent.getStringExtra("file_name"));
                    } else {
                        this.u = new an(this, "tieba_resized_image_display");
                    }
                    this.u.execute(new Object[0]);
                    this.z.removeCallbacks(this.L);
                    this.z.postDelayed(this.L, 10000L);
                }
                n();
            } else if (i == 12010 || i == 12009) {
                p();
                if (this.u != null) {
                    this.u.cancel();
                }
                this.u = null;
                if (intent.getStringExtra("file_name") != null) {
                    this.u = new an(this, intent.getStringExtra("file_name"));
                } else {
                    this.u = new an(this, "tieba_resized_image_display");
                }
                this.u.execute(new Object[0]);
                this.z.removeCallbacks(this.L);
                this.z.postDelayed(this.L, 10000L);
                n();
                a(this.f, 300);
            } else if (i == 12004) {
                String a2 = AtListActivity.a(intent);
                if (a2 != null) {
                    this.f.getText().insert(this.f.getSelectionStart(), "@" + a2 + " ");
                }
            } else if (i == 12006) {
                DatabaseService.a(this.f1897a);
                setResult(-1);
                finish();
            } else {
                if (this.u != null) {
                    this.u.cancel();
                }
                this.u = null;
                if (i == 12002) {
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), null, null, null);
                    } else {
                        ba.b(this);
                    }
                } else if (i == 12001) {
                    WriteImageActivity.a(this, 12001, 12010, null, null, null, null);
                }
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                case 12002:
                    this.s.show();
                    return;
                case 12009:
                    ba.b(this);
                    return;
                case 12010:
                    ba.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void p() {
        this.A = true;
        this.p.setVisibility(8);
        this.p.setImageBitmap(null);
        this.o.setVisibility(8);
        if (this.y != null && !this.y.isRecycled()) {
            this.y.recycle();
        }
        this.y = null;
        this.f1897a.setBitmapId(null);
        this.n.setVisibility(0);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        this.z.removeCallbacks(this.L);
        this.A = false;
        this.n.setVisibility(8);
        if (bitmap != null) {
            this.y = bitmap;
            this.f1897a.setBitmapId(null);
            this.p.setImageBitmap(this.y);
            this.p.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            a(getString(R.string.pic_parser_error));
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        a(this.d, this.e);
        a(this.d, this.f);
        if (this.r.getVisibility() == 0) {
            this.r.setVisibility(8);
        }
        super.onPause();
    }
}
