package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonChangeActivity extends com.baidu.tieba.e {
    private AlertDialog c = null;
    private ImageView d = null;
    private ImageView e = null;
    private Button f = null;
    private LinearLayout g = null;
    private LinearLayout h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private TextView l = null;
    private ImageView m = null;
    private ImageView n = null;
    private ImageView o = null;
    private LinearLayout p = null;
    private RelativeLayout q = null;
    private TextView r = null;
    private TextView s = null;
    private EditText t = null;
    private RadioGroup u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private InputMethodManager x = null;
    private boolean y = false;
    private com.baidu.tieba.c.bh z = null;
    private com.baidu.adp.widget.a.b A = null;
    private av B = null;
    private aw C = null;
    private ProgressBar D = null;
    private DialogInterface.OnCancelListener E = null;
    private com.baidu.tieba.d.a F = null;
    private Dialog G = null;
    private boolean H = false;
    private View.OnClickListener I = new aj(this);

    public static void a(Activity activity, int i, com.baidu.tieba.a.ao aoVar) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", aoVar);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        this.x = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.B != null) {
            this.B.cancel();
        }
        if (this.C != null) {
            this.C.cancel();
        }
        if (this.D != null) {
            this.D.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.y = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.y) {
            b();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.t.getVisibility() == 0) {
            this.t.setVisibility(8);
            if (this.t.getText().length() > 0) {
                this.r.setText(this.t.getText());
            } else if (this.z.d().a() != null && this.z.d().a().length() > 0) {
                this.r.setText(this.z.d().a());
            } else {
                this.r.setText(getString(R.string.add_intro));
            }
            if (this.z.d().a() == null || !this.z.d().a().equals(this.t.getText().toString())) {
                this.H = true;
            }
            this.z.d().a(this.t.getText().toString());
            this.r.setVisibility(0);
            a(this.x, this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.t.getVisibility() != 0) {
            this.r.setVisibility(8);
            this.t.setText(this.z.d().a());
            this.t.setVisibility(0);
            this.t.requestFocus();
            b(this.x, this.t);
        }
    }

    private void a(Bundle bundle) {
        com.baidu.tieba.a.ao aoVar;
        this.E = new an(this);
        if (bundle != null) {
            aoVar = (com.baidu.tieba.a.ao) bundle.getSerializable("data");
        } else {
            aoVar = (com.baidu.tieba.a.ao) getIntent().getSerializableExtra("data");
        }
        if (aoVar == null) {
            aoVar = new com.baidu.tieba.a.ao();
        }
        this.z = new com.baidu.tieba.c.bh(aoVar);
        this.F = new com.baidu.tieba.d.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.a(this.g, i);
        com.baidu.tieba.d.ac.f(this.i, i);
        com.baidu.tieba.d.ac.d(this.h, i);
        com.baidu.tieba.d.ac.g((TextView) this.f, i);
        com.baidu.tieba.d.ac.a(this.e, i);
        if (i == 1) {
            this.j.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.k.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.l.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.v.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.w.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.s.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.r.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.m.setImageResource(R.drawable.list_divider_1);
            this.n.setImageResource(R.drawable.list_divider_1);
            this.o.setImageResource(R.drawable.list_divider_1);
            return;
        }
        this.j.setTextColor(-14277082);
        this.k.setTextColor(-14277082);
        this.l.setTextColor(-14277082);
        this.v.setTextColor(-14277082);
        this.w.setTextColor(-14277082);
        this.s.setTextColor(-14277082);
        this.r.setTextColor(-14277082);
        this.m.setImageResource(R.drawable.list_divider);
        this.n.setImageResource(R.drawable.list_divider);
        this.o.setImageResource(R.drawable.list_divider);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.z.d());
    }

    private void d() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ao(this));
        if (this.c == null) {
            this.c = builder.create();
        }
        this.q = (RelativeLayout) findViewById(R.id.info);
        this.q.setOnClickListener(new ap(this));
        this.d = (ImageView) findViewById(R.id.photo);
        this.A = this.F.b(this.z.d().e());
        if (this.A != null) {
            this.A.b(this.d);
        } else {
            this.F.c(this.z.d().e(), new aq(this));
        }
        this.g = (LinearLayout) findViewById(R.id.parent);
        this.m = (ImageView) findViewById(R.id.divider1);
        this.n = (ImageView) findViewById(R.id.divider2);
        this.o = (ImageView) findViewById(R.id.divider3);
        this.h = (LinearLayout) findViewById(R.id.title);
        this.i = (TextView) findViewById(R.id.title_text);
        this.k = (TextView) findViewById(R.id.change_text);
        this.l = (TextView) findViewById(R.id.sex_text);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(this.I);
        this.f = (Button) findViewById(R.id.save);
        this.f.setOnClickListener(new ar(this));
        this.p = (LinearLayout) findViewById(R.id.intro_click);
        this.p.setOnClickListener(new as(this));
        this.p.setOnTouchListener(new at(this));
        this.s = (TextView) findViewById(R.id.intro_text);
        this.r = (TextView) findViewById(R.id.intro);
        if (this.z.d().a() != null && this.z.d().a().length() > 0) {
            this.r.setText(this.z.d().a());
        } else {
            this.r.setText(getString(R.string.add_intro));
        }
        this.t = (EditText) findViewById(R.id.edit);
        this.t.setText(this.z.d().a());
        this.t.setOnFocusChangeListener(new au(this));
        this.t.setOnTouchListener(new ak(this));
        this.u = (RadioGroup) findViewById(R.id.sexgroup);
        this.v = (RadioButton) findViewById(R.id.man);
        this.w = (RadioButton) findViewById(R.id.woman);
        if (this.z.d().b() == 1) {
            this.v.setChecked(true);
        } else if (this.z.d().b() == 2) {
            this.w.setChecked(true);
        }
        this.j = (TextView) findViewById(R.id.name);
        this.j.setText(this.z.d().c());
        this.D = (ProgressBar) findViewById(R.id.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.confirm_giveup));
        builder2.setPositiveButton(getString(R.string.alert_yes_button), new al(this));
        builder2.setNeutralButton(getString(R.string.cancel), new am(this));
        this.G = builder2.create();
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.I.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1200001:
                    EditHeadActivity.a(this, 1200001, 1200010, null, TiebaApplication.F());
                    return;
                case 1200002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 1200002, 1200009, intent.getData(), TiebaApplication.F());
                        return;
                    }
                    return;
                case 1200009:
                case 1200010:
                    this.z.d().a(true);
                    m();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200009:
                    com.baidu.tieba.write.bb.b(this);
                    return;
                case 1200010:
                    com.baidu.tieba.write.bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void m() {
        if (this.B != null) {
            this.B.cancel();
        }
        this.A = null;
        this.B = new av(this, null);
        this.B.execute(new Object[0]);
    }
}
