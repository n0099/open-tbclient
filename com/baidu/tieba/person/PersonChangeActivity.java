package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.write.ba;
/* loaded from: classes.dex */
public class PersonChangeActivity extends com.baidu.tieba.e {
    private AlertDialog b = null;
    private ImageView c = null;
    private Button d = null;
    private Button e = null;
    private TextView f = null;
    private LinearLayout g = null;
    private RelativeLayout h = null;
    private TextView i = null;
    private EditText j = null;
    private RadioGroup k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private InputMethodManager n = null;
    private boolean o = false;
    private com.baidu.tieba.b.o p = null;
    private Bitmap q = null;
    private ak r = null;
    private al s = null;
    private ProgressBar t = null;
    private DialogInterface.OnCancelListener u = null;
    private com.baidu.tieba.c.a v = null;
    private Dialog w = null;
    private boolean x = false;
    private View.OnClickListener y = new y(this);

    public static void a(Activity activity, int i, com.baidu.tieba.b.o oVar) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", oVar);
        activity.startActivityForResult(intent, i);
    }

    private void a(Bundle bundle) {
        this.u = new ac(this);
        if (bundle != null) {
            this.p = (com.baidu.tieba.b.o) bundle.getSerializable("data");
        } else {
            this.p = (com.baidu.tieba.b.o) getIntent().getSerializableExtra("data");
        }
        if (this.p == null) {
            this.p = new com.baidu.tieba.b.o();
        }
        this.v = new com.baidu.tieba.c.a(this);
    }

    public void g() {
        if (this.j.getVisibility() == 0) {
            this.j.setVisibility(8);
            if (this.j.getText().length() > 0) {
                this.i.setText(this.j.getText());
            } else if (this.p.a() == null || this.p.a().length() <= 0) {
                this.i.setText(getString(R.string.add_intro));
            } else {
                this.i.setText(this.p.a());
            }
            if (this.p.a() == null || !this.p.a().equals(this.j.getText().toString())) {
                this.x = true;
            }
            this.p.a(this.j.getText().toString());
            this.i.setVisibility(0);
            a(this.n, this.j);
        }
    }

    public void h() {
        if (this.j.getVisibility() != 0) {
            this.i.setVisibility(8);
            this.j.setText(this.p.a());
            this.j.setVisibility(0);
            this.j.requestFocus();
            b(this.n, this.j);
        }
    }

    private void i() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ad(this));
        if (this.b == null) {
            this.b = builder.create();
        }
        this.h = (RelativeLayout) findViewById(R.id.info);
        this.h.setOnClickListener(new ae(this));
        this.c = (ImageView) findViewById(R.id.photo);
        this.q = this.v.b(this.p.e());
        if (this.q != null) {
            this.c.setImageBitmap(this.q);
        } else {
            this.v.c(this.p.e(), new af(this));
        }
        this.d = (Button) findViewById(R.id.back);
        this.d.setOnClickListener(this.y);
        this.e = (Button) findViewById(R.id.save);
        this.e.setOnClickListener(new ag(this));
        this.g = (LinearLayout) findViewById(R.id.intro_click);
        this.g.setOnClickListener(new ah(this));
        this.g.setOnTouchListener(new ai(this));
        this.i = (TextView) findViewById(R.id.intro);
        if (this.p.a() == null || this.p.a().length() <= 0) {
            this.i.setText(getString(R.string.add_intro));
        } else {
            this.i.setText(this.p.a());
        }
        this.j = (EditText) findViewById(R.id.edit);
        this.j.setText(this.p.a());
        this.j.setOnFocusChangeListener(new aj(this));
        this.j.setOnTouchListener(new z(this));
        this.k = (RadioGroup) findViewById(R.id.sexgroup);
        this.l = (RadioButton) findViewById(R.id.man);
        this.m = (RadioButton) findViewById(R.id.woman);
        if (this.p.b() == 1) {
            this.l.setChecked(true);
        } else if (this.p.b() == 2) {
            this.m.setChecked(true);
        }
        this.f = (TextView) findViewById(R.id.name);
        this.f.setText(this.p.c());
        this.t = (ProgressBar) findViewById(R.id.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.confirm_giveup));
        builder2.setPositiveButton(getString(R.string.alert_yes_button), new aa(this));
        builder2.setNeutralButton(getString(R.string.cancel), new ab(this));
        this.w = builder2.create();
    }

    private void j() {
        if (this.r != null) {
            this.r.a();
        }
        this.q = null;
        this.r = new ak(this, null);
        this.r.execute(new Object[0]);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.o = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.o) {
            g();
        }
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 0) {
                switch (i) {
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
            return;
        }
        switch (i) {
            case 1200001:
                EditHeadActivity.a(this, 1200001, 12000010, null, TiebaApplication.w());
                return;
            case 1200002:
                if (intent != null) {
                    EditHeadActivity.a(this, 1200002, 1200008, intent.getData(), TiebaApplication.w());
                    return;
                }
                return;
            case 1200008:
            case 12000010:
                this.p.a(true);
                j();
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        this.n = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        i();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.r != null) {
            this.r.a();
        }
        if (this.s != null) {
            this.s.a();
        }
        if (this.t != null) {
            this.t.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.y.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.p);
    }
}
