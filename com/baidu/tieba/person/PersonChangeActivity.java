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
import com.baidu.tieba.data.PersonChangeData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonChangeActivity extends com.baidu.tieba.g {

    /* renamed from: a */
    private AlertDialog f1556a = null;
    private ImageView b = null;
    private ImageView c = null;
    private Button d = null;
    private LinearLayout e = null;
    private LinearLayout f = null;
    private TextView g = null;
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
    private com.baidu.tieba.model.bm z = null;
    private com.baidu.adp.widget.a.b A = null;
    private aw B = null;
    private ax C = null;
    private ProgressBar D = null;
    private DialogInterface.OnCancelListener E = null;
    private com.baidu.tieba.util.a F = null;
    private Dialog G = null;
    private boolean H = false;
    private View.OnClickListener I = new ak(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        this.x = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        d();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
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

    public void b() {
        if (this.t.getVisibility() == 0) {
            this.t.setVisibility(8);
            if (this.t.getText().length() > 0) {
                this.r.setText(this.t.getText());
            } else if (this.z.a().getIntro() != null && this.z.a().getIntro().length() > 0) {
                this.r.setText(this.z.a().getIntro());
            } else {
                this.r.setText(getString(R.string.add_intro));
            }
            if (this.z.a().getIntro() == null || !this.z.a().getIntro().equals(this.t.getText().toString())) {
                this.H = true;
            }
            this.z.a().setIntro(this.t.getText().toString());
            this.r.setVisibility(0);
            a(this.x, this.t);
        }
    }

    public void c() {
        if (this.t.getVisibility() != 0) {
            this.r.setVisibility(8);
            this.t.setText(this.z.a().getIntro());
            this.t.setVisibility(0);
            this.t.requestFocus();
            b(this.x, this.t);
        }
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        this.E = new ao(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.z = new com.baidu.tieba.model.bm(personChangeData);
        this.F = new com.baidu.tieba.util.a(this);
    }

    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.e, i);
        com.baidu.tieba.util.ah.f(this.g, i);
        com.baidu.tieba.util.ah.d(this.f, i);
        com.baidu.tieba.util.ah.g((TextView) this.d, i);
        com.baidu.tieba.util.ah.a(this.c, i);
        if (i == 1) {
            this.j.setTextColor(com.baidu.tieba.util.ah.a(i));
            this.k.setTextColor(com.baidu.tieba.util.ah.a(i));
            this.l.setTextColor(com.baidu.tieba.util.ah.a(i));
            this.v.setTextColor(com.baidu.tieba.util.ah.a(i));
            this.w.setTextColor(com.baidu.tieba.util.ah.a(i));
            this.s.setTextColor(com.baidu.tieba.util.ah.a(i));
            this.r.setTextColor(com.baidu.tieba.util.ah.a(i));
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
        bundle.putSerializable("data", this.z.a());
    }

    private void d() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ap(this));
        if (this.f1556a == null) {
            this.f1556a = builder.create();
        }
        this.q = (RelativeLayout) findViewById(R.id.info);
        this.q.setOnClickListener(new aq(this));
        this.b = (ImageView) findViewById(R.id.photo);
        this.A = this.F.c(this.z.a().getPortrait());
        if (this.A != null) {
            this.A.b(this.b);
        } else {
            this.F.c(this.z.a().getPortrait(), new ar(this));
        }
        this.e = (LinearLayout) findViewById(R.id.parent);
        this.m = (ImageView) findViewById(R.id.divider1);
        this.n = (ImageView) findViewById(R.id.divider2);
        this.o = (ImageView) findViewById(R.id.divider3);
        this.f = (LinearLayout) findViewById(R.id.title);
        this.g = (TextView) findViewById(R.id.title_text);
        this.k = (TextView) findViewById(R.id.change_text);
        this.l = (TextView) findViewById(R.id.sex_text);
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(this.I);
        this.d = (Button) findViewById(R.id.save);
        this.d.setOnClickListener(new as(this));
        this.p = (LinearLayout) findViewById(R.id.intro_click);
        this.p.setOnClickListener(new at(this));
        this.p.setOnTouchListener(new au(this));
        this.s = (TextView) findViewById(R.id.intro_text);
        this.r = (TextView) findViewById(R.id.intro);
        if (this.z.a().getIntro() != null && this.z.a().getIntro().length() > 0) {
            this.r.setText(this.z.a().getIntro());
        } else {
            this.r.setText(getString(R.string.add_intro));
        }
        this.t = (EditText) findViewById(R.id.edit);
        this.t.setText(this.z.a().getIntro());
        this.t.setOnFocusChangeListener(new av(this));
        this.t.setOnTouchListener(new al(this));
        this.u = (RadioGroup) findViewById(R.id.sexgroup);
        this.v = (RadioButton) findViewById(R.id.man);
        this.w = (RadioButton) findViewById(R.id.woman);
        if (this.z.a().getSex() == 1) {
            this.v.setChecked(true);
        } else if (this.z.a().getSex() == 2) {
            this.w.setChecked(true);
        }
        this.j = (TextView) findViewById(R.id.name);
        this.j.setText(this.z.a().getName());
        this.D = (ProgressBar) findViewById(R.id.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.confirm_giveup));
        builder2.setPositiveButton(getString(R.string.alert_yes_button), new am(this));
        builder2.setNeutralButton(getString(R.string.cancel), new an(this));
        this.G = builder2.create();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
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
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.H());
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.H());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.z.a().setPhotoChanged(true);
                    k();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.ba.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.ba.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void k() {
        if (this.B != null) {
            this.B.cancel();
        }
        this.A = null;
        this.B = new aw(this, null);
        this.B.execute(new Object[0]);
    }
}
