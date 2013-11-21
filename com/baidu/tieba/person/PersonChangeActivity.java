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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonChangeActivity extends com.baidu.tieba.j {
    private Boolean b = false;
    private AlertDialog c = null;
    private HeadImageView d = null;
    private NavigationBar e = null;
    private ImageView f = null;
    private TextView g = null;
    private LinearLayout h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private ImageView l = null;
    private ImageView m = null;
    private ImageView n = null;
    private LinearLayout o = null;
    private RelativeLayout p = null;
    private TextView q = null;
    private TextView r = null;
    private EditText s = null;
    private RadioGroup t = null;
    private RadioButton u = null;
    private RadioButton v = null;
    private InputMethodManager w = null;
    private boolean x = false;
    private bw y = null;

    /* renamed from: a  reason: collision with root package name */
    protected FrameLayout f2187a = null;
    private com.baidu.adp.widget.ImageView.e z = null;
    private ax A = null;
    private ay B = null;
    private ProgressBar C = null;
    private DialogInterface.OnCancelListener D = null;
    private com.baidu.tieba.util.i E = null;
    private Dialog F = null;
    private boolean G = false;
    private View.OnClickListener H = new ao(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        this.w = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        c();
        if (bundle != null) {
            this.b = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.b = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.A != null) {
            this.A.cancel();
        }
        if (this.B != null) {
            this.B.cancel();
        }
        if (this.C != null) {
            this.C.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.x = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.x) {
            a();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.s.getVisibility() == 0) {
            this.s.setVisibility(8);
            if (this.s.getText().length() > 0) {
                this.q.setText(this.s.getText());
            } else if (this.y.a().getIntro() != null && this.y.a().getIntro().length() > 0) {
                this.q.setText(this.y.a().getIntro());
            } else {
                this.q.setText(getString(R.string.add_intro));
            }
            if (this.y.a().getIntro() == null || !this.y.a().getIntro().equals(this.s.getText().toString())) {
                this.G = true;
            }
            this.y.a().setIntro(this.s.getText().toString());
            this.q.setVisibility(0);
            HidenSoftKeyPad(this.w, this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.s.getVisibility() != 0) {
            this.q.setVisibility(8);
            this.s.setText(this.y.a().getIntro());
            this.s.setVisibility(0);
            this.s.requestFocus();
            ShowSoftKeyPad(this.w, this.s);
        }
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        this.D = new al(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.y = new bw(personChangeData);
        this.E = new com.baidu.tieba.util.i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bd.a(this.h, i);
        this.e.c(i);
        this.d.d();
        if (i == 1) {
            this.i.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.j.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.k.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.u.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.v.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.r.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.q.setTextColor(com.baidu.tieba.util.bd.a(i));
            this.l.setImageResource(R.drawable.list_divider_1);
            this.m.setImageResource(R.drawable.list_divider_1);
            this.n.setImageResource(R.drawable.list_divider_1);
            this.f2187a.setForeground(getResources().getDrawable(R.drawable.pic_bj_touxiang_n_1));
            return;
        }
        this.i.setTextColor(-14277082);
        this.j.setTextColor(-14277082);
        this.k.setTextColor(-14277082);
        this.u.setTextColor(-14277082);
        this.v.setTextColor(-14277082);
        this.r.setTextColor(-14277082);
        this.q.setTextColor(-14277082);
        this.l.setImageResource(R.drawable.list_divider);
        this.m.setImageResource(R.drawable.list_divider);
        this.n.setImageResource(R.drawable.list_divider);
        this.f2187a.setForeground(getResources().getDrawable(R.drawable.pic_bj_touxiang_n));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.y.a());
    }

    private void c() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ap(this));
        if (this.c == null) {
            this.c = builder.create();
        }
        this.p = (RelativeLayout) findViewById(R.id.info);
        this.p.setOnClickListener(new aq(this));
        this.d = (HeadImageView) findViewById(R.id.photo);
        d();
        this.f2187a = (FrameLayout) findViewById(R.id.frame_photo);
        this.z = this.E.c(this.y.a().getPortrait());
        if (this.z != null) {
            this.z.a(this.d);
        } else {
            this.E.c(this.y.a().getPortrait(), new ar(this));
        }
        this.h = (LinearLayout) findViewById(R.id.parent);
        this.l = (ImageView) findViewById(R.id.divider1);
        this.m = (ImageView) findViewById(R.id.divider2);
        this.n = (ImageView) findViewById(R.id.divider3);
        this.j = (TextView) findViewById(R.id.change_text);
        this.k = (TextView) findViewById(R.id.sex_text);
        this.e = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.e.a(getResources().getString(R.string.my_info));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.H);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.save));
        this.g.setOnClickListener(new as(this));
        this.o = (LinearLayout) findViewById(R.id.intro_click);
        this.o.setOnClickListener(new at(this));
        this.o.setOnTouchListener(new au(this));
        this.r = (TextView) findViewById(R.id.intro_text);
        this.q = (TextView) findViewById(R.id.intro);
        if (this.y.a().getIntro() != null && this.y.a().getIntro().length() > 0) {
            this.q.setText(this.y.a().getIntro());
        } else {
            this.q.setText(getString(R.string.add_intro));
        }
        this.s = (EditText) findViewById(R.id.edit);
        this.s.setText(this.y.a().getIntro());
        this.s.setOnFocusChangeListener(new av(this));
        this.s.setOnTouchListener(new aw(this));
        this.t = (RadioGroup) findViewById(R.id.sexgroup);
        this.u = (RadioButton) findViewById(R.id.man);
        this.v = (RadioButton) findViewById(R.id.woman);
        if (this.y.a().getSex() == 1) {
            this.u.setChecked(true);
        } else if (this.y.a().getSex() == 2) {
            this.v.setChecked(true);
        }
        this.i = (TextView) findViewById(R.id.name);
        this.i.setText(this.y.a().getName());
        this.C = (ProgressBar) findViewById(R.id.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(R.string.confirm_giveup));
        builder2.setPositiveButton(getString(R.string.alert_yes_button), new am(this));
        builder2.setNeutralButton(getString(R.string.cancel), new an(this));
        this.F = builder2.create();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.H.onClick(null);
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
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.E());
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.E());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.y.a().setPhotoChanged(true);
                    e();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.bd.c(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bd.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setDefaultResource(0);
        this.d.setNightDefaultResource(0);
        this.d.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.person_photo));
    }

    private void e() {
        if (this.A != null) {
            this.A.cancel();
        }
        this.z = null;
        this.A = new ax(this, null);
        this.A.execute(new Object[0]);
    }
}
