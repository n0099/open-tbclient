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

    /* renamed from: a  reason: collision with root package name */
    private Boolean f1592a = false;
    private AlertDialog b = null;
    private ImageView c = null;
    private ImageView d = null;
    private Button e = null;
    private LinearLayout f = null;
    private LinearLayout g = null;
    private TextView j = null;
    private TextView k = null;
    private TextView l = null;
    private TextView m = null;
    private ImageView n = null;
    private ImageView o = null;
    private ImageView p = null;
    private LinearLayout q = null;
    private RelativeLayout r = null;
    private TextView s = null;
    private TextView t = null;
    private EditText u = null;
    private RadioGroup v = null;
    private RadioButton w = null;
    private RadioButton x = null;
    private InputMethodManager y = null;
    private boolean z = false;
    private com.baidu.tieba.model.bl A = null;
    private com.baidu.adp.widget.a.b B = null;
    private aw C = null;
    private ax D = null;
    private ProgressBar E = null;
    private DialogInterface.OnCancelListener F = null;
    private com.baidu.tieba.util.a G = null;
    private Dialog H = null;
    private boolean I = false;
    private View.OnClickListener J = new ak(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        this.y = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        d();
        if (bundle != null) {
            this.f1592a = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.f1592a = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.C != null) {
            this.C.cancel();
        }
        if (this.D != null) {
            this.D.cancel();
        }
        if (this.E != null) {
            this.E.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.z = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.z) {
            b();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.u.getVisibility() == 0) {
            this.u.setVisibility(8);
            if (this.u.getText().length() > 0) {
                this.s.setText(this.u.getText());
            } else if (this.A.a().getIntro() != null && this.A.a().getIntro().length() > 0) {
                this.s.setText(this.A.a().getIntro());
            } else {
                this.s.setText(getString(R.string.add_intro));
            }
            if (this.A.a().getIntro() == null || !this.A.a().getIntro().equals(this.u.getText().toString())) {
                this.I = true;
            }
            this.A.a().setIntro(this.u.getText().toString());
            this.s.setVisibility(0);
            a(this.y, this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.u.getVisibility() != 0) {
            this.s.setVisibility(8);
            this.u.setText(this.A.a().getIntro());
            this.u.setVisibility(0);
            this.u.requestFocus();
            b(this.y, this.u);
        }
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        this.F = new ao(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.A = new com.baidu.tieba.model.bl(personChangeData);
        this.G = new com.baidu.tieba.util.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ao.a(this.f, i);
        com.baidu.tieba.util.ao.f(this.j, i);
        com.baidu.tieba.util.ao.d(this.g, i);
        com.baidu.tieba.util.ao.g((TextView) this.e, i);
        com.baidu.tieba.util.ao.a(this.d, i);
        if (i == 1) {
            this.k.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.l.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.m.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.w.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.x.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.t.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.s.setTextColor(com.baidu.tieba.util.ao.a(i));
            this.n.setImageResource(R.drawable.list_divider_1);
            this.o.setImageResource(R.drawable.list_divider_1);
            this.p.setImageResource(R.drawable.list_divider_1);
            return;
        }
        this.k.setTextColor(-14277082);
        this.l.setTextColor(-14277082);
        this.m.setTextColor(-14277082);
        this.w.setTextColor(-14277082);
        this.x.setTextColor(-14277082);
        this.t.setTextColor(-14277082);
        this.s.setTextColor(-14277082);
        this.n.setImageResource(R.drawable.list_divider);
        this.o.setImageResource(R.drawable.list_divider);
        this.p.setImageResource(R.drawable.list_divider);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.A.a());
    }

    private void d() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ap(this));
        if (this.b == null) {
            this.b = builder.create();
        }
        this.r = (RelativeLayout) findViewById(R.id.info);
        this.r.setOnClickListener(new aq(this));
        this.c = (ImageView) findViewById(R.id.photo);
        this.B = this.G.c(this.A.a().getPortrait());
        if (this.B != null) {
            this.B.a(this.c);
        } else {
            this.G.c(this.A.a().getPortrait(), new ar(this));
        }
        this.f = (LinearLayout) findViewById(R.id.parent);
        this.n = (ImageView) findViewById(R.id.divider1);
        this.o = (ImageView) findViewById(R.id.divider2);
        this.p = (ImageView) findViewById(R.id.divider3);
        this.g = (LinearLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.l = (TextView) findViewById(R.id.change_text);
        this.m = (TextView) findViewById(R.id.sex_text);
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(this.J);
        this.e = (Button) findViewById(R.id.save);
        this.e.setOnClickListener(new as(this));
        this.q = (LinearLayout) findViewById(R.id.intro_click);
        this.q.setOnClickListener(new at(this));
        this.q.setOnTouchListener(new au(this));
        this.t = (TextView) findViewById(R.id.intro_text);
        this.s = (TextView) findViewById(R.id.intro);
        if (this.A.a().getIntro() != null && this.A.a().getIntro().length() > 0) {
            this.s.setText(this.A.a().getIntro());
        } else {
            this.s.setText(getString(R.string.add_intro));
        }
        this.u = (EditText) findViewById(R.id.edit);
        this.u.setText(this.A.a().getIntro());
        this.u.setOnFocusChangeListener(new av(this));
        this.u.setOnTouchListener(new al(this));
        this.v = (RadioGroup) findViewById(R.id.sexgroup);
        this.w = (RadioButton) findViewById(R.id.man);
        this.x = (RadioButton) findViewById(R.id.woman);
        if (this.A.a().getSex() == 1) {
            this.w.setChecked(true);
        } else if (this.A.a().getSex() == 2) {
            this.x.setChecked(true);
        }
        this.k = (TextView) findViewById(R.id.name);
        this.k.setText(this.A.a().getName());
        this.E = (ProgressBar) findViewById(R.id.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.confirm_giveup));
        builder2.setPositiveButton(getString(R.string.alert_yes_button), new am(this));
        builder2.setNeutralButton(getString(R.string.cancel), new an(this));
        this.H = builder2.create();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.J.onClick(null);
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
                    this.A.a().setPhotoChanged(true);
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
        if (this.C != null) {
            this.C.cancel();
        }
        this.B = null;
        this.C = new aw(this, null);
        this.C.execute(new Object[0]);
    }
}
