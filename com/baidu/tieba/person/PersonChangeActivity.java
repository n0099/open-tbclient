package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity {
    private Boolean b = false;
    private AlertDialog c = null;
    private int d = -1;
    private NavigationBar e = null;
    private TextView f = null;
    private LinearLayout g = null;
    private ScrollView h = null;
    private TextView i = null;
    private LinearLayout j = null;
    private TextView k = null;
    private LinearLayout l = null;
    private TextView m = null;
    private EditText n = null;
    private LinearLayout o = null;
    private TextView p = null;
    private TextView q = null;
    private TextView r = null;
    private InputMethodManager s = null;
    private boolean t = false;
    private com.baidu.tieba.model.au u = null;
    protected HeadImageView a = null;
    private com.baidu.adp.widget.a.a v = null;
    private bf w = null;
    private bg x = null;
    private ProgressBar y = null;
    private DialogInterface.OnCancelListener z = null;
    private com.baidu.tbadk.editortool.ab A = null;
    private Dialog B = null;
    private Dialog C = null;
    private boolean D = false;
    private int E = 0;
    private final int F = 50;
    private View.OnClickListener G = new ao(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.person_change_activity);
        this.s = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        d();
        if (bundle != null) {
            this.b = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.b = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.x != null) {
            this.x.cancel();
        }
        if (this.y != null) {
            this.y.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.t = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.t) {
            a();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.n.getVisibility() == 0) {
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            String replaceAll = this.n.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.m.setText(replaceAll);
            } else {
                this.m.setText(getString(com.baidu.tieba.u.add_intro));
            }
            if (this.u.a().getIntro() == null || !this.u.a().getIntro().equals(replaceAll)) {
                this.D = true;
            }
            this.u.a().setIntro(replaceAll);
            this.m.setVisibility(0);
            HidenSoftKeyPad(this.s, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.n.getVisibility() != 0) {
            this.m.setVisibility(8);
            this.n.setText(this.u.a().getIntro());
            this.n.setVisibility(0);
            this.n.setSelection(this.n.getText().length());
            this.n.requestFocus();
            ShowSoftKeyPad(this.s, this.n);
            a(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.h.postDelayed(new ax(this), i);
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        this.z = new ay(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.u = new com.baidu.tieba.model.au(personChangeData);
        this.A = new com.baidu.tbadk.editortool.ab(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        BitmapDrawable bitmapDrawable;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (this.E == 1) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.q.icon_pop_boy_1);
            } else {
                if (this.E == 2) {
                    bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.q.icon_pop_girl_1);
                }
                bitmapDrawable = null;
            }
        } else if (this.E == 1) {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.q.icon_pop_boy);
        } else {
            if (this.E == 2) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(com.baidu.tieba.q.icon_pop_girl);
            }
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.k.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.g);
        this.e.c(i);
        this.a.b();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.u.a());
    }

    private void d() {
        this.d = TbadkApplication.m252getInst().getSkinType();
        String[] strArr = {getString(com.baidu.tieba.u.take_photo), getString(com.baidu.tieba.u.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.u.operation));
        builder.setItems(strArr, new az(this));
        if (this.c == null) {
            this.c = builder.create();
        }
        this.a = (HeadImageView) findViewById(com.baidu.tieba.r.photo);
        this.a.setIsRound(true);
        this.a.setAutoChangeStyle(true);
        this.a.setDrawBorder(false);
        this.a.setOnClickListener(new ba(this));
        this.v = this.A.c(this.u.a().getPortrait());
        h();
        if (this.v != null) {
            this.v.a(this.a);
        } else {
            this.A.a(this.u.a().getPortrait(), new bb(this));
        }
        this.g = (LinearLayout) findViewById(com.baidu.tieba.r.parent);
        this.h = (ScrollView) findViewById(com.baidu.tieba.r.person_change_scroll);
        this.j = (LinearLayout) findViewById(com.baidu.tieba.r.person_sex);
        this.k = (TextView) findViewById(com.baidu.tieba.r.sex_show);
        this.e = (NavigationBar) findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.G);
        this.e.a(getResources().getString(com.baidu.tieba.u.my_info));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.u.save));
        this.f.setOnClickListener(new bc(this));
        this.j.setOnClickListener(new bd(this));
        this.l = (LinearLayout) findViewById(com.baidu.tieba.r.intro_click);
        this.l.setOnClickListener(new be(this));
        this.l.setOnTouchListener(new ap(this));
        this.i = (TextView) findViewById(com.baidu.tieba.r.nick_name_show);
        this.i.setText(this.u.a().getName());
        this.m = (TextView) findViewById(com.baidu.tieba.r.intro);
        if (this.u.a().getIntro() != null && this.u.a().getIntro().length() > 0) {
            this.m.setText(this.u.a().getIntro());
        } else {
            this.m.setText(getString(com.baidu.tieba.u.add_intro));
        }
        this.n = (EditText) findViewById(com.baidu.tieba.r.edit);
        this.n.setText(this.u.a().getIntro());
        this.n.setOnFocusChangeListener(new aq(this));
        this.n.setOnTouchListener(new ar(this));
        this.n.setOnClickListener(new as(this));
        this.n.addTextChangedListener(new at(this));
        if (this.u.a().getSex() == 1) {
            this.E = 1;
            this.k.setText(com.baidu.tieba.u.man);
        } else if (this.u.a().getSex() == 2) {
            this.E = 2;
            this.k.setText(com.baidu.tieba.u.woman);
        } else {
            this.k.setText(com.baidu.tieba.u.change_sex);
        }
        this.o = (LinearLayout) findViewById(com.baidu.tieba.r.intro_text_tip);
        this.p = (TextView) findViewById(com.baidu.tieba.r.intro_text_tip_num);
        this.q = (TextView) findViewById(com.baidu.tieba.r.intro_text_tip_divider);
        this.r = (TextView) findViewById(com.baidu.tieba.r.intro_text_tip_limit);
        c();
        this.y = (ProgressBar) findViewById(com.baidu.tieba.r.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(com.baidu.tieba.u.confirm_giveup));
        builder2.setPositiveButton(getString(com.baidu.tieba.u.alert_yes_button), new au(this));
        builder2.setNeutralButton(getString(com.baidu.tieba.u.cancel), new av(this));
        this.B = builder2.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int color;
        int color2;
        if (this.n.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = getResources().getColor(com.baidu.tieba.o.person_change_up_limit_text);
            color2 = getResources().getColor(com.baidu.tieba.o.person_change_up_limit_text_1);
        } else {
            color = getResources().getColor(com.baidu.tieba.o.person_change_not_up_limit_text);
            color2 = getResources().getColor(com.baidu.tieba.o.person_change_not_up_limit_text_1);
        }
        a(color, color2);
    }

    private void a(int i, int i2) {
        if (this.d == 1) {
            this.p.setTextColor(i2);
            this.q.setTextColor(i2);
            this.r.setTextColor(i2);
            return;
        }
        this.p.setTextColor(i);
        this.q.setTextColor(i);
        this.r.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.u != null && this.u.a() != null) {
            a();
            this.u.a().setIntro(this.n.getText().toString().replaceAll("\\s*", ""));
            this.u.a().setSex(this.E);
            if (this.x == null) {
                this.x = new bg(this, this.u);
                this.x.setPriority(3);
                this.x.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.C == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String string = getString(com.baidu.tieba.u.man);
            String string2 = getString(com.baidu.tieba.u.woman);
            builder.setTitle(com.baidu.tieba.u.choose_sex);
            builder.setItems(new String[]{string, string2}, new aw(this, string, string2));
            this.C = builder.create();
            this.C.setCanceledOnTouchOutside(true);
            this.C.show();
            return;
        }
        this.C.show();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a();
            this.G.onClick(null);
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
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj());
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.u.a().setPhotoChanged(true);
                    i();
                    r.a(true);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tbadk.core.util.bb.c(this);
                    return;
                case 12010:
                    com.baidu.tbadk.core.util.bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void h() {
        this.a.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setDefaultResource(0);
        this.a.setNightDefaultResource(0);
        this.a.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.person_photo));
    }

    private void i() {
        if (this.w != null) {
            this.w.cancel();
        }
        this.v = null;
        this.w = new bf(this, null);
        this.w.execute(new Object[0]);
    }
}
